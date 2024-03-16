package com.example.atividade4;

import android.os.Bundle;
import android.text.TextWatcher;
import android.widget.SeekBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.atividade4.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    private ActivityMainBinding binding;
    private TextWatcher inputTextWatcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.skbTamanho.setOnSeekBarChangeListener(this);
        String texto = binding.edtTexto.getText().toString();
        binding.txtEscrita.setText(texto);

//        TextWatcher inputTextWatcher1 = new TextWatcher() {
//            public void afterTextChanged(Editable s) {
//                number = Integer.parseInt(s.toString());
//                sum+=number;
//                tv.setText("sum is "+sum);
//
//            }

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}