package com.teamwork.businessguideprofortiktok.src.models.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;


class CanVasBoder extends View {
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);


    public CanVasBoder(Context context) {
        super(context);
        init();
    }

    public CanVasBoder(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CanVasBoder(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public CanVasBoder(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){
        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(160); //the width you want
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path mPath;
        mPath = new Path();
        mPath.moveTo(0, 0);
        mPath.cubicTo(60, 60, getWidth()/2, -80, getWidth(), 10); /*the anchors you want, the curve will tend to reach these anchor points; look at the wikipedia article to understand more */
        canvas.drawPath(mPath, paint);

    }
}
