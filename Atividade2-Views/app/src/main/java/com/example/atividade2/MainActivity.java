package com.example.atividade2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.example.atividade2.databinding.ActivityMainBinding;

import java.util.IllegalFormatCodePointException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnLimpar.setOnClickListener(this);
        binding.btnExibir.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnLimpar) {
            binding.edtNome.setText("");
            binding.edtEmail.setText("");
            binding.edtTelefone.setText("");
            binding.rdbSexo.clearCheck();
            binding.chkCinema.setChecked(false);
            binding.chkEsporte.setChecked(false);
            binding.chkGastron.setChecked(false);
            binding.chkMusica.setChecked(false);
        }  else if (view.getId() == R.id.btnExibir) {
            binding.lblDados.setVisibility(View.VISIBLE);
            binding.txtNome.setText("Nome: " + binding.edtNome.getText().toString());
            binding.txtEmail.setText("Email: " + binding.edtEmail.getText().toString());
            binding.txtTelefone.setText("Telefone: " + binding.edtTelefone.getText().toString());

            int idRdbSelecionado = binding.rdbSexo.getCheckedRadioButtonId();
            if (idRdbSelecionado > 0) {
                RadioButton rdbSelecionado = findViewById(idRdbSelecionado);
                binding.txtSexo.setText("Sexo: " + rdbSelecionado.getText().toString());
            }

            String pref = "";
            if (binding.chkMusica.isChecked()) {
                pref = binding.chkMusica.getText().toString();
            }
            if (binding.chkGastron.isChecked()) {
                pref += " ";
                pref += binding.chkGastron.getText().toString();
            }
            if (binding.chkCinema.isChecked()) {
                pref += " ";
                pref += binding.chkCinema.getText().toString();
            }
            if (binding.chkEsporte.isChecked()) {
                pref += " ";
                pref += binding.chkEsporte.getText().toString();
            }
            binding.txtPreferencias.setText("Preferências: " + pref);

            if (binding.swtNotif.isChecked()) {
                binding.txtNotif.setText("Notificações " + binding.swtNotif.getTextOn());
            } else {
                binding.txtNotif.setText("Notificações " + binding.swtNotif.getTextOff());
            }


        }
    }
}