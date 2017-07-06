package turma_android.com.br.appexemplos.aluno;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import turma_android.com.br.appexemplos.R;

public class AlunoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aluno_layout);
    }

    public void invocarAtividadeAlunos(View view) {
        Intent it = new Intent(this, AlunoListagemActivity.class);
        startActivity(it);
    }

}
