package com.codecool.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/"})
public class WebShopServlet extends HttpServlet {
    public static List<Item> avalibleItem = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        PrintWriter out = response.getWriter();
        init();



        String title = "Available Items";
        String addButton = "<form action=\"/webshop-post\" id=\"add-form\" method=\"get\">\n" +
                "    <button form=\"add-form\" name=\"add\" >Add</button>\n" +
                "</form>"
                ;
        String removeButton = "<button>Remove</button>";
        String ShopingCardBUtton = "<a href=\"/shopping_card\"><button >Check shopping cart</button>\n</a>" ;//"<button href>My shopping card</button>"


        StringBuilder itemTableBuilder = new StringBuilder();
        for (Item item: avalibleItem) {
            itemTableBuilder.append("<center>" + "Name: " + item.getName() + " Price: " + item.getPrice() + makeButton(item.getId()) + removeButton + "\n");
        }

        out.println(
                "<html>\n" +
                        "<head><title>" + title + "</title></head>\n" +
                        "<body>\n" +
                        "<h1 align = \"center\">" + title + "</h1>\n" +
                        itemTableBuilder +"\n"+
                        "<center>" + ShopingCardBUtton + "</center>" +
                        "</body></html>"
        );
    }

    public void init(){
        if(avalibleItem.isEmpty()){
            avalibleItem.add(new Item("MacBook Air", 232.2));
            avalibleItem.add(new Item("Asus", 23.2));
            avalibleItem.add(new Item("AirCraft", 231122.2));
        }
    }

    public String makeButton(int itemIndex){
        return String.format("<form action=\"/webshop-post\" id=\"add-form\" method=\"post\"> \n" +
                "                \"    <button form=\"add-form\" name=\"add\" value=\"%s\" >Add</button>  \n" +
                "                \"</form>\"", itemIndex);
    }
}
