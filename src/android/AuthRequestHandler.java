package com.handler.auth;

import org.apache.cordova.*;

public class AuthRequestHandler extends CordovaPlugin {
    final String jsCommand = "cordova.fireWindowEvent('crosswalk.auth_request');";

    public boolean onReceivedHttpAuthRequest(CordovaWebView view, final ICordovaHttpAuthHandler handler, String host, String realm) {
      if(view != null) {
          if (VERSION.SDK_INT >= VERSION_CODES.KITKAT) {
              webView.sendJavascript(jsCommand);
          } else {
              webView.loadUrl("javascript:" + jsCommand);
          }
      }
      return true;
    }
}
