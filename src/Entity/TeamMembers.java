package Entity;

import javax.swing.JTable;
import sportingclub.Tools;

public class TeamMembers implements MainData {
    private int teamMemberId;
    private int teamId;

    // Getters and Setters
    public int getTeamMemberId() {
        return teamMemberId;
    }

    public void setTeamMemberId(int teamMemberId) {
        this.teamMemberId = teamMemberId;
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
        String strInsert = "INSERT INTO Team_member (teamMemberId, teamId) VALUES ("
                + teamMemberId + ", " + teamId + ")";
        boolean isAdded = DB.go.runNonQuery(strInsert);
        if (isAdded) {
            Tools.msgBox("Team member record added successfully.");
        }
    }

    @Override
    public void update() {
        String strUpdate = "UPDATE Team_member SET "
                + "teamId=" + teamId
                + " WHERE teamMemberId=" + teamMemberId;
        boolean isUpdated = DB.go.runNonQuery(strUpdate);
        if (isUpdated) {
            Tools.msgBox("Team member record updated successfully.");
        }
    }

    @Override
    public void delete() {
        String strDelete = "DELETE FROM Team_member "
                + "WHERE teamMemberId=" + teamMemberId
                + " AND teamId=" + teamId;
        boolean isDeleted = DB.go.runNonQuery(strDelete);
        if (isDeleted) {
            Tools.msgBox("Team member record deleted successfully.");
        }
    }

    public void deleteByTeam() {
        String strDelete = "DELETE FROM Team_member "
                + "WHERE teamId=" + teamId;
        boolean isDeleted = DB.go.runNonQuery(strDelete);
        if (isDeleted) {
            Tools.msgBox("All members for the specified team deleted successfully.");
        }
    }

    @Override
    public void getAllRows(JTable table) {
        String strSelect = "Slecet phone from Team_member"
                +"where teamId="+teamId;
       DB.go.fillToJTable(strSelect, table);
    }

    @Override
    public String getAutoNumber() {
        Tools.msgBox("getAutoNumber method in Team_member class not supported.");
        return "";
    }

    @Override
    public void getOneRow(JTable table) {
        Tools.msgBox("getOneRow method in Team_member class not supported.");
    }

    @Override
    public void getCustomRows(String statement, JTable table) {
        Tools.msgBox("getCustomRows method in Team_member class not supported.");
    }

    @Override
    public String getValueByName(String name) {
        Tools.msgBox("getValueByName method in Team_member class not supported.");
        return "";
    }

    @Override
    public String getNameByValue(String value) {
        Tools.msgBox("getNameByValue method in Team_member class not supported.");
        return"";
}
}