package Desafio.Mecanico.Api.Domain.login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface LoginRepository extends JpaRepository<Login , Long> {

    UserDetails findByLogin(String login);
}
