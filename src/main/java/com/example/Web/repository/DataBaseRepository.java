package com.example.Web.repository;

import com.example.Web.controller.dto.MemberDTO;

public interface DataBaseRepository {

    void socketConnect();

    void socketClose();

    String save(MemberDTO memberDTO);


}
