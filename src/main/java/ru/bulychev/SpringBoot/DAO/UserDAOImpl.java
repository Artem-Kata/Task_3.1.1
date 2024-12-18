package ru.bulychev.SpringBoot.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.bulychev.SpringBoot.models.User;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(int id, User updatedUser) {
        User userToUpdate = entityManager.find(User.class, id);
        if (userToUpdate != null) {
            userToUpdate.setName(updatedUser.getName());
            userToUpdate.setSurname(updatedUser.getSurname());
            userToUpdate.setAge(updatedUser.getAge());
            entityManager.merge(userToUpdate);
        }
    }

    @Override
    public User userById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void delete(int id) {
        User userToDelete = entityManager.find(User.class, id);
        if (userToDelete != null) {
            entityManager.remove(userToDelete);
        }
    }
}