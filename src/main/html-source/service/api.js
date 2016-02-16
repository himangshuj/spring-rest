angular.module('htmlSource').factory('api',function($http) {

    var baseUrl="api/";
	var api = {
        getCount:function(){
            return $http.get(baseUrl+"getCount");
        },
        getCompanies:function(pageNo){
            return $http.get(baseUrl+"getAll",{params:{pageNo:pageNo}});
        },
        getDetails:function(companyId){
            return $http.get(baseUrl+'/details/'+companyId);
        }
    };

	return api;
});
