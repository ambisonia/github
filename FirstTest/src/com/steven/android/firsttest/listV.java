package com.steven.android.firsttest;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

//THIS IS TUTORIAL TWO!!!!!!!!!!!!!!!!!!
public class listV extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//create new list adapter that takes a string
		setListAdapter (new ArrayAdapter<String>(this, R.layout.single_item, Food));
		
		ListView list = getListView();
		list.setTextFilterEnabled(true);
		list.setOnItemClickListener(new OnItemClickListener(){

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Your selection is "+((TextView) arg1).getText(), Toast.LENGTH_SHORT).show();
			}
		
		});
	}
	
	static final String[] Food = new String[] {
		"Ice Cream", "Bacon", "Cheese", "Sandwich","Ice Cream", "Bacon", "Cheese", "Sandwich","Ice Cream", "Bacon", "Cheese", "Sandwich"
	};
	

}
