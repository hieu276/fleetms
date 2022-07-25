document.addEventListener("DOMContentLoaded", function() {
    var displayButton = document.querySelectorAll(".table #display");
    displayButton.forEach(button=>{
        button.addEventListener('click',function (event){
            event.preventDefault();
            var href = this.href;
            fetch(href).then(response => response.json()).then(responseJson =>{
                document.getElementById('txtId').value = responseJson.id;
                document.getElementById('txtDescription').value = responseJson.description;
                document.getElementById('txtDetails').value = responseJson.details;
            })
        })
    })
})
