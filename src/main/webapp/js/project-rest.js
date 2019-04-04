
var app = angular.module("UserManagement", []);
 
app.controller("UserManagementController", function($scope, $http) {
 
    //Initialize page with default data which is blank in this example
    $scope.employees = [];
    $scope.form = {
		project_name : "",
		project_location : "",
		manager_id : ""
    };
 
    $scope.submitEmployee = function() {
    	
    	$http({
    	    method : "POST",
    	    url : "rest/project/addProject",
    	    data : angular.toJson($scope.form),
    	    headers : {
    	        'Content-Type' : 'application/json'
    	    }
    	}).then( _success, _error );
 
    };
        
});


