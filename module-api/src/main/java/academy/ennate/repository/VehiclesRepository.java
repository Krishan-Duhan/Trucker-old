package academy.ennate.repository;

import academy.ennate.entity.Vehicles;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface VehiclesRepository extends CrudRepository<Vehicles, String> {
    Optional<Vehicles> findByVin(String vin);
}
