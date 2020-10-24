package com.teamwork.businessguideprofortiktok.src.activity.dialog.show_loading;

import android.app.Dialog;
import android.content.Context;
import android.view.View;

import com.teamwork.businessguideprofortiktok.R;

public class ShowLoadingDialog {
    public static Dialog getDialog(Context context){
        Dialog dialog = new Dialog(context);
        dialog.setContentView(View.inflate(context, R.layout.layout_dialog_loading,null));
        return  dialog;
    }
}
