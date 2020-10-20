package entity;

import util.GUIUtil;

/**
 * @ClassName Category
 * @Description 实体类，映射数据库中的 category (消费分类表)。
 * @Author NightGlower
 * @Date 2020/7/15 16:10
 * @Version 1.0
 */
public class Category {
    public int id;
    public String name;
    //消费记录数 recordNumber 这个属性并不会出现在数据库中,属于临时数据。
    public int recordNumber;

    /**
     * 在后续JComboBox中显示的时候，会调用此方法，用于显示分类名称。
     *
     * @return 返回一个分类名称。
     */
    public String toString() {
        return name;
    }

    public int getRecordNumber() {
        return recordNumber;
    }

    public void setRecordNumber(int recordNumber) {
        this.recordNumber = recordNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
