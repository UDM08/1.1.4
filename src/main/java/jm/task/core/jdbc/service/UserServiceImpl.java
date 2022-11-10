package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDao userDao = new UserDaoHibernateImpl();

    public void createUsersTable() {
        userDao.createUsersTable();


    }

    public void dropUsersTable() {
        userDao.dropUsersTable();


    }

    public void saveUser(String name, String lastName, byte age) {
        userDao.saveUser(name,lastName,age);

    }

    public void removeUserById(long id) {
        userDao.removeUserById(id);


    }

    public List<User> getAllUsers() {

        List<User> user = userDao.getAllUsers();
        for(User u:user){
            System.out.println(u.toString());
        }

        return user;
    }


    public void cleanUsersTable() {
        userDao.cleanUsersTable();

    }
}
