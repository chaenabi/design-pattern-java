package chapter14;

import java.util.ArrayList;
import java.util.List;

class Client {
    public static void main(String[] args) {
        FileSystemComposite fileSystemComposite = new FileSystemComposite();
        File file = new File("파일");
        Directory directory = new Directory("폴더");
        fileSystemComposite.addComponent(file);
        fileSystemComposite.addComponent(directory);

        System.out.println(fileSystemComposite.getFileSystemSize());
        System.out.println(fileSystemComposite.getFileSystemName());
        fileSystemComposite.fileSystemPrint();
    }
}

class FileSystemComposite extends FileSystem {

    private List<FileSystem> components = new ArrayList<FileSystem>();
    public void addComponent(FileSystem component) {
        components.add(component);
    }
    public void removeComponent(FileSystem component) {
        components.remove(component);
    }

    public int getFileSystemSize() {
        int size = 0;
        for(FileSystem component:components) {
            size += component.getSize();
        }
        return size;
    }

    public StringBuilder getFileSystemName() {
        StringBuilder stringBuilder = new StringBuilder();
        for(FileSystem component:components) {
            stringBuilder.append(component.getName());
        }
        return stringBuilder;
    }

    public void fileSystemPrint() {
        for(FileSystem component:components) {
            component.print();
        }
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public void print() {

    }
}


public abstract class FileSystem {
    public abstract String getName();
    public abstract int getSize();
    public abstract void print();
}

class File extends FileSystem {
    private String name;
    private int size;
    private int depth = 0;

    public File(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }

    public int getDepth() {
        return 0;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    @Override
    public void print() {
        for(int i = 0; i < depth; i++)
            System.out.print("\t");
        System.out.println("[File] " + name + ", Size: " + size);
    }
}

class Directory extends FileSystem {
    private String name;
    private int depth = 0;
    private List<Object> entries = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }
    public void addEntry(Object entry) {
        entries.add(entry);
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public void removeEntry(Object entry) {
        entries.remove(entry);
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        int size = 0;
        for(Object entry : entries) {
            if(entry instanceof File)
                size += ((File) entry).getSize();
            if(entry instanceof  Directory)
                size += ((Directory) entry).getSize();
        }
        return size;
    }

    @Override
    public void print() {
        for(int i=0; i < depth; i++)
            System.out.println("\t");
        System.out.println("[Directory] " + name + ", SIze: "+ getSize());

        for(Object entry: entries) {
            if(entry instanceof File)
                ((File) entry).print();
            if(entry instanceof Directory)
                ((Directory) entry).print();
        }
    }


}