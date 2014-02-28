package com.toplion.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.polites.android.ZoomTextView;
import com.toplion.activity.R;
import com.toplion.entity.HomeContent;

public class HomeOfAdapter extends BaseAdapter {
	private Context context;
	private List<HomeContent> list;
	

	public HomeOfAdapter(Context context, List<HomeContent> list) {
		super();
		this.context = context;
		this.list = list;
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
		LayoutInflater inflater = LayoutInflater.from(context);
		// 加载 xml 文件
		View view = inflater.inflate(R.layout.home, null);
		//研究院
		ImageView yanjiuyuan=(ImageView) view.findViewById(R.id.h_yan);
		yanjiuyuan.setImageResource(list.get(arg0).getYanJIuyuan());
		//文字
		TextView tv=(TextView) view.findViewById(R.id.h_wenzi);
		tv.setText(list.get(arg0).getContentOfCompany());
		


		//优势
		ImageView youshi=(ImageView) view.findViewById(R.id.h_youshi);
		youshi.setImageResource(list.get(arg0).getYouShi());
		//愿景
		ImageView yuan = (ImageView) view.findViewById(R.id.h_one);
		yuan.setImageResource(list.get(arg0).getYuan());
		ImageView jing = (ImageView) view.findViewById(R.id.h_two);
		jing.setImageResource(list.get(arg0).getJing());
		return view;
	}
}
