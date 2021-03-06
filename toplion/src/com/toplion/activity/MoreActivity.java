package com.toplion.activity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;





import com.toplion.activity.R;
import com.toplion.adapter.AdapterOfMore;
import com.toplion.entity.MoreContent;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

/**
 * 更多界面
 * 
 * @author Ayres
 * 
 */
public class MoreActivity extends Activity {

	private ListView lvMore;
	private AdapterOfMore mores;
	
	private ViewPager adViewPager;
	private LinearLayout pagerLayout;
	private List<View> pageViews;
	private ImageView[] imageViews;
	private ImageView imageView;  
	private AdPageAdapter adapter;
	private AtomicInteger atomicInteger = new AtomicInteger(0);  
    private boolean isContinue = true; 
    
    final Integer  projects[][] = {
    		
			{R.string.case1,R.drawable.btcar},
		//	{R.string.case1,R.drawable.btcarcontrol},
			
			{R.string.case1,R.drawable.btcall1},		
			
			{R.string.case2,R.drawable.weather},
			{R.string.case3,R.drawable.baidumap},
			
			{R.string.case4,R.drawable.simuweixin},
	//		{R.string.case4,R.drawable.simuweixin2},
			
	//		{R.string.case5,R.drawable.viewpage},
			{R.string.case6,R.drawable.qrcode},
		//	{R.string.case6,R.drawable.qrcode2},
			
			{R.string.case7,R.drawable.player0},
		//	{R.string.case7,R.drawable.player},
			
		//	{R.string.case8,R.drawable.ab},
		//	{R.string.case8,R.drawable.ad},
			
			{R.string.case9,R.drawable.gold},
		//	{R.string.case9,R.drawable.gold2},
			
		//	{R.string.case10,R.drawable.jimuyouxi},
		//	{R.string.case10,R.drawable.demo},
			
			
	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	//	setContentView(R.layout.activity_more);
	//	getInit();
		setContentView(R.layout.activity_cases);
		
		initViewPager();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_more, menu);
		return true;
	}

	/**
	 * 初始化
	 */
	private void getInit() {
		lvMore = (ListView) findViewById(R.id.lvMore);
		mores = new AdapterOfMore(getData(), this);
		lvMore.setAdapter(mores);
	}

	/**
	 * 添加数据
	 * 
	 * @return 得到的
	 */
	
	private List<MoreContent> getData() {
		List<MoreContent> list = new ArrayList<MoreContent>();
		
		for(int i=0;i<projects.length;i++)
		{
			MoreContent moreContent = new MoreContent();
			
			moreContent.setCasenameid(projects[i][0]);
			moreContent.setCasepic(projects[i][1]);			
			list.add(moreContent);
		}
		
		return list;
	}
	
	private void initViewPager() {

		//从布局文件中获取ViewPager父容器
		pagerLayout = (LinearLayout) findViewById(R.id.view_pager_content);
		//创建ViewPager
    	adViewPager = new ViewPager(this);
    	
    	//获取屏幕像素相关信息
    	DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
    	
        //根据屏幕信息设置ViewPager广告容器的宽高
        adViewPager.setLayoutParams(new LayoutParams(dm.widthPixels, dm.heightPixels ));
        
        //将ViewPager容器设置到布局文件父容器中
    	pagerLayout.addView(adViewPager);
    	
    	initPageAdapter();
    	
    	initCirclePoint();
    	
    	adViewPager.setAdapter(adapter);
    	adViewPager.setOnPageChangeListener(new AdPageChangeListener());
    	
    	new Thread(new Runnable() {  
            @Override  
            public void run() {  
                while (true) {  
                    if (isContinue) {  
                        viewHandler.sendEmptyMessage(atomicInteger.get());  
                        atomicOption();  
                    }  
                }  
            }  
        }).start();  
    	
    	
  
	}
	
	
    private void atomicOption() {  
        atomicInteger.incrementAndGet();  
        if (atomicInteger.get() > imageViews.length - 1) {  
        	atomicInteger.getAndAdd(-imageViews.length);  
        }  
        try {  
            Thread.sleep(1000);  
        } catch (InterruptedException e) {  
              
        }  
    } 
	
    /*
     * 每隔固定时间切换广告栏图片
     */
    private final Handler viewHandler = new Handler() {  
  
        @Override  
        public void handleMessage(Message msg) {  
        	adViewPager.setCurrentItem(msg.what);  
            super.handleMessage(msg);  
        }  
  
    }; 
	
	private void initPageAdapter() {
		pageViews = new ArrayList<View>();
		
		for(int i=0;i<projects.length;i++)
		{
			ImageView img1 = new ImageView(this);  
	        img1.setBackgroundResource(projects[i][1]);  
	        pageViews.add(img1);  
		}		 
        
        adapter = new AdPageAdapter(pageViews);
	}
	
	private void initCirclePoint(){
		ViewGroup group = (ViewGroup) findViewById(R.id.viewGroup); 
        imageViews = new ImageView[pageViews.size()];  
        //广告栏的小圆点图标
        for (int i = 0; i < pageViews.size(); i++) {  
        	//创建一个ImageView, 并设置宽高. 将该对象放入到数组中
        	imageView = new ImageView(this);  
            imageView.setLayoutParams(new LayoutParams(10,10));  
            imageViews[i] = imageView;  
            
            //初始值, 默认第0个选中
            if (i == 0) {  
                imageViews[i]  
                        .setBackgroundResource(R.drawable.point_focused);  
            } else {  
                imageViews[i]  
                        .setBackgroundResource(R.drawable.point_unfocused);  
            }  
            //将小圆点放入到布局中
            group.addView(imageViews[i]);  
        } 
	}
	
	/**
	 *	ViewPager 页面改变监听器 
	 */
    private final class AdPageChangeListener implements OnPageChangeListener {  
    	
    	/**
    	 * 页面滚动状态发生改变的时候触发
    	 */
        @Override  
        public void onPageScrollStateChanged(int arg0) {  
        }  
  
        /**
         * 页面滚动的时候触发
         */
        @Override  
        public void onPageScrolled(int arg0, float arg1, int arg2) {  
        }  
  
        /**
         * 页面选中的时候触发
         */
        @Override  
        public void onPageSelected(int arg0) {  
        	//获取当前显示的页面是哪个页面
            atomicInteger.getAndSet(arg0);  
            //重新设置原点布局集合
            for (int i = 0; i < imageViews.length; i++) {  
                imageViews[arg0]  
                        .setBackgroundResource(R.drawable.point_focused);  
                if (arg0 != i) {  
                    imageViews[i]  
                            .setBackgroundResource(R.drawable.point_unfocused);  
                }  
            }  
        }  
    } 
	private final class AdPageAdapter extends PagerAdapter {  
        private List<View> views = null;  
  
        /**
         * 初始化数据源, 即View数组
         */
        public AdPageAdapter(List<View> views) {  
            this.views = views;  
        }  
        
        /**
         * 从ViewPager中删除集合中对应索引的View对象
         */
        @Override  
        public void destroyItem(View container, int position, Object object) {  
            ((ViewPager) container).removeView(views.get(position));  
        }  
  
        /**
         * 获取ViewPager的个数
         */
        @Override  
        public int getCount() {  
            return views.size();  
        }  
  
        /**
         * 从View集合中获取对应索引的元素, 并添加到ViewPager中
         */
        @Override  
        public Object instantiateItem(View container, int position) {  
            ((ViewPager) container).addView(views.get(position), 0);  
            return views.get(position);  
        }  
  
        /**
         * 是否将显示的ViewPager页面与instantiateItem返回的对象进行关联
         * 这个方法是必须实现的
         */
        @Override  
        public boolean isViewFromObject(View view, Object object) {  
            return view == object;  
        }  
    }
}
