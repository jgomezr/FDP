package org.grameenfoundation.fdp.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.grameenfoundation.fdp.R;

import java.text.DecimalFormat;

/**
 * Created by julian_Gf on 1/4/2017.
 */

public class yearDelayFragment extends Fragment {
    private TextView jlb,fblb,mrlb,ablb,mylb,jnlb,jllb,aglb,splb,oclb,nvlb,dclb,jvl,fbvl,mrvl,abvl,myvl,jnvl,jlvl,agvl,spvl,ocvl,nvvl,dcvl;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.yeardetail_fragment, container, false);
        jlb = (TextView) view.findViewById(R.id.pjlb);
        fblb = (TextView) view.findViewById(R.id.pflb);
        mrlb = (TextView) view.findViewById(R.id.pmrlb);
        ablb = (TextView) view.findViewById(R.id.palb);
        mylb = (TextView) view.findViewById(R.id.pmylb);
        jnlb = (TextView) view.findViewById(R.id.pjnlb);
        jllb = (TextView) view.findViewById(R.id.pjllb);
        aglb = (TextView) view.findViewById(R.id.paglb);
        splb = (TextView) view.findViewById(R.id.psplb);
        oclb = (TextView) view.findViewById(R.id.poclb);
        nvlb = (TextView) view.findViewById(R.id.pnvlb);
        dclb = (TextView) view.findViewById(R.id.pdclb);
        jvl = (TextView) view.findViewById(R.id.pjcs);
        fbvl = (TextView) view.findViewById(R.id.pfcs);
        mrvl = (TextView) view.findViewById(R.id.pmrcs);
        abvl = (TextView) view.findViewById(R.id.pacs);
        myvl = (TextView) view.findViewById(R.id.pmycs);
        jnvl = (TextView) view.findViewById(R.id.pjncs);
        jlvl = (TextView) view.findViewById(R.id.pjlcs);
        agvl = (TextView) view.findViewById(R.id.pagcs);
        spvl = (TextView) view.findViewById(R.id.pspcs);
        ocvl = (TextView) view.findViewById(R.id.poccs);
        nvvl = (TextView) view.findViewById(R.id.pnvcs);
        dcvl = (TextView) view.findViewById(R.id.pdccs);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public void calc(String main, final String relat, final String labor, final Double area, String yearStart, String yearLaunch){
        int startYear = Integer.valueOf(yearStart.substring(5));
        int launchYear = Integer.valueOf(yearLaunch);
        int jan = 0;
        int feb = 0;
        int mar = 0;
        int apr = 0;
        int may = 0;
        int jun = 0;
        int jul = 0;
        int aug = 0;
        int sep = 0;
        int oct = 0;
        int nov = 0;
        int dec = 0;
        DecimalFormat decF = new DecimalFormat("IDR ###,###,###");

        if (launchYear < startYear){
            setText(jlb, "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
            setText(fblb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
            setText(mrlb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
            setText(ablb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
            setText(mylb, "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
            setText(jnlb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
            setText(jllb, "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
            setText(aglb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
            setText(splb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
            setText(oclb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
            setText(nvlb, "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
            setText(dclb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
            if (labor == "labor") {
                jan = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Jan)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Jan))));
                feb = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Feb)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Feb))));
                mar = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Mar)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Mar))));
                apr = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Apr)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Apr))));
                may = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1May)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1May))));
                jun = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Jun)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Jun))));
                jul = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Jul)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Jul))));
                aug = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Aug)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Aug))));
                sep = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Sep)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Sep))));
                oct = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Oct)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Oct))));
                nov = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Nov)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Nov))));
                dec = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Dec)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Dec))));
            }else {
                jan = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Jan)));
                feb = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Feb)));
                mar = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Mar)));
                apr = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Apr)));
                may = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1May)));
                jun = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Jun)));
                jul = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Jul)));
                aug = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Aug)));
                sep = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Sep)));
                oct = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Oct)));
                nov = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Nov)));
                dec = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Dec)));
            }
        }else{
            if (yearLaunch.equals("1")){
                if (main == "replant"){
                    setText(jlb, "Harvest, ferment, dry, sell");
                    setText(fblb, "Harvest, ferment, dry, sell");
                    setText(mrlb, "Harvest, ferment, dry, sell");
                    setText(ablb, "Harvest, ferment, dry, sell");
                    setText(mylb, "Harvest, ferment, dry, sell");
                    setText(jnlb, "Harvest, ferment, dry, sell + Clearing");
                    setText(jllb, "");
                    setText(aglb, "Lining-cocoa and shade");
                    setText(splb, "Drainage");
                    setText(oclb, "Cocoa Planting + Shade Planting");
                    setText(nvlb, "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer");
                    setText(dclb, "Cocoa Planting + Coconut leaf - temporary shade + Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar");
                    if (relat == "extra"){
                        if (labor == "labor"){
                            jan = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY1Jan))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY1Jan)))+(area * (getResources().getInteger(R.integer.difInputY1Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY1Feb))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY1Feb)))+(area * (getResources().getInteger(R.integer.difInputY1Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY1Mar))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY1Mar)))+(area * (getResources().getInteger(R.integer.difInputY1Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY1Apr))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY1Apr)))+(area * (getResources().getInteger(R.integer.difInputY1Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY1May))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY1May)))+(area * (getResources().getInteger(R.integer.difInputY1May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY1Jun))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY1Jun)))+(area * (getResources().getInteger(R.integer.difInputY1Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY1Jul))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY1Jul)))+(area * (getResources().getInteger(R.integer.difInputY1Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY1Aug))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY1Aug)))+(area * (getResources().getInteger(R.integer.difInputY1Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY1Sep))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY1Sep)))+(area * (getResources().getInteger(R.integer.difInputY1Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY1Oct))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY1Oct)))+(area * (getResources().getInteger(R.integer.difInputY1Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY1Nov))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY1Nov)))+(area * (getResources().getInteger(R.integer.difInputY1Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY1Dec))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY1Dec)))+(area * (getResources().getInteger(R.integer.difInputY1Dec))));
                        }else{
                            jan = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY1Jan)))+(area * (getResources().getInteger(R.integer.difInputY1Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY1Feb)))+(area * (getResources().getInteger(R.integer.difInputY1Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY1Mar)))+(area * (getResources().getInteger(R.integer.difInputY1Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY1Apr)))+(area * (getResources().getInteger(R.integer.difInputY1Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY1May)))+(area * (getResources().getInteger(R.integer.difInputY1May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY1Jun)))+(area * (getResources().getInteger(R.integer.difInputY1Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY1Jul)))+(area * (getResources().getInteger(R.integer.difInputY1Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY1Aug)))+(area * (getResources().getInteger(R.integer.difInputY1Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY1Sep)))+(area * (getResources().getInteger(R.integer.difInputY1Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY1Oct)))+(area * (getResources().getInteger(R.integer.difInputY1Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY1Nov)))+(area * (getResources().getInteger(R.integer.difInputY1Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY1Dec)))+(area * (getResources().getInteger(R.integer.difInputY1Dec))));
                        }
                    }else {
                        if (labor == "labor") {
                            jan = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY1Jan))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY1Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY1Feb))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY1Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY1Mar))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY1Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY1Apr))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY1Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY1May))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY1May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY1Jun))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY1Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY1Jul))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY1Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY1Aug))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY1Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY1Sep))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY1Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY1Oct))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY1Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY1Nov))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY1Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY1Dec))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY1Dec))));
                        } else {
                            jan = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY1Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY1Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY1Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY1Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY1May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY1Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY1Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY1Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY1Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY1Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY1Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY1Dec))));
                        }
                    }

                }else if (main =="graft"){
                    setText(jlb, "Pruning/Sanitation + Fertilizer + P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText(fblb, "Grafting work/ take off the plastic + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(mrlb, "Grafting work/ take off the plastic + Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(ablb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(mylb, "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Shape pruning + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText(jnlb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText(jllb, "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText(aglb, "P&D Control Foliar + Shape pruning + Sanitation + Harvest, ferment, dry, sell");
                    setText(splb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(oclb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(nvlb, "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Shape pruning + Harvest, ferment, dry, sell");
                    setText(dclb, "Pollarding/Sanitation, cutting old tree after grafting + Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");

                    if (relat == "extra"){

                        if (labor == "labor"){
                            jan = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY1Jan)))+(area * (getResources().getInteger(R.integer.GraftingLaborY1Jan)))+(area * (getResources().getInteger(R.integer.difInputY1Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY1Feb)))+(area * (getResources().getInteger(R.integer.GraftingLaborY1Feb)))+(area * (getResources().getInteger(R.integer.difInputY1Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY1Mar)))+(area * (getResources().getInteger(R.integer.GraftingLaborY1Mar)))+(area * (getResources().getInteger(R.integer.difInputY1Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY1Apr)))+(area * (getResources().getInteger(R.integer.GraftingLaborY1Apr)))+(area * (getResources().getInteger(R.integer.difInputY1Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY1May)))+(area * (getResources().getInteger(R.integer.GraftingLaborY1May)))+(area * (getResources().getInteger(R.integer.difInputY1May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY1Jun)))+(area * (getResources().getInteger(R.integer.GraftingLaborY1Jun)))+(area * (getResources().getInteger(R.integer.difInputY1Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY1Jul)))+(area * (getResources().getInteger(R.integer.GraftingLaborY1Jul)))+(area * (getResources().getInteger(R.integer.difInputY1Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY1Aug)))+(area * (getResources().getInteger(R.integer.GraftingLaborY1Aug)))+(area * (getResources().getInteger(R.integer.difInputY1Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY1Sep)))+(area * (getResources().getInteger(R.integer.GraftingLaborY1Sep)))+(area * (getResources().getInteger(R.integer.difInputY1Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY1Oct)))+(area * (getResources().getInteger(R.integer.GraftingLaborY1Oct)))+(area * (getResources().getInteger(R.integer.difInputY1Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY1Nov)))+(area * (getResources().getInteger(R.integer.GraftingLaborY1Nov)))+(area * (getResources().getInteger(R.integer.difInputY1Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY1Dec)))+(area * (getResources().getInteger(R.integer.GraftingLaborY1Dec)))+(area * (getResources().getInteger(R.integer.difInputY1Dec))));
                        }else{
                            jan = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY1Jan)))+(area * (getResources().getInteger(R.integer.difInputY1Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY1Feb)))+(area * (getResources().getInteger(R.integer.difInputY1Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY1Mar)))+(area * (getResources().getInteger(R.integer.difInputY1Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY1Apr)))+(area * (getResources().getInteger(R.integer.difInputY1Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY1May)))+(area * (getResources().getInteger(R.integer.difInputY1May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY1Jun)))+(area * (getResources().getInteger(R.integer.difInputY1Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY1Jul)))+(area * (getResources().getInteger(R.integer.difInputY1Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY1Aug)))+(area * (getResources().getInteger(R.integer.difInputY1Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY1Sep)))+(area * (getResources().getInteger(R.integer.difInputY1Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY1Oct)))+(area * (getResources().getInteger(R.integer.difInputY1Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY1Nov)))+(area * (getResources().getInteger(R.integer.difInputY1Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY1Dec)))+(area * (getResources().getInteger(R.integer.difInputY1Dec))));
                        }

                    }else{
                        if (labor == "labor"){
                            jan = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY1Jan)))+(area * (getResources().getInteger(R.integer.GraftingLaborY1Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY1Feb)))+(area * (getResources().getInteger(R.integer.GraftingLaborY1Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY1Mar)))+(area * (getResources().getInteger(R.integer.GraftingLaborY1Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY1Apr)))+(area * (getResources().getInteger(R.integer.GraftingLaborY1Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY1May)))+(area * (getResources().getInteger(R.integer.GraftingLaborY1May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY1Jun)))+(area * (getResources().getInteger(R.integer.GraftingLaborY1Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY1Jul)))+(area * (getResources().getInteger(R.integer.GraftingLaborY1Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY1Aug)))+(area * (getResources().getInteger(R.integer.GraftingLaborY1Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY1Sep)))+(area * (getResources().getInteger(R.integer.GraftingLaborY1Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY1Oct)))+(area * (getResources().getInteger(R.integer.GraftingLaborY1Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY1Nov)))+(area * (getResources().getInteger(R.integer.GraftingLaborY1Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY1Dec)))+(area * (getResources().getInteger(R.integer.GraftingLaborY1Dec))));
                        }else{
                            jan = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY1Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY1Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY1Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY1Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY1May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY1Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY1Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY1Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY1Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY1Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY1Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY1Dec))));
                        }
                    }

                }else if (main =="extra"){
                    setText(jlb, "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText(fblb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(mrlb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(ablb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(mylb, "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText(jnlb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText(jllb, "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText(aglb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(splb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(oclb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(nvlb, "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText(dclb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");

                    if (labor == "labor"){
                        jan = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY1Jan)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Jan))));
                        feb = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY1Feb)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Feb))));
                        mar = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY1Mar)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Mar))));
                        apr = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY1Apr)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Apr))));
                        may = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY1May)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY1May))));
                        jun = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY1Jun)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Jun))));
                        jul = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY1Jul)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Jul))));
                        aug = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY1Aug)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Aug))));
                        sep = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY1Sep)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Sep))));
                        oct = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY1Oct)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Oct))));
                        nov = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY1Nov)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Nov))));
                        dec = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY1Dec)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY1Dec))));
                    }else{
                        jan = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY1Jan))));
                        feb = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY1Feb))));
                        mar = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY1Mar))));
                        apr = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY1Apr))));
                        may = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY1May))));
                        jun = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY1Jun))));
                        jul = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY1Jul))));
                        aug = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY1Aug))));
                        sep = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY1Sep))));
                        oct = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY1Oct))));
                        nov = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY1Nov))));
                        dec = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY1Dec))));
                    }

                }else{
                    setText(jlb, "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText(fblb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(mrlb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(ablb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(mylb, "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText(jnlb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText(jllb, "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText(aglb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(splb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(oclb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(nvlb, "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText(dclb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    if (relat == "extra"){
                        if (labor == "labor"){
                            jan = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Jan)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Jan)))+(area * (getResources().getInteger(R.integer.difInputY1Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Feb)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Feb)))+(area * (getResources().getInteger(R.integer.difInputY1Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Mar)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Mar)))+(area * (getResources().getInteger(R.integer.difInputY1Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Apr)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Apr)))+(area * (getResources().getInteger(R.integer.difInputY1Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1May)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1May)))+(area * (getResources().getInteger(R.integer.difInputY1May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Jun)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Jun)))+(area * (getResources().getInteger(R.integer.difInputY1Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Jul)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Jul)))+(area * (getResources().getInteger(R.integer.difInputY1Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Aug)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Aug)))+(area * (getResources().getInteger(R.integer.difInputY1Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Sep)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Sep)))+(area * (getResources().getInteger(R.integer.difInputY1Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Oct)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Oct)))+(area * (getResources().getInteger(R.integer.difInputY1Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Nov)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Nov)))+(area * (getResources().getInteger(R.integer.difInputY1Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Dec)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Dec)))+(area * (getResources().getInteger(R.integer.difInputY1Dec))));
                        }else{
                            jan = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Jan)))+(area * (getResources().getInteger(R.integer.difInputY1Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Feb)))+(area * (getResources().getInteger(R.integer.difInputY1Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Mar)))+(area * (getResources().getInteger(R.integer.difInputY1Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Apr)))+(area * (getResources().getInteger(R.integer.difInputY1Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1May)))+(area * (getResources().getInteger(R.integer.difInputY1May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Jun)))+(area * (getResources().getInteger(R.integer.difInputY1Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Jul)))+(area * (getResources().getInteger(R.integer.difInputY1Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Aug)))+(area * (getResources().getInteger(R.integer.difInputY1Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Sep)))+(area * (getResources().getInteger(R.integer.difInputY1Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Oct)))+(area * (getResources().getInteger(R.integer.difInputY1Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Nov)))+(area * (getResources().getInteger(R.integer.difInputY1Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Dec)))+(area * (getResources().getInteger(R.integer.difInputY1Dec))));
                        }
                    }else{
                        if (labor == "labor"){
                            jan = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Jan)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Feb)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Mar)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Apr)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1May)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Jun)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Jul)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Aug)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Sep)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Oct)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Nov)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Dec)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Dec))));
                        }else{
                            jan = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Dec))));
                        }

                    }

                }

            }else if (yearLaunch.equals("2")){
                if (main == "replant"){
                    setText(jlb, "P&D Control Foliar + Maintenance");
                    setText(fblb, "Circle weeding + P&D Control Foliar + Maintenance");
                    setText(mrlb, "Cocoa re- or inter-planting + Shade Planting + Herbiciding OR mechanical manual weeding + Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Shape pruning");
                    setText(ablb, "P&D Control Foliar + Maintenance");
                    setText(mylb, "Application of lime, organic fertilizer + P&D Control Foliar + Maintenance");
                    setText(jnlb, "Circle weeding + Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Shape pruning");
                    setText(jllb, "Herbiciding OR mechanical manual weeding + P&D Control Foliar + Maintenance");
                    setText(aglb, "P&D Control Foliar + Maintenance");
                    setText(splb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Shape pruning");
                    setText(oclb, "Circle weeding + P&D Control Foliar + Maintenance");
                    setText(nvlb, "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Maintenance");
                    setText(dclb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance");
                    if (relat == "extra"){
                        if (labor == "labor"){
                            jan = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY2Jan))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY2Jan)))+(area * (getResources().getInteger(R.integer.difInputY2Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY2Feb))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY2Feb)))+(area * (getResources().getInteger(R.integer.difInputY2Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY2Mar))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY2Mar)))+(area * (getResources().getInteger(R.integer.difInputY2Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY2Apr))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY2Apr)))+(area * (getResources().getInteger(R.integer.difInputY2Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY2May))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY2May)))+(area * (getResources().getInteger(R.integer.difInputY2May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY2Jun))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY2Jun)))+(area * (getResources().getInteger(R.integer.difInputY2Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY2Jul))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY2Jul)))+(area * (getResources().getInteger(R.integer.difInputY2Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY2Aug))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY2Aug)))+(area * (getResources().getInteger(R.integer.difInputY2Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY2Sep))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY2Sep)))+(area * (getResources().getInteger(R.integer.difInputY2Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY2Oct))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY2Oct)))+(area * (getResources().getInteger(R.integer.difInputY2Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY2Nov))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY2Nov)))+(area * (getResources().getInteger(R.integer.difInputY2Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY2Dec))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY2Dec)))+(area * (getResources().getInteger(R.integer.difInputY2Dec))));
                        }else{
                            jan = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY2Jan)))+(area * (getResources().getInteger(R.integer.difInputY2Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY2Feb)))+(area * (getResources().getInteger(R.integer.difInputY2Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY2Mar)))+(area * (getResources().getInteger(R.integer.difInputY2Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY2Apr)))+(area * (getResources().getInteger(R.integer.difInputY2Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY2May)))+(area * (getResources().getInteger(R.integer.difInputY2May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY2Jun)))+(area * (getResources().getInteger(R.integer.difInputY2Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY2Jul)))+(area * (getResources().getInteger(R.integer.difInputY2Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY2Aug)))+(area * (getResources().getInteger(R.integer.difInputY2Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY2Sep)))+(area * (getResources().getInteger(R.integer.difInputY2Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY2Oct)))+(area * (getResources().getInteger(R.integer.difInputY2Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY2Nov)))+(area * (getResources().getInteger(R.integer.difInputY2Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY2Dec)))+(area * (getResources().getInteger(R.integer.difInputY2Dec))));
                        }
                    }else {
                        if (labor == "labor") {
                            jan = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY2Jan))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY2Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY2Feb))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY2Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY2Mar))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY2Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY2Apr))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY2Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY2May))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY2May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY2Jun))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY2Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY2Jul))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY2Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY2Aug))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY2Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY2Sep))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY2Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY2Oct))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY2Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY2Nov))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY2Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY2Dec))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY2Dec))));
                        } else {
                            jan = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY2Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY2Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY2Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY2Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY2May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY2Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY2Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY2Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY2Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY2Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY2Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY2Dec))));
                        }
                    }

                }else if (main =="graft"){
                    setText(jlb,"P&D Control Foliar + Maintenance");
                    setText(fblb, "P&D Control Foliar + Maintenance + Sanitation");
                    setText(mrlb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Shape pruning + Sanitation");
                    setText(ablb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(mylb, "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText(jnlb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText(jllb, "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText(aglb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(splb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(oclb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(nvlb, "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText(dclb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Production/shape/Reducing mother trees branches + Harvest, ferment, dry, sell");

                    if (relat == "extra"){

                        if (labor == "labor"){
                            jan = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY2Jan)))+(area * (getResources().getInteger(R.integer.GraftingLaborY2Jan)))+(area * (getResources().getInteger(R.integer.difInputY2Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY2Feb)))+(area * (getResources().getInteger(R.integer.GraftingLaborY2Feb)))+(area * (getResources().getInteger(R.integer.difInputY2Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY2Mar)))+(area * (getResources().getInteger(R.integer.GraftingLaborY2Mar)))+(area * (getResources().getInteger(R.integer.difInputY2Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY2Apr)))+(area * (getResources().getInteger(R.integer.GraftingLaborY2Apr)))+(area * (getResources().getInteger(R.integer.difInputY2Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY2May)))+(area * (getResources().getInteger(R.integer.GraftingLaborY2May)))+(area * (getResources().getInteger(R.integer.difInputY2May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY2Jun)))+(area * (getResources().getInteger(R.integer.GraftingLaborY2Jun)))+(area * (getResources().getInteger(R.integer.difInputY2Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY2Jul)))+(area * (getResources().getInteger(R.integer.GraftingLaborY2Jul)))+(area * (getResources().getInteger(R.integer.difInputY2Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY2Aug)))+(area * (getResources().getInteger(R.integer.GraftingLaborY2Aug)))+(area * (getResources().getInteger(R.integer.difInputY2Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY2Sep)))+(area * (getResources().getInteger(R.integer.GraftingLaborY2Sep)))+(area * (getResources().getInteger(R.integer.difInputY2Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY2Oct)))+(area * (getResources().getInteger(R.integer.GraftingLaborY2Oct)))+(area * (getResources().getInteger(R.integer.difInputY2Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY2Nov)))+(area * (getResources().getInteger(R.integer.GraftingLaborY2Nov)))+(area * (getResources().getInteger(R.integer.difInputY2Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY2Dec)))+(area * (getResources().getInteger(R.integer.GraftingLaborY2Dec)))+(area * (getResources().getInteger(R.integer.difInputY2Dec))));
                        }else{
                            jan = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY2Jan)))+(area * (getResources().getInteger(R.integer.difInputY2Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY2Feb)))+(area * (getResources().getInteger(R.integer.difInputY2Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY2Mar)))+(area * (getResources().getInteger(R.integer.difInputY2Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY2Apr)))+(area * (getResources().getInteger(R.integer.difInputY2Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY2May)))+(area * (getResources().getInteger(R.integer.difInputY2May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY2Jun)))+(area * (getResources().getInteger(R.integer.difInputY2Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY2Jul)))+(area * (getResources().getInteger(R.integer.difInputY2Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY2Aug)))+(area * (getResources().getInteger(R.integer.difInputY2Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY2Sep)))+(area * (getResources().getInteger(R.integer.difInputY2Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY2Oct)))+(area * (getResources().getInteger(R.integer.difInputY2Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY2Nov)))+(area * (getResources().getInteger(R.integer.difInputY2Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY2Dec)))+(area * (getResources().getInteger(R.integer.difInputY2Dec))));
                        }

                    }else{
                        if (labor == "labor"){
                            jan = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY2Jan)))+(area * (getResources().getInteger(R.integer.GraftingLaborY2Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY2Feb)))+(area * (getResources().getInteger(R.integer.GraftingLaborY2Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY2Mar)))+(area * (getResources().getInteger(R.integer.GraftingLaborY2Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY2Apr)))+(area * (getResources().getInteger(R.integer.GraftingLaborY2Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY2May)))+(area * (getResources().getInteger(R.integer.GraftingLaborY2May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY2Jun)))+(area * (getResources().getInteger(R.integer.GraftingLaborY2Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY2Jul)))+(area * (getResources().getInteger(R.integer.GraftingLaborY2Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY2Aug)))+(area * (getResources().getInteger(R.integer.GraftingLaborY2Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY2Sep)))+(area * (getResources().getInteger(R.integer.GraftingLaborY2Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY2Oct)))+(area * (getResources().getInteger(R.integer.GraftingLaborY2Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY2Nov)))+(area * (getResources().getInteger(R.integer.GraftingLaborY2Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY2Dec)))+(area * (getResources().getInteger(R.integer.GraftingLaborY2Dec))));
                        }else{
                            jan = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY2Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY2Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY2Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY2Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY2May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY2Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY2Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY2Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY2Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY2Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY2Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY2Dec))));
                        }
                    }

                }else if (main =="extra"){
                    setText(jlb, "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText(fblb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(mrlb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(ablb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(mylb, "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText(jnlb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText(jllb, "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText(aglb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(splb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(oclb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(nvlb, "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText(dclb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");

                    if (labor == "labor"){
                        jan = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY2Jan)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Jan))));
                        feb = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY2Feb)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Feb))));
                        mar = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY2Mar)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Mar))));
                        apr = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY2Apr)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Apr))));
                        may = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY2May)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY2May))));
                        jun = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY2Jun)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Jun))));
                        jul = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY2Jul)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Jul))));
                        aug = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY2Aug)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Aug))));
                        sep = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY2Sep)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Sep))));
                        oct = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY2Oct)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Oct))));
                        nov = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY2Nov)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Nov))));
                        dec = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY2Dec)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY2Dec))));
                    }else{
                        jan = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY2Jan))));
                        feb = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY2Feb))));
                        mar = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY2Mar))));
                        apr = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY2Apr))));
                        may = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY2May))));
                        jun = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY2Jun))));
                        jul = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY2Jul))));
                        aug = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY2Aug))));
                        sep = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY2Sep))));
                        oct = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY2Oct))));
                        nov = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY2Nov))));
                        dec = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY2Dec))));
                    }

                }else{
                    setText(jlb, "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText(fblb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(mrlb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(ablb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(mylb, "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText(jnlb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText(jllb, "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText(aglb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(splb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(oclb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(nvlb, "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText(dclb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    if (relat == "extra"){
                        if (labor == "labor"){
                            jan = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY2Jan)))+(area * (getResources().getInteger(R.integer.GAPSLaborY2Jan)))+(area * (getResources().getInteger(R.integer.difInputY2Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY2Feb)))+(area * (getResources().getInteger(R.integer.GAPSLaborY2Feb)))+(area * (getResources().getInteger(R.integer.difInputY2Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY2Mar)))+(area * (getResources().getInteger(R.integer.GAPSLaborY2Mar)))+(area * (getResources().getInteger(R.integer.difInputY2Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY2Apr)))+(area * (getResources().getInteger(R.integer.GAPSLaborY2Apr)))+(area * (getResources().getInteger(R.integer.difInputY2Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY2May)))+(area * (getResources().getInteger(R.integer.GAPSLaborY2May)))+(area * (getResources().getInteger(R.integer.difInputY2May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY2Jun)))+(area * (getResources().getInteger(R.integer.GAPSLaborY2Jun)))+(area * (getResources().getInteger(R.integer.difInputY2Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY2Jul)))+(area * (getResources().getInteger(R.integer.GAPSLaborY2Jul)))+(area * (getResources().getInteger(R.integer.difInputY2Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY2Aug)))+(area * (getResources().getInteger(R.integer.GAPSLaborY2Aug)))+(area * (getResources().getInteger(R.integer.difInputY2Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY2Sep)))+(area * (getResources().getInteger(R.integer.GAPSLaborY2Sep)))+(area * (getResources().getInteger(R.integer.difInputY2Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY2Oct)))+(area * (getResources().getInteger(R.integer.GAPSLaborY2Oct)))+(area * (getResources().getInteger(R.integer.difInputY2Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY2Nov)))+(area * (getResources().getInteger(R.integer.GAPSLaborY2Nov)))+(area * (getResources().getInteger(R.integer.difInputY2Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY2Dec)))+(area * (getResources().getInteger(R.integer.GAPSLaborY2Dec)))+(area * (getResources().getInteger(R.integer.difInputY2Dec))));
                        }else{
                            jan = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY2Jan)))+(area * (getResources().getInteger(R.integer.difInputY2Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY2Feb)))+(area * (getResources().getInteger(R.integer.difInputY2Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY2Mar)))+(area * (getResources().getInteger(R.integer.difInputY2Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY2Apr)))+(area * (getResources().getInteger(R.integer.difInputY2Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY2May)))+(area * (getResources().getInteger(R.integer.difInputY2May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY2Jun)))+(area * (getResources().getInteger(R.integer.difInputY2Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY2Jul)))+(area * (getResources().getInteger(R.integer.difInputY2Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY2Aug)))+(area * (getResources().getInteger(R.integer.difInputY2Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY2Sep)))+(area * (getResources().getInteger(R.integer.difInputY2Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY2Oct)))+(area * (getResources().getInteger(R.integer.difInputY2Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY2Nov)))+(area * (getResources().getInteger(R.integer.difInputY2Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY2Dec)))+(area * (getResources().getInteger(R.integer.difInputY2Dec))));
                        }
                    }else{
                        if (labor == "labor"){
                            jan = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY2Jan)))+(area * (getResources().getInteger(R.integer.GAPSLaborY2Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY2Feb)))+(area * (getResources().getInteger(R.integer.GAPSLaborY2Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY2Mar)))+(area * (getResources().getInteger(R.integer.GAPSLaborY2Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY2Apr)))+(area * (getResources().getInteger(R.integer.GAPSLaborY2Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY2May)))+(area * (getResources().getInteger(R.integer.GAPSLaborY2May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY2Jun)))+(area * (getResources().getInteger(R.integer.GAPSLaborY2Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY2Jul)))+(area * (getResources().getInteger(R.integer.GAPSLaborY2Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY2Aug)))+(area * (getResources().getInteger(R.integer.GAPSLaborY2Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY2Sep)))+(area * (getResources().getInteger(R.integer.GAPSLaborY2Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY2Oct)))+(area * (getResources().getInteger(R.integer.GAPSLaborY2Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY2Nov)))+(area * (getResources().getInteger(R.integer.GAPSLaborY2Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY2Dec)))+(area * (getResources().getInteger(R.integer.GAPSLaborY2Dec))));
                        }else{
                            jan = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY2Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY2Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY2Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY2Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY2May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY2Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY2Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY2Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY2Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY2Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY2Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY2Dec))));
                        }

                    }

                }

            }else if (yearLaunch.equals("3")){

                if (main == "replant"){
                    setText(jlb, "P&D Control Foliar + Maintenance");
                    setText(fblb, "P&D Control Foliar + Maintenance + Sanitation");
                    setText(mrlb, "Herbiciding OR mechanical manual weeding + Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation");
                    setText(ablb, "P&D Control Foliar + Shape pruning + Sanitation");
                    setText(mylb, "Application of lime, organic fertilizer + P&D Control Foliar + Production/shape + Shape pruning");
                    setText(jnlb, "Herbiciding OR mechanical manual weeding + Fertilizing NPK, Cocoa Fertilizer + P&D Control Foliar + Maintenance + Production/shape + Shape pruning + Harvest, ferment, dry, sell");
                    setText(jllb, "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText(aglb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(splb, "Herbiciding OR mechanical manual weeding + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(oclb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(nvlb, "Application of lime, organic fertilizer + P&D Control Foliar + Production/shape + Harvest, ferment, dry, sell");
                    setText(dclb, "Herbiciding OR mechanical manual weeding + Fertilizing NPK, Cocoa Fertilizer + P&D Control Foliar + Production/shape + Harvest, ferment, dry, sell");
                    if (relat == "extra"){
                        if (labor == "labor"){
                            jan = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Jan))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY3Jan)))+(area * (getResources().getInteger(R.integer.difInputY3Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Feb))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY3Feb)))+(area * (getResources().getInteger(R.integer.difInputY3Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Mar))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY3Mar)))+(area * (getResources().getInteger(R.integer.difInputY3Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Apr))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY3Apr)))+(area * (getResources().getInteger(R.integer.difInputY3Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3May))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY3May)))+(area * (getResources().getInteger(R.integer.difInputY3May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Jun))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY3Jun)))+(area * (getResources().getInteger(R.integer.difInputY3Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Jul))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY3Jul)))+(area * (getResources().getInteger(R.integer.difInputY3Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Aug))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY3Aug)))+(area * (getResources().getInteger(R.integer.difInputY3Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Sep))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY3Sep)))+(area * (getResources().getInteger(R.integer.difInputY3Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Oct))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY3Oct)))+(area * (getResources().getInteger(R.integer.difInputY3Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Nov))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY3Nov)))+(area * (getResources().getInteger(R.integer.difInputY3Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Dec))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY3Dec)))+(area * (getResources().getInteger(R.integer.difInputY3Dec))));
                        }else{
                            jan = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Jan)))+(area * (getResources().getInteger(R.integer.difInputY3Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Feb)))+(area * (getResources().getInteger(R.integer.difInputY3Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Mar)))+(area * (getResources().getInteger(R.integer.difInputY3Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Apr)))+(area * (getResources().getInteger(R.integer.difInputY3Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3May)))+(area * (getResources().getInteger(R.integer.difInputY3May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Jun)))+(area * (getResources().getInteger(R.integer.difInputY3Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Jul)))+(area * (getResources().getInteger(R.integer.difInputY3Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Aug)))+(area * (getResources().getInteger(R.integer.difInputY3Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Sep)))+(area * (getResources().getInteger(R.integer.difInputY3Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Oct)))+(area * (getResources().getInteger(R.integer.difInputY3Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Nov)))+(area * (getResources().getInteger(R.integer.difInputY3Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Dec)))+(area * (getResources().getInteger(R.integer.difInputY3Dec))));
                        }
                    }else {
                        if (labor == "labor") {
                            jan = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Jan))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY3Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Feb))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY3Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Mar))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY3Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Apr))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY3Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3May))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY3May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Jun))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY3Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Jul))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY3Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Aug))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY3Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Sep))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY3Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Oct))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY3Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Nov))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY3Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Dec))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY3Dec))));
                        } else {
                            jan = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Dec))));
                        }
                    }

                }else if (main =="graft"){
                    setText(jlb,"P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText(fblb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(mrlb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(ablb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(mylb, "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText(jnlb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + roduction/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText(jllb, "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText(aglb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(splb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(oclb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(nvlb, "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Harvest, ferment, dry, sell");
                    setText(dclb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Production/shape/Reducing mother trees branches + Harvest, ferment, dry, sell");

                    if (relat == "extra"){

                        if (labor == "labor"){
                            jan = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Jan)))+(area * (getResources().getInteger(R.integer.GraftingLaborY3Jan)))+(area * (getResources().getInteger(R.integer.difInputY3Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Feb)))+(area * (getResources().getInteger(R.integer.GraftingLaborY3Feb)))+(area * (getResources().getInteger(R.integer.difInputY3Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Mar)))+(area * (getResources().getInteger(R.integer.GraftingLaborY3Mar)))+(area * (getResources().getInteger(R.integer.difInputY3Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Apr)))+(area * (getResources().getInteger(R.integer.GraftingLaborY3Apr)))+(area * (getResources().getInteger(R.integer.difInputY3Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3May)))+(area * (getResources().getInteger(R.integer.GraftingLaborY3May)))+(area * (getResources().getInteger(R.integer.difInputY3May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Jun)))+(area * (getResources().getInteger(R.integer.GraftingLaborY3Jun)))+(area * (getResources().getInteger(R.integer.difInputY3Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Jul)))+(area * (getResources().getInteger(R.integer.GraftingLaborY3Jul)))+(area * (getResources().getInteger(R.integer.difInputY3Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Aug)))+(area * (getResources().getInteger(R.integer.GraftingLaborY3Aug)))+(area * (getResources().getInteger(R.integer.difInputY3Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Sep)))+(area * (getResources().getInteger(R.integer.GraftingLaborY3Sep)))+(area * (getResources().getInteger(R.integer.difInputY3Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Oct)))+(area * (getResources().getInteger(R.integer.GraftingLaborY3Oct)))+(area * (getResources().getInteger(R.integer.difInputY3Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Nov)))+(area * (getResources().getInteger(R.integer.GraftingLaborY3Nov)))+(area * (getResources().getInteger(R.integer.difInputY3Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Dec)))+(area * (getResources().getInteger(R.integer.GraftingLaborY3Dec)))+(area * (getResources().getInteger(R.integer.difInputY3Dec))));
                        }else{
                            jan = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Jan)))+(area * (getResources().getInteger(R.integer.difInputY3Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Feb)))+(area * (getResources().getInteger(R.integer.difInputY3Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Mar)))+(area * (getResources().getInteger(R.integer.difInputY3Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Apr)))+(area * (getResources().getInteger(R.integer.difInputY3Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3May)))+(area * (getResources().getInteger(R.integer.difInputY3May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Jun)))+(area * (getResources().getInteger(R.integer.difInputY3Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Jul)))+(area * (getResources().getInteger(R.integer.difInputY3Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Aug)))+(area * (getResources().getInteger(R.integer.difInputY3Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Sep)))+(area * (getResources().getInteger(R.integer.difInputY3Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Oct)))+(area * (getResources().getInteger(R.integer.difInputY3Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Nov)))+(area * (getResources().getInteger(R.integer.difInputY3Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Dec)))+(area * (getResources().getInteger(R.integer.difInputY3Dec))));
                        }

                    }else{
                        if (labor == "labor"){
                            jan = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Jan)))+(area * (getResources().getInteger(R.integer.GraftingLaborY3Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Feb)))+(area * (getResources().getInteger(R.integer.GraftingLaborY3Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Mar)))+(area * (getResources().getInteger(R.integer.GraftingLaborY3Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Apr)))+(area * (getResources().getInteger(R.integer.GraftingLaborY3Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3May)))+(area * (getResources().getInteger(R.integer.GraftingLaborY3May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Jun)))+(area * (getResources().getInteger(R.integer.GraftingLaborY3Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Jul)))+(area * (getResources().getInteger(R.integer.GraftingLaborY3Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Aug)))+(area * (getResources().getInteger(R.integer.GraftingLaborY3Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Sep)))+(area * (getResources().getInteger(R.integer.GraftingLaborY3Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Oct)))+(area * (getResources().getInteger(R.integer.GraftingLaborY3Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Nov)))+(area * (getResources().getInteger(R.integer.GraftingLaborY3Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Dec)))+(area * (getResources().getInteger(R.integer.GraftingLaborY3Dec))));
                        }else{
                            jan = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Dec))));
                        }
                    }

                }else if (main =="extra"){
                    setText(jlb, "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText(fblb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(mrlb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(ablb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(mylb, "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText(jnlb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText(jllb, "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText(aglb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(splb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(oclb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(nvlb, "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText(dclb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");

                    if (labor == "labor"){
                        jan = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY3Jan)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Jan))));
                        feb = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY3Feb)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Feb))));
                        mar = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY3Mar)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Mar))));
                        apr = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY3Apr)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Apr))));
                        may = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY3May)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY3May))));
                        jun = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY3Jun)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Jun))));
                        jul = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY3Jul)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Jul))));
                        aug = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY3Aug)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Aug))));
                        sep = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY3Sep)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Sep))));
                        oct = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY3Oct)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Oct))));
                        nov = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY3Nov)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Nov))));
                        dec = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY3Dec)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Dec))));
                    }else{
                        jan = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY3Jan))));
                        feb = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY3Feb))));
                        mar = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY3Mar))));
                        apr = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY3Apr))));
                        may = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY3May))));
                        jun = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY3Jun))));
                        jul = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY3Jul))));
                        aug = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY3Aug))));
                        sep = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY3Sep))));
                        oct = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY3Oct))));
                        nov = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY3Nov))));
                        dec = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY3Dec))));
                    }

                }else{
                    setText(jlb, "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText(fblb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(mrlb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(ablb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(mylb, "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText(jnlb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText(jllb, "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText(aglb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(splb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(oclb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(nvlb, "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText(dclb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    if (relat == "extra"){
                        if (labor == "labor"){
                            jan = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Jan)))+(area * (getResources().getInteger(R.integer.GAPSLaborY3Jan)))+(area * (getResources().getInteger(R.integer.difInputY3Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Feb)))+(area * (getResources().getInteger(R.integer.GAPSLaborY3Feb)))+(area * (getResources().getInteger(R.integer.difInputY3Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Mar)))+(area * (getResources().getInteger(R.integer.GAPSLaborY3Mar)))+(area * (getResources().getInteger(R.integer.difInputY3Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Apr)))+(area * (getResources().getInteger(R.integer.GAPSLaborY3Apr)))+(area * (getResources().getInteger(R.integer.difInputY3Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3May)))+(area * (getResources().getInteger(R.integer.GAPSLaborY3May)))+(area * (getResources().getInteger(R.integer.difInputY3May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Jun)))+(area * (getResources().getInteger(R.integer.GAPSLaborY3Jun)))+(area * (getResources().getInteger(R.integer.difInputY3Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Jul)))+(area * (getResources().getInteger(R.integer.GAPSLaborY3Jul)))+(area * (getResources().getInteger(R.integer.difInputY3Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Aug)))+(area * (getResources().getInteger(R.integer.GAPSLaborY3Aug)))+(area * (getResources().getInteger(R.integer.difInputY3Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Sep)))+(area * (getResources().getInteger(R.integer.GAPSLaborY3Sep)))+(area * (getResources().getInteger(R.integer.difInputY3Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Oct)))+(area * (getResources().getInteger(R.integer.GAPSLaborY3Oct)))+(area * (getResources().getInteger(R.integer.difInputY3Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Nov)))+(area * (getResources().getInteger(R.integer.GAPSLaborY3Nov)))+(area * (getResources().getInteger(R.integer.difInputY3Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Dec)))+(area * (getResources().getInteger(R.integer.GAPSLaborY3Dec)))+(area * (getResources().getInteger(R.integer.difInputY3Dec))));
                        }else{
                            jan = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Jan)))+(area * (getResources().getInteger(R.integer.difInputY3Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Feb)))+(area * (getResources().getInteger(R.integer.difInputY3Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Mar)))+(area * (getResources().getInteger(R.integer.difInputY3Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Apr)))+(area * (getResources().getInteger(R.integer.difInputY3Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3May)))+(area * (getResources().getInteger(R.integer.difInputY3May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Jun)))+(area * (getResources().getInteger(R.integer.difInputY3Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Jul)))+(area * (getResources().getInteger(R.integer.difInputY3Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Aug)))+(area * (getResources().getInteger(R.integer.difInputY3Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Sep)))+(area * (getResources().getInteger(R.integer.difInputY3Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Oct)))+(area * (getResources().getInteger(R.integer.difInputY3Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Nov)))+(area * (getResources().getInteger(R.integer.difInputY3Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Dec)))+(area * (getResources().getInteger(R.integer.difInputY3Dec))));
                        }
                    }else{
                        if (labor == "labor"){
                            jan = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Jan)))+(area * (getResources().getInteger(R.integer.GAPSLaborY3Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Feb)))+(area * (getResources().getInteger(R.integer.GAPSLaborY3Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Mar)))+(area * (getResources().getInteger(R.integer.GAPSLaborY3Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Apr)))+(area * (getResources().getInteger(R.integer.GAPSLaborY3Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3May)))+(area * (getResources().getInteger(R.integer.GAPSLaborY3May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Jun)))+(area * (getResources().getInteger(R.integer.GAPSLaborY3Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Jul)))+(area * (getResources().getInteger(R.integer.GAPSLaborY3Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Aug)))+(area * (getResources().getInteger(R.integer.GAPSLaborY3Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Sep)))+(area * (getResources().getInteger(R.integer.GAPSLaborY3Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Oct)))+(area * (getResources().getInteger(R.integer.GAPSLaborY3Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Nov)))+(area * (getResources().getInteger(R.integer.GAPSLaborY3Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Dec)))+(area * (getResources().getInteger(R.integer.GAPSLaborY3Dec))));
                        }else{
                            jan = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Dec))));
                        }

                    }

                }

            }else if (yearLaunch.equals("4")){

                if (main == "replant"){
                    setText(jlb, "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText(fblb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(mrlb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(ablb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(mylb, "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText(jnlb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText(jllb, "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText(aglb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(splb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(oclb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(nvlb, "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText(dclb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    if (relat == "extra"){
                        if (labor == "labor"){
                            jan = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Jan))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY4Jan)))+(area * (getResources().getInteger(R.integer.difInputY4Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Feb))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY4Feb)))+(area * (getResources().getInteger(R.integer.difInputY4Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Mar))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY4Mar)))+(area * (getResources().getInteger(R.integer.difInputY4Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Apr))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY4Apr)))+(area * (getResources().getInteger(R.integer.difInputY4Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4May))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY4May)))+(area * (getResources().getInteger(R.integer.difInputY4May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Jun))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY4Jun)))+(area * (getResources().getInteger(R.integer.difInputY4Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Jul))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY4Jul)))+(area * (getResources().getInteger(R.integer.difInputY4Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Aug))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY4Aug)))+(area * (getResources().getInteger(R.integer.difInputY4Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Sep))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY4Sep)))+(area * (getResources().getInteger(R.integer.difInputY4Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Oct))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY4Oct)))+(area * (getResources().getInteger(R.integer.difInputY4Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Nov))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY4Nov)))+(area * (getResources().getInteger(R.integer.difInputY4Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Dec))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY4Dec)))+(area * (getResources().getInteger(R.integer.difInputY4Dec))));
                        }else{
                            jan = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Jan)))+(area * (getResources().getInteger(R.integer.difInputY4Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Feb)))+(area * (getResources().getInteger(R.integer.difInputY4Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Mar)))+(area * (getResources().getInteger(R.integer.difInputY4Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Apr)))+(area * (getResources().getInteger(R.integer.difInputY4Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4May)))+(area * (getResources().getInteger(R.integer.difInputY4May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Jun)))+(area * (getResources().getInteger(R.integer.difInputY4Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Jul)))+(area * (getResources().getInteger(R.integer.difInputY4Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Aug)))+(area * (getResources().getInteger(R.integer.difInputY4Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Sep)))+(area * (getResources().getInteger(R.integer.difInputY4Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Oct)))+(area * (getResources().getInteger(R.integer.difInputY4Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Nov)))+(area * (getResources().getInteger(R.integer.difInputY4Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Dec)))+(area * (getResources().getInteger(R.integer.difInputY4Dec))));
                        }
                    }else {
                        if (labor == "labor") {
                            jan = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Jan))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY4Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Feb))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY4Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Mar))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY4Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Apr))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY4Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4May))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY4May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Jun))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY4Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Jul))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY4Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Aug))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY4Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Sep))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY4Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Oct))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY4Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Nov))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY4Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Dec))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY4Dec))));
                        } else {
                            jan = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Dec))));
                        }
                    }

                }else if (main =="graft"){
                    setText(jlb, "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText(fblb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(mrlb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(ablb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(mylb, "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText(jnlb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText(jllb, "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText(aglb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(splb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(oclb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(nvlb, "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText(dclb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");

                    if (relat == "extra"){

                        if (labor == "labor"){
                            jan = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Jan)))+(area * (getResources().getInteger(R.integer.GraftingLaborY4Jan)))+(area * (getResources().getInteger(R.integer.difInputY4Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Feb)))+(area * (getResources().getInteger(R.integer.GraftingLaborY4Feb)))+(area * (getResources().getInteger(R.integer.difInputY4Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Mar)))+(area * (getResources().getInteger(R.integer.GraftingLaborY4Mar)))+(area * (getResources().getInteger(R.integer.difInputY4Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Apr)))+(area * (getResources().getInteger(R.integer.GraftingLaborY4Apr)))+(area * (getResources().getInteger(R.integer.difInputY4Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4May)))+(area * (getResources().getInteger(R.integer.GraftingLaborY4May)))+(area * (getResources().getInteger(R.integer.difInputY4May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Jun)))+(area * (getResources().getInteger(R.integer.GraftingLaborY4Jun)))+(area * (getResources().getInteger(R.integer.difInputY4Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Jul)))+(area * (getResources().getInteger(R.integer.GraftingLaborY4Jul)))+(area * (getResources().getInteger(R.integer.difInputY4Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Aug)))+(area * (getResources().getInteger(R.integer.GraftingLaborY4Aug)))+(area * (getResources().getInteger(R.integer.difInputY4Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Sep)))+(area * (getResources().getInteger(R.integer.GraftingLaborY4Sep)))+(area * (getResources().getInteger(R.integer.difInputY4Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Oct)))+(area * (getResources().getInteger(R.integer.GraftingLaborY4Oct)))+(area * (getResources().getInteger(R.integer.difInputY4Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Nov)))+(area * (getResources().getInteger(R.integer.GraftingLaborY4Nov)))+(area * (getResources().getInteger(R.integer.difInputY4Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Dec)))+(area * (getResources().getInteger(R.integer.GraftingLaborY4Dec)))+(area * (getResources().getInteger(R.integer.difInputY4Dec))));
                        }else{
                            jan = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Jan)))+(area * (getResources().getInteger(R.integer.difInputY4Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Feb)))+(area * (getResources().getInteger(R.integer.difInputY4Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Mar)))+(area * (getResources().getInteger(R.integer.difInputY4Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Apr)))+(area * (getResources().getInteger(R.integer.difInputY4Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4May)))+(area * (getResources().getInteger(R.integer.difInputY4May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Jun)))+(area * (getResources().getInteger(R.integer.difInputY4Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Jul)))+(area * (getResources().getInteger(R.integer.difInputY4Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Aug)))+(area * (getResources().getInteger(R.integer.difInputY4Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Sep)))+(area * (getResources().getInteger(R.integer.difInputY4Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Oct)))+(area * (getResources().getInteger(R.integer.difInputY4Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Nov)))+(area * (getResources().getInteger(R.integer.difInputY4Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Dec)))+(area * (getResources().getInteger(R.integer.difInputY4Dec))));
                        }

                    }else{
                        if (labor == "labor"){
                            jan = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Jan)))+(area * (getResources().getInteger(R.integer.GraftingLaborY4Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Feb)))+(area * (getResources().getInteger(R.integer.GraftingLaborY4Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Mar)))+(area * (getResources().getInteger(R.integer.GraftingLaborY4Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Apr)))+(area * (getResources().getInteger(R.integer.GraftingLaborY4Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4May)))+(area * (getResources().getInteger(R.integer.GraftingLaborY4May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Jun)))+(area * (getResources().getInteger(R.integer.GraftingLaborY4Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Jul)))+(area * (getResources().getInteger(R.integer.GraftingLaborY4Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Aug)))+(area * (getResources().getInteger(R.integer.GraftingLaborY4Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Sep)))+(area * (getResources().getInteger(R.integer.GraftingLaborY4Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Oct)))+(area * (getResources().getInteger(R.integer.GraftingLaborY4Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Nov)))+(area * (getResources().getInteger(R.integer.GraftingLaborY4Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Dec)))+(area * (getResources().getInteger(R.integer.GraftingLaborY4Dec))));
                        }else{
                            jan = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Dec))));
                        }
                    }

                }else if (main =="extra"){
                    setText(jlb, "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText(fblb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(mrlb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(ablb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(mylb, "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText(jnlb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText(jllb, "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText(aglb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(splb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(oclb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(nvlb, "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText(dclb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");

                    if (labor == "labor"){
                        jan = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY4Jan)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Jan))));
                        feb = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY4Feb)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Feb))));
                        mar = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY4Mar)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Mar))));
                        apr = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY4Apr)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Apr))));
                        may = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY4May)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY4May))));
                        jun = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY4Jun)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Jun))));
                        jul = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY4Jul)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Jul))));
                        aug = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY4Aug)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Aug))));
                        sep = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY4Sep)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Sep))));
                        oct = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY4Oct)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Oct))));
                        nov = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY4Nov)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Nov))));
                        dec = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY4Dec)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY4Dec))));
                    }else{
                        jan = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY4Jan))));
                        feb = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY4Feb))));
                        mar = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY4Mar))));
                        apr = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY4Apr))));
                        may = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY4May))));
                        jun = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY4Jun))));
                        jul = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY4Jul))));
                        aug = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY4Aug))));
                        sep = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY4Sep))));
                        oct = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY4Oct))));
                        nov = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY4Nov))));
                        dec = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY4Dec))));
                    }

                }else{
                    setText(jlb, "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText(fblb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(mrlb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(ablb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(mylb, "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText(jnlb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText(jllb, "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText(aglb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(splb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(oclb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(nvlb, "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText(dclb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    if (relat == "extra"){
                        if (labor == "labor"){
                            jan = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Jan)))+(area * (getResources().getInteger(R.integer.GAPSLaborY4Jan)))+(area * (getResources().getInteger(R.integer.difInputY4Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Feb)))+(area * (getResources().getInteger(R.integer.GAPSLaborY4Feb)))+(area * (getResources().getInteger(R.integer.difInputY4Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Mar)))+(area * (getResources().getInteger(R.integer.GAPSLaborY4Mar)))+(area * (getResources().getInteger(R.integer.difInputY4Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Apr)))+(area * (getResources().getInteger(R.integer.GAPSLaborY4Apr)))+(area * (getResources().getInteger(R.integer.difInputY4Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4May)))+(area * (getResources().getInteger(R.integer.GAPSLaborY4May)))+(area * (getResources().getInteger(R.integer.difInputY4May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Jun)))+(area * (getResources().getInteger(R.integer.GAPSLaborY4Jun)))+(area * (getResources().getInteger(R.integer.difInputY4Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Jul)))+(area * (getResources().getInteger(R.integer.GAPSLaborY4Jul)))+(area * (getResources().getInteger(R.integer.difInputY4Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Aug)))+(area * (getResources().getInteger(R.integer.GAPSLaborY4Aug)))+(area * (getResources().getInteger(R.integer.difInputY4Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Sep)))+(area * (getResources().getInteger(R.integer.GAPSLaborY4Sep)))+(area * (getResources().getInteger(R.integer.difInputY4Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Oct)))+(area * (getResources().getInteger(R.integer.GAPSLaborY4Oct)))+(area * (getResources().getInteger(R.integer.difInputY4Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Nov)))+(area * (getResources().getInteger(R.integer.GAPSLaborY4Nov)))+(area * (getResources().getInteger(R.integer.difInputY4Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Dec)))+(area * (getResources().getInteger(R.integer.GAPSLaborY4Dec)))+(area * (getResources().getInteger(R.integer.difInputY4Dec))));
                        }else{
                            jan = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Jan)))+(area * (getResources().getInteger(R.integer.difInputY4Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Feb)))+(area * (getResources().getInteger(R.integer.difInputY4Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Mar)))+(area * (getResources().getInteger(R.integer.difInputY4Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Apr)))+(area * (getResources().getInteger(R.integer.difInputY4Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4May)))+(area * (getResources().getInteger(R.integer.difInputY4May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Jun)))+(area * (getResources().getInteger(R.integer.difInputY4Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Jul)))+(area * (getResources().getInteger(R.integer.difInputY4Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Aug)))+(area * (getResources().getInteger(R.integer.difInputY4Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Sep)))+(area * (getResources().getInteger(R.integer.difInputY4Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Oct)))+(area * (getResources().getInteger(R.integer.difInputY4Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Nov)))+(area * (getResources().getInteger(R.integer.difInputY4Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Dec)))+(area * (getResources().getInteger(R.integer.difInputY4Dec))));
                        }
                    }else{
                        if (labor == "labor"){
                            jan = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Jan)))+(area * (getResources().getInteger(R.integer.GAPSLaborY4Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Feb)))+(area * (getResources().getInteger(R.integer.GAPSLaborY4Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Mar)))+(area * (getResources().getInteger(R.integer.GAPSLaborY4Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Apr)))+(area * (getResources().getInteger(R.integer.GAPSLaborY4Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4May)))+(area * (getResources().getInteger(R.integer.GAPSLaborY4May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Jun)))+(area * (getResources().getInteger(R.integer.GAPSLaborY4Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Jul)))+(area * (getResources().getInteger(R.integer.GAPSLaborY4Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Aug)))+(area * (getResources().getInteger(R.integer.GAPSLaborY4Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Sep)))+(area * (getResources().getInteger(R.integer.GAPSLaborY4Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Oct)))+(area * (getResources().getInteger(R.integer.GAPSLaborY4Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Nov)))+(area * (getResources().getInteger(R.integer.GAPSLaborY4Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Dec)))+(area * (getResources().getInteger(R.integer.GAPSLaborY4Dec))));
                        }else{
                            jan = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Dec))));
                        }

                    }

                }

            }else{

                if (main == "replant"){
                    setText(jlb, "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText(fblb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(mrlb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(ablb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(mylb, "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText(jnlb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText(jllb, "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText(aglb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(splb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(oclb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(nvlb, "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText(dclb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    if (relat == "extra"){
                        if (labor == "labor"){
                            jan = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Jan))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY5Jan)))+(area * (getResources().getInteger(R.integer.difInputY5Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Feb))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY5Feb)))+(area * (getResources().getInteger(R.integer.difInputY5Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Mar))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY5Mar)))+(area * (getResources().getInteger(R.integer.difInputY5Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Apr))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY5Apr)))+(area * (getResources().getInteger(R.integer.difInputY5Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5May))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY5May)))+(area * (getResources().getInteger(R.integer.difInputY5May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Jun))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY5Jun)))+(area * (getResources().getInteger(R.integer.difInputY5Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Jul))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY5Jul)))+(area * (getResources().getInteger(R.integer.difInputY5Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Aug))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY5Aug)))+(area * (getResources().getInteger(R.integer.difInputY5Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Sep))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY5Sep)))+(area * (getResources().getInteger(R.integer.difInputY5Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Oct))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY5Oct)))+(area * (getResources().getInteger(R.integer.difInputY5Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Nov))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY5Nov)))+(area * (getResources().getInteger(R.integer.difInputY5Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Dec))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY5Dec)))+(area * (getResources().getInteger(R.integer.difInputY5Dec))));
                        }else{
                            jan = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Jan)))+(area * (getResources().getInteger(R.integer.difInputY5Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Feb)))+(area * (getResources().getInteger(R.integer.difInputY5Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Mar)))+(area * (getResources().getInteger(R.integer.difInputY5Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Apr)))+(area * (getResources().getInteger(R.integer.difInputY5Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5May)))+(area * (getResources().getInteger(R.integer.difInputY5May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Jun)))+(area * (getResources().getInteger(R.integer.difInputY5Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Jul)))+(area * (getResources().getInteger(R.integer.difInputY5Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Aug)))+(area * (getResources().getInteger(R.integer.difInputY5Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Sep)))+(area * (getResources().getInteger(R.integer.difInputY5Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Oct)))+(area * (getResources().getInteger(R.integer.difInputY5Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Nov)))+(area * (getResources().getInteger(R.integer.difInputY5Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Dec)))+(area * (getResources().getInteger(R.integer.difInputY5Dec))));
                        }
                    }else {
                        if (labor == "labor") {
                            jan = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Jan))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY5Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Feb))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY5Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Mar))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY5Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Apr))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY5Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5May))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY5May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Jun))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY5Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Jul))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY5Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Aug))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY5Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Sep))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY5Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Oct))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY5Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Nov))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY5Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Dec))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY5Dec))));
                        } else {
                            jan = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Dec))));
                        }
                    }

                }else if (main =="graft"){
                    setText(jlb, "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText(fblb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(mrlb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(ablb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(mylb, "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText(jnlb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText(jllb, "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText(aglb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(splb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(oclb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(nvlb, "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText(dclb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");

                    if (relat == "extra"){

                        if (labor == "labor"){
                            jan = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Jan)))+(area * (getResources().getInteger(R.integer.GraftingLaborY5Jan)))+(area * (getResources().getInteger(R.integer.difInputY5Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Feb)))+(area * (getResources().getInteger(R.integer.GraftingLaborY5Feb)))+(area * (getResources().getInteger(R.integer.difInputY5Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Mar)))+(area * (getResources().getInteger(R.integer.GraftingLaborY5Mar)))+(area * (getResources().getInteger(R.integer.difInputY5Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Apr)))+(area * (getResources().getInteger(R.integer.GraftingLaborY5Apr)))+(area * (getResources().getInteger(R.integer.difInputY5Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5May)))+(area * (getResources().getInteger(R.integer.GraftingLaborY5May)))+(area * (getResources().getInteger(R.integer.difInputY5May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Jun)))+(area * (getResources().getInteger(R.integer.GraftingLaborY5Jun)))+(area * (getResources().getInteger(R.integer.difInputY5Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Jul)))+(area * (getResources().getInteger(R.integer.GraftingLaborY5Jul)))+(area * (getResources().getInteger(R.integer.difInputY5Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Aug)))+(area * (getResources().getInteger(R.integer.GraftingLaborY5Aug)))+(area * (getResources().getInteger(R.integer.difInputY5Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Sep)))+(area * (getResources().getInteger(R.integer.GraftingLaborY5Sep)))+(area * (getResources().getInteger(R.integer.difInputY5Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Oct)))+(area * (getResources().getInteger(R.integer.GraftingLaborY5Oct)))+(area * (getResources().getInteger(R.integer.difInputY5Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Nov)))+(area * (getResources().getInteger(R.integer.GraftingLaborY5Nov)))+(area * (getResources().getInteger(R.integer.difInputY5Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Dec)))+(area * (getResources().getInteger(R.integer.GraftingLaborY5Dec)))+(area * (getResources().getInteger(R.integer.difInputY5Dec))));
                        }else{
                            jan = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Jan)))+(area * (getResources().getInteger(R.integer.difInputY5Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Feb)))+(area * (getResources().getInteger(R.integer.difInputY5Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Mar)))+(area * (getResources().getInteger(R.integer.difInputY5Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Apr)))+(area * (getResources().getInteger(R.integer.difInputY5Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5May)))+(area * (getResources().getInteger(R.integer.difInputY5May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Jun)))+(area * (getResources().getInteger(R.integer.difInputY5Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Jul)))+(area * (getResources().getInteger(R.integer.difInputY5Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Aug)))+(area * (getResources().getInteger(R.integer.difInputY5Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Sep)))+(area * (getResources().getInteger(R.integer.difInputY5Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Oct)))+(area * (getResources().getInteger(R.integer.difInputY5Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Nov)))+(area * (getResources().getInteger(R.integer.difInputY5Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Dec)))+(area * (getResources().getInteger(R.integer.difInputY5Dec))));
                        }

                    }else{
                        if (labor == "labor"){
                            jan = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Jan)))+(area * (getResources().getInteger(R.integer.GraftingLaborY5Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Feb)))+(area * (getResources().getInteger(R.integer.GraftingLaborY5Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Mar)))+(area * (getResources().getInteger(R.integer.GraftingLaborY5Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Apr)))+(area * (getResources().getInteger(R.integer.GraftingLaborY5Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5May)))+(area * (getResources().getInteger(R.integer.GraftingLaborY5May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Jun)))+(area * (getResources().getInteger(R.integer.GraftingLaborY5Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Jul)))+(area * (getResources().getInteger(R.integer.GraftingLaborY5Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Aug)))+(area * (getResources().getInteger(R.integer.GraftingLaborY5Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Sep)))+(area * (getResources().getInteger(R.integer.GraftingLaborY5Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Oct)))+(area * (getResources().getInteger(R.integer.GraftingLaborY5Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Nov)))+(area * (getResources().getInteger(R.integer.GraftingLaborY5Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Dec)))+(area * (getResources().getInteger(R.integer.GraftingLaborY5Dec))));
                        }else{
                            jan = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Dec))));
                        }
                    }

                }else if (main =="extra"){
                    setText(jlb, "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText(fblb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(mrlb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(ablb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(mylb, "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText(jnlb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText(jllb, "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText(aglb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(splb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(oclb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(nvlb, "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText(dclb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");

                    if (labor == "labor"){
                        jan = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY5Jan)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Jan))));
                        feb = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY5Feb)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Feb))));
                        mar = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY5Mar)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Mar))));
                        apr = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY5Apr)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Apr))));
                        may = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY5May)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY5May))));
                        jun = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY5Jun)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Jun))));
                        jul = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY5Jul)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Jul))));
                        aug = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY5Aug)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Aug))));
                        sep = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY5Sep)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Sep))));
                        oct = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY5Oct)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Oct))));
                        nov = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY5Nov)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Nov))));
                        dec = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY5Dec)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY5Dec))));
                    }else{
                        jan = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY5Jan))));
                        feb = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY5Feb))));
                        mar = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY5Mar))));
                        apr = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY5Apr))));
                        may = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY5May))));
                        jun = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY5Jun))));
                        jul = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY5Jul))));
                        aug = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY5Aug))));
                        sep = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY5Sep))));
                        oct = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY5Oct))));
                        nov = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY5Nov))));
                        dec = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY5Dec))));
                    }

                }else{
                    setText(jlb, "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText(fblb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(mrlb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(ablb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(mylb, "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText(jnlb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText(jllb, "P&D Control Foliar + Maintenance + Harvest, ferment, dry, sell");
                    setText(aglb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(splb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(oclb, "P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    setText(nvlb, "Herbiciding OR mechanical manual weeding + Application of lime, organic fertilizer + P&D Control Foliar + Production/shape/Reducing mother trees branches + Shape pruning + Harvest, ferment, dry, sell");
                    setText(dclb, "Fertilizing NPK, Cocoa Fertilizer, foliar at planting + P&D Control Foliar + Maintenance + Sanitation + Harvest, ferment, dry, sell");
                    if (relat == "extra"){
                        if (labor == "labor"){
                            jan = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Jan)))+(area * (getResources().getInteger(R.integer.GAPSLaborY5Jan)))+(area * (getResources().getInteger(R.integer.difInputY5Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Feb)))+(area * (getResources().getInteger(R.integer.GAPSLaborY5Feb)))+(area * (getResources().getInteger(R.integer.difInputY5Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Mar)))+(area * (getResources().getInteger(R.integer.GAPSLaborY5Mar)))+(area * (getResources().getInteger(R.integer.difInputY5Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Apr)))+(area * (getResources().getInteger(R.integer.GAPSLaborY5Apr)))+(area * (getResources().getInteger(R.integer.difInputY5Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5May)))+(area * (getResources().getInteger(R.integer.GAPSLaborY5May)))+(area * (getResources().getInteger(R.integer.difInputY5May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Jun)))+(area * (getResources().getInteger(R.integer.GAPSLaborY5Jun)))+(area * (getResources().getInteger(R.integer.difInputY5Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Jul)))+(area * (getResources().getInteger(R.integer.GAPSLaborY5Jul)))+(area * (getResources().getInteger(R.integer.difInputY5Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Aug)))+(area * (getResources().getInteger(R.integer.GAPSLaborY5Aug)))+(area * (getResources().getInteger(R.integer.difInputY5Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Sep)))+(area * (getResources().getInteger(R.integer.GAPSLaborY5Sep)))+(area * (getResources().getInteger(R.integer.difInputY5Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Oct)))+(area * (getResources().getInteger(R.integer.GAPSLaborY5Oct)))+(area * (getResources().getInteger(R.integer.difInputY5Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Nov)))+(area * (getResources().getInteger(R.integer.GAPSLaborY5Nov)))+(area * (getResources().getInteger(R.integer.difInputY5Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Dec)))+(area * (getResources().getInteger(R.integer.GAPSLaborY5Dec)))+(area * (getResources().getInteger(R.integer.difInputY5Dec))));
                        }else{
                            jan = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Jan)))+(area * (getResources().getInteger(R.integer.difInputY5Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Feb)))+(area * (getResources().getInteger(R.integer.difInputY5Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Mar)))+(area * (getResources().getInteger(R.integer.difInputY5Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Apr)))+(area * (getResources().getInteger(R.integer.difInputY5Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5May)))+(area * (getResources().getInteger(R.integer.difInputY5May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Jun)))+(area * (getResources().getInteger(R.integer.difInputY5Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Jul)))+(area * (getResources().getInteger(R.integer.difInputY5Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Aug)))+(area * (getResources().getInteger(R.integer.difInputY5Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Sep)))+(area * (getResources().getInteger(R.integer.difInputY5Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Oct)))+(area * (getResources().getInteger(R.integer.difInputY5Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Nov)))+(area * (getResources().getInteger(R.integer.difInputY5Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Dec)))+(area * (getResources().getInteger(R.integer.difInputY5Dec))));
                        }
                    }else{
                        if (labor == "labor"){
                            jan = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Jan)))+(area * (getResources().getInteger(R.integer.GAPSLaborY5Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Feb)))+(area * (getResources().getInteger(R.integer.GAPSLaborY5Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Mar)))+(area * (getResources().getInteger(R.integer.GAPSLaborY5Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Apr)))+(area * (getResources().getInteger(R.integer.GAPSLaborY5Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5May)))+(area * (getResources().getInteger(R.integer.GAPSLaborY5May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Jun)))+(area * (getResources().getInteger(R.integer.GAPSLaborY5Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Jul)))+(area * (getResources().getInteger(R.integer.GAPSLaborY5Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Aug)))+(area * (getResources().getInteger(R.integer.GAPSLaborY5Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Sep)))+(area * (getResources().getInteger(R.integer.GAPSLaborY5Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Oct)))+(area * (getResources().getInteger(R.integer.GAPSLaborY5Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Nov)))+(area * (getResources().getInteger(R.integer.GAPSLaborY5Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Dec)))+(area * (getResources().getInteger(R.integer.GAPSLaborY5Dec))));
                        }else{
                            jan = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Dec))));
                        }

                    }

                }

            }

        }

        setText(jvl,String.valueOf(decF.format(jan)));
        setText(fbvl, String.valueOf(decF.format(feb)));
        setText(mrvl, String.valueOf(decF.format(mar)));
        setText(abvl, String.valueOf(decF.format(apr)));
        setText(myvl, String.valueOf(decF.format(may)));
        setText(jnvl, String.valueOf(decF.format(jun)));
        setText(jlvl, String.valueOf(decF.format(jul)));
        setText(agvl, String.valueOf(decF.format(aug)));
        setText(spvl, String.valueOf(decF.format(sep)));
        setText(ocvl, String.valueOf(decF.format(oct)));
        setText(nvvl, String.valueOf(decF.format(nov)));
        setText(dcvl, String.valueOf(decF.format(dec)));
    }

    private void setText(TextView textField, String text) {
        if (textField != null) {
            textField.setText(text);
        }
    }
}
