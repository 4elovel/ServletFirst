package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/maxnumber")
public class MaxNumberServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Максимум із трьох чисел</title></head><body>");
        out.println("<form action=\"maxnumber\" method=\"post\">");
        out.println("<label for=\"num1\">Число 1:</label>");
        out.println("<input type=\"text\" id=\"num1\" name=\"num1\"><br>");
        out.println("<label for=\"num2\">Число 2:</label>");
        out.println("<input type=\"text\" id=\"num2\" name=\"num2\"><br>");
        out.println("<label for=\"num3\">Число 3:</label>");
        out.println("<input type=\"text\" id=\"num3\" name=\"num3\"><br>");
        out.println("<input type=\"submit\" value=\"Обчислити максимум\">");
        out.println("</form>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));
        int num3 = Integer.parseInt(request.getParameter("num3"));

        int max = Math.max(num1, Math.max(num2, num3));

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Максимум із трьох чисел</title></head><body>");
        out.println("<h2>Введені числа:</h2>");
        out.println("<p>" + num1 + ", " + num2 + ", " + num3 + "</p>");
        out.println("<h3>Максимальне число:</h3>");
        out.println("<p>" + max + "</p>");
        out.println("</body></html>");
    }
}
