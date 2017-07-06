package turma_android.com.br.appexemplos.aluno;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import turma_android.com.br.appexemplos.R;

public class AlunoAdapter extends BaseAdapter {
    private List<Aluno> alunos;
    private Context contexto;

    public AlunoAdapter(List<Aluno> alunos, Context contexto) {
        this.alunos = alunos;
        this.contexto = contexto;
    }

    @Override
    public int getCount() {
        return alunos.size();
    }

    @Override
    public Object getItem(int i) {
        return alunos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View item = LayoutInflater.from(contexto).inflate(R.layout.aluno_item_layout, null);

        TextView txtNome = (TextView)item.findViewById(R.id.nomeAluno);
        TextView txtEmail = (TextView) item.findViewById(R.id.emailAluno);

        Aluno a = alunos.get(i);

        txtNome.setText(a.getNome());
        txtEmail.setText(a.getEmail());

        return item;
    }
}