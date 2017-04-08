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
		<c:choose>
			<c:when test="${incomeDetails.size() == 0 }">
				<p>暂无收益.</p>
			</c:when>
			<c:otherwise>
				<table class="table table-hover">
					<caption>${incomeDetails.get(0).productName }</caption>
					<thead>
						<tr>
							<th>收益时间</th>
							<th>收益状态</th>
							<th>收益（元）</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="row" items="${incomeDetails }" varStatus="status">
							<c:set var="_class">
								<c:choose>
									<c:when test="${row.type == 1 }">success</c:when>
									<c:when test="${row.type == 2 }">active</c:when>
								</c:choose>
							</c:set>
							<tr class="${_class }">
								<td><fmt:formatDate value="${row.createDate }" pattern="yyyy-MM-dd" /></td>
							  	<td>${row.typeName }</td>
							  	<td>
							  		<fmt:formatNumber value="${row.amount / 100 }" pattern="#,#00.00#"/>
							  	</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<hr>
			</c:otherwise>
		</c:choose>
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