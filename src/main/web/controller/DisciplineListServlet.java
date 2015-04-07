package controller;

import dao.DisciplineDao;
import dao.impl.DisciplineDaoImpl;
import entity.Discipline;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class DisciplineListServlet extends HttpServlet {
    private DisciplineDao disciplineDao = new DisciplineDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Discipline> list = disciplineDao.getDisciplines();
            req.setAttribute("list", list);
            req.getRequestDispatcher("/JSP/disciplineLict.jsp").forward(req, resp);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
