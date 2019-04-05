var app = angular.module("UserManagement", []);

app.controller("UserManagementController", function($scope, $http) {

	// Initialize page with default data which is blank in this example
	$scope.employees = [];
	$scope.emp;
	$scope.form = {
		sort_by : "",
		emp_id : 0,
		emp_name : "",
		emp_salary : 0,
		project_id : "",
		emp_email : ""
	};

	_refreshPageData();

	$scope.searchEmployee = function() {
		var method = "";
		var url = "";
		if ($scope.form.sort_by == 'manager') {
			method = "GET";
			url = 'rest/employee/' + $scope.form.emp_id + '/managedEmployees';
		} else if ($scope.form.sort_by == 'project') {
			method = "GET";
			url = 'rest/employee/' + $scope.form.emp_id + '/allEmployee';
		} else if ($scope.form.sort_by == 'employee') {
			method = "GET";
			url = 'rest/employee/getEmployee/' + $scope.form.emp_id;
		} else {
			method = "GET";
			url = 'rest/employee/getAllEmployees';
		}
		$http({
			method : method,
			url : url,
		}).then(function successCallback(response) {
			if ($scope.form.sort_by == 'employee') {
				$scope.emp = response.data;
				$scope.employees = [];
				$scope.employees.push($scope.emp);
				console.log($scope.emp);
			} else {
				$scope.employees = response.data.employee;
			}
			console.log($scope.form.sort_by);
			$scope.$watch('employees', function() {
				console.log($scope.employees);
			});
			_refreshPageData();
		}, function errorCallback(response) {
			console.log(response.statusText);
		});

	};

	/*
	 * function _refreshPageData() { $http({ method : 'GET', url :
	 * 'rest/employee/getAllEmployees' }).then(function
	 * successCallback(response) { $scope.employees = response.data;
	 * $scope.employees = response.data.employee; $scope.$watch('employees',
	 * function() { console.log($scope.employees); }); }, function
	 * errorCallback(response) { console.log(response.statusText); }); }
	 */

	function _refreshPageData() {
		$scope.employees = $scope.employees;
	}

	function _success(response) {
		_refreshPageData();
	}

	$scope.deleteEmployee = function() {
		console.log("delete executed");
		console.log($scope.form.emp_id);
		$http({
			method : "DELETE",
			url : 'rest/employee/deleteEmployee/' + $scope.form.emp_id
		}).then(_success, _error);

	};

	$scope.editEmployee = function() {
		console.log("edit executed");
		console.log($scope.form.emp_id);
		$http({
			method : "PUT",
			url : 'rest/employee/updateEmployee',
			data : angular.toJson($scope.form),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(_success, _error);

	};

});
