package com.example.atividade4;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.atividade4.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, View.OnClickListener {
    private ActivityMainBinding binding;
    private Integer tamanhoLetra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.skbTamanho.setOnSeekBarChangeListener(this);
        binding.btnExibir.setOnClickListener(this);
        binding.chkItalico.setOnClickListener(this);
        binding.chkNegrito.setOnClickListener(this);
        binding.rdbCor.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String texto = binding.edtTexto.getText().toString();
        Typeface italicTypeface = Typeface.defaultFromStyle(Typeface.ITALIC); //itálico
        if (view.getId() == R.id.btnExibir) {
            binding.txtEscrita.setText(texto);
        }

        if (view.getId() == R.id.chkMaiuscula ) {
            String textoCaps = "";
            if (binding.chkMaiuscula.isChecked()) {
                textoCaps = texto.toUpperCase();
            } else {
                textoCaps = texto.toLowerCase();
            }
            binding.txtEscrita.setText(textoCaps);
        }
        if (view.getId() == R.id.chkNegrito) {
            int estilo = Typeface.NORMAL;

            if (binding.chkNegrito.isChecked()) {
                estilo += Typeface.BOLD;
            } else {
                estilo += Typeface.NORMAL;
            }
            binding.txtEscrita.setText(texto);
            binding.txtEscrita.setTypeface(null, estilo);
        }
        if (view.getId() == R.id.chkItalico) {
            int estilo = Typeface.NORMAL;

            if (binding.chkItalico.isChecked()) {
                estilo += Typeface.ITALIC;
            } else {
                estilo += Typeface.NORMAL;
            }
            binding.txtEscrita.setText(texto);
            binding.txtEscrita.setTypeface(null, estilo);
        }

        if (binding.rdbCor.getId() != View.NO_ID) {
            RadioButton rdbSelecionado = findViewById(binding.rdbCor.getId());
            String black = "#000000";
            String vermelho = "#FF0000";
            String azul = "#0000ff";

            binding.rdbPreto.setText(black);
            binding.rdbVerm.setText(vermelho);
            binding.rdbAzul.setText(azul);

            binding.txtEscrita.setTextColor(Color.parseColor(rdbSelecionado.getText().toString()));
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (seekBar.getId() == R.id.skbTamanho) {
            float tamanhoTexto = progress * 1.0f;
            binding.txtTamanho.setText((int) tamanhoTexto);
            binding.txtEscrita.setTextSize(tamanhoTexto);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

//    public static SpannableStringBuilder makeSectionOfTextBold(String text, String textToBold){
//
//        SpannableStringBuilder builder=new SpannableStringBuilder();
//
//        if(textToBold.length() > 0 && !textToBold.trim().equals("")){
//
//            //for counting start/end indexes
//            String testText = text.toLowerCase(Locale.US);
//            String testTextToBold = textToBold.toLowerCase(Locale.US);
//            int startingIndex = testText.indexOf(testTextToBold);
//            int endingIndex = startingIndex + testTextToBold.length();
//            //for counting start/end indexes
//
//            if(startingIndex < 0 || endingIndex <0){
//                return builder.append(text);
//            }
//            else if(startingIndex >= 0 && endingIndex >=0){
//
//                builder.append(text);
//                builder.setSpan(new StyleSpan(Typeface.BOLD), startingIndex, endingIndex, 0);
//            }
//        }else{
//            return builder.append(text);
//        }
//
//        return builder;
//    }
}