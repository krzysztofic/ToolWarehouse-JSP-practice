package pl.vermintyn.controller;


import pl.vermintyn.service.ToolService;
import pl.vermintyn.service.ToolServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {""}, name="ToolServlet")
public class ToolController extends HttpServlet {

    private ToolService toolService = ToolServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("tools", toolService.getAll());
        getServletContext().getRequestDispatcher("/tools.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long id = Long.parseLong(req.getParameter("id"));
        boolean isAvailable = Boolean.parseBoolean(req.getParameter("isAvailable"));

        toolService.setAvailability(id, isAvailable);

        resp.sendRedirect(req.getContextPath()+ "/");

    }
}
