/**
 * 
 */
app.factory('metrics', metrics);

function metrics($http,globalVars){
	
	var service = {};

	service.get = function (businessObject,frequency,id,callback){

		var callurl = globalVars.apiUrl + 'api/metric/' + businessObject + '.' + frequency + '.' + id;
		
		var httpMethod = {
				method: 'GET',
				url: callurl
		};

		$http(httpMethod).then(callback);
	}

	console.log("created metrics");
	
	return service;
}