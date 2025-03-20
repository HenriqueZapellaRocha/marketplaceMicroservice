package integreation.DTOS;

import lombok.Builder;


@Builder
public record RoleRequestDTO(

        String id,
        String name


) {
}
