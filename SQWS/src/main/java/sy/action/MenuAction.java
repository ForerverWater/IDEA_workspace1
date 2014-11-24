package sy.action;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;
import sy.service.IMenuService;

/**
 * Created by shui on 2014/11/20.
 */
@Action(value = "menuAction")
public class MenuAction  extends BaseAction{

    private IMenuService menuSerive;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;

    public IMenuService getMenuSerive() {
        return menuSerive;
    }

    @Autowired
    public void setMenuSerive(IMenuService menuSerive) {
        this.menuSerive = menuSerive;
    }

    public void getTreeNode(){
        super.writeJson(menuSerive.getTreeNode(this.getId()));
    }
}
