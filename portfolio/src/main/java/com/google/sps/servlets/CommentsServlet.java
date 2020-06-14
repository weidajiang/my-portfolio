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

/** Servlet that returns some example content. TODO: modify this file to handle comments data */
@WebServlet("/comments")
public class CommentsServlet extends HttpServlet {

  private List<Comments> commentList = new ArrayList<Comments>();

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("application/json;");

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

         System.out.println(firstname+","+lastname+","+email+","+comment);

          if(comment.equals("")){
             response.setContentType("text/html;");
             response.getWriter().println("Empty Comment!");
          }else{
             Comments c = new Comments(firstname,lastname,email,comment,timestamp);
             commentList.add(c);

          }
          response.sendRedirect("/index.html#commentlist");


  }

}