package com.example.intentfilterpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText email;
    private EditText cc;
    private EditText content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button1);
        email=findViewById(R.id.edittextgmail);
        cc=findViewById(R.id.edittextcc);
        content=findViewById(R.id.edittextcontent);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent click=new Intent(Intent.ACTION_VIEW);
                click.setType("text/plain");
                click.putExtra(Intent.EXTRA_SUBJECT,"email subject");
                click.putExtra(Intent.EXTRA_CC,new String[]{"thakurreeta1995@gmail.com","bookstore.shivi@gmail.com"});
                click.putExtra(Intent.EXTRA_TEXT,"Hi reeta are you ok");
                PackageManager packageManager=getPackageManager();
                List<ResolveInfo> list=packageManager.queryIntentActivities(click,0);
                if(list !=null && list.size()>=1){
                    startActivity(click);
                }else{
                    Toast.makeText(MainActivity.this,"No app found",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}