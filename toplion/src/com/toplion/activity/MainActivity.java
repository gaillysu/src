package com.toplion.activity;



import android.util.Log;
import android.view.GestureDetector.SimpleOnGestureListener;
import com.toplion.activity.R;

import android.app.ActivityGroup;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

/**
 * 欢迎界面
 * 
 * @author Ayres
 * 
 */
@SuppressWarnings("deprecation")
public class MainActivity extends ActivityGroup {

	// body部分
	private LinearLayout layoutBody;
	// 欢迎页LOGO
	private ImageView igvLogo;
	// 标题
	private TextView titlebarTitle;
	private RadioGroup btn;
	private RadioButton btnA;
	private RadioButton btnB;
	private RadioButton btnC;
	private RadioButton btnD;
	private RadioButton btnE;
	
	static public GestureDetector gd;	//用于捕捉touch的详细手势

	private long  backkeyeventtime =0;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		findViews();
		setAnimation(igvLogo);
		titlebarTitle.setText("顶狮信息欢迎您! 联系电话 13714720103，联系人苏老师");
		titlebarTitle.setFocusableInTouchMode(true);
		titlebarTitle.setFocusable(true);
		setListener();
		
		new Handler().postDelayed(new Runnable(){
			@Override
			public void run(){
				btnA.setChecked(true);
			}
		}, 5000);
		
	}

	/**
	 * 初始化控件
	 */
	private void findViews() {
		igvLogo = (ImageView) findViewById(R.id.ivLogo);
		
		igvLogo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				PlayFromRawFile();
			}
		});
		//igvLogo.setVisibility(0x00000004);
		layoutBody = (LinearLayout) findViewById(R.id.layoutBody);
		titlebarTitle = (TextView) findViewById(R.id.titlebarTitle);
		btn = (RadioGroup) findViewById(R.id.btn);
		btnA = (RadioButton) findViewById(R.id.btnA);
		btnB = (RadioButton) findViewById(R.id.btnB);
		btnC = (RadioButton) findViewById(R.id.btnC);
		btnD = (RadioButton) findViewById(R.id.btnD);
		btnE = (RadioButton) findViewById(R.id.btnE);
		//创建一个GestureDetector实例
		gd = new GestureDetector (this, new SimpleOnGestureListener()
		{
			
			@Override
			public boolean onFling(	MotionEvent e1,  	//按下时的状态,位置
					MotionEvent e2, 	//松手时的状态，位置
					float vx,			//x坐标的移动速度，单位: px/秒
					float vy)			//y坐标的移动速度
			{
				// TODO Auto-generated method stub
				if(e1==null || e2==null) return false;
				
				if((e1.getX()-e2.getX()>200) && (Math.abs(vx)>50)) 	//滑动速度足够快至少50点/秒，手指起落点减起点是正值且>200 判断属于向左滑动
				{
					if(btn.getCheckedRadioButtonId()== btnA.getId())
						   btnB.setChecked(true);
					else if(btn.getCheckedRadioButtonId()== btnB.getId())
						   btnD.setChecked(true);
					else if(btn.getCheckedRadioButtonId()== btnD.getId())
						   btnE.setChecked(true);
				
				}
				else if ((e2.getX()-e1.getX()>200) && (Math.abs(vx)>50)) //同理判断是向右滑动
				{
					if(btn.getCheckedRadioButtonId()== btnB.getId())
						   btnA.setChecked(true);
					else if(btn.getCheckedRadioButtonId()== btnD.getId())
						   btnB.setChecked(true);
				//	else if(btn.getCheckedRadioButtonId()== btnA.getId())
				//		   btnE.setChecked(true);
				}
				
				return true;
			}				
		});		
				
	/*  无效，只能在各个界面的listview下设置setOnTouchListener来捕获划屏事件
		layoutBody.setOnTouchListener(new OnTouchListener(){

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				return gd.onTouchEvent(event);
			}			
		}); 
		
		layoutBody.setLongClickable(true);	
				 
		*/
	}
	
	


/*   对 layoutBody无效，仅仅响应标题的区域划屏事件
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		//return super.onTouchEvent(event);
		return gd.onTouchEvent(event);
	}
*/
	private void setListener() {
		btn.setOnCheckedChangeListener(btnOnCheckedChangeListener);
	}

	private  void PlayFromRawFile()
	{
		MediaPlayer play = MediaPlayer.create(this, R.raw.lion);
		play.setAudioStreamType(AudioManager.STREAM_MUSIC);
		
		AudioManager mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
		int maxVolume = mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
		mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, maxVolume , 0);

		play.start();		
	}
	private void setAnimation(View v) {
		// 声明一个图片集
		AnimationSet set = new AnimationSet(true);
		// 设置动画效果
		ScaleAnimation animation = new ScaleAnimation(0.0f, 1.2f, 0.0f, 1.2f, 
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		// 设置时间
		animation.setDuration(4000);
		
		animation.setAnimationListener(new AnimationListener(){

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				PlayFromRawFile();
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}});
		
		set.addAnimation(animation);
		// 设置最先效果
		set.setFillAfter(true);
		set.setFillBefore(false);
		// 绑定控件
		v.setAnimation(set);
	//	igvLogo.setAnimation(set);
		
	//	igvLogo.startAnimation(animation);
	}

	/**
	 * 标题栏监听和底部菜单
	 */
	private OnCheckedChangeListener btnOnCheckedChangeListener = new OnCheckedChangeListener() {
		@Override
		public void onCheckedChanged(RadioGroup radioGroup, int paramInt) {
			layoutBody.removeAllViews();
			// 首页
			if (paramInt == btnA.getId()) {
				// 跳转页面
				Intent intent = new Intent(MainActivity.this,
						HomeActivity.class);
				// 开辟一个新的HomeActivity
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				// 获取新视图
				View view = getLocalActivityManager().startActivity("btnA",
						intent).getDecorView();
				// 标题
				titlebarTitle.setText("顶狮信息");
				layoutBody.addView(view);
				//h_wenzi
				
				// 解决方案
			} else if (paramInt == btnB.getId()) {
				Intent intent = new Intent(MainActivity.this,
						SolutionActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				View view = getLocalActivityManager().startActivity("btnB",
						intent).getDecorView();
				titlebarTitle.setText("课程体系");
				layoutBody.addView(view);
				// 产品终端
			} else if (paramInt == btnC.getId()) {
				Intent intent = new Intent(MainActivity.this,
						ProductActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				View view = getLocalActivityManager().startActivity("btnC",
						intent).getDecorView();
				titlebarTitle.setText("产品终端");
				layoutBody.addView(view);
				// 联系我们
			} else if (paramInt == btnD.getId()) {
				Intent intent = new Intent(MainActivity.this,
						AboutActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				View view = getLocalActivityManager().startActivity("btnD",
						intent).getDecorView();
				titlebarTitle.setText("关于我们");
				layoutBody.addView(view);
				// 更多页
			} else if (paramInt == btnE.getId()) {
				Intent intent = new Intent(MainActivity.this,
						MoreActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				
				
				
				View view = getLocalActivityManager().startActivity("btnE",
						intent).getDecorView();
				titlebarTitle.setText("案例展示");
				layoutBody.addView(view);
				
			}
			
			
		}
	};

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// 判断按下的键是返回键.
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
			
			/*
			new AlertDialog.Builder(this).setTitle("温馨提示").setMessage("您是否要要退出程序？").setPositiveButton("确定", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					MainActivity.this.finish();
				}
			}).setNeutralButton("取消", null).show();
			*/
			if(backkeyeventtime ==0 ||
					(backkeyeventtime >0 &&	(event.getEventTime()-backkeyeventtime)>3000)	
			)
			{
			backkeyeventtime = event.getEventTime();
			 Toast.makeText(  
              		  this,
                        "再按一次退出程序",
                        Toast.LENGTH_SHORT).show();  
			 return true;			
			}
			else 
			{			
					MainActivity.this.finish();				
			}
			
		}
		return super.onKeyDown(keyCode, event);

	}

}
