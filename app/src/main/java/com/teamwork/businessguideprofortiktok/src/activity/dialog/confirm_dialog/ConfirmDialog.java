package com.teamwork.businessguideprofortiktok.src.activity.dialog.confirm_dialog;

import android.content.Context;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

import com.teamwork.businessguideprofortiktok.R;
import com.teamwork.businessguideprofortiktok.src.models.callback.CallbackInterface;

public class ConfirmDialog {
    public static void showDialogAcount(final Context context, String title, String Message, final CallbackInterface callbackInterface) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setMessage(Message);
        dialog.setTitle(title);
        dialog.setIcon(android.R.drawable.ic_menu_help);
        dialog.setNegativeButton(context.getResources().getString(R.string.txt_ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                callbackInterface.methodToCallback();
            }
        });

        dialog.setPositiveButton(context.getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        dialog.show();
    }
}
