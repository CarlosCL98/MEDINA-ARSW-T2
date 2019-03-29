var app = (function(){

    var mostrarCiudad = function(ciudad) {
        $("#weatherTable").find("thead").append("<tr><th>Name</th><th>Temperature</th><th>Humidity</th><th>Pressure</th><th>Tem Minima</th><th>Tem Maxima</th></tr>");
        $("#weatherTable").find("tbody").append("<tr><td>"+ciudad.name+"</td><td>"+ciudad.main.humidity+"</td><td>"+ciudad.main.pressure+"</td><td>"+ciudad.main.temp+"</td><td>"+ciudad.main.temp_min+"</td><td>"+ciudad.main.temp_max+"</td></tr>");
    }

    return {
        getCiudadByName:function() {
            var nombre = $("#CiudadInput").val();
            appCiudad.getCiudadByName(nombre, mostrarCiudad);
        }
    }
})();
