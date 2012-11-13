package de.dfncert.sai_dialog;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class SaiBroadcastReceiver extends BroadcastReceiver {

		/**
		 * Sample implementation of a SAI-Broadcastreceiver.
		 */
		@Override
		public void onReceive(Context context, Intent intent) {
			// just make sure we are getting the right intent (better safe than sorry)
				if( "de.dfncert.sai.install_hook".equals(intent.getAction())) {
					Intent i = new Intent(context, MainActivity.class);
					i.setData(intent.getData());
					i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					context.startActivity(i);
				}
		}
}
