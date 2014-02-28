package com.toplion.adapter;

import java.util.List;

import com.polites.android.ZoomTextView;
import com.toplion.activity.R;
import com.toplion.entity.AboutOfMe;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 关于填充器
 * @author Ayres
 *
 */
public class AdapterOfAbout extends BaseAdapter{

	private List<AboutOfMe> list;
	private Context context;

	public AdapterOfAbout(List<AboutOfMe> list, Context context) {
		super();
		this.list = list;
		this.context = context;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		LayoutInflater  inflater=LayoutInflater.from(context);
		View view=inflater.inflate(R.layout.about, null);
		//公司架构
		ImageView jiayou=(ImageView) view.findViewById(R.id.about_iv_jiayou);
		jiayou.setImageResource(list.get(arg0).getOurOfjiagou());
		ImageView jiayous=(ImageView) view.findViewById(R.id.ivJiagou);
		jiayous.setImageResource(list.get(arg0).getOurOfjiagous());
		//公司愿景
		ImageView yuanjing=(ImageView) view.findViewById(R.id.about_iv_yuanjing);
		yuanjing.setImageResource(list.get(arg0).getOurOfyuanjing());
		TextView yuanjings=(TextView) view.findViewById(R.id.about_tv_yuanjins);
		yuanjings.setText(list.get(arg0).getOurOfyuanjings());
		//核心业务
		ImageView yewu=(ImageView) view.findViewById(R.id.about_iv_yewu);
		yewu.setImageResource(list.get(arg0).getOurofHexin());
		TextView hexins=(TextView) view.findViewById(R.id.about_tv_yewu);
		hexins.setText(list.get(arg0).getOurOfhexinx());
		
		TextView us=(TextView) view.findViewById(R.id.about_tv_us);
		us.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				context.startActivity(new Intent("android.intent.action.CALL",Uri.parse("tel:13714720103")));	
			}
		});
		
		
		
		return view;
	}

}
