package com.junkakeno.sportsbuddy.View;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.junkakeno.sportsbuddy.R;


public class ProgressBarDialog extends DialogFragment {

    private RelativeLayout progressBar;
    private boolean startedShowing;

    public ProgressBarDialog() {
        super();
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_progress,null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        Dialog dialog =builder.setView(view).create();

        /*Make the dialog none-clickable.*/
        setCancelable(false);

        return dialog;
    }

    @Override
    public void onStart() {
        super.onStart();
        progressBar = getDialog().findViewById(R.id.progress);

        if (getDialog().getWindow() != null) {
            /*Set the dialog view properties.*/
            int width = ViewGroup.LayoutParams.WRAP_CONTENT;
            int height = ViewGroup.LayoutParams.WRAP_CONTENT;
            getDialog().getWindow().setLayout(width, height);
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
    }

    @Override
    public void show(final FragmentManager manager, final String tag) {
        startedShowing = false;
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                showDialog(manager,tag);
            }
        });

    }

    private void showDialog(FragmentManager manager, String tag) {
        startedShowing = true;
        FragmentTransaction ft = manager.beginTransaction();
        ft.add(this, tag);
        ft.commitAllowingStateLoss();
    }

    public void cancel() {

        if (startedShowing) {
            if (progressBar != null) {
                new Handler().post(new Runnable() {
                    @Override
                    public void run() {
                        dismissAllowingStateLoss();
                    }
                });
            }
        }
    }
}
