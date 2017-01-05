package org.grameenfoundation.fdp.ui;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.grameenfoundation.fdp.R;

import java.text.DecimalFormat;

/**
 * Created by julian_Gf on 12/20/2016.
 */

public class fdpFragment extends Fragment {
    public String startYear;
    public Spinner start;
    private Button changeR;
    private EditText comment;
    private TextView plotLB,gaplp,grflp,replp,exslp,limlp,dralp,fillp,lablp,lnp,lcp,lnpy1,lnpy2,lnpy3,lnpy4,lnpy5,lnpy6,lnpy7,lcpy1,lcpy2,lcpy3,lcpy4,lcpy5,lcpy6,lcpy7,plpy1,plpy2,plpy3,plpy4,plpy5,plpy6,plpy7,incomeY1,incomeY2,incomeY3,incomeY4,incomeY5,incomeY6,incomeY7,costY1,costY2,costY3,costY4,costY5,costY6,costY7;
    int income1 = 0;
    int income2 = 0;
    int income3 = 0;
    int income4 = 0;
    int income5 = 0;
    int income6 = 0;
    int income7 = 0;
    int cost1 = 0;
    int cost2 = 0;
    int cost3 = 0;
    int cost4 = 0;
    int cost5 = 0;
    int cost6 = 0;
    int cost7 = 0;
    int laborD1 = 0;
    int laborD2 = 0;
    int laborD3 = 0;
    int laborD4 = 0;
    int laborD5 = 0;
    int laborD6 = 0;
    int laborD7 = 0;
    int labor1 = 0;
    int labor2 = 0;
    int labor3 = 0;
    int labor4 = 0;
    int labor5 = 0;
    int labor6 = 0;
    int labor7 = 0;
    int pl1 = 0;
    int pl2 = 0;
    int pl3 = 0;
    int pl4 = 0;
    int pl5 = 0;
    int pl6 = 0;
    int pl7 = 0;
    int gapcost1 = 0;
    int gapcost2 = 0;
    int gapcost3 = 0;
    int gapcost4 = 0;
    int gapcost5 = 0;
    int gapcost6 = 0;
    int gapcost7 = 0;
    int gaplaborD1 = 0;
    int gaplaborD2 = 0;
    int gaplaborD3 = 0;
    int gaplaborD4 = 0;
    int gaplaborD5 = 0;
    int gaplaborD6 = 0;
    int gaplaborD7 = 0;
    int gaplabor1 = 0;
    int gaplabor2 = 0;
    int gaplabor3 = 0;
    int gaplabor4 = 0;
    int gaplabor5 = 0;
    int gaplabor6 = 0;
    int gaplabor7 = 0;
    int gappl1 = 0;
    int gappl2 = 0;
    int gappl3 = 0;
    int gappl4 = 0;
    int gappl5 = 0;
    int gappl6 = 0;
    int gappl7 = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fdp_fragment, container, false);
        plotLB = (TextView)view.findViewById(R.id.plot);
        gaplp = (TextView)view.findViewById(R.id.gapLabelP_field);
        grflp = (TextView)view.findViewById(R.id.graftLabelP_field);
        replp = (TextView)view.findViewById(R.id.replantLabelP_field);
        exslp = (TextView)view.findViewById(R.id.extraSoilLabelP_field);
        limlp = (TextView)view.findViewById(R.id.limeLabelP_field);
        dralp = (TextView)view.findViewById(R.id.drainageLabelP_field);
        fillp = (TextView)view.findViewById(R.id.fillingLabelP_field);
        lablp = (TextView)view.findViewById(R.id.laborLabelP_field);
        lnp = (TextView)view.findViewById(R.id.lnp);
        lcp = (TextView)view.findViewById(R.id.lcp);
        incomeY1 = (TextView) view.findViewById(R.id.incomeY1P);
        incomeY2 = (TextView) view.findViewById(R.id.incomeY2P);
        incomeY3 = (TextView) view.findViewById(R.id.incomeY3P);
        incomeY4 = (TextView) view.findViewById(R.id.incomeY4P);
        incomeY5 = (TextView) view.findViewById(R.id.incomeY5P);
        incomeY6 = (TextView) view.findViewById(R.id.incomeY6P);
        incomeY7 = (TextView) view.findViewById(R.id.incomeY7P);
        costY1 = (TextView) view.findViewById(R.id.costY1P);
        costY2 = (TextView) view.findViewById(R.id.costY2P);
        costY3 = (TextView) view.findViewById(R.id.costY3P);
        costY4 = (TextView) view.findViewById(R.id.costY4P);
        costY5 = (TextView) view.findViewById(R.id.costY5P);
        costY6 = (TextView) view.findViewById(R.id.costY6P);
        costY7 = (TextView) view.findViewById(R.id.costY7P);
        lnpy1 = (TextView)view.findViewById(R.id.manDaysY1P);
        lnpy2 = (TextView)view.findViewById(R.id.manDaysY2P);
        lnpy3 = (TextView)view.findViewById(R.id.manDaysY3P);
        lnpy4 = (TextView)view.findViewById(R.id.manDaysY4P);
        lnpy5 = (TextView)view.findViewById(R.id.manDaysY5P);
        lnpy6 = (TextView)view.findViewById(R.id.manDaysY6P);
        lnpy7 = (TextView)view.findViewById(R.id.manDaysY7P);
        lcpy1= (TextView)view.findViewById(R.id.laborY1P);
        lcpy2= (TextView)view.findViewById(R.id.laborY2P);
        lcpy3= (TextView)view.findViewById(R.id.laborY3P);
        lcpy4= (TextView)view.findViewById(R.id.laborY4P);
        lcpy5= (TextView)view.findViewById(R.id.laborY5P);
        lcpy6= (TextView)view.findViewById(R.id.laborY6P);
        lcpy7= (TextView)view.findViewById(R.id.laborY7P);
        plpy1= (TextView)view.findViewById(R.id.plY1P);
        plpy2= (TextView)view.findViewById(R.id.plY2P);
        plpy3= (TextView)view.findViewById(R.id.plY3P);
        plpy4= (TextView)view.findViewById(R.id.plY4P);
        plpy5= (TextView)view.findViewById(R.id.plY5P);
        plpy6= (TextView)view.findViewById(R.id.plY6P);
        plpy7= (TextView)view.findViewById(R.id.plY7P);
        comment = (EditText)view.findViewById(R.id.comments);
        changeR = (Button)view.findViewById(R.id.change);
        start =(Spinner)view.findViewById(R.id.startP_field);

        final fdpActivity activity = (fdpActivity) getActivity();
        start.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            DecimalFormat dec = new DecimalFormat("IDR ###,###,###");
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(start.getSelectedItem().toString().equals("Year 2")){
                    if(gappl1 > 0){
                        plpy1.setTextColor(Color.parseColor("#29a329"));
                    }else{
                        plpy1.setTextColor(Color.parseColor("#cc0000"));
                    }
                    if(pl1 > 0){
                        plpy2.setTextColor(Color.parseColor("#29a329"));
                    }else{
                        plpy2.setTextColor(Color.parseColor("#cc0000"));
                    }

                    if(pl2 > 0){
                        plpy3.setTextColor(Color.parseColor("#29a329"));
                    }else{
                        plpy3.setTextColor(Color.parseColor("#cc0000"));
                    }

                    if(pl3 > 0){
                        plpy4.setTextColor(Color.parseColor("#29a329"));
                    }else{
                        plpy4.setTextColor(Color.parseColor("#cc0000"));
                    }

                    if(pl4 > 0){
                        plpy5.setTextColor(Color.parseColor("#29a329"));
                    }else{
                        plpy5.setTextColor(Color.parseColor("#cc0000"));
                    }
                    if(pl5 > 0){
                        plpy6.setTextColor(Color.parseColor("#29a329"));
                    }else{
                        plpy6.setTextColor(Color.parseColor("#cc0000"));
                    }
                    if(pl6 > 0){
                        plpy7.setTextColor(Color.parseColor("#29a329"));
                    }else{
                        plpy7.setTextColor(Color.parseColor("#cc0000"));
                    }

                    setText(incomeY1, String.valueOf(dec.format(income1)));
                    setText(incomeY2, String.valueOf(dec.format(income1)));
                    setText(incomeY3, String.valueOf(dec.format(income2)));
                    setText(incomeY4, String.valueOf(dec.format(income3)));
                    setText(incomeY5, String.valueOf(dec.format(income4)));
                    setText(incomeY6, String.valueOf(dec.format(income5)));
                    setText(incomeY7, String.valueOf(dec.format(income6)));
                    setText(costY1, String.valueOf(dec.format(gapcost1)));
                    setText(costY2, String.valueOf(dec.format(cost1)));
                    setText(costY3, String.valueOf(dec.format(cost2)));
                    setText(costY4, String.valueOf(dec.format(cost3)));
                    setText(costY5, String.valueOf(dec.format(cost4)));
                    setText(costY6, String.valueOf(dec.format(cost5)));
                    setText(costY7, String.valueOf(dec.format(cost6)));
                    setText(lnpy1, String.valueOf(gaplaborD1));
                    setText(lnpy2, String.valueOf(laborD1));
                    setText(lnpy3, String.valueOf(laborD2));
                    setText(lnpy4, String.valueOf(laborD3));
                    setText(lnpy5, String.valueOf(laborD4));
                    setText(lnpy6, String.valueOf(laborD5));
                    setText(lnpy7, String.valueOf(laborD6));
                    setText(lcpy1, String.valueOf(dec.format(gaplabor1)));
                    setText(lcpy2, String.valueOf(dec.format(labor1)));
                    setText(lcpy3, String.valueOf(dec.format(labor2)));
                    setText(lcpy4, String.valueOf(dec.format(labor3)));
                    setText(lcpy5, String.valueOf(dec.format(labor4)));
                    setText(lcpy6, String.valueOf(dec.format(labor5)));
                    setText(lcpy7, String.valueOf(dec.format(labor6)));
                    setText(plpy1, String.valueOf(dec.format(gappl1)));
                    setText(plpy2, String.valueOf(dec.format(pl1)));
                    setText(plpy3, String.valueOf(dec.format(pl2)));
                    setText(plpy4, String.valueOf(dec.format(pl3)));
                    setText(plpy5, String.valueOf(dec.format(pl4)));
                    setText(plpy6, String.valueOf(dec.format(pl5)));
                    setText(plpy7, String.valueOf(dec.format(pl6)));
                    activity.calculations();
                }else if (start.getSelectedItem().toString().equals("Year 3")){
                    if(gappl1 > 0){
                        plpy1.setTextColor(Color.parseColor("#29a329"));
                    }else{
                        plpy1.setTextColor(Color.parseColor("#cc0000"));
                    }
                    if(gappl2 > 0){
                        plpy2.setTextColor(Color.parseColor("#29a329"));
                    }else{
                        plpy2.setTextColor(Color.parseColor("#cc0000"));
                    }
                    if(pl1 > 0){
                        plpy3.setTextColor(Color.parseColor("#29a329"));
                    }else{
                        plpy3.setTextColor(Color.parseColor("#cc0000"));
                    }
                    if(pl2 > 0){
                        plpy4.setTextColor(Color.parseColor("#29a329"));
                    }else{
                        plpy4.setTextColor(Color.parseColor("#cc0000"));
                    }
                    if(pl3 > 0){
                        plpy5.setTextColor(Color.parseColor("#29a329"));
                    }else{
                        plpy5.setTextColor(Color.parseColor("#cc0000"));
                    }
                    if(pl4 > 0){
                        plpy6.setTextColor(Color.parseColor("#29a329"));
                    }else{
                        plpy6.setTextColor(Color.parseColor("#cc0000"));
                    }
                    if(pl5 > 0){
                        plpy7.setTextColor(Color.parseColor("#29a329"));
                    }else{
                        plpy7.setTextColor(Color.parseColor("#cc0000"));
                    }

                    setText(incomeY1, String.valueOf(dec.format(income1)));
                    setText(incomeY2, String.valueOf(dec.format(income1)));
                    setText(incomeY3, String.valueOf(dec.format(income1)));
                    setText(incomeY4, String.valueOf(dec.format(income2)));
                    setText(incomeY5, String.valueOf(dec.format(income3)));
                    setText(incomeY6, String.valueOf(dec.format(income4)));
                    setText(incomeY7, String.valueOf(dec.format(income5)));
                    setText(costY1, String.valueOf(dec.format(gapcost1)));
                    setText(costY2, String.valueOf(dec.format(gapcost2)));
                    setText(costY3, String.valueOf(dec.format(cost1)));
                    setText(costY4, String.valueOf(dec.format(cost2)));
                    setText(costY5, String.valueOf(dec.format(cost3)));
                    setText(costY6, String.valueOf(dec.format(cost4)));
                    setText(costY7, String.valueOf(dec.format(cost5)));
                    setText(lnpy1, String.valueOf(gaplaborD1));
                    setText(lnpy2, String.valueOf(gaplaborD2));
                    setText(lnpy3, String.valueOf(laborD1));
                    setText(lnpy4, String.valueOf(laborD2));
                    setText(lnpy5, String.valueOf(laborD3));
                    setText(lnpy6, String.valueOf(laborD4));
                    setText(lnpy7, String.valueOf(laborD5));
                    setText(lcpy1, String.valueOf(dec.format(gaplabor1)));
                    setText(lcpy2, String.valueOf(dec.format(gaplabor2)));
                    setText(lcpy3, String.valueOf(dec.format(labor1)));
                    setText(lcpy4, String.valueOf(dec.format(labor2)));
                    setText(lcpy5, String.valueOf(dec.format(labor3)));
                    setText(lcpy6, String.valueOf(dec.format(labor4)));
                    setText(lcpy7, String.valueOf(dec.format(labor5)));
                    setText(plpy1, String.valueOf(dec.format(gappl1)));
                    setText(plpy2, String.valueOf(dec.format(gappl2)));
                    setText(plpy3, String.valueOf(dec.format(pl1)));
                    setText(plpy4, String.valueOf(dec.format(pl2)));
                    setText(plpy5, String.valueOf(dec.format(pl3)));
                    setText(plpy6, String.valueOf(dec.format(pl4)));
                    setText(plpy7, String.valueOf(dec.format(pl5)));
                    activity.calculations();
                }else if (start.getSelectedItem().toString().equals("Year 4")){
                    if(gappl1 > 0){
                        plpy1.setTextColor(Color.parseColor("#29a329"));
                    }else{
                        plpy1.setTextColor(Color.parseColor("#cc0000"));
                    }
                    if(gappl2 > 0){
                        plpy2.setTextColor(Color.parseColor("#29a329"));
                    }else{
                        plpy2.setTextColor(Color.parseColor("#cc0000"));
                    }
                    if(gappl3 > 0){
                        plpy3.setTextColor(Color.parseColor("#29a329"));
                    }else{
                        plpy3.setTextColor(Color.parseColor("#cc0000"));
                    }

                    if(pl1 > 0){
                        plpy4.setTextColor(Color.parseColor("#29a329"));
                    }else{
                        plpy4.setTextColor(Color.parseColor("#cc0000"));
                    }
                    if(pl2 > 0){
                        plpy5.setTextColor(Color.parseColor("#29a329"));
                    }else{
                        plpy5.setTextColor(Color.parseColor("#cc0000"));
                    }
                    if(pl3 > 0){
                        plpy6.setTextColor(Color.parseColor("#29a329"));
                    }else{
                        plpy6.setTextColor(Color.parseColor("#cc0000"));
                    }
                    if(pl4 > 0){
                        plpy7.setTextColor(Color.parseColor("#29a329"));
                    }else{
                        plpy7.setTextColor(Color.parseColor("#cc0000"));
                    }

                    setText(incomeY1, String.valueOf(dec.format(income1)));
                    setText(incomeY2, String.valueOf(dec.format(income1)));
                    setText(incomeY3, String.valueOf(dec.format(income1)));
                    setText(incomeY4, String.valueOf(dec.format(income1)));
                    setText(incomeY5, String.valueOf(dec.format(income2)));
                    setText(incomeY6, String.valueOf(dec.format(income3)));
                    setText(incomeY7, String.valueOf(dec.format(income4)));
                    setText(costY1, String.valueOf(dec.format(gapcost1)));
                    setText(costY2, String.valueOf(dec.format(gapcost2)));
                    setText(costY3, String.valueOf(dec.format(gapcost3)));
                    setText(costY4, String.valueOf(dec.format(cost1)));
                    setText(costY5, String.valueOf(dec.format(cost2)));
                    setText(costY6, String.valueOf(dec.format(cost3)));
                    setText(costY7, String.valueOf(dec.format(cost4)));
                    setText(lnpy1, String.valueOf(gaplaborD1));
                    setText(lnpy2, String.valueOf(gaplaborD2));
                    setText(lnpy3, String.valueOf(gaplaborD3));
                    setText(lnpy4, String.valueOf(laborD1));
                    setText(lnpy5, String.valueOf(laborD2));
                    setText(lnpy6, String.valueOf(laborD3));
                    setText(lnpy7, String.valueOf(laborD4));
                    setText(lcpy1, String.valueOf(dec.format(gaplabor1)));
                    setText(lcpy2, String.valueOf(dec.format(gaplabor2)));
                    setText(lcpy3, String.valueOf(dec.format(gaplabor3)));
                    setText(lcpy4, String.valueOf(dec.format(labor1)));
                    setText(lcpy5, String.valueOf(dec.format(labor2)));
                    setText(lcpy6, String.valueOf(dec.format(labor3)));
                    setText(lcpy7, String.valueOf(dec.format(labor4)));
                    setText(plpy1, String.valueOf(dec.format(gappl1)));
                    setText(plpy2, String.valueOf(dec.format(gappl2)));
                    setText(plpy3, String.valueOf(dec.format(gappl3)));
                    setText(plpy4, String.valueOf(dec.format(pl1)));
                    setText(plpy5, String.valueOf(dec.format(pl2)));
                    setText(plpy6, String.valueOf(dec.format(pl3)));
                    setText(plpy7, String.valueOf(dec.format(pl4)));
                    activity.calculations();
                }else if (start.getSelectedItem().toString().equals("Year 5")){
                    if(gappl1 > 0){
                        plpy1.setTextColor(Color.parseColor("#29a329"));
                    }else{
                        plpy1.setTextColor(Color.parseColor("#cc0000"));
                    }
                    if(gappl2 > 0){
                        plpy2.setTextColor(Color.parseColor("#29a329"));
                    }else{
                        plpy2.setTextColor(Color.parseColor("#cc0000"));
                    }
                    if(gappl3 > 0){
                        plpy3.setTextColor(Color.parseColor("#29a329"));
                    }else{
                        plpy3.setTextColor(Color.parseColor("#cc0000"));
                    }
                    if(gappl4 > 0){
                        plpy4.setTextColor(Color.parseColor("#29a329"));
                    }else{
                        plpy4.setTextColor(Color.parseColor("#cc0000"));
                    }

                    if(pl1 > 0){
                        plpy5.setTextColor(Color.parseColor("#29a329"));
                    }else{
                        plpy5.setTextColor(Color.parseColor("#cc0000"));
                    }
                    if(pl2 > 0){
                        plpy6.setTextColor(Color.parseColor("#29a329"));
                    }else{
                        plpy6.setTextColor(Color.parseColor("#cc0000"));
                    }
                    if(pl3 > 0){
                        plpy7.setTextColor(Color.parseColor("#29a329"));
                    }else{
                        plpy7.setTextColor(Color.parseColor("#cc0000"));
                    }

                    setText(incomeY1, String.valueOf(dec.format(income1)));
                    setText(incomeY2, String.valueOf(dec.format(income1)));
                    setText(incomeY3, String.valueOf(dec.format(income1)));
                    setText(incomeY4, String.valueOf(dec.format(income1)));
                    setText(incomeY5, String.valueOf(dec.format(income1)));
                    setText(incomeY6, String.valueOf(dec.format(income2)));
                    setText(incomeY7, String.valueOf(dec.format(income3)));
                    setText(costY1, String.valueOf(dec.format(gapcost1)));
                    setText(costY2, String.valueOf(dec.format(gapcost2)));
                    setText(costY3, String.valueOf(dec.format(gapcost3)));
                    setText(costY4, String.valueOf(dec.format(gapcost4)));
                    setText(costY5, String.valueOf(dec.format(cost1)));
                    setText(costY6, String.valueOf(dec.format(cost2)));
                    setText(costY7, String.valueOf(dec.format(cost3)));
                    setText(lnpy1, String.valueOf(gaplaborD1));
                    setText(lnpy2, String.valueOf(gaplaborD2));
                    setText(lnpy3, String.valueOf(gaplaborD3));
                    setText(lnpy4, String.valueOf(gaplaborD4));
                    setText(lnpy5, String.valueOf(laborD1));
                    setText(lnpy6, String.valueOf(laborD2));
                    setText(lnpy7, String.valueOf(laborD3));
                    setText(lcpy1, String.valueOf(dec.format(gaplabor1)));
                    setText(lcpy2, String.valueOf(dec.format(gaplabor2)));
                    setText(lcpy3, String.valueOf(dec.format(gaplabor3)));
                    setText(lcpy4, String.valueOf(dec.format(gaplabor4)));
                    setText(lcpy5, String.valueOf(dec.format(labor1)));
                    setText(lcpy6, String.valueOf(dec.format(labor2)));
                    setText(lcpy7, String.valueOf(dec.format(labor3)));
                    setText(plpy1, String.valueOf(dec.format(gappl1)));
                    setText(plpy2, String.valueOf(dec.format(gappl2)));
                    setText(plpy3, String.valueOf(dec.format(gappl3)));
                    setText(plpy4, String.valueOf(dec.format(gappl4)));
                    setText(plpy5, String.valueOf(dec.format(pl1)));
                    setText(plpy6, String.valueOf(dec.format(pl2)));
                    setText(plpy7, String.valueOf(dec.format(pl3)));
                    activity.calculations();
                }else if (start.getSelectedItem().toString().equals("Year 6")){
                    if(gappl1 > 0){
                        plpy1.setTextColor(Color.parseColor("#29a329"));
                    }else{
                        plpy1.setTextColor(Color.parseColor("#cc0000"));
                    }
                    if(gappl2 > 0){
                        plpy2.setTextColor(Color.parseColor("#29a329"));
                    }else{
                        plpy2.setTextColor(Color.parseColor("#cc0000"));
                    }
                    if(gappl3 > 0){
                        plpy3.setTextColor(Color.parseColor("#29a329"));
                    }else{
                        plpy3.setTextColor(Color.parseColor("#cc0000"));
                    }
                    if(gappl4 > 0){
                        plpy4.setTextColor(Color.parseColor("#29a329"));
                    }else{
                        plpy4.setTextColor(Color.parseColor("#cc0000"));
                    }
                    if(gappl5 > 0){
                        plpy5.setTextColor(Color.parseColor("#29a329"));
                    }else{
                        plpy5.setTextColor(Color.parseColor("#cc0000"));
                    }

                    if(pl1 > 0){
                        plpy6.setTextColor(Color.parseColor("#29a329"));
                    }else{
                        plpy6.setTextColor(Color.parseColor("#cc0000"));
                    }
                    if(pl2 > 0){
                        plpy7.setTextColor(Color.parseColor("#29a329"));
                    }else{
                        plpy7.setTextColor(Color.parseColor("#cc0000"));
                    }

                    setText(incomeY1, String.valueOf(dec.format(income1)));
                    setText(incomeY2, String.valueOf(dec.format(income1)));
                    setText(incomeY3, String.valueOf(dec.format(income1)));
                    setText(incomeY4, String.valueOf(dec.format(income1)));
                    setText(incomeY5, String.valueOf(dec.format(income1)));
                    setText(incomeY6, String.valueOf(dec.format(income1)));
                    setText(incomeY7, String.valueOf(dec.format(income2)));
                    setText(costY1, String.valueOf(dec.format(gapcost1)));
                    setText(costY2, String.valueOf(dec.format(gapcost2)));
                    setText(costY3, String.valueOf(dec.format(gapcost3)));
                    setText(costY4, String.valueOf(dec.format(gapcost4)));
                    setText(costY5, String.valueOf(dec.format(gapcost5)));
                    setText(costY6, String.valueOf(dec.format(cost1)));
                    setText(costY7, String.valueOf(dec.format(cost2)));
                    setText(lnpy1, String.valueOf(gaplaborD1));
                    setText(lnpy2, String.valueOf(gaplaborD2));
                    setText(lnpy3, String.valueOf(gaplaborD3));
                    setText(lnpy4, String.valueOf(gaplaborD4));
                    setText(lnpy5, String.valueOf(gaplaborD5));
                    setText(lnpy6, String.valueOf(laborD1));
                    setText(lnpy7, String.valueOf(laborD2));
                    setText(lcpy1, String.valueOf(dec.format(gaplabor1)));
                    setText(lcpy2, String.valueOf(dec.format(gaplabor2)));
                    setText(lcpy3, String.valueOf(dec.format(gaplabor3)));
                    setText(lcpy4, String.valueOf(dec.format(gaplabor4)));
                    setText(lcpy5, String.valueOf(dec.format(gaplabor5)));
                    setText(lcpy6, String.valueOf(dec.format(labor1)));
                    setText(lcpy7, String.valueOf(dec.format(labor2)));
                    setText(plpy1, String.valueOf(dec.format(gappl1)));
                    setText(plpy2, String.valueOf(dec.format(gappl2)));
                    setText(plpy3, String.valueOf(dec.format(gappl3)));
                    setText(plpy4, String.valueOf(dec.format(gappl4)));
                    setText(plpy5, String.valueOf(dec.format(gappl5)));
                    setText(plpy6, String.valueOf(dec.format(pl1)));
                    setText(plpy7, String.valueOf(dec.format(pl2)));
                    activity.calculations();
                }else if (start.getSelectedItem().toString().equals("Year 7")){
                    if(gappl1 > 0){
                        plpy1.setTextColor(Color.parseColor("#29a329"));
                    }else{
                        plpy1.setTextColor(Color.parseColor("#cc0000"));
                    }
                    if(gappl2 > 0){
                        plpy2.setTextColor(Color.parseColor("#29a329"));
                    }else{
                        plpy2.setTextColor(Color.parseColor("#cc0000"));
                    }
                    if(gappl3 > 0){
                        plpy3.setTextColor(Color.parseColor("#29a329"));
                    }else{
                        plpy3.setTextColor(Color.parseColor("#cc0000"));
                    }
                    if(gappl4 > 0){
                        plpy4.setTextColor(Color.parseColor("#29a329"));
                    }else{
                        plpy4.setTextColor(Color.parseColor("#cc0000"));
                    }
                    if(gappl5 > 0){
                        plpy5.setTextColor(Color.parseColor("#29a329"));
                    }else{
                        plpy5.setTextColor(Color.parseColor("#cc0000"));
                    }
                    if(gappl6 > 0){
                        plpy6.setTextColor(Color.parseColor("#29a329"));
                    }else{
                        plpy6.setTextColor(Color.parseColor("#cc0000"));
                    }

                    if(pl1 > 0){
                        plpy7.setTextColor(Color.parseColor("#29a329"));
                    }else{
                        plpy7.setTextColor(Color.parseColor("#cc0000"));
                    }

                    setText(incomeY1, String.valueOf(dec.format(income1)));
                    setText(incomeY2, String.valueOf(dec.format(income1)));
                    setText(incomeY3, String.valueOf(dec.format(income1)));
                    setText(incomeY4, String.valueOf(dec.format(income1)));
                    setText(incomeY5, String.valueOf(dec.format(income1)));
                    setText(incomeY6, String.valueOf(dec.format(income1)));
                    setText(incomeY7, String.valueOf(dec.format(income1)));
                    setText(costY1, String.valueOf(dec.format(gapcost1)));
                    setText(costY2, String.valueOf(dec.format(gapcost2)));
                    setText(costY3, String.valueOf(dec.format(gapcost3)));
                    setText(costY4, String.valueOf(dec.format(gapcost4)));
                    setText(costY5, String.valueOf(dec.format(gapcost5)));
                    setText(costY6, String.valueOf(dec.format(gapcost6)));
                    setText(costY7, String.valueOf(dec.format(cost1)));
                    setText(lnpy1, String.valueOf(gaplaborD1));
                    setText(lnpy2, String.valueOf(gaplaborD2));
                    setText(lnpy3, String.valueOf(gaplaborD3));
                    setText(lnpy4, String.valueOf(gaplaborD4));
                    setText(lnpy5, String.valueOf(gaplaborD5));
                    setText(lnpy6, String.valueOf(gaplaborD6));
                    setText(lnpy7, String.valueOf(laborD1));
                    setText(lcpy1, String.valueOf(dec.format(gaplabor1)));
                    setText(lcpy2, String.valueOf(dec.format(gaplabor2)));
                    setText(lcpy3, String.valueOf(dec.format(gaplabor3)));
                    setText(lcpy4, String.valueOf(dec.format(gaplabor4)));
                    setText(lcpy5, String.valueOf(dec.format(gaplabor5)));
                    setText(lcpy6, String.valueOf(dec.format(gaplabor6)));
                    setText(lcpy7, String.valueOf(dec.format(labor1)));
                    setText(plpy1, String.valueOf(dec.format(gappl1)));
                    setText(plpy2, String.valueOf(dec.format(gappl2)));
                    setText(plpy3, String.valueOf(dec.format(gappl3)));
                    setText(plpy4, String.valueOf(dec.format(gappl4)));
                    setText(plpy5, String.valueOf(dec.format(gappl5)));
                    setText(plpy6, String.valueOf(dec.format(gappl6)));
                    setText(plpy7, String.valueOf(dec.format(pl1)));
                    activity.calculations();
                }else{
                    if(pl1 > 0){
                        plpy1.setTextColor(Color.parseColor("#29a329"));
                    }else{
                        plpy1.setTextColor(Color.parseColor("#cc0000"));
                    }

                    if(pl2 > 0){
                        plpy2.setTextColor(Color.parseColor("#29a329"));
                    }else{
                        plpy2.setTextColor(Color.parseColor("#cc0000"));
                    }

                    if(pl3 > 0){
                        plpy3.setTextColor(Color.parseColor("#29a329"));
                    }else{
                        plpy3.setTextColor(Color.parseColor("#cc0000"));
                    }

                    if(pl4 > 0){
                        plpy4.setTextColor(Color.parseColor("#29a329"));
                    }else{
                        plpy4.setTextColor(Color.parseColor("#cc0000"));
                    }
                    if(pl5 > 0){
                        plpy5.setTextColor(Color.parseColor("#29a329"));
                    }else{
                        plpy5.setTextColor(Color.parseColor("#cc0000"));
                    }
                    if(pl6 > 0){
                        plpy6.setTextColor(Color.parseColor("#29a329"));
                    }else{
                        plpy6.setTextColor(Color.parseColor("#cc0000"));
                    }
                    if(pl7 > 0){
                        plpy7.setTextColor(Color.parseColor("#29a329"));
                    }else{
                        plpy7.setTextColor(Color.parseColor("#cc0000"));
                    }
                    setText(incomeY1 , String.valueOf(dec.format(income1)));
                    setText(incomeY2, String.valueOf(dec.format(income2)));
                    setText(incomeY3, String.valueOf(dec.format(income3)));
                    setText(incomeY4, String.valueOf(dec.format(income4)));
                    setText(incomeY5, String.valueOf(dec.format(income5)));
                    setText(incomeY6, String.valueOf(dec.format(income6)));
                    setText(incomeY7, String.valueOf(dec.format(income7)));
                    setText(costY1, String.valueOf(dec.format(cost1)));
                    setText(costY2, String.valueOf(dec.format(cost2)));
                    setText(costY3, String.valueOf(dec.format(cost3)));
                    setText(costY4, String.valueOf(dec.format(cost4)));
                    setText(costY5, String.valueOf(dec.format(cost5)));
                    setText(costY6, String.valueOf(dec.format(cost6)));
                    setText(costY7, String.valueOf(dec.format(cost7)));
                    setText(lnpy1, String.valueOf(laborD1));
                    setText(lnpy2, String.valueOf(laborD2));
                    setText(lnpy3, String.valueOf(laborD3));
                    setText(lnpy4, String.valueOf(laborD4));
                    setText(lnpy5, String.valueOf(laborD5));
                    setText(lnpy6, String.valueOf(laborD6));
                    setText(lnpy7, String.valueOf(laborD7));
                    setText(lcpy1, String.valueOf(dec.format(labor1)));
                    setText(lcpy2, String.valueOf(dec.format(labor2)));
                    setText(lcpy3, String.valueOf(dec.format(labor3)));
                    setText(lcpy4, String.valueOf(dec.format(labor4)));
                    setText(lcpy5, String.valueOf(dec.format(labor5)));
                    setText(lcpy6, String.valueOf(dec.format(labor6)));
                    setText(lcpy7, String.valueOf(dec.format(labor7)));
                    setText(plpy1, String.valueOf(dec.format(pl1)));
                    setText(plpy2, String.valueOf(dec.format(pl2)));
                    setText(plpy3, String.valueOf(dec.format(pl3)));
                    setText(plpy4, String.valueOf(dec.format(pl4)));
                    setText(plpy5, String.valueOf(dec.format(pl5)));
                    setText(plpy6, String.valueOf(dec.format(pl6)));
                    setText(plpy7, String.valueOf(dec.format(pl7)));
                    activity.calculations();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private void setText(TextView textField, String text) {
        if (textField != null) {
            textField.setText(text);
        }
    }

    public void setStartYear(String sty){
        startYear = sty;
    }

    public void mainint(String main, final String relat, final String labor, final Double area, final Double avgCost, Integer age){

        changeR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replp.setVisibility(View.GONE);
                grflp.setVisibility(View.VISIBLE);
                gaplp.setVisibility(View.VISIBLE);
                comment.setText("+Change Replant for Grafting "+plotLB.getText()+"+");
                final fdpActivity activity2 = (fdpActivity) getActivity();
                activity2.comt(plotLB.getText().toString());
                if (relat == "extra"){
                    exslp.setVisibility(View.VISIBLE);
                    if (labor == "labor"){
                        laborD1 = (int) ((area * (getResources().getInteger(R.integer.graftY1Total))) + (area * (getResources().getInteger(R.integer.difDaysY1Total))));
                        laborD2 = (int) ((area * (getResources().getInteger(R.integer.graftY2Total))) + (area * (getResources().getInteger(R.integer.difDaysY2Total))));
                        laborD3 = (int) ((area * (getResources().getInteger(R.integer.graftY3Total))) + (area * (getResources().getInteger(R.integer.difDaysY3Total))));
                        laborD4 = (int) ((area * (getResources().getInteger(R.integer.graftY4Total))) + (area * (getResources().getInteger(R.integer.difDaysY4Total))));
                        laborD5 = (int) ((area * (getResources().getInteger(R.integer.graftY5Total))) + (area * (getResources().getInteger(R.integer.difDaysY5Total))));
                        laborD6 = (int) ((area * (getResources().getInteger(R.integer.graftY6Total))) + (area * (getResources().getInteger(R.integer.difDaysY6Total))));
                        laborD7 = (int) ((area * (getResources().getInteger(R.integer.graftY7Total))) + (area * (getResources().getInteger(R.integer.difDaysY7Total))));
                        labor1 = (int) ((area * (getResources().getInteger(R.integer.GraftingLaborY1Total))) + (area * (getResources().getInteger(R.integer.difLaborY1Total))));
                        labor2 = (int) ((area * (getResources().getInteger(R.integer.GraftingLaborY2Total))) + (area * (getResources().getInteger(R.integer.difLaborY2Total))));
                        labor3 = (int) ((area * (getResources().getInteger(R.integer.GraftingLaborY3Total))) + (area * (getResources().getInteger(R.integer.difLaborY3Total))));
                        labor4 = (int) ((area * (getResources().getInteger(R.integer.GraftingLaborY4Total))) + (area * (getResources().getInteger(R.integer.difLaborY4Total))));
                        labor5 = (int) ((area * (getResources().getInteger(R.integer.GraftingLaborY5Total))) + (area * (getResources().getInteger(R.integer.difLaborY5Total))));
                        labor6 = (int) ((area * (getResources().getInteger(R.integer.GraftingLaborY6Total))) + (area * (getResources().getInteger(R.integer.difLaborY6Total))));
                        labor7 = (int) ((area * (getResources().getInteger(R.integer.GraftingLaborY7Total))) + (area * (getResources().getInteger(R.integer.difLaborY7Total))));
                    }
                    cost1 = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY1Total)))+(area * (getResources().getInteger(R.integer.difInputY1Total))));
                    cost2 = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY2Total)))+(area * (getResources().getInteger(R.integer.difInputY2Total))));
                    cost3 = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Total)))+(area * (getResources().getInteger(R.integer.difInputY3Total))));
                    cost4 = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Total)))+(area * (getResources().getInteger(R.integer.difInputY4Total))));
                    cost5 = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Total)))+(area * (getResources().getInteger(R.integer.difInputY5Total))));
                    cost6 = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY6Total)))+(area * (getResources().getInteger(R.integer.difInputY6Total))));
                    cost7 = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY7Total)))+(area * (getResources().getInteger(R.integer.difInputY7Total))));
                }else{
                    if (labor == "labor"){
                        laborD1 = (int) (area * (getResources().getInteger(R.integer.graftY1Total)));
                        laborD2 = (int) (area * (getResources().getInteger(R.integer.graftY2Total)));
                        laborD3 = (int) (area * (getResources().getInteger(R.integer.graftY3Total)));
                        laborD4 = (int) (area * (getResources().getInteger(R.integer.graftY4Total)));
                        laborD5 = (int) (area * (getResources().getInteger(R.integer.graftY5Total)));
                        laborD6 = (int) (area * (getResources().getInteger(R.integer.graftY6Total)));
                        laborD7 = (int) (area * (getResources().getInteger(R.integer.graftY7Total)));
                        labor1 = (int) (area * (getResources().getInteger(R.integer.GraftingLaborY1Total)));
                        labor2 = (int) (area * (getResources().getInteger(R.integer.GraftingLaborY2Total)));
                        labor3 = (int) (area * (getResources().getInteger(R.integer.GraftingLaborY3Total)));
                        labor4 = (int) (area * (getResources().getInteger(R.integer.GraftingLaborY4Total)));
                        labor5 = (int) (area * (getResources().getInteger(R.integer.GraftingLaborY5Total)));
                        labor6 = (int) (area * (getResources().getInteger(R.integer.GraftingLaborY6Total)));
                        labor7 = (int) (area * (getResources().getInteger(R.integer.GraftingLaborY7Total)));
                    }
                    cost1 = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Total)));
                    cost2 = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Total)));
                    cost3 = (int) (area * (getResources().getInteger(R.integer.GraftingInputY3Total)));
                    cost4 = (int) (area * (getResources().getInteger(R.integer.GraftingInputY4Total)));
                    cost5 = (int) (area * (getResources().getInteger(R.integer.GraftingInputY5Total)));
                    cost6 = (int) (area * (getResources().getInteger(R.integer.GraftingInputY6Total)));
                    cost7 = (int) (area * (getResources().getInteger(R.integer.GraftingInputY7Total)));
                }
                income1 =(int) ((area * (getResources().getInteger(R.integer.graftingY1))*avgCost));
                income2 =(int) ((area * (getResources().getInteger(R.integer.graftingY2))*avgCost));
                income3 =(int) ((area * (getResources().getInteger(R.integer.graftingY3))*avgCost));
                income4 =(int) ((area * (getResources().getInteger(R.integer.graftingY4))*avgCost));
                income5 =(int) ((area * (getResources().getInteger(R.integer.graftingY5))*avgCost));
                income6 =(int) ((area * (getResources().getInteger(R.integer.graftingY6))*avgCost));
                income7 =(int) ((area * (getResources().getInteger(R.integer.graftingY7))*avgCost));
            }
        });

        gapcost1 = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Total)));
        gapcost2 = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2Total)));
        gapcost3 = (int) (area * (getResources().getInteger(R.integer.GAPSInputY3Total)));
        gapcost4 = (int) (area * (getResources().getInteger(R.integer.GAPSInputY4Total)));
        gapcost5 = (int) (area * (getResources().getInteger(R.integer.GAPSInputY5Total)));
        gapcost6 = (int) (area * (getResources().getInteger(R.integer.GAPSInputY6Total)));
        gapcost7 = (int) (area * (getResources().getInteger(R.integer.GAPSInputY7Total)));

        if (labor == "labor"){
            gaplaborD1 = (int) (area * (getResources().getInteger(R.integer.gapY1Total)));
            gaplaborD2 = (int) (area * (getResources().getInteger(R.integer.gapY2Total)));
            gaplaborD3 = (int) (area * (getResources().getInteger(R.integer.gapY3Total)));
            gaplaborD4 = (int) (area * (getResources().getInteger(R.integer.gapY4Total)));
            gaplaborD5 = (int) (area * (getResources().getInteger(R.integer.gapY5Total)));
            gaplaborD6 = (int) (area * (getResources().getInteger(R.integer.gapY6Total)));
            gaplaborD7 = (int) (area * (getResources().getInteger(R.integer.gapY7Total)));
            gaplabor1 = (int) (area * (getResources().getInteger(R.integer.GAPSLaborY1Total)));
            gaplabor2 = (int) (area * (getResources().getInteger(R.integer.GAPSLaborY2Total)));
            gaplabor3 = (int) (area * (getResources().getInteger(R.integer.GAPSLaborY3Total)));
            gaplabor4 = (int) (area * (getResources().getInteger(R.integer.GAPSLaborY4Total)));
            gaplabor5 = (int) (area * (getResources().getInteger(R.integer.GAPSLaborY5Total)));
            gaplabor6 = (int) (area * (getResources().getInteger(R.integer.GAPSLaborY6Total)));
            gaplabor7 = (int) (area * (getResources().getInteger(R.integer.GAPSLaborY7Total)));
        }



        DecimalFormat dec = new DecimalFormat("IDR ###,###,###");

        if (main == "replant"){
            replp.setVisibility(View.VISIBLE);
            gaplp.setVisibility(View.VISIBLE);
            if(age<30){
                changeR.setVisibility(View.VISIBLE);
            }
            if (relat == "extra"){
                exslp.setVisibility(View.VISIBLE);
                if (labor == "labor"){
                    laborD1 = (int) ((area * (getResources().getInteger(R.integer.replantY1Total))) + (area * (getResources().getInteger(R.integer.difDaysY1Total))));
                    laborD2 = (int) ((area * (getResources().getInteger(R.integer.replantY2Total))) + (area * (getResources().getInteger(R.integer.difDaysY2Total))));
                    laborD3 = (int) ((area * (getResources().getInteger(R.integer.replantY3Total))) + (area * (getResources().getInteger(R.integer.difDaysY3Total))));
                    laborD4 = (int) ((area * (getResources().getInteger(R.integer.replantY4Total))) + (area * (getResources().getInteger(R.integer.difDaysY4Total))));
                    laborD5 = (int) ((area * (getResources().getInteger(R.integer.replantY5Total))) + (area * (getResources().getInteger(R.integer.difDaysY5Total))));
                    laborD6 = (int) ((area * (getResources().getInteger(R.integer.replantY6Total))) + (area * (getResources().getInteger(R.integer.difDaysY6Total))));
                    laborD7 = (int) ((area * (getResources().getInteger(R.integer.replantY7Total))) + (area * (getResources().getInteger(R.integer.difDaysY7Total))));
                    labor1 = (int) ((area * (getResources().getInteger(R.integer.ReplantingLaborY1Total))) + (area * (getResources().getInteger(R.integer.difLaborY1Total))));
                    labor2 = (int) ((area * (getResources().getInteger(R.integer.ReplantingLaborY2Total))) + (area * (getResources().getInteger(R.integer.difLaborY2Total))));
                    labor3 = (int) ((area * (getResources().getInteger(R.integer.ReplantingLaborY3Total))) + (area * (getResources().getInteger(R.integer.difLaborY3Total))));
                    labor4 = (int) ((area * (getResources().getInteger(R.integer.ReplantingLaborY4Total))) + (area * (getResources().getInteger(R.integer.difLaborY4Total))));
                    labor5 = (int) ((area * (getResources().getInteger(R.integer.ReplantingLaborY5Total))) + (area * (getResources().getInteger(R.integer.difLaborY5Total))));
                    labor6 = (int) ((area * (getResources().getInteger(R.integer.ReplantingLaborY6Total))) + (area * (getResources().getInteger(R.integer.difLaborY6Total))));
                    labor7 = (int) ((area * (getResources().getInteger(R.integer.ReplantingLaborY7Total))) + (area * (getResources().getInteger(R.integer.difLaborY7Total))));
                }
                cost1 = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY1Total)))+(area * (getResources().getInteger(R.integer.difInputY1Total))));
                cost2 = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY2Total)))+(area * (getResources().getInteger(R.integer.difInputY2Total))));
                cost3 = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Total)))+(area * (getResources().getInteger(R.integer.difInputY3Total))));
                cost4 = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Total)))+(area * (getResources().getInteger(R.integer.difInputY4Total))));
                cost5 = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Total)))+(area * (getResources().getInteger(R.integer.difInputY5Total))));
                cost6 = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY6Total)))+(area * (getResources().getInteger(R.integer.difInputY6Total))));
                cost7 = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY7Total)))+(area * (getResources().getInteger(R.integer.difInputY7Total))));
            }else{
                if (labor == "labor"){
                    laborD1 = (int) (area * (getResources().getInteger(R.integer.replantY1Total)));
                    laborD2 = (int) (area * (getResources().getInteger(R.integer.replantY2Total)));
                    laborD3 = (int) (area * (getResources().getInteger(R.integer.replantY3Total)));
                    laborD4 = (int) (area * (getResources().getInteger(R.integer.replantY4Total)));
                    laborD5 = (int) (area * (getResources().getInteger(R.integer.replantY5Total)));
                    laborD6 = (int) (area * (getResources().getInteger(R.integer.replantY6Total)));
                    laborD7 = (int) (area * (getResources().getInteger(R.integer.replantY7Total)));
                    labor1 = (int) (area * (getResources().getInteger(R.integer.ReplantingLaborY1Total)));
                    labor2 = (int) (area * (getResources().getInteger(R.integer.ReplantingLaborY2Total)));
                    labor3 = (int) (area * (getResources().getInteger(R.integer.ReplantingLaborY3Total)));
                    labor4 = (int) (area * (getResources().getInteger(R.integer.ReplantingLaborY4Total)));
                    labor5 = (int) (area * (getResources().getInteger(R.integer.ReplantingLaborY5Total)));
                    labor6 = (int) (area * (getResources().getInteger(R.integer.ReplantingLaborY6Total)));
                    labor7 = (int) (area * (getResources().getInteger(R.integer.ReplantingLaborY7Total)));
                }
                cost1 = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Total)));
                cost2 = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Total)));
                cost3 = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY3Total)));
                cost4 = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY4Total)));
                cost5 = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY5Total)));
                cost6 = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY6Total)));
                cost7 = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY7Total)));
            }
            income1 =(int) ((area * (getResources().getInteger(R.integer.replantingY1))*avgCost));
            income2 =(int) ((area * (getResources().getInteger(R.integer.replantingY2))*avgCost));
            income3 =(int) ((area * (getResources().getInteger(R.integer.replantingY3))*avgCost));
            income4 =(int) ((area * (getResources().getInteger(R.integer.replantingY4))*avgCost));
            income5 =(int) ((area * (getResources().getInteger(R.integer.replantingY5))*avgCost));
            income6 =(int) ((area * (getResources().getInteger(R.integer.replantingY6))*avgCost));
            income7 =(int) ((area * (getResources().getInteger(R.integer.replantingY7))*avgCost));
        }else if (main =="graft"){
            grflp.setVisibility(View.VISIBLE);
            gaplp.setVisibility(View.VISIBLE);
            if (relat == "extra"){
                exslp.setVisibility(View.VISIBLE);
                if (labor == "labor"){
                    laborD1 = (int) ((area * (getResources().getInteger(R.integer.graftY1Total))) + (area * (getResources().getInteger(R.integer.difDaysY1Total))));
                    laborD2 = (int) ((area * (getResources().getInteger(R.integer.graftY2Total))) + (area * (getResources().getInteger(R.integer.difDaysY2Total))));
                    laborD3 = (int) ((area * (getResources().getInteger(R.integer.graftY3Total))) + (area * (getResources().getInteger(R.integer.difDaysY3Total))));
                    laborD4 = (int) ((area * (getResources().getInteger(R.integer.graftY4Total))) + (area * (getResources().getInteger(R.integer.difDaysY4Total))));
                    laborD5 = (int) ((area * (getResources().getInteger(R.integer.graftY5Total))) + (area * (getResources().getInteger(R.integer.difDaysY5Total))));
                    laborD6 = (int) ((area * (getResources().getInteger(R.integer.graftY6Total))) + (area * (getResources().getInteger(R.integer.difDaysY6Total))));
                    laborD7 = (int) ((area * (getResources().getInteger(R.integer.graftY7Total))) + (area * (getResources().getInteger(R.integer.difDaysY7Total))));
                    labor1 = (int) ((area * (getResources().getInteger(R.integer.GraftingLaborY1Total))) + (area * (getResources().getInteger(R.integer.difLaborY1Total))));
                    labor2 = (int) ((area * (getResources().getInteger(R.integer.GraftingLaborY2Total))) + (area * (getResources().getInteger(R.integer.difLaborY2Total))));
                    labor3 = (int) ((area * (getResources().getInteger(R.integer.GraftingLaborY3Total))) + (area * (getResources().getInteger(R.integer.difLaborY3Total))));
                    labor4 = (int) ((area * (getResources().getInteger(R.integer.GraftingLaborY4Total))) + (area * (getResources().getInteger(R.integer.difLaborY4Total))));
                    labor5 = (int) ((area * (getResources().getInteger(R.integer.GraftingLaborY5Total))) + (area * (getResources().getInteger(R.integer.difLaborY5Total))));
                    labor6 = (int) ((area * (getResources().getInteger(R.integer.GraftingLaborY6Total))) + (area * (getResources().getInteger(R.integer.difLaborY6Total))));
                    labor7 = (int) ((area * (getResources().getInteger(R.integer.GraftingLaborY7Total))) + (area * (getResources().getInteger(R.integer.difLaborY7Total))));
                }
                cost1 = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY1Total)))+(area * (getResources().getInteger(R.integer.difInputY1Total))));
                cost2 = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY2Total)))+(area * (getResources().getInteger(R.integer.difInputY2Total))));
                cost3 = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Total)))+(area * (getResources().getInteger(R.integer.difInputY3Total))));
                cost4 = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Total)))+(area * (getResources().getInteger(R.integer.difInputY4Total))));
                cost5 = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Total)))+(area * (getResources().getInteger(R.integer.difInputY5Total))));
                cost6 = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY6Total)))+(area * (getResources().getInteger(R.integer.difInputY6Total))));
                cost7 = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY7Total)))+(area * (getResources().getInteger(R.integer.difInputY7Total))));
            }else{
                if (labor == "labor"){
                    laborD1 = (int) (area * (getResources().getInteger(R.integer.graftY1Total)));
                    laborD2 = (int) (area * (getResources().getInteger(R.integer.graftY2Total)));
                    laborD3 = (int) (area * (getResources().getInteger(R.integer.graftY3Total)));
                    laborD4 = (int) (area * (getResources().getInteger(R.integer.graftY4Total)));
                    laborD5 = (int) (area * (getResources().getInteger(R.integer.graftY5Total)));
                    laborD6 = (int) (area * (getResources().getInteger(R.integer.graftY6Total)));
                    laborD7 = (int) (area * (getResources().getInteger(R.integer.graftY7Total)));
                    labor1 = (int) (area * (getResources().getInteger(R.integer.GraftingLaborY1Total)));
                    labor2 = (int) (area * (getResources().getInteger(R.integer.GraftingLaborY2Total)));
                    labor3 = (int) (area * (getResources().getInteger(R.integer.GraftingLaborY3Total)));
                    labor4 = (int) (area * (getResources().getInteger(R.integer.GraftingLaborY4Total)));
                    labor5 = (int) (area * (getResources().getInteger(R.integer.GraftingLaborY5Total)));
                    labor6 = (int) (area * (getResources().getInteger(R.integer.GraftingLaborY6Total)));
                    labor7 = (int) (area * (getResources().getInteger(R.integer.GraftingLaborY7Total)));
                }
                cost1 = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Total)));
                cost2 = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Total)));
                cost3 = (int) (area * (getResources().getInteger(R.integer.GraftingInputY3Total)));
                cost4 = (int) (area * (getResources().getInteger(R.integer.GraftingInputY4Total)));
                cost5 = (int) (area * (getResources().getInteger(R.integer.GraftingInputY5Total)));
                cost6 = (int) (area * (getResources().getInteger(R.integer.GraftingInputY6Total)));
                cost7 = (int) (area * (getResources().getInteger(R.integer.GraftingInputY7Total)));
            }
            income1 =(int) ((area * (getResources().getInteger(R.integer.graftingY1))*avgCost));
            income2 =(int) ((area * (getResources().getInteger(R.integer.graftingY2))*avgCost));
            income3 =(int) ((area * (getResources().getInteger(R.integer.graftingY3))*avgCost));
            income4 =(int) ((area * (getResources().getInteger(R.integer.graftingY4))*avgCost));
            income5 =(int) ((area * (getResources().getInteger(R.integer.graftingY5))*avgCost));
            income6 =(int) ((area * (getResources().getInteger(R.integer.graftingY6))*avgCost));
            income7 =(int) ((area * (getResources().getInteger(R.integer.graftingY7))*avgCost));

        }else if (main =="extra"){
            exslp.setVisibility(View.VISIBLE);
            gaplp.setVisibility(View.VISIBLE);
            if (labor == "labor"){
                laborD1 = (int) (area * (getResources().getInteger(R.integer.ExtraSoilY1Total)));
                laborD2 = (int) (area * (getResources().getInteger(R.integer.ExtraSoilY2Total)));
                laborD3 = (int) (area * (getResources().getInteger(R.integer.ExtraSoilY3Total)));
                laborD4 = (int) (area * (getResources().getInteger(R.integer.ExtraSoilY4Total)));
                laborD5 = (int) (area * (getResources().getInteger(R.integer.ExtraSoilY5Total)));
                laborD6 = (int) (area * (getResources().getInteger(R.integer.ExtraSoilY6Total)));
                laborD7 = (int) (area * (getResources().getInteger(R.integer.ExtraSoilY7Total)));
                labor1 = (int) (area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Total)));
                labor2 = (int) (area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Total)));
                labor3 = (int) (area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Total)));
                labor4 = (int) (area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Total)));
                labor5 = (int) (area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Total)));
                labor6 = (int) (area * (getResources().getInteger(R.integer.ExtraSoilLaborY6Total)));
                labor7 = (int) (area * (getResources().getInteger(R.integer.ExtraSoilLaborY7Total)));
            }
            cost1 = (int) (area * (getResources().getInteger(R.integer.ExtraSoilInputY1Total)));
            cost2 = (int) (area * (getResources().getInteger(R.integer.ExtraSoilInputY2Total)));
            cost3 = (int) (area * (getResources().getInteger(R.integer.ExtraSoilInputY3Total)));
            cost4 = (int) (area * (getResources().getInteger(R.integer.ExtraSoilInputY4Total)));
            cost5 = (int) (area * (getResources().getInteger(R.integer.ExtraSoilInputY5Total)));
            cost6 = (int) (area * (getResources().getInteger(R.integer.ExtraSoilInputY6Total)));
            cost7 = (int) (area * (getResources().getInteger(R.integer.ExtraSoilInputY7Total)));
            income1 =(int) ((area * (getResources().getInteger(R.integer.extraSoilY1))*avgCost));
            income2 =(int) ((area * (getResources().getInteger(R.integer.extraSoilY2))*avgCost));
            income3 =(int) ((area * (getResources().getInteger(R.integer.extraSoilY3))*avgCost));
            income4 =(int) ((area * (getResources().getInteger(R.integer.extraSoilY4))*avgCost));
            income5 =(int) ((area * (getResources().getInteger(R.integer.extraSoilY5))*avgCost));
            income6 =(int) ((area * (getResources().getInteger(R.integer.extraSoilY6))*avgCost));
            income7 =(int) ((area * (getResources().getInteger(R.integer.extraSoilY7))*avgCost));
        }else{
            gaplp.setVisibility(View.VISIBLE);
            if (relat == "extra"){
                exslp.setVisibility(View.VISIBLE);
                if (labor == "labor"){
                    laborD1 = (int) ((area * (getResources().getInteger(R.integer.gapY1Total))) + (area * (getResources().getInteger(R.integer.difDaysY1Total))));
                    laborD2 = (int) ((area * (getResources().getInteger(R.integer.gapY2Total))) + (area * (getResources().getInteger(R.integer.difDaysY2Total))));
                    laborD3 = (int) ((area * (getResources().getInteger(R.integer.gapY3Total))) + (area * (getResources().getInteger(R.integer.difDaysY3Total))));
                    laborD4 = (int) ((area * (getResources().getInteger(R.integer.gapY4Total))) + (area * (getResources().getInteger(R.integer.difDaysY4Total))));
                    laborD5 = (int) ((area * (getResources().getInteger(R.integer.gapY5Total))) + (area * (getResources().getInteger(R.integer.difDaysY5Total))));
                    laborD6 = (int) ((area * (getResources().getInteger(R.integer.gapY6Total))) + (area * (getResources().getInteger(R.integer.difDaysY6Total))));
                    laborD7 = (int) ((area * (getResources().getInteger(R.integer.gapY7Total))) + (area * (getResources().getInteger(R.integer.difDaysY7Total))));
                    labor1 = (int) ((area * (getResources().getInteger(R.integer.GAPSLaborY1Total))) + (area * (getResources().getInteger(R.integer.difLaborY1Total))));
                    labor2 = (int) ((area * (getResources().getInteger(R.integer.GAPSLaborY2Total))) + (area * (getResources().getInteger(R.integer.difLaborY2Total))));
                    labor3 = (int) ((area * (getResources().getInteger(R.integer.GAPSLaborY3Total))) + (area * (getResources().getInteger(R.integer.difLaborY3Total))));
                    labor4 = (int) ((area * (getResources().getInteger(R.integer.GAPSLaborY4Total))) + (area * (getResources().getInteger(R.integer.difLaborY4Total))));
                    labor5 = (int) ((area * (getResources().getInteger(R.integer.GAPSLaborY5Total))) + (area * (getResources().getInteger(R.integer.difLaborY5Total))));
                    labor6 = (int) ((area * (getResources().getInteger(R.integer.GAPSLaborY6Total))) + (area * (getResources().getInteger(R.integer.difLaborY6Total))));
                    labor7 = (int) ((area * (getResources().getInteger(R.integer.GAPSLaborY1Total))) + (area * (getResources().getInteger(R.integer.difLaborY7Total))));
                }
                cost1 = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Total)))+(area * (getResources().getInteger(R.integer.difInputY1Total))));
                cost2 = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY2Total)))+(area * (getResources().getInteger(R.integer.difInputY2Total))));
                cost3 = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Total)))+(area * (getResources().getInteger(R.integer.difInputY3Total))));
                cost4 = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Total)))+(area * (getResources().getInteger(R.integer.difInputY4Total))));
                cost5 = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Total)))+(area * (getResources().getInteger(R.integer.difInputY5Total))));
                cost6 = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY6Total)))+(area * (getResources().getInteger(R.integer.difInputY6Total))));
                cost7 = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY7Total)))+(area * (getResources().getInteger(R.integer.difInputY7Total))));
            }else{
                if (labor == "labor"){
                    laborD1 = (int) (area * (getResources().getInteger(R.integer.gapY1Total)));
                    laborD2 = (int) (area * (getResources().getInteger(R.integer.gapY2Total)));
                    laborD3 = (int) (area * (getResources().getInteger(R.integer.gapY3Total)));
                    laborD4 = (int) (area * (getResources().getInteger(R.integer.gapY4Total)));
                    laborD5 = (int) (area * (getResources().getInteger(R.integer.gapY5Total)));
                    laborD6 = (int) (area * (getResources().getInteger(R.integer.gapY6Total)));
                    laborD7 = (int) (area * (getResources().getInteger(R.integer.gapY7Total)));
                    labor1 = (int) (area * (getResources().getInteger(R.integer.GAPSLaborY1Total)));
                    labor2 = (int) (area * (getResources().getInteger(R.integer.GAPSLaborY2Total)));
                    labor3 = (int) (area * (getResources().getInteger(R.integer.GAPSLaborY3Total)));
                    labor4 = (int) (area * (getResources().getInteger(R.integer.GAPSLaborY4Total)));
                    labor5 = (int) (area * (getResources().getInteger(R.integer.GAPSLaborY5Total)));
                    labor6 = (int) (area * (getResources().getInteger(R.integer.GAPSLaborY6Total)));
                    labor7 = (int) (area * (getResources().getInteger(R.integer.GAPSLaborY7Total)));
                }
                cost1 = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Total)));
                cost2 = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2Total)));
                cost3 = (int) (area * (getResources().getInteger(R.integer.GAPSInputY3Total)));
                cost4 = (int) (area * (getResources().getInteger(R.integer.GAPSInputY4Total)));
                cost5 = (int) (area * (getResources().getInteger(R.integer.GAPSInputY5Total)));
                cost6 = (int) (area * (getResources().getInteger(R.integer.GAPSInputY6Total)));
                cost7 = (int) (area * (getResources().getInteger(R.integer.GAPSInputY7Total)));
            }
            income1 =(int) ((area * (getResources().getInteger(R.integer.gapsY1))*avgCost));
            income2 =(int) ((area * (getResources().getInteger(R.integer.gapsY2))*avgCost));
            income3 =(int) ((area * (getResources().getInteger(R.integer.gapsY3))*avgCost));
            income4 =(int) ((area * (getResources().getInteger(R.integer.gapsY4))*avgCost));
            income5 =(int) ((area * (getResources().getInteger(R.integer.gapsY5))*avgCost));
            income6 =(int) ((area * (getResources().getInteger(R.integer.gapsY6))*avgCost));
            income7 =(int) ((area * (getResources().getInteger(R.integer.gapsY7))*avgCost));
        }

        pl1= income1-(cost1+labor1);
        pl2= income2-(cost2+labor2);
        pl3= income3-(cost3+labor3);
        pl4= income4-(cost4+labor4);
        pl5= income5-(cost5+labor5);
        pl6= income6-(cost6+labor6);
        pl7= income7-(cost7+labor7);

        gappl1 = income1-(gapcost1+gaplabor1);
        gappl2 = income2-(gapcost2+gaplabor2);
        gappl3 = income3-(gapcost3+gaplabor3);
        gappl4 = income4-(gapcost4+gaplabor4);
        gappl5 = income5-(gapcost5+gaplabor5);
        gappl6 = income6-(gapcost6+gaplabor6);
        gappl7 = income7-(gapcost7+gaplabor7);

        if (startYear.equals("N/A")||startYear.equals("Year 1") ){
            if(pl1 > 0){
                plpy1.setTextColor(Color.parseColor("#29a329"));
            }else{
                plpy1.setTextColor(Color.parseColor("#cc0000"));
            }

            if(pl2 > 0){
                plpy2.setTextColor(Color.parseColor("#29a329"));
            }else{
                plpy2.setTextColor(Color.parseColor("#cc0000"));
            }

            if(pl3 > 0){
                plpy3.setTextColor(Color.parseColor("#29a329"));
            }else{
                plpy3.setTextColor(Color.parseColor("#cc0000"));
            }

            if(pl4 > 0){
                plpy4.setTextColor(Color.parseColor("#29a329"));
            }else{
                plpy4.setTextColor(Color.parseColor("#cc0000"));
            }
            if(pl5 > 0){
                plpy5.setTextColor(Color.parseColor("#29a329"));
            }else{
                plpy5.setTextColor(Color.parseColor("#cc0000"));
            }
            if(pl6 > 0){
                plpy6.setTextColor(Color.parseColor("#29a329"));
            }else{
                plpy6.setTextColor(Color.parseColor("#cc0000"));
            }
            if(pl7 > 0){
                plpy7.setTextColor(Color.parseColor("#29a329"));
            }else{
                plpy7.setTextColor(Color.parseColor("#cc0000"));
            }
            setText(incomeY1 , String.valueOf(dec.format(income1)));
            setText(incomeY2, String.valueOf(dec.format(income2)));
            setText(incomeY3, String.valueOf(dec.format(income3)));
            setText(incomeY4, String.valueOf(dec.format(income4)));
            setText(incomeY5, String.valueOf(dec.format(income5)));
            setText(incomeY6, String.valueOf(dec.format(income6)));
            setText(incomeY7, String.valueOf(dec.format(income7)));
            setText(costY1, String.valueOf(dec.format(cost1)));
            setText(costY2, String.valueOf(dec.format(cost2)));
            setText(costY3, String.valueOf(dec.format(cost3)));
            setText(costY4, String.valueOf(dec.format(cost4)));
            setText(costY5, String.valueOf(dec.format(cost5)));
            setText(costY6, String.valueOf(dec.format(cost6)));
            setText(costY7, String.valueOf(dec.format(cost7)));
            setText(lnpy1, String.valueOf(laborD1));
            setText(lnpy2, String.valueOf(laborD2));
            setText(lnpy3, String.valueOf(laborD3));
            setText(lnpy4, String.valueOf(laborD4));
            setText(lnpy5, String.valueOf(laborD5));
            setText(lnpy6, String.valueOf(laborD6));
            setText(lnpy7, String.valueOf(laborD7));
            setText(lcpy1, String.valueOf(dec.format(labor1)));
            setText(lcpy2, String.valueOf(dec.format(labor2)));
            setText(lcpy3, String.valueOf(dec.format(labor3)));
            setText(lcpy4, String.valueOf(dec.format(labor4)));
            setText(lcpy5, String.valueOf(dec.format(labor5)));
            setText(lcpy6, String.valueOf(dec.format(labor6)));
            setText(lcpy7, String.valueOf(dec.format(labor7)));
            setText(plpy1, String.valueOf(dec.format(pl1)));
            setText(plpy2, String.valueOf(dec.format(pl2)));
            setText(plpy3, String.valueOf(dec.format(pl3)));
            setText(plpy4, String.valueOf(dec.format(pl4)));
            setText(plpy5, String.valueOf(dec.format(pl5)));
            setText(plpy6, String.valueOf(dec.format(pl6)));
            setText(plpy7, String.valueOf(dec.format(pl7)));
        }else if (startYear.equals("Year 2")){
            if(gappl1 > 0){
                plpy1.setTextColor(Color.parseColor("#29a329"));
            }else{
                plpy1.setTextColor(Color.parseColor("#cc0000"));
            }
            if(pl1 > 0){
                plpy2.setTextColor(Color.parseColor("#29a329"));
            }else{
                plpy2.setTextColor(Color.parseColor("#cc0000"));
            }

            if(pl2 > 0){
                plpy3.setTextColor(Color.parseColor("#29a329"));
            }else{
                plpy3.setTextColor(Color.parseColor("#cc0000"));
            }

            if(pl3 > 0){
                plpy4.setTextColor(Color.parseColor("#29a329"));
            }else{
                plpy4.setTextColor(Color.parseColor("#cc0000"));
            }

            if(pl4 > 0){
                plpy5.setTextColor(Color.parseColor("#29a329"));
            }else{
                plpy5.setTextColor(Color.parseColor("#cc0000"));
            }
            if(pl5 > 0){
                plpy6.setTextColor(Color.parseColor("#29a329"));
            }else{
                plpy6.setTextColor(Color.parseColor("#cc0000"));
            }
            if(pl6 > 0){
                plpy7.setTextColor(Color.parseColor("#29a329"));
            }else{
                plpy7.setTextColor(Color.parseColor("#cc0000"));
            }

            setText(incomeY1, String.valueOf(dec.format(income1)));
            setText(incomeY2, String.valueOf(dec.format(income1)));
            setText(incomeY3, String.valueOf(dec.format(income2)));
            setText(incomeY4, String.valueOf(dec.format(income3)));
            setText(incomeY5, String.valueOf(dec.format(income4)));
            setText(incomeY6, String.valueOf(dec.format(income5)));
            setText(incomeY7, String.valueOf(dec.format(income6)));
            setText(costY1, String.valueOf(dec.format(gapcost1)));
            setText(costY2, String.valueOf(dec.format(cost1)));
            setText(costY3, String.valueOf(dec.format(cost2)));
            setText(costY4, String.valueOf(dec.format(cost3)));
            setText(costY5, String.valueOf(dec.format(cost4)));
            setText(costY6, String.valueOf(dec.format(cost5)));
            setText(costY7, String.valueOf(dec.format(cost6)));
            setText(lnpy1, String.valueOf(gaplaborD1));
            setText(lnpy2, String.valueOf(laborD1));
            setText(lnpy3, String.valueOf(laborD2));
            setText(lnpy4, String.valueOf(laborD3));
            setText(lnpy5, String.valueOf(laborD4));
            setText(lnpy6, String.valueOf(laborD5));
            setText(lnpy7, String.valueOf(laborD6));
            setText(lcpy1, String.valueOf(dec.format(gaplabor1)));
            setText(lcpy2, String.valueOf(dec.format(labor1)));
            setText(lcpy3, String.valueOf(dec.format(labor2)));
            setText(lcpy4, String.valueOf(dec.format(labor3)));
            setText(lcpy5, String.valueOf(dec.format(labor4)));
            setText(lcpy6, String.valueOf(dec.format(labor5)));
            setText(lcpy7, String.valueOf(dec.format(labor6)));
            setText(plpy1, String.valueOf(dec.format(gappl1)));
            setText(plpy2, String.valueOf(dec.format(pl1)));
            setText(plpy3, String.valueOf(dec.format(pl2)));
            setText(plpy4, String.valueOf(dec.format(pl3)));
            setText(plpy5, String.valueOf(dec.format(pl4)));
            setText(plpy6, String.valueOf(dec.format(pl5)));
            setText(plpy7, String.valueOf(dec.format(pl6)));
        }else if (startYear.equals("Year 3")){
            if(gappl1 > 0){
                plpy1.setTextColor(Color.parseColor("#29a329"));
            }else{
                plpy1.setTextColor(Color.parseColor("#cc0000"));
            }
            if(gappl2 > 0){
                plpy2.setTextColor(Color.parseColor("#29a329"));
            }else{
                plpy2.setTextColor(Color.parseColor("#cc0000"));
            }
            if(pl1 > 0){
                plpy3.setTextColor(Color.parseColor("#29a329"));
            }else{
                plpy3.setTextColor(Color.parseColor("#cc0000"));
            }
            if(pl2 > 0){
                plpy4.setTextColor(Color.parseColor("#29a329"));
            }else{
                plpy4.setTextColor(Color.parseColor("#cc0000"));
            }
            if(pl3 > 0){
                plpy5.setTextColor(Color.parseColor("#29a329"));
            }else{
                plpy5.setTextColor(Color.parseColor("#cc0000"));
            }
            if(pl4 > 0){
                plpy6.setTextColor(Color.parseColor("#29a329"));
            }else{
                plpy6.setTextColor(Color.parseColor("#cc0000"));
            }
            if(pl5 > 0){
                plpy7.setTextColor(Color.parseColor("#29a329"));
            }else{
                plpy7.setTextColor(Color.parseColor("#cc0000"));
            }

            setText(incomeY1, String.valueOf(dec.format(income1)));
            setText(incomeY2, String.valueOf(dec.format(income1)));
            setText(incomeY3, String.valueOf(dec.format(income1)));
            setText(incomeY4, String.valueOf(dec.format(income2)));
            setText(incomeY5, String.valueOf(dec.format(income3)));
            setText(incomeY6, String.valueOf(dec.format(income4)));
            setText(incomeY7, String.valueOf(dec.format(income5)));
            setText(costY1, String.valueOf(dec.format(gapcost1)));
            setText(costY2, String.valueOf(dec.format(gapcost2)));
            setText(costY3, String.valueOf(dec.format(cost1)));
            setText(costY4, String.valueOf(dec.format(cost2)));
            setText(costY5, String.valueOf(dec.format(cost3)));
            setText(costY6, String.valueOf(dec.format(cost4)));
            setText(costY7, String.valueOf(dec.format(cost5)));
            setText(lnpy1, String.valueOf(gaplaborD1));
            setText(lnpy2, String.valueOf(gaplaborD2));
            setText(lnpy3, String.valueOf(laborD1));
            setText(lnpy4, String.valueOf(laborD2));
            setText(lnpy5, String.valueOf(laborD3));
            setText(lnpy6, String.valueOf(laborD4));
            setText(lnpy7, String.valueOf(laborD5));
            setText(lcpy1, String.valueOf(dec.format(gaplabor1)));
            setText(lcpy2, String.valueOf(dec.format(gaplabor2)));
            setText(lcpy3, String.valueOf(dec.format(labor1)));
            setText(lcpy4, String.valueOf(dec.format(labor2)));
            setText(lcpy5, String.valueOf(dec.format(labor3)));
            setText(lcpy6, String.valueOf(dec.format(labor4)));
            setText(lcpy7, String.valueOf(dec.format(labor5)));
            setText(plpy1, String.valueOf(dec.format(gappl1)));
            setText(plpy2, String.valueOf(dec.format(gappl2)));
            setText(plpy3, String.valueOf(dec.format(pl1)));
            setText(plpy4, String.valueOf(dec.format(pl2)));
            setText(plpy5, String.valueOf(dec.format(pl3)));
            setText(plpy6, String.valueOf(dec.format(pl4)));
            setText(plpy7, String.valueOf(dec.format(pl5)));
        }else if (startYear.equals("Year 4")){
            if(gappl1 > 0){
                plpy1.setTextColor(Color.parseColor("#29a329"));
            }else{
                plpy1.setTextColor(Color.parseColor("#cc0000"));
            }
            if(gappl2 > 0){
                plpy2.setTextColor(Color.parseColor("#29a329"));
            }else{
                plpy2.setTextColor(Color.parseColor("#cc0000"));
            }
            if(gappl3 > 0){
                plpy3.setTextColor(Color.parseColor("#29a329"));
            }else{
                plpy3.setTextColor(Color.parseColor("#cc0000"));
            }

            if(pl1 > 0){
                plpy4.setTextColor(Color.parseColor("#29a329"));
            }else{
                plpy4.setTextColor(Color.parseColor("#cc0000"));
            }
            if(pl2 > 0){
                plpy5.setTextColor(Color.parseColor("#29a329"));
            }else{
                plpy5.setTextColor(Color.parseColor("#cc0000"));
            }
            if(pl3 > 0){
                plpy6.setTextColor(Color.parseColor("#29a329"));
            }else{
                plpy6.setTextColor(Color.parseColor("#cc0000"));
            }
            if(pl4 > 0){
                plpy7.setTextColor(Color.parseColor("#29a329"));
            }else{
                plpy7.setTextColor(Color.parseColor("#cc0000"));
            }

            setText(incomeY1, String.valueOf(dec.format(income1)));
            setText(incomeY2, String.valueOf(dec.format(income1)));
            setText(incomeY3, String.valueOf(dec.format(income1)));
            setText(incomeY4, String.valueOf(dec.format(income1)));
            setText(incomeY5, String.valueOf(dec.format(income2)));
            setText(incomeY6, String.valueOf(dec.format(income3)));
            setText(incomeY7, String.valueOf(dec.format(income4)));
            setText(costY1, String.valueOf(dec.format(gapcost1)));
            setText(costY2, String.valueOf(dec.format(gapcost2)));
            setText(costY3, String.valueOf(dec.format(gapcost3)));
            setText(costY4, String.valueOf(dec.format(cost1)));
            setText(costY5, String.valueOf(dec.format(cost2)));
            setText(costY6, String.valueOf(dec.format(cost3)));
            setText(costY7, String.valueOf(dec.format(cost4)));
            setText(lnpy1, String.valueOf(gaplaborD1));
            setText(lnpy2, String.valueOf(gaplaborD2));
            setText(lnpy3, String.valueOf(gaplaborD3));
            setText(lnpy4, String.valueOf(laborD1));
            setText(lnpy5, String.valueOf(laborD2));
            setText(lnpy6, String.valueOf(laborD3));
            setText(lnpy7, String.valueOf(laborD4));
            setText(lcpy1, String.valueOf(dec.format(gaplabor1)));
            setText(lcpy2, String.valueOf(dec.format(gaplabor2)));
            setText(lcpy3, String.valueOf(dec.format(gaplabor3)));
            setText(lcpy4, String.valueOf(dec.format(labor1)));
            setText(lcpy5, String.valueOf(dec.format(labor2)));
            setText(lcpy6, String.valueOf(dec.format(labor3)));
            setText(lcpy7, String.valueOf(dec.format(labor4)));
            setText(plpy1, String.valueOf(dec.format(gappl1)));
            setText(plpy2, String.valueOf(dec.format(gappl2)));
            setText(plpy3, String.valueOf(dec.format(gappl3)));
            setText(plpy4, String.valueOf(dec.format(pl1)));
            setText(plpy5, String.valueOf(dec.format(pl2)));
            setText(plpy6, String.valueOf(dec.format(pl3)));
            setText(plpy7, String.valueOf(dec.format(pl4)));
        }else if (startYear.equals("Year 5")){
            if(gappl1 > 0){
                plpy1.setTextColor(Color.parseColor("#29a329"));
            }else{
                plpy1.setTextColor(Color.parseColor("#cc0000"));
            }
            if(gappl2 > 0){
                plpy2.setTextColor(Color.parseColor("#29a329"));
            }else{
                plpy2.setTextColor(Color.parseColor("#cc0000"));
            }
            if(gappl3 > 0){
                plpy3.setTextColor(Color.parseColor("#29a329"));
            }else{
                plpy3.setTextColor(Color.parseColor("#cc0000"));
            }
            if(gappl4 > 0){
                plpy4.setTextColor(Color.parseColor("#29a329"));
            }else{
                plpy4.setTextColor(Color.parseColor("#cc0000"));
            }

            if(pl1 > 0){
                plpy5.setTextColor(Color.parseColor("#29a329"));
            }else{
                plpy5.setTextColor(Color.parseColor("#cc0000"));
            }
            if(pl2 > 0){
                plpy6.setTextColor(Color.parseColor("#29a329"));
            }else{
                plpy6.setTextColor(Color.parseColor("#cc0000"));
            }
            if(pl3 > 0){
                plpy7.setTextColor(Color.parseColor("#29a329"));
            }else{
                plpy7.setTextColor(Color.parseColor("#cc0000"));
            }

            setText(incomeY1, String.valueOf(dec.format(income1)));
            setText(incomeY2, String.valueOf(dec.format(income1)));
            setText(incomeY3, String.valueOf(dec.format(income1)));
            setText(incomeY4, String.valueOf(dec.format(income1)));
            setText(incomeY5, String.valueOf(dec.format(income1)));
            setText(incomeY6, String.valueOf(dec.format(income2)));
            setText(incomeY7, String.valueOf(dec.format(income3)));
            setText(costY1, String.valueOf(dec.format(gapcost1)));
            setText(costY2, String.valueOf(dec.format(gapcost2)));
            setText(costY3, String.valueOf(dec.format(gapcost3)));
            setText(costY4, String.valueOf(dec.format(gapcost4)));
            setText(costY5, String.valueOf(dec.format(cost1)));
            setText(costY6, String.valueOf(dec.format(cost2)));
            setText(costY7, String.valueOf(dec.format(cost3)));
            setText(lnpy1, String.valueOf(gaplaborD1));
            setText(lnpy2, String.valueOf(gaplaborD2));
            setText(lnpy3, String.valueOf(gaplaborD3));
            setText(lnpy4, String.valueOf(gaplaborD4));
            setText(lnpy5, String.valueOf(laborD1));
            setText(lnpy6, String.valueOf(laborD2));
            setText(lnpy7, String.valueOf(laborD3));
            setText(lcpy1, String.valueOf(dec.format(gaplabor1)));
            setText(lcpy2, String.valueOf(dec.format(gaplabor2)));
            setText(lcpy3, String.valueOf(dec.format(gaplabor3)));
            setText(lcpy4, String.valueOf(dec.format(gaplabor4)));
            setText(lcpy5, String.valueOf(dec.format(labor1)));
            setText(lcpy6, String.valueOf(dec.format(labor2)));
            setText(lcpy7, String.valueOf(dec.format(labor3)));
            setText(plpy1, String.valueOf(dec.format(gappl1)));
            setText(plpy2, String.valueOf(dec.format(gappl2)));
            setText(plpy3, String.valueOf(dec.format(gappl3)));
            setText(plpy4, String.valueOf(dec.format(gappl4)));
            setText(plpy5, String.valueOf(dec.format(pl1)));
            setText(plpy6, String.valueOf(dec.format(pl2)));
            setText(plpy7, String.valueOf(dec.format(pl3)));
        }else if (startYear.equals("Year 6")){
            if(gappl1 > 0){
                plpy1.setTextColor(Color.parseColor("#29a329"));
            }else{
                plpy1.setTextColor(Color.parseColor("#cc0000"));
            }
            if(gappl2 > 0){
                plpy2.setTextColor(Color.parseColor("#29a329"));
            }else{
                plpy2.setTextColor(Color.parseColor("#cc0000"));
            }
            if(gappl3 > 0){
                plpy3.setTextColor(Color.parseColor("#29a329"));
            }else{
                plpy3.setTextColor(Color.parseColor("#cc0000"));
            }
            if(gappl4 > 0){
                plpy4.setTextColor(Color.parseColor("#29a329"));
            }else{
                plpy4.setTextColor(Color.parseColor("#cc0000"));
            }
            if(gappl5 > 0){
                plpy5.setTextColor(Color.parseColor("#29a329"));
            }else{
                plpy5.setTextColor(Color.parseColor("#cc0000"));
            }

            if(pl1 > 0){
                plpy6.setTextColor(Color.parseColor("#29a329"));
            }else{
                plpy6.setTextColor(Color.parseColor("#cc0000"));
            }
            if(pl2 > 0){
                plpy7.setTextColor(Color.parseColor("#29a329"));
            }else{
                plpy7.setTextColor(Color.parseColor("#cc0000"));
            }

            setText(incomeY1, String.valueOf(dec.format(income1)));
            setText(incomeY2, String.valueOf(dec.format(income1)));
            setText(incomeY3, String.valueOf(dec.format(income1)));
            setText(incomeY4, String.valueOf(dec.format(income1)));
            setText(incomeY5, String.valueOf(dec.format(income1)));
            setText(incomeY6, String.valueOf(dec.format(income1)));
            setText(incomeY7, String.valueOf(dec.format(income2)));
            setText(costY1, String.valueOf(dec.format(gapcost1)));
            setText(costY2, String.valueOf(dec.format(gapcost2)));
            setText(costY3, String.valueOf(dec.format(gapcost3)));
            setText(costY4, String.valueOf(dec.format(gapcost4)));
            setText(costY5, String.valueOf(dec.format(gapcost5)));
            setText(costY6, String.valueOf(dec.format(cost1)));
            setText(costY7, String.valueOf(dec.format(cost2)));
            setText(lnpy1, String.valueOf(gaplaborD1));
            setText(lnpy2, String.valueOf(gaplaborD2));
            setText(lnpy3, String.valueOf(gaplaborD3));
            setText(lnpy4, String.valueOf(gaplaborD4));
            setText(lnpy5, String.valueOf(gaplaborD5));
            setText(lnpy6, String.valueOf(laborD1));
            setText(lnpy7, String.valueOf(laborD2));
            setText(lcpy1, String.valueOf(dec.format(gaplabor1)));
            setText(lcpy2, String.valueOf(dec.format(gaplabor2)));
            setText(lcpy3, String.valueOf(dec.format(gaplabor3)));
            setText(lcpy4, String.valueOf(dec.format(gaplabor4)));
            setText(lcpy5, String.valueOf(dec.format(gaplabor5)));
            setText(lcpy6, String.valueOf(dec.format(labor1)));
            setText(lcpy7, String.valueOf(dec.format(labor2)));
            setText(plpy1, String.valueOf(dec.format(gappl1)));
            setText(plpy2, String.valueOf(dec.format(gappl2)));
            setText(plpy3, String.valueOf(dec.format(gappl3)));
            setText(plpy4, String.valueOf(dec.format(gappl4)));
            setText(plpy5, String.valueOf(dec.format(gappl5)));
            setText(plpy6, String.valueOf(dec.format(pl1)));
            setText(plpy7, String.valueOf(dec.format(pl2)));
        }else if (startYear.equals("Year 7")){
            if(gappl1 > 0){
                plpy1.setTextColor(Color.parseColor("#29a329"));
            }else{
                plpy1.setTextColor(Color.parseColor("#cc0000"));
            }
            if(gappl2 > 0){
                plpy2.setTextColor(Color.parseColor("#29a329"));
            }else{
                plpy2.setTextColor(Color.parseColor("#cc0000"));
            }
            if(gappl3 > 0){
                plpy3.setTextColor(Color.parseColor("#29a329"));
            }else{
                plpy3.setTextColor(Color.parseColor("#cc0000"));
            }
            if(gappl4 > 0){
                plpy4.setTextColor(Color.parseColor("#29a329"));
            }else{
                plpy4.setTextColor(Color.parseColor("#cc0000"));
            }
            if(gappl5 > 0){
                plpy5.setTextColor(Color.parseColor("#29a329"));
            }else{
                plpy5.setTextColor(Color.parseColor("#cc0000"));
            }
            if(gappl6 > 0){
                plpy6.setTextColor(Color.parseColor("#29a329"));
            }else{
                plpy6.setTextColor(Color.parseColor("#cc0000"));
            }

            if(pl1 > 0){
                plpy7.setTextColor(Color.parseColor("#29a329"));
            }else{
                plpy7.setTextColor(Color.parseColor("#cc0000"));
            }

            setText(incomeY1, String.valueOf(dec.format(income1)));
            setText(incomeY2, String.valueOf(dec.format(income1)));
            setText(incomeY3, String.valueOf(dec.format(income1)));
            setText(incomeY4, String.valueOf(dec.format(income1)));
            setText(incomeY5, String.valueOf(dec.format(income1)));
            setText(incomeY6, String.valueOf(dec.format(income1)));
            setText(incomeY7, String.valueOf(dec.format(income1)));
            setText(costY1, String.valueOf(dec.format(gapcost1)));
            setText(costY2, String.valueOf(dec.format(gapcost2)));
            setText(costY3, String.valueOf(dec.format(gapcost3)));
            setText(costY4, String.valueOf(dec.format(gapcost4)));
            setText(costY5, String.valueOf(dec.format(gapcost5)));
            setText(costY6, String.valueOf(dec.format(gapcost6)));
            setText(costY7, String.valueOf(dec.format(cost1)));
            setText(lnpy1, String.valueOf(gaplaborD1));
            setText(lnpy2, String.valueOf(gaplaborD2));
            setText(lnpy3, String.valueOf(gaplaborD3));
            setText(lnpy4, String.valueOf(gaplaborD4));
            setText(lnpy5, String.valueOf(gaplaborD5));
            setText(lnpy6, String.valueOf(gaplaborD6));
            setText(lnpy7, String.valueOf(laborD1));
            setText(lcpy1, String.valueOf(dec.format(gaplabor1)));
            setText(lcpy2, String.valueOf(dec.format(gaplabor2)));
            setText(lcpy3, String.valueOf(dec.format(gaplabor3)));
            setText(lcpy4, String.valueOf(dec.format(gaplabor4)));
            setText(lcpy5, String.valueOf(dec.format(gaplabor5)));
            setText(lcpy6, String.valueOf(dec.format(gaplabor6)));
            setText(lcpy7, String.valueOf(dec.format(labor1)));
            setText(plpy1, String.valueOf(dec.format(gappl1)));
            setText(plpy2, String.valueOf(dec.format(gappl2)));
            setText(plpy3, String.valueOf(dec.format(gappl3)));
            setText(plpy4, String.valueOf(dec.format(gappl4)));
            setText(plpy5, String.valueOf(dec.format(gappl5)));
            setText(plpy6, String.valueOf(dec.format(gappl6)));
            setText(plpy7, String.valueOf(dec.format(pl1)));
        }
    }

    public void other(String otherint){
        if (otherint == "labor"){
            lablp.setVisibility(View.VISIBLE);
            lnp.setVisibility(View.VISIBLE);
            lcp.setVisibility(View.VISIBLE);
            lnpy1.setVisibility(View.VISIBLE);
            lnpy2.setVisibility(View.VISIBLE);
            lnpy3.setVisibility(View.VISIBLE);
            lnpy4.setVisibility(View.VISIBLE);
            lnpy5.setVisibility(View.VISIBLE);
            lnpy6.setVisibility(View.VISIBLE);
            lnpy7.setVisibility(View.VISIBLE);
            lcpy1.setVisibility(View.VISIBLE);
            lcpy2.setVisibility(View.VISIBLE);
            lcpy3.setVisibility(View.VISIBLE);
            lcpy4.setVisibility(View.VISIBLE);
            lcpy5.setVisibility(View.VISIBLE);
            lcpy6.setVisibility(View.VISIBLE);
            lcpy7.setVisibility(View.VISIBLE);
        }
        if (otherint =="lime"){
            limlp.setVisibility(View.VISIBLE);
        }
        if (otherint =="filling"){
            fillp.setVisibility(View.VISIBLE);
        }
        if (otherint =="drainage"){
            dralp.setVisibility(View.VISIBLE);
        }
    }
}
