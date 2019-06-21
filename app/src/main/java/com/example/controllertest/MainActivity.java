package com.example.controllertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mtv_state;

    Button mb_go_forward;
    Button mb_lotate_left;
    Button mb_lotate_right;
    Button mb_go_backward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtv_state = (TextView)findViewById(R.id.text_view_state);

        mb_go_forward = (Button)findViewById(R.id.button_go_forward);
        mb_lotate_left = (Button)findViewById(R.id.button_lotate_left);
        mb_lotate_right = (Button)findViewById(R.id.button_lotate_right);
        mb_go_backward = (Button)findViewById(R.id.button_go_backward);

        final SocketClientTask socket = new SocketClientTask(this);

        mb_go_forward.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    // 指がタッチした時の処理を記述
                    mtv_state.setText("前進！");
                    mb_lotate_left.setEnabled(false);
                    mb_lotate_right.setEnabled(false);
                    mb_go_backward.setEnabled(false);
                    //socket.execute("1");
                } else if(event.getAction() == MotionEvent.ACTION_UP) {
                    // タッチした指が離れた時の処理を記述
                    mtv_state.setText("停止！");
                    mb_lotate_left.setEnabled(true);
                    mb_lotate_right.setEnabled(true);
                    mb_go_backward.setEnabled(true);
                    socket.execute("0");
                }
                return false;
            }
        });

        mb_lotate_left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    // 指がタッチした時の処理を記述
                    mtv_state.setText("左回転！");
                    mb_go_forward.setEnabled(false);
                    mb_lotate_right.setEnabled(false);
                    mb_go_backward.setEnabled(false);
                    socket.execute("4");
                } else if(event.getAction() == MotionEvent.ACTION_UP) {
                    // タッチした指が離れた時の処理を記述
                    mtv_state.setText("停止！");
                    mb_go_forward.setEnabled(true);
                    mb_lotate_right.setEnabled(true);
                    mb_go_backward.setEnabled(true);
                    socket.execute("0");
                }
                return false;
            }
        });

        mb_lotate_right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    // 指がタッチした時の処理を記述
                    mtv_state.setText("右回転！");
                    mb_go_forward.setEnabled(false);
                    mb_lotate_left.setEnabled(false);
                    mb_go_backward.setEnabled(false);
                    socket.execute("3");
                } else if(event.getAction() == MotionEvent.ACTION_UP) {
                    // タッチした指が離れた時の処理を記述
                    mtv_state.setText("停止！");
                    mb_go_forward.setEnabled(true);
                    mb_lotate_left.setEnabled(true);
                    mb_go_backward.setEnabled(true);
                    socket.execute("0");
                }
                return false;
            }
        });

        mb_go_backward.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    // 指がタッチした時の処理を記述
                    mtv_state.setText("後退！");
                    mb_go_forward.setEnabled(false);
                    mb_lotate_left.setEnabled(false);
                    mb_lotate_right.setEnabled(false);
                    socket.execute("2");
                } else if(event.getAction() == MotionEvent.ACTION_UP) {
                    // タッチした指が離れた時の処理を記述
                    mtv_state.setText("停止！");
                    mb_go_forward.setEnabled(true);
                    mb_lotate_left.setEnabled(true);
                    mb_lotate_right.setEnabled(true);
                    socket.execute("0");
                }
                return false;
            }
        });
    }
}
