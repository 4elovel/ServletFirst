package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calculate")
public class CalculateServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Обчислення з трьох чисел</title></head><body>");
        out.println("<form action=\"calculate\" method=\"post\">");
        out.println("<label for=\"num1\">Число 1:</label>");
        out.println("<input type=\"text\" id=\"num1\" name=\"num1\"><br>");
        out.println("<label for=\"num2\">Число 2:</label>");
        out.println("<input type=\"text\" id=\"num2\" name=\"num2\"><br>");
        out.println("<label for=\"num3\">Число 3:</label>");
        out.println("<input type=\"text\" id=\"num3\" name=\"num3\"><br>");
        out.println("<input type=\"radio\" id=\"max\" name=\"action\" value=\"max\" checked>");
        out.println("<label for=\"max\">Максимум</label><br>");
        out.println("<input type=\"radio\" id=\"min\" name=\"action\" value=\"min\">");
        out.println("<label for=\"min\">Мінімум</label><br>");
        out.println("<input type=\"radio\" id=\"avg\" name=\"action\" value=\"avg\">");
        out.println("<label for=\"avg\">Середнє арифметичне</label><br>");
        out.println("<input type=\"submit\" value=\"Обчислити\">");
        out.println("</form>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));
        int num3 = Integer.parseInt(request.getParameter("num3"));
        String action = request.getParameter("action");

        int result = 0;
        String resultText = "";

        switch (action) {
            case "max":
                result = Math.max(num1, Math.max(num2, num3));
                resultText = "Максимальне число";
                break;
            case "min":
                result = Math.min(num1, Math.min(num2, num3));
                resultText = "Мінімальне число";
                break;
            case "avg":
                result = (num1 + num2 + num3) / 3;
                resultText = "Середнє арифметичне";
                break;
        }

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Обчислення з трьох чисел</title></head><body>");
        out.println("<h2>Введені числа:</h2>");
        out.println("<p>" + num1 + ", " + num2 + ", " + num3 + "</p>");
        out.println("<h3>" + resultText + ":</h3>");
        out.println("<p>" + result + "</p>");
        out.println("</body></html>");
    }
}
