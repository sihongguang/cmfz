<%@ page isELIgnored="false" contentType="text/html; UTF-8"  pageEncoding="UTF-8" %>
<%@ include file="JSPUtil.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>login</title>
		<link rel="stylesheet" type="text/css" href="${prc}/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css" href="${prc}/themes/IconExtension.css">

		<script type="text/javascript" src="${prc}/js/jquery.min.js"></script>
		<script type="text/javascript" src="${prc}/js/jquery.easyui.min.js"></script>

		<script type="text/javascript" src="${prc}/js/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript" src="${prc}/js/jquery.edatagrid.js"></script>

		<script type="text/javascript" src="${prc}/js/datagrid-detailview.js"></script>
		<script type="text/javascript" src="${prc}/js/form.validator.rules.js"></script>

	</head>


	<body>
		<div id="wrap">
			<div id="top_content">
					<div id="header">

				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						来吧登陆吧少年 会有意想不到的效果
					</h1>
					<form action="${prc}/user/login" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									手机号:
								</td>
								<td valign="middle" align="left">
									<input calss="easyui-textbox" name="phone" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									密码:
								</td>
								<td valign="middle" align="left">
									<input name="password" class="easyui-passwordbox" data-options="iconCls:'icon-search'" style="width:300px">
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="Submit &raquo;" />
							<input type="button" class="button" onclick="location.href='${prc}/register.jsp'" value="Regist &raquo;" />
						</p>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>
