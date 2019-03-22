package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "date_availables")
public class DateAvailable implements Serializable {

    List<User> voters;
    private long id;
    private Date Date;
    private Survey survey;

    public DateAvailable(Date date) {
        Date = date;
    }

    public DateAvailable() {
    }

    @ManyToMany(targetEntity = User.class)
    @JoinTable(
            name = "votes",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "date_available_id")
    )
    public List<User> getVoters() {
        return voters;
    }

    public void setVoters(List<User> voters) {
        this.voters = voters;
    }

    @ManyToOne(targetEntity = Survey.class)
    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date date) {
        Date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DateAvailable that = (DateAvailable) o;

        return Date.equals(that.Date);
    }

    @Override
    public int hashCode() {
        return Date.hashCode();
    }

    @Override
    public String toString() {
        return "DateAvailable{" +
                "Date=" + Date +
                '}';
    }
}
