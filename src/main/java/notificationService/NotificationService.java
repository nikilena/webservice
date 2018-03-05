package notificationService;

import java.io.IOException;
import javax.mail.MessagingException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import io.jsonwebtoken.*;


import management.*;

@Path("/NotificationService")
public class NotificationService {
   private static final String TOKEN_SECRET = "DSE208";
   TodoManagement todo = new TodoManagement();
   ItemManagement item = new ItemManagement();

   public String parseToken(String token) {
      String username=null;
      try {
         System.out.println("TOKEN: " + token);
         username = Jwts.parser()
                 .setSigningKey(TOKEN_SECRET)
                 .parseClaimsJws(token)
                 .getBody()
                 .getSubject();

      }catch(SignatureException e){
         throw new IllegalArgumentException("Invalid Token");
      }
      return username;
   }


   public String getUsernameFromToken(String auth) {

      System.out.println("Authorization " + auth);
      String[] authParts = auth.split(" ");
      return parseToken(authParts[1]);
   }

   //zu testen
   @GET
   @Path("/index")
   @Produces(MediaType.APPLICATION_JSON)
   public String index() {
      return "Hallo World";
}

    //prove todo changes
   @GET
   @Path("/notification")
   @Produces(MediaType.APPLICATION_JSON)
   public String getChanges
   (@HeaderParam("Authorization")String authorization) throws IOException, ClassNotFoundException, MessagingException {
      String username = getUsernameFromToken(authorization);
     todo.getToDoChanges(username);
      String result ="notification works";
      return result;
     }

// prove item changes by todo id
   @GET
   @Path("/not/{todoid}")
   @Produces(MediaType.APPLICATION_JSON)
   public String getItemChanges
   (@HeaderParam("Authorization")String authorization,
                                @PathParam("todoid") String todoid) throws IOException, ClassNotFoundException, MessagingException {
      String username = getUsernameFromToken(authorization);
      item.getItemChanges(username, todoid);
      String result ="not works";
      return result;


   }


}
