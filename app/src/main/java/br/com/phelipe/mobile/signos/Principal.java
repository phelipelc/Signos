package br.com.phelipe.mobile.signos;

import android.content.Intent;
import  android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Button;
public class Principal extends AppCompatActivity {
    private Spinner spinnerDia = null;
    private Spinner spinnerMes = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        spinnerDia = (Spinner) findViewById(R.id.spinnerDia);
        spinnerMes = (Spinner) findViewById(R.id.spinnerMes);

        ArrayAdapter<CharSequence> adapter_dia = ArrayAdapter.createFromResource(this, R.array.dias,
                android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter_mes = ArrayAdapter.createFromResource(this, R.array.meses,
                android.R.layout.simple_spinner_item);

        adapter_dia.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_mes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDia.setAdapter(adapter_dia);
        spinnerMes.setAdapter(adapter_mes);
        Button enviar = (Button) findViewById(R.id.buttonEnviar);
        enviar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                int posicaoDia =  spinnerDia.getSelectedItemPosition();
                int posicaoMes = spinnerMes.getSelectedItemPosition();
                posicaoDia++;
                posicaoMes++;

                InterpretadorSigno Interpretador = new InterpretadorSigno();
                Signo signoresultado = Interpretador.Interpretar(posicaoDia,posicaoMes);

                Bundle args = new Bundle();
                args.putSerializable("resultado", signoresultado);

                Intent intent = new Intent(Principal.this, Resultado.class);
                intent.putExtra("signo",args);

                startActivity(intent);

            }

        });
    }
}







