package com.example.controller.mappers;


import com.example.controller.DTOS.requests.UserCreationRequestDTO;
import domain.User.User;

public class UserInboundMappers {

    public static User requestToDomain( UserCreationRequestDTO userCreationRequestDTO ) {

        return User.UserBuilder.Builder()
                .username( userCreationRequestDTO.username() )
                .firstName( userCreationRequestDTO.firstName() )
                .lastName( userCreationRequestDTO.lastName() )
                .email( userCreationRequestDTO.email() )
                .city( userCreationRequestDTO.city() )
                .country( userCreationRequestDTO.country() )
                .roles( userCreationRequestDTO.roles() )
                .cpf( userCreationRequestDTO.cpf() )
                .credentials( userCreationRequestDTO.credentials() )
                .store( userCreationRequestDTO.store() )
                .build();
    }
}
