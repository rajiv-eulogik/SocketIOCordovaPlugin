package cordova.plugin.agora.sdk;

import android.content.Context;
import android.content.Intent;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaInterface;
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
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
    }


    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        // Context context = cordova.getActivity().getApplicationContext();
        if (action.equals("connectSocket")) {
            String uri = args.getString(0);
            Log.d("URL----: ", uri);
            this.connectSocket(uri, callbackContext);
            return true;
        }
        return true;
    }

    // private void openNewActivity(Context context) {
    //     Intent intent = new Intent(context, SocketActivity.class);
    //     this.cordova.getActivity().startActivity(intent);
    // }

    private void connectSocket(String url, CallbackContext callbackContext) {
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
}
