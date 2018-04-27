package com.aarongoldbin.persistence;


import com.fasterxml.jackson.databind.ObjectMapper;
//import org.geonames.api.*;
//import com.google.geocoder.*;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;

import org.geonames.Response;
import org.junit.Test;
import static org.junit.Assert.*;



public class PostalCodeTest {

    @Test
    public void testGeonamesJsonApi() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("http://api.geonames.org/findNearbyPostalCodesJSON" +
                        "?postalcode=53713&country=US&radius=16.1&maxRows=50&username=agoldbin");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        Response zipResonse = mapper.readValue(response, Response.class);
//        ResultsItem result = results.getResults().get(0);

        // test how many zips are returned
        assertEquals(35, zipResonse.getPostalCodes().size());
        // test first/closest zip returned
        assertEquals("???", zipResonse.getPostalCodes().get(0));
    }
}


