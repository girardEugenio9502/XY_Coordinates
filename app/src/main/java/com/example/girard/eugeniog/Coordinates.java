package com.example.girard.eugeniog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.FloatProperty;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class Coordinates extends AppCompatActivity {


ImageView imgBG;
TextView X1T, X2T, Y1T, Y2T, diff_X, diff_Y, Motion, Quad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinates);

        imgBG = (ImageView) findViewById(R.id.imgBG);
        X1T = (TextView) findViewById(R.id.x1T);
        X2T = (TextView) findViewById(R.id.x2T);
        Y1T = (TextView) findViewById(R.id.y1T);
        Y2T = (TextView) findViewById(R.id.y2T);
        diff_X = (TextView) findViewById(R.id.diffX);
        diff_Y = (TextView) findViewById(R.id.diffY);
        Motion = (TextView) findViewById(R.id.moTn);
        Quad = (TextView) findViewById(R.id.quad);

        imgBG.setOnTouchListener(new View.OnTouchListener() {
            float X1,X2,Y1,Y2,X_diff,Y_diff;
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                int event = motionEvent.getAction();
                switch (event){

                    case MotionEvent.ACTION_DOWN:
                        X1 = motionEvent.getX();
                        Y1 = motionEvent.getY();

                    case MotionEvent.ACTION_UP:
                        X2 = motionEvent.getX();
                        Y2 = motionEvent.getY();

                        X1T.setText(Float.toString(X1));
                        X2T.setText(Float.toString(X2));
                        Y1T.setText(Float.toString(Y1));
                        Y2T.setText(Float.toString(Y2));

                        if(X1 < X2 && Y1 > Y2){
                            Motion.setText("Right to Up");
                            Quad.setText("Quadrant 1");
                        }

                        if(X1 < X2 && Y1 < Y2){
                            Motion.setText("Right to Down");
                            Quad.setText("Quadrant 4");
                        }

                        if(X1 > X2 && Y1 > Y2){
                            Motion.setText("Right to Up");
                            Quad.setText("Quadrant 2");
                        }

                        if(X1 > X2 && Y1 < Y2){
                            Motion.setText("Right to Up");
                            Quad.setText("Quadrant 3");
                        }

                        if(X1 < X2){
                            X_diff = X2-X1;
                            diff_X.setText(Float.toString(X_diff));
                        }else
                            X_diff = X1-X2;
                            diff_X.setText(Float.toString(X_diff));

                        if (Y1 < Y2){
                            Y_diff = Y2-Y1;
                            diff_Y.setText(Float.toString(Y_diff));
                        }else
                            Y_diff = Y1-Y2;
                            diff_Y.setText(Float.toString(Y_diff));

                }


                return true;

            }
        });
    }
}
