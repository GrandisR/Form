package id.sch.smktelkom_mlg.learn.form;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{

    EditText etNama;
    EditText etJumlah;
    Button bOK;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etJumlah = (EditText) findViewById(R.id.editTextJumlah);
        bOK = (Button) findViewById(R.id.buttonOK);

        bOK.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

            }
        });
    }
}
