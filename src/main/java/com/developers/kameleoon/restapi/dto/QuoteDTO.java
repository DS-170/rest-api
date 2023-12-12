package com.developers.kameleoon.restapi.dto;

import lombok.Data;

import java.util.Date;

@Data
public class QuoteDTO {
    private Long id;
    private String content;
    private Date creationDate;
    private int votes;
    private Long authorId;
}
