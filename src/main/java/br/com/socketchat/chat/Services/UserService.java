package br.com.socketchat.chat.Services;

import br.com.socketchat.chat.Components.Filter.UserComponent;
import br.com.socketchat.chat.DTO.UserDto;
import br.com.socketchat.chat.BusinessCase.Creation.CreationUser.UserFactory;
import br.com.socketchat.chat.Entity.UserEntity;
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

    public void alterUser(Long id, UserDto userDto){
        UserEntity user = UserComponent.findUser(id);
        user.setUsername(userDto.username());
        UserComponent.saveUser(user);
    }


}
