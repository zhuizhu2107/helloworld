<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="zh_CN"/>
<!DOCTYPE html>
<html class="no-js">
    <head>
        <meta charset="utf-8">
        <title><fmt:message key="userLogin"/></title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

		<!-- 网站图标 -->
		<link href="${ctx}images/icons/favicon.ico" rel="shortcut icon" />

        <!-- CSS -->
        <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
        <link rel="stylesheet" href="${ctx}assets/css/reset.css">
        <link rel="stylesheet" href="${ctx}assets/css/supersized.css">
        <link rel="stylesheet" href="${ctx}assets/css/style.css">

        <!-- Bootstrap -->
    	<link href="${ctx}cs/bootstrap/bootstrap-3.3.7/bootstrap.min.css" rel="stylesheet">
    	<link rel="stylesheet" href="${ctx}cs/jquery/comfirm/xcConfirm.css">

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

    </head>
    
	<% 
		String isSendRedirect=request.getParameter("isSendRedirect");
		request.setAttribute("isSendRedirect", isSendRedirect);
	%>

    <body>
    
        <div class="page-container">
	            <h1><fmt:message key="userLogin"/></h1>
	            <form id="loginForm" method="post" class="form-horizontal">
					<div class="form-group">
						<label for="userName"><fmt:message key="userName"/>:</label>
						<input type="text"  name="userName"  class="username"  placeholder="<fmt:message key="userName_placeholder"/>" title="<fmt:message key="userName_title"/>">
				  	</div>
	            	<div class="form-group">
	            		<label for="password"><fmt:message key="password"/>:</label>
					    <input type="password" name="password"  class="password"  placeholder="<fmt:message key="password_placeholder"/>" title="<fmt:message key="password_title"/>">
				  	</div>
	                
	                <div class="form-group">
                		<button href="${ctx}pages/user/register.jsp"  class="btn-link" data-target="#modal" data-toggle="modal">
							<i class="fa fa-edit "><fmt:message key="register"/></i> 
						</button>
	                	<button  type="button" class="btn-success" onclick="loginClick();"><fmt:message key="login"/></button>
					</div>
	            </form>
        </div>

		<div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="modal">
			<div class="modal-dialog" role="document">
				<div class="modal-content"></div>
			</div>
		</div>

		<!--  定义全局变量  -->
		<c:set var="callJavaScript"  value="${sessionScope['org.springframework.web.servlet.support.SessionFlashMapManager.FLASH_MAPS'][0]['callJavaScript']}"  scope="session"></c:set>

        <!-- Javascript -->
        <script src="${ctx}js/jquery/jquery-1.9.1/jquery.min.js"></script>
        
        <script src="${ctx}assets/js/supersized.3.2.7.min.js"></script>
        <script src="${ctx}assets/js/supersized-init.js"></script>
        <script src="${ctx}assets/js/scripts.js"></script>
        
        <script type="text/javascript" src="${ctx}js/bootstrap/bootstrap-3.3.7/bootstrap.min.js"></script>
        <script src="${ctx}js/jquery/jquery.validate1.7/jquery.validate.min.js"></script>
        <script src="${ctx}js/jquery/jquery.confirm1.0/xcConfirm.js"></script>
        <script src="${ctx}js/self/my.validate.from.js"></script>
        <script src="${ctx}js/md5/md5.min.js"></script>
        <script src="${ctx}js/self/my.callback.js"></script>
        <script src="${ctx}js/self/my.common.js"></script>
        
        <script type="text/javascript">
        	$(document).ready(function(){
        		var callJavaScript="${sessionScope['org.springframework.web.servlet.support.SessionFlashMapManager.FLASH_MAPS'][0]['callJavaScript']}";
        		callbackBefore(callJavaScript);
        		
        		var isSendRedirect="${isSendRedirect}";
        		if(isSendRedirect&&isSendRedirect=='true'){
        			window.wxc.xcConfirm('<fmt:message key="login_first_limit"/>',"info",{title:'<fmt:message key="login_tip"/>'});
        		}
        	});
        
        	/**登陆点击事件**/
        	function loginClick(){
        		var userName=loginForm.userName.value;
        		var password=loginForm.password.value;
        		if(!checkUser(userName)){
        			window.wxc.xcConfirm('<fmt:message key="login_name_tip"/>',"info",{title:'<fmt:message key="login_tip"/>'});
        			return;
        		}
        		if(!checkUser(password)){
        			window.wxc.xcConfirm('<fmt:message key="login_password_tip"/>',"info",{title:'<fmt:message key="login_tip"/>'});
        			return;
        		}        		
        		
        		/**密码加密过程**/
        		loginForm.password.value=md5(password);
        		
				window.wxc.xcConfirm('<fmt:message key="login_confirm"/>', window.wxc.xcConfirm.typeEnum.confirm,{
					onOk:function(e){//确定事件
						$("#loginForm").attr("action","${ctx}user/login.do");
		        		$("#loginForm").submit();
					}
				});
				
        	}
        
        	//回车事件
        	document.onkeydown=function(event){
                var e = event || window.event || arguments.callee.caller.arguments[0];
                 if(e && e.keyCode==13){ // enter 键
                	 loginClick();
                }
            };  
            
            //清除缓存数据
            window.onload=function(){
            	$('body').on('hidden', '.modal', function () {
            	      $(this).removeData('modal');
            	});
            };        
            
        </script>
    </body>

</html>

