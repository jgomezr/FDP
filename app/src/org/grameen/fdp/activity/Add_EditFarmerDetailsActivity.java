package org.grameen.fdp.activity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.squareup.picasso.Picasso;

import org.grameen.fdp.R;
import org.grameen.fdp.fragment.MyFormFragment;
import org.grameen.fdp.object.RealFarmer;
import org.grameen.fdp.utility.Constants;
import org.grameen.fdp.utility.CustomToast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;

/**
 * Created by aangjnr on 09/11/2017.
 */

public class Add_EditFarmerDetailsActivity extends BaseActivity {

    public static int CAMERA_INTENT = 90;
    public static int PERMISSION_CAMERA = 11;
    public static String ROOT_DIR = Environment
            .getExternalStorageDirectory() + File.separator + ".FDP";
    static String TAG = Add_EditFarmerDetailsActivity.class.getSimpleName();
    String IMAGE_URL = "";
    EditText farmerName;
    EditText farmerCode;
    TextView takePhoto;
    MaterialSpinner villageSpinner;
    MaterialSpinner educationLevelSpinner;
    MaterialSpinner genderSpinner;
    String gender = "";
    String village = "";
    String education = "";
    EditText birthYearEdittext;
    CircleImageView circleImageView;
    TextView initials;
    RealFarmer farmer;
    boolean isEditMode = false;
    boolean newFarmer = false;
    Button cancel;
    Button save;
    String formType = "";
    MyFormFragment formFragment;
    String[] educationLevels = {"Primary", "Secondary", "Tertiary", "Professional Course", "Other"};
    String[] genders = {"Male", "Female"};
    private boolean newDataSaved = false;

    public static void createNoMediaFile() {
        FileOutputStream out = null;

        try {

            File ROOT = new File(ROOT_DIR);

            if (!ROOT.exists())
                if (ROOT.mkdirs()) {

                    Log.i(TAG, "ROOT dir file created!  " + ROOT);

                }


            File thumbnailsDir = new File(ROOT + File.separator + ".thumbnails");
            if (!thumbnailsDir.exists())
                if (thumbnailsDir.mkdirs()) {

                    Log.i(TAG, "Thumbnails dir file created!  " + thumbnailsDir);
                }


            File file = new File(ROOT + File.separator, ".nomedia");
            if (!file.exists()) {
                out = new FileOutputStream(file);
                out.write(0);
                out.close();


                Log.i(TAG, "No media file created!  " + file);
            } else {
                Log.i(TAG, "No media already exists!!!!!!  " + file);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


   /* @Override
    protected void onStop() {

        Log.i(TAG, "ON STOP");

        saveOrUpdateData(false);
        super.onStop();



    }*/

    public static String generateThumbnail(String path, String destinationName) {
        File file = new File(path);

        BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();

        bitmapOptions.inJustDecodeBounds = true; // obtain the size of the image, without loading it in memory
        BitmapFactory.decodeFile(file.getAbsolutePath(), bitmapOptions);

        int desiredWidth = 400;
        int desiredHeight = 300;

        float widthScale = (float) bitmapOptions.outWidth / desiredWidth;
        float heightScale = (float) bitmapOptions.outHeight / desiredHeight;

        float scale = Math.min(widthScale, heightScale);

        int sampleSize = 1;
        while (sampleSize < scale) {
            sampleSize *= 2;
        }
        bitmapOptions.inSampleSize = sampleSize; // this value must be a power of 2,
        // this is why you can not have an image scaled as you would like
        bitmapOptions.inJustDecodeBounds = false; // now we want to load the image

        Bitmap thumbnail = BitmapFactory.decodeFile(String.valueOf(file), bitmapOptions);

        File thumbnailFile = new File(ROOT_DIR + File.separator + ".thumbnails", destinationName + ".jpg");

        FileOutputStream fos = null;


        try {
            fos = new FileOutputStream(thumbnailFile);
            thumbnail.compress(Bitmap.CompressFormat.JPEG, 70, fos);

            Log.i(TAG, "Saving thumbnail " + thumbnailFile);
            return thumbnailFile.getAbsolutePath();

        } catch (FileNotFoundException e) {
            e.printStackTrace();

            thumbnail.recycle();
            return "null";

        } finally {
            // Not really required
            try {

                thumbnail.recycle();
                if (fos != null) {
                    fos.flush();
                    fos.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static String saveImage(Bitmap imageBitmap, String destinationName) {

        OutputStream fOut = null;

        File dir = new File(ROOT_DIR + File.separator + "Farmer Images");
        if (!dir.exists()) Log.i(TAG, "Is DIR created?  " + dir.mkdirs());
        Log.i(TAG, "Destination path is " + dir);

        File save_image = new File(dir, destinationName + ".jpg");

        try {
            fOut = new FileOutputStream(save_image);
            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 70, fOut);

            Log.i(TAG, "Saving edited screenshot with name" + save_image);

            return save_image.getAbsolutePath();

        } catch (FileNotFoundException e) {
            e.printStackTrace();

            return "null";
        } finally {
            // Not really required
            try {

                if (fOut != null) {
                    fOut.flush();
                    fOut.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createNoMediaFile();

        Intent intent = getIntent();
        setContentView(R.layout.activity_edit_farmer_details);


        cancel = (Button) findViewById(R.id.back);
        save = (Button) findViewById(R.id.save);

        farmerName = findViewById(R.id.farmerName);
        farmerName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                if (editable.length() < 3) {
                    save.setEnabled(false);

                    farmerName.setError(getResources(R.string.full_name_error));

                } else save.setEnabled(true);
                farmerName.setError(null);
            }
        });


        farmerCode = findViewById(R.id.farmerCode);
        birthYearEdittext = findViewById(R.id.birthdayYearEdittext);

        takePhoto = (TextView) findViewById(R.id.takeImage);
        takePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startCameraIntent();

            }
        });


        initials = (TextView) findViewById(R.id.initials);

        villageSpinner = (MaterialSpinner) findViewById(R.id.villageSpinner);
        villageSpinner.setItems(databaseHelper.getAllVillageNames());

        villageSpinner.setSelectedIndex(0);

        village = villageSpinner.getItems().get(0).toString();


        villageSpinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
                village = item.toString();

                Log.i(TAG, "^^^^^^^^^^ ON VILLAGE ITEM SELECTED " + village);


            }
        });

        educationLevelSpinner = (MaterialSpinner) findViewById(R.id.educationLevelSpinner);

        try {
            educationLevelSpinner.setItems(databaseHelper.getQuestionByTranslation("Highest education level graduated").formatQuestionOptions());


        }catch(Exception e){e.printStackTrace();

        educationLevelSpinner.setItems(educationLevels);}


        education = educationLevelSpinner.getItems().get(0).toString();


        educationLevelSpinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
                education = item.toString();


                Log.i(TAG, "^^^^^^^^^^ ON EDUCATION ITEM SELECTED " + education);


            }
        });


        genderSpinner = (MaterialSpinner) findViewById(R.id.genderSpinner);
        try {
            genderSpinner.setItems(databaseHelper.getQuestionByTranslation("Gender").formatQuestionOptions());


        }catch(Exception e) {
            e.printStackTrace();

            genderSpinner.setItems(genders);
        }
        gender = genderSpinner.getItems().get(0).toString();

        genderSpinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {

                gender = item.toString();

                Log.i(TAG, "^^^^^^^^^^ ON GENDER ITEM SELECTED " + gender);

            }
        });


        circleImageView = (CircleImageView) findViewById(R.id.photo);

        farmer = new Gson().fromJson(getIntent().getStringExtra("farmer"), RealFarmer.class);
        formType = intent.getStringExtra("formType");


        Log.d("ACTION TYPE", prefs.getString("flag", ""));
        if (prefs.getString("flag", "").equals(Constants.MONITORING)) {

            //Todo hide views, load farmer details with tag
            Toolbar toolbar = setToolbar("View Farmer Details");
            //save.setVisibility(View.GONE);
            cancel.setText("BACK");
            farmerName.setEnabled(false);
            farmerCode.setEnabled(false);
            villageSpinner.setEnabled(false);
            educationLevelSpinner.setEnabled(false);
            genderSpinner.setEnabled(false);
            birthYearEdittext.setEnabled(false);
            takePhoto.setVisibility(View.GONE);

            setUpViews();

            formFragment = MyFormFragment.newInstance(formType, true, farmer.getCode(), true);


        } else {

            //Todo load farmer details with tag

            if (intent.getStringExtra("flag") != null && intent.getStringExtra("flag").equals("edit")) {

                Toolbar toolbar = setToolbar(getResources(R.string.edit_farmer_details));
                isEditMode = true;
                newFarmer = false;

                setUpViews();
                formFragment = MyFormFragment.newInstance(formType, true, farmer.getCode(), false);


            } else {

                isEditMode = true;
                newFarmer = true;

                //Todo load ui views with tag default socioeconomic
                Toolbar toolbar = setToolbar(getResources(R.string.add_farmer_details));
                formType = Constants.FARMER_PROFILE;
                formFragment = MyFormFragment.newInstance(formType, false, null, false);


                farmerCode.setText(getRandomNumber() + "");
                save.setEnabled(false);

            }
        }


        loadDynamicView(formType);
        onBackClicked();
    }

    @Override
    protected void onPause() {


        Log.i(TAG, "ON PAUSE");

        if (prefs.getBoolean("shouldSave", false))

            if (!newDataSaved && isEditMode) {
                Log.i(TAG, "SAVING NEW DATA NOW!!!");

                if (!farmerName.getText().toString().equals(""))
                    saveOrUpdateData(false);

            }

        super.onPause();


    }

    @Override
    public void onBackPressed() {


        Log.i(TAG, "ON BACK PRESSED");

        if (!newDataSaved && isEditMode) {
            Log.i(TAG, "NEW DATA NOT SAVED, SAVING NEW DATA NOW!!!");


            if (!farmerName.getText().toString().equals("")) {

                showAlertDialog(true, getResources(R.string.save_data), getResources(R.string.save_data_explanation), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        prefs.edit().putBoolean("shouldRestartActivity", true).apply();

                        dialogInterface.dismiss();

                        saveOrUpdateData(false);
                        finish();


                    }
                }, getResources(R.string.yes), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        newDataSaved = true;
                        prefs.edit().putBoolean("shouldRestartActivity", false).apply();


                        dialogInterface.dismiss();
                        finish();

                    }
                }, getResources(R.string.no), 0);


            } else finish();


        } else {
            finish();
        }

    }

    void loadDynamicView(final String formType) {

        //Todo add parameter to load data from the database, if is in editing mode else display default forms with their resp values


        FragmentManager fm = getSupportFragmentManager();

        fm.beginTransaction()
                .add(R.id.dynamicLayout, formFragment, formFragment.getClass().getSimpleName())
                .commit();


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                saveOrUpdateData(true);


            }
        });


    }

    void saveOrUpdateData(boolean shouldLoadNextActivity) {

        save.setEnabled(false);
        String newJsonValue = formFragment.getAllAnswersInJSON();

        Log.d(TAG, "JSON VALUE IS + \n" + newJsonValue + "\n");

        prefs.edit().putBoolean("shouldRestartMainActivity", true).apply();

        if (newFarmer) {
            //Todo add new farmer, save details finish this activity and go back to farmer details activity

            RealFarmer _farmer = new RealFarmer();
            _farmer.setId(String.valueOf(System.currentTimeMillis()));
            _farmer.setFarmerName(farmerName.getText().toString());
            _farmer.setCode(farmerCode.getText().toString());
            _farmer.setVillage(village);
            _farmer.setEducationLevel(education);
            _farmer.setBirthYear(birthYearEdittext.getText().toString());
            _farmer.setGender(gender);
            _farmer.setImageUrl(IMAGE_URL);
            _farmer.setSocioEconomicProfileJson(newJsonValue);

            if (databaseHelper.addNewFarmer(_farmer)) {

                databaseHelper.editSpecificFarmerDetails(Constants.FARMER_PROFILE, _farmer.getCode(), newJsonValue);

                newDataSaved = true;

                if (shouldLoadNextActivity) {
                    CustomToast.makeToast(Add_EditFarmerDetailsActivity.this, getResources(R.string.new_farmer_added), Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(Add_EditFarmerDetailsActivity.this, FarmerDetailsActivity.class);
                    intent.putExtra("farmer", new Gson().toJson(_farmer));
                    intent.setFlags(FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);


                    finish();


                }

            } else
                CustomToast.makeToast(Add_EditFarmerDetailsActivity.this, getResources(R.string.new_farmer_not_added), Toast.LENGTH_SHORT).show();


        } else {  //Todo save details finish this activity and go back to farmer details activity


            farmer.setFarmerName(farmerName.getText().toString());
            farmer.setCode(farmerCode.getText().toString());
            farmer.setVillage(village);
            farmer.setEducationLevel(education);
            farmer.setBirthYear(birthYearEdittext.getText().toString());
            farmer.setGender(gender);
            farmer.setImageUrl(IMAGE_URL);


            if (databaseHelper.editFarmerBasicInfo(farmer)) {
                //String value = databaseHelper.getSpecificFarmerDetails(formType, farmer.getCode());

                //if (value == null) value = "empty";


                if (databaseHelper.editSpecificFarmerDetails(formType, farmer.getCode(), newJsonValue)) {

                    newDataSaved = true;

                    if (shouldLoadNextActivity) {
                        CustomToast.makeToast(Add_EditFarmerDetailsActivity.this, getResources(R.string.farmer_updated), Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(Add_EditFarmerDetailsActivity.this, FarmerDetailsActivity.class);
                        intent.putExtra("farmer", new Gson().toJson(farmer));
                        intent.setFlags(FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();

                    }

                } else
                    CustomToast.makeToast(Add_EditFarmerDetailsActivity.this, getResources(R.string.could_not_save) + formType + getResources(R.string.try_again_suffix), Toast.LENGTH_SHORT).show();


            } else
                CustomToast.makeToast(Add_EditFarmerDetailsActivity.this, getResources(R.string.could_not_save) + formType + getResources(R.string.try_again_suffix), Toast.LENGTH_SHORT).show();


        }

        save.setEnabled(true);

        prefs.edit().putBoolean("shouldRestartMainActivity", true).apply();


    }

    void setUpViews() {

        farmerName.setText(farmer.getFarmerName());
        farmerCode.setText(farmer.getCode());
        birthYearEdittext.setText(farmer.getBirthYear());


        village = farmer.getVillage();
        villageSpinner.setText(village.toUpperCase());

        education = farmer.getEducationLevel();
        educationLevelSpinner.setText(education);

        gender = farmer.getGender();
        genderSpinner.setText(gender);


        IMAGE_URL = farmer.getImageUrl();


        if (farmer.getImageUrl() != null && !farmer.getImageUrl().equals("")) {
            Picasso.with(this).load(farmer.getImageUrl()).resize(200, 200).into(circleImageView);

        } else {


            try {
                String[] valueArray = farmer.getFarmerName().split(" ");
                String value = valueArray[0].substring(0, 1) + valueArray[1].substring(0, 1);
                initials.setText(value);

            } catch (Exception e) {

                if (!farmer.getFarmerName().trim().isEmpty())
                    initials.setText(farmer.getFarmerName().substring(0, 1));


            }


            int[] mColors = getResources().getIntArray(R.array.recommendations_colors);

            int randomColor = mColors[new Random().nextInt(mColors.length)];

            GradientDrawable drawable = new GradientDrawable();
            drawable.setCornerRadius(1000);
            drawable.setColor(randomColor);
            circleImageView.setBackground(drawable);
        }


    }

    void startCameraIntent() {


        prefs.edit().putBoolean("shouldSave", false).apply();

        if (!hasPermissions(this, Manifest.permission.CAMERA)) {
            ActivityCompat.requestPermissions(Add_EditFarmerDetailsActivity.this, new String[]{Manifest.permission.CAMERA}, PERMISSION_CAMERA);
        } else {


            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {

                Log.d(TAG, "Starting camera intent");

                startActivityForResult(takePictureIntent, CAMERA_INTENT);

            }


        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {


            Log.d(TAG, "RESULT CODE = " + resultCode + " REQUEST CODE " + requestCode);


            if (resultCode == RESULT_OK) {

                Log.d(TAG, " REQUEST CODE IS OK");

                if (requestCode == CAMERA_INTENT) {


                    Log.d(TAG, "CAMERA INTENT");


                    Bundle extras = data.getExtras();
                    Bitmap imageBitmap = (Bitmap) extras.get("data");


                    String farmerImage = "file://" + saveImage(imageBitmap, farmerCode.getText().toString());


                    IMAGE_URL = farmerImage;

                    Log.d(TAG, "FARMER IMAGE URL IS " + farmerImage);


                    if (circleImageView != null) {

                        Picasso.with(this).load(IMAGE_URL).resize(400, 300).into(circleImageView);
                        initials.setVisibility(View.GONE);

                    } else {

                        Log.d(TAG, "Image view is null");

                    }


                }


            } else CustomToast.makeToast(this, "Something went wrong", Toast.LENGTH_LONG).show();

        } catch (Exception e) {
            CustomToast.makeToast(this, "Something went wrong", Toast.LENGTH_LONG)
                    .show();
        }

        prefs.edit().putBoolean("shouldSave", true).apply();


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permission, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permission, grantResults);
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            // CustomToast.makeToast(this, permission[0], Toast.LENGTH_SHORT).show();

            if (requestCode == PERMISSION_CAMERA) {

                startCameraIntent();

            }

        } else {

            showAlertDialog(true, getResources(R.string.permission_required), getResources(R.string.camera_permission_rationale) , new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    dialogInterface.dismiss();
                    startCameraIntent();

                }
            }, getResources(R.string.ok), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    dialogInterface.dismiss();

                }
            }, getResources(R.string.no), 0);
        }
    }

    private int getRandomNumber() {
        Random r = new Random(System.currentTimeMillis());
        return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
    }

    private File getOutputMediaFile() {
        File mediaStorageDir = new File(ROOT_DIR);

        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                return null;
            }
        }


        return new File(ROOT_DIR,
                "temp" + ".jpg");
    }


}
