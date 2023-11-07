package me.mixer.skola;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kalkulacka);
    }


    public void Stisknuto(View button) {
        EditText et = findViewById(R.id.userName);
        TextView tv = findViewById(R.id.text);
        tv.setText("Uživatel " + et.getText());
    }

    String num1 = "";
    String op = "";
    String num2 = "";
    public void kalkulacka(View button) {
        Button but = (Button) button;
        String cislo = (String) but.getText();
        TextView display = findViewById(R.id.kalkulackaDisplay);
        String text = display.getText().toString();

        if(cislo.equals("=")) {
            if(num1.equals("")) num1 = text;
            else num2 = text;
            text = String.valueOf(kalkulovat());
            cislo = "";
        }

        if(text.equals("0") || text.equals("+") || text.equals("-") || text.equals("*") || text.equals("/"))
            text = "";

        if(cislo.equals("*") || cislo.equals("/") || cislo.equals("+") || cislo.equals("-")) {
            display.setText(cislo);
            if(num1.equals("")) num1 = text;
            else num2 = text;
            op = cislo;
            text = "";
        }

        display.setText(text + cislo);
    }

    double kalkulovat() {
        double res = 0;

        if(op.equals("+")) {
            res = Double.parseDouble(num1) + Double.parseDouble(num2);
        }

        if(op.equals("-")) {
            res = Double.parseDouble(num1) - Double.parseDouble(num2);
        }

        if(op.equals("*")) {
            res = Double.parseDouble(num1) * Double.parseDouble(num2);
        }

        if(op.equals("/")) {
            res = Double.parseDouble(num1) / Double.parseDouble(num2);
        }

        num1 = String.valueOf(res);

        return res;
    }
}