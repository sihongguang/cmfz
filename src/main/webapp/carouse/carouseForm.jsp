<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<script>


</script>

<div style="text-align: center;">
    <form id="carouseFor" method="post" enctype="multipart/form-data" class="easyui-form">
        <div style="margin-top:80px;">
            <label>专辑名称:</label>
            <input class="easyui-textbox" type="text" name="carousetitle" data-options="required:true,width:150," />
        </div>
        <div style="margin-top:30px;">
            <label>发布时间:</label>
            <input class="easyui-datebox" name="createtime" data-options="required:true,width:150," />
        </div>

        <div style="margin-top:30px;">
            <label>上传轮播图:</label>
            <input  class="easyui-filebox"  name="filename" data-options="required:true,width:150," />
        </div>
        <div style="margin-top:30px;">
            <label>描述:</label>
            <input class="easyui-textbox" type="text" name="description" data-options="required:true,width:150," />
        </div>
    </form>
</div>