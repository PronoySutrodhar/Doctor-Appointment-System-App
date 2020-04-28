package com.example.ylogin;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText etsignUN,etsigninPass;
    Button signin;
    TextView signintextview;
    private FirebaseAuth mAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        this.setTitle("Sign In");
        etsignUN=findViewById(R.id.signinUN);
        progressBar=findViewById(R.id.progress);
        etsigninPass=findViewById(R.id.signinPass);
        signin=findViewById(R.id.signin);
        signintextview=findViewById(R.id.textviewregister);
        signintextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SignUp.class);
                startActivity(intent);

            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userSignin();

            }
        });
    }

    private void userSignin() {
        String email=etsignUN.getText().toString().trim();
        String password=etsigninPass.getText().toString().trim();
        if(email.isEmpty()){
            etsignUN.setError("insert Email");
            etsignUN.requestFocus();
            return;

        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            etsignUN.setError("Insert valid Email");
            etsignUN.requestFocus();
            return;

        }

        if(password.isEmpty()){
            etsigninPass.setError("insert Email");
            etsigninPass.requestFocus();
            return;

        }

        if(password.length()<6){
            etsigninPass.setError("password too smaller");
            etsigninPass.requestFocus();
            return;

        }
        progressBar.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBar.setVisibility(View.GONE);
                        if (task.isSuccessful()) {
                            finish();
                            Intent intent=new Intent(MainActivity.this,Second.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this, "Sign In Failed", Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
        etsignUN.setText("");
        etsigninPass.setText("");
    }
}
