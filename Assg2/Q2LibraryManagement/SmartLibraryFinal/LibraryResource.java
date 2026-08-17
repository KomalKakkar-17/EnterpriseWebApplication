package library.model;

public abstract class LibraryResource {

    private int resourceId;
    private String title;
    private String author;

    public static String libraryName;
    public static int totalResources;
    public static double totalFine;

    public LibraryResource(int id, String title, String author) {
        this.resourceId = id;
        this.title = title;
        this.author = author;
        totalResources++;
    }

    public void setResourceId(int id) {
        this.resourceId = id;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    // protected: subclasses use this to build printDetails() output,
    // outside classes should go through printDetails() instead.
    protected String getBaseDetails() {
        return "ID: " + resourceId + " | Title: " + title + " | Author: " + author;
    }

    public static void setLibraryName(String name) {
        libraryName = name; // no 'this' - static method, no object context
    }

    public static String getLibraryName() {
        return libraryName;
    }

    public abstract double calculateFine(int overdueDays);

    public static void displayTotalResources() {
        System.out.println("Total Resources in Library: " + totalResources);
    }

    public static void displayTotalFine() {
        System.out.println("Total Fine: " + totalFine);
    }
}
