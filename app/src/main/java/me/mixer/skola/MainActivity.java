package me.mixer.skola;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kalkulacka);
    }

    String num1 = "";
    String op = "";
    String num2 = "";

    boolean typing = false;
    boolean toReset = false;
    public void kalkulacka(View button) {
        Button but = (Button) button;
        String cislo = (String) but.getText();
        TextView display = findViewById(R.id.kalkulackaDisplay);
        String text = display.getText().toString();

        if(cislo.equals("."))
            typing = true;

        if(cislo.equals("*") || cislo.equals("/") || cislo.equals("+") || cislo.equals("-")) {
            display.setText(cislo);
            if(num1.equals("")) num1 = text;
            else num2 = text;
            op = cislo;
            text = "";
            typing = true;
            toReset = false;
        }

        if(text.equals("0") && !typing || text.equals("+") || text.equals("-") || text.equals("*") || text.equals("/")) {
            text = "";
        }

        if(toReset) {
            text = "";
            num1 = "";
            num2 = "";
            toReset = false;
        }

        if(cislo.equals("=")) {
            if(num1.equals("")) num1 = text;
            else num2 = text;
            text = String.valueOf(kalkulovat());
            cislo = "";
            toReset = true;
        }

        String res = text + cislo;
        display.setText(res);

    }

    double kalkulovat() {
        if(num1.equals(""))
            num1 = "0";
        if(num2.equals(""))
            num2 = "0";

        System.out.println("debug: " + num1);
        System.out.println("debug: " + num2);

        double n1 = Double.parseDouble(num1);
        double n2 = Double.parseDouble(num2);
        double res = n1;

        if(op.equals("+")) {
            res = n1 + n2;
        }

        if(op.equals("-")) {
            res = n1 - n2;
        }

        if(op.equals("*")) {
            res = n1 * n2;
        }

        if(op.equals("/")) {
            res = n1 / n2;
        }

        num1 = String.valueOf(res);

        return res;
    }
}