package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/textanalysis")
public class TextAnalysisServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Аналіз тексту</title></head><body>");
        out.println("<form action=\"textanalysis\" method=\"post\">");
        out.println("<label for=\"text\">Введіть текст:</label><br>");
        out.println("<textarea id=\"text\" name=\"text\" rows=\"4\" cols=\"50\"></textarea><br>");
        out.println("<input type=\"submit\" value=\"Аналізувати\">");
        out.println("</form>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String text = request.getParameter("text");
        String vowels = "aeiouAEIOU";
        String consonants = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";
        String punctuation = ".,;:!?";

        int vowelCount = 0;
        int consonantCount = 0;
        int punctuationCount = 0;

        StringBuilder vowelList = new StringBuilder();
        StringBuilder consonantList = new StringBuilder();
        StringBuilder punctuationList = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                vowelCount++;
                vowelList.append(c).append(" ");
            } else if (consonants.indexOf(c) != -1) {
                consonantCount++;
                consonantList.append(c).append(" ");
            } else if (punctuation.indexOf(c) != -1) {
                punctuationCount++;
                punctuationList.append(c).append(" ");
            }
        }

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Аналіз тексту</title></head><body>");
        out.println("<h2>Введений текст:</h2>");
        out.println("<p>" + text + "</p>");
        out.println("<h3>Кількість голосних:</h3>");
        out.println("<p>" + vowelCount + "</p>");
        out.println("<p>Голосні: " + vowelList + "</p>");
        out.println("<h3>Кількість приголосних:</h3>");
        out.println("<p>" + consonantCount + "</p>");
        out.println("<p>Приголосні: " + consonantList + "</p>");
        out.println("<h3>Кількість розділових знаків:</h3>");
        out.println("<p>" + punctuationCount + "</p>");
        out.println("<p>Розділові знаки: " + punctuationList + "</p>");
        out.println("</body></html>");
    }
}
