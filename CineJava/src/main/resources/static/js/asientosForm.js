function submitForm() {
    var checkboxes = document.getElementsByClassName("asiento-checkbox");
    var asientosSeleccionados = [];
    for (var i = 0; i < checkboxes.length; i++) {
        if (checkboxes[i].checked) {
            asientosSeleccionados.push(checkboxes[i].id);
        }
    }   
    document.getElementById("asientosSeleccionadosInput").value = asientosSeleccionados;
}