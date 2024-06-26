package com.example.Web.user.repository;

import com.example.Web.common.socket.SocketHandler;
import com.example.Web.common.socket.SocketHandlerImpl;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRepositoryImpl extends SocketHandlerImpl implements UserRepository {

    private final SocketHandler socketHandler;

    @Autowired
    public UserRepositoryImpl(SocketHandler socketHandler) {
        this.socketHandler = socketHandler;
    }

    public String request(JsonObject json) {
        socketHandler.socketConnect();
        socketHandler.socketRead();
        socketHandler.socketWrite();

        String result = request(json.toString());
        socketHandler.socketClose();

        return result;
    }

    /*private static final String HOST = "127.0.0.1";
    private static final int PORT = 13555;

    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;



    @Override
    public void socketConnect() {
        try {
            socket = new Socket(HOST, PORT);
        } catch (IOException e) {
            *//** 의도치 않은 input을 건내줌 *//*
            throw new IllegalArgumentException(
                "==================================================================================" +
                "\n\n\n[서버 소켓과의 연결 실패] : " + e + "\n\n\n" +
                "==================================================================================");
        }
    }

    @Override
    public void socketRead() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            throw new IllegalArgumentException("[Read 연결 실패] : " + e);
        }
    }

    @Override
    public void socketWrite() {
        try {
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            throw new IllegalStateException("[Write 연결 실패] : " + e);
        }
    }

    @Override
    public void socketClose() {
        try {
            if (out != null) out.close();
            if (in != null) in.close();
            socket.close();
        } catch (IOException e) {
            *//** 의도치 않은 output을 받음 *//*
            throw new IllegalStateException(
                "==================================================================================" +
                "\n\n\n[클라이언트 소켓의 종료 실패] : " + e + "\n\n\n" +
                "==================================================================================");
        }
    }

    @Override
    public String insertUsers(UserDTO userDTO) {
        socketConnect(); socketWrite(); socketRead();

        Gson gson = new Gson();
        JsonObject json = new JsonObject();

        json.addProperty("entity", "user");
        json.addProperty("mode", "save");
        json.add("userDTO", gson.toJsonTree(userDTO));

        try {
            out.write(json.toString());
            out.flush();
        } catch (IOException e) {

        } finally {
            socketClose();
        }

        return userDTO.getId();
    }

    @Override
    public String selectUsers(String user_email) {
        socketConnect(); socketRead(); socketWrite();

        // Gson gson = new Gson();
        JsonObject json = new JsonObject();
        json.addProperty("entity", "user");
        json.addProperty("mode", "select");
        json.addProperty("user_email", user_email);

        try {
            out.write(json.toString());
            out.flush();
        } catch (IOException e) {

        } finally {
            socketClose();
        }

        return null;
    }

    @Override
    public String updateUsers(UserDTO member) {
        socketConnect(); socketRead(); socketWrite();
        return null;
    }

    @Override
    public String deleteUsers(String user_id) {
        socketConnect(); socketRead(); socketWrite();
        return null;
    }*/
}
