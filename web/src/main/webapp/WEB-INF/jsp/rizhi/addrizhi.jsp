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
    <title>添加日志</title>
    <base href="<%=basePath%>">
   <link rel="stylesheet" type="text/css" href="css/amazeui.css">
        <link rel="stylesheet" type="text/css" href="css/wangEditor-1.1.0-min.css">
    <link rel="stylesheet" type="text/css" href="css/fontawesome-4.2.0/css/font-awesome.min.css">
    
    <link rel="stylesheet" type="text/css"
	href="js/laypage/skin/laypage.css">
    <script src="js/jquery.min.js"></script>
    <script src="js/amazeui.js"></script>
    <script src="js/laypage/laypage.js"></script>
    <script src="js/laytpl.js"></script>
    <script src="js/laytpl.js"></script>

    <style type="text/css">
        body{
            padding: 0px 10px 0px 10px;
            color:#333333;
        }
    </style>
</head>
<body>
<form class="am-form" action="rizhi/addrizhi" method="post">
<article class="am-article">
  <div class="am-article-hd">
    <p>标题：<input type="text" name="rizhititle" class="am-form-field am-round" placeholder="请输入标题"/></p>
      <div class="am-form-group">
      <label for="doc-select-1">日志类型:</label>
      <select id="doc-select-1" name="rizhitype.typeid">
      <c:forEach items="${type}" var="t">
      <c:if test="${t.typestatus==2}">
        <option  selected="selected" value="${t.typeid}">${t.typename}</option>
         <input type="hidden" name="rizhiuserid.userid" value="${t.userid.userid}">
      </c:if>
       <c:if test="${t.typestatus==1}">
       <option value="${t.typeid}">${t.typename}</option>
       </c:if>
        </c:forEach>
      </select>
      <span class="am-form-caret"></span>
    </div>
  </div>


  <div class="am-article-bd">
   <fieldset>
    <div class="am-form-group">
      <label for="doc-ta-1">内容：</label>
     
      <div id='txtDiv' style='border:1px solid #cccccc; height:240px;'>
        <p>请输入内容...</p>
      </div>
      
      <div style='margin-top:10px;'>

        <textarea id='textarea' name="rizhicontent" style='width:100%; height:100px; margin-top:10px;'></textarea>
      </div>  

    </div>
    
    <p><button type="submit" id='btnHtml' class="am-btn am-btn-default">提交</button></p>
    </fieldset>
    </div>
    </article>
    </form>
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
                $textarea.show();
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