package org.grameenfoundation.fdp.ui;

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

import org.grameenfoundation.fdp.MainActivity;
import org.grameenfoundation.fdp.R;
import org.grameenfoundation.fdp.loaders.ContactDetailLoader;
import org.grameenfoundation.fdp.loaders.ContactListLoader;
import org.grameenfoundation.fdp.objects.ContactObject;
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
    private TextView found1,found2,found3,found4,found5,found6,found7,pyl1,pyl2,pyl3,pyl4,pyl5,pyl6,pyl7,plot1,plot2,plot3,plot4,plot5,plot6,plot7,plot8,plot9,plot10,income11,income21,income31,income41,income51,income61,income71,income81,income91,income101,income12,income22,income32,income42,income52,income62,income72,income82,income92,income102,income13,income23,income33,income43,income53,income63,income73,income83,income93,income103,income14,income24,income34,income44,income54,income64,income74,income84,income94,income104,income15,income25,income35,income45,income55,income65,income75,income85,income95,income105,income16,income26,income36,income46,income56,income66,income76,income86,income96,income106,income17,income27,income37,income47,income57,income67,income77,income87,income97,income107,cost11,labor11,cost21,labor21,cost31,labor31,cost41,labor41,cost51,labor51,cost61,labor61,cost71,labor71,cost81,labor81,cost91,labor91,cost101,labor101,cost12,labor12,cost22,labor22,cost32,labor32,cost42,labor42,cost52,labor52,cost62,labor62,cost72,labor72,cost82,labor82,cost92,labor92,cost102,labor102,cost13,labor13,cost23,labor23,cost33,labor33,cost43,labor43,cost53,labor53,cost63,labor63,cost73,labor73,cost83,labor83,cost93,labor93,cost103,labor103,cost14,labor14,cost24,labor24,cost34,labor34,cost44,labor44,cost54,labor54,cost64,labor64,cost74,labor74,cost84,labor84,cost94,labor94,cost104,labor104,cost15,labor15,cost25,labor25,cost35,labor35,cost45,labor45,cost55,labor55,cost65,labor65,cost75,labor75,cost85,labor85,cost95,labor95,cost105,labor105,cost16,labor16,cost26,labor26,cost36,labor36,cost46,labor46,cost56,labor56,cost66,labor66,cost76,labor76,cost86,labor86,cost96,labor96,cost106,labor106,cost17,labor17,cost27,labor27,cost37,labor37,cost47,labor47,cost57,labor57,cost67,labor67,cost77,labor77,cost87,labor87,cost97,labor97,cost107,labor107;
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
        income11 =(TextView) fragment1.getView().findViewById(R.id.incomeY1P);
        income12 =(TextView) fragment1.getView().findViewById(R.id.incomeY2P);
        income13 =(TextView) fragment1.getView().findViewById(R.id.incomeY3P);
        income14 =(TextView) fragment1.getView().findViewById(R.id.incomeY4P);
        income15 =(TextView) fragment1.getView().findViewById(R.id.incomeY5P);
        income16 =(TextView) fragment1.getView().findViewById(R.id.incomeY6P);
        income17 =(TextView) fragment1.getView().findViewById(R.id.incomeY7P);
        cost11 =(TextView) fragment1.getView().findViewById(R.id.costY1P);
        cost12 =(TextView) fragment1.getView().findViewById(R.id.costY2P);
        cost13 =(TextView) fragment1.getView().findViewById(R.id.costY3P);
        cost14 =(TextView) fragment1.getView().findViewById(R.id.costY4P);
        cost15 =(TextView) fragment1.getView().findViewById(R.id.costY5P);
        cost16 =(TextView) fragment1.getView().findViewById(R.id.costY6P);
        cost17 =(TextView) fragment1.getView().findViewById(R.id.costY7P);
        labor11 =(TextView) fragment1.getView().findViewById(R.id.laborY1P);
        labor12 =(TextView) fragment1.getView().findViewById(R.id.laborY2P);
        labor13 =(TextView) fragment1.getView().findViewById(R.id.laborY3P);
        labor14 =(TextView) fragment1.getView().findViewById(R.id.laborY4P);
        labor15 =(TextView) fragment1.getView().findViewById(R.id.laborY5P);
        labor16 =(TextView) fragment1.getView().findViewById(R.id.laborY6P);
        labor17 =(TextView) fragment1.getView().findViewById(R.id.laborY7P);
        income21 =(TextView) fragment2.getView().findViewById(R.id.incomeY1P);
        income22 =(TextView) fragment2.getView().findViewById(R.id.incomeY2P);
        income23 =(TextView) fragment2.getView().findViewById(R.id.incomeY3P);
        income24 =(TextView) fragment2.getView().findViewById(R.id.incomeY4P);
        income25 =(TextView) fragment2.getView().findViewById(R.id.incomeY5P);
        income26 =(TextView) fragment2.getView().findViewById(R.id.incomeY6P);
        income27 =(TextView) fragment2.getView().findViewById(R.id.incomeY7P);
        cost21 =(TextView) fragment2.getView().findViewById(R.id.costY1P);
        cost22 =(TextView) fragment2.getView().findViewById(R.id.costY2P);
        cost23 =(TextView) fragment2.getView().findViewById(R.id.costY3P);
        cost24 =(TextView) fragment2.getView().findViewById(R.id.costY4P);
        cost25 =(TextView) fragment2.getView().findViewById(R.id.costY5P);
        cost26 =(TextView) fragment2.getView().findViewById(R.id.costY6P);
        cost27 =(TextView) fragment2.getView().findViewById(R.id.costY7P);
        labor21 =(TextView) fragment2.getView().findViewById(R.id.laborY1P);
        labor22 =(TextView) fragment2.getView().findViewById(R.id.laborY2P);
        labor23 =(TextView) fragment2.getView().findViewById(R.id.laborY3P);
        labor24 =(TextView) fragment2.getView().findViewById(R.id.laborY4P);
        labor25 =(TextView) fragment2.getView().findViewById(R.id.laborY5P);
        labor26 =(TextView) fragment2.getView().findViewById(R.id.laborY6P);
        labor27 =(TextView) fragment2.getView().findViewById(R.id.laborY7P);
        income31 =(TextView) fragment3.getView().findViewById(R.id.incomeY1P);
        income32 =(TextView) fragment3.getView().findViewById(R.id.incomeY2P);
        income33 =(TextView) fragment3.getView().findViewById(R.id.incomeY3P);
        income34 =(TextView) fragment3.getView().findViewById(R.id.incomeY4P);
        income35 =(TextView) fragment3.getView().findViewById(R.id.incomeY5P);
        income36 =(TextView) fragment3.getView().findViewById(R.id.incomeY6P);
        income37 =(TextView) fragment3.getView().findViewById(R.id.incomeY7P);
        cost31 =(TextView) fragment3.getView().findViewById(R.id.costY1P);
        cost32 =(TextView) fragment3.getView().findViewById(R.id.costY2P);
        cost33 =(TextView) fragment3.getView().findViewById(R.id.costY3P);
        cost34 =(TextView) fragment3.getView().findViewById(R.id.costY4P);
        cost35 =(TextView) fragment3.getView().findViewById(R.id.costY5P);
        cost36 =(TextView) fragment3.getView().findViewById(R.id.costY6P);
        cost37 =(TextView) fragment3.getView().findViewById(R.id.costY7P);
        labor31 =(TextView) fragment3.getView().findViewById(R.id.laborY1P);
        labor32 =(TextView) fragment3.getView().findViewById(R.id.laborY2P);
        labor33 =(TextView) fragment3.getView().findViewById(R.id.laborY3P);
        labor34 =(TextView) fragment3.getView().findViewById(R.id.laborY4P);
        labor35 =(TextView) fragment3.getView().findViewById(R.id.laborY5P);
        labor36 =(TextView) fragment3.getView().findViewById(R.id.laborY6P);
        labor37 =(TextView) fragment3.getView().findViewById(R.id.laborY7P);
        income41 =(TextView) fragment4.getView().findViewById(R.id.incomeY1P);
        income42 =(TextView) fragment4.getView().findViewById(R.id.incomeY2P);
        income43 =(TextView) fragment4.getView().findViewById(R.id.incomeY3P);
        income44 =(TextView) fragment4.getView().findViewById(R.id.incomeY4P);
        income45 =(TextView) fragment4.getView().findViewById(R.id.incomeY5P);
        income46 =(TextView) fragment4.getView().findViewById(R.id.incomeY6P);
        income47 =(TextView) fragment4.getView().findViewById(R.id.incomeY7P);
        cost41 =(TextView) fragment4.getView().findViewById(R.id.costY1P);
        cost42 =(TextView) fragment4.getView().findViewById(R.id.costY2P);
        cost43 =(TextView) fragment4.getView().findViewById(R.id.costY3P);
        cost44 =(TextView) fragment4.getView().findViewById(R.id.costY4P);
        cost45 =(TextView) fragment4.getView().findViewById(R.id.costY5P);
        cost46 =(TextView) fragment4.getView().findViewById(R.id.costY6P);
        cost47 =(TextView) fragment4.getView().findViewById(R.id.costY7P);
        labor41 =(TextView) fragment4.getView().findViewById(R.id.laborY1P);
        labor42 =(TextView) fragment4.getView().findViewById(R.id.laborY2P);
        labor43 =(TextView) fragment4.getView().findViewById(R.id.laborY3P);
        labor44 =(TextView) fragment4.getView().findViewById(R.id.laborY4P);
        labor45 =(TextView) fragment4.getView().findViewById(R.id.laborY5P);
        labor46 =(TextView) fragment4.getView().findViewById(R.id.laborY6P);
        labor47 =(TextView) fragment4.getView().findViewById(R.id.laborY7P);
        income51 =(TextView) fragment5.getView().findViewById(R.id.incomeY1P);
        income52 =(TextView) fragment5.getView().findViewById(R.id.incomeY2P);
        income53 =(TextView) fragment5.getView().findViewById(R.id.incomeY3P);
        income54 =(TextView) fragment5.getView().findViewById(R.id.incomeY4P);
        income55 =(TextView) fragment5.getView().findViewById(R.id.incomeY5P);
        income56 =(TextView) fragment5.getView().findViewById(R.id.incomeY6P);
        income57 =(TextView) fragment5.getView().findViewById(R.id.incomeY7P);
        cost51 =(TextView) fragment5.getView().findViewById(R.id.costY1P);
        cost52 =(TextView) fragment5.getView().findViewById(R.id.costY2P);
        cost53 =(TextView) fragment5.getView().findViewById(R.id.costY3P);
        cost54 =(TextView) fragment5.getView().findViewById(R.id.costY4P);
        cost55 =(TextView) fragment5.getView().findViewById(R.id.costY5P);
        cost56 =(TextView) fragment5.getView().findViewById(R.id.costY6P);
        cost57 =(TextView) fragment5.getView().findViewById(R.id.costY7P);
        labor51 =(TextView) fragment5.getView().findViewById(R.id.laborY1P);
        labor52 =(TextView) fragment5.getView().findViewById(R.id.laborY2P);
        labor53 =(TextView) fragment5.getView().findViewById(R.id.laborY3P);
        labor54 =(TextView) fragment5.getView().findViewById(R.id.laborY4P);
        labor55 =(TextView) fragment5.getView().findViewById(R.id.laborY5P);
        labor56 =(TextView) fragment5.getView().findViewById(R.id.laborY6P);
        labor57 =(TextView) fragment5.getView().findViewById(R.id.laborY7P);
        income61 =(TextView) fragment6.getView().findViewById(R.id.incomeY1P);
        income62 =(TextView) fragment6.getView().findViewById(R.id.incomeY2P);
        income63 =(TextView) fragment6.getView().findViewById(R.id.incomeY3P);
        income64 =(TextView) fragment6.getView().findViewById(R.id.incomeY4P);
        income65 =(TextView) fragment6.getView().findViewById(R.id.incomeY5P);
        income66 =(TextView) fragment6.getView().findViewById(R.id.incomeY6P);
        income67 =(TextView) fragment6.getView().findViewById(R.id.incomeY7P);
        cost61 =(TextView) fragment6.getView().findViewById(R.id.costY1P);
        cost62 =(TextView) fragment6.getView().findViewById(R.id.costY2P);
        cost63 =(TextView) fragment6.getView().findViewById(R.id.costY3P);
        cost64 =(TextView) fragment6.getView().findViewById(R.id.costY4P);
        cost65 =(TextView) fragment6.getView().findViewById(R.id.costY5P);
        cost66 =(TextView) fragment6.getView().findViewById(R.id.costY6P);
        cost67 =(TextView) fragment6.getView().findViewById(R.id.costY7P);
        labor61 =(TextView) fragment6.getView().findViewById(R.id.laborY1P);
        labor62 =(TextView) fragment6.getView().findViewById(R.id.laborY2P);
        labor63 =(TextView) fragment6.getView().findViewById(R.id.laborY3P);
        labor64 =(TextView) fragment6.getView().findViewById(R.id.laborY4P);
        labor65 =(TextView) fragment6.getView().findViewById(R.id.laborY5P);
        labor66 =(TextView) fragment6.getView().findViewById(R.id.laborY6P);
        labor67 =(TextView) fragment6.getView().findViewById(R.id.laborY7P);
        income71 =(TextView) fragment7.getView().findViewById(R.id.incomeY1P);
        income72 =(TextView) fragment7.getView().findViewById(R.id.incomeY2P);
        income73 =(TextView) fragment7.getView().findViewById(R.id.incomeY3P);
        income74 =(TextView) fragment7.getView().findViewById(R.id.incomeY4P);
        income75 =(TextView) fragment7.getView().findViewById(R.id.incomeY5P);
        income76 =(TextView) fragment7.getView().findViewById(R.id.incomeY6P);
        income77 =(TextView) fragment7.getView().findViewById(R.id.incomeY7P);
        cost71 =(TextView) fragment7.getView().findViewById(R.id.costY1P);
        cost72 =(TextView) fragment7.getView().findViewById(R.id.costY2P);
        cost73 =(TextView) fragment7.getView().findViewById(R.id.costY3P);
        cost74 =(TextView) fragment7.getView().findViewById(R.id.costY4P);
        cost75 =(TextView) fragment7.getView().findViewById(R.id.costY5P);
        cost76 =(TextView) fragment7.getView().findViewById(R.id.costY6P);
        cost77 =(TextView) fragment7.getView().findViewById(R.id.costY7P);
        labor71 =(TextView) fragment7.getView().findViewById(R.id.laborY1P);
        labor72 =(TextView) fragment7.getView().findViewById(R.id.laborY2P);
        labor73 =(TextView) fragment7.getView().findViewById(R.id.laborY3P);
        labor74 =(TextView) fragment7.getView().findViewById(R.id.laborY4P);
        labor75 =(TextView) fragment7.getView().findViewById(R.id.laborY5P);
        labor76 =(TextView) fragment7.getView().findViewById(R.id.laborY6P);
        labor77 =(TextView) fragment7.getView().findViewById(R.id.laborY7P);
        income81 =(TextView) fragment8.getView().findViewById(R.id.incomeY1P);
        income82 =(TextView) fragment8.getView().findViewById(R.id.incomeY2P);
        income83 =(TextView) fragment8.getView().findViewById(R.id.incomeY3P);
        income84 =(TextView) fragment8.getView().findViewById(R.id.incomeY4P);
        income85 =(TextView) fragment8.getView().findViewById(R.id.incomeY5P);
        income86 =(TextView) fragment8.getView().findViewById(R.id.incomeY6P);
        income87 =(TextView) fragment8.getView().findViewById(R.id.incomeY7P);
        cost81 =(TextView) fragment8.getView().findViewById(R.id.costY1P);
        cost82 =(TextView) fragment8.getView().findViewById(R.id.costY2P);
        cost83 =(TextView) fragment8.getView().findViewById(R.id.costY3P);
        cost84 =(TextView) fragment8.getView().findViewById(R.id.costY4P);
        cost85 =(TextView) fragment8.getView().findViewById(R.id.costY5P);
        cost86 =(TextView) fragment8.getView().findViewById(R.id.costY6P);
        cost87 =(TextView) fragment8.getView().findViewById(R.id.costY7P);
        labor81 =(TextView) fragment8.getView().findViewById(R.id.laborY1P);
        labor82 =(TextView) fragment8.getView().findViewById(R.id.laborY2P);
        labor83 =(TextView) fragment8.getView().findViewById(R.id.laborY3P);
        labor84 =(TextView) fragment8.getView().findViewById(R.id.laborY4P);
        labor85 =(TextView) fragment8.getView().findViewById(R.id.laborY5P);
        labor86 =(TextView) fragment8.getView().findViewById(R.id.laborY6P);
        labor87 =(TextView) fragment8.getView().findViewById(R.id.laborY7P);
        income91 =(TextView) fragment9.getView().findViewById(R.id.incomeY1P);
        income92 =(TextView) fragment9.getView().findViewById(R.id.incomeY2P);
        income93 =(TextView) fragment9.getView().findViewById(R.id.incomeY3P);
        income94 =(TextView) fragment9.getView().findViewById(R.id.incomeY4P);
        income95 =(TextView) fragment9.getView().findViewById(R.id.incomeY5P);
        income96 =(TextView) fragment9.getView().findViewById(R.id.incomeY6P);
        income97 =(TextView) fragment9.getView().findViewById(R.id.incomeY7P);
        cost91 =(TextView) fragment9.getView().findViewById(R.id.costY1P);
        cost92 =(TextView) fragment9.getView().findViewById(R.id.costY2P);
        cost93 =(TextView) fragment9.getView().findViewById(R.id.costY3P);
        cost94 =(TextView) fragment9.getView().findViewById(R.id.costY4P);
        cost95 =(TextView) fragment9.getView().findViewById(R.id.costY5P);
        cost96 =(TextView) fragment9.getView().findViewById(R.id.costY6P);
        cost97 =(TextView) fragment9.getView().findViewById(R.id.costY7P);
        labor91 =(TextView) fragment9.getView().findViewById(R.id.laborY1P);
        labor92 =(TextView) fragment9.getView().findViewById(R.id.laborY2P);
        labor93 =(TextView) fragment9.getView().findViewById(R.id.laborY3P);
        labor94 =(TextView) fragment9.getView().findViewById(R.id.laborY4P);
        labor95 =(TextView) fragment9.getView().findViewById(R.id.laborY5P);
        labor96 =(TextView) fragment9.getView().findViewById(R.id.laborY6P);
        labor97 =(TextView) fragment9.getView().findViewById(R.id.laborY7P);
        income101 =(TextView) fragment10.getView().findViewById(R.id.incomeY1P);
        income102 =(TextView) fragment10.getView().findViewById(R.id.incomeY2P);
        income103 =(TextView) fragment10.getView().findViewById(R.id.incomeY3P);
        income104 =(TextView) fragment10.getView().findViewById(R.id.incomeY4P);
        income105 =(TextView) fragment10.getView().findViewById(R.id.incomeY5P);
        income106 =(TextView) fragment10.getView().findViewById(R.id.incomeY6P);
        income107 =(TextView) fragment10.getView().findViewById(R.id.incomeY7P);
        cost101 =(TextView) fragment10.getView().findViewById(R.id.costY1P);
        cost102 =(TextView) fragment10.getView().findViewById(R.id.costY2P);
        cost103 =(TextView) fragment10.getView().findViewById(R.id.costY3P);
        cost104 =(TextView) fragment10.getView().findViewById(R.id.costY4P);
        cost105 =(TextView) fragment10.getView().findViewById(R.id.costY5P);
        cost106 =(TextView) fragment10.getView().findViewById(R.id.costY6P);
        cost107 =(TextView) fragment10.getView().findViewById(R.id.costY7P);
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

        found1 = (TextView)findViewById(R.id.netFamilyY1_field);
        found2 = (TextView)findViewById(R.id.netFamilyY2_field);
        found3 = (TextView)findViewById(R.id.netFamilyY3_field);
        found4 = (TextView)findViewById(R.id.netFamilyY4_field);
        found5 = (TextView)findViewById(R.id.netFamilyY5_field);
        found6 = (TextView)findViewById(R.id.netFamilyY6_field);
        found7 = (TextView)findViewById(R.id.netFamilyY7_field);
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
            if (sObject.getAgreeRecomendations().contentEquals("Yes")||sObject.getAgreeRecomendations().contentEquals("Ya")) {
                Spinner spinner = (Spinner) findViewById(R.id.farmerAgree_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yes, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getAgreeRecomendations().contentEquals("No")||sObject.getAgreeRecomendations().contentEquals("Tidak")) {
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

            setText(comments,sObject.getReasonNotAgreed());

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
            }else if (sObject.getStartYearP1().contentEquals("Year 1")||sObject.getStartYearP1().contentEquals("Tahun 1")) {
                Spinner spinner = st1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP1().contentEquals("Year 2")||sObject.getStartYearP1().contentEquals("Tahun 2")) {
                Spinner spinner = st1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP1().contentEquals("Year 3")||sObject.getStartYearP1().contentEquals("Tahun 3")) {
                Spinner spinner = st1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP1().contentEquals("Year 4")||sObject.getStartYearP1().contentEquals("Tahun 4")) {
                Spinner spinner = st1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP1().contentEquals("Year 5")||sObject.getStartYearP1().contentEquals("Tahun 5")) {
                Spinner spinner = st1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP1().contentEquals("Year 6")||sObject.getStartYearP1().contentEquals("Tahun 6")) {
                Spinner spinner = st1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year6, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP1().contentEquals("Year 7")||sObject.getStartYearP1().contentEquals("Tahun 7")) {
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
            }else if (sObject.getStartYearP2().contentEquals("Year 1")||sObject.getStartYearP2().contentEquals("Tahun 1")) {
                Spinner spinner = st2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP2().contentEquals("Year 2")||sObject.getStartYearP2().contentEquals("Tahun 2")) {
                Spinner spinner = st2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP2().contentEquals("Year 3")||sObject.getStartYearP2().contentEquals("Tahun 3")) {
                Spinner spinner = st2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP2().contentEquals("Year 4")||sObject.getStartYearP2().contentEquals("Tahun 4")) {
                Spinner spinner = st2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP2().contentEquals("Year 5")||sObject.getStartYearP2().contentEquals("Tahun 5")) {
                Spinner spinner = st2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP2().contentEquals("Year 6")||sObject.getStartYearP2().contentEquals("Tahun 6")) {
                Spinner spinner = st2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year6, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP2().contentEquals("Year 7")||sObject.getStartYearP2().contentEquals("Tahun 7")) {
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
            }else if (sObject.getStartYearP3().contentEquals("Year 1")||sObject.getStartYearP3().contentEquals("Tahun 1")) {
                Spinner spinner = st3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP3().contentEquals("Year 2")||sObject.getStartYearP3().contentEquals("Tahun 2")) {
                Spinner spinner = st3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP3().contentEquals("Year 3")||sObject.getStartYearP3().contentEquals("Tahun 3")) {
                Spinner spinner = st3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP3().contentEquals("Year 4")||sObject.getStartYearP3().contentEquals("Tahun 4")) {
                Spinner spinner = st3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP3().contentEquals("Year 5")||sObject.getStartYearP3().contentEquals("Tahun 5")) {
                Spinner spinner = st3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP3().contentEquals("Year 6")||sObject.getStartYearP3().contentEquals("Tahun 6")) {
                Spinner spinner = st3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year6, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP3().contentEquals("Year 7")||sObject.getStartYearP3().contentEquals("Tahun 7")) {
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
            }else if (sObject.getStartYearP4().contentEquals("Year 1")||sObject.getStartYearP4().contentEquals("Tahun 1")) {
                Spinner spinner = st4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP4().contentEquals("Year 2")||sObject.getStartYearP4().contentEquals("Tahun 2")) {
                Spinner spinner = st4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP4().contentEquals("Year 3")||sObject.getStartYearP4().contentEquals("Tahun 3")) {
                Spinner spinner = st4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP4().contentEquals("Year 4")||sObject.getStartYearP4().contentEquals("Tahun 4")) {
                Spinner spinner = st4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP4().contentEquals("Year 5")||sObject.getStartYearP4().contentEquals("Tahun 5")) {
                Spinner spinner = st4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP4().contentEquals("Year 6")||sObject.getStartYearP4().contentEquals("Tahun 6")) {
                Spinner spinner = st4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year6, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP4().contentEquals("Year 7")||sObject.getStartYearP4().contentEquals("Tahun 7")) {
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
            }else if (sObject.getStartYearP5().contentEquals("Year 1")||sObject.getStartYearP5().contentEquals("Tahun 1")) {
                Spinner spinner = st5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP5().contentEquals("Year 2")||sObject.getStartYearP5().contentEquals("Tahun 2")) {
                Spinner spinner = st5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP5().contentEquals("Year 3")||sObject.getStartYearP5().contentEquals("Tahun 3")) {
                Spinner spinner = st5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP5().contentEquals("Year 4")||sObject.getStartYearP5().contentEquals("Tahun 4")) {
                Spinner spinner = st5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP5().contentEquals("Year 5")||sObject.getStartYearP5().contentEquals("Tahun 5")) {
                Spinner spinner = st5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP5().contentEquals("Year 6")||sObject.getStartYearP5().contentEquals("Tahun 6")) {
                Spinner spinner = st5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year6, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP5().contentEquals("Year 7")||sObject.getStartYearP5().contentEquals("Tahun 7")) {
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
            }else if (sObject.getStartYearP6().contentEquals("Year 1")||sObject.getStartYearP6().contentEquals("Tahun 1")) {
                Spinner spinner = st6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP6().contentEquals("Year 2")||sObject.getStartYearP6().contentEquals("Tahun 2")) {
                Spinner spinner = st6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP6().contentEquals("Year 3")||sObject.getStartYearP6().contentEquals("Tahun 3")) {
                Spinner spinner = st6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP6().contentEquals("Year 4")||sObject.getStartYearP6().contentEquals("Tahun 4")) {
                Spinner spinner = st6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP6().contentEquals("Year 5")||sObject.getStartYearP6().contentEquals("Tahun 5")) {
                Spinner spinner = st6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP6().contentEquals("Year 6")||sObject.getStartYearP6().contentEquals("Tahun 6")) {
                Spinner spinner = st6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year6, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP6().contentEquals("Year 7")||sObject.getStartYearP6().contentEquals("Tahun 7")) {
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
            }else if (sObject.getStartYearP7().contentEquals("Year 1")||sObject.getStartYearP7().contentEquals("Tahun 1")) {
                Spinner spinner = st7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP7().contentEquals("Year 2")||sObject.getStartYearP7().contentEquals("Tahun 2")) {
                Spinner spinner = st7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP7().contentEquals("Year 3")||sObject.getStartYearP7().contentEquals("Tahun 3")) {
                Spinner spinner = st7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP7().contentEquals("Year 4")||sObject.getStartYearP7().contentEquals("Tahun 4")) {
                Spinner spinner = st7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP7().contentEquals("Year 5")||sObject.getStartYearP7().contentEquals("Tahun 5")) {
                Spinner spinner = st7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP7().contentEquals("Year 6")||sObject.getStartYearP7().contentEquals("Tahun 6")) {
                Spinner spinner = st7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year6, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP7().contentEquals("Year 7")||sObject.getStartYearP7().contentEquals("Tahun 7")) {
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
            }else if (sObject.getStartYearP8().contentEquals("Year 1")||sObject.getStartYearP8().contentEquals("Tahun 1")) {
                Spinner spinner = st8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP8().contentEquals("Year 2")||sObject.getStartYearP8().contentEquals("Tahun 2")) {
                Spinner spinner = st8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP8().contentEquals("Year 3")||sObject.getStartYearP8().contentEquals("Tahun 3")) {
                Spinner spinner = st8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP8().contentEquals("Year 4")||sObject.getStartYearP8().contentEquals("Tahun 4")) {
                Spinner spinner = st8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP8().contentEquals("Year 5")||sObject.getStartYearP8().contentEquals("Tahun 5")) {
                Spinner spinner = st8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP8().contentEquals("Year 6")||sObject.getStartYearP8().contentEquals("Tahun 6")) {
                Spinner spinner = st8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year6, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP8().contentEquals("Year 7")||sObject.getStartYearP8().contentEquals("Tahun 7")) {
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
            }else if (sObject.getStartYearP9().contentEquals("Year 1")||sObject.getStartYearP9().contentEquals("Tahun 1")) {
                Spinner spinner = st9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP9().contentEquals("Year 2")||sObject.getStartYearP9().contentEquals("Tahun 2")) {
                Spinner spinner = st9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP9().contentEquals("Year 3")||sObject.getStartYearP9().contentEquals("Tahun 3")) {
                Spinner spinner = st9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP9().contentEquals("Year 4")||sObject.getStartYearP9().contentEquals("Tahun 4")) {
                Spinner spinner = st9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP9().contentEquals("Year 5")||sObject.getStartYearP9().contentEquals("Tahun 5")) {
                Spinner spinner = st9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP9().contentEquals("Year 6")||sObject.getStartYearP9().contentEquals("Tahun 6")) {
                Spinner spinner = st9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year6, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP9().contentEquals("Year 7")||sObject.getStartYearP9().contentEquals("Tahun 7")) {
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
            }else if (sObject.getStartYearP10().contentEquals("Year 1")||sObject.getStartYearP10().contentEquals("Tahun 1")) {
                Spinner spinner = st10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP10().contentEquals("Year 2")||sObject.getStartYearP10().contentEquals("Tahun 2")) {
                Spinner spinner = st10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP10().contentEquals("Year 3")||sObject.getStartYearP10().contentEquals("Tahun 3")) {
                Spinner spinner = st10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP10().contentEquals("Year 4")||sObject.getStartYearP10().contentEquals("Tahun 4")) {
                Spinner spinner = st10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP10().contentEquals("Year 5")||sObject.getStartYearP10().contentEquals("Tahun 5")) {
                Spinner spinner = st10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP10().contentEquals("Year 6")||sObject.getStartYearP10().contentEquals("Tahun 6")) {
                Spinner spinner = st10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.year6, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getStartYearP10().contentEquals("Year 7")||sObject.getStartYearP10().contentEquals("Tahun 7")) {
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

            double plot1Area = Double.valueOf(sObject.getPlot1Area());
            double plot2Area = Double.valueOf(sObject.getPlot2Area());
            double plot3Area = Double.valueOf(sObject.getPlot3Area());
            double plot4Area = Double.valueOf(sObject.getPlot4Area());
            double plot5Area = Double.valueOf(sObject.getPlot5Area());
            double plot6Area = Double.valueOf(sObject.getPlot6Area());
            double plot7Area = Double.valueOf(sObject.getPlot7Area());
            double plot8Area = Double.valueOf(sObject.getPlot8Area());
            double plot9Area = Double.valueOf(sObject.getPlot9Area());
            double plot10Area = Double.valueOf(sObject.getPlot10Area());
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

            FragmentTransaction ft = getFragmentManager().beginTransaction();
            //plot1
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 0) {
                setText(plot1,"PLOT 1");
                fragment1.getView().setBackgroundColor(Color.parseColor("#e5e5e5"));
                fragment1.setStartYear(startY1);
                if(sObject.getPLOT1RENOVATION().equals("Yes")||sObject.getPLOT1RENOVATION().equals("Ya")){
                    if(sObject.getPLOT1RENOVATIONREASON().equals("Replanting")||sObject.getPLOT1RENOVATIONREASON().equals("Penanamman kembali")){
                        if (sObject.getHireLabor1().equals("Yes") || sObject.getHireLabor1().equals("Ya")) {
                            fragment1.mainint("replant", "", "labor", plot1Area, avgCost, age1);
                            fragment1.other("labor");
                        } else if (sObject.getHireLabor1().equals("Seasonal") || sObject.getHireLabor1().equals("Musiman")) {
                            fragment1.mainint("replant", "", "season", plot1Area, avgCost, age1);
                            fragment1.other("labor");
                        } else {
                            fragment1.mainint("replant", "", "", plot1Area, avgCost, age1);
                        }
                    }else{
                        if (sObject.getHireLabor1().equals("Yes") || sObject.getHireLabor1().equals("Ya")) {
                            fragment1.mainint("graft", "", "labor", plot1Area, avgCost, age1);
                            fragment1.other("labor");
                        } else if (sObject.getHireLabor1().equals("Seasonal") || sObject.getHireLabor1().equals("Musiman")) {
                            fragment1.mainint("graft", "", "season", plot1Area, avgCost, age1);
                            fragment1.other("labor");
                        } else {
                            fragment1.mainint("graft", "", "", plot1Area, avgCost, age1);
                        }
                    }
                }else{
                    //main intervention
                    if (sObject.getFarmCondition1().equals("B")|| (Integer.parseInt(sObject.getPlot1Age()) > 30)) {
                        //Replant
                        if (sObject.getSOILMNG1().equals("B")||sObject.getSOILMNG1().equals("M")) {
                            if (sObject.getHireLabor1().equals("Yes") || sObject.getHireLabor1().equals("Ya")) {
                                fragment1.mainint("replant", "extra", "labor", plot1Area, avgCost, age1);
                                fragment1.other("labor");
                            } else if (sObject.getHireLabor1().equals("Seasonal") || sObject.getHireLabor1().equals("Musiman")) {
                                fragment1.mainint("replant", "extra", "season", plot1Area, avgCost, age1);
                                fragment1.other("labor");
                            } else {
                                fragment1.mainint("replant", "extra", "", plot1Area, avgCost, age1);
                            }
                        } else {
                            if (sObject.getHireLabor1().equals("Yes") || sObject.getHireLabor1().equals("Ya")) {
                                fragment1.mainint("replant", "", "labor", plot1Area, avgCost, age1);
                                fragment1.other("labor");
                            } else if (sObject.getHireLabor1().equals("Seasonal") || sObject.getHireLabor1().equals("Musiman")) {
                                fragment1.mainint("replant", "", "season", plot1Area, avgCost, age1);
                                fragment1.other("labor");
                            } else {
                                fragment1.mainint("replant", "", "", plot1Area, avgCost, age1);
                            }
                        }

                    } else if ((sObject.getFarmCondition1().equals("G") && (sObject.getGENETIC1().equals("B")||sObject.getGENETIC1().equals("M"))) || ((Integer.parseInt(sObject.getPlot1Age()) > 25) && (Integer.parseInt(sObject.getPlot1Age()) < 30))) {
                        //Graft
                        if (sObject.getSOILMNG1().equals("B")||sObject.getSOILMNG1().equals("M")) {
                            if (sObject.getHireLabor1().equals("Yes") || sObject.getHireLabor1().equals("Ya")) {
                                fragment1.mainint("graft", "extra", "labor", plot1Area, avgCost, age1);
                                fragment1.other("labor");
                            } else if (sObject.getHireLabor1().equals("Seasonal") || sObject.getHireLabor1().equals("Musiman")) {
                                fragment1.mainint("graft", "extra", "season", plot1Area, avgCost, age1);
                                fragment1.other("labor");
                            } else {
                                fragment1.mainint("graft", "extra", "", plot1Area, avgCost, age1);
                            }
                        } else {
                            if (sObject.getHireLabor1().equals("Yes") || sObject.getHireLabor1().equals("Ya")) {
                                fragment1.mainint("graft", "", "labor", plot1Area, avgCost, age1);
                                fragment1.other("labor");
                            } else if (sObject.getHireLabor1().equals("Seasonal") || sObject.getHireLabor1().equals("Musiman")) {
                                fragment1.mainint("graft", "", "season", plot1Area, avgCost, age1);
                                fragment1.other("labor");
                            } else {
                                fragment1.mainint("graft", "", "", plot1Area, avgCost, age1);
                            }
                        }

                    } else if (sObject.getSOILMNG1().equals("B")||sObject.getSOILMNG1().equals("M")) {
                        //Extra Soil Management
                        if (sObject.getHireLabor1().equals("Yes") || sObject.getHireLabor1().equals("Ya")) {
                            fragment1.mainint("extra", "", "labor", plot1Area, avgCost, age1);
                            fragment1.other("labor");
                        } else if (sObject.getHireLabor1().equals("Seasonal") || sObject.getHireLabor1().equals("Musiman")) {
                            fragment1.mainint("extra", "", "season", plot1Area, avgCost, age1);
                            fragment1.other("labor");
                        } else {
                            fragment1.mainint("extra", "", "", plot1Area, avgCost, age1);
                        }

                    } else {
                        //GAP
                        if (sObject.getSOILMNG1().equals("B")||sObject.getSOILMNG1().equals("M")) {
                            if (sObject.getHireLabor1().equals("Yes") || sObject.getHireLabor1().equals("Ya")) {
                                fragment1.mainint("gap", "extra", "labor", plot1Area, avgCost, age1);
                                fragment1.other("labor");
                            } else if (sObject.getHireLabor1().equals("Seasonal") || sObject.getHireLabor1().equals("Musiman")) {
                                fragment1.mainint("gap", "extra", "season", plot1Area, avgCost, age1);
                                fragment1.other("labor");
                            } else {
                                fragment1.mainint("gap", "extra", "", plot1Area, avgCost, age1);
                            }
                        } else {
                            if (sObject.getHireLabor1().equals("Yes") || sObject.getHireLabor1().equals("Ya")) {
                                fragment1.mainint("gap", "", "labor", plot1Area, avgCost, age1);
                                fragment1.other("labor");
                            } else if (sObject.getHireLabor1().equals("Seasonal") || sObject.getHireLabor1().equals("Musiman")) {
                                fragment1.mainint("gap", "", "season", plot1Area, avgCost, age1);
                                fragment1.other("labor");
                            } else {
                                fragment1.mainint("gap", "", "", plot1Area, avgCost, age1);
                            }
                        }
                    }
                }

                //other interventions
                if (sObject.getLimeNeed1().equals("Yes")||sObject.getLimeNeed1().equals("Ya")) {
                    fragment1.other("lime");
                }

                if (sObject.getFillingOption1().equals("Yes")||sObject.getFillingOption1().equals("Ya")) {
                    if (sObject.getPlot1CocoaTrees().contentEquals("2x2")||sObject.getPlot1CocoaTrees().contentEquals("2x2.5")||sObject.getPlot1CocoaTrees().contentEquals("2x3")||sObject.getPlot1CocoaTrees().contentEquals("2.5x2.5")) {
                        fragment1.other("thinning");
                    }else{
                        fragment1.other("filling");
                    }

                }

                if (sObject.getDrainageNeed1().equals("Yes")||sObject.getDrainageNeed1().equals("Ya")) {
                    fragment1.other("drainage");
                }

                ft.show(fragment1);
            }else{ft.hide(fragment1);}
            //plot2

            if (Integer.valueOf(sObject.getNumberOfPlots()) > 1) {
                setText(plot2,"PLOT 2");
                fragment2.setStartYear(startY2);
                if(sObject.getPLOT2RENOVATION().equals("Yes")||sObject.getPLOT2RENOVATION().equals("Ya")){
                    if(sObject.getPLOT2RENOVATIONREASON().equals("Replanting")||sObject.getPLOT2RENOVATIONREASON().equals("Penanamman kembali")){
                        if (sObject.getHireLabor2().equals("Yes") || sObject.getHireLabor2().equals("Ya")) {
                            fragment2.mainint("replant", "", "labor", plot2Area, avgCost, age2);
                            fragment2.other("labor");
                        } else if (sObject.getHireLabor2().equals("Seasonal") || sObject.getHireLabor2().equals("Musiman")) {
                            fragment2.mainint("replant", "", "season", plot2Area, avgCost, age2);
                            fragment2.other("labor");
                        } else {
                            fragment2.mainint("replant", "", "", plot2Area, avgCost, age2);
                        }
                    }else{
                        if (sObject.getHireLabor2().equals("Yes") || sObject.getHireLabor2().equals("Ya")) {
                            fragment2.mainint("graft", "", "labor", plot2Area, avgCost, age2);
                            fragment2.other("labor");
                        } else if (sObject.getHireLabor2().equals("Seasonal") || sObject.getHireLabor2().equals("Musiman")) {
                            fragment2.mainint("graft", "", "season", plot2Area, avgCost, age2);
                            fragment2.other("labor");
                        } else {
                            fragment2.mainint("graft", "", "", plot2Area, avgCost, age2);
                        }
                    }
                }else{
                    //main intervention
                    if (sObject.getFarmCondition2().equals("B") || (Integer.parseInt(sObject.getPlot2Age()) > 30)) {
                        //Replant
                        if (sObject.getSOILMNG2().equals("B")||sObject.getSOILMNG2().equals("M")) {
                            if (sObject.getHireLabor2().equals("Yes") || sObject.getHireLabor2().equals("Ya")) {
                                fragment2.mainint("replant", "extra", "labor", plot2Area, avgCost, age2);
                                fragment2.other("labor");
                            } else if (sObject.getHireLabor2().equals("Seasonal") || sObject.getHireLabor2().equals("Musiman")) {
                                fragment2.mainint("replant", "extra", "season", plot2Area, avgCost, age2);
                                fragment2.other("labor");
                            } else {
                                fragment2.mainint("replant", "extra", "", plot2Area, avgCost, age2);
                            }
                        } else {
                            if (sObject.getHireLabor2().equals("Yes") || sObject.getHireLabor2().equals("Ya")) {
                                fragment2.mainint("replant", "", "labor", plot2Area, avgCost, age2);
                                fragment2.other("labor");
                            } else if (sObject.getHireLabor2().equals("Seasonal") || sObject.getHireLabor2().equals("Musiman")) {
                                fragment2.mainint("replant", "", "season", plot2Area, avgCost, age2);
                                fragment2.other("labor");
                            } else {
                                fragment2.mainint("replant", "", "", plot2Area, avgCost, age2);
                            }
                        }

                    } else if ((sObject.getFarmCondition2().equals("G") && (sObject.getGENETIC2().equals("B")||sObject.getGENETIC2().equals("M"))) || ((Integer.parseInt(sObject.getPlot2Age()) > 25) && (Integer.parseInt(sObject.getPlot2Age()) < 30))) {
                        //Graft
                        if (sObject.getSOILMNG2().equals("B")||sObject.getSOILMNG2().equals("M")) {
                            if (sObject.getHireLabor2().equals("Yes") || sObject.getHireLabor2().equals("Ya")) {
                                fragment2.mainint("graft", "extra", "labor", plot2Area, avgCost, age2);
                                fragment2.other("labor");
                            } else if (sObject.getHireLabor2().equals("Seasonal") || sObject.getHireLabor2().equals("Musiman")) {
                                fragment2.mainint("graft", "extra", "season", plot2Area, avgCost, age2);
                                fragment2.other("labor");
                            } else {
                                fragment2.mainint("graft", "extra", "", plot2Area, avgCost, age2);
                            }
                        } else {
                            if (sObject.getHireLabor2().equals("Yes") || sObject.getHireLabor2().equals("Ya")) {
                                fragment2.mainint("graft", "", "labor", plot2Area, avgCost, age2);
                                fragment2.other("labor");
                            } else if (sObject.getHireLabor2().equals("Seasonal") || sObject.getHireLabor2().equals("Musiman")) {
                                fragment2.mainint("graft", "", "season", plot2Area, avgCost, age2);
                                fragment2.other("labor");
                            } else {
                                fragment2.mainint("graft", "", "", plot2Area, avgCost, age2);
                            }
                        }

                    } else if (sObject.getSOILMNG2().equals("B")||sObject.getSOILMNG2().equals("M")) {
                        //Extra Soil Management
                        if (sObject.getHireLabor2().equals("Yes") || sObject.getHireLabor2().equals("Ya")) {
                            fragment2.mainint("extra", "", "labor", plot2Area, avgCost, age2);
                            fragment2.other("labor");
                        } else if (sObject.getHireLabor2().equals("Seasonal") || sObject.getHireLabor2().equals("Musiman")) {
                            fragment2.mainint("extra", "", "season", plot2Area, avgCost, age2);
                            fragment2.other("labor");
                        } else {
                            fragment2.mainint("extra", "", "", plot2Area, avgCost, age2);
                        }

                    } else {
                        //GAP
                        if (sObject.getSOILMNG2().equals("B")||sObject.getSOILMNG2().equals("M")) {
                            if (sObject.getHireLabor2().equals("Yes") || sObject.getHireLabor2().equals("Ya")) {
                                fragment2.mainint("gap", "extra", "labor", plot2Area, avgCost, age2);
                                fragment2.other("labor");
                            } else if (sObject.getHireLabor2().equals("Seasonal") || sObject.getHireLabor2().equals("Musiman")) {
                                fragment2.mainint("gap", "extra", "season", plot2Area, avgCost, age2);
                                fragment2.other("labor");
                            } else {
                                fragment2.mainint("gap", "extra", "", plot2Area, avgCost, age2);
                            }
                        } else {
                            if (sObject.getHireLabor2().equals("Yes") || sObject.getHireLabor2().equals("Ya")) {
                                fragment2.mainint("gap", "", "labor", plot2Area, avgCost, age2);
                                fragment2.other("labor");
                            } else if (sObject.getHireLabor2().equals("Seasonal") || sObject.getHireLabor2().equals("Musiman")) {
                                fragment2.mainint("gap", "", "season", plot2Area, avgCost, age2);
                                fragment2.other("labor");
                            } else {
                                fragment2.mainint("gap", "", "", plot2Area, avgCost, age2);
                            }
                        }
                    }
                }

                //other interventions
                if (sObject.getLimeNeed2().equals("Yes")||sObject.getLimeNeed2().equals("Ya")) {
                    fragment2.other("lime");
                }

                if (sObject.getFillingOption2().equals("Yes")||sObject.getFillingOption2().equals("Ya")) {
                    if (sObject.getPlot2CocoaTrees().contentEquals("2x2")||sObject.getPlot2CocoaTrees().contentEquals("2x2.5")||sObject.getPlot2CocoaTrees().contentEquals("2x3")||sObject.getPlot2CocoaTrees().contentEquals("2.5x2.5")) {
                        fragment2.other("thinning");
                    }else{
                        fragment2.other("filling");
                    }
                }

                if (sObject.getDrainageNeed2().equals("Yes")||sObject.getDrainageNeed2().equals("Ya")) {
                    fragment2.other("drainage");
                }
                
                ft.show(fragment2);
            }else{ft.hide(fragment2);}

            //plot3
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 2) {
                setText(plot3,"PLOT 3");
                fragment3.getView().setBackgroundColor(Color.parseColor("#e5e5e5"));
                fragment3.setStartYear(startY3);
                if(sObject.getPLOT3RENOVATION().equals("Yes")||sObject.getPLOT3RENOVATION().equals("Ya")){
                    if(sObject.getPLOT3RENOVATIONREASON().equals("Replanting")||sObject.getPLOT3RENOVATIONREASON().equals("Penanamman kembali")){
                        if (sObject.getHireLabor3().equals("Yes") || sObject.getHireLabor3().equals("Ya")) {
                            fragment3.mainint("replant", "", "labor", plot3Area, avgCost, age3);
                            fragment3.other("labor");
                        } else if (sObject.getHireLabor3().equals("Seasonal") || sObject.getHireLabor3().equals("Musiman")) {
                            fragment3.mainint("replant", "", "season", plot3Area, avgCost, age3);
                            fragment3.other("labor");
                        } else {
                            fragment3.mainint("replant", "", "", plot3Area, avgCost, age3);
                        }
                    }else{
                        if (sObject.getHireLabor3().equals("Yes") || sObject.getHireLabor3().equals("Ya")) {
                            fragment3.mainint("graft", "", "labor", plot3Area, avgCost, age3);
                            fragment3.other("labor");
                        } else if (sObject.getHireLabor3().equals("Seasonal") || sObject.getHireLabor3().equals("Musiman")) {
                            fragment3.mainint("graft", "", "season", plot3Area, avgCost, age3);
                            fragment3.other("labor");
                        } else {
                            fragment3.mainint("graft", "", "", plot3Area, avgCost, age3);
                        }
                    }
                }else {
                    //main intervention
                    if (sObject.getFarmCondition3().equals("B") || (Integer.parseInt(sObject.getPlot3Age()) > 30)) {
                        //Replant
                        if (sObject.getSOILMNG3().equals("B")||sObject.getSOILMNG3().equals("M")) {
                            if (sObject.getHireLabor3().equals("Yes") || sObject.getHireLabor3().equals("Ya")) {
                                fragment3.mainint("replant", "extra", "labor", plot3Area, avgCost, age3);
                                fragment3.other("labor");
                            } else if (sObject.getHireLabor3().equals("Seasonal") || sObject.getHireLabor3().equals("Musiman")) {
                                fragment3.mainint("replant", "extra", "season", plot3Area, avgCost, age3);
                                fragment3.other("labor");
                            } else {
                                fragment3.mainint("replant", "extra", "", plot3Area, avgCost, age3);
                            }
                        } else {
                            if (sObject.getHireLabor3().equals("Yes") || sObject.getHireLabor3().equals("Ya")) {
                                fragment3.mainint("replant", "", "labor", plot3Area, avgCost, age3);
                                fragment3.other("labor");
                            } else if (sObject.getHireLabor3().equals("Seasonal") || sObject.getHireLabor3().equals("Musiman")) {
                                fragment3.mainint("replant", "", "season", plot3Area, avgCost, age3);
                                fragment3.other("labor");
                            } else {
                                fragment3.mainint("replant", "", "", plot3Area, avgCost, age3);
                            }
                        }

                    } else if ((sObject.getFarmCondition3().equals("G") && (sObject.getGENETIC3().equals("B")||sObject.getGENETIC3().equals("M"))) || ((Integer.parseInt(sObject.getPlot3Age()) > 25) && (Integer.parseInt(sObject.getPlot3Age()) < 30))) {
                        //Graft
                        if (sObject.getSOILMNG3().equals("B")||sObject.getSOILMNG3().equals("M")) {
                            if (sObject.getHireLabor3().equals("Yes") || sObject.getHireLabor3().equals("Ya")) {
                                fragment3.mainint("graft", "extra", "labor", plot3Area, avgCost, age3);
                                fragment3.other("labor");
                            } else if (sObject.getHireLabor3().equals("Seasonal") || sObject.getHireLabor3().equals("Musiman")) {
                                fragment3.mainint("graft", "extra", "season", plot3Area, avgCost, age3);
                                fragment3.other("labor");
                            } else {
                                fragment3.mainint("graft", "extra", "", plot3Area, avgCost, age3);
                            }
                        } else {
                            if (sObject.getHireLabor3().equals("Yes") || sObject.getHireLabor3().equals("Ya")) {
                                fragment3.mainint("graft", "", "labor", plot3Area, avgCost, age3);
                                fragment3.other("labor");
                            } else if (sObject.getHireLabor3().equals("Seasonal") || sObject.getHireLabor3().equals("Musiman")) {
                                fragment3.mainint("graft", "", "season", plot3Area, avgCost, age3);
                                fragment3.other("labor");
                            } else {
                                fragment3.mainint("graft", "", "", plot3Area, avgCost, age3);
                            }
                        }

                    } else if (sObject.getSOILMNG3().equals("B")||sObject.getSOILMNG3().equals("M")) {
                        //Extra Soil Management
                        if (sObject.getHireLabor3().equals("Yes") || sObject.getHireLabor3().equals("Ya")) {
                            fragment3.mainint("extra", "", "labor", plot3Area, avgCost, age3);
                            fragment3.other("labor");
                        } else if (sObject.getHireLabor3().equals("Seasonal") || sObject.getHireLabor3().equals("Musiman")) {
                            fragment3.mainint("extra", "", "season", plot3Area, avgCost, age3);
                            fragment3.other("labor");
                        } else {
                            fragment3.mainint("extra", "", "", plot3Area, avgCost, age3);
                        }

                    } else {
                        //GAP
                        if (sObject.getSOILMNG3().equals("B")||sObject.getSOILMNG3().equals("M")) {
                            if (sObject.getHireLabor3().equals("Yes") || sObject.getHireLabor3().equals("Ya")) {
                                fragment3.mainint("gap", "extra", "labor", plot3Area, avgCost, age3);
                                fragment3.other("labor");
                            } else if (sObject.getHireLabor3().equals("Seasonal") || sObject.getHireLabor3().equals("Musiman")) {
                                fragment3.mainint("gap", "extra", "season", plot3Area, avgCost, age3);
                                fragment3.other("labor");
                            } else {
                                fragment3.mainint("gap", "extra", "", plot3Area, avgCost, age3);
                            }
                        } else {
                            if (sObject.getHireLabor3().equals("Yes") || sObject.getHireLabor3().equals("Ya")) {
                                fragment3.mainint("gap", "", "labor", plot3Area, avgCost, age3);
                                fragment3.other("labor");
                            } else if (sObject.getHireLabor3().equals("Seasonal") || sObject.getHireLabor3().equals("Musiman")) {
                                fragment3.mainint("gap", "", "season", plot3Area, avgCost, age3);
                                fragment3.other("labor");
                            } else {
                                fragment3.mainint("gap", "", "", plot3Area, avgCost, age3);
                            }
                        }
                    }
                }

                //other interventions

                if (sObject.getLimeNeed3().equals("Yes")||sObject.getLimeNeed3().equals("Ya")) {
                    fragment3.other("lime");
                }

                if (sObject.getFillingOption3().equals("Yes")||sObject.getFillingOption3().equals("Ya")) {
                    if (sObject.getPlot3CocoaTrees().contentEquals("2x2")||sObject.getPlot3CocoaTrees().contentEquals("2x2.5")||sObject.getPlot3CocoaTrees().contentEquals("2x3")||sObject.getPlot3CocoaTrees().contentEquals("2.5x2.5")) {
                        fragment3.other("thinning");
                    }else{
                        fragment3.other("filling");
                    }
                }

                if (sObject.getDrainageNeed3().equals("Yes")||sObject.getDrainageNeed3().equals("Ya")) {
                    fragment3.other("drainage");
                }
                
                ft.show(fragment3);
            }else{ft.hide(fragment3);}

            //plot4
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 3) {
                setText(plot4,"PLOT 4");
                fragment4.setStartYear(startY4);
                if(sObject.getPLOT4RENOVATION().equals("Yes")||sObject.getPLOT4RENOVATION().equals("Ya")){
                    if(sObject.getPLOT4RENOVATIONREASON().equals("Replanting")||sObject.getPLOT4RENOVATIONREASON().equals("Penanamman kembali")){
                        if (sObject.getHireLabor4().equals("Yes") || sObject.getHireLabor4().equals("Ya")) {
                            fragment4.mainint("replant", "", "labor", plot4Area, avgCost, age4);
                            fragment4.other("labor");
                        } else if (sObject.getHireLabor4().equals("Seasonal") || sObject.getHireLabor4().equals("Musiman")) {
                            fragment4.mainint("replant", "", "season", plot4Area, avgCost, age4);
                            fragment4.other("labor");
                        } else {
                            fragment4.mainint("replant", "", "", plot4Area, avgCost, age4);
                        }
                    }else{
                        if (sObject.getHireLabor4().equals("Yes") || sObject.getHireLabor4().equals("Ya")) {
                            fragment4.mainint("graft", "", "labor", plot4Area, avgCost, age4);
                            fragment4.other("labor");
                        } else if (sObject.getHireLabor4().equals("Seasonal") || sObject.getHireLabor4().equals("Musiman")) {
                            fragment4.mainint("graft", "", "season", plot4Area, avgCost, age4);
                            fragment4.other("labor");
                        } else {
                            fragment4.mainint("graft", "", "", plot4Area, avgCost, age4);
                        }
                    }
                }else {
                    //main intervention
                    if (sObject.getFarmCondition4().equals("B") || (Integer.parseInt(sObject.getPlot4Age()) > 30)) {
                        //Replant
                        if (sObject.getSOILMNG4().equals("B")||sObject.getSOILMNG4().equals("M")) {
                            if (sObject.getHireLabor4().equals("Yes") || sObject.getHireLabor4().equals("Ya")) {
                                fragment4.mainint("replant", "extra", "labor", plot4Area, avgCost, age4);
                                fragment4.other("labor");
                            } else if (sObject.getHireLabor4().equals("Seasonal") || sObject.getHireLabor4().equals("Musiman")) {
                                fragment4.mainint("replant", "extra", "season", plot4Area, avgCost, age4);
                                fragment4.other("labor");
                            } else {
                                fragment4.mainint("replant", "extra", "", plot4Area, avgCost, age4);
                            }
                        } else {
                            if (sObject.getHireLabor4().equals("Yes") || sObject.getHireLabor4().equals("Ya")) {
                                fragment4.mainint("replant", "", "labor", plot4Area, avgCost, age4);
                                fragment4.other("labor");
                            } else if (sObject.getHireLabor4().equals("Seasonal") || sObject.getHireLabor4().equals("Musiman")) {
                                fragment4.mainint("replant", "", "season", plot4Area, avgCost, age4);
                                fragment4.other("labor");
                            } else {
                                fragment4.mainint("replant", "", "", plot4Area, avgCost, age4);
                            }
                        }

                    } else if ((sObject.getFarmCondition4().equals("G") && (sObject.getGENETIC4().equals("B")||sObject.getGENETIC4().equals("M"))) || ((Integer.parseInt(sObject.getPlot4Age()) > 25) && (Integer.parseInt(sObject.getPlot4Age()) < 30))) {
                        //Graft
                        if (sObject.getSOILMNG4().equals("B")||sObject.getSOILMNG4().equals("M")) {
                            if (sObject.getHireLabor4().equals("Yes") || sObject.getHireLabor4().equals("Ya")) {
                                fragment4.mainint("graft", "extra", "labor", plot4Area, avgCost, age4);
                                fragment4.other("labor");
                            } else if (sObject.getHireLabor4().equals("Seasonal") || sObject.getHireLabor4().equals("Musiman")) {
                                fragment4.mainint("graft", "extra", "season", plot4Area, avgCost, age4);
                                fragment4.other("labor");
                            } else {
                                fragment4.mainint("graft", "extra", "", plot4Area, avgCost, age4);
                            }
                        } else {
                            if (sObject.getHireLabor4().equals("Yes") || sObject.getHireLabor4().equals("Ya")) {
                                fragment4.mainint("graft", "", "labor", plot4Area, avgCost, age4);
                                fragment4.other("labor");
                            } else if (sObject.getHireLabor4().equals("Seasonal") || sObject.getHireLabor4().equals("Musiman")) {
                                fragment4.mainint("graft", "", "season", plot4Area, avgCost, age4);
                                fragment4.other("labor");
                            } else {
                                fragment4.mainint("graft", "", "", plot4Area, avgCost, age4);
                            }
                        }

                    } else if (sObject.getSOILMNG4().equals("B")||sObject.getSOILMNG4().equals("M")) {
                        //Extra Soil Management
                        if (sObject.getHireLabor4().equals("Yes") || sObject.getHireLabor4().equals("Ya")) {
                            fragment4.mainint("extra", "", "labor", plot4Area, avgCost, age4);
                            fragment4.other("labor");
                        } else if (sObject.getHireLabor4().equals("Seasonal") || sObject.getHireLabor4().equals("Musiman")) {
                            fragment4.mainint("extra", "", "season", plot4Area, avgCost, age4);
                            fragment4.other("labor");
                        } else {
                            fragment4.mainint("extra", "", "", plot4Area, avgCost, age4);
                        }

                    } else {
                        //GAP
                        if (sObject.getSOILMNG4().equals("B")||sObject.getSOILMNG4().equals("M")) {
                            if (sObject.getHireLabor4().equals("Yes") || sObject.getHireLabor4().equals("Ya")) {
                                fragment4.mainint("gap", "extra", "labor", plot4Area, avgCost, age4);
                                fragment4.other("labor");
                            } else if (sObject.getHireLabor4().equals("Seasonal") || sObject.getHireLabor4().equals("Musiman")) {
                                fragment4.mainint("gap", "extra", "season", plot4Area, avgCost, age4);
                                fragment4.other("labor");
                            } else {
                                fragment4.mainint("gap", "extra", "", plot4Area, avgCost, age4);
                            }
                        } else {
                            if (sObject.getHireLabor4().equals("Yes") || sObject.getHireLabor4().equals("Ya")) {
                                fragment4.mainint("gap", "", "labor", plot4Area, avgCost, age4);
                                fragment4.other("labor");
                            } else if (sObject.getHireLabor4().equals("Seasonal") || sObject.getHireLabor4().equals("Musiman")) {
                                fragment4.mainint("gap", "", "season", plot4Area, avgCost, age4);
                                fragment4.other("labor");
                            } else {
                                fragment4.mainint("gap", "", "", plot4Area, avgCost, age4);
                            }
                        }
                    }
                }

                //other interventions
                if (sObject.geLimeNeed4().equals("Yes")||sObject.geLimeNeed4().equals("Ya")) {
                    fragment4.other("lime");
                }

                if (sObject.getFillingOption4().equals("Yes")||sObject.getFillingOption4().equals("Ya")) {
                    if (sObject.getPlot4CocoaTrees().contentEquals("2x2")||sObject.getPlot4CocoaTrees().contentEquals("2x2.5")||sObject.getPlot4CocoaTrees().contentEquals("2x3")||sObject.getPlot4CocoaTrees().contentEquals("2.5x2.5")) {
                        fragment4.other("thinning");
                    }else{
                        fragment4.other("filling");
                    }
                }

                if (sObject.getDrainageNeed4().equals("Yes")||sObject.getDrainageNeed4().equals("Ya")) {
                    fragment4.other("drainage");
                }
                ft.show(fragment4);
            }else{ft.hide(fragment4);}

            //plot5
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 4) {
                setText(plot5,"PLOT 5");
                fragment5.getView().setBackgroundColor(Color.parseColor("#e5e5e5"));
                fragment5.setStartYear(startY5);
                if(sObject.getPLOT5RENOVATION().equals("Yes")||sObject.getPLOT5RENOVATION().equals("Ya")){
                    if(sObject.getPLOT5RENOVATIONREASON().equals("Replanting")||sObject.getPLOT5RENOVATIONREASON().equals("Penanamman kembali")){
                        if (sObject.getHireLabor5().equals("Yes") || sObject.getHireLabor5().equals("Ya")) {
                            fragment5.mainint("replant", "", "labor", plot5Area, avgCost, age5);
                            fragment5.other("labor");
                        } else if (sObject.getHireLabor5().equals("Seasonal") || sObject.getHireLabor5().equals("Musiman")) {
                            fragment5.mainint("replant", "", "season", plot5Area, avgCost, age5);
                            fragment5.other("labor");
                        } else {
                            fragment5.mainint("replant", "", "", plot5Area, avgCost, age5);
                        }
                    }else{
                        if (sObject.getHireLabor5().equals("Yes") || sObject.getHireLabor5().equals("Ya")) {
                            fragment5.mainint("graft", "", "labor", plot5Area, avgCost, age5);
                            fragment5.other("labor");
                        } else if (sObject.getHireLabor5().equals("Seasonal") || sObject.getHireLabor5().equals("Musiman")) {
                            fragment5.mainint("graft", "", "season", plot5Area, avgCost, age5);
                            fragment5.other("labor");
                        } else {
                            fragment5.mainint("graft", "", "", plot5Area, avgCost, age5);
                        }
                    }
                }else {
                    //main intervention
                    if (sObject.getFarmCondition5().equals("B") || (Integer.parseInt(sObject.getPlot5Age()) > 30)) {
                        //Replant
                        if (sObject.getSOILMNG5().equals("B")||sObject.getSOILMNG5().equals("M")) {
                            if (sObject.getHireLabor5().equals("Yes") || sObject.getHireLabor5().equals("Ya")) {
                                fragment5.mainint("replant", "extra", "labor", plot5Area, avgCost, age5);
                                fragment5.other("labor");
                            } else if (sObject.getHireLabor5().equals("Seasonal") || sObject.getHireLabor5().equals("Musiman")) {
                                fragment5.mainint("replant", "extra", "season", plot5Area, avgCost, age5);
                                fragment5.other("labor");
                            } else {
                                fragment5.mainint("replant", "extra", "", plot5Area, avgCost, age5);
                            }
                        } else {
                            if (sObject.getHireLabor5().equals("Yes") || sObject.getHireLabor5().equals("Ya")) {
                                fragment5.mainint("replant", "", "labor", plot5Area, avgCost, age5);
                                fragment5.other("labor");
                            } else if (sObject.getHireLabor5().equals("Seasonal") || sObject.getHireLabor5().equals("Musiman")) {
                                fragment5.mainint("replant", "", "season", plot5Area, avgCost, age5);
                                fragment5.other("labor");
                            } else {
                                fragment5.mainint("replant", "", "", plot5Area, avgCost, age5);
                            }
                        }

                    } else if ((sObject.getFarmCondition5().equals("G") && (sObject.getGENETIC5().equals("B")||sObject.getGENETIC5().equals("M"))) || ((Integer.parseInt(sObject.getPlot5Age()) > 25) && (Integer.parseInt(sObject.getPlot5Age()) < 30))) {
                        //Graft
                        if (sObject.getSOILMNG5().equals("B")||sObject.getSOILMNG5().equals("M")) {
                            if (sObject.getHireLabor5().equals("Yes") || sObject.getHireLabor5().equals("Ya")) {
                                fragment5.mainint("graft", "extra", "labor", plot5Area, avgCost, age5);
                                fragment5.other("labor");
                            } else if (sObject.getHireLabor5().equals("Seasonal") || sObject.getHireLabor5().equals("Musiman")) {
                                fragment5.mainint("graft", "extra", "season", plot5Area, avgCost, age5);
                                fragment5.other("labor");
                            } else {
                                fragment5.mainint("graft", "extra", "", plot5Area, avgCost, age5);
                            }
                        } else {
                            if (sObject.getHireLabor5().equals("Yes") || sObject.getHireLabor5().equals("Ya")) {
                                fragment5.mainint("graft", "", "labor", plot5Area, avgCost, age5);
                                fragment5.other("labor");
                            } else if (sObject.getHireLabor5().equals("Seasonal") || sObject.getHireLabor5().equals("Musiman")) {
                                fragment5.mainint("graft", "", "season", plot5Area, avgCost, age5);
                                fragment5.other("labor");
                            } else {
                                fragment5.mainint("graft", "", "", plot5Area, avgCost, age5);
                            }
                        }

                    } else if (sObject.getSOILMNG5().equals("B")||sObject.getSOILMNG5().equals("M")) {
                        //Extra Soil Management
                        if (sObject.getHireLabor5().equals("Yes") || sObject.getHireLabor5().equals("Ya")) {
                            fragment5.mainint("extra", "", "labor", plot5Area, avgCost, age5);
                            fragment5.other("labor");
                        } else if (sObject.getHireLabor5().equals("Seasonal") || sObject.getHireLabor5().equals("Musiman")) {
                            fragment5.mainint("extra", "", "season", plot5Area, avgCost, age5);
                            fragment5.other("labor");
                        } else {
                            fragment5.mainint("extra", "", "", plot5Area, avgCost, age5);
                        }

                    } else {
                        //GAP
                        if (sObject.getSOILMNG5().equals("B")||sObject.getSOILMNG5().equals("M")) {
                            if (sObject.getHireLabor5().equals("Yes") || sObject.getHireLabor5().equals("Ya")) {
                                fragment5.mainint("gap", "extra", "labor", plot5Area, avgCost, age5);
                                fragment5.other("labor");
                            } else if (sObject.getHireLabor5().equals("Seasonal") || sObject.getHireLabor5().equals("Musiman")) {
                                fragment5.mainint("gap", "extra", "season", plot5Area, avgCost, age5);
                                fragment5.other("labor");
                            } else {
                                fragment5.mainint("gap", "extra", "", plot5Area, avgCost, age5);
                            }
                        } else {
                            if (sObject.getHireLabor5().equals("Yes") || sObject.getHireLabor5().equals("Ya")) {
                                fragment5.mainint("gap", "", "labor", plot5Area, avgCost, age5);
                                fragment5.other("labor");
                            } else if (sObject.getHireLabor5().equals("Seasonal") || sObject.getHireLabor5().equals("Musiman")) {
                                fragment5.mainint("gap", "", "season", plot5Area, avgCost, age5);
                                fragment5.other("labor");
                            } else {
                                fragment5.mainint("gap", "", "", plot5Area, avgCost, age5);
                            }
                        }
                    }
                }

                //other interventions
                if (sObject.getLimeNeed5().equals("Yes")||sObject.getLimeNeed5().equals("Ya")) {
                    fragment5.other("lime");
                }

                if (sObject.getFillingOption5().equals("Yes")||sObject.getFillingOption5().equals("Ya")) {
                    if (sObject.getPlot5CocoaTrees().contentEquals("2x2")||sObject.getPlot5CocoaTrees().contentEquals("2x2.5")||sObject.getPlot5CocoaTrees().contentEquals("2x3")||sObject.getPlot5CocoaTrees().contentEquals("2.5x2.5")) {
                        fragment5.other("thinning");
                    }else{
                        fragment5.other("filling");
                    }
                }

                if (sObject.getDrainageNeed5().equals("Yes")||sObject.getDrainageNeed5().equals("Ya")) {
                    fragment5.other("drainage");
                }
                ft.show(fragment5);
            }else{ft.hide(fragment5);}

            //plot6
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 5) {
                setText(plot6,"PLOT 6");
                fragment6.setStartYear(startY6);
                if(sObject.getPLOT6RENOVATION().equals("Yes")||sObject.getPLOT6RENOVATION().equals("Ya")){
                    if(sObject.getPLOT6RENOVATIONREASON().equals("Replanting")||sObject.getPLOT6RENOVATIONREASON().equals("Penanamman kembali")){
                        if (sObject.getHireLabor6().equals("Yes") || sObject.getHireLabor6().equals("Ya")) {
                            fragment6.mainint("replant", "", "labor", plot6Area, avgCost, age6);
                            fragment6.other("labor");
                        } else if (sObject.getHireLabor6().equals("Seasonal") || sObject.getHireLabor6().equals("Musiman")) {
                            fragment6.mainint("replant", "", "season", plot6Area, avgCost, age6);
                            fragment6.other("labor");
                        } else {
                            fragment6.mainint("replant", "", "", plot6Area, avgCost, age6);
                        }
                    }else{
                        if (sObject.getHireLabor6().equals("Yes") || sObject.getHireLabor6().equals("Ya")) {
                            fragment6.mainint("graft", "", "labor", plot6Area, avgCost, age6);
                            fragment6.other("labor");
                        } else if (sObject.getHireLabor6().equals("Seasonal") || sObject.getHireLabor6().equals("Musiman")) {
                            fragment6.mainint("graft", "", "season", plot6Area, avgCost, age6);
                            fragment6.other("labor");
                        } else {
                            fragment6.mainint("graft", "", "", plot6Area, avgCost, age6);
                        }
                    }
                }else {
                    //main intervention
                    if (sObject.getFarmCondition6().equals("B") || (Integer.parseInt(sObject.getPlot6Age()) > 30)) {
                        //Replant
                        if (sObject.getSOILMNG6().equals("B")||sObject.getSOILMNG6().equals("M")) {
                            if (sObject.getHireLabor6().equals("Yes") || sObject.getHireLabor6().equals("Ya")) {
                                fragment6.mainint("replant", "extra", "labor", plot6Area, avgCost, age6);
                                fragment6.other("labor");
                            } else if (sObject.getHireLabor6().equals("Seasonal") || sObject.getHireLabor6().equals("Musiman")) {
                                fragment6.mainint("replant", "extra", "season", plot6Area, avgCost, age6);
                                fragment6.other("labor");
                            } else {
                                fragment6.mainint("replant", "extra", "", plot6Area, avgCost, age6);
                            }
                        } else {
                            if (sObject.getHireLabor6().equals("Yes") || sObject.getHireLabor6().equals("Ya")) {
                                fragment6.mainint("replant", "", "labor", plot6Area, avgCost, age6);
                                fragment6.other("labor");
                            } else if (sObject.getHireLabor6().equals("Seasonal") || sObject.getHireLabor6().equals("Musiman")) {
                                fragment6.mainint("replant", "", "season", plot6Area, avgCost, age6);
                                fragment6.other("labor");
                            } else {
                                fragment6.mainint("replant", "", "", plot6Area, avgCost, age6);
                            }
                        }

                    } else if ((sObject.getFarmCondition6().equals("G") && (sObject.getGENETIC6().equals("B")||sObject.getGENETIC6().equals("M"))) || ((Integer.parseInt(sObject.getPlot6Age()) > 25) && (Integer.parseInt(sObject.getPlot6Age()) < 30))) {
                        //Graft
                        if (sObject.getSOILMNG6().equals("B")||sObject.getSOILMNG6().equals("M")) {
                            if (sObject.getHireLabor6().equals("Yes") || sObject.getHireLabor6().equals("Ya")) {
                                fragment6.mainint("graft", "extra", "labor", plot6Area, avgCost, age6);
                                fragment6.other("labor");
                            } else if (sObject.getHireLabor6().equals("Seasonal") || sObject.getHireLabor6().equals("Musiman")) {
                                fragment6.mainint("graft", "extra", "season", plot6Area, avgCost, age6);
                                fragment6.other("labor");
                            } else {
                                fragment6.mainint("graft", "extra", "", plot6Area, avgCost, age6);
                            }
                        } else {
                            if (sObject.getHireLabor6().equals("Yes") || sObject.getHireLabor6().equals("Ya")) {
                                fragment6.mainint("graft", "", "labor", plot6Area, avgCost, age6);
                                fragment6.other("labor");
                            } else if (sObject.getHireLabor6().equals("Seasonal") || sObject.getHireLabor6().equals("Musiman")) {
                                fragment6.mainint("graft", "", "season", plot6Area, avgCost, age6);
                                fragment6.other("labor");
                            } else {
                                fragment6.mainint("graft", "", "", plot6Area, avgCost, age6);
                            }
                        }

                    } else if (sObject.getSOILMNG6().equals("B")||sObject.getSOILMNG6().equals("M")) {
                        //Extra Soil Management
                        if (sObject.getHireLabor6().equals("Yes") || sObject.getHireLabor6().equals("Ya")) {
                            fragment6.mainint("extra", "", "labor", plot6Area, avgCost, age6);
                            fragment6.other("labor");
                        } else if (sObject.getHireLabor6().equals("Seasonal") || sObject.getHireLabor6().equals("Musiman")) {
                            fragment6.mainint("extra", "", "season", plot6Area, avgCost, age6);
                            fragment6.other("labor");
                        } else {
                            fragment6.mainint("extra", "", "", plot6Area, avgCost, age6);
                        }

                    } else {
                        //GAP
                        if (sObject.getSOILMNG6().equals("B")||sObject.getSOILMNG6().equals("M")) {
                            if (sObject.getHireLabor6().equals("Yes") || sObject.getHireLabor6().equals("Ya")) {
                                fragment6.mainint("gap", "extra", "labor", plot6Area, avgCost, age6);
                                fragment6.other("labor");
                            } else if (sObject.getHireLabor6().equals("Seasonal") || sObject.getHireLabor6().equals("Musiman")) {
                                fragment6.mainint("gap", "extra", "season", plot6Area, avgCost, age6);
                                fragment6.other("labor");
                            } else {
                                fragment6.mainint("gap", "extra", "", plot6Area, avgCost, age6);
                            }
                        } else {
                            if (sObject.getHireLabor6().equals("Yes") || sObject.getHireLabor6().equals("Ya")) {
                                fragment6.mainint("gap", "", "labor", plot6Area, avgCost, age6);
                                fragment6.other("labor");
                            } else if (sObject.getHireLabor6().equals("Seasonal") || sObject.getHireLabor6().equals("Musiman")) {
                                fragment6.mainint("gap", "", "season", plot6Area, avgCost, age6);
                                fragment6.other("labor");
                            } else {
                                fragment6.mainint("gap", "", "", plot6Area, avgCost, age6);
                            }
                        }
                    }
                }

                //other interventions
                if (sObject.getLimeNeed6().equals("Yes")||sObject.getLimeNeed6().equals("Ya")) {
                    fragment6.other("lime");
                }

                if (sObject.getFillingOption6().equals("Yes")||sObject.getFillingOption6().equals("Ya")) {
                    if (sObject.getPlot6CocoaTrees().contentEquals("2x2")||sObject.getPlot6CocoaTrees().contentEquals("2x2.5")||sObject.getPlot6CocoaTrees().contentEquals("2x3")||sObject.getPlot6CocoaTrees().contentEquals("2.5x2.5")) {
                        fragment6.other("thinning");
                    }else{
                        fragment6.other("filling");
                    }
                }

                if (sObject.getDrainageNeed6().equals("Yes")||sObject.getDrainageNeed6().equals("Ya")) {
                    fragment6.other("drainage");
                }
                ft.show(fragment6);
            }else{ft.hide(fragment6);}

            //plot7
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 6) {
                setText(plot7,"PLOT 7");
                fragment7.getView().setBackgroundColor(Color.parseColor("#e5e5e5"));
                fragment7.setStartYear(startY7);
                if(sObject.getPLOT7RENOVATION().equals("Yes")||sObject.getPLOT7RENOVATION().equals("Ya")){
                    if(sObject.getPLOT7RENOVATIONREASON().equals("Replanting")||sObject.getPLOT7RENOVATIONREASON().equals("Penanamman kembali")){
                        if (sObject.getHireLabor7().equals("Yes") || sObject.getHireLabor7().equals("Ya")) {
                            fragment7.mainint("replant", "", "labor", plot7Area, avgCost, age7);
                            fragment7.other("labor");
                        } else if (sObject.getHireLabor7().equals("Seasonal") || sObject.getHireLabor7().equals("Musiman")) {
                            fragment7.mainint("replant", "", "season", plot7Area, avgCost, age7);
                            fragment7.other("labor");
                        } else {
                            fragment7.mainint("replant", "", "", plot7Area, avgCost, age7);
                        }
                    }else{
                        if (sObject.getHireLabor7().equals("Yes") || sObject.getHireLabor7().equals("Ya")) {
                            fragment7.mainint("graft", "", "labor", plot7Area, avgCost, age7);
                            fragment7.other("labor");
                        } else if (sObject.getHireLabor7().equals("Seasonal") || sObject.getHireLabor7().equals("Musiman")) {
                            fragment7.mainint("graft", "", "season", plot7Area, avgCost, age7);
                            fragment7.other("labor");
                        } else {
                            fragment7.mainint("graft", "", "", plot7Area, avgCost, age7);
                        }
                    }
                }else {
                    //main intervention
                    if (sObject.getFarmCondition7().equals("B") || (Integer.parseInt(sObject.getPlot7Age()) > 30)) {
                        //Replant
                        if (sObject.getSOILMNG7().equals("B")||sObject.getSOILMNG7().equals("M")) {
                            if (sObject.getHireLabor7().equals("Yes") || sObject.getHireLabor7().equals("Ya")) {
                                fragment7.mainint("replant", "extra", "labor", plot7Area, avgCost, age7);
                                fragment7.other("labor");
                            } else if (sObject.getHireLabor7().equals("Seasonal") || sObject.getHireLabor7().equals("Musiman")) {
                                fragment7.mainint("replant", "extra", "season", plot7Area, avgCost, age7);
                                fragment7.other("labor");
                            } else {
                                fragment7.mainint("replant", "extra", "", plot7Area, avgCost, age7);
                            }
                        } else {
                            if (sObject.getHireLabor7().equals("Yes") || sObject.getHireLabor7().equals("Ya")) {
                                fragment7.mainint("replant", "", "labor", plot7Area, avgCost, age7);
                                fragment7.other("labor");
                            } else if (sObject.getHireLabor7().equals("Seasonal") || sObject.getHireLabor7().equals("Musiman")) {
                                fragment7.mainint("replant", "", "season", plot7Area, avgCost, age7);
                                fragment7.other("labor");
                            } else {
                                fragment7.mainint("replant", "", "", plot7Area, avgCost, age7);
                            }
                        }

                    } else if ((sObject.getFarmCondition7().equals("G") && (sObject.getGENETIC7().equals("B")||sObject.getGENETIC7().equals("M"))) || ((Integer.parseInt(sObject.getPlot7Age()) > 25) && (Integer.parseInt(sObject.getPlot7Age()) < 30))) {
                        //Graft
                        if (sObject.getSOILMNG7().equals("B")||sObject.getSOILMNG7().equals("M")) {
                            if (sObject.getHireLabor7().equals("Yes") || sObject.getHireLabor7().equals("Ya")) {
                                fragment7.mainint("graft", "extra", "labor", plot7Area, avgCost, age7);
                                fragment7.other("labor");
                            } else if (sObject.getHireLabor7().equals("Seasonal") || sObject.getHireLabor7().equals("Musiman")) {
                                fragment7.mainint("graft", "extra", "season", plot7Area, avgCost, age7);
                                fragment7.other("labor");
                            } else {
                                fragment7.mainint("graft", "extra", "", plot7Area, avgCost, age7);
                            }
                        } else {
                            if (sObject.getHireLabor7().equals("Yes") || sObject.getHireLabor7().equals("Ya")) {
                                fragment7.mainint("graft", "", "labor", plot7Area, avgCost, age7);
                                fragment7.other("labor");
                            } else if (sObject.getHireLabor7().equals("Seasonal") || sObject.getHireLabor7().equals("Musiman")) {
                                fragment7.mainint("graft", "", "season", plot7Area, avgCost, age7);
                                fragment7.other("labor");
                            } else {
                                fragment7.mainint("graft", "", "", plot7Area, avgCost, age7);
                            }
                        }

                    } else if (sObject.getSOILMNG7().equals("B")||sObject.getSOILMNG7().equals("M")) {
                        //Extra Soil Management
                        if (sObject.getHireLabor7().equals("Yes") || sObject.getHireLabor7().equals("Ya")) {
                            fragment7.mainint("extra", "", "labor", plot7Area, avgCost, age7);
                            fragment7.other("labor");
                        } else if (sObject.getHireLabor7().equals("Seasonal") || sObject.getHireLabor7().equals("Musiman")) {
                            fragment7.mainint("extra", "", "season", plot7Area, avgCost, age7);
                            fragment7.other("labor");
                        } else {
                            fragment7.mainint("extra", "", "", plot7Area, avgCost, age7);
                        }

                    } else {
                        //GAP
                        if (sObject.getSOILMNG7().equals("B")||sObject.getSOILMNG7().equals("M")) {
                            if (sObject.getHireLabor7().equals("Yes") || sObject.getHireLabor7().equals("Ya")) {
                                fragment7.mainint("gap", "extra", "labor", plot7Area, avgCost, age7);
                                fragment7.other("labor");
                            } else if (sObject.getHireLabor7().equals("Seasonal") || sObject.getHireLabor7().equals("Musiman")) {
                                fragment7.mainint("gap", "extra", "season", plot7Area, avgCost, age7);
                                fragment7.other("labor");
                            } else {
                                fragment7.mainint("gap", "extra", "", plot7Area, avgCost, age7);
                            }
                        } else {
                            if (sObject.getHireLabor7().equals("Yes") || sObject.getHireLabor7().equals("Ya")) {
                                fragment7.mainint("gap", "", "labor", plot7Area, avgCost, age7);
                                fragment7.other("labor");
                            } else if (sObject.getHireLabor7().equals("Seasonal") || sObject.getHireLabor7().equals("Musiman")) {
                                fragment7.mainint("gap", "", "season", plot7Area, avgCost, age7);
                                fragment7.other("labor");
                            } else {
                                fragment7.mainint("gap", "", "", plot7Area, avgCost, age7);
                            }
                        }
                    }
                }

                //other interventions
                if (sObject.getLimeNeed7().equals("Yes")||sObject.getLimeNeed7().equals("Ya")) {
                    fragment7.other("lime");
                }

                if (sObject.getFillingOption7().equals("Yes")||sObject.getFillingOption7().equals("Ya")) {
                    if (sObject.getPlot7CocoaTrees().contentEquals("2x2")||sObject.getPlot7CocoaTrees().contentEquals("2x2.5")||sObject.getPlot7CocoaTrees().contentEquals("2x3")||sObject.getPlot7CocoaTrees().contentEquals("2.5x2.5")) {
                        fragment7.other("thinning");
                    }else{
                        fragment7.other("filling");
                    }
                }

                if (sObject.getDrainageNeed7().equals("Yes")||sObject.getDrainageNeed7().equals("Ya")) {
                    fragment7.other("drainage");
                }
                ft.show(fragment7);
            }else{ft.hide(fragment7);}

            //plot8
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 7) {
                setText(plot8,"PLOT 8");
                fragment8.setStartYear(startY8);
                if(sObject.getPLOT8RENOVATION().equals("Yes")||sObject.getPLOT8RENOVATION().equals("Ya")){
                    if(sObject.getPLOT8RENOVATIONREASON().equals("Replanting")||sObject.getPLOT8RENOVATIONREASON().equals("Penanamman kembali")){
                        if (sObject.getHireLabor8().equals("Yes") || sObject.getHireLabor8().equals("Ya")) {
                            fragment8.mainint("replant", "", "labor", plot8Area, avgCost, age8);
                            fragment8.other("labor");
                        } else if (sObject.getHireLabor8().equals("Seasonal") || sObject.getHireLabor8().equals("Musiman")) {
                            fragment8.mainint("replant", "", "season", plot8Area, avgCost, age8);
                            fragment8.other("labor");
                        } else {
                            fragment8.mainint("replant", "", "", plot8Area, avgCost, age8);
                        }
                    }else{
                        if (sObject.getHireLabor8().equals("Yes") || sObject.getHireLabor8().equals("Ya")) {
                            fragment8.mainint("graft", "", "labor", plot8Area, avgCost, age8);
                            fragment8.other("labor");
                        } else if (sObject.getHireLabor8().equals("Seasonal") || sObject.getHireLabor8().equals("Musiman")) {
                            fragment8.mainint("graft", "", "season", plot8Area, avgCost, age8);
                            fragment8.other("labor");
                        } else {
                            fragment8.mainint("graft", "", "", plot8Area, avgCost, age8);
                        }
                    }
                }else {
                    //main intervention
                    if (sObject.getFarmCondition8().equals("B") || (Integer.parseInt(sObject.getPlot8Age()) > 30)) {
                        //Replant
                        if (sObject.getSOILMNG8().equals("B")||sObject.getSOILMNG8().equals("M")) {
                            if (sObject.getHireLabor8().equals("Yes") || sObject.getHireLabor8().equals("Ya")) {
                                fragment8.mainint("replant", "extra", "labor", plot8Area, avgCost, age8);
                                fragment8.other("labor");
                            } else if (sObject.getHireLabor8().equals("Seasonal") || sObject.getHireLabor8().equals("Musiman")) {
                                fragment8.mainint("replant", "extra", "season", plot8Area, avgCost, age8);
                                fragment8.other("labor");
                            } else {
                                fragment8.mainint("replant", "extra", "", plot8Area, avgCost, age8);
                            }
                        } else {
                            if (sObject.getHireLabor8().equals("Yes") || sObject.getHireLabor8().equals("Ya")) {
                                fragment8.mainint("replant", "", "labor", plot8Area, avgCost, age8);
                                fragment8.other("labor");
                            } else if (sObject.getHireLabor8().equals("Seasonal") || sObject.getHireLabor8().equals("Musiman")) {
                                fragment8.mainint("replant", "", "season", plot8Area, avgCost, age8);
                                fragment8.other("labor");
                            } else {
                                fragment8.mainint("replant", "", "", plot8Area, avgCost, age8);
                            }
                        }

                    } else if ((sObject.getFarmCondition8().equals("G") && (sObject.getGENETIC8().equals("B")||sObject.getGENETIC8().equals("M"))) || ((Integer.parseInt(sObject.getPlot8Age()) > 25) && (Integer.parseInt(sObject.getPlot8Age()) < 30))) {
                        //Graft
                        if (sObject.getSOILMNG8().equals("B")||sObject.getSOILMNG8().equals("M")) {
                            if (sObject.getHireLabor8().equals("Yes") || sObject.getHireLabor8().equals("Ya")) {
                                fragment8.mainint("graft", "extra", "labor", plot8Area, avgCost, age8);
                                fragment8.other("labor");
                            } else if (sObject.getHireLabor8().equals("Seasonal") || sObject.getHireLabor8().equals("Musiman")) {
                                fragment8.mainint("graft", "extra", "season", plot8Area, avgCost, age8);
                                fragment8.other("labor");
                            } else {
                                fragment8.mainint("graft", "extra", "", plot8Area, avgCost, age8);
                            }
                        } else {
                            if (sObject.getHireLabor8().equals("Yes") || sObject.getHireLabor8().equals("Ya")) {
                                fragment8.mainint("graft", "", "labor", plot8Area, avgCost, age8);
                                fragment8.other("labor");
                            } else if (sObject.getHireLabor8().equals("Seasonal") || sObject.getHireLabor8().equals("Musiman")) {
                                fragment8.mainint("graft", "", "season", plot8Area, avgCost, age8);
                                fragment8.other("labor");
                            } else {
                                fragment8.mainint("graft", "", "", plot8Area, avgCost, age8);
                            }
                        }

                    } else if (sObject.getSOILMNG8().equals("B")||sObject.getSOILMNG8().equals("M")) {
                        //Extra Soil Management
                        if (sObject.getHireLabor8().equals("Yes") || sObject.getHireLabor8().equals("Ya")) {
                            fragment8.mainint("extra", "", "labor", plot8Area, avgCost, age8);
                            fragment8.other("labor");
                        } else if (sObject.getHireLabor8().equals("Seasonal") || sObject.getHireLabor8().equals("Musiman")) {
                            fragment8.mainint("extra", "", "season", plot8Area, avgCost, age8);
                            fragment8.other("labor");
                        } else {
                            fragment8.mainint("extra", "", "", plot8Area, avgCost, age8);
                        }

                    } else {
                        //GAP
                        if (sObject.getSOILMNG8().equals("B")||sObject.getSOILMNG8().equals("M")) {
                            if (sObject.getHireLabor8().equals("Yes") || sObject.getHireLabor8().equals("Ya")) {
                                fragment8.mainint("gap", "extra", "labor", plot8Area, avgCost, age8);
                                fragment8.other("labor");
                            } else if (sObject.getHireLabor8().equals("Seasonal") || sObject.getHireLabor8().equals("Musiman")) {
                                fragment8.mainint("gap", "extra", "season", plot8Area, avgCost, age8);
                                fragment8.other("labor");
                            } else {
                                fragment8.mainint("gap", "extra", "", plot8Area, avgCost, age8);
                            }
                        } else {
                            if (sObject.getHireLabor8().equals("Yes") || sObject.getHireLabor8().equals("Ya")) {
                                fragment8.mainint("gap", "", "labor", plot8Area, avgCost, age8);
                                fragment8.other("labor");
                            } else if (sObject.getHireLabor8().equals("Seasonal") || sObject.getHireLabor8().equals("Musiman")) {
                                fragment8.mainint("gap", "", "season", plot8Area, avgCost, age8);
                                fragment8.other("labor");
                            } else {
                                fragment8.mainint("gap", "", "", plot8Area, avgCost, age8);
                            }
                        }
                    }
                }

                //other interventions
                if (sObject.getLimeNeed8().equals("Yes")||sObject.getLimeNeed8().equals("Ya")) {
                    fragment8.other("lime");
                }

                if (sObject.getFillingOption8().equals("Yes")||sObject.getFillingOption8().equals("Ya")) {
                    if (sObject.getPlot8CocoaTrees().contentEquals("2x2")||sObject.getPlot8CocoaTrees().contentEquals("2x2.5")||sObject.getPlot8CocoaTrees().contentEquals("2x3")||sObject.getPlot8CocoaTrees().contentEquals("2.5x2.5")) {
                        fragment8.other("thinning");
                    }else{
                        fragment8.other("filling");
                    }
                }

                if (sObject.getDrainageNeed8().equals("Yes")||sObject.getDrainageNeed8().equals("Ya")) {
                    fragment8.other("drainage");
                }
                ft.show(fragment8);
            }else{ft.hide(fragment8);}

            //plot9
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 8) {
                setText(plot9,"PLOT 9");
                fragment9.getView().setBackgroundColor(Color.parseColor("#e5e5e5"));
                fragment9.setStartYear(startY9);
                if(sObject.getPLOT9RENOVATION().equals("Yes")||sObject.getPLOT9RENOVATION().equals("Ya")){
                    if(sObject.getPLOT9RENOVATIONREASON().equals("Replanting")||sObject.getPLOT9RENOVATIONREASON().equals("Penanamman kembali")){
                        if (sObject.getHireLabor9().equals("Yes") || sObject.getHireLabor9().equals("Ya")) {
                            fragment9.mainint("replant", "", "labor", plot9Area, avgCost, age9);
                            fragment9.other("labor");
                        } else if (sObject.getHireLabor9().equals("Seasonal") || sObject.getHireLabor9().equals("Musiman")) {
                            fragment9.mainint("replant", "", "season", plot9Area, avgCost, age9);
                            fragment9.other("labor");
                        } else {
                            fragment9.mainint("replant", "", "", plot9Area, avgCost, age9);
                        }
                    }else{
                        if (sObject.getHireLabor9().equals("Yes") || sObject.getHireLabor9().equals("Ya")) {
                            fragment9.mainint("graft", "", "labor", plot9Area, avgCost, age9);
                            fragment9.other("labor");
                        } else if (sObject.getHireLabor9().equals("Seasonal") || sObject.getHireLabor9().equals("Musiman")) {
                            fragment9.mainint("graft", "", "season", plot9Area, avgCost, age9);
                            fragment9.other("labor");
                        } else {
                            fragment9.mainint("graft", "", "", plot9Area, avgCost, age9);
                        }
                    }
                }else {
                    //main intervention
                    if (sObject.getFarmCondition9().equals("B") || (Integer.parseInt(sObject.getPlot9Age()) > 30)) {
                        //Replant
                        if (sObject.getSOILMNG9().equals("B")||sObject.getSOILMNG9().equals("M")) {
                            if (sObject.getHireLabor9().equals("Yes") || sObject.getHireLabor9().equals("Ya")) {
                                fragment9.mainint("replant", "extra", "labor", plot9Area, avgCost, age9);
                                fragment9.other("labor");
                            } else if (sObject.getHireLabor9().equals("Seasonal") || sObject.getHireLabor9().equals("Musiman")) {
                                fragment9.mainint("replant", "extra", "season", plot9Area, avgCost, age9);
                                fragment9.other("labor");
                            } else {
                                fragment9.mainint("replant", "extra", "", plot9Area, avgCost, age9);
                            }
                        } else {
                            if (sObject.getHireLabor9().equals("Yes") || sObject.getHireLabor9().equals("Ya")) {
                                fragment9.mainint("replant", "", "labor", plot9Area, avgCost, age9);
                                fragment9.other("labor");
                            } else if (sObject.getHireLabor9().equals("Seasonal") || sObject.getHireLabor9().equals("Musiman")) {
                                fragment9.mainint("replant", "", "season", plot9Area, avgCost, age9);
                                fragment9.other("labor");
                            } else {
                                fragment9.mainint("replant", "", "", plot9Area, avgCost, age9);
                            }
                        }

                    } else if ((sObject.getFarmCondition9().equals("G") && (sObject.getGENETIC9().equals("B")||sObject.getGENETIC9().equals("M"))) || ((Integer.parseInt(sObject.getPlot9Age()) > 25) && (Integer.parseInt(sObject.getPlot9Age()) < 30))) {
                        //Graft
                        if (sObject.getSOILMNG9().equals("B")||sObject.getSOILMNG9().equals("M")) {
                            if (sObject.getHireLabor9().equals("Yes") || sObject.getHireLabor9().equals("Ya")) {
                                fragment9.mainint("graft", "extra", "labor", plot9Area, avgCost, age9);
                                fragment9.other("labor");
                            } else if (sObject.getHireLabor9().equals("Seasonal") || sObject.getHireLabor9().equals("Musiman")) {
                                fragment9.mainint("graft", "extra", "season", plot9Area, avgCost, age9);
                                fragment9.other("labor");
                            } else {
                                fragment9.mainint("graft", "extra", "", plot9Area, avgCost, age9);
                            }
                        } else {
                            if (sObject.getHireLabor9().equals("Yes") || sObject.getHireLabor9().equals("Ya")) {
                                fragment9.mainint("graft", "", "labor", plot9Area, avgCost, age9);
                                fragment9.other("labor");
                            } else if (sObject.getHireLabor9().equals("Seasonal") || sObject.getHireLabor9().equals("Musiman")) {
                                fragment9.mainint("graft", "", "season", plot9Area, avgCost, age9);
                                fragment9.other("labor");
                            } else {
                                fragment9.mainint("graft", "", "", plot9Area, avgCost, age9);
                            }
                        }

                    } else if (sObject.getSOILMNG9().equals("B")||sObject.getSOILMNG9().equals("M")) {
                        //Extra Soil Management
                        if (sObject.getHireLabor9().equals("Yes") || sObject.getHireLabor9().equals("Ya")) {
                            fragment9.mainint("extra", "", "labor", plot9Area, avgCost, age9);
                            fragment9.other("labor");
                        } else if (sObject.getHireLabor9().equals("Seasonal") || sObject.getHireLabor9().equals("Musiman")) {
                            fragment9.mainint("extra", "", "season", plot9Area, avgCost, age9);
                            fragment9.other("labor");
                        } else {
                            fragment9.mainint("extra", "", "", plot9Area, avgCost, age9);
                        }

                    } else {
                        //GAP
                        if (sObject.getSOILMNG9().equals("B")||sObject.getSOILMNG9().equals("M")) {
                            if (sObject.getHireLabor9().equals("Yes") || sObject.getHireLabor9().equals("Ya")) {
                                fragment9.mainint("gap", "extra", "labor", plot9Area, avgCost, age9);
                                fragment9.other("labor");
                            } else if (sObject.getHireLabor9().equals("Seasonal") || sObject.getHireLabor9().equals("Musiman")) {
                                fragment9.mainint("gap", "extra", "season", plot9Area, avgCost, age9);
                                fragment9.other("labor");
                            } else {
                                fragment9.mainint("gap", "extra", "", plot9Area, avgCost, age9);
                            }
                        } else {
                            if (sObject.getHireLabor9().equals("Yes") || sObject.getHireLabor9().equals("Ya")) {
                                fragment9.mainint("gap", "", "labor", plot9Area, avgCost, age9);
                                fragment9.other("labor");
                            } else if (sObject.getHireLabor9().equals("Seasonal") || sObject.getHireLabor9().equals("Musiman")) {
                                fragment9.mainint("gap", "", "season", plot9Area, avgCost, age9);
                                fragment9.other("labor");
                            } else {
                                fragment9.mainint("gap", "", "", plot9Area, avgCost, age9);
                            }
                        }
                    }
                }

                //other interventions
                if (sObject.getLimeNeed9().equals("Yes")||sObject.getLimeNeed9().equals("Ya")) {
                    fragment9.other("lime");
                }

                if (sObject.getFillingOption9().equals("Yes")||sObject.getFillingOption9().equals("Ya")) {
                    if (sObject.getPlot9CocoaTrees().contentEquals("2x2")||sObject.getPlot9CocoaTrees().contentEquals("2x2.5")||sObject.getPlot9CocoaTrees().contentEquals("2x3")||sObject.getPlot9CocoaTrees().contentEquals("2.5x2.5")) {
                        fragment9.other("thinning");
                    }else{
                        fragment9.other("filling");
                    }
                }

                if (sObject.getDrainageNeed9().equals("Yes")||sObject.getDrainageNeed9().equals("Ya")) {
                    fragment9.other("drainage");
                }
                ft.show(fragment9);
            }else{ft.hide(fragment9);}

            //plot10
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 9) {
                setText(plot10,"PLOT 10");
                fragment10.setStartYear(startY10);
                if(sObject.getPLOT10RENOVATION().equals("Yes")||sObject.getPLOT10RENOVATION().equals("Ya")){
                    if(sObject.getPLOT10RENOVATIONREASON().equals("Replanting")||sObject.getPLOT10RENOVATIONREASON().equals("Penanamman kembali")){
                        if (sObject.getHireLabor10().equals("Yes") || sObject.getHireLabor10().equals("Ya")) {
                            fragment10.mainint("replant", "", "labor", plot10Area, avgCost, age10);
                            fragment10.other("labor");
                        } else if (sObject.getHireLabor10().equals("Seasonal") || sObject.getHireLabor10().equals("Musiman")) {
                            fragment10.mainint("replant", "", "season", plot10Area, avgCost, age10);
                            fragment10.other("labor");
                        } else {
                            fragment10.mainint("replant", "", "", plot10Area, avgCost, age10);
                        }
                    }else{
                        if (sObject.getHireLabor10().equals("Yes") || sObject.getHireLabor10().equals("Ya")) {
                            fragment10.mainint("graft", "", "labor", plot10Area, avgCost, age10);
                            fragment10.other("labor");
                        } else if (sObject.getHireLabor10().equals("Seasonal") || sObject.getHireLabor10().equals("Musiman")) {
                            fragment10.mainint("graft", "", "season", plot10Area, avgCost, age10);
                            fragment10.other("labor");
                        } else {
                            fragment10.mainint("graft", "", "", plot10Area, avgCost, age10);
                        }
                    }
                }else {
                    //main intervention
                    if (sObject.getFarmCondition10().equals("B") || (Integer.parseInt(sObject.getPlot10Age()) > 30)) {
                        //Replant
                        if (sObject.getSOILMNG10().equals("B")||sObject.getSOILMNG10().equals("M")) {
                            if (sObject.getHireLabor10().equals("Yes") || sObject.getHireLabor10().equals("Ya")) {
                                fragment10.mainint("replant", "extra", "labor", plot10Area, avgCost, age10);
                                fragment10.other("labor");
                            } else if (sObject.getHireLabor10().equals("Seasonal") || sObject.getHireLabor10().equals("Musiman")) {
                                fragment10.mainint("replant", "extra", "season", plot10Area, avgCost, age10);
                                fragment10.other("labor");
                            } else {
                                fragment10.mainint("replant", "extra", "", plot10Area, avgCost, age10);
                            }
                        } else {
                            if (sObject.getHireLabor10().equals("Yes") || sObject.getHireLabor10().equals("Ya")) {
                                fragment10.mainint("replant", "", "labor", plot10Area, avgCost, age10);
                                fragment10.other("labor");
                            } else if (sObject.getHireLabor10().equals("Seasonal") || sObject.getHireLabor10().equals("Musiman")) {
                                fragment10.mainint("replant", "", "season", plot10Area, avgCost, age10);
                                fragment10.other("labor");
                            } else {
                                fragment10.mainint("replant", "", "", plot10Area, avgCost, age10);
                            }
                        }

                    } else if ((sObject.getFarmCondition10().equals("G") && (sObject.getGENETIC10().equals("B")||sObject.getGENETIC10().equals("M"))) || ((Integer.parseInt(sObject.getPlot10Age()) > 25) && (Integer.parseInt(sObject.getPlot10Age()) < 30))) {
                        //Graft
                        if (sObject.getSOILMNG10().equals("B")||sObject.getSOILMNG10().equals("M")) {
                            if (sObject.getHireLabor10().equals("Yes") || sObject.getHireLabor10().equals("Ya")) {
                                fragment10.mainint("graft", "extra", "labor", plot10Area, avgCost, age10);
                                fragment10.other("labor");
                            } else if (sObject.getHireLabor10().equals("Seasonal") || sObject.getHireLabor10().equals("Musiman")) {
                                fragment10.mainint("graft", "extra", "season", plot10Area, avgCost, age10);
                                fragment10.other("labor");
                            } else {
                                fragment10.mainint("graft", "extra", "", plot10Area, avgCost, age10);
                            }
                        } else {
                            if (sObject.getHireLabor10().equals("Yes") || sObject.getHireLabor10().equals("Ya")) {
                                fragment10.mainint("graft", "", "labor", plot10Area, avgCost, age10);
                                fragment10.other("labor");
                            } else if (sObject.getHireLabor10().equals("Seasonal") || sObject.getHireLabor10().equals("Musiman")) {
                                fragment10.mainint("graft", "", "season", plot10Area, avgCost, age10);
                                fragment10.other("labor");
                            } else {
                                fragment10.mainint("graft", "", "", plot10Area, avgCost, age10);
                            }
                        }

                    } else if (sObject.getSOILMNG10().equals("B")||sObject.getSOILMNG10().equals("M")) {
                        //Extra Soil Management
                        if (sObject.getHireLabor10().equals("Yes") || sObject.getHireLabor10().equals("Ya")) {
                            fragment10.mainint("extra", "", "labor", plot10Area, avgCost, age10);
                            fragment10.other("labor");
                        } else if (sObject.getHireLabor10().equals("Seasonal") || sObject.getHireLabor10().equals("Musiman")) {
                            fragment10.mainint("extra", "", "season", plot10Area, avgCost, age10);
                            fragment10.other("labor");
                        } else {
                            fragment10.mainint("extra", "", "", plot10Area, avgCost, age10);
                        }

                    } else {
                        //GAP
                        if (sObject.getSOILMNG10().equals("B")||sObject.getSOILMNG10().equals("M")) {
                            if (sObject.getHireLabor10().equals("Yes") || sObject.getHireLabor10().equals("Ya")) {
                                fragment10.mainint("gap", "extra", "labor", plot10Area, avgCost, age10);
                                fragment10.other("labor");
                            } else if (sObject.getHireLabor10().equals("Seasonal") || sObject.getHireLabor10().equals("Musiman")) {
                                fragment10.mainint("gap", "extra", "season", plot10Area, avgCost, age10);
                                fragment10.other("labor");
                            } else {
                                fragment10.mainint("gap", "extra", "", plot10Area, avgCost, age10);
                            }
                        } else {
                            if (sObject.getHireLabor10().equals("Yes") || sObject.getHireLabor10().equals("Ya")) {
                                fragment10.mainint("gap", "", "labor", plot10Area, avgCost, age10);
                                fragment10.other("labor");
                            } else if (sObject.getHireLabor10().equals("Seasonal") || sObject.getHireLabor10().equals("Musiman")) {
                                fragment10.mainint("gap", "", "season", plot10Area, avgCost, age10);
                                fragment10.other("labor");
                            } else {
                                fragment10.mainint("gap", "", "", plot10Area, avgCost, age10);
                            }
                        }
                    }
                }

                //other interventions
                if (sObject.getLimeNeed10().equals("Yes")||sObject.getLimeNeed10().equals("Ya")) {
                    fragment10.other("lime");
                }

                if (sObject.getFillingOption10().equals("Yes")||sObject.getFillingOption10().equals("Ya")) {
                    if (sObject.getPlot10CocoaTrees().contentEquals("2x2")||sObject.getPlot10CocoaTrees().contentEquals("2x2.5")||sObject.getPlot10CocoaTrees().contentEquals("2x3")||sObject.getPlot10CocoaTrees().contentEquals("2.5x2.5")) {
                        fragment10.other("thinning");
                    }else{
                        fragment10.other("filling");
                    }
                }

                if (sObject.getDrainageNeed10().equals("Yes")||sObject.getDrainageNeed10().equals("Ya")) {
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

    public void calculations() {
        if (sObject != null) {
            DecimalFormat dec = new DecimalFormat("Ghs ###,###,###");
            //net income cocoa
            int totalIncomeY1 = Integer.parseInt(income11.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income21.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income31.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income41.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income51.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income61.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income71.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income81.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income91.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income101.getText().toString().replaceAll("[^0-9]+", ""));
            int totalIncomeY2 = Integer.parseInt(income12.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income22.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income32.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income42.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income52.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income62.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income72.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income82.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income92.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income102.getText().toString().replaceAll("[^0-9]+", ""));
            int totalIncomeY3 = Integer.parseInt(income13.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income23.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income33.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income43.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income53.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income63.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income73.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income83.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income93.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income103.getText().toString().replaceAll("[^0-9]+", ""));
            int totalIncomeY4 = Integer.parseInt(income14.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income24.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income34.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income44.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income54.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income64.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income74.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income84.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income94.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income104.getText().toString().replaceAll("[^0-9]+", ""));
            int totalIncomeY5 = Integer.parseInt(income15.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income25.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income35.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income45.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income55.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income65.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income75.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income85.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income95.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income105.getText().toString().replaceAll("[^0-9]+", ""));
            int totalIncomeY6 = Integer.parseInt(income16.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income26.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income36.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income46.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income56.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income66.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income76.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income86.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income96.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income106.getText().toString().replaceAll("[^0-9]+", ""));
            int totalIncomeY7 = Integer.parseInt(income17.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income27.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income37.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income47.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income57.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income67.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income77.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income87.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income97.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(income107.getText().toString().replaceAll("[^0-9]+", ""));
            setText((TextView) findViewById(R.id.netPlotIncomeY1_field), String.valueOf(dec.format(totalIncomeY1)));
            setText((TextView) findViewById(R.id.netPlotIncomeY2_field), String.valueOf(dec.format(totalIncomeY2)));
            setText((TextView) findViewById(R.id.netPlotIncomeY3_field), String.valueOf(dec.format(totalIncomeY3)));
            setText((TextView) findViewById(R.id.netPlotIncomeY4_field), String.valueOf(dec.format(totalIncomeY4)));
            setText((TextView) findViewById(R.id.netPlotIncomeY5_field), String.valueOf(dec.format(totalIncomeY5)));
            setText((TextView) findViewById(R.id.netPlotIncomeY6_field), String.valueOf(dec.format(totalIncomeY6)));
            setText((TextView) findViewById(R.id.netPlotIncomeY7_field), String.valueOf(dec.format(totalIncomeY7)));

            //net income other crops
            double otherCrops = Double.parseDouble(sObject.getIncomeothercrops());
            setText((TextView) findViewById(R.id.otherCropY1_field), String.valueOf(dec.format(otherCrops)));
            setText((TextView) findViewById(R.id.otherCropY2_field), String.valueOf(dec.format(otherCrops)));
            setText((TextView) findViewById(R.id.otherCropY3_field), String.valueOf(dec.format(otherCrops)));
            setText((TextView) findViewById(R.id.otherCropY4_field), String.valueOf(dec.format(otherCrops)));
            setText((TextView) findViewById(R.id.otherCropY5_field), String.valueOf(dec.format(otherCrops)));
            setText((TextView) findViewById(R.id.otherCropY6_field), String.valueOf(dec.format(otherCrops)));
            setText((TextView) findViewById(R.id.otherCropY7_field), String.valueOf(dec.format(otherCrops)));

            //net income farming
            int farmingy1 = (int) (totalIncomeY1+otherCrops);
            int farmingy2 = (int) (totalIncomeY2+otherCrops);
            int farmingy3 = (int) (totalIncomeY3+otherCrops);
            int farmingy4 = (int) (totalIncomeY4+otherCrops);
            int farmingy5 = (int) (totalIncomeY5+otherCrops);
            int farmingy6 = (int) (totalIncomeY6+otherCrops);
            int farmingy7 = (int) (totalIncomeY7+otherCrops);
            setText((TextView) findViewById(R.id.netFarmingY1_field), String.valueOf(dec.format(farmingy1)));
            setText((TextView) findViewById(R.id.netFarmingY2_field), String.valueOf(dec.format(farmingy2)));
            setText((TextView) findViewById(R.id.netFarmingY3_field), String.valueOf(dec.format(farmingy3)));
            setText((TextView) findViewById(R.id.netFarmingY4_field), String.valueOf(dec.format(farmingy4)));
            setText((TextView) findViewById(R.id.netFarmingY5_field), String.valueOf(dec.format(farmingy5)));
            setText((TextView) findViewById(R.id.netFarmingY6_field), String.valueOf(dec.format(farmingy6)));
            setText((TextView) findViewById(R.id.netFarmingY7_field), String.valueOf(dec.format(farmingy7)));

            //net other income sources
            double moneyBack = Double.parseDouble(sObject.getLoanmoneygetback());
            double farmWork = Double.parseDouble(sObject.getIncomefarmlabor());
            double spouseWork = Double.parseDouble(sObject.getSpouseincome());
            double familyWork = Double.parseDouble(sObject.getFamilymembersincome());
            int totalOtherIncome = (int) (moneyBack+farmWork+spouseWork+familyWork);
            setText((TextView) findViewById(R.id.netOtherY1_field), String.valueOf(dec.format(totalOtherIncome)));
            setText((TextView) findViewById(R.id.netOtherY2_field), String.valueOf(dec.format(totalOtherIncome)));
            setText((TextView) findViewById(R.id.netOtherY3_field), String.valueOf(dec.format(totalOtherIncome)));
            setText((TextView) findViewById(R.id.netOtherY4_field), String.valueOf(dec.format(totalOtherIncome)));
            setText((TextView) findViewById(R.id.netOtherY5_field), String.valueOf(dec.format(totalOtherIncome)));
            setText((TextView) findViewById(R.id.netOtherY6_field), String.valueOf(dec.format(totalOtherIncome)));
            setText((TextView) findViewById(R.id.netOtherY7_field), String.valueOf(dec.format(totalOtherIncome)));

            //total income
            int totalIncomeAllY1 = farmingy1 + totalOtherIncome;
            int totalIncomeAllY2 = farmingy2 + totalOtherIncome;
            int totalIncomeAllY3 = farmingy3 + totalOtherIncome;
            int totalIncomeAllY4 = farmingy4 + totalOtherIncome;
            int totalIncomeAllY5 = farmingy5 + totalOtherIncome;
            int totalIncomeAllY6 = farmingy6 + totalOtherIncome;
            int totalIncomeAllY7 = farmingy7 + totalOtherIncome;
            setText((TextView) findViewById(R.id.totalIncomeY1_field), String.valueOf(dec.format(totalIncomeAllY1)));
            setText((TextView) findViewById(R.id.totalIncomeY2_field), String.valueOf(dec.format(totalIncomeAllY2)));
            setText((TextView) findViewById(R.id.totalIncomeY3_field), String.valueOf(dec.format(totalIncomeAllY3)));
            setText((TextView) findViewById(R.id.totalIncomeY4_field), String.valueOf(dec.format(totalIncomeAllY4)));
            setText((TextView) findViewById(R.id.totalIncomeY5_field), String.valueOf(dec.format(totalIncomeAllY5)));
            setText((TextView) findViewById(R.id.totalIncomeY6_field), String.valueOf(dec.format(totalIncomeAllY6)));
            setText((TextView) findViewById(R.id.totalIncomeY7_field), String.valueOf(dec.format(totalIncomeAllY7)));

            //total family costs
            double anLivExpen = Double.parseDouble(sObject.getAnnuallivingexpenses());
            double anOtherExp = Double.parseDouble(sObject.getAnnualotherexpenses());
            double expEducExp = Double.parseDouble(sObject.getExpectededucationexpenses());
            double credPay = Double.parseDouble(sObject.getHowmuchpayforcredit());
            int totalExpenses = (int) (anLivExpen+anOtherExp+expEducExp+credPay);
            setText((TextView) findViewById(R.id.totalExpensesY1_field), String.valueOf(dec.format(totalExpenses)));
            setText((TextView) findViewById(R.id.totalExpensesY2_field), String.valueOf(dec.format(totalExpenses)));
            setText((TextView) findViewById(R.id.totalExpensesY3_field), String.valueOf(dec.format(totalExpenses)));
            setText((TextView) findViewById(R.id.totalExpensesY4_field), String.valueOf(dec.format(totalExpenses)));
            setText((TextView) findViewById(R.id.totalExpensesY5_field), String.valueOf(dec.format(totalExpenses)));
            setText((TextView) findViewById(R.id.totalExpensesY6_field), String.valueOf(dec.format(totalExpenses)));
            setText((TextView) findViewById(R.id.totalExpensesY7_field), String.valueOf(dec.format(totalExpenses)));

            // net family income
            int availableY1 = totalIncomeAllY1-totalExpenses;
            int availableY2 = totalIncomeAllY2-totalExpenses;
            int availableY3 = totalIncomeAllY3-totalExpenses;
            int availableY4 = totalIncomeAllY4-totalExpenses;
            int availableY5 = totalIncomeAllY5-totalExpenses;
            int availableY6 = totalIncomeAllY6-totalExpenses;
            int availableY7 = totalIncomeAllY7-totalExpenses;
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
            int totalY1 = Integer.parseInt(cost11.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor11.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost21.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor21.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost31.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor31.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost41.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor41.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost51.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor51.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost71.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor71.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost81.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor81.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost91.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor91.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost101.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor101.getText().toString().replaceAll("[^0-9]+", ""));
            int totalY2 = Integer.parseInt(cost12.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor12.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost22.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor22.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost32.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor32.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost42.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor42.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost52.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor52.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost72.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor72.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost82.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor82.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost92.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor92.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost102.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor102.getText().toString().replaceAll("[^0-9]+", ""));
            int totalY3 = Integer.parseInt(cost13.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor13.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost23.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor23.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost33.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor33.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost43.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor43.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost53.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor53.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost73.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor73.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost83.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor83.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost93.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor93.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost103.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor103.getText().toString().replaceAll("[^0-9]+", ""));
            int totalY4 = Integer.parseInt(cost14.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor14.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost24.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor24.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost34.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor34.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost44.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor44.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost54.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor54.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost74.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor74.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost84.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor84.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost94.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor94.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost104.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor104.getText().toString().replaceAll("[^0-9]+", ""));
            int totalY5 = Integer.parseInt(cost15.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor15.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost25.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor25.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost35.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor35.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost45.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor45.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost55.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor55.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost75.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor75.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost85.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor85.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost95.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor95.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost105.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor105.getText().toString().replaceAll("[^0-9]+", ""));
            int totalY6 = Integer.parseInt(cost16.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor16.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost26.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor26.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost36.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor36.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost46.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor46.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost56.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor56.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost76.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor76.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost86.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor86.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost96.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor96.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost106.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor106.getText().toString().replaceAll("[^0-9]+", ""));
            int totalY7 = Integer.parseInt(cost17.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor17.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost27.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor27.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost37.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor37.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost47.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor47.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost57.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor57.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost77.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor77.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost87.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor87.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost97.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor97.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(cost107.getText().toString().replaceAll("[^0-9]+", ""))+Integer.parseInt(labor107.getText().toString().replaceAll("[^0-9]+", ""));
            setText((TextView) findViewById(R.id.foundsNeededY1_field), String.valueOf(dec.format(totalY1)));
            setText((TextView) findViewById(R.id.foundsNeededY2_field), String.valueOf(dec.format(totalY2)));
            setText((TextView) findViewById(R.id.foundsNeededY3_field), String.valueOf(dec.format(totalY3)));
            setText((TextView) findViewById(R.id.foundsNeededY4_field), String.valueOf(dec.format(totalY4)));
            setText((TextView) findViewById(R.id.foundsNeededY5_field), String.valueOf(dec.format(totalY5)));
            setText((TextView) findViewById(R.id.foundsNeededY6_field), String.valueOf(dec.format(totalY6)));
            setText((TextView) findViewById(R.id.foundsNeededY7_field), String.valueOf(dec.format(totalY7)));

            //profit or lost
            int pl1 = availableY1-totalY1;
            int pl2 = availableY2-totalY2;
            int pl3 = availableY3-totalY3;
            int pl4 = availableY4-totalY4;
            int pl5 = availableY5-totalY5;
            int pl6 = availableY6-totalY6;
            int pl7 = availableY7-totalY7;
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
            double hhSavings = Double.parseDouble(sObject.getHouseholdsavings());
            double hhInvestments = Double.parseDouble(sObject.getPlannedinvestments());

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
            contact.put(ContactObject.REASONSNOTAGREED,coments);
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
