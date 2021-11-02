
package cordova.plugin.agora.sdk;

import android.content.Context;
import android.content.Intent;
import android.app.Activity;

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
import io.socket.emitter.Emitter;

/**
 * This class echoes a string called from JavaScript.
 */
public class SocketIOCordova extends CordovaPlugin {
    private Socket socket;

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        try {
            socket = IO.socket("http://192.168.1.2:3004");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        socket.connect();
    }


    // public void socketEventsInit() {
    //     socket.on("androidDevice", emitterFn);
    // }


    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        Activity activity = cordova.getActivity();
        Intent intent = new Intent(activity, SocketIOConnection.class);
        if (action.equals("connectSocket")) {
            String uri = args.getString(0);
            Log.d("URL----: ", uri);
            this.connectSocket(uri, callbackContext, activity, intent);
            return true;
        }
        else if(action.equals("socketOnEv")) {
            String ev = args.getString(0);
            this.socketOnEv(ev, callbackContext);
            return true
        }
        return true;
    }

    int clicked = 0;
    private boolean connectSocket(String url, CallbackContext callbackContext, Activity activity, Intent intent) {
        clicked++;
        if(url != null) {
            JSONObject socketConn = new JSONObject();
            try {
                socketConn.put("socketId", socket.id());
                socketConn.put("socket", socket);
                socketConn.put("status", socket.connected());
                socketConn.put("active", socket.isActive());
            }
            catch (JSONException e) {
                callbackContext.error("ERROR IOException " + e.toString());
            }
            if(clicked == 2) {
                this.startService(activity, intent);
            }
            else if(clicked == 4){
                this.stopService(activity, intent);
            }
            callbackContext.success(socketConn);
            return true;
        }
        else {
            callbackContext.error("Expecting an URI");
            return false;
        }
    }

    private Emitter.Listener emitterFn = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            JSONObject data = (JSONObject) args[0]; //GET THE PARAMS
        }
    };

    private boolean socketOnEv(String eventName, CallbackContext callbackContext) {
        if(eventName != null) {
            socket.on(eventName, new Emitter.Listener() {
                @Override
                void call(final Object... args) {
                    JSONObject data = (JSONObject) args[0];
                    PluginResult result = new PluginResult(PluginResult.Status.OK, data);
                    result.setKeepCallback(true);
                    callbackContext.sendPluginResult(result);
                }
            });
        }
        else {
            callbackContext.error("Expecting an EventName");
        }
    }

    public void startService(Activity activity, Intent intent) {
        intent.setAction("start");
        activity.getApplicationContext().startForegroundService(intent);
    }

    public void stopService(Activity activity, Intent intent) {
        intent.setAction("stop");
        // Stop the service
        activity.getApplicationContext().startService(intent);
    }
}
