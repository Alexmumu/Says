<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>Insert title here</title>
	<base href="<%=basePath%>">
	<link rel="stylesheet" type="text/css" href="css/amazeui.css">
	<script src="js/jquery.min.js"></script>
	<script src="js/amazeui.js"></script>
	<script type="text/javascript">
		$(function(){
			$(".am-fr").click(function(){
				
				var useridare1=($(this).find("#useridare1").val());
				
				$("#useridare2").attr('value',useridare1);
				var commentid1=($(this).find("#commentid1").val());
				
				$("#commentid2").attr('value',commentid1);
				var commentsforid1=($(this).find("#commentsforid1").val());
				
				$("#commentsforid2").attr('value',commentsforid1);
				
			})
			
		})
		
	
	</script>
	<style type="text/css">
	li{ list-style-type: none; margin-bottom: 10px;}
	</style>

</head>
<body>
	<div class="am-panel am-panel-default">
  
		<!--评论框-->
							
<!--评论列表
							     <div class="am-g">
				     	<div class="am-u-lg-12">
	
<ul class="am-comments-list">
	
	<li class="am-comment am-comment-primary">
  <a href="#link-to-user-home">
    <img src="" alt="" class="am-comment-avatar" width="48" height="48"/>
  </a>

  <div class="am-comment-main">
    <header class="am-comment-hd">
      <h3 class="am-comment-title">评论标题</h3>
      <div class="am-comment-meta">
        <a href="#link-to-user" class="am-comment-author">某人</a>
        评论于 <time datetime="2013-07-27T04:54:29-07:00" title="2013年7月27日 下午7:54 格林尼治标准时间+0800">2014-7-12 15:30</time>
        <a href="" class="am-fr"> 回复</a>
      </div>
    </header>

    <div class="am-comment-bd">
      ...
    </div>
  </div>
</li>
<li class="am-comment am-comment-flip ">
  <a href="#link-to-user-home">
    <img src="" alt="" class="am-comment-avatar" width="48" height="48"/>
  </a>

  <div class="am-comment-main">
    <header class="am-comment-hd">
      <h3 class="am-comment-title">评论标题</h3>
      <div class="am-comment-meta">
        <a href="#link-to-user" class="am-comment-author">某人</a>
        评论于 <time datetime="2013-07-27T04:54:29-07:00" title="2013年7月27日 下午7:54 格林尼治标准时间+0800">2014-7-12 15:30</time>
        <a href="" class="am-fr"> 回复</a>
      </div>
    </header>

    <div class="am-comment-bd">
      你现在在哪列呢？
    </div>

  </div>
</li>
</ul>
							     	</div>
							     </div>-->
		

<div class="am-panel-bd" style="padding-left:20px;padding-right:20px;">
<c:forEach items="${page1.result}" var="pro">
<li class="am-comment am-comment-primary">
  <a href="">
    <img src="images/${pro.useridare.userimg}" alt="" class="am-comment-avatar" width="48" height="48"/>
  </a>

  <div class="am-comment-main">
    <header class="am-comment-hd">
      <!--<h3 class="am-comment-title">评论标题</h3>-->
      <div class="am-comment-meta">
        <a href="#link-to-user" class="am-comment-author">${pro.userid.usernickname}</a>
        评论于${pro.commentdate} <a  class="am-fr" data-am-modal="{target: '#my-popup'}" >回复 <input type="hidden" id="useridare1" value="${pro.useridare.userid}">
        																		      <input type="hidden" id="commentid1" value="${pro.commentid}">
        																				<input type="hidden" id="commentsforid1" value="${pro.commentsforid}">
        																						</a>
      </div>
    </header>

    <div class="am-comment-bd">
      <p>${pro.commentcontent}</p>
      <blockquote>提醒：我是评论。</blockquote>
    </div>
  </div>
</li>
	<c:forEach items="${pro.saysreply}" var="rep">
		<li class="am-comment am-comment-flip"><a href="#link-to-user-home"><img title="${rep.userid.userimg}" src="images/${rep.userid.userimg}" alt="" class="am-comment-avatar" width="48" height="48"></a><div class="am-comment-main"><header class="am-comment-hd"><div class="am-comment-meta"><a href="#link-to-user" class="am-comment-author">${rep.userid.usernickname }</a> 回复于<span> ${rep.replydate}</span></div></header><div class="am-comment-bd"><p><a href="#lurenyi">@${pro.userid.usernickname}</a> ${rep.replycontent }</p></div></div></li>
	</c:forEach>
</c:forEach>
  <!--  <ul class="am-list">
<c:forEach items="${page1.result}" var="pro">
  <li style="height:80px; line-height:78px;"><span style="display:block;width:80px; float:left;"><img  src="images/${pro.useridare.userimg}" alt="" class="am-comment-avatar" width="48" height="48"></span><span>${pro.commentcontent}</span><span style="float:right;"> <a href="javascript:void(0);" data-am-modal="{target: '#my-popup'}" class="am-link-muted"><i class="am-icon-comments"></i>回复(0) </a></span></li>
  <li ><span style="font-size: 12px;">${pro.userid.usernickname} 在</span><span style="color: blue;">${pro.commentdate}</span><span style="font-size: 12px;">发表了评论</span></li>
 <c:if test="${aaa==myuser.userid}"> <a  id="sanchu" onclick="javascript:window.parent.location.reload();" style="background-color:A2A2A2; font-size:14px; color:blue; margin-top: -118px ; float:right;" class="am-close am-close-alt am-close-spin" href="Comments/deleteComment?commentid=${pro.commentid}">
  x
</a></c:if>
</c:forEach>
  </ul>-->
 <form action="Reply/addReply" method="post">
  <div class="am-popup" id="my-popup" style="display: none;">
   
						<div class="am-popup-inner">
							<div class="am-popup-hd">
								<h4 class="am-popup-title">评论输入窗口<span id="beihuifuid"></span> </h4>
								<span data-am-modal-close="" class="am-close">×</span>
							</div>
							<div class="am-popup-bd">
							 <div class="am-u-lg-14" style="height:100px;">
							<input type="hidden" name="commentid.commentid"   id="commentid2">
							 <input type="hidden" name="useridare.userid"   id="useridare2">
							<input type="hidden" name="commentsforid" id="commentsforid2" >
							 <input type="hidden" name="userid.userid" value="${myuser.userid}">
							 <input type="hidden"  >
							<input type="hidden" name="type" value="${type }"  >
							     	<textarea   name="replycontent"  style="width:100%; height:100%; border:1px solid #A6A6A6; padding: 0px;"></textarea>
							    
							     <div class="am-u-lg-14 ">
							     		<button type="submit" style=" float: right; margin-top:-45px; margin-right: -8px; " class="am-btn am-btn-default am-fr"  >回复</button>
							     </div>	
							     	 </div>
					</div>
					</div>
					
					</div>
</form>
					
 </div>
</body>
</html>