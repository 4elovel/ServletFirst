package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calculator")
public class CalculatorServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Калькулятор</title></head><body>");
        out.println("<form action=\"calculator\" method=\"post\">");
        out.println("<label for=\"num1\">Число 1:</label>");
        out.println("<input type=\"text\" id=\"num1\" name=\"num1\"><br>");
        out.println("<label for=\"num2\">Число 2:</label>");
        out.println("<input type=\"text\" id=\"num2\" name=\"num2\"><br>");
        out.println("<input type=\"radio\" id=\"add\" name=\"action\" value=\"add\" checked>");
        out.println("<label for=\"add\">Додавання</label><br>");
        out.println("<input type=\"radio\" id=\"subtract\" name=\"action\" value=\"subtract\">");
        out.println("<label for=\"subtract\">Віднімання</label><br>");
        out.println("<input type=\"radio\" id=\"multiply\" name=\"action\" value=\"multiply\">");
        out.println("<label for=\"multiply\">Множення</label><br>");
        out.println("<input type=\"radio\" id=\"divide\" name=\"action\" value=\"divide\">");
        out.println("<label for=\"divide\">Ділення</label><br>");
        out.println("<input type=\"radio\" id=\"power\" name=\"action\" value=\"power\">");
        out.println("<label for=\"power\">Піднесення до степеня</label><br>");
        out.println(
                "<input type=\"radio\" id=\"percentage\" name=\"action\" value=\"percentage\">");
        out.println("<label for=\"percentage\">Підрахунок відсотків</label><br>");
        out.println("<input type=\"submit\" value=\"Обчислити\">");
        out.println("</form>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        double num1 = Double.parseDouble(request.getParameter("num1"));
        double num2 = Double.parseDouble(request.getParameter("num2"));
        String action = request.getParameter("action");

        double result = 0;
        String resultText = "";

        switch (action) {
            case "add":
                result = num1 + num2;
                resultText = "Результат додавання";
                break;
            case "subtract":
                result = num1 - num2;
                resultText = "Результат віднімання";
                break;
            case "multiply":
                result = num1 * num2;
                resultText = "Результат множення";
                break;
            case "divide":
                if (num2 != 0) {
                    result = num1 / num2;
                    resultText = "Результат ділення";
                } else {
                    resultText = "Помилка: ділення на нуль";
                }
                break;
            case "power":
                result = Math.pow(num1, num2);
                resultText = "Результат піднесення до степеня";
                break;
            case "percentage":
                result = (num1 * num2) / 100;
                resultText = "Результат підрахунку відсотків";
                break;
        }

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Калькулятор</title></head><body>");
        out.println("<h2>Введені числа:</h2>");
        out.println("<p>" + num1 + ", " + num2 + "</p>");
        out.println("<h3>" + resultText + ":</h3>");
        if (resultText.contains("Помилка")) {
            out.println("<p>" + resultText + "</p>");
        } else {
            out.println("<p>" + result + "</p>");
        }
        out.println("</body></html>");
    }
}
