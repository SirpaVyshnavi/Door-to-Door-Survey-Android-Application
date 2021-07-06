package com.example.dell.doortodoorsurvey;

 import android.annotation.SuppressLint;
 import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter =5;

    //@SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText)findViewById(R.id.stname);

        Password = (EditText)findViewById(R.id.etPassword);
        Info = (TextView) findViewById(R.id.tvinfo);
        Login = (Button)findViewById(R.id.btnLogin);

        Info.setText("No of attempts:5");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(),Password.getText().toString());

            }
        });

    }
    private void validate(String userName, String userPassword){
        if((userName.equals("admin")) && (userPassword.equals("1234"))) {
            // String message;
            // message = "Welcome User!";
            Intent intent = new Intent(MainActivity.this, MapsActivity.class);
            // Here I am trying to put the second page
            // intent.putExtra("user",Name.getText().toString());
            // intent.putExtra("desig",message.toString());


            startActivity(intent);
            Toast.makeText(getApplicationContext(), "Welcome User!",
                    Toast.LENGTH_SHORT).show();

        } else{
            counter--;

            Info.setText("No of attempts:" + String.valueOf(counter));

            if (counter==0){
                Login.setEnabled(false);
            }
        }
    }
}

