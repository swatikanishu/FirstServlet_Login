package com.firstservletproject;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

    @WebServlet("/FirstServlet")
    public class FirstServlet extends HttpServlet {
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws IOException {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h3> Hello Swatika My First Servlet </h3>");
            out.close();

        }
    }

