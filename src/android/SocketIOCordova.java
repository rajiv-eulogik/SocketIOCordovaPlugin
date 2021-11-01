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
    private Socket mSocket;
    {
        try {
            mSocket = IO.socket("ws://192.168.1.2:3004/");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public Socket getSocket() {
        return mSocket;
    }
    


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
        Socket webSockets = this.getSocket();
        webSockets.connect();      
        Log.d("URL: ", webSockets.toString());
        callbackContext.success(webSockets.toString());
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
