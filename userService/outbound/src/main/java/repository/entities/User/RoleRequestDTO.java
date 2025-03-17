package repository.entities.User;

import lombok.Builder;


@Builder
public record RoleRequestDTO(

        String id,
        String name


) {
}
