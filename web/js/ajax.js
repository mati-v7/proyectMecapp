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
            console.log(xmlDoc);
            x = xmlDoc.getElementsByTagName("modelovehiculo");
            for (i = 0; i < x.length; i++) {
                txt = txt + x[i].childNodes[0].nodeValue;
            }
            document.getElementById("demo").innerHTML = txt;
        }
    };

    xhttp.open("GET", "/car_record?id=" + id, true);
    xhttp.send();
}

