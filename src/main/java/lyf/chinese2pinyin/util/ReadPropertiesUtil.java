package lyf.chinese2pinyin.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author: liyufeng
 * @Description:
 * @Date: Created in 上午11:42 18-8-28
 * @Modified By:
 */
public class ReadPropertiesUtil {

    private static Properties pros = null;

    static{
        InputStream is = ReadPropertiesUtil.class.getClassLoader().getResourceAsStream("db.properties");
        if(is == null){
            try {
                throw new Exception("文件读取失败");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        pros = new Properties();
        try {
            pros.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String getProperty(String key){
        return pros.getProperty(key);
    }
}
