import java.sql.*;

public class check {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// step 1 loading of driver
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("driver loaded");
		//establish connection
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","mayuresh");
		
		System.out.println("success");
		//create statement
		Statement st=con.createStatement();
		System.out.println("statement created");
		//executing query AND obtain result set
		 java.util.Date date= new java.util.Date();
		 Timestamp timestamp=new Timestamp(date.getTime());
		 String t= String.valueOf(timestamp);
		 System.out.println(t);
		String query="INSERT INTO chatusers VALUES (4,\"tayuresh\",\"gokhale\",\""+t+"\")";
		String query1="INSERT INTO chatusers VALUES (2,\"suresh\",\"gokhale\",\""+t+"\")";
		String query2="INSERT INTO chatusers VALUES (3,\"ramesh\",\"gokhale\",\""+t+"\")";
		int rs=st.executeUpdate(query);
		int rs1=st.executeUpdate(query1);
		int rs2=st.executeUpdate(query2);
        System.out.println("inserted");
        ResultSet rws= st.executeQuery("SELECT * FROM chatusers");
        System.out.println("inserted");
        while(rws.next()){
        	System.out.println(rws.getInt("PersonID")+"--"+rws.getString("LastName"));
        	
        }
	}
	

}
