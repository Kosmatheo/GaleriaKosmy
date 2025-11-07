package com.example.galeriakosmy;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.ViewSwitcher;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button preview;
    private Button next;
    private ImageView Obraz;
    private EditText edittekst;
    private Switch swit;
    private LinearLayout layout;
    private ArrayList<Obraz> Lista = new ArrayList<>();
    private int AktualnyObraz = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        preview = findViewById(R.id.poprzednii);
        next = findViewById(R.id.nastepny);
        Obraz = findViewById(R.id.imageView);
        edittekst = findViewById(R.id.edit);
        swit = findViewById(R.id.switch1);
        layout = findViewById(R.id.main);

        Lista.add(new Obraz(
                R.drawable.kot1
        ));
        Lista.add(new Obraz(
                R.drawable.kot2
        ));
        Lista.add(new Obraz(
                R.drawable.kot3
        ));
        Lista.add(new Obraz(
                R.drawable.kot4
        ));
        preview.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(AktualnyObraz!=0) {
                            AktualnyObraz--;
                            UstawObraz();
                        }
                        else{
                            AktualnyObraz = 3;
                            UstawObraz();
                        }
                    }
                }
        );
        next.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(AktualnyObraz!=3) {
                            AktualnyObraz++;
                            UstawObraz();
                        }
                        else{
                            AktualnyObraz = 0;
                            UstawObraz();
                        }
                    }
                }
        );
        swit.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if(b){
                            layout.setBackgroundColor(Color.parseColor("#2196F3"));
                        }
                        else {
                            layout.setBackgroundColor(Color.parseColor("#00796B"));
                        }
                    }
                }
        );
        edittekst.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        if(charSequence.toString() != null) {
                            AktualnyObraz = Integer.parseInt(charSequence.toString());
                            UstawObraz();
                        }
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                }
        );
    }
    public void UstawObraz(){
        Obraz.setImageResource(Lista.get(AktualnyObraz).getObraz());
    }

}