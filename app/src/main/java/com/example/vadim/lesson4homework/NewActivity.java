package com.example.vadim.lesson4homework;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity {

  public int savedData;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.savedData = getIntent().getIntExtra("NEW_KEY", 0);
    setContentView(R.layout.activity_new);
    TextView textView = (TextView) findViewById(R.id.saved_number);
    textView.setText("" + this.savedData);
  }
}
