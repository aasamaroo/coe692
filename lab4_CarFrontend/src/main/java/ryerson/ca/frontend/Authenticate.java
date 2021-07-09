package ryerson.ca.frontend;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.util.AbstractMap;
import java.util.Date;
import java.util.Map.Entry;
import static javax.crypto.Cipher.SECRET_KEY;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author student
 */
public class Authenticate {

    SignatureAlgorithm signatureAlgorithm;
    private final String secretString="mysecuresecurecode_coe692_labs_winter2021";

     

    public Authenticate() {

        signatureAlgorithm = SignatureAlgorithm.HS256;
       
    }

    public String createJWT(String issuer, String subject, long ttlMillis) throws UnsupportedEncodingException {

        //The JWT signature algorithm we will be using to sign the token
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
   
     
Key key = Keys.hmacShaKeyFor(secretString.getBytes("UTF-8"));
        //Let's set the JWT Claims
        JwtBuilder builder;
        builder = Jwts.builder()
                .setIssuedAt(now)
                .setSubject(subject)
                .setIssuer(issuer)
               
                .signWith(key, signatureAlgorithm)
                ;

        //if it has been specified, let's add the expiration
        if (ttlMillis > 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

        String a = builder.compact();
        System.out.println(a);
        //Builds the JWT and serializes it to a compact, URL-safe string
        return a;
    }

    public Entry<Boolean, String> verify(String jwt) throws UnsupportedEncodingException {
        Jws<Claims> jws = null;
        String username="";
        System.out.println("I am veryfying! :" + jwt);
        try {
            jws = Jwts.parserBuilder()
                   // (1)
                    .setSigningKey(Keys.hmacShaKeyFor(secretString.getBytes("UTF-8")))
                   
                    // (2)
                    .build() // (3)
                   
                    .parseClaimsJws(jwt); // (4)

            System.out.println("we can safely trust the JWT");
            username=jws.getBody().getSubject();
            System.out.println(username);
                 
        } catch (JwtException ex) {       // (5)

            System.out.println(ex.getMessage());
            System.out.println(" we *cannot* use the JWT as intended by its creator");
        }
        if (jws == null) {
            Entry entry= new  AbstractMap.SimpleEntry<Boolean, String>(false,"");
            return entry;
        }
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        if (jws.getBody().getExpiration().before(now)) {
           Entry entry= new  AbstractMap.SimpleEntry<Boolean, String>(false,"");
            return entry;
        }

       Entry entry= new  AbstractMap.SimpleEntry<Boolean, String>(true,username);
            return entry;

    }

}
