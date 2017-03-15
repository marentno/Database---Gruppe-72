package treningsdagbok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class JDBCMySQLDemo {
    public static void main(String[] args) {        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the ExerciseID:");
         
        int exerciseId;
        try {
            exerciseId = Integer.parseInt(br.readLine());
            JDBCMySQLDemo demo = new JDBCMySQLDemo();
            Exercise exercise = demo.getExercise(exerciseId);
            System.out.println(exercise);           
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }       
    }
 
    public Exercise getExercise(int exerciseId)  {      
        ResultSet rs = null;
        Connection connection = null;
        Statement statement = null; 
         
        Exercise exercise = null;
        String query = "SELECT * FROM employee WHERE emp_id=" + exerciseId;
        try {           
            connection = JDBCMySQLConnection.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
             
            if (rs.next()) {
                exercise = new Exercise();
                exercise.setId(rs.getInt("id"));
                exercise.setName(rs.getString("name"));
                exercise.setDuration(rs.getDouble("duration"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return exercise;
    }
}

