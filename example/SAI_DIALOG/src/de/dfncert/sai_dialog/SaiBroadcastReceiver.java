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
