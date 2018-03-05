package model;
import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("restriction")

	
	
	@XmlRootElement(name = "ToDo")
	public class ToDo implements Serializable {

	   private static final long serialVersionUID = 1L;

	public String id;
	public String tdlId;

	public ToDo(String id, String tdlId){this.id=id; this.tdlId=tdlId;}

	public ToDo(){}

	public ToDo(String id){this.id=id;}

	public String getID() {
		return id;
	}

	@XmlElement
	public void setID(String id) {
		this.id = id;
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
		return "Id: " + getID() + "\n" + "TodoListId: " + getTdlId() + "\n";
	}

}








