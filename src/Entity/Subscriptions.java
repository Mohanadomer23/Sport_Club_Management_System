package Entity;

import javax.swing.JTable;
import sportingclub.Tools;

public class Subscriptions implements MainData {
    private int subscriptionId;
    private String subscriptionPlanType;
    private double subscriptionAmount;
    private String subscriptionStartDate;
    private String subscriptionEndDate;

    public int getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getSubscriptionPlanType() {
        return subscriptionPlanType;
    }

    public void setSubscriptionPlanType(String subscriptionPlanType) {
        this.subscriptionPlanType = subscriptionPlanType;
    }

    public double getSubscriptionAmount() {
        return subscriptionAmount;
    }

    public void setSubscriptionAmount(double subscriptionAmount) {
        this.subscriptionAmount = subscriptionAmount;
    }

    public String getSubscriptionStartDate() {
        return subscriptionStartDate;
    }

    public void setSubscriptionStartDate(String subscriptionStartDate) {
        this.subscriptionStartDate = subscriptionStartDate;
    }

    public String getSubscriptionEndDate() {
        return subscriptionEndDate;
    }

    public void setSubscriptionEndDate(String subscriptionEndDate) {
        this.subscriptionEndDate = subscriptionEndDate;
    }

    @Override
    public void add() {
        String strinsert = "INSERT INTO subscription (subscriptionId, subscriptionPlanType, subscriptionAmount, subscriptionStartDate, subscriptionEndDate) VALUES ("
                + subscriptionId + ","
                + "'" + subscriptionPlanType + "',"
                + subscriptionAmount + ","
                + "'" + subscriptionStartDate + "',"
                + "'" + subscriptionEndDate + "')";
        boolean isAdd = DB.go.runNonQuery(strinsert);
        if (isAdd) {
            Tools.msgBox("Subscription is Added");
        }
    }

    @Override
    public void update() {
        String strupdate = "UPDATE subscription SET "
                + "subscriptionPlanType='" + subscriptionPlanType + "',"
                + "subscriptionAmount=" + subscriptionAmount + ","
                + "subscriptionStartDate='" + subscriptionStartDate + "',"
                + "subscriptionEndDate='" + subscriptionEndDate + "' "
                + "WHERE subscriptionId=" + subscriptionId;
        boolean isUpdate = DB.go.runNonQuery(strupdate);
        if (isUpdate) {
            Tools.msgBox("Subscription is Updated");
        }
    }

    @Override
    public void delete() {
        String strdelete = "DELETE FROM subscription "
                + "WHERE subscriptionId=" + subscriptionId;
        boolean isDelete = DB.go.runNonQuery(strdelete);
        if (isDelete) {
            Tools.msgBox("Subscription is Deleted");
        }
    }

    @Override
    public String getAutoNumber() {
        return DB.go.getAutoNumber("subscription", "subscriptionId");
    }

    @Override
    public void getAllRows(JTable table) {
        DB.go.fillToJTable("subscription", table);
    }

    @Override
    public void getOneRow(JTable table) {
        String strSelect = "SELECT * FROM subscription "
                + "WHERE subscriptionId=" + subscriptionId;
        DB.go.fillToJTable(strSelect, table);
    }

    
    @Override
    public String getValueByName(String name) {
        String strSelect = "SELECT subscriptionId FROM subscription "
                + "WHERE subscriptionPlanType='" + name + "'";
        String strVal = (String) DB.go.getTableData(strSelect).Items[0][0].toString();
        return strVal;
    }

    @Override
    public String getNameByValue(String value) {
        String strSelect = "SELECT subscriptionPlanType FROM subscription "
                + "WHERE subscriptionId=" + value;
        String strName = (String) DB.go.getTableData(strSelect).Items[0][0].toString();
        return strName;
    }

    @Override
    public void getCustomRows(String statement, JTable table)
    {
        DB.go.fillToJTable(statement, table);    
    }
}