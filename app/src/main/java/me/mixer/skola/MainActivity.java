package me.mixer.skola;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int i = 0;
    TextView citackaText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.citacka);
        citackaText = findViewById(R.id.citackaText);
    }

    public void citackaUp(View v) {
        i++;
        // Ochrana přetečení
        if(i < 99) {
            // Přidání 0 před jednociferná čísla
            if(i > 0 && i < 10) citackaText.setText("0" + i);
            else citackaText.setText("" + i);
        } else i--;

    }

    public void citackaDown(View v) {
        i--;
        // Ochrana podtečení
        if(i >= 0) {
            if(i > 0 && i < 10) citackaText.setText("0" + i);
            else citackaText.setText("" + i);
        } else i++;

    }

    public void mizeni() {
        setContentView(R.layout.mizeni);
        TextView t = findViewById(R.id.textView2);
        t.setVisibility(View.INVISIBLE);
    }

    public void visible(View v) {
        TextView t = findViewById(R.id.textView2);
        Button b = (Button) v;
        if(t.getVisibility() == View.VISIBLE) {
            b.setText("Ukaž");
            t.setVisibility(View.INVISIBLE);
        } else {
            b.setText("Smaž");
            t.setVisibility(View.VISIBLE);
        }
    }

    public void sachovnice(View v) {
        TextView tv1 = findViewById(R.id.textView);
        TextView tv2 = findViewById(R.id.textView3);
        TextView tv3 = findViewById(R.id.textView4);
        TextView tv4 = findViewById(R.id.textView5);


        switch (i) {
            case 0:
                tv1.setText(" ");
                tv1.setBackgroundColor(Color.WHITE);
                break;
            case 1:
                tv2.setText(" ");
                tv2.setBackgroundColor(Color.BLACK);
                break;
            case 2:
                tv3.setText(" ");
                tv3.setBackgroundColor(Color.BLACK);
                break;
            case 3:
                tv4.setText(" ");
                tv4.setBackgroundColor(Color.WHITE);
                break;
        }
        i++;
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