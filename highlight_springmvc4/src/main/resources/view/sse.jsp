<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/1
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SSE Demo</title>
</head>
<body>

<div id="msgFormpPush"></div>

<script src="https://code.jquery.com/jquery-3.1.1.min.js" type="text/javascript"></script>
<script type="text/javascript">
    //EventSource只有新式的浏览器才有，EventSoure 是SSE的客户端
    if (!!window.EventSource){
        var source = new EventSource("push");
        s='';
        //添加SSE客户端监听，在此获得浏览器推送的消息
        source.addEventListener('message',function (evt) {
            s += evt.data+"<br/>";
            $("#msgFormpPush").html(s);
        });

        source.addEventListener('open',function (evt) {
            console.log("连接打开");
        },false);

        source.addEventListener('error',function (evt) {
            if (evt.readyState == EventSource.CLOSED){
                console.log("连接关闭");
            } else {
                console.log(evt.readyState);
            }
        },false);
    } else {
        console.log("你的浏览器不支持SSE");
    }

</script>

</body>
</html>
