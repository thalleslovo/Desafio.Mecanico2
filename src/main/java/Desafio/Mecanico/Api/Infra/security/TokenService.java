package Desafio.Mecanico.Api.Infra.security;


import Desafio.Mecanico.Api.Domain.login.Login;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;


@Service
public class TokenService {

    public String gerarToken(Login login) {
        try {
            var algoritimo = Algorithm.HMAC256("123456");
            return JWT.create()
                    .withIssuer("Desafio.Mecanico.Api")
                    .withSubject(login.getLogin())
                    .withExpiresAt(dataExperacao())
                    .sign(algoritimo);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("erro ao gerar token jwt" , exception);

        }
    }

    public String getSubject(String tokenJWt) {
        try {
            var algoritimo = Algorithm.HMAC256("123456");
            return JWT.require(algoritimo)
                    .withIssuer("Desafio.Mecanico.Api")
                    .build()
                    .verify(tokenJWt)
                    .getSubject();


        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Token JWT inválido ou expirado!");
        }
    }

    private Instant dataExperacao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
