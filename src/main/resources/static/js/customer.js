class CustomerInfoBox extends HTMLElement{
    constructor() {
        super();
    }

    render(){
        let ime = this.getAttribute('ime') || undefined;
        let brojTelefona = this.getAttribute('brojtelefona') || undefined;
        let opisKvara = this.getAttribute('opiskvara') || undefined;
        let adresa = this.getAttribute('adresa') || undefined;
        let cena = this.getAttribute('cena') || undefined;
        let status = this.getAttribute('status') || undefined;
        let id = this.getAttribute('id') || undefined;
        let yId = this.getAttribute('yId') || undefined;
        let date = this.getAttribute('date') || undefined;

        let customerInfoDiv = document.createElement('div')
        customerInfoDiv.classList.add("customer-info-div");
        customerInfoDiv.innerHTML = '<class="customerInfo"> Ime: ' + ime  +
            '<p class="customerInfo"> Adresa: ' + adresa + '</p>' +
            '<p class="customerInfo"> Broj telefona: ' + brojTelefona + '</p>' +
            '<p class="customerInfo"> Cena: ' + cena + '</p>';

        this.appendChild(customerInfoDiv);


        let btn = document.createElement("button");
        btn.classList.add("editButton");
        btn.innerHTML = '<i class="fa-solid fa-pen-to-square"></i>';
        btn.id = "cEditBtn" + id;
        this.appendChild(btn);

        /*$(this).on('mouseover' ,function(event){
           console.log("TESTING " + id)
        });*/

        $("#cEditBtn" + id).on('click',function(event){
            let newCustomerInfo = new Musterija(ime, adresa, brojTelefona, opisKvara, cena);
            let newCustomerWrapper = new CustomerInfoWrapper(id, newCustomerInfo, yId, date, status);
            editCustomerInfo(newCustomerWrapper);
        });

        let opisKvaraDiv = document.createElement('div');
        opisKvaraDiv.classList.add("opis-kvara-div");
        opisKvaraDiv.innerHTML = "  Opis kvara :";// + opisKvara;

        let opisDiv = document.createElement('div');
        opisDiv.classList.add("opis-div");
        opisDiv.innerHTML = opisKvara;

        opisKvaraDiv.appendChild(opisDiv);

        this.appendChild(opisKvaraDiv);
    }

    connectedCallback(){
        if(!this.rendered){
            this.render();
            this.rendered = true;
        }
    }


    static get observedAttributes(){
        return ['ime','brojtelefona','opiskvara','adresa','cena','status','id'];
    }

    /*
    attributeChangedCallback(ime, brojtelefona, opiskvara, adresa, cena){
        this.render();
    }
    */
}

customElements.define('cib-element', CustomerInfoBox);

class CustomerInfoWrapper{
    constructor(customerId, musterija, yId, date, status) {
        this.id = customerId;
        this.musterija = musterija;
        this.yId = yId;
        this.date = date;
        this.status = status;
    }
}

class Musterija {
    constructor(ime, adresa, brojTelefona, opisKvara, cena) {
        this.ime = ime;
        this.adresa = adresa;
        this.brojTelefona = brojTelefona;
        this.opisKvara = opisKvara;
        this.cena = cena;
    }
}