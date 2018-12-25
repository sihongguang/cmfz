<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<script>
    $(function () {
        $('#Ariticle').treegrid({
            fit:true,
            remoteSort:false,
            singleSelect:true,
            nowrap:false,
            fitColumns:true,
            url:'${pageContext.request.contextPath}/article/queryallGuruAndArticle',
            idField:'guruid',            //定义关键字段来标识树节点。也就是数据的id
            treeField:'guruname',        //定义树形显示字段
            columns:[[                //定义表格头名称
                {title: '创作者', field: 'guruname', width: 180,},
                {title: '图书编号', field: 'articleid', width: 180,},
                {title: '图书名称', field:'articlename', width: 180,},
                {title: '发布时间', field: 'publishtime', width: 180,},
                {title: '封面路径', field: 'figurepath', width: 180,},
                {title: '简介', field: 'content', width: 180,}
            ]],
        });
    });

</script>

<table id="Ariticle" style="width:380px;height:150px;"></table>