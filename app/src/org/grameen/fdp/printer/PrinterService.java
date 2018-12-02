package org.grameen.fdp.printer;


import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.brother.ptouch.sdk.NetPrinter;
import com.brother.ptouch.sdk.Printer;
import com.brother.ptouch.sdk.PrinterInfo;
import com.google.gson.Gson;

import org.grameen.fdp.R;
import org.grameen.fdp.printer.common.Common;
import org.grameen.fdp.printer.common.MsgDialog;
import org.grameen.fdp.printer.common.MsgHandle;
import org.grameen.fdp.printer.printprocess.ImagePrint;
import org.grameen.fdp.printer.printprocess.PdfPrint;
import org.grameen.fdp.printer.printprocess.PrinterModelInfo;
import org.grameen.fdp.utility.CustomToast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AangJnr on 01, December, 2018 @ 2:18 PM
 * Work Mail cibrahim@grameenfoundation.org
 * Personal mail aang.jnr@gmail.com
 */

public class PrinterService {

    private final String PREFS_SSID = "ssid";
    private final String PREFS_SSID_KEY = "ssid_password";
    private final String PREFS_SSID_ID = "ssid_id";
    private final String PREFS_SHOULD_REMEMBER_SSID = "shouldRemember_ssid";
    private final String PREFS_PRINTER_PORT = "port";
    private final String PREFS_PRINTER_ADDRESS = "address";
    private final String PREFS_PRINTER_MAC_ADDRESS = "macAddress";
    private final String PREFS_PRINTER_LOCAL_NAME = "localName";
    private final String PREFS_PRINTER = "printer";


    private final String modelName = PrinterInfo.Model.PJ_773.name().replaceAll("_", "-");
    private final ImagePrint myPrint;

    private String TAG = "*** PrinterService";
    private String STORED_SSID;
    private String SSID;
    private String PASSWORD;

    private IntentFilter intentFilter;
    private SharedPreferences preferences;
    private WifiManager wifiManager;
    private ProgressDialog progressDialog;
    private MsgDialog msgDialog;
    private ArrayList<String> wifiList = new ArrayList<>();
    ;
    private AppCompatActivity mContext;

    private WifiConnectionReceiver mReceiver;
    private ArrayList<String> mItems;

    private String fileLocation;


    public PrinterService(AppCompatActivity context, String file) {
        mContext = context;
        msgDialog = new MsgDialog(context);

        fileLocation = file;

        progressDialog = new ProgressDialog(mContext, R.style.AppDialog);
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(true);

        preferences = PreferenceManager.getDefaultSharedPreferences(mContext);

        STORED_SSID = preferences.getString(PREFS_SSID, null);
        mReceiver = new WifiConnectionReceiver();

        //Declare other variables
        wifiManager = (WifiManager) mContext.getApplicationContext().getSystemService(Context.WIFI_SERVICE);


        MsgHandle mHandle = new MsgHandle(mContext, msgDialog);
        myPrint = new ImagePrint(mContext, mHandle, msgDialog);


        setPreferences();


        //Initializer


        preferences.edit().putString("orientation", PrinterInfo.Orientation.LANDSCAPE.toString()).apply();
        preferences.edit().putString("halftone", PrinterInfo.Halftone.ERRORDIFFUSION.toString()).apply();


    }


    public void initializeConnection() {

        if (isConnected(STORED_SSID)) {
            SSID = STORED_SSID;
            //Attempt print
            searchForPrinter();

        } else
            scanForNetworks();
    }


    private boolean isConnected(String ssid) {
        String v = wifiManager.getConnectionInfo().getSSID().replace("\"", "");

        Log.i(TAG, "&&&&&&&&&&&   Connected Network    = " + v);
        Log.i(TAG, "&&&&&&&&&&&   STORED SSID   = " + STORED_SSID);


        return (ssid != null && v.equals(ssid));

    }


    void searchForPrinter() {
        Log.i(TAG, "********* Printer Name is " + modelName);
        msgDialog.showMsgNoButton(
                mContext.getString(R.string.netPrinterListTitle_label),
                mContext.getString(R.string.search_printer));


        SearchThread searchPrinter = new SearchThread();
        searchPrinter.start();
    }


    private void print() {

        ArrayList<String> files = new ArrayList<>();
        files.add(fileLocation);

        // set the printing data
        myPrint.setFiles(files);

        // call function to print
        myPrint.print();

    }


    private void scanForNetworks() {

        intentFilter = new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);
        mContext.registerReceiver(mReceiver, intentFilter);

        showProgress("", "Scanning for networks...");

        if (!wifiManager.isWifiEnabled())
            wifiManager.setWifiEnabled(true);

        wifiManager.startScan();

    }

    private void attemptConnection() {
        intentFilter = new IntentFilter(WifiManager.NETWORK_STATE_CHANGED_ACTION);
        mContext.registerReceiver(mReceiver, intentFilter);


        showProgress("", "Connecting to wireless network...");

        WifiConfiguration conf = new WifiConfiguration();
        conf.SSID = String.format("\"%s\"", SSID);
        conf.preSharedKey = String.format("\"%s\"", PASSWORD);

        int NET_ID = wifiManager.addNetwork(conf);
        wifiManager.disconnect();
        wifiManager.enableNetwork(NET_ID, true);
        wifiManager.reconnect();

    }


    /**
     * printer searching thread
     */
    private class SearchThread extends Thread {

        /* search for the printer for 10 times until printer has been found. */
        @Override
        public void run() {

            for (int i = 0; i < Common.SEARCH_TIMES; i++) {
                // search for net printer.
                if (netPrinterList(i)) {
                    msgDialog.close();
                    print();
                    break;
                }
            }
            msgDialog.close();
        }
    }

    private boolean netPrinterList(int times) {

        boolean searchEnd = false;

        try {
            // clear the item list
            if (mItems != null) {
                mItems.clear();
            }

            // get net printers of the particular model
            mItems = new ArrayList<String>();
            Printer myPrinter = new Printer();
            PrinterInfo info = myPrinter.getPrinterInfo();
            info.enabledTethering = Boolean.parseBoolean(preferences
                    .getString("enabledTethering", "false"));
            myPrinter.setPrinterInfo(info);

            NetPrinter[] mNetPrinter = myPrinter.getNetPrinters(modelName);
            final int netPrinterCount = mNetPrinter.length;

            // when find printers,set the printers' information to the list.
            if (netPrinterCount > 0) {
                searchEnd = true;

                String dispBuff[] = new String[netPrinterCount];
                for (int i = 0; i < netPrinterCount; i++) {
                    dispBuff[i] = mNetPrinter[i].modelName + "\n\n"
                            + mNetPrinter[i].ipAddress + "\n"
                            + mNetPrinter[i].macAddress + "\n"
                            + mNetPrinter[i].serNo + "\n"
                            + mNetPrinter[i].nodeName;
                    mItems.add(dispBuff[i]);
                }
            } else if (netPrinterCount == 0 && times == (Common.SEARCH_TIMES - 1)) { // when no printer is found
                String dispBuff[] = new String[1];
                dispBuff[0] = mContext.getString(R.string.no_network_device);
                mItems.add(dispBuff[0]);
                searchEnd = true;
            }

            if (searchEnd) {
                // list the result of searching for net printer

                if (mNetPrinter.length > 0) {
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString(PREFS_PRINTER_PORT, PrinterInfo.Port.NET.toString());
                    editor.putString(PREFS_PRINTER_ADDRESS, mNetPrinter[0].ipAddress);
                    editor.putString(PREFS_PRINTER_MAC_ADDRESS, mNetPrinter[0].macAddress);
                    editor.putString(PREFS_PRINTER_LOCAL_NAME, "");
                    editor.putString(PREFS_PRINTER, mNetPrinter[0].modelName);
                    editor.apply();
                }
            }
        } catch (Exception e) {
        }

        return searchEnd;
    }

    public class WifiConnectionReceiver extends BroadcastReceiver {
        public WifiConnectionReceiver() {
        }

        public void onReceive(Context c, Intent intent) {
            Log.d(TAG, "*******************    onReceive() called with: intent = " + intent);

            String action = intent.getAction();
            if (action != null)

                switch (action) {
                    case WifiManager.NETWORK_STATE_CHANGED_ACTION:

                        dismissProgress();

                        if (isConnected(SSID)) {

                            if (preferences.getBoolean(PREFS_SHOULD_REMEMBER_SSID, false)) {
                                preferences.edit().putString(PREFS_SSID, SSID).apply();
                                preferences.edit().putString(PREFS_SSID_KEY, PASSWORD).apply();
                            } else {
                                preferences.edit().putString(PREFS_SSID, null).apply();
                                preferences.edit().putString(PREFS_SSID_KEY, null).apply();
                            }


                            searchForPrinter();

                            if (intentFilter != null)
                                mContext.unregisterReceiver(mReceiver);
                        } else {

                            CustomToast.makeToast(mContext, "Could not connect to network, Please try again", Toast.LENGTH_LONG).show();


                        }

                        break;


                    case WifiManager.SCAN_RESULTS_AVAILABLE_ACTION:


                        List<ScanResult> data = wifiManager.getScanResults();
                        Log.i(TAG, new Gson().toJson(data));

                        if (data == null)
                            wifiList = new ArrayList<>();
                        else {
                            for (int i = 0; i < data.size(); i++)
                                wifiList.add(data.get(i).SSID);
                        }


                        showListDialog();

                        if (intentFilter != null)
                            mContext.unregisterReceiver(mReceiver);

                        break;


                }
        }
    }

    private void showProgress(final String title, final String message) {
        dismissProgress();

        mContext.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressDialog.setTitle(title);
                progressDialog.setMessage(message);
                progressDialog.show();
            }
        });

    }

    private void dismissProgress() {
        if (progressDialog.isShowing())
            progressDialog.dismiss();
    }

    private void showListDialog() {
        dismissProgress();


        if (wifiList.size() == 0) {

            msgDialog.showAlertDialog("", "No Wireless networks found");

        } else {

            AlertDialog.Builder builderSingle = new AlertDialog.Builder(mContext, R.style.AppAlertDialog);
            builderSingle.setTitle("Select one option");

            final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_selectable_list_item, wifiList);

            builderSingle.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    SSID = wifiList.get(which);

                    if (STORED_SSID != null) {
                        if (STORED_SSID.equals(SSID)) {
                            PASSWORD = preferences.getString(PREFS_SSID_KEY, null);
                            //Connect to wifi, on wifi connected and remember password, store new creds.
                            attemptConnection();
                        } else {
                            //Show enter password dialog
                            showEnterPasswordDialog();

                        }

                    } else {
                        //Show enter password dialog
                        showEnterPasswordDialog();
                    }
                }
            });
            builderSingle.show();
        }


    }

    private void showEnterPasswordDialog() {

        dismissProgress();


        AlertDialog.Builder builder = new AlertDialog.Builder(mContext, R.style.AppAlertDialog);
        builder.setTitle("Please enter password for " + SSID);
        builder.setCancelable(true);

        LinearLayout layout = new LinearLayout(mContext);
        layout.setOrientation(LinearLayout.VERTICAL);

        layout.setPadding(20, 20, 20, 20);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(0, 0, 0, 20);


        final EditText editText = new EditText(mContext);
        editText.setLayoutParams(lp);


        final CheckBox checkBox = new CheckBox(mContext);
        checkBox.setText("Remember network");

        layout.addView(editText);
        layout.addView(checkBox);

        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layout.setLayoutParams(layoutParams);


        builder.setView(layout);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if (editText.getText().toString().length() < 6) {
                    editText.setError("Password must be 6 or more characters");
                } else {

                    editText.setError(null);
                    PASSWORD = editText.getText().toString();

                    preferences.edit().putBoolean(PREFS_SHOULD_REMEMBER_SSID, checkBox.isChecked()).apply();

                    //Connect to wifi

                    attemptConnection();

                    dialogInterface.dismiss();
                }
            }
        });
        builder.setNegativeButton("CANCEL", null);

        builder.show();


    }


    private void setPreferences() {
        preferences = PreferenceManager
                .getDefaultSharedPreferences(mContext);
        // initialization for print
        Printer printer = new Printer();
        PrinterInfo printerInfo = printer.getPrinterInfo();

        if (printerInfo == null) {
            printerInfo = new PrinterInfo();
            printer.setPrinterInfo(printerInfo);

        }
        if (preferences.getString("printerModel", "").equals("")) {

            PrinterModelInfo.Model model = PrinterModelInfo.Model.valueOf(PrinterInfo.Model.PJ_773.name());

            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("printerModel", model.name());
            editor.putString("port", PrinterInfo.Port.NET.toString());
            editor.putString("address", printerInfo.ipAddress);

            editor.putString("macAddress", printerInfo.macAddress);


            editor.putString("localName", printerInfo.getLocalName());

            // Override SDK default paper size
            editor.putString("paperSize", model.getDefaultPaperSize());

            editor.putString("orientation", printerInfo.orientation.toString());
            editor.putString("numberOfCopies",
                    Integer.toString(printerInfo.numberOfCopies));
            editor.putString("halftone", printerInfo.halftone.toString());
            editor.putString("printMode", printerInfo.printMode.toString());
            editor.putString("pjCarbon", Boolean.toString(printerInfo.pjCarbon));
            editor.putString("pjDensity",
                    Integer.toString(printerInfo.pjDensity));
            editor.putString("pjFeedMode", printerInfo.pjFeedMode.toString());
            editor.putString("align", printerInfo.align.toString());
            editor.putString("leftMargin",
                    Integer.toString(printerInfo.margin.left));
            editor.putString("valign", printerInfo.valign.toString());
            editor.putString("topMargin",
                    Integer.toString(printerInfo.margin.top));
            editor.putString("customPaperWidth",
                    Integer.toString(printerInfo.customPaperWidth));
            editor.putString("customPaperLength",
                    Integer.toString(printerInfo.customPaperLength));
            editor.putString("customFeed",
                    Integer.toString(printerInfo.customFeed));
            editor.putString("paperPosition",
                    printerInfo.paperPosition.toString());
            editor.putString("customSetting",
                    preferences.getString("customSetting", ""));
            editor.putString("rjDensity",
                    Integer.toString(printerInfo.rjDensity));
            editor.putString("rotate180",
                    Boolean.toString(printerInfo.rotate180));
            editor.putString("dashLine", Boolean.toString(printerInfo.dashLine));

            editor.putString("peelMode", Boolean.toString(printerInfo.peelMode));
            editor.putString("mode9", Boolean.toString(printerInfo.mode9));
            editor.putString("pjSpeed", Integer.toString(printerInfo.pjSpeed));
            editor.putString("pjPaperKind", printerInfo.pjPaperKind.toString());
            editor.putString("printerCase",
                    printerInfo.rollPrinterCase.toString());
            editor.putString("printQuality", printerInfo.printQuality.toString());
            editor.putString("skipStatusCheck",
                    Boolean.toString(printerInfo.skipStatusCheck));
            editor.putString("checkPrintEnd", printerInfo.checkPrintEnd.toString());
            editor.putString("imageThresholding",
                    Integer.toString(printerInfo.thresholdingValue));
            editor.putString("scaleValue",
                    Double.toString(printerInfo.scaleValue));
            editor.putString("trimTapeAfterData",
                    Boolean.toString(printerInfo.trimTapeAfterData));
            editor.putString("enabledTethering",
                    Boolean.toString(printerInfo.enabledTethering));


            editor.putString("processTimeout",
                    Integer.toString(printerInfo.timeout.processTimeoutSec));
            editor.putString("sendTimeout",
                    Integer.toString(printerInfo.timeout.sendTimeoutSec));
            editor.putString("receiveTimeout",
                    Integer.toString(printerInfo.timeout.receiveTimeoutSec));
            editor.putString("connectionTimeout",
                    Integer.toString(printerInfo.timeout.connectionWaitMSec));
            editor.putString("closeWaitTime",
                    Integer.toString(printerInfo.timeout.closeWaitDisusingStatusCheckSec));

            editor.putString("overwrite",
                    Boolean.toString(printerInfo.overwrite));
            editor.putString("savePrnPath", printerInfo.savePrnPath);
            editor.putString("softFocusing",
                    Boolean.toString(printerInfo.softFocusing));
            editor.putString("rawMode",
                    Boolean.toString(printerInfo.rawMode));
            editor.putString("workPath", printerInfo.workPath);
            editor.putString("useLegacyHalftoneEngine",
                    Boolean.toString(printerInfo.useLegacyHalftoneEngine));
            editor.apply();
        }

    }

}
