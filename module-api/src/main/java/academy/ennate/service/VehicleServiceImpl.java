package academy.ennate.service;

import academy.ennate.entity.Vehicles;
import academy.ennate.exception.ResourceNotFoundException;
import academy.ennate.repository.VehiclesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehiclesRepository repository;

    @Transactional(readOnly = true)
    public List<Vehicles> findAll(){
        return (List<Vehicles>) repository.findAll();
    }

    @Transactional(readOnly = true)
    public Vehicles findOne(String vid){
        return repository.findById(vid).orElseThrow(() -> new ResourceNotFoundException("vehicle doesn't exist"));
    }

    @Override
    @Transactional
    public void loadVehicles(Vehicles[] vehicles) {
        for (Vehicles vehicle : vehicles){
            //Optional<Vehicles> existing = repository.findByVin(vehicle.getVin());
            repository.save(vehicle);
        }
    }


}
