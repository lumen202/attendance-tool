package sms.admin.app;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class StudentAttendance {

    private final SimpleStringProperty studentId;
    private final SimpleStringProperty studentName;
    private final SimpleStringProperty status;
    private final SimpleStringProperty lastActionTime;
    private final SimpleBooleanProperty loggedIn;

    public StudentAttendance(String studentId, String studentName) {
        this.studentId = new SimpleStringProperty(studentId);
        this.studentName = new SimpleStringProperty(studentName);
        this.status = new SimpleStringProperty("Absent");
        this.lastActionTime = new SimpleStringProperty("-");
        this.loggedIn = new SimpleBooleanProperty(false);
    }

    // Getters and Setters
    public String getStudentId() {
        return studentId.get();
    }

    public String getStudentName() {
        return studentName.get();
    }

    public String getStatus() {
        return status.get();
    }

    public String getLastActionTime() {
        return lastActionTime.get();
    }

    public boolean isLoggedIn() {
        return loggedIn.get();
    }

    public void setStatus(String value) {
        status.set(value);
    }

    public void setLastActionTime(String value) {
        lastActionTime.set(value);
    }

    public void setLoggedIn(boolean value) {
        loggedIn.set(value);
    }
}
