package repositories.mappers;

import domain.User.User;
import domain.enums.UserRoles;
import integreation.DTOS.RoleRequestDTO;
import repositories.entities.User.UserEntity;


public class UserRepositoryMappers {

    public static UserEntity domainToEntity( User user ) {

        return UserEntity.builder()
                .userId( user.getUserId() )
                .country( user.getCountry() )
                .city( user.getCity() )
                .cpf( user.getCpf() )
                .build();

    }

    public static RoleRequestDTO valuesToRoleRequestDTO( String roleId, UserRoles userRoleName ) {

        return RoleRequestDTO.builder()
                .id( roleId )
                .name( userRoleName.toString() )
                .build();

    }
}
