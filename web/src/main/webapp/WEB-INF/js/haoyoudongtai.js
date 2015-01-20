
$(function(){
	$(document).ajaxStart(function(){
    	$('#zhuanzhuan').show();
	}).ajaxStop(function(){
		$('#zhuanzhuan').hide();
	});
	
	wokanguoshui();
	shuikanguowo();
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
	        dongtai(obj.curr);
	    }
	});
})

//查询我看过谁 访客记录 的ajax请求
function wokanguoshui(){
	$.getJSON('visit/findByMy?pageNo=1', function(json, textStatus) {
		xuanranFk(json,'fangkebody1');
	});
}

//查询谁看过我 访客记录 的ajax请求
function shuikanguowo(){
	$.getJSON('visit/findBy?pageNo=1',function(json, textStatus) {
		xuanranFk(json,'fangkebody2');
	});
}
////////////////////////////////////////////////////////////////////////////////

//查询动态
function dongtai(mypageNo){
	$.getJSON('News/listNews',{pageNo:mypageNo},function(json,textStatus){
		xuanranDongTai(json,'dongtai');
	});
}
//访客模版渲染
function xuanranFk(json,dizhi){
	var gettpl = document.getElementById('fangkeTpl').innerHTML;
	laytpl(gettpl).render(json, function(html){
	    document.getElementById(dizhi).innerHTML = html;
	    
	    //访客记录
	    $('.am-circle').each(function(){
	    	$(this).popover({
		    	content:$(this).attr('content'),
		    	trigger:'hover focus'
		    })
	    });
	});
}

//渲染动态
function xuanranDongTai(json,moban){
	var gettpl = document.getElementById(moban).innerHTML;
	laytpl(gettpl).render(json, function(html){
		$('#showdongtai').append(html);
	});
}