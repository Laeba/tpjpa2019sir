package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "dietaries")
public class Dietary implements Serializable {

    private long id;
    private String allergies;
    private String preferencesAlimentaire;
    private List<User> participants;


    public Dietary(String allergies, String preferencesAlimentaire, List<User> participants) {
        this.allergies = allergies;
        this.preferencesAlimentaire = preferencesAlimentaire;
        this.participants = participants;
    }

    public Dietary() {
    }

    @ManyToMany(targetEntity = User.class)
    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getPreferencesAlimentaire() {
        return preferencesAlimentaire;
    }

    public void setPreferencesAlimentaire(String preferencesAlimentaire) {
        this.preferencesAlimentaire = preferencesAlimentaire;
    }


    @Override
    public String toString() {
        return "Dietary{" +
                "allergies='" + allergies + '\'' +
                ", preferencesAlimentaire='" + preferencesAlimentaire + '\'' +
                ", participants=" + participants +
                '}';
    }

    @Id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
