var app = angular.module("UserManagement", []);

app.controller("UserManagementController", function($scope, $http) {

	// Initialize page with default data which is blank in this example
	$scope.employees = [];
	$scope.form = {
		name : "",
		email : "",
		contact_number : ""
	};

	$scope.submitEmployee = function() {

		$http({
			method : 'GET',
			url : 'rest/employee/getAllEmployees'
		}).then(function successCallback(response) {
			$scope.employees = response.data.employees;
		}, function errorCallback(response) {
			console.log(response.statusText);
		});

	};

	$scope.submitManager = function() {

		$http({
			method : "POST",
			url : "rest/manager/addManager",
			data : angular.toJson($scope.form),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(_success, _error);

	};

});
