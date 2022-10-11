package mateja.bazamusterija.dal;

import mateja.bazamusterija.MusterijaWrapper;

import java.util.List;

public interface MusterijaDAL {
    List<MusterijaWrapper> getAllMusterije();
    List<MusterijaWrapper> getAllCompleted();
    List<MusterijaWrapper> getAllIncomplete();
    List<MusterijaWrapper> getAllCanceled();
    void addNewMusterija(MusterijaWrapper musterijaWrapper);
    long getNewestMusterijaId();
    List<MusterijaWrapper> editMusterija(MusterijaWrapper musterijaWrapper);
    List<MusterijaWrapper> deleteMusterija(MusterijaWrapper musterijaWrapper);
    List<MusterijaWrapper> searchCustomers(String query);
}
