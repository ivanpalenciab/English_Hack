
package controller;

import beans.UserLesson;
import com.google.gson.Gson;
import connection.DBConnection;
import java.sql.ResultSet;
import java.sql.Statement;


public class LessonController implements ILessonController{
    @Override
    public String sendGrade(String username, int lessonId,boolean finished , double grade){
        Gson gson = new Gson();
        DBConnection connection = new DBConnection();
        String sql = "INSERT INTO user_lesson (username,lesson_id,finished,grade) VALUES ('"+ username +"',"+ lessonId + ","+finished+","+grade+");";
         try {
            Statement st = connection.getConnection().createStatement();
           st.executeUpdate(sql);
            
           UserLesson lesson = new UserLesson(username,lessonId,finished,grade);
           st.close();
           return gson.toJson(lesson);
                      
            }
            
         catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
         finally {
            connection.disconnect();
        }
        return "false";
    }
    
    @Override
    public String getInfo(String username, int lessonId ){
        Gson gson = new Gson();
        DBConnection connection = new DBConnection();
        String sql = "SELECT * FROM user_lesson WHERE username= '" +username +"' AND lesson_id = "+lessonId+";";
        try {
            Statement st = connection.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                
                boolean finished = rs.getBoolean("finished");
                double grade = rs.getDouble("grade");
                
                UserLesson userLesson = new UserLesson(username,lessonId,finished,grade);
                return gson.toJson(userLesson);
                      
            }
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return "false";
    }
    
    
    
}
