package academy.ennate.service;

import academy.ennate.entity.Alerts;
import academy.ennate.entity.Readings;
import academy.ennate.entity.Rule;
import academy.ennate.entity.Vehicles;
import academy.ennate.exception.ResourceNotFoundException;
import academy.ennate.repository.AlertsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
public class AlertsServiceImpl implements  AlertsService{
    @Autowired
    private AlertsRepository repository;
    @Autowired
    private VehicleService service;

    @Override
    @Transactional(readOnly = true)
    public List<Alerts> findAlertsBySeverity(String severity, Integer hours) {
        return repository.findAlertsBySeverity(severity, hours, new Sort(Sort.Direction.ASC, "vin"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Alerts> findAlertsByVin(String vin) {
        return repository.findAlertsByVin(vin);
    }

    @Override
    public void validateRule(Readings reading) {
        String vin = reading.getVin();
        Timestamp alertTime = reading.getTimestamp();
        Vehicles vehicle = service.findOne(vin);
        Boolean isValid = true;
        if (vehicle == null){
            throw new ResourceNotFoundException("Vehicle with vin:" + vin + " not found");
        } else {
            if(reading.getEngineRPM() > vehicle.getRPM_red()){
                saveAlert(vin, Rule.Rule1, alertTime);
            } else if(reading.getFuelVolume() < vehicle.getFuelVolume()/10) {
                saveAlert(vin, Rule.Rule2, alertTime);
            } else if((reading.getTires().getFrontLeft() < 32 || reading.getTires().getFrontLeft() > 36)
                    || (reading.getTires().getFrontRight() < 32 || reading.getTires().getFrontRight() > 36)
                    || (reading.getTires().getRearLeft() < 32 || reading.getTires().getRearLeft() > 36)
            || (reading.getTires().getRearRight() < 32 || reading.getTires().getRearRight() > 36)){
                saveAlert(vin, Rule.Rule3, alertTime);
            } else if(reading.getCheckEngineLightOn() || reading.getEngineCoolantLow()){
                saveAlert(vin, Rule.Rule4, alertTime);
            }
        }
    }

    @Override
    public void saveAlert(String vin, Rule rule, Timestamp timestamp) {
        Alerts alert = new Alerts();
        alert.setVin(vin);
        alert.setSeverity(rule.getSeverity());
        alert.setTimeOccured(timestamp);
        alert.setReason(rule.getReason());
        repository.save(alert);
    }
}
