package libraryapp.services.user;

import java.util.List;

import libraryapp.models.User;


public interface UserService {
    void createUser(User user);

    List<User> getUser();

    User getUserById(Integer id);
}
