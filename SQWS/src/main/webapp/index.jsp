<%--
  Created by IntelliJ IDEA.
  User: shui
  Date: 2014/11/16
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
    request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE HTML>
<html>
<head>
    <title>首页</title>
    <%--引入jQuery文件--%>
    <script type="text/javascript" src="jslib/jQuery/jquery-1.8.3.min.js"></script>
    <%--引入easyui主文件--%>
    <script type="text/javascript" src="jslib/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
    <%--引入国际化文件--%>
    <script type="text/javascript" src="jslib/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js"></script>
    <%--引入easyui样式文件--%>
    <link rel="stylesheet" type="text/css" href="jslib/jquery-easyui-1.4.1/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="jslib/jquery-easyui-1.4.1/themes/icon.css">
    <%--引入工具 函数js文件--%>
    <script type="text/javascript" src="js/util.js"></script>
    <%--引入验证函数js文件--%>
    <script type="text/javascript" src="js/vali.js"></script>
    <script type="text/javascript">
        $(function(){
            /*此段代码，用于控制验证触发事件*/
            $('input.easyui-validatebox').validatebox('disableValidation')
                    .focus(function () { $(this).validatebox('enableValidation'); })
                    .blur(function () { $(this).validatebox('validate') });
        });
            //var $index_regForm = $('#index_regForm');
            /*由于回车提交功能提交的是原生的form，所以要有下面的代码，
            用于把form转成easyui的form实现异步提交
            */
            /*
            $index_regForm.form({
                url: '<%=request.getContextPath()%>/userAction!regUser.action',
                success: function (r) {
                    var obj = $.parseJSON(r);
                    if (obj.success) {
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
            */
            /*
            * 单独这段代码提交为原生form提交，而原生form要求定义action属性，
            * 如果不转成easyui的form，默认就会提交到127.0.0.1:8080/SQWS,
            * 所以会出现页面刷新了一下，但没数据提交到后台，后台也没有返回信息
            * */
            /*
             $('#index_regForm input').bind('keyup',function(event){//增加回车提交功能
                if(event.keyCode == '13'){
                    $index_regForm.submit();
                }
            });
            */

            //var $regForm = $('#index_regForm');
            /*一、easyui方式*/
           /* $('#index_regForm').form('submit',{
                url:'<%=request.getContextPath()%>/userAction!regUser.action',
                success:function(r) {
                    var obj = $.parseJSON(r);
                    if(obj.success){
                        $('#index_regDialog').dialog('close');
                    }
                    $.messager.show({
                        title:'提示',
                        msg:obj.msg,
                        timeout:5000,
                        showType:'slide'
                    });
                }
            })
            */
            /*二、ajax方式*/
            /*if($regForm.form('validate')){//调用validate方法，令ajax提交也能验证
                $.ajax({
                    url:'<%=request.getContextPath()%>/userAction!regUser.action',
                    //data:{
                    //    name:$('#index_regForm input[name=name]').val(),
                    //    pwd:$('#index_regForm input[name=pwd]').val()
                    //},
                    data:$regForm.serialize(),
                    method:'post',
                    dataType:'json',
                    success:function(obj,textStatus,jqXHR){
                        if(obj.success){
                            $('#index_regDialog').dialog('close');
                        }
                        $.messager.show({
                            title:'提示',
                            msg:obj.msg,
                            timeout:5000,
                            showType:'slide'
                        });
                    }
                });
            }*/
    </script>
</head>
<body class="easyui-layout">
    <div data-options="region:'north',title:'north'" style="height: 100px"></div>
    <div data-options="region:'south',title:'south'" style="height: 60px"></div>
    <div data-options="region:'west'" style="width: 200px">
        <jsp:include page="menu/menu.jsp"  ></jsp:include>
    </div>
    <div data-options="region:'east',title:'east',split:true" style="width: 200px"></div>
    <div data-options="region:'center',title:'center'">
        <div class="easyui-tabs" id="index_centertabs" data-options="fit:true,border:false">
            <div title="首页">

            </div>
        </div>
    </div>
    <jsp:include page="user/login.jsp"  ></jsp:include>
    <jsp:include page="user/reg.jsp"  ></jsp:include>


</body>
</html>
