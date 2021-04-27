package cat.itb.testingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
        Button buttonSecondActivity;
        TextView textView2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        Bundle extras = getIntent().getExtras();
        String user = extras.getString("username");

        buttonSecondActivity = findViewById(R.id.buttonSecondActivity);
        textView2 = findViewById(R.id.textView2);

        textView2.setText("Welcome back "+ user);

        buttonSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
