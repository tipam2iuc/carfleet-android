package com.example.hp.carfleet;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static com.example.hp.carfleet.BuildConfig.APPLICATION_ID;

public class SignIn extends AppCompatActivity {
    EditText  password1;
    TextView mp_oublie ;
    TextView insciption ;


    LinearLayout ll_button1, ll_bottom1;

    //firebase variable
    private EditText emailAdress;
    private Button signin1;

    //firebasem auth
   private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        //firebase login
        password1 = (EditText) findViewById(R.id.et_password1);
        emailAdress = (EditText) findViewById(R.id.et_email1);
        signin1 = (Button) findViewById(R.id.btn_sign_up1);
        mp_oublie=(TextView) findViewById(R.id.mp_oublie);

        mp_oublie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignIn.this, reset_password.class));
            }
        });

        insciption=(TextView) findViewById(R.id.inscrire);
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

                if(!TextUtils.isEmpty(email)&&!TextUtils.isEmpty(Pass)){
                    mAuth.signInWithEmailAndPassword(email,Pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                startActivity(new Intent(SignIn.this,Drawer.class));
                                finish();
                            }else {
                                Toast.makeText(SignIn.this,"Error: "+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }else {
                    Toast.makeText(SignIn.this,"vous avez oublier un champ",Toast.LENGTH_SHORT).show();
                }
            }
        });



        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        changeStatusBarColor();

        emailAdress.setPadding(0,15,0,15);


        password1.setPadding(0,15,0,15);
        ll_button1 = (LinearLayout) findViewById(R.id.ll_button1);
        ll_bottom1 = (LinearLayout) findViewById(R.id.ll_bottom1);
        ease1(ll_button1);
        ease21(ll_bottom1);





    }
    /**
     * Making notification bar transparent
     */
    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }


    private void ease1(final View view) {
        Easing easing1 = new Easing(1000);
        AnimatorSet animatorSet1 = new AnimatorSet();
        float fromYY = 900;
        float toYY = view.getTop();
        ValueAnimator valueAnimatorYY = ValueAnimator.ofFloat(fromYY,toYY);

        valueAnimatorYY.setEvaluator(easing1);

        valueAnimatorYY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation1) {
                view.setTranslationY((float) animation1.getAnimatedValue());
            }
        });

        animatorSet1.playTogether(valueAnimatorYY);
        animatorSet1.setDuration(1000);
        animatorSet1.start();
    }
    private void ease21(final View view) {
        Easing easing1 = new Easing(2000);
        AnimatorSet animatorSet1 = new AnimatorSet();
        float fromYY = 900;
        float toYY = view.getTop();
        ValueAnimator valueAnimatorYY = ValueAnimator.ofFloat(fromYY,toYY);

        valueAnimatorYY.setEvaluator(easing1);

        valueAnimatorYY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation1) {
                view.setTranslationY((float) animation1.getAnimatedValue());
            }
        });

        animatorSet1.playTogether(valueAnimatorYY);
        animatorSet1.setDuration(1100);
        animatorSet1.start();
    }



}