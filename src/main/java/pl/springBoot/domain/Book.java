package pl.springBoot.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Book")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Book implements Serializable{

    private static final long serialVersionUID = -7080601120453273201L;

    public Book() {
    }

    public Book(String description, String author, long publishDate, Set<Category> categories) {
        this.description = description;
        this.author = author;
        this.publishDate = publishDate;
        this.categories = categories;
    }

    @GenericGenerator(
            name = "id_Sequence_Book",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "ID_SEQ_BOOK"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "100"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @Id
    @GeneratedValue(generator = "id_Sequence_Book")
    @Column(name = "idBook", unique = true, nullable = false)
    private long idBook;

    @Column(name = "description")
    private String description;

    @Column(name = "author")
    private String author;

    @Column(name = "publishDate")
    private long publishDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "BOOK_CATEGORY",
            joinColumns = @JoinColumn(name = "idBook"),
            inverseJoinColumns = @JoinColumn(name = "idCategory"))
    private Set<Category> categories = new HashSet<>();

    public long getIdBook() {
        return idBook;
    }

    public void setIdBook(long idBook) {
        this.idBook = idBook;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(long publishDate) {
        this.publishDate = publishDate;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

}
