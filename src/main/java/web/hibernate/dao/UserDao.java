package web.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import web.hibernate.model.User;

import java.util.List;

@Repository
public class UserDao {

    @PersistenceContext
    private EntityManager emf;

    public void save(User user){
        emf.persist(user);
    }

    public List<User> findAll() {
        return emf.createQuery("from User", User.class).getResultList();
    }

    public User findById(Long id){
        return emf.find(User.class, id);
    }

    public void delete(Long id){
        User user = findById(id);
        emf.remove(user);
    }

    public void update(User user){
        emf.merge(user);
    }
}
