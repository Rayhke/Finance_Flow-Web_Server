package com.example.Web.ledger;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LedgerVO {

    private String author;

    private String category;

    private String content;

    private Long unitPrice;

    private Long quantity;

    private Long totalPrice;

    private Date date;
}
