<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<script>
    $(function (){
        $("#adminff").form('load','${pageContext.request.contextPath}/admin/updateShowAdmin?name=${sessionScope.admin.adminname}');
    });
</script>
<div style="text-align: center;">
    <form  id="adminff" class="easyui-form" method="post">
        <input type="hidden" name="adminid" data-options="width:150," />
        <div style="margin-top:80px;">
            <label>用户名:</label>
            <input class="easyui-textbox" type="text" name="adminname" data-options="width:150," />
        </div>
        <div style="margin-top:20px;">
            <label>需要修改的密码:</label>
            <input class="easyui-textbox" id="updatePassword" name="password" data-options="required:true,width:150" />
            <span id="spanPassword"></span>
        </div>
        <div style="margin-top:20px;">
            <img src="${pageContext.request.contextPath}/img/B4.jpg"  height="300"/>
        </div>

    </form>
</div>