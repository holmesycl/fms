<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
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
		<c:forEach var="row" items="${uesrProducts.rows }" varStatus="status">
			<c:set var="template">
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
			</c:set>
			<%-- <c:set var="prefixRow" value="<div class="row" id="topExpectRate">"></c:set>
			<c:set var="suffixRow" value="</div>"></c:set> --%>
			
			<c:choose>
				<c:when test="${status.count % 3 == 1 }">
					<%-- <c:out value="${prefixRow }"/> --%>
					<c:out value="${template }"/>
				</c:when>
				<c:when test="${status.count % 3 == 0 }">
					<c:out value="${template }"/>
					<%-- <c:out value="${suffixRow }"/> --%>
				</c:when>
				<c:otherwise>
					<c:out value="${template }"/>
				</c:otherwise>
			</c:choose>
			<%-- <div class="panel panel-default">
			  <div class="panel-heading">
			  	<p><span><fmt:formatDate value="${row.createDate }" pattern="yyyy-MM-dd HH:mm:ss" /></span></p>
			  </div>
			  <div class="panel-body">
			    <p>${row.productName }</p>
			    <p>
			    	<span><fmt:formatDate value="${row.effectiveDate }" pattern="yyyy-MM-dd HH:mm:ss" /></span>
			    	 - 
			    	<span><fmt:formatDate value="${row.expireDate }" pattern="yyyy-MM-dd HH:mm:ss" /></span>
			    
			    </p>
			  </div>
			</div>
			<hr> --%>
		</c:forEach>
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