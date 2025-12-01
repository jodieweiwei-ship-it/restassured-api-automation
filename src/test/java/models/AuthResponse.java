package models;

/**
 * Authentication Response POJO
 * Maps the response from successful /register and /login requests
 */
public class AuthResponse {

    private Integer id;
    private String token;

    // Default constructor
    public AuthResponse() {
    }

    // Constructor with both fields
    public AuthResponse(Integer id, String token) {
        this.id = id;
        this.token = token;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
