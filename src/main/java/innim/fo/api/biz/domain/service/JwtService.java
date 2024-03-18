package innim.fo.api.biz.domain.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    private final String ISSUER = "admin_innim";
    private final String SECRET = "innim_secret_key_240215";
    private final String REFRESH_SECRET = "innim_secret_key_refresh_240215";

    public String authenticateUser(String username, String password) {
        // 여기서는 예시를 위한 간단한 인증 로직을 사용합니다.
        // 실제 애플리케이션에서는 사용자 저장소를 조회하여 인증을 처리해야 합니다.
        if ("user".equals(username) && "password".equals(password)) {
            return generateToken(username);
        }
        return null;
    }

    public String generateRefreshToken(String subject) {
        return JWT.create()
                .withSubject(subject)
                .withIssuer(ISSUER)
                .withExpiresAt(new Date(System.currentTimeMillis() + 30 * 24 * 60 * 60 * 1000)) // 30일 후 만료
                .sign(Algorithm.HMAC256(REFRESH_SECRET));
    }

    // 리프레시 토큰을 데이터베이스에 저장하는 로직 추가
    public void saveRefreshToken(String userId, String refreshToken) {
        // 데이터베이스 저장 로직 구현
    }

    private String generateToken(String subject) {
        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        Date expiresAt = new Date(System.currentTimeMillis() + 10 * 60 * 1000); // 10분 후 만료

        return JWT.create()
                .withIssuer(ISSUER)
                .withSubject(subject)
                .withExpiresAt(expiresAt)
                .sign(algorithm);
    }

    public boolean verifyToken(String token) {
        try {
            // 알고리즘 설정 (토큰 생성시 사용한 것과 동일해야 합니다)
            Algorithm algorithm = Algorithm.HMAC256(SECRET);

            // JWTVerifier 구성
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(ISSUER)
                    .build(); // 재사용 가능한 verifier 인스턴스를 생성합니다.

            // 토큰 검증
            verifier.verify(token);
            return true; // 검증에 성공하면 true 반환
        } catch (JWTVerificationException exception){
            // 유효하지 않은 토큰의 경우 예외 처리
            return false; // 검증에 실패하면 false 반환
        }
    }
}
