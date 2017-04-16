<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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
    </div>
     <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="${pageContext.request.contextPath}/index"><span style="color:#ff721f;"><span class="glyphicon glyphicon-home" aria-hidden="true">首页</span></span> <span class="sr-only">(current)</span></a></li>
       <!--  <li><a href="#">Link</a></li> -->
      </ul>
      <ul class="nav navbar-nav navbar-right">
      	<shiro:authenticated>
      		<li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-user" aria-hidden="true"><shiro:principal/></span><span class="caret"></span></a>
	          <ul class="dropdown-menu">
	          	 <li><a href="${pageContext.request.contextPath}/home"><span class="glyphicon glyphicon-piggy-bank" aria-hidden="true">我的理财</span></a></li>
	             <li><a href="${pageContext.request.contextPath}/s/logout"><span class="glyphicon glyphicon-log-out" aria-hidden="true">退出登录</span></a></li>
	          </ul>
	        </li>
      	</shiro:authenticated>
      	<%-- <shiro:notAuthenticated>
      		<li><a href="${pageContext.request.contextPath}/signup">没有账号？点击注册</a></li>
      	</shiro:notAuthenticated> --%>
      	<shiro:notAuthenticated>
      		<li><a href="${pageContext.request.contextPath}/s/login">已有账号？点击登录</a></li>
      	</shiro:notAuthenticated>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>