package management;

import java.util.ArrayList;

import model.*;

public class TestDaten {
	
	ArrayList <ToDo> testDaten = new ArrayList<ToDo>();
    ArrayList <Item> testItem = new ArrayList<Item>();

	public String getEmail(){
		String email ="user1@gmail.com";
		return email;
	}

    public String getTodoId(){
        String id ="1";
        return id;
    }

	
	public ArrayList<ToDo> getToDoTestDaten(){
		ToDo todo1 = new ToDo("1", "julius.christine@hotmail.com");
		testDaten.add(todo1);
		ToDo todo2 = new ToDo("2", "user2@gmail.com");
		testDaten.add(todo2);
		ToDo todo3 = new ToDo("3", "user3@gmail.com");
		testDaten.add(todo3);
		ToDo todo4 = new ToDo("4", "user1@gmail.com");
		testDaten.add(todo4);
		return testDaten;
		}


    public ArrayList<Item> getItemTestDaten(){
        Item item1 = new Item("1", false, "1", "julius.christine@hotmail.com");
        testItem.add(item1);
        Item item2 = new Item("1",false, "2", "user2@gmail.com");
        testItem.add(item2);
        Item item3 = new Item("1",false, "3", "user3@gmail.com");
        testItem.add(item3);
        Item item4 = new Item("1",false, "4", "user4@gmail.com");
        testItem.add(item4);
        return testItem;



    }
}
