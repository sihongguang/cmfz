<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>

<script>
    $('#UserTT').edatagrid({
        fit:true,
        remoteSort:false,
        singleSelect:true,
        nowrap:false,
        fitColumns:true,
        url:'${pageContext.request.contextPath }/user/queryAllUser',
        columns:[[
            {field:'userid',title:'id',width:140},
            {field:'nikename',title:'法名',width:80,align:'right',sortable:true},
            {field:'username',title:'姓名',width:80,align:'right',sortable:true},
            {field:'gender',title:'性别',width:150,sortable:true},
            {field:'sign',title:'签名',width:60,align:'center'},
            {field:'phone',title:'电话',width:150,align:'center'},
            {field:'status',title:'状态',width:150,align:'center'},
            {field:'profile',title:'图片',width:150,align:'center',
                formatter:function(value,row,index){
                    return "<img src='${pageContext.request.contextPath}"+ value + "' width='25px' height='25px' >";
                }
            },
            {field:'province',title:'省',width:150,align:'center'},
            {field:'city',title:'市',width:150,align:'center'},
            {field:'registertime',title:'创建时间',width:150,align:'center'},
            {"title":"操作","field":"soptions","width":"70","align":"center",
                formatter:function(value,row,index){
                    var json =  JSON.stringify(row);
                    return "<a class='userUpdate' onclick='delRow("+json+");' data-options=\"plain:true,iconCls:' icon-control_remove'\">修改状态</a>"
                }
            },
        ]],
        onLoadSuccess:function(){
            $(".eduserUpdateit").linkbutton();

        },
    });
    function delRow(row){
        console.log(row.userid);
        $.messager.confirm("提示","您确定要修改状态吗?",function(r){
            if(r){
                //发送ajax请求删除一行数据
                $.post("${pageContext.request.contextPath}/user/updateUserStatus",{userid:row.userid,status:row.status},
                    function(result){  //jquery的ajax请求获取的是js对象 使用时直接使用
                       if(result.verify){
                                   //提示状态
                                $.messager.show({title:"提示",msg:result.content});
                                //刷新现有datagrid表格
                                $("#UserTT").datagrid('reload');
                       }else{
                           $.messager.show({title:"提示",msg:result.content});
                       }
                    },"JSON");
            }
        });
    }

</script>
<table id="UserTT">
</table>
