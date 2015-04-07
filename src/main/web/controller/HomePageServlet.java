package controller;

import entity.Account;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomePageServlet extends HttpServlet {



    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {

            //home work -> MySQL
            
            //name - >> Account
            String name = request.getParameter("username");
            String password = request.getParameter("password");
            Account accountWeb = new Account(name, password);

           //  List<Account>  accountDao = ObjectDAO.methodList
            //accountDao.conta(accountWeb); ->> true
            //if(true){  request.getRequestDispatcher("/JSP/homePage.jsp").forward(request, response); } else  request.getRequestDispatcher("/JSP/homePageError.jsp").forward(request, response);

            request.getRequestDispatcher("/JSP/homePage.jsp").forward(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }


}
