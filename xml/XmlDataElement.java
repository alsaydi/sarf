package xml;

public class XmlDataElement {
    protected String name;
    protected String value;

    public XmlDataElement(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String toString() {
        return "<"+name+">" + value + "</"+name+">";
    }
}
