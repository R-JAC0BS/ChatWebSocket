package br.com.socketchat.chat.Repositorys;

import br.com.socketchat.chat.Entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, String> {




    Optional<UserEntity> findByusername(String username);

    List<UserEntity> findAll();

    boolean existsByusername(String username);
}
