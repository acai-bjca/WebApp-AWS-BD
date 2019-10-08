apiclient = (function () {
    return {
        getPets1: function (callback) {
            console.log("Entro a buscar getPets");
            //alert( "Load was performed." );
            $.get('/pets', function (data) {                
                console.log(data);
                callback(data);
            });            
        },
        savePet1: function(pet){
            $.ajax({
                type: 'POST',
                url: "/pets",
                data: JSON.stringify(pet),
                contentType: "application/json",
            }).done(function () {
                alert("La mascota se guardó correctamente.");
            }).fail(function () {
                alert("La mascota se guardó correctamente.");
            });
        },
        savePet: function(pet){
            console.log("Entro a buscar savePet");
            axios({
                method: 'post',
                url: 'http://ec2-35-175-225-106.compute-1.amazonaws.com:8080/pets',
                //data: JSON.stringify(pet),
                data: pet,
                contentType: 'application/json'
            });
            /*
            axios.post('http://ec2-54-90-224-213.compute-1.amazonaws.com:8080/pets', {
            data: JSON.stringify(pet),
            contentType: "application/json"
            });*/
        },
        getPets: function(callback){
            console.log("Entro a buscar getPets");
            axios.get('http://ec2-35-175-225-106.compute-1.amazonaws.com:8080/pets')
            .then(response => {
                // JSON responses are automatically parsed.
                callback(response.data);
            });
        } 
    };
})();

