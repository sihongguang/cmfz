<%@ page isELIgnored="false" contentType="text/html; UTF-8"  pageEncoding="UTF-8" %>
<%@ include file="JSPUtil.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>持名法州用户注册</title>

    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">


    <link rel="icon" href="img/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="${prc}/css/common.css" type="text/css"></link>
    <link rel="stylesheet" href="${prc}/css/login.css" type="text/css"></link>

    <script type="text/javascript" src="${prc}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${prc}/js/jquery.easyui.min.js"></script>

    <script type="text/javascript">
    </script>
</head>
        <body>
        <div style="text-align: center;">
            <form id="UserForm" action="${prc}/user/addUser"  method="post" enctype="multipart/form-data" >
                <div style="margin-top:80px;">
                    <label>用户名称:</label>
                    <input type="text" name="username"  />
                </div>
                <div style="margin-top:30px;">
                    <label>用户昵称:</label>
                    <input  type="text"  name="nikename"  />
                </div>

                <div style="margin-top:30px;">
                    <label>性别:</label>
                    <input type="text" name="gender" />
                </div>

                <div style="margin-top:30px;">
                    <label>头像:</label>
                    <input type="file" name="addFile" />
                </div>

                <div style="margin-top:30px;">
                    <label>省份:</label>
                    <input type="text" name="province"  />
                </div>

                <div style="margin-top:30px;">
                    <label>市:</label>
                    <input type="text" name="city"  />
                </div>

                <div style="margin-top:30px;">
                    <label>签名:</label>
                    <input type="text" name="sign" />
                </div>

                <div style="margin-top:30px;">
                    <label>密码:</label>
                    <input type="text" name="password"  />
                </div>

                <div style="margin-top:30px;">
                    <label>手机号:</label>
                    <input type="text" name="phone"  />
                </div>

                <div style="margin-top:30px;">
                    <input type="submit" value="注册" />
                </div>

            </form>
        </div>
       </body>
</html>