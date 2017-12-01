package com.grameen.fdp.utility;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.preference.PreferenceManager;
import android.util.Log;

import com.grameen.fdp.object.Form;
import com.grameen.fdp.object.Question;

 import java.math.BigInteger;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import static com.grameen.fdp.utility.DatabaseDataClass.*;


/**
 * Created by aangjnr on 24/06/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {


    static final String TAG = DatabaseHelper.class.getSimpleName();
    static final String DB_NAME = "fdp.db";
    static final int DB_VERSION = 2;

    private static final String TEXT_TYPE = " TEXT";
    private static final String INT_TYPE = " integer";
    private static final String COMMA = ",";


    private static DatabaseHelper instance;
    Context _context;
    SharedPreferences prefs;
    private SQLiteDatabase db;


    private DatabaseHelper(Context ctx) { //
        super(ctx, DB_NAME, null, DB_VERSION);
        prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        db = this.getWritableDatabase();
        _context = ctx;

    }

    public static synchronized DatabaseHelper getInstance(Context ctx) {
        if (instance == null) {
            instance = new DatabaseHelper(ctx.getApplicationContext());

        }
        return instance;
    }


    public void beginTransaction() {
        db.beginTransaction();
    }

    public void endTransaction(boolean success) {
        if (success) {
            db.setTransactionSuccessful();
        }
        db.endTransaction();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_QUESTIONS_TABLE);


    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(DROP_QUESTIONS_TABLE);

        onCreate(db);
    }




    public boolean addAQuestion(Question question){
        try{

            ContentValues contentValues = new ContentValues();
            contentValues.put(QUESTION_ID ,question.getId());
            contentValues.put(QUESTION_CAPTION ,question.getCaption__c());
            contentValues.put(QUESTION_ERROR_TEXT ,question.getError_text__c());
            contentValues.put(QUESTION_HELPER_TEXT ,question.getHelp_Text__c());
            contentValues.put(QUESTION_MAXI_VALUE ,question.getMax_value__c());
            contentValues.put(QUESTION_MINI_VALUE ,question.getMin_value__c());
            contentValues.put(QUESTION_OPTIONS ,question.getOptions__c());
            contentValues.put(QUESTION_TYPE ,question.getType__c());
            contentValues.put(QUESTION_FORM_NAME, question.getForm__r().getName());
            contentValues.put(QUESTION_FORM_ID ,question.getForm__r().getCountryId());


            db.insert(QUESTIONS_TABLE, null, contentValues);

            Log.d(TAG, "QUESTION WITH ID " + question.getId() + " INSERTED" );



        }catch(Exception e){
            e.printStackTrace();
            return false;
        }

        return true;

    }


    public boolean deleteQuestion(String id){

        return db.delete(QUESTIONS_TABLE, QUESTION_ID + " = ? ", new String[]{id} ) > 0;

    }


    public boolean deleteQuestionsTable(){

        try {


            db.execSQL("DELETE FROM " + QUESTIONS_TABLE);

            Log.i("DATABASE", "QUESTIONS TABLE DELETED");

            return true;
        }catch(Exception e)
        {
            e.printStackTrace();

            return false;
        }
    }




    public Question getQuestion(String id){

        Question question = null;
        Cursor cursor = null;
        try {
           question = new Question();


            String selectQuery = "SELECT  * FROM " + QUESTIONS_TABLE + " WHERE " +
                    QUESTION_ID + " ='" + id + "'";
            Log.i("QUERY", selectQuery);
             cursor = db.rawQuery(selectQuery, null);

            if (cursor != null && cursor.getCount() > 0) {

                if (cursor.moveToFirst())

                    do {


                        Form form = new Form();
                        form.setCountryId(cursor.getString(cursor.getColumnIndex(QUESTION_FORM_ID)));
                        form.setName(cursor.getString(cursor.getColumnIndex(QUESTION_FORM_NAME)));


                        question.setId(cursor.getString(cursor.getColumnIndex(QUESTION_ID)));
                        question.setCaption__c(cursor.getString(cursor.getColumnIndex(QUESTION_CAPTION)));
                        question.setError_text__c(cursor.getString(cursor.getColumnIndex(QUESTION_ERROR_TEXT)));
                        question.setHelp_Text__c(cursor.getString(cursor.getColumnIndex(QUESTION_HELPER_TEXT)));
                        question.setMax_value__c(cursor.getString(cursor.getColumnIndex(QUESTION_MAXI_VALUE)));
                        question.setMin_value__c(cursor.getString(cursor.getColumnIndex(QUESTION_MINI_VALUE)));
                        question.setOptions__c(cursor.getString(cursor.getColumnIndex(QUESTION_OPTIONS)));
                        question.setType__c(cursor.getString(cursor.getColumnIndex(QUESTION_TYPE)));
                        question.setForm__r(form);



                    } while (cursor.moveToNext());
            }







        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally {

        if (cursor != null)
            cursor.close();
        }

        return question;

    }




    public List<Question> getAllQuestions(){

        List<Question> questions = null;
        Cursor cursor = null;

        try {

            questions = new ArrayList<>();

            String selectQuery = "SELECT  * FROM " + QUESTIONS_TABLE;
            Log.i("QUERY", selectQuery);
            cursor = db.rawQuery(selectQuery, null);

            if (cursor != null && cursor.getCount() > 0) {

                if (cursor.moveToFirst())

                    do {


                        Question question = new Question();
                    Form form = new Form();
                    form.setCountryId(cursor.getString(cursor.getColumnIndex(QUESTION_FORM_ID)));
                    form.setName(cursor.getString(cursor.getColumnIndex(QUESTION_FORM_NAME)));


                         question.setId(cursor.getString(cursor.getColumnIndex(QUESTION_ID)));
                        question.setCaption__c(cursor.getString(cursor.getColumnIndex(QUESTION_CAPTION)));
                        question.setError_text__c(cursor.getString(cursor.getColumnIndex(QUESTION_ERROR_TEXT)));
                        question.setHelp_Text__c(cursor.getString(cursor.getColumnIndex(QUESTION_HELPER_TEXT)));
                        question.setMax_value__c(cursor.getString(cursor.getColumnIndex(QUESTION_MAXI_VALUE)));
                        question.setMin_value__c(cursor.getString(cursor.getColumnIndex(QUESTION_MINI_VALUE)));
                        question.setOptions__c(cursor.getString(cursor.getColumnIndex(QUESTION_OPTIONS)));
                        question.setType__c(cursor.getString(cursor.getColumnIndex(QUESTION_TYPE)));
                        question.setForm__r(form);



                        Log.i(TAG, "Question found with id " + question.getId());

                        questions.add(question);



                    } while (cursor.moveToNext());
            }
        }catch(Exception e){
            e.printStackTrace();
            return null;

        }finally {

            if (cursor != null)
                cursor.close();
        }

        return questions;



    }








    public List<Question> getSpecificSetOfQuestions(String questionFormName){


        List<Question> questions = null;
        Cursor cursor = null;

            try {

                questions = new ArrayList<>();

                String selectQuery = "SELECT  * FROM " + QUESTIONS_TABLE + " WHERE " +
                        QUESTION_FORM_NAME + " ='" + questionFormName + "'";

                Log.i("QUERY", selectQuery);
                cursor = db.rawQuery(selectQuery, null);



                if (cursor != null && cursor.getCount() > 0) {

                    if (cursor.moveToFirst())

                        do {


                            Question question = new Question();
                            Form form = new Form();
                            form.setCountryId(cursor.getString(cursor.getColumnIndex(QUESTION_FORM_ID)));
                            form.setName(cursor.getString(cursor.getColumnIndex(QUESTION_FORM_NAME)));


                            question.setId(cursor.getString(cursor.getColumnIndex(QUESTION_ID)));
                            question.setCaption__c(cursor.getString(cursor.getColumnIndex(QUESTION_CAPTION)));
                            question.setError_text__c(cursor.getString(cursor.getColumnIndex(QUESTION_ERROR_TEXT)));
                            question.setHelp_Text__c(cursor.getString(cursor.getColumnIndex(QUESTION_HELPER_TEXT)));
                            question.setMax_value__c(cursor.getString(cursor.getColumnIndex(QUESTION_MAXI_VALUE)));
                            question.setMin_value__c(cursor.getString(cursor.getColumnIndex(QUESTION_MINI_VALUE)));
                            question.setOptions__c(cursor.getString(cursor.getColumnIndex(QUESTION_OPTIONS)));
                            question.setType__c(cursor.getString(cursor.getColumnIndex(QUESTION_TYPE)));
                            question.setForm__r(form);



                            Log.i(TAG, "Question found with id " + question.getId());
                            questions.add(question);



                        } while (cursor.moveToNext());
                }
            }catch(Exception e){
                e.printStackTrace();
                return null;

            }finally {

                if (cursor != null)
                    cursor.close();
            }

            return questions;

    }
































    Boolean parseBoolean(String value) {
        if (value.equalsIgnoreCase("true"))
            return true;
        else if (value.equalsIgnoreCase("false"))
            return false;
        else return null;
    }

    public String getSystemTime() {
        return String.valueOf(System.currentTimeMillis());
    }

    public String getTime() {

        return new SimpleDateFormat("h:mm a", Locale.getDefault())
                .format(Calendar.getInstance().getTime());

    }

    public String getDate() {
        return new SimpleDateFormat("MMM d", Locale.getDefault())
                .format(Calendar.getInstance().getTime());
    }

    public String getRandomAlphaNumericString() {
        return new BigInteger(130, new SecureRandom()).toString(32);

    }






}
