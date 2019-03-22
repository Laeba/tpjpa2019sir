package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "surveys")
public class Survey implements Serializable {

    private List<DateAvailable> dateAvailables;
    private String link;
    private Meeting meeting;

    public Survey(String link) {
        this.link = link;
    }

    @OneToMany(targetEntity = DateAvailable.class, cascade = CascadeType.PERSIST)
    public List<DateAvailable> getDateAvailables() {
        return dateAvailables;
    }

    public void setDateAvailables(List<DateAvailable> dateAvailables) {
        this.dateAvailables = dateAvailables;
    }

    @Id
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Survey survey = (Survey) o;

        return link.equals(survey.link);
    }

    @Override
    public int hashCode() {
        return link.hashCode();
    }

    @Override
    public String toString() {
        return "Survey{" +
                "link='" + link + '\'' +
                '}';
    }

    @ManyToOne(targetEntity = Meeting.class)
    public Meeting getMeeting() {
        return meeting;
    }

    public void setMeeting(Meeting meeting) {
        this.meeting = meeting;
    }
}
