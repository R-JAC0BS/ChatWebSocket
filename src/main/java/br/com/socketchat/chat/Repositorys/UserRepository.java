package br.com.socketchat.chat.Repositorys;

import br.com.socketchat.chat.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, String> {

    Optional<UserEntity> findByEmail(String email);
    UserEntity findById(long id);
    List<UserEntity> findAll();
    boolean existsByEmail(String email);
}
