package com.example.estique.realmtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {

    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }


    private void init() {

        RealmConfiguration config = new RealmConfiguration.Builder().name("myrealm.realm").build();

        realm = Realm.getInstance(config);

        final EditText etName = findViewById(R.id.etName);
        final EditText etNumber = findViewById(R.id.etNumber);


        Button btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!TextUtils.isEmpty(etName.getText().toString().trim()) && !TextUtils.isEmpty(etNumber.getText().toString().trim())) {

                    addContact(etName.getText().toString().trim(), etNumber.getText().toString().trim());

                } else {

                    Toast.makeText(MainActivity.this, "Field Missing", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    private void addContact(final String name, final String number) {

        realm.executeTransactionAsync(new Realm.Transaction() {
                                          @Override
                                          public void execute(Realm realm) {

                                              PhoneBook phoneBook = realm.createObject(PhoneBook.class);
                                              phoneBook.setName(name);
                                              phoneBook.setNumber(number);


                                          }
                                      }, new Realm.Transaction.OnSuccess() {
                                          @Override
                                          public void onSuccess() {

                                              Log.d("Realm", "onSuccess");



                                          }
                                      }, new Realm.Transaction.OnError() {
                                          @Override
                                          public void onError(Throwable error) {

                                              Log.d("Realm", "onError");

                                          }
                                      }


        );

    }
}
