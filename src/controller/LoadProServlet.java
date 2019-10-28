/**
 * Company: ALIBABA
 * Author： ZHOUZHIQIANG
 * FileName:LoadProServlet
 * Time:2019/10/1712:02
 * Description:
 */
package controller;

import model.Region;
import service.ReService;
import service.serviceImple.ReServiceImple;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class LoadProServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ReService service=new ReServiceImple();
        List<Region> pList = service.getRListByPid(-1);
        req.setAttribute("pList",pList);
        req.getRequestDispatcher("/WEB-INF/region.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
