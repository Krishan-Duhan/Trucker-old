package academy.ennate.entity;

import org.springframework.stereotype.Component;

import javax.persistence.Id;


public class Vehicles {
    @Id
    String vin;
    String model;
    String make;
    Integer year;
    Integer RPM_red;
    Float FuelVolume;


    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getRPM_red() {
        return RPM_red;
    }

    public void setRPM_red(Integer RPM_red) {
        this.RPM_red = RPM_red;
    }

    public Float getFuelVolume() {
        return FuelVolume;
    }

    public void setFuelVolume(Float fuelVolume) {
        FuelVolume = fuelVolume;
    }
}
