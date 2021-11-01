var exec = require('cordova/exec');

var SocketIOCordova = {
    connectSocket: function(uri, success, error) {
        exec(success, error, "SocketIOCordova", "connectSocket", [uri]);
    }
};

module.exports = SocketIOCordova;