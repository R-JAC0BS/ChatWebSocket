package br.com.socketchat.chat.Components.Filter;


import br.com.socketchat.chat.Components.CustomExcpetion.NotFoundUserException;
import br.com.socketchat.chat.Entity.UserEntity;
import br.com.socketchat.chat.Repositorys.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserComponent {

    private static UserRepository userRepository = null;


    public UserComponent(UserRepository userRepository) {
        UserComponent.userRepository = userRepository;
    }

    public static UserEntity findUser(String email) {
        return (userRepository.findByEmail(email).orElseThrow(NotFoundUserException::new));
    }

    public static void saveUser (UserEntity user) {
        userRepository.save(user);
    }


}
