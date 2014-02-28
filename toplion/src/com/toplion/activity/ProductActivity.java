package com.toplion.activity;

import java.util.ArrayList;
import java.util.List;

import com.toplion.activity.R;
import com.polites.android.GestureImageView;
import com.toplion.adapter.AdapterOfproduct;
import com.toplion.entity.Product;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.AlertDialog.Builder;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

/**
 * 产品终端
 * 
 * @author Ayres
 * 
 */
public class ProductActivity extends Activity {

	private ListView lvView;
	private AdapterOfproduct ofProduct;
	private List<Product> list;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_product);
		// 初始化控件对象
		initeView();
		ofProduct = new AdapterOfproduct(getData(), this);
		lvView.setAdapter(ofProduct);
		MyDoubleClickListener listener = new MyDoubleClickListener();
		lvView.setOnItemClickListener(listener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_product, menu);
		return true;
	}

	/**
	 * 得到控件对象
	 */
	private void initeView() {
		lvView = (ListView) findViewById(R.id.lvpinganjian);
	}

	/**
	 * 得到数据
	 */
	private List<Product> getData() {
		list = new ArrayList<Product>();
		Product p = new Product(R.drawable.pinganjian);
		list.add(p);
		return list;
	}

	private class MyDoubleClickListener implements OnItemClickListener {

		@SuppressLint("NewApi")
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			 AlertDialog.Builder builder = new
			 Builder(ProductActivity.this,R.style.Dialog_Fullscreen);
			//AlertDialog.Builder builder = new Builder(ProductActivity.this);
			LayoutInflater inflater = LayoutInflater.from(ProductActivity.this);
			View view = inflater.inflate(R.layout.dialog, null);
			GestureImageView g = (GestureImageView) view
					.findViewById(R.id.big_image);
			g.setImageResource(R.drawable.pinganjian);
			builder.setView(view);
			Dialog dialog = builder.create();
			// 设置大小
//			WindowManager.LayoutParams layoutParams = dialog.getWindow()
//					.getAttributes();
//			layoutParams.width = LayoutParams.MATCH_PARENT;
//			layoutParams.height = LayoutParams.MATCH_PARENT;
//			dialog.getWindow().setAttributes(layoutParams);

			dialog.show();
		}

	}
}
