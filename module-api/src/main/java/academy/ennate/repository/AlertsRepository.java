package academy.ennate.repository;

import academy.ennate.entity.Alerts;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
public interface AlertsRepository extends CrudRepository<Alerts, String> {
    public List<Alerts> findAlertsByVin(String vin);

    @Query(value = "select *  from alerts " + "where severity= ?1 "
            + "and alert_occured > DATE_SUB(CONVERT_TZ(NOW(),'GMT','America/Chicago'), INTERVAL ?2 HOUR)"
            + " ORDER BY ?#{#sort} ", nativeQuery = true)
    public List<Alerts> findAlertsBySeverity(String severity, Integer hours, Sort sort);
}
