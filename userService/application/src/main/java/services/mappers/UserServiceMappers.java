package services.mappers;

import com.example.demo.controller.DTOS.requests.UserCreationRequestDTO;
import com.example.demo.domain.User;

public class UserServiceMappers {

    public static User requestToDomain(UserCreationRequestDTO userCreationRequestDTO) {

        return User.UserBuilder.Builder()
                .username( userCreationRequestDTO.username() )
                .firstName( userCreationRequestDTO.firstName() )
                .lastName( userCreationRequestDTO.lastName() )
                .email( userCreationRequestDTO.email() )
                .city( userCreationRequestDTO.city() )
                .country( userCreationRequestDTO.country() )
                .roles( userCreationRequestDTO.roles() )
                .cpf( userCreationRequestDTO.cpf() )
                .build();
    }
}
