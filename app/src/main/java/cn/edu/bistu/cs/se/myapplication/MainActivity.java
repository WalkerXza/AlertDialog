package cn.edu.bistu.cs.se.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View v = getLayoutInflater().inflate(R.layout.login_dialog, null);
        final EditText userId = (EditText) v.findViewById(R.id.editText_userId);
        final EditText password = (EditText) v.findViewById(R.id.editText_password);
        Button button = (Button) findViewById(R.id.main_btn_login);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater = getLayoutInflater();

                builder.setView(v).setTitle("Login");

                builder.setPositiveButton("login",new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int id){
                        if(userId.getText().toString().equals("abc") && password.getText().toString().equals("123")){
                            Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_LONG).show();
                        }
                       else{
                            Toast.makeText(MainActivity.this,"登录失败",Toast.LENGTH_LONG).show();
                        }
                    }
                });

                builder.setNegativeButton("cancel",new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int id){
                        Toast.makeText(MainActivity.this,"用户按下了取消按钮",Toast.LENGTH_LONG).show();
                    }
                });
                builder.show();
            }
        });
    }
}