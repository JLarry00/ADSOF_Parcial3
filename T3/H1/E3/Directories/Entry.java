package Directories;

import java.time.*;

public abstract class Entry {
    private String name;
    private LocalDateTime lastModif;
    
    public Entry(String name, LocalDateTime dateTime) {
        this.name = name;
        this.lastModif = dateTime;
    }
    
    public String getName() { return name; }

    public LocalDateTime getLastModif() { return lastModif; }

    public String getContent(int indent) {
        String str = "";
        for (int i = 0; i < indent; i++) str += "    ";
        str += "Name: " + name;
        return str;
    }

    abstract public int size();

    abstract public int nFiles();

    abstract public void add(Entry e) throws IllegalArgumentException;

    abstract public void remove(Entry e) throws IllegalArgumentException;
}