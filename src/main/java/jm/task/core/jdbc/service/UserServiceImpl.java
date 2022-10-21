package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDao userDao = new UserDaoJDBCImpl();
    private final UserDao userDaoHibernate = new UserDaoHibernateImpl();

    public void createUsersTable() {
        //userDao.createUsersTable();
        userDaoHibernate.createUsersTable();

    }

    public void dropUsersTable() {
        //userDao.dropUsersTable();
        userDaoHibernate.dropUsersTable();

    }

    public void saveUser(String name, String lastName, byte age) {
        //userDao.saveUser(name,lastName,age);
        userDaoHibernate.saveUser(name,lastName,age);
    }

    public void removeUserById(long id) {
        //userDao.removeUserById(id);
        userDaoHibernate.removeUserById(id);

    }

    public List<User> getAllUsers() {
        List<User> user = userDaoHibernate.getAllUsers();
        //List<User> user = userDao.getAllUsers();
        for(User u:user){
            System.out.println(u.toString());
        }

        return user;
    }


    public void cleanUsersTable() {
        //userDao.cleanUsersTable();
        userDaoHibernate.cleanUsersTable();

    }
}
