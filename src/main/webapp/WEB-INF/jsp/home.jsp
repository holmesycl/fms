<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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
	      <a class="navbar-brand" href="${pageContext.request.contextPath}/home">理财系统</a>
	    </div>
	     <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav navbar-right">
	        <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><shiro:principal/><span class="caret"></span></a>
	          <ul class="dropdown-menu">
	            <li><a href="${pageContext.request.contextPath}/s/logout">退出登录</a></li>
	          </ul>
	        </li>
	      </ul>
	    </div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
	</nav>
	
	<div id="cc" class="easyui-layout" style="width: 100%;margin-top: -20px;">
	    <div data-options="region:'west',title:'菜单',split:true" style="width:15%;" id="west">
	    	<div id="aa" class="easyui-accordion" data-options="fit:true,border:false" id="menu">
	    	<!-- 动态panel -->	
			</div>
	    </div>
	    <div id="content" data-options="region:'center',title:''" style="padding:5px;background:#eee;">
	    	<div id="tt" class="easyui-tabs" data-options="fit:true,border:false,plain:true">
				
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
 		
 		autoHeight();
 		loadMenu();

 		function autoHeight(){
 			var height = $(window).height()
 		 	var navHeight = $('nav').height()
 		 	$('#cc').height(height - navHeight - 5);
 		}
 		
	 	// 获取菜单
	 	function loadMenu(){
	 		var url = '${pageContext.request.contextPath}/menu/all';
	 		$.getJSON(url, function(data){
	 	        var categoryObj = {};
	 			$.each(data, function(i, n){
	 				var category = n.category;
	 				if(categoryObj[category] == null){
	 					categoryObj[category] = '';
	 				}
	 	        	var item = '<a href="javascript:void(0)" onclick="addTab(\''+n.title+'\',\''+n.url+'\')" class="list-group-item">'+n.title+'</a>';
	 	        	categoryObj[category] = categoryObj[category] + item;
	 	        });
	 			
	 	        for(category in categoryObj){
	 	        	var content = '<div class="list-group">'
										+ categoryObj[category]
								 +'</div>';
					addPanel(category, content);
	 	        }
	 		});
	 	}
	 	
	 	function addPanel(title, content){
			$('#aa').accordion('add',{
				title: title,
				content: content
			});
		}
	 	
	 	function addTab(title, url){
	 		console.log(url);
	 		if ($('#tt').tabs('exists', title)){
	 			$('#tt').tabs('select', title);
	 		} else {
	 			var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
	 			$('#tt').tabs('add',{
	 				title:title,
	 				content:content,
	 				closable:true
	 			});
	 		}
	 	}

 	</script>
 
  </body>
</html>