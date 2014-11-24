package sy.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by shui on 2014/11/19.
 */
@Entity
@Table(name = "T_menu")
public class Tmenu implements java.io.Serializable{

    @Id
    @Column(name = "ID",  nullable = false, length = 4)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PID")
    public Tmenu getTmenu() {
        return tmenu;
    }

    public void setTmenu(Tmenu tmenu) {
        this.tmenu = tmenu;
    }

    @Column(name = "MENU_NAME", length = 20)
    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @Column(name = "ICONCLS", length = 50)
    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    @Column(name = "URL", length = 200)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tmenu")
    public Set<Tmenu> getTmenus() {
        return tmenus;
    }

    public void setTmenus(Set<Tmenu> tmenus) {
        this.tmenus = tmenus;
    }

    private String id;
    private Tmenu tmenu;
    private String menuName;
    private String iconCls;
    private String url;
    private Set<Tmenu> tmenus = new HashSet<Tmenu>(0);

    public Tmenu(String id, Tmenu tmenu, String menuName, String iconCls, String url, Set<Tmenu> tmenus) {
        this.id = id;
        this.tmenu = tmenu;
        this.menuName = menuName;
        this.iconCls = iconCls;
        this.url = url;
        this.tmenus = tmenus;
    }

    public Tmenu(String id,String menuName){
            this.id = id;
            this.menuName = menuName;
    }

    public Tmenu() {
    }
}
