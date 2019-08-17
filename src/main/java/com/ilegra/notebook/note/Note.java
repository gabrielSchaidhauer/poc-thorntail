package com.ilegra.notebook.note;



import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "note", schema = "poc")
public class Note {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id")
    private UUID id;

    @Column(name = "content")
    private String content;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
