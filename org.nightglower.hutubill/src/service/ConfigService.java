package service;

import dao.ConfigDAO;
import entity.Config;

/**
 * @ClassName ConfigService
 * @Description 业务类，对数据进行预处理。监听器调用业务类，再调用DAO访问数据库。
 * @Author NightGlower
 * @Date 2020/7/23 17:09
 * @Version 1.0
 */
public class ConfigService {
    public static final String budget = "budget";
    public static final String mysqlPath = "mysqlPath";
    public static final String default_budget = "500";

    static ConfigDAO dao = new ConfigDAO();
    static {
        init();
    }


    /**
     * 初始化 ,设置信息里有两个数据，一个是预算，一个是Mysql路径。
     * 这两个信息，无论如何都应该是存在数据库中的。 所以会调用init把他们俩初始化。
     */
    public static void init(){
        init(budget,default_budget);
        init(mysqlPath,"");
    }

    public static void init(String key,String value){
        Config config = dao.getByKey(key);
        if (config == null){
            Config c = new Config();
            c.setKey(key);
            c.setValue(value);
            dao.add(c);
        }
    }

    public String get(String key){
        Config config = dao.getByKey(key);
        return config.getValue();
    }

    public void update(String key,String value){
        Config config = dao.getByKey(key);
        config.setValue(value);
        dao.update(config);
    }

    public int getIntBudget(){
        return Integer.parseInt(get(budget));
    }

}
