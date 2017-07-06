package turma_android.com.br.appexemplos;

import android.content.Intent;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import turma_android.com.br.appexemplos.aluno.AlunoActivity;
import turma_android.com.br.appexemplos.estado.EstadoActivity;

public class MainActivity extends AppCompatActivity {
    private ActionBarDrawerToggle drawerToggle;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(new OuvinteMenuLateral());
    }

    private class OuvinteMenuLateral implements NavigationView.OnNavigationItemSelectedListener {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            drawerLayout.closeDrawers();

            switch (item.getItemId()) {
                case R.id.itemCalculadora: invocarAtividade(new Intent(MainActivity.this, CalculadoraActivity.class)); return true;
                case R.id.itemConfiguracoes: invocarAtividade(new Intent(Settings.ACTION_SETTINGS)); return true;
                case R.id.itemEstado: invocarAtividade(new Intent(MainActivity.this, EstadoActivity.class)); return true;
                case R.id.itemAluno: invocarAtividade(new Intent(MainActivity.this, AlunoActivity.class)); return true;
            }

            return true;
        }
    }

    private void invocarAtividade(Intent it) {
        if(it.resolveActivity(getPackageManager()) != null) {
            startActivity(it);
        } else {
            mensagem(R.string.msg_nao_invocar_atividade);
        }
    }

    private void mensagem(int chaveString) {
        Toast.makeText(this, chaveString, Toast.LENGTH_SHORT).show();
    }
}
