package Directories;

import java.time.LocalDateTime;

public class File extends Entry{
    private int size;
    private String content;

    public File(String name, LocalDateTime dateTime, String content) {
        super(name, dateTime);
        this.size = content.getBytes().length;
        this.content = content;
    }

    @Override
    public String getContent(int indent) {
        String str = super.getContent(indent) + "\n";
        for (int i = 0; i < indent; i++) str += "    ";
        str += "Content: " + content;
        return str;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int nFiles() {
        return 1;
    }

    @Override
    public void add(Entry e) throws IllegalArgumentException {
        throw new IllegalArgumentException("This is a File, not a directory");
    }

    @Override
    public void remove(Entry e) throws IllegalArgumentException {
        throw new IllegalArgumentException("This is a File, not a directory");
    }
}
