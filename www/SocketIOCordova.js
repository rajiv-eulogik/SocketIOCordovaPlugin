var exec = require('cordova/exec');

var SocketIOCordova = {
    connectSocket: function(uri, success, error) {
        exec(success, error, "SocketIOCordova", "connectSocket", [uri]);
    },

    socketOnEv: function(eventName, success, error) {
        exec(success, error, "SocketIOCordova", "socketOnEv", [eventName]);
    },

    check: function(eventName, success, error) {
        exec(success, error, "SocketIOCordova", "check", [eventName]);
    },

    disconnect: function(eventName, success, error) {
        exec(success, error, "SocketIOCordova", "disconnect", [eventName]);
    },

    recieveMessage: function(eventName, success, error) {
        exec(success, error, "SocketIOCordova", "recieveMessage", [eventName]);
    },

    dataAftergiftChat: function(eventName, success, error) {
        exec(success, error, "SocketIOCordova", "dataAftergiftChat", [eventName]);
    },

    messageStart: function(eventName, success, error) {
        exec(success, error, "SocketIOCordova", "messageStart", [eventName]);
    },

    chatEnd: function(eventName, success, error) {
        exec(success, error, "SocketIOCordova", "chatEnd", [eventName]);
    },

    liveScheduled: function(eventName, success, error) {
        exec(success, error, "SocketIOCordova", "liveScheduled", [eventName]);
    },
    
    liveUserJoin: function(eventName, success, error) {
        exec(success, error, "SocketIOCordova", "liveUserJoin", [eventName]);
    },
    
    liveCallConnected: function(eventName, success, error) {
        exec(success, error, "SocketIOCordova", "liveCallConnected", [eventName]);
    },
    
    liveAppCrash: function(eventName, success, error) {
        exec(success, error, "SocketIOCordova", "liveAppCrash", [eventName]);
    },
    
    liveFollowedReceive: function(eventName, success, error) {
        exec(success, error, "SocketIOCordova", "liveFollowedReceive", [eventName]);
    },
    
    receivedLiveId: function(eventName, success, error) {
        exec(success, error, "SocketIOCordova", "receivedLiveId", [eventName]);
    },
    
    liveCallRequest: function(eventName, success, error) {
        exec(success, error, "SocketIOCordova", "liveCallRequest", [eventName]);
    },
    
    liveCallEndedByUser: function(eventName, success, error) {
        exec(success, error, "SocketIOCordova", "liveCallEndedByUser", [eventName]);
    },
    
    giftData: function(eventName, success, error) {
        exec(success, error, "SocketIOCordova", "giftData", [eventName]);
    },
    
    dataAftergiftcall: function(eventName, success, error) {
        exec(success, error, "SocketIOCordova", "dataAftergiftcall", [eventName]);
    },
    
    callEnded: function(eventName, success, error) {
        exec(success, error, "SocketIOCordova", "callEnded", [eventName]);
    },
    
    appKilledUser: function(eventName, success, error) {
        exec(success, error, "SocketIOCordova", "appKilledUser", [eventName]);
    },
    
    resumeOnline: function(params, success, error) {
        exec(success, error, "SocketIOCordova", "resumeOnline", [params]);
    },

    changeIsOnline: function(params, success, error) {
        exec(success, error, "SocketIOCordova", "changeIsOnline", [params]);
    },

    messagePicked: function(params, success, error) {
        exec(success, error, "SocketIOCordova", "messagePicked", [params]);
    },

    sendAttachmentMessage: function(params, success, error) {
        exec(success, error, "SocketIOCordova", "sendAttachmentMessage", [params]);
    },

    chatAstroLeave: function(params, success, error) {
        exec(success, error, "SocketIOCordova", "chatAstroLeave", [params]);
    },

    sendMessage: function(params, success, error) {
        exec(success, error, "SocketIOCordova", "sendMessage", [params]);
    },

    chatLeave: function(params, success, error) {
        exec(success, error, "SocketIOCordova", "chatLeave", [params]);
    },

    liveChatData: function(params, success, error) {
        exec(success, error, "SocketIOCordova", "liveChatData", [params]);
    },

    liveCallReceived: function(params, success, error) {
        exec(success, error, "SocketIOCordova", "liveCallReceived", [params]);
    },

    liveCallEnded: function(params, success, error) {
        exec(success, error, "SocketIOCordova", "liveCallEnded", [params]);
    },

    disconnected: function(params, success, error) {
        exec(success, error, "SocketIOCordova", "disconnected", [params]);
    },

    userJoin: function(params, success, error) {
        exec(success, error, "SocketIOCordova", "userJoin", [params]);
    },

    startLive: function(params, success, error) {
        exec(success, error, "SocketIOCordova", "startLive", [params]);
    },
    
    callLeave: function(params, success, error) {
        exec(success, error, "SocketIOCordova", "callLeave", [params]);
    },
    
    callPicked: function(params, success, error) {
        exec(success, error, "SocketIOCordova", "callPicked", [params]);
    },
    
    callPick: function(params, success, error) {
        exec(success, error, "SocketIOCordova", "callPick", [params]);
    },

    removeEvent: function(event, success, error) {
        exec(success, error, "SocketIOCordova", "removeEvent", [params]);
    },

    removeAllEvents: function(success, error) {
        exec(success, error, "SocketIOCordova", "removeAllEvents", []);
    }
    
};

module.exports = SocketIOCordova;