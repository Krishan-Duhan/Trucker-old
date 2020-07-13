package academy.ennate.service;

import academy.ennate.entity.Alerts;

import java.util.List;

public interface AlertsService {
    public List<Alerts> findAlertsBySeverity(String severity, Integer hours);
    public List<Alerts> findAlertsByVin(String vin);
}
