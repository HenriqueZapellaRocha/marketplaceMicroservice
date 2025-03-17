package domain.User;

import domain.Store.Store;
import domain.enums.UserRoles;

public class User {

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private UserRoles roles;
    private String userId;
    private String country;
    private String city;
    private String cpf;
    private Store store;

    public User(String username, String firstName, String lastName, String email, UserRoles roles, String userId,
                String country, String city, String cpf, Store store) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.roles = roles;
        this.userId = userId;
        this.country = country;
        this.city = city;
        this.cpf = cpf;
        this.store = store;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public UserRoles getRoles() {
        return roles;
    }

    public void setRoles(UserRoles roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static class UserBuilder {

        private String username;
        private String firstName;
        private String lastName;
        private String email;
        private UserRoles roles;
        private String userId;
        private String country;
        private String city;
        private String cpf;
        private Store store;

        public UserBuilder() {}

        public static UserBuilder Builder() {
            return new UserBuilder();
        }

        public UserBuilder username(String username) {
            this.username = username;
            return this;
        }

        public UserBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder roles(UserRoles roles) {
            this.roles = roles;
            return this;
        }

        public UserBuilder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public UserBuilder country(String country) {
            this.country = country;
            return this;
        }

        public UserBuilder city(String city) {
            this.city = city;
            return this;
        }

        public UserBuilder cpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public UserBuilder store( Store store ) {
            this.store = store;
            return this;
        }

        public User build() {
            return new User(username, firstName, lastName, email, roles, userId, country, city, cpf, store);
        }


    }
}
