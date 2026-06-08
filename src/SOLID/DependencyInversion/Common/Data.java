package SOLID.DependencyInversion.Common;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class Data {
    private int id;
    private String content;
    private LocalDateTime createdAt;

    public Data(int id, String content) {
        this.id = id;
        this.content = content;
        this.createdAt = LocalDateTime.now(ZoneId.of("UTC"));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
