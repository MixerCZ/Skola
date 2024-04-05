package me.mixer.skola;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Activity act = MainActivity.this;
    int i = 0;

    SeekBar sbpismen;
    TextView pismeno;
    TextView tvslovo;
    String slovo = "";
    int remain = 0;
    Handler h = new Handler();

    boolean automatRun = false;

    boolean otoceno1 = false;
    boolean otoceno2 = false;
    boolean otoceno3 = false;
    boolean otoceno4 = false;

    Drawable p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.heslo);
        //onCreateObesenec();
        //onCreateHadaniCisla();
        //onCreateAutomat();
        //onCreatePexeso();
        //onCreateTest();
    }

    public void Heslo(View v) {
        Button b = findViewById(R.id.bPass);
        TextView tvPass = findViewById(R.id.tvPass);
        EditText etPass = findViewById(R.id.etPass);
        String pass = "";

        if(b.getText().toString().toLowerCase().equals("potvrdit")) {
            pass = etPass.getText().toString();
            tvPass.setText("Kontrola hesla");
            etPass.setText("");
            b.setText("Kontrola");
        } else {
            if(etPass.getText().toString().equals(pass))
                tvPass.setText("Správně!");
            else
                tvPass.setText("Špatně!");
        }
    }

    EditText t1,t2,t3;
    public void onCreateTest() {
        t1 = findViewById(R.id.tNumber1);
        t2 = findViewById(R.id.tText);
        t3 = findViewById(R.id.tNumber2);
        tvslovo = findViewById(R.id.tvPis);
    };

    public void TestFce(View v) {
        double a = Double.parseDouble(t1.getText().toString());
        double b = Double.parseDouble(t3.getText().toString());
        int op = t2.getText().charAt(0);
        double res = 0;

        if(op == '+') res = a+b;
        else if(op == '-') res = a-b;
        else if(op == '*') res = a*b;
        else res = a/b;

        tvslovo.setText(res + "");
    };

    public void onCreatePexeso() {
        p1 = getDrawable(R.drawable.greencircle);
        p2 = getDrawable(R.drawable.greencircle);
        p3 = getDrawable(R.drawable.greencircle);
        p4 = getDrawable(R.drawable.greencircle);
        p5 = getDrawable(R.drawable.greencircle);
        p6 = getDrawable(R.drawable.greencircle);
        p7 = getDrawable(R.drawable.greencircle);
        p8 = getDrawable(R.drawable.greencircle);
        p9 = getDrawable(R.drawable.greencircle);
        p10 = getDrawable(R.drawable.greencircle);
        p11 = getDrawable(R.drawable.greencircle);
        p12 = getDrawable(R.drawable.greencircle);
    }

    int otocenoCounter = 0;
    int pokusy = 0;
    ImageView last;
    ImageView last2;

    public void reload(View b) {
        act.recreate();
    }

    public void stop(View b) {
        act.finishAffinity();
    }

    public void pexeso(View b) {
        //Generate random pictures
        if(i==0) {
            ArrayList<Integer> arr = new ArrayList<>(12);
            arr.addAll(Arrays.asList(R.drawable.greencircle, R.drawable.redcircle,R.drawable.kocka,R.drawable.pes,R.drawable.opice, R.drawable.tygr));

            Collections.shuffle(arr);

            p1 = getDrawable(arr.get(0));
            p2 = getDrawable(arr.get(0));
            p3 = getDrawable(arr.get(1));
            p4 = getDrawable(arr.get(1));
            p5 = getDrawable(arr.get(2));
            p6 = getDrawable(arr.get(2));
            p7 = getDrawable(arr.get(3));
            p8 = getDrawable(arr.get(3));
            p9 = getDrawable(arr.get(4));
            p10 = getDrawable(arr.get(4));
            p11 = getDrawable(arr.get(5));
            p12 = getDrawable(arr.get(5));

            i=1;
        }

        ImageView ib = findViewById(b.getId());
        otocenoCounter++;
        if (otocenoCounter == 1) {
            last = ib;
        } else if (otocenoCounter == 2) {
            last2 = ib;
            if(last.getId() == last2.getId()) otocenoCounter--;
        } else {
            if (last.getDrawable().getConstantState() == last2.getDrawable().getConstantState() && last.getId() != last2.getId()) {
                last.setVisibility(View.INVISIBLE);
                last2.setVisibility(View.INVISIBLE);
            } else {
                last.setImageDrawable(getDrawable(R.drawable.pexeso));
                last2.setImageDrawable(getDrawable(R.drawable.pexeso));
                pokusy++;
            }
            otocenoCounter = 1;
            last = ib;
        }

        TextView pokusyD = findViewById(R.id.pocetKaret);
        pokusyD.setText("Chyby: " + pokusy);

        if (ib.getId() == R.id.p1) {
            ib.setImageDrawable(p1);
        }
        if (ib.getId() == R.id.p2) {
            ib.setImageDrawable(p2);
        }
        if (ib.getId() == R.id.p3) {
            ib.setImageDrawable(p3);
        }
        if (ib.getId() == R.id.p4) {
            ib.setImageDrawable(p4);
        }
        if (ib.getId() == R.id.p5) {
            ib.setImageDrawable(p5);
        }
        if (ib.getId() == R.id.p6) {
            ib.setImageDrawable(p6);
        }
        if (ib.getId() == R.id.p7) {
            ib.setImageDrawable(p7);
        }
        if (ib.getId() == R.id.p8) {
            ib.setImageDrawable(p8);
        }
        if (ib.getId() == R.id.p9) {
            ib.setImageDrawable(p9);
        }
        if (ib.getId() == R.id.p10) {
            ib.setImageDrawable(p10);
        }
        if (ib.getId() == R.id.p11) {
            ib.setImageDrawable(p11);
        }
        if (ib.getId() == R.id.p12) {
            ib.setImageDrawable(p12);
        }
    }

    public void automatStart() {
        automatRun = true;
        timer.run();
    }

    public void automatToggle(View b) {
        TextView tvbody = findViewById(R.id.tvbody);
        TextView tvAutomat = findViewById(R.id.tvautomat);

        // reset
        if(i<-2||i>2) {
            i=0;
            tvbody.setText("Body: 0");
        }
        if(automatRun) automatStop();
        else {
            tvAutomat.setText("");
            automatStart();
        }
    }

    Runnable timer = new Runnable() {
        @Override
        public void run() {
            TextView tv = findViewById(R.id.tvn0);
            TextView tv1 = findViewById(R.id.tvn1);
            TextView tv2 = findViewById(R.id.tvn2);

            tv.setText(String.valueOf(new Random().nextInt(10)));
            tv1.setText(String.valueOf(new Random().nextInt(10)));
            tv2.setText(String.valueOf(new Random().nextInt(10)));
            h.postDelayed(this, 700);
        }
    };

    public void automatStop() {
        automatRun = false;
        h.removeCallbacks(timer);
        TextView tv = findViewById(R.id.tvn0);
        TextView tv1 = findViewById(R.id.tvn1);
        TextView tv2 = findViewById(R.id.tvn2);
        TextView tvAutomat = findViewById(R.id.tvautomat);
        TextView tvbody = findViewById(R.id.tvbody);

        //2 shody - +1 bod
        if(tv.getText() == tv1.getText() && tv1.getText() == tv2.getText()) {
            tvAutomat.setText("SHODA 3x");
            i+=2;
        }
        //3 shody - +2 body
        else if(tv.getText() == tv1.getText() || tv1.getText() == tv2.getText() || tv.getText() == tv2.getText()){
            tvAutomat.setText("SHODA");
            i++;
        }
        //neshoda - -1 bod
        else {
            tvAutomat.setText("NESHODA");
            i--;
        }

        tvbody.setText("Body: " + i);
        if(i>2) tvbody.setText("Výhra!");
        if(i<-2) tvbody.setText("Prohra!");
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
        for(int i = 0; i < slovo.length(); i++) {
            char znak = (char) (sbpismen.getProgress() + 97);
            char znakUpper = (char) (sbpismen.getProgress() + 65);
            if(slovo.charAt(i) == znak) {
                String act = (String) tvslovo.getText();
                act = act.replace((char) (i + 49), znak);
                tvslovo.setText(act);
                remain--;
            } else if (slovo.charAt(i) == znakUpper) {
                String act = (String) tvslovo.getText();
                act = act.replace((char) (i + 49), znakUpper);
                tvslovo.setText(act);
                remain--;
            }
            Log.d("Remain",remain + ": remain");
        }

        //odstranit tlacitko
        if(remain <= 0) {
            Button b = findViewById(R.id.hang);
            b.setVisibility(View.INVISIBLE);
        }
    }

    //Oběšenec - new game
    public void obesenecng(View v) {
        int r = new Random().nextInt(4);
        if(r == 0) slovo = "ZOO";
        if(r == 1) slovo = "tygr";
        if(r == 2) slovo = "Martin";
        if(r == 3) slovo = "LOGoPEd";
        if(r == 4) slovo = "Slovo";
        remain = slovo.length();

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