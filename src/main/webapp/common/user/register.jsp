<%--
  Created by IntelliJ IDEA.
  User: kage
  Date: 2017/7/14
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

        <meta charset="utf-8" />
        <title>用户注册</title>
        <!-- Bootstrap 核心 CSS 文件 -->
        <link href="../static/lib/bootstrap3/css/bootstrap.css" rel="stylesheet">
        <!--font-awesome 核心我CSS 文件-->
        <link href="../static/css/font-awesome.min.css" rel="stylesheet">
        <!-- 在bootstrap.min.js 之前引入 -->
        <script src="../static/js/jquery-3.2.1.js"></script>
        <!-- Bootstrap 核心 JavaScript 文件 -->
        <script src="../static/lib/bootstrap3/js/bootstrap.min.js"></script>
        <!--jquery.validate-->
        <script type="text/javascript" src="../static/lib/jquery-validation-1.16.0/jquery.validate.js" ></script>
        <script type="text/javascript" src="js/message.js" ></script>
        <style type="text/css">
            body{background: url(img/4.jpg) no-repeat;background-size:cover;font-size: 16px;}
            .form{background: rgba(255,255,255,0.2);width:400px;margin:100px auto;}

            #register_form{display: block;}
            .fa{display: inline-block;top: 27px;left: 6px;position: relative;color: #ccc;}
            input[type="text"],input[type="password"]{padding-left:26px;}
            .checkbox{padding-left:21px;}
        </style>

</head>
<body>
<div class="container">


        <div class="form row">
                <form class="form-horizontal col-sm-offset-3 col-md-offset-3" id="register_form" method="post" action="/normal/register_submit">
                        <h3 class="form-title">Register  your account</h3>
                        <div class="col-sm-9 col-md-9">
                                <div class="form-group">
                                        <i class="fa fa-user fa-lg"></i>
                                        <input class="form-control required" type="text" placeholder="Username" name="userName" autofocus="autofocus" id="userName"/>
                                </div>
                                <div class="form-group">
                                        <i class="fa fa-lock fa-lg"></i>
                                        <input class="form-control required" type="password" placeholder="Password" id="password" name="password"/>
                                </div>
                                <div class="form-group">
                                        <i class="fa fa-check fa-lg"></i>
                                        <input class="form-control required" type="password" placeholder="Re-type Your Password" name="rpassword"/>
                                </div>

                                <div class="form-group">
                                        <i class="fa fa-institution fa-lg"></i>
                                        <input class="form-control" type="text" placeholder="city" name="city"/>
                                </div>

                                <div class="form-group">
                                        <i class="fa fa-building fa-lg"></i>
                                        <input class="form-control" type="text" placeholder="address" name="address"/>
                                </div>



                                <div class="form-group text-center">
                                        <input type="submit" class="btn btn-success " value="Sign Up "/>

                                </div>
                        </div>
                </form>
        </div>
</div>
<script type="text/javascript" src="js/main.js" ></script>
</body>
</html>
