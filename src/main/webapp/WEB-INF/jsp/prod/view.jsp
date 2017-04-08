<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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
			
		  	<h3 style="font-size: 20px;color: #848484;">${product.productName }</h3>
			<hr>
			<div class="row">
				<div class="col-md-3">
				<p>
					<span style="font-size: 40px;font-family: HelveticaNeueLt;color: #ff721f;">
						<fmt:formatNumber value="${product.expectRate * 100 }" pattern="#.00#"/>
					</span>
					<span style="font-size: 26px;color: #ff721f;">%</span>
				</p>
				<p style="color: #848484;">预期年收益</p>
				</div>
				
				<div class="col-md-3">
					<p>
						<span style="font-size: 40px;font-family: HelveticaNeueLt;">${product.productTerm }</span>
						<span style="font-size: 26px;">天</span>
					</p>
					<p style="color: #848484;">投资期限</p>
				</div>
				
				<div class="col-md-3">
					<p>
						<span style="font-size: 40px;font-family: HelveticaNeueLt;">${product.limitStartAmount }</span>
						<span style="font-size: 26px;">元</span>
					</p>
					<p style="color: #848484;">起购金额</p>
				</div>
				
				<div class="col-md-3">
					<p>
						<span style="font-size: 40px;font-family: HelveticaNeueLt;">${product.limitEndAmount }</span>
						<span style="font-size: 26px;">元</span>
					</p>
					<p style="color: #848484;">最大限额</p>
				</div>
			</div>
			<hr>
			<form class="form-inline pull-right" method="post" action="${pageContext.request.contextPath}/order/purchase">
			 <div class="form-group sr-only">
			    <label class="sr-only" for="inputProductId">产品ID</label>
			    <input type="text" class="form-control" name="productId" value="${product.productId }" id="inputProductId" placeholder="购买金额">
			  </div>
			  <div class="form-group">
			    <label class="sr-only" for="inputPurchaseAmount">购买金额</label>
			    <div class="input-group">
			      <div class="input-group-addon">￥</div>
			      <input type="number" class="form-control" name="purchaseAmount" id="inputPurchaseAmount" placeholder="购买金额">
			      <div class="input-group-addon">元</div>
			    </div>
			  </div>
			  <button type="submit" class="btn btn-primary">购买</button>
			</form>

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