package libraryapp.dao;

import java.util.ArrayList;
import java.util.List;

import libraryapp.models.User;

public class UserDao implements BaseDao<User, Integer> {

    List<User> user = new ArrayList<>();

    @Override
    public void create(User data) {
        user.add(data);
    }

    @Override
    public void delete(Integer id) {
        user.remove(id-1);
    }

    @Override
    public List<User> findAll() {
        return this.user;
    }

    @Override
    public User findById(Integer id) {
        return this.user.get(id - 1 );
    }

    @Override
    public void update(Integer id, User data) {
        user.set(id -1, data);
    }

    
}
