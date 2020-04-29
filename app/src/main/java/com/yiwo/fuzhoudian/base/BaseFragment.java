package com.yiwo.fuzhoudian.base;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.widget.Toast;


public class BaseFragment extends Fragment {

    public void toToast(Context c, String content) {
        Toast.makeText(c, content, Toast.LENGTH_SHORT).show();
    }
    public void toDialog(Context context, String title, String message, DialogInterface.OnClickListener listener, DialogInterface.OnClickListener listener1){
        AlertDialog.Builder normalDialog = new AlertDialog.Builder(context);
//        normalDialog.setIcon(R.mipmap.ic_launcher);
        normalDialog.setTitle(title);
        normalDialog.setMessage(message);
        normalDialog.setPositiveButton("确定", listener);
        normalDialog.setNegativeButton("取消", listener1);
        // 显示
        normalDialog.show();
    }
}
