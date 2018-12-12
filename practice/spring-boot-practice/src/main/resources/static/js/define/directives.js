//定义一个指令名为datePicker
actionApp.directive('datePicker',function () {
    return{
        restrict:'AC',//限制为属性指定和样式指令restrict：是指令的类型，有四种取值：E：以元素的方式出现;A：以属性的方式出现C：以类的方式出现（用的比较少）M：以注释的方式（用的少）
        link:function (scope,elem,attrs) {//使用link方法来定义指令，在link方法内可使用当前scope、当前元素及元素属性
            elem.datepicker();//初始化jqueryui的datePicker（jquery的写法是$('#id').datePicker()）
        }
    }

})