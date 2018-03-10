package xml;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: developer SW Solutions</p>
 * @author Haytham
 * @version 1.0
 */

public class XmlPropertyElement extends XmlDataElement{

    public XmlPropertyElement(String name, String value) {
        super(name,value);
    }

    public String toString() {
        return "<property name= \""+name+"\" value= \"" + value + "\"/>";
    }
}
