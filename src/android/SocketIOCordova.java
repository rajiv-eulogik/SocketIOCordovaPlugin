package cordova.plugin.agora.sdk;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.net.Uri;
import java.net.URISyntaxException;


import io.socket.client.IO;
import io.socket.client.Socket;

/**
 * This class echoes a string called from JavaScript.
 */
public class SocketIOCordova extends CordovaPlugin {

    private Socket socket;

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

    private boolean connectSocket(String url, CallbackContext callbackContext) {
        try {
            if(url != null) {
                try {
                    socket = IO.socket(url); //CONNECTION MADE TO SOCKET SERVER
                }
                catch(URISyntaxException e) {
                    callbackContext.error("Expecting an URI:" + e);
                }
                socket.connect();
                callbackContext.success(socket.toString());
                return true;
            }
            else {
                callbackContext.error("Expecting an URI");
                return false;
            }
        }
        catch (Exception e) {
            callbackContext.error("Error: " + e.getMessage());
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
