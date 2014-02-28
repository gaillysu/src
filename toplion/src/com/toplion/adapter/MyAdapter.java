package com.toplion.adapter;

import java.util.List;

import com.toplion.activity.R;
import com.toplion.entity.FangAn;
import com.toplion.entity.KeCheng;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

	private Context context;
	private List<KeCheng> list;
	

	public MyAdapter(Context context, List<KeCheng> list) {
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
		
		// 加载 xml 文件
		
		View view = null;
		if(arg1 == null)
		{
		 LayoutInflater inflater = LayoutInflater.from(context);
		 view = inflater.inflate(R.layout.kecheng, null);
		}
		else
			view = arg1;
		
		TextView tv=(TextView) view.findViewById(R.id.iv_banjiname);		
		TextView tv1=(TextView) view.findViewById(R.id.tv_kcjj_content);		
		TextView tv2=(TextView) view.findViewById(R.id.tv_pxdx_content);		
		TextView tv3=(TextView) view.findViewById(R.id.tv_pxnr_content);		
		TextView tv4=(TextView) view.findViewById(R.id.tv_pxmb_content);
		
		tv.setText(list.get(arg0).getBanjiname());
		tv1.setText(list.get(arg0).getKcjj());
		tv2.setText(list.get(arg0).getPxdx());
		tv3.setText(list.get(arg0).getPxnr());
		tv4.setText(list.get(arg0).getPxmb());
		
	
		return view;
	}

}
