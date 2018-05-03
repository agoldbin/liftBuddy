package com.aarongoldbin.controller;

import com.aarongoldbin.entity.Role;
import com.aarongoldbin.entity.User;
import com.aarongoldbin.entity.Gym;
import com.aarongoldbin.persistence.GenericDao;
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
 * A servlet to SearchForm for users
 *
 * @author agoldbin
 */

@WebServlet(
        urlPatterns = {"/adminSearch"}
)

public class AdminSearch extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao userDao = new GenericDao<>(User.class);
        GenericDao gymDao  = new GenericDao<>(Gym.class);
        GenericDao roleDao = new GenericDao<>(Role.class);

        String searchType;
        String searchTerm;
        String formAction = req.getParameter("submit");

        switch (formAction) {
            case "search":
                searchType = req.getParameter("searchType");
                searchTerm = req.getParameter("searchTerm");
                switch (searchType) {
                    case "id":
                        User user = (User) userDao.getById(Integer.parseInt(searchTerm));
                        req.setAttribute("user", user);
                        directResults(req, resp, "/adminUserResults.jsp");
                        break;
                    case "userName":
                        req.setAttribute("users", userDao.getByPropertyLike("userName", searchTerm));
                        directResults(req, resp, "/adminUserResults.jsp");
                        break;
                    case "lastName":
                        req.setAttribute("users", userDao.getByPropertyLike("lastName", searchTerm));
                        directResults(req, resp, "/adminUserResults.jsp");
                        break;
                    case "gymName":
                        req.setAttribute("gyms", gymDao.getByPropertyLike("gymName", searchTerm));
                        directResults(req, resp, "/adminGymResults.jsp");
                        break;
                    default:
                        logger.info("Error in AdminSearch. Unexpected Search Term. "
                                + "\nsearchType: " + searchType
                                + "\nsearchTerm: " + searchTerm)
                        ;
                }
            case "viewAllUsers":
                req.setAttribute("users", userDao.getAll());
                directResults(req, resp, "/adminUserResults.jsp");
                break;
            case "viewAllGyms":
                req.setAttribute("gyms", gymDao.getAll());
                directResults(req, resp, "/adminGymResults.jsp");
                break;
            case "viewAllAdmins":
                req.setAttribute("admins", userDao.getByPropertyLike("roles.roleName", "admin"));
//                req.setAttribute("admins", roleDao.getByPropertyEqual("roleName", "admin"));
                directResults(req, resp, "/adminUserResults.jsp");
                break;
            case "addAdmin":
                req.setAttribute("users", userDao.getAll());
                directResults(req, resp, "/adminNew.jsp");
                break;
            case "addUser":
                break;
            case "addGym":
                directResults(req, resp, "/gymNew.jsp");
                break;
            default:
                logger.info("Error in AdminSearch. Unexpected form action: " + formAction);
        }
    }

    private void directResults(HttpServletRequest req, HttpServletResponse resp, String url)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}