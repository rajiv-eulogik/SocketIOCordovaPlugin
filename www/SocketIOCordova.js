var exec = require('cordova/exec');

var SocketIOCordova = {
    connectSocket: function(uri) {
        exec(success, error, "SocketIOCordova", "connectSocket", [uri]);
    },
    coolMethod: function() {
        exec(success, error, 'SocketIOCordova', 'coolMethod', [arg0]);
    }
};

module.exports = SocketIOCordova;