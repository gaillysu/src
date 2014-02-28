package com.toplion.activity;

import java.util.ArrayList;
import java.util.List;

import com.toplion.activity.R;
import com.polites.android.GestureImageView;
import com.toplion.adapter.AdapterOfAbout;
import com.toplion.entity.AboutOfMe;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.AlertDialog.Builder;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * 关于我们
 * 
 * @author Ayres
 * 
 */
public class AboutActivity extends Activity {

	private ImageView jiaGou;
	private AdapterOfAbout abouts;
	private ListView lvAbout;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
		getInit();
		
		lvAbout.setOnTouchListener(new OnTouchListener(){

				@Override
				public boolean onTouch(View v, MotionEvent event) {
					// TODO Auto-generated method stub
					return MainActivity.gd.onTouchEvent(event);
				}			
			}); 
	}

	/**
	 * 公司架构
	 */
	private void getInit() {
		lvAbout=(ListView) findViewById(R.id.lvAbout);
		abouts=new AdapterOfAbout(getData(), this);
		lvAbout.setAdapter(abouts);
	//	lvAbout.setOnItemClickListener(new OnDoubleClickListener());
	}

	/**
	 * 获取数据
	 * @return 得到数据
	 */
	private List<AboutOfMe> getData(){
		List<AboutOfMe> list=new ArrayList<AboutOfMe>();
		AboutOfMe about=new AboutOfMe();
		about.setOurofHexin(R.drawable.c_yewu);
		about.setOurOfhexinx(this.getString(R.string.yewus));
		about.setOurOfjiagou(R.drawable.c_jiagou);
		about.setOurOfjiagous(R.drawable.jiagou);
		about.setOurOfyuanjing(R.drawable.c_yuanjin);
		about.setOurOfyuanjings(this.getString(R.string.yuanjins));
		list.add(about);
		return list;
	}
	
	class OnDoubleClickListener implements OnItemClickListener{

		@SuppressLint("NewApi")
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			AlertDialog.Builder builder = new
					 Builder(AboutActivity.this,R.style.Dialog_Fullscreen);
					//AlertDialog.Builder builder = new Builder(ProductActivity.this);
					LayoutInflater inflater = LayoutInflater.from(AboutActivity.this);
					View view = inflater.inflate(R.layout.dialog, null);
					GestureImageView g = (GestureImageView) view
							.findViewById(R.id.big_image);
					g.setImageResource(R.drawable.company_jiagou);
					builder.setView(view);
					Dialog dialog = builder.create();
					// 设置大小
//					WindowManager.LayoutParams layoutParams = dialog.getWindow()
//							.getAttributes();
//					layoutParams.width = LayoutParams.MATCH_PARENT;
//					layoutParams.height = LayoutParams.MATCH_PARENT;
//					dialog.getWindow().setAttributes(layoutParams);

					dialog.show();
			
		}

		

		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_about, menu);
		return true;
	}
}
