/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import javax.swing.JTable;
import sportingclub.Tools;

public class Managers implements MainData {
    private int mangerId;
    private String name;
    private String department;
    private String email;

    // Getters and Setters
    public int getMangerId() {
        return mangerId;
    }

    public void setMangerId(int mangerId) {
        this.mangerId = mangerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Override methods
    @Override
    public void add() {
        if (name==null|| "".equals(name) || email==null|| "".equals(email) || department==null|| "".equals(department)) {
            Tools.msgBox("Please fill in all fields.");
            
        }
        else{
        String strInsert = "INSERT INTO managers (manager_id, name, department, email) VALUES ("
                + mangerId + ", "
                + "'" + name + "', "
                + "'" + department + "', "
                + "'" + email + "')";
        boolean isAdded = DB.go.runNonQuery(strInsert);
        if (isAdded) {
            Tools.msgBox("Manager added successfully.");
        }
    }}

    @Override
    public void update() {
        String strUpdate = "UPDATE managers SET "
                + "name='" + name + "', "
                + "department='" + department + "', "
                + "email='" + email + "' "
                + "WHERE manager_id=" + mangerId;
        boolean isUpdated = DB.go.runNonQuery(strUpdate);
        if (isUpdated) {
            Tools.msgBox("Manager updated successfully.");
        }
    }

    @Override
    public void delete() {
        String strDelete = "DELETE FROM managers"
                +" WHERE manager_id=" + mangerId;
        boolean isDeleted = DB.go.runNonQuery(strDelete);
        if (isDeleted) {
            Tools.msgBox("Manager deleted successfully.");
        }
    }

    @Override
    public String getAutoNumber() {
        return DB.go.getAutoNumber("managers", "manager_id");
    }

    @Override
    public void getAllRows(JTable table) {
        DB.go.fillToJTable("managers", table);
    }

    @Override
    public void getOneRow(JTable table) {
        String strSelect = "SELECT * FROM managers "
                +"WHERE manager_id=" + mangerId;
        DB.go.fillToJTable(strSelect, table);
    }

    @Override
    public void getCustomRows(String statement, JTable table) {
        DB.go.fillToJTable(statement, table);
    }

    @Override
    public String getValueByName(String name) {
        String strSelect = "SELECT manager_id FROM managers "
                +"WHERE name='" + name + "'";
        String strVal = (String) DB.go.getTableData(strSelect).Items[0][0].toString();
        return strVal;
    }

    @Override
    public String getNameByValue(String value) {
        String strSelect = "SELECT name FROM managers "
                +"WHERE manager_id=" + value;
        String strName = (String) DB.go.getTableData(strSelect).Items[0][0].toString();
        return strName;
}
}