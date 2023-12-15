package me.mixer.skola;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int i = 0;

    SeekBar sbpismen;
    TextView pismeno;
    TextView tvslovo;
    String slovo = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hangman);
        onCreateObesenec();
        //onCreateHadaniCisla();
    }

    public void onCreateHadaniCisla() {
        Button b = findViewById(R.id.trybut);
        b.setVisibility(View.INVISIBLE);
        sbpismen = findViewById(R.id.hadaniCislaSeek);
        sbpismen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvslovo = findViewById(R.id.textSeekRng);
                tvslovo.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void genRandom(View v) {
        TextView tvHeader = findViewById(R.id.randomInt);
        if(i == sbpismen.getProgress()) {
            tvHeader.setText(R.string.spravne);

        } else {
            tvHeader.setText(R.string.spatne);
        }
    }

    public void newGame(View v) {
        TextView tvHeader = findViewById(R.id.randomInt);
        Button b = findViewById(R.id.trybut);
        Button tb = findViewById(v.getId());

        if(b.getVisibility() == View.VISIBLE) {
            b.setVisibility(View.INVISIBLE);
            tb.setText(R.string.start);
            tvHeader.setText(R.string.cisloBylo + i);
        } else {
            b.setVisibility(View.VISIBLE);
            tb.setText(R.string.end);
        }
        i = new Random().nextInt(11);
    }

    public void onCreateObesenec() {
        Button b = findViewById(R.id.hang);
        b.setVisibility(View.INVISIBLE);
        sbpismen = findViewById(R.id.sbPismen);
        pismeno = findViewById(R.id.pismeno);
        tvslovo = findViewById(R.id.slovo);
        pismeno.setText(String.valueOf(sbpismen.getProgress()));

        loadHangman();

        sbpismen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                pismeno.setText(String.valueOf((char) (progress + 97)));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void loadHangman() {
        String str = "";

        for(int i = 1; i <= slovo.length(); i++) {
            str += i;
        }

        tvslovo.setText(str);
    }

    public void obesenec(View v) {
        int remain = 0;
        for(int i = 0; i < slovo.length(); i++) {
            char znak = (char) (sbpismen.getProgress() + 97);
            if(slovo.charAt(i) == znak) {
                String act = (String) tvslovo.getText();
                act = act.replace((char) (i + 49), znak);
                tvslovo.setText(act);
                remain--;
            }
            else {
                remain++;
            }
        }

        //odstranit tlacitko
        if(remain <= 0) {
            Button b = findViewById(R.id.hang);
            b.setVisibility(View.INVISIBLE);
        }
    }

    public void obesenecng(View v) {
        int r = new Random().nextInt(4);
        if(r == 0) slovo = "ZOO";
        if(r == 1) slovo = "tygr";
        if(r == 2) slovo = "Martin";
        if(r == 3) slovo = "Logoped";
        if(r == 4) slovo = "Slovo";

        Button b = findViewById(R.id.hang);
        Button tb = findViewById(v.getId());

        if(b.getVisibility() == View.VISIBLE) {
            b.setVisibility(View.INVISIBLE);
            tb.setText(R.string.start);
        } else {
            b.setVisibility(View.VISIBLE);
            tb.setText(R.string.end);
            loadHangman();
        }
    }

    public void BMI(View v) {
        SeekBar sbVyska = findViewById(R.id.seekBarVyska);
        SeekBar sbHmotnost = findViewById(R.id.seekBarHmotnost);

        TextView tv = findViewById(R.id.tvBMI);
        TextView tv2 = findViewById(R.id.tvBMI2);
        double hmotnost = sbHmotnost.getProgress();
        double vyska = sbVyska.getProgress();
        vyska = vyska/100;
        double res = hmotnost/(vyska*vyska);
        tv.setText("BMI je " + Math.round(res));

        if(res<20) tv2.setText("Podváha");
        else if(res<25) tv2.setText("Norma");
        else if(res<30) tv2.setText("Nadváha");
        else tv2.setText("Obezita");
    }

    public void citackaUp(View v) {
        TextView sbProgress = findViewById(R.id.citackaText);
        i++;
        // Ochrana přetečení
        if(i < 99) {
            // Přidání 0 před jednociferná čísla
            if(i > 0 && i < 10) sbProgress.setText("0" + i);
            else sbProgress.setText("" + i);
        } else i--;

    }

    public void citackaDown(View v) {
        TextView sbProgress = findViewById(R.id.citackaText);
        i--;
        // Ochrana podtečení
        if(i >= 0) {
            if(i > 0 && i < 10) sbProgress.setText(R.string.empty + i);
            else sbProgress.setText(String.valueOf(i));
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