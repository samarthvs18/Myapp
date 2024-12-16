package com.example.myapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProfileActivity extends AppCompatActivity {

    TextView completedWorkoutsTextView, upcomingWorkoutsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        completedWorkoutsTextView = findViewById(R.id.textViewCompletedWorkouts);
        upcomingWorkoutsTextView = findViewById(R.id.textViewUpcomingWorkouts);

        String completedWorkouts = "Completed Workouts:\n\n" +
                "1. Push Ups - 3 Sets of 15\n" +
                "2. Squats - 3 Sets of 20\n" +
                "3. Running - 30 Minutes\n";

        String upcomingWorkouts = "Upcoming Workouts:\n\n" +
                "1. Pull Ups - 3 Sets of 12\n" +
                "2. Deadlifts - 3 Sets of 10\n" +
                "3. Jump Rope - 15 Minutes";

        completedWorkoutsTextView.setText(completedWorkouts);
        upcomingWorkoutsTextView.setText(upcomingWorkouts);

    }
}