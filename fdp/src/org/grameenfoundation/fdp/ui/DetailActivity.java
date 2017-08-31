package org.grameenfoundation.fdp.ui;

import android.Manifest;
import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.content.pm.PackageManager;
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
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
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

import java.lang.ref.WeakReference;
import java.text.DecimalFormat;

/**
 * Object detail activity.
 *
 * @author jgomez
 */
public class DetailActivity extends SalesforceActivity implements LoaderManager.LoaderCallbacks<ContactObject> {

	private static final int CONTACT_DETAIL_LOADER_ID = 2;
	private static final String TAG = "SmartSyncExplorer: DetailActivity";
	private Button button;
	private EditText textView,avgCocoaPrice, prdCocoaLy,numbChildrens,fcode,spousename,incomelabor,spouseincome,livinexp,familyIncome,incomeOtherCrops,totalCrd,payCredit,loanAmmount,moneyBack,hhSaving,otherExpenses,planedInvest,eduExpenses,expensesCCLY,grossCC,tOS,tL,tC,tR,childreSchool,childrenUnder,familyMemb;
    private TextView tHelp1, t1,tHelp2,t2,tHelp3,t3,tHelp4,t4,tHelp5,t5,tHelp6,t6;
	private Spinner spouseP,familyP,farmP,credit,loan,aditionalC,haveSpouse,bank;
	private LinearLayout actType,mbMoney,wntAct,farmLY,spouseLY,familyLY,creditLY,loanLY,amountLY,aditionalLY,under17,under17School,spouseName,spouseBirthday,spouseEdLvl,spousePaidWork,totalCredit,OftenPay,sourceLoan,addCrop;
	private LocationManager locationManager;
	private LocationListener locationListener;
	private UserAccount curAccount;
	private String objectId;
	private String objectTitle;
	private String objNameKey;
	private ContactObject sObject;
	public static final String OBJECT_ID_KEY = "object_id";
	public static final String OBJECT_TITLE_KEY = "object_title";
	public static final String OBJECT_NAME_KEY = "object_name";
    public static final String PHOTO_NAME = "photo_Name";
	String mCurrentPhotoPath;
    static final int REQUEST_TAKE_PHOTO = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail);
		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setIcon(R.drawable.ic_action_back);
		final Intent launchIntent = getIntent();
		if (launchIntent != null) {
			objectId = launchIntent.getStringExtra(MainActivity.OBJECT_ID_KEY);
			objectTitle = launchIntent.getStringExtra(MainActivity.OBJECT_TITLE_KEY);
			objNameKey = launchIntent.getStringExtra(MainActivity.OBJECT_NAME_KEY);
			getActionBar().setTitle(launchIntent.getStringExtra(MainActivity.OBJECT_NAME_KEY));
			getActionBar().setSubtitle(objectTitle);
		}


        tOS = (EditText) findViewById(R.id.farmArea_field);
        tL = (EditText) findViewById(R.id.cultivationArea_field);
        tC = (EditText) findViewById(R.id.cocoaArea_field);
        tR = (EditText) findViewById(R.id.renovationArea_field);
        tL.addTextChangedListener(new DetailActivity.areaWatcher(tL));
        tC.addTextChangedListener(new DetailActivity.areaWatcher(tC));
        tR.addTextChangedListener(new DetailActivity.areaWatcher(tR));
        childreSchool = (EditText) findViewById(R.id.childrenInSchool);
        childrenUnder = (EditText) findViewById(R.id.childrenUnder);
        childrenUnder.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                double qc;
                double qcu;
                double qcs;

                if(numbChildrens.getText().toString().isEmpty()||childrenUnder.getText().toString().isEmpty()){
                    qc=0;
                    qcu=0;

                }else{
                    qc = Double.parseDouble(numbChildrens.getText().toString());
                    qcu= Double.parseDouble(childrenUnder.getText().toString());

                }
                if (qcu > qc ) {
                    childrenUnder.setError(getString(R.string.childrenVal));
                }

            }
        });
        childreSchool.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                double qc;
                double qcu;
                double qcs;

                if(childreSchool.getText().toString().isEmpty()||childrenUnder.getText().toString().isEmpty()){
                    qc=0;
                    qcu=0;

                }else{
                    qc = Double.parseDouble(childreSchool.getText().toString());
                    qcu= Double.parseDouble(childrenUnder.getText().toString());
                }
                if (qc>qcu) {
                    childreSchool.setError(getString(R.string.childrenVal));
                }
            }
        });
        familyMemb = (EditText) findViewById(R.id.familyMembers);
		button = (Button) findViewById(R.id.gpsbutton);
		textView = (EditText) findViewById(R.id.gps_field);
		locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
		locationListener = new LocationListener() {
			@Override
			public void onLocationChanged(Location location) {
				setText( textView,location.convert(location.getLatitude(), Location.FORMAT_MINUTES) + "/" + location.convert(location.getLongitude(), Location.FORMAT_MINUTES));
                onStop();
            }

			@Override
			public void onStatusChanged(String provider, int status, Bundle extras) {
			}

			@Override
			public void onProviderEnabled(String provider) {
			}

			@Override
			public void onProviderDisabled(String provider) {
				Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
				startActivity(intent);
			}

			public void onStop() {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        requestPermissions(new String[]{
                                Manifest.permission.ACCESS_FINE_LOCATION,
                                Manifest.permission.ACCESS_COARSE_LOCATION,
                                Manifest.permission.INTERNET
                        }, 10);
                        return;
                    }
                }
                locationManager.removeUpdates(locationListener);
			}
		};

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
				requestPermissions(new String[]{
						Manifest.permission.ACCESS_FINE_LOCATION,
						Manifest.permission.ACCESS_COARSE_LOCATION,
						Manifest.permission.INTERNET
				}, 10);
				return;
			}
		} else {
			configureButton();
		}
        bank = (Spinner)findViewById(R.id.bankAccount_field);
        actType = (LinearLayout)findViewById(R.id.bnkType);
        mbMoney = (LinearLayout)findViewById(R.id.mbMoney);
        wntAct = (LinearLayout)findViewById(R.id.wtAccount);
        bank.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (bank.getSelectedItem().toString().equals("Yes")||bank.getSelectedItem().toString().equals("Ya")){
                    actType.setVisibility(View.VISIBLE);
                    mbMoney.setVisibility(View.VISIBLE);
                    wntAct.setVisibility(View.GONE);

                }else if (bank.getSelectedItem().toString().equals("No")||bank.getSelectedItem().toString().equals("Tidak")){
                    actType.setVisibility(View.GONE);
                    mbMoney.setVisibility(View.GONE);
                    wntAct.setVisibility(View.VISIBLE);
                }else{
                    actType.setVisibility(View.GONE);
                    mbMoney.setVisibility(View.GONE);
                    wntAct.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

		avgCocoaPrice = (EditText) findViewById(R.id.averageCocoaPrice_Field);
		prdCocoaLy = (EditText) findViewById(R.id.productionCocoaLY_Field);
		numbChildrens = (EditText) findViewById(R.id.numChildren);

		avgCocoaPrice.setOnFocusChangeListener(new View.OnFocusChangeListener() {
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if(!hasFocus){
                        savePoint();
                    double avg = Double.parseDouble(avgCocoaPrice.getText().toString().replaceAll("[^0-9.]+", ""));
                    double prd = 0;
                    try{
                        prd = Double.parseDouble(prdCocoaLy.getText().toString().replaceAll("[^0-9.]+", ""));
                    }catch (NumberFormatException e){}
                    int result1 = (int) (avg * prd);
                    Log.d(TAG, "resultado: "+result1);
                    setText((EditText) findViewById(R.id.grossCocoaLY_Field),String.valueOf(result1));

				}

			}
		});

        spousename =(EditText) findViewById(R.id.spouseName);
        spousename.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    savePoint();
                }
            }
        });

        incomelabor =(EditText) findViewById(R.id.totalIncomeLabor_Field);
        incomelabor.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    savePoint();
                }
            }
        });

        spouseincome =(EditText) findViewById(R.id.totalSpouseIncome_Field);
        spouseincome.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    savePoint();
                }
            }
        });

        livinexp =(EditText) findViewById(R.id.livingExpenses_Field);
        livinexp.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    savePoint();
                }
            }
        });
        tC.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    savePoint();
                }
            }
        });

		prdCocoaLy.setOnFocusChangeListener(new View.OnFocusChangeListener() {
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if(!hasFocus){
                    savePoint();
                    double avg = Double.parseDouble(avgCocoaPrice.getText().toString().replaceAll("[^0-9.]+", ""));
                    double prd = 0;
                    try{
                        prd = Double.parseDouble(prdCocoaLy.getText().toString().replaceAll("[^0-9.]+", ""));
                    }catch (NumberFormatException e){}
                    int result1 = (int) (avg * prd);
                    Log.d(TAG, "resultado: "+result1);
					setText((EditText) findViewById(R.id.grossCocoaLY_Field),String.valueOf(result1));
				}
			}
		});


		under17 = (LinearLayout) findViewById(R.id.under17);
		under17School = (LinearLayout)findViewById(R.id.under17School);
		numbChildrens.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
				under17.setVisibility(View.GONE);
				under17School.setVisibility(View.GONE);
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (String.valueOf(numbChildrens.getText()).isEmpty()){
                    under17.setVisibility(View.GONE);
                    under17School.setVisibility(View.GONE);
                }else if (Integer.valueOf(String.valueOf(numbChildrens.getText()))>0){
					under17.setVisibility(View.VISIBLE);
					under17School.setVisibility(View.VISIBLE);
				}else{

                }
			}

			@Override
			public void afterTextChanged(Editable s) {
                savePoint();
			}
		});

        haveSpouse = (Spinner) findViewById(R.id.haveSpouse);
        spouseName = (LinearLayout) findViewById(R.id.spName);
        spouseBirthday = (LinearLayout) findViewById(R.id.spBday);
        spouseEdLvl = (LinearLayout) findViewById(R.id.spEdlvl);
        spousePaidWork = (LinearLayout) findViewById(R.id.spPaidWk);
        haveSpouse.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //savePoint();
                if (haveSpouse.getSelectedItem().toString().equals("Yes")||haveSpouse.getSelectedItem().toString().equals("Ya")){
                    spouseName.setVisibility(View.VISIBLE);
                    spouseBirthday.setVisibility(View.VISIBLE);
                    spouseEdLvl.setVisibility(View.VISIBLE);
                    spousePaidWork.setVisibility(View.VISIBLE);
                }else{
                    spouseName.setVisibility(View.GONE);
                    spouseBirthday.setVisibility(View.GONE);
                    spouseEdLvl.setVisibility(View.GONE);
                    spousePaidWork.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


		farmP = (Spinner) findViewById(R.id.receivesFarmPayment_Field);
		farmLY = (LinearLayout) findViewById(R.id.farmLabor_Layout);
		farmP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //savePoint();
				if (farmP.getSelectedItem().toString().equals("Yes")||farmP.getSelectedItem().toString().equals("Ya")){
					farmLY.setVisibility(View.VISIBLE);
				}else{
					farmLY.setVisibility(View.GONE);
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {

			}
		});

		spouseP = (Spinner) findViewById(R.id.spousePaidWork_Field);
		spouseLY = (LinearLayout) findViewById(R.id.spouseIncome_Layout);
		spouseP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				if (spouseP.getSelectedItem().toString().equals("Yes")||spouseP.getSelectedItem().toString().equals("Ya")){
					spouseLY.setVisibility(View.VISIBLE);
				}else{
					spouseLY.setVisibility(View.GONE);
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {

			}
		});

		familyP = (Spinner) findViewById(R.id.familyPaidWork_Field);
		familyLY = (LinearLayout) findViewById(R.id.familyIncome_Layout);
		familyP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				if (familyP.getSelectedItem().toString().equals("Yes")||familyP.getSelectedItem().toString().equals("Ya")){
					familyLY.setVisibility(View.VISIBLE);
				}else{
					familyLY.setVisibility(View.GONE);
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {

			}
		});

		aditionalC = (Spinner)findViewById(R.id.haveOtherCrops_Field);
		aditionalLY = (LinearLayout) findViewById(R.id.otherCrops_Layout);
        addCrop = (LinearLayout) findViewById(R.id.aditionalCrops_Layout);
		aditionalC.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				if (aditionalC.getSelectedItem().toString().equals("Yes")||aditionalC.getSelectedItem().toString().equals("Ya")){
					aditionalLY.setVisibility(View.VISIBLE);
                    addCrop.setVisibility(View.VISIBLE);
				}else{
					aditionalLY.setVisibility(View.GONE);
                    addCrop.setVisibility(View.GONE);
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {

			}
		});

		credit = (Spinner)findViewById(R.id.haveCredit_Field);
		creditLY = (LinearLayout) findViewById(R.id.payCredit_Layout);
        totalCredit = (LinearLayout) findViewById(R.id.totalCredit_Layout);
        OftenPay = (LinearLayout)findViewById(R.id.payOften_Layout);
        sourceLoan = (LinearLayout) findViewById(R.id.sourceLoan_Layout);
		credit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				if (credit.getSelectedItem().toString().equals("Yes")||credit.getSelectedItem().toString().equals("Ya")){
					creditLY.setVisibility(View.VISIBLE);
                    totalCredit.setVisibility(View.VISIBLE);
                    OftenPay.setVisibility(View.VISIBLE);
                    sourceLoan.setVisibility(View.VISIBLE);

				}else{
					creditLY.setVisibility(View.GONE);
                    totalCredit.setVisibility(View.GONE);
                    OftenPay.setVisibility(View.GONE);
                    sourceLoan.setVisibility(View.GONE);
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {

			}
		});

		loan = (Spinner)findViewById(R.id.giveLoan_Field);
		loanLY = (LinearLayout) findViewById(R.id.amountLoan_Layout);
		amountLY = (LinearLayout) findViewById(R.id.moneyBack_Layout);
		loan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //savePoint();
				if (loan.getSelectedItem().toString().equals("Yes")||loan.getSelectedItem().toString().equals("Ya")){
					loanLY.setVisibility(View.VISIBLE);
					amountLY.setVisibility(View.VISIBLE);
				}else{
					loanLY.setVisibility(View.GONE);
					amountLY.setVisibility(View.GONE);
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {

			}
		});

        tHelp1 = (TextView) findViewById(R.id.tooltipHelp1);
        t1= (TextView)findViewById(R.id.tooltip1);
        tHelp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setVisibility(View.VISIBLE);
            }
        });

        tHelp2 = (TextView) findViewById(R.id.tooltipHelp2);
        t2= (TextView)findViewById(R.id.tooltip2);
        tHelp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t2.setVisibility(View.VISIBLE);
            }
        });

        tHelp3 = (TextView) findViewById(R.id.tooltipHelp3);
        t3= (TextView)findViewById(R.id.tooltip3);
        tHelp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t3.setVisibility(View.VISIBLE);
            }
        });

        tHelp4 = (TextView) findViewById(R.id.tooltipHelp4);
        t4= (TextView)findViewById(R.id.tooltip4);
        tHelp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t4.setVisibility(View.VISIBLE);
            }
        });

        tHelp5 = (TextView) findViewById(R.id.tooltipHelp5);
        t5= (TextView)findViewById(R.id.tooltip5);
        tHelp5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t5.setVisibility(View.VISIBLE);
            }
        });

        tHelp6 = (TextView) findViewById(R.id.tooltipHelp6);
        t6= (TextView)findViewById(R.id.tooltip6);
        tHelp6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t6.setVisibility(View.VISIBLE);
            }
        });


		familyIncome =(EditText) findViewById(R.id.totalFamilyMembersIncome_Field);
		incomeOtherCrops=(EditText) findViewById(R.id.incomeOtherCrops_Field);
		totalCrd=(EditText) findViewById(R.id.totalCredit_Field);
		payCredit=(EditText) findViewById(R.id.payForCredit_Field);
		loanAmmount=(EditText) findViewById(R.id.amountOfLoan_Field);
		moneyBack=(EditText) findViewById(R.id.moneyBack_Field);
		hhSaving=(EditText) findViewById(R.id.householdSavings_Field);
		otherExpenses=(EditText) findViewById(R.id.otherExpenses_Field);
		planedInvest=(EditText) findViewById(R.id.plannedInvestments_Field);
		eduExpenses=(EditText) findViewById(R.id.educationExpenses_Field);
		expensesCCLY=(EditText) findViewById(R.id.expensesCocoaLY_Field);
		grossCC=(EditText) findViewById(R.id.grossCocoaLY_Field);

		incomelabor.addTextChangedListener(new MoneyTextWatcher(incomelabor));
		spouseincome.addTextChangedListener(new MoneyTextWatcher(spouseincome));
		livinexp.addTextChangedListener(new MoneyTextWatcher(livinexp));
		familyIncome.addTextChangedListener(new MoneyTextWatcher(familyIncome));
		incomeOtherCrops.addTextChangedListener(new MoneyTextWatcher(incomeOtherCrops));
		totalCrd.addTextChangedListener(new MoneyTextWatcher(totalCrd));
		payCredit.addTextChangedListener(new MoneyTextWatcher(payCredit));
		loanAmmount.addTextChangedListener(new MoneyTextWatcher(loanAmmount));
		moneyBack.addTextChangedListener(new MoneyTextWatcher(moneyBack));
		hhSaving.addTextChangedListener(new MoneyTextWatcher(hhSaving));
		otherExpenses.addTextChangedListener(new MoneyTextWatcher(otherExpenses));
		planedInvest.addTextChangedListener(new MoneyTextWatcher(planedInvest));
		eduExpenses.addTextChangedListener(new MoneyTextWatcher(eduExpenses));
		expensesCCLY.addTextChangedListener(new MoneyTextWatcher(expensesCCLY));
		grossCC.addTextChangedListener(new MoneyTextWatcher(grossCC));
		avgCocoaPrice.addTextChangedListener(new MoneyTextWatcher(avgCocoaPrice));
        prdCocoaLy.addTextChangedListener(new QuantityWatcher(prdCocoaLy));

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
            double toa;
            double tl;
            double tc;
            double tr;

            if(tOS.getText().toString().isEmpty()||tL.getText().toString().isEmpty()||tC.getText().toString().isEmpty()||tR.getText().toString().isEmpty()){
                toa=0;
                tl=0;
                tc=0;
                tr=0;
            }else{
                if(tOS.getText().toString().startsWith(".")){
                    toa=Double.parseDouble(0+tOS.getText().toString());
                }else{
                    toa=Double.parseDouble(tOS.getText().toString());
                }

                if(tL.getText().toString().startsWith(".")){
                    tl= Double.parseDouble(0+tL.getText().toString());
                }else{
                    tl= Double.parseDouble(tL.getText().toString());
                }

                if(tC.getText().toString().startsWith(".")){
                    tc= Double.parseDouble(0+tC.getText().toString());
                }else{
                    tc= Double.parseDouble(tC.getText().toString());
                }

                if(tR.getText().toString().startsWith(".")){
                    tr= Double.parseDouble(0+tR.getText().toString());
                }else{
                    tr= Double.parseDouble(tR.getText().toString());
                }

            }
            if (tl>toa) {
                editText.setError( getString(R.string.areaHiger) );
            }

            if (tc>tl) {
                editText.setError( getString(R.string.areaHiger) );
            }

            if(tr>tc){
                editText.setError( getString(R.string.renovationHigh) );
            }

        }
    }


    public class familyWatcher implements TextWatcher {
        private final WeakReference<EditText> editTextWeakReference;

        public familyWatcher(EditText editText) {
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
            //savePoint();
            EditText editText = editTextWeakReference.get();
            double qc;
            double fm;

            if(numbChildrens.getText().toString().isEmpty()||familyMemb.getText().toString().isEmpty()){
                qc=0;
                fm=0;
            }else{
                qc=Double.parseDouble(numbChildrens.getText().toString());
                fm= Double.parseDouble(familyMemb.getText().toString());
            }
            if ((qc+1)<fm ||(qc+1)==fm) {

            }else{
                editText.setError( getString(R.string.familyLess) );
            }
        }
    }

	public class MoneyTextWatcher implements TextWatcher {
		private final WeakReference<EditText> editTextWeakReference;

		public MoneyTextWatcher(EditText editText) {
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
			if (editText != null) {
                String s = editable.toString();
                editText.removeTextChangedListener(this);
                DecimalFormat dec = new DecimalFormat("IDR ###,###,###");
                String cleanString = s.replaceAll("[^0-9]+", "");
                double parsed = 0;
                try{
                    parsed = Double.parseDouble(cleanString);
                }catch (NumberFormatException e){
                    e.printStackTrace();
                }

                String formatted = dec.format(parsed);
                editText.setText(formatted);
                editText.setSelection(formatted.length());
                editText.addTextChangedListener(this);
            }

		}
	}

    public class QuantityWatcher implements TextWatcher {
        private final WeakReference<EditText> editTextWeakReference;

        public QuantityWatcher(EditText editText) {
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
            if (editText != null) {
                String s = editable.toString();
                editText.removeTextChangedListener(this);
                DecimalFormat dec = new DecimalFormat("###,###,###");
                String cleanString = s.replaceAll("[^0-9]+", "");
                double parsed = 0;
                try{
                    parsed = Double.parseDouble(cleanString);
                }catch (NumberFormatException e){
                    e.printStackTrace();
                }

                String formatted = dec.format(parsed);
                editText.setText(formatted);
                editText.setSelection(formatted.length());
                editText.addTextChangedListener(this);
            }

        }
    }


    public void dispatchTakePictureIntent(View view) {
        save();
        String photoFile = "null";
        switch (view.getId()) {
            case R.id.familyPhoto:
                photoFile = "family";
                break;
            case R.id.mapPhoto:
                photoFile = "farm";
                break;
        }

        final Intent photoIntent = new Intent(this, photoActivity.class);
        photoIntent.addCategory(Intent.CATEGORY_DEFAULT);
        photoIntent.putExtra(OBJECT_ID_KEY, sObject.getObjectId());
        photoIntent.putExtra(OBJECT_TITLE_KEY, sObject.getName());
        photoIntent.putExtra(OBJECT_NAME_KEY, sObject.getEmail());
        photoIntent.putExtra(PHOTO_NAME, photoFile);
        startActivity(photoIntent);

    }


	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		switch (requestCode) {
			case 10:
				if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
					configureButton();
				return;
		}
	}

	private void configureButton() {
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
                savePoint();
				if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
					if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
						requestPermissions(new String[]{
								Manifest.permission.ACCESS_FINE_LOCATION,
								Manifest.permission.ACCESS_COARSE_LOCATION,
								Manifest.permission.INTERNET
						}, 10);
						return;
					}
				}
				locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 500, 0, locationListener);
			}
		});
	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		// Save variables on screen orientation change. Save the user's current game state
		savedInstanceState.putString(OBJECT_ID_KEY, objectId);
		savedInstanceState.putString(OBJECT_TITLE_KEY, objectTitle);
		savedInstanceState.putString(OBJECT_NAME_KEY, objNameKey);

		// Always call the superclass so it can save the view hierarchy state
		super.onSaveInstanceState(savedInstanceState);
	}

	public void onRestoreInstanceState(Bundle savedInstanceState) {
		// Always call the superclass so it can restore the view hierarchy
		super.onRestoreInstanceState(savedInstanceState);

		// Restore variables on screen orientation change. Restore state members from saved instance
		objectId = savedInstanceState.getString(OBJECT_ID_KEY);
		objectTitle = savedInstanceState.getString(OBJECT_TITLE_KEY);
		objNameKey = savedInstanceState.getString(OBJECT_NAME_KEY);
	}

	@Override
	public void onResume(RestClient client) {
		curAccount = SmartSyncSDKManager.getInstance().getUserAccountManager().getCurrentUser();
		getLoaderManager().initLoader(CONTACT_DETAIL_LOADER_ID, null, this).forceLoad();
	}

	@Override
	public void onDestroy() {
		getLoaderManager().destroyLoader(CONTACT_DETAIL_LOADER_ID);
		super.onDestroy();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
		final MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.action_bar_menu, menu);
		final MenuItem searchItem = menu.findItem(R.id.action_search);
		searchItem.setVisible(false);
		final MenuItem addItem = menu.findItem(R.id.action_add);
		addItem.setVisible(false);
		final MenuItem refreshItem = menu.findItem(R.id.action_refresh);
        refreshItem.setVisible(false);
        final MenuItem internal = menu.findItem(R.id.internal_Inspection);
        internal.setVisible(false);
        final MenuItem changeUser = menu.findItem(R.id.action_switch_user);
        changeUser.setVisible(false);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
        final String firstName = ((EditText) findViewById(R.id.full_name_field)).getText().toString();
        final String title = ((EditText) findViewById(R.id.farmer_code_field)).getText().toString();
        switch (item.getItemId()) {
			case android.R.id.home:
				finish();
				overridePendingTransition(R.anim.slide_in_from_left, R.anim.slide_out_to_right);
				return true;
			case R.id.action_refresh:
                if (TextUtils.isEmpty(firstName) || TextUtils.isEmpty(title)) {
                    Toast.makeText(this, this.getString(R.string.cannotBeEmpty), Toast.LENGTH_LONG).show();
                }else{
				save();
				return true;
                }
			default:
				return super.onOptionsItemSelected(item);
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

	private void refreshScreen() {
		if (sObject != null) {
			setText((EditText) findViewById(R.id.full_name_field),
					sObject.getFirstName());
			setText((EditText) findViewById(R.id.farmer_code_field),
					sObject.getTitle());
			setText((EditText) findViewById(R.id.birthday_field),
					sObject.getBirthday());
			//Set gender field
			if (sObject.getGender().contentEquals("Male")||sObject.getGender().contentEquals("Pria")) {
				Spinner spinner = (Spinner) findViewById(R.id.gender_Field);
				ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
						R.array.gender_male, android.R.layout.simple_spinner_item);
				adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinner.setAdapter(adapter);
			} else if (sObject.getGender().contentEquals("Female")||sObject.getGender().contentEquals("Wanita")) {
				Spinner spinner = (Spinner) findViewById(R.id.gender_Field);
				ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
						R.array.gender_female, android.R.layout.simple_spinner_item);
				adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinner.setAdapter(adapter);
			} else {
				Spinner spinner = (Spinner) findViewById(R.id.gender_Field);
				// Create an ArrayAdapter using the string array and a default spinner layout
				ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
						R.array.gender, android.R.layout.simple_spinner_item);
				// Specify the layout to use when the list of choices appears
				adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				// Apply the adapter to the spinner
				spinner.setAdapter(adapter);
			}
			//set Educational Level field
			if (sObject.getEducationallevel().contentEquals("Sekolah Dasar - SD")) {
				Spinner spinner = (Spinner) findViewById(R.id.educational_lv_field);
				ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
						R.array.education_SD, android.R.layout.simple_spinner_item);
				adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinner.setAdapter(adapter);
			} else if (sObject.getEducationallevel().contentEquals("Sekolah Menengah Pertama - SMP")) {
				Spinner spinner = (Spinner) findViewById(R.id.educational_lv_field);
				ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
						R.array.education_SMP, android.R.layout.simple_spinner_item);
				adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinner.setAdapter(adapter);
			} else if (sObject.getEducationallevel().contentEquals("Sekolah Menengah Atas - SMA")) {
				Spinner spinner = (Spinner) findViewById(R.id.educational_lv_field);
				ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
						R.array.education_SMA, android.R.layout.simple_spinner_item);
				adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinner.setAdapter(adapter);
			} else if (sObject.getEducationallevel().contentEquals("Sekolah Menengah Kejuaruan - SMK")) {
                Spinner spinner = (Spinner) findViewById(R.id.educational_lv_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.education_SMK, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getEducationallevel().contentEquals("Madrasah Tsanawiyah - MTS")) {
                Spinner spinner = (Spinner) findViewById(R.id.educational_lv_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.education_MTS, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getEducationallevel().contentEquals("Madrasah Aliyah Kejuruan - MAK")) {
				Spinner spinner = (Spinner) findViewById(R.id.educational_lv_field);
				ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
						R.array.education_MAK, android.R.layout.simple_spinner_item);
				adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinner.setAdapter(adapter);
			}
            else if (sObject.getEducationallevel().contentEquals("Sarjana - S1")) {
                Spinner spinner = (Spinner) findViewById(R.id.educational_lv_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.education_S1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else {
				Spinner spinner = (Spinner) findViewById(R.id.educational_lv_field);
				ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
						R.array.education, android.R.layout.simple_spinner_item);
				adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinner.setAdapter(adapter);
			}

			setText((EditText) findViewById(R.id.village),
					sObject.getEmail());
			setText((EditText) findViewById(R.id.gps_field),
					sObject.getDepartment());
			setText((EditText) findViewById(R.id.relation_mars_field),
					sObject.getRelationWithMars());
			setText((EditText) findViewById(R.id.spouseName),
					sObject.getHomePhone());
			setText((EditText) findViewById(R.id.spouseBirthday),
					sObject.getSpousebirthday());
			//set Spouse Educational Level field
            if (sObject.getSpouseeducationallevel().contentEquals("Sekolah Dasar - SD")) {
                Spinner spinner = (Spinner) findViewById(R.id.spouseEducationalLevel_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.education_SD, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getSpouseeducationallevel().contentEquals("Sekolah Menengah Pertama - SMP")) {
                Spinner spinner = (Spinner) findViewById(R.id.spouseEducationalLevel_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.education_SMP, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getSpouseeducationallevel().contentEquals("Sekolah Menengah Atas - SMA")) {
                Spinner spinner = (Spinner) findViewById(R.id.spouseEducationalLevel_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.education_SMA, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getSpouseeducationallevel().contentEquals("Sekolah Menengah Kejuaruan - SMK")) {
                Spinner spinner = (Spinner) findViewById(R.id.spouseEducationalLevel_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.education_SMK, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getSpouseeducationallevel().contentEquals("Madrasah Tsanawiyah - MTS")) {
                Spinner spinner = (Spinner) findViewById(R.id.spouseEducationalLevel_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.education_MTS, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getSpouseeducationallevel().contentEquals("Madrasah Aliyah Kejuruan - MAK")) {
                Spinner spinner = (Spinner) findViewById(R.id.spouseEducationalLevel_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.education_MAK, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }
            else if (sObject.getSpouseeducationallevel().contentEquals("Sarjana - S1")) {
                Spinner spinner = (Spinner) findViewById(R.id.spouseEducationalLevel_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.education_S1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else {
                Spinner spinner = (Spinner) findViewById(R.id.spouseEducationalLevel_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.education, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

			setText((EditText) findViewById(R.id.childrenUnder),
					sObject.getUnder17());
			setText((EditText) findViewById(R.id.childrenInSchool),
					sObject.getUnder17inschool());
			setText((EditText) findViewById(R.id.familyMembers),
					sObject.getFamilymembers());
			setText((EditText) findViewById(R.id.dependEconomically),
					sObject.getDependeconomically());

			//Set receive pay for farm labor field
			if (sObject.getReceivespaymentfarmlabor().contentEquals("Yes")||sObject.getReceivespaymentfarmlabor().contentEquals("Ya")) {
				Spinner spinner = (Spinner) findViewById(R.id.receivesFarmPayment_Field);
				ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
						R.array.yes, android.R.layout.simple_spinner_item);
				adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinner.setAdapter(adapter);
			} else if (sObject.getReceivespaymentfarmlabor().contentEquals("No")||sObject.getReceivespaymentfarmlabor().contentEquals("Tidak")) {
				Spinner spinner = (Spinner) findViewById(R.id.receivesFarmPayment_Field);
				ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
						R.array.No, android.R.layout.simple_spinner_item);
				adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinner.setAdapter(adapter);
			} else {
				Spinner spinner = (Spinner) findViewById(R.id.receivesFarmPayment_Field);
				ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
						R.array.yesNo, android.R.layout.simple_spinner_item);
				adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinner.setAdapter(adapter);
			}

			//Set Spouse receive pay field
			if (sObject.getSpousehavepaidwork().contentEquals("Yes")||sObject.getSpousehavepaidwork().contentEquals("Ya")) {
				Spinner spinner = (Spinner) findViewById(R.id.spousePaidWork_Field);
				ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
						R.array.yes, android.R.layout.simple_spinner_item);
				adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinner.setAdapter(adapter);
			} else if (sObject.getSpousehavepaidwork().contentEquals("No")||sObject.getSpousehavepaidwork().contentEquals("Tidak")) {
				Spinner spinner = (Spinner) findViewById(R.id.spousePaidWork_Field);
				ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
						R.array.No, android.R.layout.simple_spinner_item);
				adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinner.setAdapter(adapter);
			} else {
				Spinner spinner = (Spinner) findViewById(R.id.spousePaidWork_Field);
				ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
						R.array.yesNo, android.R.layout.simple_spinner_item);
				adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinner.setAdapter(adapter);
			}

			//Set family member pay field
			if (sObject.getFamilymemberspaidwork().contentEquals("Yes")||sObject.getFamilymemberspaidwork().contentEquals("Ya")) {
				Spinner spinner = (Spinner) findViewById(R.id.familyPaidWork_Field);
				ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
						R.array.yes, android.R.layout.simple_spinner_item);
				adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinner.setAdapter(adapter);
			} else if (sObject.getFamilymemberspaidwork().contentEquals("No")||sObject.getFamilymemberspaidwork().contentEquals("Tidak")) {
				Spinner spinner = (Spinner) findViewById(R.id.familyPaidWork_Field);
				ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
						R.array.No, android.R.layout.simple_spinner_item);
				adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinner.setAdapter(adapter);
			} else {
				Spinner spinner = (Spinner) findViewById(R.id.familyPaidWork_Field);
				ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
						R.array.yesNo, android.R.layout.simple_spinner_item);
				adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinner.setAdapter(adapter);
			}

			//Set other crops field
			if (sObject.getHaveaditionalcrops().contentEquals("Yes")||sObject.getHaveaditionalcrops().contentEquals("Ya")) {
				Spinner spinner = (Spinner) findViewById(R.id.haveOtherCrops_Field);
				ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
						R.array.yes, android.R.layout.simple_spinner_item);
				adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinner.setAdapter(adapter);
			} else if (sObject.getHaveaditionalcrops().contentEquals("No")||sObject.getHaveaditionalcrops().contentEquals("Tidak")) {
				Spinner spinner = (Spinner) findViewById(R.id.haveOtherCrops_Field);
				ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
						R.array.No, android.R.layout.simple_spinner_item);
				adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinner.setAdapter(adapter);
			} else {
				Spinner spinner = (Spinner) findViewById(R.id.haveOtherCrops_Field);
				ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
						R.array.yesNo, android.R.layout.simple_spinner_item);
				adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinner.setAdapter(adapter);
			}

			//Set have credits field
			if (sObject.getHavecredit().contentEquals("Yes")||sObject.getHavecredit().contentEquals("Ya")) {
				Spinner spinner = (Spinner) findViewById(R.id.haveCredit_Field);
				ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
						R.array.yes, android.R.layout.simple_spinner_item);
				adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinner.setAdapter(adapter);
			} else if (sObject.getHavecredit().contentEquals("No")||sObject.getHavecredit().contentEquals("Tidak")) {
				Spinner spinner = (Spinner) findViewById(R.id.haveCredit_Field);
				ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
						R.array.No, android.R.layout.simple_spinner_item);
				adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinner.setAdapter(adapter);
			} else {
				Spinner spinner = (Spinner) findViewById(R.id.haveCredit_Field);
				ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
						R.array.yesNo, android.R.layout.simple_spinner_item);
				adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinner.setAdapter(adapter);
			}

			//Set give loans field
			if (sObject.getGivensomeonealoan().contentEquals("Yes")||sObject.getGivensomeonealoan().contentEquals("Ya")) {
				Spinner spinner = (Spinner) findViewById(R.id.giveLoan_Field);
				ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
						R.array.yes, android.R.layout.simple_spinner_item);
				adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinner.setAdapter(adapter);
			} else if (sObject.getGivensomeonealoan().contentEquals("No")||sObject.getGivensomeonealoan().contentEquals("Tidak")) {
				Spinner spinner = (Spinner) findViewById(R.id.giveLoan_Field);
				ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
						R.array.No, android.R.layout.simple_spinner_item);
				adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinner.setAdapter(adapter);
			} else {
				Spinner spinner = (Spinner) findViewById(R.id.giveLoan_Field);
				ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
						R.array.yesNo, android.R.layout.simple_spinner_item);
				adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinner.setAdapter(adapter);
			}

            double grossCocoa = 0;
			//set production cocoa ly field
			if (sObject.getProductioncocoaly().isEmpty()){
				setText((EditText) findViewById(R.id.productionCocoaLY_Field),Integer.toString(0));
			}else {
				setText((EditText) findViewById(R.id.productionCocoaLY_Field),
						sObject.getProductioncocoaly());
			}

			//set average cocoa price ly field
			if (sObject.getAveragecocoaprice().isEmpty()){
				setText((EditText) findViewById(R.id.averageCocoaPrice_Field),Integer.toString(35000));
			}else {
				setText((EditText) findViewById(R.id.averageCocoaPrice_Field),sObject.getAveragecocoaprice());
			}

			//set expenses cocoa ly field
			if (sObject.getExpensescocoaly().isEmpty()){
				setText((EditText) findViewById(R.id.expensesCocoaLY_Field),Integer.toString(0));
			}else {
				setText((EditText) findViewById(R.id.expensesCocoaLY_Field),
						sObject.getExpensescocoaly());
			}

            //set gross cocoa income
            if (sObject.getGROSSINCOME().isEmpty()){
                setText((EditText) findViewById(R.id.grossCocoaLY_Field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.grossCocoaLY_Field),sObject.getGROSSINCOME());
            }

			//set income other crops field
			if (sObject.getIncomeothercrops().isEmpty()){
				setText((EditText) findViewById(R.id.incomeOtherCrops_Field),Integer.toString(0));
			}else {
				setText((EditText) findViewById(R.id.incomeOtherCrops_Field),
						sObject.getIncomeothercrops());
			}

			//set income farm labor field
			if (sObject.getIncomefarmlabor().isEmpty()){
				setText((EditText) findViewById(R.id.totalIncomeLabor_Field),Integer.toString(0));
			}else {
				setText((EditText) findViewById(R.id.totalIncomeLabor_Field),
						sObject.getIncomefarmlabor());
			}

			//set income from spouse field
			if (sObject.getSpouseincome().isEmpty()){
				setText((EditText) findViewById(R.id.totalSpouseIncome_Field),Integer.toString(0));
			}else {
				setText((EditText) findViewById(R.id.totalSpouseIncome_Field),
						sObject.getSpouseincome());
			}

			//set income from family members field
			if (sObject.getFamilymembersincome().isEmpty()){
				setText((EditText) findViewById(R.id.totalFamilyMembersIncome_Field),Integer.toString(0));
			}else {
				setText((EditText) findViewById(R.id.totalFamilyMembersIncome_Field),
						sObject.getFamilymembersincome());
			}

			//set amount of loan field
			if (sObject.getAmountofloan().isEmpty()){
				setText((EditText) findViewById(R.id.amountOfLoan_Field),Integer.toString(0));
			}else {
				setText((EditText) findViewById(R.id.amountOfLoan_Field),
						sObject.getAmountofloan());
			}

			//set loan back field
			if (sObject.getLoanmoneygetback().isEmpty()){
				setText((EditText) findViewById(R.id.moneyBack_Field),Integer.toString(0));
			}else {
				setText((EditText) findViewById(R.id.moneyBack_Field),
						sObject.getLoanmoneygetback());
			}

			//set Household Savings field
			if (sObject.getHouseholdsavings().isEmpty()){
				setText((EditText) findViewById(R.id.householdSavings_Field),Integer.toString(0));
			}else {
				setText((EditText) findViewById(R.id.householdSavings_Field),
						sObject.getHouseholdsavings());
			}

			//set Living expenses field
			if (sObject.getAnnuallivingexpenses().isEmpty()){
				setText((EditText) findViewById(R.id.livingExpenses_Field),Integer.toString(30000000));
			}else {
				setText((EditText) findViewById(R.id.livingExpenses_Field),
						sObject.getAnnuallivingexpenses());
			}

			//set other expenses field
			if (sObject.getAnnualotherexpenses().isEmpty()){
				setText((EditText) findViewById(R.id.otherExpenses_Field),Integer.toString(0));
			}else {
				setText((EditText) findViewById(R.id.otherExpenses_Field),
						sObject.getAnnualotherexpenses());
			}

			//set planed investment field
			if (sObject.getPlannedinvestments().isEmpty()){
				setText((EditText) findViewById(R.id.plannedInvestments_Field),Integer.toString(0));
			}else {
				setText((EditText) findViewById(R.id.plannedInvestments_Field),
						sObject.getPlannedinvestments());
			}

			//set Educational Expenses field
			if (sObject.getExpectededucationexpenses().isEmpty()){
				setText((EditText) findViewById(R.id.educationExpenses_Field),Integer.toString(0));
			}else {
				setText((EditText) findViewById(R.id.educationExpenses_Field),
						sObject.getExpectededucationexpenses());
			}

            //set total credit field
            if (sObject.getPAYBACK().isEmpty()){
                setText((EditText) findViewById(R.id.totalCredit_Field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.totalCredit_Field),
                        sObject.getPAYBACK());
            }

			//set pay for credit field
			if (sObject.getHowmuchpayforcredit().isEmpty()){
				setText((EditText) findViewById(R.id.payForCredit_Field),Integer.toString(0));
			}else {
				setText((EditText) findViewById(R.id.payForCredit_Field),
						sObject.getHowmuchpayforcredit());
			}
			setText((EditText) findViewById(R.id.farmAge_field),sObject.getFarmAge());

            //set certification spinner
            if (sObject.getFarmCertifications().contentEquals("UTZ")) {
                Spinner spinner = (Spinner) findViewById(R.id.farmCertifications_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.cert1, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getFarmCertifications().contentEquals("RA")) {
                Spinner spinner = (Spinner) findViewById(R.id.farmCertifications_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.cert2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getFarmCertifications().contentEquals("FT")) {
                Spinner spinner = (Spinner) findViewById(R.id.farmCertifications_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.cert3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getFarmCertifications().contentEquals("UTZ/RA")) {
                Spinner spinner = (Spinner) findViewById(R.id.farmCertifications_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.cert4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getFarmCertifications().contentEquals("UTZ/FT")) {
                Spinner spinner = (Spinner) findViewById(R.id.farmCertifications_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.cert5, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getFarmCertifications().contentEquals("RA/FT")) {
                Spinner spinner = (Spinner) findViewById(R.id.farmCertifications_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.cert6, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getFarmCertifications().contentEquals("RA/UTZ/FT")) {
                Spinner spinner = (Spinner) findViewById(R.id.farmCertifications_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.cert7, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.farmCertifications_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.cert, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set Total farm Area field
            if (sObject.getTotalFarmArea().isEmpty()){
                setText((EditText) findViewById(R.id.farmArea_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.farmArea_field),sObject.getTotalFarmArea());
            }

            //set Total cultivation Area field
            if (sObject.getCultivationArea().isEmpty()){
                setText((EditText) findViewById(R.id.cultivationArea_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.cultivationArea_field),sObject.getCultivationArea());
            }

			//set Total Cocoa Area field
			if (sObject.getTotalCocoaArea().isEmpty()){
				setText((EditText) findViewById(R.id.cocoaArea_field),Integer.toString(0));
			}else {
				setText((EditText) findViewById(R.id.cocoaArea_field),sObject.getTotalCocoaArea());
			}

			//set Total Renovation Area field
			if (sObject.getTotalRenovationArea().isEmpty()){
				setText((EditText) findViewById(R.id.renovationArea_field),Integer.toString(0));
			}else {
				setText((EditText) findViewById(R.id.renovationArea_field),sObject.getTotalRenovationArea());
			}

			setText((EditText) findViewById(R.id.additionalCrops_field),sObject.getAditionalCrops());
			setText((EditText) findViewById(R.id.fmWorkFarm_field),sObject.getFamilyMembersWorkFarm());

			//set number of plots field
			if (sObject.getNumberOfPlots().isEmpty()){
				setText((EditText) findViewById(R.id.numberPlots_field),Integer.toString(0));
			}else {
				setText((EditText) findViewById(R.id.numberPlots_field),
						sObject.getNumberOfPlots());
			}

			//set number of Childrens
			if (sObject.getNUMBERCHILDRENS().isEmpty()){
				setText((EditText) findViewById(R.id.numChildren),Integer.toString(0));
			}else {
				setText((EditText) findViewById(R.id.numChildren),
						sObject.getNUMBERCHILDRENS());
			}

            //set have Spouse
            if (sObject.getHAVESPOUSE().contentEquals("Yes")||sObject.getHAVESPOUSE().contentEquals("Ya")) {
                Spinner spinner = (Spinner) findViewById(R.id.haveSpouse);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yes, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getHAVESPOUSE().contentEquals("No")||sObject.getHAVESPOUSE().contentEquals("Tidak")) {
                Spinner spinner = (Spinner) findViewById(R.id.haveSpouse);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.No, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else {
                Spinner spinner = (Spinner) findViewById(R.id.haveSpouse);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNo, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

			//set how often
			if (sObject.getOFTENPAY().contentEquals("Quarterly")||sObject.getOFTENPAY().contentEquals("Per tigabulan")) {
				Spinner spinner = (Spinner) findViewById(R.id.payOftenForCredit_Field);
				ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
						R.array.creditOftenQuarter, android.R.layout.simple_spinner_item);
				adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinner.setAdapter(adapter);
			} else if (sObject.getOFTENPAY().contentEquals("Bi annually")||sObject.getOFTENPAY().contentEquals("Setiap dua tahun")) {
                Spinner spinner = (Spinner) findViewById(R.id.payOftenForCredit_Field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.creditOftenbiannual, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getOFTENPAY().contentEquals("Annually")||sObject.getOFTENPAY().contentEquals("Tahunan")) {
                Spinner spinner = (Spinner) findViewById(R.id.payOftenForCredit_Field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.creditOftenAnnual, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getOFTENPAY().contentEquals("No set frequency")||sObject.getOFTENPAY().contentEquals("Frekuensi tidak terset")) {
                Spinner spinner = (Spinner) findViewById(R.id.payOftenForCredit_Field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.creditOftenNoSet, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else {
				Spinner spinner = (Spinner) findViewById(R.id.payOftenForCredit_Field);
				ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
						R.array.creditOften, android.R.layout.simple_spinner_item);
				adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinner.setAdapter(adapter);
			}

            //set number of Childrens
            if (sObject.getNUMBERCHILDRENS().isEmpty()){
                setText((EditText) findViewById(R.id.numChildren),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.numChildren),
                        sObject.getNUMBERCHILDRENS());
            }

            //set sources
            if (sObject.getSOURCELOAN().contentEquals("Friends")||sObject.getSOURCELOAN().contentEquals("Teman")) {
                Spinner spinner = (Spinner) findViewById(R.id.sourceCredit_Field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.sourceLoanFriend, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getSOURCELOAN().contentEquals("Community Savings")||sObject.getSOURCELOAN().contentEquals("Simpanan di Komunitas")) {
                Spinner spinner = (Spinner) findViewById(R.id.sourceCredit_Field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.sourceLoanCommunity, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getSOURCELOAN().contentEquals("Microcredit Organization")||sObject.getSOURCELOAN().contentEquals("Organisasi Mikrokredit")) {
                Spinner spinner = (Spinner) findViewById(R.id.sourceCredit_Field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.sourceLoanMicro, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getSOURCELOAN().contentEquals("Bank")) {
                Spinner spinner = (Spinner) findViewById(R.id.sourceCredit_Field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.sourceLoanBank, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else {
                Spinner spinner = (Spinner) findViewById(R.id.sourceCredit_Field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.sourceLoan, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set Farmer Group
            setText((EditText) findViewById(R.id.farmerGp),
                    sObject.getFARMERGROUP());

            //set house Address
            setText((EditText) findViewById(R.id.postalAdd),
                    sObject.getPhone());

            //set phone Number
            setText((EditText) findViewById(R.id.phoneNumber),
                    sObject.getPhoneNumber());

			//set bank account
			if (sObject.getBANKACCOUNT().contentEquals("Yes")||sObject.getBANKACCOUNT().contentEquals("Ya")) {
				Spinner spinner = (Spinner) findViewById(R.id.bankAccount_field);
				ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
						R.array.yes, android.R.layout.simple_spinner_item);
				adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinner.setAdapter(adapter);
			} else if (sObject.getBANKACCOUNT().contentEquals("No")||sObject.getBANKACCOUNT().contentEquals("Tidak")) {
				Spinner spinner = (Spinner) findViewById(R.id.bankAccount_field);
				ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
						R.array.No, android.R.layout.simple_spinner_item);
				adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinner.setAdapter(adapter);
			} else {
				Spinner spinner = (Spinner) findViewById(R.id.bankAccount_field);
				ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
						R.array.yesNo, android.R.layout.simple_spinner_item);
				adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinner.setAdapter(adapter);
			}

			//set mobile money
			if (sObject.getMOBILEMONEY().contentEquals("Yes")||sObject.getMOBILEMONEY().contentEquals("Ya")) {
				Spinner spinner = (Spinner) findViewById(R.id.mobileMoney_field);
				ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
						R.array.yes, android.R.layout.simple_spinner_item);
				adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinner.setAdapter(adapter);
			} else if (sObject.getMOBILEMONEY().contentEquals("No")||sObject.getMOBILEMONEY().contentEquals("Tidak")) {
				Spinner spinner = (Spinner) findViewById(R.id.mobileMoney_field);
				ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
						R.array.No, android.R.layout.simple_spinner_item);
				adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinner.setAdapter(adapter);
			} else {
				Spinner spinner = (Spinner) findViewById(R.id.mobileMoney_field);
				ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
						R.array.yesNo, android.R.layout.simple_spinner_item);
				adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinner.setAdapter(adapter);
			}
			//set want account
			if (sObject.getWANTACCOUNT().contentEquals("Yes")||sObject.getWANTACCOUNT().contentEquals("Ya")) {
				Spinner spinner = (Spinner) findViewById(R.id.wantAccount_field);
				ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
						R.array.yes, android.R.layout.simple_spinner_item);
				adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinner.setAdapter(adapter);
			} else if (sObject.getWANTACCOUNT().contentEquals("No")||sObject.getWANTACCOUNT().contentEquals("Tidak")) {
				Spinner spinner = (Spinner) findViewById(R.id.wantAccount_field);
				ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
						R.array.No, android.R.layout.simple_spinner_item);
				adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinner.setAdapter(adapter);
			} else {
				Spinner spinner = (Spinner) findViewById(R.id.wantAccount_field);
				ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
						R.array.yesNo, android.R.layout.simple_spinner_item);
				adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinner.setAdapter(adapter);
			}

			//set account type
			if (sObject.getACCOUNTTYPE().contentEquals("Standard bank account")||sObject.getACCOUNTTYPE().contentEquals("Rekening standard bank")) {
				Spinner spinner = (Spinner) findViewById(R.id.accountType_field);
				ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
						R.array.bank1, android.R.layout.simple_spinner_item);
				adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinner.setAdapter(adapter);
			} else if (sObject.getACCOUNTTYPE().contentEquals("Mobile banking")) {
				Spinner spinner = (Spinner) findViewById(R.id.accountType_field);
				ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
						R.array.bank2, android.R.layout.simple_spinner_item);
				adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinner.setAdapter(adapter);
			}else if (sObject.getACCOUNTTYPE().contentEquals("Micro finance")) {
				Spinner spinner = (Spinner) findViewById(R.id.accountType_field);
				ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
						R.array.bank3, android.R.layout.simple_spinner_item);
				adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinner.setAdapter(adapter);
			}else if (sObject.getACCOUNTTYPE().contentEquals("Village loan")||sObject.getACCOUNTTYPE().contentEquals("Pinjaman desa")) {
				Spinner spinner = (Spinner) findViewById(R.id.accountType_field);
				ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
						R.array.bank4, android.R.layout.simple_spinner_item);
				adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinner.setAdapter(adapter);
			}else if (sObject.getACCOUNTTYPE().contentEquals("Other")||sObject.getACCOUNTTYPE().contentEquals("Lainnya")) {
				Spinner spinner = (Spinner) findViewById(R.id.accountType_field);
				ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
						R.array.bank5, android.R.layout.simple_spinner_item);
				adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinner.setAdapter(adapter);
			} else {
				Spinner spinner = (Spinner) findViewById(R.id.accountType_field);
				ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
						R.array.bank, android.R.layout.simple_spinner_item);
				adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinner.setAdapter(adapter);
			}
		}
        familyMemb.addTextChangedListener(new DetailActivity.familyWatcher(familyMemb));
	}

	private void setText(EditText textField, String text) {
		if (textField != null) {
			textField.setText(text);
		}
	}


	public void launchFarm(View view) {
        final double farmArea;
        final double farmCocoaArea;
        final double farmRenArea;
        final double cultivating;
        final String firstName = ((EditText) findViewById(R.id.full_name_field)).getText().toString();
        final String title = ((EditText) findViewById(R.id.farmer_code_field)).getText().toString();
        final String numberPlots = ((EditText) findViewById(R.id.numberPlots_field)).getText().toString();

        if(((EditText) findViewById(R.id.farmArea_field)).getText().toString().isEmpty()){
            farmArea = 0;
        }else{
            farmArea = Double.parseDouble(((EditText) findViewById(R.id.farmArea_field)).getText().toString());
        }
        if(((EditText) findViewById(R.id.cocoaArea_field)).getText().toString().isEmpty()){
            farmCocoaArea = 0;
        }else{
            farmCocoaArea = Double.parseDouble(((EditText) findViewById(R.id.cocoaArea_field)).getText().toString());
        }
        if(((EditText) findViewById(R.id.renovationArea_field)).getText().toString().isEmpty()){
            farmRenArea = 0;
        }else{
            farmRenArea = Double.parseDouble(((EditText) findViewById(R.id.renovationArea_field)).getText().toString());
        }
        if(((EditText) findViewById(R.id.cultivationArea_field)).getText().toString().isEmpty()){
            cultivating = 0;
        }else{
            cultivating = Double.parseDouble(((EditText) findViewById(R.id.cultivationArea_field)).getText().toString());
        }
        if (TextUtils.isEmpty(firstName) || TextUtils.isEmpty(title)||TextUtils.equals(numberPlots,"0")) {
            Toast.makeText(this, this.getString(R.string.cannotBeEmpty), Toast.LENGTH_LONG).show();
            return;
        }else if(cultivating>farmArea||farmCocoaArea>cultivating||farmRenArea>farmCocoaArea){
            Toast.makeText(this, this.getString(R.string.areasInco), Toast.LENGTH_LONG).show();
            return;
        }else{
			save();
			final Intent plotIntent = new Intent(this, plotActivity.class);
			plotIntent.addCategory(Intent.CATEGORY_DEFAULT);
			plotIntent.putExtra(OBJECT_ID_KEY, sObject.getObjectId());
			plotIntent.putExtra(OBJECT_TITLE_KEY, sObject.getName());
			plotIntent.putExtra(OBJECT_NAME_KEY, sObject.getEmail());
			startActivity(plotIntent);
        }
	}

	private void save() {
		final String firstName = ((EditText) findViewById(R.id.full_name_field)).getText().toString();
		final String title = ((EditText) findViewById(R.id.farmer_code_field)).getText().toString();
		final String birthday = ((EditText) findViewById(R.id.birthday_field)).getText().toString();
		final String gender = ((Spinner) findViewById(R.id.gender_Field)).getSelectedItem().toString();
		final String educationalLvl = ((Spinner) findViewById(R.id.educational_lv_field)).getSelectedItem().toString();
		final String email = ((EditText) findViewById(R.id.village)).getText().toString();
		final String department = ((EditText) findViewById(R.id.gps_field)).getText().toString();
		final String relationMars = ((EditText) findViewById(R.id.relation_mars_field)).getText().toString();
		final String homePhone = ((EditText) findViewById(R.id.spouseName)).getText().toString();
		final String spouseBirthday = ((EditText) findViewById(R.id.spouseBirthday)).getText().toString();
		final String spouseEducationalLvl = ((Spinner) findViewById(R.id.spouseEducationalLevel_field)).getSelectedItem().toString();
		final String under17 = ((EditText) findViewById(R.id.childrenUnder)).getText().toString();
		final String under17InSchool = ((EditText) findViewById(R.id.childrenInSchool)).getText().toString();
		final String familyMembers = ((EditText) findViewById(R.id.familyMembers)).getText().toString();
		final String dependsEconomically = ((EditText) findViewById(R.id.dependEconomically)).getText().toString();
		final String receivesFarmPayment = ((Spinner) findViewById(R.id.receivesFarmPayment_Field)).getSelectedItem().toString();
		final String spousePaidWork = ((Spinner) findViewById(R.id.spousePaidWork_Field)).getSelectedItem().toString();
		final String familyPaidWork = ((Spinner) findViewById(R.id.familyPaidWork_Field)).getSelectedItem().toString();
		final String haveOtherCrops = ((Spinner) findViewById(R.id.haveOtherCrops_Field)).getSelectedItem().toString();
		final String haveCredit = ((Spinner) findViewById(R.id.haveCredit_Field)).getSelectedItem().toString();
		final String giveLoan = ((Spinner) findViewById(R.id.giveLoan_Field)).getSelectedItem().toString();
		final String cocoaProductionLY = ((EditText) findViewById(R.id.productionCocoaLY_Field)).getText().toString().replaceAll("[^0-9]+", "");
		final String averageCocoaPrice = ((EditText) findViewById(R.id.averageCocoaPrice_Field)).getText().toString().replaceAll("[^0-9]+", "");
		final String expensesCocoaLy = ((EditText) findViewById(R.id.expensesCocoaLY_Field)).getText().toString().replaceAll("[^0-9]+", "");
        final String grossIncome = ((EditText) findViewById(R.id.grossCocoaLY_Field)).getText().toString().replaceAll("[^0-9]+", "");
		final String incomeOtherCrops = ((EditText) findViewById(R.id.incomeOtherCrops_Field)).getText().toString().replaceAll("[^0-9]+", "");
		final String incomeLabor = ((EditText) findViewById(R.id.totalIncomeLabor_Field)).getText().toString().replaceAll("[^0-9]+", "");
		final String spouseIncome = ((EditText) findViewById(R.id.totalSpouseIncome_Field)).getText().toString().replaceAll("[^0-9]+", "");
		final String familyIncome = ((EditText) findViewById(R.id.totalFamilyMembersIncome_Field)).getText().toString().replaceAll("[^0-9]+", "");
		final String ammountLoan = ((EditText) findViewById(R.id.amountOfLoan_Field)).getText().toString().replaceAll("[^0-9]+", "");
		final String moneyBack = ((EditText) findViewById(R.id.moneyBack_Field)).getText().toString().replaceAll("[^0-9]+", "");
		final String hhSavings = ((EditText) findViewById(R.id.householdSavings_Field)).getText().toString().replaceAll("[^0-9]+", "");
		final String livingExpenses = ((EditText) findViewById(R.id.livingExpenses_Field)).getText().toString().replaceAll("[^0-9]+", "");
		final String otherExpenses = ((EditText) findViewById(R.id.otherExpenses_Field)).getText().toString().replaceAll("[^0-9]+", "");
		final String planInvest = ((EditText) findViewById(R.id.plannedInvestments_Field)).getText().toString().replaceAll("[^0-9]+", "");
		final String educationalExpenses = ((EditText) findViewById(R.id.educationExpenses_Field)).getText().toString().replaceAll("[^0-9]+", "");
		final String payForCredit = ((EditText) findViewById(R.id.payForCredit_Field)).getText().toString().replaceAll("[^0-9]+", "");
		final String farmAge = ((EditText) findViewById(R.id.farmAge_field)).getText().toString();
		final String farmCert = ((Spinner) findViewById(R.id.farmCertifications_field)).getSelectedItem().toString();
		final String farmArea = ((EditText) findViewById(R.id.farmArea_field)).getText().toString();
		final String farmCocoaArea = ((EditText) findViewById(R.id.cocoaArea_field)).getText().toString();
		final String farmRenArea = ((EditText) findViewById(R.id.renovationArea_field)).getText().toString();
		final String farmAditionalCrops = ((EditText) findViewById(R.id.additionalCrops_field)).getText().toString();
		final String farmWorkOnFarm = ((EditText) findViewById(R.id.fmWorkFarm_field)).getText().toString();
		final String numberPlots = ((EditText) findViewById(R.id.numberPlots_field)).getText().toString();
		final String numberChildrens = ((EditText) findViewById(R.id.numChildren)).getText().toString();
        final String haveSpouse = ((Spinner) findViewById(R.id.haveSpouse)).getSelectedItem().toString();
        final String totalPayCredit = ((EditText)findViewById(R.id.totalCredit_Field)).getText().toString().replaceAll("[^0-9]+", "");
        final String oftenPayCredit = ((Spinner)findViewById(R.id.payOftenForCredit_Field)).getSelectedItem().toString();
        final String sourceOfCredit = ((Spinner)findViewById(R.id.sourceCredit_Field)).getSelectedItem().toString();
        final String fmGroup = ((EditText) findViewById(R.id.farmerGp)).getText().toString();
        final String postal = ((EditText) findViewById(R.id.postalAdd)).getText().toString();
        final String phone = ((EditText) findViewById(R.id.phoneNumber)).getText().toString();
        final String cultivating =((EditText) findViewById(R.id.cultivationArea_field)).getText().toString();
		final String bankAccount = ((Spinner) findViewById(R.id.bankAccount_field)).getSelectedItem().toString();
		final String acctType = ((Spinner) findViewById(R.id.accountType_field)).getSelectedItem().toString();
		final String mbMoney =((Spinner) findViewById(R.id.mobileMoney_field)).getSelectedItem().toString();
		final String want = ((Spinner) findViewById(R.id.wantAccount_field)).getSelectedItem().toString();
        final String country = "Indonesia";
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
			contact.put(ContactObject.FIRST_NAME, firstName);
			contact.put(ContactObject.TITLE, title);
			contact.put(ContactObject.BIRTHDAY, birthday);
			contact.put(ContactObject.GENDER, gender);
			contact.put(ContactObject.EDUCATIONALLEVEL, educationalLvl);
			contact.put(ContactObject.EMAIL, email);
			contact.put(ContactObject.DEPARTMENT, department);
			contact.put(ContactObject.YEARSRELATIONSHIPWITHMARS,relationMars);
			contact.put(ContactObject.HOME_PHONE, homePhone);
			contact.put(ContactObject.SPOUSEBIRTHDAY,spouseBirthday);
			contact.put(ContactObject.SPOUSEEDUCATIONALLEVEL,spouseEducationalLvl);
			contact.put(ContactObject.UNDER17,under17);
			contact.put(ContactObject.UNDER17INSCHOOL,under17InSchool);
			contact.put(ContactObject.FAMILYMEMBERS,familyMembers);
			contact.put(ContactObject.DEPENDECONOMICALLY,dependsEconomically);
			contact.put(ContactObject.RECEIVESPAYMENTFARMLABOR,receivesFarmPayment);
			contact.put(ContactObject.SPOUSEHAVEPAIDWORK,spousePaidWork);
			contact.put(ContactObject.FAMILYMEMBERSPAIDWORK,familyPaidWork);
			contact.put(ContactObject.HAVEADITIONALCROPS,haveOtherCrops);
			contact.put(ContactObject.HAVECREDIT,haveCredit);
			contact.put(ContactObject.GIVENSOMEONEALOAN,giveLoan);
			contact.put(ContactObject.PRODUCTIONCOCOALY,cocoaProductionLY);
			contact.put(ContactObject.AVERAGECOCOAPRICE,averageCocoaPrice);
			contact.put(ContactObject.EXPENSESCOCOALY,expensesCocoaLy);
            contact.put(ContactObject.GROSSINCOME,grossIncome);
			contact.put(ContactObject.INCOMEOTHERCROPS,incomeOtherCrops);
			contact.put(ContactObject.INCOMEFARMLABOR,incomeLabor);
			contact.put(ContactObject.SPOUSEINCOME,spouseIncome);
			contact.put(ContactObject.FAMILYMEMBERSINCOME,familyIncome);
			contact.put(ContactObject.AMOUNTOFLOAN,ammountLoan);
			contact.put(ContactObject.LOANMONEYGETBACK,moneyBack);
			contact.put(ContactObject.HOUSEHOLDSAVINGS,hhSavings);
			contact.put(ContactObject.ANNUALLIVINGEXPENSES,livingExpenses);
			contact.put(ContactObject.ANNUALOTHEREXPENSES,otherExpenses);
			contact.put(ContactObject.PLANNEDINVESTMENTS,planInvest);
			contact.put(ContactObject.EXPECTEDEDUCATIONEXPENSES,educationalExpenses);
			contact.put(ContactObject.HOWMUCHPAYFORCREDIT,payForCredit);
			contact.put(ContactObject.FARMAGE, farmAge);
			contact.put(ContactObject.FARMCERTIFICATIONS, farmCert);
			contact.put(ContactObject.TOTALFARMAREA, farmArea);
			contact.put(ContactObject.TOTALCOCOAAREA, farmCocoaArea);
			contact.put(ContactObject.TOTALRENOVATIONAREA, farmRenArea);
			contact.put(ContactObject.ADITIONALCROPS, farmAditionalCrops);
			contact.put(ContactObject.FAMILYMEMBERSWORKONFARM, farmWorkOnFarm);
			contact.put(ContactObject.NUMBEROFPLOTS, numberPlots);
            contact.put(ContactObject.NUMBERCHILDRENS,numberChildrens);
			contact.put(ContactObject.HAVESPOUSE,haveSpouse);
            contact.put(ContactObject.PAYBACK,totalPayCredit);
            contact.put(ContactObject.OFTENPAY,oftenPayCredit);
            contact.put(ContactObject.SOURCELOAN,sourceOfCredit);
            contact.put(ContactObject.FARMERGROUP,fmGroup);
            contact.put(ContactObject.PHONE,postal);
            contact.put(ContactObject.PHONENUMBER,phone);
            contact.put(ContactObject.CULTIVATIONAREA,cultivating);
            contact.put(ContactObject.BANKACCOUNT,bankAccount);
            contact.put(ContactObject.ACCOUNTTYPE,acctType);
            contact.put(ContactObject.MOBILEMONEY,mbMoney);
            contact.put(ContactObject.WANTACCOUNT,want);
            contact.put(ContactObject.COUNTRY,country);
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

    private void savePoint() {
        final String firstName = ((EditText) findViewById(R.id.full_name_field)).getText().toString();
        final String title = ((EditText) findViewById(R.id.farmer_code_field)).getText().toString();
        final String birthday = ((EditText) findViewById(R.id.birthday_field)).getText().toString();
        final String gender = ((Spinner) findViewById(R.id.gender_Field)).getSelectedItem().toString();
        final String educationalLvl = ((Spinner) findViewById(R.id.educational_lv_field)).getSelectedItem().toString();
        final String email = ((EditText) findViewById(R.id.village)).getText().toString();
        final String department = ((EditText) findViewById(R.id.gps_field)).getText().toString();
        final String relationMars = ((EditText) findViewById(R.id.relation_mars_field)).getText().toString();
        final String homePhone = ((EditText) findViewById(R.id.spouseName)).getText().toString();
        final String spouseBirthday = ((EditText) findViewById(R.id.spouseBirthday)).getText().toString();
        final String spouseEducationalLvl = ((Spinner) findViewById(R.id.spouseEducationalLevel_field)).getSelectedItem().toString();
        final String under17 = ((EditText) findViewById(R.id.childrenUnder)).getText().toString();
        final String under17InSchool = ((EditText) findViewById(R.id.childrenInSchool)).getText().toString();
        final String familyMembers = ((EditText) findViewById(R.id.familyMembers)).getText().toString();
        final String dependsEconomically = ((EditText) findViewById(R.id.dependEconomically)).getText().toString();
        final String receivesFarmPayment = ((Spinner) findViewById(R.id.receivesFarmPayment_Field)).getSelectedItem().toString();
        final String spousePaidWork = ((Spinner) findViewById(R.id.spousePaidWork_Field)).getSelectedItem().toString();
        final String familyPaidWork = ((Spinner) findViewById(R.id.familyPaidWork_Field)).getSelectedItem().toString();
        final String haveOtherCrops = ((Spinner) findViewById(R.id.haveOtherCrops_Field)).getSelectedItem().toString();
        final String haveCredit = ((Spinner) findViewById(R.id.haveCredit_Field)).getSelectedItem().toString();
        final String giveLoan = ((Spinner) findViewById(R.id.giveLoan_Field)).getSelectedItem().toString();
        final String cocoaProductionLY = ((EditText) findViewById(R.id.productionCocoaLY_Field)).getText().toString().replaceAll("[^0-9]+", "");
        final String averageCocoaPrice = ((EditText) findViewById(R.id.averageCocoaPrice_Field)).getText().toString().replaceAll("[^0-9]+", "");
        final String expensesCocoaLy = ((EditText) findViewById(R.id.expensesCocoaLY_Field)).getText().toString().replaceAll("[^0-9]+", "");
        final String grossIncome = ((EditText) findViewById(R.id.grossCocoaLY_Field)).getText().toString().replaceAll("[^0-9]+", "");
        final String incomeOtherCrops = ((EditText) findViewById(R.id.incomeOtherCrops_Field)).getText().toString().replaceAll("[^0-9]+", "");
        final String incomeLabor = ((EditText) findViewById(R.id.totalIncomeLabor_Field)).getText().toString().replaceAll("[^0-9]+", "");
        final String spouseIncome = ((EditText) findViewById(R.id.totalSpouseIncome_Field)).getText().toString().replaceAll("[^0-9]+", "");
        final String familyIncome = ((EditText) findViewById(R.id.totalFamilyMembersIncome_Field)).getText().toString().replaceAll("[^0-9]+", "");
        final String ammountLoan = ((EditText) findViewById(R.id.amountOfLoan_Field)).getText().toString().replaceAll("[^0-9]+", "");
        final String moneyBack = ((EditText) findViewById(R.id.moneyBack_Field)).getText().toString().replaceAll("[^0-9]+", "");
        final String hhSavings = ((EditText) findViewById(R.id.householdSavings_Field)).getText().toString().replaceAll("[^0-9]+", "");
        final String livingExpenses = ((EditText) findViewById(R.id.livingExpenses_Field)).getText().toString().replaceAll("[^0-9]+", "");
        final String otherExpenses = ((EditText) findViewById(R.id.otherExpenses_Field)).getText().toString().replaceAll("[^0-9]+", "");
        final String planInvest = ((EditText) findViewById(R.id.plannedInvestments_Field)).getText().toString().replaceAll("[^0-9]+", "");
        final String educationalExpenses = ((EditText) findViewById(R.id.educationExpenses_Field)).getText().toString().replaceAll("[^0-9]+", "");
        final String payForCredit = ((EditText) findViewById(R.id.payForCredit_Field)).getText().toString().replaceAll("[^0-9]+", "");
        final String farmAge = ((EditText) findViewById(R.id.farmAge_field)).getText().toString();
        final String farmCert = ((Spinner) findViewById(R.id.farmCertifications_field)).getSelectedItem().toString();
        final String farmArea = ((EditText) findViewById(R.id.farmArea_field)).getText().toString();
        final String farmCocoaArea = ((EditText) findViewById(R.id.cocoaArea_field)).getText().toString();
        final String farmRenArea = ((EditText) findViewById(R.id.renovationArea_field)).getText().toString();
        final String farmAditionalCrops = ((EditText) findViewById(R.id.additionalCrops_field)).getText().toString();
        final String farmWorkOnFarm = ((EditText) findViewById(R.id.fmWorkFarm_field)).getText().toString();
        final String numberPlots = ((EditText) findViewById(R.id.numberPlots_field)).getText().toString();
        final String numberChildrens = ((EditText) findViewById(R.id.numChildren)).getText().toString();
        final String haveSpouse = ((Spinner) findViewById(R.id.haveSpouse)).getSelectedItem().toString();
        final String totalPayCredit = ((EditText)findViewById(R.id.totalCredit_Field)).getText().toString().replaceAll("[^0-9]+", "");
        final String oftenPayCredit = ((Spinner)findViewById(R.id.payOftenForCredit_Field)).getSelectedItem().toString();
        final String sourceOfCredit = ((Spinner)findViewById(R.id.sourceCredit_Field)).getSelectedItem().toString();
        final String fmGroup = ((EditText) findViewById(R.id.farmerGp)).getText().toString();
        final String postal = ((EditText) findViewById(R.id.postalAdd)).getText().toString();
        final String phone = ((EditText) findViewById(R.id.phoneNumber)).getText().toString();
        final String cultivating =((EditText) findViewById(R.id.cultivationArea_field)).getText().toString();
        final String bankAccount = ((Spinner) findViewById(R.id.bankAccount_field)).getSelectedItem().toString();
        final String acctType = ((Spinner) findViewById(R.id.accountType_field)).getSelectedItem().toString();
        final String mbMoney =((Spinner) findViewById(R.id.mobileMoney_field)).getSelectedItem().toString();
        final String want = ((Spinner) findViewById(R.id.wantAccount_field)).getSelectedItem().toString();
        final String country = "Indonesia";
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
            contact.put(ContactObject.FIRST_NAME, firstName);
            contact.put(ContactObject.TITLE, title);
            contact.put(ContactObject.BIRTHDAY, birthday);
            contact.put(ContactObject.GENDER, gender);
            contact.put(ContactObject.EDUCATIONALLEVEL, educationalLvl);
            contact.put(ContactObject.EMAIL, email);
            contact.put(ContactObject.DEPARTMENT, department);
            contact.put(ContactObject.YEARSRELATIONSHIPWITHMARS,relationMars);
            contact.put(ContactObject.HOME_PHONE, homePhone);
            contact.put(ContactObject.SPOUSEBIRTHDAY,spouseBirthday);
            contact.put(ContactObject.SPOUSEEDUCATIONALLEVEL,spouseEducationalLvl);
            contact.put(ContactObject.UNDER17,under17);
            contact.put(ContactObject.UNDER17INSCHOOL,under17InSchool);
            contact.put(ContactObject.FAMILYMEMBERS,familyMembers);
            contact.put(ContactObject.DEPENDECONOMICALLY,dependsEconomically);
            contact.put(ContactObject.RECEIVESPAYMENTFARMLABOR,receivesFarmPayment);
            contact.put(ContactObject.SPOUSEHAVEPAIDWORK,spousePaidWork);
            contact.put(ContactObject.FAMILYMEMBERSPAIDWORK,familyPaidWork);
            contact.put(ContactObject.HAVEADITIONALCROPS,haveOtherCrops);
            contact.put(ContactObject.HAVECREDIT,haveCredit);
            contact.put(ContactObject.GIVENSOMEONEALOAN,giveLoan);
            contact.put(ContactObject.PRODUCTIONCOCOALY,cocoaProductionLY);
            contact.put(ContactObject.AVERAGECOCOAPRICE,averageCocoaPrice);
            contact.put(ContactObject.EXPENSESCOCOALY,expensesCocoaLy);
            contact.put(ContactObject.GROSSINCOME,grossIncome);
            contact.put(ContactObject.INCOMEOTHERCROPS,incomeOtherCrops);
            contact.put(ContactObject.INCOMEFARMLABOR,incomeLabor);
            contact.put(ContactObject.SPOUSEINCOME,spouseIncome);
            contact.put(ContactObject.FAMILYMEMBERSINCOME,familyIncome);
            contact.put(ContactObject.AMOUNTOFLOAN,ammountLoan);
            contact.put(ContactObject.LOANMONEYGETBACK,moneyBack);
            contact.put(ContactObject.HOUSEHOLDSAVINGS,hhSavings);
            contact.put(ContactObject.ANNUALLIVINGEXPENSES,livingExpenses);
            contact.put(ContactObject.ANNUALOTHEREXPENSES,otherExpenses);
            contact.put(ContactObject.PLANNEDINVESTMENTS,planInvest);
            contact.put(ContactObject.EXPECTEDEDUCATIONEXPENSES,educationalExpenses);
            contact.put(ContactObject.HOWMUCHPAYFORCREDIT,payForCredit);
            contact.put(ContactObject.FARMAGE, farmAge);
            contact.put(ContactObject.FARMCERTIFICATIONS, farmCert);
            contact.put(ContactObject.TOTALFARMAREA, farmArea);
            contact.put(ContactObject.TOTALCOCOAAREA, farmCocoaArea);
            contact.put(ContactObject.TOTALRENOVATIONAREA, farmRenArea);
            contact.put(ContactObject.ADITIONALCROPS, farmAditionalCrops);
            contact.put(ContactObject.FAMILYMEMBERSWORKONFARM, farmWorkOnFarm);
            contact.put(ContactObject.NUMBEROFPLOTS, numberPlots);
            contact.put(ContactObject.NUMBERCHILDRENS,numberChildrens);
            contact.put(ContactObject.HAVESPOUSE,haveSpouse);
            contact.put(ContactObject.PAYBACK,totalPayCredit);
            contact.put(ContactObject.OFTENPAY,oftenPayCredit);
            contact.put(ContactObject.SOURCELOAN,sourceOfCredit);
            contact.put(ContactObject.FARMERGROUP,fmGroup);
            contact.put(ContactObject.PHONE,postal);
            contact.put(ContactObject.PHONENUMBER,phone);
            contact.put(ContactObject.CULTIVATIONAREA,cultivating);
            contact.put(ContactObject.BANKACCOUNT,bankAccount);
            contact.put(ContactObject.ACCOUNTTYPE,acctType);
            contact.put(ContactObject.MOBILEMONEY,mbMoney);
            contact.put(ContactObject.WANTACCOUNT,want);
            contact.put(ContactObject.COUNTRY,country);
            contact.put(SyncManager.LOCAL, true);
            contact.put(SyncManager.LOCALLY_UPDATED, !isCreate);
            contact.put(SyncManager.LOCALLY_CREATED, isCreate);
            contact.put(SyncManager.LOCALLY_DELETED, false);
            if (isCreate) {
                smartStore.create(ContactListLoader.CONTACT_SOUP, contact);
            } else {
                smartStore.upsert(ContactListLoader.CONTACT_SOUP, contact);
            }
            Toast.makeText(this, this.getString(R.string.autosave), Toast.LENGTH_SHORT).show();
        } catch (JSONException e) {
            Log.e(TAG, "JSONException occurred while parsing", e);
        }
    }

}

