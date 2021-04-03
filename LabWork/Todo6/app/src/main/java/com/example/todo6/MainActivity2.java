package com.example.Todo6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.Todo6.R;

public class MainActivity2 extends AppCompatActivity {
    public static final String EXTRA_REPLY = "com.example.Todo6";
    private EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editText2 = (EditText) findViewById(R.id.reply);

        Intent intent = getIntent();
        String message = intent.getStringExtra(com.example.Todo6.MainActivity.EXTRA_MESSAGE);
        TextView textView = (TextView)findViewById(R.id.textView4);
        textView.setText(message);
    }

    public void reply(View view) {
        String reply = editText2.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}