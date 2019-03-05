package com.example.hp.carfleet;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class reset_password extends AppCompatActivity {


    private Button button_reset;
    private EditText email_reset;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);


        mAuth = FirebaseAuth.getInstance();

        button_reset = (Button) findViewById(R.id.button_reset);
        email_reset = (EditText) findViewById(R.id.email_reset);


        button_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String userEmail = email_reset.getText().toString();
                if (TextUtils.isEmpty(userEmail))
                {
               Toast.makeText(reset_password.this,"Veuillez entrer l'email valide",Toast.LENGTH_SHORT).show();
                }
                else
                    {
                    mAuth.sendPasswordResetEmail(userEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task)
                        {
                        if(task.isSuccessful())
                        {
                        Toast.makeText(reset_password.this,"Verifier votre boite Email",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(reset_password.this,SignIn.class));
                        }
                        else
                            {
                                String message = task.getException().getMessage();
                                Toast.makeText(reset_password.this,"Une Erreur c'est produite" +message,Toast.LENGTH_SHORT).show();

                            }

                        }
                    });
                   }
            }
        });
    }
}