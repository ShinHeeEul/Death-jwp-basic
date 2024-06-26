package next.web;


import core.db.DataBase;
import next.model.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebServlet("/user/login")
public class LoginUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");

        User user = DataBase.findUserById(userId);

        if(user == null) {
            resp.sendRedirect("/user/login_failed.jsp");
            return;
        }
        if(!user.getPassword().equals(password)) {
            resp.sendRedirect("/user/login_failed.jsp");
            return;
        }

        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("user", user);
        resp.sendRedirect("/");
    }
}
