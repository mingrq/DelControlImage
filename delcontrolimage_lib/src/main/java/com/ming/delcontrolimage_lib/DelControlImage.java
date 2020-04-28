package com.ming.delcontrolimage_lib;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;

public class DelControlImage extends ViewGroup {
    private OnClickListener delOnClickListener;//删除点击监听
    private OnClickListener imgOnClickListener;//图片点击监听
    private ImageView ivImage;
    private View vBtnDel;

    public DelControlImage(Context context) {
        this(context, null);
    }

    public DelControlImage(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DelControlImage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.del_control_image_layout, this);
        ivImage = (ImageView) findViewById(R.id.iv_image);
        vBtnDel = (View) findViewById(R.id.v_btn_del);
        //initView();
       // initViewClick();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureChildren(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {
        final int width = getMeasuredWidth();
        Log.e("测试",String.valueOf(width));
        final int height = getMeasuredHeight();
        final int childLeft = getPaddingLeft();
        final int childTop = getPaddingTop();
        View child = getChildAt(0);
        child.layout(childLeft, childTop, width - getPaddingRight(), height - getPaddingBottom());
    }

    /**
     * 设置删除按钮点击监听
     *
     * @param delOnClickListener
     */
    public void setDelOnClickListener(@Nullable OnClickListener delOnClickListener) {
        this.delOnClickListener = delOnClickListener;
    }

    /**
     * 设置图片点击监听
     *
     * @param imgOnClickListener
     */
    public void setImgOnClickListener(@Nullable OnClickListener imgOnClickListener) {
        this.imgOnClickListener = imgOnClickListener;
    }

    private void initView() {
        ivImage = (ImageView) findViewById(R.id.iv_image);
        vBtnDel = (View) findViewById(R.id.v_btn_del);
    }

    private void initViewClick() {
        ivImage.setOnClickListener(imgOnClickListener);
        vBtnDel.setOnClickListener(delOnClickListener);
    }
}
