package mateja.bazamusterija.dal;

import mateja.bazamusterija.MusterijaWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MusterijaDALImpl implements MusterijaDAL {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<MusterijaWrapper> getAllMusterije(){
        return mongoTemplate.findAll(MusterijaWrapper.class);
    }

    @Override
    public List<MusterijaWrapper> getAllCompleted(){
        Query query = new Query();
        query.addCriteria(Criteria.where("status").is("COMPLETED"));
        return mongoTemplate.find(query,MusterijaWrapper.class);
    }

    @Override
    public List<MusterijaWrapper> getAllIncomplete(){
        Query query = new Query();
        query.addCriteria(Criteria.where("status").is("INCOMPLETE"));
        return mongoTemplate.find(query,MusterijaWrapper.class);
    }

    @Override
    public List<MusterijaWrapper> getAllCanceled(){
        Query query = new Query();
        query.addCriteria(Criteria.where("status").is("CANCELED"));
        return mongoTemplate.find(query,MusterijaWrapper.class);
    }

    @Override
    public void addNewMusterija(MusterijaWrapper musterijaWrapper){
        mongoTemplate.save(musterijaWrapper);
    }

    @Override
    public long getNewestMusterijaId(){
        Query query = new Query();
        query.with(Sort.by(Sort.Direction.DESC, "id"));
        query.limit(1);
        MusterijaWrapper msw  = mongoTemplate.findOne(query, MusterijaWrapper.class);
        return msw.getId();
    }

}
