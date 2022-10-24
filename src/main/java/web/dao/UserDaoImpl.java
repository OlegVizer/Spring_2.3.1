package web.dao;


import org.springframework.stereotype.Component;
import web.model.User;
import javax.persistence.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public List<User> getAllUser() {
        TypedQuery<User> query = entityManager.createQuery("select u from User u", User.class);
        return query.getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    @Override
    public User readUser(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
        entityManager.flush();
    }

    @Override
    public void removeUser(long id) {
        entityManager.remove(getUserById(id));
    }
}
