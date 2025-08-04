package br.com.socketchat.chat.Strategy.UserValidation;

import br.com.socketchat.chat.Components.CustomErrors.CustomUserError.ValidacaoException;
import br.com.socketchat.chat.DTO.ErroValidacaoDTO;
import br.com.socketchat.chat.DTO.UserDto;
import br.com.socketchat.chat.Repositorys.UserRepository;
import org.springframework.stereotype.Component;


@Component
public class EmailValidation implements CrendenciaisValidacao<UserDto> {

    private final UserRepository userRepository;

    String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    public EmailValidation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void validarCrendenciais(UserDto userDto) throws ValidacaoException {
        if (!userDto.email().matches(regex)) {
            throw new ValidacaoException(new ErroValidacaoDTO("Email invalido"));
        }
        if (userRepository.existsByEmail(userDto.email())) {
            throw new ValidacaoException(new ErroValidacaoDTO("Email já utilizado"));
        }
    }
}
