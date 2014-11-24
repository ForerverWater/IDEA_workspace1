package sy.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by shui on 2014/11/19.
 */
public class TBbsText implements java.io.Serializable{
    @Id
    @Column(name = "TEXT_ID", unique = true, nullable = false, length = 36)
    public String getText_id() {
        return text_id;
    }

    public void setText_id(String text_id) {
        this.text_id = text_id;
    }

    public String getText_type() {
        return text_type;
    }

    public void setText_type(String text_type) {
        this.text_type = text_type;
    }

    public String getText_context() {
        return text_context;
    }

    public void setText_context(String text_context) {
        this.text_context = text_context;
    }

    public Date getText_createtime() {
        return text_createtime;
    }

    public void setText_createtime(Date text_createtime) {
        this.text_createtime = text_createtime;
    }

    public Integer getText_points() {
        return text_points;
    }

    public void setText_points(Integer text_points) {
        this.text_points = text_points;
    }

    public String getText_title() {
        return text_title;
    }

    public void setText_title(String text_title) {
        this.text_title = text_title;
    }

    private String text_id;
    private String text_title;
    private String text_type;
    private String text_context;
    private Date text_createtime;
    private Integer text_points;
}
