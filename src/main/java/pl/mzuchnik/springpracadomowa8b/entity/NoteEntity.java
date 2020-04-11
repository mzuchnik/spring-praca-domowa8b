package pl.mzuchnik.springpracadomowa8b.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "notes")
public class NoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String title;

    @Column(length = 65535, columnDefinition = "Text")
    private String content;

    @Column(name = "create_date")
    private LocalDate createDate;

    @Column(name = "modification_date")
    private LocalDate modificationDate;

    public NoteEntity() {
    }

    public NoteEntity(String title, String content, LocalDate createDate, LocalDate modificationDate) {
        this.title = title;
        this.content = content;
        this.createDate = createDate;
        this.modificationDate = modificationDate;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(LocalDate modificationDate) {
        this.modificationDate = modificationDate;
    }

    @Override
    public String toString() {
        return "NoteEntity{" +
                "Id=" + Id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
                ", modificationDate=" + modificationDate +
                '}';
    }
}
