<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<html lang="en">
<head>
   <meta charset="utf-8">
   <base href="<%=basePath%>">
   <title>Document</title>
    <link rel="stylesheet" type="text/css" href="css/amazeui.css">
   <script src="js/jquery.min.js"></script>
  <script src="js/amazeui.js"></script>
  <script type="text/javascript">
//为了让父窗口弹出模态窗 里面方的是ifream
function tanchuang(url){
	//1.获取父窗口的元素 这个元素我方在了top。jsp里面 然后改属性 就是改url地址
	$('#myframe',window.parent.document).attr('src',url);
	//2.使用模态窗口的方法 激活弹出
	$('#my-popup',window.parent.document).modal('open');
}
</script>
</head>
<body style="background-color: rgb(237, 237, 239);" >
<div class="am-g am-animation-slide-left ">
<div class="am-container">
  <div class="am-panel am-panel-default">
  <div class="am-panel-hd">${album.albumtitle}相册 
  <c:if test="${album.userid.userid==myuser.userid}">
  	 <a href="javascript:void(0)" 
       class="am-icon-cloud-download am-icon-md" 
       style="margin-left: 20px;" onclick="tanchuang('photo/toadd?albumid=${album.albumid}')" >上传照片</a>
  </c:if>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  
  <span class="am-icon-eye am-fr">
  ${yuedu}人浏览
  </span>
  <a href="javascript:history.go(-1);" >返回</a>

  
  
  
 
  
  </div>
   
  <div class="am-panel-bd">
<figure data-am-widget="figure" class="am am-figure am-figure-default "
data-am-figure="{  pureview: 'auto' }">
<ul class="am-avg-lg-3 am-thumbnail">
 <c:if test="${ empty photo.result}">
         <h3 align="center">还没有靓照哦！</h3>
 </c:if>
 
 <c:if test="${ not empty photo.result}">
  <c:forEach items="${photo.result}" var="p">
<li>
<img src="images/photo/${p.data.photosrc}" data-rel=" images/photo/${p.data.photosrc}"alt="${p.data.photosrc}" style="width: 250px;height: 300px;"/>
       <div style="float: right;">
       
       <c:if test="${album.userid.userid==myuser.userid}">
           <a href="photo/delectphoto?photoid=${p.data.photoid}&albumid=${p.data.albumid.albumid}" style="position: absolute;  margin-top:-45px;color:#0e90d2;
         margin-left:-70px;  width:20px;" class="am-icon-trash am-icon-md" title="删除"></a>
         </c:if>
       </div>
<input type="hidden" value="${p.data.albumid.albumid}" name="albumid">
              
   <figcaption class="am-figure-capition-btm"> <div class="am-g am-text-sm">
              <div class="">
                <span>
                  <a href="javascript:void(0);" data-am-modal="{target: '#my-popup'}" class="am-link-muted"><i class="am-icon-comments"></i>评论(${p.pinglunnum})</a>
 
<!--评论弹出框-->
  <div class="am-popup" id="my-popup" style="display: none;">
    <div class="am-popup-inner">
      <div class="am-popup-hd">
        <h4 class="am-popup-title">评论输入窗口</h4>
        <span data-am-modal-close="" class="am-close">×</span>
      </div>
      <div class="am-popup-bd">

         <iframe src="pinglun.html" name="rightF" width="600px" height="550px" marginheight="0" marginwidth="0" style="margin: 0px;padding: 0px;"> </iframe>

  </div>
  </div>
  </div>
  
    

  
  
<!--评论弹出框结束-->
          </span>
          <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
            <span>
            <a href="" class="am-link-muted" alt="转发">
        <i class="am-icon-share" alt="转发"></i>
        转发(${p.zhuanfanum})</a>
                </span>
                  <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                <span>
                  <a href="" class="am-link-muted"><i class="am-icon-thumbs-up"></i>赞(${p.dianzannum})</a>
                </span>

              </div>
            </div>
            </figcaption>

  
</li>
 </c:forEach> 
 </c:if>
</ul>




  





<ul class="am-pagination am-pagination-centered ">
	<c:if test="${page.pageNo<=1}">
  	<li class="am-pagination am-disabled"><a href="photo/listphoto?albumid=${albumid}&pageNo=${page.pageNo-1}&userid=${album.userid.userid}">&laquo; 上一页</a></li>
  </c:if>
  <c:if test="${page.pageNo>1}">
  	<li class="am-pagination"><a href="photo/listphoto?albumid=${albumid}&pageNo=${page.pageNo-1}&userid=${album.userid.userid}">&laquo; 上一页</a></li>
  </c:if>
  <c:if test="${page.pageNo==page.pageSum}">
  <li class="am-pagination am-disabled"><a href="photo/listphoto?albumid=${albumid}&pageNo=${page.pageNo+1}&userid=${album.userid.userid}">下一页 &raquo;</a></li>
  </c:if>
  <c:if test="${page.pageNo!=page.pageSum}">
  <li class="am-pagination"><a href="photo/listphoto?albumid=${albumid}&pageNo=${page.pageNo+1}&userid=${album.userid.userid}">下一页 &raquo;</a></li>
  </c:if>
</ul>
</figure>
 
</div>
</div>
</div>
</div>


</body>
</html>