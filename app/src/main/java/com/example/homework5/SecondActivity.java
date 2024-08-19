package com.example.homework5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.slider.RangeSlider;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        registerReceiver(finishReceiver, new IntentFilter("close_all_activities"));
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        MaterialButton buttonHeart = findViewById(R.id.btn_heart);


        TextView textResult = findViewById(R.id.text_result);
        String result = getIntent().getStringExtra("key");
        textResult.setText(result);

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.dropdown_items, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);


        RangeSlider rangeSlider = findViewById(R.id.range_slider);
        rangeSlider.setValues(20f, 80f);

        RangeSlider rangeSlider2 = findViewById(R.id.range_slider_second);
        rangeSlider2.setValues(20f, 80f);


        buttonHeart.setTag(R.drawable.ic_heart);

        findViewById(R.id.btn_next).setOnClickListener(view -> {
            Intent intent = new Intent("close_all_activities");
            sendBroadcast(intent);
            finish();
        });



        findViewById(R.id.btn_heart).setOnClickListener(view ->{
            int currentIconId = (int) buttonHeart.getTag();
            if (currentIconId == R.drawable.ic_heart) {
                buttonHeart.setIcon(getResources().getDrawable(R.drawable.ic_heart1));
                buttonHeart.setTag(R.drawable.ic_heart1);
            } else {
                buttonHeart.setIcon(getResources().getDrawable(R.drawable.ic_heart));
                buttonHeart.setTag(R.drawable.ic_heart);
            }
        });
    }


    private BroadcastReceiver finishReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            finish();
        }
    };
}   