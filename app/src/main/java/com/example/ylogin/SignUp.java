package com.example.ylogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class SignUp extends AppCompatActivity {
    EditText etsignupUN,etsignupPass;
    Button signup;
    private FirebaseAuth mAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        this.setTitle("Sign Up");
        mAuth = FirebaseAuth.getInstance();
        etsignupPass=findViewById(R.id.signupPass);
        etsignupUN=findViewById(R.id.signupUN);
        signup=findViewById(R.id.signup);
        progressBar=findViewById(R.id.progress);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Register();
            }
        });
    }

    public void Register() {
        String email=etsignupUN.getText().toString().trim();
        String password=etsignupPass.getText().toString().trim();
        if(email.isEmpty()){
            etsignupUN.setError("insert Email");
            etsignupUN.requestFocus();
            return;

        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            etsignupUN.setError("Insert valid Email");
            etsignupUN.requestFocus();
            return;

        }

        if(password.isEmpty()){
            etsignupPass.setError("insert Email");
            etsignupPass.requestFocus();
            return;

        }

        if(password.length()<6){
            etsignupPass.setError("password too smaller");
            etsignupPass.requestFocus();
            return;

        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBar.setVisibility(View.GONE);
                        if (task.isSuccessful()) {
                            finish();;
                            Intent intent =new Intent(SignUp.this,MainActivity.class);
                            startActivity(intent);
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_SHORT).show();

                        } else {

                            if(task.getException() instanceof FirebaseAuthUserCollisionException){
                                Toast.makeText(SignUp.this, "Email is already register", Toast.LENGTH_SHORT).show();

                            }else{

                                Toast.makeText(SignUp.this, "Error :"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }

                        // ...
                    }
                });
        etsignupUN.setText("");
        etsignupPass.setText("");

    }
}

