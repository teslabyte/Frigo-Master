//console.log(musterije)

var musterijeTemp = musterije;
var musterijeCompleted = null;
var musterijeIncomplete = null;
var musterijeCancelled = null;

drawCustomerBoxes();

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
        $.get("cancelled", function (data, status) {
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

function filterNoFilter(){
    musterijeTemp = musterije;
    drawCustomerBoxes();
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
        div.appendChild(cust);
        testing.appendChild(div);
    })
}
