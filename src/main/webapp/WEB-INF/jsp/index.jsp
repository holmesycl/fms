<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  
  	<jsp:include page="nav.jsp"/>
  	
  	<shiro:notAuthenticated>
		<div style="width: 100%;height: 350px;background-color: #ff4e4a;margin-top: -20px;">
			<div class="container">
				<div class="row">
					<div class="col-md-5 col-md-offset-7">
						<div class="panel panel-default" style="margin-top: 30px;">
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
    </shiro:notAuthenticated>
    <!-- 收益推荐 -->
    <div class="container" style="margin-top: 20px;">
    	<h3>收益推荐</h3>
    	<div class="row">
    	<c:forEach var="item" items="${data['topExpectRateProducts'] }">
    		<div class="col-md-4">
			    <div class="thumbnail">
			      <div class="caption">
			        <p class="text-center" style="color: #333;font-style: normal;">${item.productName }</p>
			        <hr>
			        <p class="text-center">
			        	<span style="line-height: 60px;font-size: 55px;color: #ff721f;"><fmt:formatNumber value="${item.expectRate * 100 }" pattern="#,##0.00"/></span>
			        	<span style="font-size: 12px;line-height: 70px;color: #ff721f;font-style: normal">%</span>
			        </p>
			        <p class="text-center" style="line-height: 20px;font-size: 12px;color: #999;margin-top: -30px;">预期年收益</p>
			        <hr>
			         <p data-product="${item.productId }" class="text-center view" style="font-size: 14px;line-height:45px; color: #fff;cursor: pointer;background-color: #ff721f;">立即购买</p>
			      </div>
			    </div>
		  	</div>
    	</c:forEach>
    	</div>
	</div>
	
	<!-- 精品推荐 -->
    <div class="container" style="margin-top: 20px;">
    	<h3>精品推荐</h3>
	    <div class="row" id="topRealRate">
	    <c:forEach var="item" items="${data['topRealRateProducts'] }">
	      <div class="col-md-3">
		    <div class="thumbnail">
		      <div class="caption">
		        <p class="text-center" style="color: #333;font-style: normal;">${item.productName }</p>
		        <hr>
		        <p class="text-center">
		        	<span style="line-height: 50px;font-size: 48px;color: #ff721f;"><fmt:formatNumber value="${item.expectRate * 100 }" pattern="#,##0.00"/></span>
		        	<span style="font-size: 12px;line-height: 70px;color: #ff721f;font-style: normal">%</span>
		        </p>
		        <p class="text-center" style="line-height: 20px;font-size: 12px;color: #999;margin-top: -30px;">预期年收益</p>
		        <hr>
		        <p data-product="${item.productId }" class="text-center view" style="font-size: 14px;color: #ff721f;cursor: pointer;">立即购买</p>
		      </div>
		    </div>
		  </div>
	    </c:forEach>
		</div>
	</div>
	
	<!-- 人气推荐 -->
    <div class="container" style="margin-top: 20px;">
    	<h3>人气推荐</h3>
    	<div class="row">
    	<c:forEach var="item" items="${data['topPopuProducts'] }" varStatus="status">
    		<c:if test="${status.count <= 4 }">
    			<div class="col-md-3">
				    <div class="thumbnail">
				      <div class="caption">
				        <p class="text-center" style="color: #333;font-style: normal;">${item.productName }</p>
				        <hr>
				        <p class="text-center">
				        	<span style="line-height: 50px;font-size: 48px;color: #ff721f;"><fmt:formatNumber value="${item.expectRate * 100 }" pattern="#,##0.00"/></span>
				        	<span style="font-size: 12px;line-height: 70px;color: #ff721f;font-style: normal">%</span>
				        </p>
				        <p class="text-center" style="line-height: 20px;font-size: 12px;color: #999;margin-top: -30px;">预期年收益</p>
				        <hr>
				        <p data-product="${item.productId }" class="text-center view" style="font-size: 14px;color: #ff721f;cursor: pointer;">立即购买</p>
				      </div>
				    </div>
				</div>
    		</c:if>
    	</c:forEach>
    	</div>
    	<div class="row" id="topPopu">
    	<c:forEach var="item" items="${data['topPopuProducts'] }" varStatus="status">
    		<c:if test="${status.count > 4 }">
    			<div class="col-md-3">
				    <div class="thumbnail">
				      <div class="caption">
				        <p class="text-center" style="color: #333;font-style: normal;">${item.productName }</p>
				        <hr>
				        <p class="text-center">
				        	<span style="line-height: 50px;font-size: 48px;color: #ff721f;"><fmt:formatNumber value="${item.expectRate * 100 }" pattern="#,##0.00"/></span>
				        	<span style="font-size: 12px;line-height: 70px;color: #ff721f;font-style: normal">%</span>
				        </p>
				        <p class="text-center" style="line-height: 20px;font-size: 12px;color: #999;margin-top: -30px;">预期年收益</p>
				        <hr>
				        <p data-product="${item.productId }" class="text-center view" style="font-size: 14px;color: #ff721f;cursor: pointer;">立即购买</p>
				      </div>
				    </div>
				</div>
    		</c:if>
    	</c:forEach>
    	</div>
	</div>
	
	<!-- 新品推荐 -->
    <div class="container" style="margin-top: 20px;">
    	<h3>新品推荐</h3>
	    <div class="row">
    	<c:forEach var="item" items="${data['topNewProducts'] }" varStatus="status">
    		<c:if test="${status.count <= 4 }">
    			<div class="col-md-3">
				    <div class="thumbnail">
				      <div class="caption">
				        <p class="text-center" style="color: #333;font-style: normal;">${item.productName }</p>
				        <hr>
				        <p class="text-center">
				        	<span style="line-height: 50px;font-size: 48px;color: #ff721f;"><fmt:formatNumber value="${item.expectRate * 100 }" pattern="#,##0.00"/></span>
				        	<span style="font-size: 12px;line-height: 70px;color: #ff721f;font-style: normal">%</span>
				        </p>
				        <p class="text-center" style="line-height: 20px;font-size: 12px;color: #999;margin-top: -30px;">预期年收益</p>
				        <hr>
				        <p data-product="${item.productId }" class="text-center view" style="font-size: 14px;color: #ff721f;cursor: pointer;">立即购买</p>
				      </div>
				    </div>
				</div>
    		</c:if>
    	</c:forEach>
    	</div>
    	<div class="row" id="topPopu">
    	<c:forEach var="item" items="${data['topNewProducts'] }" varStatus="status">
    		<c:if test="${status.count > 4 }">
    			<div class="col-md-3">
				    <div class="thumbnail">
				      <div class="caption">
				        <p class="text-center" style="color: #333;font-style: normal;">${item.productName }</p>
				        <hr>
				        <p class="text-center">
				        	<span style="line-height: 50px;font-size: 48px;color: #ff721f;"><fmt:formatNumber value="${item.expectRate * 100 }" pattern="#,##0.00"/></span>
				        	<span style="font-size: 12px;line-height: 70px;color: #ff721f;font-style: normal">%</span>
				        </p>
				        <p class="text-center" style="line-height: 20px;font-size: 12px;color: #999;margin-top: -30px;">预期年收益</p>
				        <hr>
				        <p data-product="${item.productId }" class="text-center view" style="font-size: 14px;color: #ff721f;cursor: pointer;">立即购买</p>
				      </div>
				    </div>
				</div>
    		</c:if>
    	</c:forEach>
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
 		/* $.getJSON('${pageContext.request.contextPath}/index/data', function(data){
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
				 			         '<p data-product="'+n.productId+'" class="text-center view" style="font-size: 14px;line-height:45px; color: #fff;cursor: pointer;background-color: #ff721f;">立即购买</p>'+
				 			      '</div>'+
				 			    '</div>'+
				 			  '</div>'
				 	html += item;
 				});
 				$('#topExpectRate').empty().append(html);
 			}
 			
 			if(data.TOP_REAL_RATE){
 				var d = data.TOP_REAL_RATE;
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
				 			         '<p data-product="'+n.productId+'" class="text-center view" style="font-size: 14px;line-height:45px; color: #fff;cursor: pointer;background-color: #ff721f;">立即购买</p>'+
				 			      '</div>'+
				 			    '</div>'+
				 			  '</div>'
				 	html += item;
 				});
 				$('#topExpectRate').empty().append(html);
 			}
 			
 			if(data.TOP_POPU){
 				var d = data.TOP_POPU;
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
				 			         '<p data-product="'+n.productId+'" class="text-center view" style="font-size: 14px;line-height:45px; color: #fff;cursor: pointer;background-color: #ff721f;">立即购买</p>'+
				 			      '</div>'+
				 			    '</div>'+
				 			  '</div>'
				 	html += item;
 				});
 				$('#topExpectRate').empty().append(html);
 			}
 			
 			if(data.TOP_NEW){
 				var d = data.TOP_NEW;
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
				 			         '<p data-product="'+n.productId+'" class="text-center view" style="font-size: 14px;line-height:45px; color: #fff;cursor: pointer;background-color: #ff721f;">立即购买</p>'+
				 			      '</div>'+
				 			    '</div>'+
				 			  '</div>'
				 	html += item;
 				});
 				$('#topExpectRate').empty().append(html);
 			}
 			
 			
 		});*/
 		$('.view').click(function(){
			var $this = $(this);
			var productId = $this.data('product');
			location.href = '${pageContext.request.contextPath}' + '/view/product/' + productId;
		});
 		
 	}); 
 	

 	</script>
 
  </body>
</html>