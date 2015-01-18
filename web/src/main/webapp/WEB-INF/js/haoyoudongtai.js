
$(function(){
	wokanguoshui();
	shuikanguowo();
	dongtai();
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
function dongtai(){
	$.getJSON('News/listNews?pageNo=1&pageSize=100',function(json,textStatus){
		xuanranDongTai(json,'showdongtai','dongtai');
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
function xuanranDongTai(json,address,moban){
	var gettpl = document.getElementById(moban).innerHTML;
	laytpl(gettpl).render(json, function(html){
	    document.getElementById(address).innerHTML = html;
	});
}