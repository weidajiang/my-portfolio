package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.List;
import com.google.sps.entity.Comments;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.SortDirection;

/** Servlet that returns some example content. TODO: modify this file to handle comments data */
@WebServlet("/comments")
public class CommentsServlet extends HttpServlet {


  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {


    Query query = new Query("Comments").addSort("timestamp", SortDirection.DESCENDING);

    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
    PreparedQuery results = datastore.prepare(query);

    List<Comments> commentList = new ArrayList<>();
    for (Entity entity : results.asIterable()) {
      long id = entity.getKey().getId();
      String firstName = (String) entity.getProperty("firstName");
      String lastName = (String) entity.getProperty("lastName");
      String comment = (String) entity.getProperty("comment");
      String email = (String) entity.getProperty("email");
      long timestamp = (long) entity.getProperty("timestamp");
      Comments c = new Comments(id, firstName, lastName,email, comment, timestamp);
      commentList.add(c);
    }

    response.setContentType("application/json;");
    response.setCharacterEncoding("utf-8");

    Gson gson = new Gson(); 
    response.getWriter().println(gson.toJson(commentList));
      
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

          String firstname = request.getParameter("firstname");
          String lastname = request.getParameter("lastname");
          String email = request.getParameter("email");
          long timestamp = System.currentTimeMillis();
          String comment = request.getParameter("comment");

         //System.out.println(firstname+","+lastname+","+email+","+comment);

          if(comment.equals("")){
             response.setContentType("text/html;");
             response.getWriter().println("Empty Comment!");
          }else{

            Entity commentEntity = new Entity("Comments");
            commentEntity.setProperty("firstName", firstname);
            commentEntity.setProperty("lastName", lastname);
            commentEntity.setProperty("email", email);
            commentEntity.setProperty("timestamp", timestamp);
            commentEntity.setProperty("comment", comment);

             DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
             datastore.put(commentEntity);
            //  Comments c = new Comments(firstname,lastname,email,comment,timestamp);
            //  commentList.add(c);

          }
          response.sendRedirect("/index.html#commentlist");


  }

}