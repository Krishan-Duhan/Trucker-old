package academy.ennate.entity;

public enum Rule {
    Rule1("High","Engine RPM above threshold"),
    Rule2("Medium", "Low Fuel"),
    Rule3("Low", "Check Tire Pressure"),
    Rule4("Low", "Engine Check Needed");
    private final String severity;

    public String getSeverity() {
        return severity;
    }

    public String getReason() {
        return reason;
    }

    private final String reason;

    private Rule(String severity, String reason){
        this.severity = severity;
        this.reason = reason;
    }
}
