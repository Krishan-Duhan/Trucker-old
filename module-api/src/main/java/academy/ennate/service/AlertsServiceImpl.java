package academy.ennate.service;

import academy.ennate.entity.Alerts;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertsServiceImpl implements  AlertsService{
    @Override
    public List<Alerts> findAlertsBySeverity(String severity, Integer hours) {
        return null;
    }

    @Override
    public List<Alerts> findAlertsByVin(String vin) {
        return null;
    }
}
