document.getElementById("titulo")
document.getElementById("sinopsis")
document.getElementById("altPortada")
document.getElementById("portada")

function validarForm() {
    let correcto = compTitulo() && compSinopsis()
        && compAltPortada() && compPortada();

    return correcto;
}

function compTitulo() {
    let titulo = formPelis.titulo;
    let correcto = titulo.lenght() > 1;

    return correcto;
}