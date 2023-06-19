package lt.code.academy.book;

public enum Format {
    HARDCOVER("Hardcover"),
    PAPERBACK("Paperback"),
    EBOOK("eBook");

    private String name;

    Format(String name){
        this.name = name;
    }
}
