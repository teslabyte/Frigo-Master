package mateja.bazamusterija.dal;

import mateja.bazamusterija.DeletedCustomer;
import mateja.bazamusterija.MusterijaWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class DeletedCustomerDALImpl implements DeletedCustomerDAL{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<DeletedCustomer> getAllDeletedCustomers() {
        return mongoTemplate.findAll(DeletedCustomer.class);
    }

    @Override
    public DeletedCustomer getDeletedCustomer(long deletedCustomerId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(deletedCustomerId));
        return mongoTemplate.findOne(query, DeletedCustomer.class);
    }

    @Override
    public void deleteCustomer(MusterijaWrapper customerToDelete, String deletedDate) {
        DeletedCustomer deletedCustomer = new DeletedCustomer(customerToDelete);
        deletedCustomer.setDeletedDate(deletedDate);
        mongoTemplate.save(deletedCustomer);
    }
}
