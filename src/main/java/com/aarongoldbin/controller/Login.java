package com.aarongoldbin.controller;

import com.aarongoldbin.entity.Role;
import com.aarongoldbin.entity.User;
import com.aarongoldbin.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Directs user to user jsp page
 *
 * @author agoldbin
 */
@WebServlet(
        urlPatterns = {"/login"}
)
public class Login extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext;

        String userVal = req.getRemoteUser();

        GenericDao<User> localDao = new GenericDao<>(User.class);

        int id = localDao.getByPropertyLike("userName", userVal).get(0).getId();

        User user = localDao.getById(id);

        Role role = user.getRoles().iterator().next();

        int roleId = role.getId();

        String roleName = role.getRoleName();

        logger.info("~~~~~~~~~~~~~~~~~~~~~ROLE ID: ~~~~~~~~~~~~~~~~~~~~~~~~~" + roleId + "~~~~~" + roleName);

        servletContext = getServletContext();

        servletContext.setAttribute("userId", id);

        servletContext.setAttribute("role", roleName);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/user.jsp");

        dispatcher.forward(req, resp);

    }
//        ServletContext session;
//        List<User> users;
//        User thisUser = users.get(0);

//        users = userDao.getByPropertyLike("userName", userVal);
//        if (users == null || users.isEmpty()) {
//            // do something
//            RequestDispatcher dispatcher = req.getRequestDispatcher("/loginError.jsp");
//            dispatcher.forward(req, resp);
//
//        } else {






//        HttpSession session;
//        String userVal = req.getRemoteUser();
//
//        GenericDao<User> userDao = new GenericDao<>(User.class);
//        int id = userDao.getByPropertyLike("userName", userVal).get(0).getId();
//        User user = userDao.getById(id);
//
//            Role role = user.getRoles().iterator().next();
//            int roleId = role.getId();
//            String roleName = role.getRoleName();
//
//            logger.info("~~~~~~~~~~~~~~~~~~~~~ROLE ID: ~~~~~~~~~~~~~~~~~~~~~~~~~" + roleId + "~~~~~" + roleName);
//
//    //        session.getServletContext();
//            session = req.getSession();
//            session.setAttribute("user", user);
//            session.setAttribute("role", roleName);
//
//            RequestDispatcher dispatcher = req.getRequestDispatcher("/user.jsp");
//            dispatcher.forward(req, resp);
//        }
//         Get user who signed in and set their role
//        GenericDao userDao = new GenericDao(User.class);
//        req.getRemoteUser();


//        List<User> users = userDao.getByPropertyEqual("userName", );
//        User thisUser = users.get(0);
//

//        HttpSession session = request.getSession();
//        session.setAttribute("MySessionVariable", param);

//        HttpSession session = req.getSession();
//        session.setAttribute("user", thisUser);
//        logger.info("User signed in: " + thisUser.getUserName());
//
//
//        session.setAttribute("role", thisUser.getRoles());
//        logger.info("Roles retrieved: " + thisUser.getRoles());
//
//        resp.sendRedirect("/user.jsp");




}