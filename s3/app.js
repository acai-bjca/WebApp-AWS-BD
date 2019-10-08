
var petsG;
var funcionSeleccionada;

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
    apiclient.savePet(pet);    
}

app = (function () {
    var mascotas;

    return {
        obtenerMascotas: function (pets) {
            mascotas = pets;
            petsG = pets;
            llenarTabla();            
        },

        buscarMascotas: function () {
            console.log("Entro a buscar mascotas");            
            apiclient.getPets(app.obtenerMascotas);            
        }
    };
})();
