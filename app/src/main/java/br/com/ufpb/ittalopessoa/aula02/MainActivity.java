package br.com.ufpb.ittalopessoa.aula02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTexto = (TextView) findViewById(R.id.texto);
        Bundle bundle = getIntent().getExtras(); //capturar da minha Intent os seus parametros
        String texto = bundle.getString("nome");// no caso, o meu usuário. Definido através da chave "nome"
        mTexto.setText("Olá "+texto+ " seja bem-vindo!"); //atribuir a minha View mTexto a menssagem mostrada na tela.
    }
}
