package com.example.Web.ledger;


import com.example.Web.ledger.service.LedgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/ledger")
public class LedgerController {

    private final LedgerService ledgerService;

    @Autowired
    public LedgerController(LedgerService ledgerService) {
        this.ledgerService = ledgerService;
    }

    /*@PostMapping("/save")
    public String save(@RequestBody List<LedgerVO> list) {

    }*/

    /*@PostMapping("finances/")
    public String saveUser(@ModelAttribute UserDTO userDTO) {
        DataBaseTcpRepository tcp = new DataBaseTcpRepository();
        tcp.send(userDTO);
        return "index";
    }*/

    /*private String saveAll(List<LedgerVO> list) {
        return ledgerService;
    }*/
}
