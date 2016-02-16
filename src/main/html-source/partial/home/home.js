angular.module('htmlSource').controller('HomeCtrl',function($scope,countResp,companiesResp){
    var count = countResp.data;
    $scope.pages = _.range(0,count/10,1);
    $scope.count = count;
    $scope.companies = companiesResp.data;
});
