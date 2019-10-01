
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
    var pet = new Object();
    pet.name = document.getElementById("pName").value;
    pet.owner = document.getElementById("pOwner").value;
    pet.age = parseInt(document.getElementById("pAge").value);
    pet.phone = document.getElementById("pPhone").value;
    alert(pet.name);
    apiclient.savePet(pet);
    console.log("Termino");
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
            console.log("GUARDANDO1");
            var nom = document.getElementById("pName").value;
            alert(nom);
            console.log(document.getElementById("pName").value);
            console.log("GUARDANDO2");
        }
    };
})();
