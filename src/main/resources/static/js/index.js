//console.log(musterije)
var testing = document.getElementById("losd");

musterije.forEach((item)=>{
    var div = document.createElement("div");
    var cust = document.createElement("cib-element");
    div.classList.add("cust-box-div");
    cust.classList.add("cust-box");
    cust.setAttribute('ime', item.ime);
    cust.setAttribute('brojtelefona', item.brojTelefona);
    cust.setAttribute('opiskvara', item.opisKvara);
    cust.setAttribute('adresa', item.adresa);
    cust.setAttribute('cena', item.cena);
    div.appendChild(cust);
    testing.appendChild(div);
})


//let lista = document.getElementById("testLista");
//musterije.forEach((item)=>{
    //let m = document.createElement("li");
   // m.innerText = musterijaToString(item)
   // lista.appendChild(m);
//})

//function musterijaToString(m){
  //  return m.ime + "," + m.brojTelefona;
//}
