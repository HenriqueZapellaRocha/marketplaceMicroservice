package domain.enums;

public enum UserRoles {

    SIMPLE_USER( "SIMPLE_USER" ),
    STORE_ADMIN( "STORE_ADMIN" ),
    ADMIN( "ADMIN" );

    private final String role;

    UserRoles( String role ) {
        this.role = role;
    }
}
