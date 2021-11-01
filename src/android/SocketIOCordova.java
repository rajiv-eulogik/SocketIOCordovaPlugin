package cordova.plugin.agora.sdk;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.net.Uri;
import java.net.URISyntaxException;
import android.util.Log;


import io.socket.client.IO;
import io.socket.client.Socket;

/**
 * This class echoes a string called from JavaScript.
 */
public class SocketIOCordova extends CordovaPlugin {
    private Socket socket;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("connectSocket")) {
            String uri = args.getString(0);
            this.connectSocket(uri, callbackContext);
            return true;
        }
        return false;
    }

    private void connectSocket(String url, CallbackContext callbackContext) {
        Log.d("URL: ", url.toString());
        try {
            socket = IO.socket(url); //CONNECTION MADE TO SOCKET SERVER
            Log.d("Socket--: ", socket.toString());
        }
        catch(URISyntaxException e) {
            Log.d("Socket--: ", e.toString());
            callbackContext.error("Expecting an URI:" + e);
        }
        socket.connect();
        Log.d("Socket: ", socket.toString());
        JSONObject obj = new JSONObject(socket.toString());
        final PluginResult result = new PluginResult(PluginResult.Status.OK, obj);
        callbackContext.sendPluginResult(result);
        // try {
        //     if(url != null) {
                
        //     }
        //     else {
        //         callbackContext.error("Expecting an URI");
        //     }
        // }
        // catch (Exception e) {
        //     callbackContext.error("Error: " + e.getMessage());
        // }
    }
}
