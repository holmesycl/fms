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
	p{
		height: 40px;
		font-size: 15px;
		line-height: 40px;
	}
	
	p label{
		margin-left: 5px;
		width: 100px;
	}
	
	</style>
  </head>
  <body>
	
	<jsp:include page="../nav.jsp"/>
	
	<div class="container">
	
		<ol class="breadcrumb">
		  <li><a href="${pageContext.request.contextPath}/index">首页</a></li>
		  <li><a href="#" onclick="history.back();">购买理财产品</a></li>
		  <li class="active">订单详情</li>
		</ol>
		
		<h3>订购订单详情</h3>
		<hr>
		
		<p class="bg-success"><label>用户操作</label>${order.businessName }</p>
		<p class="bg-success"><label>购买状态</label>成功</p>
		
		<p class="bg-info"><label>订单编号</label> ${order.orderNumber }</p>
		
		<p class="bg-info"><label>购买时间</label> <fmt:formatDate value="${order.createDate }" pattern="yyyy-MM-dd HH:mm:ss"/></p>

		<p class="bg-info"><label>操作人员</label><shiro:principal/></p>
		
		<p class="bg-info"><label>购买金额</label> <fmt:formatNumber value="${order.amount / 100 }" pattern="#,##0.00#"/>元</p>
		
		<p class="bg-info"><label>产品名称</label>${order.productName }</p>
		
		<p class="bg-info"><label>收益开始时间</label><fmt:formatDate value="${order.effectiveDate }" pattern="yyyy-MM-dd"/></p>
		
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