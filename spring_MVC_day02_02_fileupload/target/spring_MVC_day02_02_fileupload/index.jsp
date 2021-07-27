<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2021/6/18
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<headchuan>
    <title>文件上传</title>
</headchuan>
<body>
    <h3>传统文件上传</h3>

    <%--<a href="user/fileupload1" methods="post">testfileupload1</a>--%>
    <form action="user/fileupload1" method="post" enctype="multipart/form-data">
        选择文件:<input type="file" name="upload"><br>
        <input type="submit" value="上传">
    </form>

    <h3>SpringMVC方式文件上传</h3>

    <%--<a href="user/fileupload1" methods="post">testfileupload1</a>--%>
    <form action="user/fileupload2" method="post" enctype="multipart/form-data">
        选择文件:<input type="file" name="upload"><br>
        <input type="submit" value="上传">
    </form>

    <h3>跨服务器方式文件上传</h3>

    <%--<a href="user/fileupload1" methods="post">testfileupload1</a>--%>
    <form action="user/fileupload3" method="post" enctype="multipart/form-data">
        选择文件:<input type="file" name="upload"><br>
        <input type="submit" value="上传">
    </form>
</body>
</html>
