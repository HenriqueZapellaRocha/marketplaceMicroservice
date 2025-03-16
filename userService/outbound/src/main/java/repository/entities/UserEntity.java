package repository.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document( collection = "users" )
@Data
@AllArgsConstructor
@Builder
public class UserEntity {

    @Id
    private String userId;
    private String country;
    private String city;
    private String cpf;
}
