package domain.User;

public class Credentials {

    private String value;
    private Boolean temporary = false;
    private String type;

    public Credentials( String value, Boolean temporary, String type ) {
        this.value = value;
        this.temporary = temporary;
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean getTemporary() {
        return temporary;
    }

    public void setTemporary(Boolean temporary) {
        this.temporary = temporary;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static CredentialsBuilder builder() {
        return new CredentialsBuilder();
    }

    public static class CredentialsBuilder {
        private String value;
        private Boolean temporary;
        private String type;

        CredentialsBuilder() {}

        public CredentialsBuilder value(String value) {
            this.value = value;
            return this;
        }

        public CredentialsBuilder temporary(Boolean temporary) {
            this.temporary = temporary;
            return this;
        }

        public CredentialsBuilder type(String type) {
            this.type = type;
            return this;
        }

        public Credentials build() {
            return new Credentials(value, temporary, type);
        }
    }
}