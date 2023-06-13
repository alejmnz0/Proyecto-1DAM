function submitForm() {
    let checkboxes = document.getElementsByName("asientosCheck");
    let asientosSeleccionados = [];
    let checked = false;
    
    for (let i = 0; i < checkboxes.length; i++) {
        if (checkboxes[i].checked) {
            asientosSeleccionados.push(checkboxes[i].value);
            checked = true;
        }
    }
    
    if (!checked) {
        alert("Debes seleccionar al menos un asiento.");
        event.preventDefault();
        return;
    }
    
    document.getElementById("asientosSeleccionadosInput").value = asientosSeleccionados;
    console.log("Sus asientos son: " + asientosSeleccionados);
}

let popoverTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="popover"]'));
let popoverList = popoverTriggerList.map(function (popoverTriggerEl) {
    return new bootstrap.Popover(popoverTriggerEl);
});
let popover = new bootstrap.Popover(document.querySelector('.example-popover'), {
    container: 'body'
});