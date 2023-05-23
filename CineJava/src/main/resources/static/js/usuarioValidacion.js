function validarFormulario() {
    
    limpiarMensajesError();

    
    let nombre = obtenerValorCampo("nombre");
    if (!validarLongitudMaxima(nombre, 50)) {
        mostrarMensajeError("El nombre debe tener como máximo 50 caracteres.", "errorNombre");
        return false;
    }

    
    let apellidos = obtenerValorCampo("apellidos");
    if (!validarLongitudMaxima(apellidos, 50)) {
        mostrarMensajeError("Los apellidos deben tener como máximo 50 caracteres.", "errorApellidos");
        return false;
    }

    
    let email = obtenerValorCampo("username");
    if (!validarLongitudMaxima(email, 100)) {
        mostrarMensajeError("El email debe tener como máximo 100 caracteres.", "errorEmail");
        return false;
    }

    return true;
}

function obtenerValorCampo(idCampo) {
    let campo = document.getElementById(idCampo);
    return campo.value;
}

function validarLongitudMaxima(valor, longitudMaxima) {
    return valor.length <= longitudMaxima;
}

function limpiarMensajesError() {
    let mensajesError = document.getElementsByClassName("mensaje-error");
    for (let i = 0; i < mensajesError.length; i++) {
        mensajesError[i].style.display = "none";
    }
}

function mostrarMensajeError(mensaje, idCampoError) {
    let campoError = document.getElementById(idCampoError);
    campoError.textContent = mensaje;
    campoError.style.display = "block";
}