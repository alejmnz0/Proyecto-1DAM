function validarFormulario(event) {

    let precioBaseEntrada = obtenerValorCampo("precioBaseEntrada");
    let precioVip = obtenerValorCampo("precioVip");

    if (!esNumero(precioBaseEntrada) || precioBaseEntrada<1 || !esNumero(precioVip) || precioVip<1) {
        event.preventDefault();

        mostrarMensajeError("Por favor, introduce un número válido.");

        return false;
    }

    return true;
}

function obtenerValorCampo(idCampo) {
    let campo = document.getElementById(idCampo);
    return campo.value;
}

function esNumero(valor) {
    let parsedValue = parseFloat(valor);
    return !isNaN(parsedValue);
}

function mostrarMensajeError(mensaje) {
    let errorMensaje = document.getElementById("errorMensaje");
    errorMensaje.textContent = mensaje;
    errorMensaje.style.display = "block";
}