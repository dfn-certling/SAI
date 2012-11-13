package de.dfncert.sai;

import android.app.IntentService;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.util.Log;

import android.os.RemoteException;
import android.os.ServiceManager;
import android.content.pm.IPackageManager;

public class SaiService extends IntentService{

	private SharedPreferences pref;
	private IPackageManager pms;
	private Uri packageUri;

	public SaiService() {
		super("SaiService");
	}

	protected void onHandleIntent(Intent intent) {
		
	        pref = PreferenceManager.getDefaultSharedPreferences(this);
        
		packageUri = intent.getData();
		String packagePath = packageUri.getPath(); 
		String action = intent.getStringExtra("action");

		if(action.equals("verify") && ! pref.getBoolean("use_sai", true)) {
			installApp(packageUri);
		} else if(action.equals("verify") && pref.getBoolean("use_sai", true)) {
			Log.d(SaiService.class.getName(), "onHandleIntent startet with " + packagePath);
			
			Intent broadcastIntent = new Intent();
			broadcastIntent.setAction("de.dfncert.sai.install_hook");
			broadcastIntent.setData(packageUri);
	                broadcastIntent.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
				
			if(getPackageManager().queryBroadcastReceivers(broadcastIntent, 0).size() > 0) {
				sendBroadcast(broadcastIntent);
			} else {
				installApp(packageUri);
			}
		} else if(action.equals("install") && pref.getBoolean("use_sai", true)) {
			installApp(packageUri);
		} else if(action.equals("abort") && pref.getBoolean("use_sai", true)) {
			abortInstallation(packageUri);
		}
	}
		
	private void installApp(Uri packageUri) {
		pms = IPackageManager.Stub.asInterface(ServiceManager.getService("package"));
		try{
			pms.installPackageAfterSaiCheck(packageUri);
		} catch (RemoteException e){
			Log.d(SaiService.class.getName(), e.getMessage(), e);
		}
	}
	
	private void abortInstallation(Uri packageUri) {
		pms = IPackageManager.Stub.asInterface(ServiceManager.getService("package"));
		try{
			pms.abortInstallPackageAfterSaiCheck(packageUri);
		} catch (RemoteException e){
			Log.d(SaiService.class.getName(), e.getMessage(), e);
		}
	}
}
