
function tanchuang(url){
	alert(url);
	$('#myframe',window.parent.document).attr('src',url);
	$('#my-popup',window.parent.document).modal('open');
}