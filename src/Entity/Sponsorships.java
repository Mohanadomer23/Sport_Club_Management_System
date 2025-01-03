/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import javax.swing.JTable;
import sportingclub.Tools;

public class Sponsorships implements MainData {
    private int sponsorshipId;
    private String sponsorName;
    private float amountProvided;
    private String startDate;
    private String endDate;
    private int teamId;

    // Getters and Setters
    public int getSponsorshipId() {
        return sponsorshipId;
    }

    public void setSponsorshipId(int sponsorshipId) {
        this.sponsorshipId = sponsorshipId;
    }

    public String getSponsorName() {
        return sponsorName;
    }

    public void setSponsorName(String sponsorName) {
        this.sponsorName = sponsorName;
    }

    public float getAmountProvided() {
        return amountProvided;
    }

    public void setAmountProvided(float amountProvided) {
        this.amountProvided = amountProvided;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    // Override methods
    @Override
    public void add() {
        String strInsert = "INSERT INTO Sponsorship (sponsorship_id, sponsor_name, amount_provided, start_date, end_date, team_id) VALUES ("
                + sponsorshipId + ", "
                + "'" + sponsorName + "', "
                + amountProvided + ", "
                + "'" + startDate + "', "
                + "'" + endDate + "', "
                + teamId + ")";
        boolean isAdded = DB.go.runNonQuery(strInsert);
        if (isAdded) {
            Tools.msgBox("Sponsorship added successfully.");
        }
    }

    @Override
    public void update() {
        String strUpdate = "UPDATE Sponsorship SET "
                + "sponsor_name='" + sponsorName + "', "
                + "amount_provided=" + amountProvided + ", "
                + "start_date='" + startDate + "', "
                + "end_date='" + endDate + "', "
                + "team_id=" + teamId + " "
                + "WHERE sponsorship_id=" + sponsorshipId;
        boolean isUpdated = DB.go.runNonQuery(strUpdate);
        if (isUpdated) {
            Tools.msgBox("Sponsorship updated successfully.");
        }
    }

    @Override
    public void delete() {
        String strDelete = "DELETE FROM Sponsorship "
                +"WHERE sponsorship_id=" + sponsorshipId;
        boolean isDeleted = DB.go.runNonQuery(strDelete);
        if (isDeleted) {
            Tools.msgBox("Sponsorship deleted successfully.");
        }
    }

    @Override
    public String getAutoNumber() {
        return DB.go.getAutoNumber("Sponsorship", "sponsorship_id");
    }

    @Override
    public void getAllRows(JTable table) {
        DB.go.fillToJTable("Sponsorship", table);
    }

    @Override
    public void getOneRow(JTable table) {
        String strSelect = "SELECT * FROM Sponsorship "
                +"WHERE sponsorship_id=" + sponsorshipId;
        DB.go.fillToJTable(strSelect, table);
    }

    @Override
    public void getCustomRows(String statement, JTable table) {
        DB.go.fillToJTable(statement, table);
    }

    @Override
    public String getValueByName(String name) {
        String strSelect = "SELECT sponsorship_id FROM Sponsorship "
                +"WHERE sponsor_name='" + name + "'";
        String strVal = (String) DB.go.getTableData(strSelect).Items[0][0].toString();
        return strVal;
    }

    @Override
    public String getNameByValue(String value) {
        String strSelect = "SELECT sponsor_name FROM Sponsorship "
                +"WHERE sponsorship_id=" + value;
        String strName = (String) DB.go.getTableData(strSelect).Items[0][0].toString();
        return strName;

    }
}