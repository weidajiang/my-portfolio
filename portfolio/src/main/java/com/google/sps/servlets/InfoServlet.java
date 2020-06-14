package com.google.sps.servlets;

import com.google.sps.entity.PersonInfo;
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


@WebServlet("/info")
public class InfoServlet extends HttpServlet {


  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd");
    // create new person object
    PersonInfo person= new PersonInfo();

    // fill my info
    person.setAddress("New York, NY, USA");
    try {
        person.setBirthday(format.parse("1900-12-10"));
    } catch (ParseException e) {
        e.printStackTrace();
    }
    person.setEmail("jiangwd1992@gmail.com");
    person.setPhone_number("(+1) 646 000 0000");    
    // convert to json and return
    String json = convertToJsonUsingGson(person);
    response.setContentType("application/json;");
    response.getWriter().println(json);
  }

  private String convertToJsonUsingGson(PersonInfo person) {
    // create new builder to format time
    Gson gson =  new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
    String json = gson.toJson(person);
    return json;
  }

}
