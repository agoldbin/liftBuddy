package com.aarongoldbin.controller;

import com.aarongoldbin.entity.User;
import com.aarongoldbin.entity.Gym;
import com.aarongoldbin.persistence.GenericDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.geonames.PostalCodesItem;
import org.geonames.Response;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A servlet to SearchForm for users
 *
 * @author agoldbin
 */

@WebServlet(
        urlPatterns = {"/searchUser"}
)

public class UserSearch extends HttpServlet {
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
                    case "zip":
                        // TODO for loop to search for each zip?
//                        List<User> users = new ArrayList<User>(Arrays.asList((User) userDao.getById(Integer.parseInt(searchTerm))));
//                        req.setAttribute("users", users);
//                        directResults(req, resp, "/userResults.jsp");

                        List<User> users = new ArrayList<User>();
                        userDao.getByPropertyLike("location", zipSearch(searchTerm));

                        req.setAttribute("users", zipSearch(searchTerm));
                        directResults(req, resp, "/userResults.jsp");
                        break;
                    case "userName":
                        req.setAttribute("users", userDao.getByPropertyLike("userName", searchTerm));
                        directResults(req, resp, "/userResults.jsp");
                        break;
                    case "gymName":
                        req.setAttribute("gyms", gymDao.getByPropertyLike("gymName", searchTerm));
                        directResults(req, resp, "/gymResults.jsp");
                        break;
                    default:
                        logger.info("Error in SearchForm. Unexpected Search Term. "
                                + "\nsearchType: " + searchType
                                + "\nsearchTerm: " + searchTerm)
                        ;
                }
            case "viewAllGyms":
                req.setAttribute("gyms", gymDao.getAll());
                directResults(req, resp, "/gymResults.jsp");
                break;
            default:
                logger.info("Error in UserSearch. Unexpected form action: " + formAction);
        }
    }

    /**
     * This method will create a list of all postal codes returned in the search. It will then iterate through
     * the list and create a sql statement of the returned zip codes to be searched for.
     *
     * @param zip
     * @return
     */
    private String zipSearch(String zip) {
        String sql = "";
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("http://api.geonames.org/findNearbyPostalCodesJSON?"
                        + "postalcode="
                        + zip
                        +"&country=US&radius=16.1&maxRows=50&username=agoldbin");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        try {
            ArrayList<String> userZips = new ArrayList<>();
            Response zipResponse = mapper.readValue(response, Response.class);
            logger.info("# zip codes returned: "
                    + zipResponse.getPostalCodes().size());
            for (int i = 0; i < zipResponse.getPostalCodes().size(); i ++) {
                userZips.add(zipResponse.getPostalCodes().get(i).getPostalCode());
                sql += "\nOR WHERE location LIKE " + zipResponse.getPostalCodes().get(i).getPostalCode();
            }
            return sql.substring(3);
        } catch (IOException ioe) {
            logger.error("Err searching for zip in UserSearch: " + ioe);
            return sql;
        }
//        zipResponse.getPostalCodes().toArray();
    }

    /**
     * This method will determine which results page the user should end up on based on the type of search
     * they performed
     *
     * @param req
     * @param resp
     * @param url
     * @throws ServletException
     * @throws IOException
     */
    private void directResults(HttpServletRequest req, HttpServletResponse resp, String url)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}