/**
* Copyright 2012 DFN-CERT Services GmbH
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
* 
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and 
* limitations under the License.
*/

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
