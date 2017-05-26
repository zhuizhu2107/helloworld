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
    	<link href="${ctx}cs/bootstrap/bootstrap-3.3.7/bootstrapValidator.min.css" rel="stylesheet">    
    	<link rel="stylesheet" href="${ctx}cs/jquery/comfirm/xcConfirm.css">
    	
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
	            <form id="registerForm" method="post" class="form-horizontal" style="text-align: left;">
					<div class="form-group">
						<label for="userName"><font color="red">*</font>登陆名:</label>
						<input type="text"  name="userName"  class="form-control"  placeholder="请输入登陆名" title="字母、数字、下划线组成，字母开头，4-16位">
				  	</div>
	            	<div class="form-group">
	            		<label for="password"><font color="red">*</font>密码:</label>
					    <input type="password" name="password"  class="form-control"  placeholder="请输入登陆密码" title="字母、数字、下划线组成，字母开头，4-16位">
				  	</div>
					<div class="form-group">
						<label for="nickName">昵称:</label>
						<input type="text"  name="nickName"  class="form-control"  placeholder="请输入昵称" title="请输入昵称">
				  	</div>
	            	<div class="form-group">
	            		<label for="realName">真实姓名:</label>
					    <input type="text" name="realName"  class="form-control"  placeholder="请输入真实姓名" title="请输入真实姓名">
				  	</div>				  	
	            </form>		
		</div>
		
		<div class="modal-footer">
			<button type="button" class="btn btn-primary" onclick="registerClick();" id="registerBtn">注 册</button>
			<button type="button" class="btn btn-default" data-dismiss="modal" id="dismissBtn">关 闭</button>
		</div>

	    <!-- Placed at the end of the document so the pages load faster -->
	    <script type="text/javascript" src="${ctx}js/jquery/jquery-3.0.0/jquery-3.0.0.min.js"></script>
	    <script type="text/javascript" src="${ctx}js/bootstrap/bootstrap-3.3.7/bootstrap.min.js"></script>
	    <script type="text/javascript" src="${ctx}js/bootstrap/bootstrapvalidator/bootstrapValidator.min.js"></script>
	    <script src="${ctx}js/jquery/jquery.confirm1.0/xcConfirm.js"></script>
	    <script src="${ctx}js/md5/md5.min.js"></script>
	    
	    <script type="text/javascript">
	    	$(function(){
	    		//注册表单校验
	    		$("#registerForm").bootstrapValidator({
	    			message: "This value is not valid",
	                feedbackIcons: {
	　　　　　　 valid: "glyphicon glyphicon-ok",
	　　　　　　 invalid: "glyphicon glyphicon-remove",
	　　　　　　 validating: "glyphicon glyphicon-refresh"
　　　　　　},
	               fields: {
	            	   userName: {
	                       validators: {
								notEmpty: {
								    message: "用户名不能为空"
								},
								stringLength: {
								    min: 4,
								    max: 16,
								    message: "用户名长度必须在4到16位之间"
								},
								regexp: {
								    regexp: /^[a-zA-Z][a-zA-Z0-9_]+$/,
								    message: "用户名只能包含大写、小写、数字和下划线，字母开头"
								},
								threshold :  4 , //有4字符以上才发送ajax请求，（input中输入一个字符，插件会向服务器发送一次，设置限制，6字符以上才开始）
								remote: {//ajax验证。server result:{"valid",true or false} 向服务发送当前input name值，获得一个json数据。例表示正确：{"valid",true}  
									url: "${ctx}user/checkUserNameExists.do",//验证地址
									message: "该用户名已存在",//提示消息
									delay :  2000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
									type: "POST"//请求方式
								}
	                       }
	                   },
	                   password: {
	                	   validators: {
	                		   notEmpty: {
								    message: "密码不能为空"
								},
								stringLength: {
								    min: 4,
								    max: 16,
								    message: "密码长度必须在4到16位之间"
								},
								regexp: {
								    regexp: /^[a-zA-Z][a-zA-Z0-9_]+$/,
								    message: "密码只能包含大写、小写、数字和下划线，字母开头"
								}
	                	   }
	                   }
	               }
	    		});
	    	});
	    
	    	//注册点击事件
	    	function registerClick(){
	    		//调用表单校验
	    		$("#registerForm").bootstrapValidator('validate');
	    		//判断是否校验通过
	    		var isValid=$("#registerForm").data("bootstrapValidator").isValid();
	    		if(isValid){
	    			AjaxSubmitFormData();
	    		}
	    	}
	    
	    	//注册异步事件
	    	function AjaxSubmitFormData(){
	    		/**操作按钮置灰操作**/
	    		document.getElementById("registerBtn").disabled=true
	    		
        		/**密码加密过程**/
        		var password=registerForm.password.value;
        		registerForm.password.value=md5(password);
	    		
				//封装表单数据
				var formData=$("#registerForm").serialize();
				var url="${ctx}user/register.do";
				$.ajax({
				   type: "POST",
				   url: url,
				   async: false,
				   cache: false,
				   data: formData,
				   dataType:"json",
				   success: function(data){
					   if(data.flag&&data.flag=='success'){
						   var option = {
								title:"提示信息",  
								onOk: function(){
									//关闭弹出框
									setTimeout(dismissEvent,1000);
								}
						   };
						   window.wxc.xcConfirm("操作成功!","custom",option);
					   }
				   },
				   error:function (XMLHttpRequest, textStatus, errorThrown) {
					   alert("操作失败！");
				   }
				});	
	    	}

		     
	    	//modal模拟框点击消失事件
	    	function dismissEvent(){
	    		$("#dismissBtn").click();
	    	}
	    	
	    </script>
		
    </body>
</html>
