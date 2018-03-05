package management;

import java.io.IOException;
import java.util.ArrayList;
import model.Item;
import model.ToDo;
import serialization.ItemSerialisierung;

import javax.mail.MessagingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

public class ItemManagement {
	 private ItemSerialisierung todoDAO;

	int todoId;
	String email;
	ArrayList<Item> testItemList;
	TestDaten daten=new TestDaten();
	SendEmail send = new SendEmail();

	private Client client;
	private String REST_SERVICE_URL_Item = "10.102.108.17:8080/todo/{todoId}/items";
	private ArrayList<Item> OldTodoList = new ArrayList<Item>();
	 private ArrayList<Item> SortedtestTodoList = new ArrayList<Item>();
	 private ArrayList<Item> SortedOldTodoList = new ArrayList<Item>();
	 
	 public ItemManagement(){

	        this.todoDAO = new ItemSerialisierung();
	    }
	    public ItemManagement(String todo){

	        this.todoDAO = new ItemSerialisierung();
	    }
	    
	    

	    public void addItem(Item todo) throws ClassNotFoundException, Exception{
	    	todoDAO.addItem(todo);
	    }
	 
	    
	 public void saveItemList( ArrayList<Item>list) {
		 todoDAO.saveItemList(list);}
		 
	 
	 public ArrayList<Item> getItemList() throws ClassNotFoundException{
		 OldTodoList=todoDAO.getItemList();
		 return OldTodoList;
		 
	 }
	 
	
	 
	 public String getItemChanges (String mail, String todoId) throws ClassNotFoundException, MessagingException {
		 email=mail;
		 /*GenericType<ArrayList<Item>> list = new GenericType<ArrayList<Item>>() {};
		 ArrayList<Item> testItemList = client
				 .target(REST_SERVICE_URL_Item)
				 .request(MediaType.APPLICATION_JSON)
				 .get(list);*/

		 //String result= "Notification was successfully sent to your email address";
		 OldTodoList=getItemList();
		 for(Item oldByMail: OldTodoList){
			 if((oldByMail.getTodoId().equalsIgnoreCase(todoId))&&((oldByMail.getTdlId()).equalsIgnoreCase(email))){
				 SortedOldTodoList.add(oldByMail);}}
		 System.out.println("Old Item list sorted :) ");
		// else System.out.println("No user with such email or no ToDo list with such ID");

		 testItemList=daten.getItemTestDaten();
		 for(int i=0;i<testItemList.size();i++){{
		 	i=i+1;
		 }
		 System.out.println("i= "+ i);}
		 System.out.println(todoId);
		 for(Item newByMail: testItemList){
			 if((newByMail.getTodoId().equalsIgnoreCase(todoId))&&((newByMail.getTdlId()).equalsIgnoreCase(email))){

				 SortedtestTodoList.add(newByMail);}

		 }

		 System.out.println("Test Item list sorted :) ");

		 if( SortedtestTodoList.size()==SortedOldTodoList.size()){
			 String text = "Keine Items wurden geloescht oder addiert";
			 send.generateAndSendEmail(email, text);
		 }
		 else
		 if (SortedtestTodoList.size()>SortedOldTodoList.size()){
			 String text = "Neue Item(s) wurde(n) addiert";
			 send.generateAndSendEmail(email, text);
		 }
		 else{
			 String text = "Item(s) wurde(n) geloescht";
			 send.generateAndSendEmail(email, text);}


		 ArrayList<Item> toRemove = new ArrayList<Item>();
		 for (Item str : OldTodoList) {
			 if((str.getTodoId().equalsIgnoreCase(todoId))&&((str.getTdlId()).equalsIgnoreCase(email))){
				 toRemove.add(str);
			 }
		 }
		 OldTodoList.removeAll(toRemove);


		 for(Item todo: SortedtestTodoList){
			 OldTodoList.add(todo);
		 }

		 System.out.println("Old Item list updated :) ");


		 todoDAO.deleteItemList();
		 System.out.println("Item list deleted :) ");

		 saveItemList(OldTodoList);

		 System.out.println("Updated Item list saved :) ");
		 String result = "email sent";
		 return result;
	 }
}