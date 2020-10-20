package entity;

/**
 * @ClassName Config
 * @Description 实体类,映射数据库中的 config (配置信息表)。
 * @Author NightGlower
 * @Date 2020/7/15 16:05
 * @Version 1.0
 */
public class Config {
    public int id;
    public String key;
    public String value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
