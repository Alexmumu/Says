<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta charset="UTF-8">
	<title>Document</title>
	<base href="<%=basePath%>">
	
	<link rel="stylesheet" type="text/css" href="css/amazeui.css">
		<link rel="stylesheet" type="text/css" href="css/laypage/skin/laypage.css">
	<script src="js/jquery.min.js"></script>
	<script src="js/amazeui.js"></script>
  	  	<script src="css/laypage/laypage.js"></script>
  	  	
	<script type="text/javascript">
  	$(function(){
  		
  			laypage({
		    cont: 'page1', //容器。值支持id名、原生dom对象，jquery对象,
		    pages: 10,//总页数
		    skin: '#AF0000', //加载内置皮肤，也可以直接赋值16进制颜色值，如:#c00
		    groups: 5, //连续显示分页数
		    jump: function(e){
		    	alert(e.curr);
		    }
		});
  	});
  	</script>
</head>
<body>
<div class="am-panel am-panel-default">
  <div class="am-panel-hd" >留言寄语</div>
  <div class="am-panel-bd" style=" text-align:center; ">
    大家好 欢迎来留言！！
  </div>
</div>
	
	
<div class="am-panel am-panel-default">
  <div class="am-panel-hd">留言板</div>
	<div class="am-g" style="background: #fafafa; border:1px dashed #ededef;height:100px;">

		<!--评论框-->
							<div class="am-g">
							     <div class="am-u-lg-12" style="height:100px;">
							     	<textarea style="width:100%; height:100%; border:1px solid #A6A6A6;"></textarea>
							     </div>
							     </div>

							     <div class="am-g">
							     	 <div class="am-u-lg-12 ">
							     	 <a class="am-btn am-btn-default am-fr" href="" style="margin-top:-45px; margin-right:5px;">确定</a>
							     	</div>
							     </div>

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
							</div>
<div class="am-panel-bd">

 
  <ul class="am-list">
  <c:forEach items="${page1.result}" var="pro">
  <li style="height:80px; line-height:78px;"><span style="display:block;width:80px; float:left;"><img src="images/touxiang1.jpg" alt="" class="am-comment-avatar" width="48" height="48"></span><span>${pro.leavewordcontent}</span><span style="float:right;"> <a href="javascript:void(0);" data-am-modal="{target: '#my-popup'}" class="am-link-muted"><i class="am-icon-comments"></i>评论(0)</a></span></li>
  </c:forEach>
  </ul>
  </div>
 
	<div id="page1"></div>
						</div>
					
</body>
</html>