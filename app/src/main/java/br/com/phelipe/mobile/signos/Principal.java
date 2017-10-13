package br.com.phelipe.mobile.signos;

import android.content.Intent;
import  android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Button;
public class Principal extends AppCompatActivity {
    private Spinner spinnerDia = null;
    private Spinner spinnerMes = null;

    private void validarData(){
     int dia = spinnerDia.getSelectedItemPosition();
     int mes = spinnerMes.getSelectedItemPosition();
        dia++;
        mes++;

        if(dia > 29 && mes == 2){
        spinnerDia.setSelection(28);
        }else if((mes == 4 || mes == 6 || mes == 9 || mes == 11) && (dia > 30)){
        spinnerDia.setSelection(29);
        }

    }

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

        spinnerDia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                validarData();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerMes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                validarData();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




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







