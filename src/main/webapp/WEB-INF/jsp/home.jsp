<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
	
	</nav>
	
	<div id="cc" class="easyui-layout" style="width: 100%;margin-top: -20px;">
	    <div data-options="region:'west',title:'菜单',split:true" style="width:15%;">
	    	<div class="easyui-accordion" data-options="fit:true,border:false">
				<div title="个人收藏" data-options="selected:true">
					<div class="list-group">
					  <a href="javascript:void(0)" onclick="addTab('jquery','http://jquery.com/')" class="list-group-item">jquery</a>
					  <a href="javascript:void(0)" onclick="addTab('baidu','http://www.baidu.com/')" class="list-group-item">baidu</a>
					  <a href="javascript:void(0)" onclick="addTab('easyui','http://jquery.com/')" class="list-group-item">easyui</a>
					</div>
				</div>
				<div title="理财信息">
					<div class="list-group">
					  <a href="#" class="list-group-item">Dapibus ac facilisis in</a>
					  <a href="#" class="list-group-item">Morbi leo risus</a>
					  <a href="#" class="list-group-item">Porta ac consectetur ac</a>
					  <a href="#" class="list-group-item">Vestibulum at eros</a>
					</div>
				</div>
			</div>
	    </div>
	    <div id="content" data-options="region:'center',title:''" style="padding:5px;background:#eee;">
	    	<div id="tt" class="easyui-tabs" data-options="fit:true,border:false,plain:true">
				<div title="About" data-options="href:'_content.html'" style="padding:10px"></div>
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
	 	var height = $(window).height()
	 	var navHeight = $('nav').height()
	 	$('#cc').height(height - navHeight - 5);
	 	
	 	function addTab(title, url){
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