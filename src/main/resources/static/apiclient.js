apiclient = (function () {
    return {
        getPets: function (callback) {
            console.log("Entro a buscar getPets");
            //alert( "Load was performed." );
            $.get('/pets', function (data) {                
                console.log(data);
                callback(data);
            });            
        }
        
    };

})();