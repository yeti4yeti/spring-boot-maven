package pl.springBoot.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "Category")
public class Category implements Serializable {

    public Category() {
    }

    public Category(String name, Set<Book> books) {
        this.name = name;
        this.books = books;
    }

    @GenericGenerator(
            name = "id_Sequence_Category",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "ID_SEQ_CAT"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "100"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @Id
    @GeneratedValue(generator = "id_Sequence_Category")
    @Column(name = "idCategory", nullable = false)
    private long idCategory;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "categories")
    private Set<Book> books = new HashSet<>();

    public long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(long idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(LinkedHashSet<Book> books) {
        this.books = books;
    }
}
