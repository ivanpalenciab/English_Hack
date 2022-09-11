
package test;

import controller.UserController;


public class LoginTest {
    public static void main(String[] args){
        UserController usuario = new UserController();
        String algo = usuario.login("lina","hola");
        System.out.println(algo);
    }
}
