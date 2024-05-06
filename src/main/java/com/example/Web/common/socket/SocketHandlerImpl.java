package com.example.Web.common.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public abstract class SocketHandlerImpl implements SocketHandler {

    private static final String HOST = "127.0.0.1";
    private static final int PORT = 13555;

    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;

    @Override
    public void socketConnect() {
        try {
            socket = new Socket(HOST, PORT);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void socketRead() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void socketWrite() {
        try {
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void socketClose() {
        try {
            if (out != null) out.close();
            if (in != null) in.close();
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String request(String input) {
        try {
            socket.setSoTimeout(30000);
            out.write(input);
            out.flush();

            String output = in.readLine();
            return output;
        } catch (SocketException e) {
            return "Connection Failed";
        } catch (SocketTimeoutException e) {
            return "Request Timeout";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
