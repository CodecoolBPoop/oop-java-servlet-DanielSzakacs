package com.codecool.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "webShopPost", urlPatterns = {"/webshop-post"})
public class WebShopPost extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{

        String addItem = request.getParameter("add");
        String removeItem = request.getParameter("remove");

        if(addItem != null){
            int indexOfItem = Integer.parseInt(addItem);
            ItemStore.add(WebShopServlet.avalibleItem.get(indexOfItem));
        }else if(removeItem != null){
            int indexOfItem = Integer.parseInt(removeItem);
            ItemStore.remove(WebShopServlet.avalibleItem.get(indexOfItem));
        }
        response.sendRedirect("/");
    }
}
