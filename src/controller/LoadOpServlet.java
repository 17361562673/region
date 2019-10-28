/**
 * Company: ALIBABA
 * Author： ZHOUZHIQIANG
 * FileName:LoadOpServlet
 * Time:2019/10/1714:08
 * Description:
 */
package controller;

import model.Region;
import net.sf.json.JSONArray;
import service.ReService;
import service.serviceImple.ReServiceImple;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class LoadOpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pid = req.getParameter("pid");
        ReService service=new ReServiceImple();
        List<Region> rList = service.getRListByPid(new Integer(pid));
        JSONArray jsonArray = JSONArray.fromObject(rList);
        String result = jsonArray.toString();
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().write(result);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}