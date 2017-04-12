<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>理财管理系统</title>

    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/static/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="${pageContext.request.contextPath}/static/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="${pageContext.request.contextPath}/static/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui/1.5.1/themes/bootstrap/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui/1.5.1/themes/icon.css">

  </head>
  <body>
	
	<div class="container" style="margin-top: 20px;">
		<h3>用户信息</h3>
		<hr>
		<form id="ff" class="form-horizontal" method="post" action="${pageContext.request.contextPath}/personal/user/updateBasicInfo">
		  <div class="form-group">
		    <label class="col-sm-2 control-label">用户名</label>
		    <div class="col-sm-10">
		      <p class="form-control-static">${user.username }</p>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="inputEmail" class="col-sm-2 control-label">邮箱</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" name="email" id="inputEmail" value="${user.email }">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="inputCellphoneNumber" class="col-sm-2 control-label">手机号码</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" name="cellphoneNumber" id="inputCellphoneNumber" value="${user.cellphoneNumber }">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="inputPassword" class="col-sm-2 control-label">密码</label>
		    <div class="col-sm-10">
		      <input type="password" class="form-control" name="password" id="inputPassword">
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <button class="btn btn-primary">修改用户信息</button>
		    </div>
		  </div>
		</form>
	</div>
	
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="${pageContext.request.contextPath}/static/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${pageContext.request.contextPath}/static/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui/1.5.1/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui/1.5.1/locale/easyui-lang-zh_CN.js"></script>
 	
 	<script type="text/javascript">
 	$("#ff").submit(function (e) {
 		e.preventDefault();
 		$.messager.progress();	// display the progress bar
	 	$('#ff').form('submit', {
	 	    url: '${pageContext.request.contextPath}/personal/user/updateBasicInfo',
	 		onSubmit: function(){
	 	    	var isValid = $(this).form('validate');
	 			if (!isValid){
	 				$.messager.progress('close');	// hide progress bar while the form is invalid
	 			}
	 			return isValid;	// return false will stop the form submission
	 	    },
	 	    success: function(data){
	 	    	$.messager.progress('close');	// hide progress bar while submit successfully
	 	    	data = JSON.parse(data);
	 	    	$.messager.alert('提示', data.msg, data.type, function(){
	 	    		location.href = location.href;
	 	    	});
	 	    }
	 	});
 	} );
 	</script>
 
  </body>
</html>