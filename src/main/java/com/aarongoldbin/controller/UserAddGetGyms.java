package com.aarongoldbin.controller;

import com.aarongoldbin.entity.Gym;
import com.aarongoldbin.persistence.GenericDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Servlet to get gyms from liftbuddy database to populate dropdown selection
 *
 * @author agoldbin
 */

@WebServlet(
        urlPatterns = {"/getGyms"}
)
public class UserAddGetGyms extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get gyms currently in DB to populate new user dropdown selection
        GenericDao gymDao = new GenericDao(Gym.class);
        List<Gym> gyms = gymDao.getAll();

        HttpSession session = req.getSession();
        session.setAttribute("gyms", gyms);

//        TODO actually forward to the jsp...
        resp.sendRedirect(req.getContextPath() + "/userNew.jsp");

//        resp.sendRedirect("../LiftBuddy/userNew.jsp");

    }
}
