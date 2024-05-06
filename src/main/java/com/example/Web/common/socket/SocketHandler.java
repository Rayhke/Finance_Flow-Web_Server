package com.example.Web.common.socket;

public interface SocketHandler {

    void socketConnect();

    void socketRead();

    void socketWrite();

    void socketClose();

    String request(String input);
}
