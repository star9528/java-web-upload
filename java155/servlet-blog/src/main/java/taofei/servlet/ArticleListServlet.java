package taofei.servlet;

import taofei.dao.ArticleDAO;
import taofei.model.Article;
import taofei.model.Response;
import taofei.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

//@WebServlet("/articleList")
public class ArticleListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");//请求体编码
        resp.setCharacterEncoding("UTF-8");//响应体设置编码
        resp.setContentType("application/json;charset=UTF-8");//浏览器接收数据解析方式

        String id = req.getParameter("id");//获取前端数据,用户id
        Response response = new Response();
        try {
            //jdbc操作:查询文章列表(根据用户id查询关联的所有文章)
            List<Article> articles = ArticleDAO.query(Integer.parseInt(id));
            response.setSuccess(true);
            response.setData(articles);
        } catch (Exception e) {//出现异常,返回success = false.并设置错误信息,异常堆栈
            response.setMessage(e.getMessage());
            StringWriter sw = new StringWriter();
            PrintWriter writer = new PrintWriter(sw);
            e.printStackTrace(writer);
            response.setStackTrace(sw.toString());
        }
        //响应数据,json数据
        PrintWriter pw = resp.getWriter();
        pw.println(JSONUtil.serialize(response));
        pw.flush();
    }
}
