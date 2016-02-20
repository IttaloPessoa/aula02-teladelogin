package br.com.ufpb.ittalopessoa.aula02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    //Declarar as variaveis
    private EditText mUsuario;
    private EditText mSenha;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //Recuperar as Id's atribuidas nas views inseridas no xml
        mUsuario = (EditText) findViewById(R.id.usuario);
        mSenha = (EditText) findViewById(R.id.senha);
        mButton = (Button) findViewById(R.id.btn);

        mButton.setOnClickListener(new View.OnClickListener() {//metodo de evento de click do botão
            @Override
            public void onClick(View v) {
                logar();
            }
        });
    }

    private void logar() {//ação do botão
        //capturar o usuário e senha digitados na tela
        String usuario = mUsuario.getText().toString();
        String senha = mSenha.getText().toString();

        if (usuario.equalsIgnoreCase("seu nome") && senha.equalsIgnoreCase("123")) {
            Intent intent = new Intent(this, MainActivity.class);//Intenção de mudança de tela, caso o usuário seja válido, passando a Acitviy atual e a futura
            Bundle bundle = new Bundle(); //Instância do Objeto necessário para enviar parametros para minha nova Activity
            bundle.putString("nome", usuario);//guardar o usuario no Bundle, e uma chave para sua futura busca
            intent.putExtras(bundle);//guardar na sua Intent o Bundle
            startActivity(intent);//Chamada da minha nova Activity
            finish();// encerrar a execursão da activty atual, para que depois de logado o usuario não consiga mais voltar.
        } else {
            View focus = null; // objeto encarregado de lançar a mensagem de tratamento de eventos
            boolean exibir = false; //variável para auxiliar na exibição do focus
            if (TextUtils.isEmpty(usuario)) {// verificar se o campo de usuário está vazio.
                mUsuario.setError("Campo vazio"); // Menssagem de tratamento na View mUsuaário
                focus = mUsuario; //atribuir a menssgem para exibição do focus;
                exibir = true;
            }
            if(TextUtils.isEmpty(senha)){// verificar se o campo senha está vazio
                mSenha.setError("Campo vazio ");// menssagem de tratamento para View mSenha
                focus = mSenha; // atribuir atribuir a menssagem para o focus
                exibir = true;
            }
            else{//Login ou senha incorretos
                mUsuario.setError("Login ou senha incorretos");
                focus = mUsuario;
                exibir = true;
            }
            if(exibir){//com a variável auxiliar atribuida valor booleano true, exibir a menssagem na tela
                focus.requestFocus();
            }
        }
    }
}
