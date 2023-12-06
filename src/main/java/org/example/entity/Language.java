package org.example.entity;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(schema = "movie", name = "language")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id")
    private Byte id;
    @Column(name = "name", columnDefinition = "char")
    private String name;
    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;

    public Language() {
    }

    public Language(Byte id, String name, LocalDateTime lastUpdate) {
        this.id = id;
        this.name = name;
        this.lastUpdate = lastUpdate;
    }

    public Byte getId() {
        return id;
    }

    public void setId(Byte id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
