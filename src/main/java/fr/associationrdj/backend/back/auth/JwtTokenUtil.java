package fr.associationrdj.backend.back.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtTokenUtil implements Serializable {

    private static final long serialVersionUID = -2550185165626007488L;

    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

    private String secret = "xsdcevgrfbtnhyj,:l!mùedscfgbhjuk:l!mzeqdscfghjkdszerfgthjuklmkxszdcefrgthjuklm";

    /**
     * Retourne l'username du token.
     * @param token le token
     * @return l'username
     */
    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    /**
     * Retourne la date d'émission du token.
     * @param token le token
     * @return la date d'émission
     */
    public Date getIssuedAtDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getIssuedAt);
    }

    /**
     * Retourne la date d'expiration du token.
     * @param token le token
     * @return la date d'expiration
     */
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    /**
     * Retourne le claim du token.
     * @param token le token
     * @param claimsResolver la fonction de résolution des claims
     * @return le claim
     * @param <T> le type du claim
     */
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    /**
     * Retourne l'ensemble des claims du token.
     * @param token le token
     * @return les claims
     */
    private Claims getAllClaimsFromToken(String token) {
        Key key = Keys.hmacShaKeyFor(secret.getBytes());
        return Jwts.parserBuilder()
                .setSigningKey(secret.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * Vérifie si le token est expiré.
     * @param token le token
     * @return true si le token est expiré, false sinon
     */
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    private boolean ignoreTokenExpiration(String token) {
        // here you specify tokens, for that the expiration is ignored
        return false;
    }

    /**
     * Génère un token pour l'utilisateur.
     * @param userDetails l'username de l'utilisateur
     * @return le token
     */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = Jwts.claims().setSubject(userDetails.getUsername());
        return doGenerateToken(userDetails.getUsername(), claims);
    }

    /**
     * Génère un token pour l'utilisateur.
     * @param username l'username de l'utilisateur
     * @param claims les claims
     * @return le token
     */
    private String doGenerateToken(String username, Map<String, Object> claims) {
        final Date createdDate = new Date();
        final Date expirationDate = new Date(createdDate.getTime() + JWT_TOKEN_VALIDITY * 1000);
        Key key = Keys.hmacShaKeyFor(secret.getBytes());

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(createdDate)
                .setExpiration(expirationDate)
                .signWith(key)
                .compact();
    }

    /**
     * Vérifie si le token peut être rafraichi.
     * @param token le token
     * @return true si le token peut être rafraichi, false sinon
     */
    public Boolean canTokenBeRefreshed(String token) {
        return (!isTokenExpired(token) || ignoreTokenExpiration(token));
    }

    public boolean validateToken(String token, String username) {
        final String usernameFromToken = getUsernameFromToken(token);
        return (usernameFromToken.equals(username) && !isTokenExpired(token));
    }


}