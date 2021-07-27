<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2021/6/10
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js"></script>
    <script>
        //页面加载,绑定单机
        $(function () {
            $("#bt").click(function () {
                // alert("hello btn");
                $.ajax({
                    url:"user/testAjax",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"username":"zhaolele","password":"456","age":20}',
                    dataType:"json",
                    type:"post",
                    success:function (data) {
                        //data服务器端响应json的数据,进行解析
                        alert(data);
                        alert(data.password);
                        alert(data.username);
                        alert(data.age);
                    }
                });
            });
        });
    </script>
</head>


<body>
    <a href="user/testString">testString</a><br>

    <a href="user/testVoid">testVoid</a><br>

    <a href="user/testModelAndView">testModelAndView</a><br>

    <button id="bt">发送ajax的请求</button>


</body>
</html>
