package com.example.atividade4;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.EditText;
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
    private TextWatcher inputTextWatcher;
    private EditText editText;
    private TextView textView;

    SpannableStringBuilder builder=new SpannableStringBuilder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.skbTamanho.setOnSeekBarChangeListener(this);
        binding.btnExibir.setOnClickListener(this);
        binding.chkItalico.setOnClickListener(this);
        binding.chkNegrito.setOnClickListener(this);


//        String texto = binding.edtTexto.getText().toString();
//        TextView txtEscrita = findViewById(R.id.txtEscrita);
//        txtEscrita.addTextChangedListener(inputTextWatcher);


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
//            String textoNegrito = "";

            if (binding.chkNegrito.isChecked()) {
                estilo += Typeface.BOLD;
            } else {
                estilo += Typeface.NORMAL;
            }
//            builder.setSpan(new StyleSpan(Typeface.BOLD), textoNegrito, 0);
            binding.txtEscrita.setText(texto);
            binding.txtEscrita.setTypeface(null, estilo);
        }
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