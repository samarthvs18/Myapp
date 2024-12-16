package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class UserDetailsActivity extends AppCompatActivity {

    EditText ageInput, heightInput, weightInput;
    Button nextButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ageInput = findViewById(R.id.editTextAge);
        heightInput = findViewById(R.id.editTextHeight);
        weightInput = findViewById(R.id.editTextWeight);
        nextButton = findViewById(R.id.buttonNext);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String age = ageInput.getText().toString();
                String height = heightInput.getText().toString();
                String weight = weightInput.getText().toString();

                if (!age.isEmpty() && !height.isEmpty() && !weight.isEmpty()) {
                    Toast.makeText(UserDetailsActivity.this, "Details Saved", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(UserDetailsActivity.this, WorkoutActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(UserDetailsActivity.this, "Please Fill All Details", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}