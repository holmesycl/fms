<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>产品管理</title>

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
	
	<div class="container-fluid">
		<table class="easyui-datagrid" title="理财产品查询" style="width:100%;height:400px;"
			data-options="rownumbers:true,singleSelect:true,url:'datagrid_data1.json',method:'get',toolbar:toolbar">
			<thead>
				<tr>
					<th data-options="field:'itemid',width:80">Item ID</th>
					<th data-options="field:'productid',width:100">Product</th>
					<th data-options="field:'listprice',width:80,align:'right'">List Price</th>
					<th data-options="field:'unitcost',width:80,align:'right'">Unit Cost</th>
					<th data-options="field:'attr1',width:240">Attribute</th>
					<th data-options="field:'status',width:60,align:'center'">Status</th>
				</tr>
			</thead>
		</table>
		
		<div id="w" class="easyui-window" title="新增理财产品" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:70%;height:600px;padding:10px;">
			<div class="container-fluid">
				<form>
				  <div class="form-group">
				    <label for="exampleInputEmail1">产品名称</label>
				    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1">Password</label>
				    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputFile">File input</label>
				    <input type="file" id="exampleInputFile">
				    <p class="help-block">Example block-level help text here.</p>
				  </div>
				  <div class="checkbox">
				    <label>
				      <input type="checkbox"> Check me out
				    </label>
				  </div>
				  <button type="submit" class="btn btn-default">Submit</button>
				</form>
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
 		
	 	var toolbar = [{
			text:'新增',
			iconCls:'icon-add',
			handler:function(){
				$('#w').window('open');
			}
		},{
			text:'删除',
			iconCls:'icon-cut',
			handler:function(){
				alert('cut')
			}
		},'-',{
			text:'保存',
			iconCls:'icon-save',
			handler:function(){
				alert('save')
			}
		}];

 	</script>
 
  </body>
</html>