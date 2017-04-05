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
	<style type="text/css">
	.item{
		line-height: 50px;
		font-size: 20px;
	}
	
	</style>
  </head>
  <body>
	
	<div class="container">
		
	    <h3>${uesrProduct.productName }</h3>
	  	<hr>
	  	<div class="row">
	  		<div class="col-md-3">
	  			<p class="item text-right">订单编号</p>
	  		</div>
	  		<div class="col-md-9">
	  			<p class="item">${uesrProduct.userProductId }</p>
	  		</div>
	  	</div>
	  	<div class="row">
	  		<div class="col-md-3">
	  			<p class="item text-right">购买金额</p>
	  		</div>
	  		<div class="col-md-9">
	  			<p class="item">${uesrProduct.amount }元</p>
	  		</div>
	  	</div>
	  	<div class="row">
	  		<div class="col-md-3">
	  			<p class="item text-right">购买时间</p>
	  		</div>
	  		<div class="col-md-9">
	  			<p class="item"><fmt:formatDate value="${uesrProduct.createDate }" pattern="yyyy-MM-dd HH:mm:ss"/></p>
	  		</div>
	  	</div>
	  	<div class="row">
	  		<div class="col-md-3">
	  			<p class="item text-right">开始计算收益时间</p>
	  		</div>
	  		<div class="col-md-9">
	  			<p class="item"><fmt:formatDate value="${uesrProduct.effectiveDate }" pattern="yyyy-MM-dd"/></p>
	  		</div>
	  	</div>
	  	<div class="row">
	  		<div class="col-md-3">
	  			<p class="item text-right">截止计算收益时间</p>
	  		</div>
	  		<div class="col-md-9">
	  			<p class="item"><fmt:formatDate value="${uesrProduct.expireDate }" pattern="yyyy-MM-dd"/></p>
	  		</div>
	  	</div>
	  	<div class="row">
	  		<div class="col-md-3">
	  			<p class="item text-right">已产生收益</p>
	  		</div>
	  		<div class="col-md-9">
	  			<p class="item">0元<a class="btn btn-warning" style="margin-left: 20px;">收益详情</a></p>
	  		</div>
	  	</div>
	  	<hr>
	  	<div class="row">
	  		<div class="col-md-3">
	  			<p class="text-right"><a class="btn btn-danger btn-lg">赎回</a></p>
	  		</div>
	  	</div>

	</div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="${pageContext.request.contextPath}/static/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${pageContext.request.contextPath}/static/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui/1.5.1/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui/1.5.1/locale/easyui-lang-zh_CN.js"></script>
 	
 	<script type="text/javascript">
 		
 	</script>
 
  </body>
</html>