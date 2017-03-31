<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../images/icons/index.ico">
    
    <title>账号测试</title>

    <!-- Bootstrap core CSS -->
    <link href="../../cs/bootstrap/bootstrap-3.3.7/bootstrap.min.css" rel="stylesheet">
    
    <!-- select2 core CSS -->
    <link href="../../cs/select2/select2-4.0.3/select2.min.css" rel="stylesheet">
    
    <!-- daterangepicker core CSS -->
    <link href="../../cs/bootstrap/daterangepicker-master/daterangepicker.css" rel="stylesheet">
    
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="../../cs/bootstrap/bootstrap-3.3.7/ie10-viewport-bug-workaround.css" rel="stylesheet">

	<!-- Custom styles for this template -->
	<link href="test-account.css" rel="stylesheet">	

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
	<script type="text/javascript" src="../../js/bootstrap/bootstrap-3.3.7/ie-emulation-modes-warning.js"></script>


    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
  </head>
  <body>
	<!--  向父 form 元素添加 class .form-horizontal。把标签和控件放在一个带有 class .form-group 的 <div> 中。 向标签添加 class .control-label。 -->
	<form id="inputForm"  action=""  class="form-horizontal" role="form" >
		<div class="form-group">
		    <label for="accCode" class="col-sm-1 control-label">编码:</label>
		    <div class="col-sm-3">
		      <input type="text"  class="form-control"  id="accCode"  name="accCode"  placeholder="请输入编码">
		    </div>
		    
		    <label for="accName" class="col-sm-1 control-label">名称:</label>
		    <div class="col-sm-3">
		      <input type="text"  class="form-control"  id="accName"  name="accName"  placeholder="请输入名称">
		    </div>
		 </div>	
		 
		<div class="form-group">
<!-- 		    <label for="accCreatTime" class="col-sm-1 control-label">注册时段:</label>
		    <div class="col-sm-2" >
		      <input type="text"  class="form-control"  id="accCreatTime"  name="accCreatTime" >
		    </div> -->

		    <label for="accType" class="col-sm-1 control-label">账号类型:</label>
		    <div class="col-sm-3">
		      	<select class="form-control" id="accType" name="accType" >
		      		<option value="" selected="selected" >请选择</option>
		      		<optgroup label="个人帐户">
		      			<option value="1">个人结算帐户</option>
			            <option value="2">储蓄帐户</option>
			            <option value="3">个人支票帐户</option>
			            <option value="4">信用卡帐户</option>
			      		<option value="5">其他</option>
		      		</optgroup>
			      	<optgroup label="公司帐户">
			      		<option value="6">公司帐户</option>
		      		</optgroup>
		      	</select>
		    </div>
		    
		    <label for="accState" class="col-sm-1 control-label">状态:</label>
		    <div class="col-sm-3 radio">
				<label><input type="radio" name="accState"  value="1" > 正常</label>
   				<label><input type="radio" name="accState"  value="2" > 挂失</label>
   				<label><input type="radio" name="accState"  value="3" > 冻结</label>
   				<label><input type="radio" name="accState"  value="4" > 销户</label>
		    </div>
		 </div>	
		 
		 <div class="form-group">
		    <label for="accRemark" class="col-sm-1 control-label">备注:</label>
		    <div class="col-sm-7" >
		      <textarea class="form-control" id="accRemark" name="accRemark" rows="3" placeholder="请输入备注信息"></textarea> 
		    </div>
		 </div>	
		 
		 <div class="form-group" align="center">
			 <button type="button" class="btn btn-success"  onclick="registerClick(this);">注册</button>
			 <button type="button" class="btn btn-default"  onclick="javascript:window.history.go(-1);">取消</button>
		 </div>	
		 
	</form>

    <!-- Placed at the end of the document so the pages load faster -->
    <script type="text/javascript" src="../../js/jquery/jquery-3.0.0/jquery-3.0.0.min.js"></script>
    <script type="text/javascript" src="../../js/bootstrap/bootstrap-3.3.7/bootstrap.min.js"></script>
	<script type="text/javascript" src="../../js/select2/select2-4.0.3/select2.min.js"></script> 
	<script type="text/javascript" src="../../js/bootstrap/daterangepicker-master/moment.min.js"></script> 
	<script type="text/javascript" src="../../js/bootstrap/daterangepicker-master/daterangepicker.js"></script> 
    
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script type="text/javascript" src="../../js/bootstrap/bootstrap-3.3.7/ie10-viewport-bug-workaround.js"></script>
    
   	<!-- Custom script for this template -->
	<script type="text/javascript" src="test-account.js"></script>
    
  </body>
</html>