// package gic.itc.coffee_shop.util;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.JwtBuilder;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import io.jsonwebtoken.security.Keys;

// import java.security.Key;
// import java.util.Arrays;
// import java.util.Collection;
// import java.util.Date;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;

// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;

// public class JwtUtil {
//     private static String secret="test";
// 	private int jwtExpirationInMs = 0;
// 	private int refreshExpirationDateInMs= 9000000;
//     private static Key getKey() {
//         return Keys.hmacShaKeyFor(secret.getBytes());
//     }
//     private String doGenerateToken(Map<String, Object> claims, String subject) {

// 		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
// 				.setExpiration(new Date(System.currentTimeMillis() + jwtExpirationInMs))
// 				.signWith(getKey(),SignatureAlgorithm.HS512).compact();

// 	}
//     public String generateToken(UserDetails userDetails) {
// 		Map<String, Object> claims = new HashMap<>();

// 		Collection<? extends GrantedAuthority> roles = userDetails.getAuthorities();

// 		if (roles.contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
// 			claims.put("isAdmin", true);
// 		}
// 		if (roles.contains(new SimpleGrantedAuthority("ROLE_USER"))) {
// 			claims.put("isUser", true);
// 		}

// 		return doGenerateToken(claims, userDetails.getUsername());
// 	}
//     public String getUsernameFromToken(String token) {
// 		Claims claims = Jwts.parserBuilder().setSigningKey(getKey()).build().parseClaimsJws(token).getBody();
// 		return claims.getSubject();

// 	}
//     public List<SimpleGrantedAuthority> getRolesFromToken(String token) {
// 		Claims claims = Jwts.parserBuilder().setSigningKey(getKey()).build().parseClaimsJws(token).getBody();

// 		List<SimpleGrantedAuthority> roles = null;

// 		Boolean isAdmin = claims.get("isAdmin", Boolean.class);
// 		Boolean isUser = claims.get("isUser", Boolean.class);

// 		if (isAdmin != null && isAdmin) {
// 			roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
// 		}

// 		if (isUser != null && isAdmin) {
// 			roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
// 		}
// 		return roles;

// 	}
// }

