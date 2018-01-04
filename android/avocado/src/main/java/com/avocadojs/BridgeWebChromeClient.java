package com.avocadojs;

import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class BridgeWebChromeClient extends WebChromeClient {

  @Override
  public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
    Dialogs.alert(view.getContext(), message, new Dialogs.OnResultListener() {
      @Override
      public void onResult(boolean value, boolean didCancel, String inputValue) {
        if(value) {
          result.confirm();
        } else {
          result.cancel();
        }
      }
    });

    return true;
  }

  @Override
  public boolean onJsConfirm(WebView view, String url, String message, final JsResult result) {
    Dialogs.confirm(view.getContext(), message, new Dialogs.OnResultListener() {
      @Override
      public void onResult(boolean value, boolean didCancel, String inputValue) {
        if(value) {
          result.confirm();
        } else {
          result.cancel();
        }
      }
    });

    return true;
  }

  @Override
  public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, final JsPromptResult result) {
    Dialogs.prompt(view.getContext(), message, new Dialogs.OnResultListener() {
      @Override
      public void onResult(boolean value, boolean didCancel, String inputValue) {
        if(value) {
          result.confirm(inputValue);
        } else {
          result.cancel();
        }
      }
    });

    return true;
  }
}