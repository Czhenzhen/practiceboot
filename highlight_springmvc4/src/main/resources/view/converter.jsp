<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/1
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HttpMessageConverter Demo</title>
</head>
<body>
<div id="resp"></div>
<input type="button" onclick="req()" value="请求"/>

<script src="https://code.jquery.com/jquery-3.1.1.min.js" type="text/javascript"></script>
<script>
    function req() {
        $.ajax({
           url:"convert",
           data:"1-zhangsan",
           type:"POST",
            contentType:"application/x-wisely",
            success:function(data){
               $("#resp").html(data);
            }
        });
    }

</script>

</body>
</html>
