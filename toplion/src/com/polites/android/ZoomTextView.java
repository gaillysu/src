package com.polites.android;

import android.content.Context;
import android.util.AttributeSet;
import android.util.FloatMath;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

public class ZoomTextView extends TextView
{
	
	// -----------------------------------------------
	private static final int NONE = 0;// 空
	private static final int DRAG = 1;// 按下第一个点
	private static final int ZOOM = 2;// 按下第二个点

	/** 屏幕上点的数量 */
	private int mode = NONE;

	/** 记录按下第二个点距第一个点的距离 */
	float oldDist;

	/**最小字体*/
	public static final float MIN_TEXT_SIZE = 10f;
	
	/**最大子图*/
	public static final float MAX_TEXT_SIZE = 100.0f;

	/** 缩放比例 */
	float scale;

	/** 设置字体大小 */
	float textSize;
	
	
	public ZoomTextView(Context context, AttributeSet attrs) 
	{
		super(context, attrs);
		this.scale = 0.5f;
		textSize = getTextSize();
	}
	public ZoomTextView(Context context)
	{
		super(context);
		this.scale = 0.5f;
		textSize = getTextSize();
	}

	
	private float spacing(MotionEvent event)
	{
		float x = event.getX(0) - event.getX(1);
		float y = event.getY(0) - event.getY(1);
		return FloatMath.sqrt(x * x + y * y);
	}
	
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub

		switch (event.getAction() & MotionEvent.ACTION_MASK)
		{
		case MotionEvent.ACTION_DOWN:
			mode = DRAG;
			break;		
		case MotionEvent.ACTION_UP:
		case MotionEvent.ACTION_POINTER_UP:
			mode = NONE;
			break;
		case MotionEvent.ACTION_POINTER_DOWN:
			oldDist = spacing(event);
			if (oldDist > 10f)
			{
				mode = ZOOM;
			}
			break;
		case MotionEvent.ACTION_MOVE:
			if (mode == ZOOM)
			{
				// 正在移动的点距初始点的距离
				float newDist = spacing(event);

				if (newDist > oldDist)
				{
					zoomOut();
				}
				if (newDist < oldDist)
				{
					zoomIn();
				}

			}
			break;
		}
		return true;
		//return super.onTouchEvent(event);
	
	}
	
	/**
	 * 放大
	 */
	protected void zoomOut()
	{
		textSize += scale;
		if (textSize > MAX_TEXT_SIZE)
		{
			textSize = MAX_TEXT_SIZE;
		}
		setTextSize(textSize);
	}

	/**
	 * 缩小
	 */
	protected void zoomIn()
	{
		textSize -= scale;
		if (textSize < MIN_TEXT_SIZE)
		{
			textSize = MIN_TEXT_SIZE;
		}
		setTextSize(textSize);
	}

}
