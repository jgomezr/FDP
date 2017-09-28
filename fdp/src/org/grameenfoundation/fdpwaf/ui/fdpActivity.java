package org.grameenfoundation.fdpwaf.ui;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.rest.RestClient;
import com.salesforce.androidsdk.smartstore.store.SmartStore;
import com.salesforce.androidsdk.smartsync.app.SmartSyncSDKManager;
import com.salesforce.androidsdk.smartsync.manager.SyncManager;
import com.salesforce.androidsdk.smartsync.util.Constants;
import com.salesforce.androidsdk.ui.SalesforceActivity;

import org.grameenfoundation.fdpwaf.MainActivity;
import org.grameenfoundation.fdpwaf.R;
import org.grameenfoundation.fdpwaf.loaders.ContactDetailLoader;
import org.grameenfoundation.fdpwaf.loaders.ContactListLoader;
import org.grameenfoundation.fdpwaf.objects.ContactObject;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;

/**
 * Created by julian_Gf on 7/4/2016.
 */
public class fdpActivity  extends SalesforceActivity implements LoaderManager.LoaderCallbacks<ContactObject> {
    private static final int CONTACT_DETAIL_LOADER_ID = 2;
    private static final String TAG = "SmartSyncExplorer: fdpActivity";
    private UserAccount curAccount;
    private String objectId;
    private String objectTitle;
    private String objNameKey;
    private ContactObject sObject;
    public static final String OBJECT_ID_KEY = "object_id";
    public static final String OBJECT_TITLE_KEY = "object_title";
    public static final String OBJECT_NAME_KEY = "object_name";
    public static final String YEAR_LAUNCH = "year_launch";
    private EditText comt1,comt2,comt3,comt4,comt5,comt6,comt7,comt8,comt9,comt10,comments;
    private Spinner st1,st2,st3,st4,st5,st6,st7,st8,st9,st10;
    private TextView found0,found1,found2,found3,found4,found5,found6,found7,pyl0,pyl1,pyl2,pyl3,pyl4,pyl5,pyl6,pyl7,plot1,plot2,plot3,plot4,plot5,plot6,plot7,plot8,plot9,plot10,income10,income20,income30,income40,income50,income60,income70,income80,income90,income100,income11,income21,income31,income41,income51,income61,income71,income81,income91,income101,income12,income22,income32,income42,income52,income62,income72,income82,income92,income102,income13,income23,income33,income43,income53,income63,income73,income83,income93,income103,income14,income24,income34,income44,income54,income64,income74,income84,income94,income104,income15,income25,income35,income45,income55,income65,income75,income85,income95,income105,income16,income26,income36,income46,income56,income66,income76,income86,income96,income106,income17,income27,income37,income47,income57,income67,income77,income87,income97,income107,cost11,labor11,cost21,labor21,cost31,labor31,cost41,labor41,cost51,labor51,cost61,labor61,cost71,labor71,cost81,labor81,cost91,labor91,cost101,labor101,cost12,labor12,cost22,labor22,cost32,labor32,cost42,labor42,cost52,labor52,cost62,labor62,cost72,labor72,cost82,labor82,cost92,labor92,cost102,labor102,cost13,labor13,cost23,labor23,cost33,labor33,cost43,labor43,cost53,labor53,cost63,labor63,cost73,labor73,cost83,labor83,cost93,labor93,cost103,labor103,cost14,labor14,cost24,labor24,cost34,labor34,cost44,labor44,cost54,labor54,cost64,labor64,cost74,labor74,cost84,labor84,cost94,labor94,cost104,labor104,cost15,labor15,cost25,labor25,cost35,labor35,cost45,labor45,cost55,labor55,cost65,labor65,cost75,labor75,cost85,labor85,cost95,labor95,cost105,labor105,cost16,labor16,cost26,labor26,cost36,labor36,cost46,labor46,cost56,labor56,cost66,labor66,cost76,labor76,cost86,labor86,cost96,labor96,cost106,labor106,cost17,labor17,cost27,labor27,cost37,labor37,cost47,labor47,cost57,labor57,cost67,labor67,cost77,labor77,cost87,labor87,cost97,labor97,cost107,labor107,labor10,cost10,labor20,cost20,labor30,cost30,labor40,cost40,labor50,cost50,labor60,cost60,labor70,cost70,labor80,cost80,labor90,cost90,labor100,cost100;
    public fdpFragment fragment1,fragment2,fragment3,fragment4,fragment5,fragment6,fragment7,fragment8,fragment9,fragment10;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fdp);
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getActionBar().setTitle(R.string.fdpActivityTitle);
        final Intent launchIntent = getIntent();
        if (launchIntent != null) {
            objectId = launchIntent.getStringExtra(plotActivity.OBJECT_ID_KEY);
            objectTitle = launchIntent.getStringExtra(plotActivity.OBJECT_TITLE_KEY);
            objNameKey = launchIntent.getStringExtra(plotActivity.OBJECT_NAME_KEY);
        }
        comments = (EditText) findViewById(R.id.reasonNotAgree_field);
        fragment1 = (fdpFragment) getFragmentManager().findFragmentById(R.id.fgPlot1);
        fragment2 = (fdpFragment) getFragmentManager().findFragmentById(R.id.fgPlot2);
        fragment3 = (fdpFragment) getFragmentManager().findFragmentById(R.id.fgPlot3);
        fragment4 = (fdpFragment) getFragmentManager().findFragmentById(R.id.fgPlot4);
        fragment5 = (fdpFragment) getFragmentManager().findFragmentById(R.id.fgPlot5);
        fragment6 = (fdpFragment) getFragmentManager().findFragmentById(R.id.fgPlot6);
        fragment7 = (fdpFragment) getFragmentManager().findFragmentById(R.id.fgPlot7);
        fragment8 = (fdpFragment) getFragmentManager().findFragmentById(R.id.fgPlot8);
        fragment9 = (fdpFragment) getFragmentManager().findFragmentById(R.id.fgPlot9);
        fragment10 = (fdpFragment) getFragmentManager().findFragmentById(R.id.fgPlot10);
        plot1 = (TextView) fragment1.getView().findViewById(R.id.plot);
        plot2 = (TextView) fragment2.getView().findViewById(R.id.plot);
        plot3 = (TextView) fragment3.getView().findViewById(R.id.plot);
        plot4 = (TextView) fragment4.getView().findViewById(R.id.plot);
        plot5 = (TextView) fragment5.getView().findViewById(R.id.plot);
        plot6 = (TextView) fragment6.getView().findViewById(R.id.plot);
        plot7 = (TextView) fragment7.getView().findViewById(R.id.plot);
        plot8 = (TextView) fragment8.getView().findViewById(R.id.plot);
        plot9 = (TextView) fragment9.getView().findViewById(R.id.plot);
        plot10 = (TextView) fragment10.getView().findViewById(R.id.plot);
        st1 = (Spinner)fragment1.getView().findViewById(R.id.startP_field);
        st2 = (Spinner)fragment2.getView().findViewById(R.id.startP_field);
        st3 = (Spinner)fragment3.getView().findViewById(R.id.startP_field);
        st4 = (Spinner)fragment4.getView().findViewById(R.id.startP_field);
        st5 = (Spinner)fragment5.getView().findViewById(R.id.startP_field);
        st6 = (Spinner)fragment6.getView().findViewById(R.id.startP_field);
        st7 = (Spinner)fragment7.getView().findViewById(R.id.startP_field);
        st8 = (Spinner)fragment8.getView().findViewById(R.id.startP_field);
        st9 = (Spinner)fragment9.getView().findViewById(R.id.startP_field);
        st10 = (Spinner)fragment10.getView().findViewById(R.id.startP_field);
        income10  =(TextView) fragment1.getView().findViewById(R.id.incomeY0P);
        income11 =(TextView) fragment1.getView().findViewById(R.id.incomeY1P);
        income12 =(TextView) fragment1.getView().findViewById(R.id.incomeY2P);
        income13 =(TextView) fragment1.getView().findViewById(R.id.incomeY3P);
        income14 =(TextView) fragment1.getView().findViewById(R.id.incomeY4P);
        income15 =(TextView) fragment1.getView().findViewById(R.id.incomeY5P);
        income16 =(TextView) fragment1.getView().findViewById(R.id.incomeY6P);
        income17 =(TextView) fragment1.getView().findViewById(R.id.incomeY7P);
        cost10 =(TextView) fragment1.getView().findViewById(R.id.costY0P);
        cost11 =(TextView) fragment1.getView().findViewById(R.id.costY1P);
        cost12 =(TextView) fragment1.getView().findViewById(R.id.costY2P);
        cost13 =(TextView) fragment1.getView().findViewById(R.id.costY3P);
        cost14 =(TextView) fragment1.getView().findViewById(R.id.costY4P);
        cost15 =(TextView) fragment1.getView().findViewById(R.id.costY5P);
        cost16 =(TextView) fragment1.getView().findViewById(R.id.costY6P);
        cost17 =(TextView) fragment1.getView().findViewById(R.id.costY7P);
        labor10 =(TextView) fragment1.getView().findViewById(R.id.laborY0P);
        labor11 =(TextView) fragment1.getView().findViewById(R.id.laborY1P);
        labor12 =(TextView) fragment1.getView().findViewById(R.id.laborY2P);
        labor13 =(TextView) fragment1.getView().findViewById(R.id.laborY3P);
        labor14 =(TextView) fragment1.getView().findViewById(R.id.laborY4P);
        labor15 =(TextView) fragment1.getView().findViewById(R.id.laborY5P);
        labor16 =(TextView) fragment1.getView().findViewById(R.id.laborY6P);
        labor17 =(TextView) fragment1.getView().findViewById(R.id.laborY7P);

        income20 =(TextView) fragment2.getView().findViewById(R.id.incomeY2P);
        income21 =(TextView) fragment2.getView().findViewById(R.id.incomeY1P);
        income22 =(TextView) fragment2.getView().findViewById(R.id.incomeY2P);
        income23 =(TextView) fragment2.getView().findViewById(R.id.incomeY3P);
        income24 =(TextView) fragment2.getView().findViewById(R.id.incomeY4P);
        income25 =(TextView) fragment2.getView().findViewById(R.id.incomeY5P);
        income26 =(TextView) fragment2.getView().findViewById(R.id.incomeY6P);
        income27 =(TextView) fragment2.getView().findViewById(R.id.incomeY7P);
        cost20 =(TextView) fragment2.getView().findViewById(R.id.costY0P);
        cost21 =(TextView) fragment2.getView().findViewById(R.id.costY1P);
        cost22 =(TextView) fragment2.getView().findViewById(R.id.costY2P);
        cost23 =(TextView) fragment2.getView().findViewById(R.id.costY3P);
        cost24 =(TextView) fragment2.getView().findViewById(R.id.costY4P);
        cost25 =(TextView) fragment2.getView().findViewById(R.id.costY5P);
        cost26 =(TextView) fragment2.getView().findViewById(R.id.costY6P);
        cost27 =(TextView) fragment2.getView().findViewById(R.id.costY7P);
        labor20 =(TextView) fragment2.getView().findViewById(R.id.laborY0P);
        labor21 =(TextView) fragment2.getView().findViewById(R.id.laborY1P);
        labor22 =(TextView) fragment2.getView().findViewById(R.id.laborY2P);
        labor23 =(TextView) fragment2.getView().findViewById(R.id.laborY3P);
        labor24 =(TextView) fragment2.getView().findViewById(R.id.laborY4P);
        labor25 =(TextView) fragment2.getView().findViewById(R.id.laborY5P);
        labor26 =(TextView) fragment2.getView().findViewById(R.id.laborY6P);
        labor27 =(TextView) fragment2.getView().findViewById(R.id.laborY7P);

        income30 =(TextView) fragment3.getView().findViewById(R.id.incomeY0P);
        income31 =(TextView) fragment3.getView().findViewById(R.id.incomeY1P);
        income32 =(TextView) fragment3.getView().findViewById(R.id.incomeY2P);
        income33 =(TextView) fragment3.getView().findViewById(R.id.incomeY3P);
        income34 =(TextView) fragment3.getView().findViewById(R.id.incomeY4P);
        income35 =(TextView) fragment3.getView().findViewById(R.id.incomeY5P);
        income36 =(TextView) fragment3.getView().findViewById(R.id.incomeY6P);
        income37 =(TextView) fragment3.getView().findViewById(R.id.incomeY7P);
        cost30 =(TextView) fragment3.getView().findViewById(R.id.costY0P);
        cost31 =(TextView) fragment3.getView().findViewById(R.id.costY1P);
        cost32 =(TextView) fragment3.getView().findViewById(R.id.costY2P);
        cost33 =(TextView) fragment3.getView().findViewById(R.id.costY3P);
        cost34 =(TextView) fragment3.getView().findViewById(R.id.costY4P);
        cost35 =(TextView) fragment3.getView().findViewById(R.id.costY5P);
        cost36 =(TextView) fragment3.getView().findViewById(R.id.costY6P);
        cost37 =(TextView) fragment3.getView().findViewById(R.id.costY7P);
        labor30 =(TextView) fragment3.getView().findViewById(R.id.laborY0P);
        labor31 =(TextView) fragment3.getView().findViewById(R.id.laborY1P);
        labor32 =(TextView) fragment3.getView().findViewById(R.id.laborY2P);
        labor33 =(TextView) fragment3.getView().findViewById(R.id.laborY3P);
        labor34 =(TextView) fragment3.getView().findViewById(R.id.laborY4P);
        labor35 =(TextView) fragment3.getView().findViewById(R.id.laborY5P);
        labor36 =(TextView) fragment3.getView().findViewById(R.id.laborY6P);
        labor37 =(TextView) fragment3.getView().findViewById(R.id.laborY7P);

        income40 =(TextView) fragment4.getView().findViewById(R.id.incomeY0P);
        income41 =(TextView) fragment4.getView().findViewById(R.id.incomeY1P);
        income42 =(TextView) fragment4.getView().findViewById(R.id.incomeY2P);
        income43 =(TextView) fragment4.getView().findViewById(R.id.incomeY3P);
        income44 =(TextView) fragment4.getView().findViewById(R.id.incomeY4P);
        income45 =(TextView) fragment4.getView().findViewById(R.id.incomeY5P);
        income46 =(TextView) fragment4.getView().findViewById(R.id.incomeY6P);
        income47 =(TextView) fragment4.getView().findViewById(R.id.incomeY7P);
        cost40 =(TextView) fragment4.getView().findViewById(R.id.costY0P);
        cost41 =(TextView) fragment4.getView().findViewById(R.id.costY1P);
        cost42 =(TextView) fragment4.getView().findViewById(R.id.costY2P);
        cost43 =(TextView) fragment4.getView().findViewById(R.id.costY3P);
        cost44 =(TextView) fragment4.getView().findViewById(R.id.costY4P);
        cost45 =(TextView) fragment4.getView().findViewById(R.id.costY5P);
        cost46 =(TextView) fragment4.getView().findViewById(R.id.costY6P);
        cost47 =(TextView) fragment4.getView().findViewById(R.id.costY7P);
        labor40 =(TextView) fragment4.getView().findViewById(R.id.laborY0P);
        labor41 =(TextView) fragment4.getView().findViewById(R.id.laborY1P);
        labor42 =(TextView) fragment4.getView().findViewById(R.id.laborY2P);
        labor43 =(TextView) fragment4.getView().findViewById(R.id.laborY3P);
        labor44 =(TextView) fragment4.getView().findViewById(R.id.laborY4P);
        labor45 =(TextView) fragment4.getView().findViewById(R.id.laborY5P);
        labor46 =(TextView) fragment4.getView().findViewById(R.id.laborY6P);
        labor47 =(TextView) fragment4.getView().findViewById(R.id.laborY7P);

        income50 =(TextView) fragment5.getView().findViewById(R.id.incomeY0P);
        income51 =(TextView) fragment5.getView().findViewById(R.id.incomeY1P);
        income52 =(TextView) fragment5.getView().findViewById(R.id.incomeY2P);
        income53 =(TextView) fragment5.getView().findViewById(R.id.incomeY3P);
        income54 =(TextView) fragment5.getView().findViewById(R.id.incomeY4P);
        income55 =(TextView) fragment5.getView().findViewById(R.id.incomeY5P);
        income56 =(TextView) fragment5.getView().findViewById(R.id.incomeY6P);
        income57 =(TextView) fragment5.getView().findViewById(R.id.incomeY7P);
        cost50 =(TextView) fragment5.getView().findViewById(R.id.costY0P);
        cost51 =(TextView) fragment5.getView().findViewById(R.id.costY1P);
        cost52 =(TextView) fragment5.getView().findViewById(R.id.costY2P);
        cost53 =(TextView) fragment5.getView().findViewById(R.id.costY3P);
        cost54 =(TextView) fragment5.getView().findViewById(R.id.costY4P);
        cost55 =(TextView) fragment5.getView().findViewById(R.id.costY5P);
        cost56 =(TextView) fragment5.getView().findViewById(R.id.costY6P);
        cost57 =(TextView) fragment5.getView().findViewById(R.id.costY7P);
        labor50 =(TextView) fragment5.getView().findViewById(R.id.laborY0P);
        labor51 =(TextView) fragment5.getView().findViewById(R.id.laborY1P);
        labor52 =(TextView) fragment5.getView().findViewById(R.id.laborY2P);
        labor53 =(TextView) fragment5.getView().findViewById(R.id.laborY3P);
        labor54 =(TextView) fragment5.getView().findViewById(R.id.laborY4P);
        labor55 =(TextView) fragment5.getView().findViewById(R.id.laborY5P);
        labor56 =(TextView) fragment5.getView().findViewById(R.id.laborY6P);
        labor57 =(TextView) fragment5.getView().findViewById(R.id.laborY7P);

        income60 =(TextView) fragment6.getView().findViewById(R.id.incomeY0P);
        income61 =(TextView) fragment6.getView().findViewById(R.id.incomeY1P);
        income62 =(TextView) fragment6.getView().findViewById(R.id.incomeY2P);
        income63 =(TextView) fragment6.getView().findViewById(R.id.incomeY3P);
        income64 =(TextView) fragment6.getView().findViewById(R.id.incomeY4P);
        income65 =(TextView) fragment6.getView().findViewById(R.id.incomeY5P);
        income66 =(TextView) fragment6.getView().findViewById(R.id.incomeY6P);
        income67 =(TextView) fragment6.getView().findViewById(R.id.incomeY7P);
        cost60 =(TextView) fragment6.getView().findViewById(R.id.costY0P);
        cost61 =(TextView) fragment6.getView().findViewById(R.id.costY1P);
        cost62 =(TextView) fragment6.getView().findViewById(R.id.costY2P);
        cost63 =(TextView) fragment6.getView().findViewById(R.id.costY3P);
        cost64 =(TextView) fragment6.getView().findViewById(R.id.costY4P);
        cost65 =(TextView) fragment6.getView().findViewById(R.id.costY5P);
        cost66 =(TextView) fragment6.getView().findViewById(R.id.costY6P);
        cost67 =(TextView) fragment6.getView().findViewById(R.id.costY7P);
        labor60 =(TextView) fragment6.getView().findViewById(R.id.laborY0P);
        labor61 =(TextView) fragment6.getView().findViewById(R.id.laborY1P);
        labor62 =(TextView) fragment6.getView().findViewById(R.id.laborY2P);
        labor63 =(TextView) fragment6.getView().findViewById(R.id.laborY3P);
        labor64 =(TextView) fragment6.getView().findViewById(R.id.laborY4P);
        labor65 =(TextView) fragment6.getView().findViewById(R.id.laborY5P);
        labor66 =(TextView) fragment6.getView().findViewById(R.id.laborY6P);
        labor67 =(TextView) fragment6.getView().findViewById(R.id.laborY7P);

        income70 =(TextView) fragment7.getView().findViewById(R.id.incomeY0P);
        income71 =(TextView) fragment7.getView().findViewById(R.id.incomeY1P);
        income72 =(TextView) fragment7.getView().findViewById(R.id.incomeY2P);
        income73 =(TextView) fragment7.getView().findViewById(R.id.incomeY3P);
        income74 =(TextView) fragment7.getView().findViewById(R.id.incomeY4P);
        income75 =(TextView) fragment7.getView().findViewById(R.id.incomeY5P);
        income76 =(TextView) fragment7.getView().findViewById(R.id.incomeY6P);
        income77 =(TextView) fragment7.getView().findViewById(R.id.incomeY7P);
        cost70 =(TextView) fragment7.getView().findViewById(R.id.costY0P);
        cost71 =(TextView) fragment7.getView().findViewById(R.id.costY1P);
        cost72 =(TextView) fragment7.getView().findViewById(R.id.costY2P);
        cost73 =(TextView) fragment7.getView().findViewById(R.id.costY3P);
        cost74 =(TextView) fragment7.getView().findViewById(R.id.costY4P);
        cost75 =(TextView) fragment7.getView().findViewById(R.id.costY5P);
        cost76 =(TextView) fragment7.getView().findViewById(R.id.costY6P);
        cost77 =(TextView) fragment7.getView().findViewById(R.id.costY7P);
        labor70 =(TextView) fragment7.getView().findViewById(R.id.laborY0P);
        labor71 =(TextView) fragment7.getView().findViewById(R.id.laborY1P);
        labor72 =(TextView) fragment7.getView().findViewById(R.id.laborY2P);
        labor73 =(TextView) fragment7.getView().findViewById(R.id.laborY3P);
        labor74 =(TextView) fragment7.getView().findViewById(R.id.laborY4P);
        labor75 =(TextView) fragment7.getView().findViewById(R.id.laborY5P);
        labor76 =(TextView) fragment7.getView().findViewById(R.id.laborY6P);
        labor77 =(TextView) fragment7.getView().findViewById(R.id.laborY7P);

        income80 =(TextView) fragment8.getView().findViewById(R.id.incomeY0P);
        income81 =(TextView) fragment8.getView().findViewById(R.id.incomeY1P);
        income82 =(TextView) fragment8.getView().findViewById(R.id.incomeY2P);
        income83 =(TextView) fragment8.getView().findViewById(R.id.incomeY3P);
        income84 =(TextView) fragment8.getView().findViewById(R.id.incomeY4P);
        income85 =(TextView) fragment8.getView().findViewById(R.id.incomeY5P);
        income86 =(TextView) fragment8.getView().findViewById(R.id.incomeY6P);
        income87 =(TextView) fragment8.getView().findViewById(R.id.incomeY7P);
        cost80 =(TextView) fragment8.getView().findViewById(R.id.costY0P);
        cost81 =(TextView) fragment8.getView().findViewById(R.id.costY1P);
        cost82 =(TextView) fragment8.getView().findViewById(R.id.costY2P);
        cost83 =(TextView) fragment8.getView().findViewById(R.id.costY3P);
        cost84 =(TextView) fragment8.getView().findViewById(R.id.costY4P);
        cost85 =(TextView) fragment8.getView().findViewById(R.id.costY5P);
        cost86 =(TextView) fragment8.getView().findViewById(R.id.costY6P);
        cost87 =(TextView) fragment8.getView().findViewById(R.id.costY7P);
        labor80 =(TextView) fragment8.getView().findViewById(R.id.laborY0P);
        labor81 =(TextView) fragment8.getView().findViewById(R.id.laborY1P);
        labor82 =(TextView) fragment8.getView().findViewById(R.id.laborY2P);
        labor83 =(TextView) fragment8.getView().findViewById(R.id.laborY3P);
        labor84 =(TextView) fragment8.getView().findViewById(R.id.laborY4P);
        labor85 =(TextView) fragment8.getView().findViewById(R.id.laborY5P);
        labor86 =(TextView) fragment8.getView().findViewById(R.id.laborY6P);
        labor87 =(TextView) fragment8.getView().findViewById(R.id.laborY7P);

        income90 =(TextView) fragment9.getView().findViewById(R.id.incomeY0P);
        income91 =(TextView) fragment9.getView().findViewById(R.id.incomeY1P);
        income92 =(TextView) fragment9.getView().findViewById(R.id.incomeY2P);
        income93 =(TextView) fragment9.getView().findViewById(R.id.incomeY3P);
        income94 =(TextView) fragment9.getView().findViewById(R.id.incomeY4P);
        income95 =(TextView) fragment9.getView().findViewById(R.id.incomeY5P);
        income96 =(TextView) fragment9.getView().findViewById(R.id.incomeY6P);
        income97 =(TextView) fragment9.getView().findViewById(R.id.incomeY7P);
        cost90 =(TextView) fragment9.getView().findViewById(R.id.costY0P);
        cost91 =(TextView) fragment9.getView().findViewById(R.id.costY1P);
        cost92 =(TextView) fragment9.getView().findViewById(R.id.costY2P);
        cost93 =(TextView) fragment9.getView().findViewById(R.id.costY3P);
        cost94 =(TextView) fragment9.getView().findViewById(R.id.costY4P);
        cost95 =(TextView) fragment9.getView().findViewById(R.id.costY5P);
        cost96 =(TextView) fragment9.getView().findViewById(R.id.costY6P);
        cost97 =(TextView) fragment9.getView().findViewById(R.id.costY7P);
        labor90 =(TextView) fragment9.getView().findViewById(R.id.laborY0P);
        labor91 =(TextView) fragment9.getView().findViewById(R.id.laborY1P);
        labor92 =(TextView) fragment9.getView().findViewById(R.id.laborY2P);
        labor93 =(TextView) fragment9.getView().findViewById(R.id.laborY3P);
        labor94 =(TextView) fragment9.getView().findViewById(R.id.laborY4P);
        labor95 =(TextView) fragment9.getView().findViewById(R.id.laborY5P);
        labor96 =(TextView) fragment9.getView().findViewById(R.id.laborY6P);
        labor97 =(TextView) fragment9.getView().findViewById(R.id.laborY7P);

        income100 =(TextView) fragment10.getView().findViewById(R.id.incomeY0P);
        income101 =(TextView) fragment10.getView().findViewById(R.id.incomeY1P);
        income102 =(TextView) fragment10.getView().findViewById(R.id.incomeY2P);
        income103 =(TextView) fragment10.getView().findViewById(R.id.incomeY3P);
        income104 =(TextView) fragment10.getView().findViewById(R.id.incomeY4P);
        income105 =(TextView) fragment10.getView().findViewById(R.id.incomeY5P);
        income106 =(TextView) fragment10.getView().findViewById(R.id.incomeY6P);
        income107 =(TextView) fragment10.getView().findViewById(R.id.incomeY7P);
        cost100 =(TextView) fragment10.getView().findViewById(R.id.costY0P);
        cost101 =(TextView) fragment10.getView().findViewById(R.id.costY1P);
        cost102 =(TextView) fragment10.getView().findViewById(R.id.costY2P);
        cost103 =(TextView) fragment10.getView().findViewById(R.id.costY3P);
        cost104 =(TextView) fragment10.getView().findViewById(R.id.costY4P);
        cost105 =(TextView) fragment10.getView().findViewById(R.id.costY5P);
        cost106 =(TextView) fragment10.getView().findViewById(R.id.costY6P);
        cost107 =(TextView) fragment10.getView().findViewById(R.id.costY7P);
        labor100 =(TextView) fragment10.getView().findViewById(R.id.laborY0P);
        labor101 =(TextView) fragment10.getView().findViewById(R.id.laborY1P);
        labor102 =(TextView) fragment10.getView().findViewById(R.id.laborY2P);
        labor103 =(TextView) fragment10.getView().findViewById(R.id.laborY3P);
        labor104 =(TextView) fragment10.getView().findViewById(R.id.laborY4P);
        labor105 =(TextView) fragment10.getView().findViewById(R.id.laborY5P);
        labor106 =(TextView) fragment10.getView().findViewById(R.id.laborY6P);
        labor107 =(TextView) fragment10.getView().findViewById(R.id.laborY7P);
        comt1 = (EditText) fragment1.getView().findViewById(R.id.comments);
        comt2 = (EditText) fragment2.getView().findViewById(R.id.comments);
        comt3 = (EditText) fragment3.getView().findViewById(R.id.comments);
        comt4 = (EditText) fragment4.getView().findViewById(R.id.comments);
        comt5 = (EditText) fragment5.getView().findViewById(R.id.comments);
        comt6 = (EditText) fragment6.getView().findViewById(R.id.comments);
        comt7 = (EditText) fragment7.getView().findViewById(R.id.comments);
        comt8 = (EditText) fragment8.getView().findViewById(R.id.comments);
        comt9 = (EditText) fragment9.getView().findViewById(R.id.comments);
        comt10 = (EditText) fragment10.getView().findViewById(R.id.comments);

        found0 = (TextView)findViewById(R.id.netFamilyY0_field);
        found1 = (TextView)findViewById(R.id.netFamilyY1_field);
        found2 = (TextView)findViewById(R.id.netFamilyY2_field);
        found3 = (TextView)findViewById(R.id.netFamilyY3_field);
        found4 = (TextView)findViewById(R.id.netFamilyY4_field);
        found5 = (TextView)findViewById(R.id.netFamilyY5_field);
        found6 = (TextView)findViewById(R.id.netFamilyY6_field);
        found7 = (TextView)findViewById(R.id.netFamilyY7_field);
        pyl0 = (TextView)findViewById(R.id.profitOrLostY0_field);
        pyl1 = (TextView)findViewById(R.id.profitOrLostY1_field);
        pyl2 = (TextView)findViewById(R.id.profitOrLostY2_field);
        pyl3 = (TextView)findViewById(R.id.profitOrLostY3_field);
        pyl4 = (TextView)findViewById(R.id.profitOrLostY4_field);
        pyl5 = (TextView)findViewById(R.id.profitOrLostY5_field);
        pyl6 = (TextView)findViewById(R.id.profitOrLostY6_field);
        pyl7 = (TextView)findViewById(R.id.profitOrLostY7_field);

    }

    @Override
    public void onResume(RestClient client) {
        curAccount = SmartSyncSDKManager.getInstance().getUserAccountManager().getCurrentUser();
        getLoaderManager().initLoader(CONTACT_DETAIL_LOADER_ID, null, this).forceLoad();
    }

    @Override
    public Loader<ContactObject> onCreateLoader(int id, Bundle args) {
        return new ContactDetailLoader(this, curAccount, objectId);
    }

    @Override
    public void onLoadFinished(Loader<ContactObject> loader, ContactObject data) {
        sObject = data;
        refreshScreen();
    }

    @Override
    public void onLoaderReset(Loader<ContactObject> loader) {
        sObject = null;
        refreshScreen();
    }

    public boolean onOptionsItemSelected(MenuItem item){
        save();
        Intent plotIntent = new Intent(getApplicationContext(), plotActivity.class);
        plotIntent.addCategory(Intent.CATEGORY_DEFAULT);
        plotIntent.putExtra(OBJECT_ID_KEY, sObject.getObjectId());
        plotIntent.putExtra(OBJECT_TITLE_KEY, sObject.getName());
        plotIntent.putExtra(OBJECT_NAME_KEY, sObject.getEmail());
        startActivityForResult(plotIntent, 0);
        return true;
    }

    public void launchYear1(View view) {
        save();
        final Intent yearIntent = new Intent(this, YearDetailActivity.class);
        yearIntent.addCategory(Intent.CATEGORY_DEFAULT);
        yearIntent.putExtra(OBJECT_ID_KEY, sObject.getObjectId());
        yearIntent.putExtra(OBJECT_TITLE_KEY, sObject.getName());
        yearIntent.putExtra(OBJECT_NAME_KEY, sObject.getEmail());
        yearIntent.putExtra(YEAR_LAUNCH, "1");
        startActivity(yearIntent);
    }
    public void launchYear2(View view) {
        save();
        final Intent yearIntent = new Intent(this, YearDetailActivity.class);
        yearIntent.addCategory(Intent.CATEGORY_DEFAULT);
        yearIntent.putExtra(OBJECT_ID_KEY, sObject.getObjectId());
        yearIntent.putExtra(OBJECT_TITLE_KEY, sObject.getName());
        yearIntent.putExtra(OBJECT_NAME_KEY, sObject.getEmail());
        yearIntent.putExtra(YEAR_LAUNCH, "2");
        startActivity(yearIntent);
    }
    public void launchYear3(View view) {
        save();
        final Intent yearIntent = new Intent(this, YearDetailActivity.class);
        yearIntent.addCategory(Intent.CATEGORY_DEFAULT);
        yearIntent.putExtra(OBJECT_ID_KEY, sObject.getObjectId());
        yearIntent.putExtra(OBJECT_TITLE_KEY, sObject.getName());
        yearIntent.putExtra(OBJECT_NAME_KEY, sObject.getEmail());
        yearIntent.putExtra(YEAR_LAUNCH, "3");
        startActivity(yearIntent);
    }

    public void launchYear4(View view) {
        save();
        final Intent yearIntent = new Intent(this, YearDetailActivity.class);
        yearIntent.addCategory(Intent.CATEGORY_DEFAULT);
        yearIntent.putExtra(OBJECT_ID_KEY, sObject.getObjectId());
        yearIntent.putExtra(OBJECT_TITLE_KEY, sObject.getName());
        yearIntent.putExtra(OBJECT_NAME_KEY, sObject.getEmail());
        yearIntent.putExtra(YEAR_LAUNCH, "4");
        startActivity(yearIntent);
    }

    public void launchYear5(View view) {
        save();
        final Intent yearIntent = new Intent(this, YearDetailActivity.class);
        yearIntent.addCategory(Intent.CATEGORY_DEFAULT);
        yearIntent.putExtra(OBJECT_ID_KEY, sObject.getObjectId());
        yearIntent.putExtra(OBJECT_TITLE_KEY, sObject.getName());
        yearIntent.putExtra(OBJECT_NAME_KEY, sObject.getEmail());
        yearIntent.putExtra(YEAR_LAUNCH, "5");
        startActivity(yearIntent);
    }
    public void launchYear6(View view) {
        save();
        final Intent yearIntent = new Intent(this, YearDetailActivity.class);
        yearIntent.addCategory(Intent.CATEGORY_DEFAULT);
        yearIntent.putExtra(OBJECT_ID_KEY, sObject.getObjectId());
        yearIntent.putExtra(OBJECT_TITLE_KEY, sObject.getName());
        yearIntent.putExtra(OBJECT_NAME_KEY, sObject.getEmail());
        yearIntent.putExtra(YEAR_LAUNCH, "6");
        startActivity(yearIntent);
    }

    public void launchYear7(View view) {
        save();
        final Intent yearIntent = new Intent(this, YearDetailActivity.class);
        yearIntent.addCategory(Intent.CATEGORY_DEFAULT);
        yearIntent.putExtra(OBJECT_ID_KEY, sObject.getObjectId());
        yearIntent.putExtra(OBJECT_TITLE_KEY, sObject.getName());
        yearIntent.putExtra(OBJECT_NAME_KEY, sObject.getEmail());
        yearIntent.putExtra(YEAR_LAUNCH, "7");
        startActivity(yearIntent);
    }

    public void onFinishClicked(View view) {
        save();
        Intent i = new Intent(this, MainActivity.class );
        startActivity(i);
    }

    private void refreshScreen() {
        if (sObject != null) {

            //Set Agree with recomendations field
            if (sObject.getAgreeRecomendations().contentEquals("Yes")||sObject.getAgreeRecomendations().contentEquals("Oui")) {
                Spinner spinner = (Spinner) findViewById(R.id.farmerAgree_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yes, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getAgreeRecomendations().contentEquals("No")||sObject.getAgreeRecomendations().contentEquals("Non")) {
                Spinner spinner = (Spinner) findViewById(R.id.farmerAgree_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.No, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else {
                Spinner spinner = (Spinner) findViewById(R.id.farmerAgree_field);
                // Create an ArrayAdapter using the string array and a default spinner layout
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNo, android.R.layout.simple_spinner_item);
                // Specify the layout to use when the list of choices appears
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                // Apply the adapter to the spinner
                spinner.setAdapter(adapter);
            }

            setText(comments,sObject.getFarmerComments());

            //Set start year 1
            if (sObject.getStartYearP1().contentEquals("-1")) {
                Spinner spinner = st1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.reno1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getStartYearP1().contentEquals("-2")) {
                Spinner spinner = st1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.reno2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getStartYearP1().contentEquals("-3")) {
                Spinner spinner = st1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.reno3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getStartYearP1().contentEquals("-4")) {
                Spinner spinner = st1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.reno4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getStartYearP1().contentEquals("-5")) {
                Spinner spinner = st1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.reno5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getStartYearP1().contentEquals("Year 1")||sObject.getStartYearP1().contentEquals("Année 1")) {
                Spinner spinner = st1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP1().contentEquals("Year 2")||sObject.getStartYearP1().contentEquals("Année 2")) {
                Spinner spinner = st1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP1().contentEquals("Year 3")||sObject.getStartYearP1().contentEquals("Année 3")) {
                Spinner spinner = st1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP1().contentEquals("Year 4")||sObject.getStartYearP1().contentEquals("Année 4")) {
                Spinner spinner = st1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP1().contentEquals("Year 5")||sObject.getStartYearP1().contentEquals("Année 5")) {
                Spinner spinner = st1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP1().contentEquals("Year 6")||sObject.getStartYearP1().contentEquals("Année 6")) {
                Spinner spinner = st1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year6, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP1().contentEquals("Year 7")||sObject.getStartYearP1().contentEquals("Année 7")) {
                Spinner spinner = st1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year7, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = st1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.years, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //Set start year 2
            if (sObject.getStartYearP2().contentEquals("-1")) {
                Spinner spinner = st2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.reno1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getStartYearP2().contentEquals("-2")) {
                Spinner spinner = st2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.reno2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getStartYearP2().contentEquals("-3")) {
                Spinner spinner = st2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.reno3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getStartYearP2().contentEquals("-4")) {
                Spinner spinner = st2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.reno4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getStartYearP2().contentEquals("-5")) {
                Spinner spinner = st2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.reno5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getStartYearP2().contentEquals("Year 1")||sObject.getStartYearP2().contentEquals("Année 1")) {
                Spinner spinner = st2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP2().contentEquals("Year 2")||sObject.getStartYearP2().contentEquals("Année 2")) {
                Spinner spinner = st2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP2().contentEquals("Year 3")||sObject.getStartYearP2().contentEquals("Année 3")) {
                Spinner spinner = st2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP2().contentEquals("Year 4")||sObject.getStartYearP2().contentEquals("Année 4")) {
                Spinner spinner = st2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP2().contentEquals("Year 5")||sObject.getStartYearP2().contentEquals("Année 5")) {
                Spinner spinner = st2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP2().contentEquals("Year 6")||sObject.getStartYearP2().contentEquals("Année 6")) {
                Spinner spinner = st2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year6, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP2().contentEquals("Year 7")||sObject.getStartYearP2().contentEquals("Année 7")) {
                Spinner spinner = st2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year7, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = st2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.years, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //Set start year 3
            if (sObject.getStartYearP3().contentEquals("-1")) {
                Spinner spinner = st3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.reno1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getStartYearP3().contentEquals("-2")) {
                Spinner spinner = st3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.reno2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getStartYearP3().contentEquals("-3")) {
                Spinner spinner = st3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.reno3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getStartYearP3().contentEquals("-4")) {
                Spinner spinner = st3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.reno4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getStartYearP3().contentEquals("-5")) {
                Spinner spinner = st3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.reno5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getStartYearP3().contentEquals("Year 1")||sObject.getStartYearP3().contentEquals("Année 1")) {
                Spinner spinner = st3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP3().contentEquals("Year 2")||sObject.getStartYearP3().contentEquals("Année 2")) {
                Spinner spinner = st3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP3().contentEquals("Year 3")||sObject.getStartYearP3().contentEquals("Année 3")) {
                Spinner spinner = st3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP3().contentEquals("Year 4")||sObject.getStartYearP3().contentEquals("Année 4")) {
                Spinner spinner = st3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP3().contentEquals("Year 5")||sObject.getStartYearP3().contentEquals("Année 5")) {
                Spinner spinner = st3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP3().contentEquals("Year 6")||sObject.getStartYearP3().contentEquals("Année 6")) {
                Spinner spinner = st3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year6, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP3().contentEquals("Year 7")||sObject.getStartYearP3().contentEquals("Année 7")) {
                Spinner spinner = st3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year7, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = st3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.years, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //Set start year 4
            if (sObject.getStartYearP4().contentEquals("-1")) {
                Spinner spinner = st4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.reno1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getStartYearP4().contentEquals("-2")) {
                Spinner spinner = st4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.reno2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getStartYearP4().contentEquals("-3")) {
                Spinner spinner = st4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.reno3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getStartYearP4().contentEquals("-4")) {
                Spinner spinner = st4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.reno4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getStartYearP4().contentEquals("-5")) {
                Spinner spinner = st4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.reno5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getStartYearP4().contentEquals("Year 1")||sObject.getStartYearP4().contentEquals("Année 1")) {
                Spinner spinner = st4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP4().contentEquals("Year 2")||sObject.getStartYearP4().contentEquals("Année 2")) {
                Spinner spinner = st4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP4().contentEquals("Year 3")||sObject.getStartYearP4().contentEquals("Année 3")) {
                Spinner spinner = st4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP4().contentEquals("Year 4")||sObject.getStartYearP4().contentEquals("Année 4")) {
                Spinner spinner = st4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP4().contentEquals("Year 5")||sObject.getStartYearP4().contentEquals("Année 5")) {
                Spinner spinner = st4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP4().contentEquals("Year 6")||sObject.getStartYearP4().contentEquals("Année 6")) {
                Spinner spinner = st4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year6, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP4().contentEquals("Year 7")||sObject.getStartYearP4().contentEquals("Année 7")) {
                Spinner spinner = st4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year7, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = st4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.years, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //Set start year 5
            if (sObject.getStartYearP5().contentEquals("-1")) {
                Spinner spinner = st5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.reno1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getStartYearP5().contentEquals("-2")) {
                Spinner spinner = st5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.reno2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getStartYearP5().contentEquals("-3")) {
                Spinner spinner = st5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.reno3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getStartYearP5().contentEquals("-4")) {
                Spinner spinner = st5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.reno4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getStartYearP5().contentEquals("-5")) {
                Spinner spinner = st5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.reno5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getStartYearP5().contentEquals("Year 1")||sObject.getStartYearP5().contentEquals("Année 1")) {
                Spinner spinner = st5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP5().contentEquals("Year 2")||sObject.getStartYearP5().contentEquals("Année 2")) {
                Spinner spinner = st5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP5().contentEquals("Year 3")||sObject.getStartYearP5().contentEquals("Année 3")) {
                Spinner spinner = st5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP5().contentEquals("Year 4")||sObject.getStartYearP5().contentEquals("Année 4")) {
                Spinner spinner = st5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP5().contentEquals("Year 5")||sObject.getStartYearP5().contentEquals("Année 5")) {
                Spinner spinner = st5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP5().contentEquals("Year 6")||sObject.getStartYearP5().contentEquals("Année 6")) {
                Spinner spinner = st5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year6, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP5().contentEquals("Year 7")||sObject.getStartYearP5().contentEquals("Année 7")) {
                Spinner spinner = st5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year7, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = st5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.years, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //Set start year 6
            if (sObject.getStartYearP6().contentEquals("-1")) {
                Spinner spinner = st6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.reno1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getStartYearP6().contentEquals("-2")) {
                Spinner spinner = st6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.reno2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getStartYearP6().contentEquals("-3")) {
                Spinner spinner = st6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.reno3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getStartYearP6().contentEquals("-4")) {
                Spinner spinner = st6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.reno4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getStartYearP6().contentEquals("-5")) {
                Spinner spinner = st6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.reno5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getStartYearP6().contentEquals("Year 1")||sObject.getStartYearP6().contentEquals("Année 1")) {
                Spinner spinner = st6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP6().contentEquals("Year 2")||sObject.getStartYearP6().contentEquals("Année 2")) {
                Spinner spinner = st6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP6().contentEquals("Year 3")||sObject.getStartYearP6().contentEquals("Année 3")) {
                Spinner spinner = st6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP6().contentEquals("Year 4")||sObject.getStartYearP6().contentEquals("Année 4")) {
                Spinner spinner = st6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP6().contentEquals("Year 5")||sObject.getStartYearP6().contentEquals("Année 5")) {
                Spinner spinner = st6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP6().contentEquals("Year 6")||sObject.getStartYearP6().contentEquals("Année 6")) {
                Spinner spinner = st6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year6, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP6().contentEquals("Year 7")||sObject.getStartYearP6().contentEquals("Année 7")) {
                Spinner spinner = st6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year7, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = st6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.years, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //Set start year 7
            if (sObject.getStartYearP7().contentEquals("-1")) {
                Spinner spinner = st7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.reno1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getStartYearP7().contentEquals("-2")) {
                Spinner spinner = st7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.reno2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getStartYearP7().contentEquals("-3")) {
                Spinner spinner = st7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.reno3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getStartYearP7().contentEquals("-4")) {
                Spinner spinner = st7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.reno4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getStartYearP7().contentEquals("-5")) {
                Spinner spinner = st7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.reno5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getStartYearP7().contentEquals("Year 1")||sObject.getStartYearP7().contentEquals("Année 1")) {
                Spinner spinner = st7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP7().contentEquals("Year 2")||sObject.getStartYearP7().contentEquals("Année 2")) {
                Spinner spinner = st7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP7().contentEquals("Year 3")||sObject.getStartYearP7().contentEquals("Année 3")) {
                Spinner spinner = st7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP7().contentEquals("Year 4")||sObject.getStartYearP7().contentEquals("Année 4")) {
                Spinner spinner = st7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP7().contentEquals("Year 5")||sObject.getStartYearP7().contentEquals("Année 5")) {
                Spinner spinner = st7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP7().contentEquals("Year 6")||sObject.getStartYearP7().contentEquals("Année 6")) {
                Spinner spinner = st7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year6, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP7().contentEquals("Year 7")||sObject.getStartYearP7().contentEquals("Année 7")) {
                Spinner spinner = st7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year7, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = st7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.years, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //Set start year 8
            if (sObject.getStartYearP8().contentEquals("-1")) {
                Spinner spinner = st8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.reno1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getStartYearP8().contentEquals("-2")) {
                Spinner spinner = st8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.reno2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getStartYearP8().contentEquals("-3")) {
                Spinner spinner = st8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.reno3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getStartYearP8().contentEquals("-4")) {
                Spinner spinner = st8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.reno4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getStartYearP8().contentEquals("-5")) {
                Spinner spinner = st8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.reno5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getStartYearP8().contentEquals("Year 1")||sObject.getStartYearP8().contentEquals("Année 1")) {
                Spinner spinner = st8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP8().contentEquals("Year 2")||sObject.getStartYearP8().contentEquals("Année 2")) {
                Spinner spinner = st8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP8().contentEquals("Year 3")||sObject.getStartYearP8().contentEquals("Année 3")) {
                Spinner spinner = st8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP8().contentEquals("Year 4")||sObject.getStartYearP8().contentEquals("Année 4")) {
                Spinner spinner = st8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP8().contentEquals("Year 5")||sObject.getStartYearP8().contentEquals("Année 5")) {
                Spinner spinner = st8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP8().contentEquals("Year 6")||sObject.getStartYearP8().contentEquals("Année 6")) {
                Spinner spinner = st8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year6, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP8().contentEquals("Year 7")||sObject.getStartYearP8().contentEquals("Année 7")) {
                Spinner spinner = st8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year7, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = st8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.years, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //Set start year 9
            if (sObject.getStartYearP9().contentEquals("-1")) {
                Spinner spinner = st9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.reno1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getStartYearP9().contentEquals("-2")) {
                Spinner spinner = st9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.reno2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getStartYearP9().contentEquals("-3")) {
                Spinner spinner = st9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.reno3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getStartYearP9().contentEquals("-4")) {
                Spinner spinner = st9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.reno4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getStartYearP9().contentEquals("-5")) {
                Spinner spinner = st9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.reno5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getStartYearP9().contentEquals("Year 1")||sObject.getStartYearP9().contentEquals("Année 1")) {
                Spinner spinner = st9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP9().contentEquals("Year 2")||sObject.getStartYearP9().contentEquals("Année 2")) {
                Spinner spinner = st9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP9().contentEquals("Year 3")||sObject.getStartYearP9().contentEquals("Année 3")) {
                Spinner spinner = st9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP9().contentEquals("Year 4")||sObject.getStartYearP9().contentEquals("Année 4")) {
                Spinner spinner = st9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP9().contentEquals("Year 5")||sObject.getStartYearP9().contentEquals("Année 5")) {
                Spinner spinner = st9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP9().contentEquals("Year 6")||sObject.getStartYearP9().contentEquals("Année 6")) {
                Spinner spinner = st9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year6, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP9().contentEquals("Year 7")||sObject.getStartYearP9().contentEquals("Année 7")) {
                Spinner spinner = st9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year7, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = st9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.years, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //Set start year 10
            if (sObject.getStartYearP10().contentEquals("-1")) {
                Spinner spinner = st10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.reno1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getStartYearP10().contentEquals("-2")) {
                Spinner spinner = st10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.reno2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getStartYearP10().contentEquals("-3")) {
                Spinner spinner = st10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.reno3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getStartYearP10().contentEquals("-4")) {
                Spinner spinner = st10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.reno4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getStartYearP10().contentEquals("-5")) {
                Spinner spinner = st10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.reno5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getStartYearP10().contentEquals("Year 1")||sObject.getStartYearP10().contentEquals("Année 1")) {
                Spinner spinner = st10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP10().contentEquals("Year 2")||sObject.getStartYearP10().contentEquals("Année 2")) {
                Spinner spinner = st10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP10().contentEquals("Year 3")||sObject.getStartYearP10().contentEquals("Année 3")) {
                Spinner spinner = st10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP10().contentEquals("Year 4")||sObject.getStartYearP10().contentEquals("Année 4")) {
                Spinner spinner = st10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP10().contentEquals("Year 5")||sObject.getStartYearP10().contentEquals("Année 5")) {
                Spinner spinner = st10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP10().contentEquals("Year 6")||sObject.getStartYearP10().contentEquals("Année 6")) {
                Spinner spinner = st10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year6, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP10().contentEquals("Year 7")||sObject.getStartYearP10().contentEquals("Année 7")) {
                Spinner spinner = st10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year7, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = st10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.years, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }
            double plot1Area = 0;
            double plot2Area = 0;
            double plot3Area = 0;
            double plot4Area = 0;
            double plot5Area = 0;
            double plot6Area = 0;
            double plot7Area = 0;
            double plot8Area = 0;
            double plot9Area = 0;
            double plot10Area = 0;
            double cocoarea = 0;

            if (sObject.getAREAUNITS().contentEquals("Ac")){
                plot1Area = Double.valueOf(sObject.getPlot1Area())*0.4046856;
                plot2Area = Double.valueOf(sObject.getPlot2Area())*0.4046856;
                plot3Area = Double.valueOf(sObject.getPlot3Area())*0.4046856;
                plot4Area = Double.valueOf(sObject.getPlot4Area())*0.4046856;
                plot5Area = Double.valueOf(sObject.getPlot5Area())*0.4046856;
                plot6Area = Double.valueOf(sObject.getPlot6Area())*0.4046856;
                plot7Area = Double.valueOf(sObject.getPlot7Area())*0.4046856;
                plot8Area = Double.valueOf(sObject.getPlot8Area())*0.4046856;
                plot9Area = Double.valueOf(sObject.getPlot9Area())*0.4046856;
                plot10Area = Double.valueOf(sObject.getPlot10Area())*0.4046856;
                cocoarea = Double.valueOf(sObject.getTotalCocoaArea())*0.4046856;
                Log.d(TAG, "plot1area: "+plot1Area);

            }else{
                plot1Area = Double.valueOf(sObject.getPlot1Area());
                plot2Area = Double.valueOf(sObject.getPlot2Area());
                plot3Area = Double.valueOf(sObject.getPlot3Area());
                plot4Area = Double.valueOf(sObject.getPlot4Area());
                plot5Area = Double.valueOf(sObject.getPlot5Area());
                plot6Area = Double.valueOf(sObject.getPlot6Area());
                plot7Area = Double.valueOf(sObject.getPlot7Area());
                plot8Area = Double.valueOf(sObject.getPlot8Area());
                plot9Area = Double.valueOf(sObject.getPlot9Area());
                plot10Area = Double.valueOf(sObject.getPlot10Area());
                cocoarea =Double.valueOf(sObject.getTotalCocoaArea());
                Log.d(TAG, "plot1area: "+plot1Area);
            }

            double cocoExpenses =Double.valueOf(sObject.getExpensescocoaly());
            double farmerCost = cocoExpenses/cocoarea;
            String startY1 = sObject.getStartYearP1();
            String startY2 = sObject.getStartYearP2();
            String startY3 = sObject.getStartYearP3();
            String startY4 = sObject.getStartYearP4();
            String startY5 = sObject.getStartYearP5();
            String startY6 = sObject.getStartYearP6();
            String startY7 = sObject.getStartYearP7();
            String startY8 = sObject.getStartYearP8();
            String startY9 = sObject.getStartYearP9();
            String startY10 = sObject.getStartYearP10();
            double avgCost = Double.parseDouble(sObject.getAveragecocoaprice());
            Integer age1 = Integer.valueOf(sObject.getPlot1Age());
            Integer age2 = Integer.valueOf(sObject.getPlot2Age());
            Integer age3 = Integer.valueOf(sObject.getPlot3Age());
            Integer age4 = Integer.valueOf(sObject.getPlot4Age());
            Integer age5 = Integer.valueOf(sObject.getPlot5Age());
            Integer age6 = Integer.valueOf(sObject.getPlot6Age());
            Integer age7 = Integer.valueOf(sObject.getPlot7Age());
            Integer age8 = Integer.valueOf(sObject.getPlot8Age());
            Integer age9 = Integer.valueOf(sObject.getPlot9Age());
            Integer age10 = Integer.valueOf(sObject.getPlot10Age());

            double estPrd1 = 0;
            double estPrd2 = 0;
            double estPrd3 = 0;
            double estPrd4 = 0;
            double estPrd5 = 0;
            double estPrd6 = 0;
            double estPrd7 = 0;
            double estPrd8 = 0;
            double estPrd9 = 0;
            double estPrd10 = 0;

            if (sObject.getMEASURE().contentEquals("Bag")||sObject.getMEASURE().contentEquals("Sac")){
                estPrd1 = Double.valueOf(sObject.getPlot1Yield())*62.5;
                estPrd2 = Double.valueOf(sObject.getPlot2Yield())*62.5;
                estPrd3 = Double.valueOf(sObject.getPlot3Yield())*62.5;
                estPrd4 = Double.valueOf(sObject.getPlot4Yield())*62.5;
                estPrd5 = Double.valueOf(sObject.getPlot5Yield())*62.5;
                estPrd6 = Double.valueOf(sObject.getPlot6Yield())*62.5;
                estPrd7 = Double.valueOf(sObject.getPlot7Yield())*62.5;
                estPrd8 = Double.valueOf(sObject.getPlot8Yield())*62.5;
                estPrd9 = Double.valueOf(sObject.getPlot9Yield())*62.5;
                estPrd10 = Double.valueOf(sObject.getPlot10Yield())*62.5;
                Log.d(TAG, "est prod: "+estPrd1);
            }else if(sObject.getMEASURE().contentEquals("Qq")){
                estPrd1 = Double.valueOf(sObject.getPlot1Yield())*100;
                estPrd2 = Double.valueOf(sObject.getPlot2Yield())*100;
                estPrd3 = Double.valueOf(sObject.getPlot3Yield())*100;
                estPrd4 = Double.valueOf(sObject.getPlot4Yield())*100;
                estPrd5 = Double.valueOf(sObject.getPlot5Yield())*100;
                estPrd6 = Double.valueOf(sObject.getPlot6Yield())*100;
                estPrd7 = Double.valueOf(sObject.getPlot7Yield())*100;
                estPrd8 = Double.valueOf(sObject.getPlot8Yield())*100;
                estPrd9 = Double.valueOf(sObject.getPlot9Yield())*100;
                estPrd10 = Double.valueOf(sObject.getPlot10Yield())*100;
                Log.d(TAG, "est prod: "+estPrd1);
            }else{
                estPrd1 = Double.valueOf(sObject.getPlot1Yield());
                estPrd2 = Double.valueOf(sObject.getPlot2Yield());
                estPrd3 = Double.valueOf(sObject.getPlot3Yield());
                estPrd4 = Double.valueOf(sObject.getPlot4Yield());
                estPrd5 = Double.valueOf(sObject.getPlot5Yield());
                estPrd6 = Double.valueOf(sObject.getPlot6Yield());
                estPrd7 = Double.valueOf(sObject.getPlot7Yield());
                estPrd8 = Double.valueOf(sObject.getPlot8Yield());
                estPrd9 = Double.valueOf(sObject.getPlot9Yield());
                estPrd10 = Double.valueOf(sObject.getPlot10Yield());
                Log.d(TAG, "est prod: "+estPrd1);
            }

            FragmentTransaction ft = getFragmentManager().beginTransaction();
            //plot1
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 0) {
                setText(plot1,getString(R.string.pt1));
                fragment1.getView().setBackgroundColor(Color.parseColor("#e5e5e5"));
                fragment1.setStartYear(startY1);
                if(sObject.getPLOT1RENOVATION().equals("Yes")||sObject.getPLOT1RENOVATION().equals("Oui")){
                    if(sObject.getPLOT1RENOVATIONREASON().equals("Replanting")||sObject.getPLOT1RENOVATIONREASON().equals("Replantation")){
                        if (sObject.getHireLabor1().equals("Yes")||sObject.getHireLabor1().equals("Oui") ) {
                            fragment1.mainint("replant", "", "labor", plot1Area, avgCost, age1, estPrd1,farmerCost, "");
                            fragment1.other("labor");
                        } else if (sObject.getHireLabor1().equals("Seasonal")||sObject.getHireLabor1().equals("Saisonnier") ) {
                            fragment1.mainint("replant", "", "season", plot1Area, avgCost, age1, estPrd1,farmerCost, "");
                            fragment1.other("labor");
                        } else {
                            fragment1.mainint("replant", "", "", plot1Area, avgCost, age1, estPrd1,farmerCost, "");
                        }
                    }else{
                        if (sObject.getHireLabor1().equals("Yes")||sObject.getHireLabor1().equals("Oui") ) {
                            fragment1.mainint("graft", "", "labor", plot1Area, avgCost, age1, estPrd1,farmerCost, "");
                            fragment1.other("labor");
                        } else if (sObject.getHireLabor1().equals("Seasonal")||sObject.getHireLabor1().equals("Saisonnier")) {
                            fragment1.mainint("graft", "", "season", plot1Area, avgCost, age1, estPrd1,farmerCost, "");
                            fragment1.other("labor");
                        } else {
                            fragment1.mainint("graft", "", "", plot1Area, avgCost, age1, estPrd1,farmerCost, "");
                        }
                    }
                }else{
                    //main intervention
                    if (sObject.getRECO1().equals("replanting")) {
                        //Replant
                        if (Double.parseDouble(sObject.getPlot1Age())<30 && sObject.getTreeHealth1().equals("G")&&sObject.getDebilitatingDisease1().equals("G")){
                            if (sObject.getPlot1CocoaTrees().contentEquals("2x2")||sObject.getPlot1CocoaTrees().contentEquals("2x2.5")||sObject.getPlot1CocoaTrees().contentEquals("2x3")||sObject.getPlot1CocoaTrees().contentEquals("2.5x2.5")||sObject.getPlot1CocoaTrees().contentEquals("2x3.5")) {
                                if (sObject.getHireLabor1().equals("Yes") || sObject.getHireLabor1().equals("Oui")) {
                                    fragment1.mainint("replant", "", "labor", plot1Area, avgCost, age1, estPrd1,farmerCost, "t");
                                    fragment1.other("labor");
                                } else if (sObject.getHireLabor1().equals("Seasonal") || sObject.getHireLabor1().equals("Saisonnier")) {
                                    fragment1.mainint("replant", "", "season", plot1Area, avgCost, age1, estPrd1,farmerCost, "t");
                                    fragment1.other("labor");
                                } else {
                                    fragment1.mainint("replant", "", "", plot1Area, avgCost, age1, estPrd1,farmerCost, "t");
                                }
                            }else if(sObject.getPlot1CocoaTrees().contentEquals("3.5x4")||sObject.getPlot1CocoaTrees().contentEquals("4x4")){
                                if (sObject.getHireLabor1().equals("Yes") || sObject.getHireLabor1().equals("Oui")) {
                                    fragment1.mainint("replant", "", "labor", plot1Area, avgCost, age1, estPrd1,farmerCost, "f");
                                    fragment1.other("labor");
                                } else if (sObject.getHireLabor1().equals("Seasonal") || sObject.getHireLabor1().equals("Saisonnier")) {
                                    fragment1.mainint("replant", "", "season", plot1Area, avgCost, age1, estPrd1,farmerCost, "f");
                                    fragment1.other("labor");
                                } else {
                                    fragment1.mainint("replant", "", "", plot1Area, avgCost, age1, estPrd1,farmerCost, "f");
                                }
                            }else{
                                if (sObject.getHireLabor1().equals("Yes")||sObject.getHireLabor1().equals("Oui") ) {
                                    fragment1.mainint("replant", "", "labor", plot1Area, avgCost, age1, estPrd1,farmerCost,"");
                                    fragment1.other("labor");
                                } else if (sObject.getHireLabor1().equals("Seasonal")||sObject.getHireLabor1().equals("Saisonnier") ) {
                                    fragment1.mainint("replant", "", "season", plot1Area, avgCost, age1, estPrd1,farmerCost,"");
                                    fragment1.other("labor");
                                } else {
                                    fragment1.mainint("replant", "", "", plot1Area, avgCost, age1, estPrd1,farmerCost,"");
                                }
                            }

                        }else{
                            if (sObject.getHireLabor1().equals("Yes") || sObject.getHireLabor1().equals("Oui")) {
                                fragment1.mainint("replant", "", "labor", plot1Area, avgCost, age1, estPrd1,farmerCost, "");
                                fragment1.other("labor");
                            } else if (sObject.getHireLabor1().equals("Seasonal") || sObject.getHireLabor1().equals("Saisonnier")) {
                                fragment1.mainint("replant", "", "season", plot1Area, avgCost, age1, estPrd1,farmerCost, "");
                                fragment1.other("labor");
                            } else {
                                fragment1.mainint("replant", "", "", plot1Area, avgCost, age1, estPrd1,farmerCost, "");
                            }
                        }

                    }else if(sObject.getRECO1().equals("replanting+extra")) {
                        if (Double.parseDouble(sObject.getPlot1Age())<30 && sObject.getTreeHealth1().equals("G")&&sObject.getDebilitatingDisease1().equals("G")){
                            if (sObject.getPlot1CocoaTrees().contentEquals("2x2")||sObject.getPlot1CocoaTrees().contentEquals("2x2.5")||sObject.getPlot1CocoaTrees().contentEquals("2x3")||sObject.getPlot1CocoaTrees().contentEquals("2.5x2.5")||sObject.getPlot1CocoaTrees().contentEquals("2x3.5")) {
                                if (sObject.getHireLabor1().equals("Yes")||sObject.getHireLabor1().equals("Oui") ) {
                                    fragment1.mainint("replant", "extra", "labor", plot1Area, avgCost, age1, estPrd1,farmerCost, "t");
                                    fragment1.other("labor");
                                } else if (sObject.getHireLabor1().equals("Seasonal")||sObject.getHireLabor1().equals("Saisonnier") ) {
                                    fragment1.mainint("replant", "extra", "season", plot1Area, avgCost, age1, estPrd1,farmerCost, "t");
                                    fragment1.other("labor");
                                } else {
                                    fragment1.mainint("replant", "extra", "", plot1Area, avgCost, age1, estPrd1,farmerCost, "t");
                                }
                            }else if(sObject.getPlot1CocoaTrees().contentEquals("3.5x4")||sObject.getPlot1CocoaTrees().contentEquals("4x4")){
                                if (sObject.getHireLabor1().equals("Yes")||sObject.getHireLabor1().equals("Oui") ) {
                                    fragment1.mainint("replant", "extra", "labor", plot1Area, avgCost, age1, estPrd1,farmerCost, "f");
                                    fragment1.other("labor");
                                } else if (sObject.getHireLabor1().equals("Seasonal")||sObject.getHireLabor1().equals("Saisonnier") ) {
                                    fragment1.mainint("replant", "extra", "season", plot1Area, avgCost, age1, estPrd1,farmerCost, "f");
                                    fragment1.other("labor");
                                } else {
                                    fragment1.mainint("replant", "extra", "", plot1Area, avgCost, age1, estPrd1,farmerCost, "f");
                                }
                            }else{
                                if (sObject.getHireLabor1().equals("Yes")||sObject.getHireLabor1().equals("Oui") ) {
                                    fragment1.mainint("replant", "extra", "labor", plot1Area, avgCost, age1, estPrd1,farmerCost,"");
                                    fragment1.other("labor");
                                } else if (sObject.getHireLabor1().equals("Seasonal")||sObject.getHireLabor1().equals("Saisonnier") ) {
                                    fragment1.mainint("replant", "extra", "season", plot1Area, avgCost, age1, estPrd1,farmerCost,"");
                                    fragment1.other("labor");
                                } else {
                                    fragment1.mainint("replant", "extra", "", plot1Area, avgCost, age1, estPrd1,farmerCost,"");
                                }
                            }

                        }else{
                            if (sObject.getHireLabor1().equals("Yes")||sObject.getHireLabor1().equals("Oui") ) {
                                fragment1.mainint("replant", "extra", "labor", plot1Area, avgCost, age1, estPrd1,farmerCost,"");
                                fragment1.other("labor");
                            } else if (sObject.getHireLabor1().equals("Seasonal")||sObject.getHireLabor1().equals("Saisonnier") ) {
                                fragment1.mainint("replant", "extra", "season", plot1Area, avgCost, age1, estPrd1,farmerCost,"");
                                fragment1.other("labor");
                            } else {
                                fragment1.mainint("replant", "extra", "", plot1Area, avgCost, age1, estPrd1,farmerCost,"");
                            }
                        }


                    } else if (sObject.getRECO1().equals("grafting+extra")) {
                        //Graft
                        if (sObject.getHireLabor1().equals("Yes") || sObject.getHireLabor1().equals("Oui")) {
                            fragment1.mainint("graft", "extra", "labor", plot1Area, avgCost, age1, estPrd1,farmerCost,"");
                            fragment1.other("labor");
                        } else if (sObject.getHireLabor1().equals("Seasonal") || sObject.getHireLabor1().equals("Saisonnier")) {
                            fragment1.mainint("graft", "extra", "season", plot1Area, avgCost, age1, estPrd1,farmerCost,"");
                            fragment1.other("labor");
                        } else {
                            fragment1.mainint("graft", "extra", "", plot1Area, avgCost, age1, estPrd1,farmerCost,"");
                        }
                    }else if(sObject.getRECO1().equals("grafting")){
                        if (sObject.getHireLabor1().equals("Yes")||sObject.getHireLabor1().equals("Oui") ) {
                            fragment1.mainint("graft", "", "labor", plot1Area, avgCost, age1, estPrd1,farmerCost,"");
                            fragment1.other("labor");
                        } else if (sObject.getHireLabor1().equals("Seasonal")||sObject.getHireLabor1().equals("Saisonnier") ) {
                            fragment1.mainint("graft", "", "season", plot1Area, avgCost, age1, estPrd1,farmerCost,"");
                            fragment1.other("labor");
                        } else {
                            fragment1.mainint("graft", "", "", plot1Area, avgCost, age1, estPrd1,farmerCost,"");
                        }

                    } else if (sObject.getRECO1().equals("extra")) {
                        //Extra Soil Management
                        if (sObject.getHireLabor1().equals("Yes")||sObject.getHireLabor1().equals("Oui") ) {
                            fragment1.mainint("extra", "", "labor", plot1Area, avgCost, age1, estPrd1,farmerCost,"");
                            fragment1.other("labor");
                        } else if (sObject.getHireLabor1().equals("Seasonal")||sObject.getHireLabor1().equals("Saisonnier") ) {
                            fragment1.mainint("extra", "", "season", plot1Area, avgCost, age1, estPrd1,farmerCost,"");
                            fragment1.other("labor");
                        } else {
                            fragment1.mainint("extra", "", "", plot1Area, avgCost, age1, estPrd1,farmerCost,"");
                        }

                    } else if (sObject.getRECO1().equals("thinning+extra")) {
                        //Thinning
                        if (sObject.getHireLabor1().equals("Yes")||sObject.getHireLabor1().equals("Oui") ) {
                            fragment1.mainint("thinning", "extra", "labor", plot1Area, avgCost, age1, estPrd1,farmerCost,"");
                            fragment1.other("labor");
                        } else if (sObject.getHireLabor1().equals("Seasonal")||sObject.getHireLabor1().equals("Saisonnier") ) {
                            fragment1.mainint("thinning", "extra", "season", plot1Area, avgCost, age1, estPrd1,farmerCost,"");
                            fragment1.other("labor");
                        } else {
                            fragment1.mainint("thinning", "extra", "", plot1Area, avgCost, age1, estPrd1,farmerCost,"");
                        }

                    }else if (sObject.getRECO1().equals("thinning")) {
                        //Thinning
                        if (sObject.getHireLabor1().equals("Yes")||sObject.getHireLabor1().equals("Oui") ) {
                            fragment1.mainint("thinning", "", "labor", plot1Area, avgCost, age1, estPrd1,farmerCost,"");
                            fragment1.other("labor");
                        } else if (sObject.getHireLabor1().equals("Seasonal")||sObject.getHireLabor1().equals("Saisonnier") ) {
                            fragment1.mainint("thinning", "", "season", plot1Area, avgCost, age1, estPrd1,farmerCost,"");
                            fragment1.other("labor");
                        } else {
                            fragment1.mainint("thinning", "", "", plot1Area, avgCost, age1, estPrd1,farmerCost,"");
                        }

                    }else if (sObject.getRECO1().equals("filling+extra")) {
                        //filling
                        if (sObject.getHireLabor1().equals("Yes")||sObject.getHireLabor1().equals("Oui") ) {
                            fragment1.mainint("filling", "extra", "labor", plot1Area, avgCost, age1, estPrd1,farmerCost,"");
                            fragment1.other("labor");
                        } else if (sObject.getHireLabor1().equals("Seasonal")||sObject.getHireLabor1().equals("Saisonnier") ) {
                            fragment1.mainint("filling", "extra", "season", plot1Area, avgCost, age1, estPrd1,farmerCost,"");
                            fragment1.other("labor");
                        } else {
                            fragment1.mainint("filling", "extra", "", plot1Area, avgCost, age1, estPrd1,farmerCost,"");
                        }

                    }else if (sObject.getRECO1().equals("filling")) {
                        //filling
                        if (sObject.getHireLabor1().equals("Yes")||sObject.getHireLabor1().equals("Oui") ) {
                            fragment1.mainint("filling", "", "labor", plot1Area, avgCost, age1, estPrd1,farmerCost,"");
                            fragment1.other("labor");
                        } else if (sObject.getHireLabor1().equals("Seasonal")||sObject.getHireLabor1().equals("Saisonnier") ) {
                            fragment1.mainint("filling", "", "season", plot1Area, avgCost, age1, estPrd1,farmerCost,"");
                            fragment1.other("labor");
                        } else {
                            fragment1.mainint("filling", "", "", plot1Area, avgCost, age1, estPrd1,farmerCost,"");
                        }

                    }else {
                        //GAP
                        if (sObject.getHireLabor1().equals("Yes")||sObject.getHireLabor1().equals("Oui") ) {
                            fragment1.mainint("gap", "", "labor", plot1Area, avgCost, age1, estPrd1,farmerCost,"");
                            fragment1.other("labor");
                        } else if (sObject.getHireLabor1().equals("Seasonal")||sObject.getHireLabor1().equals("Saisonnier") ) {
                            fragment1.mainint("gap", "", "season", plot1Area, avgCost, age1, estPrd1,farmerCost,"");
                            fragment1.other("labor");
                        } else {
                            fragment1.mainint("gap", "", "", plot1Area, avgCost, age1, estPrd1,farmerCost,"");
                        }
                    }
                }

                //other interventions
                if (sObject.getLimeNeed1().equals("Yes")||sObject.getLimeNeed1().equals("Oui")) {
                    fragment1.other("lime");
                }

                if (sObject.getFillingOption1().equals("Yes")||sObject.getFillingOption1().equals("Non")) {
                    if (sObject.getPlot1CocoaTrees().contentEquals("2x2")||sObject.getPlot1CocoaTrees().contentEquals("2x2.5")||sObject.getPlot1CocoaTrees().contentEquals("2x3")||sObject.getPlot1CocoaTrees().contentEquals("2.5x2.5")||sObject.getPlot1CocoaTrees().contentEquals("2x3.5")) {
                        fragment1.other("thinning");
                    }else{
                        fragment1.other("filling");
                    }

                }

                if (sObject.getDrainageNeed1().equals("Yes")||sObject.getDrainageNeed1().equals("Oui")) {
                    fragment1.other("drainage");
                }

                ft.show(fragment1);
            }else{ft.hide(fragment1);}
            //plot2

            if (Integer.valueOf(sObject.getNumberOfPlots()) > 1) {
                setText(plot2,getString(R.string.pt2));
                fragment2.setStartYear(startY2);
                if(sObject.getPLOT2RENOVATION().equals("Yes")||sObject.getPLOT2RENOVATION().equals("Oui")){
                    if(sObject.getPLOT2RENOVATIONREASON().equals("Replanting")||sObject.getPLOT2RENOVATIONREASON().equals("Replantation")){
                        if (sObject.getHireLabor2().equals("Yes")||sObject.getHireLabor2().equals("Oui") ) {
                            fragment2.mainint("replant", "", "labor", plot2Area, avgCost, age2, estPrd2,farmerCost,"");
                            fragment2.other("labor");
                        } else if (sObject.getHireLabor2().equals("Seasonal")||sObject.getHireLabor2().equals("Saisonnier") ) {
                            fragment2.mainint("replant", "", "season", plot2Area, avgCost, age2, estPrd2,farmerCost,"");
                            fragment2.other("labor");
                        } else {
                            fragment2.mainint("replant", "", "", plot2Area, avgCost, age2, estPrd2,farmerCost,"");
                        }
                    }else{
                        if (sObject.getHireLabor2().equals("Yes")||sObject.getHireLabor2().equals("Oui") ) {
                            fragment2.mainint("graft", "", "labor", plot2Area, avgCost, age2, estPrd2,farmerCost,"");
                            fragment2.other("labor");
                        } else if (sObject.getHireLabor2().equals("Seasonal")||sObject.getHireLabor2().equals("Saisonnier") ) {
                            fragment2.mainint("graft", "", "season", plot2Area, avgCost, age2, estPrd2,farmerCost,"");
                            fragment2.other("labor");
                        } else {
                            fragment2.mainint("graft", "", "", plot2Area, avgCost, age2, estPrd2,farmerCost,"");
                        }
                    }
                }else{
                    //main intervention
                    if (sObject.getRECO2().equals("replanting")) {
                        //Replant
                        if (Double.parseDouble(sObject.getPlot2Age())<30 && sObject.getTreeHealth2().equals("G")&&sObject.getDebilitatingDisease2().equals("G")){

                            if (sObject.getPlot2CocoaTrees().contentEquals("2x2")||sObject.getPlot2CocoaTrees().contentEquals("2x2.5")||sObject.getPlot2CocoaTrees().contentEquals("2x3")||sObject.getPlot2CocoaTrees().contentEquals("2.5x2.5")||sObject.getPlot2CocoaTrees().contentEquals("2x3.5")) {
                                if (sObject.getHireLabor2().equals("Yes")||sObject.getHireLabor2().equals("Oui") ) {
                                    fragment2.mainint("replant", "", "labor", plot2Area, avgCost, age2, estPrd2,farmerCost, "t");
                                    fragment2.other("labor");
                                } else if (sObject.getHireLabor2().equals("Seasonal")||sObject.getHireLabor2().equals("Saisonnier") ) {
                                    fragment2.mainint("replant", "", "season", plot2Area, avgCost, age2, estPrd2,farmerCost, "t");
                                    fragment2.other("labor");
                                } else {
                                    fragment2.mainint("replant", "", "", plot2Area, avgCost, age2, estPrd2,farmerCost, "t");
                                }
                            }else if(sObject.getPlot2CocoaTrees().contentEquals("3.5x4")||sObject.getPlot2CocoaTrees().contentEquals("4x4")){
                                if (sObject.getHireLabor2().equals("Yes")||sObject.getHireLabor2().equals("Oui") ) {
                                    fragment2.mainint("replant", "", "labor", plot2Area, avgCost, age2, estPrd2,farmerCost, "f");
                                    fragment2.other("labor");
                                } else if (sObject.getHireLabor2().equals("Seasonal")||sObject.getHireLabor2().equals("Saisonnier") ) {
                                    fragment2.mainint("replant", "", "season", plot2Area, avgCost, age2, estPrd2,farmerCost, "f");
                                    fragment2.other("labor");
                                } else {
                                    fragment2.mainint("replant", "", "", plot2Area, avgCost, age2, estPrd2,farmerCost, "f");
                                }
                            }else{
                                if (sObject.getHireLabor2().equals("Yes")||sObject.getHireLabor2().equals("Oui") ) {
                                    fragment2.mainint("replant", "", "labor", plot2Area, avgCost, age2, estPrd2,farmerCost,"");
                                    fragment2.other("labor");
                                } else if (sObject.getHireLabor2().equals("Seasonal")||sObject.getHireLabor2().equals("Saisonnier") ) {
                                    fragment2.mainint("replant", "", "season", plot2Area, avgCost, age2, estPrd2,farmerCost,"");
                                    fragment2.other("labor");
                                } else {
                                    fragment2.mainint("replant", "", "", plot2Area, avgCost, age2, estPrd2,farmerCost,"");
                                }
                            }

                        }else{
                            if (sObject.getHireLabor2().equals("Yes")||sObject.getHireLabor2().equals("Oui") ) {
                                fragment2.mainint("replant", "", "labor", plot2Area, avgCost, age2, estPrd2,farmerCost,"");
                                fragment2.other("labor");
                            } else if (sObject.getHireLabor2().equals("Seasonal")||sObject.getHireLabor2().equals("Saisonnier") ) {
                                fragment2.mainint("replant", "", "season", plot2Area, avgCost, age2, estPrd2,farmerCost,"");
                                fragment2.other("labor");
                            } else {
                                fragment2.mainint("replant", "", "", plot2Area, avgCost, age2, estPrd2,farmerCost,"");
                            }
                        }

                    }else if(sObject.getRECO2().equals("replanting+extra")) {
                        if (Double.parseDouble(sObject.getPlot2Age())<30 && sObject.getTreeHealth2().equals("G")&&sObject.getDebilitatingDisease2().equals("G")){

                            if (sObject.getPlot2CocoaTrees().contentEquals("2x2")||sObject.getPlot2CocoaTrees().contentEquals("2x2.5")||sObject.getPlot2CocoaTrees().contentEquals("2x3")||sObject.getPlot2CocoaTrees().contentEquals("2.5x2.5")||sObject.getPlot2CocoaTrees().contentEquals("2x3.5")) {
                                if (sObject.getHireLabor2().equals("Yes")||sObject.getHireLabor2().equals("Oui") ) {
                                    fragment2.mainint("replant", "extra", "labor", plot2Area, avgCost, age2, estPrd2,farmerCost, "t");
                                    fragment2.other("labor");
                                } else if (sObject.getHireLabor2().equals("Seasonal")||sObject.getHireLabor2().equals("Saisonnier") ) {
                                    fragment2.mainint("replant", "extra", "season", plot2Area, avgCost, age2, estPrd2,farmerCost, "t");
                                    fragment2.other("labor");
                                } else {
                                    fragment2.mainint("replant", "extra", "", plot2Area, avgCost, age2, estPrd2,farmerCost, "t");
                                }
                            }else if(sObject.getPlot2CocoaTrees().contentEquals("3.5x4")||sObject.getPlot2CocoaTrees().contentEquals("4x4")){
                                if (sObject.getHireLabor2().equals("Yes")||sObject.getHireLabor2().equals("Oui") ) {
                                    fragment2.mainint("replant", "extra", "labor", plot2Area, avgCost, age2, estPrd2,farmerCost, "f");
                                    fragment2.other("labor");
                                } else if (sObject.getHireLabor2().equals("Seasonal")||sObject.getHireLabor2().equals("Saisonnier") ) {
                                    fragment2.mainint("replant", "extra", "season", plot2Area, avgCost, age2, estPrd2,farmerCost, "f");
                                    fragment2.other("labor");
                                } else {
                                    fragment2.mainint("replant", "extra", "", plot2Area, avgCost, age2, estPrd2,farmerCost, "f");
                                }
                            }else{
                                if (sObject.getHireLabor2().equals("Yes")||sObject.getHireLabor2().equals("Oui") ) {
                                    fragment2.mainint("replant", "extra", "labor", plot2Area, avgCost, age2, estPrd2,farmerCost,"");
                                    fragment2.other("labor");
                                } else if (sObject.getHireLabor2().equals("Seasonal")||sObject.getHireLabor2().equals("Saisonnier") ) {
                                    fragment2.mainint("replant", "extra", "season", plot2Area, avgCost, age2, estPrd2,farmerCost,"");
                                    fragment2.other("labor");
                                } else {
                                    fragment2.mainint("replant", "extra", "", plot2Area, avgCost, age2, estPrd2,farmerCost,"");
                                }
                            }

                        }else{
                            if (sObject.getHireLabor2().equals("Yes")||sObject.getHireLabor2().equals("Oui") ) {
                                fragment2.mainint("replant", "extra", "labor", plot2Area, avgCost, age2, estPrd2,farmerCost,"");
                                fragment2.other("labor");
                            } else if (sObject.getHireLabor2().equals("Seasonal")||sObject.getHireLabor2().equals("Saisonnier") ) {
                                fragment2.mainint("replant", "extra", "season", plot2Area, avgCost, age2, estPrd2,farmerCost,"");
                                fragment2.other("labor");
                            } else {
                                fragment2.mainint("replant", "extra", "", plot2Area, avgCost, age2, estPrd2,farmerCost,"");
                            }
                        }


                    } else if (sObject.getRECO2().equals("grafting+extra")) {
                        //Graft
                        if (sObject.getHireLabor2().equals("Yes")||sObject.getHireLabor2().equals("Oui") ) {
                            fragment2.mainint("graft", "extra", "labor", plot2Area, avgCost, age2, estPrd2,farmerCost,"");
                            fragment2.other("labor");
                        } else if (sObject.getHireLabor2().equals("Seasonal")||sObject.getHireLabor2().equals("Saisonnier") ) {
                            fragment2.mainint("graft", "extra", "season", plot2Area, avgCost, age2, estPrd2,farmerCost,"");
                            fragment2.other("labor");
                        } else {
                            fragment2.mainint("graft", "extra", "", plot2Area, avgCost, age2, estPrd2,farmerCost,"");
                        }
                    } else if (sObject.getRECO2().equals("grafting")){
                        if (sObject.getHireLabor2().equals("Yes")||sObject.getHireLabor2().equals("Oui") ) {
                            fragment2.mainint("graft", "", "labor", plot2Area, avgCost, age2, estPrd2,farmerCost,"");
                            fragment2.other("labor");
                        } else if (sObject.getHireLabor2().equals("Seasonal")||sObject.getHireLabor2().equals("Saisonnier") ) {
                            fragment2.mainint("graft", "", "season", plot2Area, avgCost, age2, estPrd2,farmerCost,"");
                            fragment2.other("labor");
                        } else {
                            fragment2.mainint("graft", "", "", plot2Area, avgCost, age2, estPrd2,farmerCost,"");
                        }

                    } else if (sObject.getRECO2().equals("extra")) {
                        //Extra Soil Management
                        if (sObject.getHireLabor2().equals("Yes")||sObject.getHireLabor2().equals("Oui") ) {
                            fragment2.mainint("extra", "", "labor", plot2Area, avgCost, age2, estPrd2,farmerCost,"");
                            fragment2.other("labor");
                        } else if (sObject.getHireLabor2().equals("Seasonal")||sObject.getHireLabor2().equals("Saisonnier") ) {
                            fragment2.mainint("extra", "", "season", plot2Area, avgCost, age2, estPrd2,farmerCost,"");
                            fragment2.other("labor");
                        } else {
                            fragment2.mainint("extra", "", "", plot2Area, avgCost, age2, estPrd2,farmerCost,"");
                        }

                    }else if (sObject.getRECO2().equals("thinning+extra")) {
                        //Thinning
                        if (sObject.getHireLabor2().equals("Yes")||sObject.getHireLabor2().equals("Oui") ) {
                            fragment2.mainint("thinning", "extra", "labor", plot2Area, avgCost, age2, estPrd2,farmerCost,"");
                            fragment2.other("labor");
                        } else if (sObject.getHireLabor2().equals("Seasonal")||sObject.getHireLabor2().equals("Saisonnier") ) {
                            fragment2.mainint("thinning", "extra", "season", plot2Area, avgCost, age2, estPrd2,farmerCost,"");
                            fragment2.other("labor");
                        } else {
                            fragment2.mainint("thinning", "extra", "", plot2Area, avgCost, age2, estPrd2,farmerCost,"");
                        }

                    }else if (sObject.getRECO2().equals("thinning")) {
                        //Thinning
                        if (sObject.getHireLabor2().equals("Yes")||sObject.getHireLabor2().equals("Oui") ) {
                            fragment2.mainint("thinning", "", "labor", plot2Area, avgCost, age2, estPrd2,farmerCost,"");
                            fragment2.other("labor");
                        } else if (sObject.getHireLabor2().equals("Seasonal")||sObject.getHireLabor2().equals("Saisonnier") ) {
                            fragment2.mainint("thinning", "", "season", plot2Area, avgCost, age2, estPrd2,farmerCost,"");
                            fragment2.other("labor");
                        } else {
                            fragment2.mainint("thinning", "", "", plot2Area, avgCost, age2, estPrd2,farmerCost,"");
                        }

                    }else if (sObject.getRECO2().equals("filling+extra")) {
                        //filling
                        if (sObject.getHireLabor2().equals("Yes")||sObject.getHireLabor2().equals("Oui") ) {
                            fragment2.mainint("filling", "extra", "labor", plot2Area, avgCost, age2, estPrd2,farmerCost,"");
                            fragment2.other("labor");
                        } else if (sObject.getHireLabor2().equals("Seasonal")||sObject.getHireLabor2().equals("Saisonnier") ) {
                            fragment2.mainint("filling", "extra", "season", plot2Area, avgCost, age2, estPrd2,farmerCost,"");
                            fragment2.other("labor");
                        } else {
                            fragment2.mainint("filling", "extra", "", plot2Area, avgCost, age2, estPrd2,farmerCost,"");
                        }

                    }else if (sObject.getRECO2().equals("filling")) {
                        //filling
                        if (sObject.getHireLabor2().equals("Yes")||sObject.getHireLabor2().equals("Oui") ) {
                            fragment2.mainint("filling", "", "labor", plot2Area, avgCost, age2, estPrd2,farmerCost,"");
                            fragment2.other("labor");
                        } else if (sObject.getHireLabor2().equals("Seasonal")||sObject.getHireLabor2().equals("Saisonnier") ) {
                            fragment2.mainint("filling", "", "season", plot2Area, avgCost, age2, estPrd2,farmerCost,"");
                            fragment2.other("labor");
                        } else {
                            fragment2.mainint("filling", "", "", plot2Area, avgCost, age2, estPrd2,farmerCost,"");
                        }

                    } else {
                        //GAP
                        if (sObject.getHireLabor2().equals("Yes")||sObject.getHireLabor2().equals("Oui") ) {
                            fragment2.mainint("gap", "", "labor", plot2Area, avgCost, age2, estPrd2,farmerCost,"");
                            fragment2.other("labor");
                        } else if (sObject.getHireLabor2().equals("Seasonal")||sObject.getHireLabor2().equals("Saisonnier") ) {
                            fragment2.mainint("gap", "", "season", plot2Area, avgCost, age2, estPrd2,farmerCost,"");
                            fragment2.other("labor");
                        } else {
                            fragment2.mainint("gap", "", "", plot2Area, avgCost, age2, estPrd2,farmerCost,"");
                        }
                    }
                }

                //other interventions
                if (sObject.getLimeNeed2().equals("Yes")||sObject.getLimeNeed2().equals("Oui")) {
                    fragment2.other("lime");
                }

                if (sObject.getFillingOption2().equals("Yes")||sObject.getFillingOption2().equals("Oui")) {
                    if (sObject.getPlot2CocoaTrees().contentEquals("2x2")||sObject.getPlot2CocoaTrees().contentEquals("2x2.5")||sObject.getPlot2CocoaTrees().contentEquals("2x3")||sObject.getPlot2CocoaTrees().contentEquals("2.5x2.5")||sObject.getPlot2CocoaTrees().contentEquals("2x3.5")) {
                        fragment2.other("thinning");
                    }else{
                        fragment2.other("filling");
                    }
                }

                if (sObject.getDrainageNeed2().equals("Yes")||sObject.getDrainageNeed2().equals("Oui")) {
                    fragment2.other("drainage");
                }

                ft.show(fragment2);
            }else{ft.hide(fragment2);}

            //plot3
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 2) {
                setText(plot3,getString(R.string.pt3));
                fragment3.getView().setBackgroundColor(Color.parseColor("#e5e5e5"));
                fragment3.setStartYear(startY3);
                if(sObject.getPLOT3RENOVATION().equals("Yes")||sObject.getPLOT3RENOVATION().equals("Oui")){
                    if(sObject.getPLOT3RENOVATIONREASON().equals("Replanting")||sObject.getPLOT3RENOVATIONREASON().equals("Replantation")){
                        if (sObject.getHireLabor3().equals("Yes")||sObject.getHireLabor3().equals("Oui") ) {
                            fragment3.mainint("replant", "", "labor", plot3Area, avgCost, age3, estPrd3,farmerCost,"");
                            fragment3.other("labor");
                        } else if (sObject.getHireLabor3().equals("Seasonal")||sObject.getHireLabor3().equals("Saisonnier") ) {
                            fragment3.mainint("replant", "", "season", plot3Area, avgCost, age3, estPrd3,farmerCost,"");
                            fragment3.other("labor");
                        } else {
                            fragment3.mainint("replant", "", "", plot3Area, avgCost, age3, estPrd3,farmerCost,"");
                        }
                    }else{
                        if (sObject.getHireLabor3().equals("Yes")||sObject.getHireLabor3().equals("Oui") ) {
                            fragment3.mainint("graft", "", "labor", plot3Area, avgCost, age3, estPrd3,farmerCost,"");
                            fragment3.other("labor");
                        } else if (sObject.getHireLabor3().equals("Seasonal")||sObject.getHireLabor3().equals("Saisonnier") ) {
                            fragment3.mainint("graft", "", "season", plot3Area, avgCost, age3, estPrd3,farmerCost,"");
                            fragment3.other("labor");
                        } else {
                            fragment3.mainint("graft", "", "", plot3Area, avgCost, age3, estPrd3,farmerCost,"");
                        }
                    }
                }else {
                    //main intervention
                    if (sObject.getRECO3().equals("replanting")) {
                        //Replant
                        if (Double.parseDouble(sObject.getPlot3Age())<30 && sObject.getTreeHealth3().equals("G")&&sObject.getDebilitatingDisease3().equals("G")){

                            if (sObject.getPlot3CocoaTrees().contentEquals("2x2")||sObject.getPlot3CocoaTrees().contentEquals("2x2.5")||sObject.getPlot3CocoaTrees().contentEquals("2x3")||sObject.getPlot3CocoaTrees().contentEquals("2.5x2.5")||sObject.getPlot2CocoaTrees().contentEquals("2x3.5")) {
                                if (sObject.getHireLabor3().equals("Yes")||sObject.getHireLabor3().equals("Oui") ) {
                                    fragment3.mainint("replant", "", "labor", plot3Area, avgCost, age3, estPrd3,farmerCost, "t");
                                    fragment3.other("labor");
                                } else if (sObject.getHireLabor3().equals("Seasonal")||sObject.getHireLabor3().equals("Saisonnier") ) {
                                    fragment3.mainint("replant", "", "season", plot3Area, avgCost, age3, estPrd3,farmerCost, "t");
                                    fragment3.other("labor");
                                } else {
                                    fragment3.mainint("replant", "", "", plot3Area, avgCost, age3, estPrd3,farmerCost, "t");
                                }
                            }else if(sObject.getPlot3CocoaTrees().contentEquals("3.5x4")||sObject.getPlot3CocoaTrees().contentEquals("4x4")){
                                if (sObject.getHireLabor3().equals("Yes")||sObject.getHireLabor3().equals("Oui") ) {
                                    fragment3.mainint("replant", "", "labor", plot3Area, avgCost, age3, estPrd3,farmerCost, "f");
                                    fragment3.other("labor");
                                } else if (sObject.getHireLabor3().equals("Seasonal")||sObject.getHireLabor3().equals("Saisonnier") ) {
                                    fragment3.mainint("replant", "", "season", plot3Area, avgCost, age3, estPrd3,farmerCost, "f");
                                    fragment3.other("labor");
                                } else {
                                    fragment3.mainint("replant", "", "", plot3Area, avgCost, age3, estPrd3,farmerCost, "f");
                                }
                            }else{
                                if (sObject.getHireLabor3().equals("Yes")||sObject.getHireLabor3().equals("Oui") ) {
                                    fragment3.mainint("replant", "", "labor", plot3Area, avgCost, age3, estPrd3,farmerCost,"");
                                    fragment3.other("labor");
                                } else if (sObject.getHireLabor3().equals("Seasonal")||sObject.getHireLabor3().equals("Saisonnier") ) {
                                    fragment3.mainint("replant", "", "season", plot3Area, avgCost, age3, estPrd3,farmerCost,"");
                                    fragment3.other("labor");
                                } else {
                                    fragment3.mainint("replant", "", "", plot3Area, avgCost, age3, estPrd3,farmerCost,"");
                                }
                            }

                        }else{
                            if (sObject.getHireLabor3().equals("Yes")||sObject.getHireLabor3().equals("Oui") ) {
                                fragment3.mainint("replant", "", "labor", plot3Area, avgCost, age3, estPrd3,farmerCost,"");
                                fragment3.other("labor");
                            } else if (sObject.getHireLabor3().equals("Seasonal")||sObject.getHireLabor3().equals("Saisonnier") ) {
                                fragment3.mainint("replant", "", "season", plot3Area, avgCost, age3, estPrd3,farmerCost,"");
                                fragment3.other("labor");
                            } else {
                                fragment3.mainint("replant", "", "", plot3Area, avgCost, age3, estPrd3,farmerCost,"");
                            }
                        }


                    }else if(sObject.getRECO3().equals("replanting+extra")) {
                        if (Double.parseDouble(sObject.getPlot3Age())<30 && sObject.getTreeHealth3().equals("G")&&sObject.getDebilitatingDisease3().equals("G")){

                            if (sObject.getPlot3CocoaTrees().contentEquals("2x2")||sObject.getPlot3CocoaTrees().contentEquals("2x2.5")||sObject.getPlot3CocoaTrees().contentEquals("2x3")||sObject.getPlot3CocoaTrees().contentEquals("2.5x2.5")||sObject.getPlot2CocoaTrees().contentEquals("2x3.5")) {
                                if (sObject.getHireLabor3().equals("Yes")||sObject.getHireLabor3().equals("Oui") ) {
                                    fragment3.mainint("replant", "extra", "labor", plot3Area, avgCost, age3, estPrd3,farmerCost, "t");
                                    fragment3.other("labor");
                                } else if (sObject.getHireLabor3().equals("Seasonal")||sObject.getHireLabor3().equals("Saisonnier") ) {
                                    fragment3.mainint("replant", "extra", "season", plot3Area, avgCost, age3, estPrd3,farmerCost, "t");
                                    fragment3.other("labor");
                                } else {
                                    fragment3.mainint("replant", "extra", "", plot3Area, avgCost, age3, estPrd3,farmerCost, "t");
                                }
                            }else if(sObject.getPlot3CocoaTrees().contentEquals("3.5x4")||sObject.getPlot3CocoaTrees().contentEquals("4x4")){
                                if (sObject.getHireLabor3().equals("Yes")||sObject.getHireLabor3().equals("Oui") ) {
                                    fragment3.mainint("replant", "extra", "labor", plot3Area, avgCost, age3, estPrd3,farmerCost, "f");
                                    fragment3.other("labor");
                                } else if (sObject.getHireLabor3().equals("Seasonal")||sObject.getHireLabor3().equals("Saisonnier") ) {
                                    fragment3.mainint("replant", "extra", "season", plot3Area, avgCost, age3, estPrd3,farmerCost, "f");
                                    fragment3.other("labor");
                                } else {
                                    fragment3.mainint("replant", "extra", "", plot3Area, avgCost, age3, estPrd3,farmerCost, "f");
                                }
                            }else{
                                if (sObject.getHireLabor3().equals("Yes")||sObject.getHireLabor3().equals("Oui") ) {
                                    fragment3.mainint("replant", "extra", "labor", plot3Area, avgCost, age3, estPrd3,farmerCost,"");
                                    fragment3.other("labor");
                                } else if (sObject.getHireLabor3().equals("Seasonal")||sObject.getHireLabor3().equals("Saisonnier") ) {
                                    fragment3.mainint("replant", "extra", "season", plot3Area, avgCost, age3, estPrd3,farmerCost,"");
                                    fragment3.other("labor");
                                } else {
                                    fragment3.mainint("replant", "extra", "", plot3Area, avgCost, age3, estPrd3,farmerCost,"");
                                }
                            }

                        }else{
                            if (sObject.getHireLabor3().equals("Yes")||sObject.getHireLabor3().equals("Oui") ) {
                                fragment3.mainint("replant", "extra", "labor", plot3Area, avgCost, age3, estPrd3,farmerCost,"");
                                fragment3.other("labor");
                            } else if (sObject.getHireLabor3().equals("Seasonal")||sObject.getHireLabor3().equals("Saisonnier") ) {
                                fragment3.mainint("replant", "extra", "season", plot3Area, avgCost, age3, estPrd3,farmerCost,"");
                                fragment3.other("labor");
                            } else {
                                fragment3.mainint("replant", "extra", "", plot3Area, avgCost, age3, estPrd3,farmerCost,"");
                            }
                        }


                    } else if (sObject.getRECO3().equals("grafting+extra")) {
                        //Graft
                        if (sObject.getHireLabor3().equals("Yes")||sObject.getHireLabor3().equals("Oui") ) {
                            fragment3.mainint("graft", "extra", "labor", plot3Area, avgCost, age3, estPrd3,farmerCost,"");
                            fragment3.other("labor");
                        } else if (sObject.getHireLabor3().equals("Seasonal")||sObject.getHireLabor3().equals("Saisonnier") ) {
                            fragment3.mainint("graft", "extra", "season", plot3Area, avgCost, age3, estPrd3,farmerCost,"");
                            fragment3.other("labor");
                        } else {
                            fragment3.mainint("graft", "extra", "", plot3Area, avgCost, age3, estPrd3,farmerCost,"");
                        }
                    } else if(sObject.getRECO3().equals("grafting")){
                        if (sObject.getHireLabor3().equals("Yes")||sObject.getHireLabor3().equals("Oui") ) {
                            fragment3.mainint("graft", "", "labor", plot3Area, avgCost, age3, estPrd3,farmerCost,"");
                            fragment3.other("labor");
                        } else if (sObject.getHireLabor3().equals("Seasonal")||sObject.getHireLabor3().equals("Saisonnier") ) {
                            fragment3.mainint("graft", "", "season", plot3Area, avgCost, age3, estPrd3,farmerCost,"");
                            fragment3.other("labor");
                        } else {
                            fragment3.mainint("graft", "", "", plot3Area, avgCost, age3, estPrd3,farmerCost,"");
                        }

                    } else if (sObject.getRECO3().equals("extra")) {
                        //Extra Soil Management
                        if (sObject.getHireLabor3().equals("Yes")||sObject.getHireLabor3().equals("Oui") ) {
                            fragment3.mainint("extra", "", "labor", plot3Area, avgCost, age3, estPrd3,farmerCost,"");
                            fragment3.other("labor");
                        } else if (sObject.getHireLabor3().equals("Seasonal")||sObject.getHireLabor3().equals("Saisonnier") ) {
                            fragment3.mainint("extra", "", "season", plot3Area, avgCost, age3, estPrd3,farmerCost,"");
                            fragment3.other("labor");
                        } else {
                            fragment3.mainint("extra", "", "", plot3Area, avgCost, age3, estPrd3,farmerCost,"");
                        }

                    }else if (sObject.getRECO3().equals("thinning+extra")) {
                        //Thinning
                        if (sObject.getHireLabor3().equals("Yes")||sObject.getHireLabor3().equals("Oui") ) {
                            fragment3.mainint("thinning", "extra", "labor", plot3Area, avgCost, age3, estPrd3,farmerCost,"");
                            fragment3.other("labor");
                        } else if (sObject.getHireLabor3().equals("Seasonal")||sObject.getHireLabor3().equals("Saisonnier") ) {
                            fragment3.mainint("thinning", "extra", "season", plot3Area, avgCost, age3, estPrd3,farmerCost,"");
                            fragment3.other("labor");
                        } else {
                            fragment3.mainint("thinning", "extra", "", plot3Area, avgCost, age3, estPrd3,farmerCost,"");
                        }

                    }else if (sObject.getRECO3().equals("thinning")) {
                        //Thinning
                        if (sObject.getHireLabor3().equals("Yes")||sObject.getHireLabor3().equals("Oui") ) {
                            fragment3.mainint("thinning", "", "labor", plot3Area, avgCost, age3, estPrd3,farmerCost,"");
                            fragment3.other("labor");
                        } else if (sObject.getHireLabor3().equals("Seasonal")||sObject.getHireLabor3().equals("Saisonnier") ) {
                            fragment3.mainint("thinning", "", "season", plot3Area, avgCost, age3, estPrd3,farmerCost,"");
                            fragment3.other("labor");
                        } else {
                            fragment3.mainint("thinning", "", "", plot3Area, avgCost, age3, estPrd3,farmerCost,"");
                        }

                    }else if (sObject.getRECO3().equals("filling+extra")) {
                        //filling
                        if (sObject.getHireLabor3().equals("Yes")||sObject.getHireLabor3().equals("Oui") ) {
                            fragment3.mainint("filling", "extra", "labor", plot3Area, avgCost, age3, estPrd3,farmerCost,"");
                            fragment3.other("labor");
                        } else if (sObject.getHireLabor3().equals("Seasonal")||sObject.getHireLabor3().equals("Saisonnier") ) {
                            fragment3.mainint("filling", "extra", "season", plot3Area, avgCost, age3, estPrd3,farmerCost,"");
                            fragment3.other("labor");
                        } else {
                            fragment3.mainint("filling", "extra", "", plot3Area, avgCost, age3, estPrd3,farmerCost,"");
                        }

                    }else if (sObject.getRECO3().equals("filling")) {
                        //filling
                        if (sObject.getHireLabor3().equals("Yes")||sObject.getHireLabor3().equals("Oui") ) {
                            fragment3.mainint("filling", "", "labor", plot3Area, avgCost, age3, estPrd3,farmerCost,"");
                            fragment3.other("labor");
                        } else if (sObject.getHireLabor3().equals("Seasonal")||sObject.getHireLabor3().equals("Saisonnier") ) {
                            fragment3.mainint("filling", "", "season", plot3Area, avgCost, age3, estPrd3,farmerCost,"");
                            fragment3.other("labor");
                        } else {
                            fragment3.mainint("filling", "", "", plot3Area, avgCost, age3, estPrd3,farmerCost,"");
                        }

                    } else {
                        //GAP
                        if (sObject.getHireLabor3().equals("Yes")||sObject.getHireLabor3().equals("Oui") ) {
                            fragment3.mainint("gap", "", "labor", plot3Area, avgCost, age3, estPrd3,farmerCost,"");
                            fragment3.other("labor");
                        } else if (sObject.getHireLabor3().equals("Seasonal")||sObject.getHireLabor3().equals("Saisonnier") ) {
                            fragment3.mainint("gap", "", "season", plot3Area, avgCost, age3, estPrd3,farmerCost,"");
                            fragment3.other("labor");
                        } else {
                            fragment3.mainint("gap", "", "", plot3Area, avgCost, age3, estPrd3,farmerCost,"");
                        }
                    }
                }

                //other interventions

                if (sObject.getLimeNeed3().equals("Yes")||sObject.getLimeNeed3().equals("Oui")) {
                    fragment3.other("lime");
                }

                if (sObject.getFillingOption3().equals("Yes")||sObject.getFillingOption3().equals("Oui")) {
                    if (sObject.getPlot3CocoaTrees().contentEquals("2x2")||sObject.getPlot3CocoaTrees().contentEquals("2x2.5")||sObject.getPlot3CocoaTrees().contentEquals("2x3")||sObject.getPlot3CocoaTrees().contentEquals("2.5x2.5")||sObject.getPlot2CocoaTrees().contentEquals("2x3.5")) {
                        fragment3.other("thinning");
                    }else{
                        fragment3.other("filling");
                    }
                }

                if (sObject.getDrainageNeed3().equals("Yes")||sObject.getDrainageNeed3().equals("Oui")) {
                    fragment3.other("drainage");
                }

                ft.show(fragment3);
            }else{ft.hide(fragment3);}

            //plot4
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 3) {
                setText(plot4,getString(R.string.pt4));
                fragment4.setStartYear(startY4);
                if(sObject.getPLOT4RENOVATION().equals("Yes")||sObject.getPLOT4RENOVATION().equals("Oui")){
                    if(sObject.getPLOT4RENOVATIONREASON().equals("Replanting")||sObject.getPLOT4RENOVATIONREASON().equals("Replantation")){
                        if (sObject.getHireLabor4().equals("Yes")||sObject.getHireLabor4().equals("Oui") ) {
                            fragment4.mainint("replant", "", "labor", plot4Area, avgCost, age4, estPrd4,farmerCost,"");
                            fragment4.other("labor");
                        } else if (sObject.getHireLabor4().equals("Seasonal")||sObject.getHireLabor4().equals("Saisonnier") ) {
                            fragment4.mainint("replant", "", "season", plot4Area, avgCost, age4, estPrd4,farmerCost,"");
                            fragment4.other("labor");
                        } else {
                            fragment4.mainint("replant", "", "", plot4Area, avgCost, age4, estPrd4,farmerCost,"");
                        }
                    }else{
                        if (sObject.getHireLabor4().equals("Yes")||sObject.getHireLabor4().equals("Oui") ) {
                            fragment4.mainint("graft", "", "labor", plot4Area, avgCost, age4, estPrd4,farmerCost,"");
                            fragment4.other("labor");
                        } else if (sObject.getHireLabor4().equals("Seasonal")||sObject.getHireLabor4().equals("Saisonnier") ) {
                            fragment4.mainint("graft", "", "season", plot4Area, avgCost, age4, estPrd4,farmerCost,"");
                            fragment4.other("labor");
                        } else {
                            fragment4.mainint("graft", "", "", plot4Area, avgCost, age4, estPrd4,farmerCost,"");
                        }
                    }
                }else {
                    //main intervention
                    if (sObject.getRECO4().equals("replanting")) {
                        //Replant
                        if (Double.parseDouble(sObject.getPlot4Age())<30 && sObject.getTreeHealth4().equals("G")&&sObject.getDebilitatingDisease4().equals("G")){

                            if (sObject.getPlot4CocoaTrees().contentEquals("2x2")||sObject.getPlot4CocoaTrees().contentEquals("2x2.5")||sObject.getPlot4CocoaTrees().contentEquals("2x3")||sObject.getPlot4CocoaTrees().contentEquals("2.5x2.5")||sObject.getPlot4CocoaTrees().contentEquals("2x3.5")) {
                                if (sObject.getHireLabor4().equals("Yes")||sObject.getHireLabor4().equals("Oui") ) {
                                    fragment4.mainint("replant", "", "labor", plot4Area, avgCost, age4, estPrd4,farmerCost, "t");
                                    fragment4.other("labor");
                                } else if (sObject.getHireLabor4().equals("Seasonal")||sObject.getHireLabor4().equals("Saisonnier") ) {
                                    fragment4.mainint("replant", "", "season", plot4Area, avgCost, age4, estPrd4,farmerCost, "t");
                                    fragment4.other("labor");
                                } else {
                                    fragment4.mainint("replant", "", "", plot4Area, avgCost, age4, estPrd4,farmerCost, "t");
                                }
                            }else if(sObject.getPlot4CocoaTrees().contentEquals("3.5x4")||sObject.getPlot4CocoaTrees().contentEquals("4x4")){
                                if (sObject.getHireLabor4().equals("Yes")||sObject.getHireLabor4().equals("Oui") ) {
                                    fragment4.mainint("replant", "", "labor", plot4Area, avgCost, age4, estPrd4,farmerCost, "f");
                                    fragment4.other("labor");
                                } else if (sObject.getHireLabor4().equals("Seasonal")||sObject.getHireLabor4().equals("Saisonnier") ) {
                                    fragment4.mainint("replant", "", "season", plot4Area, avgCost, age4, estPrd4,farmerCost, "f");
                                    fragment4.other("labor");
                                } else {
                                    fragment4.mainint("replant", "", "", plot4Area, avgCost, age4, estPrd4,farmerCost, "f");
                                }
                            }else{
                                if (sObject.getHireLabor4().equals("Yes")||sObject.getHireLabor4().equals("Oui") ) {
                                    fragment4.mainint("replant", "", "labor", plot4Area, avgCost, age4, estPrd4,farmerCost,"");
                                    fragment4.other("labor");
                                } else if (sObject.getHireLabor4().equals("Seasonal")||sObject.getHireLabor4().equals("Saisonnier") ) {
                                    fragment4.mainint("replant", "", "season", plot4Area, avgCost, age4, estPrd4,farmerCost,"");
                                    fragment4.other("labor");
                                } else {
                                    fragment4.mainint("replant", "", "", plot4Area, avgCost, age4, estPrd4,farmerCost,"");
                                }
                            }

                        }else{
                            if (sObject.getHireLabor4().equals("Yes")||sObject.getHireLabor4().equals("Oui") ) {
                                fragment4.mainint("replant", "", "labor", plot4Area, avgCost, age4, estPrd4,farmerCost,"");
                                fragment4.other("labor");
                            } else if (sObject.getHireLabor4().equals("Seasonal")||sObject.getHireLabor4().equals("Saisonnier") ) {
                                fragment4.mainint("replant", "", "season", plot4Area, avgCost, age4, estPrd4,farmerCost,"");
                                fragment4.other("labor");
                            } else {
                                fragment4.mainint("replant", "", "", plot4Area, avgCost, age4, estPrd4,farmerCost,"");
                            }
                        }

                    }else if(sObject.getRECO4().equals("replanting+extra")) {
                        if (Double.parseDouble(sObject.getPlot4Age())<30 && sObject.getTreeHealth4().equals("G")&&sObject.getDebilitatingDisease4().equals("G")){

                            if (sObject.getPlot4CocoaTrees().contentEquals("2x2")||sObject.getPlot4CocoaTrees().contentEquals("2x2.5")||sObject.getPlot4CocoaTrees().contentEquals("2x3")||sObject.getPlot4CocoaTrees().contentEquals("2.5x2.5")||sObject.getPlot4CocoaTrees().contentEquals("2x3.5")) {
                                if (sObject.getHireLabor4().equals("Yes")||sObject.getHireLabor4().equals("Oui") ) {
                                    fragment4.mainint("replant", "extra", "labor", plot4Area, avgCost, age4, estPrd4,farmerCost, "t");
                                    fragment4.other("labor");
                                } else if (sObject.getHireLabor4().equals("Seasonal")||sObject.getHireLabor4().equals("Saisonnier") ) {
                                    fragment4.mainint("replant", "extra", "season", plot4Area, avgCost, age4, estPrd4,farmerCost, "t");
                                    fragment4.other("labor");
                                } else {
                                    fragment4.mainint("replant", "extra", "", plot4Area, avgCost, age4, estPrd4,farmerCost, "t");
                                }
                            }else if(sObject.getPlot4CocoaTrees().contentEquals("3.5x4")||sObject.getPlot4CocoaTrees().contentEquals("4x4")){
                                if (sObject.getHireLabor4().equals("Yes")||sObject.getHireLabor4().equals("Oui") ) {
                                    fragment4.mainint("replant", "extra", "labor", plot4Area, avgCost, age4, estPrd4,farmerCost, "f");
                                    fragment4.other("labor");
                                } else if (sObject.getHireLabor4().equals("Seasonal")||sObject.getHireLabor4().equals("Saisonnier") ) {
                                    fragment4.mainint("replant", "extra", "season", plot4Area, avgCost, age4, estPrd4,farmerCost, "f");
                                    fragment4.other("labor");
                                } else {
                                    fragment4.mainint("replant", "extra", "", plot4Area, avgCost, age4, estPrd4,farmerCost, "f");
                                }
                            }else{
                                if (sObject.getHireLabor4().equals("Yes")||sObject.getHireLabor4().equals("Oui") ) {
                                    fragment4.mainint("replant", "extra", "labor", plot4Area, avgCost, age4, estPrd4,farmerCost,"");
                                    fragment4.other("labor");
                                } else if (sObject.getHireLabor4().equals("Seasonal")||sObject.getHireLabor4().equals("Saisonnier") ) {
                                    fragment4.mainint("replant", "extra", "season", plot4Area, avgCost, age4, estPrd4,farmerCost,"");
                                    fragment4.other("labor");
                                } else {
                                    fragment4.mainint("replant", "extra", "", plot4Area, avgCost, age4, estPrd4,farmerCost,"");
                                }
                            }

                        }else{
                            if (sObject.getHireLabor4().equals("Yes")||sObject.getHireLabor4().equals("Oui") ) {
                                fragment4.mainint("replant", "extra", "labor", plot4Area, avgCost, age4, estPrd4,farmerCost,"");
                                fragment4.other("labor");
                            } else if (sObject.getHireLabor4().equals("Seasonal")||sObject.getHireLabor4().equals("Saisonnier") ) {
                                fragment4.mainint("replant", "extra", "season", plot4Area, avgCost, age4, estPrd4,farmerCost,"");
                                fragment4.other("labor");
                            } else {
                                fragment4.mainint("replant", "extra", "", plot4Area, avgCost, age4, estPrd4,farmerCost,"");
                            }
                        }

                    } else if (sObject.getRECO4().equals("grafting+extra")) {
                        //Graft
                        if (sObject.getHireLabor4().equals("Yes")||sObject.getHireLabor4().equals("Oui") ) {
                            fragment4.mainint("graft", "extra", "labor", plot4Area, avgCost, age4, estPrd4,farmerCost,"");
                            fragment4.other("labor");
                        } else if (sObject.getHireLabor4().equals("Seasonal")||sObject.getHireLabor4().equals("Saisonnier") ) {
                            fragment4.mainint("graft", "extra", "season", plot4Area, avgCost, age4, estPrd4,farmerCost,"");
                            fragment4.other("labor");
                        } else {
                            fragment4.mainint("graft", "extra", "", plot4Area, avgCost, age4, estPrd4,farmerCost,"");
                        }
                    } else if (sObject.getRECO4().equals("grafting")){
                        if (sObject.getHireLabor4().equals("Yes")||sObject.getHireLabor4().equals("Oui") ) {
                            fragment4.mainint("graft", "", "labor", plot4Area, avgCost, age4, estPrd4,farmerCost,"");
                            fragment4.other("labor");
                        } else if (sObject.getHireLabor4().equals("Seasonal")||sObject.getHireLabor4().equals("Saisonnier") ) {
                            fragment4.mainint("graft", "", "season", plot4Area, avgCost, age4, estPrd4,farmerCost,"");
                            fragment4.other("labor");
                        } else {
                            fragment4.mainint("graft", "", "", plot4Area, avgCost, age4, estPrd4,farmerCost,"");
                        }

                    } else if (sObject.getRECO4().equals("extra")) {
                        //Extra Soil Management
                        if (sObject.getHireLabor4().equals("Yes")||sObject.getHireLabor4().equals("Oui") ) {
                            fragment4.mainint("extra", "", "labor", plot4Area, avgCost, age4, estPrd4,farmerCost,"");
                            fragment4.other("labor");
                        } else if (sObject.getHireLabor4().equals("Seasonal")||sObject.getHireLabor4().equals("Saisonnier") ) {
                            fragment4.mainint("extra", "", "season", plot4Area, avgCost, age4, estPrd4,farmerCost,"");
                            fragment4.other("labor");
                        } else {
                            fragment4.mainint("extra", "", "", plot4Area, avgCost, age4, estPrd4,farmerCost,"");
                        }

                    }else if (sObject.getRECO4().equals("thinning+extra")) {
                        //Thinning
                        if (sObject.getHireLabor4().equals("Yes")||sObject.getHireLabor4().equals("Oui") ) {
                            fragment4.mainint("thinning", "extra", "labor", plot4Area, avgCost, age4, estPrd4,farmerCost,"");
                            fragment4.other("labor");
                        } else if (sObject.getHireLabor4().equals("Seasonal")||sObject.getHireLabor4().equals("Saisonnier") ) {
                            fragment4.mainint("thinning", "extra", "season", plot4Area, avgCost, age4, estPrd4,farmerCost,"");
                            fragment4.other("labor");
                        } else {
                            fragment4.mainint("thinning", "extra", "", plot4Area, avgCost, age4, estPrd4,farmerCost,"");
                        }

                    }else if (sObject.getRECO4().equals("thinning")) {
                        //Thinning
                        if (sObject.getHireLabor4().equals("Yes")||sObject.getHireLabor4().equals("Oui") ) {
                            fragment4.mainint("thinning", "", "labor", plot4Area, avgCost, age4, estPrd4,farmerCost,"");
                            fragment4.other("labor");
                        } else if (sObject.getHireLabor4().equals("Seasonal")||sObject.getHireLabor4().equals("Saisonnier") ) {
                            fragment4.mainint("thinning", "", "season", plot4Area, avgCost, age4, estPrd4,farmerCost,"");
                            fragment4.other("labor");
                        } else {
                            fragment4.mainint("thinning", "", "", plot4Area, avgCost, age4, estPrd4,farmerCost,"");
                        }

                    }else if (sObject.getRECO4().equals("filling+extra")) {
                        //filling
                        if (sObject.getHireLabor4().equals("Yes")||sObject.getHireLabor4().equals("Oui") ) {
                            fragment4.mainint("filling", "extra", "labor", plot4Area, avgCost, age4, estPrd4,farmerCost,"");
                            fragment4.other("labor");
                        } else if (sObject.getHireLabor4().equals("Seasonal")||sObject.getHireLabor4().equals("Saisonnier") ) {
                            fragment4.mainint("filling", "extra", "season", plot4Area, avgCost, age4, estPrd4,farmerCost,"");
                            fragment4.other("labor");
                        } else {
                            fragment4.mainint("filling", "extra", "", plot4Area, avgCost, age4, estPrd4,farmerCost,"");
                        }

                    }else if (sObject.getRECO4().equals("filling")) {
                        //filling
                        if (sObject.getHireLabor4().equals("Yes")||sObject.getHireLabor4().equals("Oui") ) {
                            fragment4.mainint("filling", "", "labor", plot4Area, avgCost, age4, estPrd4,farmerCost,"");
                            fragment4.other("labor");
                        } else if (sObject.getHireLabor4().equals("Seasonal")||sObject.getHireLabor4().equals("Saisonnier") ) {
                            fragment4.mainint("filling", "", "season", plot4Area, avgCost, age4, estPrd4,farmerCost,"");
                            fragment4.other("labor");
                        } else {
                            fragment4.mainint("filling", "", "", plot4Area, avgCost, age4, estPrd4,farmerCost,"");
                        }

                    } else {
                        //GAP
                        if (sObject.getHireLabor4().equals("Yes")||sObject.getHireLabor4().equals("Oui") ) {
                            fragment4.mainint("gap", "", "labor", plot4Area, avgCost, age4, estPrd4,farmerCost,"");
                            fragment4.other("labor");
                        } else if (sObject.getHireLabor4().equals("Seasonal")||sObject.getHireLabor4().equals("Saisonnier") ) {
                            fragment4.mainint("gap", "", "season", plot4Area, avgCost, age4, estPrd4,farmerCost,"");
                            fragment4.other("labor");
                        } else {
                            fragment4.mainint("gap", "", "", plot4Area, avgCost, age4, estPrd4,farmerCost,"");
                        }
                    }
                }

                //other interventions
                if (sObject.geLimeNeed4().equals("Yes")||sObject.geLimeNeed4().equals("Oui")) {
                    fragment4.other("lime");
                }

                if (sObject.getFillingOption4().equals("Yes")||sObject.getFillingOption4().equals("Oui")) {
                    if (sObject.getPlot4CocoaTrees().contentEquals("2x2")||sObject.getPlot4CocoaTrees().contentEquals("2x2.5")||sObject.getPlot4CocoaTrees().contentEquals("2x3")||sObject.getPlot4CocoaTrees().contentEquals("2.5x2.5")||sObject.getPlot4CocoaTrees().contentEquals("2x3.5")) {
                        fragment4.other("thinning");
                    }else{
                        fragment4.other("filling");
                    }
                }

                if (sObject.getDrainageNeed4().equals("Yes")||sObject.getDrainageNeed4().equals("Oui")) {
                    fragment4.other("drainage");
                }
                ft.show(fragment4);
            }else{ft.hide(fragment4);}

            //plot5
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 4) {
                setText(plot5,getString(R.string.pt5));
                fragment5.getView().setBackgroundColor(Color.parseColor("#e5e5e5"));
                fragment5.setStartYear(startY5);
                if(sObject.getPLOT5RENOVATION().equals("Yes")||sObject.getPLOT5RENOVATION().equals("Oui")){
                    if(sObject.getPLOT5RENOVATIONREASON().equals("Replanting")||sObject.getPLOT5RENOVATIONREASON().equals("Replantation")){
                        if (sObject.getHireLabor5().equals("Yes")||sObject.getHireLabor5().equals("Oui") ) {
                            fragment5.mainint("replant", "", "labor", plot5Area, avgCost, age5, estPrd5,farmerCost,"");
                            fragment5.other("labor");
                        } else if (sObject.getHireLabor5().equals("Seasonal")||sObject.getHireLabor5().equals("Saisonnier") ) {
                            fragment5.mainint("replant", "", "season", plot5Area, avgCost, age5, estPrd5,farmerCost,"");
                            fragment5.other("labor");
                        } else {
                            fragment5.mainint("replant", "", "", plot5Area, avgCost, age5, estPrd5,farmerCost,"");
                        }
                    }else{
                        if (sObject.getHireLabor5().equals("Yes")||sObject.getHireLabor5().equals("Oui") ) {
                            fragment5.mainint("graft", "", "labor", plot5Area, avgCost, age5, estPrd5,farmerCost,"");
                            fragment5.other("labor");
                        } else if (sObject.getHireLabor5().equals("Seasonal")||sObject.getHireLabor5().equals("Saisonnier") ) {
                            fragment5.mainint("graft", "", "season", plot5Area, avgCost, age5, estPrd5,farmerCost,"");
                            fragment5.other("labor");
                        } else {
                            fragment5.mainint("graft", "", "", plot5Area, avgCost, age5, estPrd5,farmerCost,"");
                        }
                    }
                }else {
                    //main intervention
                    if (sObject.getRECO5().equals("replanting")) {
                        //Replant
                        if (Double.parseDouble(sObject.getPlot5Age())<30 && sObject.getTreeHealth5().equals("G")&&sObject.getDebilitatingDisease5().equals("G")){

                            if (sObject.getPlot5CocoaTrees().contentEquals("2x2")||sObject.getPlot5CocoaTrees().contentEquals("2x2.5")||sObject.getPlot5CocoaTrees().contentEquals("2x3")||sObject.getPlot5CocoaTrees().contentEquals("2.5x2.5")||sObject.getPlot5CocoaTrees().contentEquals("2x3.5")) {
                                if (sObject.getHireLabor5().equals("Yes")||sObject.getHireLabor5().equals("Oui") ) {
                                    fragment5.mainint("replant", "", "labor", plot5Area, avgCost, age5, estPrd5,farmerCost, "t");
                                    fragment5.other("labor");
                                } else if (sObject.getHireLabor5().equals("Seasonal")||sObject.getHireLabor5().equals("Saisonnier") ) {
                                    fragment5.mainint("replant", "", "season", plot5Area, avgCost, age5, estPrd5,farmerCost, "t");
                                    fragment5.other("labor");
                                } else {
                                    fragment5.mainint("replant", "", "", plot5Area, avgCost, age5, estPrd5,farmerCost, "t");
                                }
                            }else if(sObject.getPlot5CocoaTrees().contentEquals("3.5x4")||sObject.getPlot5CocoaTrees().contentEquals("4x4")){
                                if (sObject.getHireLabor5().equals("Yes")||sObject.getHireLabor5().equals("Oui") ) {
                                    fragment5.mainint("replant", "", "labor", plot5Area, avgCost, age5, estPrd5,farmerCost, "f");
                                    fragment5.other("labor");
                                } else if (sObject.getHireLabor5().equals("Seasonal")||sObject.getHireLabor5().equals("Saisonnier") ) {
                                    fragment5.mainint("replant", "", "season", plot5Area, avgCost, age5, estPrd5,farmerCost, "f");
                                    fragment5.other("labor");
                                } else {
                                    fragment5.mainint("replant", "", "", plot5Area, avgCost, age5, estPrd5,farmerCost, "f");
                                }
                            }else{
                                if (sObject.getHireLabor5().equals("Yes")||sObject.getHireLabor5().equals("Oui") ) {
                                    fragment5.mainint("replant", "", "labor", plot5Area, avgCost, age5, estPrd5,farmerCost,"");
                                    fragment5.other("labor");
                                } else if (sObject.getHireLabor5().equals("Seasonal")||sObject.getHireLabor5().equals("Saisonnier") ) {
                                    fragment5.mainint("replant", "", "season", plot5Area, avgCost, age5, estPrd5,farmerCost,"");
                                    fragment5.other("labor");
                                } else {
                                    fragment5.mainint("replant", "", "", plot5Area, avgCost, age5, estPrd5,farmerCost,"");
                                }
                            }
                        }else{
                            if (sObject.getHireLabor5().equals("Yes")||sObject.getHireLabor5().equals("Oui") ) {
                                fragment5.mainint("replant", "", "labor", plot5Area, avgCost, age5, estPrd5,farmerCost,"");
                                fragment5.other("labor");
                            } else if (sObject.getHireLabor5().equals("Seasonal")||sObject.getHireLabor5().equals("Saisonnier") ) {
                                fragment5.mainint("replant", "", "season", plot5Area, avgCost, age5, estPrd5,farmerCost,"");
                                fragment5.other("labor");
                            } else {
                                fragment5.mainint("replant", "", "", plot5Area, avgCost, age5, estPrd5,farmerCost,"");
                            }
                        }
                    }else if (sObject.getRECO5().equals("replanting+extra")) {
                        if (Double.parseDouble(sObject.getPlot5Age())<30 && sObject.getTreeHealth5().equals("G")&&sObject.getDebilitatingDisease5().equals("G")){

                            if (sObject.getPlot5CocoaTrees().contentEquals("2x2")||sObject.getPlot5CocoaTrees().contentEquals("2x2.5")||sObject.getPlot5CocoaTrees().contentEquals("2x3")||sObject.getPlot5CocoaTrees().contentEquals("2.5x2.5")||sObject.getPlot5CocoaTrees().contentEquals("2x3.5")) {
                                if (sObject.getHireLabor5().equals("Yes")||sObject.getHireLabor5().equals("Oui") ) {
                                    fragment5.mainint("replant", "extra", "labor", plot5Area, avgCost, age5, estPrd5,farmerCost, "t");
                                    fragment5.other("labor");
                                } else if (sObject.getHireLabor5().equals("Seasonal")||sObject.getHireLabor5().equals("Saisonnier") ) {
                                    fragment5.mainint("replant", "extra", "season", plot5Area, avgCost, age5, estPrd5,farmerCost, "t");
                                    fragment5.other("labor");
                                } else {
                                    fragment5.mainint("replant", "extra", "", plot5Area, avgCost, age5, estPrd5,farmerCost, "t");
                                }
                            }else if(sObject.getPlot5CocoaTrees().contentEquals("3.5x4")||sObject.getPlot5CocoaTrees().contentEquals("4x4")){
                                if (sObject.getHireLabor5().equals("Yes")||sObject.getHireLabor5().equals("Oui") ) {
                                    fragment5.mainint("replant", "extra", "labor", plot5Area, avgCost, age5, estPrd5,farmerCost, "f");
                                    fragment5.other("labor");
                                } else if (sObject.getHireLabor5().equals("Seasonal")||sObject.getHireLabor5().equals("Saisonnier") ) {
                                    fragment5.mainint("replant", "extra", "season", plot5Area, avgCost, age5, estPrd5,farmerCost, "f");
                                    fragment5.other("labor");
                                } else {
                                    fragment5.mainint("replant", "extra", "", plot5Area, avgCost, age5, estPrd5,farmerCost, "f");
                                }
                            }else{
                                if (sObject.getHireLabor5().equals("Yes")||sObject.getHireLabor5().equals("Oui") ) {
                                    fragment5.mainint("replant", "extra", "labor", plot5Area, avgCost, age5, estPrd5,farmerCost,"");
                                    fragment5.other("labor");
                                } else if (sObject.getHireLabor5().equals("Seasonal")||sObject.getHireLabor5().equals("Saisonnier") ) {
                                    fragment5.mainint("replant", "extra", "season", plot5Area, avgCost, age5, estPrd5,farmerCost,"");
                                    fragment5.other("labor");
                                } else {
                                    fragment5.mainint("replant", "extra", "", plot5Area, avgCost, age5, estPrd5,farmerCost,"");
                                }
                            }

                        }else{
                            if (sObject.getHireLabor5().equals("Yes")||sObject.getHireLabor5().equals("Oui") ) {
                                fragment5.mainint("replant", "extra", "labor", plot5Area, avgCost, age5, estPrd5,farmerCost,"");
                                fragment5.other("labor");
                            } else if (sObject.getHireLabor5().equals("Seasonal")||sObject.getHireLabor5().equals("Saisonnier") ) {
                                fragment5.mainint("replant", "extra", "season", plot5Area, avgCost, age5, estPrd5,farmerCost,"");
                                fragment5.other("labor");
                            } else {
                                fragment5.mainint("replant", "extra", "", plot5Area, avgCost, age5, estPrd5,farmerCost,"");
                            }
                        }

                    } else if (sObject.getRECO5().equals("grafting+extra")) {
                        //Graft
                        if (sObject.getHireLabor5().equals("Yes")||sObject.getHireLabor5().equals("Oui") ) {
                            fragment5.mainint("graft", "extra", "labor", plot5Area, avgCost, age5, estPrd5,farmerCost,"");
                            fragment5.other("labor");
                        } else if (sObject.getHireLabor5().equals("Seasonal")||sObject.getHireLabor5().equals("Saisonnier") ) {
                            fragment5.mainint("graft", "extra", "season", plot5Area, avgCost, age5, estPrd5,farmerCost,"");
                            fragment5.other("labor");
                        } else {
                            fragment5.mainint("graft", "extra", "", plot5Area, avgCost, age5, estPrd5,farmerCost,"");
                        }
                    } else if(sObject.getRECO5().equals("grafting")){
                        if (sObject.getHireLabor5().equals("Yes")||sObject.getHireLabor5().equals("Oui") ) {
                            fragment5.mainint("graft", "", "labor", plot5Area, avgCost, age5, estPrd5,farmerCost,"");
                            fragment5.other("labor");
                        } else if (sObject.getHireLabor5().equals("Seasonal")||sObject.getHireLabor5().equals("Saisonnier") ) {
                            fragment5.mainint("graft", "", "season", plot5Area, avgCost, age5, estPrd5,farmerCost,"");
                            fragment5.other("labor");
                        } else {
                            fragment5.mainint("graft", "", "", plot5Area, avgCost, age5, estPrd5,farmerCost,"");
                        }

                    } else if (sObject.getRECO5().equals("extra")) {
                        //Extra Soil Management
                        if (sObject.getHireLabor5().equals("Yes")||sObject.getHireLabor5().equals("Oui") ) {
                            fragment5.mainint("extra", "", "labor", plot5Area, avgCost, age5, estPrd5,farmerCost,"");
                            fragment5.other("labor");
                        } else if (sObject.getHireLabor5().equals("Seasonal")||sObject.getHireLabor5().equals("Saisonnier") ) {
                            fragment5.mainint("extra", "", "season", plot5Area, avgCost, age5, estPrd5,farmerCost,"");
                            fragment5.other("labor");
                        } else {
                            fragment5.mainint("extra", "", "", plot5Area, avgCost, age5, estPrd5,farmerCost,"");
                        }

                    }else if (sObject.getRECO5().equals("thinning+extra")) {
                        //Thinning
                        if (sObject.getHireLabor5().equals("Yes")||sObject.getHireLabor5().equals("Oui") ) {
                            fragment5.mainint("thinning", "extra", "labor", plot5Area, avgCost, age5, estPrd5,farmerCost,"");
                            fragment5.other("labor");
                        } else if (sObject.getHireLabor5().equals("Seasonal")||sObject.getHireLabor5().equals("Saisonnier") ) {
                            fragment5.mainint("thinning", "extra", "season", plot5Area, avgCost, age5, estPrd5,farmerCost,"");
                            fragment5.other("labor");
                        } else {
                            fragment5.mainint("thinning", "extra", "", plot5Area, avgCost, age5, estPrd5,farmerCost,"");
                        }

                    }else if (sObject.getRECO5().equals("thinning")) {
                        //Thinning
                        if (sObject.getHireLabor5().equals("Yes")||sObject.getHireLabor5().equals("Oui") ) {
                            fragment5.mainint("thinning", "", "labor", plot5Area, avgCost, age5, estPrd5,farmerCost,"");
                            fragment5.other("labor");
                        } else if (sObject.getHireLabor5().equals("Seasonal")||sObject.getHireLabor5().equals("Saisonnier") ) {
                            fragment5.mainint("thinning", "", "season", plot5Area, avgCost, age5, estPrd5,farmerCost,"");
                            fragment5.other("labor");
                        } else {
                            fragment5.mainint("thinning", "", "", plot5Area, avgCost, age5, estPrd5,farmerCost,"");
                        }

                    }else if (sObject.getRECO5().equals("filling+extra")) {
                        //filling
                        if (sObject.getHireLabor5().equals("Yes")||sObject.getHireLabor5().equals("Oui") ) {
                            fragment5.mainint("filling", "extra", "labor", plot5Area, avgCost, age5, estPrd5,farmerCost,"");
                            fragment5.other("labor");
                        } else if (sObject.getHireLabor5().equals("Seasonal")||sObject.getHireLabor5().equals("Saisonnier") ) {
                            fragment5.mainint("filling", "extra", "season", plot5Area, avgCost, age5, estPrd5,farmerCost,"");
                            fragment5.other("labor");
                        } else {
                            fragment5.mainint("filling", "extra", "", plot5Area, avgCost, age5, estPrd5,farmerCost,"");
                        }

                    }else if (sObject.getRECO5().equals("filling")) {
                        //filling
                        if (sObject.getHireLabor5().equals("Yes")||sObject.getHireLabor5().equals("Oui") ) {
                            fragment5.mainint("filling", "", "labor", plot5Area, avgCost, age5, estPrd5,farmerCost,"");
                            fragment5.other("labor");
                        } else if (sObject.getHireLabor5().equals("Seasonal")||sObject.getHireLabor5().equals("Saisonnier") ) {
                            fragment5.mainint("filling", "", "season", plot5Area, avgCost, age5, estPrd5,farmerCost,"");
                            fragment5.other("labor");
                        } else {
                            fragment5.mainint("filling", "", "", plot5Area, avgCost, age5, estPrd5,farmerCost,"");
                        }

                    } else {
                        //GAP
                        if (sObject.getHireLabor5().equals("Yes")||sObject.getHireLabor5().equals("Oui") ) {
                            fragment5.mainint("gap", "", "labor", plot5Area, avgCost, age5, estPrd5,farmerCost,"");
                            fragment5.other("labor");
                        } else if (sObject.getHireLabor5().equals("Seasonal")||sObject.getHireLabor5().equals("Saisonnier") ) {
                            fragment5.mainint("gap", "", "season", plot5Area, avgCost, age5, estPrd5,farmerCost,"");
                            fragment5.other("labor");
                        } else {
                            fragment5.mainint("gap", "", "", plot5Area, avgCost, age5, estPrd5,farmerCost,"");
                        }
                    }
                }

                //other interventions
                if (sObject.getLimeNeed5().equals("Yes")||sObject.getLimeNeed5().equals("Oui")) {
                    fragment5.other("lime");
                }

                if (sObject.getFillingOption5().equals("Yes")||sObject.getFillingOption5().equals("Oui")) {
                    if (sObject.getPlot5CocoaTrees().contentEquals("2x2")||sObject.getPlot5CocoaTrees().contentEquals("2x2.5")||sObject.getPlot5CocoaTrees().contentEquals("2x3")||sObject.getPlot5CocoaTrees().contentEquals("2.5x2.5")||sObject.getPlot5CocoaTrees().contentEquals("2x3.5")) {
                        fragment5.other("thinning");
                    }else{
                        fragment5.other("filling");
                    }
                }

                if (sObject.getDrainageNeed5().equals("Yes")||sObject.getDrainageNeed5().equals("Oui")) {
                    fragment5.other("drainage");
                }
                ft.show(fragment5);
            }else{ft.hide(fragment5);}

            //plot6
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 5) {
                setText(plot6,getString(R.string.pt6));
                fragment6.setStartYear(startY6);
                if(sObject.getPLOT6RENOVATION().equals("Yes")||sObject.getPLOT6RENOVATION().equals("Oui")){
                    if(sObject.getPLOT6RENOVATIONREASON().equals("Replanting")||sObject.getPLOT6RENOVATIONREASON().equals("Replantation")){
                        if (sObject.getHireLabor6().equals("Yes")||sObject.getHireLabor6().equals("Oui") ) {
                            fragment6.mainint("replant", "", "labor", plot6Area, avgCost, age6, estPrd6,farmerCost,"");
                            fragment6.other("labor");
                        } else if (sObject.getHireLabor6().equals("Seasonal")||sObject.getHireLabor6().equals("Saisonnier") ) {
                            fragment6.mainint("replant", "", "season", plot6Area, avgCost, age6, estPrd6,farmerCost,"");
                            fragment6.other("labor");
                        } else {
                            fragment6.mainint("replant", "", "", plot6Area, avgCost, age6, estPrd6,farmerCost,"");
                        }
                    }else{
                        if (sObject.getHireLabor6().equals("Yes")||sObject.getHireLabor6().equals("Oui") ) {
                            fragment6.mainint("graft", "", "labor", plot6Area, avgCost, age6, estPrd6,farmerCost,"");
                            fragment6.other("labor");
                        } else if (sObject.getHireLabor6().equals("Seasonal")||sObject.getHireLabor6().equals("Saisonnier") ) {
                            fragment6.mainint("graft", "", "season", plot6Area, avgCost, age6, estPrd6,farmerCost,"");
                            fragment6.other("labor");
                        } else {
                            fragment6.mainint("graft", "", "", plot6Area, avgCost, age6, estPrd6,farmerCost,"");
                        }
                    }
                }else {
                    //main intervention
                    if (sObject.getRECO6().equals("replanting")) {
                        //Replant
                        if (Double.parseDouble(sObject.getPlot6Age())<30 && sObject.getTreeHealth6().equals("G")&&sObject.getDebilitatingDisease6().equals("G")){

                            if (sObject.getPlot6CocoaTrees().contentEquals("2x2")||sObject.getPlot6CocoaTrees().contentEquals("2x2.5")||sObject.getPlot6CocoaTrees().contentEquals("2x3")||sObject.getPlot6CocoaTrees().contentEquals("2.5x2.5")||sObject.getPlot6CocoaTrees().contentEquals("2x3.5")) {
                                if (sObject.getHireLabor6().equals("Yes")||sObject.getHireLabor6().equals("Oui") ) {
                                    fragment6.mainint("replant", "", "labor", plot6Area, avgCost, age6, estPrd6,farmerCost, "t");
                                    fragment6.other("labor");
                                } else if (sObject.getHireLabor6().equals("Seasonal")||sObject.getHireLabor6().equals("Saisonnier") ) {
                                    fragment6.mainint("replant", "", "season", plot6Area, avgCost, age6, estPrd6,farmerCost, "t");
                                    fragment6.other("labor");
                                } else {
                                    fragment6.mainint("replant", "", "", plot6Area, avgCost, age6, estPrd6,farmerCost, "t");
                                }
                            }else if(sObject.getPlot6CocoaTrees().contentEquals("3.5x4")||sObject.getPlot6CocoaTrees().contentEquals("4x4")){
                                if (sObject.getHireLabor6().equals("Yes")||sObject.getHireLabor6().equals("Oui") ) {
                                    fragment6.mainint("replant", "", "labor", plot6Area, avgCost, age6, estPrd6,farmerCost, "f");
                                    fragment6.other("labor");
                                } else if (sObject.getHireLabor6().equals("Seasonal")||sObject.getHireLabor6().equals("Saisonnier") ) {
                                    fragment6.mainint("replant", "", "season", plot6Area, avgCost, age6, estPrd6,farmerCost, "f");
                                    fragment6.other("labor");
                                } else {
                                    fragment6.mainint("replant", "", "", plot6Area, avgCost, age6, estPrd6,farmerCost, "f");
                                }
                            }else{
                                if (sObject.getHireLabor6().equals("Yes")||sObject.getHireLabor6().equals("Oui") ) {
                                    fragment6.mainint("replant", "", "labor", plot6Area, avgCost, age6, estPrd6,farmerCost,"");
                                    fragment6.other("labor");
                                } else if (sObject.getHireLabor6().equals("Seasonal")||sObject.getHireLabor6().equals("Saisonnier") ) {
                                    fragment6.mainint("replant", "", "season", plot6Area, avgCost, age6, estPrd6,farmerCost,"");
                                    fragment6.other("labor");
                                } else {
                                    fragment6.mainint("replant", "", "", plot6Area, avgCost, age6, estPrd6,farmerCost,"");
                                }
                            }
                            
                        }else{
                            if (sObject.getHireLabor6().equals("Yes")||sObject.getHireLabor6().equals("Oui") ) {
                                fragment6.mainint("replant", "", "labor", plot6Area, avgCost, age6, estPrd6,farmerCost,"");
                                fragment6.other("labor");
                            } else if (sObject.getHireLabor6().equals("Seasonal")||sObject.getHireLabor6().equals("Saisonnier") ) {
                                fragment6.mainint("replant", "", "season", plot6Area, avgCost, age6, estPrd6,farmerCost,"");
                                fragment6.other("labor");
                            } else {
                                fragment6.mainint("replant", "", "", plot6Area, avgCost, age6, estPrd6,farmerCost,"");
                            }
                        }
                    }else if (sObject.getRECO6().equals("replanting+extra")) {
                        if (Double.parseDouble(sObject.getPlot6Age())<30 && sObject.getTreeHealth6().equals("G")&&sObject.getDebilitatingDisease6().equals("G")){
                            if (sObject.getPlot6CocoaTrees().contentEquals("2x2")||sObject.getPlot6CocoaTrees().contentEquals("2x2.5")||sObject.getPlot6CocoaTrees().contentEquals("2x3")||sObject.getPlot6CocoaTrees().contentEquals("2.5x2.5")||sObject.getPlot6CocoaTrees().contentEquals("2x3.5")) {
                                if (sObject.getHireLabor6().equals("Yes")||sObject.getHireLabor6().equals("Oui") ) {
                                    fragment6.mainint("replant", "extra", "labor", plot6Area, avgCost, age6, estPrd6,farmerCost, "t");
                                    fragment6.other("labor");
                                } else if (sObject.getHireLabor6().equals("Seasonal")||sObject.getHireLabor6().equals("Saisonnier") ) {
                                    fragment6.mainint("replant", "extra", "season", plot6Area, avgCost, age6, estPrd6,farmerCost, "t");
                                    fragment6.other("labor");
                                } else {
                                    fragment6.mainint("replant", "extra", "", plot6Area, avgCost, age6, estPrd6,farmerCost, "t");
                                }
                            }else if(sObject.getPlot6CocoaTrees().contentEquals("3.5x4")||sObject.getPlot6CocoaTrees().contentEquals("4x4")){
                                if (sObject.getHireLabor6().equals("Yes")||sObject.getHireLabor6().equals("Oui") ) {
                                    fragment6.mainint("replant", "extra", "labor", plot6Area, avgCost, age6, estPrd6,farmerCost, "f");
                                    fragment6.other("labor");
                                } else if (sObject.getHireLabor6().equals("Seasonal")||sObject.getHireLabor6().equals("Saisonnier") ) {
                                    fragment6.mainint("replant", "extra", "season", plot6Area, avgCost, age6, estPrd6,farmerCost, "f");
                                    fragment6.other("labor");
                                } else {
                                    fragment6.mainint("replant", "extra", "", plot6Area, avgCost, age6, estPrd6,farmerCost, "f");
                                }
                            }else{
                                if (sObject.getHireLabor6().equals("Yes")||sObject.getHireLabor6().equals("Oui") ) {
                                    fragment6.mainint("replant", "extra", "labor", plot6Area, avgCost, age6, estPrd6,farmerCost,"");
                                    fragment6.other("labor");
                                } else if (sObject.getHireLabor6().equals("Seasonal")||sObject.getHireLabor6().equals("Saisonnier") ) {
                                    fragment6.mainint("replant", "extra", "season", plot6Area, avgCost, age6, estPrd6,farmerCost,"");
                                    fragment6.other("labor");
                                } else {
                                    fragment6.mainint("replant", "extra", "", plot6Area, avgCost, age6, estPrd6,farmerCost,"");
                                }
                            }
                            
                        }else{
                            if (sObject.getHireLabor6().equals("Yes")||sObject.getHireLabor6().equals("Oui") ) {
                                fragment6.mainint("replant", "extra", "labor", plot6Area, avgCost, age6, estPrd6,farmerCost,"");
                                fragment6.other("labor");
                            } else if (sObject.getHireLabor6().equals("Seasonal")||sObject.getHireLabor6().equals("Saisonnier") ) {
                                fragment6.mainint("replant", "extra", "season", plot6Area, avgCost, age6, estPrd6,farmerCost,"");
                                fragment6.other("labor");
                            } else {
                                fragment6.mainint("replant", "extra", "", plot6Area, avgCost, age6, estPrd6,farmerCost,"");
                            }
                        }

                    } else if (sObject.getRECO6().equals("grafting+extra")) {
                        //Graft
                        if (sObject.getHireLabor6().equals("Yes")||sObject.getHireLabor6().equals("Oui") ) {
                            fragment6.mainint("graft", "extra", "labor", plot6Area, avgCost, age6, estPrd6,farmerCost,"");
                            fragment6.other("labor");
                        } else if (sObject.getHireLabor6().equals("Seasonal")||sObject.getHireLabor6().equals("Saisonnier") ) {
                            fragment6.mainint("graft", "extra", "season", plot6Area, avgCost, age6, estPrd6,farmerCost,"");
                            fragment6.other("labor");
                        } else {
                            fragment6.mainint("graft", "extra", "", plot6Area, avgCost, age6, estPrd6,farmerCost,"");
                        }
                    } else  if(sObject.getRECO6().equals("grafting")){
                        if (sObject.getHireLabor6().equals("Yes")||sObject.getHireLabor6().equals("Oui") ) {
                            fragment6.mainint("graft", "", "labor", plot6Area, avgCost, age6, estPrd6,farmerCost,"");
                            fragment6.other("labor");
                        } else if (sObject.getHireLabor6().equals("Seasonal")||sObject.getHireLabor6().equals("Saisonnier") ) {
                            fragment6.mainint("graft", "", "season", plot6Area, avgCost, age6, estPrd6,farmerCost,"");
                            fragment6.other("labor");
                        } else {
                            fragment6.mainint("graft", "", "", plot6Area, avgCost, age6, estPrd6,farmerCost,"");
                        }

                    } else if (sObject.getRECO6().equals("extra")) {
                        //Extra Soil Management
                        if (sObject.getHireLabor6().equals("Yes")||sObject.getHireLabor6().equals("Oui") ) {
                            fragment6.mainint("extra", "", "labor", plot6Area, avgCost, age6, estPrd6,farmerCost,"");
                            fragment6.other("labor");
                        } else if (sObject.getHireLabor6().equals("Seasonal")||sObject.getHireLabor6().equals("Saisonnier") ) {
                            fragment6.mainint("extra", "", "season", plot6Area, avgCost, age6, estPrd6,farmerCost,"");
                            fragment6.other("labor");
                        } else {
                            fragment6.mainint("extra", "", "", plot6Area, avgCost, age6, estPrd6,farmerCost,"");
                        }

                    }else if (sObject.getRECO6().equals("thinning+extra")) {
                        //Thinning
                        if (sObject.getHireLabor6().equals("Yes")||sObject.getHireLabor6().equals("Oui") ) {
                            fragment6.mainint("thinning", "extra", "labor", plot6Area, avgCost, age6, estPrd6,farmerCost,"");
                            fragment6.other("labor");
                        } else if (sObject.getHireLabor6().equals("Seasonal")||sObject.getHireLabor6().equals("Saisonnier") ) {
                            fragment6.mainint("thinning", "extra", "season", plot6Area, avgCost, age6, estPrd6,farmerCost,"");
                            fragment6.other("labor");
                        } else {
                            fragment6.mainint("thinning", "extra", "", plot6Area, avgCost, age6, estPrd6,farmerCost,"");
                        }

                    }else if (sObject.getRECO6().equals("thinning")) {
                        //Thinning
                        if (sObject.getHireLabor6().equals("Yes")||sObject.getHireLabor6().equals("Oui") ) {
                            fragment6.mainint("thinning", "", "labor", plot6Area, avgCost, age6, estPrd6,farmerCost,"");
                            fragment6.other("labor");
                        } else if (sObject.getHireLabor6().equals("Seasonal")||sObject.getHireLabor6().equals("Saisonnier") ) {
                            fragment6.mainint("thinning", "", "season", plot6Area, avgCost, age6, estPrd6,farmerCost,"");
                            fragment6.other("labor");
                        } else {
                            fragment6.mainint("thinning", "", "", plot6Area, avgCost, age6, estPrd6,farmerCost,"");
                        }

                    }else if (sObject.getRECO6().equals("filling+extra")) {
                        //filling
                        if (sObject.getHireLabor6().equals("Yes")||sObject.getHireLabor6().equals("Oui") ) {
                            fragment6.mainint("filling", "extra", "labor", plot6Area, avgCost, age6, estPrd6,farmerCost,"");
                            fragment6.other("labor");
                        } else if (sObject.getHireLabor6().equals("Seasonal")||sObject.getHireLabor6().equals("Saisonnier") ) {
                            fragment6.mainint("filling", "extra", "season", plot6Area, avgCost, age6, estPrd6,farmerCost,"");
                            fragment6.other("labor");
                        } else {
                            fragment6.mainint("filling", "extra", "", plot6Area, avgCost, age6, estPrd6,farmerCost,"");
                        }

                    }else if (sObject.getRECO6().equals("filling")) {
                        //filling
                        if (sObject.getHireLabor6().equals("Yes")||sObject.getHireLabor6().equals("Oui") ) {
                            fragment6.mainint("filling", "", "labor", plot6Area, avgCost, age6, estPrd6,farmerCost,"");
                            fragment6.other("labor");
                        } else if (sObject.getHireLabor6().equals("Seasonal")||sObject.getHireLabor6().equals("Saisonnier") ) {
                            fragment6.mainint("filling", "", "season", plot6Area, avgCost, age6, estPrd6,farmerCost,"");
                            fragment6.other("labor");
                        } else {
                            fragment6.mainint("filling", "", "", plot6Area, avgCost, age6, estPrd6,farmerCost,"");
                        }

                    } else {
                        //GAP
                        if (sObject.getHireLabor6().equals("Yes")||sObject.getHireLabor6().equals("Oui") ) {
                            fragment6.mainint("gap", "", "labor", plot6Area, avgCost, age6, estPrd6,farmerCost,"");
                            fragment6.other("labor");
                        } else if (sObject.getHireLabor6().equals("Seasonal")||sObject.getHireLabor6().equals("Saisonnier") ) {
                            fragment6.mainint("gap", "", "season", plot6Area, avgCost, age6, estPrd6,farmerCost,"");
                            fragment6.other("labor");
                        } else {
                            fragment6.mainint("gap", "", "", plot6Area, avgCost, age6, estPrd6,farmerCost,"");
                        }
                    }
                }

                //other interventions
                if (sObject.getLimeNeed6().equals("Yes")||sObject.getLimeNeed6().equals("Oui")) {
                    fragment6.other("lime");
                }

                if (sObject.getFillingOption6().equals("Yes")||sObject.getFillingOption6().equals("Oui")) {
                    if (sObject.getPlot6CocoaTrees().contentEquals("2x2")||sObject.getPlot6CocoaTrees().contentEquals("2x2.5")||sObject.getPlot6CocoaTrees().contentEquals("2x3")||sObject.getPlot6CocoaTrees().contentEquals("2.5x2.5")||sObject.getPlot6CocoaTrees().contentEquals("2x3.5")) {
                        fragment6.other("thinning");
                    }else{
                        fragment6.other("filling");
                    }
                }

                if (sObject.getDrainageNeed6().equals("Yes")||sObject.getDrainageNeed6().equals("Oui")) {
                    fragment6.other("drainage");
                }
                ft.show(fragment6);
            }else{ft.hide(fragment6);}

            //plot7
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 6) {
                setText(plot7,getString(R.string.pt7));
                fragment7.getView().setBackgroundColor(Color.parseColor("#e5e5e5"));
                fragment7.setStartYear(startY7);
                if(sObject.getPLOT7RENOVATION().equals("Yes")||sObject.getPLOT7RENOVATION().equals("Oui")){
                    if(sObject.getPLOT7RENOVATIONREASON().equals("Replanting")||sObject.getPLOT7RENOVATIONREASON().equals("Replantation")){
                        if (sObject.getHireLabor7().equals("Yes")||sObject.getHireLabor7().equals("Oui") ) {
                            fragment7.mainint("replant", "", "labor", plot7Area, avgCost, age7, estPrd7,farmerCost,"");
                            fragment7.other("labor");
                        } else if (sObject.getHireLabor7().equals("Seasonal")||sObject.getHireLabor7().equals("Saisonnier") ) {
                            fragment7.mainint("replant", "", "season", plot7Area, avgCost, age7, estPrd7,farmerCost,"");
                            fragment7.other("labor");
                        } else {
                            fragment7.mainint("replant", "", "", plot7Area, avgCost, age7, estPrd7,farmerCost,"");
                        }
                    }else{
                        if (sObject.getHireLabor7().equals("Yes")||sObject.getHireLabor7().equals("Oui") ) {
                            fragment7.mainint("graft", "", "labor", plot7Area, avgCost, age7, estPrd7,farmerCost,"");
                            fragment7.other("labor");
                        } else if (sObject.getHireLabor7().equals("Seasonal")||sObject.getHireLabor7().equals("Saisonnier") ) {
                            fragment7.mainint("graft", "", "season", plot7Area, avgCost, age7, estPrd7,farmerCost,"");
                            fragment7.other("labor");
                        } else {
                            fragment7.mainint("graft", "", "", plot7Area, avgCost, age7, estPrd7,farmerCost,"");
                        }
                    }
                }else {
                    //main intervention
                    if (sObject.getRECO7().equals("replanting")) {
                        //Replant
                        if (Double.parseDouble(sObject.getPlot7Age())<30 && sObject.getTreeHealth7().equals("G")&&sObject.getDebilitatingDisease7().equals("G")){

                            if (sObject.getPlot7CocoaTrees().contentEquals("2x2")||sObject.getPlot7CocoaTrees().contentEquals("2x2.5")||sObject.getPlot7CocoaTrees().contentEquals("2x3")||sObject.getPlot7CocoaTrees().contentEquals("2.5x2.5")||sObject.getPlot7CocoaTrees().contentEquals("2x3.5")) {
                                if (sObject.getHireLabor7().equals("Yes")||sObject.getHireLabor7().equals("Oui") ) {
                                    fragment7.mainint("replant", "", "labor", plot7Area, avgCost, age7, estPrd7,farmerCost, "t");
                                    fragment7.other("labor");
                                } else if (sObject.getHireLabor7().equals("Seasonal")||sObject.getHireLabor7().equals("Saisonnier") ) {
                                    fragment7.mainint("replant", "", "season", plot7Area, avgCost, age7, estPrd7,farmerCost, "t");
                                    fragment7.other("labor");
                                } else {
                                    fragment7.mainint("replant", "", "", plot7Area, avgCost, age7, estPrd7,farmerCost, "t");
                                }
                            }else if(sObject.getPlot7CocoaTrees().contentEquals("3.5x4")||sObject.getPlot7CocoaTrees().contentEquals("4x4")){
                                if (sObject.getHireLabor7().equals("Yes")||sObject.getHireLabor7().equals("Oui") ) {
                                    fragment7.mainint("replant", "", "labor", plot7Area, avgCost, age7, estPrd7,farmerCost, "f");
                                    fragment7.other("labor");
                                } else if (sObject.getHireLabor7().equals("Seasonal")||sObject.getHireLabor7().equals("Saisonnier") ) {
                                    fragment7.mainint("replant", "", "season", plot7Area, avgCost, age7, estPrd7,farmerCost, "f");
                                    fragment7.other("labor");
                                } else {
                                    fragment7.mainint("replant", "", "", plot7Area, avgCost, age7, estPrd7,farmerCost, "f");
                                }
                            }else{
                                if (sObject.getHireLabor7().equals("Yes")||sObject.getHireLabor7().equals("Oui") ) {
                                    fragment7.mainint("replant", "", "labor", plot7Area, avgCost, age7, estPrd7,farmerCost,"");
                                    fragment7.other("labor");
                                } else if (sObject.getHireLabor7().equals("Seasonal")||sObject.getHireLabor7().equals("Saisonnier") ) {
                                    fragment7.mainint("replant", "", "season", plot7Area, avgCost, age7, estPrd7,farmerCost,"");
                                    fragment7.other("labor");
                                } else {
                                    fragment7.mainint("replant", "", "", plot7Area, avgCost, age7, estPrd7,farmerCost,"");
                                }
                            }

                        }else{
                            if (sObject.getHireLabor7().equals("Yes")||sObject.getHireLabor7().equals("Oui") ) {
                                fragment7.mainint("replant", "", "labor", plot7Area, avgCost, age7, estPrd7,farmerCost,"");
                                fragment7.other("labor");
                            } else if (sObject.getHireLabor7().equals("Seasonal")||sObject.getHireLabor7().equals("Saisonnier") ) {
                                fragment7.mainint("replant", "", "season", plot7Area, avgCost, age7, estPrd7,farmerCost,"");
                                fragment7.other("labor");
                            } else {
                                fragment7.mainint("replant", "", "", plot7Area, avgCost, age7, estPrd7,farmerCost,"");
                            }
                        }

                    }else if(sObject.getRECO7().equals("replanting+extra")) {

                        if (Double.parseDouble(sObject.getPlot7Age())<30 && sObject.getTreeHealth7().equals("G")&&sObject.getDebilitatingDisease7().equals("G")){
                            if (sObject.getPlot7CocoaTrees().contentEquals("2x2")||sObject.getPlot7CocoaTrees().contentEquals("2x2.5")||sObject.getPlot7CocoaTrees().contentEquals("2x3")||sObject.getPlot7CocoaTrees().contentEquals("2.5x2.5")||sObject.getPlot7CocoaTrees().contentEquals("2x3.5")) {
                                if (sObject.getHireLabor7().equals("Yes")||sObject.getHireLabor7().equals("Oui") ) {
                                    fragment7.mainint("replant", "extra", "labor", plot7Area, avgCost, age7, estPrd7,farmerCost, "t");
                                    fragment7.other("labor");
                                } else if (sObject.getHireLabor7().equals("Seasonal")||sObject.getHireLabor7().equals("Saisonnier") ) {
                                    fragment7.mainint("replant", "extra", "season", plot7Area, avgCost, age7, estPrd7,farmerCost, "t");
                                    fragment7.other("labor");
                                } else {
                                    fragment7.mainint("replant", "extra", "", plot7Area, avgCost, age7, estPrd7,farmerCost, "t");
                                }
                            }else if(sObject.getPlot7CocoaTrees().contentEquals("3.5x4")||sObject.getPlot7CocoaTrees().contentEquals("4x4")){
                                if (sObject.getHireLabor7().equals("Yes")||sObject.getHireLabor7().equals("Oui") ) {
                                    fragment7.mainint("replant", "extra", "labor", plot7Area, avgCost, age7, estPrd7,farmerCost, "f");
                                    fragment7.other("labor");
                                } else if (sObject.getHireLabor7().equals("Seasonal")||sObject.getHireLabor7().equals("Saisonnier") ) {
                                    fragment7.mainint("replant", "extra", "season", plot7Area, avgCost, age7, estPrd7,farmerCost, "f");
                                    fragment7.other("labor");
                                } else {
                                    fragment7.mainint("replant", "extra", "", plot7Area, avgCost, age7, estPrd7,farmerCost, "f");
                                }
                            }else{
                                if (sObject.getHireLabor7().equals("Yes")||sObject.getHireLabor7().equals("Oui") ) {
                                    fragment7.mainint("replant", "extra", "labor", plot7Area, avgCost, age7, estPrd7,farmerCost,"");
                                    fragment7.other("labor");
                                } else if (sObject.getHireLabor7().equals("Seasonal")||sObject.getHireLabor7().equals("Saisonnier") ) {
                                    fragment7.mainint("replant", "extra", "season", plot7Area, avgCost, age7, estPrd7,farmerCost,"");
                                    fragment7.other("labor");
                                } else {
                                    fragment7.mainint("replant", "extra", "", plot7Area, avgCost, age7, estPrd7,farmerCost,"");
                                }
                            }
                        }else{
                            if (sObject.getHireLabor7().equals("Yes")||sObject.getHireLabor7().equals("Oui") ) {
                                fragment7.mainint("replant", "extra", "labor", plot7Area, avgCost, age7, estPrd7,farmerCost,"");
                                fragment7.other("labor");
                            } else if (sObject.getHireLabor7().equals("Seasonal")||sObject.getHireLabor7().equals("Saisonnier") ) {
                                fragment7.mainint("replant", "extra", "season", plot7Area, avgCost, age7, estPrd7,farmerCost,"");
                                fragment7.other("labor");
                            } else {
                                fragment7.mainint("replant", "extra", "", plot7Area, avgCost, age7, estPrd7,farmerCost,"");
                            }
                        }

                    } else if (sObject.getRECO7().equals("grafting+extra")) {
                        //Graft
                        if (sObject.getHireLabor7().equals("Yes")||sObject.getHireLabor7().equals("Oui") ) {
                            fragment7.mainint("graft", "extra", "labor", plot7Area, avgCost, age7, estPrd7,farmerCost,"");
                            fragment7.other("labor");
                        } else if (sObject.getHireLabor7().equals("Seasonal")||sObject.getHireLabor7().equals("Saisonnier") ) {
                            fragment7.mainint("graft", "extra", "season", plot7Area, avgCost, age7, estPrd7,farmerCost,"");
                            fragment7.other("labor");
                        } else {
                            fragment7.mainint("graft", "extra", "", plot7Area, avgCost, age7, estPrd7,farmerCost,"");
                        }
                    } else if (sObject.getRECO7().equals("grafting")){
                        if (sObject.getHireLabor7().equals("Yes")||sObject.getHireLabor7().equals("Oui") ) {
                            fragment7.mainint("graft", "", "labor", plot7Area, avgCost, age7, estPrd7,farmerCost,"");
                            fragment7.other("labor");
                        } else if (sObject.getHireLabor7().equals("Seasonal")||sObject.getHireLabor7().equals("Saisonnier") ) {
                            fragment7.mainint("graft", "", "season", plot7Area, avgCost, age7, estPrd7,farmerCost,"");
                            fragment7.other("labor");
                        } else {
                            fragment7.mainint("graft", "", "", plot7Area, avgCost, age7, estPrd7,farmerCost,"");
                        }

                    } else if (sObject.getRECO7().equals("extra")) {
                        //Extra Soil Management
                        if (sObject.getHireLabor7().equals("Yes")||sObject.getHireLabor7().equals("Oui") ) {
                            fragment7.mainint("extra", "", "labor", plot7Area, avgCost, age7, estPrd7,farmerCost,"");
                            fragment7.other("labor");
                        } else if (sObject.getHireLabor7().equals("Seasonal")||sObject.getHireLabor7().equals("Saisonnier") ) {
                            fragment7.mainint("extra", "", "season", plot7Area, avgCost, age7, estPrd7,farmerCost,"");
                            fragment7.other("labor");
                        } else {
                            fragment7.mainint("extra", "", "", plot7Area, avgCost, age7, estPrd7,farmerCost,"");
                        }

                    }else if (sObject.getRECO7().equals("thinning+extra")) {
                        //Thinning
                        if (sObject.getHireLabor7().equals("Yes")||sObject.getHireLabor7().equals("Oui") ) {
                            fragment7.mainint("thinning", "extra", "labor", plot7Area, avgCost, age7, estPrd7,farmerCost,"");
                            fragment7.other("labor");
                        } else if (sObject.getHireLabor7().equals("Seasonal")||sObject.getHireLabor7().equals("Saisonnier") ) {
                            fragment7.mainint("thinning", "extra", "season", plot7Area, avgCost, age7, estPrd7,farmerCost,"");
                            fragment7.other("labor");
                        } else {
                            fragment7.mainint("thinning", "extra", "", plot7Area, avgCost, age7, estPrd7,farmerCost,"");
                        }

                    }else if (sObject.getRECO7().equals("thinning")) {
                        //Thinning
                        if (sObject.getHireLabor7().equals("Yes")||sObject.getHireLabor7().equals("Oui") ) {
                            fragment7.mainint("thinning", "", "labor", plot7Area, avgCost, age7, estPrd7,farmerCost,"");
                            fragment7.other("labor");
                        } else if (sObject.getHireLabor7().equals("Seasonal")||sObject.getHireLabor7().equals("Saisonnier") ) {
                            fragment7.mainint("thinning", "", "season", plot7Area, avgCost, age7, estPrd7,farmerCost,"");
                            fragment7.other("labor");
                        } else {
                            fragment7.mainint("thinning", "", "", plot7Area, avgCost, age7, estPrd7,farmerCost,"");
                        }

                    }else if (sObject.getRECO7().equals("filling+extra")) {
                        //filling
                        if (sObject.getHireLabor7().equals("Yes")||sObject.getHireLabor7().equals("Oui") ) {
                            fragment7.mainint("filling", "extra", "labor", plot7Area, avgCost, age7, estPrd7,farmerCost,"");
                            fragment7.other("labor");
                        } else if (sObject.getHireLabor7().equals("Seasonal")||sObject.getHireLabor7().equals("Saisonnier") ) {
                            fragment7.mainint("filling", "extra", "season", plot7Area, avgCost, age7, estPrd7,farmerCost,"");
                            fragment7.other("labor");
                        } else {
                            fragment7.mainint("filling", "extra", "", plot7Area, avgCost, age7, estPrd7,farmerCost,"");
                        }

                    }else if (sObject.getRECO7().equals("filling")) {
                        //filling
                        if (sObject.getHireLabor7().equals("Yes")||sObject.getHireLabor7().equals("Oui") ) {
                            fragment7.mainint("filling", "", "labor", plot7Area, avgCost, age7, estPrd7,farmerCost,"");
                            fragment7.other("labor");
                        } else if (sObject.getHireLabor7().equals("Seasonal")||sObject.getHireLabor7().equals("Saisonnier") ) {
                            fragment7.mainint("filling", "", "season", plot7Area, avgCost, age7, estPrd7,farmerCost,"");
                            fragment7.other("labor");
                        } else {
                            fragment7.mainint("filling", "", "", plot7Area, avgCost, age7, estPrd7,farmerCost,"");
                        }

                    } else {
                        //GAP
                        if (sObject.getHireLabor7().equals("Yes")||sObject.getHireLabor7().equals("Oui") ) {
                            fragment7.mainint("gap", "", "labor", plot7Area, avgCost, age7, estPrd7,farmerCost,"");
                            fragment7.other("labor");
                        } else if (sObject.getHireLabor7().equals("Seasonal")||sObject.getHireLabor7().equals("Saisonnier") ) {
                            fragment7.mainint("gap", "", "season", plot7Area, avgCost, age7, estPrd7,farmerCost,"");
                            fragment7.other("labor");
                        } else {
                            fragment7.mainint("gap", "", "", plot7Area, avgCost, age7, estPrd7,farmerCost,"");
                        }
                    }
                }

                //other interventions
                if (sObject.getLimeNeed7().equals("Yes")||sObject.getLimeNeed7().equals("Oui")) {
                    fragment7.other("lime");
                }

                if (sObject.getFillingOption7().equals("Yes")||sObject.getFillingOption7().equals("Oui")) {
                    if (sObject.getPlot7CocoaTrees().contentEquals("2x2")||sObject.getPlot7CocoaTrees().contentEquals("2x2.5")||sObject.getPlot7CocoaTrees().contentEquals("2x3")||sObject.getPlot7CocoaTrees().contentEquals("2.5x2.5")||sObject.getPlot7CocoaTrees().contentEquals("2x3.5")) {
                        fragment7.other("thinning");
                    }else{
                        fragment7.other("filling");
                    }
                }

                if (sObject.getDrainageNeed7().equals("Yes")||sObject.getDrainageNeed7().equals("Oui")) {
                    fragment7.other("drainage");
                }
                ft.show(fragment7);
            }else{ft.hide(fragment7);}

            //plot8
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 7) {
                setText(plot8,getString(R.string.pt8));
                fragment8.setStartYear(startY8);
                if(sObject.getPLOT8RENOVATION().equals("Yes")||sObject.getPLOT8RENOVATION().equals("Oui")){
                    if(sObject.getPLOT8RENOVATIONREASON().equals("Replanting")||sObject.getPLOT8RENOVATIONREASON().equals("Replantation")){
                        if (sObject.getHireLabor8().equals("Yes")||sObject.getHireLabor8().equals("Oui") ) {
                            fragment8.mainint("replant", "", "labor", plot8Area, avgCost, age8, estPrd8,farmerCost,"");
                            fragment8.other("labor");
                        } else if (sObject.getHireLabor8().equals("Seasonal")||sObject.getHireLabor8().equals("Saisonnier") ) {
                            fragment8.mainint("replant", "", "season", plot8Area, avgCost, age8, estPrd8,farmerCost,"");
                            fragment8.other("labor");
                        } else {
                            fragment8.mainint("replant", "", "", plot8Area, avgCost, age8, estPrd8,farmerCost,"");
                        }
                    }else{
                        if (sObject.getHireLabor8().equals("Yes")||sObject.getHireLabor8().equals("Oui") ) {
                            fragment8.mainint("graft", "", "labor", plot8Area, avgCost, age8, estPrd8,farmerCost,"");
                            fragment8.other("labor");
                        } else if (sObject.getHireLabor8().equals("Seasonal")||sObject.getHireLabor8().equals("Saisonnier") ) {
                            fragment8.mainint("graft", "", "season", plot8Area, avgCost, age8, estPrd8,farmerCost,"");
                            fragment8.other("labor");
                        } else {
                            fragment8.mainint("graft", "", "", plot8Area, avgCost, age8, estPrd8,farmerCost,"");
                        }
                    }
                }else {
                    //main intervention
                    if (sObject.getRECO8().equals("replanting")) {
                        //Replant
                        if (Double.parseDouble(sObject.getPlot8Age())<30 && sObject.getTreeHealth8().equals("G")&&sObject.getDebilitatingDisease8().equals("G")){
                            if (sObject.getPlot8CocoaTrees().contentEquals("2x2")||sObject.getPlot8CocoaTrees().contentEquals("2x2.5")||sObject.getPlot8CocoaTrees().contentEquals("2x3")||sObject.getPlot8CocoaTrees().contentEquals("2.5x2.5")||sObject.getPlot8CocoaTrees().contentEquals("2x3.5")) {
                                if (sObject.getHireLabor8().equals("Yes")||sObject.getHireLabor8().equals("Oui") ) {
                                    fragment8.mainint("replant", "", "labor", plot8Area, avgCost, age8, estPrd8,farmerCost, "t");
                                    fragment8.other("labor");
                                } else if (sObject.getHireLabor8().equals("Seasonal")||sObject.getHireLabor8().equals("Saisonnier") ) {
                                    fragment8.mainint("replant", "", "season", plot8Area, avgCost, age8, estPrd8,farmerCost, "t");
                                    fragment8.other("labor");
                                } else {
                                    fragment8.mainint("replant", "", "", plot8Area, avgCost, age8, estPrd8,farmerCost, "t");
                                }
                            }else if(sObject.getPlot8CocoaTrees().contentEquals("3.5x4")||sObject.getPlot8CocoaTrees().contentEquals("4x4")){
                                if (sObject.getHireLabor8().equals("Yes")||sObject.getHireLabor8().equals("Oui") ) {
                                    fragment8.mainint("replant", "", "labor", plot8Area, avgCost, age8, estPrd8,farmerCost, "f");
                                    fragment8.other("labor");
                                } else if (sObject.getHireLabor8().equals("Seasonal")||sObject.getHireLabor8().equals("Saisonnier") ) {
                                    fragment8.mainint("replant", "", "season", plot8Area, avgCost, age8, estPrd8,farmerCost, "f");
                                    fragment8.other("labor");
                                } else {
                                    fragment8.mainint("replant", "", "", plot8Area, avgCost, age8, estPrd8,farmerCost, "f");
                                }
                            }else{
                                if (sObject.getHireLabor8().equals("Yes")||sObject.getHireLabor8().equals("Oui") ) {
                                    fragment8.mainint("replant", "", "labor", plot8Area, avgCost, age8, estPrd8,farmerCost,"");
                                    fragment8.other("labor");
                                } else if (sObject.getHireLabor8().equals("Seasonal")||sObject.getHireLabor8().equals("Saisonnier") ) {
                                    fragment8.mainint("replant", "", "season", plot8Area, avgCost, age8, estPrd8,farmerCost,"");
                                    fragment8.other("labor");
                                } else {
                                    fragment8.mainint("replant", "", "", plot8Area, avgCost, age8, estPrd8,farmerCost,"");
                                }
                            }

                        }else{
                            if (sObject.getHireLabor8().equals("Yes")||sObject.getHireLabor8().equals("Oui") ) {
                                fragment8.mainint("replant", "", "labor", plot8Area, avgCost, age8, estPrd8,farmerCost,"");
                                fragment8.other("labor");
                            } else if (sObject.getHireLabor8().equals("Seasonal")||sObject.getHireLabor8().equals("Saisonnier") ) {
                                fragment8.mainint("replant", "", "season", plot8Area, avgCost, age8, estPrd8,farmerCost,"");
                                fragment8.other("labor");
                            } else {
                                fragment8.mainint("replant", "", "", plot8Area, avgCost, age8, estPrd8,farmerCost,"");
                            }
                        }

                    }else if (sObject.getRECO8().equals("replanting+extra")) {
                        if (Double.parseDouble(sObject.getPlot8Age())<30 && sObject.getTreeHealth8().equals("G")&&sObject.getDebilitatingDisease8().equals("G")){
                            if (sObject.getPlot8CocoaTrees().contentEquals("2x2")||sObject.getPlot8CocoaTrees().contentEquals("2x2.5")||sObject.getPlot8CocoaTrees().contentEquals("2x3")||sObject.getPlot8CocoaTrees().contentEquals("2.5x2.5")||sObject.getPlot8CocoaTrees().contentEquals("2x3.5")) {
                                if (sObject.getHireLabor8().equals("Yes")||sObject.getHireLabor8().equals("Oui") ) {
                                    fragment8.mainint("replant", "extra", "labor", plot8Area, avgCost, age8, estPrd8,farmerCost, "t");
                                    fragment8.other("labor");
                                } else if (sObject.getHireLabor8().equals("Seasonal")||sObject.getHireLabor8().equals("Saisonnier") ) {
                                    fragment8.mainint("replant", "extra", "season", plot8Area, avgCost, age8, estPrd8,farmerCost, "t");
                                    fragment8.other("labor");
                                } else {
                                    fragment8.mainint("replant", "extra", "", plot8Area, avgCost, age8, estPrd8,farmerCost, "t");
                                }
                            }else if(sObject.getPlot8CocoaTrees().contentEquals("3.5x4")||sObject.getPlot8CocoaTrees().contentEquals("4x4")){
                                if (sObject.getHireLabor8().equals("Yes")||sObject.getHireLabor8().equals("Oui") ) {
                                    fragment8.mainint("replant", "extra", "labor", plot8Area, avgCost, age8, estPrd8,farmerCost, "f");
                                    fragment8.other("labor");
                                } else if (sObject.getHireLabor8().equals("Seasonal")||sObject.getHireLabor8().equals("Saisonnier") ) {
                                    fragment8.mainint("replant", "extra", "season", plot8Area, avgCost, age8, estPrd8,farmerCost, "f");
                                    fragment8.other("labor");
                                } else {
                                    fragment8.mainint("replant", "extra", "", plot8Area, avgCost, age8, estPrd8,farmerCost, "f");
                                }
                            }else{
                                if (sObject.getHireLabor8().equals("Yes")||sObject.getHireLabor8().equals("Oui") ) {
                                    fragment8.mainint("replant", "extra", "labor", plot8Area, avgCost, age8, estPrd8,farmerCost,"");
                                    fragment8.other("labor");
                                } else if (sObject.getHireLabor8().equals("Seasonal")||sObject.getHireLabor8().equals("Saisonnier") ) {
                                    fragment8.mainint("replant", "extra", "season", plot8Area, avgCost, age8, estPrd8,farmerCost,"");
                                    fragment8.other("labor");
                                } else {
                                    fragment8.mainint("replant", "extra", "", plot8Area, avgCost, age8, estPrd8,farmerCost,"");
                                }
                            }

                        }else{
                            if (sObject.getHireLabor8().equals("Yes")||sObject.getHireLabor8().equals("Oui") ) {
                                fragment8.mainint("replant", "extra", "labor", plot8Area, avgCost, age8, estPrd8,farmerCost,"");
                                fragment8.other("labor");
                            } else if (sObject.getHireLabor8().equals("Seasonal")||sObject.getHireLabor8().equals("Saisonnier") ) {
                                fragment8.mainint("replant", "extra", "season", plot8Area, avgCost, age8, estPrd8,farmerCost,"");
                                fragment8.other("labor");
                            } else {
                                fragment8.mainint("replant", "extra", "", plot8Area, avgCost, age8, estPrd8,farmerCost,"");
                            }
                        }

                    } else if (sObject.getRECO8().equals("grafting+extra")) {
                        //Graft
                        if (sObject.getHireLabor8().equals("Yes")||sObject.getHireLabor8().equals("Oui") ) {
                            fragment8.mainint("graft", "extra", "labor", plot8Area, avgCost, age8, estPrd8,farmerCost,"");
                            fragment8.other("labor");
                        } else if (sObject.getHireLabor8().equals("Seasonal")||sObject.getHireLabor8().equals("Saisonnier") ) {
                            fragment8.mainint("graft", "extra", "season", plot8Area, avgCost, age8, estPrd8,farmerCost,"");
                            fragment8.other("labor");
                        } else {
                            fragment8.mainint("graft", "extra", "", plot8Area, avgCost, age8, estPrd8,farmerCost,"");
                        }
                    } else if(sObject.getRECO8().equals("grafting")){
                        if (sObject.getHireLabor8().equals("Yes")||sObject.getHireLabor8().equals("Oui") ) {
                            fragment8.mainint("graft", "", "labor", plot8Area, avgCost, age8, estPrd8,farmerCost,"");
                            fragment8.other("labor");
                        } else if (sObject.getHireLabor8().equals("Seasonal")||sObject.getHireLabor8().equals("Saisonnier") ) {
                            fragment8.mainint("graft", "", "season", plot8Area, avgCost, age8, estPrd8,farmerCost,"");
                            fragment8.other("labor");
                        } else {
                            fragment8.mainint("graft", "", "", plot8Area, avgCost, age8, estPrd8,farmerCost,"");
                        }

                    } else if (sObject.getRECO8().equals("extra")) {
                        //Extra Soil Management
                        if (sObject.getHireLabor8().equals("Yes")||sObject.getHireLabor8().equals("Oui") ) {
                            fragment8.mainint("extra", "", "labor", plot8Area, avgCost, age8, estPrd8,farmerCost,"");
                            fragment8.other("labor");
                        } else if (sObject.getHireLabor8().equals("Seasonal")||sObject.getHireLabor8().equals("Saisonnier") ) {
                            fragment8.mainint("extra", "", "season", plot8Area, avgCost, age8, estPrd8,farmerCost,"");
                            fragment8.other("labor");
                        } else {
                            fragment8.mainint("extra", "", "", plot8Area, avgCost, age8, estPrd8,farmerCost,"");
                        }

                    }else if (sObject.getRECO8().equals("thinning+extra")) {
                        //Thinning
                        if (sObject.getHireLabor8().equals("Yes")||sObject.getHireLabor8().equals("Oui") ) {
                            fragment8.mainint("thinning", "extra", "labor", plot8Area, avgCost, age8, estPrd8,farmerCost,"");
                            fragment8.other("labor");
                        } else if (sObject.getHireLabor8().equals("Seasonal")||sObject.getHireLabor8().equals("Saisonnier") ) {
                            fragment8.mainint("thinning", "extra", "season", plot8Area, avgCost, age8, estPrd8,farmerCost,"");
                            fragment8.other("labor");
                        } else {
                            fragment8.mainint("thinning", "extra", "", plot8Area, avgCost, age8, estPrd8,farmerCost,"");
                        }

                    }else if (sObject.getRECO8().equals("thinning")) {
                        //Thinning
                        if (sObject.getHireLabor8().equals("Yes")||sObject.getHireLabor8().equals("Oui") ) {
                            fragment8.mainint("thinning", "", "labor", plot8Area, avgCost, age8, estPrd8,farmerCost,"");
                            fragment8.other("labor");
                        } else if (sObject.getHireLabor8().equals("Seasonal")||sObject.getHireLabor8().equals("Saisonnier") ) {
                            fragment8.mainint("thinning", "", "season", plot8Area, avgCost, age8, estPrd8,farmerCost,"");
                            fragment8.other("labor");
                        } else {
                            fragment8.mainint("thinning", "", "", plot8Area, avgCost, age8, estPrd8,farmerCost,"");
                        }

                    }else if (sObject.getRECO8().equals("filling+extra")) {
                        //filling
                        if (sObject.getHireLabor8().equals("Yes")||sObject.getHireLabor8().equals("Oui") ) {
                            fragment8.mainint("filling", "extra", "labor", plot8Area, avgCost, age8, estPrd8,farmerCost,"");
                            fragment8.other("labor");
                        } else if (sObject.getHireLabor8().equals("Seasonal")||sObject.getHireLabor8().equals("Saisonnier") ) {
                            fragment8.mainint("filling", "extra", "season", plot8Area, avgCost, age8, estPrd8,farmerCost,"");
                            fragment8.other("labor");
                        } else {
                            fragment8.mainint("filling", "extra", "", plot8Area, avgCost, age8, estPrd8,farmerCost,"");
                        }

                    }else if (sObject.getRECO8().equals("filling")) {
                        //filling
                        if (sObject.getHireLabor8().equals("Yes")||sObject.getHireLabor8().equals("Oui") ) {
                            fragment8.mainint("filling", "", "labor", plot8Area, avgCost, age8, estPrd8,farmerCost,"");
                            fragment8.other("labor");
                        } else if (sObject.getHireLabor8().equals("Seasonal")||sObject.getHireLabor8().equals("Saisonnier") ) {
                            fragment8.mainint("filling", "", "season", plot8Area, avgCost, age8, estPrd8,farmerCost,"");
                            fragment8.other("labor");
                        } else {
                            fragment8.mainint("filling", "", "", plot8Area, avgCost, age8, estPrd8,farmerCost,"");
                        }

                    } else {
                        //GAP
                        if (sObject.getHireLabor8().equals("Yes")||sObject.getHireLabor8().equals("Oui") ) {
                            fragment8.mainint("gap", "", "labor", plot8Area, avgCost, age8, estPrd8,farmerCost,"");
                            fragment8.other("labor");
                        } else if (sObject.getHireLabor8().equals("Seasonal")||sObject.getHireLabor8().equals("Saisonnier") ) {
                            fragment8.mainint("gap", "", "season", plot8Area, avgCost, age8, estPrd8,farmerCost,"");
                            fragment8.other("labor");
                        } else {
                            fragment8.mainint("gap", "", "", plot8Area, avgCost, age8, estPrd8,farmerCost,"");
                        }
                    }
                }

                //other interventions
                if (sObject.getLimeNeed8().equals("Yes")||sObject.getLimeNeed8().equals("Oui")) {
                    fragment8.other("lime");
                }

                if (sObject.getFillingOption8().equals("Yes")||sObject.getFillingOption8().equals("Oui")) {
                    if (sObject.getPlot8CocoaTrees().contentEquals("2x2")||sObject.getPlot8CocoaTrees().contentEquals("2x2.5")||sObject.getPlot8CocoaTrees().contentEquals("2x3")||sObject.getPlot8CocoaTrees().contentEquals("2.5x2.5")||sObject.getPlot8CocoaTrees().contentEquals("2x3.5")) {
                        fragment8.other("thinning");
                    }else{
                        fragment8.other("filling");
                    }
                }

                if (sObject.getDrainageNeed8().equals("Yes")||sObject.getDrainageNeed8().equals("Oui")) {
                    fragment8.other("drainage");
                }
                ft.show(fragment8);
            }else{ft.hide(fragment8);}

            //plot9
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 8) {
                setText(plot9,getString(R.string.pt9));
                fragment9.getView().setBackgroundColor(Color.parseColor("#e5e5e5"));
                fragment9.setStartYear(startY9);
                if(sObject.getPLOT9RENOVATION().equals("Yes")||sObject.getPLOT9RENOVATION().equals("Oui")){
                    if(sObject.getPLOT9RENOVATIONREASON().equals("Replanting")||sObject.getPLOT9RENOVATIONREASON().equals("Replantation")){
                        if (sObject.getHireLabor9().equals("Yes")||sObject.getHireLabor9().equals("Oui") ) {
                            fragment9.mainint("replant", "", "labor", plot9Area, avgCost, age9, estPrd9,farmerCost,"");
                            fragment9.other("labor");
                        } else if (sObject.getHireLabor9().equals("Seasonal")||sObject.getHireLabor9().equals("Saisonnier") ) {
                            fragment9.mainint("replant", "", "season", plot9Area, avgCost, age9, estPrd9,farmerCost,"");
                            fragment9.other("labor");
                        } else {
                            fragment9.mainint("replant", "", "", plot9Area, avgCost, age9, estPrd9,farmerCost,"");
                        }
                    }else{
                        if (sObject.getHireLabor9().equals("Yes")||sObject.getHireLabor9().equals("Oui") ) {
                            fragment9.mainint("graft", "", "labor", plot9Area, avgCost, age9, estPrd9,farmerCost,"");
                            fragment9.other("labor");
                        } else if (sObject.getHireLabor9().equals("Seasonal")||sObject.getHireLabor9().equals("Saisonnier") ) {
                            fragment9.mainint("graft", "", "season", plot9Area, avgCost, age9, estPrd9,farmerCost,"");
                            fragment9.other("labor");
                        } else {
                            fragment9.mainint("graft", "", "", plot9Area, avgCost, age9, estPrd9,farmerCost,"");
                        }
                    }
                }else {
                    //main intervention
                    if (sObject.getRECO9().equals("replanting")) {
                        //Replant
                        if (Double.parseDouble(sObject.getPlot9Age())<30 && sObject.getTreeHealth9().equals("G")&&sObject.getDebilitatingDisease9().equals("G")){

                            if (sObject.getPlot9CocoaTrees().contentEquals("2x2")||sObject.getPlot9CocoaTrees().contentEquals("2x2.5")||sObject.getPlot9CocoaTrees().contentEquals("2x3")||sObject.getPlot9CocoaTrees().contentEquals("2.5x2.5")||sObject.getPlot9CocoaTrees().contentEquals("2x3.5")) {
                                if (sObject.getHireLabor9().equals("Yes")||sObject.getHireLabor9().equals("Oui") ) {
                                    fragment9.mainint("replant", "", "labor", plot9Area, avgCost, age9, estPrd9,farmerCost, "t");
                                    fragment9.other("labor");
                                } else if (sObject.getHireLabor9().equals("Seasonal")||sObject.getHireLabor9().equals("Saisonnier") ) {
                                    fragment9.mainint("replant", "", "season", plot9Area, avgCost, age9, estPrd9,farmerCost, "t");
                                    fragment9.other("labor");
                                } else {
                                    fragment9.mainint("replant", "", "", plot9Area, avgCost, age9, estPrd9,farmerCost, "t");
                                }
                            }else if(sObject.getPlot9CocoaTrees().contentEquals("3.5x4")||sObject.getPlot9CocoaTrees().contentEquals("4x4")){
                                if (sObject.getHireLabor9().equals("Yes")||sObject.getHireLabor9().equals("Oui") ) {
                                    fragment9.mainint("replant", "", "labor", plot9Area, avgCost, age9, estPrd9,farmerCost, "f");
                                    fragment9.other("labor");
                                } else if (sObject.getHireLabor9().equals("Seasonal")||sObject.getHireLabor9().equals("Saisonnier") ) {
                                    fragment9.mainint("replant", "", "season", plot9Area, avgCost, age9, estPrd9,farmerCost, "f");
                                    fragment9.other("labor");
                                } else {
                                    fragment9.mainint("replant", "", "", plot9Area, avgCost, age9, estPrd9,farmerCost, "f");
                                }
                            }else{
                                if (sObject.getHireLabor9().equals("Yes")||sObject.getHireLabor9().equals("Oui") ) {
                                    fragment9.mainint("replant", "", "labor", plot9Area, avgCost, age9, estPrd9,farmerCost,"");
                                    fragment9.other("labor");
                                } else if (sObject.getHireLabor9().equals("Seasonal")||sObject.getHireLabor9().equals("Saisonnier") ) {
                                    fragment9.mainint("replant", "", "season", plot9Area, avgCost, age9, estPrd9,farmerCost,"");
                                    fragment9.other("labor");
                                } else {
                                    fragment9.mainint("replant", "", "", plot9Area, avgCost, age9, estPrd9,farmerCost,"");
                                }
                            }

                        }else{
                            if (sObject.getHireLabor9().equals("Yes")||sObject.getHireLabor9().equals("Oui") ) {
                                fragment9.mainint("replant", "", "labor", plot9Area, avgCost, age9, estPrd9,farmerCost,"");
                                fragment9.other("labor");
                            } else if (sObject.getHireLabor9().equals("Seasonal")||sObject.getHireLabor9().equals("Saisonnier") ) {
                                fragment9.mainint("replant", "", "season", plot9Area, avgCost, age9, estPrd9,farmerCost,"");
                                fragment9.other("labor");
                            } else {
                                fragment9.mainint("replant", "", "", plot9Area, avgCost, age9, estPrd9,farmerCost,"");
                            }
                        }

                    }else if(sObject.getRECO9().equals("replanting+extra")) {
                        if (Double.parseDouble(sObject.getPlot9Age())<30 && sObject.getTreeHealth9().equals("G")&&sObject.getDebilitatingDisease9().equals("G")){
                            if (sObject.getPlot9CocoaTrees().contentEquals("2x2")||sObject.getPlot9CocoaTrees().contentEquals("2x2.5")||sObject.getPlot9CocoaTrees().contentEquals("2x3")||sObject.getPlot9CocoaTrees().contentEquals("2.5x2.5")||sObject.getPlot9CocoaTrees().contentEquals("2x3.5")) {
                                if (sObject.getHireLabor9().equals("Yes")||sObject.getHireLabor9().equals("Oui") ) {
                                    fragment9.mainint("replant", "extra", "labor", plot9Area, avgCost, age9, estPrd9,farmerCost, "t");
                                    fragment9.other("labor");
                                } else if (sObject.getHireLabor9().equals("Seasonal")||sObject.getHireLabor9().equals("Saisonnier") ) {
                                    fragment9.mainint("replant", "extra", "season", plot9Area, avgCost, age9, estPrd9,farmerCost, "t");
                                    fragment9.other("labor");
                                } else {
                                    fragment9.mainint("replant", "extra", "", plot9Area, avgCost, age9, estPrd9,farmerCost, "t");
                                }
                            }else if(sObject.getPlot9CocoaTrees().contentEquals("3.5x4")||sObject.getPlot9CocoaTrees().contentEquals("4x4")){
                                if (sObject.getHireLabor9().equals("Yes")||sObject.getHireLabor9().equals("Oui") ) {
                                    fragment9.mainint("replant", "extra", "labor", plot9Area, avgCost, age9, estPrd9,farmerCost, "f");
                                    fragment9.other("labor");
                                } else if (sObject.getHireLabor9().equals("Seasonal")||sObject.getHireLabor9().equals("Saisonnier") ) {
                                    fragment9.mainint("replant", "extra", "season", plot9Area, avgCost, age9, estPrd9,farmerCost, "f");
                                    fragment9.other("labor");
                                } else {
                                    fragment9.mainint("replant", "extra", "", plot9Area, avgCost, age9, estPrd9,farmerCost, "f");
                                }
                            }else{
                                if (sObject.getHireLabor9().equals("Yes")||sObject.getHireLabor9().equals("Oui") ) {
                                    fragment9.mainint("replant", "extra", "labor", plot9Area, avgCost, age9, estPrd9,farmerCost,"");
                                    fragment9.other("labor");
                                } else if (sObject.getHireLabor9().equals("Seasonal")||sObject.getHireLabor9().equals("Saisonnier") ) {
                                    fragment9.mainint("replant", "extra", "season", plot9Area, avgCost, age9, estPrd9,farmerCost,"");
                                    fragment9.other("labor");
                                } else {
                                    fragment9.mainint("replant", "extra", "", plot9Area, avgCost, age9, estPrd9,farmerCost,"");
                                }
                            }

                        }else{
                            if (sObject.getHireLabor9().equals("Yes")||sObject.getHireLabor9().equals("Oui") ) {
                                fragment9.mainint("replant", "extra", "labor", plot9Area, avgCost, age9, estPrd9,farmerCost,"");
                                fragment9.other("labor");
                            } else if (sObject.getHireLabor9().equals("Seasonal")||sObject.getHireLabor9().equals("Saisonnier") ) {
                                fragment9.mainint("replant", "extra", "season", plot9Area, avgCost, age9, estPrd9,farmerCost,"");
                                fragment9.other("labor");
                            } else {
                                fragment9.mainint("replant", "extra", "", plot9Area, avgCost, age9, estPrd9,farmerCost,"");
                            }
                        }

                    } else if (sObject.getRECO9().equals("grafting+extra")) {
                        //Graft
                        if (sObject.getHireLabor9().equals("Yes")||sObject.getHireLabor9().equals("Oui") ) {
                            fragment9.mainint("graft", "extra", "labor", plot9Area, avgCost, age9, estPrd9,farmerCost,"");
                            fragment9.other("labor");
                        } else if (sObject.getHireLabor9().equals("Seasonal")||sObject.getHireLabor9().equals("Saisonnier") ) {
                            fragment9.mainint("graft", "extra", "season", plot9Area, avgCost, age9, estPrd9,farmerCost,"");
                            fragment9.other("labor");
                        } else {
                            fragment9.mainint("graft", "extra", "", plot9Area, avgCost, age9, estPrd9,farmerCost,"");
                        }
                    } else if(sObject.getRECO9().equals("grafting")){
                        if (sObject.getHireLabor9().equals("Yes")||sObject.getHireLabor9().equals("Oui") ) {
                            fragment9.mainint("graft", "", "labor", plot9Area, avgCost, age9, estPrd9,farmerCost,"");
                            fragment9.other("labor");
                        } else if (sObject.getHireLabor9().equals("Seasonal")||sObject.getHireLabor9().equals("Saisonnier") ) {
                            fragment9.mainint("graft", "", "season", plot9Area, avgCost, age9, estPrd9,farmerCost,"");
                            fragment9.other("labor");
                        } else {
                            fragment9.mainint("graft", "", "", plot9Area, avgCost, age9, estPrd9,farmerCost,"");
                        }

                    } else if (sObject.getRECO9().equals("extra")) {
                        //Extra Soil Management
                        if (sObject.getHireLabor9().equals("Yes")||sObject.getHireLabor9().equals("Oui") ) {
                            fragment9.mainint("extra", "", "labor", plot9Area, avgCost, age9, estPrd9,farmerCost,"");
                            fragment9.other("labor");
                        } else if (sObject.getHireLabor9().equals("Seasonal")||sObject.getHireLabor9().equals("Saisonnier") ) {
                            fragment9.mainint("extra", "", "season", plot9Area, avgCost, age9, estPrd9,farmerCost,"");
                            fragment9.other("labor");
                        } else {
                            fragment9.mainint("extra", "", "", plot9Area, avgCost, age9, estPrd9,farmerCost,"");
                        }

                    }else if (sObject.getRECO9().equals("thinning+extra")) {
                        //Thinning
                        if (sObject.getHireLabor9().equals("Yes")||sObject.getHireLabor9().equals("Oui") ) {
                            fragment9.mainint("thinning", "extra", "labor", plot9Area, avgCost, age9, estPrd9,farmerCost,"");
                            fragment9.other("labor");
                        } else if (sObject.getHireLabor9().equals("Seasonal")||sObject.getHireLabor9().equals("Saisonnier") ) {
                            fragment9.mainint("thinning", "extra", "season", plot9Area, avgCost, age9, estPrd9,farmerCost,"");
                            fragment9.other("labor");
                        } else {
                            fragment9.mainint("thinning", "extra", "", plot9Area, avgCost, age9, estPrd9,farmerCost,"");
                        }

                    }else if (sObject.getRECO9().equals("thinning")) {
                        //Thinning
                        if (sObject.getHireLabor9().equals("Yes")||sObject.getHireLabor9().equals("Oui") ) {
                            fragment9.mainint("thinning", "", "labor", plot9Area, avgCost, age9, estPrd9,farmerCost,"");
                            fragment9.other("labor");
                        } else if (sObject.getHireLabor9().equals("Seasonal")||sObject.getHireLabor9().equals("Saisonnier") ) {
                            fragment9.mainint("thinning", "", "season", plot9Area, avgCost, age9, estPrd9,farmerCost,"");
                            fragment9.other("labor");
                        } else {
                            fragment9.mainint("thinning", "", "", plot9Area, avgCost, age9, estPrd9,farmerCost,"");
                        }

                    }else if (sObject.getRECO9().equals("filling+extra")) {
                        //filling
                        if (sObject.getHireLabor9().equals("Yes")||sObject.getHireLabor9().equals("Oui") ) {
                            fragment9.mainint("filling", "extra", "labor", plot9Area, avgCost, age9, estPrd9,farmerCost,"");
                            fragment9.other("labor");
                        } else if (sObject.getHireLabor9().equals("Seasonal")||sObject.getHireLabor9().equals("Saisonnier") ) {
                            fragment9.mainint("filling", "extra", "season", plot9Area, avgCost, age9, estPrd9,farmerCost,"");
                            fragment9.other("labor");
                        } else {
                            fragment9.mainint("filling", "extra", "", plot9Area, avgCost, age9, estPrd9,farmerCost,"");
                        }

                    }else if (sObject.getRECO9().equals("filling")) {
                        //filling
                        if (sObject.getHireLabor9().equals("Yes")||sObject.getHireLabor9().equals("Oui") ) {
                            fragment9.mainint("filling", "", "labor", plot9Area, avgCost, age9, estPrd9,farmerCost,"");
                            fragment9.other("labor");
                        } else if (sObject.getHireLabor9().equals("Seasonal")||sObject.getHireLabor9().equals("Saisonnier") ) {
                            fragment9.mainint("filling", "", "season", plot9Area, avgCost, age9, estPrd9,farmerCost,"");
                            fragment9.other("labor");
                        } else {
                            fragment9.mainint("filling", "", "", plot9Area, avgCost, age9, estPrd9,farmerCost,"");
                        }

                    } else {
                        //GAP
                        if (sObject.getHireLabor9().equals("Yes")||sObject.getHireLabor9().equals("Oui") ) {
                            fragment9.mainint("gap", "", "labor", plot9Area, avgCost, age9, estPrd9,farmerCost,"");
                            fragment9.other("labor");
                        } else if (sObject.getHireLabor9().equals("Seasonal")||sObject.getHireLabor9().equals("Saisonnier") ) {
                            fragment9.mainint("gap", "", "season", plot9Area, avgCost, age9, estPrd9,farmerCost,"");
                            fragment9.other("labor");
                        } else {
                            fragment9.mainint("gap", "", "", plot9Area, avgCost, age9, estPrd9,farmerCost,"");
                        }
                    }
                }

                //other interventions
                if (sObject.getLimeNeed9().equals("Yes")||sObject.getLimeNeed9().equals("Oui")) {
                    fragment9.other("lime");
                }

                if (sObject.getFillingOption9().equals("Yes")||sObject.getFillingOption9().equals("Oui")) {
                    if (sObject.getPlot9CocoaTrees().contentEquals("2x2")||sObject.getPlot9CocoaTrees().contentEquals("2x2.5")||sObject.getPlot9CocoaTrees().contentEquals("2x3")||sObject.getPlot9CocoaTrees().contentEquals("2.5x2.5")||sObject.getPlot9CocoaTrees().contentEquals("2x3.5")) {
                        fragment9.other("thinning");
                    }else{
                        fragment9.other("filling");
                    }
                }

                if (sObject.getDrainageNeed9().equals("Yes")||sObject.getDrainageNeed9().equals("Oui")) {
                    fragment9.other("drainage");
                }
                ft.show(fragment9);
            }else{ft.hide(fragment9);}

            //plot10
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 9) {
                setText(plot10,getString(R.string.pt10));
                fragment10.setStartYear(startY10);
                if(sObject.getPLOT10RENOVATION().equals("Yes")||sObject.getPLOT10RENOVATION().equals("Oui")){
                    if(sObject.getPLOT10RENOVATIONREASON().equals("Replanting")||sObject.getPLOT10RENOVATIONREASON().equals("Replantation")){
                        if (sObject.getHireLabor10().equals("Yes")||sObject.getHireLabor10().equals("Oui") ) {
                            fragment10.mainint("replant", "", "labor", plot10Area, avgCost, age10, estPrd10,farmerCost,"");
                            fragment10.other("labor");
                        } else if (sObject.getHireLabor10().equals("Seasonal")||sObject.getHireLabor10().equals("Saisonnier") ) {
                            fragment10.mainint("replant", "", "season", plot10Area, avgCost, age10, estPrd10,farmerCost,"");
                            fragment10.other("labor");
                        } else {
                            fragment10.mainint("replant", "", "", plot10Area, avgCost, age10, estPrd10,farmerCost,"");
                        }
                    }else{
                        if (sObject.getHireLabor10().equals("Yes")||sObject.getHireLabor10().equals("Oui") ) {
                            fragment10.mainint("graft", "", "labor", plot10Area, avgCost, age10, estPrd10,farmerCost,"");
                            fragment10.other("labor");
                        } else if (sObject.getHireLabor10().equals("Seasonal")||sObject.getHireLabor10().equals("Saisonnier") ) {
                            fragment10.mainint("graft", "", "season", plot10Area, avgCost, age10, estPrd10,farmerCost,"");
                            fragment10.other("labor");
                        } else {
                            fragment10.mainint("graft", "", "", plot10Area, avgCost, age10, estPrd10,farmerCost,"");
                        }
                    }
                }else {
                    //main intervention
                    if (sObject.getRECO10().equals("replanting")) {
                        //Replant
                        if (Double.parseDouble(sObject.getPlot10Age())<30 && sObject.getTreeHealth10().equals("G")&&sObject.getDebilitatingDisease10().equals("G")){

                            if (sObject.getPlot10CocoaTrees().contentEquals("2x2")||sObject.getPlot10CocoaTrees().contentEquals("2x2.5")||sObject.getPlot10CocoaTrees().contentEquals("2x3")||sObject.getPlot10CocoaTrees().contentEquals("2.5x2.5")||sObject.getPlot10CocoaTrees().contentEquals("2x3.5")) {
                                if (sObject.getHireLabor10().equals("Yes")||sObject.getHireLabor10().equals("Oui") ) {
                                    fragment10.mainint("replant", "", "labor", plot10Area, avgCost, age10, estPrd10,farmerCost, "t");
                                    fragment10.other("labor");
                                } else if (sObject.getHireLabor10().equals("Seasonal")||sObject.getHireLabor10().equals("Saisonnier") ) {
                                    fragment10.mainint("replant", "", "season", plot10Area, avgCost, age10, estPrd10,farmerCost, "t");
                                    fragment10.other("labor");
                                } else {
                                    fragment10.mainint("replant", "", "", plot10Area, avgCost, age10, estPrd10,farmerCost, "t");
                                }
                            }else if(sObject.getPlot10CocoaTrees().contentEquals("3.5x4")||sObject.getPlot10CocoaTrees().contentEquals("4x4")){
                                if (sObject.getHireLabor10().equals("Yes")||sObject.getHireLabor10().equals("Oui") ) {
                                    fragment10.mainint("replant", "", "labor", plot10Area, avgCost, age10, estPrd10,farmerCost, "f");
                                    fragment10.other("labor");
                                } else if (sObject.getHireLabor10().equals("Seasonal")||sObject.getHireLabor10().equals("Saisonnier") ) {
                                    fragment10.mainint("replant", "", "season", plot10Area, avgCost, age10, estPrd10,farmerCost, "f");
                                    fragment10.other("labor");
                                } else {
                                    fragment10.mainint("replant", "", "", plot10Area, avgCost, age10, estPrd10,farmerCost, "f");
                                }
                            }else{
                                if (sObject.getHireLabor10().equals("Yes")||sObject.getHireLabor10().equals("Oui") ) {
                                    fragment10.mainint("replant", "", "labor", plot10Area, avgCost, age10, estPrd10,farmerCost,"");
                                    fragment10.other("labor");
                                } else if (sObject.getHireLabor10().equals("Seasonal")||sObject.getHireLabor10().equals("Saisonnier") ) {
                                    fragment10.mainint("replant", "", "season", plot10Area, avgCost, age10, estPrd10,farmerCost,"");
                                    fragment10.other("labor");
                                } else {
                                    fragment10.mainint("replant", "", "", plot10Area, avgCost, age10, estPrd10,farmerCost,"");
                                }
                            }

                        }else{
                            if (sObject.getHireLabor10().equals("Yes")||sObject.getHireLabor10().equals("Oui") ) {
                                fragment10.mainint("replant", "", "labor", plot10Area, avgCost, age10, estPrd10,farmerCost,"");
                                fragment10.other("labor");
                            } else if (sObject.getHireLabor10().equals("Seasonal")||sObject.getHireLabor10().equals("Saisonnier") ) {
                                fragment10.mainint("replant", "", "season", plot10Area, avgCost, age10, estPrd10,farmerCost,"");
                                fragment10.other("labor");
                            } else {
                                fragment10.mainint("replant", "", "", plot10Area, avgCost, age10, estPrd10,farmerCost,"");
                            }
                        }

                    }else if (sObject.getRECO10().equals("replanting+extra")) {
                        if (Double.parseDouble(sObject.getPlot10Age())<30 && sObject.getTreeHealth10().equals("G")&&sObject.getDebilitatingDisease10().equals("G")){

                            if (sObject.getPlot10CocoaTrees().contentEquals("2x2")||sObject.getPlot10CocoaTrees().contentEquals("2x2.5")||sObject.getPlot10CocoaTrees().contentEquals("2x3")||sObject.getPlot10CocoaTrees().contentEquals("2.5x2.5")||sObject.getPlot10CocoaTrees().contentEquals("2x3.5")) {
                                if (sObject.getHireLabor10().equals("Yes")||sObject.getHireLabor10().equals("Oui") ) {
                                    fragment10.mainint("replant", "extra", "labor", plot10Area, avgCost, age10, estPrd10,farmerCost, "t");
                                    fragment10.other("labor");
                                } else if (sObject.getHireLabor10().equals("Seasonal")||sObject.getHireLabor10().equals("Saisonnier") ) {
                                    fragment10.mainint("replant", "extra", "season", plot10Area, avgCost, age10, estPrd10,farmerCost, "t");
                                    fragment10.other("labor");
                                } else {
                                    fragment10.mainint("replant", "extra", "", plot10Area, avgCost, age10, estPrd10,farmerCost, "t");
                                }
                            }else if(sObject.getPlot10CocoaTrees().contentEquals("3.5x4")||sObject.getPlot10CocoaTrees().contentEquals("4x4")){
                                if (sObject.getHireLabor10().equals("Yes")||sObject.getHireLabor10().equals("Oui") ) {
                                    fragment10.mainint("replant", "extra", "labor", plot10Area, avgCost, age10, estPrd10,farmerCost, "f");
                                    fragment10.other("labor");
                                } else if (sObject.getHireLabor10().equals("Seasonal")||sObject.getHireLabor10().equals("Saisonnier") ) {
                                    fragment10.mainint("replant", "extra", "season", plot10Area, avgCost, age10, estPrd10,farmerCost, "f");
                                    fragment10.other("labor");
                                } else {
                                    fragment10.mainint("replant", "extra", "", plot10Area, avgCost, age10, estPrd10,farmerCost, "f");
                                }
                            }else{
                                if (sObject.getHireLabor10().equals("Yes")||sObject.getHireLabor10().equals("Oui") ) {
                                    fragment10.mainint("replant", "extra", "labor", plot10Area, avgCost, age10, estPrd10,farmerCost,"");
                                    fragment10.other("labor");
                                } else if (sObject.getHireLabor10().equals("Seasonal")||sObject.getHireLabor10().equals("Saisonnier") ) {
                                    fragment10.mainint("replant", "extra", "season", plot10Area, avgCost, age10, estPrd10,farmerCost,"");
                                    fragment10.other("labor");
                                } else {
                                    fragment10.mainint("replant", "extra", "", plot10Area, avgCost, age10, estPrd10,farmerCost,"");
                                }
                            }

                        }else{
                            if (sObject.getHireLabor10().equals("Yes")||sObject.getHireLabor10().equals("Oui") ) {
                                fragment10.mainint("replant", "extra", "labor", plot10Area, avgCost, age10, estPrd10,farmerCost,"");
                                fragment10.other("labor");
                            } else if (sObject.getHireLabor10().equals("Seasonal")||sObject.getHireLabor10().equals("Saisonnier") ) {
                                fragment10.mainint("replant", "extra", "season", plot10Area, avgCost, age10, estPrd10,farmerCost,"");
                                fragment10.other("labor");
                            } else {
                                fragment10.mainint("replant", "extra", "", plot10Area, avgCost, age10, estPrd10,farmerCost,"");
                            }
                        }

                    } else if (sObject.getRECO10().equals("grafting+extra")) {
                        //Graft
                        if (sObject.getHireLabor10().equals("Yes")||sObject.getHireLabor10().equals("Oui") ) {
                            fragment10.mainint("graft", "extra", "labor", plot10Area, avgCost, age10, estPrd10,farmerCost,"");
                            fragment10.other("labor");
                        } else if (sObject.getHireLabor10().equals("Seasonal")||sObject.getHireLabor10().equals("Saisonnier") ) {
                            fragment10.mainint("graft", "extra", "season", plot10Area, avgCost, age10, estPrd10,farmerCost,"");
                            fragment10.other("labor");
                        } else {
                            fragment10.mainint("graft", "extra", "", plot10Area, avgCost, age10, estPrd10,farmerCost,"");
                        }
                    } else  if(sObject.getRECO10().equals("grafting")){
                        if (sObject.getHireLabor10().equals("Yes")||sObject.getHireLabor10().equals("Oui") ) {
                            fragment10.mainint("graft", "", "labor", plot10Area, avgCost, age10, estPrd10,farmerCost,"");
                            fragment10.other("labor");
                        } else if (sObject.getHireLabor10().equals("Seasonal")||sObject.getHireLabor10().equals("Saisonnier") ) {
                            fragment10.mainint("graft", "", "season", plot10Area, avgCost, age10, estPrd10,farmerCost,"");
                            fragment10.other("labor");
                        } else {
                            fragment10.mainint("graft", "", "", plot10Area, avgCost, age10, estPrd10,farmerCost,"");
                        }

                    } else if (sObject.getRECO10().equals("extra")) {
                        //Extra Soil Management
                        if (sObject.getHireLabor10().equals("Yes")||sObject.getHireLabor10().equals("Oui") ) {
                            fragment10.mainint("extra", "", "labor", plot10Area, avgCost, age10, estPrd10,farmerCost,"");
                            fragment10.other("labor");
                        } else if (sObject.getHireLabor10().equals("Seasonal")||sObject.getHireLabor10().equals("Saisonnier") ) {
                            fragment10.mainint("extra", "", "season", plot10Area, avgCost, age10, estPrd10,farmerCost,"");
                            fragment10.other("labor");
                        } else {
                            fragment10.mainint("extra", "", "", plot10Area, avgCost, age10, estPrd10,farmerCost,"");
                        }

                    }else if (sObject.getRECO10().equals("thinning+extra")) {
                        //Thinning
                        if (sObject.getHireLabor10().equals("Yes")||sObject.getHireLabor10().equals("Oui") ) {
                            fragment10.mainint("thinning", "extra", "labor", plot10Area, avgCost, age10, estPrd10,farmerCost,"");
                            fragment10.other("labor");
                        } else if (sObject.getHireLabor10().equals("Seasonal")||sObject.getHireLabor10().equals("Saisonnier") ) {
                            fragment10.mainint("thinning", "extra", "season", plot10Area, avgCost, age10, estPrd10,farmerCost,"");
                            fragment10.other("labor");
                        } else {
                            fragment10.mainint("thinning", "extra", "", plot10Area, avgCost, age10, estPrd10,farmerCost,"");
                        }

                    }else if (sObject.getRECO10().equals("thinning")) {
                        //Thinning
                        if (sObject.getHireLabor10().equals("Yes")||sObject.getHireLabor10().equals("Oui") ) {
                            fragment10.mainint("thinning", "", "labor", plot10Area, avgCost, age10, estPrd10,farmerCost,"");
                            fragment10.other("labor");
                        } else if (sObject.getHireLabor10().equals("Seasonal")||sObject.getHireLabor10().equals("Saisonnier") ) {
                            fragment10.mainint("thinning", "", "season", plot10Area, avgCost, age10, estPrd10,farmerCost,"");
                            fragment10.other("labor");
                        } else {
                            fragment10.mainint("thinning", "", "", plot10Area, avgCost, age10, estPrd10,farmerCost,"");
                        }

                    }else if (sObject.getRECO10().equals("filling+extra")) {
                        //filling
                        if (sObject.getHireLabor10().equals("Yes")||sObject.getHireLabor10().equals("Oui") ) {
                            fragment10.mainint("filling", "extra", "labor", plot10Area, avgCost, age10, estPrd10,farmerCost,"");
                            fragment10.other("labor");
                        } else if (sObject.getHireLabor10().equals("Seasonal")||sObject.getHireLabor10().equals("Saisonnier") ) {
                            fragment10.mainint("filling", "extra", "season", plot10Area, avgCost, age10, estPrd10,farmerCost,"");
                            fragment10.other("labor");
                        } else {
                            fragment10.mainint("filling", "extra", "", plot10Area, avgCost, age10, estPrd10,farmerCost,"");
                        }

                    }else if (sObject.getRECO10().equals("filling")) {
                        //filling
                        if (sObject.getHireLabor10().equals("Yes")||sObject.getHireLabor10().equals("Oui") ) {
                            fragment10.mainint("filling", "", "labor", plot10Area, avgCost, age10, estPrd10,farmerCost,"");
                            fragment10.other("labor");
                        } else if (sObject.getHireLabor10().equals("Seasonal")||sObject.getHireLabor10().equals("Saisonnier") ) {
                            fragment10.mainint("filling", "", "season", plot10Area, avgCost, age10, estPrd10,farmerCost,"");
                            fragment10.other("labor");
                        } else {
                            fragment10.mainint("filling", "", "", plot10Area, avgCost, age10, estPrd10,farmerCost,"");
                        }

                    } else {
                        //GAP
                        if (sObject.getHireLabor10().equals("Yes")||sObject.getHireLabor10().equals("Oui") ) {
                            fragment10.mainint("gap", "", "labor", plot10Area, avgCost, age10, estPrd10,farmerCost,"");
                            fragment10.other("labor");
                        } else if (sObject.getHireLabor10().equals("Seasonal")||sObject.getHireLabor10().equals("Saisonnier") ) {
                            fragment10.mainint("gap", "", "season", plot10Area, avgCost, age10, estPrd10,farmerCost,"");
                            fragment10.other("labor");
                        } else {
                            fragment10.mainint("gap", "", "", plot10Area, avgCost, age10, estPrd10,farmerCost,"");
                        }
                    }
                }

                //other interventions
                if (sObject.getLimeNeed10().equals("Yes")||sObject.getLimeNeed10().equals("Oui")) {
                    fragment10.other("lime");
                }

                if (sObject.getFillingOption10().equals("Yes")||sObject.getFillingOption10().equals("Oui")) {
                    if (sObject.getPlot10CocoaTrees().contentEquals("2x2")||sObject.getPlot10CocoaTrees().contentEquals("2x2.5")||sObject.getPlot10CocoaTrees().contentEquals("2x3")||sObject.getPlot10CocoaTrees().contentEquals("2.5x2.5")||sObject.getPlot10CocoaTrees().contentEquals("2x3.5")) {
                        fragment10.other("thinning");
                    }else{
                        fragment10.other("filling");
                    }
                }

                if (sObject.getDrainageNeed10().equals("Yes")||sObject.getDrainageNeed10().equals("Oui")) {
                    fragment10.other("drainage");
                }
                ft.show(fragment10);
            }else{ft.hide(fragment10);}
            ft.commitAllowingStateLoss();

            calculations();
        }
    }
    public void comt(String plot){
        comments.setText("+Change Replant for Grafting "+plot+"+");
    }
    public void comt2(String plot){
        comments.setText("+Change Replant for Thinning out "+plot+"+");
    }
    public void comt3(String plot){
        comments.setText("+Change Replant for Filling in "+plot+"+");
    }

    public void change(String plot,String reco){
        final String coments = ((EditText) findViewById(R.id.reasonNotAgree_field)).getText().toString()+comt1.getText().toString()+comt2.getText().toString()+comt3.getText().toString()+comt4.getText().toString()+comt4.getText().toString()+comt5.getText().toString()+comt6.getText().toString()+comt7.getText().toString()+comt8.getText().toString()+comt9.getText().toString()+comt10.getText().toString();
        final SmartStore smartStore = SmartSyncSDKManager.getInstance().getSmartStore(curAccount);
        JSONObject contact;
        try {
            boolean isCreate = TextUtils.isEmpty(objectId);
            if (!isCreate) {
                contact = smartStore.retrieve(ContactListLoader.CONTACT_SOUP,
                        smartStore.lookupSoupEntryId(ContactListLoader.CONTACT_SOUP,
                                Constants.ID, objectId)).getJSONObject(0);
            } else {
                contact = new JSONObject();
                contact.put(Constants.ID, "local_" + System.currentTimeMillis()
                        + Constants.EMPTY_STRING);
                final JSONObject attributes = new JSONObject();
                attributes.put(Constants.TYPE.toLowerCase(), Constants.SUBMISSION);
                contact.put(Constants.ATTRIBUTES, attributes);
            }
            switch (plot) {
                case "PLOT 1":
                    contact.put(ContactObject.RECO1,reco);
                    break;
                case "PLOT 2":
                    contact.put(ContactObject.RECO2,reco);
                    break;
                case "PLOT 3":
                    contact.put(ContactObject.RECO3,reco);
                    break;
                case "PLOT 4":
                    contact.put(ContactObject.RECO4,reco);
                    break;
                case "PLOT 5":
                    contact.put(ContactObject.RECO5,reco);
                    break;
                case "PLOT 6":
                    contact.put(ContactObject.RECO6,reco);
                    break;
                case "PLOT 7":
                    contact.put(ContactObject.RECO7,reco);
                    break;
                case "PLOT 8":
                    contact.put(ContactObject.RECO8,reco);
                    break;
                case "PLOT 9":
                    contact.put(ContactObject.RECO9,reco);
                    break;
                case "PLOT 10":
                    contact.put(ContactObject.RECO10,reco);
                    break;
            }
            contact.put(ContactObject.FARMERCOMMENTS,coments);
            contact.put(SyncManager.LOCAL, true);
            contact.put(SyncManager.LOCALLY_UPDATED, !isCreate);
            contact.put(SyncManager.LOCALLY_CREATED, isCreate);
            contact.put(SyncManager.LOCALLY_DELETED, false);
            if (isCreate) {
                smartStore.create(ContactListLoader.CONTACT_SOUP, contact);
            } else {
                smartStore.upsert(ContactListLoader.CONTACT_SOUP, contact);
            }
            Toast.makeText(this, this.getString(R.string.saved), Toast.LENGTH_SHORT).show();
            finish();
            final Intent fdpIntent = new Intent(this, fdpActivity.class);
            fdpIntent.addCategory(Intent.CATEGORY_DEFAULT);
            fdpIntent.putExtra(OBJECT_ID_KEY, sObject.getObjectId());
            fdpIntent.putExtra(OBJECT_TITLE_KEY, sObject.getName());
            fdpIntent.putExtra(OBJECT_NAME_KEY, sObject.getEmail());
            startActivity(fdpIntent);
        } catch (JSONException e) {
            Log.e(TAG, "JSONException occurred while parsing", e);
        }

    }

    public void calculations() {
        if (sObject != null) {
            DecimalFormat dec = new DecimalFormat("Ghs ###,###,###");
            //net income cocoa
            int totalIncomeY0 = Integer.parseInt(income10.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income20.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income30.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income40.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income50.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income60.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income70.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income80.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income90.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income100.getText().toString().replaceAll("[^0-9.]+", ""));
            int totalIncomeY1 = Integer.parseInt(income11.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income21.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income31.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income41.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income51.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income61.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income71.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income81.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income91.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income101.getText().toString().replaceAll("[^0-9.]+", ""));
            int totalIncomeY2 = Integer.parseInt(income12.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income22.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income32.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income42.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income52.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income62.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income72.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income82.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income92.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income102.getText().toString().replaceAll("[^0-9.]+", ""));
            int totalIncomeY3 = Integer.parseInt(income13.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income23.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income33.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income43.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income53.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income63.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income73.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income83.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income93.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income103.getText().toString().replaceAll("[^0-9.]+", ""));
            int totalIncomeY4 = Integer.parseInt(income14.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income24.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income34.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income44.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income54.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income64.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income74.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income84.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income94.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income104.getText().toString().replaceAll("[^0-9.]+", ""));
            int totalIncomeY5 = Integer.parseInt(income15.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income25.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income35.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income45.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income55.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income65.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income75.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income85.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income95.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income105.getText().toString().replaceAll("[^0-9.]+", ""));
            int totalIncomeY6 = Integer.parseInt(income16.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income26.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income36.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income46.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income56.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income66.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income76.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income86.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income96.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income106.getText().toString().replaceAll("[^0-9.]+", ""));
            int totalIncomeY7 = Integer.parseInt(income17.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income27.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income37.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income47.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income57.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income67.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income77.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income87.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income97.getText().toString().replaceAll("[^0-9.]+", ""))+Integer.parseInt(income107.getText().toString().replaceAll("[^0-9.]+", ""));
            setText((TextView) findViewById(R.id.netPlotIncomeY0_field), String.valueOf(dec.format(totalIncomeY0)));
            setText((TextView) findViewById(R.id.netPlotIncomeY1_field), String.valueOf(dec.format(totalIncomeY1)));
            setText((TextView) findViewById(R.id.netPlotIncomeY2_field), String.valueOf(dec.format(totalIncomeY2)));
            setText((TextView) findViewById(R.id.netPlotIncomeY3_field), String.valueOf(dec.format(totalIncomeY3)));
            setText((TextView) findViewById(R.id.netPlotIncomeY4_field), String.valueOf(dec.format(totalIncomeY4)));
            setText((TextView) findViewById(R.id.netPlotIncomeY5_field), String.valueOf(dec.format(totalIncomeY5)));
            setText((TextView) findViewById(R.id.netPlotIncomeY6_field), String.valueOf(dec.format(totalIncomeY6)));
            setText((TextView) findViewById(R.id.netPlotIncomeY7_field), String.valueOf(dec.format(totalIncomeY7)));

            //net income other crops
            double otherCrops = 0;
            if (sObject.getIncomeothercrops().isEmpty()){
                otherCrops = 0;
            }else {
                otherCrops = Double.parseDouble(sObject.getIncomeothercrops());
            }

            setText((TextView) findViewById(R.id.otherCropY0_field), String.valueOf(dec.format(otherCrops)));
            setText((TextView) findViewById(R.id.otherCropY1_field), String.valueOf(dec.format(otherCrops)));
            setText((TextView) findViewById(R.id.otherCropY2_field), String.valueOf(dec.format(otherCrops)));
            setText((TextView) findViewById(R.id.otherCropY3_field), String.valueOf(dec.format(otherCrops)));
            setText((TextView) findViewById(R.id.otherCropY4_field), String.valueOf(dec.format(otherCrops)));
            setText((TextView) findViewById(R.id.otherCropY5_field), String.valueOf(dec.format(otherCrops)));
            setText((TextView) findViewById(R.id.otherCropY6_field), String.valueOf(dec.format(otherCrops)));
            setText((TextView) findViewById(R.id.otherCropY7_field), String.valueOf(dec.format(otherCrops)));

            //net income farming
            int farmingy0 = (int) (totalIncomeY0+otherCrops);
            int farmingy1 = (int) (totalIncomeY1+otherCrops);
            int farmingy2 = (int) (totalIncomeY2+otherCrops);
            int farmingy3 = (int) (totalIncomeY3+otherCrops);
            int farmingy4 = (int) (totalIncomeY4+otherCrops);
            int farmingy5 = (int) (totalIncomeY5+otherCrops);
            int farmingy6 = (int) (totalIncomeY6+otherCrops);
            int farmingy7 = (int) (totalIncomeY7+otherCrops);
            setText((TextView) findViewById(R.id.netFarmingY0_field), String.valueOf(dec.format(farmingy0)));
            setText((TextView) findViewById(R.id.netFarmingY1_field), String.valueOf(dec.format(farmingy1)));
            setText((TextView) findViewById(R.id.netFarmingY2_field), String.valueOf(dec.format(farmingy2)));
            setText((TextView) findViewById(R.id.netFarmingY3_field), String.valueOf(dec.format(farmingy3)));
            setText((TextView) findViewById(R.id.netFarmingY4_field), String.valueOf(dec.format(farmingy4)));
            setText((TextView) findViewById(R.id.netFarmingY5_field), String.valueOf(dec.format(farmingy5)));
            setText((TextView) findViewById(R.id.netFarmingY6_field), String.valueOf(dec.format(farmingy6)));
            setText((TextView) findViewById(R.id.netFarmingY7_field), String.valueOf(dec.format(farmingy7)));

            //net other income sources
            double moneyBack = 0;
            if (sObject.getLoanmoneygetback().isEmpty()){
                moneyBack = 0;
            }else {
                moneyBack = Double.parseDouble(sObject.getLoanmoneygetback());
            }

            double farmWork = 0;
            if (sObject.getIncomefarmlabor().isEmpty()){
                farmWork = 0;
            }else {
                farmWork = Double.parseDouble(sObject.getIncomefarmlabor());
            }

            double spouseWork = 0;
            if (sObject.getSpouseincome().isEmpty()){
                spouseWork = 0;
            }else {
                spouseWork = Double.parseDouble(sObject.getSpouseincome());
            }

            double familyWork = 0;
            if (sObject.getFamilymembersincome().isEmpty()){
                familyWork = 0;
            }else {
                familyWork = Double.parseDouble(sObject.getFamilymembersincome());
            }
            int totalOtherIncome = (int) (moneyBack+farmWork+spouseWork+familyWork);
            setText((TextView) findViewById(R.id.netOtherY0_field), String.valueOf(dec.format(totalOtherIncome)));
            setText((TextView) findViewById(R.id.netOtherY1_field), String.valueOf(dec.format(totalOtherIncome)));
            setText((TextView) findViewById(R.id.netOtherY2_field), String.valueOf(dec.format(totalOtherIncome)));
            setText((TextView) findViewById(R.id.netOtherY3_field), String.valueOf(dec.format(totalOtherIncome)));
            setText((TextView) findViewById(R.id.netOtherY4_field), String.valueOf(dec.format(totalOtherIncome)));
            setText((TextView) findViewById(R.id.netOtherY5_field), String.valueOf(dec.format(totalOtherIncome)));
            setText((TextView) findViewById(R.id.netOtherY6_field), String.valueOf(dec.format(totalOtherIncome)));
            setText((TextView) findViewById(R.id.netOtherY7_field), String.valueOf(dec.format(totalOtherIncome)));

            //total income
            int totalIncomeAllY0 = farmingy0 + totalOtherIncome;
            int totalIncomeAllY1 = farmingy1 + totalOtherIncome;
            int totalIncomeAllY2 = farmingy2 + totalOtherIncome;
            int totalIncomeAllY3 = farmingy3 + totalOtherIncome;
            int totalIncomeAllY4 = farmingy4 + totalOtherIncome;
            int totalIncomeAllY5 = farmingy5 + totalOtherIncome;
            int totalIncomeAllY6 = farmingy6 + totalOtherIncome;
            int totalIncomeAllY7 = farmingy7 + totalOtherIncome;
            setText((TextView) findViewById(R.id.totalIncomeY0_field), String.valueOf(dec.format(totalIncomeAllY0)));
            setText((TextView) findViewById(R.id.totalIncomeY1_field), String.valueOf(dec.format(totalIncomeAllY1)));
            setText((TextView) findViewById(R.id.totalIncomeY2_field), String.valueOf(dec.format(totalIncomeAllY2)));
            setText((TextView) findViewById(R.id.totalIncomeY3_field), String.valueOf(dec.format(totalIncomeAllY3)));
            setText((TextView) findViewById(R.id.totalIncomeY4_field), String.valueOf(dec.format(totalIncomeAllY4)));
            setText((TextView) findViewById(R.id.totalIncomeY5_field), String.valueOf(dec.format(totalIncomeAllY5)));
            setText((TextView) findViewById(R.id.totalIncomeY6_field), String.valueOf(dec.format(totalIncomeAllY6)));
            setText((TextView) findViewById(R.id.totalIncomeY7_field), String.valueOf(dec.format(totalIncomeAllY7)));

            //total family costs
            double anLivExpen = 0;
            if (sObject.getAnnuallivingexpenses().isEmpty()){
                anLivExpen = 0;
            }else {
                anLivExpen = Double.parseDouble(sObject.getAnnuallivingexpenses());
            }

            double anOtherExp = 0;
            if (sObject.getAnnualotherexpenses().isEmpty()){
                anOtherExp = 0;
            }else {
                anOtherExp = Double.parseDouble(sObject.getAnnualotherexpenses());
            }

            double expEducExp = 0;
            if (sObject.getExpectededucationexpenses().isEmpty()){
                expEducExp = 0;
            }else {
                expEducExp = Double.parseDouble(sObject.getExpectededucationexpenses());
            }

            double credPay = 0;
            if (sObject.getHowmuchpayforcredit().isEmpty()){
                credPay = 0;
            }else {
                credPay = Double.parseDouble(sObject.getHowmuchpayforcredit());
            }

            int totalExpenses = (int) (anLivExpen+anOtherExp+expEducExp+credPay);
            setText((TextView) findViewById(R.id.totalExpensesY0_field), String.valueOf(dec.format(totalExpenses)));
            setText((TextView) findViewById(R.id.totalExpensesY1_field), String.valueOf(dec.format(totalExpenses)));
            setText((TextView) findViewById(R.id.totalExpensesY2_field), String.valueOf(dec.format(totalExpenses)));
            setText((TextView) findViewById(R.id.totalExpensesY3_field), String.valueOf(dec.format(totalExpenses)));
            setText((TextView) findViewById(R.id.totalExpensesY4_field), String.valueOf(dec.format(totalExpenses)));
            setText((TextView) findViewById(R.id.totalExpensesY5_field), String.valueOf(dec.format(totalExpenses)));
            setText((TextView) findViewById(R.id.totalExpensesY6_field), String.valueOf(dec.format(totalExpenses)));
            setText((TextView) findViewById(R.id.totalExpensesY7_field), String.valueOf(dec.format(totalExpenses)));

            // net family income
            int availableY0 = totalIncomeAllY0-totalExpenses;
            int availableY1 = totalIncomeAllY1-totalExpenses;
            int availableY2 = totalIncomeAllY2-totalExpenses;
            int availableY3 = totalIncomeAllY3-totalExpenses;
            int availableY4 = totalIncomeAllY4-totalExpenses;
            int availableY5 = totalIncomeAllY5-totalExpenses;
            int availableY6 = totalIncomeAllY6-totalExpenses;
            int availableY7 = totalIncomeAllY7-totalExpenses;
            setText((TextView) findViewById(R.id.netFamilyY0_field), String.valueOf(dec.format(availableY0)));
            if(availableY0 > 0){
                found0.setTextColor(Color.parseColor("#29a329"));
            }else{
                found0.setTextColor(Color.parseColor("#cc0000"));
            }
            setText((TextView) findViewById(R.id.netFamilyY1_field), String.valueOf(dec.format(availableY1)));
            if(availableY1 > 0){
                found1.setTextColor(Color.parseColor("#29a329"));
            }else{
                found1.setTextColor(Color.parseColor("#cc0000"));
            }
            setText((TextView) findViewById(R.id.netFamilyY2_field), String.valueOf(dec.format(availableY2)));
            if(availableY2 > 0){
                found2.setTextColor(Color.parseColor("#29a329"));
            }else{
                found2.setTextColor(Color.parseColor("#cc0000"));
            }
            setText((TextView) findViewById(R.id.netFamilyY3_field), String.valueOf(dec.format(availableY3)));
            if(availableY3 > 0){
                found3.setTextColor(Color.parseColor("#29a329"));
            }else{
                found3.setTextColor(Color.parseColor("#cc0000"));
            }
            setText((TextView) findViewById(R.id.netFamilyY4_field), String.valueOf(dec.format(availableY4)));
            if(availableY4 > 0){
                found4.setTextColor(Color.parseColor("#29a329"));
            }else{
                found4.setTextColor(Color.parseColor("#cc0000"));
            }
            setText((TextView) findViewById(R.id.netFamilyY5_field), String.valueOf(dec.format(availableY5)));
            if(availableY5 > 0){
                found5.setTextColor(Color.parseColor("#29a329"));
            }else{
                found5.setTextColor(Color.parseColor("#cc0000"));
            }
            setText((TextView) findViewById(R.id.netFamilyY6_field), String.valueOf(dec.format(availableY6)));
            if(availableY6 > 0){
                found6.setTextColor(Color.parseColor("#29a329"));
            }else{
                found6.setTextColor(Color.parseColor("#cc0000"));
            }
            setText((TextView) findViewById(R.id.netFamilyY7_field), String.valueOf(dec.format(availableY7)));
            if(availableY7 > 0){
                found7.setTextColor(Color.parseColor("#29a329"));
            }else{
                found7.setTextColor(Color.parseColor("#cc0000"));
            }

            //found needed
            int totalY0 = Integer.parseInt(cost10.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor10.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost20.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor20.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost30.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor30.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost40.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor40.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost50.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor50.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost60.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor60.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost70.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor70.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost80.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor80.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost90.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor90.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost100.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor100.getText().toString().replaceAll("[^0-9]+", ""));
            int totalY1 = Integer.parseInt(cost11.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor11.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost21.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor21.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost31.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor31.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost41.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor41.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost51.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor51.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost61.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor61.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost71.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor71.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost81.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor81.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost91.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor91.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost101.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor101.getText().toString().replaceAll("[^0-9]+", ""));
            int totalY2 = Integer.parseInt(cost12.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor12.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost22.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor22.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost32.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor32.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost42.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor42.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost52.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor52.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost62.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor62.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost72.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor72.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost82.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor82.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost92.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor92.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost102.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor102.getText().toString().replaceAll("[^0-9]+", ""));
            int totalY3 = Integer.parseInt(cost13.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor13.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost23.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor23.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost33.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor33.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost43.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor43.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost53.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor53.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost63.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor63.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost73.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor73.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost83.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor83.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost93.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor93.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost103.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor103.getText().toString().replaceAll("[^0-9]+", ""));
            int totalY4 = Integer.parseInt(cost14.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor14.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost24.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor24.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost34.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor34.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost44.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor44.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost54.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor54.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost64.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor64.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost74.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor74.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost84.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor84.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost94.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor94.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost104.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor104.getText().toString().replaceAll("[^0-9]+", ""));
            int totalY5 = Integer.parseInt(cost15.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor15.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost25.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor25.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost35.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor35.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost45.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor45.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost55.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor55.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost65.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor65.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost75.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor75.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost85.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor85.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost95.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor95.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost105.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor105.getText().toString().replaceAll("[^0-9]+", ""));
            int totalY6 = Integer.parseInt(cost16.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor16.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost26.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor26.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost36.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor36.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost46.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor46.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost56.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor56.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost66.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor66.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost76.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor76.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost86.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor86.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost96.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor96.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost106.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor106.getText().toString().replaceAll("[^0-9]+", ""));
            int totalY7 = Integer.parseInt(cost17.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor17.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost27.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor27.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost37.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor37.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost47.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor47.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost57.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor57.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost67.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor67.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost77.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor77.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost87.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor87.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost97.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor97.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost107.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor107.getText().toString().replaceAll("[^0-9]+", ""));
            setText((TextView) findViewById(R.id.foundsNeededY0_field), String.valueOf(dec.format(totalY0)));
            setText((TextView) findViewById(R.id.foundsNeededY1_field), String.valueOf(dec.format(totalY1)));
            setText((TextView) findViewById(R.id.foundsNeededY2_field), String.valueOf(dec.format(totalY2)));
            setText((TextView) findViewById(R.id.foundsNeededY3_field), String.valueOf(dec.format(totalY3)));
            setText((TextView) findViewById(R.id.foundsNeededY4_field), String.valueOf(dec.format(totalY4)));
            setText((TextView) findViewById(R.id.foundsNeededY5_field), String.valueOf(dec.format(totalY5)));
            setText((TextView) findViewById(R.id.foundsNeededY6_field), String.valueOf(dec.format(totalY6)));
            setText((TextView) findViewById(R.id.foundsNeededY7_field), String.valueOf(dec.format(totalY7)));

            //profit or lost
            int pl0 = availableY0-totalY0;
            int pl1 = availableY1-totalY1;
            int pl2 = availableY2-totalY2;
            int pl3 = availableY3-totalY3;
            int pl4 = availableY4-totalY4;
            int pl5 = availableY5-totalY5;
            int pl6 = availableY6-totalY6;
            int pl7 = availableY7-totalY7;
            setText((TextView) findViewById(R.id.profitOrLostY0_field), String.valueOf(dec.format(pl0)));
            if(pl0 > 0){
                pyl0.setTextColor(Color.parseColor("#29a329"));
            }else{
                pyl0.setTextColor(Color.parseColor("#cc0000"));
            }
            setText((TextView) findViewById(R.id.profitOrLostY1_field), String.valueOf(dec.format(pl1)));
            if(pl1 > 0){
                pyl1.setTextColor(Color.parseColor("#29a329"));
            }else{
                pyl1.setTextColor(Color.parseColor("#cc0000"));
            }
            setText((TextView) findViewById(R.id.profitOrLostY2_field), String.valueOf(dec.format(pl2)));
            if(pl2 > 0){
                pyl2.setTextColor(Color.parseColor("#29a329"));
            }else{
                pyl2.setTextColor(Color.parseColor("#cc0000"));
            }
            setText((TextView) findViewById(R.id.profitOrLostY3_field), String.valueOf(dec.format(pl3)));
            if(pl3 > 0){
                pyl3.setTextColor(Color.parseColor("#29a329"));
            }else{
                pyl3.setTextColor(Color.parseColor("#cc0000"));
            }
            setText((TextView) findViewById(R.id.profitOrLostY4_field), String.valueOf(dec.format(pl4)));
            if(pl4 > 0){
                pyl4.setTextColor(Color.parseColor("#29a329"));
            }else{
                pyl4.setTextColor(Color.parseColor("#cc0000"));
            }
            setText((TextView) findViewById(R.id.profitOrLostY5_field), String.valueOf(dec.format(pl5)));
            if(pl5 > 0){
                pyl5.setTextColor(Color.parseColor("#29a329"));
            }else{
                pyl5.setTextColor(Color.parseColor("#cc0000"));
            }
            setText((TextView) findViewById(R.id.profitOrLostY6_field), String.valueOf(dec.format(pl6)));
            if(pl6 > 0){
                pyl6.setTextColor(Color.parseColor("#29a329"));
            }else{
                pyl6.setTextColor(Color.parseColor("#cc0000"));
            }
            setText((TextView) findViewById(R.id.profitOrLostY7_field), String.valueOf(dec.format(pl7)));
            if(pl7 > 0){
                pyl7.setTextColor(Color.parseColor("#29a329"));
            }else{
                pyl7.setTextColor(Color.parseColor("#cc0000"));
            }


            //savings and investments
            double hhSavings = 0;
            if (sObject.getHouseholdsavings().isEmpty()){
                hhSavings = 0;
            }else {
                hhSavings = Double.parseDouble(sObject.getHouseholdsavings());
            }

            double hhInvestments = 0;
            if (sObject.getPlannedinvestments().isEmpty()){
                hhInvestments = 0;
            }else {
                hhInvestments = Double.parseDouble(sObject.getPlannedinvestments());
            }

            setText((TextView) findViewById(R.id.savings_field), String.valueOf(dec.format(hhSavings)));
            setText((TextView) findViewById(R.id.investments_field), String.valueOf(dec.format(hhInvestments)));
        }
    }

    private void setText(TextView textField, String text) {
        if (textField != null) {
            textField.setText(text);
        }
    }

    private void save() {
        final String start1 = (st1.getSelectedItem().toString());
        final String start2 = (st2.getSelectedItem().toString());
        final String start3 = (st3.getSelectedItem().toString());
        final String start4 = (st4.getSelectedItem().toString());
        final String start5 = (st5.getSelectedItem().toString());
        final String start6 = (st6.getSelectedItem().toString());
        final String start7 = (st7.getSelectedItem().toString());
        final String start8 = (st8.getSelectedItem().toString());
        final String start9 = (st9.getSelectedItem().toString());
        final String start10 = (st10.getSelectedItem().toString());
        final String agree = ((Spinner) findViewById(R.id.farmerAgree_field)).getSelectedItem().toString();
        final String coments = ((EditText) findViewById(R.id.reasonNotAgree_field)).getText().toString()+comt1.getText().toString()+comt2.getText().toString()+comt3.getText().toString()+comt4.getText().toString()+comt4.getText().toString()+comt5.getText().toString()+comt6.getText().toString()+comt7.getText().toString()+comt8.getText().toString()+comt9.getText().toString()+comt10.getText().toString();
        final SmartStore smartStore = SmartSyncSDKManager.getInstance().getSmartStore(curAccount);
        JSONObject contact;
        try {
            boolean isCreate = TextUtils.isEmpty(objectId);
            if (!isCreate) {
                contact = smartStore.retrieve(ContactListLoader.CONTACT_SOUP,
                        smartStore.lookupSoupEntryId(ContactListLoader.CONTACT_SOUP,
                                Constants.ID, objectId)).getJSONObject(0);
            } else {
                contact = new JSONObject();
                contact.put(Constants.ID, "local_" + System.currentTimeMillis()
                        + Constants.EMPTY_STRING);
                final JSONObject attributes = new JSONObject();
                attributes.put(Constants.TYPE.toLowerCase(), Constants.SUBMISSION);
                contact.put(Constants.ATTRIBUTES, attributes);
            }
            contact.put(ContactObject.STARTYEARP1,start1);
            contact.put(ContactObject.STARTYEARP2,start2);
            contact.put(ContactObject.STARTYEARP3,start3);
            contact.put(ContactObject.STARTYEARP4,start4);
            contact.put(ContactObject.STARTYEARP5,start5);
            contact.put(ContactObject.STARTYEARP6,start6);
            contact.put(ContactObject.STARTYEARP7,start7);
            contact.put(ContactObject.STARTYEARP8,start8);
            contact.put(ContactObject.STARTYEARP9,start9);
            contact.put(ContactObject.STARTYEARP10,start10);
            contact.put(ContactObject.AGREERECOMENDATIONS,agree);
            contact.put(ContactObject.FARMERCOMMENTS,coments);
            contact.put(SyncManager.LOCAL, true);
            contact.put(SyncManager.LOCALLY_UPDATED, !isCreate);
            contact.put(SyncManager.LOCALLY_CREATED, isCreate);
            contact.put(SyncManager.LOCALLY_DELETED, false);
            if (isCreate) {
                smartStore.create(ContactListLoader.CONTACT_SOUP, contact);
            } else {
                smartStore.upsert(ContactListLoader.CONTACT_SOUP, contact);
            }
            Toast.makeText(this, this.getString(R.string.saved), Toast.LENGTH_SHORT).show();
            finish();
        } catch (JSONException e) {
            Log.e(TAG, "JSONException occurred while parsing", e);
        }
    }
}
