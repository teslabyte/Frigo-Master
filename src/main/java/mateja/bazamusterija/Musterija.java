package mateja.bazamusterija;

public class Musterija {
    private String ime;
    private String adresa;
    private String brojTelefona;
    private String opisKvara;
    private long cena;

    public Musterija() {
    }

    public Musterija(String ime, String brojTelefona, String opisKvara, String adresa, long cena) {
        this.ime = ime;
        this.brojTelefona = brojTelefona;
        this.opisKvara = opisKvara;
        this.adresa = adresa;
        this.cena = cena;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getOpisKvara() {
        return opisKvara;
    }

    public void setOpisKvara(String opisKvara) {
        this.opisKvara = opisKvara;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public long getCena() {
        return cena;
    }

    public void setCena(long cena) {
        this.cena = cena;
    }
}
