package com.aarongoldbin.controller;

import com.aarongoldbin.entity.Gym;
import com.aarongoldbin.persistence.GymDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.*;

/**
 * A servlet to searchForm for gyms
 *
 * @author agoldbin
 */
/*
@WebServlet(
        urlPatterns = {"/searchUser"}
)

public class searchGym extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GymDao gymDao = new GymDao();

        if (req.getParameter("submit").equals("searchForm")
                && req.getParameter("searchType").equals("lastName")) {
            req.setAttribute("users", gymDao.getAllUsersByLastName(req.getParameter("searchTerm")));
        } else if (req.getParameter("submit").equals("searchForm")
                && req.getParameter("searchType").equals("id")) {
            // convert returned user id to a list
            List<Gym> gyms = new ArrayList<Gym>(Arrays.asList(gymDao.getByGymName(req.getParameter("searchTerm"))));
            req.setAttribute("users", users);
        } else {
            req.setAttribute("users", gymDao.getAllGyms());
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/userResults.jsp");
        dispatcher.forward(req, resp);
    }
}
*/