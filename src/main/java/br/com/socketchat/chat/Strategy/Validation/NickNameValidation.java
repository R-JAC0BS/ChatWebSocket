package br.com.socketchat.chat.Strategy.Validation;

import br.com.socketchat.chat.DTO.UserDto;
import br.com.socketchat.chat.Entity.UserEntity;
import br.com.socketchat.chat.Repositorys.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;



@Configuration
public class NickNameValidation  {

    private final UserRepository userRepository;

    public NickNameValidation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void isNickNameValid(UserDto userDto) throws Exception {


        if (userDto.username().length() < 3) {
            throw new Exception("Esse nick é curto demais");
        }

        if (userDto.username().length() > 30) {
            throw new Exception("Nickname muito grande");
        }

    }

}
