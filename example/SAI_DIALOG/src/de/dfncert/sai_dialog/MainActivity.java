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

package de.dfncert.sai_dialog;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final Activity mActivity = this;
        final Uri packageURI = getIntent().getData();
        
        Button installButton = (Button) findViewById(R.id.install);
        Button cancelButton = (Button) findViewById(R.id.cancel);
        TextView content = (TextView) findViewById(R.id.content);
        
    	content.setText("Path of package: " + packageURI);

    	installButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				/**
				 * After operating on the APK send this Intent to the SaiService to install the APK
				 */
				Intent intent = new Intent();
				intent.setComponent(new ComponentName("de.dfncert.sai", "de.dfncert.sai.SaiService"));
				intent.setData(packageURI);
				intent.putExtra("action", "install");
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				mActivity.startService(intent);
				mActivity.finish();
			}
		});
        
        cancelButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				/**
				 * After operating on the APK send this Intent to the SaiService to abort the installation of the APK
				 */
				Intent intent = new Intent();
				intent.setComponent(new ComponentName("de.dfncert.sai", "de.dfncert.sai.SaiService"));
				intent.setData(packageURI);
				intent.putExtra("action", "abort");
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				mActivity.startService(intent);
				mActivity.finish();
			}
		});
    }
}
