package jae.phones.JAEphones.Payloads;

import javax.validation.constraints.NotBlank;

/**
 * LoginRequest
 */
public class LoginRequest {

    @NotBlank
    private String usernameOrEmail;

    @NotBlank
    private String password;

    public String getUsernameOrEmail() {
        return this.usernameOrEmail;
    }

    public void setUsernameOrEmail(String usernameOrEmail) {
        this.usernameOrEmail = usernameOrEmail;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}