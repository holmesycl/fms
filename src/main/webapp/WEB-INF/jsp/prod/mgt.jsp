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
		<div id="tb" style="padding:5px">
			<div style="margin-bottom:5px">
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" id="addProduct" plain="true"></a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" id="editProduct" plain="true"></a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" id="removeProduct" plain="true"></a>
			</div>
			<form id="qryForm" class="form-inline">
			  <div class="form-group" style="margin-right: 20px;">
			    <label class="control-label" for="qryProductId">产品ID：</label>
			    <input type="text" class="form-control" id="qryProductId">
			  </div>
			  <div class="form-group" style="margin-right: 20px;">
			    <label class="control-label" for="qryProductName">产品名称：</label>
			    <input type="text" class="form-control" id="qryProductName">
			  </div>
			  <div class="form-group" style="margin-right: 20px;">
			    <label class="control-label" for="qryProductType">产品类型：</label>
			    <select id="qryProductType" class="form-control">
			     	<option value="">全部</option>
				  	<option value="1">保证收益型</option>
				  	<option value="2">保本浮动收益型</option>
				  	<option value="3">非保本浮动收益型</option>
			  	</select>
			  </div>
			  <div class="form-group" style="margin-right: 20px;">
			    <label class="control-label" for="qryRiskLevel">风险等级：</label>
			    <select id="qryRiskLevel" class="form-control">
			    	<option value="">全部</option>
				  	<option value="R1">谨慎型(R1)</option>
				  	<option value="R2">稳健型(R2)</option>
				  	<option value="R3">平衡型(R3)</option>
				  	<option value="R4">进取型(R4)</option>
				  	<option value="R5">激进型(R5)</option>
			  	</select>
			  </div>
			  <button type="submit" class="btn btn-primary">查询</button>
			</form>
		</div>
		<table id="tt" class="easyui-datagrid" title="理财产品查询" style="width:100%;height:670px;"
			data-options="fitColumns:true,striped:true,rownumbers:true,pagination:true,pageSize:20,url:'${pageContext.request.contextPath}/prod/query',singleSelect:true,method:'post',toolbar:tb">
		</table>
		
		<div id="w" class="easyui-window" title="新增理财产品" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:65%;height:700px;padding:10px;">
			<div class="container-fluid">
				<form id="ff" class="form-horizontal" method="post">
				  	<div class="form-group">
				    	<label for="inputProductName" class="col-sm-2 control-label">产品名称</label>
				     	<div class="col-sm-10">
				    		<input type="text" class="form-control easyui-validatebox textbox" name="productName" id="inputProductName" placeholder="输入产品名称">
				    	</div>
				  	</div>
				  	<div class="form-group">
				    	<label for="textareaProductDesc" class="col-sm-2 control-label">产品描述</label>
				    	<div class="col-sm-10">
				    		<textarea class="form-control" name="productDesc" rows="3" id="textareaProductDesc"></textarea>
				    	</div>
				  	</div>
				  	<div class="form-group">
				    	<label for="datetimeboxEffectiveDate" class="col-sm-2 control-label">产品生效时间</label>
				     	<div class="col-sm-2">
				    		<input type="text" class="form-control easyui-datetimebox" name="effectiveDate" id="datetimeboxEffectiveDate">
				    	</div>
				 	</div>
					<div class="form-group">
				    	<label for="datetimeboxExpireDate" class="col-sm-2 control-label">产品失效时间</label>
				     	<div class="col-sm-2">
				    		<input type="text" class="form-control easyui-datetimebox" name="expireDate" id="datetimeboxExpireDate">
				    	</div>
				 	</div>
				 	<div class="form-group">
				    	<label for="datetimeboxSaleStartDate" class="col-sm-2 control-label">发售开始时间</label>
				     	<div class="col-sm-2">
				    		<input type="text" class="form-control easyui-datetimebox" name="saleStartDate" id="datetimeboxSaleStartDate">
				    	</div>
				 	</div>
					<div class="form-group">
				    	<label for="datetimeboxSaleEndDate" class="col-sm-2 control-label">发售截止时间</label>
				     	<div class="col-sm-2">
				    		<input type="text" class="form-control easyui-datetimebox" name="saleEndDate" id="datetimeboxSaleEndDate">
				    	</div>
				 	</div>
				 	<div class="form-group">
				    	<label for="numberProductTerm" class="col-sm-2 control-label">产品期限</label>
				     	<div class="col-sm-3">
				     		<div class="input-group">
				     			<input type="number" class="form-control" name="productTerm" id="numberProductTerm" placeholder="产品最少持有时间">
				     			<div class="input-group-addon">天</div>
				     		</div>
				    	</div>
				 	</div>
				 	<div class="form-group">
				    	<label for="numberLimitStartAmount" class="col-sm-2 control-label">起始限额</label>
				     	<div class="col-sm-3">
				     		<div class="input-group">
				    			<input type="number" class="form-control" name="limitStartAmount" id="numberLimitStartAmount">
				    			<div class="input-group-addon">元</div>
				     		</div>
				    	</div>
				 	</div>
				 	<div class="form-group">
				    	<label for="numberLimitEndAmount" class="col-sm-2 control-label">最大限额</label>
				     	<div class="col-sm-3">
				     		<div class="input-group">
				     			<input type="number" class="form-control" name="limitEndAmount" id="numberLimitEndAmount">
				     			<div class="input-group-addon">元</div>
				     		</div>
				    	</div>
				 	</div>
				 	<div class="form-group">
				    	<label for="radioinlineProductType" class="col-sm-2 control-label">产品类型</label>
				     	<div class="col-sm-10">
				     		<label class="radio-inline">
						  		<input type="radio" name="productType" id="radioinlineProductType" value="1"> 保证收益型
							</label>
							<label class="radio-inline">
						  		<input type="radio" name="productType" value="2"> 保本浮动收益型
							</label>
							<label class="radio-inline">
						  		<input type="radio" name="productType" value="3"> 非保本浮动收益型
							</label>
				    	</div>
				 	</div>
				 	<div class="form-group">
				    	<label for="radioinlineRiskLevel" class="col-sm-2 control-label">风险等级</label>
				     	<div class="col-sm-10">
				    		<label class="radio-inline">
						  		<input type="radio" name="riskLevel" id="radioinlineRiskLevel" value="R1"> 谨慎型(R1)
							</label>
							<label class="radio-inline">
						  		<input type="radio" name="riskLevel" value="R2"> 稳健型(R2)
							</label>
							<label class="radio-inline">
						  		<input type="radio" name="riskLevel" value="R3"> 平衡型(R3)
							</label>
							<label class="radio-inline">
						  		<input type="radio" name="riskLevel" value="R4"> 进取型(R4)
							</label>
							<label class="radio-inline">
						  		<input type="radio" name="riskLevel" value="R5"> 激进型(R5)
							</label>
				    	</div>
				 	</div>
				 	<div class="form-group">
				    	<label for="numberExpectRate" class="col-sm-2 control-label">预期收益率</label>
				     	<div class="col-sm-3">
				     		<div class="input-group">
				    			<input type="number" class="form-control" name="expectRate" id="numberExpectRate">
				    			<div class="input-group-addon">% / 年</div>
				    		</div>
				    	</div>
				 	</div>
				  	<div class="form-group">
				    	<div class="col-sm-offset-2 col-sm-10">
				      		<button type="submit" class="btn btn-primary">确认保存</button>
				    	</div>
				  </div>
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

	 	$('#tt').datagrid({
	 		columns:[[
	 			{field:'ck', checkbox:true},
	 			{field:'productId',title:'产品ID', width:100, align:'right'},
	 			{field:'productName',title:'产品名称', width:120, align:'right'},
	 			{field:'effectiveDate',title:'生效时间', width:150, align:'right'},
	 			{field:'expireDate',title:'失效时间', width:150, align:'right'},
	 			{field:'saleStartDate',title:'发售开始时间', width:150, align:'right'},
	 			{field:'saleEndDate',title:'发售截止时间', width:150, align:'right'},
	 			{field:'productTerm',title:'产品期限（天）', width:120, align:'right'},
	 			{field:'limitStartAmount',title:'起始限额（元）', width:100, align:'right'},
	 			{field:'limitEndAmount',title:'最大限额（元）', width:100, align:'right'},
	 			{field:'productType',title:'产品类型', width:120, align:'right',
	 				formatter: function(value, row, index){
	 					var text = value;
	 					if(value === '1'){
	 						text = '保证收益型';
	 					}else if(value === '2'){
	 						text = '保本浮动收益型';
	 					}else if(value === '3'){
	 						text = '非保本浮动收益型';
	 					}
	 					return text;
	 				}
	 			},
	 			{field:'riskLevel',title:'风险等级', width:100, align:'right',
	 				formatter: function(value, row, index){
	 					var text = value;
	 					if(value === 'R1'){
	 						text = '谨慎型(R1)';
	 					}else if(value === 'R2'){
	 						text = '稳健型(R2)';
	 					}else if(value === 'R3'){
	 						text = '平衡型(R3)';
	 					}else if(value === 'R4'){
	 						text = '进取型(R4)';
	 					}else if(value === 'R5'){
	 						text = '激进型(R5)';
	 					}
	 					return text;
	 				}
	 			},
	 			{field:'expectRate',title:'预期收益率（%/年）', width:150, align:'right'},
	 		]]
	 	});

	 	$("#qryForm").submit(function (e) {
	 		e.preventDefault();
	 		$('#tt').datagrid('load',{
	 			productId: $('#qryProductId').val(),
	 			productName: $('#qryProductName').val(),
	 			productType: $('#qryProductType').val(),
	 			riskLevel: $('#qryRiskLevel').val()
	 		});
	 	} );
	 	
	 	$('#addProduct').click(function(){
	 		$('#w').window('open')
	 	});
	 	
	 	$('#editProduct').click(function(){
	 		$('#w').window('open')
	 	});
	 	
	 	$('#removeProduct').click(function(){
	 		$('#w').window('open')
	 	});
	 	
 	 	$("#ff").submit(function (e) {
	 		e.preventDefault();
	 		$.messager.progress();	// display the progress bar
		 	$('#ff').form('submit', {
		 	    url: '${pageContext.request.contextPath}/prod/save',
		 		onSubmit: function(){
		 	    	var isValid = $(this).form('validate');
		 			if (!isValid){
		 				$.messager.progress('close');	// hide progress bar while the form is invalid
		 			}
		 			return isValid;	// return false will stop the form submission
		 	    },
		 	    success: function(data){
		 	    	$.messager.progress('close');	// hide progress bar while submit successfully
		 	    	data = JSON.parse(data);
		 	    	$.messager.alert('提示', data.msg, data.type);
		 	    }
		 	});
	 	} );
	 	

 	</script>
 
  </body>
</html>