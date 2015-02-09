
var M4M = angular.module('m4mApp', []);


M4M.controller('LibraryController', ['$scope', '$http', function($scope,$http) {
	
	
	$http.get('http://192.241.171.69:8080/Book/webresources/com.percivallucena.book.book').then(function(result) {
	$scope.books = result.data;
	}); 
	
	
}]);

