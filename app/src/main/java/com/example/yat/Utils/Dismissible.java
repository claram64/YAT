package com.example.yat.Utils;

public interface Dismissible {
    interface OnDismissedListener {
        void onDismissed();
    }

    void dismiss(OnDismissedListener listener);
}