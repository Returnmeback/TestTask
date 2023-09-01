package API;



import lombok.Getter;
import lombok.Setter;

public class UserIsCreated {
    @Getter
    @Setter

    private Integer code;
    private String type;
    private String message;

    public UserIsCreated(Integer code, String type, String message) {
        this.code = code;
        this.type = type;
        this.message = message;
    }



    public Integer getCode() {
        return this.code;
    }

    public String getType() {
        return this.type;
    }

    public String getMessage() {
        return this.message;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

