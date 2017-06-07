package org.grameenfoundation.fdp.ui;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.rest.RestClient;
import com.salesforce.androidsdk.ui.SalesforceActivity;

import org.grameenfoundation.fdp.R;
import org.grameenfoundation.fdp.loaders.ContactDetailLoader;
import org.grameenfoundation.fdp.objects.ContactObject;

import java.io.File;
import java.io.IOException;

/**
 * Created by julian_Gf on 3/28/2017.
 */

public class photoActivity extends SalesforceActivity implements LoaderManager.LoaderCallbacks<ContactObject> {
    private String objectId;
    private String objectTitle;
    private String objNameKey;
    private String photoName;
    private UserAccount curAccount;
    private ContactObject sObject;
    public static final String OBJECT_ID_KEY = "object_id";
    public static final String OBJECT_TITLE_KEY = "object_title";
    public static final String OBJECT_NAME_KEY = "object_name";
    public static final String PHOTO_NAME = "photo_Name";
    String mCurrentPhotoPath;
    private Bitmap mImageBitmap;
    private Uri imageToUploadUri;
    static final int REQUEST_TAKE_PHOTO = 1;
    private ImageView mImageView;

    @Override
    public void onResume(RestClient client) {

    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo);
        final Intent launchIntent = getIntent();
        if (launchIntent != null) {
            objectId = launchIntent.getStringExtra(DetailActivity.OBJECT_ID_KEY);
            objectTitle = launchIntent.getStringExtra(DetailActivity.OBJECT_TITLE_KEY);
            objNameKey = launchIntent.getStringExtra(DetailActivity.OBJECT_NAME_KEY);
            photoName = launchIntent.getStringExtra(DetailActivity.PHOTO_NAME);
        }
        mImageView = (ImageView) findViewById(R.id.imageView);
    }

    private File createImageFile(String name) throws IOException {
        // Create an image file name

        String imageFileName = objectId+"_"+ name;
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = image.getAbsolutePath();
        return image;
    }

    public void dispatchTakePictureIntent(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile(photoName);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,"com.example.android.fileprovider",photoFile);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                    imageToUploadUri = Uri.fromFile(photoFile);
                    startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
                }
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK) {
            Log.v("data:", String.valueOf(mCurrentPhotoPath));
            try {
                mImageBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), Uri.parse("file://" +mCurrentPhotoPath));
                mImageView.setImageBitmap(mImageBitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void launchDetail(View view) {
        final Intent plotIntent = new Intent(this, DetailActivity.class);
        plotIntent.addCategory(Intent.CATEGORY_DEFAULT);
        plotIntent.putExtra(OBJECT_ID_KEY, objectId);
        plotIntent.putExtra(OBJECT_TITLE_KEY, objectTitle);
        plotIntent.putExtra(OBJECT_NAME_KEY, objNameKey);
        startActivity(plotIntent);
        finish();
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

        }
    }
}
