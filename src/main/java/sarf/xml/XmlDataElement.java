package sarf.xml;

public class XmlDataElement {
    protected final String name;
    protected final String value;

    XmlDataElement(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String toString() {
        return "<"+name+">" + value + "</"+name+">";
    }
}
