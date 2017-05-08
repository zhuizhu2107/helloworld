<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
	  <head>
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
	    <meta name="description" content="">
	    <meta name="author" content="">
	    <link rel="icon" href="${ctx}images/icons/index.ico">
        <title>用户注册</title>
        
        <!-- Bootstrap -->
    	<link href="${ctx}cs/bootstrap/bootstrap-3.3.7/bootstrap.min.css" rel="stylesheet">        
        
        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

    </head>       
        
   <body>       
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-label="Close">
				<span aria-hidden="true">×</span>
			</button>
			<h2 class="modal-title" style="font: bolder;">用户注册</h2>
		</div>
		
		<div class="modal-body"  style="height: 350px">
	            <form id="registerForm" method="post" class="form-horizontal">
					<div class="form-group">
						<label for="userName"><font color="red">*</font>登陆名:</label>
						<input type="text"  name="userName"  class=""  placeholder="请输入登陆名" title="字母、数字、下划线组成，字母开头，4-16位">
						<p class="help-block">字母、数字、下划线组成，字母开头，4-16位</p>
				  	</div>
	            	<div class="form-group">
	            		<label for="password"><font color="red">*</font>密码:</label>
					    <input type="password" name="password"  class=""  placeholder="请输入登陆密码" title="字母、数字、下划线组成，字母开头，4-16位">
					    <p class="help-block">字母、数字、下划线组成，字母开头，4-16位</p>
				  	</div>
					<div class="form-group">
						<label for="nickName">昵称:</label>
						<input type="text"  name="nickName"  class=""  placeholder="请输入昵称" title="请输入昵称">
				  	</div>
	            	<div class="form-group">
	            		<label for="realName">真实姓名:</label>
					    <input type="text" name="realName"  class=""  placeholder="请输入真实姓名" title="请输入真实姓名">
				  	</div>				  	
	            </form>		
		</div>
		
		<div class="modal-footer">
			<button type="button" class="btn btn-primary">注 册</button>
			<button type="button" class="btn btn-default" data-dismiss="modal">关 闭</button>
		</div>

	    <!-- Placed at the end of the document so the pages load faster -->
	    <script type="text/javascript" src="${ctx}js/jquery/jquery-3.0.0/jquery-3.0.0.min.js"></script>
	    <script type="text/javascript" src="${ctx}js/bootstrap/bootstrap-3.3.7/bootstrap.min.js"></script>
		
    </body>
</html>
