package libraryapp.services.user;

import java.util.List;

import libraryapp.dao.UserDao;
import libraryapp.models.User;

public class UserImpl implements UserService {
    UserDao userDao;

    public UserImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void createUser(User user) {
        if (user.getUsername() == "") {
            System.out.println("Username empty");
            
        } else if (user.getEmail() == ""){
            System.out.println("Email empty");
        } else {
            
        }
        userDao.create(user);
        System.out.println("user sucessfully added");
    }

    @Override
    public List<User> getUser() {
        return userDao.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        return userDao.findById(1);
    }
    
}
