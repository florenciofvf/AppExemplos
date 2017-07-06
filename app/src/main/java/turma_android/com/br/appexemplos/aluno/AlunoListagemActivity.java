package turma_android.com.br.appexemplos.aluno;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import turma_android.com.br.appexemplos.R;

public class AlunoListagemActivity extends AppCompatActivity {
    private ListView listagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aluno_listagem_layout);

        listagem = (ListView)findViewById(R.id.listaAlunos);

        AlunoAdapter adapter = new AlunoAdapter(criarAlunos(), this);

        listagem.setAdapter(adapter);

    }

    private List<Aluno> criarAlunos() {
        List<Aluno> resp = new ArrayList<>();

        Aluno a = new Aluno();
        a.setNome("Maria da Silva");
        a.setEmail("maria@maria.com");
        resp.add(a);

        for(int i=1; i<=100; i++) {
            Aluno b = new Aluno();
            b.setNome("Maria da Silva - " + i);
            b.setEmail("maria@maria.com - " + i);

            resp.add(b);
        }

        return resp;
    }
}
