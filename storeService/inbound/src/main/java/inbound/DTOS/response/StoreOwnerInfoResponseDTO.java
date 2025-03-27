package inbound.DTOS.response;

import lombok.Builder;

@Builder
public record StoreOwnerInfoResponseDTO(

        String ownerId

) {
}
