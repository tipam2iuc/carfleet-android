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
        requestWindowFeature(1);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_sign_in);

        google_id = (ImageView) findViewById(R.id.google_id);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, new GoogleApiClient.OnConnectionFailedListener() {
                    @Override
                    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
                    }
                } /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();


        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null) {

                    final FirebaseUser user = firebaseAuth.getCurrentUser();
                    Toast.makeText(SignIn.this, "Now you are logged In " + firebaseAuth.getCurrentUser().getEmail(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignIn.this, Drawer.class);
                    startActivity(intent);
                    finish();

                }
            }
        };
        google_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });


        //firebase login
        password1 = (EditText) findViewById(R.id.et_password1);
        emailAdress = (EditText) findViewById(R.id.et_email1);
        signin1 = (Button) findViewById(R.id.btn_sign_up1);
        mp_oublie = (TextView) findViewById(R.id.mp_oublie);

        mp_oublie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignIn.this, reset_password.class));
            }
        });

        insciption = (TextView) findViewById(R.id.inscrire);
        insciption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignIn.this, SignUp.class));
            }
        });

        FirebaseApp.initializeApp(this);


        mAuth = FirebaseAuth.getInstance();

        signin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = emailAdress.getText().toString();
                String Pass = password1.getText().toString();

                if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(Pass)) {

                    mAuth.signInWithEmailAndPassword(email, Pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                startActivity(new Intent(SignIn.this, Drawer.class));
                                finish();
                            } else {
                                Toast.makeText(SignIn.this, "Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } else {
                    Toast.makeText(SignIn.this, "vous avez oublier un champ", Toast.LENGTH_SHORT).show();
                }
            }
        });


        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        //  changeStatusBarColor();

        emailAdress.setPadding(0, 15, 0, 15);


        password1.setPadding(0, 15, 0, 15);
        /**
         ll_button1 = (LinearLayout) findViewById(R.id.ll_button1);
         ll_bottom1 = (LinearLayout) findViewById(R.id.ll_bottom1);
         ease1(ll_button1);
         ease21(ll_bottom1);*/


    }

    private void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess()) {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = result.getSignInAccount();
                firebaseAuthWithGoogle(account);
            } else {
                // Google Sign In failed, update UI appropriately
                // ...
            }
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    private void showProgress() {

    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());
        progressDialog = ProgressDialog.show(this, "Chargement...", "veuillez patienter...");
        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)

                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "signInWithCredential:onComplete:" + task.isSuccessful());
                        progressDialog.dismiss();
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "signInWithCredential", task.getException());
                            Toast.makeText(SignIn.this, "Echec lors de l'Authentification.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });


        /**
         * Making notification bar transparent
         */
        /**
         private void changeStatusBarColor () {
         if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
         Window window = getWindow();
         window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
         window.setStatusBarColor(Color.TRANSPARENT);
         }
         }*/

/**
 private void ease1 ( final View view){
 Easing easing1 = new Easing(1000);
 AnimatorSet animatorSet1 = new AnimatorSet();
 float fromYY = 900;
 float toYY = view.getTop();
 ValueAnimator valueAnimatorYY = ValueAnimator.ofFloat(fromYY, toYY);

 valueAnimatorYY.setEvaluator(easing1);

 valueAnimatorYY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
@Override public void onAnimationUpdate(ValueAnimator animation1) {
view.setTranslationY((float) animation1.getAnimatedValue());
}
});

 animatorSet1.playTogether(valueAnimatorYY);
 animatorSet1.setDuration(1000);
 animatorSet1.start();
 }
 private void ease21 ( final View view){
 Easing easing1 = new Easing(2000);
 AnimatorSet animatorSet1 = new AnimatorSet();
 float fromYY = 900;
 float toYY = view.getTop();
 ValueAnimator valueAnimatorYY = ValueAnimator.ofFloat(fromYY, toYY);

 valueAnimatorYY.setEvaluator(easing1);

 valueAnimatorYY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
@Override public void onAnimationUpdate(ValueAnimator animation1) {
view.setTranslationY((float) animation1.getAnimatedValue());
}
});

 animatorSet1.playTogether(valueAnimatorYY);
 animatorSet1.setDuration(1100);
 animatorSet1.start();
 }*/


    }
}