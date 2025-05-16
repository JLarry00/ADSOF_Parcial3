package Directories;

import java.time.*;
import java.util.*;

public class Directory extends Entry {
    private List<Entry> entries;

    public Directory(String name, LocalDateTime dateTime) {
        super(name, dateTime);
        entries = new ArrayList<Entry>();
    }

    public List<Entry> getEntries() {
        return Collections.unmodifiableList(entries);
    }

    @Override
    public String getContent(int indent) {
        String str = super.getContent(indent) + "\n";
        for (int i = 0; i < indent; i++) str += "    ";
        str += "Entries:";
        for (Entry e: entries) str += "\n" + e.getContent(indent + 1);
        return str;
    }

    @Override
    public int size() {
        int size = 0;
        for (Entry e: entries) {
            size += e.size();
        }
        return size;
    }

    @Override
    public int nFiles() {
        int nFiles = 0;
        for (Entry e: entries) {
            nFiles += e.nFiles();
        }
        return nFiles;
    }

    @Override
    public void add(Entry e) throws IllegalArgumentException {
        if (entries.contains(e) == false) entries.add(e);
        else throw new IllegalArgumentException("Entry already in this directory");
    }

    @Override
    public void remove(Entry e) throws IllegalArgumentException {
        if (entries.contains(e) == true) entries.remove(e);
        else throw new IllegalArgumentException("Entry not in this directory");
    }
}