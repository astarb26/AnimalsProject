package com.example.hitprojectanimals.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hitprojectanimals.Person;
import com.example.hitprojectanimals.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseApp.initializeApp(this);
        mAuth = FirebaseAuth.getInstance();
    }


    public void funcButtonLoginLoginPage(EditText emailText, EditText passText, View view) {
        String email = emailText.getText().toString().trim();
        String password = passText.getText().toString().trim();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override

                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "login ok", Toast.LENGTH_LONG).show();
                            if (email.charAt(0) == 'M')
                            {
                                Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_userFragment);
                            }
                            else
                            {
                                Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_regUserFragment);
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "login fail", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    public void write(EditText textEmail, EditText textPhone, EditText textId, EditText textAddress){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference().child("user").child(textId.getText().toString());
        Person person = new Person(textEmail.getText().toString(),textPhone.getText().toString(),textId.getText().toString(),textAddress.getText().toString());
        myRef.setValue(person);
    }

    public void read(TextView email, TextView phone, TextView address,EditText search,TextView id){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference().child("user").child(search.getText().toString());
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Person value = dataSnapshot.getValue(Person.class);
                email.setText(value.email);
                id.setText(value.id);
                phone.setText(value.phone);
                address.setText(value.address);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });
    }


        public void funcButtonRegLoginPage(EditText TextEmail, EditText TextPass,View view) {
            String email  =  TextEmail.getText().toString().trim();
            String password = TextPass.getText().toString().trim();

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(MainActivity.this,"reg ok",Toast.LENGTH_LONG).show();
                                Navigation.findNavController(view).navigate(R.id.action_regFragment_to_userFragment);
                            } else {
                                Toast.makeText(MainActivity.this,"reg fail",Toast.LENGTH_LONG).show();
                            }
                        }
                    });
        }






}