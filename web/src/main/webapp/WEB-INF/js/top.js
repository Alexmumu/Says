//$(function(){
//	getCountxxnum();
//	window.setInterval(getCountxxnum,'3000');//定时循环执行
//});
加载出用户的未读消息数
function getCountxxnum(){
	$.getJSON('user/countByMsgnum', function(json, textStatus) {
		if(json.xxnum=='0'){
			$('#xxnum').text(json.xxnum);
			$('#xxnumspan').hide();
			
		}else{
			$('#xxnum').text(json.xxnum);
			$('#xxnum').show();
		}
	});
}