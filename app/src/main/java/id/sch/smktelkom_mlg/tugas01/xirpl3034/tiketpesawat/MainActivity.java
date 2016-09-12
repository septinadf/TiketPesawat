package id.sch.smktelkom_mlg.tugas01.xirpl3034.tiketpesawat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNama;
    EditText etEmail;
    EditText etPnpDewasa;
    EditText etPnpAnak;
    Button bPesan;
    TextView tvHasil, tvNama, tvEmail, tvPesawat, tvRute,
            tvPnpDewasa, tvPnpAnak, tvpnp;
    RadioGroup rgPesawat;
    RadioButton rbGI, rbLA, rbSA;
    CheckBox cbRingan, cbMedium, cbBerat;
    Spinner spRute;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etEmail = (EditText) findViewById(R.id.editTextEmail);
        etPnpDewasa = (EditText) findViewById(R.id.editTextPD);
        etPnpAnak = (EditText) findViewById(R.id.editTextPA);
        bPesan = (Button) findViewById(R.id.buttonPesan);
        tvHasil = (TextView) findViewById(R.id.textViewhasil);
        tvNama = (TextView) findViewById(R.id.textViewNama);
        tvEmail = (TextView) findViewById(R.id.textViewEmail);
        tvPesawat = (TextView) findViewById(R.id.textViewPesawat);
        tvRute = (TextView) findViewById(R.id.textViewRute);
        tvPnpDewasa = (TextView) findViewById(R.id.textViewJmlDewasa);
        tvPnpAnak = (TextView) findViewById(R.id.textViewJmlAnak);
        tvpnp = (TextView) findViewById(R.id.textViewJenisPnp);
        rgPesawat = (RadioGroup) findViewById(R.id.radioGroupPswt);
        rbGI = (RadioButton) findViewById(R.id.radioButtonGI);
        rbLA = (RadioButton) findViewById(R.id.radioButtonLA);
        rbSA = (RadioButton) findViewById(R.id.radioButtonSA);
        cbRingan = (CheckBox) findViewById(R.id.checkBoxRingan);
        cbMedium = (CheckBox) findViewById(R.id.checkBoxMedium);
        cbBerat = (CheckBox) findViewById(R.id.checkBoxBerat);
        spRute = (Spinner) findViewById(R.id.spinnerRute);

        bPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProcess();
                doPesawat();
                doJenis();
                doRute();

            }
        });
    }

    private void doRute() {
        tvRute.setText("Rute Perjalanan: " + spRute.getSelectedItem().toString());
    }

    private void doJenis() {
        String hasil = "Bagasi yang dipilih ";
        int startlen = hasil.length();
        if (cbRingan.isChecked()) hasil += cbRingan.getText() + " , ";
        if (cbMedium.isChecked()) hasil += cbMedium.getText() + " , ";
        if (cbBerat.isChecked()) hasil += cbBerat.getText() + "";
        if (hasil.length() == startlen) hasil += "Tidak ada pilihan";
        tvpnp.setText(hasil);
    }

    private void doPesawat() {
        String hasil = null;
        if (rbGI.isChecked()) {
            hasil = rbGI.getText().toString();
        } else if (rbLA.isChecked()) {
            hasil = rbLA.getText().toString();
        } else if (rbSA.isChecked()) {
            hasil = rbSA.getText().toString();
        }
        if (hasil == null) {
            tvPesawat.setText("Belum memilih pesawat");
        } else {
            tvPesawat.setText("Nama Pesawat : " + hasil);
        }
    }

    private void doProcess() {

        if (isValid()) {
            String nama = etNama.getText().toString();
            String email = etEmail.getText().toString();
            String jmlDewasa = etPnpDewasa.getText().toString();
            String jmlAnak = etPnpAnak.getText().toString();
            tvHasil.setText("TERIMA KASIH PEMESANAN BERHASIL");
            tvNama.setText("Nama Pemesan: " + nama);
            tvEmail.setText("Email: " + email);
            tvPnpDewasa.setText("Jumlah Tiket Dewasa: " + jmlDewasa);
            tvPnpAnak.setText("Jumlah Tiket Anak-anak: " + jmlAnak);
        }
    }

    private boolean isValid() {
        boolean valid = true;

        String nama = etNama.getText().toString();
        String email = etEmail.getText().toString();
        String jmlDewasa = etPnpDewasa.getText().toString();
        String jmlAnak = etPnpAnak.getText().toString();

        if (nama.isEmpty()) {
            etNama.setError("Nama belum diisi");
            valid = false;
        } else {
            etNama.setError(null);
        }

        if (email.isEmpty()) {
            etEmail.setError("Email belum diisi");
            valid = false;
        } else {
            etEmail.setError(null);
        }
        if (jmlDewasa.isEmpty()) {
            etPnpDewasa.setError("Jumlah penumpang dewasa belum diisi");
            valid = false;
        } else {
            etPnpDewasa.setError(null);
        }
        if (jmlAnak.isEmpty()) {
            etPnpAnak.setError("Jumlah penumpang anak-anak belum diisi");
            valid = false;
        } else {
            etPnpAnak.setError(null);
        }
        return valid;
    }
}






