package com.aarongoldbin.controller;

import com.aarongoldbin.entity.Gym;
import com.aarongoldbin.entity.User;
import com.aarongoldbin.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.boot.model.relational.Database;

/**
 * Servlet to add a new user. If user enters a gym that is not in the database it will be created
 *
 * @author agoldbin
 */

@WebServlet(
    urlPatterns = {"/newUser"}
)
public class UserAdd extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    Gym gym;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // check gym to see if it exists. If not, create it
//        GenericDao gymDao = new GenericDao(Gym.class);
//        String userGym = req.getParameter("userGym");
//        List<Gym> gyms = gymDao.getByPropertyEqual("gymName", userGym);
//        if (gyms.size() > 1) {
//            // Gym exists
//            gym = gyms.get(0);
//        } else {
//            // Create new gym in db
//            gym = new Gym(userGym);
//            int id = gymDao.insert(gym);
//            logger.info("New Gym entered by user: " + gym);
//        }

        // TODO update site to take actual gym, not this debug stuff
        GenericDao gymDao = new GenericDao(Gym.class);
        Gym tempGym = (Gym) gymDao.getById(1);

        // TODO check if username already taken?

        // create new user. Add user to gym.
        String fName = req.getParameter("first_name");
        String lName = req.getParameter("last_name");
        String password = req.getParameter("password");

        GenericDao userDao = new GenericDao(User.class);
        User newUser = new User(req.getParameter("email"), req.getParameter("password")
                , req.getParameter("user_name"), req.getParameter("first_name")
                , req.getParameter("last_name"), tempGym, req.getParameter("location"));
        logger.info(newUser);
        userDao.insert(newUser);
        tempGym.addUser(newUser);

        logger.info("User created: " + newUser);

        // TODO add user to session
        req.setAttribute("user", newUser);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/user.jsp");
        dispatcher.forward(req, resp);
    }
}
