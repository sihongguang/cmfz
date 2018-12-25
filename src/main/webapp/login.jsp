<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<%@include file="JSPUtil.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>持名法州后台管理中心</title>
			
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
	<link rel="icon" href="img/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" href="css/common.css" type="text/css"></link>
	<link rel="stylesheet" href="css/login.css" type="text/css"></link>
	<script type="text/javascript" src="script/jquery.js"></script>
	<script type="text/javascript" src="script/common.js"></script>
	<script type="text/javascript">
	
		$(function(){
			//点击更换验证码：
			$("#captchaImage").click(function(){//点击更换验证码
				$("#captchaImage").prop("src","${prc}/code/code?c="+new Date().getTime());
			});

			//  form 表单提交
			$("#loginForm").bind("submit",function(){
			    //设置初始值
			    var verifySubmit=false;
                var b3= userNameVerify();
                var b1 = passwordVerify ();
                var b2 = codeVerify();
               	var b4= b3&&b1&&b2;
               if(b4){
                    //得到提交的用户名和密码
				    var adminName=$("#adminName").val();
				    var adminPassword=$("#adminPassword").val();
				    var remeberMe=$("#checkboxName").val();
				    //使用ajax 异步请求进行提交验证
				    $.get("${prc}/admin/adminLoginShiro",{"adminName":adminName,"password":adminPassword,rm:remeberMe},function(result){
						if(result.verify){//判断成功跳转网页
						    console.log("成功")
				             window.location.href="${prc}/main/main.jsp";
						    verifySubmit=true;
						}else {//失败告诉他明确的错误
							$("#adminSubmitResult").html(result.content).css("color","red");
						}
					},"json");
				}
				return verifySubmit;
			});
		});

		function userNameVerify() {
			var adminName=$("#adminName").val();
			if (adminName!=null){
			    if(adminName!=""){
			        $("#adminNameSpan").html("");
			        return true;
				}
            }
            $("#adminNameSpan").html("不能为空").css("color","red");
			return false;
        }


        function passwordVerify () {
            var adminPassword=$("#adminPassword").val();
            if (adminPassword!=null){
                if(adminPassword!=""){
                    $("#adminPasswordSpan").html("");
                    return true;
                }
            }
            $("#adminPasswordSpan").html("不能为空").css("color","red");
            return false;
        }
        var ble=false;
        function codeVerify(){
		   var encode= $("#enCode").val();
			$.post("${prc}/code/verifyEncode",{"encode":encode},function(result){
                if (result.verify) {
                    $("#encodeSpan").html(result.content).css("color","green");
                    ble=result.verify;
                }else {
                    $("#encodeSpan").html(result.content).css("color","red");
                }
            },"JSON");
			return ble;
		}
	</script>
</head>
<body>
	
		<div class="login">
			<form id="loginForm">
				
				<table>
					<tbody>
						<tr>
							<td width="190" rowspan="2" align="center" valign="bottom">
								<img src="img/header_logo.gif" />
							</td>
							<th>
								用户名:
							</th>
							<td>
								<input ONBLUR="userNameVerify();" id="adminName" type="text"  name="" class="text" value="" maxlength="20"/>
								<span id="adminNameSpan"></span>
								<span id="adminSubmitResult"></span>
							</td>
					  </tr>
					  <tr>
							<th>
								密&nbsp;&nbsp;&nbsp;码:
							</th>
							<td>
								<input ONBLUR="passwordVerify();" id="adminPassword" type="password" name="" class="text" value="" maxlength="20" autocomplete="off"/>
								<span id="adminPasswordSpan"></span>
							</td>
					  </tr>
					
						<tr>
							<td>&nbsp;</td>
							<th>验证码:</th>
							<td>
								<input type="text" id="enCode"  ONBLUR="codeVerify();" style="width:95px;" maxlength="4" autocomplete="off"/>
								<img id="captchaImage" class="captchaImage" src="${prc}/code/code" title="点击更换验证码"/>
								<span id="encodeSpan"></span>
							</td>
						</tr>					
					<tr>
						<td>
							&nbsp;
						</td>
						<th>
							&nbsp;
						</th>
					</tr>
						<td>记住密码 :<input id="checkboxName" type="checkbox" name="remeberMe" ></td>
					<tr>
						<td>&nbsp;</td>
						<th>&nbsp;</th>
						<td>
							<input type="button" class="homeButton" value="" onclick="location.href=''"><input type="submit" class="loginButton" value="登录">
						</td>
					</tr>
				</tbody></table>
				<div class="powered">COPYRIGHT © 2008-2017.</div>
				<div class="link">
					<a href="http://www.chimingfowang.com/">持名佛网首页</a> |
					<a href="http://www.chimingbbs.com/">交流论坛</a> |
					<a href="">关于我们</a> |
					<a href="">联系我们</a> |
					<a href="">授权查询</a>
				</div>
			</form>
		</div>
</body>
</html>