<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <base href="<%=basePath%>">
	<link rel="stylesheet" type="text/css" href="css/amazeui.css">
	<script src="js/jquery.min.js"></script>
  	<script src="js/amazeui.js"></script>
  	<script type="text/javascript">
  	$(function(){
  		$("#pllist").click(function(){
  			$.post(
  	  				"Comments/toAddComments",
  	  				{
  	  	  				'userid.userid':'U001',
  	  	  				'useridare.userid':'U002',
  	  	  				'commentsforid':'S001',
  	  	  				'commentcontent':$("#commentcontent").val(),
  	  	  				},
  	  				function(data){
  	  	  			  var content = "<table border='1' width='100%'>";
						content += "<tbody>";
  	  	  				$.each(data.pinlunlist,function(i,c){
							content += "<tr>";
							content += "<td style='font-size: 14px;'>"+c.userid.userimg + "</td>";	
							content += "<td style='font-size: 14px;'>"+c.commentcontent + "</td>";		
							content += "<td style='font-size: 14px;'>评论于"+c.commentdate + "</td>";		
							content +="<td><a  style='  background-color:A2A2A2; font-size:14px; color:blue;  float:right;' class='am-close am-close-alt am-close-spin'>x</a></td>";
							content += "</tr>";											
						});
  	  	  			content += "</tbody></table>";
						$("#pinlunlist").html(content);
  	  				}	
  	  			);	
  		})		
  	})
  	</script>
</head>
<body>
<div class="am-g" style="background: #fafafa; border:1px dashed #ededef;">

		<!--评论框-->
							<div class="am-g">
							     <div class="am-u-lg-12">
							     	<textarea style="width:100%" name="commentcontent" id="commentcontent"></textarea>
							     </div>
							     </div>

							     <div class="am-g">
							     	 <div class="am-u-lg-12 ">
							     	 <button type="button" id="pllist" class="am-btn am-btn-default am-fr" >确定</button>
							     	</div>
							     </div>
								 

<!--评论列表-->
							     <div class="am-g">
				     	<div class="am-u-lg-12">
	
<ul class="am-comments-list">
	
	<li class="am-comment am-comment-primary">
  <a href="#link-to-user-home">
    <img src="" alt="" class="am-comment-avatar" width="48" height="48"/>
  </a>

  <div class="am-comment-main">
    <header class="am-comment-hd">
      <!--<h3 class="am-comment-title">评论标题</h3>-->
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
      <!--<h3 class="am-comment-title">评论标题</h3>-->
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
							     </div>
							</div>

<div id="pinlunlist">
	<table style=" border: solid 1px black; width:100%">
				<tbody>
					<c:forEach items="${list}" var="l" >
						<tr>
							<td >	
							${l.userid.userimg}
							</td>
							<td >
							${l.commentcontent}	
							</td>
							<td >
							${l.commentdate}	
							</td>
							 <td><a href="Comments/deleteComment?commentid=${l.commentid}" name="l.commentid"  style="background-color:A2A2A2; font-size:14px; color:blue;  float:right;" class="am-close am-close-alt am-close-spin" >
  x
</a></td>
						</tr>
					</c:forEach>
				</tbody>
					</table>
</div>

</body>
</html>