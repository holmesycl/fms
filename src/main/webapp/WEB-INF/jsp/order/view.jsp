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
	
	<jsp:include page="../nav.jsp"/>
	
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="row">
					<div class="col-md-2"><label>订单编号</label></div>		
					<div>
						<p>${order.orderNumber }</p>
					</div>
				</div>
				<div class="row">
					<div class="col-md-2"><label>创建时间</label></div>		
					<div>
						<p><fmt:formatDate value="${order.createDate }" pattern="yyyy-MM-dd HH:mm:ss"/></p>
					</div>
				</div>
				<div class="row">
					<div class="col-md-2"><label>用户操作</label></div>		
					<div>
						<p>${order.businessName }</p>
					</div>
				</div>
				<div class="row">
					<div class="col-md-2"><label>产品名称</label></div>		
					<div>
						<p>${order.productName }</p>
					</div>
				</div> 	
				<div class="row">
					<div class="col-md-2"><label>产品金额</label></div>		
					<div>
						<p>${order.amount / 100 } 元</p>
					</div>
				</div>
				<div class="row">
					<div class="col-md-2"><label>生效时间</label></div>		
					<div>
						<p><fmt:formatDate value="${order.effectiveDate }" pattern="yyyy-MM-dd HH:mm:ss"/></p>
					</div>
				</div>
				<div class="row">
					<div class="col-md-2"><label>失效时间</label></div>		
					<div>
						<p><fmt:formatDate value="${order.expireDate }" pattern="yyyy-MM-dd HH:mm:ss"/></p>
					</div>
				</div>
				<div class="row">
					<div class="col-md-2"><label>状态</label></div>		
					<div>
						<p>成功</p>
					</div>
				</div>
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