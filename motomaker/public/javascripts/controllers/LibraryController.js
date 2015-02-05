(function(angular) {

var M4M = angular.module('m4mApp', []);


M4M.controller('LibraryController', ['$scope', function($scope) {
	
	$scope.books  = [{"id":1,"author":"Douglas Adams","collection":"fiction","other":"","title":"hitchhiker's guide to the galaxy","user":"plucena@gmail.com"},{"id":1,"author":"George Orwell","collection":"fiction","other":"","title":"1984","user":"plucena@gmail.com"}];
	
}]);

})(window.angular);