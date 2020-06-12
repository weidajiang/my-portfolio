package com.google.sps.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// create my Randon motto servlet
@WebServlet("/random_motto")
public class RandomMotto extends HttpServlet {
  
  private List<String> mottos;

  @Override
  public void init() {
    // create a arraylist to store the mottos
    mottos = new ArrayList<>();
    mottos.add(
        "The attitude towards things determines someone’s destiny," 
       + " and the key to success is the ability to capture details.");
    mottos.add("虽然过去不能改变，未来可以!"); // means We can't change pass, but we can change future
    mottos.add("Good enough isn't good enough.");
    mottos.add("Vision Without Action Is A Daydream. - Japanese Proverb");
    mottos.add("If You Want To Go Fast, Go Alone. If You Want To Go Far, Go With Others – African Proverb");
  }

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    String motto = mottos.get((int) (Math.random() * mottos.size()));
    response.setContentType("text/html;");
    // in case Chinese does not display properly
    response.setCharacterEncoding("utf-8");
    response.getWriter().println(motto);
  }

}
