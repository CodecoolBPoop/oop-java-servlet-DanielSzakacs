package com.codecool.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/shopping_card"})
public class ShoppingCardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        PrintWriter out = response.getWriter();

        StringBuffer buffer = new StringBuffer();
        for (Item item: ItemStore.getListOfItems()) {
            buffer.append("<center> Name" + item.getName() + "Price" + item.getPrice() + "</center>");
        }

        String title = "My shopping card";
        String backButton = "<a href=\"/\"><button>Back to Shopping</button></a>";

        out.println(
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body>\n" +
                "<h1 align = \"center\">" + title + "</h1>\n" +
                buffer +"\n"+
                "<center>" + backButton + "</center>" +
                "</body></html>"
        );
    }
}
