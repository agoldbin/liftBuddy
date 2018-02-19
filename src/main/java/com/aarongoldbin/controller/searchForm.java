package com.aarongoldbin.controller;

import com.aarongoldbin.entity.User;
import com.aarongoldbin.entity.Gym;
import com.aarongoldbin.persistence.UserDao;
import com.aarongoldbin.persistence.GymDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A servlet to searchForm for users
 *
 * @author agoldbin
 */

@WebServlet(
        urlPatterns = {"/searchForm"}
)

public class searchForm extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        GymDao gymDao = new GymDao();

        String searchType;
        String searchTerm;
        String formAction = req.getParameter("submit");

        switch (formAction) {
            case "search":
                searchType = req.getParameter("searchType");
                searchTerm = req.getParameter("searchTerm");
                switch (searchType) {
                    case "id":
                        List<User> users = new ArrayList<User>(Arrays.asList(userDao.getById(Integer.parseInt(searchTerm))));
                        req.setAttribute("users", users);
//                        userDao.getByPropertyLike("id", searchTerm);
                        break;
                    case "lastName":
                        req.setAttribute("users", userDao.getAllUsersByLastName(searchTerm));
                        break;
                    case "gymName":
                        req.setAttribute("gyms", gymDao.getByPropertyLike("gymName", searchTerm));
                        break;
                    default:
                        logger.info("Error in searchForm. Unexpected Search Term. "
                                + "\nsearchType: " + searchType
                                + "\nsearchTerm: " + searchTerm)
                        ;
                }
            case "viewAllUsers":
                req.setAttribute("users", userDao.getAll());
//           userDao.getAllUsers();
                break;
            case "viewAllGyms":
                req.setAttribute("gyms", gymDao.getAll());
//                gymDao.getAllGyms();
                break;
            default:
                logger.info("Error in searchForm. Unexpected form action: " + formAction);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);
    }
}


/*


        if (req.getParameter("submit").equals("searchForm")) {

        }
        switch ()


/*
        String searchButton = "submit";



        if (req.getParameter("submit").equals("searchForm")) {
            if (req.getParameter("searchType").equals("lastName")) {
                req.setAttribute("users", userDao.getAllUsersByLastName(req.getParameter("searchTerm")));
            } else if (req.getParameter("searchType").equals("id")) {
                // convert returned user id to a list
                List<User> users = new ArrayList<User>(Arrays.asList(userDao.getById(Integer.parseInt(req.getParameter("searchTerm")))));
                req.setAttribute("users", users);
            } else if (req.getParameter("searchType").equals("gymName")) {
                // convert returned user id to a list
                List<User> users = new ArrayList<User>(Arrays.asList(userDao.getById(Integer.parseInt(req.getParameter("searchTerm")))));
                req.setAttribute("users", users);
            }
        } else {
            req.setAttribute("users", userDao.getAllGyms());
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);

*/