package org.grameen.fdp.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.wooplr.spotlight.SpotlightConfig;
import com.wooplr.spotlight.utils.SpotlightSequence;

import org.grameen.fdp.R;
import org.grameen.fdp.activity.BaseActivity;
import org.grameen.fdp.activity.FarmerDetailsActivity;
import org.grameen.fdp.adapter.FarmerListAdapter;
import org.grameen.fdp.object.RealFarmer;
import org.grameen.fdp.utility.Constants;
import org.grameen.fdp.utility.CustomToast;
import org.grameen.fdp.utility.DatabaseHelper;
import org.grameen.fdp.utility.Utils;

import java.util.List;

/**
 * Created by aangjnr on 11/12/2017.
 */

public class FarmerListFragment extends Fragment {


    RecyclerView recyclerView;
    View rootView;
    FarmerListAdapter mAdapter;
    List<RealFarmer> farmers;
    private DatabaseHelper databaseHelper;


    public FarmerListFragment() {

        super();
    }


    public static FarmerListFragment newInstance(String filter) {

        FarmerListFragment farmerListFragment = new FarmerListFragment();

        Bundle bundle = new Bundle();
        bundle.putString("filter", filter);
        //bundle.putSerializable("farmers", farmers);
        farmerListFragment.setArguments(bundle);
        return farmerListFragment;


    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


        rootView = inflater.inflate(R.layout.fragment_farmer_list, container, false);
        recyclerView = rootView.findViewById(R.id.recycler_view);

        return rootView;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }


    @Override
    public void onAttach(Context context) {

        //Todo get all farmers from db according to tag


        super.onAttach(context);

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        databaseHelper = DatabaseHelper.getInstance(getActivity());
        setUpAdapter();


    }


    void setUpAdapter() {

      /*  String array =  getArguments().getString("farmers");
        Type listType = new TypeToken<List<RealFarmer>>() {}.getType();
        farmers = (List<RealFarmer>) new Gson().fromJson(array, listType);
        */
        String filter = getArguments().getString("filter");

        Log.d("FARMER LIST FRAG", "FILTER IS " + filter);

        farmers = databaseHelper.getAllFarmersBasicInfoAccordingToVillage(filter);

        GridLayoutManager productsGridLayoutManager;

        if (Utils.isTablet((AppCompatActivity) getActivity()))
            productsGridLayoutManager = new GridLayoutManager(getActivity(), 6);
        else
            productsGridLayoutManager = new GridLayoutManager(getActivity(), 4);


        recyclerView.setLayoutManager(productsGridLayoutManager);
        BaseActivity.SpacesGridItemDecoration decoration = new BaseActivity.SpacesGridItemDecoration(8);
        //  mRecycler.addItemDecoration(decoration);


        mAdapter = new FarmerListAdapter(getActivity(), farmers);
        mAdapter.setHasStableIds(true);
        recyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new FarmerListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {


                RealFarmer farmer = farmers.get(position);

/*
                if(farmer.getHasSubmitted() != null)
                if (farmer.getHasSubmitted().equalsIgnoreCase(Constants.YES)) {

                    showAlertDialog(true, "Read Only Data!", "You cannot make anymore modifications to " + farmer.getFarmerName() + "'s data", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();

                        }
                    }, getResources().getString(R.string.ok), null, "", 0);

                } else{


                    Intent intent = new Intent(getActivity(), FarmerDetailsActivity.class);
                intent.putExtra("farmer", new Gson().toJson(farmer));
                startActivity(intent);
            }

            else{*/

                Intent intent = new Intent(getActivity(), FarmerDetailsActivity.class);
                intent.putExtra("farmer", new Gson().toJson(farmer));
                startActivity(intent);

                //  }


            }
        });


        if (!PreferenceManager.getDefaultSharedPreferences(getActivity()).getString("flag", "").equals(Constants.MONITORING))
            mAdapter.OnLongClickListener(new FarmerListAdapter.OnLongClickListener() {
                @Override
                public void onLongClick(View view, final int position) {

                    final RealFarmer farmer = farmers.get(position);


                    showAlertDialog(true, "Delete Farmer", "Do you want to delete data for " + farmer.getFarmerName() + "?", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            dialogInterface.dismiss();

                            if (databaseHelper.deleteFarmer(farmer.getId())) {



                                CustomToast.makeToast(getActivity(), "Data deleted!", Toast.LENGTH_LONG).show();
                                farmers.remove(position);
                                mAdapter.notifyItemRemoved(position);

                            }


                        }
                    }, "YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            dialogInterface.dismiss();

                        }
                    }, "No", 0);


                }

            });


        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {


                try {
                    startIntro();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }, 1000);


    }

/*

    @Override
    public void onResume() {

        Log.i("FRAGMENT", "ON RESUME!");
       // setUpAdapter();




        super.onResume();
    }

*/


    public void showAlertDialog(Boolean cancelable, @Nullable String title, @Nullable String message,
                                @Nullable DialogInterface.OnClickListener onPositiveButtonClickListener,
                                @NonNull String positiveText,
                                @Nullable DialogInterface.OnClickListener onNegativeButtonClickListener,
                                @NonNull String negativeText, @Nullable int icon_drawable) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AppDialog);
        builder.setTitle(title);
        builder.setCancelable(cancelable);


        if (icon_drawable != 0) builder.setIcon(icon_drawable);
        builder.setMessage(message);

        if (onPositiveButtonClickListener != null)
            builder.setPositiveButton(positiveText, onPositiveButtonClickListener);
        if (onNegativeButtonClickListener != null)
            builder.setNegativeButton(negativeText, onNegativeButtonClickListener);
        builder.show();
    }


    void startIntro() {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());


        if (prefs.getBoolean("farmersFragment", true)) {

            try {


                prefs.edit().putBoolean("farmersFragment", false).apply();

                final View itemView = recyclerView.findViewHolderForAdapterPosition(0).itemView;


                final SpotlightConfig config = new SpotlightConfig();
                config.setDismissOnBackpress(true);
                config.setDismissOnTouch(true);
                config.setHeadingTvColor(ContextCompat.getColor(getActivity(), R.color.colorAccent));
                config.setHeadingTvSize(26);
                config.setSubHeadingTvSize(16);
                config.setSubHeadingTvColor(ContextCompat.getColor(getActivity(), R.color.black_50));
                config.setFadingTextDuration(400);
                config.setIntroAnimationDuration(200);
                config.setMaskColor(ContextCompat.getColor(getActivity(), R.color.white_50));
                config.setLineAndArcColor(ContextCompat.getColor(getActivity(), R.color.colorAccent));
                config.setFadingTextDuration(250);
                config.setLineStroke(2);


                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        SpotlightSequence.getInstance(getActivity(), config)

                                .addSpotlight(itemView, "Long click to delete item", "Press and hold to delete item", "deleteFarmer")

                                .startSequence();
                    }
                }, 400);


            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }


}
