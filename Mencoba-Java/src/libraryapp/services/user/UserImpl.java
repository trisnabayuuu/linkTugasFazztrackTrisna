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
            throw new ExceptionInInitializerError("username tidak boleh kosong");
            
        } else if (user.getEmail() == ""){
            throw new ExceptionInInitializerError("email tidak boleh kosong");
        } else {
            
        }
        userDao.create(user);
        System.out.println("user sucessfully added");
    }

    @Override
    public List<User> getUser() {
        if (userDao == null) {
            throw new ExceptionInInitializerError("User kosong");
            
        }
        return userDao.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        try {
            return userDao.findById(id);
            
        } catch (IndexOutOfBoundsException e) {
            System.out.println("id tidak ditemukan");
        }
        return null;
        
    }
    
}
