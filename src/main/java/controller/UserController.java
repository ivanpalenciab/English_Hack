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
        String sql = "SELECT * FROM user WHERE username='"+username+"'and password ='"+password+"'";
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
    
        @Override
    public String signup(String username,String password,String name,String lastname,String email){
        Gson gson = new Gson();
        DBConnection con = new DBConnection();
        String sql = "INSERT INTO user VALUES ('"+username+"', '"+name+"', '"+lastname+"', '"+password+"', '"+email+"')";
        try {
            Statement st = con.getConnection().createStatement();
             st.executeUpdate(sql);

                
                User user = new User( username, name,lastname, password, email);
                st.close();
                return gson.toJson(user);
                
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            con.disconnect();
        }
        return "false";       
    }
     @Override
    public String get(String username){
        Gson gson = new Gson();
        DBConnection con = new DBConnection();
        String sql = "SELECT * FROM user WHERE username='"+username+"'";
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                String password =rs.getString("password");
                String name =rs.getString("name");
                String lastname =rs.getString("lastname");
                String email =rs.getString("email");
                
                User user = new User( username, name,lastname, password, email);
                return gson.toJson(user);
                
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            con.disconnect();
        }
        return "false";       
    }
    @Override
    public String Delete(String username){
        DBConnection con = new DBConnection();
        String sql1 = "Delete from user where username = '" + username + "'";
        String sql2 = "Delete from user_lesson where username = '" + username + "'";
        
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql2);
            st.executeUpdate(sql1);

            return "true";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.disconnect();
        }

        return "false";
    
    }
    @Override
    public String Update(String username,String newpassword,String newname,String newlastname,String newemail){
        DBConnection con = new DBConnection();
        String sql =  "UPDATE user set name = '"+ newname +"', lastname='"+newlastname+"', password='"+ newpassword +"',email='"+newemail+"' WHERE username = '"+username+"';";
        
         try {

            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            return "true";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.disconnect();
        }

        return "false";

    }
    }
    

