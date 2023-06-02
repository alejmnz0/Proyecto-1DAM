function submitForm() {
    let checkboxes = document.getElementsByClassName("asiento-checkbox");
    let asientosSeleccionados = [];
    for (let i = 0; i < checkboxes.length; i++) {
        if (checkboxes[i].checked) {
            asientosSeleccionados.push(checkboxes[i].id);
        }
    }
    document.getElementById("asientosSeleccionadosInput").value = asientosSeleccionados;
}

let popoverTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="popover"]'))
let popoverList = popoverTriggerList.map(function (popoverTriggerEl) {
    return new bootstrap.Popover(popoverTriggerEl)
})
let popover = new bootstrap.Popover(document.querySelector('.example-popover'), {
    container: 'body'
})