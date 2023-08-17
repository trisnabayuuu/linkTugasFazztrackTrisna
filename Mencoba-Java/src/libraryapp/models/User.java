package libraryapp.models;

public class User {
    String username;
    String email;
    
    public User() {
    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    @Override
    public String toString() {
        return "user [username=" + username + ", email=" + email + "]";
    }
    
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
