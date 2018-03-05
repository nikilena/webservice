package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.BufferedOutputStream;




import model.Item;

public class ItemSerialisierung {
	 private ArrayList<Item> itemList = new ArrayList<Item>();
	
	    

	    
	    public boolean addItem(Item item) throws ClassNotFoundException, Exception {
	        boolean wert=false;
	        try {
	            itemList=getItemList();
	           
	            itemList.add(item);
	            ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("C:\\Users\\Lena\\Desktop\\DBitem.txt")));
	            oos.writeObject(itemList);
	            oos.close();
	            System.out.println("Saved Item :) ");
	            wert=true;
	        } catch (IOException i) {
	            i.printStackTrace();
	            System.exit(1);
	        }
	        return wert;
	    }

	 public void saveItemList(ArrayList<Item> copy) {
	        try {
	        	 ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("C:\\Users\\Lena\\Desktop\\DBitem.txt")));
		            oos.writeObject(copy);
		            oos.close();
		            System.out.println("Saved Item list :) ");
		        } catch (IOException i) {
		            i.printStackTrace();
		            System.exit(1);}
		        }
	    
	        
	 
	 @SuppressWarnings("unchecked")
	public ArrayList<Item> getItemList() throws ClassNotFoundException{
		 System.out.println("getItemList works");
		 try{
	            FileInputStream fileIn=new FileInputStream("C:\\Users\\Lena\\Desktop\\DBitem.txt");
	            ObjectInputStream in=new ObjectInputStream(fileIn);
	            itemList= new ArrayList<Item>((ArrayList<Item>) in.readObject());
	            in.close();
	            fileIn.close();
	        } catch(IOException ex)
	        {
	            System.out.println(ex);
	        }
	        return itemList;
	    }

	 
	 
	 public void deleteItemList() throws ClassNotFoundException {
	        itemList = getItemList();
	        for (int i = 0; i < itemList.size(); i++) {
	                itemList.remove(itemList.get(i));
	            
	        }
	        try {
	        	ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("C:\\Users\\Lena\\Desktop\\DBitem.txt")));
	            oos.writeObject(itemList);
	            oos.close();
	            System.out.println("Deleted Todo list:) ");
	        } catch (IOException i) {
	            i.printStackTrace();
	            System.exit(1);}
	        }
    
	    

}
	 
	 


