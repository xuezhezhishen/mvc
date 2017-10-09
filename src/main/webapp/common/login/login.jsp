<%--
  Created by IntelliJ IDEA.
  User: kage
  Date: 2017/7/7
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Login Page</title>
    <link rel="stylesheet" href="../static/css/font-awesome.min.css">
    <link rel="stylesheet" href="../static/lib/bootstrap3/css/bootstrap.css">
    <link rel="stylesheet" href="../static/css/login.css">
    <link rel="stylesheet" type="text/css" href="../static/css/htmleaf-demo.css">

    <!--[if IE]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="htmleaf-container">
    <header class="htmleaf-header">
        <h1>My Login Page <span>Bootstrap Form Style</span></h1>

    </header>
    <div class="demo form-bg" style="padding: 20px 0;">
        <div class="container">
            <div class="row">
                <div class="col-md-offset-3 col-md-6">
                    <form class="form-horizontal" action="${pageContext.request.contextPath}/user/login-submit" method="post">
                        <span class="heading">用户登录</span>
                        <div class="form-group">
                            <input type="text" class="form-control" name="j_username" id="username" placeholder="用户名或电子邮件">
                            <i class="fa fa-user"></i>
                        </div>
                        <div class="form-group help">
                            <input type="password" class="form-control" name="j_password" id="password" placeholder="密　码">
                            <i class="fa fa-lock"></i>
                            <a href="#" class="fa fa-question-circle"></a>
                        </div>
                        <div class="form-group">
                            <div class="main-checkbox">
                                <input type="checkbox" value="None" id="checkbox1" name="check"/>
                                <label for="checkbox1"></label>
                            </div>
                            <span class="text">Remember me</span>
                            <a href="/normal/register" class="btn btn-default"> 注册</a>
                            <button type="submit" class="btn btn-default">登录</button>


                        </div>
                        <div class="form-group">

                        <img src="http://images2015.cnblogs.com/blog/450988/201603/450988-20160316202655146-279652734.gif" alt="">
                    </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>
