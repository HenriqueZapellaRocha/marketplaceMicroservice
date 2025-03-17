package domain.exceptions;


public class UserCreationErrorDTO {

    private String error;

    public UserCreationErrorDTO() {
    }

    public UserCreationErrorDTO(String error) {
        this.error = error;
    }
    public String getError() {
        return error;
    }

}
