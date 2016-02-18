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
            return $http.get(baseUrl+'details/'+companyId);
        },
        addOwner:function(companyId,owner){
            return $http.get(baseUrl+'addOwner/'+companyId,{params:{owner:owner}});
        },
        add:function(details){
            return $http.post(baseUrl+'insert',details);
        },
        update:function(companyId,details){
            return $http.post(baseUrl+'update/'+companyId,details);
        }


    };

	return api;
});
