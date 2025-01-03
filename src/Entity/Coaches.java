package Entity;

import javax.swing.JTable;
import sportingclub.Tools;

public class Coaches implements MainData {
    private int coachId;
    private String coachName;
    private String coachSpecialty;
    private String coachEmail;

    public int getCoachId() {
        return coachId;
    }

    public void setCoachId(int coachId) {
        this.coachId = coachId;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public String getCoachSpecialty() {
        return coachSpecialty;
    }

    public void setCoachSpecialty(String coachSpecialty) {
        this.coachSpecialty = coachSpecialty;
    }

    public String getCoachEmail() {
        return coachEmail;
    }

    public void setCoachEmail(String coachEmail) {
        this.coachEmail = coachEmail;
    }

    @Override
    public void add() {
        if (coachName==null|| "".equals(coachName) || coachEmail==null|| "".equals(coachEmail) || coachSpecialty==null|| "".equals(coachSpecialty)) {
            Tools.msgBox("Please fill in all fields.");
            
        }
        else{
        String strinsert = "INSERT INTO coaches (coach_id, name, specialty, email) VALUES ("
                + coachId + ","
                + "'" + coachName + "',"
                + "'" + coachSpecialty + "',"
                + "'" + coachEmail + "')";
        boolean isAdd = DB.go.runNonQuery(strinsert);
        if (isAdd) {
            Tools.msgBox("Coach is Added");
        }
    }}

    @Override
    public void update() {
        String strupdate = "UPDATE coaches SET "
                + "name='" + coachName + "',"
                + "specialty='" + coachSpecialty + "',"
                + "email='" + coachEmail + "' "
                + "WHERE coach_id=" + coachId;
        boolean isUpdate = DB.go.runNonQuery(strupdate);
        if (isUpdate) {
            Tools.msgBox("Coach is Updated");
        }
    }

    @Override
    public void delete() {
        String strdelete = "DELETE FROM coaches "
                + "WHERE coach_id=" + coachId;
        boolean isDelete = DB.go.runNonQuery(strdelete);
        if (isDelete) {
            Tools.msgBox("Coach is Deleted");
        }
    }

    @Override
    public String getAutoNumber() {
        return DB.go.getAutoNumber("coaches", "coach_id");
    }

    @Override
    public void getAllRows(JTable table) {
        DB.go.fillToJTable("coaches", table);
    }

    @Override
    public void getOneRow(JTable table) {
        String strSelect = "SELECT * FROM coaches "
                + "WHERE coach_id=" + coachId;
        DB.go.fillToJTable(strSelect, table);
    }

    @Override
    public void getCustomRows(String statement, JTable table) {
        DB.go.fillToJTable(statement, table);
    }

    @Override
    public String getValueByName(String name) {
        String strSelect = "SELECT coach_id FROM coaches "
                + "WHERE name='" + name + "'";
        String strVal = (String) DB.go.getTableData(strSelect).Items[0][0].toString();
        return strVal;
    }

    @Override
    public String getNameByValue(String value) {
        String strSelect = "SELECT name FROM coaches "
                + "WHERE coach_id=" + value;
        String strName = (String) DB.go.getTableData(strSelect).Items[0][0].toString();
        return strName;
    }
    
}