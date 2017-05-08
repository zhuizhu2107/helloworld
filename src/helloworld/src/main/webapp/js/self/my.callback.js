/**
 * 回调函数内容部分
 * 用法如下：
 * 	  1、在页面最下方的js引用处添加：<script src="${ctx}js/self/my.callback.js"></script>
 * 	  2、并在对应的<script type="text/javascript">XXX</script>处使用
 *         	$(function(){
 *      		var callJavaScript="${sessionScope['org.springframework.web.servlet.support.SessionFlashMapManager.FLASH_MAPS'][0]['callJavaScript']}";
  *     		callbackBefore(callJavaScript);
 *     		});
 * 
 * 	  3、注意要点：该js要依赖于jquery.min.js、xcConfirm.js的存在，所以必须放在它们下面
 * 			<script src="${ctx}js/jquery/jquery-1.9.1/jquery.min.js"></script>（可以更换）
 * 			<script src="${ctx}js/jquery/jquery.confirm1.0/xcConfirm.js"></script>
 * */
function callbackBefore(callJavaScript){
	if(callJavaScript){
		eval(callJavaScript);
		removeSessionKey("callJavaScript");
	}
}

/**回调函数**/
function callback4Page(flag,content,type,tile){
	if(flag&&flag=='failed'){
		window.wxc.xcConfirm(content,type,{title:tile});
	}
} 

/**删除缓存**/
function removeSessionKey(callJavaScript){
	/**异步请求删除缓存内容**/
	$.ajax({
		url: "common/removeSessionKey.do",
		cache: false,
		data: "key="+callJavaScript,
		success: function(data){
			
		}
	}); 
}
