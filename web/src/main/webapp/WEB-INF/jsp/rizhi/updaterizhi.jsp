<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
    <title>编辑日志内容</title>
    <base href="<%=basePath%>">
   <link rel="stylesheet" type="text/css" href="css/amazeui.css">
        <link rel="stylesheet" type="text/css" href="css/wangEditor-1.1.0-min.css">
    <link rel="stylesheet" type="text/css" href="css/fontawesome-4.2.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css"
	href="js/laypage/skin/laypage.css">
	<link rel="stylesheet" type="text/css" href="css/appdefault.css">

	
    <script src="js/jquery.min.js"></script>
    <script src="js/amazeui.js"></script>
    <script src="js/laypage/laypage.js"></script>
    <script src="js/laytpl.js"></script>
    <script src="js/laytpl.js"></script>

    <style type="text/css">
        body{
            padding: 0px 10px 0px 10px;
            color:#333333;
            background-color: rgb(237, 237, 239);
        }
    </style>
</head>
<body>
<div class="am-g ">
 <div class="am-container">
		<div class="am-u-sm-12 am-animation-slide-left block">

<form class="am-form" action="rizhi/updaterizhi" method="post">
<article class="am-article">
  <div class="am-article-hd">
    <p>标题：<input type="text" name="rizhititle" class="am-form-field am-round" value="${rz1.rizhititle}"/></p>
      <div class="am-form-group">
      <label for="doc-select-1">日志类型:</label>
      <select id="doc-select-1" name="rizhitype.typeid">
        <c:forEach items="${type}" var="t">
        <option  selected="selected" value="${t.typeid}">${t.typename}</option>
        </c:forEach>
      </select>
      <span class="am-form-caret"></span>
    </div>
  </div>
   <input type="hidden" name="rizhiuserid.userid" value="${rz1.rizhiuserid.userid}">
    <input type="hidden" name="rizhiid" value="${rz1.rizhiid}">
   <input type="hidden" name="rizhidate" value="${rz1.rizhidate}">
   <input type="hidden" name="rizhinature" value="${rz1.rizhinature}">
   <input type="hidden" name="rizhistatus" value="${rz1.rizhistatus}">


  <div class="am-article-bd">
   <fieldset>
    <div class="am-form-group">
      <label for="doc-ta-1">内容：</label>
     
      <div id='txtDiv' style='border:1px solid #cccccc; height:240px;'>
        <p>${rz1.rizhicontent}</p>
      </div>
      
      <div style='margin-top:10px;'>

        <textarea id='textarea' name="rizhicontent" style='width:100%; height:100px; margin-top:10px;'></textarea>
      </div>  

    </div>
    
    <p><span><button type="submit" id='btnHtml' class="am-btn am-btn-secondary">修改</button></span>
        <span><a  href="javascript:history.go(-1)" class="am-btn  am-btn-default">取消</a></span>
    </p>
    </fieldset>
    </div>
    </article>
    </form>
    </div>
    </div>
    </div>
</body>
<script type="text/javascript" src='js/wangEditor-1.1.0-min.js'></script>
    <script type="text/javascript">
        $(function(){
            $('#spanTime').text((new Date()).toString());

            //一句话，即可把一个div 变为一个富文本框！o(∩_∩)o 
            var $editor = $('#txtDiv').wangEditor();

            //显示 html / text
            var $textarea = $('#textarea'),
                $btnHtml = $('#btnHtml'),
                $btnText = $('#btnText'),
                $btnHide = $('#btnHide');
            $textarea.hide();
            $btnHtml.click(function(){
                //$textarea.show();
                $textarea.val( $editor.html() );
            });
            $btnText.click(function(){
                $textarea.show();
                $textarea.val( $editor.text() );
            });
            $btnHide.click(function(){
                $textarea.hide();
            });
        });
    </script>
</html>