angular.module('htmlSource', ['ui.bootstrap','ui.utils','ui.router','ngAnimate']);

angular.module('htmlSource').config(function($stateProvider, $urlRouterProvider) {

    $stateProvider.state('home', {
        url: '/home/:pageNo',
        templateUrl: 'partial/home/home.html',
        controller:'HomeCtrl',
        resolve:{
            countResp:['api' ,function(api){
                return api.getCount();
            }],
            companiesResp:['api','$stateParams',function(api,$stateParams){
                return api.getCompanies($stateParams.pageNo||0);
            }]
        }
    });
    $stateProvider.state('details', {
        url: '/details/:companyId',
        templateUrl: 'partial/details/details.html',
        controller:'DetailsCtrl',
        resolve: {
            detailsResp: ['api','$stateParams', function (api,$stateParams) {
                return api.getDetails($stateParams.companyId);
            }]
        }
    });
    /* Add New States Above */
    $urlRouterProvider.otherwise('/home/0');

});

angular.module('htmlSource').run(function($rootScope) {

    $rootScope.safeApply = function(fn) {
        var phase = $rootScope.$$phase;
        if (phase === '$apply' || phase === '$digest') {
            if (fn && (typeof(fn) === 'function')) {
                fn();
            }
        } else {
            this.$apply(fn);
        }
    };

});
