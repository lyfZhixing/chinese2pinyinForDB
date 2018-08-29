package lyf.chinese2pinyin;

import lyf.chinese2pinyin.business.Chinese2pinyin;
import lyf.chinese2pinyin.util.JdbcUtil;

/**
 * @Author: liyufeng
 * @Description: 程序入口
 * @Date: Created in 下午12:08 18-8-28
 * @Modified By:
 */
public class Chinese2pinyinApplication {
    public static void main(String[] args) {
        Chinese2pinyin chinese2pinyin = new Chinese2pinyin(JdbcUtil.getConnection());
        chinese2pinyin.doRepalce();
        System.out.println("==========OK==========");
    }
}
