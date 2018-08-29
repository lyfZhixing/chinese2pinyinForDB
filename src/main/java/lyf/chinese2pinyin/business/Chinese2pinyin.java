package lyf.chinese2pinyin.business;

import lyf.chinese2pinyin.util.Chinese2pinyinUtil;
import lyf.chinese2pinyin.util.JdbcTemplate;
import lyf.chinese2pinyin.util.JdbcUtil;
import lyf.chinese2pinyin.util.ReadPropertiesUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liyufeng
 * @Description:
 * @Date: Created in 上午11:20 18-8-28
 * @Modified By:
 */
public class Chinese2pinyin extends JdbcTemplate {

    private static String chineseColumn = ReadPropertiesUtil.getProperty("chineseColumn");
    private static String pinyinColumn = ReadPropertiesUtil.getProperty("pinyinColumn");
    private static String tableName = ReadPropertiesUtil.getProperty("tableName");

    public Chinese2pinyin(Connection conn) {
        super(conn);
    }

    public void doRepalce(){

        String sql,sql2;
        ResultSet rs = null;
        Map<String,String> map = new HashMap<String, String>();
        try{
            sql = "select `"+chineseColumn+"` from `"+tableName+"`";
            rs = executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString(chineseColumn);
                String pinyin = Chinese2pinyinUtil.convertHanzi2Pinyin(name,true);
                map.put(name,pinyin);
            }

            for (String key: map.keySet()) {
                sql2 = "UPDATE  `"+tableName+"` SET `"+pinyinColumn+"`='"+map.get(key)+
                        "' WHERE `"+chineseColumn+"`='"+key+"'";
                executeUpdate(sql2);
            }

        }catch (SQLException e) {
            System.out.println("SQL操作错误");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeAll(null, null, rs);
        }
    }

}
