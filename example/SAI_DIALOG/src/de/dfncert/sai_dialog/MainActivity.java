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
