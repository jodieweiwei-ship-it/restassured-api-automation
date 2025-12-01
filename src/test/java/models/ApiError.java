package models;

/**
 * API Error POJO
 * Maps error responses from the API
 */
public class ApiError {

    private String error;

    // Default constructor
    public ApiError() {
    }

    // Constructor with error message
    public ApiError(String error) {
        this.error = error;
    }

    // Getter and Setter
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
