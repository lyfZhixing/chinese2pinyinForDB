package lyf.chinese2pinyin.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author: liyufeng
 * @Description:
 * @Date: Created in 上午11:41 18-8-28
 * @Modified By:
 */
public class JdbcUtil {

    private static String driver = ReadPropertiesUtil.getProperty("driverClass");
    private static String url = ReadPropertiesUtil.getProperty("url");
    private static String username = ReadPropertiesUtil.getProperty("username");
    private static String password = ReadPropertiesUtil.getProperty("password");

    static{
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     * @return
     */
    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭连接
     * @param con
     * @param stmt
     * @param rs
     */
    public static void closeAll(Connection con, Statement stmt, ResultSet rs){

        try {
            if(con != null && !con.isClosed()){
                con.close();
            }
            if(stmt != null && !stmt.isClosed()){
                stmt.close();
            }
            if(rs != null && !rs.isClosed()){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
