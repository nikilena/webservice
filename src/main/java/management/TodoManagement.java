package management;

import java.util.ArrayList;
import javax.mail.MessagingException;
import javax.ws.rs.core.MediaType;


import model.ToDo;
import serialization.ToDoSerialisierung;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.GenericType;


public class TodoManagement {
	 private ToDoSerialisierung todoDAO;



	private Client client;
	private String REST_SERVICE_URL_ToDo = "http://10.102.108.17:8080/todo/todos";
	TestDaten daten=new TestDaten();
    private static final String PASS = "pass";
    private static final String FAIL = "fail";

    SendEmail sendmail = new SendEmail();
	
	 private ArrayList<ToDo> OldTodoList = new ArrayList<ToDo>();
	 private ArrayList<ToDo> SortedtestTodoList = new ArrayList<ToDo>();
	 private ArrayList<ToDo> SortedOldTodoList = new ArrayList<ToDo>();
	ArrayList<ToDo> testToDoList;
	 
	 public TodoManagement(){

	        this.todoDAO = new ToDoSerialisierung();
	    }
	    public TodoManagement(String todo){

	        this.todoDAO = new ToDoSerialisierung();
	    }
	    
	    

	    public void addToDo(ToDo todo) throws ClassNotFoundException, Exception{
	    	todoDAO.addToDo(todo);
	    }
	 
	    
	 public void saveList( ArrayList<ToDo>list) {
		 todoDAO.saveList(list);}
		 
	 
	 public ArrayList<ToDo> getTodoList() throws ClassNotFoundException{
		 OldTodoList=todoDAO.getTodoList();
		 return OldTodoList;
		 
	 }
	 
	
	 
	 public String getToDoChanges (String id) throws ClassNotFoundException, MessagingException {
		 String email=id;

		 /*GenericType<ArrayList<ToDo>> list = new GenericType<ArrayList<ToDo>>() {};
		 System.out.println("Before Maira");
		 ArrayList<ToDo> testToDoList = client
				 .target(REST_SERVICE_URL_ToDo)
				 .request(MediaType.APPLICATION_JSON)
				 .request("Authorization " + auth)
				 .get(list);
		 System.out.println("Got list from Maira");
         String result = PASS;
         if(testToDoList.isEmpty()){
             result = FAIL;
         }
         System.out.println("Test case  Result: " + result );*/

		 testToDoList=daten.getToDoTestDaten();
		//String result= "Notification was successfully sent to your email address";
		OldTodoList=getTodoList();
		 for(ToDo oldByMail: OldTodoList){
			 if((oldByMail.getTdlId()).equalsIgnoreCase(email)){
				 SortedOldTodoList.add(oldByMail);}}
		 System.out.println("Old Todo list sorted :) ");
		 
			 for(ToDo newByMail: testToDoList){
				 if((newByMail.getTdlId()).equalsIgnoreCase(email)){
					 SortedtestTodoList.add(newByMail);}
				 
		 }
			 
			 System.out.println("Test Todo list sorted :) ");
		 
	if( SortedtestTodoList.size()==SortedOldTodoList.size()){
  	  String text = "Keine TODO Listen wurden geloescht oder addiert";
	sendmail.generateAndSendEmail(email, text);
	}
  	  else
  		  if (SortedtestTodoList.size()>SortedOldTodoList.size()){
  			  String text = "Neue TODO List wurde addiert";
			  sendmail.generateAndSendEmail(email, text);
  		  }
  		  else{
  			  String text = "TODO List wurde geloescht";
			  sendmail.generateAndSendEmail(email, text);}
	
	
	ArrayList<ToDo> toRemove = new ArrayList<ToDo>();
	for (ToDo str : OldTodoList) {
		 if(str.getTdlId().equalsIgnoreCase(email)) {
	        toRemove.add(str);
	    }
	}
	OldTodoList.removeAll(toRemove);
	
	
	     for(ToDo todo: SortedtestTodoList){
			 OldTodoList.add(todo);
	}
	           
	 System.out.println("Old Todo list updated :) ");
	 
		 	 
	todoDAO.deleteList();
	 System.out.println("Todo list deleted :) ");
	
	 saveList(OldTodoList);
	 
	 System.out.println("Updated Todo list saved :) ");
	 String result = "email sent";
	 return result;



}
}