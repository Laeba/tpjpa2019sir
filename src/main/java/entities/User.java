package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements Serializable {

    private List<DateAvailable> votes;
    private List<Meeting> meetings;
    private String email;
    private String nom;
    private String prenom;

    public User() {
    }

    public User(String email, String nom, String prenom) {
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
    }


    @ManyToMany(targetEntity = DateAvailable.class, mappedBy = "voters")
    public List<DateAvailable> getVotes() {
        return votes;
    }

    public void setVotes(List<DateAvailable> votes) {
        this.votes = votes;
    }

    @Id
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!email.equals(user.email)) return false;
        if (!nom.equals(user.nom)) return false;
        return prenom.equals(user.prenom);
    }

    @Override
    public int hashCode() {
        int result = email.hashCode();
        result = 31 * result + nom.hashCode();
        result = 31 * result + prenom.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }


    @OneToMany(targetEntity = Meeting.class)
    public List<Meeting> getMeetings() {
        return meetings;
    }

    public void setMeetings(List<Meeting> meetings) {
        this.meetings = meetings;
    }
}
