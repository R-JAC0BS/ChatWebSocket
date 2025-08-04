package br.com.socketchat.chat.BusinessCase.Creation.CreationUser;

import br.com.socketchat.chat.DTO.UserDto;
import br.com.socketchat.chat.Entity.UserEntity;
import br.com.socketchat.chat.Strategy.UserValidation.CrendenciaisValidacao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserFactory")
public class UserFactory implements CreationUserFactory{


    private final List<CrendenciaisValidacao<UserDto>> validaCredenciais;


    public UserFactory(List<CrendenciaisValidacao<UserDto>> validCrendenciaisValidacao) {
        this.validaCredenciais = validCrendenciaisValidacao;
    }

    @Override
    public UserEntity userCreation(UserDto userDto) {
        validaCredenciais.forEach(valida -> valida.validarCrendenciais(userDto));
        UserEntity userEntity = new UserEntity();
        System.out.println(userDto.toString());
        userEntity.setUsername(userDto.username());
        userEntity.setEmail(userDto.email());
        return userEntity;
    }
}
