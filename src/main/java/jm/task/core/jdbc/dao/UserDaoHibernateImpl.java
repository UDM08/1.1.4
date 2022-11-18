package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }

    private Session session;

    @Override
    public void createUsersTable() {
        try {
            session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            session.createSQLQuery("CREATE TABLE IF NOT EXISTS USERS (Id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,Name VARCHAR(20) NOT NULL,last_Name VARCHAR(40) NOT NULL, Age INT NOT NULL)").executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
    }

    @Override
    public void dropUsersTable() {
        try {
            session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            session.createSQLQuery("DROP TABLE IF EXISTS USERS").executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

        try {
            session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(new User(name, lastName, age));
            session.getTransaction().commit();
            System.out.println("User имя " + name + " фамилия " + lastName + " возраст " + age + " добавлен в базу данных ");
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
    }


    @Override
    public void removeUserById(long id) {
        try {
            session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(session.get(User.class, id));
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
    }


    @Override
    public List<User> getAllUsers() {
        List<User> user = null;
        try {
            session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            user = session.createQuery("FROM User ").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
        return user;
    }


    @Override
    public void cleanUsersTable() {
        try {
            session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            session.createSQLQuery("TRUNCATE TABLE USERS").executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
    }
}