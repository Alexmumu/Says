function albumlist()
{
	$.ajax({
		url : "album/albumlist",
		type : "post",
		data : {
			  "pageNo" : curr,
	          "userid":"U001" ,
	          "albumstatus":0
		     },
		dataType : "json",
		success : function(data) {
			
          var  gettpl = $("#demo").html();
          var render = laytpl(gettpl).render(data);
          document.getElementById('album').innerHTML = render;
           
		}
	});
}