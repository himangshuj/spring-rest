angular.module('htmlSource').controller('DetailsCtrl', function ($scope, detailsResp,api,$window,$state) {
    //noinspection JSUnresolvedVariable
    $scope.details = detailsResp.data.companyId ? detailsResp.data : {};
    $scope.details.owners = $scope.details.owners ||[];
    $scope.addOwners = function(companyId,newOwner){
        api.addOwner(companyId,newOwner).then(function(resp){
            if(resp.status===200 && resp.data==="1"){
                $state.go('details',{companyId:companyId});
            }
        });
    };
    $scope.update = function(details){
        if(details.companyId){
            api.update(details.companyId,details).then(function(resp){
                if(resp.status===200 && resp.data==="1"){
                    $state.go('details',{companyId:details.companyId});
                }
            });
        }else{
            api.add(details).then(function(resp){
                if(resp.status===200 && resp.data.companyId){
                    $state.go('details',{companyId:resp.data.companyId});
                }
            });
        }

    };

    //noinspection JSUnresolvedVariable
    $scope.formType = detailsResp.data.companyId ? 'update':'add';
});
