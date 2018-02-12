package com.aarongoldbin.persistence;

import com.aarongoldbin.entity.Profile;
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

public class ProfileDao {
    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    public List<Profile> getAllprofilesByLastName(String lastName) {
        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Profile> query = builder.createQuery(Profile.class);
        Root<Profile> root = query.from(Profile.class);
        Expression<String> propertyPath = root.get("lastName");
        query.where(builder.like(propertyPath, "%" + lastName + "%"));
        List<Profile> profiles = session.createQuery(query).getResultList();
        session.close();
        return profiles;
    }

//    TODO change this method to getByGym/getByLocation?
    /**
     * Gets a Profile by id
     *
     * @return a Profile
     */
    public Profile getById(int id) {
        Session session = sessionFactory.openSession();
        Profile Profile = session.get(Profile.class, id);
        session.close();
        return Profile;
    }

    /**
     * update Profile
     *
     * @param Profile Profile to be inserted or updated
     */
    public void saveOrUpdate(Profile Profile) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(Profile);
        transaction.commit();
        session.close();
    }

    /**
     * update Profile
     *
     * @param Profile Profile to be inserted or updated
     */
    public int insert(Profile Profile) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int) session.save(Profile);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a Profile
     *
     * @param Profile Profile to be deleted
     */
    public void delete(Profile Profile) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(Profile);
        transaction.commit();
        session.close();
    }


    /**
     * Return a list of all profiles
     *
     * @return All profiles
     */
    public List<Profile> getAll() {

        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Profile> query = builder.createQuery(Profile.class);
        Root<Profile> root = query.from(Profile.class);
        List<Profile> profiles = session.createQuery(query).getResultList();

        logger.debug("The list of profiles " + profiles);
        session.close();

        return profiles;
    }

    /**
     * Get Profile by property (exact match)
     * sample usage: getByPropertyEqual("lastname", "Curry")
     */
    public List<Profile> getByPropertyEqual(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for Profile with " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Profile> query = builder.createQuery(Profile.class);
        Root<Profile> root = query.from(Profile.class);
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<Profile> profiles = session.createQuery(query).getResultList();

        session.close();
        return profiles;
    }

    /**
     * Get Profile by property (like)
     * sample usage: getByPropertyLike("lastname", "C")
     */
    public List<Profile> getByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for Profile with {} = {}", propertyName, value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Profile> query = builder.createQuery(Profile.class);
        Root<Profile> root = query.from(Profile.class);
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<Profile> profiles = session.createQuery(query).getResultList();
        session.close();
        return profiles;
    }
}
