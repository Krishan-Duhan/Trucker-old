package academy.ennate.entity;

import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
public class Readings {
    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String id;
    private String vin;
    private Double latitude;
    private Double longitude;
    private Timestamp timestamp;
    private Float fuelVolume;
    private Float speed;
    private Float engineHP;
    private Integer engineRPM;
    private Boolean checkEngineLightOn;
    private Boolean engineCoolantLow;

    @Embedded
    private Tires tires;

    public Readings(){
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Float getFuelVolume() {
        return fuelVolume;
    }

    public void setFuelVolume(Float fuelVolume) {
        this.fuelVolume = fuelVolume;
    }

    public Float getSpeed() {
        return speed;
    }

    public void setSpeed(Float speed) {
        this.speed = speed;
    }

    public Float getEngineHP() {
        return engineHP;
    }

    public void setEngineHP(Float engineHP) {
        this.engineHP = engineHP;
    }

    public Integer getEngineRPM() {
        return engineRPM;
    }

    public void setEngineRPM(Integer engineRPM) {
        this.engineRPM = engineRPM;
    }

    public Boolean getCheckEngineLightOn() {
        return checkEngineLightOn;
    }

    public void setCheckEngineLightOn(Boolean checkEngineLightOn) {
        this.checkEngineLightOn = checkEngineLightOn;
    }

    public Boolean getEngineCoolantLow() {
        return engineCoolantLow;
    }

    public void setEngineCoolantLow(Boolean engineCoolantLow) {
        this.engineCoolantLow = engineCoolantLow;
    }

    public Tires getTires() {
        return tires;
    }

    public void setTires(Tires tires) {
        this.tires = tires;
    }
}
