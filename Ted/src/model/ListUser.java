package model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;


@XmlRootElement(name="users")
@XmlAccessorType (XmlAccessType.FIELD)
public class ListUser {
	
@XmlElement(name = "user")	
private List<XMLUser> listuser = null;

public List<XMLUser> getList() {
    return this.listuser;
}

public void setList(List<XMLUser> listuser) {
    this.listuser = listuser;
}
}