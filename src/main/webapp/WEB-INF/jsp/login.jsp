<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <title>理财管理系统 用户登录</title>

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
	<nav class="navbar navbar-default" style="border-radius: 0">
	  <div class="container-fluid">
	    <!-- Brand and toggle get grouped for better mobile display -->
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand" href="${pageContext.request.contextPath}/home">理财系统</a>
	    </div>
	     <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav navbar-right">
	        <li><a href="${pageContext.request.contextPath}/signup">没有账号？点击注册</a></li>
	      </ul>
	    </div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
	</nav>

	<div class="container" style="margin-top: 100px;">
		<div class="row">
			<div class="col-sm-10 col-sm-offset-1">
				<div class="row">
					<div class="col-sm-6">
						<img src="${pageContext.request.contextPath}/static/img/signup.jpg" alt="理财系统" class="img-responsive img-rounded">
					</div>
					<div class="col-sm-6">
						<div class="panel panel-default">
						  <div class="panel-heading">用户密码登录</div>
						  <div class="panel-body">
							<form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/s/login">
							  <div class="form-group">
							    <label for="inputUsername" class="col-sm-2 control-label">用户名</label>
							    <div class="col-sm-10">
							      <input type="text" class="form-control" name="username" id="inputUsername" placeholder="输入用户名">
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="inputPassword" class="col-sm-2 control-label">密码</label>
							    <div class="col-sm-10">
							      <input type="password" class="form-control" name="password" id="inputPassword" placeholder="输入登陆密码">
							    </div>
							  </div>
							  <div class="form-group">
							    <div class="col-sm-offset-2 col-sm-10">
							      <div class="checkbox">
							        <label>
							          <input type="checkbox"> 记住我
							        </label>
							      </div>
							    </div>
							  </div>
							  <div class="form-group">
							    <div class="col-sm-offset-2 col-sm-10">
							      <button type="submit" class="btn btn-default">登录</button>
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