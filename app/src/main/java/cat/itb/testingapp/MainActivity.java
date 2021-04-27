package cat.itb.testingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.IllegalFormatCodePointException;

public class MainActivity extends AppCompatActivity {

    public  static  String USER_TO_BE_TYPED = "pau";
    public  static String PASS_TO_BE_TYPED = "pau";
    EditText username;
    EditText password;
    Button button;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().length() != 0 && password.getText().length() != 0){
                    button.setText("LOGGED");
                    Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                    intent.putExtra("username", username.getText().toString());
                    startActivity(intent);
                }else {
                    button.setText("BACK");
                    Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                //    intent.putExtra("username", username.getText());
                    startActivity(intent);
                }

            }
        });
    }
}