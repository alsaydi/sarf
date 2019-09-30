package sarf.xml;

public interface XmlElement {
    XmlElement addElement(String name);
    void addDataElement(String name, String value);
    void addDataElement(XmlDataElement dataElement);
    void close();
    void closeStartTag();
    void closeStartAndEndTag();
    void addAttribute(String name, String value);
}
