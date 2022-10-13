package mateja.bazamusterija;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Deleted")
public class DeletedCustomer {
    public enum Status{
        INCOMPLETE,
        COMPLETED,
        CANCELED
    }

    @Id
    private long id;

    private Musterija musterija;

    private String deletedDate;

    private long yId;

    private MusterijaWrapper.Status status;

    public DeletedCustomer() {
    }

    public DeletedCustomer(long id, Musterija musterija, String deletedDate, long yId, MusterijaWrapper.Status status) {
        this.id = id;
        this.musterija = musterija;
        this.deletedDate = deletedDate;
        this.yId = yId;
        this.status = status;
    }

    public DeletedCustomer(MusterijaWrapper deletedCustomer){
        this.id = deletedCustomer.getId();
        this.musterija = deletedCustomer.getMusterija();
        this.yId = deletedCustomer.getyId();
        this.status = deletedCustomer.getStatus();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Musterija getMusterija() {
        return musterija;
    }

    public void setMusterija(Musterija musterija) {
        this.musterija = musterija;
    }

    public String getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(String deletedDate) {
        this.deletedDate = deletedDate;
    }

    public long getyId() {
        return yId;
    }

    public void setyId(long yId) {
        this.yId = yId;
    }

    public MusterijaWrapper.Status getStatus() {
        return status;
    }

    public void setStatus(MusterijaWrapper.Status status) {
        this.status = status;
    }
}
