<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html lang="zh-CN" class="no-js">
    <head>
        <meta charset="utf-8">
        <title>用户登陆</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- CSS -->
        <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
        <link rel="stylesheet" href="${ctx}assets/css/reset.css">
        <link rel="stylesheet" href="${ctx}assets/css/supersized.css">
        <link rel="stylesheet" href="${ctx}assets/css/style.css">

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

    </head>

    <body>

        <div class="page-container">
            <h1>系统登陆</h1>
            <form id="loginForm" method="post">
                <input type="text"  name="userName"  class="username required"  placeholder="Username">
                <input type="password" name="password"  class="password required"  placeholder="Password" >
                <button  type="button" onclick="loginClick();">登  陆</button><button type="button"  onclick="registerClick();">注  册</button>
                <div class="error"><span>+</span></div>
            </form>
        </div>

        <!-- Javascript -->
        <script src="${ctx}js/jquery/jquery-1.9.1/jquery.min.js"></script>
        
        <script src="${ctx}assets/js/supersized.3.2.7.min.js"></script>
        <script src="${ctx}assets/js/supersized-init.js"></script>
        <script src="${ctx}assets/js/scripts.js"></script>
        
        <script type="text/javascript" src="${ctx}js/bootstrap/bootstrap-3.3.7/bootstrap.min.js"></script>
        <script src="${ctx}js/jquery/jquery.validate1.7/jquery.validate.min.js"></script>
        <script type="text/javascript">
        	function loginClick(){
        		$("#loginForm").attr("action","${ctx}user/login.do");
        		$("#loginForm").submit();
        	}

        	function registerClick(){
        		alert("registerClick");
        	}
        
        	//回车事件
        	document.onkeydown=function(event){
                var e = event || window.event || arguments.callee.caller.arguments[0];
                 if(e && e.keyCode==13){ // enter 键
                	 loginClick();
                }
            };        	
        	
        </script>
    </body>

</html>

