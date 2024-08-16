package com.example.homework5;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Double variableA, variableB;
    private Boolean isOperationClick;
    private Boolean isPlusClick;
    private Boolean isMinusClick;
    private Boolean isMultiplyClick;
    private Boolean isDivideClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textView = findViewById(R.id.text_view);

    }

    public void onNumberClick(View view) {
        String text = ((MaterialButton) view).getText().toString();
        if (text.equals("AC")) {
            textView.setText("0");
            variableB = 0.0;
            variableA = 0.0;
        } else if (textView.getText().toString().equals("0") || isOperationClick) {
            textView.setText(text);
        } else {
            textView.append(text);
        }
        if (textView.getText().toString().equals(".")) {
            textView.setText("0.");
        }
        isOperationClick = false;
    }

    public void onEqualClick(View view) {
        variableB = Double.valueOf(textView.getText().toString());
        Double result = 0.0;
        if (isPlusClick) {
            result = variableA + variableB;
        } else if (isMinusClick) {
            result = variableA - variableB;
        } else if (isMultiplyClick) {
            result = variableA * variableB;
        } else if (isDivideClick) {
            result = variableA / variableB;
        }
        int num = 2;
        String lastValues = result.toString().substring(result.toString().length() - num);
        if (lastValues.equals(".0")){
            int resultInt = result.intValue();
            Integer resultInteger = resultInt;
            textView.setText(resultInteger.toString());
        }else {
            textView.setText(result.toString());
        }
        isOperationClick = true;
        isMultiplyClick = false;
        isPlusClick = false;
        isMinusClick = false;
        isDivideClick = false;
    }

    public void onPlusClick(View view) {
        variableA = Double.valueOf(textView.getText().toString());

        isPlusClick = true;
        isOperationClick = true;
    }

    public void onMinusClick(View view) {
        variableA = Double.valueOf(textView.getText().toString());

        isMinusClick = true;
        isOperationClick = true;
    }

    public void onMultiplyClick(View view) {
        variableA = Double.valueOf(textView.getText().toString());

        isMultiplyClick = true;
        isOperationClick = true;
    }

    public void onDivideClick(View view) {
        variableA = Double.valueOf(textView.getText().toString());

        isDivideClick = true;
        isOperationClick = true;
    }
}