package com.example.Web.ledger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LedgerDTO {

    private String author;

    private String category;

    private String content;

    private Long unitPrice;

    private Long quantity;

    private Long totalPrice;

    private Date date;
}
