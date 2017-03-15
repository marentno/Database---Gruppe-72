package treningsdagbok2;

	import java.sql.Connection;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	public class printNotes {
			
				static Connection conn = workoutClass.setUpConn();
				static Statement stmt = workoutClass.setUpStmt();
				
				
				public static ResultSet getNotes() {
				try {
					String sql;
					sql = "SELECT * FROM notes";
					ResultSet rs = stmt.executeQuery(sql);
					return rs;

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
				}
				
				public static void printNotes(ResultSet rs) {
					 try {
						while(rs.next()){
						     //Retrieve by column name
							int id = rs.getInt("id");
							String tips = rs.getString("workouttips");
							String purpose = rs.getString("workoutpurpose");
							   

						     //Display values
							 System.out.println("Id:" + id + ", Tips:" + tips + 
									 ", Purpose: " + purpose);
						
						  }
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					 workoutClass.close(conn, stmt, rs);
				}	

		}

