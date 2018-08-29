package lyf.chinese2pinyin.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: liyufeng
 * @Description: jdbc操作模板
 * @Date: Created in 上午11:58 18-8-28
 * @Modified By:
 */
public class JdbcTemplate {

    private Connection conn;

    public JdbcTemplate(Connection conn) {
        super();
        this.conn = conn;
    }

    /**
     * Insert,update,delete template
     * @param sql
     * @param params
     * @return
     * @throws SQLException
     */
    protected int executeUpdate(String sql , Object...params) throws SQLException {
        int result = 0;
        PreparedStatement pstmt = null;
        try{
            pstmt = conn.prepareStatement(sql);
            if(params != null){
                for(int i = 0; i < params.length; i++){
                    pstmt.setObject(i+1, params[i]);
                }
            }
            result = pstmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            JdbcUtil.closeAll(null, pstmt, null);
        }
        return result;
    }

    /**
     * Query template
     * @param sql
     * @param params
     * @return
     */
    public ResultSet executeQuery(String sql, Object...params){

        ResultSet rs = null;
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(sql);
            if(params != null){
                for(int i = 0; i < params.length; i++){
                    pstmt.setObject(i+1, params[i]);
                }
            }
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

}
