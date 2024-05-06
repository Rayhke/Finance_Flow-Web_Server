package com.example.Web.ledger.service;

import com.example.Web.ledger.LedgerVO;
import com.example.Web.ledger.repository.LedgerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class LedgerServiceImpl implements LedgerService {

    private final LedgerRepository ledgerRepository;

    @Autowired
    public LedgerServiceImpl(LedgerRepository ledgerRepository) {
        this.ledgerRepository = ledgerRepository;
    }

    public String saveAll(List<LedgerVO> list) {
        return ledgerRepository.saveAll(list);
    }
}
