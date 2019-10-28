/**
 * Company: ALIBABA
 * Author： ZHOUZHIQIANG
 * FileName:ReDaoImple
 * Time:2019/10/1711:37
 * Description:
 */
package dao.daoImple;

import dao.ReDao;
import model.Region;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ReDaoImple implements ReDao {
    @Override
    public List<Region> getRListByPid(Integer pid) {
        InputStream resource = ReDaoImple.class.getClassLoader().getResourceAsStream("db.properties");
        Properties pro = new Properties();
        Connection conn=null;
        PreparedStatement psmt=null;
        ResultSet rs=null;
        List<Region> rList=new ArrayList<>();
        try {
            String sql="SELECT *FROM region WHERE pid=?";
            pro.load(resource);
            BasicDataSource dataSource = BasicDataSourceFactory.createDataSource(pro);
            conn=dataSource.getConnection();
            psmt=conn.prepareStatement(sql);
            psmt.setInt(1,pid);
            rs=psmt.executeQuery();
            while (rs.next()) {
                int re_id = rs.getInt("re_id");
                String re_name = rs.getString("re_name");
                int PId = rs.getInt("pid");
                int re_level = rs.getInt("re_level");
                Region re = new Region();
                re.setRe_id(re_id);
                re.setRe_name(re_name);
                re.setPid(PId);
                re.setRe_level(re_level);
                rList.add(re);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (rs != null) {
                try {
                    rs.close();
                    if (psmt != null) {
                        psmt.close();
                        if (conn != null) {
                            conn.close();
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return rList;
    }
}
