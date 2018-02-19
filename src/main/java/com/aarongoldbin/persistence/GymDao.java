package com.aarongoldbin.persistence;

import com.aarongoldbin.entity.Gym;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

public class GymDao {
    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Method to return all gym names in the DB
     *
     * @param gymName
     * @return names of gyms in DB based on users searchForm
     */
    public List<Gym> getByGymName(String gymName) {
        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Gym> query = builder.createQuery(Gym.class);
        Root<Gym> root = query.from(Gym.class);
        Expression<String> propertyPath = root.get("gymName");
        query.where(builder.like(propertyPath, "%" + gymName + "%"));
        List<Gym> gyms = session.createQuery(query).getResultList();
        session.close();
        return gyms;
    }

    /**
     * Gets a gym by id
     *
     * @return a user
     */
    public Gym getById(int gymId) {
        Session session = sessionFactory.openSession();
        Gym gym = session.get(Gym.class, gymId);
        session.close();
        return gym;
    }

    /**
     * update gym
     *
     * @param gym Gym to be inserted or updated
     */
    public void saveOrUpdate(Gym gym) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(gym);
        transaction.commit();
        session.close();
    }

    /**
     * insert gym
     *
     * @param gym Gym to be inserted or updated
     */
    public int insert(Gym gym) {
        int gymId = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        gymId = (int) session.save(gym);
        transaction.commit();
        session.close();
        return gymId;
    }

    /**
     * Delete a gym
     *
     * @param gym Gym to be deleted
     */
    public void delete(Gym gym) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(gym);
        transaction.commit();
        session.close();
    }


    /**
     * Return a list of all gym names
     *
     * @return All gym names
     */
    public List<Gym> getAll() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Gym> query = builder.createQuery(Gym.class);
        Root<Gym> root = query.from(Gym.class);
        List<Gym> gyms = session.createQuery(query).getResultList();

        logger.debug("The list of gyms " + gyms);
        session.close();

        return gyms;
    }

    /**
     * Get user by property (like)
     * sample usage: getByPropertyLike("gymName", "A")
     */
    public List<Gym> getByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for gyms with {} = {}", propertyName, value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Gym> query = builder.createQuery(Gym.class);
        Root<Gym> root = query.from(Gym.class);
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<Gym> gyms = session.createQuery(query).getResultList();
        session.close();
        return gyms;
    }
}