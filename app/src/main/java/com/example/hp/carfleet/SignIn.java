package com.example.hp.carfleet;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class SignIn extends AppCompatActivity {
    EditText password1;
    TextView mp_oublie;
    TextView insciption;

    private static final String TAG = "SignInActivity";
    private static final int RC_SIGN_IN = 0;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private ImageView google_id;
    private GoogleApiClient mGoogleApiClient;
    ProgressDialog progressDialog;


    // LinearLayout ll_button1, ll_bottom1;

    //firebase variable
    private EditText emailAdress;
    private Button signin1;

    //firebasem auth
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sign_in);





        signin1 = (Button) findViewById(R.id.btn_sign_up1);


        signin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = emailAdress.getText().toString();
                String Pass = password1.getText().toString();

                if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(Pass)) {


                    startActivity(new Intent(SignIn.this, Drawer.class));
                    finish();

                } else {
                    Toast.makeText(SignIn.this, "vous avez oublier un champ", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}

