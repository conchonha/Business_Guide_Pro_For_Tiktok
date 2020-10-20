package com.teamwork.businessguideprofortiktok.src.resource.dialog.show_loading;

import android.app.Dialog;
import android.content.Context;

import com.teamwork.businessguideprofortiktok.R;

public class ShowLoadingDialog {
    public static Dialog getDialog(Context context){
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.layout_dialog_loading);
        return  dialog;
    }
}
