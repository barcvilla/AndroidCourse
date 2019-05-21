package com.ceva.appnotepad.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ceva.appnotepad.R;

public class Sample_Empty_Activity extends AppCompatActivity {
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample__empty_);

         textView = (TextView)findViewById(R.id.texto);
         button = (Button)findViewById(R.id.boton);

         button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        textView.setText("Este texto se ha modificado");
        }
        });
    }
}
