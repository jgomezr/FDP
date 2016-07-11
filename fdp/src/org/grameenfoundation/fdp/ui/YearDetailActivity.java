package org.grameenfoundation.fdp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.salesforce.androidsdk.rest.RestClient;
import com.salesforce.androidsdk.ui.SalesforceActivity;

import org.grameenfoundation.fdp.R;

/**
 * Created by julian_Gf on 7/8/2016.
 */
public class YearDetailActivity extends SalesforceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yeardetail);
    }

    @Override
    public void onResume(RestClient client) {

    }

    public void onBackClicked(View view) {
        Intent i = new Intent(this, fdpActivity.class );
        startActivity(i);
    }
}
