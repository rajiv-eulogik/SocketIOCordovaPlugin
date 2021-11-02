var exec = require('cordova/exec');

var SocketIOCordova = {
    connectSocket: function(uri, success, error) {
        exec(success, error, "SocketIOCordova", "connectSocket", [uri]);
    },

    socketOnEv: function(eventName, success, error) {
        exec(success, error, "SocketIOCordova", "socketOnEv", [eventName]);
    }
};

module.exports = SocketIOCordova;