<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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
	
	<style type="text/css">
	.banner { position: relative; overflow: auto; }
    .banner li { list-style: none; }
        .banner ul li { float: left; }
	
	</style>

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
	      	<li><a href="${pageContext.request.contextPath}/s/login">已有账号？点击登录</a></li>
	      </ul>
	    </div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
	</nav>
	
	<div style="width: 100%;height: 400px;background-color: #ff4e4a;margin-top: -20px;">
		<div class="container">
			<div class="row">
				<div class="col-md-5 col-md-offset-7">
					<div class="panel panel-default" style="margin-top: 50px;">
					  <div class="panel-heading text-center">新用户注册</div>
					  <div class="panel-body">
						<form method="post" action="${pageContext.request.contextPath}/signup/save">
					      <div class="form-group sr-only">
						  	  <label for="radioUserType" class="sr-only">用户类型</label>
						  	  <div class="col-md-10 col-md-offset-1" style="margin-top: 20px;">
						  	  	<input type="radio" name="userType" checked="checked" id="radioUserType" value="1"> 普通用户
						  	  </div>
						  </div>
						  <div class="form-group">
						    <label for="inputUsername" class="sr-only">用户名</label>
						    <div class="col-md-10 col-md-offset-1" style="margin-top: 20px;">
						      <input type="text" class="form-control" name="username" id="inputUsername" placeholder="用户名">
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="inputEmail" class="sr-only">邮箱</label>
						    <div class="col-md-10 col-md-offset-1" style="margin-top: 20px;">
						      <input type="email" class="form-control" name="email" id="inputEmail" placeholder="邮箱">
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="inputPassword" class="sr-only">密码</label>
						    <div class="col-md-10 col-md-offset-1" style="margin-top: 20px;">
						      <input type="password" class="form-control" name="password" id="inputPassword" placeholder="登陆密码">
						  	</div>
						  </div>
						  <div class="form-group">
						  	<div class="col-md-10 col-md-offset-1" style="margin-top: 20px;margin-bottom: 20px;">
						      <button type="submit" class="btn btn-default btn-block" style="background-color: #ff721f;color: aliceblue;">确认注册</button>
						    </div>
						  </div>
						</form>
					</div>
				  </div>
				</div>
			</div>
		</div>
	</div>
    
    <!-- 收益推荐 -->
    <div class="container" style="margin-top: 20px;">
    	<h3>收益推荐</h3>
	    <div class="row" id="topExpectRate">
		  <div class="col-md-4">
		    <div class="thumbnail">
		      <div class="caption">
		        <p class="text-center" style="color: #333;font-style: normal;">12个月</p>
		        <hr>
		        <p class="text-center">
		        	<span style="line-height: 60px;font-size: 55px;color: #ff721f;">8.9</span>
		        	<span style="font-size: 12px;line-height: 70px;color: #ff721f;font-style: normal">%</span>
		        </p>
		        <p class="text-center" style="line-height: 20px;font-size: 12px;color: #999;margin-top: -30px;">预期年收益</p>
		        <hr>
		         <p class="text-center" style="font-size: 14px;line-height:45px; color: #fff;cursor: pointer;background-color: #ff721f;">立即购买</p>
		      </div>
		    </div>
		  </div>
		  <div class="col-md-4">
		    <div class="thumbnail">
		      <div class="caption">
		        <p class="text-center" style="color: #333;font-style: normal;">12个月</p>
		        <hr>
		        <p class="text-center">
		        	<span style="line-height: 60px;font-size: 55px;color: #ff721f;">8.9</span>
		        	<span style="font-size: 12px;line-height: 70px;color: #ff721f;font-style: normal">%</span>
		        </p>
		        <p class="text-center" style="line-height: 20px;font-size: 12px;color: #999;margin-top: -30px;">预期年收益</p>
		        <hr>
		         <p class="text-center" style="font-size: 14px;line-height:45px; color: #fff;cursor: pointer;background-color: #ff721f;">立即购买</p>
		      </div>
		    </div>
		  </div>
		  <div class="col-md-4">
		    <div class="thumbnail">
		      <div class="caption">
		        <p class="text-center" style="color: #333;font-style: normal;">12个月</p>
		        <hr>
		        <p class="text-center">
		        	<span style="line-height: 60px;font-size: 55px;color: #ff721f;">8.9</span>
		        	<span style="font-size: 12px;line-height: 70px;color: #ff721f;font-style: normal">%</span>
		        </p>
		        <p class="text-center" style="line-height: 20px;font-size: 12px;color: #999;margin-top: -30px;">预期年收益</p>
		        <hr>
		         <p class="text-center" style="font-size: 14px;line-height:45px; color: #fff;cursor: pointer;background-color: #ff721f;">立即购买</p>
		      </div>
		    </div>
		  </div>
		</div>
	</div>
	
	<!-- 精品推荐 -->
    <div class="container" style="margin-top: 20px;">
    	<h3>精品推荐</h3>
	    <div class="row">
		  <div class="col-md-3">
		    <div class="thumbnail">
		      <div class="caption">
		        <p class="text-center" style="color: #333;font-style: normal;">12个月</p>
		        <hr>
		        <p class="text-center">
		        	<span style="line-height: 50px;font-size: 48px;color: #ff721f;">8.9</span>
		        	<span style="font-size: 12px;line-height: 70px;color: #ff721f;font-style: normal">%</span>
		        </p>
		        <p class="text-center" style="line-height: 20px;font-size: 12px;color: #999;margin-top: -30px;">预期年收益</p>
		        <hr>
		        <p class="text-center" style="font-size: 14px;color: #ff721f;cursor: pointer;">查看详情</p>
		      </div>
		    </div>
		  </div>
		  <div class="col-md-3">
		    <div class="thumbnail">
		      <div class="caption">
		        <p class="text-center" style="color: #333;font-style: normal;">6个月</p>
		        <hr>
		        <p class="text-center">
		        	<span style="line-height: 50px;font-size: 48px;color: #ff721f;">7.8</span>
		        	<span style="font-size: 12px;line-height: 70px;color: #ff721f;font-style: normal">%</span>
		        </p>
		        <p class="text-center" style="line-height: 20px;font-size: 12px;color: #999;margin-top: -30px;">预期年收益</p>
		        <hr>
		        <p class="text-center" style="font-size: 14px;color: #ff721f;cursor: pointer;">查看详情</p>
		      </div>
		    </div>
		  </div>
		  <div class="col-md-3">
		    <div class="thumbnail">
		      <div class="caption">
		        <p class="text-center" style="color: #333;font-style: normal;">9个月</p>
		        <hr>
		        <p class="text-center">
		        	<span style="line-height: 50px;font-size: 48px;color: #ff721f;">5.9</span>
		        	<span style="font-size: 12px;line-height: 70px;color: #ff721f;font-style: normal">%</span>
		        </p>
		        <p class="text-center" style="line-height: 20px;font-size: 12px;color: #999;margin-top: -30px;">预期年收益</p>
		        <hr>
		        <p class="text-center" style="font-size: 14px;color: #ff721f;cursor: pointer;">查看详情</p>
		      </div>
		    </div>
		  </div>
		  <div class="col-md-3">
		    <div class="thumbnail">
		      <div class="caption">
		        <p class="text-center" style="color: #333;font-style: normal;">2个月</p>
		        <hr>
		        <p class="text-center">
		        	<span style="line-height: 50px;font-size: 48px;color: #ff721f;">3.2</span>
		        	<span style="font-size: 12px;line-height: 70px;color: #ff721f;font-style: normal">%</span>
		        </p>
		        <p class="text-center" style="line-height: 20px;font-size: 12px;color: #999;margin-top: -30px;">预期年收益</p>
		        <hr>
		        <p class="text-center" style="font-size: 14px;color: #ff721f;cursor: pointer;">查看详情</p>
		      </div>
		    </div>
		  </div>
		</div>
	</div>
	
	<!-- 人气推荐 -->
    <div class="container" style="margin-top: 20px;">
    	<h3>人气推荐</h3>
	    <div class="row">
		  <div class="col-md-3">
		    <div class="thumbnail">
		      <div class="caption">
		        <p class="text-center" style="color: #333;font-style: normal;">12个月</p>
		        <hr>
		        <p class="text-center">
		        	<span style="line-height: 50px;font-size: 48px;color: #ff721f;">8.9</span>
		        	<span style="font-size: 12px;line-height: 70px;color: #ff721f;font-style: normal">%</span>
		        </p>
		        <p class="text-center" style="line-height: 20px;font-size: 12px;color: #999;margin-top: -30px;">预期年收益</p>
		        <hr>
		        <p class="text-center" style="font-size: 14px;color: #ff721f;cursor: pointer;">查看详情</p>
		      </div>
		    </div>
		  </div>
		  <div class="col-md-3">
		    <div class="thumbnail">
		      <div class="caption">
		        <p class="text-center" style="color: #333;font-style: normal;">6个月</p>
		        <hr>
		        <p class="text-center">
		        	<span style="line-height: 50px;font-size: 48px;color: #ff721f;">7.8</span>
		        	<span style="font-size: 12px;line-height: 70px;color: #ff721f;font-style: normal">%</span>
		        </p>
		        <p class="text-center" style="line-height: 20px;font-size: 12px;color: #999;margin-top: -30px;">预期年收益</p>
		        <hr>
		        <p class="text-center" style="font-size: 14px;color: #ff721f;cursor: pointer;">查看详情</p>
		      </div>
		    </div>
		  </div>
		  <div class="col-md-3">
		    <div class="thumbnail">
		      <div class="caption">
		        <p class="text-center" style="color: #333;font-style: normal;">9个月</p>
		        <hr>
		        <p class="text-center">
		        	<span style="line-height: 50px;font-size: 48px;color: #ff721f;">5.9</span>
		        	<span style="font-size: 12px;line-height: 70px;color: #ff721f;font-style: normal">%</span>
		        </p>
		        <p class="text-center" style="line-height: 20px;font-size: 12px;color: #999;margin-top: -30px;">预期年收益</p>
		        <hr>
		        <p class="text-center" style="font-size: 14px;color: #ff721f;cursor: pointer;">查看详情</p>
		      </div>
		    </div>
		  </div>
		  <div class="col-md-3">
		    <div class="thumbnail">
		      <div class="caption">
		        <p class="text-center" style="color: #333;font-style: normal;">2个月</p>
		        <hr>
		        <p class="text-center">
		        	<span style="line-height: 50px;font-size: 48px;color: #ff721f;">3.2</span>
		        	<span style="font-size: 12px;line-height: 70px;color: #ff721f;font-style: normal">%</span>
		        </p>
		        <p class="text-center" style="line-height: 20px;font-size: 12px;color: #999;margin-top: -30px;">预期年收益</p>
		        <hr>
		        <p class="text-center" style="font-size: 14px;color: #ff721f;cursor: pointer;">查看详情</p>
		      </div>
		    </div>
		  </div>
		</div>
		<div class="row">
		  <div class="col-md-3">
		    <div class="thumbnail">
		      <div class="caption">
		        <p class="text-center" style="color: #333;font-style: normal;">10个月</p>
		        <hr>
		        <p class="text-center">
		        	<span style="line-height: 50px;font-size: 48px;color: #ff721f;">6.9</span>
		        	<span style="font-size: 12px;line-height: 70px;color: #ff721f;font-style: normal">%</span>
		        </p>
		        <p class="text-center" style="line-height: 20px;font-size: 12px;color: #999;margin-top: -30px;">预期年收益</p>
		        <hr>
		        <p class="text-center" style="font-size: 14px;color: #ff721f;cursor: pointer;">查看详情</p>
		      </div>
		    </div>
		  </div>
		  <div class="col-md-3">
		    <div class="thumbnail">
		      <div class="caption">
		        <p class="text-center" style="color: #333;font-style: normal;">11个月</p>
		        <hr>
		        <p class="text-center">
		        	<span style="line-height: 50px;font-size: 48px;color: #ff721f;">7.3</span>
		        	<span style="font-size: 12px;line-height: 70px;color: #ff721f;font-style: normal">%</span>
		        </p>
		        <p class="text-center" style="line-height: 20px;font-size: 12px;color: #999;margin-top: -30px;">预期年收益</p>
		        <hr>
		        <p class="text-center" style="font-size: 14px;color: #ff721f;cursor: pointer;">查看详情</p>
		      </div>
		    </div>
		  </div>
		  <div class="col-md-3">
		    <div class="thumbnail">
		      <div class="caption">
		        <p class="text-center" style="color: #333;font-style: normal;">5个月</p>
		        <hr>
		        <p class="text-center">
		        	<span style="line-height: 50px;font-size: 48px;color: #ff721f;">5.6</span>
		        	<span style="font-size: 12px;line-height: 70px;color: #ff721f;font-style: normal">%</span>
		        </p>
		        <p class="text-center" style="line-height: 20px;font-size: 12px;color: #999;margin-top: -30px;">预期年收益</p>
		        <hr>
		        <p class="text-center" style="font-size: 14px;color: #ff721f;cursor: pointer;">查看详情</p>
		      </div>
		    </div>
		  </div>
		  <div class="col-md-3">
		    <div class="thumbnail">
		      <div class="caption">
		        <p class="text-center" style="color: #333;font-style: normal;">8个月</p>
		        <hr>
		        <p class="text-center">
		        	<span style="line-height: 50px;font-size: 48px;color: #ff721f;">9.0</span>
		        	<span style="font-size: 12px;line-height: 70px;color: #ff721f;font-style: normal">%</span>
		        </p>
		        <p class="text-center" style="line-height: 20px;font-size: 12px;color: #999;margin-top: -30px;">预期年收益</p>
		        <hr>
		        <p class="text-center" style="font-size: 14px;color: #ff721f;cursor: pointer;">查看详情</p>
		      </div>
		    </div>
		  </div>
		</div>
	</div>
	
	<!-- 新品推荐 -->
    <div class="container" style="margin-top: 20px;">
    	<h3>新品推荐</h3>
	    <div class="row">
		  <div class="col-md-3">
		    <div class="thumbnail">
		      <div class="caption">
		        <p class="text-center" style="color: #333;font-style: normal;">12个月</p>
		        <hr>
		        <p class="text-center">
		        	<span style="line-height: 50px;font-size: 48px;color: #ff721f;">8.9</span>
		        	<span style="font-size: 12px;line-height: 70px;color: #ff721f;font-style: normal">%</span>
		        </p>
		        <p class="text-center" style="line-height: 20px;font-size: 12px;color: #999;margin-top: -30px;">预期年收益</p>
		        <hr>
		        <p class="text-center" style="font-size: 14px;color: #ff721f;cursor: pointer;">查看详情</p>
		      </div>
		    </div>
		  </div>
		  <div class="col-md-3">
		    <div class="thumbnail">
		      <div class="caption">
		        <p class="text-center" style="color: #333;font-style: normal;">6个月</p>
		        <hr>
		        <p class="text-center">
		        	<span style="line-height: 50px;font-size: 48px;color: #ff721f;">7.8</span>
		        	<span style="font-size: 12px;line-height: 70px;color: #ff721f;font-style: normal">%</span>
		        </p>
		        <p class="text-center" style="line-height: 20px;font-size: 12px;color: #999;margin-top: -30px;">预期年收益</p>
		        <hr>
		        <p class="text-center" style="font-size: 14px;color: #ff721f;cursor: pointer;">查看详情</p>
		      </div>
		    </div>
		  </div>
		  <div class="col-md-3">
		    <div class="thumbnail">
		      <div class="caption">
		        <p class="text-center" style="color: #333;font-style: normal;">9个月</p>
		        <hr>
		        <p class="text-center">
		        	<span style="line-height: 50px;font-size: 48px;color: #ff721f;">5.9</span>
		        	<span style="font-size: 12px;line-height: 70px;color: #ff721f;font-style: normal">%</span>
		        </p>
		        <p class="text-center" style="line-height: 20px;font-size: 12px;color: #999;margin-top: -30px;">预期年收益</p>
		        <hr>
		        <p class="text-center" style="font-size: 14px;color: #ff721f;cursor: pointer;">查看详情</p>
		      </div>
		    </div>
		  </div>
		  <div class="col-md-3">
		    <div class="thumbnail">
		      <div class="caption">
		        <p class="text-center" style="color: #333;font-style: normal;">2个月</p>
		        <hr>
		        <p class="text-center">
		        	<span style="line-height: 50px;font-size: 48px;color: #ff721f;">3.2</span>
		        	<span style="font-size: 12px;line-height: 70px;color: #ff721f;font-style: normal">%</span>
		        </p>
		        <p class="text-center" style="line-height: 20px;font-size: 12px;color: #999;margin-top: -30px;">预期年收益</p>
		        <hr>
		        <p class="text-center" style="font-size: 14px;color: #ff721f;cursor: pointer;">查看详情</p>
		      </div>
		    </div>
		  </div>
		</div>
		<div class="row">
		  <div class="col-md-3">
		    <div class="thumbnail">
		      <div class="caption">
		        <p class="text-center" style="color: #333;font-style: normal;">10个月</p>
		        <hr>
		        <p class="text-center">
		        	<span style="line-height: 50px;font-size: 48px;color: #ff721f;">6.9</span>
		        	<span style="font-size: 12px;line-height: 70px;color: #ff721f;font-style: normal">%</span>
		        </p>
		        <p class="text-center" style="line-height: 20px;font-size: 12px;color: #999;margin-top: -30px;">预期年收益</p>
		        <hr>
		        <p class="text-center" style="font-size: 14px;color: #ff721f;cursor: pointer;">查看详情</p>
		      </div>
		    </div>
		  </div>
		  <div class="col-md-3">
		    <div class="thumbnail">
		      <div class="caption">
		        <p class="text-center" style="color: #333;font-style: normal;">11个月</p>
		        <hr>
		        <p class="text-center">
		        	<span style="line-height: 50px;font-size: 48px;color: #ff721f;">7.3</span>
		        	<span style="font-size: 12px;line-height: 70px;color: #ff721f;font-style: normal">%</span>
		        </p>
		        <p class="text-center" style="line-height: 20px;font-size: 12px;color: #999;margin-top: -30px;">预期年收益</p>
		        <hr>
		        <p class="text-center" style="font-size: 14px;color: #ff721f;cursor: pointer;">查看详情</p>
		      </div>
		    </div>
		  </div>
		  <div class="col-md-3">
		    <div class="thumbnail">
		      <div class="caption">
		        <p class="text-center" style="color: #333;font-style: normal;">5个月</p>
		        <hr>
		        <p class="text-center">
		        	<span style="line-height: 50px;font-size: 48px;color: #ff721f;">5.6</span>
		        	<span style="font-size: 12px;line-height: 70px;color: #ff721f;font-style: normal">%</span>
		        </p>
		        <p class="text-center" style="line-height: 20px;font-size: 12px;color: #999;margin-top: -30px;">预期年收益</p>
		        <hr>
		        <p class="text-center" style="font-size: 14px;color: #ff721f;cursor: pointer;">查看详情</p>
		      </div>
		    </div>
		  </div>
		  <div class="col-md-3">
		    <div class="thumbnail">
		      <div class="caption">
		        <p class="text-center" style="color: #333;font-style: normal;">8个月</p>
		        <hr>
		        <p class="text-center">
		        	<span style="line-height: 50px;font-size: 48px;color: #ff721f;">9.0</span>
		        	<span style="font-size: 12px;line-height: 70px;color: #ff721f;font-style: normal">%</span>
		        </p>
		        <p class="text-center" style="line-height: 20px;font-size: 12px;color: #999;margin-top: -30px;">预期年收益</p>
		        <hr>
		        <p class="text-center" style="font-size: 14px;color: #ff721f;cursor: pointer;">查看详情</p>
		      </div>
		    </div>
		  </div>
		</div>
		
		<hr>
	</div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="${pageContext.request.contextPath}/static/jquery/1.12.4/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/unslider.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${pageContext.request.contextPath}/static/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui/1.5.1/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui/1.5.1/locale/easyui-lang-zh_CN.js"></script>
 	
 	<script type="text/javascript">
 	$(function() {
 		$.getJSON('${pageContext.request.contextPath}/index/data', function(data){
 			// 获取收益推荐数据(top_3_expect_rate)
 			if(data.TOP_EXPECT_RATE){
 				var d = data.TOP_EXPECT_RATE;
 				var html = '';
 				$.each(d,function(i, n){
 					var item = '<div class="col-md-4">'+
				 				    '<div class="thumbnail">'+
				 			      '<div class="caption">'+
				 			        '<p class="text-center" style="color: #333;font-style: normal;">'+n.productTerm+'天可赎回</p>'+
				 			        '<hr>'+
				 			        '<p class="text-center">'+
				 			        	'<span style="line-height: 60px;font-size: 55px;color: #ff721f;">'+n.expectRate+'</span>'+
				 			        	'<span style="font-size: 12px;line-height: 70px;color: #ff721f;font-style: normal">%</span>'+
				 			        '</p>'+
				 			        '<p class="text-center" style="line-height: 20px;font-size: 12px;color: #999;margin-top: -30px;">预期年收益</p>'+
				 			        '<hr>'+
				 			         '<p class="text-center" style="font-size: 14px;line-height:45px; color: #fff;cursor: pointer;background-color: #ff721f;">立即购买</p>'+
				 			      '</div>'+
				 			    '</div>'+
				 			  '</div>'
				 	html += item;
 				});
 				$('#topExpectRate').empty().append(html);
 			}
 		});
 	});

 	</script>
 
  </body>
</html>