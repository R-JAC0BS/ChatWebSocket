package br.com.socketchat.chat.BusinessCase.Creation.CreationUser;

import br.com.socketchat.chat.DTO.UserDto;
import br.com.socketchat.chat.Entity.UserEntity;

public interface CreationUserFactory {
    UserEntity userCreation(UserDto userDto);
}
