
package test;

import controller.UserController;


public class GetUserTest {
    public static void main(String[] args){
        UserController user = new UserController();
        String respuesta = user.Delete("prueba");
        System.out.println(respuesta);
    }
    
}
