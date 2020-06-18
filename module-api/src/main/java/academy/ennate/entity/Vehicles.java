package academy.ennate.entity;

import org.springframework.stereotype.Component;


public class Vehicles {
    @Id
    String vin;
    String model;
    String make;
    Integer year;
    Integer RPM_red;
    Float FuelVolume;



}
