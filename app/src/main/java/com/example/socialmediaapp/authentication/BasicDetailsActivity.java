package com.example.socialmediaapp.authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.socialmediaapp.R;
import com.example.socialmediaapp.databinding.ActivityBasicDetailsBinding;
import com.example.socialmediaapp.models.UserModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class BasicDetailsActivity extends AppCompatActivity {
    ActivityBasicDetailsBinding binding;
    FirebaseAuth auth;
    FirebaseDatabase database;
    Intent intent;
    String useremail,password,name,profession,about,userid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityBasicDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // All Intialization of Instances

        auth=FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance("https://socialmediaapp-6d057-default-rtdb.asia-southeast1.firebasedatabase.app");

        //All Intialization of Instances ended
        setContinueButton();
    }

    private void setContinueButton() {
        intent=getIntent();
        useremail=intent.getStringExtra("useremail");
        password=intent.getStringExtra("password");
        binding.continuebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name=binding.nameeddittext.getText().toString().trim();
                profession=binding.professionedittext.getText().toString().trim();
                about=binding.aboutedittext.getText().toString().trim();
                authenticateUser(useremail,password,name,profession,about);
            }
        });
    }

    private void authenticateUser(String useremail, String password, String name, String profession, String about) {
        auth.createUserWithEmailAndPassword(useremail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    UserModel model=new UserModel(name,profession,useremail,about);
                    FirebaseUser user=task.getResult().getUser();
                    userid=user.getUid();
                    database.getReference().child("Users").child(userid).setValue(model);

                    Toast.makeText(BasicDetailsActivity.this, "Data Saved", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(BasicDetailsActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}