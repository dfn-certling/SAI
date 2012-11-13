package de.dfncert.sai;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ToggleButton;

public class SAI extends Activity {
	
    private SharedPreferences pref;
    private ToggleButton toggle_button;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        toggle_button = (ToggleButton) findViewById(R.id.button1);
        
        toggle_button.setChecked(pref.getBoolean("use_sai", true));
        toggle_button.setOnClickListener(new OnClickListener() {
		public void onClick(View v) {
			SharedPreferences.Editor speditor = pref.edit();
			if(toggle_button.isChecked())
		    	    	speditor.putBoolean("use_sai", true);
			else
	    		    	speditor.putBoolean("use_sai", false);
    	    		speditor.commit();
		}
        });
    }
    
    protected void onResume(){
    	super.onResume();
    }
}
