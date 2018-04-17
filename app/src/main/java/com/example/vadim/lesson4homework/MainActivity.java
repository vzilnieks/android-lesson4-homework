package com.example.vadim.lesson4homework;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  static final String STATE_NUMBER = "STATE_NUMBER";

  public int savedNumber = 0;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

  }

  public void onClick(View view) {
    EditText edit_text = findViewById(R.id.edit_text);
    savedNumber = Integer.parseInt(edit_text.getText().toString());
    Toast toast = Toast.makeText(getApplicationContext(),"Number saved:" + savedNumber, Toast.LENGTH_SHORT);
    toast.show();
  }

  public void onNewWindow(View view) {
    Intent intent = new Intent(this, NewActivity.class);
    intent.putExtra("NEW_KEY",this.savedNumber);
    startActivity(intent);
  }

  @Override
  public void onSaveInstanceState(Bundle outState) {
    outState.putInt(STATE_NUMBER, savedNumber);
    super.onSaveInstanceState(outState);
  }

  @Override
  public void onRestoreInstanceState(Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
    savedNumber = savedInstanceState.getInt(STATE_NUMBER);
  }

  @Override
  public boolean onKeyDown(int keyCode, KeyEvent event) {
    if (keyCode == KeyEvent.KEYCODE_BACK) {
      Toast toast = Toast.makeText(getApplicationContext(), "Hello World!", Toast.LENGTH_SHORT);
      toast.show();
      return true;
    }

    return super.onKeyDown(keyCode, event);
  }

  public void onShow(View view) {
    TextView textView = (TextView) findViewById(R.id.numberView);
    textView.setText("" + savedNumber);
  }
}
