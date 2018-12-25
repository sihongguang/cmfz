<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<script>
    $("#carouseUpdateFor").form('load','${pageContext.request.contextPath}/carouse/updateShowCarouse?carouseid=${param.id}');
</script>

<div style="text-align: center;">
    <form id="carouseUpdateFor" method="post"  class="easyui-form">
        <input  type="hidden" name="carouseid" data-options="required:true,width:150," />

        <div style="margin-top:80px;">
            <label>轮播图名称:</label>
            <input class="easyui-textbox" type="text" name="carousetitle" data-options="required:true,width:150," />
        </div>

        <div style="margin-top:30px;">
            <label>描述:</label>
            <input class="easyui-textbox" type="text" name="description" data-options="required:true,width:150," />
        </div>

      </form>


</div>
<script>

</script>