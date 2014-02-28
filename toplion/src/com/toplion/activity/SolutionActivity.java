package com.toplion.activity;

import java.util.ArrayList;
import java.util.List;

import com.toplion.activity.R;
import com.polites.android.GestureImageView;
import com.toplion.adapter.MyAdapter;
import com.toplion.entity.FangAn;
import com.toplion.entity.KeCheng;

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
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

/**
 * 解决方案
 * @author Ayres
 *
 */
public class SolutionActivity extends Activity {

	private ListView listView;
	private MyAdapter myAdapter;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solution);
        listView = (ListView) findViewById(R.id.listView1);
        showView();
        
        listView.setOnTouchListener(new OnTouchListener(){

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				return MainActivity.gd.onTouchEvent(event);
			}			
		}); 
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_solution, menu);
        return true;
    }

	/**
	 * 显示list中的值
	 */
	public void showView() {
		myAdapter = new MyAdapter(this, getData());
		listView.setAdapter(myAdapter);
		MyDoubleClickListener listener=new MyDoubleClickListener();
	//	listView.setOnItemClickListener(listener);
	}
	
	private class MyDoubleClickListener implements OnItemClickListener {

		@SuppressLint("NewApi")
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			 AlertDialog.Builder builder = new
			 Builder(SolutionActivity.this,R.style.Dialog_Fullscreen);
			//AlertDialog.Builder builder = new Builder(ProductActivity.this);
			LayoutInflater inflater = LayoutInflater.from(SolutionActivity.this);
			View view = inflater.inflate(R.layout.dialog, null);
			GestureImageView g = (GestureImageView) view
					.findViewById(R.id.big_image);
			g.setImageResource(R.drawable.fangan);
			builder.setView(view);
			Dialog dialog = builder.create();
			// 设置大小
//			WindowManager.LayoutParams layoutParams = dialog.getWindow()
//					.getAttributes();
//			layoutParams.width = LayoutParams.MATCH_PARENT;
//			layoutParams.height = LayoutParams.MATCH_PARENT;
//			dialog.getWindow().setAttributes(layoutParams);

			dialog.show();
		}}
     
	private List<KeCheng> getData(){
		/*
		List<FangAn> list=new ArrayList<FangAn>();
		FangAn fa=new FangAn();
		fa.setZhengce(R.drawable.zhengczhichi);
		fa.setWenzis(this.getString(R.string.fangan_zhences));
		fa.setFuwu(R.drawable.testefuwu);
		fa.setFangan(R.drawable.fangan);
		list.add(fa);
		return  list;
		*/
		List<KeCheng> list=new ArrayList<KeCheng>();
		
		KeCheng kc1=new KeCheng();		
		kc1.setBanjiname(getString(R.string.banji1));
		kc1.setKcjj(getString(R.string.kcjj1));
		kc1.setPxdx(getString(R.string.pxdx1));
		kc1.setPxnr(getString(R.string.pxnr1));
		kc1.setPxmb(getString(R.string.pxmb1));		
		list.add(kc1);
		
		
		KeCheng kc2=new KeCheng();		
		kc2.setBanjiname(getString(R.string.banji2));
		kc2.setKcjj(getString(R.string.kcjj2));
		kc2.setPxdx(getString(R.string.pxdx2));
		kc2.setPxnr(getString(R.string.pxnr2));
		kc2.setPxmb(getString(R.string.pxmb2));		
		list.add(kc2);
		
		KeCheng kc3=new KeCheng();		
		kc3.setBanjiname(getString(R.string.banji3));
		kc3.setKcjj(getString(R.string.kcjj3));
		kc3.setPxdx(getString(R.string.pxdx3));
		kc3.setPxnr(getString(R.string.pxnr3));
		kc3.setPxmb(getString(R.string.pxmb3));		
		list.add(kc3);
		
		KeCheng kc4=new KeCheng();		
		kc4.setBanjiname(getString(R.string.banji4));
		kc4.setKcjj(getString(R.string.kcjj4));
		kc4.setPxdx(getString(R.string.pxdx4));
		kc4.setPxnr(getString(R.string.pxnr4));
		kc4.setPxmb(getString(R.string.pxmb4));		
		list.add(kc4);
		
		return  list;
		
	}
}
