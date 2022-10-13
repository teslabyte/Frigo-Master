package mateja.bazamusterija.dal;

import mateja.bazamusterija.DeletedCustomer;
import mateja.bazamusterija.MusterijaWrapper;

import java.util.List;

public interface DeletedCustomerDAL {
    List<DeletedCustomer> getAllDeletedCustomers();
    DeletedCustomer getDeletedCustomer(long deletedCustomerId);
    void deleteCustomer(MusterijaWrapper customerToDelete, String deletedDate);
}
