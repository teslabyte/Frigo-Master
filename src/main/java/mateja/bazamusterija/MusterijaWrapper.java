package mateja.bazamusterija;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Musterije")
public class MusterijaWrapper {
    public enum Status{
        INCOMPLETE,
        COMPLETED,
        CANCELED
    }

    @Id
    private long id;

    private Musterija musterija;
    private long yId;
    private String date;
    private Status status;

    public MusterijaWrapper() {
    }

    public MusterijaWrapper(Musterija musterija, long yId, String date, Status status, long id) {
        this.musterija = musterija;
        this.yId = yId;
        this.date = date;
        this.status = status;
        this.id = id;
    }

    public MusterijaWrapper(DeletedCustomer deletedCustomer){
        this.musterija = deletedCustomer.getMusterija();
        this.yId = deletedCustomer.getyId();
        this.date = deletedCustomer.getDeletedDate();
        this.status = deletedCustomer.getStatus();
        this.id = deletedCustomer.getId();
    }

    public Musterija getMusterija() {
        return musterija;
    }

    public void setMusterija(Musterija musterija) {
        this.musterija = musterija;
    }

    public long getyId() {
        return yId;
    }

    public void setyId(long yId) {
        this.yId = yId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }
}
