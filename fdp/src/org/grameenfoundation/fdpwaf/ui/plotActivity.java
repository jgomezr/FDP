package org.grameenfoundation.fdpwaf.ui;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
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

import org.grameenfoundation.fdpwaf.R;
import org.grameenfoundation.fdpwaf.loaders.ContactDetailLoader;
import org.grameenfoundation.fdpwaf.loaders.ContactListLoader;
import org.grameenfoundation.fdpwaf.objects.ContactObject;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.WeakReference;

/**
 * Created by julian_Gf on 7/4/2016.
 */
public class plotActivity extends SalesforceActivity implements LoaderManager.LoaderCallbacks<ContactObject> {

    private static final int CONTACT_DETAIL_LOADER_ID = 2;
    private static final String TAG = "SmartSyncExplorer: plotActivity";
    private UserAccount curAccount;
    private String objectId;
    private String objectTitle;
    private String objNameKey;
    private ContactObject sObject;
    public static final String OBJECT_ID_KEY = "object_id";
    public static final String OBJECT_TITLE_KEY = "object_title";
    public static final String OBJECT_NAME_KEY = "object_name";
    private LocationManager locationManager;
    private LocationListener locationListener;
    public TextView Lp1, Lp2, Lp3, Lp4, Lp5, Lp6, Lp7, Lp8, Lp9, Lp10,q41,q42;
    public EditText gps1,gps2,gps3,gps4,gps5,gps6,gps7,gps8,gps9,gps10,areP1,areP2,areP3,areP4,areP5,areP6,areP7,areP8,areP9,areP10,estP1,estP2,estP3,estP4,estP5,estP6,estP7,estP8,estP9,estP10,ageP1,steP1,fcondP1,limeNP1,filliP1,ph1,geneticP1,gapP1,soilFertMng1,ageP2,steP2,fcondP2,limeNP2,filliP2,ph2,geneticP2,gapP2,soilFertMng2,ageP3,steP3,fcondP3,limeNP3,filliP3,ph3,geneticP3,gapP3,soilFertMng3,ageP4,steP4,fcondP4,limeNP4,filliP4,ph4,geneticP4,gapP4,soilFertMng4,ageP5,steP5,fcondP5,limeNP5,filliP5,ph5,geneticP5,gapP5,soilFertMng5,ageP6,steP6,fcondP6,limeNP6,filliP6,ph6,geneticP6,gapP6,soilFertMng6,ageP7,steP7,fcondP7,limeNP7,filliP7,ph7,geneticP7,gapP7,soilFertMng7,ageP8,steP8,fcondP8,limeNP8,filliP8,ph8,geneticP8,gapP8,soilFertMng8,ageP9,steP9,fcondP9,limeNP9,filliP9,ph9,geneticP9,gapP9,soilFertMng9,ageP10,steP10,fcondP10,limeNP10,filliP10,ph10,geneticP10,gapP10,soilFertMng10,reco1,reco2,reco3,reco4,reco5,reco6,reco7,reco8,reco9,reco10;
    public Spinner cteP1,plantP1,tehelP1,debDiP1,pruniP1,pesDiP1,weediP1,harveP1,shadeP1,soilCP1,orgMaP1,fertFP1,fertAP1,drainP1,hireNP1,cteP2,plantP2,tehelP2,debDiP2,pruniP2,pesDiP2,weediP2,harveP2,shadeP2,soilCP2,orgMaP2,fertFP2,fertAP2,drainP2,hireNP2,cteP3,plantP3,tehelP3,debDiP3,pruniP3,pesDiP3,weediP3,harveP3,shadeP3,soilCP3,orgMaP3,fertFP3,fertAP3,drainP3,hireNP3,cteP4,plantP4,tehelP4,debDiP4,pruniP4,pesDiP4,weediP4,harveP4,shadeP4,soilCP4,orgMaP4,fertFP4,fertAP4,drainP4,hireNP4,cteP5,plantP5,tehelP5,debDiP5,pruniP5,pesDiP5,weediP5,harveP5,shadeP5,soilCP5,orgMaP5,fertFP5,fertAP5,drainP5,hireNP5,cteP6,plantP6,tehelP6,debDiP6,pruniP6,pesDiP6,weediP6,harveP6,shadeP6,soilCP6,orgMaP6,fertFP6,fertAP6,drainP6,hireNP6,cteP7,plantP7,tehelP7,debDiP7,pruniP7,pesDiP7,weediP7,harveP7,shadeP7,soilCP7,orgMaP7,fertFP7,fertAP7,drainP7,hireNP7,cteP8,plantP8,tehelP8,debDiP8,pruniP8,pesDiP8,weediP8,harveP8,shadeP8,soilCP8,orgMaP8,fertFP8,fertAP8,drainP8,hireNP8,cteP9,plantP9,tehelP9,debDiP9,pruniP9,pesDiP9,weediP9,harveP9,shadeP9,soilCP9,orgMaP9,fertFP9,fertAP9,drainP9,hireNP9,cteP10,plantP10,tehelP10,debDiP10,pruniP10,pesDiP10,weediP10,harveP10,shadeP10,soilCP10,orgMaP10,fertFP10,fertAP10,drainP10,hireNP10,renovP1,renovP2,renovP3,renovP4,renovP5,renovP6,renovP7,renovP8,renovP9,renovP10,renovReasonP1,renovReasonP2,renovReasonP3,renovReasonP4,renovReasonP5,renovReasonP6,renovReasonP7,renovReasonP8,renovReasonP9,renovReasonP10,renovYearP1,renovYearP2,renovYearP3,renovYearP4,renovYearP5,renovYearP6,renovYearP7,renovYearP8,renovYearP9,renovYearP10;
    public plotFragment fragment1,fragment2,fragment3,fragment4,fragment5,fragment6,fragment7,fragment8,fragment9,fragment10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getActionBar().setTitle(R.string.plotActivityTitle);
        setContentView(R.layout.plot);
        final Intent launchIntent = getIntent();
        if (launchIntent != null) {
            objectId = launchIntent.getStringExtra(DetailActivity.OBJECT_ID_KEY);
            objectTitle = launchIntent.getStringExtra(DetailActivity.OBJECT_TITLE_KEY);
            objNameKey = launchIntent.getStringExtra(DetailActivity.OBJECT_NAME_KEY);
        }

        fragment1 = (plotFragment) getFragmentManager().findFragmentById(R.id.fgPlot1);
        fragment2 = (plotFragment) getFragmentManager().findFragmentById(R.id.fgPlot2);
        fragment3 = (plotFragment) getFragmentManager().findFragmentById(R.id.fgPlot3);
        fragment4 = (plotFragment) getFragmentManager().findFragmentById(R.id.fgPlot4);
        fragment5 = (plotFragment) getFragmentManager().findFragmentById(R.id.fgPlot5);
        fragment6 = (plotFragment) getFragmentManager().findFragmentById(R.id.fgPlot6);
        fragment7 = (plotFragment) getFragmentManager().findFragmentById(R.id.fgPlot7);
        fragment8 = (plotFragment) getFragmentManager().findFragmentById(R.id.fgPlot8);
        fragment9 = (plotFragment) getFragmentManager().findFragmentById(R.id.fgPlot9);
        fragment10 = (plotFragment) getFragmentManager().findFragmentById(R.id.fgPlot10);

        Lp1 = (TextView) fragment1.getView().findViewById(R.id.plot_label);
        Lp2 = (TextView) fragment2.getView().findViewById(R.id.plot_label);
        Lp3 = (TextView) fragment3.getView().findViewById(R.id.plot_label);
        Lp4 = (TextView) fragment4.getView().findViewById(R.id.plot_label);
        Lp5 = (TextView) fragment5.getView().findViewById(R.id.plot_label);
        Lp6 = (TextView) fragment6.getView().findViewById(R.id.plot_label);
        Lp7 = (TextView) fragment7.getView().findViewById(R.id.plot_label);
        Lp8 = (TextView) fragment8.getView().findViewById(R.id.plot_label);
        Lp9 = (TextView) fragment9.getView().findViewById(R.id.plot_label);
        Lp10 = (TextView) fragment10.getView().findViewById(R.id.plot_label);
        gps1 = (EditText) fragment1.getView().findViewById(R.id.gpsp_field);
        gps2 = (EditText) fragment2.getView().findViewById(R.id.gpsp_field);
        gps3 = (EditText) fragment3.getView().findViewById(R.id.gpsp_field);
        gps4 = (EditText) fragment4.getView().findViewById(R.id.gpsp_field);
        gps5 = (EditText) fragment5.getView().findViewById(R.id.gpsp_field);
        gps6 = (EditText) fragment6.getView().findViewById(R.id.gpsp_field);
        gps7 = (EditText) fragment7.getView().findViewById(R.id.gpsp_field);
        gps8 = (EditText) fragment8.getView().findViewById(R.id.gpsp_field);
        gps9 = (EditText) fragment9.getView().findViewById(R.id.gpsp_field);
        gps10 = (EditText) fragment10.getView().findViewById(R.id.gpsp_field);
        areP1 = (EditText) fragment1.getView().findViewById(R.id.plotArea_field);
        areP2 = (EditText) fragment2.getView().findViewById(R.id.plotArea_field);
        areP3 = (EditText) fragment3.getView().findViewById(R.id.plotArea_field);
        areP4 = (EditText) fragment4.getView().findViewById(R.id.plotArea_field);
        areP5 = (EditText) fragment5.getView().findViewById(R.id.plotArea_field);
        areP6 = (EditText) fragment6.getView().findViewById(R.id.plotArea_field);
        areP7 = (EditText) fragment7.getView().findViewById(R.id.plotArea_field);
        areP8 = (EditText) fragment8.getView().findViewById(R.id.plotArea_field);
        areP9 = (EditText) fragment9.getView().findViewById(R.id.plotArea_field);
        areP10 = (EditText) fragment10.getView().findViewById(R.id.plotArea_field);
        estP1 = (EditText) fragment1.getView().findViewById(R.id.estimatedP_field);
        estP2 = (EditText) fragment2.getView().findViewById(R.id.estimatedP_field);
        estP3 = (EditText) fragment3.getView().findViewById(R.id.estimatedP_field);
        estP4 = (EditText) fragment4.getView().findViewById(R.id.estimatedP_field);
        estP5 = (EditText) fragment5.getView().findViewById(R.id.estimatedP_field);
        estP6 = (EditText) fragment6.getView().findViewById(R.id.estimatedP_field);
        estP7 = (EditText) fragment7.getView().findViewById(R.id.estimatedP_field);
        estP8 = (EditText) fragment8.getView().findViewById(R.id.estimatedP_field);
        estP9 = (EditText) fragment9.getView().findViewById(R.id.estimatedP_field);
        estP10 = (EditText) fragment10.getView().findViewById(R.id.estimatedP_field);
        ageP1 = (EditText) fragment1.getView().findViewById(R.id.plotAgep_field);
        fcondP1 = (EditText) fragment1.getView().findViewById(R.id.farmConditionP_field);
        limeNP1 = (EditText) fragment1.getView().findViewById(R.id.limeP_field);
        filliP1 = (EditText) fragment1.getView().findViewById(R.id.fillingP_field);
        ph1 = (EditText) fragment1.getView().findViewById(R.id.ph_field);
        geneticP1 = (EditText) fragment1.getView().findViewById(R.id.geneticP_field);
        gapP1 = (EditText) fragment1.getView().findViewById(R.id.gapP_field);
        soilFertMng1 = (EditText) fragment1.getView().findViewById(R.id.soilFertMng_field);
        cteP1 = (Spinner) fragment1.getView().findViewById(R.id.cocoaTreesP_field);
        plantP1 = (Spinner) fragment1.getView().findViewById(R.id.plantingP_field);
        tehelP1 = (Spinner) fragment1.getView().findViewById(R.id.treeHealthP_field);
        debDiP1 = (Spinner) fragment1.getView().findViewById(R.id.debilitationP_field);
        pruniP1 = (Spinner) fragment1.getView().findViewById(R.id.pruningP_field);
        pesDiP1 = (Spinner) fragment1.getView().findViewById(R.id.pestDiseaseP_field);
        weediP1 = (Spinner) fragment1.getView().findViewById(R.id.weedingP_field);
        harveP1 = (Spinner) fragment1.getView().findViewById(R.id.harvestingP_field);
        shadeP1 = (Spinner) fragment1.getView().findViewById(R.id.shadeManagementP_field);
        soilCP1 = (Spinner) fragment1.getView().findViewById(R.id.soilConditionP_field);
        orgMaP1 = (Spinner) fragment1.getView().findViewById(R.id.organicMatterP_field);
        fertFP1 = (Spinner) fragment1.getView().findViewById(R.id.fertFormP_field);
        fertAP1 = (Spinner) fragment1.getView().findViewById(R.id.fertApplicationP_field);
        drainP1 = (Spinner) fragment1.getView().findViewById(R.id.drainageP_field);
        hireNP1 = (Spinner) fragment1.getView().findViewById(R.id.hireP_field);
        ageP2 = (EditText) fragment2.getView().findViewById(R.id.plotAgep_field);
        fcondP2 = (EditText) fragment2.getView().findViewById(R.id.farmConditionP_field);
        limeNP2 = (EditText) fragment2.getView().findViewById(R.id.limeP_field);
        filliP2 = (EditText) fragment2.getView().findViewById(R.id.fillingP_field);
        ph2 = (EditText) fragment2.getView().findViewById(R.id.ph_field);
        geneticP2 = (EditText) fragment2.getView().findViewById(R.id.geneticP_field);
        gapP2 = (EditText) fragment2.getView().findViewById(R.id.gapP_field);
        soilFertMng2 = (EditText) fragment2.getView().findViewById(R.id.soilFertMng_field);
        cteP2 = (Spinner) fragment2.getView().findViewById(R.id.cocoaTreesP_field);
        plantP2 = (Spinner) fragment2.getView().findViewById(R.id.plantingP_field);
        tehelP2 = (Spinner) fragment2.getView().findViewById(R.id.treeHealthP_field);
        debDiP2 = (Spinner) fragment2.getView().findViewById(R.id.debilitationP_field);
        pruniP2 = (Spinner) fragment2.getView().findViewById(R.id.pruningP_field);
        pesDiP2 = (Spinner) fragment2.getView().findViewById(R.id.pestDiseaseP_field);
        weediP2 = (Spinner) fragment2.getView().findViewById(R.id.weedingP_field);
        harveP2 = (Spinner) fragment2.getView().findViewById(R.id.harvestingP_field);
        shadeP2 = (Spinner) fragment2.getView().findViewById(R.id.shadeManagementP_field);
        soilCP2 = (Spinner) fragment2.getView().findViewById(R.id.soilConditionP_field);
        orgMaP2 = (Spinner) fragment2.getView().findViewById(R.id.organicMatterP_field);
        fertFP2 = (Spinner) fragment2.getView().findViewById(R.id.fertFormP_field);
        fertAP2 = (Spinner) fragment2.getView().findViewById(R.id.fertApplicationP_field);
        drainP2 = (Spinner) fragment2.getView().findViewById(R.id.drainageP_field);
        hireNP2 = (Spinner) fragment2.getView().findViewById(R.id.hireP_field);
        ageP3 = (EditText) fragment3.getView().findViewById(R.id.plotAgep_field);
        fcondP3 = (EditText) fragment3.getView().findViewById(R.id.farmConditionP_field);
        limeNP3 = (EditText) fragment3.getView().findViewById(R.id.limeP_field);
        filliP3 = (EditText) fragment3.getView().findViewById(R.id.fillingP_field);
        ph3 = (EditText) fragment3.getView().findViewById(R.id.ph_field);
        geneticP3 = (EditText) fragment3.getView().findViewById(R.id.geneticP_field);
        gapP3 = (EditText) fragment3.getView().findViewById(R.id.gapP_field);
        soilFertMng3 = (EditText) fragment3.getView().findViewById(R.id.soilFertMng_field);
        cteP3 = (Spinner) fragment3.getView().findViewById(R.id.cocoaTreesP_field);
        plantP3 = (Spinner) fragment3.getView().findViewById(R.id.plantingP_field);
        tehelP3 = (Spinner) fragment3.getView().findViewById(R.id.treeHealthP_field);
        debDiP3 = (Spinner) fragment3.getView().findViewById(R.id.debilitationP_field);
        pruniP3 = (Spinner) fragment3.getView().findViewById(R.id.pruningP_field);
        pesDiP3 = (Spinner) fragment3.getView().findViewById(R.id.pestDiseaseP_field);
        weediP3 = (Spinner) fragment3.getView().findViewById(R.id.weedingP_field);
        harveP3 = (Spinner) fragment3.getView().findViewById(R.id.harvestingP_field);
        shadeP3 = (Spinner) fragment3.getView().findViewById(R.id.shadeManagementP_field);
        soilCP3 = (Spinner) fragment3.getView().findViewById(R.id.soilConditionP_field);
        orgMaP3 = (Spinner) fragment3.getView().findViewById(R.id.organicMatterP_field);
        fertFP3 = (Spinner) fragment3.getView().findViewById(R.id.fertFormP_field);
        fertAP3 = (Spinner) fragment3.getView().findViewById(R.id.fertApplicationP_field);
        drainP3 = (Spinner) fragment3.getView().findViewById(R.id.drainageP_field);
        hireNP3 = (Spinner) fragment3.getView().findViewById(R.id.hireP_field);
        ageP4 = (EditText) fragment4.getView().findViewById(R.id.plotAgep_field);
        fcondP4 = (EditText) fragment4.getView().findViewById(R.id.farmConditionP_field);
        limeNP4 = (EditText) fragment4.getView().findViewById(R.id.limeP_field);
        filliP4 = (EditText) fragment4.getView().findViewById(R.id.fillingP_field);
        ph4 = (EditText) fragment4.getView().findViewById(R.id.ph_field);
        geneticP4 = (EditText) fragment4.getView().findViewById(R.id.geneticP_field);
        gapP4 = (EditText) fragment4.getView().findViewById(R.id.gapP_field);
        soilFertMng4 = (EditText) fragment4.getView().findViewById(R.id.soilFertMng_field);
        cteP4 = (Spinner) fragment4.getView().findViewById(R.id.cocoaTreesP_field);
        plantP4 = (Spinner) fragment4.getView().findViewById(R.id.plantingP_field);
        tehelP4 = (Spinner) fragment4.getView().findViewById(R.id.treeHealthP_field);
        debDiP4 = (Spinner) fragment4.getView().findViewById(R.id.debilitationP_field);
        pruniP4 = (Spinner) fragment4.getView().findViewById(R.id.pruningP_field);
        pesDiP4 = (Spinner) fragment4.getView().findViewById(R.id.pestDiseaseP_field);
        weediP4 = (Spinner) fragment4.getView().findViewById(R.id.weedingP_field);
        harveP4 = (Spinner) fragment4.getView().findViewById(R.id.harvestingP_field);
        shadeP4 = (Spinner) fragment4.getView().findViewById(R.id.shadeManagementP_field);
        soilCP4 = (Spinner) fragment4.getView().findViewById(R.id.soilConditionP_field);
        orgMaP4 = (Spinner) fragment4.getView().findViewById(R.id.organicMatterP_field);
        fertFP4 = (Spinner) fragment4.getView().findViewById(R.id.fertFormP_field);
        fertAP4 = (Spinner) fragment4.getView().findViewById(R.id.fertApplicationP_field);
        drainP4 = (Spinner) fragment4.getView().findViewById(R.id.drainageP_field);
        hireNP4 = (Spinner) fragment4.getView().findViewById(R.id.hireP_field);
        ageP5 = (EditText) fragment5.getView().findViewById(R.id.plotAgep_field);
        fcondP5 = (EditText) fragment5.getView().findViewById(R.id.farmConditionP_field);
        limeNP5 = (EditText) fragment5.getView().findViewById(R.id.limeP_field);
        filliP5 = (EditText) fragment5.getView().findViewById(R.id.fillingP_field);
        ph5 = (EditText) fragment5.getView().findViewById(R.id.ph_field);
        geneticP5 = (EditText) fragment5.getView().findViewById(R.id.geneticP_field);
        gapP5 = (EditText) fragment5.getView().findViewById(R.id.gapP_field);
        soilFertMng5 = (EditText) fragment5.getView().findViewById(R.id.soilFertMng_field);
        cteP5 = (Spinner) fragment5.getView().findViewById(R.id.cocoaTreesP_field);
        plantP5 = (Spinner) fragment5.getView().findViewById(R.id.plantingP_field);
        tehelP5 = (Spinner) fragment5.getView().findViewById(R.id.treeHealthP_field);
        debDiP5 = (Spinner) fragment5.getView().findViewById(R.id.debilitationP_field);
        pruniP5 = (Spinner) fragment5.getView().findViewById(R.id.pruningP_field);
        pesDiP5 = (Spinner) fragment5.getView().findViewById(R.id.pestDiseaseP_field);
        weediP5 = (Spinner) fragment5.getView().findViewById(R.id.weedingP_field);
        harveP5 = (Spinner) fragment5.getView().findViewById(R.id.harvestingP_field);
        shadeP5 = (Spinner) fragment5.getView().findViewById(R.id.shadeManagementP_field);
        soilCP5 = (Spinner) fragment5.getView().findViewById(R.id.soilConditionP_field);
        orgMaP5 = (Spinner) fragment5.getView().findViewById(R.id.organicMatterP_field);
        fertFP5 = (Spinner) fragment5.getView().findViewById(R.id.fertFormP_field);
        fertAP5 = (Spinner) fragment5.getView().findViewById(R.id.fertApplicationP_field);
        drainP5 = (Spinner) fragment5.getView().findViewById(R.id.drainageP_field);
        hireNP5 = (Spinner) fragment5.getView().findViewById(R.id.hireP_field);
        ageP6 = (EditText) fragment6.getView().findViewById(R.id.plotAgep_field);
        fcondP6 = (EditText) fragment6.getView().findViewById(R.id.farmConditionP_field);
        limeNP6 = (EditText) fragment6.getView().findViewById(R.id.limeP_field);
        filliP6 = (EditText) fragment6.getView().findViewById(R.id.fillingP_field);
        ph6 = (EditText) fragment6.getView().findViewById(R.id.ph_field);
        geneticP6 = (EditText) fragment6.getView().findViewById(R.id.geneticP_field);
        gapP6 = (EditText) fragment6.getView().findViewById(R.id.gapP_field);
        soilFertMng6 = (EditText) fragment6.getView().findViewById(R.id.soilFertMng_field);
        cteP6 = (Spinner) fragment6.getView().findViewById(R.id.cocoaTreesP_field);
        plantP6 = (Spinner) fragment6.getView().findViewById(R.id.plantingP_field);
        tehelP6 = (Spinner) fragment6.getView().findViewById(R.id.treeHealthP_field);
        debDiP6 = (Spinner) fragment6.getView().findViewById(R.id.debilitationP_field);
        pruniP6 = (Spinner) fragment6.getView().findViewById(R.id.pruningP_field);
        pesDiP6 = (Spinner) fragment6.getView().findViewById(R.id.pestDiseaseP_field);
        weediP6 = (Spinner) fragment6.getView().findViewById(R.id.weedingP_field);
        harveP6 = (Spinner) fragment6.getView().findViewById(R.id.harvestingP_field);
        shadeP6 = (Spinner) fragment6.getView().findViewById(R.id.shadeManagementP_field);
        soilCP6 = (Spinner) fragment6.getView().findViewById(R.id.soilConditionP_field);
        orgMaP6 = (Spinner) fragment6.getView().findViewById(R.id.organicMatterP_field);
        fertFP6 = (Spinner) fragment6.getView().findViewById(R.id.fertFormP_field);
        fertAP6 = (Spinner) fragment6.getView().findViewById(R.id.fertApplicationP_field);
        drainP6 = (Spinner) fragment6.getView().findViewById(R.id.drainageP_field);
        hireNP6 = (Spinner) fragment6.getView().findViewById(R.id.hireP_field);
        ageP7 = (EditText) fragment7.getView().findViewById(R.id.plotAgep_field);
        fcondP7 = (EditText) fragment7.getView().findViewById(R.id.farmConditionP_field);
        limeNP7 = (EditText) fragment7.getView().findViewById(R.id.limeP_field);
        filliP7 = (EditText) fragment7.getView().findViewById(R.id.fillingP_field);
        ph7 = (EditText) fragment7.getView().findViewById(R.id.ph_field);
        geneticP7 = (EditText) fragment7.getView().findViewById(R.id.geneticP_field);
        gapP7 = (EditText) fragment7.getView().findViewById(R.id.gapP_field);
        soilFertMng7 = (EditText) fragment7.getView().findViewById(R.id.soilFertMng_field);
        cteP7 = (Spinner) fragment7.getView().findViewById(R.id.cocoaTreesP_field);
        plantP7 = (Spinner) fragment7.getView().findViewById(R.id.plantingP_field);
        tehelP7 = (Spinner) fragment7.getView().findViewById(R.id.treeHealthP_field);
        debDiP7 = (Spinner) fragment7.getView().findViewById(R.id.debilitationP_field);
        pruniP7 = (Spinner) fragment7.getView().findViewById(R.id.pruningP_field);
        pesDiP7 = (Spinner) fragment7.getView().findViewById(R.id.pestDiseaseP_field);
        weediP7 = (Spinner) fragment7.getView().findViewById(R.id.weedingP_field);
        harveP7 = (Spinner) fragment7.getView().findViewById(R.id.harvestingP_field);
        shadeP7 = (Spinner) fragment7.getView().findViewById(R.id.shadeManagementP_field);
        soilCP7 = (Spinner) fragment7.getView().findViewById(R.id.soilConditionP_field);
        orgMaP7 = (Spinner) fragment7.getView().findViewById(R.id.organicMatterP_field);
        fertFP7 = (Spinner) fragment7.getView().findViewById(R.id.fertFormP_field);
        fertAP7 = (Spinner) fragment7.getView().findViewById(R.id.fertApplicationP_field);
        drainP7 = (Spinner) fragment7.getView().findViewById(R.id.drainageP_field);
        hireNP7 = (Spinner) fragment7.getView().findViewById(R.id.hireP_field);
        ageP8 = (EditText) fragment8.getView().findViewById(R.id.plotAgep_field);
        fcondP8 = (EditText) fragment8.getView().findViewById(R.id.farmConditionP_field);
        limeNP8 = (EditText) fragment8.getView().findViewById(R.id.limeP_field);
        filliP8 = (EditText) fragment8.getView().findViewById(R.id.fillingP_field);
        ph8 = (EditText) fragment8.getView().findViewById(R.id.ph_field);
        geneticP8 = (EditText) fragment8.getView().findViewById(R.id.geneticP_field);
        gapP8 = (EditText) fragment8.getView().findViewById(R.id.gapP_field);
        soilFertMng8 = (EditText) fragment8.getView().findViewById(R.id.soilFertMng_field);
        cteP8 = (Spinner) fragment8.getView().findViewById(R.id.cocoaTreesP_field);
        plantP8 = (Spinner) fragment8.getView().findViewById(R.id.plantingP_field);
        tehelP8 = (Spinner) fragment8.getView().findViewById(R.id.treeHealthP_field);
        debDiP8 = (Spinner) fragment8.getView().findViewById(R.id.debilitationP_field);
        pruniP8 = (Spinner) fragment8.getView().findViewById(R.id.pruningP_field);
        pesDiP8 = (Spinner) fragment8.getView().findViewById(R.id.pestDiseaseP_field);
        weediP8 = (Spinner) fragment8.getView().findViewById(R.id.weedingP_field);
        harveP8 = (Spinner) fragment8.getView().findViewById(R.id.harvestingP_field);
        shadeP8 = (Spinner) fragment8.getView().findViewById(R.id.shadeManagementP_field);
        soilCP8 = (Spinner) fragment8.getView().findViewById(R.id.soilConditionP_field);
        orgMaP8 = (Spinner) fragment8.getView().findViewById(R.id.organicMatterP_field);
        fertFP8 = (Spinner) fragment8.getView().findViewById(R.id.fertFormP_field);
        fertAP8 = (Spinner) fragment8.getView().findViewById(R.id.fertApplicationP_field);
        drainP8 = (Spinner) fragment8.getView().findViewById(R.id.drainageP_field);
        hireNP8 = (Spinner) fragment8.getView().findViewById(R.id.hireP_field);
        ageP9 = (EditText) fragment9.getView().findViewById(R.id.plotAgep_field);
        fcondP9 = (EditText) fragment9.getView().findViewById(R.id.farmConditionP_field);
        limeNP9 = (EditText) fragment9.getView().findViewById(R.id.limeP_field);
        filliP9 = (EditText) fragment9.getView().findViewById(R.id.fillingP_field);
        ph9 = (EditText) fragment9.getView().findViewById(R.id.ph_field);
        geneticP9 = (EditText) fragment9.getView().findViewById(R.id.geneticP_field);
        gapP9 = (EditText) fragment9.getView().findViewById(R.id.gapP_field);
        soilFertMng9 = (EditText) fragment9.getView().findViewById(R.id.soilFertMng_field);
        cteP9 = (Spinner) fragment9.getView().findViewById(R.id.cocoaTreesP_field);
        plantP9 = (Spinner) fragment9.getView().findViewById(R.id.plantingP_field);
        tehelP9 = (Spinner) fragment9.getView().findViewById(R.id.treeHealthP_field);
        debDiP9 = (Spinner) fragment9.getView().findViewById(R.id.debilitationP_field);
        pruniP9 = (Spinner) fragment9.getView().findViewById(R.id.pruningP_field);
        pesDiP9 = (Spinner) fragment9.getView().findViewById(R.id.pestDiseaseP_field);
        weediP9 = (Spinner) fragment9.getView().findViewById(R.id.weedingP_field);
        harveP9 = (Spinner) fragment9.getView().findViewById(R.id.harvestingP_field);
        shadeP9 = (Spinner) fragment9.getView().findViewById(R.id.shadeManagementP_field);
        soilCP9 = (Spinner) fragment9.getView().findViewById(R.id.soilConditionP_field);
        orgMaP9 = (Spinner) fragment9.getView().findViewById(R.id.organicMatterP_field);
        fertFP9 = (Spinner) fragment9.getView().findViewById(R.id.fertFormP_field);
        fertAP9 = (Spinner) fragment9.getView().findViewById(R.id.fertApplicationP_field);
        drainP9 = (Spinner) fragment9.getView().findViewById(R.id.drainageP_field);
        hireNP9 = (Spinner) fragment9.getView().findViewById(R.id.hireP_field);
        ageP10 = (EditText) fragment10.getView().findViewById(R.id.plotAgep_field);
        fcondP10 = (EditText) fragment10.getView().findViewById(R.id.farmConditionP_field);
        limeNP10 = (EditText) fragment10.getView().findViewById(R.id.limeP_field);
        filliP10 = (EditText) fragment10.getView().findViewById(R.id.fillingP_field);
        ph10 = (EditText) fragment10.getView().findViewById(R.id.ph_field);
        geneticP10 = (EditText) fragment10.getView().findViewById(R.id.geneticP_field);
        gapP10 = (EditText) fragment10.getView().findViewById(R.id.gapP_field);
        soilFertMng10 = (EditText) fragment10.getView().findViewById(R.id.soilFertMng_field);
        cteP10 = (Spinner) fragment10.getView().findViewById(R.id.cocoaTreesP_field);
        plantP10 = (Spinner) fragment10.getView().findViewById(R.id.plantingP_field);
        tehelP10 = (Spinner) fragment10.getView().findViewById(R.id.treeHealthP_field);
        debDiP10 = (Spinner) fragment10.getView().findViewById(R.id.debilitationP_field);
        pruniP10 = (Spinner) fragment10.getView().findViewById(R.id.pruningP_field);
        pesDiP10 = (Spinner) fragment10.getView().findViewById(R.id.pestDiseaseP_field);
        weediP10 = (Spinner) fragment10.getView().findViewById(R.id.weedingP_field);
        harveP10 = (Spinner) fragment10.getView().findViewById(R.id.harvestingP_field);
        shadeP10 = (Spinner) fragment10.getView().findViewById(R.id.shadeManagementP_field);
        soilCP10 = (Spinner) fragment10.getView().findViewById(R.id.soilConditionP_field);
        orgMaP10 = (Spinner) fragment10.getView().findViewById(R.id.organicMatterP_field);
        fertFP10 = (Spinner) fragment10.getView().findViewById(R.id.fertFormP_field);
        fertAP10 = (Spinner) fragment10.getView().findViewById(R.id.fertApplicationP_field);
        drainP10 = (Spinner) fragment10.getView().findViewById(R.id.drainageP_field);
        hireNP10 = (Spinner) fragment10.getView().findViewById(R.id.hireP_field);
        renovP1 = (Spinner) fragment1.getView().findViewById(R.id.renovated_field);
        renovP2 = (Spinner) fragment2.getView().findViewById(R.id.renovated_field);
        renovP3 = (Spinner) fragment3.getView().findViewById(R.id.renovated_field);
        renovP4 = (Spinner) fragment4.getView().findViewById(R.id.renovated_field);
        renovP5 = (Spinner) fragment5.getView().findViewById(R.id.renovated_field);
        renovP6 = (Spinner) fragment6.getView().findViewById(R.id.renovated_field);
        renovP7 = (Spinner) fragment7.getView().findViewById(R.id.renovated_field);
        renovP8 = (Spinner) fragment8.getView().findViewById(R.id.renovated_field);
        renovP9 = (Spinner) fragment9.getView().findViewById(R.id.renovated_field);
        renovP10 = (Spinner) fragment10.getView().findViewById(R.id.renovated_field);
        renovReasonP1 = (Spinner) fragment1.getView().findViewById(R.id.reason_field);
        renovReasonP2 = (Spinner) fragment2.getView().findViewById(R.id.reason_field);
        renovReasonP3 = (Spinner) fragment3.getView().findViewById(R.id.reason_field);
        renovReasonP4 = (Spinner) fragment4.getView().findViewById(R.id.reason_field);
        renovReasonP5 = (Spinner) fragment5.getView().findViewById(R.id.reason_field);
        renovReasonP6 = (Spinner) fragment6.getView().findViewById(R.id.reason_field);
        renovReasonP7 = (Spinner) fragment7.getView().findViewById(R.id.reason_field);
        renovReasonP8 = (Spinner) fragment8.getView().findViewById(R.id.reason_field);
        renovReasonP9 = (Spinner) fragment9.getView().findViewById(R.id.reason_field);
        renovReasonP10 = (Spinner) fragment10.getView().findViewById(R.id.reason_field);
        renovYearP1 = (Spinner) fragment1.getView().findViewById(R.id.howLong_field);
        renovYearP2 = (Spinner) fragment2.getView().findViewById(R.id.howLong_field);
        renovYearP3 = (Spinner) fragment3.getView().findViewById(R.id.howLong_field);
        renovYearP4 = (Spinner) fragment4.getView().findViewById(R.id.howLong_field);
        renovYearP5 = (Spinner) fragment5.getView().findViewById(R.id.howLong_field);
        renovYearP6 = (Spinner) fragment6.getView().findViewById(R.id.howLong_field);
        renovYearP7 = (Spinner) fragment7.getView().findViewById(R.id.howLong_field);
        renovYearP8 = (Spinner) fragment8.getView().findViewById(R.id.howLong_field);
        renovYearP9 = (Spinner) fragment9.getView().findViewById(R.id.howLong_field);
        renovYearP10 = (Spinner) fragment10.getView().findViewById(R.id.howLong_field);
        q41 = (TextView) findViewById(R.id.q41);
        q42 = (TextView) findViewById(R.id.q42);
        reco1 = (EditText) fragment1.getView().findViewById(R.id.reco_field);
        reco2 = (EditText) fragment2.getView().findViewById(R.id.reco_field);
        reco3 = (EditText) fragment3.getView().findViewById(R.id.reco_field);
        reco4 = (EditText) fragment4.getView().findViewById(R.id.reco_field);
        reco5 = (EditText) fragment5.getView().findViewById(R.id.reco_field);
        reco6 = (EditText) fragment6.getView().findViewById(R.id.reco_field);
        reco7 = (EditText) fragment7.getView().findViewById(R.id.reco_field);
        reco8 = (EditText) fragment8.getView().findViewById(R.id.reco_field);
        reco9 = (EditText) fragment9.getView().findViewById(R.id.reco_field);
        reco10 = (EditText) fragment10.getView().findViewById(R.id.reco_field);

        gps1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                locationListener = new LocationListener() {
                    public void onLocationChanged(Location location) {
                        setText(gps1, location.convert(location.getLatitude(), Location.FORMAT_MINUTES) + "/" + location.convert(location.getLongitude(), Location.FORMAT_MINUTES));
                        onStop();
                    }

                    public void onStatusChanged(String provider, int status, Bundle extras) {
                    }

                    public void onProviderEnabled(String provider) {
                    }

                    public void onProviderDisabled(String provider) {
                        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivity(intent);
                    }
                    public void onStop(){
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            if (checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                                requestPermissions(new String[]{
                                        android.Manifest.permission.ACCESS_FINE_LOCATION,
                                        android.Manifest.permission.ACCESS_COARSE_LOCATION,
                                        android.Manifest.permission.INTERNET
                                }, 10);
                                return;
                            }
                        }
                        locationManager.removeUpdates(locationListener);
                    }

                };

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        requestPermissions(new String[]{
                                android.Manifest.permission.ACCESS_FINE_LOCATION,
                                android.Manifest.permission.ACCESS_COARSE_LOCATION,
                                android.Manifest.permission.INTERNET
                        }, 10);
                        return;
                    }
                }
                String locationProvider = LocationManager.GPS_PROVIDER;
                locationManager.requestLocationUpdates(locationProvider, 0, 0, locationListener);
            }
        });

        gps2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                locationListener = new LocationListener() {
                    public void onLocationChanged(Location location) {
                        setText(gps2, location.convert(location.getLatitude(), Location.FORMAT_MINUTES) + "/" + location.convert(location.getLongitude(), Location.FORMAT_MINUTES));
                        onStop();
                    }

                    public void onStatusChanged(String provider, int status, Bundle extras) {
                    }

                    public void onProviderEnabled(String provider) {
                    }

                    public void onProviderDisabled(String provider) {
                        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivity(intent);
                    }
                    public void onStop(){
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            if (checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                                requestPermissions(new String[]{
                                        android.Manifest.permission.ACCESS_FINE_LOCATION,
                                        android.Manifest.permission.ACCESS_COARSE_LOCATION,
                                        android.Manifest.permission.INTERNET
                                }, 10);
                                return;
                            }
                        }
                        locationManager.removeUpdates(locationListener);
                    }

                };

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        requestPermissions(new String[]{
                                android.Manifest.permission.ACCESS_FINE_LOCATION,
                                android.Manifest.permission.ACCESS_COARSE_LOCATION,
                                android.Manifest.permission.INTERNET
                        }, 10);
                        return;
                    }
                }
                String locationProvider = LocationManager.GPS_PROVIDER;
                locationManager.requestLocationUpdates(locationProvider, 0, 0, locationListener);
            }
        });

        gps3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                locationListener = new LocationListener() {
                    public void onLocationChanged(Location location) {
                        setText(gps3, location.convert(location.getLatitude(), Location.FORMAT_MINUTES) + "/" + location.convert(location.getLongitude(), Location.FORMAT_MINUTES));
                        onStop();
                    }

                    public void onStatusChanged(String provider, int status, Bundle extras) {
                    }

                    public void onProviderEnabled(String provider) {
                    }

                    public void onProviderDisabled(String provider) {
                        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivity(intent);
                    }
                    public void onStop(){
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            if (checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                                requestPermissions(new String[]{
                                        android.Manifest.permission.ACCESS_FINE_LOCATION,
                                        android.Manifest.permission.ACCESS_COARSE_LOCATION,
                                        android.Manifest.permission.INTERNET
                                }, 10);
                                return;
                            }
                        }
                        locationManager.removeUpdates(locationListener);
                    }

                };

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        requestPermissions(new String[]{
                                android.Manifest.permission.ACCESS_FINE_LOCATION,
                                android.Manifest.permission.ACCESS_COARSE_LOCATION,
                                android.Manifest.permission.INTERNET
                        }, 10);
                        return;
                    }
                }
                String locationProvider = LocationManager.GPS_PROVIDER;
                locationManager.requestLocationUpdates(locationProvider, 0, 0, locationListener);
            }
        });

        gps4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                locationListener = new LocationListener() {
                    public void onLocationChanged(Location location) {
                        setText(gps4, location.convert(location.getLatitude(), Location.FORMAT_MINUTES) + "/" + location.convert(location.getLongitude(), Location.FORMAT_MINUTES));
                        onStop();
                    }

                    public void onStatusChanged(String provider, int status, Bundle extras) {
                    }

                    public void onProviderEnabled(String provider) {
                    }

                    public void onProviderDisabled(String provider) {
                        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivity(intent);
                    }
                    public void onStop(){
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            if (checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                                requestPermissions(new String[]{
                                        android.Manifest.permission.ACCESS_FINE_LOCATION,
                                        android.Manifest.permission.ACCESS_COARSE_LOCATION,
                                        android.Manifest.permission.INTERNET
                                }, 10);
                                return;
                            }
                        }
                        locationManager.removeUpdates(locationListener);
                    }

                };

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        requestPermissions(new String[]{
                                android.Manifest.permission.ACCESS_FINE_LOCATION,
                                android.Manifest.permission.ACCESS_COARSE_LOCATION,
                                android.Manifest.permission.INTERNET
                        }, 10);
                        return;
                    }
                }
                String locationProvider = LocationManager.GPS_PROVIDER;
                locationManager.requestLocationUpdates(locationProvider, 0, 0, locationListener);
            }
        });

        gps5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                locationListener = new LocationListener() {
                    public void onLocationChanged(Location location) {
                        setText(gps5, location.convert(location.getLatitude(), Location.FORMAT_MINUTES) + "/" + location.convert(location.getLongitude(), Location.FORMAT_MINUTES));
                        onStop();
                    }

                    public void onStatusChanged(String provider, int status, Bundle extras) {
                    }

                    public void onProviderEnabled(String provider) {
                    }

                    public void onProviderDisabled(String provider) {
                        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivity(intent);
                    }
                    public void onStop(){
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            if (checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                                requestPermissions(new String[]{
                                        android.Manifest.permission.ACCESS_FINE_LOCATION,
                                        android.Manifest.permission.ACCESS_COARSE_LOCATION,
                                        android.Manifest.permission.INTERNET
                                }, 10);
                                return;
                            }
                        }
                        locationManager.removeUpdates(locationListener);
                    }

                };

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        requestPermissions(new String[]{
                                android.Manifest.permission.ACCESS_FINE_LOCATION,
                                android.Manifest.permission.ACCESS_COARSE_LOCATION,
                                android.Manifest.permission.INTERNET
                        }, 10);
                        return;
                    }
                }
                String locationProvider = LocationManager.GPS_PROVIDER;
                locationManager.requestLocationUpdates(locationProvider, 0, 0, locationListener);
            }
        });

        gps6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                locationListener = new LocationListener() {
                    public void onLocationChanged(Location location) {
                        setText(gps6, location.convert(location.getLatitude(), Location.FORMAT_MINUTES) + "/" + location.convert(location.getLongitude(), Location.FORMAT_MINUTES));
                        onStop();
                    }

                    public void onStatusChanged(String provider, int status, Bundle extras) {
                    }

                    public void onProviderEnabled(String provider) {
                    }

                    public void onProviderDisabled(String provider) {
                        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivity(intent);
                    }
                    public void onStop(){
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            if (checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                                requestPermissions(new String[]{
                                        android.Manifest.permission.ACCESS_FINE_LOCATION,
                                        android.Manifest.permission.ACCESS_COARSE_LOCATION,
                                        android.Manifest.permission.INTERNET
                                }, 10);
                                return;
                            }
                        }
                        locationManager.removeUpdates(locationListener);
                    }

                };

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        requestPermissions(new String[]{
                                android.Manifest.permission.ACCESS_FINE_LOCATION,
                                android.Manifest.permission.ACCESS_COARSE_LOCATION,
                                android.Manifest.permission.INTERNET
                        }, 10);
                        return;
                    }
                }
                String locationProvider = LocationManager.GPS_PROVIDER;
                locationManager.requestLocationUpdates(locationProvider, 0, 0, locationListener);
            }
        });

        gps7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                locationListener = new LocationListener() {
                    public void onLocationChanged(Location location) {
                        setText(gps7, location.convert(location.getLatitude(), Location.FORMAT_MINUTES) + "/" + location.convert(location.getLongitude(), Location.FORMAT_MINUTES));
                        onStop();
                    }

                    public void onStatusChanged(String provider, int status, Bundle extras) {
                    }

                    public void onProviderEnabled(String provider) {
                    }

                    public void onProviderDisabled(String provider) {
                        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivity(intent);
                    }
                    public void onStop(){
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            if (checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                                requestPermissions(new String[]{
                                        android.Manifest.permission.ACCESS_FINE_LOCATION,
                                        android.Manifest.permission.ACCESS_COARSE_LOCATION,
                                        android.Manifest.permission.INTERNET
                                }, 10);
                                return;
                            }
                        }
                        locationManager.removeUpdates(locationListener);
                    }

                };

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        requestPermissions(new String[]{
                                android.Manifest.permission.ACCESS_FINE_LOCATION,
                                android.Manifest.permission.ACCESS_COARSE_LOCATION,
                                android.Manifest.permission.INTERNET
                        }, 10);
                        return;
                    }
                }
                String locationProvider = LocationManager.GPS_PROVIDER;
                locationManager.requestLocationUpdates(locationProvider, 0, 0, locationListener);
            }
        });

        gps8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                locationListener = new LocationListener() {
                    public void onLocationChanged(Location location) {
                        setText(gps8, location.convert(location.getLatitude(), Location.FORMAT_MINUTES) + "/" + location.convert(location.getLongitude(), Location.FORMAT_MINUTES));
                        onStop();
                    }

                    public void onStatusChanged(String provider, int status, Bundle extras) {
                    }

                    public void onProviderEnabled(String provider) {
                    }

                    public void onProviderDisabled(String provider) {
                        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivity(intent);
                    }
                    public void onStop(){
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            if (checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                                requestPermissions(new String[]{
                                        android.Manifest.permission.ACCESS_FINE_LOCATION,
                                        android.Manifest.permission.ACCESS_COARSE_LOCATION,
                                        android.Manifest.permission.INTERNET
                                }, 10);
                                return;
                            }
                        }
                        locationManager.removeUpdates(locationListener);
                    }

                };

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        requestPermissions(new String[]{
                                android.Manifest.permission.ACCESS_FINE_LOCATION,
                                android.Manifest.permission.ACCESS_COARSE_LOCATION,
                                android.Manifest.permission.INTERNET
                        }, 10);
                        return;
                    }
                }
                String locationProvider = LocationManager.GPS_PROVIDER;
                locationManager.requestLocationUpdates(locationProvider, 0, 0, locationListener);
            }
        });

        gps9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                locationListener = new LocationListener() {
                    public void onLocationChanged(Location location) {
                        setText(gps9, location.convert(location.getLatitude(), Location.FORMAT_MINUTES) + "/" + location.convert(location.getLongitude(), Location.FORMAT_MINUTES));
                        onStop();
                    }

                    public void onStatusChanged(String provider, int status, Bundle extras) {
                    }

                    public void onProviderEnabled(String provider) {
                    }

                    public void onProviderDisabled(String provider) {
                        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivity(intent);
                    }
                    public void onStop(){
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            if (checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                                requestPermissions(new String[]{
                                        android.Manifest.permission.ACCESS_FINE_LOCATION,
                                        android.Manifest.permission.ACCESS_COARSE_LOCATION,
                                        android.Manifest.permission.INTERNET
                                }, 10);
                                return;
                            }
                        }
                        locationManager.removeUpdates(locationListener);
                    }

                };

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        requestPermissions(new String[]{
                                android.Manifest.permission.ACCESS_FINE_LOCATION,
                                android.Manifest.permission.ACCESS_COARSE_LOCATION,
                                android.Manifest.permission.INTERNET
                        }, 10);
                        return;
                    }
                }
                String locationProvider = LocationManager.GPS_PROVIDER;
                locationManager.requestLocationUpdates(locationProvider, 0, 0, locationListener);
            }
        });

        gps10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                locationListener = new LocationListener() {
                    public void onLocationChanged(Location location) {
                        setText(gps10, location.convert(location.getLatitude(), Location.FORMAT_MINUTES) + "/" + location.convert(location.getLongitude(), Location.FORMAT_MINUTES));
                        onStop();
                    }

                    public void onStatusChanged(String provider, int status, Bundle extras) {
                    }

                    public void onProviderEnabled(String provider) {
                    }

                    public void onProviderDisabled(String provider) {
                        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivity(intent);
                    }
                    public void onStop(){
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            if (checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                                requestPermissions(new String[]{
                                        android.Manifest.permission.ACCESS_FINE_LOCATION,
                                        android.Manifest.permission.ACCESS_COARSE_LOCATION,
                                        android.Manifest.permission.INTERNET
                                }, 10);
                                return;
                            }
                        }
                        locationManager.removeUpdates(locationListener);
                    }

                };

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        requestPermissions(new String[]{
                                android.Manifest.permission.ACCESS_FINE_LOCATION,
                                android.Manifest.permission.ACCESS_COARSE_LOCATION,
                                android.Manifest.permission.INTERNET
                        }, 10);
                        return;
                    }
                }
                String locationProvider = LocationManager.GPS_PROVIDER;
                locationManager.requestLocationUpdates(locationProvider, 0, 0, locationListener);
            }
        });

        areP1.addTextChangedListener(new areaWatcher(areP1));
        areP2.addTextChangedListener(new areaWatcher(areP2));
        areP3.addTextChangedListener(new areaWatcher(areP3));
        areP4.addTextChangedListener(new areaWatcher(areP4));
        areP5.addTextChangedListener(new areaWatcher(areP5));
        areP6.addTextChangedListener(new areaWatcher(areP6));
        areP7.addTextChangedListener(new areaWatcher(areP7));
        areP8.addTextChangedListener(new areaWatcher(areP8));
        areP9.addTextChangedListener(new areaWatcher(areP9));
        areP10.addTextChangedListener(new areaWatcher(areP10));
        estP1.addTextChangedListener(new prodWatcher(estP1));
        estP2.addTextChangedListener(new prodWatcher(estP2));
        estP3.addTextChangedListener(new prodWatcher(estP3));
        estP4.addTextChangedListener(new prodWatcher(estP4));
        estP5.addTextChangedListener(new prodWatcher(estP5));
        estP6.addTextChangedListener(new prodWatcher(estP6));
        estP7.addTextChangedListener(new prodWatcher(estP7));
        estP8.addTextChangedListener(new prodWatcher(estP8));
        estP9.addTextChangedListener(new prodWatcher(estP9));
        estP10.addTextChangedListener(new prodWatcher(estP10));

    }

    public class areaWatcher implements TextWatcher {
        private final WeakReference<EditText> editTextWeakReference;

        public areaWatcher(EditText editText) {
            editTextWeakReference = new WeakReference<EditText>(editText);
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable editable) {
            EditText editText = editTextWeakReference.get();
            double pA1;
            double pA2;
            double pA3;
            double pA4;
            double pA5;
            double pA6;
            double pA7;
            double pA8;
            double pA9;
            double pA10;
            double tarea;
            if(areP1.getText().toString().isEmpty()||areP2.getText().toString().isEmpty()||areP3.getText().toString().isEmpty()||areP4.getText().toString().isEmpty()||areP5.getText().toString().isEmpty()||areP6.getText().toString().isEmpty()||areP7.getText().toString().isEmpty()||areP8.getText().toString().isEmpty()||areP9.getText().toString().isEmpty()||areP10.getText().toString().isEmpty()){
                pA1=0;
                pA2=0;
                pA3=0;
                pA4=0;
                pA5=0;
                pA6=0;
                pA7=0;
                pA8=0;
                pA9=0;
                pA10=0;
            }else{
                if(areP1.getText().toString().startsWith(".")){
                    pA1 = Double.parseDouble(0+areP1.getText().toString());
                }else {
                    pA1 = Double.parseDouble(areP1.getText().toString());
                }
                if(areP2.getText().toString().startsWith(".")){
                    pA2= Double.parseDouble(0+areP2.getText().toString());
                }else {
                    pA2= Double.parseDouble(areP2.getText().toString());
                }
                if(areP3.getText().toString().startsWith(".")){
                    pA3= Double.parseDouble(0+areP3.getText().toString());
                }else {
                    pA3= Double.parseDouble(areP3.getText().toString());
                }
                if(areP4.getText().toString().startsWith(".")){
                    pA4= Double.parseDouble(0+areP4.getText().toString());
                }else {
                    pA4= Double.parseDouble(areP4.getText().toString());
                }
                if(areP5.getText().toString().startsWith(".")){
                    pA5= Double.parseDouble(0+areP5.getText().toString());
                }else {
                    pA5= Double.parseDouble(areP5.getText().toString());
                }
                if(areP6.getText().toString().startsWith(".")){
                    pA6= Double.parseDouble(0+areP6.getText().toString());
                }else {
                    pA6= Double.parseDouble(areP6.getText().toString());
                }
                if(areP7.getText().toString().startsWith(".")){
                    pA7= Double.parseDouble(0+areP7.getText().toString());
                }else {
                    pA7= Double.parseDouble(areP7.getText().toString());
                }
                if(areP8.getText().toString().startsWith(".")){
                    pA8= Double.parseDouble(0+areP8.getText().toString());
                }else {
                    pA8= Double.parseDouble(areP8.getText().toString());
                }
                if(areP9.getText().toString().startsWith(".")){
                    pA9= Double.parseDouble(0+areP9.getText().toString());
                }else {
                    pA9= Double.parseDouble(areP9.getText().toString());
                }
                if(areP10.getText().toString().startsWith(".")){
                    pA10= Double.parseDouble(0+areP10.getText().toString());
                }else {
                    pA10= Double.parseDouble(areP10.getText().toString());
                }
            }
            if(sObject.getTotalCocoaArea().isEmpty()){
                tarea = 0;
            }else{
                tarea = Double.parseDouble(sObject.getTotalCocoaArea());
            }
            if ((pA1+pA2+pA3+pA4+pA5+pA6+pA7+pA8+pA9+pA10)>tarea) {
                editText.setBackgroundColor(Color.parseColor("#cc0000"));
                Toast.makeText(getApplicationContext(), getString(R.string.plotAreaHiger), Toast.LENGTH_SHORT).show();
            }else{
                editText.setBackgroundColor(Color.TRANSPARENT);
            }
        }
    }

    public class prodWatcher implements TextWatcher {
        private final WeakReference<EditText> editTextWeakReference;

        public prodWatcher(EditText editText) {
            editTextWeakReference = new WeakReference<EditText>(editText);
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable editable) {
            EditText editText = editTextWeakReference.get();
            double pA1;
            double pA2;
            double pA3;
            double pA4;
            double pA5;
            double pA6;
            double pA7;
            double pA8;
            double pA9;
            double pA10;
            double ply;
            double lyp;
            if(estP1.getText().toString().isEmpty()||estP2.getText().toString().isEmpty()||estP3.getText().toString().isEmpty()||estP4.getText().toString().isEmpty()||estP5.getText().toString().isEmpty()||estP6.getText().toString().isEmpty()||estP7.getText().toString().isEmpty()||estP8.getText().toString().isEmpty()||estP9.getText().toString().isEmpty()||estP10.getText().toString().isEmpty()){
                pA1=0;
                pA2=0;
                pA3=0;
                pA4=0;
                pA5=0;
                pA6=0;
                pA7=0;
                pA8=0;
                pA9=0;
                pA10=0;
            }else{
                pA1= Double.parseDouble(estP1.getText().toString());
                pA2= Double.parseDouble(estP2.getText().toString());
                pA3= Double.parseDouble(estP3.getText().toString());
                pA4= Double.parseDouble(estP4.getText().toString());
                pA5= Double.parseDouble(estP5.getText().toString());
                pA6= Double.parseDouble(estP6.getText().toString());
                pA7= Double.parseDouble(estP7.getText().toString());
                pA8= Double.parseDouble(estP8.getText().toString());
                pA9= Double.parseDouble(estP9.getText().toString());
                pA10= Double.parseDouble(estP10.getText().toString());
            }
            if(sObject.getProductioncocoaly().isEmpty()){
                ply=0;
            }else{
                ply=Double.parseDouble(sObject.getProductioncocoaly());
            }
            if(sObject.getProductioncocoaly().isEmpty()){
                lyp=0;
            }else{
                lyp=Double.parseDouble(sObject.getProductioncocoaly());
            }
            if ((pA1+pA2+pA3+pA4+pA5+pA6+pA7+pA8+pA9+pA10)>ply) {
                Toast.makeText(getApplicationContext(), getString(R.string.productionHiger), Toast.LENGTH_SHORT).show();
            }else if((pA1+pA2+pA3+pA4+pA5+pA6+pA7+pA8+pA9+pA10)<lyp){
                Toast.makeText(getApplicationContext(), getString(R.string.productionLess), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onResume(RestClient client) {
        curAccount = SmartSyncSDKManager.getInstance().getUserAccountManager().getCurrentUser();
        getLoaderManager().initLoader(CONTACT_DETAIL_LOADER_ID, null, this).forceLoad();
    }

    public void launchFdp(View view) {
        double p1;
        double p2;
        double p3;
        double p4;
        double p5;
        double p6;
        double p7;
        double p8;
        double p9;
        double p10;
        double total;

        if (areP1.getText().toString().isEmpty()){
            p1 = 0;
        }else{
            p1=Double.parseDouble(areP1.getText().toString());
        }

        if (areP2.getText().toString().isEmpty()){
            p2 = 0;
        }else{
            p2=Double.parseDouble(areP2.getText().toString());
        }

        if (areP3.getText().toString().isEmpty()){
            p3 = 0;
        }else{
            p3=Double.parseDouble(areP3.getText().toString());
        }

        if (areP4.getText().toString().isEmpty()){
            p4 = 0;
        }else{
            p4=Double.parseDouble(areP4.getText().toString());
        }

        if (areP5.getText().toString().isEmpty()){
            p5 = 0;
        }else{
            p5=Double.parseDouble(areP5.getText().toString());
        }

        if (areP6.getText().toString().isEmpty()){
            p6 = 0;
        }else{
            p6=Double.parseDouble(areP6.getText().toString());
        }

        if (areP7.getText().toString().isEmpty()){
            p7 = 0;
        }else{
            p7=Double.parseDouble(areP7.getText().toString());
        }

        if (areP8.getText().toString().isEmpty()){
            p8 = 0;
        }else{
            p8=Double.parseDouble(areP8.getText().toString());
        }

        if (areP9.getText().toString().isEmpty()){
            p9 = 0;
        }else{
            p9=Double.parseDouble(areP9.getText().toString());
        }

        if (areP10.getText().toString().isEmpty()){
            p10 = 0;
        }else{
            p10=Double.parseDouble(areP10.getText().toString());
        }

        if (sObject.getTotalCocoaArea().isEmpty()){
            total = 0;
        }else{
            total=Double.parseDouble(sObject.getTotalCocoaArea());
        }

        if((p1+p2+p3+p4+p5+p6+p7+p8+p9+p10)>total){
            Toast.makeText(this, this.getString(R.string.areaHigher), Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(areP1.getText())||TextUtils.isEmpty(areP2.getText())||TextUtils.isEmpty(areP3.getText())||TextUtils.isEmpty(areP4.getText())||TextUtils.isEmpty(areP5.getText())||TextUtils.isEmpty(areP6.getText())||TextUtils.isEmpty(areP7.getText())||TextUtils.isEmpty(areP8.getText())||TextUtils.isEmpty(areP9.getText())||TextUtils.isEmpty(areP10.getText())){
            Toast.makeText(this, this.getString(R.string.areaEmpty), Toast.LENGTH_SHORT).show();
        }else{
            save();
            final Intent fdpIntent = new Intent(this, fdpActivity.class);
            fdpIntent.addCategory(Intent.CATEGORY_DEFAULT);
            fdpIntent.putExtra(OBJECT_ID_KEY, sObject.getObjectId());
            fdpIntent.putExtra(OBJECT_TITLE_KEY, sObject.getName());
            fdpIntent.putExtra(OBJECT_NAME_KEY, sObject.getEmail());
            startActivity(fdpIntent);
        }
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
        Intent detailIntent = new Intent(getApplicationContext(), DetailActivity.class);
        detailIntent.addCategory(Intent.CATEGORY_DEFAULT);
        detailIntent.putExtra(OBJECT_ID_KEY, sObject.getObjectId());
        detailIntent.putExtra(OBJECT_TITLE_KEY, sObject.getName());
        detailIntent.putExtra(OBJECT_NAME_KEY, sObject.getEmail());
        startActivityForResult(detailIntent, 0);
        return true;

    }

    private void refreshScreen() {

        if (sObject != null) {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 0) {
                setText(Lp1, getString(R.string.pt1));
                ft.show(fragment1);
                fragment1.setrenovSize(sObject.getTotalRenovationArea());
            }else{ft.hide(fragment1);}
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 1) {
                setText(Lp2,getString(R.string.pt2));
                ft.show(fragment2);
                fragment2.setrenovSize(sObject.getTotalRenovationArea());
            }else{ft.hide(fragment2);}
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 2) {
                setText(Lp3,getString(R.string.pt3));
                ft.show(fragment3);
                fragment3.setrenovSize(sObject.getTotalRenovationArea());
            }else{ft.hide(fragment3);}
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 3) {
                setText(Lp4,getString(R.string.pt4));
                ft.show(fragment4);
                fragment4.setrenovSize(sObject.getTotalRenovationArea());
            }else{ft.hide(fragment4);}
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 4) {
                setText(Lp5,getString(R.string.pt5));
                ft.show(fragment5);
                fragment5.setrenovSize(sObject.getTotalRenovationArea());
            }else{ft.hide(fragment5);}
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 5) {
                setText(Lp6,getString(R.string.pt6));
                ft.show(fragment6);
                fragment6.setrenovSize(sObject.getTotalRenovationArea());
            }else{ft.hide(fragment6);}
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 6) {
                setText(Lp7,getString(R.string.pt7));
                ft.show(fragment7);
                fragment7.setrenovSize(sObject.getTotalRenovationArea());
            }else{ft.hide(fragment7);}
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 7) {
                setText(Lp8,getString(R.string.pt8));
                ft.show(fragment8);
                fragment8.setrenovSize(sObject.getTotalRenovationArea());
            }else{ft.hide(fragment8);}
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 8) {
                setText(Lp9,getString(R.string.pt9));
                ft.show(fragment9);
                fragment9.setrenovSize(sObject.getTotalRenovationArea());
            }else{ft.hide(fragment9);}
            if (Integer.valueOf(sObject.getNumberOfPlots()) > 9) {
                setText(Lp10,getString(R.string.pt10));
                ft.show(fragment10);
                fragment10.setrenovSize(sObject.getTotalRenovationArea());
            }else{ft.hide(fragment10);}
            ft.commitAllowingStateLoss();

            ////////////////////////////////////////////////////////
            //set fields plot 1

            //set field plot area 1
            if (sObject.getPlot1Area().isEmpty()){
                areP1.setText(Integer.toString(0));
            }else {
                areP1.setText(sObject.getPlot1Area());
            }

            //set field plot age 1
            if (sObject.getPlot1Age().isEmpty()){
                ageP1.setText(Integer.toString(0));
            }else {
                ageP1.setText(sObject.getPlot1Age());
            }

            //set field plot gps 1
            if (sObject.getPlot1GPS().isEmpty()){
            }else {
                gps1.setText(sObject.getPlot1GPS());
            }

            //set field distance btw trees 1
            if (sObject.getPlot1CocoaTrees().contentEquals("2x2")) {
                Spinner spinner = cteP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPlot1CocoaTrees().contentEquals("2.5x2.5")) {
                Spinner spinner = cteP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot1CocoaTrees().contentEquals("3x2.5")) {
                Spinner spinner = cteP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot1CocoaTrees().contentEquals("3x3")) {
                Spinner spinner = cteP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot1CocoaTrees().contentEquals("3.5x3.5")) {
                Spinner spinner = cteP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot1CocoaTrees().contentEquals("4x4")) {
                Spinner spinner = cteP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance6, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot1CocoaTrees().contentEquals("3x3.5")) {
                Spinner spinner = cteP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance8, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot1CocoaTrees().contentEquals("3x4")) {
                Spinner spinner = cteP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance9, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot1CocoaTrees().contentEquals("3.5x4")) {
                Spinner spinner = cteP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance10, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot1CocoaTrees().contentEquals("2x2.5")) {
                Spinner spinner = cteP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance11, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot1CocoaTrees().contentEquals("2x3")) {
                Spinner spinner = cteP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance12, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot1CocoaTrees().contentEquals("2x4")) {
                Spinner spinner = cteP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance13, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot1CocoaTrees().contentEquals("2.5x3.5")) {
                Spinner spinner = cteP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance14, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot1CocoaTrees().contentEquals("2.5x4")) {
                Spinner spinner = cteP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance15, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot1CocoaTrees().contentEquals("2x3.5")) {
                Spinner spinner = cteP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance16, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else{
                Spinner spinner = cteP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field estimated production 1
            if (sObject.getPlot1Yield().isEmpty()){
                estP1.setText(Integer.toString(0));
            }else {
                estP1.setText(sObject.getPlot1Yield());
            }

            //set field planting Material 1
            if (sObject.getPlantingMaterial1().contentEquals("G")) {
                Spinner spinner = plantP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPlantingMaterial1().contentEquals("M")) {
                Spinner spinner = plantP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlantingMaterial1().contentEquals("B")) {
                Spinner spinner = plantP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = plantP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field farm condition 1
            if (sObject.getFarmCondition1().isEmpty()){
                fcondP1.setText("N/A");
            }else {
                fcondP1.setText(sObject.getFarmCondition1());
            }

            //set field tree health 1
            if (sObject.getTreeHealth1().contentEquals("G")) {
                Spinner spinner = tehelP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getTreeHealth1().contentEquals("B")) {
                Spinner spinner = tehelP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = tehelP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field debilitation disease 1
            if (sObject.getDebilitatingDisease1().contentEquals("G")) {
                Spinner spinner = debDiP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getDebilitatingDisease1().contentEquals("B")) {
                Spinner spinner = debDiP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = debDiP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field pruning 1
            if (sObject.getPruning1().contentEquals("G")) {
                Spinner spinner = pruniP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPruning1().contentEquals("M")) {
                Spinner spinner = pruniP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPruning1().contentEquals("B")) {
                Spinner spinner = pruniP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = pruniP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field pest disease sanitation 1
            if (sObject.getPestDiseaseSanitation1().contentEquals("G")) {
                Spinner spinner = pesDiP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPestDiseaseSanitation1().contentEquals("M")) {
                Spinner spinner = pesDiP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPestDiseaseSanitation1().contentEquals("B")) {
                Spinner spinner = pesDiP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = pesDiP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field weeding 1
            if (sObject.getWeeding1().contentEquals("G")) {
                Spinner spinner = weediP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getWeeding1().contentEquals("B")) {
                Spinner spinner = weediP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = weediP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field harvesting
            if (sObject.getHarvesting1().contentEquals("G")) {
                Spinner spinner = harveP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getHarvesting1().contentEquals("B")) {
                Spinner spinner = harveP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = harveP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field shade management 1
            if (sObject.getShadeManagement1().contentEquals("G")) {
                Spinner spinner = shadeP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getShadeManagement1().contentEquals("B")) {
                Spinner spinner = shadeP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = shadeP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field soil condition 1
            if (sObject.getSoilCondition1().contentEquals("G")) {
                Spinner spinner = soilCP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getSoilCondition1().contentEquals("B")) {
                Spinner spinner = soilCP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = soilCP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field organic matter 1
            if (sObject.getOrganicMatter1().contentEquals("G")) {
                Spinner spinner = orgMaP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getOrganicMatter1().contentEquals("B")) {
                Spinner spinner = orgMaP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = orgMaP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field fert formulation 1
            if (sObject.getFertilizerFormulation1().contentEquals("G")) {
                Spinner spinner = fertFP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getFertilizerFormulation1().contentEquals("M")) {
                Spinner spinner = fertFP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getFertilizerFormulation1().contentEquals("B")) {
                Spinner spinner = fertFP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = fertFP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field fert application 1
            if (sObject.getFertilizerApplication1().contentEquals("G")) {
                Spinner spinner = fertAP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getFertilizerApplication1().contentEquals("M")) {
                Spinner spinner = fertAP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getFertilizerApplication1().contentEquals("B")) {
                Spinner spinner = fertAP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = fertAP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field lime needed 1
            if (sObject.getLimeNeed1().isEmpty()){
                limeNP1.setText("N/A");
            }else {
                limeNP1.setText(sObject.getLimeNeed1());
            }

            //set field drainage needed 1
            if (sObject.getDrainageNeed1().contentEquals("Yes")||sObject.getDrainageNeed1().contentEquals("Oui")) {
                Spinner spinner = drainP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yes, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getDrainageNeed1().contentEquals("No")||sObject.getDrainageNeed1().contentEquals("Non")) {
                Spinner spinner = drainP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.No, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = drainP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNo, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field filling in 1
            if (sObject.getFillingOption1().isEmpty()){
                filliP1.setText("N/A");
            }else {
                filliP1.setText(sObject.getFillingOption1());
            }

            //set field hire labor 1
            if (sObject.getHireLabor1().contentEquals("Yes")||sObject.getHireLabor1().contentEquals("Oui")) {
                Spinner spinner = hireNP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesHire, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getHireLabor1().contentEquals("No")||sObject.getHireLabor1().contentEquals("Non")) {
                Spinner spinner = hireNP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.noHire, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getHireLabor1().contentEquals("Seasonal")||sObject.getHireLabor1().contentEquals("Saisonnier")) {
                Spinner spinner = hireNP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.seasonHire, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = hireNP1;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNoHire, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field ph 1
            if (sObject.getPH1().isEmpty()){
                ph1.setText(Integer.toString(0));
            }else {
                ph1.setText(sObject.getPH1());
            }

            //set field genetics 1
            if (sObject.getGENETIC1().isEmpty()){
                geneticP1.setText("N/A");
            }else {
                geneticP1.setText(sObject.getGENETIC1());
            }

            //set field gaps 1
            if (sObject.getGAP1().isEmpty()){
                gapP1.setText("N/A");
            }else {
                gapP1.setText(sObject.getGAP1());
            }

            //set field soil fertility mng 1
            if (sObject.getSOILMNG1().isEmpty()){
                soilFertMng1.setText("N/A");
            }else {
                soilFertMng1.setText(sObject.getSOILMNG1());
            }

            ////////////////////////////////////////////////////////
            //set fields plot 2

            //set field plot area 2
            if (sObject.getPlot2Area().isEmpty()){
                areP2.setText(Integer.toString(0));
            }else {
                areP2.setText(sObject.getPlot2Area());
            }

            //set field plot age 2
            if (sObject.getPlot2Age().isEmpty()){
                ageP2.setText(Integer.toString(0));
            }else {
                ageP2.setText(sObject.getPlot2Age());
            }

            //set field plot gps 2
            if (sObject.getPlot2GPS().isEmpty()){

            }else {
                gps2.setText(sObject.getPlot2GPS());
            }

            //set field distance btw trees 2
            if (sObject.getPlot2CocoaTrees().contentEquals("2x2")) {
                Spinner spinner = cteP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPlot2CocoaTrees().contentEquals("2.5x2.5")) {
                Spinner spinner = cteP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot2CocoaTrees().contentEquals("3x2.5")) {
                Spinner spinner = cteP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot2CocoaTrees().contentEquals("3x3")) {
                Spinner spinner = cteP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot2CocoaTrees().contentEquals("3.5x3.5")) {
                Spinner spinner = cteP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot2CocoaTrees().contentEquals("4x4")) {
                Spinner spinner = cteP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance6, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot2CocoaTrees().contentEquals("3x3.5")) {
                Spinner spinner = cteP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance8, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot2CocoaTrees().contentEquals("3x4")) {
                Spinner spinner = cteP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance9, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot2CocoaTrees().contentEquals("3.5x4")) {
                Spinner spinner = cteP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance10, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot2CocoaTrees().contentEquals("2x2.5")) {
                Spinner spinner = cteP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance11, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot2CocoaTrees().contentEquals("2x3")) {
                Spinner spinner = cteP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance12, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot2CocoaTrees().contentEquals("2x4")) {
                Spinner spinner = cteP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance13, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot2CocoaTrees().contentEquals("2.5x3.5")) {
                Spinner spinner = cteP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance14, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot2CocoaTrees().contentEquals("2.5x4")) {
                Spinner spinner = cteP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance15, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot2CocoaTrees().contentEquals("2x3.5")) {
                Spinner spinner = cteP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance16, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else{
                Spinner spinner = cteP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }


            //set field estimated production 2
            if (sObject.getPlot2Yield().isEmpty()){
                estP2.setText(Integer.toString(0));
            }else {
                estP2.setText(sObject.getPlot2Yield());
            }

            //set field planting Material 2
            if (sObject.getPlantingMaterial2().contentEquals("G")) {
                Spinner spinner = plantP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPlantingMaterial2().contentEquals("M")) {
                Spinner spinner = plantP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlantingMaterial2().contentEquals("B")) {
                Spinner spinner = plantP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = plantP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field farm condition 2
            if (sObject.getFarmCondition2().isEmpty()){
                fcondP2.setText("N/A");
            }else {
                fcondP2.setText(sObject.getFarmCondition2());
            }

            //set field tree health 2
            if (sObject.getTreeHealth2().contentEquals("G")) {
                Spinner spinner = tehelP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getTreeHealth2().contentEquals("B")) {
                Spinner spinner = tehelP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = tehelP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field debilitation disease 2
            if (sObject.getDebilitatingDisease2().contentEquals("G")) {
                Spinner spinner = debDiP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getDebilitatingDisease2().contentEquals("B")) {
                Spinner spinner = debDiP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = debDiP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field pruning 2
            if (sObject.getPruning2().contentEquals("G")) {
                Spinner spinner = pruniP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPruning2().contentEquals("M")) {
                Spinner spinner = pruniP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPruning2().contentEquals("B")) {
                Spinner spinner = pruniP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = pruniP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field pest disease sanitation 2
            if (sObject.getPestDiseaseSanitation2().contentEquals("G")) {
                Spinner spinner = pesDiP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPestDiseaseSanitation2().contentEquals("M")) {
                Spinner spinner = pesDiP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPestDiseaseSanitation2().contentEquals("B")) {
                Spinner spinner = pesDiP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = pesDiP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field weeding 2
            if (sObject.getWeeding2().contentEquals("G")) {
                Spinner spinner = weediP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getWeeding2().contentEquals("B")) {
                Spinner spinner = weediP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = weediP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field harvesting
            if (sObject.getHarvesting2().contentEquals("G")) {
                Spinner spinner = harveP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getHarvesting2().contentEquals("B")) {
                Spinner spinner = harveP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = harveP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field shade management 2
            if (sObject.getShadeManagement2().contentEquals("G")) {
                Spinner spinner = shadeP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getShadeManagement2().contentEquals("B")) {
                Spinner spinner = shadeP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = shadeP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field soil condition 2
            if (sObject.getSoilCondition2().contentEquals("G")) {
                Spinner spinner = soilCP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getSoilCondition2().contentEquals("B")) {
                Spinner spinner = soilCP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = soilCP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field organic matter 2
            if (sObject.getOrganicMatter2().contentEquals("G")) {
                Spinner spinner = orgMaP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getOrganicMatter2().contentEquals("B")) {
                Spinner spinner = orgMaP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = orgMaP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field fert formulation 2
            if (sObject.getFertilizerFormulation2().contentEquals("G")) {
                Spinner spinner = fertFP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getFertilizerFormulation2().contentEquals("M")) {
                Spinner spinner = fertFP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getFertilizerFormulation2().contentEquals("B")) {
                Spinner spinner = fertFP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = fertFP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field fert application 2
            if (sObject.getFartilizerApplication2().contentEquals("G")) {
                Spinner spinner = fertAP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getFartilizerApplication2().contentEquals("M")) {
                Spinner spinner = fertAP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getFartilizerApplication2().contentEquals("B")) {
                Spinner spinner = fertAP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = fertAP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field lime needed 2
            if (sObject.getLimeNeed2().isEmpty()){
                limeNP2.setText("N/A");
            }else {
                limeNP2.setText(sObject.getLimeNeed2());
            }

            //set field drainage needed 2
            if (sObject.getDrainageNeed2().contentEquals("Yes")||sObject.getDrainageNeed2().contentEquals("Oui")) {
                Spinner spinner = drainP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yes, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getDrainageNeed2().contentEquals("No")||sObject.getDrainageNeed2().contentEquals("Non")) {
                Spinner spinner = drainP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.No, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = drainP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNo, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field filling in 2
            if (sObject.getFillingOption2().isEmpty()){
                filliP2.setText("N/A");
            }else {
                filliP2.setText(sObject.getFillingOption2());
            }

            //set field hire labor 2
            if (sObject.getHireLabor2().contentEquals("Yes")||sObject.getHireLabor2().contentEquals("Oui")) {
                Spinner spinner = hireNP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesHire, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getHireLabor2().contentEquals("No")||sObject.getHireLabor2().contentEquals("Non")) {
                Spinner spinner = hireNP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.noHire, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getHireLabor2().contentEquals("Seasonal")||sObject.getHireLabor2().contentEquals("Saisonnier")) {
                Spinner spinner = hireNP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.seasonHire, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = hireNP2;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNoHire, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field ph 2
            if (sObject.getPH2().isEmpty()){
                ph2.setText(Integer.toString(0));
            }else {
                ph2.setText(sObject.getPH2());
            }

            //set field genetics 2
            if (sObject.getGENETIC2().isEmpty()){
                geneticP2.setText("N/A");
            }else {
                geneticP2.setText(sObject.getGENETIC2());
            }

            //set field gaps 2
            if (sObject.getGAP2().isEmpty()){
                gapP2.setText("N/A");
            }else {
                gapP2.setText(sObject.getGAP2());
            }

            //set field soil fertility mng 2
            if (sObject.getSOILMNG2().isEmpty()){
                soilFertMng2.setText("N/A");
            }else {
                soilFertMng2.setText(sObject.getSOILMNG2());
            }

            ////////////////////////////////////////////////////////
            //set fields plot 3

            //set field plot area 3
            if (sObject.getPlot3Area().isEmpty()){
                areP3.setText(Integer.toString(0));
            }else {
                areP3.setText(sObject.getPlot3Area());
            }

            //set field plot age 3
            if (sObject.getPlot3Age().isEmpty()){
                ageP3.setText(Integer.toString(0));
            }else {
                ageP3.setText(sObject.getPlot3Age());
            }

            //set field plot gps 3
            if (sObject.getPlot3GPS().isEmpty()){

            }else {
                gps3.setText(sObject.getPlot3GPS());
            }

            //set field distance btw trees 3
            if (sObject.getPlot3CocoaTrees().contentEquals("2x2")) {
                Spinner spinner = cteP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPlot3CocoaTrees().contentEquals("2.5x2.5")) {
                Spinner spinner = cteP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot3CocoaTrees().contentEquals("3x2.5")) {
                Spinner spinner = cteP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot3CocoaTrees().contentEquals("3x3")) {
                Spinner spinner = cteP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot3CocoaTrees().contentEquals("3.5x3.5")) {
                Spinner spinner = cteP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot3CocoaTrees().contentEquals("4x4")) {
                Spinner spinner = cteP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance6, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot3CocoaTrees().contentEquals("3x3.5")) {
                Spinner spinner = cteP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance8, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot3CocoaTrees().contentEquals("3x4")) {
                Spinner spinner = cteP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance9, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot3CocoaTrees().contentEquals("3.5x4")) {
                Spinner spinner = cteP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance10, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot3CocoaTrees().contentEquals("2x2.5")) {
                Spinner spinner = cteP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance11, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot3CocoaTrees().contentEquals("2x3")) {
                Spinner spinner = cteP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance12, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot3CocoaTrees().contentEquals("2x4")) {
                Spinner spinner = cteP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance13, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot3CocoaTrees().contentEquals("2.5x3.5")) {
                Spinner spinner = cteP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance14, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot3CocoaTrees().contentEquals("2.5x4")) {
                Spinner spinner = cteP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance15, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot3CocoaTrees().contentEquals("2x3.5")) {
                Spinner spinner = cteP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance16, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else{
                Spinner spinner = cteP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field estimated production 3
            if (sObject.getPlot3Yield().isEmpty()){
                estP3.setText(Integer.toString(0));
            }else {
                estP3.setText(sObject.getPlot3Yield());
            }

            //set field planting Material 3
            if (sObject.getPlantingMaterial3().contentEquals("G")) {
                Spinner spinner = plantP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPlantingMaterial3().contentEquals("M")) {
                Spinner spinner = plantP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlantingMaterial3().contentEquals("B")) {
                Spinner spinner = plantP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = plantP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field farm condition 3
            if (sObject.getFarmCondition3().isEmpty()){
                fcondP3.setText("N/A");
            }else {
                fcondP3.setText(sObject.getFarmCondition3());
            }

            //set field tree health 3
            if (sObject.getTreeHealth3().contentEquals("G")) {
                Spinner spinner = tehelP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getTreeHealth3().contentEquals("B")) {
                Spinner spinner = tehelP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = tehelP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field debilitation disease 3
            if (sObject.getDebilitatingDisease3().contentEquals("G")) {
                Spinner spinner = debDiP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getDebilitatingDisease3().contentEquals("B")) {
                Spinner spinner = debDiP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = debDiP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field pruning 3
            if (sObject.getPruning3().contentEquals("G")) {
                Spinner spinner = pruniP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPruning3().contentEquals("M")) {
                Spinner spinner = pruniP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPruning3().contentEquals("B")) {
                Spinner spinner = pruniP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = pruniP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field pest disease sanitation 3
            if (sObject.getPestDiseaseSanitation3().contentEquals("G")) {
                Spinner spinner = pesDiP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPestDiseaseSanitation3().contentEquals("M")) {
                Spinner spinner = pesDiP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPestDiseaseSanitation3().contentEquals("B")) {
                Spinner spinner = pesDiP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = pesDiP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field weeding 3
            if (sObject.getWeeding3().contentEquals("G")) {
                Spinner spinner = weediP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getWeeding3().contentEquals("B")) {
                Spinner spinner = weediP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = weediP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field harvesting
            if (sObject.getHarvesting3().contentEquals("G")) {
                Spinner spinner = harveP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getHarvesting3().contentEquals("B")) {
                Spinner spinner = harveP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = harveP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field shade management 3
            if (sObject.getShadeManagement3().contentEquals("G")) {
                Spinner spinner = shadeP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getShadeManagement3().contentEquals("B")) {
                Spinner spinner = shadeP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = shadeP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field soil condition 3
            if (sObject.getSoilCondition3().contentEquals("G")) {
                Spinner spinner = soilCP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getSoilCondition3().contentEquals("B")) {
                Spinner spinner = soilCP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = soilCP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field organic matter 3
            if (sObject.getOrganicMatter3().contentEquals("G")) {
                Spinner spinner = orgMaP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getOrganicMatter3().contentEquals("B")) {
                Spinner spinner = orgMaP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = orgMaP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field fert formulation 3
            if (sObject.getFertilizerFormulation3().contentEquals("G")) {
                Spinner spinner = fertFP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getFertilizerFormulation3().contentEquals("M")) {
                Spinner spinner = fertFP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getFertilizerFormulation3().contentEquals("B")) {
                Spinner spinner = fertFP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = fertFP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field fert application 3
            if (sObject.getFertilizerApplication3().contentEquals("G")) {
                Spinner spinner = fertAP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getFertilizerApplication3().contentEquals("M")) {
                Spinner spinner = fertAP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getFertilizerApplication3().contentEquals("B")) {
                Spinner spinner = fertAP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = fertAP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field lime needed 3
            if (sObject.getLimeNeed3().isEmpty()){
                limeNP3.setText("N/A");
            }else {
                limeNP3.setText(sObject.getLimeNeed3());
            }

            //set field drainage needed 3
            if (sObject.getDrainageNeed3().contentEquals("Yes")||sObject.getDrainageNeed3().contentEquals("Oui")) {
                Spinner spinner = drainP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yes, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getDrainageNeed3().contentEquals("No")||sObject.getDrainageNeed3().contentEquals("Non")) {
                Spinner spinner = drainP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.No, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = drainP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNo, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field filling in 3
            if (sObject.getFillingOption3().isEmpty()){
                filliP3.setText("N/A");
            }else {
                filliP3.setText(sObject.getFillingOption3());
            }

            //set field hire labor 3
            if (sObject.getHireLabor3().contentEquals("Yes")||sObject.getHireLabor3().contentEquals("Oui")) {
                Spinner spinner = hireNP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesHire, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getHireLabor3().contentEquals("No")||sObject.getHireLabor3().contentEquals("Non")) {
                Spinner spinner = hireNP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.noHire, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getHireLabor3().contentEquals("Seasonal")||sObject.getHireLabor3().contentEquals("Saisonnier")) {
                Spinner spinner = hireNP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.seasonHire, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = hireNP3;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNoHire, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field ph 3
            if (sObject.getPH3().isEmpty()){
                ph3.setText(Integer.toString(0));
            }else {
                ph3.setText(sObject.getPH3());
            }

            //set field genetics 3
            if (sObject.getGENETIC3().isEmpty()){
                geneticP3.setText("N/A");
            }else {
                geneticP3.setText(sObject.getGENETIC3());
            }

            //set field gaps 3
            if (sObject.getGAP3().isEmpty()){
                gapP3.setText("N/A");
            }else {
                gapP3.setText(sObject.getGAP3());
            }

            //set field soil fertility mng 3
            if (sObject.getSOILMNG3().isEmpty()){
                soilFertMng3.setText("N/A");
            }else {
                soilFertMng3.setText(sObject.getSOILMNG3());
            }

            ////////////////////////////////////////////////////////
            //set fields plot 4

            //set field plot area 4
            if (sObject.getPlot4Area().isEmpty()){
                areP4.setText(Integer.toString(0));
            }else {
                areP4.setText(sObject.getPlot4Area());
            }

            //set field plot age 4
            if (sObject.getPlot4Age().isEmpty()){
                ageP4.setText(Integer.toString(0));
            }else {
                ageP4.setText(sObject.getPlot4Age());
            }

            //set field plot gps 4
            if (sObject.getPlot4GPS().isEmpty()){

            }else {
                gps4.setText(sObject.getPlot4GPS());
            }

            //set field distance btw trees 4
            if (sObject.getPlot4CocoaTrees().contentEquals("2x2")) {
                Spinner spinner = cteP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPlot4CocoaTrees().contentEquals("2.5x2.5")) {
                Spinner spinner = cteP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot4CocoaTrees().contentEquals("3x2.5")) {
                Spinner spinner = cteP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot4CocoaTrees().contentEquals("3x3")) {
                Spinner spinner = cteP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot4CocoaTrees().contentEquals("3.5x3.5")) {
                Spinner spinner = cteP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot4CocoaTrees().contentEquals("4x4")) {
                Spinner spinner = cteP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance6, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot4CocoaTrees().contentEquals("3x3.5")) {
                Spinner spinner = cteP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance8, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot4CocoaTrees().contentEquals("3x4")) {
                Spinner spinner = cteP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance9, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot4CocoaTrees().contentEquals("3.5x4")) {
                Spinner spinner = cteP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance10, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot4CocoaTrees().contentEquals("2x2.5")) {
                Spinner spinner = cteP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance11, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot4CocoaTrees().contentEquals("2x3")) {
                Spinner spinner = cteP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance12, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot4CocoaTrees().contentEquals("2x4")) {
                Spinner spinner = cteP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance13, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot4CocoaTrees().contentEquals("2.5x3.5")) {
                Spinner spinner = cteP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance14, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot4CocoaTrees().contentEquals("2.5x4")) {
                Spinner spinner = cteP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance15, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot4CocoaTrees().contentEquals("2x3.5")) {
                Spinner spinner = cteP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance16, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else{
                Spinner spinner = cteP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field estimated production 4
            if (sObject.getPlot4Yield().isEmpty()){
                estP4.setText(Integer.toString(0));
            }else {
                estP4.setText(sObject.getPlot4Yield());
            }

            //set field planting Material 4
            if (sObject.getPlantingMaterial4().contentEquals("G")) {
                Spinner spinner = plantP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPlantingMaterial4().contentEquals("M")) {
                Spinner spinner = plantP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlantingMaterial4().contentEquals("B")) {
                Spinner spinner = plantP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = plantP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field farm condition 4
            if (sObject.getFarmCondition4().isEmpty()){
                fcondP4.setText("N/A");
            }else {
                fcondP4.setText(sObject.getFarmCondition4());
            }

            //set field tree health 4
            if (sObject.getTreeHealth4().contentEquals("G")) {
                Spinner spinner = tehelP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getTreeHealth4().contentEquals("B")) {
                Spinner spinner = tehelP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = tehelP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field debilitation disease 4
            if (sObject.getDebilitatingDisease4().contentEquals("G")) {
                Spinner spinner = debDiP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getDebilitatingDisease4().contentEquals("B")) {
                Spinner spinner = debDiP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = debDiP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field pruning 4
            if (sObject.getPruning4().contentEquals("G")) {
                Spinner spinner = pruniP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPruning4().contentEquals("M")) {
                Spinner spinner = pruniP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPruning4().contentEquals("B")) {
                Spinner spinner = pruniP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = pruniP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field pest disease sanitation 4
            if (sObject.getPestDiseaseSanitation4().contentEquals("G")) {
                Spinner spinner = pesDiP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPestDiseaseSanitation4().contentEquals("M")) {
                Spinner spinner = pesDiP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPestDiseaseSanitation4().contentEquals("B")) {
                Spinner spinner = pesDiP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = pesDiP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field weeding 4
            if (sObject.getWeeding4().contentEquals("G")) {
                Spinner spinner = weediP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getWeeding4().contentEquals("B")) {
                Spinner spinner = weediP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = weediP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field harvesting
            if (sObject.getHarvesting4().contentEquals("G")) {
                Spinner spinner = harveP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getHarvesting4().contentEquals("B")) {
                Spinner spinner = harveP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = harveP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field shade management 4
            if (sObject.getShadeManagement4().contentEquals("G")) {
                Spinner spinner = shadeP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getShadeManagement4().contentEquals("B")) {
                Spinner spinner = shadeP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = shadeP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field soil condition 4
            if (sObject.getSoilCondition4().contentEquals("G")) {
                Spinner spinner = soilCP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getSoilCondition4().contentEquals("B")) {
                Spinner spinner = soilCP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = soilCP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field organic matter 4
            if (sObject.getOrganicMatter4().contentEquals("G")) {
                Spinner spinner = orgMaP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getOrganicMatter4().contentEquals("B")) {
                Spinner spinner = orgMaP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = orgMaP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field fert formulation 4
            if (sObject.getFertilizerFormulation4().contentEquals("G")) {
                Spinner spinner = fertFP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getFertilizerFormulation4().contentEquals("M")) {
                Spinner spinner = fertFP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getFertilizerFormulation4().contentEquals("B")) {
                Spinner spinner = fertFP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = fertFP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field fert application 4
            if (sObject.getFertilizerApplication4().contentEquals("G")) {
                Spinner spinner = fertAP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getFertilizerApplication4().contentEquals("M")) {
                Spinner spinner = fertAP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getFertilizerApplication4().contentEquals("B")) {
                Spinner spinner = fertAP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = fertAP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field lime needed 4
            if (sObject.geLimeNeed4().isEmpty()){
                limeNP4.setText("N/A");
            }else {
                limeNP4.setText(sObject.geLimeNeed4());
            }

            //set field drainage needed 4
            if (sObject.getDrainageNeed4().contentEquals("Yes")||sObject.getDrainageNeed4().contentEquals("Oui")) {
                Spinner spinner = drainP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yes, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getDrainageNeed4().contentEquals("No")||sObject.getDrainageNeed4().contentEquals("Non")) {
                Spinner spinner = drainP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.No, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = drainP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNo, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field filling in 4
            if (sObject.getFillingOption4().isEmpty()){
                filliP4.setText("N/A");
            }else {
                filliP4.setText(sObject.getFillingOption4());
            }

            //set field hire labor 4
            if (sObject.getHireLabor4().contentEquals("Yes")||sObject.getHireLabor4().contentEquals("Oui")) {
                Spinner spinner = hireNP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesHire, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getHireLabor4().contentEquals("No")||sObject.getHireLabor4().contentEquals("Non")) {
                Spinner spinner = hireNP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.noHire, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getHireLabor4().contentEquals("Seasonal")||sObject.getHireLabor4().contentEquals("Saisonnier")) {
                Spinner spinner = hireNP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.seasonHire, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = hireNP4;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNoHire, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field ph 4
            if (sObject.getPH4().isEmpty()){
                ph4.setText(Integer.toString(0));
            }else {
                ph4.setText(sObject.getPH4());
            }

            //set field genetics 4
            if (sObject.getGENETIC4().isEmpty()){
                geneticP4.setText("N/A");
            }else {
                geneticP4.setText(sObject.getGENETIC4());
            }

            //set field gaps 4
            if (sObject.getGAP4().isEmpty()){
                gapP4.setText("N/A");
            }else {
                gapP4.setText(sObject.getGAP4());
            }

            //set field soil fertility mng 4
            if (sObject.getSOILMNG4().isEmpty()){
                soilFertMng4.setText("N/A");
            }else {
                soilFertMng4.setText(sObject.getSOILMNG4());
            }

            ////////////////////////////////////////////////////////

            //set fields plot 5

            //set field plot area 5
            if (sObject.getPlot5Area().isEmpty()){
                areP5.setText(Integer.toString(0));
            }else {
                areP5.setText(sObject.getPlot5Area());
            }

            //set field plot age 5
            if (sObject.getPlot5Age().isEmpty()){
                ageP5.setText(Integer.toString(0));
            }else {
                ageP5.setText(sObject.getPlot5Age());
            }

            //set field plot gps 5
            if (sObject.getPlot5GPS().isEmpty()){

            }else {
                gps5.setText(sObject.getPlot5GPS());
            }

            //set field distance btw trees 5
            if (sObject.getPlot5CocoaTrees().contentEquals("2x2")) {
                Spinner spinner = cteP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPlot5CocoaTrees().contentEquals("2.5x2.5")) {
                Spinner spinner = cteP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot5CocoaTrees().contentEquals("3x2.5")) {
                Spinner spinner = cteP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot5CocoaTrees().contentEquals("3x3")) {
                Spinner spinner = cteP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot5CocoaTrees().contentEquals("3.5x3.5")) {
                Spinner spinner = cteP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot5CocoaTrees().contentEquals("4x4")) {
                Spinner spinner = cteP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance6, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot5CocoaTrees().contentEquals("3x3.5")) {
                Spinner spinner = cteP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance8, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot5CocoaTrees().contentEquals("3x4")) {
                Spinner spinner = cteP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance9, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot5CocoaTrees().contentEquals("3.5x4")) {
                Spinner spinner = cteP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance10, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot5CocoaTrees().contentEquals("2x2.5")) {
                Spinner spinner = cteP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance11, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot5CocoaTrees().contentEquals("2x3")) {
                Spinner spinner = cteP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance12, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot5CocoaTrees().contentEquals("2x4")) {
                Spinner spinner = cteP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance13, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot5CocoaTrees().contentEquals("2.5x3.5")) {
                Spinner spinner = cteP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance14, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot5CocoaTrees().contentEquals("2.5x4")) {
                Spinner spinner = cteP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance15, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot5CocoaTrees().contentEquals("2x3.5")) {
                Spinner spinner = cteP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance16, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else{
                Spinner spinner = cteP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field estimated production 5
            if (sObject.getPlot5Yield().isEmpty()){
                estP5.setText(Integer.toString(0));
            }else {
                estP5.setText(sObject.getPlot5Yield());
            }

            //set field planting Material 5
            if (sObject.getPlantingMaterial5().contentEquals("G")) {
                Spinner spinner = plantP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPlantingMaterial5().contentEquals("M")) {
                Spinner spinner = plantP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlantingMaterial5().contentEquals("B")) {
                Spinner spinner = plantP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = plantP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field farm condition 5
            if (sObject.getFarmCondition5().isEmpty()){
                fcondP5.setText("N/A");
            }else {
                fcondP5.setText(sObject.getFarmCondition5());
            }

            //set field tree health 5
            if (sObject.getTreeHealth5().contentEquals("G")) {
                Spinner spinner = tehelP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getTreeHealth5().contentEquals("B")) {
                Spinner spinner = tehelP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = tehelP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field debilitation disease 5
            if (sObject.getDebilitatingDisease5().contentEquals("G")) {
                Spinner spinner = debDiP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getDebilitatingDisease5().contentEquals("B")) {
                Spinner spinner = debDiP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = debDiP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field pruning 5
            if (sObject.getPruning5().contentEquals("G")) {
                Spinner spinner = pruniP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPruning5().contentEquals("M")) {
                Spinner spinner = pruniP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPruning5().contentEquals("B")) {
                Spinner spinner = pruniP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = pruniP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field pest disease sanitation 5
            if (sObject.getPestDiseaseSanitation5().contentEquals("G")) {
                Spinner spinner = pesDiP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPestDiseaseSanitation5().contentEquals("M")) {
                Spinner spinner = pesDiP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPestDiseaseSanitation5().contentEquals("B")) {
                Spinner spinner = pesDiP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = pesDiP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field weeding 5
            if (sObject.getWeeding5().contentEquals("G")) {
                Spinner spinner = weediP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getWeeding5().contentEquals("B")) {
                Spinner spinner = weediP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = weediP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field harvesting
            if (sObject.getHarvesting5().contentEquals("G")) {
                Spinner spinner = harveP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getHarvesting5().contentEquals("B")) {
                Spinner spinner = harveP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = harveP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field shade management 5
            if (sObject.getShadeManagement5().contentEquals("G")) {
                Spinner spinner = shadeP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getShadeManagement5().contentEquals("B")) {
                Spinner spinner = shadeP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = shadeP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field soil condition 5
            if (sObject.getSoilCondition5().contentEquals("G")) {
                Spinner spinner = soilCP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getSoilCondition5().contentEquals("B")) {
                Spinner spinner = soilCP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = soilCP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field organic matter 5
            if (sObject.getOrganicMatter5().contentEquals("G")) {
                Spinner spinner = orgMaP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getOrganicMatter5().contentEquals("B")) {
                Spinner spinner = orgMaP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = orgMaP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field fert formulation 5
            if (sObject.getFertilizerFormulation5().contentEquals("G")) {
                Spinner spinner = fertFP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getFertilizerFormulation5().contentEquals("M")) {
                Spinner spinner = fertFP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getFertilizerFormulation5().contentEquals("B")) {
                Spinner spinner = fertFP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = fertFP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field fert application 5
            if (sObject.getFertilizerApplication5().contentEquals("G")) {
                Spinner spinner = fertAP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getFertilizerApplication5().contentEquals("M")) {
                Spinner spinner = fertAP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getFertilizerApplication5().contentEquals("B")) {
                Spinner spinner = fertAP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = fertAP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field lime needed 5
            if (sObject.getLimeNeed5().isEmpty()){
                limeNP5.setText("N/A");
            }else {
                limeNP5.setText(sObject.getLimeNeed5());
            }

            //set field drainage needed 5
            if (sObject.getDrainageNeed5().contentEquals("Yes")||sObject.getDrainageNeed5().contentEquals("Oui")) {
                Spinner spinner = drainP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yes, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getDrainageNeed5().contentEquals("No")||sObject.getDrainageNeed5().contentEquals("Non")) {
                Spinner spinner = drainP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.No, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = drainP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNo, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field filling in 5
            if (sObject.getFillingOption5().isEmpty()){
                filliP5.setText("N/A");
            }else {
                filliP5.setText(sObject.getFillingOption5());
            }

            //set field hire labor 5
            if (sObject.getHireLabor5().contentEquals("Yes")||sObject.getHireLabor5().contentEquals("Oui")) {
                Spinner spinner = hireNP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesHire, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getHireLabor5().contentEquals("No")||sObject.getHireLabor5().contentEquals("Non")) {
                Spinner spinner = hireNP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.noHire, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getHireLabor5().contentEquals("Seasonal")||sObject.getHireLabor5().contentEquals("Saisonnier")) {
                Spinner spinner = hireNP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.seasonHire, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = hireNP5;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNoHire, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field ph 5
            if (sObject.getPH5().isEmpty()){
                ph5.setText(Integer.toString(0));
            }else {
                ph5.setText(sObject.getPH5());
            }

            //set field genetics 5
            if (sObject.getGENETIC5().isEmpty()){
                geneticP5.setText("N/A");
            }else {
                geneticP5.setText(sObject.getGENETIC5());
            }

            //set field gaps 5
            if (sObject.getGAP5().isEmpty()){
                gapP5.setText("N/A");
            }else {
                gapP5.setText(sObject.getGAP5());
            }

            //set field soil fertility mng 5
            if (sObject.getSOILMNG5().isEmpty()){
                soilFertMng5.setText("N/A");
            }else {
                soilFertMng5.setText(sObject.getSOILMNG5());
            }

            ////////////////////////////////////////////////////////
            //set fields plot 6

            //set field plot area 6
            if (sObject.getPlot6Area().isEmpty()){
                areP6.setText(Integer.toString(0));
            }else {
                areP6.setText(sObject.getPlot6Area());
            }

            //set field plot age 6
            if (sObject.getPlot6Age().isEmpty()){
                ageP6.setText(Integer.toString(0));
            }else {
                ageP6.setText(sObject.getPlot6Age());
            }

            //set field plot gps 6
            if (sObject.getPlot6GPS().isEmpty()){

            }else {
                gps6.setText(sObject.getPlot6GPS());
            }

            //set field distance btw trees 6
            if (sObject.getPlot6CocoaTrees().contentEquals("2x2")) {
                Spinner spinner = cteP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPlot6CocoaTrees().contentEquals("2.5x2.5")) {
                Spinner spinner = cteP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot6CocoaTrees().contentEquals("3x2.5")) {
                Spinner spinner = cteP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot6CocoaTrees().contentEquals("3x3")) {
                Spinner spinner = cteP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot6CocoaTrees().contentEquals("3.5x3.5")) {
                Spinner spinner = cteP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot6CocoaTrees().contentEquals("4x4")) {
                Spinner spinner = cteP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance6, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot6CocoaTrees().contentEquals("3x3.5")) {
                Spinner spinner = cteP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance8, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot6CocoaTrees().contentEquals("3x4")) {
                Spinner spinner = cteP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance9, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot6CocoaTrees().contentEquals("3.5x4")) {
                Spinner spinner = cteP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance10, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot6CocoaTrees().contentEquals("2x2.5")) {
                Spinner spinner = cteP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance11, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot6CocoaTrees().contentEquals("2x3")) {
                Spinner spinner = cteP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance12, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot6CocoaTrees().contentEquals("2x4")) {
                Spinner spinner = cteP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance13, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot6CocoaTrees().contentEquals("2.5x3.5")) {
                Spinner spinner = cteP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance14, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot6CocoaTrees().contentEquals("2.5x4")) {
                Spinner spinner = cteP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance15, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot6CocoaTrees().contentEquals("2x3.5")) {
                Spinner spinner = cteP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance16, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else{
                Spinner spinner = cteP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field estimated production 6
            if (sObject.getPlot6Yield().isEmpty()){
                estP6.setText(Integer.toString(0));
            }else {
                estP6.setText(sObject.getPlot6Yield());
            }

            //set field planting Material 6
            if (sObject.getPlantingMaterial6().contentEquals("G")) {
                Spinner spinner = plantP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPlantingMaterial6().contentEquals("M")) {
                Spinner spinner = plantP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlantingMaterial6().contentEquals("B")) {
                Spinner spinner = plantP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = plantP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field farm condition 6
            if (sObject.getFarmCondition6().isEmpty()){
                fcondP6.setText("N/A");
            }else {
                fcondP6.setText(sObject.getFarmCondition6());
            }

            //set field tree health 6
            if (sObject.getTreeHealth6().contentEquals("G")) {
                Spinner spinner = tehelP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getTreeHealth6().contentEquals("B")) {
                Spinner spinner = tehelP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = tehelP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field debilitation disease 6
            if (sObject.getDebilitatingDisease6().contentEquals("G")) {
                Spinner spinner = debDiP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getDebilitatingDisease6().contentEquals("B")) {
                Spinner spinner = debDiP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = debDiP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field pruning 6
            if (sObject.getPruning6().contentEquals("G")) {
                Spinner spinner = pruniP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPruning6().contentEquals("M")) {
                Spinner spinner = pruniP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPruning6().contentEquals("B")) {
                Spinner spinner = pruniP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = pruniP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field pest disease sanitation 6
            if (sObject.getPestDiseaseSanitation6().contentEquals("G")) {
                Spinner spinner = pesDiP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPestDiseaseSanitation6().contentEquals("M")) {
                Spinner spinner = pesDiP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPestDiseaseSanitation6().contentEquals("B")) {
                Spinner spinner = pesDiP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = pesDiP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field weeding 6
            if (sObject.getWeeding6().contentEquals("G")) {
                Spinner spinner = weediP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getWeeding6().contentEquals("B")) {
                Spinner spinner = weediP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = weediP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field harvesting
            if (sObject.getHarvesting6().contentEquals("G")) {
                Spinner spinner = harveP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getHarvesting6().contentEquals("B")) {
                Spinner spinner = harveP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = harveP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field shade management 6
            if (sObject.getShadeManagement6().contentEquals("G")) {
                Spinner spinner = shadeP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getShadeManagement6().contentEquals("B")) {
                Spinner spinner = shadeP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = shadeP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field soil condition 6
            if (sObject.getSoilCondition6().contentEquals("G")) {
                Spinner spinner = soilCP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getSoilCondition6().contentEquals("B")) {
                Spinner spinner = soilCP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = soilCP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field organic matter 6
            if (sObject.getOrganicMatter6().contentEquals("G")) {
                Spinner spinner = orgMaP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getOrganicMatter6().contentEquals("B")) {
                Spinner spinner = orgMaP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = orgMaP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field fert formulation 6
            if (sObject.getFertilizerFormulation6().contentEquals("G")) {
                Spinner spinner = fertFP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getFertilizerFormulation6().contentEquals("M")) {
                Spinner spinner = fertFP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getFertilizerFormulation6().contentEquals("B")) {
                Spinner spinner = fertFP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = fertFP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field fert application 6
            if (sObject.getFertilizerApplication6().contentEquals("G")) {
                Spinner spinner = fertAP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getFertilizerApplication6().contentEquals("M")) {
                Spinner spinner = fertAP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getFertilizerApplication6().contentEquals("B")) {
                Spinner spinner = fertAP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = fertAP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field lime needed 6
            if (sObject.getLimeNeed6().isEmpty()){
                limeNP6.setText("N/A");
            }else {
                limeNP6.setText(sObject.getLimeNeed6());
            }

            //set field drainage needed 6
            if (sObject.getDrainageNeed6().contentEquals("Yes")||sObject.getDrainageNeed6().contentEquals("oui")) {
                Spinner spinner = drainP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yes, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getDrainageNeed6().contentEquals("No")||sObject.getDrainageNeed6().contentEquals("Non")) {
                Spinner spinner = drainP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.No, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = drainP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNo, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field filling in 6
            if (sObject.getFillingOption6().isEmpty()){
                filliP6.setText("N/A");
            }else {
                filliP6.setText(sObject.getFillingOption6());
            }

            //set field hire labor 6
            if (sObject.getHireLabor6().contentEquals("Yes")||sObject.getHireLabor6().contentEquals("Oui")) {
                Spinner spinner = hireNP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesHire, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getHireLabor6().contentEquals("No")||sObject.getHireLabor6().contentEquals("Non")) {
                Spinner spinner = hireNP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.noHire, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getHireLabor6().contentEquals("Seasonal")||sObject.getHireLabor6().contentEquals("Saisonnier")) {
                Spinner spinner = hireNP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.seasonHire, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = hireNP6;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNoHire, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field ph 6
            if (sObject.getPH6().isEmpty()){
                ph6.setText(Integer.toString(0));
            }else {
                ph6.setText(sObject.getPH6());
            }

            //set field genetics 6
            if (sObject.getGENETIC6().isEmpty()){
                geneticP6.setText("N/A");
            }else {
                geneticP6.setText(sObject.getGENETIC6());
            }

            //set field gaps 6
            if (sObject.getGAP6().isEmpty()){
                gapP6.setText("N/A");
            }else {
                gapP6.setText(sObject.getGAP6());
            }

            //set field soil fertility mng 6
            if (sObject.getSOILMNG6().isEmpty()){
                soilFertMng6.setText("N/A");
            }else {
                soilFertMng6.setText(sObject.getSOILMNG6());
            }

            ////////////////////////////////////////////////////////
            //set fields plot 7

            //set field plot area 7
            if (sObject.getPlot7Area().isEmpty()){
                areP7.setText(Integer.toString(0));
            }else {
                areP7.setText(sObject.getPlot7Area());
            }

            //set field plot age 7
            if (sObject.getPlot7Age().isEmpty()){
                ageP7.setText(Integer.toString(0));
            }else {
                ageP7.setText(sObject.getPlot7Age());
            }

            //set field plot gps 7
            if (sObject.getPlot7GPS().isEmpty()){

            }else {
                gps7.setText(sObject.getPlot7GPS());
            }

            //set field distance btw trees 7
            if (sObject.getPlot7CocoaTrees().contentEquals("2x2")) {
                Spinner spinner = cteP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPlot7CocoaTrees().contentEquals("2.5x2.5")) {
                Spinner spinner = cteP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot7CocoaTrees().contentEquals("3x2.5")) {
                Spinner spinner = cteP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot7CocoaTrees().contentEquals("3x3")) {
                Spinner spinner = cteP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot7CocoaTrees().contentEquals("3.5x3.5")) {
                Spinner spinner = cteP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot7CocoaTrees().contentEquals("4x4")) {
                Spinner spinner = cteP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance6, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot7CocoaTrees().contentEquals("3x3.5")) {
                Spinner spinner = cteP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance8, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot7CocoaTrees().contentEquals("3x4")) {
                Spinner spinner = cteP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance9, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot7CocoaTrees().contentEquals("3.5x4")) {
                Spinner spinner = cteP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance10, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot7CocoaTrees().contentEquals("2x2.5")) {
                Spinner spinner = cteP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance11, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot7CocoaTrees().contentEquals("2x3")) {
                Spinner spinner = cteP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance12, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot7CocoaTrees().contentEquals("2x4")) {
                Spinner spinner = cteP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance13, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot7CocoaTrees().contentEquals("2.5x3.5")) {
                Spinner spinner = cteP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance14, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot7CocoaTrees().contentEquals("2.5x4")) {
                Spinner spinner = cteP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance15, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot7CocoaTrees().contentEquals("2x3.5")) {
                Spinner spinner = cteP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance16, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else{
                Spinner spinner = cteP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field estimated production 7
            if (sObject.getPlot7Yield().isEmpty()){
                estP7.setText(Integer.toString(0));
            }else {
                estP7.setText(sObject.getPlot7Yield());
            }

            //set field planting Material 7
            if (sObject.getPlantingMaterial7().contentEquals("G")) {
                Spinner spinner = plantP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPlantingMaterial7().contentEquals("M")) {
                Spinner spinner = plantP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlantingMaterial7().contentEquals("B")) {
                Spinner spinner = plantP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = plantP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field farm condition 7
            if (sObject.getFarmCondition7().isEmpty()){
                fcondP7.setText("N/A");
            }else {
                fcondP7.setText(sObject.getFarmCondition7());
            }

            //set field tree health 7
            if (sObject.getTreeHealth7().contentEquals("G")) {
                Spinner spinner = tehelP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getTreeHealth7().contentEquals("B")) {
                Spinner spinner = tehelP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = tehelP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field debilitation disease 7
            if (sObject.getDebilitatingDisease7().contentEquals("G")) {
                Spinner spinner = debDiP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getDebilitatingDisease7().contentEquals("B")) {
                Spinner spinner = debDiP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = debDiP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field pruning 7
            if (sObject.getPruning7().contentEquals("G")) {
                Spinner spinner = pruniP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPruning7().contentEquals("M")) {
                Spinner spinner = pruniP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPruning7().contentEquals("B")) {
                Spinner spinner = pruniP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = pruniP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field pest disease sanitation 7
            if (sObject.getPestDiseaseSanitation7().contentEquals("G")) {
                Spinner spinner = pesDiP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPestDiseaseSanitation7().contentEquals("M")) {
                Spinner spinner = pesDiP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPestDiseaseSanitation7().contentEquals("B")) {
                Spinner spinner = pesDiP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = pesDiP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field weeding 7
            if (sObject.getWeeding7().contentEquals("G")) {
                Spinner spinner = weediP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getWeeding7().contentEquals("B")) {
                Spinner spinner = weediP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = weediP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field harvesting
            if (sObject.getHarvesting7().contentEquals("G")) {
                Spinner spinner = harveP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getHarvesting7().contentEquals("B")) {
                Spinner spinner = harveP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = harveP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field shade management 7
            if (sObject.getShadeManagement7().contentEquals("G")) {
                Spinner spinner = shadeP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getShadeManagement7().contentEquals("B")) {
                Spinner spinner = shadeP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = shadeP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field soil condition 7
            if (sObject.getSoilCondition7().contentEquals("G")) {
                Spinner spinner = soilCP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getSoilCondition7().contentEquals("B")) {
                Spinner spinner = soilCP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = soilCP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field organic matter 7
            if (sObject.getOrganicMatter7().contentEquals("G")) {
                Spinner spinner = orgMaP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getOrganicMatter7().contentEquals("B")) {
                Spinner spinner = orgMaP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = orgMaP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field fert formulation 7
            if (sObject.getFertilizerFormulation7().contentEquals("G")) {
                Spinner spinner = fertFP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getFertilizerFormulation7().contentEquals("M")) {
                Spinner spinner = fertFP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getFertilizerFormulation7().contentEquals("B")) {
                Spinner spinner = fertFP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = fertFP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field fert application 7
            if (sObject.getFertilizerApplication7().contentEquals("G")) {
                Spinner spinner = fertAP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getFertilizerApplication7().contentEquals("M")) {
                Spinner spinner = fertAP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getFertilizerApplication7().contentEquals("B")) {
                Spinner spinner = fertAP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = fertAP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field lime needed 7
            if (sObject.getLimeNeed7().isEmpty()){
                limeNP7.setText("N/A");
            }else {
                limeNP7.setText(sObject.getLimeNeed7());
            }

            //set field drainage needed 7
            if (sObject.getDrainageNeed7().contentEquals("Yes")||sObject.getDrainageNeed7().contentEquals("Oui")) {
                Spinner spinner = drainP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yes, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getDrainageNeed7().contentEquals("No")||sObject.getDrainageNeed7().contentEquals("Non")) {
                Spinner spinner = drainP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.No, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = drainP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNo, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field filling in 7
            if (sObject.getFillingOption7().isEmpty()){
                filliP7.setText("N/A");
            }else {
                filliP7.setText(sObject.getFillingOption7());
            }

            //set field hire labor 7
            if (sObject.getHireLabor7().contentEquals("Yes")||sObject.getHireLabor7().contentEquals("Oui")) {
                Spinner spinner = hireNP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesHire, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getHireLabor7().contentEquals("No")||sObject.getHireLabor7().contentEquals("Non")) {
                Spinner spinner = hireNP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.noHire, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getHireLabor7().contentEquals("Seasonal")||sObject.getHireLabor7().contentEquals("Saisonnier")) {
                Spinner spinner = hireNP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.seasonHire, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = hireNP7;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNoHire, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field ph 7
            if (sObject.getPH7().isEmpty()){
                ph7.setText(Integer.toString(0));
            }else {
                ph7.setText(sObject.getPH7());
            }

            //set field genetics 7
            if (sObject.getGENETIC7().isEmpty()){
                geneticP7.setText("N/A");
            }else {
                geneticP7.setText(sObject.getGENETIC7());
            }

            //set field gaps 7
            if (sObject.getGAP7().isEmpty()){
                gapP7.setText("N/A");
            }else {
                gapP7.setText(sObject.getGAP7());
            }

            //set field soil fertility mng 7
            if (sObject.getSOILMNG7().isEmpty()){
                soilFertMng7.setText("N/A");
            }else {
                soilFertMng7.setText(sObject.getSOILMNG7());
            }

            ////////////////////////////////////////////////////////
            //set fields plot 8

            //set field plot area 8
            if (sObject.getPlot8Area().isEmpty()){
                areP8.setText(Integer.toString(0));
            }else {
                areP8.setText(sObject.getPlot8Area());
            }

            //set field plot age 8
            if (sObject.getPlot8Age().isEmpty()){
                ageP8.setText(Integer.toString(0));
            }else {
                ageP8.setText(sObject.getPlot8Age());
            }

            //set field plot gps 8
            if (sObject.getPlot8GPS().isEmpty()){

            }else {
                gps8.setText(sObject.getPlot8GPS());
            }

            //set field distance btw trees 8
            if (sObject.getPlot8CocoaTrees().contentEquals("2x2")) {
                Spinner spinner = cteP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPlot8CocoaTrees().contentEquals("2.5x2.5")) {
                Spinner spinner = cteP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot8CocoaTrees().contentEquals("3x2.5")) {
                Spinner spinner = cteP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot8CocoaTrees().contentEquals("3x3")) {
                Spinner spinner = cteP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot8CocoaTrees().contentEquals("3.5x3.5")) {
                Spinner spinner = cteP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot8CocoaTrees().contentEquals("4x4")) {
                Spinner spinner = cteP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance6, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot8CocoaTrees().contentEquals("3x3.5")) {
                Spinner spinner = cteP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance8, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot8CocoaTrees().contentEquals("3x4")) {
                Spinner spinner = cteP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance9, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot8CocoaTrees().contentEquals("3.5x4")) {
                Spinner spinner = cteP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance10, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot8CocoaTrees().contentEquals("2x2.5")) {
                Spinner spinner = cteP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance11, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot8CocoaTrees().contentEquals("2x3")) {
                Spinner spinner = cteP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance12, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot8CocoaTrees().contentEquals("2x4")) {
                Spinner spinner = cteP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance13, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot8CocoaTrees().contentEquals("2.5x3.5")) {
                Spinner spinner = cteP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance14, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot8CocoaTrees().contentEquals("2.5x4")) {
                Spinner spinner = cteP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance15, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot8CocoaTrees().contentEquals("2x3.5")) {
                Spinner spinner = cteP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance16, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else{
                Spinner spinner = cteP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field estimated production 8
            if (sObject.getPlot8Yield().isEmpty()){
                estP8.setText(Integer.toString(0));
            }else {
                estP8.setText(sObject.getPlot8Yield());
            }

            //set field planting Material 8
            if (sObject.getPlantingMaterial8().contentEquals("G")) {
                Spinner spinner = plantP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPlantingMaterial8().contentEquals("M")) {
                Spinner spinner = plantP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlantingMaterial8().contentEquals("B")) {
                Spinner spinner = plantP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = plantP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field farm condition 8
            if (sObject.getFarmCondition8().isEmpty()){
                fcondP8.setText("N/A");
            }else {
                fcondP8.setText(sObject.getFarmCondition8());
            }

            //set field tree health 8
            if (sObject.getTreeHealth8().contentEquals("G")) {
                Spinner spinner = tehelP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getTreeHealth8().contentEquals("B")) {
                Spinner spinner = tehelP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = tehelP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field debilitation disease 8
            if (sObject.getDebilitatingDisease8().contentEquals("G")) {
                Spinner spinner = debDiP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getDebilitatingDisease8().contentEquals("B")) {
                Spinner spinner = debDiP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = debDiP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field pruning 8
            if (sObject.getPruning8().contentEquals("G")) {
                Spinner spinner = pruniP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPruning8().contentEquals("M")) {
                Spinner spinner = pruniP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPruning8().contentEquals("B")) {
                Spinner spinner = pruniP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = pruniP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field pest disease sanitation 8
            if (sObject.getPestDiseaseSanitation8().contentEquals("G")) {
                Spinner spinner = pesDiP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPestDiseaseSanitation8().contentEquals("M")) {
                Spinner spinner = pesDiP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPestDiseaseSanitation8().contentEquals("B")) {
                Spinner spinner = pesDiP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = pesDiP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field weeding 8
            if (sObject.getWeeding8().contentEquals("G")) {
                Spinner spinner = weediP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getWeeding8().contentEquals("B")) {
                Spinner spinner = weediP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = weediP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field harvesting
            if (sObject.getHarvesting8().contentEquals("G")) {
                Spinner spinner = harveP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getHarvesting8().contentEquals("B")) {
                Spinner spinner = harveP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = harveP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field shade management 8
            if (sObject.getShadeManagement8().contentEquals("G")) {
                Spinner spinner = shadeP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getShadeManagement8().contentEquals("B")) {
                Spinner spinner = shadeP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = shadeP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field soil condition 8
            if (sObject.getSoilCondition8().contentEquals("G")) {
                Spinner spinner = soilCP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getSoilCondition8().contentEquals("B")) {
                Spinner spinner = soilCP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = soilCP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field organic matter 8
            if (sObject.getOrganicMatter8().contentEquals("G")) {
                Spinner spinner = orgMaP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getOrganicMatter8().contentEquals("B")) {
                Spinner spinner = orgMaP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = orgMaP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field fert formulation 8
            if (sObject.getFertilizerFormulation8().contentEquals("G")) {
                Spinner spinner = fertFP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getFertilizerFormulation8().contentEquals("M")) {
                Spinner spinner = fertFP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getFertilizerFormulation8().contentEquals("B")) {
                Spinner spinner = fertFP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = fertFP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field fert application 8
            if (sObject.getFertilizerApplication8().contentEquals("G")) {
                Spinner spinner = fertAP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getFertilizerApplication8().contentEquals("M")) {
                Spinner spinner = fertAP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getFertilizerApplication8().contentEquals("B")) {
                Spinner spinner = fertAP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = fertAP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field lime needed 8
            if (sObject.getLimeNeed8().isEmpty()){
                limeNP8.setText("N/A");
            }else {
                limeNP8.setText(sObject.getLimeNeed8());
            }

            //set field drainage needed 8
            if (sObject.getDrainageNeed8().contentEquals("Yes")||sObject.getDrainageNeed8().contentEquals("Oui")) {
                Spinner spinner = drainP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yes, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getDrainageNeed8().contentEquals("No")||sObject.getDrainageNeed8().contentEquals("Non")) {
                Spinner spinner = drainP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.No, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = drainP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNo, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field filling in 8
            if (sObject.getFillingOption8().isEmpty()){
                filliP8.setText("N/A");
            }else {
                filliP8.setText(sObject.getFillingOption8());
            }

            //set field hire labor 8
            if (sObject.getHireLabor8().contentEquals("Yes")||sObject.getHireLabor8().contentEquals("Oui")) {
                Spinner spinner = hireNP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesHire, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getHireLabor8().contentEquals("No")||sObject.getHireLabor8().contentEquals("Non")) {
                Spinner spinner = hireNP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.noHire, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getHireLabor8().contentEquals("Seasonal")||sObject.getHireLabor8().contentEquals("Saisonnier")) {
                Spinner spinner = hireNP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.seasonHire, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = hireNP8;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNoHire, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field ph 8
            if (sObject.getPH8().isEmpty()){
                ph8.setText(Integer.toString(0));
            }else {
                ph8.setText(sObject.getPH8());
            }

            //set field genetics 8
            if (sObject.getGENETIC8().isEmpty()){
                geneticP8.setText("N/A");
            }else {
                geneticP8.setText(sObject.getGENETIC8());
            }

            //set field gaps 8
            if (sObject.getGAP8().isEmpty()){
                gapP8.setText("N/A");
            }else {
                gapP8.setText(sObject.getGAP8());
            }

            //set field soil fertility mng 8
            if (sObject.getSOILMNG8().isEmpty()){
                soilFertMng8.setText("N/A");
            }else {
                soilFertMng8.setText(sObject.getSOILMNG8());
            }

            ////////////////////////////////////////////////////////
            //set fields plot 9

            //set field plot area 9
            if (sObject.getPlot9Area().isEmpty()){
                areP9.setText(Integer.toString(0));
            }else {
                areP9.setText(sObject.getPlot9Area());
            }

            //set field plot age 9
            if (sObject.getPlot9Age().isEmpty()){
                ageP9.setText(Integer.toString(0));
            }else {
                ageP9.setText(sObject.getPlot9Age());
            }

            //set field plot gps 9
            if (sObject.getPlot9GPS().isEmpty()){

            }else {
                gps9.setText(sObject.getPlot9GPS());
            }

            //set field distance btw trees 9
            if (sObject.getPlot9CocoaTrees().contentEquals("2x2")) {
                Spinner spinner = cteP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPlot9CocoaTrees().contentEquals("2.5x2.5")) {
                Spinner spinner = cteP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot9CocoaTrees().contentEquals("3x2.5")) {
                Spinner spinner = cteP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot9CocoaTrees().contentEquals("3x3")) {
                Spinner spinner = cteP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot9CocoaTrees().contentEquals("3.5x3.5")) {
                Spinner spinner = cteP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot9CocoaTrees().contentEquals("4x4")) {
                Spinner spinner = cteP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance6, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot9CocoaTrees().contentEquals("3x3.5")) {
                Spinner spinner = cteP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance8, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot9CocoaTrees().contentEquals("3x4")) {
                Spinner spinner = cteP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance9, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot9CocoaTrees().contentEquals("3.5x4")) {
                Spinner spinner = cteP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance10, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot9CocoaTrees().contentEquals("2x2.5")) {
                Spinner spinner = cteP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance11, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot9CocoaTrees().contentEquals("2x3")) {
                Spinner spinner = cteP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance12, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot9CocoaTrees().contentEquals("2x4")) {
                Spinner spinner = cteP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance13, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot9CocoaTrees().contentEquals("2.5x3.5")) {
                Spinner spinner = cteP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance14, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot9CocoaTrees().contentEquals("2.5x4")) {
                Spinner spinner = cteP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance15, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot9CocoaTrees().contentEquals("2x3.5")) {
                Spinner spinner = cteP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance16, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else{
                Spinner spinner = cteP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }


            //set field estimated production 9
            if (sObject.getPlot9Yield().isEmpty()){
                estP9.setText(Integer.toString(0));
            }else {
                estP9.setText(sObject.getPlot9Yield());
            }

            //set field planting Material 9
            if (sObject.getPlantingMaterial9().contentEquals("G")) {
                Spinner spinner = plantP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPlantingMaterial9().contentEquals("M")) {
                Spinner spinner = plantP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlantingMaterial9().contentEquals("B")) {
                Spinner spinner = plantP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = plantP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field farm condition 9
            if (sObject.getFarmCondition9().isEmpty()){
                fcondP9.setText("N/A");
            }else {
                fcondP9.setText(sObject.getFarmCondition9());
            }

            //set field tree health 9
            if (sObject.getTreeHealth9().contentEquals("G")) {
                Spinner spinner = tehelP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getTreeHealth9().contentEquals("B")) {
                Spinner spinner = tehelP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = tehelP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field debilitation disease 9
            if (sObject.getDebilitatingDisease9().contentEquals("G")) {
                Spinner spinner = debDiP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getDebilitatingDisease9().contentEquals("B")) {
                Spinner spinner = debDiP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = debDiP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field pruning 9
            if (sObject.getPruning9().contentEquals("G")) {
                Spinner spinner = pruniP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPruning9().contentEquals("M")) {
                Spinner spinner = pruniP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPruning9().contentEquals("B")) {
                Spinner spinner = pruniP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = pruniP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field pest disease sanitation 9
            if (sObject.getPestDiseaseSanitation9().contentEquals("G")) {
                Spinner spinner = pesDiP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPestDiseaseSanitation9().contentEquals("M")) {
                Spinner spinner = pesDiP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPestDiseaseSanitation9().contentEquals("B")) {
                Spinner spinner = pesDiP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = pesDiP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field weeding 9
            if (sObject.getWeeding9().contentEquals("G")) {
                Spinner spinner = weediP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getWeeding9().contentEquals("B")) {
                Spinner spinner = weediP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = weediP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field harvesting
            if (sObject.getHarvesting9().contentEquals("G")) {
                Spinner spinner = harveP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getHarvesting9().contentEquals("B")) {
                Spinner spinner = harveP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = harveP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field shade management 9
            if (sObject.getShadeManagement9().contentEquals("G")) {
                Spinner spinner = shadeP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getShadeManagement9().contentEquals("B")) {
                Spinner spinner = shadeP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = shadeP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field soil condition 9
            if (sObject.getSoilCondition9().contentEquals("G")) {
                Spinner spinner = soilCP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getSoilCondition9().contentEquals("B")) {
                Spinner spinner = soilCP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = soilCP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field organic matter 9
            if (sObject.getOrganicMatter9().contentEquals("G")) {
                Spinner spinner = orgMaP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getOrganicMatter9().contentEquals("B")) {
                Spinner spinner = orgMaP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = orgMaP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field fert formulation 9
            if (sObject.getFertilizerFormulation9().contentEquals("G")) {
                Spinner spinner = fertFP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getFertilizerFormulation9().contentEquals("M")) {
                Spinner spinner = fertFP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getFertilizerFormulation9().contentEquals("B")) {
                Spinner spinner = fertFP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = fertFP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field fert application 9
            if (sObject.getFertilizerApplication9().contentEquals("G")) {
                Spinner spinner = fertAP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getFertilizerApplication9().contentEquals("M")) {
                Spinner spinner = fertAP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getFertilizerApplication9().contentEquals("B")) {
                Spinner spinner = fertAP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = fertAP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field lime needed 9
            if (sObject.getLimeNeed9().isEmpty()){
                limeNP9.setText("N/A");
            }else {
                limeNP9.setText(sObject.getLimeNeed9());
            }

            //set field drainage needed 9
            if (sObject.getDrainageNeed9().contentEquals("Yes")||sObject.getDrainageNeed9().contentEquals("Oui")) {
                Spinner spinner = drainP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yes, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getDrainageNeed9().contentEquals("No")||sObject.getDrainageNeed9().contentEquals("Non")) {
                Spinner spinner = drainP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.No, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = drainP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNo, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field filling in 9
            if (sObject.getFillingOption9().isEmpty()){
                filliP9.setText("N/A");
            }else {
                filliP9.setText(sObject.getFillingOption9());
            }

            //set field hire labor 9
            if (sObject.getHireLabor9().contentEquals("Yes")||sObject.getHireLabor9().contentEquals("Oui")) {
                Spinner spinner = hireNP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesHire, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getHireLabor9().contentEquals("No")||sObject.getHireLabor9().contentEquals("Non")) {
                Spinner spinner = hireNP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.noHire, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getHireLabor9().contentEquals("Seasonal")||sObject.getHireLabor9().contentEquals("Saisonnier")) {
                Spinner spinner = hireNP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.seasonHire, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = hireNP9;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNoHire, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field ph 9
            if (sObject.getPH9().isEmpty()){
                ph9.setText(Integer.toString(0));
            }else {
                ph9.setText(sObject.getPH9());
            }

            //set field genetics 9
            if (sObject.getGENETIC9().isEmpty()){
                geneticP9.setText("N/A");
            }else {
                geneticP9.setText(sObject.getGENETIC9());
            }

            //set field gaps 9
            if (sObject.getGAP9().isEmpty()){
                gapP9.setText("N/A");
            }else {
                gapP9.setText(sObject.getGAP9());
            }

            //set field soil fertility mng 9
            if (sObject.getSOILMNG9().isEmpty()){
                soilFertMng9.setText("N/A");
            }else {
                soilFertMng9.setText(sObject.getSOILMNG9());
            }

            ////////////////////////////////////////////////////////
            //set fields plot 10

            //set field plot area 10
            if (sObject.getPlot10Area().isEmpty()){
                areP10.setText(Integer.toString(0));
            }else {
                areP10.setText(sObject.getPlot10Area());
            }

            //set field plot age 10
            if (sObject.getPlot10Age().isEmpty()){
                ageP10.setText(Integer.toString(0));
            }else {
                ageP10.setText(sObject.getPlot10Age());
            }

            //set field plot gps 10
            if (sObject.getPlot10GPS().isEmpty()){

            }else {
                gps10.setText(sObject.getPlot10GPS());
            }

            //set field distance btw trees 10
            if (sObject.getPlot10CocoaTrees().contentEquals("2x2")) {
                Spinner spinner = cteP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPlot10CocoaTrees().contentEquals("2.5x2.5")) {
                Spinner spinner = cteP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot10CocoaTrees().contentEquals("3x2.5")) {
                Spinner spinner = cteP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot10CocoaTrees().contentEquals("3x3")) {
                Spinner spinner = cteP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot10CocoaTrees().contentEquals("3.5x3.5")) {
                Spinner spinner = cteP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot10CocoaTrees().contentEquals("4x4")) {
                Spinner spinner = cteP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance6, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot10CocoaTrees().contentEquals("3x3.5")) {
                Spinner spinner = cteP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance8, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot10CocoaTrees().contentEquals("3x4")) {
                Spinner spinner = cteP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance9, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot10CocoaTrees().contentEquals("3.5x4")) {
                Spinner spinner = cteP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance10, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot10CocoaTrees().contentEquals("2x2.5")) {
                Spinner spinner = cteP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance11, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot10CocoaTrees().contentEquals("2x3")) {
                Spinner spinner = cteP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance12, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot10CocoaTrees().contentEquals("2x4")) {
                Spinner spinner = cteP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance13, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot10CocoaTrees().contentEquals("2.5x3.5")) {
                Spinner spinner = cteP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance14, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot10CocoaTrees().contentEquals("2.5x4")) {
                Spinner spinner = cteP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance15, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlot10CocoaTrees().contentEquals("2x3.5")) {
                Spinner spinner = cteP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance16, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else{
                Spinner spinner = cteP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.treeDistance, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }


            //set field estimated production 10
            if (sObject.getPlot10Yield().isEmpty()){
                estP10.setText(Integer.toString(0));
            }else {
                estP10.setText(sObject.getPlot10Yield());
            }

            //set field planting Material 10
            if (sObject.getPlantingMaterial10().contentEquals("G")) {
                Spinner spinner = plantP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPlantingMaterial10().contentEquals("M")) {
                Spinner spinner = plantP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlantingMaterial10().contentEquals("B")) {
                Spinner spinner = plantP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = plantP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field farm condition 10
            if (sObject.getFarmCondition10().isEmpty()){
                fcondP10.setText("N/A");
            }else {
                fcondP10.setText(sObject.getFarmCondition10());
            }

            //set field tree health 10
            if (sObject.getTreeHealth10().contentEquals("G")) {
                Spinner spinner = tehelP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getTreeHealth10().contentEquals("B")) {
                Spinner spinner = tehelP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = tehelP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field debilitation disease 10
            if (sObject.getDebilitatingDisease10().contentEquals("G")) {
                Spinner spinner = debDiP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getDebilitatingDisease10().contentEquals("B")) {
                Spinner spinner = debDiP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = debDiP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field pruning 10
            if (sObject.getPruning10().contentEquals("G")) {
                Spinner spinner = pruniP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPruning10().contentEquals("M")) {
                Spinner spinner = pruniP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPruning10().contentEquals("B")) {
                Spinner spinner = pruniP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = pruniP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field pest disease sanitation 10
            if (sObject.getPestDiseaseSanitation10().contentEquals("G")) {
                Spinner spinner = pesDiP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPestDiseaseSanitation10().contentEquals("M")) {
                Spinner spinner = pesDiP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPestDiseaseSanitation10().contentEquals("B")) {
                Spinner spinner = pesDiP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = pesDiP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field weeding 10
            if (sObject.getWeeding10().contentEquals("G")) {
                Spinner spinner = weediP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getWeeding10().contentEquals("B")) {
                Spinner spinner = weediP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = weediP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field harvesting
            if (sObject.getHarvesting10().contentEquals("G")) {
                Spinner spinner = harveP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getHarvesting10().contentEquals("B")) {
                Spinner spinner = harveP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = harveP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field shade management 10
            if (sObject.getShadeManagement10().contentEquals("G")) {
                Spinner spinner = shadeP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getShadeManagement10().contentEquals("B")) {
                Spinner spinner = shadeP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = shadeP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field soil condition 10
            if (sObject.getSoilCondition10().contentEquals("G")) {
                Spinner spinner = soilCP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getSoilCondition10().contentEquals("B")) {
                Spinner spinner = soilCP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = soilCP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field organic matter 10
            if (sObject.getOrganicMatter10().contentEquals("G")) {
                Spinner spinner = orgMaP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getOrganicMatter10().contentEquals("B")) {
                Spinner spinner = orgMaP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = orgMaP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field fert formulation 10
            if (sObject.getFertilizerFormulation10().contentEquals("G")) {
                Spinner spinner = fertFP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getFertilizerFormulation10().contentEquals("M")) {
                Spinner spinner = fertFP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getFertilizerFormulation10().contentEquals("B")) {
                Spinner spinner = fertFP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = fertFP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field fert application 10
            if (sObject.getFertilizerApplication10().contentEquals("G")) {
                Spinner spinner = fertAP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getFertilizerApplication10().contentEquals("M")) {
                Spinner spinner = fertAP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getFertilizerApplication10().contentEquals("B")) {
                Spinner spinner = fertAP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = fertAP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field lime needed 10
            if (sObject.getLimeNeed10().isEmpty()){
                limeNP10.setText("N/A");
            }else {
                limeNP10.setText(sObject.getLimeNeed10());
            }

            //set field drainage needed 10
            if (sObject.getDrainageNeed10().contentEquals("Yes")||sObject.getDrainageNeed10().contentEquals("Oui")) {
                Spinner spinner = drainP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yes, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getDrainageNeed10().contentEquals("No")||sObject.getDrainageNeed10().contentEquals("Non")) {
                Spinner spinner = drainP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.No, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = drainP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNo, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field filling in 10
            if (sObject.getFillingOption10().isEmpty()){
                filliP10.setText("N/A");
            }else {
                filliP10.setText(sObject.getFillingOption10());
            }

            //set field hire labor 10
            if (sObject.getHireLabor10().contentEquals("Yes")||sObject.getHireLabor10().contentEquals("Oui")) {
                Spinner spinner = hireNP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesHire, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getHireLabor10().contentEquals("No")||sObject.getHireLabor10().contentEquals("Non")) {
                Spinner spinner = hireNP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.noHire, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getHireLabor10().contentEquals("Seasonal")||sObject.getHireLabor10().contentEquals("Saisonnier")) {
                Spinner spinner = hireNP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.seasonHire, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = hireNP10;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNoHire, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field ph 10
            if (sObject.getPH10().isEmpty()){
                ph10.setText(Integer.toString(0));
            }else {
                ph10.setText(sObject.getPH10());
            }

            //set field genetics 10
            if (sObject.getGENETIC10().isEmpty()){
                geneticP10.setText("N/A");
            }else {
                geneticP10.setText(sObject.getGENETIC10());
            }

            //set field gaps 10
            if (sObject.getGAP10().isEmpty()){
                gapP10.setText("N/A");
            }else {
                gapP10.setText(sObject.getGAP10());
            }

            //set field soil fertility mng 10
            if (sObject.getSOILMNG10().isEmpty()){
                soilFertMng10.setText("N/A");
            }else {
                soilFertMng10.setText(sObject.getSOILMNG10());
            }

            double tra;
            if (sObject.getTotalRenovationArea().isEmpty()){
                tra = 0;
            }else{
                tra = Double.parseDouble(sObject.getTotalRenovationArea());
            }
            if( tra<=0){
                renovP1.setEnabled(false);
                renovP2.setEnabled(false);
                renovP3.setEnabled(false);
                renovP4.setEnabled(false);
                renovP5.setEnabled(false);
                renovP6.setEnabled(false);
                renovP7.setEnabled(false);
                renovP8.setEnabled(false);
                renovP9.setEnabled(false);
                renovP10.setEnabled(false);
                renovReasonP1.setEnabled(false);
                renovReasonP2.setEnabled(false);
                renovReasonP3.setEnabled(false);
                renovReasonP4.setEnabled(false);
                renovReasonP5.setEnabled(false);
                renovReasonP6.setEnabled(false);
                renovReasonP7.setEnabled(false);
                renovReasonP8.setEnabled(false);
                renovReasonP9.setEnabled(false);
                renovReasonP10.setEnabled(false);
                renovYearP1.setEnabled(false);
                renovYearP2.setEnabled(false);
                renovYearP3.setEnabled(false);
                renovYearP4.setEnabled(false);
                renovYearP5.setEnabled(false);
                renovYearP6.setEnabled(false);
                renovYearP7.setEnabled(false);
                renovYearP8.setEnabled(false);
                renovYearP9.setEnabled(false);
                renovYearP10.setEnabled(false);
            }else {
                //set renovated 1
                if (sObject.getPLOT1RENOVATION().contentEquals("Yes") || sObject.getPLOT1RENOVATION().contentEquals("Oui")) {
                    Spinner spinner = renovP1;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.yes, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT1RENOVATION().contentEquals("No") || sObject.getPLOT1RENOVATION().contentEquals("Non")) {
                    renovReasonP1.setEnabled(false);
                    renovYearP1.setEnabled(false);
                    Spinner spinner = renovP1;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.No, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else {
                    renovReasonP1.setEnabled(false);
                    renovYearP1.setEnabled(false);
                    Spinner spinner = renovP1;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.yesNo, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                }

                //set renovated 2
                if (sObject.getPLOT2RENOVATION().contentEquals("Yes") || sObject.getPLOT2RENOVATION().contentEquals("Oui")) {
                    Spinner spinner = renovP2;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.yes, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT2RENOVATION().contentEquals("No") || sObject.getPLOT2RENOVATION().contentEquals("Non")) {
                    renovReasonP2.setEnabled(false);
                    renovYearP2.setEnabled(false);
                    Spinner spinner = renovP2;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.No, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else {
                    renovReasonP2.setEnabled(false);
                    renovYearP2.setEnabled(false);
                    Spinner spinner = renovP2;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.yesNo, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                }

                //set renovated 3
                if (sObject.getPLOT3RENOVATION().contentEquals("Yes") || sObject.getPLOT3RENOVATION().contentEquals("Oui")) {
                    Spinner spinner = renovP3;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.yes, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT3RENOVATION().contentEquals("No") || sObject.getPLOT3RENOVATION().contentEquals("Non")) {
                    renovReasonP3.setEnabled(false);
                    renovYearP3.setEnabled(false);
                    Spinner spinner = renovP3;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.No, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else {
                    renovReasonP3.setEnabled(false);
                    renovYearP3.setEnabled(false);
                    Spinner spinner = renovP3;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.yesNo, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                }

                //set renovated 4
                if (sObject.getPLOT4RENOVATION().contentEquals("Yes") || sObject.getPLOT4RENOVATION().contentEquals("Oui")) {
                    Spinner spinner = renovP4;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.yes, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT4RENOVATION().contentEquals("No") || sObject.getPLOT4RENOVATION().contentEquals("Non")) {
                    renovReasonP4.setEnabled(false);
                    renovYearP4.setEnabled(false);
                    Spinner spinner = renovP4;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.No, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else {
                    renovReasonP4.setEnabled(false);
                    renovYearP4.setEnabled(false);
                    Spinner spinner = renovP4;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.yesNo, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                }

                //set renovated 5
                if (sObject.getPLOT5RENOVATION().contentEquals("Yes") || sObject.getPLOT5RENOVATION().contentEquals("Oui")) {
                    Spinner spinner = renovP5;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.yes, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT5RENOVATION().contentEquals("No") || sObject.getPLOT5RENOVATION().contentEquals("Non")) {
                    renovReasonP5.setEnabled(false);
                    renovYearP5.setEnabled(false);
                    Spinner spinner = renovP5;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.No, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else {
                    renovReasonP5.setEnabled(false);
                    renovYearP5.setEnabled(false);
                    Spinner spinner = renovP5;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.yesNo, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                }

                //set renovated 6
                if (sObject.getPLOT6RENOVATION().contentEquals("Yes") || sObject.getPLOT6RENOVATION().contentEquals("Oui")) {
                    Spinner spinner = renovP6;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.yes, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT6RENOVATION().contentEquals("No") || sObject.getPLOT6RENOVATION().contentEquals("Non")) {
                    renovReasonP6.setEnabled(false);
                    renovYearP6.setEnabled(false);
                    Spinner spinner = renovP6;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.No, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else {
                    renovReasonP6.setEnabled(false);
                    renovYearP6.setEnabled(false);
                    Spinner spinner = renovP6;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.yesNo, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                }

                //set renovated 7
                if (sObject.getPLOT7RENOVATION().contentEquals("Yes") || sObject.getPLOT7RENOVATION().contentEquals("Oui")) {
                    Spinner spinner = renovP7;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.yes, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT7RENOVATION().contentEquals("No") || sObject.getPLOT7RENOVATION().contentEquals("Non")) {
                    renovReasonP7.setEnabled(false);
                    renovYearP7.setEnabled(false);
                    Spinner spinner = renovP7;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.No, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else {
                    renovReasonP7.setEnabled(false);
                    renovYearP7.setEnabled(false);
                    Spinner spinner = renovP7;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.yesNo, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                }

                //set renovated 8
                if (sObject.getPLOT8RENOVATION().contentEquals("Yes") || sObject.getPLOT8RENOVATION().contentEquals("Oui")) {
                    Spinner spinner = renovP8;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.yes, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT8RENOVATION().contentEquals("No") || sObject.getPLOT8RENOVATION().contentEquals("Non")) {
                    renovReasonP8.setEnabled(false);
                    renovYearP8.setEnabled(false);
                    Spinner spinner = renovP8;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.No, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else {
                    renovReasonP8.setEnabled(false);
                    renovYearP8.setEnabled(false);
                    Spinner spinner = renovP8;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.yesNo, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                }

                //set renovated 9
                if (sObject.getPLOT9RENOVATION().contentEquals("Yes") || sObject.getPLOT9RENOVATION().contentEquals("Oui")) {
                    Spinner spinner = renovP9;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.yes, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT9RENOVATION().contentEquals("No") || sObject.getPLOT9RENOVATION().contentEquals("Non")) {
                    renovReasonP9.setEnabled(false);
                    renovYearP9.setEnabled(false);
                    Spinner spinner = renovP9;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.No, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else {
                    renovReasonP9.setEnabled(false);
                    renovYearP9.setEnabled(false);
                    Spinner spinner = renovP9;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.yesNo, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                }

                //set renovated 10
                if (sObject.getPLOT10RENOVATION().contentEquals("Yes") || sObject.getPLOT10RENOVATION().contentEquals("Oui")) {
                    Spinner spinner = renovP10;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.yes, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT10RENOVATION().contentEquals("No") || sObject.getPLOT10RENOVATION().contentEquals("Non")) {
                    renovReasonP10.setEnabled(false);
                    renovYearP10.setEnabled(false);
                    Spinner spinner = renovP10;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.No, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else {
                    renovReasonP10.setEnabled(false);
                    renovYearP10.setEnabled(false);
                    Spinner spinner = renovP10;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.yesNo, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                }

                //set renovated reason 1
                if (sObject.getPLOT1RENOVATIONREASON().contentEquals("Replanting") || sObject.getPLOT1RENOVATIONREASON().contentEquals("Replantation")) {
                    Spinner spinner = renovReasonP1;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.reason1, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT1RENOVATIONREASON().contentEquals("Grafting") || sObject.getPLOT1RENOVATIONREASON().contentEquals("Greffage")) {
                    Spinner spinner = renovReasonP1;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.reason2, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else {
                    Spinner spinner = renovReasonP1;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.reason, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                }

                //set renovated reason 2
                if (sObject.getPLOT2RENOVATIONREASON().contentEquals("Replanting") || sObject.getPLOT2RENOVATIONREASON().contentEquals("Replantation")) {
                    Spinner spinner = renovReasonP2;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.reason1, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT2RENOVATIONREASON().contentEquals("Grafting") || sObject.getPLOT2RENOVATIONREASON().contentEquals("Greffage")) {
                    Spinner spinner = renovReasonP2;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.reason2, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else {
                    Spinner spinner = renovReasonP2;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.reason, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                }

                //set renovated reason 3
                if (sObject.getPLOT3RENOVATIONREASON().contentEquals("Replanting") || sObject.getPLOT3RENOVATIONREASON().contentEquals("Replantation")) {
                    Spinner spinner = renovReasonP3;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.reason1, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT3RENOVATIONREASON().contentEquals("Grafting") || sObject.getPLOT3RENOVATIONREASON().contentEquals("Greffage")) {
                    Spinner spinner = renovReasonP3;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.reason2, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else {
                    Spinner spinner = renovReasonP3;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.reason, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                }

                //set renovated reason 4
                if (sObject.getPLOT4RENOVATIONREASON().contentEquals("Replanting") || sObject.getPLOT4RENOVATIONREASON().contentEquals("Replantation")) {
                    Spinner spinner = renovReasonP4;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.reason1, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT4RENOVATIONREASON().contentEquals("Grafting") || sObject.getPLOT4RENOVATIONREASON().contentEquals("Greffage")) {
                    Spinner spinner = renovReasonP4;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.reason2, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else {
                    Spinner spinner = renovReasonP4;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.reason, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                }

                //set renovated reason 5
                if (sObject.getPLOT5RENOVATIONREASON().contentEquals("Replanting") || sObject.getPLOT5RENOVATIONREASON().contentEquals("Replantation")) {
                    Spinner spinner = renovReasonP5;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.reason1, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT5RENOVATIONREASON().contentEquals("Grafting") || sObject.getPLOT5RENOVATIONREASON().contentEquals("Greffage")) {
                    Spinner spinner = renovReasonP5;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.reason2, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else {
                    Spinner spinner = renovReasonP5;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.reason, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                }

                //set renovated reason 6
                if (sObject.getPLOT6RENOVATIONREASON().contentEquals("Replanting") || sObject.getPLOT6RENOVATIONREASON().contentEquals("Replantation")) {
                    Spinner spinner = renovReasonP6;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.reason1, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT6RENOVATIONREASON().contentEquals("Grafting") || sObject.getPLOT6RENOVATIONREASON().contentEquals("Greffage")) {
                    Spinner spinner = renovReasonP6;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.reason2, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else {
                    Spinner spinner = renovReasonP6;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.reason, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                }

                //set renovated reason 7
                if (sObject.getPLOT7RENOVATIONREASON().contentEquals("Replanting") || sObject.getPLOT7RENOVATIONREASON().contentEquals("Replantation")) {
                    Spinner spinner = renovReasonP7;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.reason1, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT7RENOVATIONREASON().contentEquals("Grafting") || sObject.getPLOT7RENOVATIONREASON().contentEquals("Greffage")) {
                    Spinner spinner = renovReasonP7;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.reason2, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else {
                    Spinner spinner = renovReasonP7;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.reason, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                }

                //set renovated reason 8
                if (sObject.getPLOT8RENOVATIONREASON().contentEquals("Replanting") || sObject.getPLOT8RENOVATIONREASON().contentEquals("Replantation")) {
                    Spinner spinner = renovReasonP8;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.reason1, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT8RENOVATIONREASON().contentEquals("Grafting") || sObject.getPLOT8RENOVATIONREASON().contentEquals("Greffage")) {
                    Spinner spinner = renovReasonP8;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.reason2, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else {
                    Spinner spinner = renovReasonP8;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.reason, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                }

                //set renovated reason 9
                if (sObject.getPLOT9RENOVATIONREASON().contentEquals("Replanting") || sObject.getPLOT9RENOVATIONREASON().contentEquals("Replantation")) {
                    Spinner spinner = renovReasonP9;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.reason1, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT9RENOVATIONREASON().contentEquals("Grafting") || sObject.getPLOT9RENOVATIONREASON().contentEquals("Greffage")) {
                    Spinner spinner = renovReasonP9;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.reason2, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else {
                    Spinner spinner = renovReasonP9;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.reason, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                }

                //set renovated reason 10
                if (sObject.getPLOT10RENOVATIONREASON().contentEquals("Replanting") || sObject.getPLOT10RENOVATIONREASON().contentEquals("Replantation")) {
                    Spinner spinner = renovReasonP1;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.reason1, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT10RENOVATIONREASON().contentEquals("Grafting") || sObject.getPLOT10RENOVATIONREASON().contentEquals("Greffage")) {
                    Spinner spinner = renovReasonP10;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.reason2, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else {
                    Spinner spinner = renovReasonP10;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.reason, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                }

                //set renovated year 1
                if (sObject.getPLOT1RENOVATIONYEAR().contentEquals("-1")) {
                    Spinner spinner = renovYearP1;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong1, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT1RENOVATIONYEAR().contentEquals("-2")) {
                    Spinner spinner = renovYearP1;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong2, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT1RENOVATIONYEAR().contentEquals("-3")) {
                    Spinner spinner = renovYearP1;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong3, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT1RENOVATIONYEAR().contentEquals("-4")) {
                    Spinner spinner = renovYearP1;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong4, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                }  else if (sObject.getPLOT1RENOVATIONYEAR().contentEquals("-5")) {
                    Spinner spinner = renovYearP1;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong5, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                }else {
                    Spinner spinner = renovYearP1;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                }

                //set renovated year 2
                if (sObject.getPLOT2RENOVATIONYEAR().contentEquals("-1")) {
                    Spinner spinner = renovYearP2;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong1, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT2RENOVATIONYEAR().contentEquals("-2")) {
                    Spinner spinner = renovYearP2;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong2, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT2RENOVATIONYEAR().contentEquals("-3")) {
                    Spinner spinner = renovYearP2;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong3, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT2RENOVATIONYEAR().contentEquals("-4")) {
                    Spinner spinner = renovYearP2;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong4, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT2RENOVATIONYEAR().contentEquals("-5")) {
                    Spinner spinner = renovYearP2;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong5, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                }else {
                    Spinner spinner = renovYearP2;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                }

                //set renovated year 3
                if (sObject.getPLOT3RENOVATIONYEAR().contentEquals("-1")) {
                    Spinner spinner = renovYearP3;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong1, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT3RENOVATIONYEAR().contentEquals("-2")) {
                    Spinner spinner = renovYearP3;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong2, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT3RENOVATIONYEAR().contentEquals("-3")) {
                    Spinner spinner = renovYearP3;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong3, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT3RENOVATIONYEAR().contentEquals("-4")) {
                    Spinner spinner = renovYearP3;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong4, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                }else if (sObject.getPLOT3RENOVATIONYEAR().contentEquals("-5")) {
                    Spinner spinner = renovYearP3;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong5, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                }else {
                    Spinner spinner = renovYearP3;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                }

                //set renovated year 4
                if (sObject.getPLOT4RENOVATIONYEAR().contentEquals("-1")) {
                    Spinner spinner = renovYearP4;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong1, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT4RENOVATIONYEAR().contentEquals("-2")) {
                    Spinner spinner = renovYearP4;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong2, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT4RENOVATIONYEAR().contentEquals("-3")) {
                    Spinner spinner = renovYearP4;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong3, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT4RENOVATIONYEAR().contentEquals("-4")) {
                    Spinner spinner = renovYearP4;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong4, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT4RENOVATIONYEAR().contentEquals("-5")) {
                    Spinner spinner = renovYearP4;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong5, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                }else {
                    Spinner spinner = renovYearP4;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                }

                //set renovated year 5
                if (sObject.getPLOT5RENOVATIONYEAR().contentEquals("-1")) {
                    Spinner spinner = renovYearP5;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong1, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT5RENOVATIONYEAR().contentEquals("-2")) {
                    Spinner spinner = renovYearP5;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong2, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT5RENOVATIONYEAR().contentEquals("-3")) {
                    Spinner spinner = renovYearP5;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong3, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT5RENOVATIONYEAR().contentEquals("-4")) {
                    Spinner spinner = renovYearP5;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong4, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT5RENOVATIONYEAR().contentEquals("-5")) {
                    Spinner spinner = renovYearP5;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong5, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                }else {
                    Spinner spinner = renovYearP5;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                }

                //set renovated year 6
                if (sObject.getPLOT6RENOVATIONYEAR().contentEquals("-1")) {
                    Spinner spinner = renovYearP6;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong1, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT6RENOVATIONYEAR().contentEquals("-2")) {
                    Spinner spinner = renovYearP6;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong2, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT6RENOVATIONYEAR().contentEquals("-3")) {
                    Spinner spinner = renovYearP6;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong3, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT6RENOVATIONYEAR().contentEquals("-4")) {
                    Spinner spinner = renovYearP6;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong4, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT6RENOVATIONYEAR().contentEquals("-5")) {
                    Spinner spinner = renovYearP6;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong5, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                }else {
                    Spinner spinner = renovYearP6;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                }

                //set renovated year 7
                if (sObject.getPLOT7RENOVATIONYEAR().contentEquals("-1")) {
                    Spinner spinner = renovYearP7;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong1, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT7RENOVATIONYEAR().contentEquals("-2")) {
                    Spinner spinner = renovYearP7;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong2, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT7RENOVATIONYEAR().contentEquals("-3")) {
                    Spinner spinner = renovYearP7;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong3, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT7RENOVATIONYEAR().contentEquals("-4")) {
                    Spinner spinner = renovYearP7;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong4, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT7RENOVATIONYEAR().contentEquals("-5")) {
                    Spinner spinner = renovYearP7;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong5, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                }else {
                    Spinner spinner = renovYearP7;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                }

                //set renovated year 8
                if (sObject.getPLOT8RENOVATIONYEAR().contentEquals("-1")) {
                    Spinner spinner = renovYearP8;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong1, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT8RENOVATIONYEAR().contentEquals("-2")) {
                    Spinner spinner = renovYearP8;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong2, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT8RENOVATIONYEAR().contentEquals("-3")) {
                    Spinner spinner = renovYearP8;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong3, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT8RENOVATIONYEAR().contentEquals("-4")) {
                    Spinner spinner = renovYearP8;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong4, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT8RENOVATIONYEAR().contentEquals("-5")) {
                    Spinner spinner = renovYearP8;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong5, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                }else {
                    Spinner spinner = renovYearP8;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                }

                //set renovated year 9
                if (sObject.getPLOT9RENOVATIONYEAR().contentEquals("-1")) {
                    Spinner spinner = renovYearP9;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong1, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT9RENOVATIONYEAR().contentEquals("-2")) {
                    Spinner spinner = renovYearP9;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong2, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT9RENOVATIONYEAR().contentEquals("-3")) {
                    Spinner spinner = renovYearP9;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong3, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT9RENOVATIONYEAR().contentEquals("-4")) {
                    Spinner spinner = renovYearP9;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong4, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT9RENOVATIONYEAR().contentEquals("-5")) {
                    Spinner spinner = renovYearP9;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong5, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                }else {
                    Spinner spinner = renovYearP9;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                }

                //set renovated year 10
                if (sObject.getPLOT10RENOVATIONYEAR().contentEquals("-1")) {
                    Spinner spinner = renovYearP10;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong1, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT10RENOVATIONYEAR().contentEquals("-2")) {
                    Spinner spinner = renovYearP10;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong2, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT10RENOVATIONYEAR().contentEquals("-3")) {
                    Spinner spinner = renovYearP10;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong3, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT10RENOVATIONYEAR().contentEquals("-4")) {
                    Spinner spinner = renovYearP10;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong4, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else if (sObject.getPLOT10RENOVATIONYEAR().contentEquals("-5")) {
                    Spinner spinner = renovYearP10;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong5, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                }else {
                    Spinner spinner = renovYearP10;
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.howLong, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                }
            }

            if (sObject.getMEASURE().contentEquals("Bag")||sObject.getMEASURE().contentEquals("Sac")){
                q42.setText(getResources().getString(R.string.estimatedProduction)+" "+getResources().getString(R.string.bag));
            }else if(sObject.getMEASURE().contentEquals("Qq")){
                q42.setText(getResources().getString(R.string.estimatedProduction)+" "+getResources().getString(R.string.qq));
            }else{
                q42.setText(getResources().getString(R.string.estimatedProduction)+" "+getResources().getString(R.string.kg));
            }

            if (sObject.getAREAUNITS().contentEquals("Ac")){
                q41.setText(getResources().getString(R.string.plotArea)+" "+getResources().getString(R.string.ac));
            }else{
                q41.setText(getResources().getString(R.string.plotArea)+" "+getResources().getString(R.string.ha));
            }
            setText(reco1, sObject.getRECO1());
            setText(reco2, sObject.getRECO2());
            setText(reco3, sObject.getRECO3());
            setText(reco4, sObject.getRECO4());
            setText(reco5, sObject.getRECO5());
            setText(reco6, sObject.getRECO6());
            setText(reco7, sObject.getRECO7());
            setText(reco8, sObject.getRECO8());
            setText(reco9, sObject.getRECO9());
            setText(reco10, sObject.getRECO10());
            ////////////////////////////////////////////////////////

        }
    }

    private void setText(TextView textField, String text) {
        if (textField != null) {
            textField.setText(text);
        }
    }

    private void save() {

        final String sgps1 = gps1.getText().toString();
        final String sgps2 = gps2.getText().toString();
        final String sgps3 = gps3.getText().toString();
        final String sgps4 = gps4.getText().toString();
        final String sgps5 = gps5.getText().toString();
        final String sgps6 = gps6.getText().toString();
        final String sgps7 = gps7.getText().toString();
        final String sgps8 = gps8.getText().toString();
        final String sgps9 = gps9.getText().toString();
        final String sgps10 = gps10.getText().toString();
        final String sareP1 = areP1.getText().toString();
        final String sareP2 = areP2.getText().toString();
        final String sareP3 = areP3.getText().toString();
        final String sareP4 = areP4.getText().toString();
        final String sareP5 = areP5.getText().toString();
        final String sareP6 = areP6.getText().toString();
        final String sareP7 = areP7.getText().toString();
        final String sareP8 = areP8.getText().toString();
        final String sareP9 = areP9.getText().toString();
        final String sareP10 = areP10.getText().toString();
        final String sestP1 = estP1.getText().toString();
        final String sestP2 = estP2.getText().toString();
        final String sestP3 = estP3.getText().toString();
        final String sestP4 = estP4.getText().toString();
        final String sestP5 = estP5.getText().toString();
        final String sestP6 = estP6.getText().toString();
        final String sestP7 = estP7.getText().toString();
        final String sestP8 = estP8.getText().toString();
        final String sestP9 = estP9.getText().toString();
        final String sestP10 = estP10.getText().toString();
        final String sageP1 = ageP1.getText().toString();
        final String sfcondP1 = fcondP1.getText().toString();
        final String slimeNP1 = limeNP1.getText().toString();
        final String sfilliP1 = filliP1.getText().toString();
        final String sph1 = ph1.getText().toString();
        final String sgeneticP1 = geneticP1.getText().toString();
        final String sgapP1 = gapP1.getText().toString();
        final String ssoilFertMng1 = soilFertMng1.getText().toString();
        final String scteP1 = cteP1.getSelectedItem().toString();
        final String splantP1 = plantP1.getSelectedItem().toString();
        final String stehelP1 = tehelP1.getSelectedItem().toString();
        final String sdebDiP1 = debDiP1.getSelectedItem().toString();
        final String spruniP1 = pruniP1.getSelectedItem().toString();
        final String spesDiP1 = pesDiP1.getSelectedItem().toString();
        final String sweediP1 = weediP1.getSelectedItem().toString();
        final String sharveP1 = harveP1.getSelectedItem().toString();
        final String sshadeP1 = shadeP1.getSelectedItem().toString();
        final String ssoilCP1 = soilCP1.getSelectedItem().toString();
        final String sorgMaP1 = orgMaP1.getSelectedItem().toString();
        final String sfertFP1 = fertFP1.getSelectedItem().toString();
        final String sfertAP1 = fertAP1.getSelectedItem().toString();
        final String sdrainP1 = drainP1.getSelectedItem().toString();
        final String shireNP1 = hireNP1.getSelectedItem().toString();
        final String sageP2 = ageP2.getText().toString();
        final String sfcondP2 = fcondP2.getText().toString();
        final String slimeNP2 = limeNP2.getText().toString();
        final String sfilliP2 = filliP2.getText().toString();
        final String sph2 = ph2.getText().toString();
        final String sgeneticP2 = geneticP2.getText().toString();
        final String sgapP2 = gapP2.getText().toString();
        final String ssoilFertMng2 = soilFertMng2.getText().toString();
        final String scteP2 = cteP2.getSelectedItem().toString();
        final String splantP2 = plantP2.getSelectedItem().toString();
        final String stehelP2 = tehelP2.getSelectedItem().toString();
        final String sdebDiP2 = debDiP2.getSelectedItem().toString();
        final String spruniP2 = pruniP2.getSelectedItem().toString();
        final String spesDiP2 = pesDiP2.getSelectedItem().toString();
        final String sweediP2 = weediP2.getSelectedItem().toString();
        final String sharveP2 = harveP2.getSelectedItem().toString();
        final String sshadeP2 = shadeP2.getSelectedItem().toString();
        final String ssoilCP2 = soilCP2.getSelectedItem().toString();
        final String sorgMaP2 = orgMaP2.getSelectedItem().toString();
        final String sfertFP2 = fertFP2.getSelectedItem().toString();
        final String sfertAP2 = fertAP2.getSelectedItem().toString();
        final String sdrainP2 = drainP2.getSelectedItem().toString();
        final String shireNP2 = hireNP2.getSelectedItem().toString();
        final String sageP3 = ageP3.getText().toString();
        final String sfcondP3 = fcondP3.getText().toString();
        final String slimeNP3 = limeNP3.getText().toString();
        final String sfilliP3 = filliP3.getText().toString();
        final String sph3 = ph3.getText().toString();
        final String sgeneticP3 = geneticP3.getText().toString();
        final String sgapP3 = gapP3.getText().toString();
        final String ssoilFertMng3 = soilFertMng3.getText().toString();
        final String scteP3 = cteP3.getSelectedItem().toString();
        final String splantP3 = plantP3.getSelectedItem().toString();
        final String stehelP3 = tehelP3.getSelectedItem().toString();
        final String sdebDiP3 = debDiP3.getSelectedItem().toString();
        final String spruniP3 = pruniP3.getSelectedItem().toString();
        final String spesDiP3 = pesDiP3.getSelectedItem().toString();
        final String sweediP3 = weediP3.getSelectedItem().toString();
        final String sharveP3 = harveP3.getSelectedItem().toString();
        final String sshadeP3 = shadeP3.getSelectedItem().toString();
        final String ssoilCP3 = soilCP3.getSelectedItem().toString();
        final String sorgMaP3 = orgMaP3.getSelectedItem().toString();
        final String sfertFP3 = fertFP3.getSelectedItem().toString();
        final String sfertAP3 = fertAP3.getSelectedItem().toString();
        final String sdrainP3 = drainP3.getSelectedItem().toString();
        final String shireNP3 = hireNP3.getSelectedItem().toString();
        final String sageP4 = ageP4.getText().toString();
        final String sfcondP4 = fcondP4.getText().toString();
        final String slimeNP4 = limeNP4.getText().toString();
        final String sfilliP4 = filliP4.getText().toString();
        final String sph4 = ph4.getText().toString();
        final String sgeneticP4 = geneticP4.getText().toString();
        final String sgapP4 = gapP4.getText().toString();
        final String ssoilFertMng4 = soilFertMng4.getText().toString();
        final String scteP4 = cteP4.getSelectedItem().toString();
        final String splantP4 = plantP4.getSelectedItem().toString();
        final String stehelP4 = tehelP4.getSelectedItem().toString();
        final String sdebDiP4 = debDiP4.getSelectedItem().toString();
        final String spruniP4 = pruniP4.getSelectedItem().toString();
        final String spesDiP4 = pesDiP4.getSelectedItem().toString();
        final String sweediP4 = weediP4.getSelectedItem().toString();
        final String sharveP4 = harveP4.getSelectedItem().toString();
        final String sshadeP4 = shadeP4.getSelectedItem().toString();
        final String ssoilCP4 = soilCP4.getSelectedItem().toString();
        final String sorgMaP4 = orgMaP4.getSelectedItem().toString();
        final String sfertFP4 = fertFP4.getSelectedItem().toString();
        final String sfertAP4 = fertAP4.getSelectedItem().toString();
        final String sdrainP4 = drainP4.getSelectedItem().toString();
        final String shireNP4 = hireNP4.getSelectedItem().toString();
        final String sageP5 = ageP5.getText().toString();
        final String sfcondP5 = fcondP5.getText().toString();
        final String slimeNP5 = limeNP5.getText().toString();
        final String sfilliP5 = filliP5.getText().toString();
        final String sph5 = ph5.getText().toString();
        final String sgeneticP5 = geneticP5.getText().toString();
        final String sgapP5 = gapP5.getText().toString();
        final String ssoilFertMng5 = soilFertMng5.getText().toString();
        final String scteP5 = cteP5.getSelectedItem().toString();
        final String splantP5 = plantP5.getSelectedItem().toString();
        final String stehelP5 = tehelP5.getSelectedItem().toString();
        final String sdebDiP5 = debDiP5.getSelectedItem().toString();
        final String spruniP5 = pruniP5.getSelectedItem().toString();
        final String spesDiP5 = pesDiP5.getSelectedItem().toString();
        final String sweediP5 = weediP5.getSelectedItem().toString();
        final String sharveP5 = harveP5.getSelectedItem().toString();
        final String sshadeP5 = shadeP5.getSelectedItem().toString();
        final String ssoilCP5 = soilCP5.getSelectedItem().toString();
        final String sorgMaP5 = orgMaP5.getSelectedItem().toString();
        final String sfertFP5 = fertFP5.getSelectedItem().toString();
        final String sfertAP5 = fertAP5.getSelectedItem().toString();
        final String sdrainP5 = drainP5.getSelectedItem().toString();
        final String shireNP5 = hireNP5.getSelectedItem().toString();
        final String sageP6 = ageP6.getText().toString();
        final String sfcondP6 = fcondP6.getText().toString();
        final String slimeNP6 = limeNP6.getText().toString();
        final String sfilliP6 = filliP6.getText().toString();
        final String sph6 = ph6.getText().toString();
        final String sgeneticP6 = geneticP6.getText().toString();
        final String sgapP6 = gapP6.getText().toString();
        final String ssoilFertMng6 = soilFertMng6.getText().toString();
        final String scteP6 = cteP6.getSelectedItem().toString();
        final String splantP6 = plantP6.getSelectedItem().toString();
        final String stehelP6 = tehelP6.getSelectedItem().toString();
        final String sdebDiP6 = debDiP6.getSelectedItem().toString();
        final String spruniP6 = pruniP6.getSelectedItem().toString();
        final String spesDiP6 = pesDiP6.getSelectedItem().toString();
        final String sweediP6 = weediP6.getSelectedItem().toString();
        final String sharveP6 = harveP6.getSelectedItem().toString();
        final String sshadeP6 = shadeP6.getSelectedItem().toString();
        final String ssoilCP6 = soilCP6.getSelectedItem().toString();
        final String sorgMaP6 = orgMaP6.getSelectedItem().toString();
        final String sfertFP6 = fertFP6.getSelectedItem().toString();
        final String sfertAP6 = fertAP6.getSelectedItem().toString();
        final String sdrainP6 = drainP6.getSelectedItem().toString();
        final String shireNP6 = hireNP6.getSelectedItem().toString();
        final String sageP7 = ageP7.getText().toString();
        final String sfcondP7 = fcondP7.getText().toString();
        final String slimeNP7 = limeNP7.getText().toString();
        final String sfilliP7 = filliP7.getText().toString();
        final String sph7 = ph7.getText().toString();
        final String sgeneticP7 = geneticP7.getText().toString();
        final String sgapP7 = gapP7.getText().toString();
        final String ssoilFertMng7 = soilFertMng7.getText().toString();
        final String scteP7 = cteP7.getSelectedItem().toString();
        final String splantP7 = plantP7.getSelectedItem().toString();
        final String stehelP7 = tehelP7.getSelectedItem().toString();
        final String sdebDiP7 = debDiP7.getSelectedItem().toString();
        final String spruniP7 = pruniP7.getSelectedItem().toString();
        final String spesDiP7 = pesDiP7.getSelectedItem().toString();
        final String sweediP7 = weediP7.getSelectedItem().toString();
        final String sharveP7 = harveP7.getSelectedItem().toString();
        final String sshadeP7 = shadeP7.getSelectedItem().toString();
        final String ssoilCP7 = soilCP7.getSelectedItem().toString();
        final String sorgMaP7 = orgMaP7.getSelectedItem().toString();
        final String sfertFP7 = fertFP7.getSelectedItem().toString();
        final String sfertAP7 = fertAP7.getSelectedItem().toString();
        final String sdrainP7 = drainP7.getSelectedItem().toString();
        final String shireNP7 = hireNP7.getSelectedItem().toString();
        final String sageP8 = ageP8.getText().toString();
        final String sfcondP8 = fcondP8.getText().toString();
        final String slimeNP8 = limeNP8.getText().toString();
        final String sfilliP8 = filliP8.getText().toString();
        final String sph8 = ph8.getText().toString();
        final String sgeneticP8 = geneticP8.getText().toString();
        final String sgapP8 = gapP8.getText().toString();
        final String ssoilFertMng8 = soilFertMng8.getText().toString();
        final String scteP8 = cteP8.getSelectedItem().toString();
        final String splantP8 = plantP8.getSelectedItem().toString();
        final String stehelP8 = tehelP8.getSelectedItem().toString();
        final String sdebDiP8 = debDiP8.getSelectedItem().toString();
        final String spruniP8 = pruniP8.getSelectedItem().toString();
        final String spesDiP8 = pesDiP8.getSelectedItem().toString();
        final String sweediP8 = weediP8.getSelectedItem().toString();
        final String sharveP8 = harveP8.getSelectedItem().toString();
        final String sshadeP8 = shadeP8.getSelectedItem().toString();
        final String ssoilCP8 = soilCP8.getSelectedItem().toString();
        final String sorgMaP8 = orgMaP8.getSelectedItem().toString();
        final String sfertFP8 = fertFP8.getSelectedItem().toString();
        final String sfertAP8 = fertAP8.getSelectedItem().toString();
        final String sdrainP8 = drainP8.getSelectedItem().toString();
        final String shireNP8 = hireNP8.getSelectedItem().toString();
        final String sageP9 = ageP9.getText().toString();
        final String sfcondP9 = fcondP9.getText().toString();
        final String slimeNP9 = limeNP9.getText().toString();
        final String sfilliP9 = filliP9.getText().toString();
        final String sph9 = ph9.getText().toString();
        final String sgeneticP9 = geneticP9.getText().toString();
        final String sgapP9 = gapP9.getText().toString();
        final String ssoilFertMng9 = soilFertMng9.getText().toString();
        final String scteP9 = cteP9.getSelectedItem().toString();
        final String splantP9 = plantP9.getSelectedItem().toString();
        final String stehelP9 = tehelP9.getSelectedItem().toString();
        final String sdebDiP9 = debDiP9.getSelectedItem().toString();
        final String spruniP9 = pruniP9.getSelectedItem().toString();
        final String spesDiP9 = pesDiP9.getSelectedItem().toString();
        final String sweediP9 = weediP9.getSelectedItem().toString();
        final String sharveP9 = harveP9.getSelectedItem().toString();
        final String sshadeP9 = shadeP9.getSelectedItem().toString();
        final String ssoilCP9 = soilCP9.getSelectedItem().toString();
        final String sorgMaP9 = orgMaP9.getSelectedItem().toString();
        final String sfertFP9 = fertFP9.getSelectedItem().toString();
        final String sfertAP9 = fertAP9.getSelectedItem().toString();
        final String sdrainP9 = drainP9.getSelectedItem().toString();
        final String shireNP9 = hireNP9.getSelectedItem().toString();
        final String sageP10 = ageP10.getText().toString();
        final String sfcondP10 = fcondP10.getText().toString();
        final String slimeNP10 = limeNP10.getText().toString();
        final String sfilliP10 = filliP10.getText().toString();
        final String sph10 = ph10.getText().toString();
        final String sgeneticP10 = geneticP10.getText().toString();
        final String sgapP10 = gapP10.getText().toString();
        final String ssoilFertMng10 = soilFertMng10.getText().toString();
        final String scteP10 = cteP10.getSelectedItem().toString();
        final String splantP10 = plantP10.getSelectedItem().toString();
        final String stehelP10 = tehelP10.getSelectedItem().toString();
        final String sdebDiP10 = debDiP10.getSelectedItem().toString();
        final String spruniP10 = pruniP10.getSelectedItem().toString();
        final String spesDiP10 = pesDiP10.getSelectedItem().toString();
        final String sweediP10 = weediP10.getSelectedItem().toString();
        final String sharveP10 = harveP10.getSelectedItem().toString();
        final String sshadeP10 = shadeP10.getSelectedItem().toString();
        final String ssoilCP10 = soilCP10.getSelectedItem().toString();
        final String sorgMaP10 = orgMaP10.getSelectedItem().toString();
        final String sfertFP10 = fertFP10.getSelectedItem().toString();
        final String sfertAP10 = fertAP10.getSelectedItem().toString();
        final String sdrainP10 = drainP10.getSelectedItem().toString();
        final String shireNP10 = hireNP10.getSelectedItem().toString();
        final String rP1 =renovP1.getSelectedItem().toString();
        final String rP2 =renovP2.getSelectedItem().toString();
        final String rP3 =renovP3.getSelectedItem().toString();
        final String rP4 =renovP4.getSelectedItem().toString();
        final String rP5 =renovP5.getSelectedItem().toString();
        final String rP6 =renovP6.getSelectedItem().toString();
        final String rP7 =renovP7.getSelectedItem().toString();
        final String rP8 =renovP8.getSelectedItem().toString();
        final String rP9 =renovP9.getSelectedItem().toString();
        final String rP10 =renovP10.getSelectedItem().toString();
        final String rRP1 =renovReasonP1.getSelectedItem().toString();
        final String rRP2 =renovReasonP2.getSelectedItem().toString();
        final String rRP3 =renovReasonP3.getSelectedItem().toString();
        final String rRP4 =renovReasonP4.getSelectedItem().toString();
        final String rRP5 =renovReasonP5.getSelectedItem().toString();
        final String rRP6 =renovReasonP6.getSelectedItem().toString();
        final String rRP7 =renovReasonP7.getSelectedItem().toString();
        final String rRP8 =renovReasonP8.getSelectedItem().toString();
        final String rRP9 =renovReasonP9.getSelectedItem().toString();
        final String rRP10 =renovReasonP10.getSelectedItem().toString();
        final String rYP1 =renovYearP1.getSelectedItem().toString();
        final String rYP2 =renovYearP2.getSelectedItem().toString();
        final String rYP3 =renovYearP3.getSelectedItem().toString();
        final String rYP4 =renovYearP4.getSelectedItem().toString();
        final String rYP5 =renovYearP5.getSelectedItem().toString();
        final String rYP6 =renovYearP6.getSelectedItem().toString();
        final String rYP7 =renovYearP7.getSelectedItem().toString();
        final String rYP8 =renovYearP8.getSelectedItem().toString();
        final String rYP9 =renovYearP9.getSelectedItem().toString();
        final String rYP10 =renovYearP10.getSelectedItem().toString();
        final String recop1 =reco1.getText().toString();
        final String recop2 =reco2.getText().toString();
        final String recop3 =reco3.getText().toString();
        final String recop4 =reco4.getText().toString();
        final String recop5 =reco5.getText().toString();
        final String recop6 =reco6.getText().toString();
        final String recop7 =reco7.getText().toString();
        final String recop8 =reco8.getText().toString();
        final String recop9 =reco9.getText().toString();
        final String recop10 =reco10.getText().toString();
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
            contact.put(ContactObject.PLOT1GPS,sgps1);
            contact.put(ContactObject.PLOT1AGE,sageP1);
            contact.put(ContactObject.PLOT1AREA,sareP1);
            contact.put(ContactObject.PLOT1COCOATREES,scteP1);
            contact.put(ContactObject.PLOT1YIELD,sestP1);
            contact.put(ContactObject.PLANTINGMATERIAL1,splantP1);
            contact.put(ContactObject.FARMCONDITION1,sfcondP1);
            contact.put(ContactObject.TREEHEALTH1,stehelP1);
            contact.put(ContactObject.DEBILITATINGDISEASE1,sdebDiP1);
            contact.put(ContactObject.PRUNING1,spruniP1);
            contact.put(ContactObject.PESTDISEASESANITATION1,spesDiP1);
            contact.put(ContactObject.WEEDING1,sweediP1);
            contact.put(ContactObject.HARVESTING1,sharveP1);
            contact.put(ContactObject.SHADEMANAGEMENT1,sshadeP1);
            contact.put(ContactObject.SOILCONDITION1,ssoilCP1);
            contact.put(ContactObject.ORGANICMATTER1,sorgMaP1);
            contact.put(ContactObject.FERTILIZERFORMULATION1,sfertFP1);
            contact.put(ContactObject.FERTILIZERAPPLICATION1,sfertAP1);
            contact.put(ContactObject.LIMENEED1,slimeNP1);
            contact.put(ContactObject.DRAINAGENEED1,sdrainP1);
            contact.put(ContactObject.FILLINGOPTION1,sfilliP1);
            contact.put(ContactObject.HIRELABOR1,shireNP1);
            contact.put(ContactObject.PH1,sph1);
            contact.put(ContactObject.GENETIC1,sgeneticP1);
            contact.put(ContactObject.GAP1,sgapP1);
            contact.put(ContactObject.SOILMNG1,ssoilFertMng1);
            contact.put(ContactObject.PLOT2GPS,sgps2);
            contact.put(ContactObject.PLOT2AGE,sageP2);
            contact.put(ContactObject.PLOT2AREA,sareP2);
            contact.put(ContactObject.PLOT2COCOATREES,scteP2);
            contact.put(ContactObject.PLOT2YIELD,sestP2);
            contact.put(ContactObject.PLANTINGMATERIAL2,splantP2);
            contact.put(ContactObject.FARMCONDITION2,sfcondP2);
            contact.put(ContactObject.TREEHEALTH2,stehelP2);
            contact.put(ContactObject.DEBILITATINGDISEASE2,sdebDiP2);
            contact.put(ContactObject.PRUNING2,spruniP2);
            contact.put(ContactObject.PESTDISEASESANITATION2,spesDiP2);
            contact.put(ContactObject.WEEDING2,sweediP2);
            contact.put(ContactObject.HARVESTING2,sharveP2);
            contact.put(ContactObject.SHADEMANAGEMENT2,sshadeP2);
            contact.put(ContactObject.SOILCONDITION2,ssoilCP2);
            contact.put(ContactObject.ORGANICMATTER2,sorgMaP2);
            contact.put(ContactObject.FERTILIZERFORMULATION2,sfertFP2);
            contact.put(ContactObject.FERTILIZERAPPLICATION2,sfertAP2);
            contact.put(ContactObject.LIMENEED2,slimeNP2);
            contact.put(ContactObject.DRAINAGENEED2,sdrainP2);
            contact.put(ContactObject.FILLINGOPTION2,sfilliP2);
            contact.put(ContactObject.HIRELABOR2,shireNP2);
            contact.put(ContactObject.PH2,sph2);
            contact.put(ContactObject.GENETIC2,sgeneticP2);
            contact.put(ContactObject.GAP2,sgapP2);
            contact.put(ContactObject.SOILMNG2,ssoilFertMng2);
            contact.put(ContactObject.PLOT3GPS,sgps3);
            contact.put(ContactObject.PLOT3AGE,sageP3);
            contact.put(ContactObject.PLOT3AREA,sareP3);
            contact.put(ContactObject.PLOT3COCOATREES,scteP3);
            contact.put(ContactObject.PLOT3YIELD,sestP3);
            contact.put(ContactObject.PLANTINGMATERIAL3,splantP3);
            contact.put(ContactObject.FARMCONDITION3,sfcondP3);
            contact.put(ContactObject.TREEHEALTH3,stehelP3);
            contact.put(ContactObject.DEBILITATINGDISEASE3,sdebDiP3);
            contact.put(ContactObject.PRUNING3,spruniP3);
            contact.put(ContactObject.PESTDISEASESANITATION3,spesDiP3);
            contact.put(ContactObject.WEEDING3,sweediP3);
            contact.put(ContactObject.HARVESTING3,sharveP3);
            contact.put(ContactObject.SHADEMANAGEMENT3,sshadeP3);
            contact.put(ContactObject.SOILCONDITION3,ssoilCP3);
            contact.put(ContactObject.ORGANICMATTER3,sorgMaP3);
            contact.put(ContactObject.FERTILIZERFORMULATION3,sfertFP3);
            contact.put(ContactObject.FERTILIZERAPPLICATION3,sfertAP3);
            contact.put(ContactObject.LIMENEED3,slimeNP3);
            contact.put(ContactObject.DRAINAGENEED3,sdrainP3);
            contact.put(ContactObject.FILLINGOPTION3,sfilliP3);
            contact.put(ContactObject.HIRELABOR3,shireNP3);
            contact.put(ContactObject.PH3,sph3);
            contact.put(ContactObject.GENETIC3,sgeneticP3);
            contact.put(ContactObject.GAP3,sgapP3);
            contact.put(ContactObject.SOILMNG3,ssoilFertMng3);
            contact.put(ContactObject.PLOT4GPS,sgps4);
            contact.put(ContactObject.PLOT4AGE,sageP4);
            contact.put(ContactObject.PLOT4AREA,sareP4);
            contact.put(ContactObject.PLOT4COCOATREES,scteP4);
            contact.put(ContactObject.PLOT4YIELD,sestP4);
            contact.put(ContactObject.PLANTINGMATERIAL4,splantP4);
            contact.put(ContactObject.FARMCONDITION4,sfcondP4);
            contact.put(ContactObject.TREEHEALTH4,stehelP4);
            contact.put(ContactObject.DEBILITATINGDISEASE4,sdebDiP4);
            contact.put(ContactObject.PRUNING4,spruniP4);
            contact.put(ContactObject.PESTDISEASESANITATION4,spesDiP4);
            contact.put(ContactObject.WEEDING4,sweediP4);
            contact.put(ContactObject.HARVESTING4,sharveP4);
            contact.put(ContactObject.SHADEMANAGEMENT4,sshadeP4);
            contact.put(ContactObject.SOILCONDITION4,ssoilCP4);
            contact.put(ContactObject.ORGANICMATTER4,sorgMaP4);
            contact.put(ContactObject.FERTILIZERFORMULATION4,sfertFP4);
            contact.put(ContactObject.FERTILIZERAPPLICATION4,sfertAP4);
            contact.put(ContactObject.LIMENEED4,slimeNP4);
            contact.put(ContactObject.DRAINAGENEED4,sdrainP4);
            contact.put(ContactObject.FILLINGOPTION4,sfilliP4);
            contact.put(ContactObject.HIRELABOR4,shireNP4);
            contact.put(ContactObject.PH4,sph4);
            contact.put(ContactObject.GENETIC4,sgeneticP4);
            contact.put(ContactObject.GAP4,sgapP4);
            contact.put(ContactObject.SOILMNG4,ssoilFertMng4);
            contact.put(ContactObject.PLOT5GPS,sgps5);
            contact.put(ContactObject.PLOT5AGE,sageP5);
            contact.put(ContactObject.PLOT5AREA,sareP5);
            contact.put(ContactObject.PLOT5COCOATREES,scteP5);
            contact.put(ContactObject.PLOT5YIELD,sestP5);
            contact.put(ContactObject.PLANTINGMATERIAL5,splantP5);
            contact.put(ContactObject.FARMCONDITION5,sfcondP5);
            contact.put(ContactObject.TREEHEALTH5,stehelP5);
            contact.put(ContactObject.DEBILITATINGDISEASE5,sdebDiP5);
            contact.put(ContactObject.PRUNING5,spruniP5);
            contact.put(ContactObject.PESTDISEASESANITATION5,spesDiP5);
            contact.put(ContactObject.WEEDING5,sweediP5);
            contact.put(ContactObject.HARVESTING5,sharveP5);
            contact.put(ContactObject.SHADEMANAGEMENT5,sshadeP5);
            contact.put(ContactObject.SOILCONDITION5,ssoilCP5);
            contact.put(ContactObject.ORGANICMATTER5,sorgMaP5);
            contact.put(ContactObject.FERTILIZERFORMULATION5,sfertFP5);
            contact.put(ContactObject.FERTILIZERAPPLICATION5,sfertAP5);
            contact.put(ContactObject.LIMENEED5,slimeNP5);
            contact.put(ContactObject.DRAINAGENEED5,sdrainP5);
            contact.put(ContactObject.FILLINGOPTION5,sfilliP5);
            contact.put(ContactObject.HIRELABOR5,shireNP5);
            contact.put(ContactObject.PH5,sph5);
            contact.put(ContactObject.GENETIC5,sgeneticP5);
            contact.put(ContactObject.GAP5,sgapP5);
            contact.put(ContactObject.SOILMNG5,ssoilFertMng5);
            contact.put(ContactObject.PLOT6GPS,sgps6);
            contact.put(ContactObject.PLOT6AGE,sageP6);
            contact.put(ContactObject.PLOT6AREA,sareP6);
            contact.put(ContactObject.PLOT6COCOATREES,scteP6);
            contact.put(ContactObject.PLOT6YIELD,sestP6);
            contact.put(ContactObject.PLANTINGMATERIAL6,splantP6);
            contact.put(ContactObject.FARMCONDITION6,sfcondP6);
            contact.put(ContactObject.TREEHEALTH6,stehelP6);
            contact.put(ContactObject.DEBILITATINGDISEASE6,sdebDiP6);
            contact.put(ContactObject.PRUNING6,spruniP6);
            contact.put(ContactObject.PESTDISEASESANITATION6,spesDiP6);
            contact.put(ContactObject.WEEDING6,sweediP6);
            contact.put(ContactObject.HARVESTING6,sharveP6);
            contact.put(ContactObject.SHADEMANAGEMENT6,sshadeP6);
            contact.put(ContactObject.SOILCONDITION6,ssoilCP6);
            contact.put(ContactObject.ORGANICMATTER6,sorgMaP6);
            contact.put(ContactObject.FERTILIZERFORMULATION6,sfertFP6);
            contact.put(ContactObject.FERTILIZERAPPLICATION6,sfertAP6);
            contact.put(ContactObject.LIMENEED6,slimeNP6);
            contact.put(ContactObject.DRAINAGENEED6,sdrainP6);
            contact.put(ContactObject.FILLINGOPTION6,sfilliP6);
            contact.put(ContactObject.HIRELABOR6,shireNP6);
            contact.put(ContactObject.PH6,sph6);
            contact.put(ContactObject.GENETIC6,sgeneticP6);
            contact.put(ContactObject.GAP6,sgapP6);
            contact.put(ContactObject.SOILMNG6,ssoilFertMng6);
            contact.put(ContactObject.PLOT7GPS,sgps7);
            contact.put(ContactObject.PLOT7AGE,sageP7);
            contact.put(ContactObject.PLOT7AREA,sareP7);
            contact.put(ContactObject.PLOT7COCOATREES,scteP7);
            contact.put(ContactObject.PLOT7YIELD,sestP7);
            contact.put(ContactObject.PLANTINGMATERIAL7,splantP7);
            contact.put(ContactObject.FARMCONDITION7,sfcondP7);
            contact.put(ContactObject.TREEHEALTH7,stehelP7);
            contact.put(ContactObject.DEBILITATINGDISEASE7,sdebDiP7);
            contact.put(ContactObject.PRUNING7,spruniP7);
            contact.put(ContactObject.PESTDISEASESANITATION7,spesDiP7);
            contact.put(ContactObject.WEEDING7,sweediP7);
            contact.put(ContactObject.HARVESTING7,sharveP7);
            contact.put(ContactObject.SHADEMANAGEMENT7,sshadeP7);
            contact.put(ContactObject.SOILCONDITION7,ssoilCP7);
            contact.put(ContactObject.ORGANICMATTER7,sorgMaP7);
            contact.put(ContactObject.FERTILIZERFORMULATION7,sfertFP7);
            contact.put(ContactObject.FERTILIZERAPPLICATION7,sfertAP7);
            contact.put(ContactObject.LIMENEED7,slimeNP7);
            contact.put(ContactObject.DRAINAGENEED7,sdrainP7);
            contact.put(ContactObject.FILLINGOPTION7,sfilliP7);
            contact.put(ContactObject.HIRELABOR7,shireNP7);
            contact.put(ContactObject.PH7,sph7);
            contact.put(ContactObject.GENETIC7,sgeneticP7);
            contact.put(ContactObject.GAP7,sgapP7);
            contact.put(ContactObject.SOILMNG7,ssoilFertMng7);
            contact.put(ContactObject.PLOT8GPS,sgps8);
            contact.put(ContactObject.PLOT8AGE,sageP8);
            contact.put(ContactObject.PLOT8AREA,sareP8);
            contact.put(ContactObject.PLOT8COCOATREES,scteP8);
            contact.put(ContactObject.PLOT8YIELD,sestP8);
            contact.put(ContactObject.PLANTINGMATERIAL8,splantP8);
            contact.put(ContactObject.FARMCONDITION8,sfcondP8);
            contact.put(ContactObject.TREEHEALTH8,stehelP8);
            contact.put(ContactObject.DEBILITATINGDISEASE8,sdebDiP8);
            contact.put(ContactObject.PRUNING8,spruniP8);
            contact.put(ContactObject.PESTDISEASESANITATION8,spesDiP8);
            contact.put(ContactObject.WEEDING8,sweediP8);
            contact.put(ContactObject.HARVESTING8,sharveP8);
            contact.put(ContactObject.SHADEMANAGEMENT8,sshadeP8);
            contact.put(ContactObject.SOILCONDITION8,ssoilCP8);
            contact.put(ContactObject.ORGANICMATTER8,sorgMaP8);
            contact.put(ContactObject.FERTILIZERFORMULATION8,sfertFP8);
            contact.put(ContactObject.FERTILIZERAPPLICATION8,sfertAP8);
            contact.put(ContactObject.LIMENEED8,slimeNP8);
            contact.put(ContactObject.DRAINAGENEED8,sdrainP8);
            contact.put(ContactObject.FILLINGOPTION8,sfilliP8);
            contact.put(ContactObject.HIRELABOR8,shireNP8);
            contact.put(ContactObject.PH8,sph8);
            contact.put(ContactObject.GENETIC8,sgeneticP8);
            contact.put(ContactObject.GAP8,sgapP8);
            contact.put(ContactObject.SOILMNG8,ssoilFertMng8);
            contact.put(ContactObject.PLOT9GPS,sgps9);
            contact.put(ContactObject.PLOT9AGE,sageP9);
            contact.put(ContactObject.PLOT9AREA,sareP9);
            contact.put(ContactObject.PLOT9COCOATREES,scteP9);
            contact.put(ContactObject.PLOT9YIELD,sestP9);
            contact.put(ContactObject.PLANTINGMATERIAL9,splantP9);
            contact.put(ContactObject.FARMCONDITION9,sfcondP9);
            contact.put(ContactObject.TREEHEALTH9,stehelP9);
            contact.put(ContactObject.DEBILITATINGDISEASE9,sdebDiP9);
            contact.put(ContactObject.PRUNING9,spruniP9);
            contact.put(ContactObject.PESTDISEASESANITATION9,spesDiP9);
            contact.put(ContactObject.WEEDING9,sweediP9);
            contact.put(ContactObject.HARVESTING9,sharveP9);
            contact.put(ContactObject.SHADEMANAGEMENT9,sshadeP9);
            contact.put(ContactObject.SOILCONDITION9,ssoilCP9);
            contact.put(ContactObject.ORGANICMATTER9,sorgMaP9);
            contact.put(ContactObject.FERTILIZERFORMULATION9,sfertFP9);
            contact.put(ContactObject.FERTILIZERAPPLICATION9,sfertAP9);
            contact.put(ContactObject.LIMENEED9,slimeNP9);
            contact.put(ContactObject.DRAINAGENEED9,sdrainP9);
            contact.put(ContactObject.FILLINGOPTION9,sfilliP9);
            contact.put(ContactObject.HIRELABOR9,shireNP9);
            contact.put(ContactObject.PH9,sph9);
            contact.put(ContactObject.GENETIC9,sgeneticP9);
            contact.put(ContactObject.GAP9,sgapP9);
            contact.put(ContactObject.SOILMNG9,ssoilFertMng9);
            contact.put(ContactObject.PLOT10GPS,sgps10);
            contact.put(ContactObject.PLOT10AGE,sageP10);
            contact.put(ContactObject.PLOT10AREA,sareP10);
            contact.put(ContactObject.PLOT10COCOATREES,scteP10);
            contact.put(ContactObject.PLOT10YIELD,sestP10);
            contact.put(ContactObject.PLANTINGMATERIAL10,splantP10);
            contact.put(ContactObject.FARMCONDITION10,sfcondP10);
            contact.put(ContactObject.TREEHEALTH10,stehelP10);
            contact.put(ContactObject.DEBILITATINGDISEASE10,sdebDiP10);
            contact.put(ContactObject.PRUNING10,spruniP10);
            contact.put(ContactObject.PESTDISEASESANITATION10,spesDiP10);
            contact.put(ContactObject.WEEDING10,sweediP10);
            contact.put(ContactObject.HARVESTING10,sharveP10);
            contact.put(ContactObject.SHADEMANAGEMENT10,sshadeP10);
            contact.put(ContactObject.SOILCONDITION10,ssoilCP10);
            contact.put(ContactObject.ORGANICMATTER10,sorgMaP10);
            contact.put(ContactObject.FERTILIZERFORMULATION10,sfertFP10);
            contact.put(ContactObject.FERTILIZERAPPLICATION10,sfertAP10);
            contact.put(ContactObject.LIMENEED10,slimeNP10);
            contact.put(ContactObject.DRAINAGENEED10,sdrainP10);
            contact.put(ContactObject.FILLINGOPTION10,sfilliP10);
            contact.put(ContactObject.HIRELABOR10,shireNP10);
            contact.put(ContactObject.PH10,sph10);
            contact.put(ContactObject.GENETIC10,sgeneticP10);
            contact.put(ContactObject.GAP10,sgapP10);
            contact.put(ContactObject.SOILMNG10,ssoilFertMng10);
            contact.put(ContactObject.PLOT1RENOVATION,rP1);
            contact.put(ContactObject.PLOT2RENOVATION,rP2);
            contact.put(ContactObject.PLOT3RENOVATION,rP3);
            contact.put(ContactObject.PLOT4RENOVATION,rP4);
            contact.put(ContactObject.PLOT5RENOVATION,rP5);
            contact.put(ContactObject.PLOT6RENOVATION,rP6);
            contact.put(ContactObject.PLOT7RENOVATION,rP7);
            contact.put(ContactObject.PLOT8RENOVATION,rP8);
            contact.put(ContactObject.PLOT9RENOVATION,rP9);
            contact.put(ContactObject.PLOT10RENOVATION,rP10);
            contact.put(ContactObject.PLOT1RENOVATIONREASON,rRP1);
            contact.put(ContactObject.PLOT2RENOVATIONREASON,rRP2);
            contact.put(ContactObject.PLOT3RENOVATIONREASON,rRP3);
            contact.put(ContactObject.PLOT4RENOVATIONREASON,rRP4);
            contact.put(ContactObject.PLOT5RENOVATIONREASON,rRP5);
            contact.put(ContactObject.PLOT6RENOVATIONREASON,rRP6);
            contact.put(ContactObject.PLOT7RENOVATIONREASON,rRP7);
            contact.put(ContactObject.PLOT8RENOVATIONREASON,rRP8);
            contact.put(ContactObject.PLOT9RENOVATIONREASON,rRP9);
            contact.put(ContactObject.PLOT10RENOVATIONREASON,rRP10);
            contact.put(ContactObject.PLOT1RENOVATIONYEAR,rYP1);
            contact.put(ContactObject.PLOT2RENOVATIONYEAR,rYP2);
            contact.put(ContactObject.PLOT3RENOVATIONYEAR,rYP3);
            contact.put(ContactObject.PLOT4RENOVATIONYEAR,rYP4);
            contact.put(ContactObject.PLOT5RENOVATIONYEAR,rYP5);
            contact.put(ContactObject.PLOT6RENOVATIONYEAR,rYP6);
            contact.put(ContactObject.PLOT7RENOVATIONYEAR,rYP7);
            contact.put(ContactObject.PLOT8RENOVATIONYEAR,rYP8);
            contact.put(ContactObject.PLOT9RENOVATIONYEAR,rYP9);
            contact.put(ContactObject.PLOT10RENOVATIONYEAR,rYP10);
            if(rP1 !="N/A"){
                contact.put(ContactObject.STARTYEARP1,rYP1);
            }
            if(rP2 != "N/A"){
                contact.put(ContactObject.STARTYEARP2,rYP2);
            }
            if(rP3 != "N/A"){
                contact.put(ContactObject.STARTYEARP3,rYP3);
            }
            if(rP4 != "N/A"){
                contact.put(ContactObject.STARTYEARP4,rYP4);
            }
            if(rP5 != "N/A"){
                contact.put(ContactObject.STARTYEARP5,rYP5);
            }
            if(rP6 != "N/A"){
                contact.put(ContactObject.STARTYEARP6,rYP6);
            }
            if(rP7 != "N/A"){
                contact.put(ContactObject.STARTYEARP7,rYP7);
            }
            if(rP8 != "N/A"){
                contact.put(ContactObject.STARTYEARP8,rYP8);
            }
            if(rP9 != "N/A"){
                contact.put(ContactObject.STARTYEARP9,rYP9);
            }
            if(rP10 != "N/A"){
                contact.put(ContactObject.STARTYEARP10,rYP10);
            }
            contact.put(ContactObject.RECO1,recop1);
            contact.put(ContactObject.RECO2,recop2);
            contact.put(ContactObject.RECO3,recop3);
            contact.put(ContactObject.RECO4,recop4);
            contact.put(ContactObject.RECO5,recop5);
            contact.put(ContactObject.RECO6,recop6);
            contact.put(ContactObject.RECO7,recop7);
            contact.put(ContactObject.RECO8,recop8);
            contact.put(ContactObject.RECO9,recop9);
            contact.put(ContactObject.RECO10,recop10);
            contact.put(SyncManager.LOCAL, true);
            contact.put(SyncManager.LOCALLY_UPDATED, !isCreate);
            contact.put(SyncManager.LOCALLY_CREATED, isCreate);
            contact.put(SyncManager.LOCALLY_DELETED, false);
            if (isCreate) {
                smartStore.create(ContactListLoader.CONTACT_SOUP, contact);
            } else {
                smartStore.upsert(ContactListLoader.CONTACT_SOUP, contact);
            }
            Toast.makeText(this, "Save successful!", Toast.LENGTH_SHORT).show();
            finish();
        } catch (JSONException e) {
            Log.e(TAG, "JSONException occurred while parsing", e);
        }
    }

    public void partialSave() {
        final String sgps1 = gps1.getText().toString();
        final String sgps2 = gps2.getText().toString();
        final String sgps3 = gps3.getText().toString();
        final String sgps4 = gps4.getText().toString();
        final String sgps5 = gps5.getText().toString();
        final String sgps6 = gps6.getText().toString();
        final String sgps7 = gps7.getText().toString();
        final String sgps8 = gps8.getText().toString();
        final String sgps9 = gps9.getText().toString();
        final String sgps10 = gps10.getText().toString();
        final String sareP1 = areP1.getText().toString();
        final String sareP2 = areP2.getText().toString();
        final String sareP3 = areP3.getText().toString();
        final String sareP4 = areP4.getText().toString();
        final String sareP5 = areP5.getText().toString();
        final String sareP6 = areP6.getText().toString();
        final String sareP7 = areP7.getText().toString();
        final String sareP8 = areP8.getText().toString();
        final String sareP9 = areP9.getText().toString();
        final String sareP10 = areP10.getText().toString();
        final String sestP1 = estP1.getText().toString();
        final String sestP2 = estP2.getText().toString();
        final String sestP3 = estP3.getText().toString();
        final String sestP4 = estP4.getText().toString();
        final String sestP5 = estP5.getText().toString();
        final String sestP6 = estP6.getText().toString();
        final String sestP7 = estP7.getText().toString();
        final String sestP8 = estP8.getText().toString();
        final String sestP9 = estP9.getText().toString();
        final String sestP10 = estP10.getText().toString();
        final String sageP1 = ageP1.getText().toString();
        final String sfcondP1 = fcondP1.getText().toString();
        final String slimeNP1 = limeNP1.getText().toString();
        final String sfilliP1 = filliP1.getText().toString();
        final String sph1 = ph1.getText().toString();
        final String sgeneticP1 = geneticP1.getText().toString();
        final String sgapP1 = gapP1.getText().toString();
        final String ssoilFertMng1 = soilFertMng1.getText().toString();
        final String scteP1 = cteP1.getSelectedItem().toString();
        final String splantP1 = plantP1.getSelectedItem().toString();
        final String stehelP1 = tehelP1.getSelectedItem().toString();
        final String sdebDiP1 = debDiP1.getSelectedItem().toString();
        final String spruniP1 = pruniP1.getSelectedItem().toString();
        final String spesDiP1 = pesDiP1.getSelectedItem().toString();
        final String sweediP1 = weediP1.getSelectedItem().toString();
        final String sharveP1 = harveP1.getSelectedItem().toString();
        final String sshadeP1 = shadeP1.getSelectedItem().toString();
        final String ssoilCP1 = soilCP1.getSelectedItem().toString();
        final String sorgMaP1 = orgMaP1.getSelectedItem().toString();
        final String sfertFP1 = fertFP1.getSelectedItem().toString();
        final String sfertAP1 = fertAP1.getSelectedItem().toString();
        final String sdrainP1 = drainP1.getSelectedItem().toString();
        final String shireNP1 = hireNP1.getSelectedItem().toString();
        final String sageP2 = ageP2.getText().toString();
        final String sfcondP2 = fcondP2.getText().toString();
        final String slimeNP2 = limeNP2.getText().toString();
        final String sfilliP2 = filliP2.getText().toString();
        final String sph2 = ph2.getText().toString();
        final String sgeneticP2 = geneticP2.getText().toString();
        final String sgapP2 = gapP2.getText().toString();
        final String ssoilFertMng2 = soilFertMng2.getText().toString();
        final String scteP2 = cteP2.getSelectedItem().toString();
        final String splantP2 = plantP2.getSelectedItem().toString();
        final String stehelP2 = tehelP2.getSelectedItem().toString();
        final String sdebDiP2 = debDiP2.getSelectedItem().toString();
        final String spruniP2 = pruniP2.getSelectedItem().toString();
        final String spesDiP2 = pesDiP2.getSelectedItem().toString();
        final String sweediP2 = weediP2.getSelectedItem().toString();
        final String sharveP2 = harveP2.getSelectedItem().toString();
        final String sshadeP2 = shadeP2.getSelectedItem().toString();
        final String ssoilCP2 = soilCP2.getSelectedItem().toString();
        final String sorgMaP2 = orgMaP2.getSelectedItem().toString();
        final String sfertFP2 = fertFP2.getSelectedItem().toString();
        final String sfertAP2 = fertAP2.getSelectedItem().toString();
        final String sdrainP2 = drainP2.getSelectedItem().toString();
        final String shireNP2 = hireNP2.getSelectedItem().toString();
        final String sageP3 = ageP3.getText().toString();
        final String sfcondP3 = fcondP3.getText().toString();
        final String slimeNP3 = limeNP3.getText().toString();
        final String sfilliP3 = filliP3.getText().toString();
        final String sph3 = ph3.getText().toString();
        final String sgeneticP3 = geneticP3.getText().toString();
        final String sgapP3 = gapP3.getText().toString();
        final String ssoilFertMng3 = soilFertMng3.getText().toString();
        final String scteP3 = cteP3.getSelectedItem().toString();
        final String splantP3 = plantP3.getSelectedItem().toString();
        final String stehelP3 = tehelP3.getSelectedItem().toString();
        final String sdebDiP3 = debDiP3.getSelectedItem().toString();
        final String spruniP3 = pruniP3.getSelectedItem().toString();
        final String spesDiP3 = pesDiP3.getSelectedItem().toString();
        final String sweediP3 = weediP3.getSelectedItem().toString();
        final String sharveP3 = harveP3.getSelectedItem().toString();
        final String sshadeP3 = shadeP3.getSelectedItem().toString();
        final String ssoilCP3 = soilCP3.getSelectedItem().toString();
        final String sorgMaP3 = orgMaP3.getSelectedItem().toString();
        final String sfertFP3 = fertFP3.getSelectedItem().toString();
        final String sfertAP3 = fertAP3.getSelectedItem().toString();
        final String sdrainP3 = drainP3.getSelectedItem().toString();
        final String shireNP3 = hireNP3.getSelectedItem().toString();
        final String sageP4 = ageP4.getText().toString();
        final String sfcondP4 = fcondP4.getText().toString();
        final String slimeNP4 = limeNP4.getText().toString();
        final String sfilliP4 = filliP4.getText().toString();
        final String sph4 = ph4.getText().toString();
        final String sgeneticP4 = geneticP4.getText().toString();
        final String sgapP4 = gapP4.getText().toString();
        final String ssoilFertMng4 = soilFertMng4.getText().toString();
        final String scteP4 = cteP4.getSelectedItem().toString();
        final String splantP4 = plantP4.getSelectedItem().toString();
        final String stehelP4 = tehelP4.getSelectedItem().toString();
        final String sdebDiP4 = debDiP4.getSelectedItem().toString();
        final String spruniP4 = pruniP4.getSelectedItem().toString();
        final String spesDiP4 = pesDiP4.getSelectedItem().toString();
        final String sweediP4 = weediP4.getSelectedItem().toString();
        final String sharveP4 = harveP4.getSelectedItem().toString();
        final String sshadeP4 = shadeP4.getSelectedItem().toString();
        final String ssoilCP4 = soilCP4.getSelectedItem().toString();
        final String sorgMaP4 = orgMaP4.getSelectedItem().toString();
        final String sfertFP4 = fertFP4.getSelectedItem().toString();
        final String sfertAP4 = fertAP4.getSelectedItem().toString();
        final String sdrainP4 = drainP4.getSelectedItem().toString();
        final String shireNP4 = hireNP4.getSelectedItem().toString();
        final String sageP5 = ageP5.getText().toString();
        final String sfcondP5 = fcondP5.getText().toString();
        final String slimeNP5 = limeNP5.getText().toString();
        final String sfilliP5 = filliP5.getText().toString();
        final String sph5 = ph5.getText().toString();
        final String sgeneticP5 = geneticP5.getText().toString();
        final String sgapP5 = gapP5.getText().toString();
        final String ssoilFertMng5 = soilFertMng5.getText().toString();
        final String scteP5 = cteP5.getSelectedItem().toString();
        final String splantP5 = plantP5.getSelectedItem().toString();
        final String stehelP5 = tehelP5.getSelectedItem().toString();
        final String sdebDiP5 = debDiP5.getSelectedItem().toString();
        final String spruniP5 = pruniP5.getSelectedItem().toString();
        final String spesDiP5 = pesDiP5.getSelectedItem().toString();
        final String sweediP5 = weediP5.getSelectedItem().toString();
        final String sharveP5 = harveP5.getSelectedItem().toString();
        final String sshadeP5 = shadeP5.getSelectedItem().toString();
        final String ssoilCP5 = soilCP5.getSelectedItem().toString();
        final String sorgMaP5 = orgMaP5.getSelectedItem().toString();
        final String sfertFP5 = fertFP5.getSelectedItem().toString();
        final String sfertAP5 = fertAP5.getSelectedItem().toString();
        final String sdrainP5 = drainP5.getSelectedItem().toString();
        final String shireNP5 = hireNP5.getSelectedItem().toString();
        final String sageP6 = ageP6.getText().toString();
        final String sfcondP6 = fcondP6.getText().toString();
        final String slimeNP6 = limeNP6.getText().toString();
        final String sfilliP6 = filliP6.getText().toString();
        final String sph6 = ph6.getText().toString();
        final String sgeneticP6 = geneticP6.getText().toString();
        final String sgapP6 = gapP6.getText().toString();
        final String ssoilFertMng6 = soilFertMng6.getText().toString();
        final String scteP6 = cteP6.getSelectedItem().toString();
        final String splantP6 = plantP6.getSelectedItem().toString();
        final String stehelP6 = tehelP6.getSelectedItem().toString();
        final String sdebDiP6 = debDiP6.getSelectedItem().toString();
        final String spruniP6 = pruniP6.getSelectedItem().toString();
        final String spesDiP6 = pesDiP6.getSelectedItem().toString();
        final String sweediP6 = weediP6.getSelectedItem().toString();
        final String sharveP6 = harveP6.getSelectedItem().toString();
        final String sshadeP6 = shadeP6.getSelectedItem().toString();
        final String ssoilCP6 = soilCP6.getSelectedItem().toString();
        final String sorgMaP6 = orgMaP6.getSelectedItem().toString();
        final String sfertFP6 = fertFP6.getSelectedItem().toString();
        final String sfertAP6 = fertAP6.getSelectedItem().toString();
        final String sdrainP6 = drainP6.getSelectedItem().toString();
        final String shireNP6 = hireNP6.getSelectedItem().toString();
        final String sageP7 = ageP7.getText().toString();
        final String sfcondP7 = fcondP7.getText().toString();
        final String slimeNP7 = limeNP7.getText().toString();
        final String sfilliP7 = filliP7.getText().toString();
        final String sph7 = ph7.getText().toString();
        final String sgeneticP7 = geneticP7.getText().toString();
        final String sgapP7 = gapP7.getText().toString();
        final String ssoilFertMng7 = soilFertMng7.getText().toString();
        final String scteP7 = cteP7.getSelectedItem().toString();
        final String splantP7 = plantP7.getSelectedItem().toString();
        final String stehelP7 = tehelP7.getSelectedItem().toString();
        final String sdebDiP7 = debDiP7.getSelectedItem().toString();
        final String spruniP7 = pruniP7.getSelectedItem().toString();
        final String spesDiP7 = pesDiP7.getSelectedItem().toString();
        final String sweediP7 = weediP7.getSelectedItem().toString();
        final String sharveP7 = harveP7.getSelectedItem().toString();
        final String sshadeP7 = shadeP7.getSelectedItem().toString();
        final String ssoilCP7 = soilCP7.getSelectedItem().toString();
        final String sorgMaP7 = orgMaP7.getSelectedItem().toString();
        final String sfertFP7 = fertFP7.getSelectedItem().toString();
        final String sfertAP7 = fertAP7.getSelectedItem().toString();
        final String sdrainP7 = drainP7.getSelectedItem().toString();
        final String shireNP7 = hireNP7.getSelectedItem().toString();
        final String sageP8 = ageP8.getText().toString();
        final String sfcondP8 = fcondP8.getText().toString();
        final String slimeNP8 = limeNP8.getText().toString();
        final String sfilliP8 = filliP8.getText().toString();
        final String sph8 = ph8.getText().toString();
        final String sgeneticP8 = geneticP8.getText().toString();
        final String sgapP8 = gapP8.getText().toString();
        final String ssoilFertMng8 = soilFertMng8.getText().toString();
        final String scteP8 = cteP8.getSelectedItem().toString();
        final String splantP8 = plantP8.getSelectedItem().toString();
        final String stehelP8 = tehelP8.getSelectedItem().toString();
        final String sdebDiP8 = debDiP8.getSelectedItem().toString();
        final String spruniP8 = pruniP8.getSelectedItem().toString();
        final String spesDiP8 = pesDiP8.getSelectedItem().toString();
        final String sweediP8 = weediP8.getSelectedItem().toString();
        final String sharveP8 = harveP8.getSelectedItem().toString();
        final String sshadeP8 = shadeP8.getSelectedItem().toString();
        final String ssoilCP8 = soilCP8.getSelectedItem().toString();
        final String sorgMaP8 = orgMaP8.getSelectedItem().toString();
        final String sfertFP8 = fertFP8.getSelectedItem().toString();
        final String sfertAP8 = fertAP8.getSelectedItem().toString();
        final String sdrainP8 = drainP8.getSelectedItem().toString();
        final String shireNP8 = hireNP8.getSelectedItem().toString();
        final String sageP9 = ageP9.getText().toString();
        final String sfcondP9 = fcondP9.getText().toString();
        final String slimeNP9 = limeNP9.getText().toString();
        final String sfilliP9 = filliP9.getText().toString();
        final String sph9 = ph9.getText().toString();
        final String sgeneticP9 = geneticP9.getText().toString();
        final String sgapP9 = gapP9.getText().toString();
        final String ssoilFertMng9 = soilFertMng9.getText().toString();
        final String scteP9 = cteP9.getSelectedItem().toString();
        final String splantP9 = plantP9.getSelectedItem().toString();
        final String stehelP9 = tehelP9.getSelectedItem().toString();
        final String sdebDiP9 = debDiP9.getSelectedItem().toString();
        final String spruniP9 = pruniP9.getSelectedItem().toString();
        final String spesDiP9 = pesDiP9.getSelectedItem().toString();
        final String sweediP9 = weediP9.getSelectedItem().toString();
        final String sharveP9 = harveP9.getSelectedItem().toString();
        final String sshadeP9 = shadeP9.getSelectedItem().toString();
        final String ssoilCP9 = soilCP9.getSelectedItem().toString();
        final String sorgMaP9 = orgMaP9.getSelectedItem().toString();
        final String sfertFP9 = fertFP9.getSelectedItem().toString();
        final String sfertAP9 = fertAP9.getSelectedItem().toString();
        final String sdrainP9 = drainP9.getSelectedItem().toString();
        final String shireNP9 = hireNP9.getSelectedItem().toString();
        final String sageP10 = ageP10.getText().toString();
        final String sfcondP10 = fcondP10.getText().toString();
        final String slimeNP10 = limeNP10.getText().toString();
        final String sfilliP10 = filliP10.getText().toString();
        final String sph10 = ph10.getText().toString();
        final String sgeneticP10 = geneticP10.getText().toString();
        final String sgapP10 = gapP10.getText().toString();
        final String ssoilFertMng10 = soilFertMng10.getText().toString();
        final String scteP10 = cteP10.getSelectedItem().toString();
        final String splantP10 = plantP10.getSelectedItem().toString();
        final String stehelP10 = tehelP10.getSelectedItem().toString();
        final String sdebDiP10 = debDiP10.getSelectedItem().toString();
        final String spruniP10 = pruniP10.getSelectedItem().toString();
        final String spesDiP10 = pesDiP10.getSelectedItem().toString();
        final String sweediP10 = weediP10.getSelectedItem().toString();
        final String sharveP10 = harveP10.getSelectedItem().toString();
        final String sshadeP10 = shadeP10.getSelectedItem().toString();
        final String ssoilCP10 = soilCP10.getSelectedItem().toString();
        final String sorgMaP10 = orgMaP10.getSelectedItem().toString();
        final String sfertFP10 = fertFP10.getSelectedItem().toString();
        final String sfertAP10 = fertAP10.getSelectedItem().toString();
        final String sdrainP10 = drainP10.getSelectedItem().toString();
        final String shireNP10 = hireNP10.getSelectedItem().toString();
        final String rP1 =renovP1.getSelectedItem().toString();
        final String rP2 =renovP2.getSelectedItem().toString();
        final String rP3 =renovP3.getSelectedItem().toString();
        final String rP4 =renovP4.getSelectedItem().toString();
        final String rP5 =renovP5.getSelectedItem().toString();
        final String rP6 =renovP6.getSelectedItem().toString();
        final String rP7 =renovP7.getSelectedItem().toString();
        final String rP8 =renovP8.getSelectedItem().toString();
        final String rP9 =renovP9.getSelectedItem().toString();
        final String rP10 =renovP10.getSelectedItem().toString();
        final String rRP1 =renovReasonP1.getSelectedItem().toString();
        final String rRP2 =renovReasonP2.getSelectedItem().toString();
        final String rRP3 =renovReasonP3.getSelectedItem().toString();
        final String rRP4 =renovReasonP4.getSelectedItem().toString();
        final String rRP5 =renovReasonP5.getSelectedItem().toString();
        final String rRP6 =renovReasonP6.getSelectedItem().toString();
        final String rRP7 =renovReasonP7.getSelectedItem().toString();
        final String rRP8 =renovReasonP8.getSelectedItem().toString();
        final String rRP9 =renovReasonP9.getSelectedItem().toString();
        final String rRP10 =renovReasonP10.getSelectedItem().toString();
        final String rYP1 =renovYearP1.getSelectedItem().toString();
        final String rYP2 =renovYearP2.getSelectedItem().toString();
        final String rYP3 =renovYearP3.getSelectedItem().toString();
        final String rYP4 =renovYearP4.getSelectedItem().toString();
        final String rYP5 =renovYearP5.getSelectedItem().toString();
        final String rYP6 =renovYearP6.getSelectedItem().toString();
        final String rYP7 =renovYearP7.getSelectedItem().toString();
        final String rYP8 =renovYearP8.getSelectedItem().toString();
        final String rYP9 =renovYearP9.getSelectedItem().toString();
        final String rYP10 =renovYearP10.getSelectedItem().toString();
        final String recop1 =reco1.getText().toString();
        final String recop2 =reco2.getText().toString();
        final String recop3 =reco3.getText().toString();
        final String recop4 =reco4.getText().toString();
        final String recop5 =reco5.getText().toString();
        final String recop6 =reco6.getText().toString();
        final String recop7 =reco7.getText().toString();
        final String recop8 =reco8.getText().toString();
        final String recop9 =reco9.getText().toString();
        final String recop10 =reco10.getText().toString();
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
            contact.put(ContactObject.PLOT1GPS,sgps1);
            contact.put(ContactObject.PLOT1AGE,sageP1);
            contact.put(ContactObject.PLOT1AREA,sareP1);
            contact.put(ContactObject.PLOT1COCOATREES,scteP1);
            contact.put(ContactObject.PLOT1YIELD,sestP1);
            contact.put(ContactObject.PLANTINGMATERIAL1,splantP1);
            contact.put(ContactObject.FARMCONDITION1,sfcondP1);
            contact.put(ContactObject.TREEHEALTH1,stehelP1);
            contact.put(ContactObject.DEBILITATINGDISEASE1,sdebDiP1);
            contact.put(ContactObject.PRUNING1,spruniP1);
            contact.put(ContactObject.PESTDISEASESANITATION1,spesDiP1);
            contact.put(ContactObject.WEEDING1,sweediP1);
            contact.put(ContactObject.HARVESTING1,sharveP1);
            contact.put(ContactObject.SHADEMANAGEMENT1,sshadeP1);
            contact.put(ContactObject.SOILCONDITION1,ssoilCP1);
            contact.put(ContactObject.ORGANICMATTER1,sorgMaP1);
            contact.put(ContactObject.FERTILIZERFORMULATION1,sfertFP1);
            contact.put(ContactObject.FERTILIZERAPPLICATION1,sfertAP1);
            contact.put(ContactObject.LIMENEED1,slimeNP1);
            contact.put(ContactObject.DRAINAGENEED1,sdrainP1);
            contact.put(ContactObject.FILLINGOPTION1,sfilliP1);
            contact.put(ContactObject.HIRELABOR1,shireNP1);
            contact.put(ContactObject.PH1,sph1);
            contact.put(ContactObject.GENETIC1,sgeneticP1);
            contact.put(ContactObject.GAP1,sgapP1);
            contact.put(ContactObject.SOILMNG1,ssoilFertMng1);
            contact.put(ContactObject.PLOT2GPS,sgps2);
            contact.put(ContactObject.PLOT2AGE,sageP2);
            contact.put(ContactObject.PLOT2AREA,sareP2);
            contact.put(ContactObject.PLOT2COCOATREES,scteP2);
            contact.put(ContactObject.PLOT2YIELD,sestP2);
            contact.put(ContactObject.PLANTINGMATERIAL2,splantP2);
            contact.put(ContactObject.FARMCONDITION2,sfcondP2);
            contact.put(ContactObject.TREEHEALTH2,stehelP2);
            contact.put(ContactObject.DEBILITATINGDISEASE2,sdebDiP2);
            contact.put(ContactObject.PRUNING2,spruniP2);
            contact.put(ContactObject.PESTDISEASESANITATION2,spesDiP2);
            contact.put(ContactObject.WEEDING2,sweediP2);
            contact.put(ContactObject.HARVESTING2,sharveP2);
            contact.put(ContactObject.SHADEMANAGEMENT2,sshadeP2);
            contact.put(ContactObject.SOILCONDITION2,ssoilCP2);
            contact.put(ContactObject.ORGANICMATTER2,sorgMaP2);
            contact.put(ContactObject.FERTILIZERFORMULATION2,sfertFP2);
            contact.put(ContactObject.FERTILIZERAPPLICATION2,sfertAP2);
            contact.put(ContactObject.LIMENEED2,slimeNP2);
            contact.put(ContactObject.DRAINAGENEED2,sdrainP2);
            contact.put(ContactObject.FILLINGOPTION2,sfilliP2);
            contact.put(ContactObject.HIRELABOR2,shireNP2);
            contact.put(ContactObject.PH2,sph2);
            contact.put(ContactObject.GENETIC2,sgeneticP2);
            contact.put(ContactObject.GAP2,sgapP2);
            contact.put(ContactObject.SOILMNG2,ssoilFertMng2);
            contact.put(ContactObject.PLOT3GPS,sgps3);
            contact.put(ContactObject.PLOT3AGE,sageP3);
            contact.put(ContactObject.PLOT3AREA,sareP3);
            contact.put(ContactObject.PLOT3COCOATREES,scteP3);
            contact.put(ContactObject.PLOT3YIELD,sestP3);
            contact.put(ContactObject.PLANTINGMATERIAL3,splantP3);
            contact.put(ContactObject.FARMCONDITION3,sfcondP3);
            contact.put(ContactObject.TREEHEALTH3,stehelP3);
            contact.put(ContactObject.DEBILITATINGDISEASE3,sdebDiP3);
            contact.put(ContactObject.PRUNING3,spruniP3);
            contact.put(ContactObject.PESTDISEASESANITATION3,spesDiP3);
            contact.put(ContactObject.WEEDING3,sweediP3);
            contact.put(ContactObject.HARVESTING3,sharveP3);
            contact.put(ContactObject.SHADEMANAGEMENT3,sshadeP3);
            contact.put(ContactObject.SOILCONDITION3,ssoilCP3);
            contact.put(ContactObject.ORGANICMATTER3,sorgMaP3);
            contact.put(ContactObject.FERTILIZERFORMULATION3,sfertFP3);
            contact.put(ContactObject.FERTILIZERAPPLICATION3,sfertAP3);
            contact.put(ContactObject.LIMENEED3,slimeNP3);
            contact.put(ContactObject.DRAINAGENEED3,sdrainP3);
            contact.put(ContactObject.FILLINGOPTION3,sfilliP3);
            contact.put(ContactObject.HIRELABOR3,shireNP3);
            contact.put(ContactObject.PH3,sph3);
            contact.put(ContactObject.GENETIC3,sgeneticP3);
            contact.put(ContactObject.GAP3,sgapP3);
            contact.put(ContactObject.SOILMNG3,ssoilFertMng3);
            contact.put(ContactObject.PLOT4GPS,sgps4);
            contact.put(ContactObject.PLOT4AGE,sageP4);
            contact.put(ContactObject.PLOT4AREA,sareP4);
            contact.put(ContactObject.PLOT4COCOATREES,scteP4);
            contact.put(ContactObject.PLOT4YIELD,sestP4);
            contact.put(ContactObject.PLANTINGMATERIAL4,splantP4);
            contact.put(ContactObject.FARMCONDITION4,sfcondP4);
            contact.put(ContactObject.TREEHEALTH4,stehelP4);
            contact.put(ContactObject.DEBILITATINGDISEASE4,sdebDiP4);
            contact.put(ContactObject.PRUNING4,spruniP4);
            contact.put(ContactObject.PESTDISEASESANITATION4,spesDiP4);
            contact.put(ContactObject.WEEDING4,sweediP4);
            contact.put(ContactObject.HARVESTING4,sharveP4);
            contact.put(ContactObject.SHADEMANAGEMENT4,sshadeP4);
            contact.put(ContactObject.SOILCONDITION4,ssoilCP4);
            contact.put(ContactObject.ORGANICMATTER4,sorgMaP4);
            contact.put(ContactObject.FERTILIZERFORMULATION4,sfertFP4);
            contact.put(ContactObject.FERTILIZERAPPLICATION4,sfertAP4);
            contact.put(ContactObject.LIMENEED4,slimeNP4);
            contact.put(ContactObject.DRAINAGENEED4,sdrainP4);
            contact.put(ContactObject.FILLINGOPTION4,sfilliP4);
            contact.put(ContactObject.HIRELABOR4,shireNP4);
            contact.put(ContactObject.PH4,sph4);
            contact.put(ContactObject.GENETIC4,sgeneticP4);
            contact.put(ContactObject.GAP4,sgapP4);
            contact.put(ContactObject.SOILMNG4,ssoilFertMng4);
            contact.put(ContactObject.PLOT5GPS,sgps5);
            contact.put(ContactObject.PLOT5AGE,sageP5);
            contact.put(ContactObject.PLOT5AREA,sareP5);
            contact.put(ContactObject.PLOT5COCOATREES,scteP5);
            contact.put(ContactObject.PLOT5YIELD,sestP5);
            contact.put(ContactObject.PLANTINGMATERIAL5,splantP5);
            contact.put(ContactObject.FARMCONDITION5,sfcondP5);
            contact.put(ContactObject.TREEHEALTH5,stehelP5);
            contact.put(ContactObject.DEBILITATINGDISEASE5,sdebDiP5);
            contact.put(ContactObject.PRUNING5,spruniP5);
            contact.put(ContactObject.PESTDISEASESANITATION5,spesDiP5);
            contact.put(ContactObject.WEEDING5,sweediP5);
            contact.put(ContactObject.HARVESTING5,sharveP5);
            contact.put(ContactObject.SHADEMANAGEMENT5,sshadeP5);
            contact.put(ContactObject.SOILCONDITION5,ssoilCP5);
            contact.put(ContactObject.ORGANICMATTER5,sorgMaP5);
            contact.put(ContactObject.FERTILIZERFORMULATION5,sfertFP5);
            contact.put(ContactObject.FERTILIZERAPPLICATION5,sfertAP5);
            contact.put(ContactObject.LIMENEED5,slimeNP5);
            contact.put(ContactObject.DRAINAGENEED5,sdrainP5);
            contact.put(ContactObject.FILLINGOPTION5,sfilliP5);
            contact.put(ContactObject.HIRELABOR5,shireNP5);
            contact.put(ContactObject.PH5,sph5);
            contact.put(ContactObject.GENETIC5,sgeneticP5);
            contact.put(ContactObject.GAP5,sgapP5);
            contact.put(ContactObject.SOILMNG5,ssoilFertMng5);
            contact.put(ContactObject.PLOT6GPS,sgps6);
            contact.put(ContactObject.PLOT6AGE,sageP6);
            contact.put(ContactObject.PLOT6AREA,sareP6);
            contact.put(ContactObject.PLOT6COCOATREES,scteP6);
            contact.put(ContactObject.PLOT6YIELD,sestP6);
            contact.put(ContactObject.PLANTINGMATERIAL6,splantP6);
            contact.put(ContactObject.FARMCONDITION6,sfcondP6);
            contact.put(ContactObject.TREEHEALTH6,stehelP6);
            contact.put(ContactObject.DEBILITATINGDISEASE6,sdebDiP6);
            contact.put(ContactObject.PRUNING6,spruniP6);
            contact.put(ContactObject.PESTDISEASESANITATION6,spesDiP6);
            contact.put(ContactObject.WEEDING6,sweediP6);
            contact.put(ContactObject.HARVESTING6,sharveP6);
            contact.put(ContactObject.SHADEMANAGEMENT6,sshadeP6);
            contact.put(ContactObject.SOILCONDITION6,ssoilCP6);
            contact.put(ContactObject.ORGANICMATTER6,sorgMaP6);
            contact.put(ContactObject.FERTILIZERFORMULATION6,sfertFP6);
            contact.put(ContactObject.FERTILIZERAPPLICATION6,sfertAP6);
            contact.put(ContactObject.LIMENEED6,slimeNP6);
            contact.put(ContactObject.DRAINAGENEED6,sdrainP6);
            contact.put(ContactObject.FILLINGOPTION6,sfilliP6);
            contact.put(ContactObject.HIRELABOR6,shireNP6);
            contact.put(ContactObject.PH6,sph6);
            contact.put(ContactObject.GENETIC6,sgeneticP6);
            contact.put(ContactObject.GAP6,sgapP6);
            contact.put(ContactObject.SOILMNG6,ssoilFertMng6);
            contact.put(ContactObject.PLOT7GPS,sgps7);
            contact.put(ContactObject.PLOT7AGE,sageP7);
            contact.put(ContactObject.PLOT7AREA,sareP7);
            contact.put(ContactObject.PLOT7COCOATREES,scteP7);
            contact.put(ContactObject.PLOT7YIELD,sestP7);
            contact.put(ContactObject.PLANTINGMATERIAL7,splantP7);
            contact.put(ContactObject.FARMCONDITION7,sfcondP7);
            contact.put(ContactObject.TREEHEALTH7,stehelP7);
            contact.put(ContactObject.DEBILITATINGDISEASE7,sdebDiP7);
            contact.put(ContactObject.PRUNING7,spruniP7);
            contact.put(ContactObject.PESTDISEASESANITATION7,spesDiP7);
            contact.put(ContactObject.WEEDING7,sweediP7);
            contact.put(ContactObject.HARVESTING7,sharveP7);
            contact.put(ContactObject.SHADEMANAGEMENT7,sshadeP7);
            contact.put(ContactObject.SOILCONDITION7,ssoilCP7);
            contact.put(ContactObject.ORGANICMATTER7,sorgMaP7);
            contact.put(ContactObject.FERTILIZERFORMULATION7,sfertFP7);
            contact.put(ContactObject.FERTILIZERAPPLICATION7,sfertAP7);
            contact.put(ContactObject.LIMENEED7,slimeNP7);
            contact.put(ContactObject.DRAINAGENEED7,sdrainP7);
            contact.put(ContactObject.FILLINGOPTION7,sfilliP7);
            contact.put(ContactObject.HIRELABOR7,shireNP7);
            contact.put(ContactObject.PH7,sph7);
            contact.put(ContactObject.GENETIC7,sgeneticP7);
            contact.put(ContactObject.GAP7,sgapP7);
            contact.put(ContactObject.SOILMNG7,ssoilFertMng7);
            contact.put(ContactObject.PLOT8GPS,sgps8);
            contact.put(ContactObject.PLOT8AGE,sageP8);
            contact.put(ContactObject.PLOT8AREA,sareP8);
            contact.put(ContactObject.PLOT8COCOATREES,scteP8);
            contact.put(ContactObject.PLOT8YIELD,sestP8);
            contact.put(ContactObject.PLANTINGMATERIAL8,splantP8);
            contact.put(ContactObject.FARMCONDITION8,sfcondP8);
            contact.put(ContactObject.TREEHEALTH8,stehelP8);
            contact.put(ContactObject.DEBILITATINGDISEASE8,sdebDiP8);
            contact.put(ContactObject.PRUNING8,spruniP8);
            contact.put(ContactObject.PESTDISEASESANITATION8,spesDiP8);
            contact.put(ContactObject.WEEDING8,sweediP8);
            contact.put(ContactObject.HARVESTING8,sharveP8);
            contact.put(ContactObject.SHADEMANAGEMENT8,sshadeP8);
            contact.put(ContactObject.SOILCONDITION8,ssoilCP8);
            contact.put(ContactObject.ORGANICMATTER8,sorgMaP8);
            contact.put(ContactObject.FERTILIZERFORMULATION8,sfertFP8);
            contact.put(ContactObject.FERTILIZERAPPLICATION8,sfertAP8);
            contact.put(ContactObject.LIMENEED8,slimeNP8);
            contact.put(ContactObject.DRAINAGENEED8,sdrainP8);
            contact.put(ContactObject.FILLINGOPTION8,sfilliP8);
            contact.put(ContactObject.HIRELABOR8,shireNP8);
            contact.put(ContactObject.PH8,sph8);
            contact.put(ContactObject.GENETIC8,sgeneticP8);
            contact.put(ContactObject.GAP8,sgapP8);
            contact.put(ContactObject.SOILMNG8,ssoilFertMng8);
            contact.put(ContactObject.PLOT9GPS,sgps9);
            contact.put(ContactObject.PLOT9AGE,sageP9);
            contact.put(ContactObject.PLOT9AREA,sareP9);
            contact.put(ContactObject.PLOT9COCOATREES,scteP9);
            contact.put(ContactObject.PLOT9YIELD,sestP9);
            contact.put(ContactObject.PLANTINGMATERIAL9,splantP9);
            contact.put(ContactObject.FARMCONDITION9,sfcondP9);
            contact.put(ContactObject.TREEHEALTH9,stehelP9);
            contact.put(ContactObject.DEBILITATINGDISEASE9,sdebDiP9);
            contact.put(ContactObject.PRUNING9,spruniP9);
            contact.put(ContactObject.PESTDISEASESANITATION9,spesDiP9);
            contact.put(ContactObject.WEEDING9,sweediP9);
            contact.put(ContactObject.HARVESTING9,sharveP9);
            contact.put(ContactObject.SHADEMANAGEMENT9,sshadeP9);
            contact.put(ContactObject.SOILCONDITION9,ssoilCP9);
            contact.put(ContactObject.ORGANICMATTER9,sorgMaP9);
            contact.put(ContactObject.FERTILIZERFORMULATION9,sfertFP9);
            contact.put(ContactObject.FERTILIZERAPPLICATION9,sfertAP9);
            contact.put(ContactObject.LIMENEED9,slimeNP9);
            contact.put(ContactObject.DRAINAGENEED9,sdrainP9);
            contact.put(ContactObject.FILLINGOPTION9,sfilliP9);
            contact.put(ContactObject.HIRELABOR9,shireNP9);
            contact.put(ContactObject.PH9,sph9);
            contact.put(ContactObject.GENETIC9,sgeneticP9);
            contact.put(ContactObject.GAP9,sgapP9);
            contact.put(ContactObject.SOILMNG9,ssoilFertMng9);
            contact.put(ContactObject.PLOT10GPS,sgps10);
            contact.put(ContactObject.PLOT10AGE,sageP10);
            contact.put(ContactObject.PLOT10AREA,sareP10);
            contact.put(ContactObject.PLOT10COCOATREES,scteP10);
            contact.put(ContactObject.PLOT10YIELD,sestP10);
            contact.put(ContactObject.PLANTINGMATERIAL10,splantP10);
            contact.put(ContactObject.FARMCONDITION10,sfcondP10);
            contact.put(ContactObject.TREEHEALTH10,stehelP10);
            contact.put(ContactObject.DEBILITATINGDISEASE10,sdebDiP10);
            contact.put(ContactObject.PRUNING10,spruniP10);
            contact.put(ContactObject.PESTDISEASESANITATION10,spesDiP10);
            contact.put(ContactObject.WEEDING10,sweediP10);
            contact.put(ContactObject.HARVESTING10,sharveP10);
            contact.put(ContactObject.SHADEMANAGEMENT10,sshadeP10);
            contact.put(ContactObject.SOILCONDITION10,ssoilCP10);
            contact.put(ContactObject.ORGANICMATTER10,sorgMaP10);
            contact.put(ContactObject.FERTILIZERFORMULATION10,sfertFP10);
            contact.put(ContactObject.FERTILIZERAPPLICATION10,sfertAP10);
            contact.put(ContactObject.LIMENEED10,slimeNP10);
            contact.put(ContactObject.DRAINAGENEED10,sdrainP10);
            contact.put(ContactObject.FILLINGOPTION10,sfilliP10);
            contact.put(ContactObject.HIRELABOR10,shireNP10);
            contact.put(ContactObject.PH10,sph10);
            contact.put(ContactObject.GENETIC10,sgeneticP10);
            contact.put(ContactObject.GAP10,sgapP10);
            contact.put(ContactObject.SOILMNG10,ssoilFertMng10);
            contact.put(ContactObject.PLOT1RENOVATION,rP1);
            contact.put(ContactObject.PLOT2RENOVATION,rP2);
            contact.put(ContactObject.PLOT3RENOVATION,rP3);
            contact.put(ContactObject.PLOT4RENOVATION,rP4);
            contact.put(ContactObject.PLOT5RENOVATION,rP5);
            contact.put(ContactObject.PLOT6RENOVATION,rP6);
            contact.put(ContactObject.PLOT7RENOVATION,rP7);
            contact.put(ContactObject.PLOT8RENOVATION,rP8);
            contact.put(ContactObject.PLOT9RENOVATION,rP9);
            contact.put(ContactObject.PLOT10RENOVATION,rP10);
            contact.put(ContactObject.PLOT1RENOVATIONREASON,rRP1);
            contact.put(ContactObject.PLOT2RENOVATIONREASON,rRP2);
            contact.put(ContactObject.PLOT3RENOVATIONREASON,rRP3);
            contact.put(ContactObject.PLOT4RENOVATIONREASON,rRP4);
            contact.put(ContactObject.PLOT5RENOVATIONREASON,rRP5);
            contact.put(ContactObject.PLOT6RENOVATIONREASON,rRP6);
            contact.put(ContactObject.PLOT7RENOVATIONREASON,rRP7);
            contact.put(ContactObject.PLOT8RENOVATIONREASON,rRP8);
            contact.put(ContactObject.PLOT9RENOVATIONREASON,rRP9);
            contact.put(ContactObject.PLOT10RENOVATIONREASON,rRP10);
            contact.put(ContactObject.PLOT1RENOVATIONYEAR,rYP1);
            contact.put(ContactObject.PLOT2RENOVATIONYEAR,rYP2);
            contact.put(ContactObject.PLOT3RENOVATIONYEAR,rYP3);
            contact.put(ContactObject.PLOT4RENOVATIONYEAR,rYP4);
            contact.put(ContactObject.PLOT5RENOVATIONYEAR,rYP5);
            contact.put(ContactObject.PLOT6RENOVATIONYEAR,rYP6);
            contact.put(ContactObject.PLOT7RENOVATIONYEAR,rYP7);
            contact.put(ContactObject.PLOT8RENOVATIONYEAR,rYP8);
            contact.put(ContactObject.PLOT9RENOVATIONYEAR,rYP9);
            contact.put(ContactObject.PLOT10RENOVATIONYEAR,rYP10);
            contact.put(ContactObject.RECO1,recop1);
            contact.put(ContactObject.RECO2,recop2);
            contact.put(ContactObject.RECO3,recop3);
            contact.put(ContactObject.RECO4,recop4);
            contact.put(ContactObject.RECO5,recop5);
            contact.put(ContactObject.RECO6,recop6);
            contact.put(ContactObject.RECO7,recop7);
            contact.put(ContactObject.RECO8,recop8);
            contact.put(ContactObject.RECO9,recop9);
            contact.put(ContactObject.RECO10,recop10);
            contact.put(SyncManager.LOCAL, true);
            contact.put(SyncManager.LOCALLY_UPDATED, !isCreate);
            contact.put(SyncManager.LOCALLY_CREATED, isCreate);
            contact.put(SyncManager.LOCALLY_DELETED, false);
            if (isCreate) {
                smartStore.create(ContactListLoader.CONTACT_SOUP, contact);
            } else {
                smartStore.upsert(ContactListLoader.CONTACT_SOUP, contact);
            }
            Toast.makeText(this, "Partially Saved!", Toast.LENGTH_LONG).show();
        } catch (JSONException e) {
            Log.e(TAG, "JSONException occurred while parsing", e);
        }
    }
}
