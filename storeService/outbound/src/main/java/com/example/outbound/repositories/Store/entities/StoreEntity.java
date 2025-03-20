package com.example.outbound.repositories.Store.entities;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document( collection = "stores" )
@Data
@Builder
public class StoreEntity {

    @Id
    private String id;
    
    private String ownerId;

    @Indexed( unique = true )
    private String name;


    private String description;
    private String address;
    private String city;
    private String state;
}
