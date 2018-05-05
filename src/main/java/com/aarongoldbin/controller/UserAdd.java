package com.aarongoldbin.controller;

import com.aarongoldbin.entity.Gym;
import com.aarongoldbin.entity.Role;
import com.aarongoldbin.entity.User;
import com.aarongoldbin.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import jdk.nashorn.internal.ir.RuntimeNode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.geonames.Response;

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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String gymParam;
        GenericDao gymDao = new GenericDao(Gym.class);
        Gym userGym;

        // check if user selected existing gym
        userGym = checkGym(req, resp);

        // TODO check if username already taken?

        // create new user. Add user to gym.
        String fName = req.getParameter("first_name");
        String lName = req.getParameter("last_name");
        String password = req.getParameter("password");

        GenericDao userDao = new GenericDao(User.class);
        User newUser = new User(req.getParameter("email"), req.getParameter("password")
                , req.getParameter("user_name"), req.getParameter("first_name")
                , req.getParameter("last_name"), userGym, req.getParameter("location"));
        logger.info(newUser);
        userDao.insert(newUser);
        userGym.addUser(newUser);

        // default new user to role "buddy"
        String roleName = "buddy";
        Role role = new Role(newUser, roleName);

        newUser.addRole(role);

//        ServletContext servletContext = req.getServletContext();
//        servletContext.setAttribute("user", newUser);
//        logger.info("New user: " + newUser.getUserName());
//
//        servletContext.setAttribute("authType", newUser.getRoles());
//        logger.info("Roles retrieved: " + newUser.getRoles());


        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }

    public Gym checkGym(HttpServletRequest req, HttpServletResponse resp) {
        String gymParam;
        GenericDao gymDao = new GenericDao(Gym.class);
        Gym userGym;

        if (! req.getParameter("gymSelect").equalsIgnoreCase("")) {
            gymParam = req.getParameter("gymSelect");
            userGym = (Gym) gymDao.getByPropertyEqual("gymName", gymParam).get(0);
        } else {
            // insert new gym into DB;
            gymParam = req.getParameter("newGym");
            userGym = new Gym(gymParam);
            gymDao.insert(userGym);
        }
        return userGym;
    }
}
