<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/2
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>servlet async support</title>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.1.1.min.js" type="text/javascript"></script>
<script type="text/javascript">
    deferred();//页面打开就想服务器发送请求

    function deferred(){
        $.get('defer',function (data) {
            console.log(data);//控制台输出服务器推送的数据
            deferred();//一次请求完成后再向服务器发送请求
        })
    }
</script>


</body>
</html>
