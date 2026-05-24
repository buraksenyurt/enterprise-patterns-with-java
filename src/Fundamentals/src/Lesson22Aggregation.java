import java.time.LocalDate;

public class Lesson22Aggregation {
    public static void run() {
        /*
            Bir nesne başka bir nesneyi içerir (contain) ve arada
            `has-a` ilişkisi vardır. Ancak içerikteki nesne veya nesneler
            bağımsız olarak da var olabilirler.
         */
        Post helloRust = new Post("Rust Hello World", "....", "BSŞ", LocalDate.now());
        System.out.println(helloRust.getSummary());

        Post[] rustPosts = {
                helloRust,
                new Post("Ownership and Borrow Checker", "...", "BSŞ", LocalDate.now()),
        };
        Section rustProgramming = new Section("Rust", "Posts about Rust programming language", rustPosts);
        rustProgramming.printSummary();
    }
}

class Post {
    String title;
    String content;
    String author;
    LocalDate date;

    Post(String title, String content, String author, LocalDate date) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.date = date;
    }

    String getSummary() {
        return String.format("Title: %s (%d chars), %s", title, content.length(), date);
    }
}

class Section {
    String name;
    String summary;
    Post[] posts;

    Section(String name, String summary, Post[] posts) {
        this.name = name;
        this.summary = summary;
        this.posts = posts;
    }

    void printSummary() {
        System.out.println(this.name + " Posts");
        System.out.println("There are " + this.posts.length + " posts");
        for (Post post : this.posts) {
            System.out.println(post.getSummary());
        }
    }
}