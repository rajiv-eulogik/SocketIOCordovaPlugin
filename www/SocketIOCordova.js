var exec = require('cordova/exec');

module.exports = {
    connectSocket: function(uri) {
        exec(success, error, "SocketIOCordova", "connectSocket", [uri]);
    },
    coolMethod: function() {
        exec(success, error, 'SocketIOCordova', 'coolMethod', [arg0]);
    }
};