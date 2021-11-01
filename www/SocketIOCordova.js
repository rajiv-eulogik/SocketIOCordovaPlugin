var exec = require('cordova/exec');

var SocketIOCordova = {
    connectSocket: function(uri, success, error) {
        exec(success, error, "SocketIOCordova", "connectSocket", [uri]);
    },
    coolMethod: function(arg0, success, error) {
        exec(success, error, 'SocketIOCordova', 'coolMethod', [arg0]);
    }
};

module.exports = SocketIOCordova;