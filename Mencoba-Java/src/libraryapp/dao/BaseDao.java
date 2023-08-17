package libraryapp.dao;

import java.util.List;

public interface BaseDao <E, ID>{
    void create(E data);

    List<E> findAll();

    E findById(ID id);

    void update(ID id, E data);

    void delete(ID id);
}
