package taofei.dao;

import taofei.model.Article;
import taofei.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleDAO {

    public static List<Article> query(int id) {
        List<Article> articles = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //获取数据库连接
        try {
            //1.获取数据库连接
            c = DBUtil.getConnection();
            //注意事项:
            // sql需要空格的地方一定要保留,
            // 占位符设置值都是从1开始,结果表头字段和获取字段名一致,类型也要一致
            String sql = "select a.id, a.title, a.content, a.user_id, a.create_time " +
                    "from article a join user u on a.user_id = u.id = ?";
            //2.创建操作命令对象
            ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            //3.执行sql
            rs = ps.executeQuery();
            //4.处理结果集
            while (rs.next()) {
                Article a = new Article();
                a.setId(rs.getInt("id"));
                a.setTitle(rs.getString("title"));
                a.setContent(rs.getString("content"));
                a.setUserId(id);
                a.setCreateTime(new Date(rs.getTimestamp("create_time").getTime()));
                articles.add(a);
            }
        } catch (Exception e) {
            throw new RuntimeException("查询文章列表出错,一般是都是自己sql写错了", e);
        } finally {//5.释放资源
            DBUtil.close(c, ps, rs);
        }

        return articles;
    }
}
