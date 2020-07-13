package academy.ennate.repository;

import academy.ennate.entity.Readings;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Entity;
import java.util.List;

public interface ReadingsRepository extends CrudRepository {
    @Query

    public List<Readings> getVehicleInfo(String vin, Integer min);
}
