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

        this.innerHTML = 'Ime: ' + ime + '<br/>' +
            'Opis kvara: ' + opisKvara + '<br/>' +
            'Adresa: ' + adresa + '<br/>' +
            'Cena: ' + cena + '<br/>' +
            'Broj telefona: ' + brojTelefona + '<br/>' +
            'Status: ' + status + '<br/>';
        let btn = document.createElement("button");
        btn.innerHTML = "Izmeni";
        btn.id = "cEditBtn" + id;
        this.appendChild(btn);
        $("#cEditBtn" + id).on('click',function(event){
            let newCustomerInfo = new Musterija(ime, adresa, brojTelefona, opisKvara, cena);
            let newCustomerWrapper = new CustomerInfoWrapper(id, newCustomerInfo, yId, date, status);
            editCustomerInfo(newCustomerWrapper);
        });
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