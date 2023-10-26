package com.example.shoesapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class detailproduct extends AppCompatActivity {
    private boolean isRed = false;
    TextView txtgiacu;
    private Button button36,button37,button38,button39,button40,button41,button42;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detaiproduct);
        button36 = findViewById(R.id.btn36);
        button37 = findViewById(R.id.btn37);
        button38 = findViewById(R.id.btn38);
        button39 = findViewById(R.id.btn39);
        button40 = findViewById(R.id.btn39);
        button41 = findViewById(R.id.btn41);
        button42 = findViewById(R.id.btn42);
        button36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRed = !isRed;

                if (isRed) {
                    button36.setBackgroundColor(getResources().getColor(R.color.red));
                } else {
                    button36.setBackgroundColor(getResources().getColor(R.color.gray));
                }
            }
        });
        button37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRed = !isRed;

                if (isRed) {
                    button37.setBackgroundColor(getResources().getColor(R.color.red));
                } else {
                    button37.setBackgroundColor(getResources().getColor(R.color.gray));
                }
            }
        });
        button38.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRed = !isRed;

                if (isRed) {
                    button38.setBackgroundColor(getResources().getColor(R.color.red));
                } else {
                    button38.setBackgroundColor(getResources().getColor(R.color.gray));
                }
            }
        });
        button39.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRed = !isRed;

                if (isRed) {
                    button39.setBackgroundColor(getResources().getColor(R.color.red));
                } else {
                    button39.setBackgroundColor(getResources().getColor(R.color.gray));
                }
            }
        });
        button40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRed = !isRed;

                if (isRed) {
                    button40.setBackgroundColor(getResources().getColor(R.color.red));
                } else {
                    button40.setBackgroundColor(getResources().getColor(R.color.gray));
                }
            }
        });
        button41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRed = !isRed;

                if (isRed) {
                    button41.setBackgroundColor(getResources().getColor(R.color.red));
                } else {
                    button41.setBackgroundColor(getResources().getColor(R.color.gray));
                }
            }
        });
        button42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRed = !isRed;

                if (isRed) {
                    button42.setBackgroundColor(getResources().getColor(R.color.red));
                } else {
                    button42.setBackgroundColor(getResources().getColor(R.color.gray));
                }
            }
        });



//        Gạch ngang giá tiên
        TextView txtgiacu = findViewById(R.id.textgiacu);
        String text = txtgiacu.getText().toString();
        SpannableString spannableString = new SpannableString(text);
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
        spannableString.setSpan(strikethroughSpan, 0, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        txtgiacu.setText(spannableString);
    }
}
