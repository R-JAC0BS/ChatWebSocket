package br.com.socketchat.chat.Strategy.UserValidation;
import br.com.socketchat.chat.Components.CustomErrors.CustomUserError.ValidacaoException;
import br.com.socketchat.chat.DTO.ErroValidacaoDTO;
import br.com.socketchat.chat.DTO.UserDto;
import org.springframework.stereotype.Component;


@Component
public class NickNameValidation implements CrendenciaisValidacao <UserDto> {
    public void validarCrendenciais(UserDto userDto) throws ValidacaoException{
        if (userDto.username().length() < 3) {
            throw new ValidacaoException(new ErroValidacaoDTO("Nickname muito curto"));
        }
        if (userDto.username().length() > 30) {
            throw new ValidacaoException(new ErroValidacaoDTO("Nickname muito grande"));
        }
    }
}
