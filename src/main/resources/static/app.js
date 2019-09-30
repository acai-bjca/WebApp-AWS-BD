
var petsG;
var funcionSeleccionada;
var sillas;

function llenarTabla() {
    $("#tb1").empty();
    $("#thead").empty();
    var fila = "<tr><td name='nombre'>Nombre</td><td>Responsable</td><td>Edad</td><td>Teléfono</td></tr>";    
    $("#thead").append(fila);   
    $("#tbody").empty();
    for (i = 0; i < petsG.length; i++) {
        var numFun = i + 1;
        var pelicula = petsG[i].name;
        var responsable = sillasDisponibles(funciones[i].seats);
        var edad = funciones[i].date;
        var telefono = funciones[i].date;
        var fila = "<tr><td name='nombre'>" + pelicula + "</td><td>" + responsable + "</td><td>" + edad + "</td><td>" + telefono + "</td></tr>";
        $("#tb1").append(fila);
    }
}

function sillasDisponibles(sillas) {
    var cont = 0;
    for (var i = 1; i < sillas.length; i++) {
        for (var j = 1; j < sillas[i].length; j++) {
            if (sillas[i][j] == true) {
                cont++;
            }
        }
    }
    return cont;
}

app = (function () {
    var mascotas;

    return {
        obtenerMascotas: function (pets) {
            mascotas = pets;
            petsG = pets;            
            llenarTabla();
            //document.getElementById("funcionesTxt").innerHTML = functionscinema[0].movie.name;
        },

        buscarMascotas: function () {
            console.log("Entro a buscar mascotas");
            //document.getElementById("funcionesTxt").innerHTML = "function app";
            apiclient.getPets(app.obtenerMascotas);
            //apimock.getCinemaByName(nameCinema, app.obtenerFunciones);
        }
    };
})();
