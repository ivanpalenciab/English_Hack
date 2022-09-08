package controller;

import beans.User;
import com.google.gson.Gson;
import connection.DBConnection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserController implements IUserController {
    
    @Override
    public String login(String username, String password){
        Gson gson = new Gson();
        DBConnection connection = new DBConnection();
        String sql = "SELECT * FROM users WHERE username='"+username+"'and password '"+password+"'";
        try {
            Statement st = connection.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                String name = rs.getString("name");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                
                User user = new User( username,  name, lastname,  password,  email);
                return gson.toJson(user);
                      
            }
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return "false";
      
    }
    
}
