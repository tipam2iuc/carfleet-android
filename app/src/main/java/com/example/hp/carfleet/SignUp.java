package com.example.hp.carfleet;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
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


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {

    private EditText confirmf, emailf, passwordf;

    Button registerf;
    LinearLayout ll_button, ll_bottom;


    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        FirebaseApp.initializeApp(this);

        mAuth = FirebaseAuth.getInstance();

        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        changeStatusBarColor();
        registerf= (Button)findViewById(R.id.btn_sign_up);
        confirmf = (EditText) findViewById(R.id.repasswordFiled);
        confirmf.setPadding(0,15,0,15);
        emailf = (EditText) findViewById(R.id.et_email);
        emailf.setPadding(0,15,0,15);
        passwordf = (EditText) findViewById(R.id.et_password);
        passwordf.setPadding(0,15,0,15);
        ll_button = (LinearLayout) findViewById(R.id.ll_button);
        ll_bottom = (LinearLayout) findViewById(R.id.ll_bottom);
        ease(ll_button);
        ease2(ll_bottom);




        registerf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = emailf.getText().toString();
                String password = passwordf.getText().toString();
                String confirm = confirmf.getText().toString();

                if(!TextUtils.isEmpty(email)&!TextUtils.isEmpty(password)&&!TextUtils.isEmpty(confirm)){

                    if(password.equals(confirm)){
                        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if(task.isSuccessful()){
                                    startActivity(new Intent(SignUp.this,Drawer.class));
                                    finish();
                                }else {
                                    Toast.makeText(SignUp.this,"Error: "+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                                }

                            }
                        });

                    }else {
                        Toast.makeText(SignUp.this,"Your password is not match",Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(SignUp.this,"All fileds are importantzz",Toast.LENGTH_SHORT).show();
                }

            }
        });
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
    private void ease(final View view) {
        Easing easing = new Easing(1000);
        AnimatorSet animatorSet = new AnimatorSet();
        float fromY = 600;
        float toY = view.getTop();
        ValueAnimator valueAnimatorY = ValueAnimator.ofFloat(fromY,toY);

        valueAnimatorY.setEvaluator(easing);

        valueAnimatorY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
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
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                view.setTranslationY((float) animation.getAnimatedValue());
            }
        });

        animatorSet.playTogether(valueAnimatorY);
        animatorSet.setDuration(2000);
        animatorSet.start();
    }

}
