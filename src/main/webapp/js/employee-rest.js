
var app = angular.module("UserManagement", []);
 
app.controller("UserManagementController", function($scope, $http) {
 
    //Initialize page with default data which is blank in this example
    $scope.employees = [];
    $scope.form = {
		emp_name : "",
		emp_salary : 0,
		project_id : "",
		emp_email : ""
    };
 
    $scope.submitEmployee = function() {
    	
    	$http({
    	    method : "POST",
    	    url : "rest/employee",
    	    data : angular.toJson($scope.form),
    	    headers : {
    	        'Content-Type' : 'application/json'
    	    }
    	}).then( _success, _error );
 
    };
    
    $scope.searchEmployee = function() {
    	
    	$http({
    	    method : "GET",
    	    url : "rest/employee/getAllEmployees",
    	    data : angular.toJson($scope.form),
    	    headers : {
    	        'Content-Type' : 'application/json'
    	    }
    	}).then( _success, _error );
 
    };
 
});


