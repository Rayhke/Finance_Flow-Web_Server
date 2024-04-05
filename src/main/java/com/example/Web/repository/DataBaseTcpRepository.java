package com.example.Web.repository;

import com.example.Web.controller.dto.MemberDTO;
import com.google.gson.Gson;
import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

public class DataBaseTcpRepository implements DataBaseRepository {

    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;

    @Override
    public void socketConnect() {
        try {
            socket = new Socket("127.0.0.1", 12555);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch(IOException e) {
            /** 의도치 않은 input을 건내줌 */
            throw new IllegalArgumentException(
                "==================================================================================" +
                "\n\n\n[서버 소켓과의 연결 실패] : " + e + "\n\n\n" +
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
                "\n\n\n[클라이언트 소켓의 종료 실패] : " + e + "\n\n\n" +
                "==================================================================================");
        }
    }

    /**
     * String 형식으로도 처리 가능
     * JSONObject json = new JSONObject("{'age' : 20, 'name' : 'test'}");
     */
    @Override
    public String send(MemberDTO memberDTO) {
        socketConnect();

        /**
         * DTO 는 필드 값이 가변으로 변하지만
         * VO 는 변하지 않는다
         * */

        ArrayList<MemberDTO> list = new ArrayList<>();
        list.add(memberDTO);

        JSONObject json = new JSONObject();
        json.put("list", list);

        // 아래의 방식은 단순하게 json 3개를 전달하는 것
        /*json.put("user_id", memberDTO.getId());
        json.put("user_pwd", memberDTO.getPwd());
        json.put("user_email", memberDTO.getEmail());*/
        try {
            out.write(new Gson().toJson(json));
            out.flush();

            System.out.println(
                "==================================================================================" +
                "\n\n\n[데이터 전송 성공]\n\n\n" +
                "==================================================================================");
        } catch(IOException e) {
            throw new IllegalArgumentException(
                "==================================================================================" +
                "\n\n\n[데이터 전송 실패] : " + e + "\n\n\n" +
                "==================================================================================");
        } finally {
            socketClose();
        }
        return memberDTO.getUser_id();
    }
}
