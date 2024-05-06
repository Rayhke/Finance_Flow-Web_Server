package com.example.Web.ledger.repository;


import com.example.Web.ledger.LedgerVO;

import java.util.List;

public interface LedgerRepository {

    void save(LedgerVO ledgerVO);

    String saveAll(List<LedgerVO> list);
}
