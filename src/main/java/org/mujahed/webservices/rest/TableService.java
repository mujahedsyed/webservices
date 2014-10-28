package org.mujahed.webservices.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mujahed on 28/10/2014.
 */
@ApplicationPath("math")
@Path("table")
public class TableService extends Application {
    @POST
    @Path("/post")
    @Consumes("application/x-www-form-urlencoded")

    public String getTable(String num) {
        MathTable mt = new MathTable(new Integer(num));
        return "" + mt.toString();
    }


    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<Class<?>>();
        s.add(TableService.class);
        return s;
    }
}