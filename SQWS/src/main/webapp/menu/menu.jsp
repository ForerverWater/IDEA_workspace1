
<%--
  Created by IntelliJ IDEA.
  User: shui
  Date: 2014/11/20
  Time: 23:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
    request.setCharacterEncoding("UTF-8");
%>
<script type="text/javascript">
    addTabs = function(opt) {
        var $index_centertabs = $("#index_centertabs");
        if($index_centertabs.tabs('exists',opt.title)){
            $index_centertabs.tabs('select',opt.title);
        }else{
            $index_centertabs.tabs('add',opt);
        }
    }
</script>
<div class="easyui-panel" data-options="title:'菜单树',border:false,fit:true">
    <div id="aa" class="easyui-accordion" data-options="fit:true,border:false" style="width:300px;height:200px;">
        <div title="系统管理" data-options="iconCls:'icon-save'" style="overflow:auto">
            <ul class="easyui-tree" data-options="
                    url:'<%=request.getContextPath()%>/menuAction!getTreeNode.action',
                    lines:true,
                    onClick:function(node){
                        console.info($(this).tree('getChildren'));
                        if($(this).tree('getChildren') != null){
                            addTabs({title:node.text});
                        }
                    }
                    ">

            </ul>
        </div>
    </div>
</div>
