package sarf.xml;

import java.io.*;

public class DefaultXmlElement implements XmlElement {

    private String name;
    private boolean closed = false;
    private int tabCount = 0;

    private PrintStream out;
    private boolean closedStartTag;

    DefaultXmlElement(String name, PrintStream out) {
        this.name = name;
        this.out = out;
        writeStartTag();
    }

    private DefaultXmlElement(String name, PrintStream out, DefaultXmlElement parent) {
        this.name = name;
        this.out = out;
        tabCount = parent.tabCount + 1;
        writeStartTag();
    }

    private void writeStartTag() {
        out.print(getTabString(tabCount) + "<" + name);
    }

    public void closeStartTag() {
        out.println(">");
        closedStartTag = true;
    }

    private void writeEndTag() {
        out.println(getTabString(tabCount) + "</" + name + ">");
    }

    private String getTabString(int count) {
        return "\t".repeat(Math.max(0, count));
    }

    public void addDataElement(String name, String data) {
        addDataElement(new XmlDataElement(name, data));
    }

    public void addDataElement(XmlDataElement dataElement) {
        out.println(getTabString(tabCount + 1) + dataElement.toString());
    }

    public XmlElement addElement(String name) {
        if (closed)
            throw new java.lang.UnsupportedOperationException("Method addAttribute() not yet implemented.");

        return new DefaultXmlElement(name, out, this);
    }

    public void closeStartAndEndTag() {
        out.println(" />");
        closedStartTag = true;
        closed = true;
    }

    public void close() {
        closed = true;
        writeEndTag();
    }

    public void addAttribute(String name, String value) {
        if (closedStartTag)
            throw new java.lang.UnsupportedOperationException("Method addAttribute() not yet implemented.");
        out.print(" "+name + "=\"" + value + "\"");
    }
}
