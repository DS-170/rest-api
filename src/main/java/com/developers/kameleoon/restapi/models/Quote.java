package com.developers.kameleoon.restapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "QUOTES")
public class Quote implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "votes")
    private int votes;

    @ManyToOne
    @JoinColumn(name = "author", nullable = false)
    private User author;
}
