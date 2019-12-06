package com.ciamiscode.esibi;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.view.View;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class ButtonSheetDialogAngka extends BottomSheetDialogFragment {
    @SuppressLint("RestrictedApi")
    @Override
    public void setupDialog(Dialog dialog, int style) {
        super.setupDialog(dialog, style);

        View contexView = View.inflate(getContext(), R.layout.dialog_angka, null);
        dialog.setContentView(contexView);
    }
}
