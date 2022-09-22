package mateja.bazamusterija;

public class MusterijaWrapper {
    public static enum Status{
        INCOMPLETE,
        COMPLETED,
        CANCELED
    }

    private Musterija musterija;
    private long yId;
    private String date;
    private Status status;

    public MusterijaWrapper() {
    }

    public MusterijaWrapper(Musterija musterija, long yId, String date, Status status) {
        this.musterija = musterija;
        this.yId = yId;
        this.date = date;
        this.status = status;
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
}
