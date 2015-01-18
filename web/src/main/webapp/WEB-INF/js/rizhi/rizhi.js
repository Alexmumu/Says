$(function() {
		rizhilist();
		$(".a1").click(function(){	
		     alert("我被点了 ！")
		    
	         });
		laypage({
			cont : 'page1', //容器。值支持id名、原生dom对象，jquery对象,
			pages : 10, //总页数
			skin : '#AF0000', //加载内置皮肤，也可以直接赋值16进制颜色值，如:#c00
			groups : 5
		//连续显示分页数
		});
	});

//查询所有的日志
function rizhilist() {

		$.ajax({
			url : "rizhi/rizhilist",
			type : "post",
			data : {
				"pageNo":1
			},
			dataType : "json",
			success : function(data) {
				var  content = "<ul  class='am-list'>";
				if(data.result==""||data.result==null){
				content +="<p class='ab'>还没有评论哦，快来抢沙发吧！</p>";
				}else{
				$.each(data.result,function(i,rz){

 					content += "<li>";
 					if(rz.rizhinature==0){
 						content += "<span >[原创]</span>&nbsp&nbsp";
 					}else{
 						content += "<span class='am-icon-share'>[转]</span>&nbsp&nbsp";
 					}
 					content += "<span><a href='rizhi/getRizhiid?rizhiid="+rz.rizhiid+"'>"+type.rizhititle;	   
 				    content += "</a></span>";
 				    content += "<span>发表时间："+rz.rizhidate;	   
				    content += "</span>";
				    if(1==1){
				    content += "<span><a>编辑</a>";	   
				    content += "</span>";
				    content += "<span><a>删除</a>";	   
				    content += "</span>";
				    }else{
				    	 content += "<span></span>"
				    }
 					content += "</li>";
 							});	
 							}
 				    content += "</ul>";
 				   $("#view").html(content);
			}
		});
	}
//查询
function type() {

	$.ajax({
		url : "rizhi/toRizhitypegl",
		type : "post",
		dataType : "json",
		success : function(data, textStatus) {
           list=data.result;
     
           alert(list.length);
		}
	});
}