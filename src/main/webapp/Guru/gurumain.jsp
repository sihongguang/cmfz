<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>

<script>
    $('#gurutt').edatagrid({
        autoSave:true,
        fit:true,
        remoteSort:false,
        singleSelect:true,
        nowrap:false,
        fitColumns:true,
        url:'${pageContext.request.contextPath}/guru/queryAllGuru',
        updateUrl:'${pageContext.request.contextPath}/guru/updateGuru',
        toolbar:[
            {
                text:"添加",
                iconCls:"icon-control_add",
                handler:addGuru,//打开保存用户信息的对话框
            },
            "-",{
                text:"确定",
                iconCls:"icon-control_remove",
                handler:saveGuru,
            },
        ],
    });


    function addGuru(){
        $("#guruAdd").dialog({//添加框
            title:'AddCarouse',
            width:450,
            height:600,
            href:"${pageContext.request.contextPath}/Guru/GuruForm.jsp",//引入界面
            buttons:[//添加工具栏
                {
                    text:'保存',
                    iconCls:'icon-database_save',
                    handler:AddGuruForm,
                },
                {
                    text:'关闭',
                    iconCls:'icon-cross',
                    handler:GuruAddCloseOUT,
                }],
        });
    }

    function AddGuruForm(){
        $("#GuruFor").form("submit",{
            dirty:true,
            url:"${pageContext.request.contextPath}/guru/addGuru",//引入界面
            success:function(result){//得到返回对象
                resultJS = $.parseJSON(result);
                if(resultJS.verify){//提示确认框
                    $.messager.confirm('确认对话框','您确定添加吗?确定将成功添加这一条数据',function(ver){
                        if(ver){
                            GuruAddCloseOUT();
                            guruCtouLoad();
                            $.messager.show({
                                title:'我的提示',
                                msg:'添加成功!消息将在5秒后关闭。对话框也将关闭',
                                timeout:5000,
                                showType:'slide'
                            });
                        }else{//取消修改
                            GuruAddCloseOUT();
                            $.messager.show({
                                title:'我的提示',
                                msg:'添加取消!消息将在5秒后关闭。对话框也将关闭',
                                timeout:5000,
                                showType:'slide'
                            });
                        }
                    });
                }else{//修改时读取数据失败
                    GuruAddCloseOUT();
                    $.messager.show({
                        title:'我的提示',
                        msg:'添加失败!消息将在5秒后关闭。',
                        timeout:5000,
                        showType:'slide'
                    });
                }
            }
        });
    }



    function saveGuru() {
        $("#gurutt").edatagrid('saveRow');//保存编辑行并发送到服务器
    }

    function cancelGuru(){
        $("#gurutt").edatagrid('cancelRow');//取消编辑
    }

    function Guruload(){
        $("#gurutt").edatagrid("reload");//更新列表
    }

    function GuruAddCloseOUT(){//关闭修改框
        $("#guruAdd").dialog("close")
    }
    function guruCtouLoad(){
        $('#gurutt').datagrid('reload');
    }
</script>
<table id="gurutt" style="width:600px;height:200px"
       singleSelect="true">
        <thead>
        <tr>
                <th field="guruid" width="100" editor="{type:'validatebox',options:{editable:false}}">编号(编号将自动生成)</th>
                <th field="guruname" width="100" editor="text">名称</th>
                <th field="gurustatus" width="100" align="right" editor="{type:'textbox',options:{precision:1}}">状态</th>
                <th field="gender" width="100" align="right" editor="{type:'validatebox',options:{editable:false}}">性别</th>
                <th field="profile" width="150" editor="{type:'validatebox',options:{editable:false}}">头像</th>
                <th field="createname" width="150" editor="{type:'validatebox',options:{editable:false}}">创建者</th>
                <th field="createtime" width="150" editor="{type:'validatebox',options:{editable:false}}">创建时间</th>
        </tr>
        </thead>
</table>

<div id="guruAdd"></div>
<div id="guruUpdate"></div>