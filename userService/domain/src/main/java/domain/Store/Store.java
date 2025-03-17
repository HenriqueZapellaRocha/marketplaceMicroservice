package domain.Store;

public class Store {

    private String id;
    private String name;
    private String description;
    private String address;
    private String city;
    private String state;

    public Store() {
    }

    public Store(String id, String name, String description, String address, String city, String state) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.address = address;
        this.city = city;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public static class StoreBuilder {
        private String id;
        private String name;
        private String description;
        private String address;
        private String city;
        private String state;

        public static StoreBuilder Builder() {
            return new StoreBuilder();
        }

        public StoreBuilder id( String id ) {
            this.id = id;
            return this;
        }

        public StoreBuilder name( String name ) {
            this.name = name;
            return this;
        }

        public StoreBuilder description( String description ) {
            this.description = description;
            return this;
        }

        public StoreBuilder address( String address ) {
            this.address = address;
            return this;
        }

        public StoreBuilder city( String city ) {
            this.city = city;
            return this;
        }

        public StoreBuilder state( String state ) {
            this.state = state;
            return this;
        }

        public Store build() {
            return new Store( id, name, description, address, city, state );
        }
    }
}
