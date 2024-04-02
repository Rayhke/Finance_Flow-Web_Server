package com.example.Web.repository;

import com.example.Web.controller.dto.MemberDTO;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class DataBaseTcpRepository implements DataBaseRepository {

    private Socket socket;
    private InputStream in;
    private OutputStream out;

    @Override
    public void socketConnect() {
        try {
            socket = new Socket("127.0.0.1", 12555);
            in = socket.getInputStream();
            out = socket.getOutputStream();
        } catch(IOException e) {
            /** 의도치 않은 input을 건내줌 */
            throw new IllegalArgumentException(
                "==================================================================================" +
                "\n\n\n[소켓 연결 실패] : " + e + "\n\n\n" +
                "==================================================================================");
        }
    }

    @Override
    public void socketClose() {
        try {
            out.close();
            in.close();
            socket.close();
        } catch(IOException e) {
            /** 의도치 않은 output을 받음 */
            throw new IllegalStateException(
                "==================================================================================" +
                "\n\n\n[소켓 종료 실패] : " + e + "\n\n\n" +
                "==================================================================================");
        }
    }

    @Override
    public String save(MemberDTO memberDTO) {
        socketConnect();

        socketClose();
        return memberDTO.getId();
    }
}
