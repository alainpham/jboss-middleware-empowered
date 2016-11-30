(function () {
  'use strict';

  angular
    .module('app')
    .directive('metricAnalysis', MetricAnalysisDirective);

function MetricAnalysisDirective() {

      return {
        restrict:     "AE",
        templateUrl:  "template/bar-chart.html",
        controllerAs: 'vm' ,
        controller: 'MetricAnalysisController'
        }
    }; // END function MetricAnalysisDirective

})();
