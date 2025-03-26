package domain.User;

public class Attributes {

    private String country;
    private String city;
    private String cpf;

    public Attributes(String country, String city, String cpf) {
        this.country = country;
        this.city = city;
        this.cpf = cpf;
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

    public static AttributsBuilder builder() {
        return new AttributsBuilder();
    }

    public static class AttributsBuilder {
        private String country;
        private String city;
        private String cpf;

        public AttributsBuilder country(String country) {
            this.country = country;
            return this;
        }

        public AttributsBuilder city(String city) {
            this.city = city;
            return this;
        }

        public AttributsBuilder cpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public Attributes build() {
            return new Attributes(country, city, cpf);
        }
    }
}
