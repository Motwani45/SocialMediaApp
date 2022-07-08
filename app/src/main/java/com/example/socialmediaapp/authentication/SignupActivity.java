package com.example.socialmediaapp.authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.socialmediaapp.R;
import com.example.socialmediaapp.databinding.ActivitySignupBinding;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {
    ActivitySignupBinding binding;
    String useremail,password;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // All Intialization of Instances

        auth=FirebaseAuth.getInstance();


        //All Intialization of Instances ended
        setSignUpButton();
        binding.haveaccounttextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SignupActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void setSignUpButton() {
    binding.signupbutton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            useremail=binding.emaileddittextsignup.getText().toString().trim();
            password=binding.passwordeddittextsignup.getText().toString().trim();
            boolean iscorrect = true;
            if (!useremail.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                    + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
                binding.emaileddittextsignup.setError("Incorrect Format of Email Id");
                iscorrect = false;
            }
            if (password.length() < 8) {
                binding.passwordeddittextsignup.setError("Please enter a password of atleast 8 characters long");
                iscorrect = false;
            }
            if(iscorrect){
                Intent intent=new Intent(SignupActivity.this,BasicDetailsActivity.class);
                intent.putExtra("useremail",useremail);
                intent.putExtra("password",password);
                startActivity(intent);
            }
            else{
                Toast.makeText(SignupActivity.this, "Email and Password are invalid", Toast.LENGTH_SHORT).show();
            }
        }
    });

    }
}