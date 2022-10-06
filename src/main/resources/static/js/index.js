//console.log(musterije)

var musterijeTemp = musterije;
var musterijeCompleted = null;
var musterijeIncomplete = null;
var musterijeCancelled = null;
var modal = document.getElementById("enterInfoModal");
var editModal = document.getElementById("editInfoModal");
var tempCustomerWrapper;

drawCustomerBoxes();

function openCustomerModal(){
    modal.style.display = "block";
}

function cancelModal(){
    modal.style.display = "none";
}

function saveCustomerInfo(){
    //reset musterije
    musterijeCompleted = null;
    musterijeIncomplete = null;
    musterijeCancelled = null;

    //get text from input boxes
    let ime = document.getElementById("unesiIme").value;
    let adresa = document.getElementById("unesiAdresu").value;
    let brojTelefona = document.getElementById("unesiBrojTelefona").value;
    let opisKvara = document.getElementById("unesiOpisKvara").value;
    let cena = document.getElementById("unesiCenu").value;

    //create customerInfo from data
    let customerInfo = new Musterija(ime,adresa, brojTelefona, opisKvara, cena);
    //send customerInfo to backend

    $.ajax({
        url: "customer/new",
        type: "POST",
        data: JSON.stringify(customerInfo),
        contentType: "application/json",
        dataType: "json",
        success: function (response){
            musterijeTemp.push(response);
            drawCustomerBoxes();
        }
    })

    modal.style.display = "none";
}

function filterCompleted(){
    if(musterijeCompleted === null) {
        $.get("completed", function (data, status) {
            musterijeCompleted = data;
            musterijeTemp = musterijeCompleted;
            drawCustomerBoxes();
        });
    }
    else {
        musterijeTemp = musterijeCompleted;
        drawCustomerBoxes();
    }
}

function filterIncomplete(){
    if(musterijeIncomplete === null) {
        $.get("incomplete", function (data, status) {
            musterijeIncomplete = data;
            musterijeTemp = musterijeIncomplete;
            drawCustomerBoxes();
        });
    }
    else{
        musterijeTemp = musterijeIncomplete;
        drawCustomerBoxes();
    }
}

function filterCancelled(){
    if(musterijeCancelled === null) {
        $.get("canceled", function (data, status) {
            musterijeCancelled = data;
            musterijeTemp = musterijeCancelled;
            drawCustomerBoxes();
        });
    }
    else{
        musterijeTemp = musterijeCancelled;
        drawCustomerBoxes();
    }
}

function filterAll(){
    musterijeTemp = musterije;
    drawCustomerBoxes();
}

function editCustomerInfo(customerInfoWrapper){
    $('#izmeniIme').val(customerInfoWrapper.musterija.ime);
    $('#izmeniBrojTelefona').val(customerInfoWrapper.musterija.brojTelefona);
    $('#izmeniOpisKvara').val(customerInfoWrapper.musterija.opisKvara);
    $('#izmeniAdresu').val(customerInfoWrapper.musterija.adresa);
    $('#izmeniCenu').val(customerInfoWrapper.musterija.cena);

    if(customerInfoWrapper.status === "COMPLETED") $('#izmeniStatus').val("completed");
    else if (customerInfoWrapper.status === "CANCELED") $('#izmeniStatus').val("canceled");
    else $('#izmeniStatus').val("incomplete");
    tempCustomerWrapper = customerInfoWrapper;

    editModal.style.display = "block";
}

function saveEditedInfo(){
    let ime = $('#izmeniIme').val();
    let adresa = $('#izmeniAdresu').val();
    let brojTelefona = $('#izmeniBrojTelefona').val();
    let opisKvara = $('#izmeniOpisKvara').val();
    let cena = $('#izmeniCenu').val();
    let status = $('#izmeniStatus').val().toUpperCase();

    let editedCustomerInfo = new Musterija(ime, adresa,brojTelefona, opisKvara, cena);
    tempCustomerWrapper.musterija = editedCustomerInfo;
    tempCustomerWrapper.status = status;

    $.ajax({
        url: "customer/edit",
        type: "POST",
        data: JSON.stringify(tempCustomerWrapper),
        contentType: "application/json",
        dataType: "json",
        success: function (response){
            musterijeTemp = response;
            drawCustomerBoxes();
        }
    })

    editModal.style.display = "none";
}

function cancelEditModal(){
    editModal.style.display = "none";
}
function drawCustomerBoxes(){
    let testing = document.getElementById("losd");
    testing.innerHTML = "";
    musterijeTemp.forEach((item)=>{
        let div = document.createElement("div");
        let cust = document.createElement("cib-element");
        div.classList.add("cust-box-div");
        cust.classList.add("cust-box");
        cust.setAttribute('ime', item.musterija.ime);
        cust.setAttribute('brojtelefona', item.musterija.brojTelefona);
        cust.setAttribute('opiskvara', item.musterija.opisKvara);
        cust.setAttribute('adresa', item.musterija.adresa);
        cust.setAttribute('cena', item.musterija.cena);
        cust.setAttribute('status', item.status);
        cust.setAttribute('id', item.id);
        cust.setAttribute('yId', item.yId);
        cust.setAttribute('date', item.date);
        div.appendChild(cust);
        testing.appendChild(div);
    })
}
