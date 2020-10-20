package service;


import dao.RecordDAO;
import entity.Category;
import entity.Record;

import java.util.Date;

/**
 * @ClassName RecordService
 * @Description 消费记录业务类
 * @Author NightGlower
 * @Date 2020/7/23 21:57
 * @Version 1.0
 */
public class RecordService {
    RecordDAO recordDAO = new RecordDAO();
    public void add(int spend, Category c, String comment, Date date){
        Record r = new Record();
        r.spend = spend;
        r.cid = c.id;
        r.comment = comment;
        r.date = date;
        recordDAO.add(r);
    }
}
