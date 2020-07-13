package academy.ennate.service;

import academy.ennate.GeoLocation;
import academy.ennate.entity.Readings;
import academy.ennate.repository.ReadingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ReadingServiceImpl implements ReadingService {
    @Autowired
    ReadingsRepository repository;
    @Autowired
    AlertsService service;

    @Override
    public void insertReadings(Readings readings) {
        repository.save(readings);
        //alert check
    }

    @Override
    public List<Readings> getReadings() {
        return (List<Readings>) repository.findAll();
    }

    @Override
    public List<GeoLocation> getVehicleInfo(String vin, Integer min) {
        List<GeoLocation> locations = new LinkedList<>();
        Iterable<Readings> readings = repository.getVehicleInfo(vin, min);
        for (Readings r: readings) {
            GeoLocation obj = new GeoLocation();
            obj.setVin(r.getVin());
            obj.setTimestamp(r.getTimestamp());
            obj.setLatitude(r.getLatitude());
            obj.setLongitude(r.getLongitude());
            locations.add(obj);
        }
        return locations;
    }
}
