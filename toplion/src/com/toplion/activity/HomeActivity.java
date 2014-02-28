package com.toplion.activity;

import java.util.ArrayList;
import java.util.List;

import com.toplion.activity.R;
import com.toplion.adapter.HomeOfAdapter;
import com.toplion.entity.HomeContent;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ListView;
import android.widget.TextView;

/**
 * 公司首頁
 * @author Ayres
 *
 */
public class HomeActivity extends Activity {
	
	HomeOfAdapter homeOfAdapter;
	private ListView lvHome;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getKongjian();
        homeOfAdapter=new HomeOfAdapter(this, getData());
        lvHome.setAdapter(homeOfAdapter);
        
        lvHome.setOnTouchListener(new OnTouchListener(){

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
			
				return MainActivity.gd.onTouchEvent(event);
			}			
		}); 
		
     //   lvHome.setLongClickable(true);	
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_home, menu);
        return true;
    }
    private void getKongjian(){
    	lvHome=(ListView) findViewById(R.id.lvhome);
    }
    
    private List<HomeContent> getData(){
		List<HomeContent> list=new ArrayList<HomeContent>();
		HomeContent fa=new HomeContent();
		fa.setYanJIuyuan(R.drawable.honm_our);
		fa.setContentOfCompany(this.getString(R.string.content_of_company));
		fa.setYouShi(R.drawable.youshi);
		fa.setYuan(R.drawable.gongsiyuanjing_one);
		fa.setJing(R.drawable.gongsiyuanjing_two);
		list.add(fa);
		return  list;
	}
}
