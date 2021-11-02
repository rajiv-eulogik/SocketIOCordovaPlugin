
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
import io.socket.emitter.Emitter;

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

    private boolean connectSocket(String url, CallbackContext callbackContext) {
        if(url != null) {
            JSONObject socketConn = new JSONObject();
            SocketIOConnection socketIO = (SocketIOConnection)getApplication();
            socket = socketIO.getSocket();
            try {
                socketConn.put("socketId", socket.id());
                socketConn.put("socket", socket);
                socketConn.put("status", socket.connected());
                socketConn.put("active", socket.isActive());
            }
            catch (JSONException e) {
                callbackContext.error("ERROR IOException " + e.toString());
            }
            // try {
            //     socket = IO.socket(url); //CONNECTION MADE TO SOCKET SERVER
            //     socket.connect();
            //     try {
            //         socketConn.put("socketId", socket.id());
            //         socketConn.put("socket", socket);
            //         socketConn.put("status", socket.connected());
            //         socketConn.put("active", socket.isActive());
            //     }
            //     catch (JSONException e) {
            //         callbackContext.error("ERROR IOException " + e.toString());
            //     }
                // socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
                //     @Override
                //     public void call(Object... args) {
                //         System.out.println(socket.connected()); // true
                //     }
                // });
                // callbackContext.success(socketConn);
            // }
            // catch(URISyntaxException e) {
            //     callbackContext.error("Expecting an URI:" + e.toString());
            // }
            callbackContext.success(socketConn);
            return true;
        }
        else {
            callbackContext.error("Expecting an URI");
            return false;
        }
    }
}
