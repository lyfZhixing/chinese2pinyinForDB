# chinese2pinyinForDB
数据库字段中文转拼音   
---

当数据中需要一个中文字段的拼音时，手动添加太麻烦还容易出错，数据库自带的拼音函数有时不太好使（可能是汉字库比较老），有的字并不能识别正确。本项目使用pinyin4j工具包编写java脚本，自动更新拼音字段。    
# 使用效果如下   
1. 数据库表原状    
![image](https://github.com/lyfZhixing/chinese2pinyinForDB/blob/master/src/main/doc/pic1.png?raw=true)      
2. 数据库配置   
![image](https://github.com/lyfZhixing/chinese2pinyinForDB/blob/master/src/main/doc/pic4.png?raw=true)    
3. 脚本启动入口    
![image](https://github.com/lyfZhixing/chinese2pinyinForDB/blob/master/src/main/doc/pic2.png?raw=true)    
4. 运行成功   
![image](https://github.com/lyfZhixing/chinese2pinyinForDB/blob/master/src/main/doc/pic3.png?raw=true)


---
