class CustomerInfoBox extends HTMLElement{
    constructor() {
        super();
    }

    render(){
        var ime = this.getAttribute('ime') || undefined;
        var brojTelefona = this.getAttribute('brojtelefona') || undefined;
        var opisKvara = this.getAttribute('opiskvara') || undefined;
        var adresa = this.getAttribute('adresa') || undefined;
        var cena = this.getAttribute('cena') || undefined;
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

    attributeChangedCallback(ime, brojtelefona, opiskvara, adresa, cena){
        this.render();
    }
}

customElements.define('cib-element', CustomerInfoBox);