package br.com.socketchat.chat.Services;

import br.com.socketchat.chat.DTO.UserDto;
import br.com.socketchat.chat.Entity.UserEntity;
import br.com.socketchat.chat.Repositorys.UserRepository;
import br.com.socketchat.chat.Strategy.Validation.NickNameValidation;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final NickNameValidation nickNameValidation;

    UserEntity userEntity = new UserEntity();

    // Injeção via construtor (mais recomendada)
    public UserService(UserRepository userRepository, NickNameValidation nickNameValidation) {
        this.userRepository = userRepository;
        this.nickNameValidation = nickNameValidation;
    }

    public String saveUser(UserDto userDto) throws Exception {
        Optional<UserEntity> nameValidation = userRepository.findByusername(userDto.username());
        if (nameValidation.isPresent()) {
            return "Bem vindo de volta!";
        }

        nickNameValidation.isNickNameValid(userDto);

        userEntity.setUsername(userDto.username());

        userRepository.save(userEntity);

        return "Usuario criado com sucesso";
    }
}
