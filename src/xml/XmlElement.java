package xml;

public interface XmlElement {
    public XmlElement addElement(String name);
    public void addDataElement(String name, String value);
    public void addDataElement(XmlDataElement dataElement);
    public void close();
    public void closeStartTag();
    public void closeStartAndEndTag();
    public void addAttribute(String name, String value);
}
