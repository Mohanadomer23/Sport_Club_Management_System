        package Entity;

import javax.swing.JTable;
import sportingclub.Tools;

public class Events implements MainData {
    private int eventId;
    private String eventName;
    private String eventDate;
    private String eventLocation;

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    @Override
    public void add() {
        if (eventDate==null|| "".equals(eventDate) || eventName==null|| "".equals(eventName) || eventLocation==null|| "".equals(eventLocation)) {
            Tools.msgBox("Please fill in all fields.");
            
        }
        else{
        String strinsert = "INSERT INTO events (eventId, eventName, eventDate, eventLocation) VALUES ("
                + eventId + ","
                + "'" + eventName + "',"
                + "'" + eventDate + "',"
                + "'" + eventLocation + "')";
        boolean isAdd = DB.go.runNonQuery(strinsert);
        if (isAdd) {
            Tools.msgBox("Event is Added");
        }
    }}

    @Override
    public void update() {
        String strupdate = "UPDATE events SET "
                + "eventName='" + eventName + "',"
                + "eventDate='" + eventDate + "',"
                + "eventLocation='" + eventLocation + "' "
                + "WHERE eventId=" + eventId;
        boolean isUpdate = DB.go.runNonQuery(strupdate);
        if (isUpdate) {
            Tools.msgBox("Event is Updated");
        }
    }

    @Override
    public void delete() {
        String strdelete = "DELETE FROM events "
                + "WHERE eventId=" + eventId;
        boolean isDelete = DB.go.runNonQuery(strdelete);
        if (isDelete) {
            Tools.msgBox("Event is Deleted");
        }
    }

    @Override
    public String getAutoNumber() {
        return DB.go.getAutoNumber("events", "eventId");
    }

    @Override
    public void getAllRows(JTable table) {
        DB.go.fillToJTable("events", table);
    }

    @Override
    public void getOneRow(JTable table) {
        String strSelect = "SELECT * FROM events "
                + "WHERE eventId=" + eventId;
        DB.go.fillToJTable(strSelect, table);
    }

    @Override
    public void getCustomRows(String statement, JTable table) {
        DB.go.fillToJTable(statement, table);
    }

    @Override
    public String getValueByName(String name) {
        String strSelect = "SELECT eventId FROM events "
                + "WHERE eventName='" + eventName + "'";
        String strVal = (String) DB.go.getTableData(strSelect).Items[0][0];
        return strVal;
    }

    @Override
    public String getNameByValue(String value) {
        String strSelect = "SELECT eventName FROM events "
                + "WHERE eventId=" + eventId;
        String strName = (String) DB.go.getTableData(strSelect).Items[0][0];
        return strName;
    }
}