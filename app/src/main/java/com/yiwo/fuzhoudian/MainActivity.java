package com.yiwo.fuzhoudian;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.yiwo.fuzhoudian.base.BaseActivity;
import com.yiwo.fuzhoudian.fragments.HomeFragment;
import com.yiwo.fuzhoudian.fragments.MessageFragment;
import com.yiwo.fuzhoudian.fragments.MineFragment;
import com.yiwo.fuzhoudian.fragments.OrderFragment;

import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @BindView(R.id.iv_bottom_1)
    ImageView ivBottom1;
    @BindView(R.id.ll_btn_1)
    LinearLayout llBtn1;
    @BindView(R.id.iv_bottom_2)
    ImageView ivBottom2;
    @BindView(R.id.ll_btn_2)
    LinearLayout llBtn2;
    @BindView(R.id.iv_bottom_3)
    ImageView ivBottom3;
    @BindView(R.id.ll_btn_3)
    LinearLayout llBtn3;
    @BindView(R.id.iv_bottom_4)
    ImageView ivBottom4;
    @BindView(R.id.ll_btn_4)
    LinearLayout llBtn4;
    @BindView(R.id.iv_bottom_5)
    ImageView ivBottom5;
    @BindView(R.id.ll_btn_5)
    LinearLayout llBtn5;
    @BindView(R.id.tv_bottom_1)
    TextView tvBottom1;
    @BindView(R.id.tv_bottom_2)
    TextView tvBottom2;
    @BindView(R.id.tv_bottom_3)
    TextView tvBottom3;
    @BindView(R.id.tv_bottom_4)
    TextView tvBottom4;
    @BindView(R.id.tv_bottom_5)
    TextView tvBottom5;
    @BindView(R.id.fl_container)
    FrameLayout flContainer;
    private long exitTime = 0;

    private List<Fragment> fragmentList = new ArrayList<>();
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

    HomeFragment homeFragment;
    MessageFragment messageFragment;
    MineFragment mineFragment;
    OrderFragment orderFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initFragment();
    }

    private void initFragment() {
        homeFragment = new HomeFragment();
        orderFragment = new OrderFragment();
        messageFragment = new MessageFragment();
        mineFragment = new MineFragment();

        fragmentList.add(homeFragment);
        fragmentList.add(orderFragment);
        fragmentList.add(messageFragment);
        fragmentList.add(mineFragment);

        fragmentTransaction.add(R.id.fl_container, homeFragment);
        fragmentTransaction.add(R.id.fl_container, orderFragment);
        fragmentTransaction.add(R.id.fl_container, messageFragment);
        fragmentTransaction.add(R.id.fl_container, mineFragment);
        fragmentTransaction.show(homeFragment).hide(orderFragment).hide(messageFragment).hide(mineFragment);
        fragmentTransaction.commit();
        select(0);
    }

    /**
     * 选择隐藏与显示的Fragment
     *
     * @param index 显示的Frgament的角标
     */
    public void switchFragment(int index) {
        select(index);
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        for (int i = 0; i < fragmentList.size(); i++) {
            if (index == i) {
                fragmentTransaction.show(fragmentList.get(index));
            } else {
                fragmentTransaction.hide(fragmentList.get(i));
            }
        }
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        backtrack();
    }

    /**
     * 退出销毁所有activity
     */
    private void backtrack() {
        if (System.currentTimeMillis() - exitTime > 2000) {
            Toast.makeText(MainActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            MyApplication.getInstance().exit();
            exitTime = 0;
        }
    }
    public void select(int i) {
        tvBottom1.setSelected(false);
        tvBottom2.setSelected(false);
        tvBottom4.setSelected(false);
        tvBottom5.setSelected(false);
        ivBottom1.setSelected(false);
        ivBottom2.setSelected(false);
        ivBottom4.setSelected(false);
        ivBottom5.setSelected(false);
        switch (i){
            case 0:
                tvBottom1.setSelected(true);
                ivBottom1.setSelected(true);
                break;
            case 1:
                tvBottom2.setSelected(true);
                ivBottom2.setSelected(true);
                break;
            case 2:
                tvBottom4.setSelected(true);
                ivBottom4.setSelected(true);
                break;
            case 3:
                tvBottom5.setSelected(true);
                ivBottom5.setSelected(true);
                break;
        }
    }
    @OnClick({R.id.ll_btn_1, R.id.ll_btn_2, R.id.ll_btn_3, R.id.ll_btn_4, R.id.ll_btn_5})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.ll_btn_1:
                switchFragment(0);
                break;
            case R.id.ll_btn_2:
                switchFragment(1);
                break;
            case R.id.ll_btn_3:
                switchFragment(0);
                break;
            case R.id.ll_btn_4:
                switchFragment(2);
                break;
            case R.id.ll_btn_5:
                switchFragment(3);
                break;
        }
    }
}
