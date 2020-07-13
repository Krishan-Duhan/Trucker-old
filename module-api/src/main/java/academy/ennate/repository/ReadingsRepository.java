package academy.ennate.repository;

import academy.ennate.entity.Readings;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Entity;
import java.util.List;

public interface ReadingsRepository extends CrudRepository {
    @Query(value = "select * from readings r where r.vin = ?1 "
                    + "and r.timestamp >  DATE_SUB(CONVERT_TZ(NOW(),'GMT','America/Chicago'), INTERVAL ?2 MINUTE)", nativeQuery = true)
    public List<Readings> getVehicleInfo(String vin, Integer min);
}
