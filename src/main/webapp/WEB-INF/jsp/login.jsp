<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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

	<jsp:include page="nav.jsp"/>

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
							<form method="post" action="${pageContext.request.contextPath}/s/login">
							  <div class="form-group ${login['otherState'] }">
							    <span class="help-block ${login['otherDisplay'] }">${login['otherMsg'] }</span>
							  </div>
							  <div class="form-group ${login['usernameState'] }">
							    <label for="inputUsername" class="control-label">用户名</label>
							    <input type="text" class="form-control" name="username" id="inputUsername" value="${username }" placeholder="输入用户名">
							    <span class="help-block ${login['usernameDisplay'] }">${login['usernameMsg'] }</span>
							  </div>
							  <div class="form-group ${login.passwordState }">
							    <label for="inputPassword" class="control-label">密码</label>
							    <input type="password" class="form-control" name="password" id="inputPassword" placeholder="输入登陆密码">
							    <span class="help-block ${login.passwordDisplay }">${login.passwordMsg }</span>
							  </div>
							  <div class="form-group">
						      <div class="checkbox">
						        <label>
						          <input type="checkbox"> 记住我
						        </label>
						      </div>
							  </div>
							  <div class="form-group">
							  	<button type="submit" class="btn btn-primary btn-block">登录</button>
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
  	<script type="text/javascript">
  	(function($){
  		$('.form-control').focusin(function() {
  			$(this).parent().removeClass('has-success').removeClass('has-error');
  			$(this).next().removeClass('show').addClass('hidden');
  		}).focusout(function(){
  			var val = $(this).val();
  			if(!val){
  				$(this).parent().addClass('has-error');
  			}else{
  				$(this).parent().addClass('has-success');
  			}
  		});
  		$('form').submit(function() {
  		  var username = $('#inputUsername').val();
  		  if(!username){
  			$('#inputUsername').parent().addClass('has-error');
  			return false;
  		  }
  		  var password = $('#inputPassword').val();
  		  if(!password){
  			$('#inputPassword').parent().addClass('has-error');
  			return false;
  		  }
  		  return true;
  		});
  	})(jQuery)
  	
  	</script>
  </body>
</html>