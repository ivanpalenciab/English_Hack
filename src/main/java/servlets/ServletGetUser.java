
package servlets;

import controller.UserController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Iapal
 */
@WebServlet(name = "ServletGetUser", urlPatterns = {"/ServletGetUser"})
public class ServletGetUser extends HttpServlet {
private static final long serialVersionUID =1L;
   public ServletGetUser(){
       super();
   }
   
    

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserController user = new UserController();
        String username = request.getParameter("username");
        String usuarioStr = user.get(username);
        
        PrintWriter out = response.getWriter();
        out.println(usuarioStr);
        out.flush();
        out.close();
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       doGet(request,response);
    }

  
}
