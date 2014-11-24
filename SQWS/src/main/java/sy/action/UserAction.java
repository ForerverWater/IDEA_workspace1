package sy.action;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;
import sy.model.Tuser;
import sy.service.IBaseService;
import sy.util.JsonObj;
import sy.util.MD5Util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by shui on 2014/11/15.
 */
@ParentPackage("basePackage")
@Action(value = "userAction")
public class UserAction extends  BaseAction{

    private static final Logger logger = Logger.getLogger(UserAction.class);

    private IBaseService<Tuser> baseService;

    public void test(){
        logger.info("进入action的test方法");
        /*ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext());
        IbaseService us = (IbaseService) ac.getBean("baseService");
        us.test();*/
        //baseService.test();
    }

    public void regUser(){
        String name = ServletActionContext.getRequest().getParameter("name");
        String pwd = ServletActionContext.getRequest().getParameter("pwd");
        Tuser tuser = new Tuser();
        tuser.setId(UUID.randomUUID().toString());
        tuser.setName(name);
        tuser.setPwd(MD5Util.md5(pwd));
        tuser.setCreatedatetime(new Date());

        //Map<String,Object> map = new HashMap<String,Object>();
        JsonObj j = new JsonObj();
        try {
            baseService.save(tuser);
            j.setSuccess(true);
            j.setMsg("注册成功");
        } catch (Exception e) {
            e.printStackTrace();
            j.setSuccess(false);
            j.setMsg("注册失败");
        }

        try {
            super.writeJson(j);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void login(){
        String login_name = ServletActionContext.getRequest().getParameter("login_name");
        String login_pwd = ServletActionContext.getRequest().getParameter("login_pwd");

        Map<String,Object> m = new HashMap<String, Object>();
        m.put("name",login_name);
        m.put("password",MD5Util.md5(login_pwd));
        JsonObj j = new JsonObj();
        try {
            Tuser t = baseService.getByHql("from Tuser u where u.name=:name and u.pwd=:password",m);
            if (t != null){
                j.setSuccess(true);
                j.setMsg("登录成功");
            }else{
                j.setSuccess(false);
                j.setMsg("登录失败。账号或密码错误!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            j.setSuccess(false);
            j.setMsg("登录失败");
        }

        try {
            super.writeJson(j);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public IBaseService getbaseService() {
        return baseService;
    }

    @Autowired
    public void setbaseService(IBaseService baseService) {
        this.baseService = baseService;
    }
}
