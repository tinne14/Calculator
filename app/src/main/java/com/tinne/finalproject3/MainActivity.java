package com.tinne.finalproject3;

import static java.lang.Double.parseDouble;
import static java.lang.Float.parseFloat;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.tinne.finalproject3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    double num1, num2=0;
    private ActivityMainBinding binding;
    private TextView vHasil;
    private boolean isDot, isNum, isZero, isPlus, isMin, isMulti, isDiv = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        vHasil = binding.tvHasil;
        setContentView(binding.getRoot());


        binding.btnClr.setOnClickListener(v -> {
            vHasil.setText(null);
            isMulti = false;
            isMin = false;
            isPlus = false;
            isDiv = false;
            num1 = 0;
            num2 = 0;
            isDot = false;
            isNum = false;
            isZero = false;
        });

        binding.btnDel.setOnClickListener(v -> {
            if (!vHasil.getText().toString().isEmpty()) {
                vHasil.setText(vHasil.getText().subSequence(0, (vHasil.length() - 1)));
            }
        });

        binding.btnSamaDengan.setOnClickListener(v -> hasil());

        binding.btnPersen.setOnClickListener(v -> {
            if (vHasil.getText().length() != 0) {
                num1 = parseFloat((vHasil.getText().toString()));
                vHasil.setText(String.format("%.1f", num1 / 100));
                isDot = false;
                isNum = false;
            }
        });


        binding.btnKali.setOnClickListener(v -> {
            if (vHasil.getText().length() != 0) {
                num1 = parseFloat((vHasil.getText().toString()));
                isDot = false;
                isNum = false;
                isMulti = true;
                isMin = false;
                isPlus = false;
                isDiv = false;
                vHasil.setText(null);
            }
        });
        binding.btnKurang.setOnClickListener(v -> {
            if (vHasil.getText().length() != 0) {
                num1 = parseFloat((vHasil.getText().toString()));
                isDot = false;
                isNum = false;
                isMin = true;
                isPlus = false;
                isMulti = false;
                isDiv = false;
                vHasil.setText(null);
            }
        });
        binding.btnBagi.setOnClickListener(v -> {
            if (vHasil.getText().length() != 0) {
                num1 = parseFloat((vHasil.getText().toString()));
                isDot = false;
                isNum = false;
                isDiv = true;
                isMin = false;
                isMulti = false;
                isPlus = false;
                vHasil.setText(null);
            }
        });
        binding.btnTambah.setOnClickListener(v -> {
            if (vHasil.getText().length() != 0) {
                num1 = parseFloat((vHasil.getText().toString()));
                isDot = false;
                isNum = false;
                isPlus = true;
                isMin = false;
                isMulti = false;
                isDiv = false;
                vHasil.setText(null);
            }
        });

        binding.btnTitik.setOnClickListener(this::titikDesimal);

        binding.btn0.setOnClickListener(this::Nol);
        binding.btn1.setOnClickListener(this);
        binding.btn2.setOnClickListener(this);
        binding.btn3.setOnClickListener(this);
        binding.btn4.setOnClickListener(this);
        binding.btn5.setOnClickListener(this);
        binding.btn6.setOnClickListener(this);
        binding.btn6.setOnClickListener(this);
        binding.btn7.setOnClickListener(this);
        binding.btn8.setOnClickListener(this);
        binding.btn9.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Button b = (Button) view;
        String value = b.getText().toString();
        vHasil.append(value);
        isNum = true;
    }

    void titikDesimal(View view) {
        if (isNum && !isDot) {
            vHasil.append(".");
            isDot = true;
            isNum = false;
        }
    }

    void Nol(View view) {
        if (isNum) {
            vHasil.append("0");
        }
    }

    void hasil() {
        if (Double.valueOf(num1).toString().isEmpty()) {
        } else if (!vHasil.getText().toString().isEmpty()){
            num2 = parseDouble(vHasil.getText().toString());
            if (isMin) {
                num1 -= num2;
                vHasil.setText(String.format("%.1f", num1));
                isMin = false;
            }
            if (isPlus) {
                num1 += num2;
                vHasil.setText(String.format("%.1f", num1));
                isPlus = false;
            }
            if (isDiv) {
                num1 /= num2;
                vHasil.setText(String.format("%.1f", num1));
                isDiv = false;
            }
            if (isMulti) {
                num1 *= num2;
                vHasil.setText(String.format("%.1f", num1));
                isMulti = false;
            }
        }
    }
}