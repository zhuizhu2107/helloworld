$(document).ready(function(){
	//TO DO YOUR CODE HERE
	$("#accType").select2({
		tags: true,
		maximumSelectionLength: 3  //最多能够选择的个数
	});
	
	$("#accCreatTime").daterangepicker({
		locale:{
			format: "YYYYMMDD",  //控件中from和to 显示的日期格式 
			separator : " - ", 
            applyLabel: '确定',
            cancelLabel: '取消',
            fromLabel: '开始',
            toLabel: '结束',
            weekLabel : "W", 
            daysOfWeek: ["日", "一", "二", "三", "四", "五", "六"],
            monthNames: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"]
        },
        startDate:new Date(),
        endDate:new Date()
	});	
});

/**注册点击事件**/
function registerClick(flag){
	$(flag).attr({"disabled":"disabled"});
	
	//封装表单数据
	var formData=$("#inputForm").serialize();
	var url=getRootPath()+"/account/add.do";
	$.ajax({
		   type: "POST",
		   url: url,
		   async: false,
		   cache: false,
		   data: formData,
		   dataType:"json",
		   success: function(data){
		     alert( "Data Saved: " + data.success);
		   },
		   error:function (XMLHttpRequest, textStatus, errorThrown) {
			   alert("操作失败！");
		   }
		});
}
