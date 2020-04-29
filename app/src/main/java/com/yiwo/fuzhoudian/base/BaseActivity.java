package com.yiwo.fuzhoudian.base;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import com.yiwo.fuzhoudian.MyApplication;
import com.yiwo.fuzhoudian.R;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        MyApplication.getInstance().addActivity(this);
    }
    public void toToast(Context c, String content){
        Toast.makeText(c,content,Toast.LENGTH_SHORT).show();
    }
    public void toDialog(Context context, String title, String message, DialogInterface.OnClickListener listener, DialogInterface.OnClickListener listener1){
        AlertDialog.Builder normalDialog = new AlertDialog.Builder(context);
//        normalDialog.setIcon(R.mipmap.ic_launcher);
        normalDialog.setTitle(title);
        normalDialog.setMessage(message);
        normalDialog.setPositiveButton("确 定", listener);
        normalDialog.setNegativeButton("取消", listener1);
        // 显示
        normalDialog.show();
    }
}
