package com.developers.kameleoon.restapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NonNull
    private String content;

    @NonNull
    private Date creationDate;

    @NonNull
    private int votes;

    @ManyToOne
    @NonNull
    @JoinColumn(name = "author_id")
    private _User authorId;
}
