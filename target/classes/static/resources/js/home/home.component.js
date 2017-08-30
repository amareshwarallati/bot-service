home.component('home',
	{
		templateUrl : 'resources/js/home/home.template.html',
		controller : ['$http','$scope','$routeParams','$route',
		     function HomeController($http, $scope,$routeParams, $route) {
				$scope.refInstance = "Select an Instance";
				$scope.compInstance="Select an Instance";
				$scope.tableName = "Select a Table";
				$scope.displayOption = 'showMissingRecords';
				$http.get('rest/home' ).then(function(response) {
					console.log(response.data.instances);
					$scope.instances = response.data.instances; 
					$scope.tables = response.data.tables;
					//$scope.showWaitingIcon = false;
		        },
		        function(reason){
		        	alert("failed to get list of available instances..");
		        	//$scope.showWaitingIcon = false;	
		        });
				
				/*
				$scope.hs = ["one", "two", "three"];
				$scope.rs = [{"one":"11", "two":"12", "three":"13"}, {"one":"21", "two":"22", "three":"23"}]
				$scope.news = [["11", "12", "13"], ["21", "22", "23"]]
				*/
				
				$scope.compare = function(){
					$scope.showWaitingIcon = true;
					var data = {
						refInstance: $scope.refInstance,
						compInstance: $scope.compInstance,
						tableName: $scope.tableName,
						whereClause: $scope.whereClause
		            };
					//alert("inside search button.." + $scope.purchaseOrderId);
					$http.post('rest/compare', data, {}).then(function(response) {
						$scope.missingDataList = response.data.dataList1;
						$scope.compareDataList = response.data.dataList2;
						$scope.headers = response.data.headers;
						$scope.refInstance = response.data.refInstance;
						$scope.comInstance = response.data.comInstance;
						$scope.showWaitingIcon = false;
			        },
			        function(reason){
			        	alert("failed to compare table records..");
			        	$scope.showWaitingIcon = false;
			        });
				}
				
				$scope.download = function(){
					$scope.showWaitingIcon = true;
					var data = {
						refInstance: $scope.refInstance,
						compInstance: $scope.compInstance,
						tableName: $scope.tableName,
						whereClause: $scope.whereClause
		            };
					//alert("inside search button.." + $scope.purchaseOrderId);
					$http.post('rest/download', data, {}).then(function(response) {
						
					},
			        function(reason){
			        	alert("failed to download..");
			        	$scope.showWaitingIcon = false;
			        });
				}
		} ]
	}
);


