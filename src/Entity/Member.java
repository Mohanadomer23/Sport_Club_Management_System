package Entity;

import javax.swing.JTable;
import sportingclub.Tools.*;
import DB.go;
import sportingclub.Tools;

public class Member implements MainData {
    private int memberId;
    private String firstName;
     private String email;
     private String joinDate;
     private int subscriptionId;

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    

    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

   
    

    
    public int getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    @Override
    public void add() {
        String strinsert="insert INTO members (member_id, name, email, join_date, sub_id) values("
                +memberId+","
                +"'"+firstName+"',"
                +"'"+email+"',"
                +"'"+joinDate+"',"
              //  +"'"+subscriptionState+"',"
                //+membershipTypeId+","
                +subscriptionId+")";
        boolean isAdd= DB.go.runNonQuery(strinsert);
        if(isAdd){
            Tools.msgBox("Member Is Added");
        }
    }

    @Override
    public void update() {
        String strupdate="update members set "
                +"name='"+firstName+"',"
                +"email='"+email+"',"
                +"join_date='"+joinDate+"'";
              //  +"MembersubscriptionState='"+subscriptionState+"',";
        boolean isUpdate= DB.go.runNonQuery(strupdate);
        if(isUpdate){
            Tools.msgBox("Member Is Updated");
        }
    }

    @Override
    public void delete() {
        String strdelete="delete from members "
                +"where Member_id="+memberId;
        boolean isDelet= DB.go.runNonQuery(strdelete);
        if(isDelet){
            Tools.msgBox("Member Is deleted");
        }
                
    }

    @Override
    public String getAutoNumber() {
       return  DB.go.getAutoNumber("members","member_id");
        
    }
    @Override
    public void getAllRows(JTable table) {
        DB.go.fillToJTable("members",table);
    }

    @Override
    public void getOneRow(JTable table) {
        String strSelect="select * from members"
                +"where Member_id="+memberId;
        DB.go.fillToJTable(strSelect,table);
    }
    @Override
    public void getCustomRows(String statement, JTable table) {
         DB.go.fillToJTable(statement,table);
    }

    @Override
    public String getValueByName(String name) {
        String strSelect="select memberid from members"
                +"where name='"+firstName+"'";
      String strVal=(String)DB.go.getTableData(strSelect).Items[0][0];
      return strVal;
    }

    @Override
    public String getNameByValue(String value) {
        String strSelect="select memberFirstName from Member"
                +"where member_id="+memberId;
        String strName=(String)DB.go.getTableData(strSelect).Items[0][0];
      return strName;
}

   

    

    

}
