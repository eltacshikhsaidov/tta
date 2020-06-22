package az.youthacademy.tta.entities;

import javax.persistence.*;

@Entity
@Table(name = "tours")
public class Tours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "when_starts")
    private String when_starts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWhen_starts() {
        return when_starts;
    }

    public void setWhen_starts(String when_starts) {
        this.when_starts = when_starts;
    }

    public Tours() {
    }

    public Tours(Long id, String title, String when_starts) {
        this.id = id;
        this.title = title;
        this.when_starts = when_starts;
    }
}
