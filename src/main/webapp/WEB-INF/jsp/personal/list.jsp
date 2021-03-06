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
		
		<ol class="breadcrumb">
		  <li class="active">我的产品</li>
		</ol>
	
		<table class="table table-hover table-striped">
			<thead>
				<tr>
					<th>理财产品</th>
					<th>总金额（元）</th>
					<th>昨日收益（元）</th>
					<th>总收益（元）</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="row" items="${uesrProducts.rows }" varStatus="status">
					<tr>
						<td>${row.productName }</td>
					  	<td><fmt:formatNumber value="${row.amount / 100 }" pattern="#,##0.00#"/></td>
					  	<td><fmt:formatNumber value="${row.yesterdayIncome / 100 }" pattern="#,##0.00#"/></td>
					  	<td><fmt:formatNumber value="${row.income / 100 }" pattern="#,##0.00#"/></td>
					  	<td><a class="btn btn-default" href="${pageContext.request.contextPath}/personal/product/${row.userProductId }">详情</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
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