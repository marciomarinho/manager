manager.controller('MasterController', ['$scope', function($scope) {

    $scope.form = '';

    $scope.validationFeedback = function(element) {
        var result;
        if ($scope.form.$submitted || element.$touched) {
            if (element.$invalid && ($scope.form.$submitted || element.$touched)) {
                result = 'has-feedback';
                result = result + ' has-error'
            }
        }
        return result;
    };

    $scope.showError = function(element) {
        var result = false;
        if ((element.$invalid) && ($scope.form.$submitted || element.$touched)) {
            result = true;
        }
        return result;
    };

    $scope.isFormInvalid = function() {
        console.log($scope.form.$invalid);
        return $scope.form.$invalid;
    }

}]);