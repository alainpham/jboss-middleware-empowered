(function () {
  'use strict';

  angular
    .module('app')
    .directive('slaOverview', SlaOverviewDirective);

function SlaOverviewDirective() {

      return {
        restrict:     "AE",
        templateUrl:  "template/aggregate-status.html",
        controllerAs: 'vm' ,
        controller: 'MetricAnalysisController'
        }
    }; // END function SlaOverviewDirective

})();
