package integreation.DTOS;

import lombok.Builder;

@Builder
public record StoreCreationRequestDTO(

        String ownerId,
        String name,
        String description,
        String address,
        String city,
        String state

) {
}
