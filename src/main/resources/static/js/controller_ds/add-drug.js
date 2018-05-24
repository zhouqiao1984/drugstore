'use strict';

app.controller('AddDrugCtrl', function ($scope, $http , $modal, $log) {

    $scope.drug= {};
   /* $scope.passwordAgain = '';
    $scope.provinceId = 'aaa';//省，领域
    $scope.cityId = 'bbb';
    $scope.areaId = '';
    $scope.areas = [];
    $scope.smallAreas = [];
    $scope.sex = -1;*/

/*    var getProvince = function () {
        $http.get('/area/provinces')
            .success(function (data) {
                if(data.resultCode == 'success') {
                    $scope.areas = data.object.sonAreaList;
                    console.log($scope.areas);
                }else{
                    console.log('请求失败');
                }
            })
            .error(function () {
                console.log('请求失败');
            })
    };

    $scope.flag = true;//初始化时下拉框选择是超级管理员时不能选择省份
    $scope.showArea = function () {
        console.log($scope.userRoleTypeId);
        if($scope.userRoleTypeId == 3){
            $scope.flag = true;
            $scope.areaId = '';
            $scope.provinceId = 'aaa';
            $scope.cityId = 'bbb';
        }else{
            $scope.flag = false;
            getProvince();

        }
    };

    $scope.loadCity = function (id) {
        console.log(id);
        if(id == 'aaa'){
            $scope.cityId = 'bbb';
            return;
        }

        $http.get('/area/city/'+id)
            .success(function (data) {
                if(data.resultCode == 'success') {
                    $scope.smallAreas = data.object;
                    console.log($scope.smallAreas);
                }else{
                    console.log('请求失败');
                    $scope.smallAreas = [];
                    $scope.cityId = 'bbb';
                }

            })
            .error(function () {
                console.log('请求失败');
            })
    };*/

    $scope.reset = function () {
        $scope.drug = {};
    };

    $scope.submit = function () {
        $http({
            url: '/drug/add',
            method: 'POST',
            data: $scope.drug
        })
            .success(function (data) {
                if(data.resultCode == 'success'){
                    var result = 1;
                    $scope.open(result);
                }else{
                     result = 2;
                    $scope.open(result);
                }
            })
            .error(function () {
                var result = 2;
                $scope.open(result);
            })
    };


    $scope.open = function (result) {
        var modalInstance = $modal.open({
            templateUrl: 'addEnd.html',
            controller: 'ModalInstanceCtrl7',
            size: 'sm',
            resolve:{
                flag: function () {
                    return result;
                }
            }
        });

        modalInstance.result.then(function (flag) {
            if(flag == 1){
                $scope.drug = {};

            }
        },function (flag) {
            if(flag == 1){
                $scope.drug = {};
            }
                $log.info('Modal dismissed at :' + new Date());
        });
    };


});