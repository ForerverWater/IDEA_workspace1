package sy.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sy.model.Tuser;
import sy.service.IUserService;

import java.util.Date;
import java.util.UUID;

/**
 * Created by shui on 2014/11/14.
 */
public class TestSpring {

       @Test
       public void test(){
           ApplicationContext ac  = new ClassPathXmlApplicationContext(new String[]{"classpath:spring.xml","classpath:spring-hibernate.xml"});
           IUserService us = (IUserService) ac.getBean("userService");
           Tuser t  = new Tuser();
           t.setId(UUID.randomUUID().toString());
           t.setName("赵国富");
           t.setPwd("123456");
           t.setSex("M");
           t.setAge(27);
           t.setCreatedatetime(new Date());
           us.save(t);
       }
}
