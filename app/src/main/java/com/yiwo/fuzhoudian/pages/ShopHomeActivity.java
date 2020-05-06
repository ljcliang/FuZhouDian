package com.yiwo.fuzhoudian.pages;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yiwo.fuzhoudian.R;
import com.yiwo.fuzhoudian.adapter.ShopHomeGoodsAdapter;
import com.yiwo.fuzhoudian.base.BaseActivity;
import com.yiwo.fuzhoudian.utils.StatusBarUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShopHomeActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_shop_home_tap1)
    TextView tvShopHomeTap1;
    @BindView(R.id.rl_shop_home_tap1)
    RelativeLayout rlShopHomeTap1;
    @BindView(R.id.tv_shop_home_tap2)
    TextView tvShopHomeTap2;
    @BindView(R.id.rl_shop_home_tap2)
    RelativeLayout rlShopHomeTap2;
    @BindView(R.id.tv_shop_home_tap3)
    TextView tvShopHomeTap3;
    @BindView(R.id.rl_shop_home_tap3)
    RelativeLayout rlShopHomeTap3;
    @BindView(R.id.tv_sousuo)
    TextView tvSousuo;
    @BindView(R.id.v1)
    View v1;
    @BindView(R.id.rl1)
    RelativeLayout rl1;
    @BindView(R.id.v2)
    View v2;
    @BindView(R.id.rl2)
    RelativeLayout rl2;
    @BindView(R.id.v3)
    View v3;
    @BindView(R.id.rl3)
    RelativeLayout rl3;
    @BindView(R.id.rv1)
    RecyclerView rv1;
    @BindView(R.id.rv2)
    RecyclerView rv2;
    @BindView(R.id.rv3)
    RecyclerView rv3;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    //标签卡也是否在顶部
    boolean tapOnTop = false;
    @BindView(R.id.ll_tab_bar)
    LinearLayout llTabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_home);
        StatusBarUtils.setStatusBarTransparent(ShopHomeActivity.this);
        ButterKnife.bind(this);
        appBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                Log.d("asdasd", appBarLayout.getHeight() + "////" + i);
                if(llTabBar.getHeight()-appBarLayout.getHeight()==i){
                    if (!tapOnTop){
                        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) llTabBar.getLayoutParams();
                        params.topMargin = 20 ;
                        llTabBar.setLayoutParams(params);
                    }
                    tapOnTop = true;
                }else {
                    if (tapOnTop){
                        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) llTabBar.getLayoutParams();
                        params.topMargin = 0 ;
                        llTabBar.setLayoutParams(params);
                    }
                    tapOnTop = false;
                }
            }
        });
        initRv();
    }

    private void initRv() {
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        ShopHomeGoodsAdapter adapter = new ShopHomeGoodsAdapter(list);
// /设置布局管理器为2列，纵向
        StaggeredGridLayoutManager mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        rv1.setLayoutManager(mLayoutManager);
        rv1.setAdapter(adapter);
    }

    public static void start(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, ShopHomeActivity.class);
        context.startActivity(intent);
    }

    @OnClick({R.id.iv_back, R.id.tv_shop_home_tap1, R.id.rl_shop_home_tap1, R.id.tv_shop_home_tap2, R.id.rl_shop_home_tap2, R.id.tv_shop_home_tap3, R.id.rl_shop_home_tap3, R.id.tv_sousuo, R.id.v1, R.id.rl1, R.id.v2, R.id.rl2, R.id.v3, R.id.rl3, R.id.rv1, R.id.rv2, R.id.rv3})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.iv_back:
                break;
            case R.id.tv_shop_home_tap1:
                break;
            case R.id.rl_shop_home_tap1:
                break;
            case R.id.tv_shop_home_tap2:
                break;
            case R.id.rl_shop_home_tap2:
                break;
            case R.id.tv_shop_home_tap3:
                break;
            case R.id.rl_shop_home_tap3:
                break;
            case R.id.tv_sousuo:
                break;
            case R.id.v1:
                break;
            case R.id.rl1:
                break;
            case R.id.v2:
                break;
            case R.id.rl2:
                break;
            case R.id.v3:
                break;
            case R.id.rl3:
                break;
            case R.id.rv1:
                break;
            case R.id.rv2:
                break;
            case R.id.rv3:
                break;
        }
    }
}
