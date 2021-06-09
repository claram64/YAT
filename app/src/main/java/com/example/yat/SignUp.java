package com.example.yat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

import org.jetbrains.annotations.NotNull;

public class SignUp extends AppCompatActivity {

    EditText email, password;
    Button signUpBtn;
    Button logInBtn;
    FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        email=findViewById(R.id.email_edt_text);
        password=findViewById(R.id.pass_edt_text);
        signUpBtn=findViewById(R.id.signUpBtn);
        logInBtn=findViewById(R.id.signUp_to_LogInBtn);

        fAuth= FirebaseAuth.getInstance();

        //check if user already logged in
        if(fAuth.getCurrentUser()!=null)
        {
            startActivity(new Intent(getApplicationContext(),MainActivity.class));//Cred ca aici la gallery ar terbui sa mearga dupa ce e signed up da las main mai intai nush sigur daca asta e contextul care trebuie
            finish();
        }

        signUpBtn.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                String eml=email.getText().toString() .trim();
                String pss=password.getText().toString().trim();

                //validate the data
                if(TextUtils.isEmpty(eml)){
                    email.setError("Email is required");
                }
                if(TextUtils.isEmpty(pss)){
                    password.setError("Password is required");
                }

                if(pss.length()<6){
                    password.setError("Password must be at least 6 characters long");
                }


                //Authenticate the user:

                fAuth.signInWithEmailAndPassword(eml,pss).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(SignUp.this,"User created",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),SignUp.class));//nush sigur daca asta e contextul care trebuie
                        }else
                        {
                            Toast.makeText(SignUp.this, "Error!"+task.getException().getMessage(),Toast.LENGTH_SHORT ).show();

                        }
                    }
                });
            }
        }

        );

    }
}