package turma_android.com.br.appexemplos.estado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import turma_android.com.br.appexemplos.R;

public class EstadoActivity extends AppCompatActivity {
    public static final String ESTADO_SELECIONADO = "estado_selecionado";
    public static final String TITULO_BUTTON = "titulo_button";
    private final int REQUISICAO_ESTADO = 1;
    private Button buttonEstado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.estado_layout);

        buttonEstado = (Button) findViewById(R.id.buttonEstado);
    }

    public void invocarAtividadeEstados(View view) {
        Intent it = new Intent(this, EstadoListagemActivity.class);
        it.putExtra(TITULO_BUTTON, buttonEstado.getText());

        startActivityForResult(it, REQUISICAO_ESTADO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(REQUISICAO_ESTADO == requestCode && resultCode == RESULT_OK) {
            String estado = data.getStringExtra(ESTADO_SELECIONADO);
            buttonEstado.setText(estado);
        }
    }
}
