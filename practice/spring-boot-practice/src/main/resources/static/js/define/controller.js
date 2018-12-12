
//定义控制器View1Controller，并注入$rootScope,$scope,$http
actionApp.controller('View1Controller',['$rootScope','$scope','$http',
function ($rootScope,$scope,$http) {
    //使用$scope.$on监听$viewContentLoaded事件，可以在页面加载完成后进行一些操作
    $scope.$on('$viewContentLoaded',function () {
        console.log("页面加载完成");
    });
    //在scope内定义一个search方法，在页面上通过ng-click调用
    $scope.search=function () {
        personName = $scope.personName;//通过$scope.personName获取页面定义的ng-model="personName"的值
        $http.get('search',{//使用$http.get向服务端地址search发送get请求
            params:{personName:personName}//使用params增加请求参数
        }).success(function (data) {//用success方法作为请求成功后的回调
            $scope.person=data;//将服务端返回的数据data通过$scope.person赋给模型person，
            // 这样在页面视图上就可以通过${person.name}来调用，且模型person值改变后，视图是自动更新的
        });
    };
}]);

actionApp.controller('View2Controller',['$rootScope','$scope','$http',
function ($rootScope,$scope,$http) {
    $scope.$on('$viewContentLoaded',function () {
        console.log("页面加载完成");
    })
}])