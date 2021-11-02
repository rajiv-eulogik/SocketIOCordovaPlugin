package cordova.plugin.agora.sdk;

import android.app.Application;
import io.socket.client.IO;
import io.socket.client.Socket;

import java.net.URISyntaxException;

public class SocketIOConnection extends Application {

    private Socket mSocket;
   
    @Override
    public void onCreate() {
        super.onCreate();
        try {
            mSocket = IO.socket("http://192.168.1.2:3004");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public Socket getSocket() {
        return mSocket;
    }
}