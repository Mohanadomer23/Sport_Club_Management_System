/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import javax.swing.JTable;
import sportingclub.Tools;

public class Facilities implements MainData {
    private int facilityId;
    private String facilityName;
    private String location;
    private int maintenanceSchedule;

    // Getters and Setters
    public int getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(int facilityId) {
        this.facilityId = facilityId;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getMaintenanceSchedule() {
        return maintenanceSchedule;
    }

    public void setMaintenanceSchedule(int maintenanceSchedule) {
        this.maintenanceSchedule = maintenanceSchedule;
    }

    // Override methods
    @Override
    public void add() {
        String strInsert = "INSERT INTO Facilites (facility_id, facility_name, location, maintananceschedule) VALUES ("
                + facilityId + ","
                + "'" + facilityName + "',"
                + "'" + location + "',"
                + maintenanceSchedule + ")";
        boolean isAdded = DB.go.runNonQuery(strInsert);
        if (isAdded) {
            Tools.msgBox("Facility added successfully.");
        }
    }

    @Override
    public void update() {
        String strUpdate = "UPDATE Facilites SET "
                + "facility_name='" + facilityName + "',"
                + "location='" + location + "',"
                + "maintananceschedule=" + maintenanceSchedule + " "
                + "WHERE facility_id=" + facilityId;
        boolean isUpdated = DB.go.runNonQuery(strUpdate);
        if (isUpdated) {
            Tools.msgBox("Facility updated successfully.");
        }
    }

    @Override
    public void delete() {
        String strDelete = "DELETE FROM Facilites "
                +"WHERE facility_id=" + facilityId;
        boolean isDeleted = DB.go.runNonQuery(strDelete);
        if (isDeleted) {
            Tools.msgBox("Facility deleted successfully.");
        }
    }

    @Override
    public String getAutoNumber() {
        return DB.go.getAutoNumber("Facilites", "facility_id");
    }

    @Override
    public void getAllRows(JTable table) {
        DB.go.fillToJTable("Facilites", table);
    }

    @Override
    public void getOneRow(JTable table) {
        String strSelect = "SELECT * FROM Facilites_date"
                +" WHERE facility_id=" + facilityId;
        DB.go.fillToJTable(strSelect, table);
    }

    @Override
    public void getCustomRows(String statement, JTable table) {
        DB.go.fillToJTable(statement, table);
    }

    @Override
    public String getValueByName(String name) {
        String strSelect = "SELECT facility_id FROM Facilites "
                +"WHERE facility_name='" + name + "'";
        String strVal = (String) DB.go.getTableData(strSelect).Items[0][0].toString();
        return strVal;
    }

    @Override
    public String getNameByValue(String value) {
        String strSelect = "SELECT facility_name FROM Facilites "
                +"WHERE facility_id=" + value;
        String strName = (String) DB.go.getTableData(strSelect).Items[0][0].toString();
        return strName;
}
}