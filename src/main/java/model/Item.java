package model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


	
@SuppressWarnings("restriction")

	
	
	@XmlRootElement(name = "Item")
	public class Item implements Serializable {

	   private static final long serialVersionUID = 1L;

	public String Id;
	public boolean status=false;
	public String TodoId;
	public String tdlId;

	public Item(String s, boolean b, String s1, String s2){}
	public Item(String Id){
		this.Id=Id;
		setStatus(false);
	}

	public String getID() {
		return Id;
	}

	@XmlElement
	public void setID(String Id) {
		this.Id = Id;
	}

	public boolean getStatus() {
		return status;
	}

	@XmlElement
	public void setStatus(boolean status) {
		this.status=status;
	}

	public String getTodoId() {
		return TodoId;
	}

	@XmlElement
	public void setTodoId(String todoId) {
		TodoId = todoId;
	}

	public String getTdlId() {
		return tdlId;
	}

	@XmlElement
	public void setTdlId(String tdlId) {
		this.tdlId = tdlId;
	}


	public String toString()
	{
		return "Item ID: " + getID() + "\n" + "Status: " + getStatus() + "\n"
				+ "TodoId: " + getTodoId()+"\n"+ "ToDoListId: " + getTdlId() + "\n";
	}

}






