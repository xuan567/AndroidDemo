package com.example.chatroom_test1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    private Button start;
    private Button end;
    private EditText edit_port;
    private String port_server;
    private ServerSocket serverSocket = null;
    public static ArrayList<Socket> socketList = new ArrayList<>();
    private startServer startserver;

    class startServer  extends Thread implements Runnable{
        @Override
        public void run(){
            try {
                serverSocket = new ServerSocket(Integer.parseInt(port_server));
                while(true){
                    Socket s = serverSocket.accept();
                    socketList.add(s);
                    new Thread(new UserThread(s,socketList)).start();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = findViewById(R.id.start);
        end = findViewById(R.id.end);
        edit_port = findViewById(R.id.input_port);
        edit_port.setText("6666");
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                port_server = edit_port.getText().toString();
                try{
                    Integer.parseInt(port_server);
                }catch (Exception e){
                    Toast.makeText(MainActivity.this,"端口错误",Toast.LENGTH_SHORT).show();
                }
                startserver = new startServer();
                startserver.start();
                Toast.makeText(MainActivity.this,"启动成功",Toast.LENGTH_SHORT).show();
                start.setEnabled(false);
                end.setEnabled(true);
            }
        });
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    start.setEnabled(true);
                    end.setEnabled(false);
                    startserver.interrupt();
                    socketList.clear();
                    serverSocket.close();
                    Toast.makeText(MainActivity.this,"关闭成功",Toast.LENGTH_SHORT).show();
                }catch(Exception e){
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this,"关闭异常",Toast.LENGTH_SHORT).show();
                }

            }
        });
        end.setEnabled(false);
    }

}