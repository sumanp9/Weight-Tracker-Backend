package beans;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "userprofile")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Double height;

    @OneToMany( mappedBy = "userprofile",
            fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
    private Set<WeightTrack> weightData;

    public UserProfile() {
    }

    public UserProfile(String firstName, String lastName, String email, Double height) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.height = height;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
