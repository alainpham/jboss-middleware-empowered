/**
 * 
 */
app.factory('globalVars', globalVars);

function globalVars(){
	
	var service = {};
	
	service.appTitle = 'Trade Orders SLA monitoring';
	service.businessObject = 'com.redhat.empowered.specific.model.trading.TradeProcessingDuration';
	service.updateIntervalMs = 2000;
	service.apiUrl= "";
	console.log("created globalVars");
	return service;
	
	
}