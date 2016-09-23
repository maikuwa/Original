package jp.techacademy.maiko.uetani.original;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class lastchartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lastchart);
        Intent intent = getIntent();
        double value2 = intent.getDoubleExtra("value2" , 0);
        TextView textView02 = (TextView) findViewById(R.id.textView02);
        textView02.setText(String.valueOf(value2));



    }
}
