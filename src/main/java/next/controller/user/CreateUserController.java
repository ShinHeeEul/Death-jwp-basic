package next.controller.user;

import core.db.DataBase;
import next.controller.Controller;
import next.model.User;
import next.view.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CreateUserController implements Controller {

    @Override
    public ModelAndView execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        User user = new User(httpServletRequest.getParameter("userId"), httpServletRequest.getParameter("password"), httpServletRequest.getParameter("name"),
                httpServletRequest.getParameter("email"));

        DataBase.addUser(user);

        return jspView("redirect:/");
    }
}
