function dianzan(useridare,likefor,ss){
	$.post(
				"Like/clickReturnDianZanNum",
				{
				'useridare.userid':useridare,
				'likefor':likefor
				},
				function(data){
					$(ss).html('<i class="am-icon-thumbs-up"></i>'+data.dianzanNum);
				});
	
}