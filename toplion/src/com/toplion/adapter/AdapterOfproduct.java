package com.toplion.adapter;

import java.util.List;

import com.toplion.activity.R;
import com.toplion.entity.Product;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * 平安健终端填充器
 * 
 * @author Ayres
 * 
 */
public class AdapterOfproduct extends BaseAdapter {

	private List<Product> list;
	private Context context;

	/**
	 * 有參构造
	 * 
	 * @param list
	 *            集合长度
	 * @param context
	 *            上下文对象
	 */
	public AdapterOfproduct(List<Product> list, Context context) {
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
		LayoutInflater inflater = LayoutInflater.from(context);
		//加载布局文件
		View view=inflater.inflate(R.layout.pinganjian,null);
		//给文件赋值
		ImageView imageView=(ImageView) view.findViewById(R.id.ivpinganjian);
		imageView.setImageResource(list.get(arg0).getImageOfpro());
		return view;
	}

}
