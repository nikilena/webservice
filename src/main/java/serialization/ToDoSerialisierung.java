package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.ListIterator;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;



import model.ToDo;

public class ToDoSerialisierung {
	 private ArrayList<ToDo> todoList = new ArrayList<ToDo>();
	/* private String todo;
	    private File file;
	    file = new File(todo);

	   @SuppressWarnings("unchecked")
	    public ToDoSerialisierung ()
	    {
		   this.todo = "DBtodo";
		   file = new File(todo);
		   if(file.exists()){
	    }
	            try {
	                FileInputStream fileIn=new FileInputStream("C:\\Users\\Lena\\Desktop\\DBtodo.txt");
	                ObjectInputStream in=new ObjectInputStream(fileIn);
	                todoList= new ArrayList<ToDo>((ArrayList<ToDo>) in.readObject());
	                in.close();
	            } catch (FileNotFoundException e) {
	                e.printStackTrace();
	                System.exit(1);
	            } catch (ClassNotFoundException e) {
	                e.printStackTrace();
	                System.exit(1);
	            } catch (IOException e) {
	                e.printStackTrace();
	                System.exit(1);
	            }
	        }*/
	    

	    
	    public boolean addToDo(ToDo todo) throws ClassNotFoundException, Exception {
	        boolean wert=false;
	        try {
	            todoList=getTodoList();
	           
	            todoList.add(todo);
	            ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("C:\\Users\\Lena\\Desktop\\DBtodo.txt")));
	            oos.writeObject(todoList);
	            oos.close();
	            System.out.println("Saved Todo :) ");
	            wert=true;
	        } catch (IOException i) {
	            i.printStackTrace();
	            System.exit(1);
	        }
	        return wert;
	    }

	 public void saveList(ArrayList<ToDo> copy) {
	        try {
	        	 ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("C:\\Users\\Lena\\Desktop\\DBtodo.txt")));
		            oos.writeObject(copy);
		            oos.close();
		            System.out.println("Saved Todo list :) ");
		        } catch (IOException i) {
		            i.printStackTrace();
		            System.exit(1);}
		        }
	    
	        
	 
	 @SuppressWarnings("unchecked")
	public ArrayList<ToDo> getTodoList() throws ClassNotFoundException{
		 System.out.println("getTodoList works");
		 try{
	            FileInputStream fileIn=new FileInputStream("C:\\Users\\Lena\\Desktop\\DBtodo.txt");
	            ObjectInputStream in=new ObjectInputStream(fileIn);
	            todoList= new ArrayList<ToDo>((ArrayList<ToDo>) in.readObject());
	            in.close();
	            fileIn.close();
	        } catch(IOException ex)
	        {
	            System.out.println(ex);
	        }
	        return todoList;
	    }

	 
	 
	 public void deleteList() throws ClassNotFoundException {
	        todoList = getTodoList();
	        for (int i = 0; i < todoList.size(); i++) {
	                todoList.remove(todoList.get(i));
	            
	        }
	        try {
	        	ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("C:\\Users\\Lena\\Desktop\\DBtodo.txt")));
	            oos.writeObject(todoList);
	            oos.close();
	            System.out.println("Deleted Todo list:) ");
	        } catch (IOException i) {
	            i.printStackTrace();
	            System.exit(1);}
	        }
    
	    

}
	 