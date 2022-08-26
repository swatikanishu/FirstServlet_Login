package com.firstservletproject;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

    @WebServlet(description = "Login Servlet Testing", urlPatterns = { "/LoginServlet" }, initParams = {
            @WebInitParam(name = "user", value = "Swatika"), @WebInitParam(name = "password", value = "4A3567@89s") })
    public class LoginServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            String user = request.getParameter("user");

            String pwd = request.getParameter("pwd");
            String userID = getServletConfig().getInitParameter("user");
            String password = getServletConfig().getInitParameter("password");
            String nameValidate = "^[A-Z]{1}[a-z]{2,}";
            String passwordValidate = "^(?=.*[A-Z])(?=.*[0-9])([a-zA-Z0-9@._-]).{8,}$";

            if(userID.equals(user) && userID.matches(nameValidate) && password.equals(pwd) && password.matches(passwordValidate)) {
                request.setAttribute( "user", user);
                request.getRequestDispatcher("LoginSuccess.jsp").forward (request,response);

            } else {
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/Login.html");
                PrintWriter out = response.getWriter();
                out.println("<font colour=red> Either User name or Password is Wrong</font>");
                rd.include(request, response);
            }
        }
    }

