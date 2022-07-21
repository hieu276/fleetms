// document.addEventListener("DOMContentLoaded", function() {
//     var ddlCountry = document.getElementById("ddlCountryAdd");
//     ddlCountry.addEventListener('change', function(){
//         var countryid = this.value;
//         while (ddlCountry.lastElementChild){
//             ddlCountry.removeChild(ddlCountry.lastElementChild);
//         }
//         document.createElement("option").text = '-option-';
//         var href = "http://localhost:8080/parameters/country/" + countryid;
//         var xmlHttp = new XMLHttpRequest();
//         xmlHttp.open("GET", href);
//         xmlHttp.send();
//         xmlHttp.onreadystatechange = function(){
//             var jsonObject = JSON.parse(xmlHttp.responseText);
//             window.alert(jsonObject[0])
//             for (var i = 0; i<= state.length()-1;i++){
//                 ddlCountry.append('<option value="' + states[i].id + '">' + states[i].name + '</option>')
//             }
//         };
//     });
// });

document.addEventListener("DOMContentLoaded", function() {
    var ddlCountry = document.getElementById("ddlCountryAdd");
    var ddlState = document.getElementById("ddlStateAdd");
    ddlCountry.addEventListener('change', function(){
        var countryid = this.value;
        while (ddlState.lastElementChild){
             ddlState.removeChild(ddlState.lastElementChild);
        }
        var href = "http://localhost:8080/parameters/country/" + countryid;
        fetch(href).then(response => response.json()).then(responseJson => {
            responseJson.states.forEach(state=>{
                ddlState.add(new Option(state.name,state.id))
            })

        })
    })
})
