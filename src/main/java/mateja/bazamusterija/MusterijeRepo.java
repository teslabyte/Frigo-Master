package mateja.bazamusterija;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MusterijeRepo extends MongoRepository<MusterijaWrapper, String> {


}
