package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "meetings")
public class Meeting implements Serializable {

    private long id;
    private String title;
    private String summary;
    private Date date;
    private Boolean aBreak;
   private List<User> participants;

    public Meeting(String title, String summary, Date date, Boolean aBreak) {
        this.title = title;
        this.summary = summary;
        this.date = date;
        this.aBreak = aBreak;
    }

    public Meeting() {
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getaBreak() {
        return aBreak;
    }

    public void setaBreak(Boolean aBreak) {
        this.aBreak = aBreak;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Meeting meeting = (Meeting) o;

        if (!title.equals(meeting.title)) return false;
        if (!summary.equals(meeting.summary)) return false;
        if (!date.equals(meeting.date)) return false;
        return aBreak.equals(meeting.aBreak);
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + summary.hashCode();
        result = 31 * result + date.hashCode();
        result = 31 * result + aBreak.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", date=" + date +
                ", aBreak=" + aBreak +
                '}';
    }

    @ManyToMany(targetEntity = User.class)
    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }
}
