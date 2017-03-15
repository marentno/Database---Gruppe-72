package treningsdagbok2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class handleTemplate {
	
	static Connection conn = workoutClass.setUpConn();
	static Statement stmt = workoutClass.setUpStmt();
	
	
	public static ResultSet getTemplates() {
	try {
		
		String sql;
		sql = "SELECT workout, name, duration, date, performance FROM exercise, workout WHERE "
				+ "exercise.workout = workout.id";
		ResultSet rs = stmt.executeQuery(sql);
		return rs;

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	}
	
	public static void printWorkout(ResultSet rs) {
		System.out.println("Pick a workout to add as template: ");
		Map<Integer, ArrayList<String>> dict = new HashMap<Integer, ArrayList<String>>();

		 try {
			while(rs.next()){
			     //Retrieve by column name
				ArrayList<String> exercises = new ArrayList<String>();
				String name = rs.getString("name");
				int id = rs.getInt("workout");
				
				if(dict.containsKey(id)){
					dict.get(id).add(name);
				}
				else{
					exercises.add(name);
					dict.put(id, exercises);
				}
				
			  }
			//Display values
			System.out.println(dict);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void chooseWorkout(ResultSet rs) {
		Scanner input = new Scanner( System.in );
		int workoutNr = input.nextInt();
		System.out.println("Write the template name: ");
		String templateName = input.next();
		try {
			stmt = conn.createStatement();
			String sql = "INSERT INTO template " +
	                   "VALUES ('test', 1)";
			stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(templateName);
		workoutClass.close(conn, stmt, rs);  
	     
	}

}


			
				