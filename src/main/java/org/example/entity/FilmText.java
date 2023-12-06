package org.example.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(schema = "movie", name = "film_text")
public class FilmText {
    @Id
    @Column(name = "film_id")
    private Short id;
    @OneToOne
    @JoinColumn(name = "film_id")
    private Film film;
    @Column(name = "title")
    private String title;
    @Column(name = "description", columnDefinition = "text")
    @Type(type = "text")
    private String description;

    public FilmText() {
    }

    public FilmText(Short id, Film film, String title, String description) {
        this.id = id;
        this.film = film;
        this.title = title;
        this.description = description;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
