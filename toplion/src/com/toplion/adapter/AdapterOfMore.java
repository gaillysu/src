package com.toplion.adapter;

import java.util.List;

import com.polites.android.GestureImageView;
import com.toplion.activity.R;
import com.toplion.entity.MoreContent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterOfMore extends BaseAdapter{

	private List<MoreContent> list;
	private Context context;

	public AdapterOfMore(List<MoreContent> list, Context context) {
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
		
		View view= null;
		if(arg1 == null)
		{
		LayoutInflater  inflater=LayoutInflater.from(context);		
		view=inflater.inflate(R.layout.more, null);
		}
		else
			view = arg1;
		
		//案例名及要点
		TextView name=(TextView) view.findViewById(R.id.textView1);
		name.setText(list.get(arg0).getCasenameid());
		
		//案例截图
		ImageView pic=(ImageView) view.findViewById(R.id.imageView1);
		pic.setImageResource(list.get(arg0).getCasepic());

		
		
	
		return view;
	}

}
