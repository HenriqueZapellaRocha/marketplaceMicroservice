package com.example.demo.repository.mappers;

import com.example.demo.domain.User;
import com.example.demo.repository.entities.UserEntity;


public class UserRepositoryMappers {

    public static UserEntity domainToEntity(User user ) {

        return UserEntity.builder()
                .userId( user.getUserId() )
                .country( user.getCountry() )
                .city( user.getCity() )
                .cpf( user.getCpf() )
                .build();

    }
}
