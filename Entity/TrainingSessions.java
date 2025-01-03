/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import javax.swing.JTable;
import sportingclub.Tools;
import java.util.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class TrainingSessions implements MainData {
    private int sessionId;
    private String date;
    private float duration;
    private String notes;
    private int teamId;
    private int coachId;

    // Getters and Setters
    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getCoachId() {
        return coachId;
    }

    public void setCoachId(int coachId) {
        this.coachId = coachId;
    }

    // Override methods
    @Override
    public void add() {
        String strInsert = "INSERT INTO training_session (session_id, session_date, duration, notes, Team_id, coach_id) VALUES ("
                + sessionId + ", "
                + "'" + date + "', "
                + duration + ", "
                + "'" + notes + "', "
                + teamId + ", "
                + coachId + ")";
        boolean isAdded = DB.go.runNonQuery(strInsert);
        if (isAdded) {
            Tools.msgBox("Training session added successfully.");
        }
    }

    @Override
    public void update() {
        String strUpdate = "UPDATE training_session SET "
                + "session_date='" + date + "', "
                + "duration=" + duration + ", "
                + "notes='" + notes + "', "
                + "Team_id=" + teamId + ", "
                + "coach_id=" + coachId + " "
                + "WHERE session_id=" + sessionId;
        boolean isUpdated = DB.go.runNonQuery(strUpdate);
        if (isUpdated) {
            Tools.msgBox("Training session updated successfully.");
        }
    }

    @Override
    public void delete() {
        String strDelete = "DELETE FROM training_session "
                +"WHERE session_id=" + sessionId;
        boolean isDeleted = DB.go.runNonQuery(strDelete);
        if (isDeleted) {
            Tools.msgBox("Training session deleted successfully.");
        }
    }

    @Override
    public String getAutoNumber() {
        return DB.go.getAutoNumber("training_session", "session_id");
    }

    @Override
    public void getAllRows(JTable table) {
        DB.go.fillToJTable("training_session", table);
    }

    @Override
    public void getOneRow(JTable table) {
        String strSelect = "SELECT * FROM training_session "
                +"WHERE session_id=" + sessionId;
        DB.go.fillToJTable(strSelect, table);
    }

    @Override
    public void getCustomRows(String statement, JTable table) {
        DB.go.fillToJTable(statement, table);
    }

    @Override
    public String getValueByName(String name) {
        String strSelect = "SELECT session_id FROM training_session "
                +"WHERE session_date='" + name + "'";
        String strVal = (String) DB.go.getTableData(strSelect).Items[0][0].toString();
        return strVal;
    }

    @Override
    public String getNameByValue(String value) {
        String strSelect = "SELECT session_date FROM training_session "
                +"WHERE session_id=" + value;
        String strName = (String) DB.go.getTableData(strSelect).Items[0][0].toString();
        return strName;
}
}