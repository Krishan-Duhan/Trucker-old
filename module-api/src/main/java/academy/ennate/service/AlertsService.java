package academy.ennate.service;

import academy.ennate.entity.Alerts;
import academy.ennate.entity.Readings;
import academy.ennate.entity.Rule;

import java.sql.Timestamp;
import java.util.List;

public interface AlertsService {
    public List<Alerts> findAlertsBySeverity(String severity, Integer hours);
    public List<Alerts> findAlertsByVin(String vin);
    public void validateRule(Readings reading);
    public void saveAlert(String vin, Rule rule, Timestamp timestamp);
}
