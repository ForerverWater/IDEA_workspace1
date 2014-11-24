package sy.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sy.dao.IBaseDao;
import sy.model.Tmenu;
import sy.pageModel.Menu;
import sy.service.IMenuService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shui on 2014/11/20.
 */
@Service(value="menuService")
public class MenuServiceImpl implements IMenuService{

    /*异步树获取节点方法
    * 一次加载树请参看视频12最后十多分钟的讲解
    * */
    @Override
    public List<Menu> getTreeNode(String id) {
        String hql = "";
        Map<String,Object> map = new HashMap<String,Object>();
        if("".equals(id) || id ==null){
            hql = "from Tmenu m where m.tmenu is null";
        }else{
            hql = "from Tmenu m where m.tmenu.id = :id";
            map.put("id",id);
        }
        List<Menu> ml = new ArrayList<Menu>();
        List<Tmenu> list = baseDao.find(hql,map);
        for (Tmenu m:list){
            Menu m2 = new Menu();
            BeanUtils.copyProperties(m,m2);
            m2.setText(m.getMenuName());
            if(m.getTmenus() !=null && !m.getTmenus().isEmpty()){
                 /*
                * 设置tree的状态，共有三种状态
                * 1、节点open，无子节点，图标为文件
                * 2、节点open，有子节点，图标为文件夹
                * 3、节点closed，不论有子节点，图标为文件夹
                * */
                m2.setState("closed");
            }else{
                m2.setState("open");
            }


            ml.add(m2);
        }
        return ml;
    }

    public IBaseDao<Tmenu> getBaseDao() {
        return baseDao;
    }
    @Autowired
    public void setBaseDao(IBaseDao<Tmenu> baseDao) {
        this.baseDao = baseDao;
    }

    private IBaseDao<Tmenu> baseDao;

}
