package br.com.socketchat.chat.Services;

import br.com.socketchat.chat.Components.Filter.UserComponent;
import br.com.socketchat.chat.DTO.UserDto;
import br.com.socketchat.chat.BusinessCase.Creation.CreationUser.UserFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    private final UserFactory userFactory;

    public UserService(@Qualifier("UserFactory") UserFactory userFactory) {
        this.userFactory = userFactory;
    }

    public String saveUser(UserDto userDto){
        UserComponent.saveUser(userFactory.userCreation(userDto));
        return "Usuario criado com sucesso";
    }
}
