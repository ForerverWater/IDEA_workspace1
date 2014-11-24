package sy.action;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.ParentPackage;

import java.io.IOException;

/**
 * Created by shui on 2014/11/19.
 */
@ParentPackage("basePackage")
public class BaseAction {
    private static final Logger logger = Logger.getLogger(BaseAction.class);

    public void writeJson(Object obj) {
        try {
            String json = JSON.toJSONStringWithDateFormat(obj, "yyyy-MM-dd HH:mm:ss");
            ServletActionContext.getResponse().setContentType("text/html,charset=utf-8");
            ServletActionContext.getResponse().setCharacterEncoding("utf-8");
            ServletActionContext.getResponse().getWriter().write(json);
            ServletActionContext.getResponse().getWriter().flush();
            ServletActionContext.getResponse().getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
