
$(function(){
	$(document).ajaxStart(function(){
    	$('#zhuanzhuan').show();
	}).ajaxStop(function(){
		$('#zhuanzhuan').hide();
	});
	laypage({
	    cont: 'page1', //容器。值支持id名、原生dom对象，jquery对象,
	    pages: $('#zongyeshu').val(), //总页数
	    groups: 0, //连续分数数0
	    prev: false, //不显示上一页
	    next: '点击查看更多',
	    skin: 'flow', //设置信息流模式的样式
	    jump: function(obj){
	        if(obj.curr === ($('#zongyeshu').val()-1)){
	            this.next = '没有更多了';
	        }
	        dongtai($('#zhuyeuserid').val(),obj.curr);
	    }
	});
})

//查询动态
function dongtai(zhuyeid,zhuyepageNo){
	$.getJSON('News/myNews',{id:zhuyeid,pageNo:zhuyepageNo},function(json,textStatus){
		xuanranDongTai(json,'mydongtaitp');
	});
}



//渲染动态
function xuanranDongTai(json,moban){
	var gettpl = document.getElementById(moban).innerHTML;
	laytpl(gettpl).render(json, function(html){
	    $('#mydongtai').append(html);
	});
}