/*package model;

import java.text.ParseException;
import java.util.ArrayList;

import management.TodoManagement;
import model.ToDo;



public class TestClient{

	public static void main(String[] args) throws ParseException {

		TodoManagement fm = new TodoManagement(args[0]);

		try{
			if(args[1].equals("add"))
			{
				ToDo newPKW = new ToDo(Integer.parseInt(args[2]),args[3]);
				fm.addToDo(newPKW);

			}

			if(args[1].equals("change"))
			{
				fm.getToDoChanges();

			}
				
				if(args[1].equals("save"))
				{
						fm.saveList();
					
				}

			if(args[1].equals("show"))
			{
				//System.out.println(fm.deleteToDo(Integer.parseInt(args[2]), args[3]));
				ArrayList<ToDo> list = fm.getTodoList();
				for(int i=0; i<list.size(); i++)
				{
					System.out.println(list.get(i).toString());
				}

			}
		}
		catch(Exception i)
		{
			i.printStackTrace();
			System.exit(1);
		}
	}
}
*/

