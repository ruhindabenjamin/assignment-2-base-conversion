package rw.ac.auca.controller.baseconversion;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.*;


@WebServlet("/ConverterServlet")
public class ConverterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the decimal input and the desired conversion type from the request
        String decimalStr = request.getParameter("decimal");
        String convertTo = request.getParameter("convertTo");

        // Perform the conversion
        String result = "";
        if (decimalStr != null && !decimalStr.isEmpty()) {
            try {
                int decimal = Integer.parseInt(decimalStr);
                if ("hex".equals(convertTo)) {
                    result = Integer.toHexString(decimal);
                } else if ("octal".equals(convertTo)) {
                    result = Integer.toOctalString(decimal);
                } else if ("binary".equals(convertTo)) {
                    result = Integer.toBinaryString(decimal);
                }
            } catch (NumberFormatException e) {
                result = "Invalid input";
            }
        } else {
            result = "Please enter a valid decimal number.";
        }

        // Send the result back as plain text
        response.setContentType("text/plain");
        response.getWriter().write(result);
    }
}