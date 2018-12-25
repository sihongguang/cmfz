<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>持名法州主页</title>
    <link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
        <link rel="stylesheet" type="text/css" href="../themes/IconExtension.css">

        <script type="text/javascript" src="../js/jquery.min.js"></script>
    <script type="text/javascript" src="../js/jquery.easyui.min.js"></script>

    <script type="text/javascript" src="../js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="../js/jquery.edatagrid.js"></script>

    <script type="text/javascript" src="../js/datagrid-detailview.js"></script>
    <script type="text/javascript" src="../js/form.validator.rules.js"></script>
    <script type="text/javascript">
        $(function(){//判断登入
            $.post("${pageContext.request.contextPath}/menu/verifyLog",function(result){
                if(result.verify){
                    menushow();
                }else{
                    window.location.replace("${pageContext.request.contextPath}/login.jsp");
                }
            },"JSON");
        });

        function menushow(){//菜单
            $.get("${pageContext.request.contextPath}/menu/queryAllBudd",function(result){
                $.each(result,function(i,menu){
                    var content="<div style='text-align: center'>"
                    $.each(menu.menuList,function(j,child){
                        var json=JSON.stringify(child)
                        content+= "<div style='margin-top:5px;'>" +
                            "<a onClick='addTabs("+json+")' class='easyui-linkbutton' data-options=\"plain:true,iconCls:'"+child.imghead+"'\" " +
                            "style='width:90%;border:1px #95B8E7 solid;'>"+child.menuname+"</a></div><br/>";
                    });
                    content +="</div>";
                    $("#aa").accordion("add",{
                        title:menu.menuname,
                        iconCls:menu.imghead,
                        content:content,
                    });
                });
            },"JSON");}

        function addTabs(child){
            console.log(child);
            if($("#tabstt").tabs('exists',child.menuname)){
                $("#tabstt").tabs('select',child.menuname);//存在 再次点击则是选中点击的那个
                return ;
            }
            $("#tabstt").tabs('add',{
                title:child.menuname,
                closable:true,
                cache:false,
                iconCls:child.imghead,
                href:'${pageContext.request.contextPath}'+child.href,
            });
        }

        function adminUpdate(adminPwdAndEnd){
            $("#adminDialog").dialog({//修改框
                    title:adminPwdAndEnd,
                    width:450,
                    height:600,
                    href:"${pageContext.request.contextPath}/admin/admin.jsp",//引入界面
                    buttons:[//添加工具栏
                        {
                            text:'保存',
                            iconCls:'icon-database_save',
                            handler:saveUpdate,
                        }
                    ,
                        {
                            text:'关闭',
                            iconCls:'icon-cross',
                            handler:closeDialog,
                        }],
            });
        }
        function saveUpdate(){
                $("#adminff").form('submit',{
                    dirty:true,
                    url:'${pageContext.request.contextPath}/admin/updateAdmin',
                    success:function(result){//得到返回对象
                        resultJS = $.parseJSON(result);
                        if(resultJS.verify){//提示确认框
                            $.messager.confirm('确认对话框', '您确定修改吗?确定将重新登入',function(ver){
                                if(ver){
                                    $.messager.progress({
                                        title:'正在更新中...',
                                        msg:'正在更新请等待...',
                                        text:'正在更新请等待....'
                                    });
                                        constraint();//注销session
                                        setTimeout(function(){//演示展示
                                        window.location.replace("${pageContext.request.contextPath}/login.jsp");
                                        },1500);
                                }else{//取消修改
                                    $.messager.show({
                                        title:'我的提示',
                                        msg:'修改取消!消息将在5秒后关闭。对话框也将关闭',
                                        timeout:5000,
                                        showType:'slide'
                                    });
                                    closeDialog();
                                }
                            });
                        }else{//修改时读取数据失败
                            $.messager.show({
                                title:'我的提示',
                                msg:'修改'+resultJS.content+'!消息将在5秒后关闭。',
                                timeout:5000,
                                showType:'slide'
                            });
                            closeDialog();
                        }
                    }
                });
        }
        function constraint(){
        //销毁session
            $.post('${pageContext.request.contextPath}/admin/constraintLogin',"JSON");
        }

        function exit(){//注销系统
            $.messager.confirm('确认关闭?', '您确定关闭吗?确定将退出当前页面',function(ver){//确认提示框
                if(ver){//判断是否点击确定
                    $.messager.progress({
                        title:'正在关闭中...',
                        msg:'正在关闭请等待...',
                        text:'正在关闭请等待....'
                    });
                    constraint();//关闭
                    setTimeout(function(){//延时跳转
                        window.location.replace("${pageContext.request.contextPath}/login.jsp");
                    },1500);
                }
            });
        };
        function closeDialog(){//关闭修改框
            $("#adminDialog").dialog("close")
        }
    </script>
</head>
<body class="easyui-layout">   
    <div data-options="region:'north',split:true" style="height:60px;background-color:  #5c150e">
    	<div style="font-size: 24px;color: white;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
    	<div  style="font-size: 16px;color: white;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:${sessionScope.admin.adminname} <br/>&nbsp;
            <a href="#" onclick="adminUpdate('修改密码')" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>
            &nbsp;&nbsp;<a href="#" onclick="exit('退出系统')" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a>
        </div>
    </div>   
    <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    	<div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 htf@zparkhr.com.cn</div>
    </div>   
       
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    	<div id="aa" class="easyui-accordion" data-options="fit:true">
		</div>
    </div>   
    <div data-options="region:'center'">
    	<div id="tabstt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">
            <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
		</div>

    </div>

    <div id="adminDialog" date-options="closed:true"></div>

</body>
</html>