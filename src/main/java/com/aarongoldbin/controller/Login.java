package com.aarongoldbin.controller;

import com.aarongoldbin.entity.User;
import com.aarongoldbin.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
        // Get user who signed in and set their role
        GenericDao userDao = new GenericDao(User.class);

        List<User> users = userDao.getByPropertyEqual("userName", req.getParameter("j_username"));
        User thisUser = users.get(0);


//        HttpSession session = request.getSession();
//        session.setAttribute("MySessionVariable", param);

        HttpSession session = req.getSession();
        session.setAttribute("user", thisUser);

        session.setAttribute("authType", thisUser.getRoles());
        logger.info("Roles retrieved: " + thisUser.getRoles());

        resp.sendRedirect("user.jsp");

    }
}