package com.example.atividadeapi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView login;
    private TextView id;
    private TextView url;
    private ProgressDialog load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DownloadPessoa download = new DownloadPessoa();

        login = (TextView) findViewById(R.id.textView2);
        id = (TextView) findViewById(R.id.idView);
        url = (TextView) findViewById(R.id.urlview);

        download.execute();
    }

    private class DownloadPessoa extends AsyncTask<Void, Void, pessoa> {

        @Override
        protected void onPreExecute() {
            //inicia o dialog
            load = ProgressDialog.show(MainActivity.this,
                    "Aguarde ...", "Obtendo Informações...");
        }

        @Override
        protected pessoa doInBackground(Void... params) {
            conversor util = new conversor();
            return util.getInformacao("https://api.github.com/users/elcimarsilva");
        }

        @Override
        protected void onPostExecute(pessoa pessoa) {
            //System.out.println(pessoa);
            login.setText(pessoa.getLogin());
            id.setText(pessoa.getId());
            url.setText(pessoa.getUrl());

            load.dismiss(); //deleta o dialog
        }

    }
}