
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

import android.os.Bundle;  
import android.widget.Toast;  

/**
 * This class echoes a string called from JavaScript.
 */
public class SocketIOCordova extends CordovaPlugin {
    private Socket socket;

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
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
            Log.i("URL----: ", uri);
            this.connectSocket(uri, callbackContext, activity, intent);
            return true;
        }
        else if(action.equals("check")) {
            String ev = args.getString(0);
            socket.on(ev, new Emitter.Listener() {
                @Override
                public void call(final Object... args) {
                    JSONObject data = (JSONObject) args[0];
                    PluginResult result = new PluginResult(PluginResult.Status.OK, data);
                    result.setKeepCallback(true);
                    callbackContext.sendPluginResult(result);
                }
            });
            return true;
        }
        else if(action.equals("disconnect")) {
            String ev = args.getString(0);
            socket.on(ev, new Emitter.Listener() {
                @Override
                public void call(final Object... args) {
                    JSONObject data = (JSONObject) args[0];
                    PluginResult result = new PluginResult(PluginResult.Status.OK, data);
                    result.setKeepCallback(true);
                    callbackContext.sendPluginResult(result);
                }
            });
            return true;
        }
        else if(action.equals("recieveMessage")) {
            String ev = args.getString(0);
            socket.on(ev, new Emitter.Listener() {
                @Override
                public void call(final Object... args) {
                    JSONObject data = (JSONObject) args[0];
                    PluginResult result = new PluginResult(PluginResult.Status.OK, data);
                    result.setKeepCallback(true);
                    callbackContext.sendPluginResult(result);
                }
            });
            return true;
        }
        else if(action.equals("dataAftergiftChat")) {
            String ev = args.getString(0);
            socket.on(ev, new Emitter.Listener() {
                @Override
                public void call(final Object... args) {
                    JSONObject data = (JSONObject) args[0];
                    PluginResult result = new PluginResult(PluginResult.Status.OK, data);
                    result.setKeepCallback(true);
                    callbackContext.sendPluginResult(result);
                }
            });
            return true;
        }
        else if(action.equals("messageStart")) {
            String ev = args.getString(0);
            socket.on(ev, new Emitter.Listener() {
                @Override
                public void call(final Object... args) {
                    JSONObject data = (JSONObject) args[0];
                    PluginResult result = new PluginResult(PluginResult.Status.OK, data);
                    result.setKeepCallback(true);
                    callbackContext.sendPluginResult(result);
                }
            });
            return true;
        }
        else if(action.equals("chatEnd")) {
            String ev = args.getString(0);
            socket.on(ev, new Emitter.Listener() {
                @Override
                public void call(final Object... args) {
                    JSONObject data = (JSONObject) args[0];
                    PluginResult result = new PluginResult(PluginResult.Status.OK, data);
                    result.setKeepCallback(true);
                    callbackContext.sendPluginResult(result);
                }
            });
            return true;
        }
        else if(action.equals("liveScheduled")) {
            String ev = args.getString(0);
            socket.on(ev, new Emitter.Listener() {
                @Override
                public void call(final Object... args) {
                    JSONObject data = (JSONObject) args[0];
                    PluginResult result = new PluginResult(PluginResult.Status.OK, data);
                    result.setKeepCallback(true);
                    callbackContext.sendPluginResult(result);
                }
            });
            return true;
        }
        else if(action.equals("liveUserJoin")) {
            String ev = args.getString(0);
            socket.on(ev, new Emitter.Listener() {
                @Override
                public void call(final Object... args) {
                    JSONObject data = (JSONObject) args[0];
                    PluginResult result = new PluginResult(PluginResult.Status.OK, data);
                    result.setKeepCallback(true);
                    callbackContext.sendPluginResult(result);
                }
            });
            return true;
        }
        else if(action.equals("liveCallConnected")) {
            String ev = args.getString(0);
            socket.on(ev, new Emitter.Listener() {
                @Override
                public void call(final Object... args) {
                    JSONObject data = (JSONObject) args[0];
                    PluginResult result = new PluginResult(PluginResult.Status.OK, data);
                    result.setKeepCallback(true);
                    callbackContext.sendPluginResult(result);
                }
            });
            return true;
        }
        else if(action.equals("liveAppCrash")) {
            String ev = args.getString(0);
            socket.on(ev, new Emitter.Listener() {
                @Override
                public void call(final Object... args) {
                    JSONObject data = (JSONObject) args[0];
                    PluginResult result = new PluginResult(PluginResult.Status.OK, data);
                    result.setKeepCallback(true);
                    callbackContext.sendPluginResult(result);
                }
            });
            return true;
        }
        else if(action.equals("liveFollowedReceive")) {
            String ev = args.getString(0);
            socket.on(ev, new Emitter.Listener() {
                @Override
                public void call(final Object... args) {
                    JSONObject data = (JSONObject) args[0];
                    PluginResult result = new PluginResult(PluginResult.Status.OK, data);
                    result.setKeepCallback(true);
                    callbackContext.sendPluginResult(result);
                }
            });
            return true;
        }
        else if(action.equals("receivedLiveId")) {
            String ev = args.getString(0);
            socket.on(ev, new Emitter.Listener() {
                @Override
                public void call(final Object... args) {
                    JSONObject data = (JSONObject) args[0];
                    PluginResult result = new PluginResult(PluginResult.Status.OK, data);
                    result.setKeepCallback(true);
                    callbackContext.sendPluginResult(result);
                }
            });
            return true;
        }
        else if(action.equals("liveCallRequest")) {
            String ev = args.getString(0);
            socket.on(ev, new Emitter.Listener() {
                @Override
                public void call(final Object... args) {
                    JSONObject data = (JSONObject) args[0];
                    PluginResult result = new PluginResult(PluginResult.Status.OK, data);
                    result.setKeepCallback(true);
                    callbackContext.sendPluginResult(result);
                }
            });
            return true;
        }
        else if(action.equals("liveCallEndedByUser")) {
            String ev = args.getString(0);
            socket.on(ev, new Emitter.Listener() {
                @Override
                public void call(final Object... args) {
                    JSONObject data = (JSONObject) args[0];
                    PluginResult result = new PluginResult(PluginResult.Status.OK, data);
                    result.setKeepCallback(true);
                    callbackContext.sendPluginResult(result);
                }
            });
            return true;
        }
        else if(action.equals("giftData")) {
            String ev = args.getString(0);
            socket.on(ev, new Emitter.Listener() {
                @Override
                public void call(final Object... args) {
                    JSONObject data = (JSONObject) args[0];
                    PluginResult result = new PluginResult(PluginResult.Status.OK, data);
                    result.setKeepCallback(true);
                    callbackContext.sendPluginResult(result);
                }
            });
            return true;
        }
        else if(action.equals("dataAftergiftcall")) {
            String ev = args.getString(0);
            socket.on(ev, new Emitter.Listener() {
                @Override
                public void call(final Object... args) {
                    JSONObject data = (JSONObject) args[0];
                    PluginResult result = new PluginResult(PluginResult.Status.OK, data);
                    result.setKeepCallback(true);
                    callbackContext.sendPluginResult(result);
                }
            });
            return true;
        }
        else if(action.equals("callEnded")) {
            String ev = args.getString(0);
            socket.on(ev, new Emitter.Listener() {
                @Override
                public void call(final Object... args) {
                    JSONObject data = (JSONObject) args[0];
                    PluginResult result = new PluginResult(PluginResult.Status.OK, data);
                    result.setKeepCallback(true);
                    callbackContext.sendPluginResult(result);
                }
            });
            return true;
        }
        else if(action.equals("appKilledUser")) {
            String ev = args.getString(0);
            socket.on(ev, new Emitter.Listener() {
                @Override
                public void call(final Object... args) {
                    JSONObject data = (JSONObject) args[0];
                    PluginResult result = new PluginResult(PluginResult.Status.OK, data);
                    result.setKeepCallback(true);
                    callbackContext.sendPluginResult(result);
                }
            });
            return true;
        }

        else if(action.equals("connection")) {
            JSONObject emitBody = (JSONObject) args[0];
            socket.emit("connection", emitBody)
            return true;
        }
        else if(action.equals("resumeOnline")) {
            JSONObject emitBody = (JSONObject) args[0];
            socket.emit("resumeOnline", emitBody)
            return true;
        }
        else if(action.equals("changeIsOnline")) {
            JSONObject emitBody = (JSONObject) args[0];
            socket.emit("changeIsOnline", emitBody)
            return true;
        }
        else if(action.equals("messagePicked")) {
            JSONObject emitBody = (JSONObject) args[0];
            socket.emit("message pick", emitBody)
            return true;
        }
        else if(action.equals("sendAttachmentMessage")) {
            JSONObject emitBody = (JSONObject) args[0];
            socket.emit("sendAttachmentMessage", emitBody)
            return true;
        }
        else if(action.equals("chatAstroLeave")) {
            JSONObject emitBody = (JSONObject) args[0];
            socket.emit("chatAstroLeave", emitBody)
            return true;
        }
        else if(action.equals("sendMessage")) {
            JSONObject emitBody = (JSONObject) args[0];
            socket.emit("sendMessage", emitBody)
            return true;
        }
        else if(action.equals("chatLeave")) {
            JSONObject emitBody = (JSONObject) args[0];
            socket.emit("chatLeave", emitBody)
            return true;
        }
        else if(action.equals("liveChatData")) {
            JSONObject emitBody = (JSONObject) args[0];
            socket.emit("liveChatData", emitBody)
            return true;
        }
        else if(action.equals("liveCallReceived")) {
            JSONObject emitBody = (JSONObject) args[0];
            socket.emit("liveCallReceived", emitBody)
            return true;
        }
        else if(action.equals("liveCallEnded")) {
            JSONObject emitBody = (JSONObject) args[0];
            socket.emit("liveCallEnded", emitBody)
            return true;
        }
        else if(action.equals("disconnected")) {
            JSONObject emitBody = (JSONObject) args[0];
            socket.emit("disconnected", emitBody)
            return true;
        }
        else if(action.equals("userJoin")) {
            JSONObject emitBody = (JSONObject) args[0];
            socket.emit("userJoin", emitBody)
            return true;
        }
        else if(action.equals("startLive")) {
            JSONObject emitBody = (JSONObject) args[0];
            socket.emit("startLive", emitBody)
            return true;
        }
        else if(action.equals("callLeave")) {
            JSONObject emitBody = (JSONObject) args[0];
            socket.emit("call leave", emitBody)
            return true;
        }
        else if(action.equals("callPicked")) {
            JSONObject emitBody = (JSONObject) args[0];
            socket.emit("call picked", emitBody)
            return true;
        }
        else if(action.equals("callPick")) {
            JSONObject emitBody = (JSONObject) args[0];
            socket.emit("call pick", emitBody)
            return true;
        }
        else if(action.equals("removeEvent")) {
            String ev = args.getString(0);
            socket.off(ev);
            return true;
        }
        else if(action.equals("removeAllEvents")) {
            socket.off();
            return true;
        }
        return true;
    }

    int clicked = 0;
    private boolean connectSocket(String url, CallbackContext callbackContext, Activity activity, Intent intent) {
        clicked++;
        if(url != null) {
            try {
                socket = IO.socket(url);
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
            socket.connect();
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
            this.startService(activity, intent);
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
                // Toast.makeText(getApplicationContext(),"Hello Javatpoint",Toast.LENGTH_SHORT).show();
                @Override
                public void call(final Object... args) {
                    JSONObject data = (JSONObject) args[0];
                    PluginResult result = new PluginResult(PluginResult.Status.OK, data);
                    result.setKeepCallback(true);
                    callbackContext.sendPluginResult(result);
                }
            });
            return true;
        }
        else {
            callbackContext.error("Expecting an EventName");
            return false;
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
