
$(function(){
	$(document).ajaxStart(function(){
    	$.AMUI.progress.start();
	}).ajaxStop(function(){
   		$.AMUI.progress.done();
	});
	getCountxxnum();
	$('#axxnum').click(function(){
		findXiaoxi();
	});
	window.setInterval(getCountxxnum,'3000');//定时循环执行
});
//加载出用户的未读消息数
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
/**
 * 发送申请表修改数据
 */
function updateFrequest(id,status){
	//ajax同步请求
	$.ajax({
		url: 'Frequest/update',
		type: 'post',
		async: false,
		data: {frid: id,frstatus:status}
	})
	//发完请求后重新刷数据
	findXiaoxi();
}

//根据消息from 来查询相应的数据  并渲染模版放到页面
function findXiaoxi(){
	$.getJSON('Msgcenter/listMsg',$('#xxmyform').serialize(), function(json, textStatus) {
			var gettpl = document.getElementById('xiaoximb').innerHTML;
			var tpl = laytpl(gettpl);
			var result = tpl.render(json);
			document.getElementById('xiaoxibody').innerHTML=result;
		
	});
}
//通过消息ID修改消息状态
function updateMsgStatus(id,i){
	//ajax异步请求
	$.ajax({
		url: 'Msgcenter/deleteMsg',
		type: 'post',
		data: {id: id}
	})
	var num = '#remove'+i;
	$(num).remove();
	
}


