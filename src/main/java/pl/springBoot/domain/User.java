package pl.springBoot.domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "User")
public class User implements Serializable {

    private static final long serialVersionUID = 4209871148977725102L;

    public User() {
    }

    public User(String password, String name, String email, String city, String address) {
        this.password = password;
        this.name = name;
        this.email = email;
        this.city = city;
        this.address = address;
    }

    @GenericGenerator(
            name = "id_Sequence_User",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "ID_SEQ_USR"),
                    @Parameter(name = "initial_value", value = "100"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @Id
    @GeneratedValue(generator = "id_Sequence_User")
    @Column(name = "idUser", unique = true, nullable = false)
    private long idUser;

    @Column(name = "password", nullable = false, length = 60)
    private String password;

    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "email", unique = true, nullable = false, length = 30)
    private String email;

    @Column(name = "city", length = 20)
    private String city;

    @Column(name = "address", length = 60)
    private String address;

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
    
