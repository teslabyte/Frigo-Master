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

        let customerInfoDivMinimised = document.createElement('div')
        customerInfoDivMinimised.classList.add("customer-info-div");

        customerInfoDivMinimised.innerHTML = '<class="customerInfo">' + ime +
            ', ' + brojTelefona + ', ' + adresa;
        this.appendChild(customerInfoDivMinimised);

        let chevronUpDown = document.createElement('i');
        chevronUpDown.style.float = 'right';
        chevronUpDown.classList.add("fa-solid");
        chevronUpDown.classList.add("fa-chevron-down");
        customerInfoDivMinimised.appendChild(chevronUpDown);
        this.appendChild(customerInfoDivMinimised);

        let customerInfoDivExpanded = document.createElement('div');
        customerInfoDivExpanded.classList.add("customer-info-expanded-div");


        let nameAndPhoneNumberDiv = document.createElement('div');
        nameAndPhoneNumberDiv.classList.add('expanded-info-divs');
        let nameDiv = document.createElement('div');
        nameDiv.innerHTML = 'Ime i prezime :<br>';
        let nameTextBox = document.createElement('input');
        nameTextBox.type = 'text';
        nameTextBox.defaultValue = ime;
        nameDiv.appendChild(nameTextBox)

        let phoneNumberDiv = document.createElement('div');
        phoneNumberDiv.innerHTML += 'Broj telefona :<br>';
        let phoneNumberTextBox = document.createElement('input');
        phoneNumberTextBox.type = 'text';
        phoneNumberTextBox.defaultValue = brojTelefona;
        phoneNumberDiv.appendChild(phoneNumberTextBox);

        nameAndPhoneNumberDiv.appendChild(nameDiv);
        nameAndPhoneNumberDiv.appendChild(phoneNumberDiv);
        customerInfoDivExpanded.appendChild(nameAndPhoneNumberDiv);

        let addressAndPriceDiv = document.createElement('div');
        addressAndPriceDiv.innerHTML += 'Adresa :<br>';
        let addressTextBox = document.createElement('input');
        addressTextBox.type = 'text';
        addressTextBox.defaultValue = adresa;
        addressAndPriceDiv.appendChild(addressTextBox);

        addressAndPriceDiv.innerHTML += 'Cena :<br>';
        let priceTextBox = document.createElement('input');
        priceTextBox.type = 'text';
        priceTextBox.defaultValue = cena;
        addressAndPriceDiv.appendChild(priceTextBox);


        customerInfoDivExpanded.appendChild(addressAndPriceDiv);
        this.appendChild(customerInfoDivExpanded);

        customerInfoDivMinimised.onclick = function (){
            if(chevronUpDown.classList.contains("fa-chevron-down")){
                chevronUpDown.classList.replace("fa-chevron-down", "fa-chevron-up");
                customerInfoDivExpanded.style.display = 'block';
            }
            else {
                chevronUpDown.classList.replace("fa-chevron-up", "fa-chevron-down");
                customerInfoDivExpanded.style.display = 'none';
            }
        };


        let btn = document.createElement("button");
        btn.classList.add("editButton");
        btn.innerHTML = '<i class="fa-solid fa-pen-to-square"></i>';
        btn.id = "cEditBtn" + id;
        //this.appendChild(btn);

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
        opisKvaraDiv.innerHTML = "Opis kvara :";// + opisKvara;

        let opisDiv = document.createElement('div');
        opisDiv.classList.add("opis-div");
        opisDiv.innerHTML = opisKvara;

        //opisKvaraDiv.appendChild(opisDiv);

        //this.appendChild(opisKvaraDiv);
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