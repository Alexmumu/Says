<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<base href="<%=basePath%>">
<link rel="stylesheet" type="text/css" href="css/amazeui.css">
	<link rel="stylesheet" type="text/css" href="css/laypage/skin/laypage.css">

  	<script src="js/jquery.min.js"></script>
  	<script src="js/amazeui.js"></script>
  	<script type="text/javascript">
  	$(function(){
  		$("#dianzan").click(function(userid,useridare,likefor){
  			$.post(
  	  				"Like/clickReturnDianZanNum",
  	  				{
  	  				'userid.userid':userid,
  	  				'useridare.userid':useridare,
  	  				'likefor':likefor
  	  				},
  	  				function(data){
  	  				 	var content = "<table border='1' width='100%'>";
						content += "<tbody>";
  	  				$.each(data.dianzanlist,function(i,c){
						content += "<span style='display:block;'>";
						content += "<img  src='images/"+c.userid.userimg+"' class='am-comment-avatar' width='48' height='48'>";	
						content += "</span>";											
					});
  	  				content += "</tbody></table>";
					$("#lookplb").html(content);
					$("#dianzannum").html(data.dianzanNum);
  	  				}	
  	  			);	
  		})		
  	})
  	
  	</script>
</head>
<body>
<article class="am-article">
  <div class="am-article-hd">
    <h1 class="am-article-title">永远的蝴蝶</h1>
    <p class="am-article-meta">陈启佑（台湾）</p>
  </div>

  <div class="am-article-bd">
    <p class="am-article-lead">
      sadfsda
      sadfsda sadfsda
      sadfsda sadfsda
      sadfsda sadfsda
      sadfsda sadfsda
      sadfsda sadfsda
      sadfsda sadfsda
      sadfsda sadfsda
      sadfsda sadfsda
      sadfsda sadfsda
      sadfsda sadfsda
      sadfsda sadfsda
      sadfsda sadfsda
      sadfsda sadfsda
      sadfsda sadfsda
      sadfsda sadfsda
      sadfsda sadfsda
      sadfsda sadfsda
      sadfsda sadfsda
      sadfsda sadfsda
      sadfsda sadfsda
      sadfsda sadfsda
      sadfsda sadfsda
      sadfsda sadfsda
      sadfsda sadfsda
      sadfsda sadfsda
      sadfsda sadfsda
      sadfsda sadfsda
      sadfsda sadfsda
      sadfsda sadfsda
      sadfsda sadfsda
      sadfsda sadfsda
      sadfsda sadfsda
      sadfsda sadfsda
      sadfsda sadfsda
      sadfsda sadfsda
      sadfsda
    </p>
    <p>
    dsaffsdasadf
  </p>
  </div>
</article>
<div class="am-g am-text-sm">
              <div class="am-fr">
                <span>
                  <button href="" data-am-modal="{target: '#my-popup'}" class="am-link-muted"><i class="am-icon-comments"></i>评论(20)</button>

<!--评论弹出框-->
  <div class="am-popup" id="my-popup" style="display: none;">
    <div class="am-popup-inner">
      <div class="am-popup-hd">
        <h4 class="am-popup-title">评论输入窗口</h4>
        <span data-am-modal-close="" class="am-close">×</span>
      </div>
      <div class="am-popup-bd">

         <iframe src="" name="rightF" width="600px" height="550px" marginheight="0" marginwidth="0" style="margin: 0px;padding: 0px;"> </iframe>

  </div>
  </div>
  </div>
<!--评论弹出框结束-->
          </span>
          <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
            <span>
            <button href="" class="am-link-muted" alt="转发">
        <i class="am-icon-share" alt="转发"></i>
        转发(10)</button>
                </span>
                  <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                <span>
                  <a id="dianzan"><button class="am-link-muted"><i class="am-icon-thumbs-up"></i>赞(<span id="dianzannum">${Likecount}</span>)</button></a>
                </span>   
              </div>
            </div>
            <div style="width: 280px; border: 1px solid #A6A6A6; float: right; height: 48px; " id="lookplb"></div>
</body>
</html>
