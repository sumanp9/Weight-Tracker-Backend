package beans;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "weighttrack")
public class WeightTrack {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY,
    optional = false )
    @JoinColumn(name ="userprofile_id", nullable = false)
    private UserProfile user;

    private Date date;
    private Double weight;

    public WeightTrack(UserProfile user, Date date, Double weight) {
        this.user = user;
        this.date = date;
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public UserProfile getUser() {
        return user;
    }

    public void setUser(UserProfile user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "WeightTrack{" +
                "id=" + id +
                ", user=" + user +
                ", date=" + date +
                ", weight=" + weight +
                '}';
    }
}
