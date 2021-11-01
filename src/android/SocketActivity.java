package cordova.plugin.agora.sdk;

import android.app.Activity;
import android.os.Bundle;



public class SocketActivity extends Activity {

    public Socket mSocket;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String package_name = getApplication().getPackageName();
        setContentView(getApplication().getResources().getIdentifier("socket_activity", "layout", package_name));
        SocketIOConnection socketIO = (SocketIOConnection) getApplication();
        mSocket = socketIO.getSocket();
    }
}