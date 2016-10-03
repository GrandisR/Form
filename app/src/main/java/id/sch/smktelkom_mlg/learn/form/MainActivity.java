package id.sch.smktelkom_mlg.learn.form;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    EditText etNama, etJumlah;
    Spinner spUkuran;
    RadioGroup rgRasa;
    CheckBox cbCc, cbC, cbN;
    TextView tvHasil;
    Button bOK;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etJumlah = (EditText) findViewById(R.id.editTextJumlah);
        rgRasa = (RadioGroup) findViewById(R.id.rgRasa);
        cbCc = (CheckBox) findViewById(R.id.checkBoxCc);
        cbC = (CheckBox) findViewById(R.id.checkBoxC);
        cbN = (CheckBox) findViewById(R.id.checkBoxN);
        spUkuran = (Spinner) findViewById(R.id.spinnerUkuran);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        bOK = (Button) findViewById(R.id.buttonOK);

        bOK.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                doProcess();
            }
        });
    }

    private void doProcess()
    {
        String nama = etNama.getText().toString();
        String hasil = null;
        String ukuran = spUkuran.getSelectedItem().toString();
        String hasiltp = "dengan toping ";
        int startlen = hasiltp.length();

//        int startlen = 0;
        if (hasil != null) {
//            startlen = hasil.length();
        } else {
            if (cbCc.isChecked()) hasiltp += cbCc.getText() + "\n";
            if (cbC.isChecked()) hasiltp += cbC.getText() + "\n";
            if (cbN.isChecked()) hasiltp += cbN.getText() + "\n";

            if (hasiltp.length() == startlen) hasil += "Tidak ada pada pilihan";
        }
        if(rgRasa.getCheckedRadioButtonId() !=-1)
        {
            RadioButton rb = (RadioButton)
                    findViewById(rgRasa.getCheckedRadioButtonId());
            hasil = rb.getText().toString();
        }

        if(isValid())
        {
            int Jumlah = Integer.parseInt(etJumlah.getText().toString());
            tvHasil.setText(nama +" memesan cupcakes berjumlah "+Jumlah+" buah"+" berukuran "+ ukuran + " rasa "+ hasil+" "+hasiltp);
        }
    }

    private boolean isValid()
    {
        boolean valid = true;

        String nama = etNama.getText().toString();
        String jumlah = etJumlah.getText().toString();

        String hasil = null;

        if(nama.isEmpty())
        {
            etNama.setError("Nama belum diisi");
            valid = false;
        }
        else if(nama.length()<3)
        {
            etNama.setError("Nama minimal 3 karakter");
            valid = false;
        }
        else
        {
            etNama.setError(null);
        }

        if(jumlah.isEmpty())
        {
            etJumlah.setError("Jumlah kue belum diisi");
            valid = false;
        }
        else
        {
            etJumlah.setError(null);
        }

        /*if(hasil==null)
            tvHasil.setText("Belum memilih rasa");
        else
        {
            tvHasil.setText("Rasa kue : "+hasil);
        }*/

        return valid;
    }
}