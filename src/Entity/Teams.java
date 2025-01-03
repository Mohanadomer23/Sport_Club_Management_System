/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import javax.swing.JTable;
import sportingclub.Tools;

public class Teams implements MainData {
    private int teamId;
    private String teamName;
    private String sportType;
    private int coachId;
    private int managerId;

    // Getters and Setters
    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getSportType() {
        return sportType;
    }

    public void setSportType(String sportType) {
        this.sportType = sportType;
    }

    public int getCoachId() {
        return coachId;
    }

    public void setCoachId(int coachId) {
        this.coachId = coachId;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    // Override methods
    @Override
    public void add() {
        String strInsert = "INSERT INTO Teams VALUES ("
                + teamId + ","
                + "'" + teamName + "',"
                + "'" + sportType + "',"
                + coachId + ","
                + managerId + ")";
        boolean isAdded = DB.go.runNonQuery(strInsert);
        if (isAdded) {
            Tools.msgBox("Team added successfully.");
        }
    }

    @Override
    public void update() {
        String strUpdate = "UPDATE Teams SET "
                + "team_name='" + teamName + "',"
                + "sport_type='" + sportType + "',"
                + "coach_id=" + coachId + ","
                + "manager_id=" + managerId + " "
                + "WHERE team_id=" + teamId;
        boolean isUpdated = DB.go.runNonQuery(strUpdate);
        if (isUpdated) {
            Tools.msgBox("Team updated successfully.");
        }
    }

    @Override
    public void delete() {
        String strDelete = "DELETE FROM Teams "
                +"WHERE team_id=" + teamId;
        boolean isDeleted = DB.go.runNonQuery(strDelete);
        if (isDeleted) {
            Tools.msgBox("Team deleted successfully.");
        }
    }

    @Override
    public String getAutoNumber() {
        return DB.go.getAutoNumber("teams", "team_id");
    }

    @Override
    public void getAllRows(JTable table) {
        DB.go.fillToJTable("teams", table);
    }

    @Override
    public void getOneRow(JTable table) {
        String strSelect = "SELECT * FROM Teams"
                +" WHERE team_id=" + teamId;
        DB.go.fillToJTable(strSelect, table);
    }

    @Override
    public void getCustomRows(String statement, JTable table) {
        DB.go.fillToJTable(statement, table);
    }

    @Override
    public String getValueByName(String name) {
        String strSelect = "SELECT team_id FROM Teams "
                +"WHERE team_name='" + name + "'";
        String strVal = (String) DB.go.getTableData(strSelect).Items[0][0].toString();
        return strVal;
    }

    @Override
    public String getNameByValue(String value) {
        String strSelect = "SELECT team_name FROM Teams "
                +"WHERE team_id=" + value;
        String strName = (String) DB.go.getTableData(strSelect).Items[0][0].toString();
        return strName;
}
}