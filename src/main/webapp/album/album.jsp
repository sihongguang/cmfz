<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
	$(function(){
		$('#tree').treegrid({    
		    url:'${pageContext.request.contextPath}/album/queryAll',
			fit:true,
            fitColumns:true,
		    idField:'id',
		    treeField:'title',
            pagination:true,
		    columns:[[
		        {title:'章节名称',field:'title',width:120},
                {title:'播放时长',field:'duration',width:120},
                {title:'下载路径',field:'downpath',width:150},
		        {title:'章节大小',field:'size',width:150},
                {title:'集数',field:'count',width:150},
                {title:'作者',field:'author',width:150},
                {title:'add',field:'id',width:120}
		    ]],
		    toolbar: [{
				iconCls: 'icon-lock',
				text:'专辑详情',
				handler: function(){
					var obj = $("#tree").treegrid('getSelected');
					if(obj == null){
						alert("您未选中");
					}else if(obj.author == null){
						alert("请选择专辑");
					}else{
						$("#detailCover").attr('src','${pageContext.request.contextPath}/'+obj.cover).attr('width','300px');
						$("#detailTitle").append('<font>'+obj.title+'<font>');/*名称*/
                        $("#detailCount").append('<font>'+obj.count+'<font>');/*集数*/
                        $("#detailScore").append('<font>'+obj.score+'<font>');/*分数*/
                        $("#detailAuthor").append('<font>'+obj.author+'<font>');/*作者*/
                        $("#detailBroadcast").append('<font>'+obj.broadcast+'<font>');/*播音员*/
                        $("#detailBrief").append('<font>'+obj.brief+'<font>');/*简介*/
                        $("#detailPublishTime").append('<font>'+obj.publisdate+'<font>');/*发布时间*/
						$('#detail').dialog({    
						    title: '专辑详情',    
						    width: 600,    
						    height: 600,    
						    cache: false,
                            onClose:function(){
                                $("#detailTitle").html("");/*名称*/
                                $("#detailCount").html("");/*集数*/
                                $("#detailScore").html("");/*分数*/
                                $("#detailAuthor").html("");/*作者*/
                                $("#detailBroadcast").html("");/*播音员*/
                                $("#detailBrief").html("");/*简介*/
                                $("#detailPublishTime").html("");/*发布时间*/
						    }
						});
					}
				}
			},'-',{
				iconCls: 'icon-add',
				text:'添加专辑',
				handler: function(){
					$('#addAlbumDiv').dialog({    
					    title: '添加专辑',    
					    width: 600,    
					    height: 300,    
					    closed: false,    
					    cache: false,    
					    modal: true   
					}); 
				}
			},'-',{
				iconCls: 'icon-add',
				text:'添加章节',
				handler: function(){
					var obj = $("#tree").treegrid('getSelected');
					if(obj == null){
						alert("您未选中");
					}else if(obj.author == null){
						alert("请选择专辑");
					}else{
						$("#albumId").textbox('setValue',obj.id);
						$("#addChapterDiv").dialog({    
						    title: '添加章节',    
						    width: 600,    
						    height: 300,    
						    closed: false,    
						    cache: false,    
						    modal: true   
						});
					}
				}
			},'-',{
				iconCls: 'icon-edit',
				text:'下载章节',
				handler: function(){
					var obj = $("#tree").treegrid('getSelected');
					if(obj == null){
						alert("您未选中");
					}else if(obj.author != null){
						alert("请选择章节");
					}else{
						//不能用ajax，用ajax不会报错，但是不会进入controller
						location.href='${pageContext.request.contextPath}/chapter/downloadChapter?id='+obj.id
					}
				}
			},{
                iconCls: 'icon-add',
                text:'删除专辑',
                handler: function(){
                    var obj = $("#tree").treegrid('getSelected');
                    if(obj == null){
                        alert("您未选中");
                    }else if(obj.author == null){
                        alert("请选择专辑");
                    }else{
                        $.messager.confirm('确定删除'+obj.title+'?吗','确定删除'+obj.title+'?吗',function(r){

							if(r){
							   $.post("${pageContext.request.contextPath}/album/deleteAlbum",{"id":obj.id},function(resultJS){
                                   if(resultJS.verify){
                                       $.messager.show({
                                           title:'我的提示',
                                           msg:'删除成功!消息将在5秒后关闭。对话框也将关闭',
                                           timeout:5000,
                                           showType:'slide'
                                       });
                                   }else{
                                       $.messager.show({
                                           title:'我的提示',
                                           msg:'删除失败!消息将在5秒后关闭。对话框也将关闭',
                                           timeout:5000,
                                           showType:'slide'
                                       });
								   };
							   },"JSON");
                                console.log(r);
							   $("#tree").treegrid("reload");
							}
						});
                    }
                }

			}],
			fit:true,

		});
		$('#addAlbumForm').form({
		    url:'${pageContext.request.contextPath}/album/addAlbum',    
		    success:function(result){
                resultJS = $.parseJSON(result);
		        if(resultJS.verify){
					$.messager.show({
						title:'我的提示',
						msg:'添加成功!消息将在5秒后关闭。对话框也将关闭',
						timeout:5000,
						showType:'slide'
					});
                    $("#addAlbumDiv").dialog("close");
                    $("#tree").treegrid("reload");
		        }else{
                    $.messager.show({
                        title:'我的提示',
                        msg:'添加取消!消息将在5秒后关闭。对话框也将关闭',
                        timeout:5000,
                        showType:'slide'
                    });
				}

		    }    
		});


		$('#addChapterForm').form({
		    url:'${pageContext.request.contextPath}/chapter/addChapter',
		    success:function(result){
                resultJS = $.parseJSON(result);
                if(resultJS.verify){
                    $.messager.show({
                        title:'我的提示',
                        msg:'修改成功!消息将在5秒后关闭。对话框也将关闭',
                        timeout:5000,
                        showType:'slide'
                    });
                    $("#addChapterDiv").dialog("close");
                    $("#tree").treegrid("reload");
                }else{
                    $.messager.show({
                        title:'我的提示',
                        msg:'修改取消!消息将在5秒后关闭。对话框也将关闭',
                        timeout:5000,
                        showType:'slide'
                    });
                }
		    }
		});
	});


</script>
<table id="tree" style="width:600px;height:400px"></table>  
<div id="detail" align="center">
	<table id="treeAlbum">
		<tr>
			<td colspan="2"><img id="detailCover"/></td>
		</tr>
		<tr>
			<td>专辑名称：</td>
			<td><span id="detailTitle"></span></td>
		</tr>
		<tr>
			<td>章节数量：</td>
			<td><span id="detailCount"></span></td>
		</tr>
		<tr>
			<td>专辑得分：</td>
			<td><span id="detailScore"></span></td>
		</tr>
		<tr>
			<td>专辑作者：</td>
			<td><span id="detailAuthor"></span></td>
		</tr>
		<tr>
			<td>播音员：</td>
			<td><span id="detailBroadcast"></span></td>
		</tr>
		<tr>
			<td>专辑简介：</td>
			<td><span id="detailBrief"></span></td>
		</tr>
		<tr>
			<td>上架时间：</td>
			<td><span id="detailPublishTime"></span></td>
		</tr>
	</table>
</div> 
<div id="addAlbumDiv" align="center">
	<form id="addAlbumForm" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>专辑名称：</td>
				<td><input name="title" class="easyui-textbox" data-options="iconCls:'icon-search'" style="width:300px"> </td>
			</tr>
			<tr>
				<td>专辑得分：</td>
				<td><input name="score" class="easyui-textbox" data-options="iconCls:'icon-search'" style="width:300px"> </td>
			</tr>
			<tr>
				<td>专辑作者：</td>
				<td><input name="author" class="easyui-textbox" data-options="iconCls:'icon-search'" style="width:300px"> </td>
			</tr>
			<tr>
				<td>播音员：</td>
				<td><input name="broadcast" class="easyui-textbox" data-options="iconCls:'icon-search'" style="width:300px"> </td>
			</tr>
			<tr>
				<td>专辑简介：</td>
				<td><input name="brief" class="easyui-textbox" data-options="iconCls:'icon-search'" style="width:300px"> </td>
			</tr>
			<tr>
				<td>上架时间：</td>
				<!-- 后台接受到的是string类型，所以要么用string接受，要么在实体类配置注解 -->
				<td><input name="publisdate" id="dd"  class= "easyui-datebox" editable="false"> </input>   </td>
			</tr>
			<tr>
				<td>专辑图片：</td>
				<td><input name="addFile" class="easyui-filebox" style="width:300px"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"/></td>
			</tr>
		</table>
	</form>
</div>
<div id="addChapterDiv" align="center">
	<form id="addChapterForm" class="easyui-form" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>专辑ID：</td>
				<td><input id="albumId" name="chapterPid" class="easyui-textbox" data-options="iconCls:'icon-search'" style="width:300px"> </td>
			</tr>

			<tr>
				<td>专辑名称：</td>
				<td><input  name="title" class="easyui-textbox" data-options="iconCls:'icon-search'" style="width:300px"> </td>
			</tr>
			<tr>
				<td>音频上传：</td>
				<td><input name="filefrequency" class="easyui-filebox" style="width:300px"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"/></td>
			</tr>
		</table>
	</form>
</div>    