package academy.ennate.service;

import academy.ennate.GeoLocation;
import academy.ennate.entity.Readings;

import java.util.List;

public interface ReadingService {
    public void insertReadings(Readings readings);
    public List<Readings> getReadings();
    public List<GeoLocation> getVehicleInfo(String vin, Integer min);
}
