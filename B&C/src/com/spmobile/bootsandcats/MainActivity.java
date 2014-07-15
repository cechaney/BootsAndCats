package com.spmobile.bootsandcats;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
	
	private Button bootsView;
	private Button catsView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
		
		init();
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		Configuration config = getResources().getConfiguration();
		
		LinearLayout controlView = (LinearLayout)this.findViewById(R.id.ControlView);
		
		if(Configuration.ORIENTATION_LANDSCAPE == config.orientation){
			controlView.setOrientation(LinearLayout.HORIZONTAL);
		}
		else{
			controlView.setOrientation(LinearLayout.VERTICAL);	
		}		
	}

	private void init(){
		
		bootsView = (Button)this.findViewById(R.id.BootsView);
		catsView = (Button)this.findViewById(R.id.CatsView);
		
		bootsView.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent me) {

				switch (me.getAction()){
					case MotionEvent.ACTION_DOWN:
						v.setBackgroundResource(R.drawable.pinkcircle);
						((Button) v).setTextColor(v.getResources().getColor(R.color.white));
						((Button) v).setTypeface(null,Typeface.BOLD);
						
						MediaPlayer mpStart = MediaPlayer.create(v.getContext(), R.raw.boot);

						mpStart.setOnCompletionListener(new OnCompletionListener() {
							
							@Override
							public void onCompletion(MediaPlayer mp) {
								mp.release();
							}
						});
						
						mpStart.start();

						break;
					case MotionEvent.ACTION_UP:
						v.setBackgroundResource(R.drawable.limecircle);
						((Button) v).setTextColor(v.getResources().getColor(R.color.black));
						((Button) v).setTypeface(null,Typeface.NORMAL);
						break;
					default:
						break;
					
				}
				
				return true;
			}
		});
		
		catsView.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent me) {

				switch (me.getAction()){
					case MotionEvent.ACTION_DOWN:
						v.setBackgroundResource(R.drawable.pinkcircle);
						((Button) v).setTextColor(v.getResources().getColor(R.color.white));
						((Button) v).setTypeface(null,Typeface.BOLD);
						
						MediaPlayer mpStart = MediaPlayer.create(v.getContext(), R.raw.cat);

						mpStart.setOnCompletionListener(new OnCompletionListener() {
							
							@Override
							public void onCompletion(MediaPlayer mp) {
								mp.release();
							}
						});
						
						mpStart.start();							

						break;
					case MotionEvent.ACTION_UP:
						v.setBackgroundResource(R.drawable.limecircle);
						((Button) v).setTextColor(v.getResources().getColor(R.color.black));
						((Button) v).setTypeface(null,Typeface.NORMAL);
						break;
					default:
						break;
					
				}
				
				return true;
			}
		});		
	}

}
