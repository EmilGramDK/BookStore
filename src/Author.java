public class Author implements AuthorInfo {
    private String authorId;
    private String name;

    public Author(String authorId, String name) {
        this.authorId = authorId;
        this.name = name;
    }

    public String getAuthorId() {
        return authorId;
    }

    public String getName() {
        return name;
    }
}

interface AuthorInfo {
    String getName();
}
