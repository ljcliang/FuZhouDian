package com.yiwo.fuzhoudian.utils;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.text.Layout;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.yiwo.fuzhoudian.widget.CustomRoundAngleImageView;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCartUntils {
    private static PathMeasure mPathMeasure;
    /**
     * 贝塞尔曲线中间过程的点的坐标
     */
    private static float[] mCurrentPosition = new float[2];

    /**
     * 添加到购物车
     *ivProductIcon 商品图片
     * ivGotoGouWuChe 购物车图片
     * @param ivProductIcon
     */
    public static void add2Cart(ImageView ivProductIcon, ImageView ivGotoGouWuChe, Context context, final RelativeLayout llContainer) {

        // 一、创建执行动画的主题---ImageView(该图片就是执行动画的图片，从开始位置出发，经过一个抛物线（贝塞尔曲线）。)
        final CustomRoundAngleImageView imageView = new CustomRoundAngleImageView(context);
        imageView.setImageDrawable(ivProductIcon.getDrawable());
        // 将执行动画的图片添加到开始位置。
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(50, 50);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        llContainer.addView(imageView, params);


        // 二、计算动画开始/结束点的坐标的准备工作
        // 得到父布局的起始点坐标（用于辅助计算动画开始/结束时的点的坐标）
        int[] parentLocation = new int[2];
        llContainer.getLocationInWindow(parentLocation);
        // 得到商品图片的坐标（用于计算动画开始的坐标）
        int[] startLoc = new int[2];
        ivProductIcon.getLocationInWindow(startLoc);
        // 得到购物车图片的坐标(用于计算动画结束后的坐标)
        int[] endLoc = new int[2];
        ivGotoGouWuChe.getLocationInWindow(endLoc);

        // 三、计算动画开始结束的坐标
        // 开始掉落的商品的起始点：商品起始点-父布局起始点+该商品图片的一半
        float startX = startLoc[0] - parentLocation[0] + ivProductIcon.getWidth() / 2;
        float startY = startLoc[1] - parentLocation[1] + ivProductIcon.getHeight() / 2;
        //商品掉落后的终点坐标：购物车起始点-父布局起始点+购物车图片的1/5
        float toX = endLoc[0] - parentLocation[0] + ivGotoGouWuChe.getWidth() / 5;
        float toY = endLoc[1] - parentLocation[1];

        // 四、计算中间动画的插值坐标（贝塞尔曲线）（其实就是用贝塞尔曲线来完成起终点的过程）
        //开始绘制贝塞尔曲线
        Path path = new Path();
        //移动到起始点（贝塞尔曲线的起点）
        path.moveTo(startX, startY);
        //使用二次萨贝尔曲线：注意第一个起始坐标越大，贝塞尔曲线的横向距离就会越大，一般按照下面的式子取即可
        path.quadTo((startX + toX) / 2, startY, toX, toY);
        //mPathMeasure用来计算贝塞尔曲线的曲线长度和贝塞尔曲线中间插值的坐标，
        // 如果是true，path会形成一个闭环
        mPathMeasure = new PathMeasure(path, false);

        //★★★属性动画实现（从0到贝塞尔曲线的长度之间进行插值计算，获取中间过程的距离值）
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, mPathMeasure.getLength());
        valueAnimator.setDuration(500);
        // 匀速线性插值器
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                // 当插值计算进行时，获取中间的每个值，
                // 这里这个值是中间过程中的曲线长度（下面根据这个值来得出中间点的坐标值）
                float value = (Float) animation.getAnimatedValue();
                // ★★★★★获取当前点坐标封装到mCurrentPosition
                // boolean getPosTan(float distance, float[] pos, float[] tan) ：
                // 传入一个距离distance(0<=distance<=getLength())，然后会计算当前距
                // 离的坐标点和切线，pos会自动填充上坐标，这个方法很重要。
                mPathMeasure.getPosTan(value, mCurrentPosition, null);//mCurrentPosition此时就是中间距离点的坐标值
                // 移动的商品图片（动画图片）的坐标设置为该中间点的坐标
                imageView.setTranslationX(mCurrentPosition[0]);
                imageView.setTranslationY(mCurrentPosition[1]);
            }
        });
        //  五、 开始执行动画
        valueAnimator.start();
        //  六、动画结束后的处理
        valueAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }
            //当动画结束后：
            @Override
            public void onAnimationEnd(Animator animation) {
                // 购物车的数量加1
                // 把移动的图片imageview从父布局里移除
                llContainer.removeView(imageView);
            }
            @Override
            public void onAnimationCancel(Animator animation) {
            }
            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
    }
}
