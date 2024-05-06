package com.example.Web.ledger.repository;

import com.example.Web.ledger.LedgerVO;
import com.example.Web.common.socket.SocketHandlerImpl;

import java.util.List;

public class LedgerRepositoryImpl extends SocketHandlerImpl implements LedgerRepository {

    @Override
    public void save(LedgerVO ledgerVO) {

    }

    @Override
    public String saveAll(List<LedgerVO> list) {
        return null;
    }
}
