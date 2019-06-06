const modelModule = (function(){
    

	const sendUrl = '/messaging/send'; 
	
	
    return {
        getSendUrl: () => sendUrl
      
    }
})();


var viewModule = (function(){
    var DOMStrings = {
        message: 'message',
        response: 'response',
        topics: 'topics',
        send: 'send'
    };
   
 
    return {
      
        getDOMStrings: () => DOMStrings,
        getMessage: () => document.getElementById(DOMStrings.message).value,
        displayResponse: (message) => document.getElementById(DOMStrings.response).textContent = message,
        clearResponse: () => document.getElementById(DOMStrings.response).textContent = '',
        getTopics: () => Array.from(document.getElementById(DOMStrings.topics).querySelectorAll("input:checked")).map(topic => topic.value),

    }
})();

const controller = (function (model, view){
	const setupEventListeners = () => {
		document.getElementById(view.getDOMStrings().send).addEventListener('click', ()=>{
			view.clearResponse();
			
			let ajax = new XMLHttpRequest();

		
			ajax.open("POST", model.getSendUrl(), true);
			ajax.setRequestHeader("Content-type", "application/json");

			let notification = {
					message: view.getMessage(),
					topics: view.getTopics()
			}
			ajax.send(JSON.stringify(notification));

		
			ajax.onreadystatechange = function() {
				view.displayResponse(ajax.responseText);
				console.log(ajax.responseText);
			}	
		});
	}
		
	
	return {
        init: function(){
            setupEventListeners();
            console.log('Application has started');
        }
    }    

})(modelModule,viewModule);

controller.init();

