import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Lesson22Aggregation {
    public static void run() {
        /*
            Bir nesne başka bir nesneyi içerir (contain) ve arada
            `has-a` ilişkisi vardır. Ancak içerikteki nesne veya nesneler
            bağımsız olarak da var olabilirler.

            Section, Post nesnelerine sahiptir. (has-a)

            Örneğin Section nesnesi bellekten silinse bile, helloRust ve ownershipPost nesneleri bağımsız olarak
            yaşamaya devam eder. Aggregation'ın temel şartı olan bağımsız yaşam döngüsü(independent lifecycle) kuralının
            uygulanmasına bir örnektir.
         */
        Post helloRust = new Post("Rust Hello World", "....", "BSŞ", LocalDate.now());
        System.out.println(helloRust.getSummary());

        List<Post> rustPosts = new ArrayList<>();
        rustPosts.add(helloRust);
        Post ownershipPost = new Post("Ownership and Borrow Checker", "...", "BSŞ", LocalDate.now());
        rustPosts.add(ownershipPost);

        Section rustProgramming = new Section("Rust", "Posts about Rust programming language", rustPosts);
        rustProgramming.AddPost(new Post("Step by step ECS", "...", "BSŞ", LocalDate.now()));

        rustProgramming.printSummary();
    }
}

class Post {
    private String title;
    private String content;
    private String author;
    private LocalDate date;

    Post(String title, String content, String author, LocalDate date) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.date = date;
    }

    String getSummary() {
        return String.format("Title: %s (%d chars), %s", title, content.length(), date);
    }

    String getAuthor() {
        return author;
    }

    String getContent() {
        return content;
    }

    LocalDate getDate() {
        return date;
    }
}

class Section {
    private String name;
    private String summary;
    private List<Post> posts;

    Section(String name, String summary, List<Post> posts) {
        this.name = name;
        this.summary = summary;
        this.posts = posts;
    }

    void AddPost(Post post) {
        posts.add(post);
    }

    void printSummary() {
        System.out.println(this.name + " Posts");
        System.out.println("There are " + this.posts.size() + " posts");
        for (Post post : this.posts) {
            System.out.println(post.getSummary());
        }
    }
}