class DeletedCustomer{
    constructor(customerId, musterija, yId, deletedDate, status) {
        this.customerId = customerId;
        this.musterija = musterija;
        this.yId = yId;
        this.deletedDate = deletedDate;
        this.status = status;
    }
}

class DeletedCustomerInfoBox extends HTMLElement{
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
        let deletedDate = this.getAttribute('deletedDate') || undefined;

        // add a restore button, nothing else


        // ---------
    }
}