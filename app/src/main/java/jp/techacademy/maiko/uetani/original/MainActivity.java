package jp.techacademy.maiko.uetani.original;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.firebase.client.Firebase;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mEditText01;
    EditText mEditText02;
    EditText mEditText03;
    EditText mEditText04;
    EditText mEditText05;
    EditText mEditText06;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //ボタン取得
        Button button01 = (Button) findViewById(R.id.button01);
        Button button02 = (Button) findViewById(R.id.button02);


        //リスナー登録
        button01.setOnClickListener(this);
        button02.setOnClickListener(this);

        //エディットの取得
        mEditText01 = (EditText) findViewById(R.id.editText01);
        mEditText01.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        mEditText02 = (EditText) findViewById(R.id.editText02);
        mEditText02.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        mEditText03 = (EditText) findViewById(R.id.editText03);
        mEditText03.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        mEditText04 = (EditText) findViewById(R.id.editText04);
        mEditText04.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        mEditText05 = (EditText) findViewById(R.id.editText05);
        mEditText05.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        mEditText06 = (EditText) findViewById(R.id.editText06);
        mEditText06.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
    }

    @Override
    public void onClick(View v) {
//        Intent intent01 = new Intent(this, timechartActivity.class);
//        Intent intent02 = new Intent(this, lastchartActivity.class);
        if (mEditText01.getText().toString().equals("")) {
            Toast.makeText(this, "数字が未入力です", Toast.LENGTH_SHORT).show();
            return;
        }
        if (mEditText02.getText().toString().equals("")) {
            Toast.makeText(this, "数字が未入力です", Toast.LENGTH_SHORT).show();
            return;
        }
        if (v.getId() == R.id.button01) {
            double a = Double.valueOf(mEditText01.getText().toString());
            double b = Double.valueOf(mEditText03.getText().toString());
            double c = Double.valueOf(mEditText05.getText().toString());
            double x = 5 * a + 4 * b + 3 * c;

            Firebase.setAndroidContext(this);
            Firebase FirebaseRef = new Firebase("https://original-cb66c.firebaseio.com/");
            FirebaseRef.child("alastdata").setValue(x);
            // インテントの生成
            Intent intent = new Intent(this, timechartActivity.class);
            // SubActivity の起動
            startActivity(intent);


//            Firebase.setAndroidContext(this);
//            Firebase FirebaseRef = new Firebase("https://original-cb66c.firebaseio.com/");
//            FirebaseRef.child("timedata").setValue(x);
        }
//        if (v.getId() == R.id.button02) {
//            double a = Double.valueOf(mEditText01.getText().toString());
//            double b = Double.valueOf(mEditText03.getText().toString());
//            double c = Double.valueOf(mEditText05.getText().toString());
//            double d = Double.valueOf(mEditText02.getText().toString());
//            double e = Double.valueOf(mEditText04.getText().toString());
//            double f = Double.valueOf(mEditText06.getText().toString());
//
//            double y = 5 * a * d + 4 * b * e + 3 * c * f;
//
//
//            Firebase.setAndroidContext(this);
//            Firebase FirebaseRef = new Firebase("https://original-cb66c.firebaseio.com/");
//            FirebaseRef.child("alastdata").setValue(y);
//            // インテントの生成
//            Intent intent = new Intent(this, timechartActivity.class);
//            // SubActivity の起動
//            startActivity(intent);



    }

}

