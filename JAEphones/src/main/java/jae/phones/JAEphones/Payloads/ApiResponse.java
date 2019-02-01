package jae.phones.JAEphones.Payloads;

/**
 * ApiResponse
 */
public class ApiResponse {

    private Boolean success;
    private String message;

    public ApiResponse(Boolean success, String messsage) {
        this.success = success;
        this.message = messsage;
    }

    public Boolean getSuccess() {
        return this.success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}