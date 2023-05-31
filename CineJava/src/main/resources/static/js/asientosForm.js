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

var popoverTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="popover"]'))
var popoverList = popoverTriggerList.map(function (popoverTriggerEl) {
    return new bootstrap.Popover(popoverTriggerEl)
})
var popover = new bootstrap.Popover(document.querySelector('.example-popover'), {
    container: 'body'
})