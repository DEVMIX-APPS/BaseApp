package br.com.devmix.baseapp.listener;

import android.support.design.widget.Snackbar;

/**
 * Created by katsuyagoto on 15/06/23.
 */
public interface OnMakeSnackbar {

    Snackbar onMakeSnackbar(CharSequence text, int duration);
}
