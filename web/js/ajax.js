/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function loadModel(id) {
    var xhttp, xmlDoc, txt, x, i;
    txt = "";
    if (id === "") {
        document.getElementById("radio").innerHTML = "";
        return;
    }
    
    xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            xmlDoc = this.responseXML;
            
            x = xmlDoc.getElementsByTagName("modelovehiculo");           
            for (i = 0; i < x.length; i++) {
                txt += "<option value="+x[i].getElementsByTagName("idmodelovehiculo")[0].childNodes[0].nodeValue+">"
                        + x[i].getElementsByTagName("modelo")[0].childNodes[0].nodeValue + "</option>";
            }
            console.log(txt);
            document.getElementById("inputModel").innerHTML = txt;
        }
    };

    xhttp.open("GET", "updatemodelo?id=" + id, true);
    xhttp.send();
}



