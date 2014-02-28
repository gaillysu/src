package com.toplion.activity;

import java.util.ArrayList;
import java.util.HashMap;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.speech.tts.TextToSpeech.OnUtteranceCompletedListener;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class AdActivity extends android.app.Activity implements OnInitListener, OnUtteranceCompletedListener {
	
	private ViewPager mViewPager;	
	private ImageView mPage0;
	private ImageView mPage1;
	private ImageView mPage2;
	private ImageView mPage3;
	private ImageView mPage4;
	private ImageView mPage5;
		
	private int currIndex = 0;
	private TextToSpeech mTts=null; // TTS对象
	
	ArrayList<String>  myinfo = new  ArrayList<String>();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
                
        setContentView(R.layout.whatsnew_viewpager);
        
        checkTtsData(); // 校验TTS引擎安装及资源状态
        
        mViewPager = (ViewPager)findViewById(R.id.whatsnew_viewpager);        
        mViewPager.setOnPageChangeListener(new MyOnPageChangeListener());
       
        
        mPage0 = (ImageView)findViewById(R.id.page0);
        mPage1 = (ImageView)findViewById(R.id.page1);
        mPage2 = (ImageView)findViewById(R.id.page2);
        mPage3 = (ImageView)findViewById(R.id.page3);
        mPage4 = (ImageView)findViewById(R.id.page4);
        mPage5 = (ImageView)findViewById(R.id.page5);
        
                
      //将要分页显示的View装入数组中
        LayoutInflater mLi = LayoutInflater.from(this);
        View view1 = mLi.inflate(R.layout.whats1, null);
        View view2 = mLi.inflate(R.layout.whats2, null);
        View view3 = mLi.inflate(R.layout.whats3, null);
        View view4 = mLi.inflate(R.layout.whats4, null);
        View view5 = mLi.inflate(R.layout.whats5, null);
        View view6 = mLi.inflate(R.layout.whats6, null);
        
        String  ss = (String) ((TextView)view1.findViewById(R.id.info)).getText();
        myinfo.add(ss);
        ss = (String) ((TextView)view2.findViewById(R.id.info)).getText();
        myinfo.add(ss);
        ss = (String) ((TextView)view3.findViewById(R.id.info)).getText();
        myinfo.add(ss);
        ss = (String) ((TextView)view4.findViewById(R.id.info)).getText();
        myinfo.add(ss);
        ss = (String) ((TextView)view5.findViewById(R.id.info)).getText();
        myinfo.add(ss);
        ss = (String) ((TextView)view6.findViewById(R.id.info)).getText();
        myinfo.add(ss);
        
        
        
      //每个页面的view数据
        final ArrayList<View> views = new ArrayList<View>();
        views.add(view1);
        views.add(view2);
        views.add(view3);
        views.add(view4);
        views.add(view5);
        views.add(view6);
        
        //填充ViewPager的数据适配器
        PagerAdapter mPagerAdapter = new PagerAdapter() {
			
			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				return arg0 == arg1;
			}
			
			@Override
			public int getCount() {
				return views.size();
			}

			@Override
			public void destroyItem(View container, int position, Object object) {
				((ViewPager)container).removeView(views.get(position));
			}
			
			
			
			@Override
			public Object instantiateItem(View container, int position) {
				((ViewPager)container).addView(views.get(position));
				return views.get(position);
			}
		};
		
		mViewPager.setAdapter(mPagerAdapter);
			
    }    
    

    public class MyOnPageChangeListener implements OnPageChangeListener {
		@Override
		public void onPageSelected(int arg0) {
			switch (arg0) {
			case 0:				
				mPage0.setImageDrawable(getResources().getDrawable(R.drawable.page_now));
				mPage1.setImageDrawable(getResources().getDrawable(R.drawable.page));
				break;
			case 1:
				mPage1.setImageDrawable(getResources().getDrawable(R.drawable.page_now));
				mPage0.setImageDrawable(getResources().getDrawable(R.drawable.page));
				mPage2.setImageDrawable(getResources().getDrawable(R.drawable.page));
				break;
			case 2:
				mPage2.setImageDrawable(getResources().getDrawable(R.drawable.page_now));
				mPage1.setImageDrawable(getResources().getDrawable(R.drawable.page));
				mPage3.setImageDrawable(getResources().getDrawable(R.drawable.page));
				break;
			case 3:
				mPage3.setImageDrawable(getResources().getDrawable(R.drawable.page_now));
				mPage4.setImageDrawable(getResources().getDrawable(R.drawable.page));
				mPage2.setImageDrawable(getResources().getDrawable(R.drawable.page));
				break;
			case 4:
				mPage4.setImageDrawable(getResources().getDrawable(R.drawable.page_now));
				mPage3.setImageDrawable(getResources().getDrawable(R.drawable.page));
				mPage5.setImageDrawable(getResources().getDrawable(R.drawable.page));
				break;
			case 5:
				mPage5.setImageDrawable(getResources().getDrawable(R.drawable.page_now));
				mPage4.setImageDrawable(getResources().getDrawable(R.drawable.page));
				break;
			}
			currIndex = arg0;
			ttsPlay(myinfo.get(currIndex));
			//animation.setFillAfter(true);// True:图片停在动画结束位置
			//animation.setDuration(300);
			//mPageImg.startAnimation(animation);
		}
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}

		@Override
		public void onPageScrollStateChanged(int arg0) {
		}
	}
    //跳转页面
    public void startbutton(View v) {  
       	Intent intent = new Intent();
		intent.setClass(this,MainActivity.class);
		startActivity(intent);
		this.finish();
      } 
    
	private static final int REQ_CHECK_TTS_DATA = 110; // TTS数据校验请求值
    /** 校验TTS引擎安装及资源状态 */
	private boolean checkTtsData() {
		try {
			Intent checkIntent = new Intent();
			checkIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
			startActivityForResult(checkIntent, REQ_CHECK_TTS_DATA);
			return true;
		} catch (ActivityNotFoundException e) {
			return false;
		}
	}
	
	@Override
	protected void onStart() {		
		super.onStart();
	}
	/** onActivityResult */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == REQ_CHECK_TTS_DATA) {
			switch (resultCode) {
			case TextToSpeech.Engine.CHECK_VOICE_DATA_PASS: // TTS引擎可用
				// 针对于重新绑定引擎，需要先shutdown()
				if (null != mTts) {
					mTts.stop(); // 停止当前发声
					mTts.shutdown(); // 释放资源
				}
				mTts = new TextToSpeech(this, this); // 创建TextToSpeech对象
				break;
			case TextToSpeech.Engine.CHECK_VOICE_DATA_BAD_DATA: // 数据错误
			case TextToSpeech.Engine.CHECK_VOICE_DATA_MISSING_DATA: // 缺失数据资源
			case TextToSpeech.Engine.CHECK_VOICE_DATA_MISSING_VOLUME: // 缺少数据存储量
				notifyReinstallDialog(); // 提示用户是否重装TTS引擎数据的对话框
				break;
			case TextToSpeech.Engine.CHECK_VOICE_DATA_FAIL: // 检查失败
			default:
				break;
			}
		}
		super.onActivityResult(requestCode, resultCode, data);
	}
	
	/** 提示用户是否重装TTS引擎数据的对话框 */
	private void notifyReinstallDialog() {
		new AlertDialog.Builder(this).setTitle("TTS引擎数据错误")
				.setMessage("是否尝试重装TTS引擎数据到设备上？")
				.setPositiveButton("是", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// 触发引擎在TTS引擎在设备上安装资源文件
						Intent dataIntent = new Intent();
						dataIntent
								.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
						startActivity(dataIntent);
					}
				}).setNegativeButton("否", null).show();
	}

	@Override
	public void onInit(int status) {
		// TODO Auto-generated method stub
		if (status == TextToSpeech.SUCCESS) {
	//		mTts.setSpeechRate(mSpeechRate); // 设置朗读速率
			// 设置发声合成监听，注意也需要在onInit()中做才有效
			mTts.setOnUtteranceCompletedListener(this);
			ttsPlay(myinfo.get(0));			
		}
	}

	@Override
	public void onUtteranceCompleted(String utteranceId) {
		// TODO Auto-generated method stub
		
	}
	
	/** tts合成语音播放 */
	private int ttsPlay(String textContent) {
		if (null != mTts) {
			/**
			 * 叙述text。
			 * 
			 * 1） 参数2（int queueMode）
			 *    1.1）QUEUE_ADD：增加模式。增加在队列尾，继续原来的说话。
			 *    1.2）QUEUE_FLUSH：刷新模式。中断正在进行的说话，说新的内容。
			 * 2）参数3（HashMap<String, String> params）
			 *    2.1）请求的参数，可以为null。
			 *    2.2）注意KEY_PARAM_UTTERANCE_ID。
			 */
			HashMap<String, String> params = new HashMap<String, String>();
			params.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "toplion");
			return mTts.speak(textContent, TextToSpeech.QUEUE_FLUSH, params);
		}
		return TextToSpeech.ERROR;
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		if (null != mTts) {
			mTts.stop(); //停止播放
			mTts.shutdown(); // 释放资源
		}
		super.onDestroy();
	}
	
	

}
