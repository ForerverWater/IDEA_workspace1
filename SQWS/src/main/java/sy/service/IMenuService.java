package sy.service;

import sy.pageModel.Menu;

import java.util.List;

/**
 * Created by shui on 2014/11/20.
 */
public interface IMenuService {

    //public List<Tmenu> getTree(String id);

    public List<Menu> getTreeNode(String id);
}
