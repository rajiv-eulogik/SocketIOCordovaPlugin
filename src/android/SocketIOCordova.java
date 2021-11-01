package cordova.plugin.agora.sdk;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.net.Uri;


import io.socket.client.IO;
import io.socket.client.Socket;

/**
 * This class echoes a string called from JavaScript.
 */
public class SocketIOCordova extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("coolMethod")) {
            String message = args.getString(0);
            this.coolMethod(message, callbackContext);
            return true;
        }
        else if (action.equals("connectSocket")) {
            String uri = args.getString(0);
            this.connectSocket(uri, callbackContext);
            return true;
        }
        return false;
    }

    private void connectSocket(String url, CallbackContext callbackContext) {
        if(url != null) {
            Uri uri = Uri.parse(url);
            Socket socket = IO.socket(uri); //CONNECTION MADE TO SOCKET SERVER
            callbackContext.success(socket.toString());
        }
        else {
            callbackContext.error("Expecting an URI");
        }
    } 


    private void coolMethod(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
