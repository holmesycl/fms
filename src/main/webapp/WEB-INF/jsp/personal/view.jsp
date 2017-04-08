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
		
	    <h3>${userProduct.productName }</h3>
	  	<hr>
	  	<div class="row">
	  		<div class="col-md-3">
	  			<p class="item text-right">理财方式</p>
	  		</div>
	  		<div class="col-md-9">
	  			<p class="item">${userProduct.termName }理财</p>
	  		</div>
	  	</div>
	  	<div class="row">
	  		<div class="col-md-3">
	  			<p class="item text-right">总金额（元）</p>
	  		</div>
	  		<div class="col-md-9">
	  			<p class="item">
	  				<fmt:formatNumber value="${userProduct.amount / 100 }" pattern="#,#00.00#"/>
	  			</p>
	  		</div>
	  	</div>
	  	<div class="row">
	  		<div class="col-md-3">
	  			<p class="item text-right">购买时间</p>
	  		</div>
	  		<div class="col-md-9">
	  			<p class="item"><fmt:formatDate value="${userProduct.createDate }" pattern="yyyy-MM-dd HH:mm:ss"/></p>
	  		</div>
	  	</div>
	  	<div class="row">
	  		<div class="col-md-3">
	  			<p class="item text-right">开始计算收益时间</p>
	  		</div>
	  		<div class="col-md-9">
	  			<p class="item"><fmt:formatDate value="${userProduct.effectiveDate }" pattern="yyyy-MM-dd"/></p>
	  		</div>
	  	</div>
	  	<div class="row">
	  		<div class="col-md-3">
	  			<p class="item text-right">到期时间</p>
	  		</div>
	  		<div class="col-md-9">
	  			<p class="item">${userProduct.endDate }</p>
	  		</div>
	  	</div>
	  	<div class="row">
	  		<div class="col-md-3">
	  			<p class="item text-right">累计收益（元）</p>
	  		</div>
	  		<div class="col-md-9">
	  			<p class="item">
	  				<fmt:formatNumber value="${userProduct.income / 100 }" pattern="#,#00.00#"/>
	  				<a class="btn btn-warning" style="margin-left: 20px;" href="${pageContext.request.contextPath}/income/detail/${userProduct.productId }">收益详情</a>
	  			</p>
	  		</div>
	  	</div>
	  	<hr>
	  	
  		<h3>赎回理财产品</h3>
	  	<hr>
	  	<div class="row">
	  		<div class="col-md-3">
	  			<p class="item text-right">赎回限制</p>
	  		</div>
	  		<div class="col-md-9">
	  			<p class="item">${userProduct.pedeemLimit }</p>
	  		</div>
	  	</div>

	  	<div class="row">
	  		<form id="ff" class="form-inline" action="${pageContext.request.contextPath}/order/pedeem/${userProduct.productId }" method="post">
			  	<div class="form-group sr-only">
			    	<input type="text" class="form-control" name="userProductId" id="inputUserProductId" value="${userProduct.userProductId }">
			  	</div>
			  	<div class="form-group col-md-3">
			    	<label for="inputProductName" class="sr-only">金额</label>
			    	<input type="text" class="form-control input-lg" name="amount" id="inputProductName" placeholder="输入赎回金额/元">
			  	</div>
			  	<c:if test="${userProduct.canPedeem == 2 }">
			  		<div class="form-group col-md-9">
				      	<button type="submit" class="btn btn-danger btn-lg" disabled="disabled">不可赎回</button>
				  	</div>
			  	</c:if>
			  	<c:if test="${userProduct.canPedeem == 1 }">
			  		<div class="form-group col-md-9">
				      	<button type="submit" class="btn btn-danger btn-lg">赎回</button>
				  	</div>
			  	</c:if>
			</form>
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