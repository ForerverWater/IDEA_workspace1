<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
    request.setCharacterEncoding("UTF-8");
%>
<script type="text/javascript">
    $(function(){
        var $user_login_form = $('#user_login_form');
        loginUser = function(){
            $user_login_form.form('submit',{
                url: '<%=request.getContextPath()%>/userAction!login.action',
                success: function (r) {
                    var obj = $.parseJSON(r);
                    if (obj.success) {
                        $('#user_login_div').dialog('close');
                    }
                    $.messager.show({
                        title: '提示',
                        msg: obj.msg,
                        timeout: 5000,
                        showType: 'slide'
                    });
                }
            });
        };
        $('#user_login_form input').bind('keyup',function(event){//增加回车提交功能
            if(event.keyCode == '13'){
                loginUser();
            }
        });
    });
</script>

<div class="easyui-dialog" id="user_login_div"
     data-options="title:'登录',modal:true,closable:false,
        buttons:[{
            text:'注册',
            iconCls:'icon-edit',
            handler:function(){
                $('#user_reg_regDialog').window('open');
            }
        },{
            text:'登录',
            iconCls:'icon-help',
            handler:function(){
                //$('#user_login_form').submit();
                loginUser();
            }
        }]">
        <form id="user_login_form" method="post">
            <table>
                <tr>
                    <th>用户名:</th><td><input type="text" id = 'login_name' name="login_name" class="easyui-validatebox" data-options="required:true,missingMessage:'登录名必填'"/></td>
                </tr>
                <tr>
                    <th>密码:</th><td><input type="password" id ="login_pwd" name="login_pwd" class="easyui-validatebox" data-options="required:true,missingMessage:'密码必填'"/></td>
                </tr>
            </table>
        </form>
</div>
