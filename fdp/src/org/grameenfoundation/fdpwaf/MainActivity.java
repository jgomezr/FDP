package org.grameenfoundation.fdpwaf;

import android.accounts.Account;
import android.app.LoaderManager;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.Loader;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnCloseListener;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.TextView;
import android.widget.Toast;

import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.rest.RestClient;
import com.salesforce.androidsdk.rest.RestRequest;
import com.salesforce.androidsdk.rest.RestResponse;
import com.salesforce.androidsdk.smartstore.store.SmartStore;
import com.salesforce.androidsdk.smartstore.ui.SmartStoreInspectorActivity;
import com.salesforce.androidsdk.smartsync.app.SmartSyncSDKManager;
import com.salesforce.androidsdk.smartsync.util.Constants;
import com.salesforce.androidsdk.ui.SalesforceListActivity;
import com.salesforce.androidsdk.util.EventsObservable;

import org.grameenfoundation.fdpwaf.loaders.ContactListLoader;
import org.grameenfoundation.fdpwaf.objects.ContactObject;
import org.grameenfoundation.fdpwaf.ui.DetailActivity;
import org.grameenfoundation.fdpwaf.ui.LogoutDialogFragment;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import static android.content.ContentValues.TAG;

/**
 * Main activity
 * @author jgomez
 */
public class MainActivity extends SalesforceListActivity implements
		OnQueryTextListener, OnCloseListener,
		LoaderManager.LoaderCallbacks<List<ContactObject>> {

	public static final String OBJECT_ID_KEY = "object_id";
	public static final String OBJECT_TITLE_KEY = "object_title";
	public static final String OBJECT_NAME_KEY = "object_name";
	private static final String SYNC_CONTENT_AUTHORITY = "org.grameenfoundation.fdp.sync.contactsyncadapter";
	private static final long SYNC_FREQUENCY_ONE_HOUR = 1 * 60 * 60;
	private static final int CONTACT_LOADER_ID = 1;
	private static final int CONTACT_COLORS[] = {
			Color.rgb(26, 188, 156),
			Color.rgb(46, 204, 113),
			Color.rgb(52, 152, 219),
			Color.rgb(155, 89, 182),
			Color.rgb(52, 73, 94),
			Color.rgb(22, 160, 133),
			Color.rgb(39, 174, 96),
			Color.rgb(41, 128, 185),
			Color.rgb(142, 68, 173),
			Color.rgb(44, 62, 80),
			Color.rgb(241, 196, 15),
			Color.rgb(230, 126, 34),
			Color.rgb(231, 76, 60),
			Color.rgb(149, 165, 166),
			Color.rgb(243, 156, 18),
			Color.rgb(211, 84, 0),
			Color.rgb(192, 57, 43),
			Color.rgb(189, 195, 199),
			Color.rgb(127, 140, 141)
	};

	private SearchView searchView;
	private ContactListAdapter listAdapter;
	private UserAccount curAccount;
	private NameFieldFilter nameFilter;
	private List<ContactObject> originalData;
	private SmartStore smartStore;
	private LogoutDialogFragment logoutConfirmationDialog;
	private ContactListLoader contactLoader;
	private LoadCompleteReceiver loadCompleteReceiver;
	private AtomicBoolean isRegistered;
    private String apiVersion;
    private RestClient client;


    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		getActionBar().setTitle(R.string.main_activity_title);
		listAdapter = new ContactListAdapter(this, R.layout.list_item);
		getListView().setAdapter(listAdapter);
		nameFilter = new NameFieldFilter(listAdapter, originalData);
		logoutConfirmationDialog = new LogoutDialogFragment();
		loadCompleteReceiver = new LoadCompleteReceiver();
		isRegistered = new AtomicBoolean(false);
        apiVersion = getString(R.string.api_version);
	}
	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {

		// Always call the superclass so it can save the view hierarchy state
		super.onSaveInstanceState(savedInstanceState);
	}

	@Override
	public void onResume(RestClient client) {
        this.client = client;
        curAccount = SmartSyncSDKManager.getInstance().getUserAccountManager().getCurrentUser();
		Account account = null;
		if (curAccount != null) {
			account = SmartSyncSDKManager.getInstance().getUserAccountManager().buildAccount(curAccount);
		}
		smartStore = SmartSyncSDKManager.getInstance().getSmartStore(curAccount);
		getLoaderManager().initLoader(CONTACT_LOADER_ID, null, this);
		if (!smartStore.hasSoup(ContactListLoader.CONTACT_SOUP)) {
			syncDownContacts();
		} else {
			refreshList();
		}

		/*
		 * Enables sync automatically for this provider. To enable almost
		 * instantaneous sync when records are modified locally, a call needs
		 * to be made by the content provider to notify the sync provider
		 * that the underlying data set has changed. Since we don't use cursors
		 * in this sample application, we simply enable periodic sync every hour.
		 */
		ContentResolver.setSyncAutomatically(account, SYNC_CONTENT_AUTHORITY, true);
		ContentResolver.addPeriodicSync(account, SYNC_CONTENT_AUTHORITY,
				Bundle.EMPTY, SYNC_FREQUENCY_ONE_HOUR);
		if (!isRegistered.get()) {
			registerReceiver(loadCompleteReceiver,
					new IntentFilter(ContactListLoader.LOAD_COMPLETE_INTENT_ACTION));
		}
		isRegistered.set(true);
	}

	@Override
	public void onPause() {
		if (isRegistered.get()) {
			unregisterReceiver(loadCompleteReceiver);
		}
		isRegistered.set(false);
		getLoaderManager().destroyLoader(CONTACT_LOADER_ID);
		contactLoader = null;
		super.onPause();
	}

	@Override
	public void onDestroy() {
		loadCompleteReceiver = null;
		super.onDestroy();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		final MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.action_bar_menu, menu);
		final MenuItem searchItem = menu.findItem(R.id.action_search);
		searchView = new SearchView(this);
		searchView.setOnQueryTextListener(this);
		searchView.setOnCloseListener(this);
		searchItem.setActionView(searchView);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.action_refresh:
				Toast.makeText(this, "Synchronizing...", Toast.LENGTH_SHORT).show();
				syncUpContacts();
				return true;
			//case R.id.action_logout:
				//logoutConfirmationDialog.show(getFragmentManager(), "LogoutDialog");
				//return true;
			case R.id.action_switch_user:
				launchAccountSwitcherActivity();
				return true;
			case R.id.action_add:
				launchDetailActivity(Constants.EMPTY_STRING, "New Farmer",
						Constants.EMPTY_STRING);
				return true;
            case R.id.internal_Inspection:
                Intent intent = getPackageManager().getLaunchIntentForPackage("org.grameen.taro");
                Uri webpage = Uri.parse("https://taroworks.zendesk.com/hc/en-us/articles/202261490-TaroWorks-Releases");
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                if (intent != null) {
                    startActivity(intent);
                }else{
                    startActivity(webIntent);
                }
			default:
				return super.onOptionsItemSelected(item);
		}
	}

	private void launchSmartStoreInspectorActivity() {
		this.startActivity(SmartStoreInspectorActivity.getIntent(this, false, null));
	}

	private void launchAccountSwitcherActivity() {
		final Intent i = new Intent(this, SalesforceSDKManager.getInstance().getAccountSwitcherActivityClass());
		i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		this.startActivity(i);
	}

	@Override
	public Loader<List<ContactObject>> onCreateLoader(int id, Bundle args) {
		contactLoader = new ContactListLoader(this, curAccount);
		return contactLoader;
	}

	@Override
	public void onLoaderReset(Loader<List<ContactObject>> loader) {
		originalData = null;
		refreshList(null);
	}

	@Override
	public void onLoadFinished(Loader<List<ContactObject>> loader,
							   List<ContactObject> data) {
		originalData = data;
		nameFilter.setOrigData(originalData);
		refreshList(data);
	}

	@Override
	public boolean onClose() {
		refreshList(originalData);
		return true;
	}

	@Override
	public boolean onQueryTextSubmit(String query) {
		filterList(query);
		return true;
	}

	@Override
	public boolean onQueryTextChange(String newText) {
		filterList(newText);
		return true;
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		final ContactObject sObject = listAdapter.getItem(position);
		launchDetailActivity(sObject.getObjectId(), sObject.getName(),
				sObject.getEmail());
	}

	private void refreshList() {
		getLoaderManager().getLoader(CONTACT_LOADER_ID).forceLoad();
	}

	private void refreshList(List<ContactObject> data) {
		listAdapter.setData(data);
	}

	private void launchDetailActivity(String objId, String objName,
									  String objTitle) {
		final Intent detailIntent = new Intent(this, DetailActivity.class);
		detailIntent.addCategory(Intent.CATEGORY_DEFAULT);
		detailIntent.putExtra(OBJECT_ID_KEY, objId);
		detailIntent.putExtra(OBJECT_TITLE_KEY, objTitle);
		detailIntent.putExtra(OBJECT_NAME_KEY, objName);
		startActivity(detailIntent);
	}

	private void filterList(String filterTerm) {
		nameFilter.filter(filterTerm);
	}

	private void syncDownContacts() {
		contactLoader.syncDown();
		Toast.makeText(MainActivity.this, "Sync down complete!",
				Toast.LENGTH_LONG).show();
	}

	private void syncUpContacts() {
		contactLoader.syncUp();
		Toast.makeText(this, "Sync up complete!", Toast.LENGTH_LONG).show();

        postImageAsAttachment();
	}

    public static String encodeToBase64(Bitmap image, Bitmap.CompressFormat compressFormat, int quality)
    {
        ByteArrayOutputStream byteArrayOS = new ByteArrayOutputStream();
        image.compress(compressFormat, quality, byteArrayOS);
        return Base64.encodeToString(byteArrayOS.toByteArray(), Base64.DEFAULT);
    }

    private void postImageAsAttachment() {
        Map<String, Object> fields = new HashMap<String, Object>();
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        final File[] files = new File(String.valueOf(storageDir)).listFiles();
        if(files != null){

            for (int i = 0; i < files.length; i++) {
                String name = files[i].getName();
                File f = new File(String.valueOf(files[i]));
                Bitmap bitmap = BitmapFactory.decodeFile(String.valueOf(f.getAbsolutePath()));
                String myBase64Image = encodeToBase64(bitmap, Bitmap.CompressFormat.JPEG, 100);
                fields.put("Name", name);
                fields.put("ParentId", name.substring(0, 18));
                fields.put("Body",myBase64Image);

                RestRequest request = null;
                try {
                    request = RestRequest.getRequestForCreate(apiVersion, "Attachment", fields);
                    System.out.println("Request File:" + request.getPath());
                } catch (Exception ex) {
                    Log.d(TAG, "sendRequest: ", ex);
                    Toast.makeText(MainActivity.this, "The file upload failed: " + ex.toString(), Toast.LENGTH_LONG).show();
                }

				final int finalI = i;
				client.sendAsync(request, new RestClient.AsyncRequestCallback() {

                    @Override
                    public void onSuccess(RestRequest request, RestResponse response) {
                        System.out.println("Response:" + response);
						files[finalI].delete();
                    }

                    @Override
                    public void onError(Exception exception) {
                        exception.printStackTrace();
                        EventsObservable.get().notifyEvent(EventsObservable.EventType.RenditionComplete);
                    }
                });

            }
        }
		Toast.makeText(this, "Sync up Images complete!", Toast.LENGTH_LONG).show();
    }

	/**
	 * Custom array adapter to supply data to the list view.
	 *
	 * @author bhariharan
	 */
	private static class ContactListAdapter extends ArrayAdapter<ContactObject> {

		private int listItemLayoutId;
		private List<ContactObject> sObjects;

		/**
		 * Parameterized constructor.
		 *
		 * @param context Context.
		 * @param listItemLayoutId List item view resource ID.
		 */
		public ContactListAdapter(Context context, int listItemLayoutId) {
			super(context, listItemLayoutId);
			this.listItemLayoutId = listItemLayoutId;
		}

		/**
		 * Sets data to this adapter.
		 *
		 * @param data Data.
		 */
		public void setData(List<ContactObject> data) {
			clear();
			sObjects = data;
			if (data != null) {
				addAll(data);
				notifyDataSetChanged();
			}
		}

		@Override
		public View getView (int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = LayoutInflater.from(getContext()).inflate(listItemLayoutId, null);
			}
			if (sObjects != null) {
				final ContactObject sObject = sObjects.get(position);
				if (sObject != null) {
					final TextView objName = (TextView) convertView.findViewById(R.id.obj_name);
					final TextView objType = (TextView) convertView.findViewById(R.id.obj_type);
					final TextView objImage = (TextView) convertView.findViewById(R.id.obj_image);
					if (objName != null) {
						objName.setText(sObject.getName());
					}
					if (objType != null) {
						objType.setText(sObject.getTitle());
					}
					if (objImage != null) {
						final String firstName = sObject.getFirstName();
						String initials = Constants.EMPTY_STRING;
						if (firstName.length() > 0) {
							initials = firstName.substring(0, 1);
						}
						objImage.setText(initials);
						setBubbleColor(objImage, firstName);
					}
					final ImageView syncImage = (ImageView) convertView.findViewById(R.id.sync_status_view);
					if (syncImage != null && sObject.isLocallyModified()) {
						syncImage.setImageResource(R.drawable.sync_local);
					} else {
						syncImage.setImageResource(R.drawable.sync_success);
					}
				}
			}
			return convertView;
		}

		private void setBubbleColor(TextView tv, String firstName) {
			firstName = firstName.trim();
			int code = 0;
			if (!TextUtils.isEmpty(firstName)) {
				for (int i = 0; i < firstName.length(); i++) {
					code += firstName.charAt(i);
				}
			}
			int colorIndex = code % CONTACT_COLORS.length;
			int color = CONTACT_COLORS[colorIndex];
			final GradientDrawable drawable = new GradientDrawable();
			drawable.setColor(color);
			drawable.setShape(GradientDrawable.OVAL);
			tv.setBackground(drawable);
		}
	}

	/**
	 * A simple utility class to implement filtering.
	 *
	 * @author bhariharan
	 */
	private static class NameFieldFilter extends Filter {

		private ContactListAdapter adpater;
		private List<ContactObject> origList;

		/**
		 * Parameterized constructor.
		 *
		 * @param adapter List adapter.
		 * @param origList List to perform filtering against.
		 */
		public NameFieldFilter(ContactListAdapter adapter, List<ContactObject> origList) {
			this.adpater = adapter;
			this.origList = origList;
		}

		/**
		 * Sets the original data set.
		 *
		 * @param origData Original data set.
		 */
		public void setOrigData(List<ContactObject> origData) {
			origList = origData;
		}

		@Override
		protected FilterResults performFiltering(CharSequence constraint) {
			if (origList == null) {
				return null;
			}
			final FilterResults results = new FilterResults();
			if (TextUtils.isEmpty(constraint)) {
				results.values = origList;
				results.count = origList.size();
				return results;
			}
			final String filterString = constraint.toString().toLowerCase();
			int count = origList.size();
			String filterableString;
			final List<ContactObject> resultSet = new ArrayList<ContactObject>();
			for (int i = 0; i < count; i++) {
				filterableString = origList.get(i).getName();
				if (filterableString.toLowerCase().contains(filterString)) {
					resultSet.add(origList.get(i));
				}
			}
			results.values = resultSet;
			results.count = resultSet.size();
			return results;
		}

		@SuppressWarnings("unchecked")
		@Override
		protected void publishResults(CharSequence constraint, FilterResults results) {
			if (results != null && results.values != null) {
				adpater.setData((List<ContactObject>) results.values);
			}
		}
	}

	/**
	 * A simple receiver for load complete events.
	 *
	 * @author bhariharan
	 */
	private class LoadCompleteReceiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			if (intent != null) {
				final String action = intent.getAction();
				if (ContactListLoader.LOAD_COMPLETE_INTENT_ACTION.equals(action)) {
					refreshList();
				}
			}
		}
	}
}