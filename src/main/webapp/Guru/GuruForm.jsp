<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<script>


</script>

<div style="text-align: center;">
    <form id="GuruFor" method="post" enctype="multipart/form-data" class="easyui-form">
        <div style="margin-top:80px;">
            <label>大师名称:</label>
            <input class="easyui-textbox" type="text" name="guruname" data-options="required:true,width:150," />
        </div>
        <div style="margin-top:30px;">
            <label>上传头像:</label>
            <input  class="easyui-filebox"  name="multipartFile" data-options="required:true,width:150," />
        </div>

        <div style="margin-top:30px;">
            <label>性别:</label>
            <input class="easyui-textbox" type="text" name="gender" data-options="required:true,width:150," />
        </div>

        <div style="margin-top:30px;">
            <label>注册时间:</label>
            <input class="easyui-datebox" name="createtime" data-options="required:true,width:150," />
        </div>
    </form>
</div>