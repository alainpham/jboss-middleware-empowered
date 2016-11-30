(function () {
  'use strict';

  angular
    .module('app')
    .controller('MetricAnalysisController', MetricAnalysisController);

  MetricAnalysisController.$inject = ['$interval', 'TradeService'];

  function MetricAnalysisController($interval, TradeService) {
    var vm = this;

    function configChart() {
        // --------- Top Drinker Chart ---------
        var c3ChartDefaults = $().c3ChartDefaults();

        var verticalBarChartConfig = $().c3ChartDefaults().getDefaultBarConfig();
        verticalBarChartConfig.bindto = '#vbar-chart';

        verticalBarChartConfig.data = {
          type: 'bar',
          x : 'x',
          columns: []
        };

        var verticalBarChart = c3.generate(verticalBarChartConfig);
        // --------- End Top Drinker Chart ---------

        return {
          "verticalBarChart" : verticalBarChart
        }
      }; // END function configChart

    function dataChart(charts) {
      TradeService.tradeProcessingDuration()
          .then(function (result) {
              if (result !== null) {
                vm.jdgData = result;
                vm.tptStatus = (vm.jdgData.actualSlaValue > vm.jdgData.expectedSlaValue);

               var xValues = ['x'];
               var yValues = ['data1'];

               for (var i = 0; i < vm.jdgData.frequencyDataAsList.length; i++) {
                 xValues.push(vm.jdgData.frequencyDataAsList[i].x);
                 yValues.push(vm.jdgData.frequencyDataAsList[i].y);
               }

                var limitSlaXGrid = {
                  value: vm.jdgData.expectedSlaValue
                  , class : 'limit-sla-grid'
                  , text: 'Limit SLA'
                  , position: 'middle'
                };

                var actualSlaXGrid = {
                  value: vm.jdgData.actualSlaValue
                  , class : (vm.tptStatus ? 'actual-ko-sla-grid' : 'actual-ok-sla-grid')
                  , text: 'Actual SLA'
                };

                charts['verticalBarChart'].xgrids([
                  limitSlaXGrid,
                  actualSlaXGrid
                ]);

                charts['verticalBarChart'].regions([
                  { axis : 'x', end : vm.jdgData.expectedSlaValue, class : 'sla-ok-region' }
                  ,{axis: 'x', start: vm.jdgData.expectedSlaValue, class: 'sla-ko-region'}
                ]);

               charts['verticalBarChart'].load({
                 columns: [
                   xValues
                   , yValues
                 ]
               });
              }
          });
    }; // END function updateMetricAnalysis

    // ---------------------------------
    // MAIN
    // ---------------------------------
    var charts = configChart();
    dataChart(charts);

    $interval(function() {
       dataChart(charts);
    }, 1500);

  }; // END function Controller
})();
