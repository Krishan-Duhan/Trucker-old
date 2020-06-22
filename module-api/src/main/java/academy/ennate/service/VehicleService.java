package academy.ennate.service;


import academy.ennate.entity.Vehicles;

import java.util.List;

public interface VehicleService {
    public List<Vehicles> findAll();

    public Vehicles findOne(String vid);

    public void loadVehicles(Vehicles[] vehicles);
}
