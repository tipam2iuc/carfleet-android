package com.example.hp.carfleet;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

public class SignUp extends AppCompatActivity {

    private EditText confirmf, emailf, passwordf;

    Button registerf;
    LinearLayout ll_button, ll_bottom;


    private FirebaseAuth mAuth;
    private static final String TAG = "SignInActivity";
    private static final int RC_SIGN_IN = 0;

    private FirebaseAuth.AuthStateListener mAuthListener;
    private ImageView google_id1;
    private GoogleApiClient mGoogleApiClient;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(1);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
            setContentView(R.layout.activity_sign_up);
            FirebaseApp.initializeApp(this);

            mAuth = FirebaseAuth.getInstance();

            if (Build.VERSION.SDK_INT >= 21) {
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            }

            // changeStatusBarColor();
            registerf = (Button) findViewById(R.id.btn_sign_up);
            confirmf = (EditText) findViewById(R.id.repasswordFiled);
            confirmf.setPadding(0, 15, 0, 15);
            emailf = (EditText) findViewById(R.id.et_email);
            emailf.setPadding(0, 15, 0, 15);
            passwordf = (EditText) findViewById(R.id.et_password);
            passwordf.setPadding(0, 15, 0, 15);
            ll_button = (LinearLayout) findViewById(R.id.ll_button);
            ll_bottom = (LinearLayout) findViewById(R.id.ll_bottom);
            //  ease(ll_button);
            // ease2(ll_bottom);

            google_id1 = (ImageView) findViewById(R.id.google_id1);

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
                        Toast.makeText(SignUp.this, "Now you are logged In " + firebaseAuth.getCurrentUser().getEmail(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SignUp.this, MainActivity.class);
                        startActivity(intent);
                        finish();

                    }
                }
            };


            google_id1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    signIn();
                }
            });


            registerf.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String email = emailf.getText().toString();
                    String password = passwordf.getText().toString();
                    String confirm = confirmf.getText().toString();

                    if (!TextUtils.isEmpty(email) & !TextUtils.isEmpty(password) && !TextUtils.isEmpty(confirm)) {

                        if (password.equals(confirm)) {
                            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if (task.isSuccessful()) {
                                        startActivity(new Intent(SignUp.this, Drawer.class));
                                        finish();
                                    } else {
                                        Toast.makeText(SignUp.this, "Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });

                        } else {
                            Toast.makeText(SignUp.this, "Your password is not match", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Toast.makeText(SignUp.this, "All fileds are importantzz", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }


        /**
         * Making notification bar transparent
         */
        /** private void changeStatusBarColor() {
         if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
         Window window = getWindow();
         window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
         window.setStatusBarColor(Color.TRANSPARENT);
         }
         }
         private void ease(final View view) {
         Easing easing = new Easing(1000);
         AnimatorSet animatorSet = new AnimatorSet();
         float fromY = 600;
         float toY = view.getTop();
         ValueAnimator valueAnimatorY = ValueAnimator.ofFloat(fromY,toY);

         valueAnimatorY.setEvaluator(easing);

         valueAnimatorY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
        @Override public void onAnimationUpdate(ValueAnimator animation) {
        view.setTranslationY((float) animation.getAnimatedValue());
        }
        });

         animatorSet.playTogether(valueAnimatorY);
         animatorSet.setDuration(1000);
         animatorSet.start();
         }
         private void ease2(final View view) {
         Easing easing = new Easing(2000);
         AnimatorSet animatorSet = new AnimatorSet();
         float fromY = 900;
         float toY = view.getTop();
         ValueAnimator valueAnimatorY = ValueAnimator.ofFloat(fromY,toY);

         valueAnimatorY.setEvaluator(easing);

         valueAnimatorY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
        @Override public void onAnimationUpdate(ValueAnimator animation) {
        view.setTranslationY((float) animation.getAnimatedValue());
        }
        });

         animatorSet.playTogether(valueAnimatorY);
         animatorSet.setDuration(2000);
         animatorSet.start();
         }*/

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
        progressDialog = ProgressDialog.show(this, "Chargement...", "Veuillez patienter...");
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
                            Toast.makeText(SignUp.this, "echec lors de l'inscriptiom.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });


    }
}
