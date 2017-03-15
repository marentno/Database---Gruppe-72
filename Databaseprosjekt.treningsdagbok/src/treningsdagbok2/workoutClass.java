package treningsdagbok2;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.Scanner;

	public class workoutClass {
		
		   // JDBC driver name and database URL
		   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		   static final String DB_URL = "jdbc:mysql://mysql.stud.ntnu.no/marentno_tdt4145_prosjektdel1";

		   //  Database credentials
		   static final String USER = "marentno";
		   static final String PASS = "gruppe72";
		   
		   public static int chooseUsecase() {
			   int usecasenr;
			   System.out.print("What do you want to do: \n"
			   		+ "1: Register a workout \n" + "2: Collect all trainning notes \n" 
					   + "3: Create a new template \n");
			   Scanner input = new Scanner( System.in );
			   usecasenr = input.nextInt();
			   return usecasenr;
		   }
		   
		   public static void executeUsecase() {
			   int usecasenr = chooseUsecase();
			   if (usecasenr == 1) {
				   
			   }
			   if (usecasenr == 2) {
				  ResultSet rs = printNotes.getNotes();
				  printNotes.printNotes(rs);
			   }
			   if (usecasenr == 3) {
				   ResultSet rs = handleTemplate.getTemplates();
				   handleTemplate.printWorkout(rs);
				   handleTemplate.chooseWorkout(rs);
				   
			   }
			   
		   }
		   
		   public static Connection setUpConn() {
			   Connection conn = null;
			   try{
			      //STEP 2: Register JDBC driver
			      Class.forName("com.mysql.jdbc.Driver");
			      //STEP 3: Open a connection
			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			      return conn;
			      
		   }catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			      return null;
		   } 
		   }
		   
		   public static Statement setUpStmt() {
			   try {
				Statement stmt = setUpConn().createStatement();
				return stmt;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		   }
		   
		   
		   public static void close(Connection conn, Statement stmt, ResultSet rs) {
			   try {
				   rs.close();
				   stmt.close();
				   conn.close();
			   }catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
			   }catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }finally{
			      //finally block used to close resources
			      try{
			         if(stmt!=null)
			            stmt.close();
			      }catch(SQLException se2){
			      }// nothing we can do
			      try{
			         if(conn!=null)
			            conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }
			   }
		   }
		   
		   
		   public static void main(String[] args) { 
		   executeUsecase();
		   System.out.println("Goodbye!");
		}
		

}
