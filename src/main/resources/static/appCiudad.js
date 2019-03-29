var appCiudad = (function(){    

    return {
       getCiudadByName: function(nombre, callback) {
            $.get("/ciudades/"+nombre, function(data) {
                console.log(nombre);
                console.log(data);
                callback(data);
            });
        }
    };
})();
