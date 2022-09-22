
package controller;



public interface IUserController  {
    
    
    public String login(String username, String password);
    public String signup (String username,String password,String name,String lastname,String email);
    
}
