<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<script>

    $('#CarouseTt').datagrid({
        cache:false,
        fit:true,
        remoteSort:false,
        singleSelect:true,
        nowrap:false,
        fitColumns:true,
        url:'${pageContext.request.contextPath}/carouse/queryAllCarouse',
        toolbar:[
            {
                text:"添加",
                iconCls:"icon-control_add",
                handler:addCarouse,//打开保存用户信息的对话框
            },
            "-",{
                text:"批量删除",
                iconCls:"icon-control_remove",
                handler:function(){},
            },
            "-"
        ],
        columns:[[

            {field:'carouseid',title:'轮播图ID',width:80},
            {field:'carousetitle',title:'轮播图名字',width:100,sortable:true},
            {field:'imgpath',title:'图片路径',width:80,align:'right',sortable:true},
            {field:'status',title:'图片状态',width:80,align:'right',sortable:true},
            {field:'createtime',title:'添加时间',width:150,sortable:true},
            {field:'description',title:'描述',width:60,align:'center'},
            {field:'createname',title:'添加者',width:60,align:'center'},
            {title:'其他操作',field:'optopns',width:150,align:'',
                formatter:function(value,row,index){
                    var json = JSON.stringify(row);
                    return "<a href='javascript:;' onclick='carouseDeleteUpdate("+json+");' class='baise' data-options=\"inconCls:'icon-add',plain:true\">删除</a>  &nbsp&nbsp <a class='baise' href='javascript:;' onclick='CarouseUpdate("+json+");' data-options=\"inconCls:'icon-remove',plain:true\">修改</a>";
                },
            },
            {title:'cks',field:'选中框',checkbox:true},
        ]],
        onLoadSuccess:function(){
            $(".baise").linkbutton();
        },
        view: detailview,
        detailFormatter: function(rowIndex, rowData){
            return '<table><tr>' +
                '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/'+ rowData.imgpath+'" style="height:50px;"></td>' +
                '<td style="border:0">' +
                '<p>描述: ' + rowData.description + '</p>' +
                '<p>状态: ' + rowData.status + '</p>' +
                '</td>' +
                '</tr></table>';
        }
    });

    function ctouLoad(){//刷新页面
        $('#CarouseTt').datagrid('reload');
    }


    function carouseAddCloseOUT(){//关闭添加框
        $("#carouseAdd").dialog("close")
    }

    function carouseUpdateClose(){//关闭修改框
        $("#carouseUpdate").dialog("close")
    }


    function carouseDeleteUpdate(json){

        $.messager.confirm("提示","您确定要删除吗?",function(rs){
            if(rs){
                //发送ajax请求删除一行数据
                $.post("${pageContext.request.contextPath}/carouse/updateStatus",{"carouseid":json.carouseid},function(result){  //jquery的ajax请求获取的是js对象 使用时直接使用
                  if(result.varify){
                    //提示状态
                    $.messager.show({title:"提示",msg:"删除用户"+result.content+"..."});

                  }else{
                      $.messager.show({title:"提示",msg:"删除用户"+result.content+"..."});
                  }
                },"JSON");
                ctouLoad();
            }
        });
    }
    function addCarouse(){
        $("#carouseAdd").dialog({//添加框
            title:'AddCarouse',
            width:450,
            height:600,
            href:"${pageContext.request.contextPath}/carouse/carouseForm.jsp",//引入界面
            buttons:[//添加工具栏
                {
                    text:'保存',
                    iconCls:'icon-database_save',
                    handler:AddCarouse,
                },
                {
                    text:'关闭',
                    iconCls:'icon-cross',
                    handler:carouseAddCloseOUT,
                }],
        });
    }
    function AddCarouse(){
            $("#carouseFor").form("submit",{
                dirty:true,
                url:"${pageContext.request.contextPath}/carouse/addCarouse",//引入界面
                success:function(result){//得到返回对象
                    resultJS = $.parseJSON(result);
                    if(resultJS.verify){//提示确认框
                        $.messager.confirm('确认对话框','您确定添加吗?确定将成功添加这一条数据',function(ver){
                            if(ver){
                                carouseAddCloseOUT();
                                ctouLoad();
                                $.messager.show({
                                    title:'我的提示',
                                    msg:'添加成功!消息将在5秒后关闭。对话框也将关闭',
                                    timeout:5000,
                                    showType:'slide'
                                });
                            }else{//取消添加
                                carouseAddCloseOUT();
                                $.messager.show({
                                    title:'我的提示',
                                    msg:'添加取消!消息将在5秒后关闭。对话框也将关闭',
                                    timeout:5000,
                                    showType:'slide'
                                });
                            }
                        });
                    }else{//添加时读取数据失败
                        carouseAddCloseOUT();
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

    function CarouseUpdate(json){
        $("#carouseUpdate").dialog({//修改框
            title:'AddCarouse',
            width:450,
            height:600,
            href:"${pageContext.request.contextPath}/carouse/UpdataForm.jsp?id="+json.carouseid,//引入界面
            buttons:[//添加工具栏
                {
                    text:'保存',
                    iconCls:'icon-database_save',
                    handler:UpdateCarouse,
                },
                {
                    text:'关闭',
                    iconCls:'icon-cross',
                    handler:carouseUpdateClose,
                }],
        });
    }

    function UpdateCarouse(){
        $("#carouseUpdateFor").form("submit",{
            dirty:true,
            url:"${pageContext.request.contextPath}/carouse/UpdateForName",//引入界面
            success:function(result){//得到返回对象
                resultJS = $.parseJSON(result);
                if(resultJS.verify){//提示确认框
                    $.messager.confirm('确认对话框','您确定修改吗?确定将修改添加这一条数据',function(ver){
                        if(ver){
                            carouseUpdateClose();
                            ctouLoad();
                            $.messager.show({
                                title:'我的提示',
                                msg:'修改成功!消息将在5秒后关闭。对话框也将关闭',
                                timeout:5000,
                                showType:'slide'
                            });
                        }else{//取消修改
                            carouseUpdateClose();
                            $.messager.show({
                                title:'我的提示',
                                msg:'修改取消!消息将在5秒后关闭。对话框也将关闭',
                                timeout:5000,
                                showType:'slide'
                            });
                        }
                    });
                }else{//修改时读取数据失败
                    carouseUpdateClose();
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




</script>
        <table id="CarouseTt"></table>

        <div id="carouseAdd"></div>
        <div id="carouseUpdate"></div>