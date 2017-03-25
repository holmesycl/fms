<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <title>理财管理系统 注册</title>

    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/static/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="${pageContext.request.contextPath}/static/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="${pageContext.request.contextPath}/static/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>

	<div class="container">
		<div class="row">
			<div class="col-sm-10 col-sm-offset-1">
				<div style="margin: 30px 0 30px 0;">
					<div class="row" style="margin-bottom: -30px;">
						<div><p class="lead text-muted" style="padding-left: 15px;display: inline-block;">用户注册</p><p class="pull-right" style="padding-right: 15px;display: inline-block;">我已注册，现在就<a class="text-primary" href="${pageContext.request.contextPath}/s/login">登陆</a></p></div>
					</div>
					<hr>
				</div>
			</div>
			
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-sm-10 col-sm-offset-1">
				<div class="row">
					<div class="col-sm-5">
						<img src="${pageContext.request.contextPath}/static/img/signup1.jpg" alt="理财系统" class="img-responsive img-rounded">
					</div>
					<div class="col-sm-7">
						<div class="panel panel-default">
						  <!-- <div class="panel-heading">用户注册</div> -->
						  <div class="panel-body">
						    <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/signup/save">
						      <div class="form-group">
							    <label for="radioUserType" class="col-sm-2 control-label">用户类型</label>
							    <div class="col-sm-10">
							      <label class="radio-inline">
								    <input type="radio" name="userType" checked="checked" id="radioUserType" value="1"> 普通用户
								  </label>
								  <label class="radio-inline">
								    <input type="radio" name="userType" value="2"> 银行用户
								  </label>
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="inputUsername" class="col-sm-2 control-label">用户名</label>
							    <div class="col-sm-10">
							      <input type="text" class="form-control" name="username" id="inputUsername" placeholder="输入用户名">
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="inputEmail" class="col-sm-2 control-label">邮箱</label>
							    <div class="col-sm-10">
							      <input type="email" class="form-control" name="email" id="inputEmail" placeholder="输入正确邮箱">
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="inputPassword" class="col-sm-2 control-label">密码</label>
							    <div class="col-sm-10">
							      <input type="password" class="form-control" name="password" id="inputPassword" placeholder="输入登陆密码">
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="inputConfirmPassword" class="col-sm-2 control-label">确认密码</label>
							    <div class="col-sm-10">
							      <input type="password" class="form-control" name="confirmPassword" id="inputConfirmPassword" placeholder="确认登陆密码">
							    </div>
							  </div>
							  <div class="form-group">
							    <div class="col-sm-offset-2 col-sm-10">
							      <button type="submit" class="btn btn-primary btn-block">确认注册</button>
							    </div>
							  </div>
							</form>
						  </div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="${pageContext.request.contextPath}/static/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${pageContext.request.contextPath}/static/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </body>
</html>