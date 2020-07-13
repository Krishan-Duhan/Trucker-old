package academy.ennate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Alerts {
    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String alertID;
    private String vin;
    private String severity;
    private Timestamp timeOccured;

    public String getAlertID() {
        return alertID;
    }

    public void setAlertID(String alertID) {
        this.alertID = alertID;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public Timestamp getTimeOccured() {
        return timeOccured;
    }

    public void setTimeOccured(Timestamp timeOccured) {
        this.timeOccured = timeOccured;
    }
}
