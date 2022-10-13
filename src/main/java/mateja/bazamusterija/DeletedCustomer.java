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

    private Status status;

    public DeletedCustomer() {
    }

    public DeletedCustomer(long id, Musterija musterija, String deletedDate, long yId, Status status) {
        this.id = id;
        this.musterija = musterija;
        this.deletedDate = deletedDate;
        this.yId = yId;
        this.status = status;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
