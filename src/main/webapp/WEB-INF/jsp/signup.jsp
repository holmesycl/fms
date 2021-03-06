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
					<div class="col-sm-7">
						<div class="panel panel-default">
						  <div class="panel-body">
						    <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/signup/save">
						      <div class="form-group ${signup['otherState'] }">
							    <div class="col-sm-10 col-sm-offset-2">
							    	<span class="help-block ${signup['otherDisplay'] }">${signup['otherMsg'] }</span>
							  	</div>
							  </div>
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
							  <div class="form-group ${signup['usernameState'] }">
							    <label for="inputUsername" class="col-sm-2 control-label">用户名</label>
							    <div class="col-sm-10">
							      <input type="text" class="form-control" name="username" id="inputUsername" placeholder="输入用户名">
							      <span class="help-block ${signup['usernameDisplay'] }">${signup['usernameMsg'] }</span>
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="inputEmail" class="col-sm-2 control-label">邮箱</label>
							    <div class="col-sm-10">
							      <input type="text" class="form-control" name="email" id="inputEmail" placeholder="输入正确邮箱">
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
					<div class="col-sm-5">
						<img src="${pageContext.request.contextPath}/static/img/signup.jpg" alt="理财系统" class="img-responsive img-rounded">
					</div>
				</div>
			</div>
		</div>
	</div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="${pageContext.request.contextPath}/static/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${pageContext.request.contextPath}/static/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  	<script type="text/javascript">
  	(function($){
  		$('.form-control').focusin(function() {
  			$(this).parent().parent().removeClass('has-success').removeClass('has-error');
  			$(this).next().removeClass('show').addClass('hidden');
  		}).focusout(function(){
  			var val = $(this).val();
  			if(!val){
  				$(this).parent().parent().addClass('has-error');
  			}else{
  				$(this).parent().parent().addClass('has-success');
  			}
  		});
  		$('form').submit(function() {
  			var username = $('#inputUsername').val();
  			if(!username){
  				$('#inputUsername').parent().parent().addClass('has-error');
  				return false;
  			}
  			var eamil = $('#inputEmail').val();
  			if(!eamil){
  				$('#inputEmail').parent().parent().addClass('has-error');
  				return false;
  			}
  		  	var password = $('#inputPassword').val();
  		  	if(!password){
  				$('#inputPassword').parent().parent().addClass('has-error');
  				return false;
  		  	}
  		 	var confirmPassword = $('#inputConfirmPassword').val();
		  	if(!confirmPassword){
				$('#inputConfirmPassword').parent().parent().addClass('has-error');
				return false;
		  	}
		  	if(password != confirmPassword){
		  		$('#inputPassword').parent().parent().addClass('has-error');
		  		$('#inputConfirmPassword').parent().parent().addClass('has-error');
		  		return false;
		  	}
  		  	return true;
  		});
  	})(jQuery)
  	
  	</script>
  </body>
</html>