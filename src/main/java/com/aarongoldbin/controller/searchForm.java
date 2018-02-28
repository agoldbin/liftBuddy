package com.aarongoldbin.controller;

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
        GenericDao userDao = new GenericDao(User.class);
        GenericDao gymDao = new GenericDao(Gym.class);

        String searchType;
        String searchTerm;
        String formAction = req.getParameter("submit");

        switch (formAction) {
            case "search":
                searchType = req.getParameter("searchType");
                searchTerm = req.getParameter("searchTerm");
                switch (searchType) {
                    case "id":
                        List<User> users = new ArrayList<User>(Arrays.asList((User) userDao.getById(Integer.parseInt(searchTerm))));
                        req.setAttribute("users", users);
                        directResults(req, resp, "/userResults.jsp");
                        break;
                    case "lastName":
                        req.setAttribute("users", (User) userDao.getByPropertyLike("lastName", searchTerm));
                        directResults(req, resp, "/userResults.jsp");
                        break;
                    case "gymName":
                        req.setAttribute("gyms", (Gym) gymDao.getByPropertyLike("gymName", searchTerm));
                        directResults(req, resp, "/gymResults.jsp");
                        break;
                    default:
                        logger.info("Error in searchForm. Unexpected Search Term. "
                                + "\nsearchType: " + searchType
                                + "\nsearchTerm: " + searchTerm)
                        ;
                }
            case "viewAllUsers":
                req.setAttribute("users", (User) userDao.getAll());
                directResults(req, resp, "/userResults.jsp");
                break;
            case "viewAllGyms":
                req.setAttribute("gyms", (Gym) gymDao.getAll());
                directResults(req, resp, "/gymResults.jsp");
                break;
            default:
                logger.info("Error in searchForm. Unexpected form action: " + formAction);
        }
    }

    private void directResults(HttpServletRequest req, HttpServletResponse resp, String url)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}