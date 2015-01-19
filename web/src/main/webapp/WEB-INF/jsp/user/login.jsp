<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
  <meta charset="utf-8">
   <base href="<%=basePath%>">
  <link rel="stylesheet" type="text/css" href="css/amazeui.css">
  <link rel="stylesheet" type="text/css" href="css/login.css">
  <script src="js/jquery.min.js"></script>
  <script src="js/amazeui.js"></script>
  <script src="js/login.js"></script>
  <title>登录页面</title>
 <script type="text/javascript">
	 function message()
	 {
		 var uname = document.d1.username.value;
		 var upwd = document.d1.userpassword.value;
			if(uname.length==0){
				alert("输入账号不能为空");
				return false;
			}
			if(upwd.length==0){
				alert("输入密码不能为空");
				return false;
			} 
	 }
	 
	 function message2()
	 {
		 var uname = document.d2.username.value;
		 var upwd = document.d2.userpassword.value;
			if(uname.length==0){
				alert("输入账号不能为空");
				return false;
			}
			if(upwd.length==0){
				alert("输入密码不能为空");
				return false;
			} 
	 }
</script> 
  
</head>
<body style="height:100%; background-color:#f1f5f8;" >
	<!-- 登录失败报错弹窗开始 -->
	<div class="am-modal am-modal-alert" tabindex="-1" id="my-alert">
  <div class="am-modal-dialog">
    <div class="am-modal-hd">登录提示</div>
    <div class="am-modal-bd">
      	你的帐号或密码错误
      	
    </div>
    <div class="am-modal-footer">
      <span class="am-modal-btn">确定</span>
    </div>
  </div>
</div>
<!-- 登录失败报错结束 -->

  <!--忘记密码弹出框开始-->
  <div class="am-popup" id="my-popup" style="display: none;">
    <div class="am-popup-inner">
      	<div class="am-popup-hd">
      	  <h4 class="am-popup-title">输入窗口</h4>
        <span data-am-modal-close="关闭" class="am-close">关闭</span>
      	</div>
      	<div class="am-popup-bd">
         	<iframe src="userzh/touserzhanghao" name="rightF" width="100%" height="620px" marginheight="0" marginwidth="0" style="margin: 0px;padding: 0px;"> </iframe>
  		</div>
  	</div>
  </div>
<!--忘记密码弹出框结束-->
	
  <div class="header" style="text-align:center;background: url(images/body_1.png);color:#FFF;min-height:220px;box-shadow: 0 2px 3px rgba(0,0,0,0.3);">
    <div class="am-g">
      <h1 class="am-kai" style="margin-top:30px; font-size:50px;">想说网</h1>
      <p>
        Thinking of you say you want to say
        <br>想你所想，说你想说</p>
    </div>
  </div>
  <hr>
  <div class="am-g">
    <div class="am-container">
      <div class="am-u-lg-6 am-u-md-8 am-u-sm-centered">
        <div data-am-widget="tabs" data-am-tabs="{noSwipe: 1}" class="am-tabs am-tabs-default" style="background-color:#FFF;box-shadow: 0 2px 3px rgba(0,0,0,0.3);">
          <ul class="am-tabs-nav am-cf">
            <li class="am-active">
              <a href="[data-tab-panel-0]">登录</a>
            </li>
            <li class="">
              <a href="[data-tab-panel-1]">注册</a>
            </li>
          </ul>

          <div class="am-tabs-bd">
            <div data-tab-panel-0 class="am-tab-panel am-active">
            <form id="dengluform" class="am-form" method="post">
              <fieldset style="margin-bottom: 0px;">
                <legend>用户登录</legend> ${msg}
                <div class="am-form-group">
                  <label >帐号：</label>
                  <input type="text" name="username"  placeholder="帐号" />
                </div>

                <div class="am-form-group">
                  <label >密码：</label>
                  <input type="password" name="userpassword"  placeholder="密码" />
                </div>
              </fieldset>
            </form>
              <div >
                <button class="am-btn am-btn-default" id="dengluok">登录</button>
                 <input type="button" name="" value="忘记密码 ^_^? " class="am-btn am-btn-default am-btn-sm am-fr" data-am-modal="{target: '#my-popup'}"></div>
            	</div>
           <div data-tab-panel-1 class="am-tab-panel">
              <form action="user/useradd" method="post" onsubmit="return message2()" class="am-form" data-am-validator name="d2">
                <fieldset>
                  <legend>用户注册</legend>
                  
                  <div class="am-form-group">
                    <label for="doc-vld-name-2">帐号：</label>
                    <input type="text" id="doc-vld-name-2" name="username" placeholder="输入注册帐号"/>
                  </div>

                  <div class="am-form-group">
                    <label for="doc-vld-email-2">密码：</label>
                    <input type="password"  placeholder="输入注册密码" name="userpassword" />
                  </div>
                  <button class="am-btn am-btn-default" type="submit">注册</button>
                </fieldset>
              </form>
         </div>
      </div>
    </div>
  </div>
</div>
</div>
</body>
</html>

</body>
</html>