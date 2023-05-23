function validarFormulario() {
    
    limpiarMensajesError();

    
    let titulo = obtenerValorCampo("titulo");
    if (!validarLongitudMaxima(titulo, 30)) {
        mostrarMensajeError("El título debe tener como máximo 30 caracteres.", "errorTitulo");
        return false;
    }

    
    let sinopsis = obtenerValorCampo("sinopsis");
    if (!validarLongitudMaxima(sinopsis, 250)) {
        mostrarMensajeError("La sinopsis debe tener como máximo 250 caracteres.", "errorSinopsis");
        return false;
    }

    
    let altPortada = obtenerValorCampo("altPortada");
    if (!validarLongitudMaxima(altPortada, 40)) {
        mostrarMensajeError("El texto alternativo de la portada debe tener como máximo 40 caracteres.", "errorAltPortada");
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