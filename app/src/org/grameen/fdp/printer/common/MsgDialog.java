/**
 * Message Dialog
 *
 * @author Brother Industries, Ltd.
 * @version 2.2
 */

package org.grameen.fdp.printer.common;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Message;

import org.grameen.fdp.R;
import org.grameen.fdp.printer.printprocess.BasePrint;


@SuppressWarnings("ALL")
public class MsgDialog {

    private final Context mContext;
    private ProgressDialog mProgressDialog;
    private MsgHandle mHandle;

    public MsgDialog(Context context) {

        mContext = context;
    }

    /**
     * set handle
     */
    public void setHandle(MsgHandle handle) {

        mHandle = handle;
    }

    /**
     * show message
     */
    public void showStartMsgDialog(final String message) {

        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }

        mProgressDialog = new ProgressDialog(mContext, R.style.AppDialog);
        mProgressDialog.setMessage(message);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setCancelable(false);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressDialog.setButton(mContext.getString(R.string.cancel),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(final DialogInterface dialog,
                                        final int which) {
                        BasePrint.cancel();
                        Message msg = mHandle
                                .obtainMessage(Common.MSG_PRINT_CANCEL);
                        mHandle.sendMessage(msg);
                    }
                });

        mProgressDialog.show();

    }

    /**
     * show the end message
     */
    public void showPrintCompleteMsgDialog(final String message) {

        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }

        mProgressDialog = new ProgressDialog(mContext, R.style.AppDialog);

        mProgressDialog.setMessage(mContext.getString(R.string.close));
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setCancelable(false);
        mProgressDialog.setMessage(message);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressDialog.setButton(mContext.getString(R.string.ok),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.cancel();
                    }
                });
        mProgressDialog.show();

    }

    /**
     * update complete dialog's message
     */
    public void setMessage(String msg) {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.setMessage(msg);
        }
    }

    /**
     * show message
     */
    public void showMsgNoButton(final String title, final String message) {

        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.setMessage(message);
        }

        mProgressDialog = new ProgressDialog(mContext, R.style.AppDialog);
        mProgressDialog.setTitle(title);
        mProgressDialog.setMessage(message);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setCancelable(false);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressDialog.show();

    }

    /**
     * close dialog
     */
    public void close() {

        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    /**
     * show alert dialog
     */
    public void showAlertDialog(String title, final String msg) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(mContext, R.style.AppAlertDialog);
        dialog.setTitle(title);
        dialog.setMessage(msg);
        dialog.setCancelable(false);
        dialog.setPositiveButton(R.string.ok, null);
        dialog.show();
    }

    public void disableCancel() {
        mProgressDialog.getButton(mProgressDialog.BUTTON_POSITIVE).setEnabled(
                false);
    }
}
