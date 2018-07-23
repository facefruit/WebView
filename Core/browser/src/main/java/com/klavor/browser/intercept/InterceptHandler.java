package com.klavor.browser.intercept;

import com.klavor.browser.WebViewProxy;
import com.klavor.browser.intf.Intercept;

import java.util.ArrayList;
import java.util.List;

public class InterceptHandler {
    private List<Intercept> mInterceptList = new ArrayList<>();

    public void addIntercept(Intercept intercept) {
        mInterceptList.add(intercept);
    }

    public void clear() {
        mInterceptList.clear();
    }

    public boolean intercept(WebViewProxy webViewProxy, String url) {
        for (Intercept intercept : mInterceptList) {
            if (intercept.isIntercept(webViewProxy, url)) {
                intercept.intercept(webViewProxy, url);
                return true;
            }
        }
        return false;
    }
}
