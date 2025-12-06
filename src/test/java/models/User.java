package models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * User POJO
 * Represents a user object from Reqres API
 */
public class User {

    private Integer id;
    private String email;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    private String avatar;//profile picture.

    // Fields for Create/Update requests (Reqres uses name/job)
    private String name;
    private String job;

    // Default constructor
    public User() {
    }

    // Constructor for Create/Update
    public User(String name, String job) {
        this.name = name;
        this.job = job;
    }

    // Builder pattern
    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public static class UserBuilder {
        private String name;
        private String job;

        public UserBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder job(String job) {
            this.job = job;
            return this;
        }

        public User build() {
            return new User(name, job);
        }
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
