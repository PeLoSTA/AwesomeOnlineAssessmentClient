package de.peterloos.onlineassessmentprototype.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import de.peterloos.onlineassessmentprototype.Globals;
import de.peterloos.onlineassessmentprototype.R;

public class MainActivity extends AppCompatActivity {

    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        // retrieve control references
        this.button = this.findViewById(R.id.buttonLogIn);

        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent demoIntent = new Intent(getApplicationContext(), ActivityChooseExam.class);
                startActivity(demoIntent);
            }
        });
    }
}
