package web.service;

import org.springframework.transaction.annotation.Transactional;
import web.hibernate.dao.UserDao;
import org.springframework.stereotype.Service;
import web.hibernate.model.User;

import java.util.List;


@Transactional
@Service
public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao){
        this.userDao = userDao;
    }

    public void save(User user){
        userDao.save(user);
    }

    public void delete(Long id){
        userDao.delete(id);
    }

    @Transactional(readOnly = true)
    public User findById(Long id){
        return userDao.findById(id);
    }

    @Transactional(readOnly = true)
    public List<User> findAll(){
        return userDao.findAll();
    }

    public void update(User user){
        userDao.update(user);
    }

}
