
package controller;



public interface IUserController  {
    
    
    public String login(String username, String password);
    public String signup (String username,String password,String name,String lastname,String email);
    public String get(String username);
    public String Delete(String username);
    public String Update(String newusername,String newpassword,String newname,String newlastname,String newemail);
    
}
