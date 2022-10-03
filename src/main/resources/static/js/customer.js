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
        this.innerHTML = 'Ime: ' + ime + '<br/>' +
            'Opis kvara: ' + opisKvara + '<br/>' +
            'Adresa: ' + adresa + '<br/>' +
            'Cena: ' + cena + '<br/>' +
            'Broj telefona: ' + brojTelefona + '<br/>';
    }

    connectedCallback(){
        if(!this.rendered){
            this.render();
            this.rendered = true;
        }
    }

    static get observedAttributes(){
        return ['ime','brojtelefona','opiskvara','adresa','cena'];
    }

    /*
    attributeChangedCallback(ime, brojtelefona, opiskvara, adresa, cena){
        this.render();
    }
    */
}

customElements.define('cib-element', CustomerInfoBox);

class CustomerInfo{
    constructor(ime, adresa, brojTelefona, opisKvara, cena) {
        this.ime = ime;
        this.adresa = adresa;
        this.brojTelefona = brojTelefona;
        this.opisKvara = opisKvara;
        this.cena = cena;
    }
}