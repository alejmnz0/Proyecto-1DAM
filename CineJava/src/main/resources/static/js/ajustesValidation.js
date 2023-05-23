function validarFormulario(event) {

    var precioBaseEntrada = obtenerValorCampo("precioBaseEntrada");
    var precioVip = obtenerValorCampo("precioVip");

    if (!esNumero(precioBaseEntrada) || !esNumero(precioVip)) {
        event.preventDefault();

        mostrarMensajeError("Por favor, introduce un número válido.");

        return false;
    }

    return true;
}

function obtenerValorCampo(idCampo) {
    var campo = document.getElementById(idCampo);
    return campo.value;
}

function esNumero(valor) {
    var parsedValue = parseFloat(valor);
    return !isNaN(parsedValue);
}

function mostrarMensajeError(mensaje) {
    var errorMensaje = document.getElementById("errorMensaje");
    errorMensaje.textContent = mensaje;
    errorMensaje.style.display = "block";
}