apiclient = (function () {
    return {
        getPets: function (callback) {
            console.log("Entro a buscar getPets");
            //alert( "Load was performed." );
            $.get('/pets', function (data) {                
                console.log(data);
                callback(data);
            });            
        },
        /*
        savePet: function(pet) {
            console.log("Entro a buscar savePet");
            console.log(pet.name);
            var prtJ = JSON.stringify(pet);
            console.log(prtJ);
            $.post('/pets', pet, function(status) {                
                console.log("Creo la mascota "+status);                
            });
        }*/
        
        savePet: function(pet){
            $.ajax({
                type: 'POST',
                url: "/pets",
                data: JSON.stringify(pet),
                contentType: "application/json",
            }).done(function () {
                alert("La mascota se guardó correctamente.");
            });
        }
    };
})();

