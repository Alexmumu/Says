$(function(){
	$('#dengluok').click(function(){
		$.ajax({
			url:'user/login',
			type:'post',
			data:$('#dengluform').serialize(),
			success:function(data){
				if(data.msg==='chenggong'){
					window.location.href="News/tolistNews"; 
				}else{
					$('#my-alert').modal();
				}
			}
		});
	});
});