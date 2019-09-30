
var petsG;
var funcionSeleccionada;
var sillas;

function llenarTabla() {
    $("#tb1").empty();
    $("#thead").empty();
    var fila = "<tr><td name='name'>Nombre</td><td>Responsable</td><td>Edad</td><td>Teléfono</td></tr>";
    $("#thead").append(fila);
    $("#tbody").empty();
    for (i = 0; i < petsG.length; i++) {
        var numFun = i + 1;
        var name = petsG[i].name;
        var owner = petsG[i].owner;
        var age = petsG[i].age;
        var phone = petsG[i].phone;
        var fila = "<tr><td name='nombre'>" + name + "</td><td>" + owner + "</td><td>" + age + "</td><td>" + phone + "</td></tr>";
        $("#tb1").append(fila);
    }
}

function savePetA() {
    console.log($('pName').text());
    console.log("GUARDANDO");


    //var pet = new Object();
    //pet.name = $('pName').val();
    //pet.owner = $('pOwner').val();
    //pet.age = $('pAge').val();
    //pet.phone = $('pPhone').val();

    //console.log(pet.name,  pet.owner,  pet.age);

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
        },

        guardarMascota: function () {
            console.log($("#pName").text());
            console.log("GUARDANDO");
            console.log($('pName').val());
        }
    };
})();
