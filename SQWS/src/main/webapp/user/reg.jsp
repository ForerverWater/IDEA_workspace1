<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
    request.setCharacterEncoding("UTF-8");
%>
<script type="text/javascript">
    $(function(){
        var $index_regForm = $('#index_regForm');
        /*由于回车提交功能提交的是原生的form，所以要有下面的代码，
         用于把form转成easyui的form实现异步提交
         */



        $index_regForm.form({
            url: '<%=request.getContextPath()%>/userAction!regUser.action',
            success: function (r) {
                var obj = $.parseJSON(r);
                if (obj.success) {
                    $('#index_regForm input').val("");
                    $('#user_reg_regDialog').dialog('close');
                }
                $.messager.show({
                    title: '提示',
                    msg: obj.msg,
                    timeout: 5000,
                    showType: 'slide'
                });
            }
        });
        /*
         * 单独这段代码提交为原生form提交，而原生form要求定义action属性，
         * 如果不转成easyui的form，默认就会提交到127.0.0.1:8080/SQWS,
         * 所以会出现页面刷新了一下，但没数据提交到后台，后台也没有返回信息
         * */
        $('#index_regForm input').bind('keyup',function(event){//增加回车提交功能
            if(event.keyCode == '13'){
                $index_regForm.submit();
            }
        });
    });
</script>
<div class="easyui-dialog" id="user_reg_regDialog" style="width: 300px"
     data-options="title:'注册',modal:true,closed: true,
			buttons:[{
				text:'注册',
				iconCls:'icon-edit',
				handler:function(){
				   $('#index_regForm').submit();
				}
			}]">
    <form id="index_regForm" method="post">
        <table>
            <tr>
                <th>用户名:</th><td><input type="text" name="name" class="easyui-validatebox" data-options="required:true"/></td>
            </tr>
            <tr>
                <th>密码:</th><td><input type="password" id ="pwd" name="pwd" class="easyui-validatebox" data-options="required:true"/></td>
            </tr>
            <tr>
                <th>重复密码:</th><td><input type="password"  class="easyui-validatebox"
                                         data-options="
                            required:true,
                            validType:{equals:['#pwd'],minLen:[5]}" /></td>
            </tr>
        </table>
    </form>
</div>