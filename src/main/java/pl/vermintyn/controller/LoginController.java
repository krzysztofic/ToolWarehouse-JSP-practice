package pl.vermintyn.controller;

import pl.vermintyn.service.UserService;
import pl.vermintyn.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    private UserService userService = UserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("username") == null) {
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");

        switch (action) {
            case "login":
                loginUser(req, resp);
                break;
            case "logout":
            default:
                logoutUser(req, resp);
        }
    }

    private void logoutUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.getSession().invalidate();

        getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    private void loginUser(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (userService.isUserValid(username, password)) {
            req.getSession().setAttribute("username", username);
            resp.sendRedirect(req.getContextPath() + "/");
        } else {
            req.setAttribute("hasError", true);
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
