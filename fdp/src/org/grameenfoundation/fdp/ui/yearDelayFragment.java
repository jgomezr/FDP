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
    private String p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18,p19,p20,p21,p22,p23,p24;
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
        p1 = getString(R.string.p1);
        p2 = getString(R.string.p2);
        p3 = getString(R.string.p3);
        p4 = getString(R.string.p4);
        p5 = getString(R.string.p5);
        p6 = getString(R.string.p6);
        p7 = getString(R.string.p7);
        p8 = getString(R.string.p8);
        p9 = getString(R.string.p9);
        p10 = getString(R.string.p10);
        p11 = getString(R.string.p11);
        p12 = getString(R.string.p12);
        p13 = getString(R.string.p13);
        p14 = getString(R.string.p14);
        p15 = getString(R.string.p15);
        p16 = getString(R.string.p16);
        p17 = getString(R.string.p17);
        p18 = getString(R.string.p18);
        p19 = getString(R.string.p19);
        p20 = getString(R.string.p20);
        p21 = getString(R.string.p21);
        p22 = getString(R.string.p22);
        p23 = getString(R.string.p23);
        p24 = getString(R.string.p24);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public void calc(String main, final String relat, final String labor, final Double area, String yearStart, String yearLaunch){
        int startYear = Integer.parseInt(yearStart.replaceAll("[^0-9]+", ""));
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
        DecimalFormat decF = new DecimalFormat("Ghs ###,###,###");

        if (launchYear < startYear){
            setText(jlb, p24);
            setText(fblb, "");
            setText(mrlb, p12);
            setText(ablb, p16+" + "+p19+" + "+p22);
            setText(mylb, p14+" + "+p15+" + "+p16+" + "+p19+" + "+p21+" + "+p24);
            setText(jnlb, p21+" + "+p24);
            setText(jllb, "");
            setText(aglb, p12);
            setText(splb, p14+" + "+p16+" + "+p19+" + "+p21+" + "+p22+" + "+p24);
            setText(oclb, p15+" + "+p19+" + "+p21+" + "+p24);
            setText(nvlb, p19+" + "+p21+" + "+p24);
            setText(dclb, p16+" + "+p23+" + "+p24);
            if (labor == "labor") {
                jan = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Jan)+ getResources().getInteger(R.integer.GAPSLaborY1Jan)));
                feb = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Feb)+ getResources().getInteger(R.integer.GAPSLaborY1Feb)));
                mar = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Mar)+ getResources().getInteger(R.integer.GAPSLaborY1Mar)));
                apr = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Apr)+ getResources().getInteger(R.integer.GAPSLaborY1Apr)));
                may = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1May)+ getResources().getInteger(R.integer.GAPSLaborY1May)));
                jun = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Jun)+ getResources().getInteger(R.integer.GAPSLaborY1Jun)));
                jul = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Jul)+ getResources().getInteger(R.integer.GAPSLaborY1Jul)));
                aug = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Aug)+ getResources().getInteger(R.integer.GAPSLaborY1Aug)));
                sep = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Sep)+ getResources().getInteger(R.integer.GAPSLaborY1Sep)));
                oct = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Oct)+ getResources().getInteger(R.integer.GAPSLaborY1Oct)));
                nov = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Nov)+ getResources().getInteger(R.integer.GAPSLaborY1Nov)));
                dec = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Dec)+ getResources().getInteger(R.integer.GAPSLaborY1Dec)));
            }else if(labor =="season") {
                jan = (int) (area * getResources().getInteger(R.integer.GAPSInputY1Jan));
                feb = (int) (area * getResources().getInteger(R.integer.GAPSInputY1Feb));
                mar = (int) (area * getResources().getInteger(R.integer.GAPSInputY1Mar));
                apr = (int) (area * getResources().getInteger(R.integer.GAPSInputY1Apr));
                may = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1May)+ getResources().getInteger(R.integer.GAPSLaborY1May)));
                jun = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Jun)+ getResources().getInteger(R.integer.GAPSLaborY1Jun)));
                jul = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Jul)+ getResources().getInteger(R.integer.GAPSLaborY1Jul)));
                aug = (int) (area * getResources().getInteger(R.integer.GAPSInputY1Aug));
                sep = (int) (area * getResources().getInteger(R.integer.GAPSInputY1Sep));
                oct = (int) (area * getResources().getInteger(R.integer.GAPSInputY1Oct));
                nov = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Nov)+ getResources().getInteger(R.integer.GAPSLaborY1Nov)));
                dec = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Dec)+ getResources().getInteger(R.integer.GAPSLaborY1Dec)));
            }else {
                jan = (int) (area * getResources().getInteger(R.integer.GAPSInputY1Jan));
                feb = (int) (area * getResources().getInteger(R.integer.GAPSInputY1Feb));
                mar = (int) (area * getResources().getInteger(R.integer.GAPSInputY1Mar));
                apr = (int) (area * getResources().getInteger(R.integer.GAPSInputY1Apr));
                may = (int) (area * getResources().getInteger(R.integer.GAPSInputY1May));
                jun = (int) (area * getResources().getInteger(R.integer.GAPSInputY1Jun));
                jul = (int) (area * getResources().getInteger(R.integer.GAPSInputY1Jul));
                aug = (int) (area * getResources().getInteger(R.integer.GAPSInputY1Aug));
                sep = (int) (area * getResources().getInteger(R.integer.GAPSInputY1Sep));
                oct = (int) (area * getResources().getInteger(R.integer.GAPSInputY1Oct));
                nov = (int) (area * getResources().getInteger(R.integer.GAPSInputY1Nov));
                dec = (int) (area * getResources().getInteger(R.integer.GAPSInputY1Dec));
            }
        }else{
            if (yearLaunch.equals("1")&&(yearStart.equals("Year 1")||yearStart.equals("Year 2")||yearStart.equals("Year 3")||yearStart.equals("Year 4")||yearStart.equals("Year 5")||yearStart.equals("Year 6")||yearStart.equals("Year 7")||yearStart.equals("Tahun 1")||yearStart.equals("Tahun 2")||yearStart.equals("Tahun 3")||yearStart.equals("Tahun 4")||yearStart.equals("Tahun 5")||yearStart.equals("Tahun 6")||yearStart.equals("Tahun 7"))){
                if (main == "replant"){
                    setText(jlb, p24);
                    setText(fblb, "");
                    setText(mrlb, "");
                    setText(ablb, p16+" + "+p19);
                    setText(mylb, p16+" + "+p21+" + "+p24);
                    setText(jnlb, p24);
                    setText(jllb, p1);
                    setText(aglb, p1);
                    setText(splb, p1);
                    setText(oclb, p2+" + "+p3);
                    setText(nvlb, p2+" + "+p3+" + "+p7);
                    setText(dclb, p2+" + "+p7);
                    if (relat == "extra"){
                        if (labor == "labor"){
                            jan = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Jan)+getResources().getInteger(R.integer.ReplantingLaborY1Jan)+getResources().getInteger(R.integer.difInputY1Jan)));
                            feb = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Feb)+getResources().getInteger(R.integer.ReplantingLaborY1Feb)+getResources().getInteger(R.integer.difInputY1Feb)));
                            mar = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Mar)+getResources().getInteger(R.integer.ReplantingLaborY1Mar)+getResources().getInteger(R.integer.difInputY1Mar)));
                            apr = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Apr)+getResources().getInteger(R.integer.ReplantingLaborY1Apr)+getResources().getInteger(R.integer.difInputY1Apr)));
                            may = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1May)+getResources().getInteger(R.integer.ReplantingLaborY1May)+getResources().getInteger(R.integer.difInputY1May)));
                            jun = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Jun)+getResources().getInteger(R.integer.ReplantingLaborY1Jun)+getResources().getInteger(R.integer.difInputY1Jun)));
                            jul = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Jul)+getResources().getInteger(R.integer.ReplantingLaborY1Jul)+getResources().getInteger(R.integer.difInputY1Jul)));
                            aug = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Aug)+getResources().getInteger(R.integer.ReplantingLaborY1Aug)+getResources().getInteger(R.integer.difInputY1Aug)));
                            sep = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Sep)+getResources().getInteger(R.integer.ReplantingLaborY1Sep)+getResources().getInteger(R.integer.difInputY1Sep)));
                            oct = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Oct)+getResources().getInteger(R.integer.ReplantingLaborY1Oct)+getResources().getInteger(R.integer.difInputY1Oct)));
                            nov = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Nov)+getResources().getInteger(R.integer.ReplantingLaborY1Nov)+getResources().getInteger(R.integer.difInputY1Nov)));
                            dec = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Dec)+getResources().getInteger(R.integer.ReplantingLaborY1Dec)+getResources().getInteger(R.integer.difInputY1Dec)));
                        }else if(labor =="season") {
                            jan = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Jan)+getResources().getInteger(R.integer.difInputY1Jan)));
                            feb = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Feb)+getResources().getInteger(R.integer.difInputY1Feb)));
                            mar = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Mar)+getResources().getInteger(R.integer.difInputY1Mar)));
                            apr = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Apr)+ getResources().getInteger(R.integer.difInputY1Apr)));
                            may = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1May)+getResources().getInteger(R.integer.ReplantingLaborY1May)+getResources().getInteger(R.integer.difInputY1May)));
                            jun = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Jun)+getResources().getInteger(R.integer.ReplantingLaborY1Jun)+getResources().getInteger(R.integer.difInputY1Jun)));
                            jul = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Jul)+getResources().getInteger(R.integer.ReplantingLaborY1Jul)+getResources().getInteger(R.integer.difInputY1Jul)));
                            aug = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Aug)+getResources().getInteger(R.integer.difInputY1Aug)));
                            sep = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Sep)+getResources().getInteger(R.integer.difInputY1Sep)));
                            oct = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Oct)+getResources().getInteger(R.integer.difInputY1Oct)));
                            nov = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Nov)+getResources().getInteger(R.integer.ReplantingLaborY1Nov)+getResources().getInteger(R.integer.difInputY1Nov)));
                            dec = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Dec)+getResources().getInteger(R.integer.ReplantingLaborY1Dec)+getResources().getInteger(R.integer.difInputY1Dec)));
                        }else{
                            jan = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Jan)+getResources().getInteger(R.integer.difInputY1Jan)));
                            feb = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Feb)+getResources().getInteger(R.integer.difInputY1Feb)));
                            mar = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Mar)+getResources().getInteger(R.integer.difInputY1Mar)));
                            apr = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Apr)+getResources().getInteger(R.integer.difInputY1Apr)));
                            may = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1May)+getResources().getInteger(R.integer.difInputY1May)));
                            jun = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Jun)+getResources().getInteger(R.integer.difInputY1Jun)));
                            jul = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Jul)+getResources().getInteger(R.integer.difInputY1Jul)));
                            aug = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Aug)+getResources().getInteger(R.integer.difInputY1Aug)));
                            sep = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Sep)+getResources().getInteger(R.integer.difInputY1Sep)));
                            oct = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Oct)+getResources().getInteger(R.integer.difInputY1Oct)));
                            nov = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Nov)+getResources().getInteger(R.integer.difInputY1Nov)));
                            dec = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Dec)+getResources().getInteger(R.integer.difInputY1Dec)));
                        }
                    }else {
                        if (labor == "labor") {
                            jan = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Jan)+getResources().getInteger(R.integer.ReplantingLaborY1Jan)));
                            feb = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Feb)+getResources().getInteger(R.integer.ReplantingLaborY1Feb)));
                            mar = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Mar)+getResources().getInteger(R.integer.ReplantingLaborY1Mar)));
                            apr = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Apr)+area * (getResources().getInteger(R.integer.ReplantingLaborY1Apr))));
                            may = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1May)+getResources().getInteger(R.integer.ReplantingLaborY1May)));
                            jun = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Jun)+getResources().getInteger(R.integer.ReplantingLaborY1Jun)));
                            jul = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Jul)+getResources().getInteger(R.integer.ReplantingLaborY1Jul)));
                            aug = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Aug)+getResources().getInteger(R.integer.ReplantingLaborY1Aug)));
                            sep = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Sep)+getResources().getInteger(R.integer.ReplantingLaborY1Sep)));
                            oct = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Oct)+getResources().getInteger(R.integer.ReplantingLaborY1Oct)));
                            nov = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Nov)+getResources().getInteger(R.integer.ReplantingLaborY1Nov)));
                            dec = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Dec)+getResources().getInteger(R.integer.ReplantingLaborY1Dec)));
                        }else if(labor =="season") {
                            jan = (int) (area * getResources().getInteger(R.integer.ReplantingInputY1Jan));
                            feb = (int) (area * getResources().getInteger(R.integer.ReplantingInputY1Feb));
                            mar = (int) (area * getResources().getInteger(R.integer.ReplantingInputY1Mar));
                            apr = (int) (area * getResources().getInteger(R.integer.ReplantingInputY1Apr));
                            may = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1May)+getResources().getInteger(R.integer.ReplantingLaborY1May)));
                            jun = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Jun)+getResources().getInteger(R.integer.ReplantingLaborY1Jun)));
                            jul = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Jul)+getResources().getInteger(R.integer.ReplantingLaborY1Jul)));
                            aug = (int) (area * getResources().getInteger(R.integer.ReplantingInputY1Aug));
                            sep = (int) (area * getResources().getInteger(R.integer.ReplantingInputY1Sep));
                            oct = (int) (area * getResources().getInteger(R.integer.ReplantingInputY1Oct));
                            nov = (int) (area * getResources().getInteger(R.integer.ReplantingInputY1Nov)+getResources().getInteger(R.integer.ReplantingLaborY1Nov));
                            dec = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Dec)+getResources().getInteger(R.integer.ReplantingLaborY1Dec)));
                        }else {
                            jan = (int) (area * getResources().getInteger(R.integer.ReplantingInputY1Jan));
                            feb = (int) (area * getResources().getInteger(R.integer.ReplantingInputY1Feb));
                            mar = (int) (area * getResources().getInteger(R.integer.ReplantingInputY1Mar));
                            apr = (int) (area * getResources().getInteger(R.integer.ReplantingInputY1Apr));
                            may = (int) (area * getResources().getInteger(R.integer.ReplantingInputY1May));
                            jun = (int) (area * getResources().getInteger(R.integer.ReplantingInputY1Jun));
                            jul = (int) (area * getResources().getInteger(R.integer.ReplantingInputY1Jul));
                            aug = (int) (area * getResources().getInteger(R.integer.ReplantingInputY1Aug));
                            sep = (int) (area * getResources().getInteger(R.integer.ReplantingInputY1Sep));
                            oct = (int) (area * getResources().getInteger(R.integer.ReplantingInputY1Oct));
                            nov = (int) (area * getResources().getInteger(R.integer.ReplantingInputY1Nov));
                            dec = (int) (area * getResources().getInteger(R.integer.ReplantingInputY1Dec));
                        }
                    }

                }else if (main =="graft"){
                    setText(jlb, p24);
                    setText(fblb, "");
                    setText(mrlb, "");
                    setText(ablb, p8+" + "+p9+" + "+p19);
                    setText(mylb, p9+" + "+p10+" + "+p14+" + "+ p15+" + "+ p16+" + "+ p19+" + "+ p20+" + "+ p24);
                    setText(jnlb, p10+" + "+p16+" + "+p20+" + "+p24);
                    setText(jllb, p10+" + "+p16);
                    setText(aglb, p8+" + "+p13);
                    setText(splb, p9+" + "+p10+" + "+p11+" + "+p14+" + "+p16+" + "+p18+" + "+p19+" + "+p20+" + "+p24);
                    setText(oclb, p9+" + "+p10+" + "+p11+" + "+p15+" + "+p16+" + "+p19+" + "+p20+" + "+p24);
                    setText(nvlb, p11+" + "+p16+" + "+p24);
                    setText(dclb, p13+" + "+p16+" + "+p18);

                    if (relat == "extra"){

                        if (labor == "labor"){
                            jan = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Jan)+getResources().getInteger(R.integer.GraftingLaborY1Jan)+getResources().getInteger(R.integer.difInputY1Jan)));
                            feb = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Feb)+getResources().getInteger(R.integer.GraftingLaborY1Feb)+getResources().getInteger(R.integer.difInputY1Feb)));
                            mar = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Mar)+getResources().getInteger(R.integer.GraftingLaborY1Mar)+getResources().getInteger(R.integer.difInputY1Mar)));
                            apr = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Apr)+getResources().getInteger(R.integer.GraftingLaborY1Apr)+getResources().getInteger(R.integer.difInputY1Apr)));
                            may = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1May)+getResources().getInteger(R.integer.GraftingLaborY1May)+getResources().getInteger(R.integer.difInputY1May)));
                            jun = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Jun)+getResources().getInteger(R.integer.GraftingLaborY1Jun)+getResources().getInteger(R.integer.difInputY1Jun)));
                            jul = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Jul)+getResources().getInteger(R.integer.GraftingLaborY1Jul)+getResources().getInteger(R.integer.difInputY1Jul)));
                            aug = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Aug)+getResources().getInteger(R.integer.GraftingLaborY1Aug)+getResources().getInteger(R.integer.difInputY1Aug)));
                            sep = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Sep)+getResources().getInteger(R.integer.GraftingLaborY1Sep)+getResources().getInteger(R.integer.difInputY1Sep)));
                            oct = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Oct)+getResources().getInteger(R.integer.GraftingLaborY1Oct)+getResources().getInteger(R.integer.difInputY1Oct)));
                            nov = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Nov)+getResources().getInteger(R.integer.GraftingLaborY1Nov)+getResources().getInteger(R.integer.difInputY1Nov)));
                            dec = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Dec)+getResources().getInteger(R.integer.GraftingLaborY1Dec)+getResources().getInteger(R.integer.difInputY1Dec)));
                        }else if(labor =="season") {
                            jan = (int) (area * getResources().getInteger(R.integer.GraftingInputY1Jan)+getResources().getInteger(R.integer.difInputY1Jan));
                            feb = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Feb)+getResources().getInteger(R.integer.difInputY1Feb)));
                            mar = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Mar)+getResources().getInteger(R.integer.difInputY1Mar)));
                            apr = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Apr)+getResources().getInteger(R.integer.difInputY1Apr)));
                            may = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1May)+getResources().getInteger(R.integer.GraftingLaborY1May)+getResources().getInteger(R.integer.difInputY1May)));
                            jun = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Jun)+getResources().getInteger(R.integer.GraftingLaborY1Jun)+getResources().getInteger(R.integer.difInputY1Jun)));
                            jul = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Jul)+getResources().getInteger(R.integer.GraftingLaborY1Jul)+getResources().getInteger(R.integer.difInputY1Jul)));
                            aug = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Aug)+getResources().getInteger(R.integer.difInputY1Aug)));
                            sep = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Sep)+getResources().getInteger(R.integer.difInputY1Sep)));
                            oct = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Oct)+getResources().getInteger(R.integer.difInputY1Oct)));
                            nov = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Nov)+getResources().getInteger(R.integer.GraftingLaborY1Nov)+getResources().getInteger(R.integer.difInputY1Nov)));
                            dec = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Dec)+getResources().getInteger(R.integer.GraftingLaborY1Dec)+getResources().getInteger(R.integer.difInputY1Dec)));
                        }else{
                            jan = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Jan)+getResources().getInteger(R.integer.difInputY1Jan)));
                            feb = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Feb)+getResources().getInteger(R.integer.difInputY1Feb)));
                            mar = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Mar)+getResources().getInteger(R.integer.difInputY1Mar)));
                            apr = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Apr)+getResources().getInteger(R.integer.difInputY1Apr)));
                            may = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1May)+getResources().getInteger(R.integer.difInputY1May)));
                            jun = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Jun)+getResources().getInteger(R.integer.difInputY1Jun)));
                            jul = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Jul)+getResources().getInteger(R.integer.difInputY1Jul)));
                            aug = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Aug)+getResources().getInteger(R.integer.difInputY1Aug)));
                            sep = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Sep)+getResources().getInteger(R.integer.difInputY1Sep)));
                            oct = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Oct)+getResources().getInteger(R.integer.difInputY1Oct)));
                            nov = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Nov)+getResources().getInteger(R.integer.difInputY1Nov)));
                            dec = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Dec)+getResources().getInteger(R.integer.difInputY1Dec)));
                        }

                    }else{
                        if (labor == "labor"){
                            jan = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Jan)+getResources().getInteger(R.integer.GraftingLaborY1Jan)));
                            feb = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Feb)+getResources().getInteger(R.integer.GraftingLaborY1Feb)));
                            mar = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Mar)+getResources().getInteger(R.integer.GraftingLaborY1Mar)));
                            apr = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Apr)+getResources().getInteger(R.integer.GraftingLaborY1Apr)));
                            may = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1May)+getResources().getInteger(R.integer.GraftingLaborY1May)));
                            jun = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Jun)+getResources().getInteger(R.integer.GraftingLaborY1Jun)));
                            jul = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Jul)+getResources().getInteger(R.integer.GraftingLaborY1Jul)));
                            aug = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Aug)+getResources().getInteger(R.integer.GraftingLaborY1Aug)));
                            sep = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Sep)+getResources().getInteger(R.integer.GraftingLaborY1Sep)));
                            oct = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Oct)+getResources().getInteger(R.integer.GraftingLaborY1Oct)));
                            nov = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Nov)+getResources().getInteger(R.integer.GraftingLaborY1Nov)));
                            dec = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Dec)+getResources().getInteger(R.integer.GraftingLaborY1Dec)));
                        }else if(labor =="season") {
                            jan = (int) (area * getResources().getInteger(R.integer.GraftingInputY1Jan));
                            feb = (int) (area * getResources().getInteger(R.integer.GraftingInputY1Feb));
                            mar = (int) (area * getResources().getInteger(R.integer.GraftingInputY1Mar));
                            apr = (int) (area * getResources().getInteger(R.integer.GraftingInputY1Apr));
                            may = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1May)+getResources().getInteger(R.integer.GraftingLaborY1May)));
                            jun = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Jun)+getResources().getInteger(R.integer.GraftingLaborY1Jun)));
                            jul = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Jul)+getResources().getInteger(R.integer.GraftingLaborY1Jul)));
                            aug = (int) (area * getResources().getInteger(R.integer.GraftingInputY1Aug));
                            sep = (int) (area * getResources().getInteger(R.integer.GraftingInputY1Sep));
                            oct = (int) (area * getResources().getInteger(R.integer.GraftingInputY1Oct));
                            nov = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Nov)+getResources().getInteger(R.integer.GraftingLaborY1Nov)));
                            dec = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Dec)+getResources().getInteger(R.integer.GraftingLaborY1Dec)));
                        }else{
                            jan = (int) (area * getResources().getInteger(R.integer.GraftingInputY1Jan));
                            feb = (int) (area * getResources().getInteger(R.integer.GraftingInputY1Feb));
                            mar = (int) (area * getResources().getInteger(R.integer.GraftingInputY1Mar));
                            apr = (int) (area * getResources().getInteger(R.integer.GraftingInputY1Apr));
                            may = (int) (area * getResources().getInteger(R.integer.GraftingInputY1May));
                            jun = (int) (area * getResources().getInteger(R.integer.GraftingInputY1Jun));
                            jul = (int) (area * getResources().getInteger(R.integer.GraftingInputY1Jul));
                            aug = (int) (area * getResources().getInteger(R.integer.GraftingInputY1Aug));
                            sep = (int) (area * getResources().getInteger(R.integer.GraftingInputY1Sep));
                            oct = (int) (area * getResources().getInteger(R.integer.GraftingInputY1Oct));
                            nov = (int) (area * getResources().getInteger(R.integer.GraftingInputY1Nov));
                            dec = (int) (area * getResources().getInteger(R.integer.GraftingInputY1Dec));
                        }
                    }

                }else if (main =="extra"){
                    setText(jlb, p24);
                    setText(fblb, "");
                    setText(mrlb, p12);
                    setText(ablb, p16+" + "+ p19+" + "+ p22);
                    setText(mylb, p14+" + "+ p15+" + "+ p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(jnlb, p21+" + "+p24);
                    setText(jllb, "");
                    setText(aglb, p12);
                    setText(splb, p14+" + "+ p16+" + "+ p19+" + "+ p21+" + "+ p22+" + "+ p24);
                    setText(oclb, p15+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(nvlb, p19+" + "+ p21+" + "+ p24);
                    setText(dclb, p16+" + "+p23+" + "+ p24);

                    if (labor == "labor"){
                        jan = (int) (area * (getResources().getInteger(R.integer.ExtraSoilInputY1Jan)+getResources().getInteger(R.integer.ExtraSoilLaborY1Jan)));
                        feb = (int) (area * (getResources().getInteger(R.integer.ExtraSoilInputY1Feb)+getResources().getInteger(R.integer.ExtraSoilLaborY1Feb)));
                        mar = (int) (area * (getResources().getInteger(R.integer.ExtraSoilInputY1Mar)+getResources().getInteger(R.integer.ExtraSoilLaborY1Mar)));
                        apr = (int) (area * (getResources().getInteger(R.integer.ExtraSoilInputY1Apr)+getResources().getInteger(R.integer.ExtraSoilLaborY1Apr)));
                        may = (int) (area * (getResources().getInteger(R.integer.ExtraSoilInputY1May)+getResources().getInteger(R.integer.ExtraSoilLaborY1May)));
                        jun = (int) (area * (getResources().getInteger(R.integer.ExtraSoilInputY1Jun)+getResources().getInteger(R.integer.ExtraSoilLaborY1Jun)));
                        jul = (int) (area * (getResources().getInteger(R.integer.ExtraSoilInputY1Jul)+getResources().getInteger(R.integer.ExtraSoilLaborY1Jul)));
                        aug = (int) (area * (getResources().getInteger(R.integer.ExtraSoilInputY1Aug)+getResources().getInteger(R.integer.ExtraSoilLaborY1Aug)));
                        sep = (int) (area * (getResources().getInteger(R.integer.ExtraSoilInputY1Sep)+getResources().getInteger(R.integer.ExtraSoilLaborY1Sep)));
                        oct = (int) (area * (getResources().getInteger(R.integer.ExtraSoilInputY1Oct)+getResources().getInteger(R.integer.ExtraSoilLaborY1Oct)));
                        nov = (int) (area * (getResources().getInteger(R.integer.ExtraSoilInputY1Nov)+getResources().getInteger(R.integer.ExtraSoilLaborY1Nov)));
                        dec = (int) (area * (getResources().getInteger(R.integer.ExtraSoilInputY1Dec)+getResources().getInteger(R.integer.ExtraSoilLaborY1Dec)));
                    }else if(labor =="season") {
                        jan = (int) (area * getResources().getInteger(R.integer.ExtraSoilInputY1Jan));
                        feb = (int) (area * getResources().getInteger(R.integer.ExtraSoilInputY1Feb));
                        mar = (int) (area * getResources().getInteger(R.integer.ExtraSoilInputY1Mar));
                        apr = (int) (area * getResources().getInteger(R.integer.ExtraSoilInputY1Apr));
                        may = (int) (area * (getResources().getInteger(R.integer.ExtraSoilInputY1May)+getResources().getInteger(R.integer.ExtraSoilLaborY1May)));
                        jun = (int) (area * (getResources().getInteger(R.integer.ExtraSoilInputY1Jun)+getResources().getInteger(R.integer.ExtraSoilLaborY1Jun)));
                        jul = (int) (area * (getResources().getInteger(R.integer.ExtraSoilInputY1Jul)+getResources().getInteger(R.integer.ExtraSoilLaborY1Jul)));
                        aug = (int) (area * getResources().getInteger(R.integer.ExtraSoilInputY1Aug));
                        sep = (int) (area * getResources().getInteger(R.integer.ExtraSoilInputY1Sep));
                        oct = (int) (area * getResources().getInteger(R.integer.ExtraSoilInputY1Oct));
                        nov = (int) (area * (getResources().getInteger(R.integer.ExtraSoilInputY1Nov)+getResources().getInteger(R.integer.ExtraSoilLaborY1Nov)));
                        dec = (int) (area * (getResources().getInteger(R.integer.ExtraSoilInputY1Dec)+getResources().getInteger(R.integer.ExtraSoilLaborY1Dec)));
                    }else{
                        jan = (int) (area * getResources().getInteger(R.integer.ExtraSoilInputY1Jan));
                        feb = (int) (area * getResources().getInteger(R.integer.ExtraSoilInputY1Feb));
                        mar = (int) (area * getResources().getInteger(R.integer.ExtraSoilInputY1Mar));
                        apr = (int) (area * getResources().getInteger(R.integer.ExtraSoilInputY1Apr));
                        may = (int) (area * getResources().getInteger(R.integer.ExtraSoilInputY1May));
                        jun = (int) (area * getResources().getInteger(R.integer.ExtraSoilInputY1Jun));
                        jul = (int) (area * getResources().getInteger(R.integer.ExtraSoilInputY1Jul));
                        aug = (int) (area * getResources().getInteger(R.integer.ExtraSoilInputY1Aug));
                        sep = (int) (area * getResources().getInteger(R.integer.ExtraSoilInputY1Sep));
                        oct = (int) (area * getResources().getInteger(R.integer.ExtraSoilInputY1Oct));
                        nov = (int) (area * getResources().getInteger(R.integer.ExtraSoilInputY1Nov));
                        dec = (int) (area * getResources().getInteger(R.integer.ExtraSoilInputY1Dec));
                    }

                }else{
                    setText(jlb, p24);
                    setText(fblb, "");
                    setText(mrlb, p12);
                    setText(ablb, p16+" + "+ p19+" + "+ p22);
                    setText(mylb, p14+" + "+ p15+" + "+ p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(jnlb, p21+" + "+ p24);
                    setText(jllb, "");
                    setText(aglb, p12);
                    setText(splb, p14+" + "+ p16+" + "+ p19+" + "+ p21+" + "+ p22+" + "+ p24);
                    setText(oclb, p15+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(nvlb, p19+" + "+ p21+" + "+ p24);
                    setText(dclb, p16+" + "+ p23+" + "+ p24);
                    if (relat == "extra"){
                        if (labor == "labor"){
                            jan = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Jan)+getResources().getInteger(R.integer.GAPSLaborY1Jan)+getResources().getInteger(R.integer.difInputY1Jan)));
                            feb = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Feb)+getResources().getInteger(R.integer.GAPSLaborY1Feb)+getResources().getInteger(R.integer.difInputY1Feb)));
                            mar = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Mar)+getResources().getInteger(R.integer.GAPSLaborY1Mar)+getResources().getInteger(R.integer.difInputY1Mar)));
                            apr = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Apr)+getResources().getInteger(R.integer.GAPSLaborY1Apr)+getResources().getInteger(R.integer.difInputY1Apr)));
                            may = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1May)+getResources().getInteger(R.integer.GAPSLaborY1May)+getResources().getInteger(R.integer.difInputY1May)));
                            jun = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Jun)+getResources().getInteger(R.integer.GAPSLaborY1Jun)+getResources().getInteger(R.integer.difInputY1Jun)));
                            jul = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Jul)+getResources().getInteger(R.integer.GAPSLaborY1Jul)+getResources().getInteger(R.integer.difInputY1Jul)));
                            aug = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Aug)+getResources().getInteger(R.integer.GAPSLaborY1Aug)+getResources().getInteger(R.integer.difInputY1Aug)));
                            sep = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Sep)+getResources().getInteger(R.integer.GAPSLaborY1Sep)+getResources().getInteger(R.integer.difInputY1Sep)));
                            oct = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Oct)+getResources().getInteger(R.integer.GAPSLaborY1Oct)+getResources().getInteger(R.integer.difInputY1Oct)));
                            nov = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Nov)+getResources().getInteger(R.integer.GAPSLaborY1Nov)+getResources().getInteger(R.integer.difInputY1Nov)));
                            dec = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Dec)+getResources().getInteger(R.integer.GAPSLaborY1Dec)+getResources().getInteger(R.integer.difInputY1Dec)));
                        }else if(labor =="season") {
                            jan = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Jan)+getResources().getInteger(R.integer.difInputY1Jan)));
                            feb = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Feb)+getResources().getInteger(R.integer.difInputY1Feb)));
                            mar = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Mar)+getResources().getInteger(R.integer.difInputY1Mar)));
                            apr = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Apr)+getResources().getInteger(R.integer.difInputY1Apr)));
                            may = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1May)+getResources().getInteger(R.integer.GAPSLaborY1May)+getResources().getInteger(R.integer.difInputY1May)));
                            jun = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Jun)+getResources().getInteger(R.integer.GAPSLaborY1Jun)+getResources().getInteger(R.integer.difInputY1Jun)));
                            jul = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Jul)+getResources().getInteger(R.integer.GAPSLaborY1Jul)+getResources().getInteger(R.integer.difInputY1Jul)));
                            aug = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Aug)+getResources().getInteger(R.integer.difInputY1Aug)));
                            sep = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Sep)+getResources().getInteger(R.integer.difInputY1Sep)));
                            oct = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Oct)+getResources().getInteger(R.integer.difInputY1Oct)));
                            nov = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Nov)+getResources().getInteger(R.integer.GAPSLaborY1Nov)+getResources().getInteger(R.integer.difInputY1Nov)));
                            dec = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Dec)+getResources().getInteger(R.integer.GAPSLaborY1Dec)+getResources().getInteger(R.integer.difInputY1Dec)));
                        }else{
                            jan = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Jan)+getResources().getInteger(R.integer.difInputY1Jan)));
                            feb = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Feb)+getResources().getInteger(R.integer.difInputY1Feb)));
                            mar = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Mar)+getResources().getInteger(R.integer.difInputY1Mar)));
                            apr = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Apr)+getResources().getInteger(R.integer.difInputY1Apr)));
                            may = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1May)+getResources().getInteger(R.integer.difInputY1May)));
                            jun = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Jun)+getResources().getInteger(R.integer.difInputY1Jun)));
                            jul = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Jul)+getResources().getInteger(R.integer.difInputY1Jul)));
                            aug = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Aug)+getResources().getInteger(R.integer.difInputY1Aug)));
                            sep = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Sep)+getResources().getInteger(R.integer.difInputY1Sep)));
                            oct = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Oct)+getResources().getInteger(R.integer.difInputY1Oct)));
                            nov = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Nov)+getResources().getInteger(R.integer.difInputY1Nov)));
                            dec = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Dec)+getResources().getInteger(R.integer.difInputY1Dec)));
                        }
                    }else{
                        if (labor == "labor"){
                            jan = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Jan)+getResources().getInteger(R.integer.GAPSLaborY1Jan)));
                            feb = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Feb)+getResources().getInteger(R.integer.GAPSLaborY1Feb)));
                            mar = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Mar)+getResources().getInteger(R.integer.GAPSLaborY1Mar)));
                            apr = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Apr)+getResources().getInteger(R.integer.GAPSLaborY1Apr)));
                            may = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1May)+getResources().getInteger(R.integer.GAPSLaborY1May)));
                            jun = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Jun)+getResources().getInteger(R.integer.GAPSLaborY1Jun)));
                            jul = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Jul)+getResources().getInteger(R.integer.GAPSLaborY1Jul)));
                            aug = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Aug)+getResources().getInteger(R.integer.GAPSLaborY1Aug)));
                            sep = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Sep)+getResources().getInteger(R.integer.GAPSLaborY1Sep)));
                            oct = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Oct)+getResources().getInteger(R.integer.GAPSLaborY1Oct)));
                            nov = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Nov)+getResources().getInteger(R.integer.GAPSLaborY1Nov)));
                            dec = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Dec)+getResources().getInteger(R.integer.GAPSLaborY1Dec)));
                        }else if(labor =="season") {
                            jan = (int) (area * getResources().getInteger(R.integer.GAPSInputY1Jan));
                            feb = (int) (area * getResources().getInteger(R.integer.GAPSInputY1Feb));
                            mar = (int) (area * getResources().getInteger(R.integer.GAPSInputY1Mar));
                            apr = (int) (area * getResources().getInteger(R.integer.GAPSInputY1Apr));
                            may = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1May)+getResources().getInteger(R.integer.GAPSLaborY1May)));
                            jun = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Jun)+getResources().getInteger(R.integer.GAPSLaborY1Jun)));
                            jul = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Jul)+getResources().getInteger(R.integer.GAPSLaborY1Jul)));
                            aug = (int) (area * getResources().getInteger(R.integer.GAPSInputY1Aug));
                            sep = (int) (area * getResources().getInteger(R.integer.GAPSInputY1Sep));
                            oct = (int) (area * getResources().getInteger(R.integer.GAPSInputY1Oct));
                            nov = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Nov)+getResources().getInteger(R.integer.GAPSLaborY1Nov)));
                            dec = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Dec)+getResources().getInteger(R.integer.GAPSLaborY1Dec)));
                        }else{
                            jan = (int) (area * getResources().getInteger(R.integer.GAPSInputY1Jan));
                            feb = (int) (area * getResources().getInteger(R.integer.GAPSInputY1Feb));
                            mar = (int) (area * getResources().getInteger(R.integer.GAPSInputY1Mar));
                            apr = (int) (area * getResources().getInteger(R.integer.GAPSInputY1Apr));
                            may = (int) (area * getResources().getInteger(R.integer.GAPSInputY1May));
                            jun = (int) (area * getResources().getInteger(R.integer.GAPSInputY1Jun));
                            jul = (int) (area * getResources().getInteger(R.integer.GAPSInputY1Jul));
                            aug = (int) (area * getResources().getInteger(R.integer.GAPSInputY1Aug));
                            sep = (int) (area * getResources().getInteger(R.integer.GAPSInputY1Sep));
                            oct = (int) (area * getResources().getInteger(R.integer.GAPSInputY1Oct));
                            nov = (int) (area * getResources().getInteger(R.integer.GAPSInputY1Nov));
                            dec = (int) (area * getResources().getInteger(R.integer.GAPSInputY1Dec));
                        }

                    }

                }

            }else if ((yearLaunch.equals("1")&& yearStart.equals("-1"))||(yearLaunch.equals("2")&&(yearStart.equals("Year 1")||yearStart.equals("Year 2")||yearStart.equals("Year 3")||yearStart.equals("Year 4")||yearStart.equals("Year 5")||yearStart.equals("Year 6")||yearStart.equals("Year 7")||yearStart.equals("Tahun 1")||yearStart.equals("Tahun 2")||yearStart.equals("Tahun 3")||yearStart.equals("Tahun 4")||yearStart.equals("Tahun 5")||yearStart.equals("Tahun 6")||yearStart.equals("Tahun 7")))){
                if (main == "replant"){
                    setText(jlb, p2);
                    setText(fblb, p2);
                    setText(mrlb, p1+" + "+p4);
                    setText(ablb, p1+" + "+p4);
                    setText(mylb, p4+" + "+ p7+" + "+ p14+" + "+ p15);
                    setText(jnlb, "");
                    setText(jllb, p12+" + "+ p16);
                    setText(aglb, "");
                    setText(splb, p4+" + "+ p14+" + "+ p15+" + "+ p16+" + "+ p18);
                    setText(oclb, p12);
                    setText(nvlb, p16);
                    setText(dclb, p12+" + "+ p18);
                    if (relat == "extra"){
                        if (labor == "labor"){
                            jan = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Jan)+getResources().getInteger(R.integer.ReplantingLaborY2Jan)+getResources().getInteger(R.integer.difInputY2Jan)));
                            feb = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Feb)+getResources().getInteger(R.integer.ReplantingLaborY2Feb)+getResources().getInteger(R.integer.difInputY2Feb)));
                            mar = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Mar)+getResources().getInteger(R.integer.ReplantingLaborY2Mar)+getResources().getInteger(R.integer.difInputY2Mar)));
                            apr = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Apr)+getResources().getInteger(R.integer.ReplantingLaborY2Apr)+getResources().getInteger(R.integer.difInputY2Apr)));
                            may = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2May)+getResources().getInteger(R.integer.ReplantingLaborY2May)+getResources().getInteger(R.integer.difInputY2May)));
                            jun = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Jun)+getResources().getInteger(R.integer.ReplantingLaborY2Jun)+getResources().getInteger(R.integer.difInputY2Jun)));
                            jul = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Jul)+getResources().getInteger(R.integer.ReplantingLaborY2Jul)+getResources().getInteger(R.integer.difInputY2Jul)));
                            aug = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Aug)+getResources().getInteger(R.integer.ReplantingLaborY2Aug)+getResources().getInteger(R.integer.difInputY2Aug)));
                            sep = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Sep)+getResources().getInteger(R.integer.ReplantingLaborY2Sep)+getResources().getInteger(R.integer.difInputY2Sep)));
                            oct = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Oct)+getResources().getInteger(R.integer.ReplantingLaborY2Oct)+getResources().getInteger(R.integer.difInputY2Oct)));
                            nov = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Nov)+getResources().getInteger(R.integer.ReplantingLaborY2Nov)+getResources().getInteger(R.integer.difInputY2Nov)));
                            dec = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Dec)+getResources().getInteger(R.integer.ReplantingLaborY2Dec)+getResources().getInteger(R.integer.difInputY2Dec)));
                        }else if(labor =="season") {
                            jan = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Jan)+getResources().getInteger(R.integer.difInputY2Jan)));
                            feb = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Feb)+getResources().getInteger(R.integer.difInputY2Feb)));
                            mar = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Mar)+getResources().getInteger(R.integer.difInputY2Mar)));
                            apr = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Apr)+getResources().getInteger(R.integer.difInputY2Apr)));
                            may = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2May)+getResources().getInteger(R.integer.ReplantingLaborY2May)+getResources().getInteger(R.integer.difInputY2May)));
                            jun = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Jun)+getResources().getInteger(R.integer.ReplantingLaborY2Jun)+getResources().getInteger(R.integer.difInputY2Jun)));
                            jul = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Jul)+getResources().getInteger(R.integer.ReplantingLaborY2Jul)+getResources().getInteger(R.integer.difInputY2Jul)));
                            aug = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Aug)+getResources().getInteger(R.integer.difInputY2Aug)));
                            sep = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Sep)+getResources().getInteger(R.integer.difInputY2Sep)));
                            oct = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Oct)+getResources().getInteger(R.integer.difInputY2Oct)));
                            nov = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Nov)+getResources().getInteger(R.integer.ReplantingLaborY2Nov)+getResources().getInteger(R.integer.difInputY2Nov)));
                            dec = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Dec)+getResources().getInteger(R.integer.ReplantingLaborY2Dec)+getResources().getInteger(R.integer.difInputY2Dec)));
                        }else{
                            jan = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Jan)+getResources().getInteger(R.integer.difInputY2Jan)));
                            feb = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Feb)+getResources().getInteger(R.integer.difInputY2Feb)));
                            mar = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Mar)+getResources().getInteger(R.integer.difInputY2Mar)));
                            apr = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Apr)+getResources().getInteger(R.integer.difInputY2Apr)));
                            may = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2May)+getResources().getInteger(R.integer.difInputY2May)));
                            jun = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Jun)+getResources().getInteger(R.integer.difInputY2Jun)));
                            jul = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Jul)+getResources().getInteger(R.integer.difInputY2Jul)));
                            aug = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Aug)+getResources().getInteger(R.integer.difInputY2Aug)));
                            sep = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Sep)+getResources().getInteger(R.integer.difInputY2Sep)));
                            oct = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Oct)+getResources().getInteger(R.integer.difInputY2Oct)));
                            nov = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Nov)+getResources().getInteger(R.integer.difInputY2Nov)));
                            dec = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Dec)+getResources().getInteger(R.integer.difInputY2Dec)));
                        }
                    }else {
                        if (labor == "labor") {
                            jan = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Jan)+getResources().getInteger(R.integer.ReplantingLaborY2Jan)));
                            feb = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Feb)+getResources().getInteger(R.integer.ReplantingLaborY2Feb)));
                            mar = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Mar)+getResources().getInteger(R.integer.ReplantingLaborY2Mar)));
                            apr = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Apr)+getResources().getInteger(R.integer.ReplantingLaborY2Apr)));
                            may = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2May)+getResources().getInteger(R.integer.ReplantingLaborY2May)));
                            jun = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Jun)+getResources().getInteger(R.integer.ReplantingLaborY2Jun)));
                            jul = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Jul)+getResources().getInteger(R.integer.ReplantingLaborY2Jul)));
                            aug = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Aug)+getResources().getInteger(R.integer.ReplantingLaborY2Aug)));
                            sep = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Sep)+getResources().getInteger(R.integer.ReplantingLaborY2Sep)));
                            oct = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Oct)+getResources().getInteger(R.integer.ReplantingLaborY2Oct)));
                            nov = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Nov)+getResources().getInteger(R.integer.ReplantingLaborY2Nov)));
                            dec = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Dec)+getResources().getInteger(R.integer.ReplantingLaborY2Dec)));
                        }else if(labor =="season") {
                            jan = (int) (area * getResources().getInteger(R.integer.ReplantingInputY2Jan));
                            feb = (int) (area * getResources().getInteger(R.integer.ReplantingInputY2Feb));
                            mar = (int) (area * getResources().getInteger(R.integer.ReplantingInputY2Mar));
                            apr = (int) (area * getResources().getInteger(R.integer.ReplantingInputY2Apr));
                            may = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2May)+getResources().getInteger(R.integer.ReplantingLaborY2May)));
                            jun = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Jun)+getResources().getInteger(R.integer.ReplantingLaborY2Jun)));
                            jul = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Jul)+getResources().getInteger(R.integer.ReplantingLaborY2Jul)));
                            aug = (int) (area * getResources().getInteger(R.integer.ReplantingInputY2Aug));
                            sep = (int) (area * getResources().getInteger(R.integer.ReplantingInputY2Sep));
                            oct = (int) (area * getResources().getInteger(R.integer.ReplantingInputY2Oct));
                            nov = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Nov)+getResources().getInteger(R.integer.ReplantingLaborY2Nov)));
                            dec = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Dec)+getResources().getInteger(R.integer.ReplantingLaborY2Dec)));
                        } else {
                            jan = (int) (area * getResources().getInteger(R.integer.ReplantingInputY2Jan));
                            feb = (int) (area * getResources().getInteger(R.integer.ReplantingInputY2Feb));
                            mar = (int) (area * getResources().getInteger(R.integer.ReplantingInputY2Mar));
                            apr = (int) (area * getResources().getInteger(R.integer.ReplantingInputY2Apr));
                            may = (int) (area * getResources().getInteger(R.integer.ReplantingInputY2May));
                            jun = (int) (area * getResources().getInteger(R.integer.ReplantingInputY2Jun));
                            jul = (int) (area * getResources().getInteger(R.integer.ReplantingInputY2Jul));
                            aug = (int) (area * getResources().getInteger(R.integer.ReplantingInputY2Aug));
                            sep = (int) (area * getResources().getInteger(R.integer.ReplantingInputY2Sep));
                            oct = (int) (area * getResources().getInteger(R.integer.ReplantingInputY2Oct));
                            nov = (int) (area * getResources().getInteger(R.integer.ReplantingInputY2Nov));
                            dec = (int) (area * getResources().getInteger(R.integer.ReplantingInputY2Dec));
                        }
                    }

                }else if (main =="graft"){
                    setText(jlb, "");
                    setText(fblb, "");
                    setText(mrlb, p13);
                    setText(ablb, p16+" + "+ p19+" + "+ p22);
                    setText(mylb, p14+" + "+ p15+" + "+ p16+" + "+ p18+" + "+ p19);
                    setText(jnlb, "");
                    setText(jllb, "");
                    setText(aglb, p13);
                    setText(splb, p14+" + "+ p15+" + "+ p16+" + "+ p19+" + "+ p22+" + "+ p24);
                    setText(oclb, p18+" + "+ p19+" + "+ p24);
                    setText(nvlb, p19+" + "+ p24);
                    setText(dclb, p16+" + "+ p19+" + "+ p23+" + "+ p24);

                    if (relat == "extra"){

                        if (labor == "labor"){
                            jan = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Jan)+getResources().getInteger(R.integer.GraftingLaborY2Jan)+getResources().getInteger(R.integer.difInputY2Jan)));
                            feb = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Feb)+getResources().getInteger(R.integer.GraftingLaborY2Feb)+getResources().getInteger(R.integer.difInputY2Feb)));
                            mar = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Mar)+getResources().getInteger(R.integer.GraftingLaborY2Mar)+getResources().getInteger(R.integer.difInputY2Mar)));
                            apr = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Apr)+getResources().getInteger(R.integer.GraftingLaborY2Apr)+getResources().getInteger(R.integer.difInputY2Apr)));
                            may = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2May)+getResources().getInteger(R.integer.GraftingLaborY2May)+getResources().getInteger(R.integer.difInputY2May)));
                            jun = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Jun)+getResources().getInteger(R.integer.GraftingLaborY2Jun)+getResources().getInteger(R.integer.difInputY2Jun)));
                            jul = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Jul)+getResources().getInteger(R.integer.GraftingLaborY2Jul)+getResources().getInteger(R.integer.difInputY2Jul)));
                            aug = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Aug)+getResources().getInteger(R.integer.GraftingLaborY2Aug)+getResources().getInteger(R.integer.difInputY2Aug)));
                            sep = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Sep)+getResources().getInteger(R.integer.GraftingLaborY2Sep)+getResources().getInteger(R.integer.difInputY2Sep)));
                            oct = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Oct)+getResources().getInteger(R.integer.GraftingLaborY2Oct)+getResources().getInteger(R.integer.difInputY2Oct)));
                            nov = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Nov)+getResources().getInteger(R.integer.GraftingLaborY2Nov)+getResources().getInteger(R.integer.difInputY2Nov)));
                            dec = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Dec)+getResources().getInteger(R.integer.GraftingLaborY2Dec)+getResources().getInteger(R.integer.difInputY2Dec)));
                        }else if(labor =="season") {
                            jan = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Jan)+getResources().getInteger(R.integer.difInputY2Jan)));
                            feb = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Feb)+getResources().getInteger(R.integer.difInputY2Feb)));
                            mar = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Mar)+getResources().getInteger(R.integer.difInputY2Mar)));
                            apr = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Apr)+getResources().getInteger(R.integer.difInputY2Apr)));
                            may = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2May)+getResources().getInteger(R.integer.GraftingLaborY2May)+getResources().getInteger(R.integer.difInputY2May)));
                            jun = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Jun)+getResources().getInteger(R.integer.GraftingLaborY2Jun)+getResources().getInteger(R.integer.difInputY2Jun)));
                            jul = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Jul)+getResources().getInteger(R.integer.GraftingLaborY2Jul)+getResources().getInteger(R.integer.difInputY2Jul)));
                            aug = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Aug)+getResources().getInteger(R.integer.difInputY2Aug)));
                            sep = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Sep)+getResources().getInteger(R.integer.difInputY2Sep)));
                            oct = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Oct)+getResources().getInteger(R.integer.difInputY2Oct)));
                            nov = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Nov)+getResources().getInteger(R.integer.GraftingLaborY2Nov)+getResources().getInteger(R.integer.difInputY2Nov)));
                            dec = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Dec)+getResources().getInteger(R.integer.GraftingLaborY2Dec)+getResources().getInteger(R.integer.difInputY2Dec)));
                        }else{
                            jan = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Jan)+getResources().getInteger(R.integer.difInputY2Jan)));
                            feb = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Feb)+getResources().getInteger(R.integer.difInputY2Feb)));
                            mar = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Mar)+getResources().getInteger(R.integer.difInputY2Mar)));
                            apr = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Apr)+getResources().getInteger(R.integer.difInputY2Apr)));
                            may = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2May)+getResources().getInteger(R.integer.difInputY2May)));
                            jun = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Jun)+getResources().getInteger(R.integer.difInputY2Jun)));
                            jul = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Jul)+getResources().getInteger(R.integer.difInputY2Jul)));
                            aug = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Aug)+getResources().getInteger(R.integer.difInputY2Aug)));
                            sep = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Sep)+getResources().getInteger(R.integer.difInputY2Sep)));
                            oct = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Oct)+getResources().getInteger(R.integer.difInputY2Oct)));
                            nov = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Nov)+getResources().getInteger(R.integer.difInputY2Nov)));
                            dec = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Dec)+getResources().getInteger(R.integer.difInputY2Dec)));
                        }

                    }else{
                        if (labor == "labor"){
                            jan = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Jan)+getResources().getInteger(R.integer.GraftingLaborY2Jan)));
                            feb = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Feb)+getResources().getInteger(R.integer.GraftingLaborY2Feb)));
                            mar = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Mar)+getResources().getInteger(R.integer.GraftingLaborY2Mar)));
                            apr = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Apr)+getResources().getInteger(R.integer.GraftingLaborY2Apr)));
                            may = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2May)+getResources().getInteger(R.integer.GraftingLaborY2May)));
                            jun = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Jun)+getResources().getInteger(R.integer.GraftingLaborY2Jun)));
                            jul = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Jul)+getResources().getInteger(R.integer.GraftingLaborY2Jul)));
                            aug = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Aug)+getResources().getInteger(R.integer.GraftingLaborY2Aug)));
                            sep = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Sep)+getResources().getInteger(R.integer.GraftingLaborY2Sep)));
                            oct = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Oct)+getResources().getInteger(R.integer.GraftingLaborY2Oct)));
                            nov = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Nov)+getResources().getInteger(R.integer.GraftingLaborY2Nov)));
                            dec = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Dec)+getResources().getInteger(R.integer.GraftingLaborY2Dec)));
                        }else if(labor =="season") {
                            jan = (int) (area * getResources().getInteger(R.integer.GraftingInputY2Jan));
                            feb = (int) (area * getResources().getInteger(R.integer.GraftingInputY2Feb));
                            mar = (int) (area * getResources().getInteger(R.integer.GraftingInputY2Mar));
                            apr = (int) (area * getResources().getInteger(R.integer.GraftingInputY2Apr));
                            may = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2May)+getResources().getInteger(R.integer.GraftingLaborY2May)));
                            jun = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Jun)+getResources().getInteger(R.integer.GraftingLaborY2Jun)));
                            jul = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Jul)+getResources().getInteger(R.integer.GraftingLaborY2Jul)));
                            aug = (int) (area * getResources().getInteger(R.integer.GraftingInputY2Aug));
                            sep = (int) (area * getResources().getInteger(R.integer.GraftingInputY2Sep));
                            oct = (int) (area * getResources().getInteger(R.integer.GraftingInputY2Oct));
                            nov = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Nov)+getResources().getInteger(R.integer.GraftingLaborY2Nov)));
                            dec = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Dec)+getResources().getInteger(R.integer.GraftingLaborY2Dec)));
                        }else{
                            jan = (int) (area * getResources().getInteger(R.integer.GraftingInputY2Jan));
                            feb = (int) (area * getResources().getInteger(R.integer.GraftingInputY2Feb));
                            mar = (int) (area * getResources().getInteger(R.integer.GraftingInputY2Mar));
                            apr = (int) (area * getResources().getInteger(R.integer.GraftingInputY2Apr));
                            may = (int) (area * getResources().getInteger(R.integer.GraftingInputY2May));
                            jun = (int) (area * getResources().getInteger(R.integer.GraftingInputY2Jun));
                            jul = (int) (area * getResources().getInteger(R.integer.GraftingInputY2Jul));
                            aug = (int) (area * getResources().getInteger(R.integer.GraftingInputY2Aug));
                            sep = (int) (area * getResources().getInteger(R.integer.GraftingInputY2Sep));
                            oct = (int) (area * getResources().getInteger(R.integer.GraftingInputY2Oct));
                            nov = (int) (area * getResources().getInteger(R.integer.GraftingInputY2Nov));
                            dec = (int) (area * getResources().getInteger(R.integer.GraftingInputY2Dec));
                        }
                    }

                }else if (main =="extra"){
                    setText(jlb, p24);
                    setText(fblb, "");
                    setText(mrlb, p12);
                    setText(ablb, p16+" + "+ p19+" + "+ p22);
                    setText(mylb, p14+" + "+ p15+" + "+ p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(jnlb, p21+" + "+ p24);
                    setText(jllb, "");
                    setText(aglb, p12);
                    setText(splb, p14+" + "+ p16+" + "+ p19+" + "+ p21+" + "+ p22+" + "+ p24);
                    setText(oclb, p15+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(nvlb, p19+" + "+ p21+" + "+ p24);
                    setText(dclb, p16+" + "+ p23+" + "+ p24);

                    if (labor == "labor"){
                        jan = (int) (area * (getResources().getInteger(R.integer.ExtraSoilInputY2Jan)+getResources().getInteger(R.integer.ExtraSoilLaborY2Jan)));
                        feb = (int) (area * (getResources().getInteger(R.integer.ExtraSoilInputY2Feb)+getResources().getInteger(R.integer.ExtraSoilLaborY2Feb)));
                        mar = (int) (area * (getResources().getInteger(R.integer.ExtraSoilInputY2Mar)+getResources().getInteger(R.integer.ExtraSoilLaborY2Mar)));
                        apr = (int) (area * (getResources().getInteger(R.integer.ExtraSoilInputY2Apr)+getResources().getInteger(R.integer.ExtraSoilLaborY2Apr)));
                        may = (int) (area * (getResources().getInteger(R.integer.ExtraSoilInputY2May)+getResources().getInteger(R.integer.ExtraSoilLaborY2May)));
                        jun = (int) (area * (getResources().getInteger(R.integer.ExtraSoilInputY2Jun)+getResources().getInteger(R.integer.ExtraSoilLaborY2Jun)));
                        jul = (int) (area * (getResources().getInteger(R.integer.ExtraSoilInputY2Jul)+getResources().getInteger(R.integer.ExtraSoilLaborY2Jul)));
                        aug = (int) (area * (getResources().getInteger(R.integer.ExtraSoilInputY2Aug)+getResources().getInteger(R.integer.ExtraSoilLaborY2Aug)));
                        sep = (int) (area * (getResources().getInteger(R.integer.ExtraSoilInputY2Sep)+getResources().getInteger(R.integer.ExtraSoilLaborY2Sep)));
                        oct = (int) (area * (getResources().getInteger(R.integer.ExtraSoilInputY2Oct)+getResources().getInteger(R.integer.ExtraSoilLaborY2Oct)));
                        nov = (int) (area * (getResources().getInteger(R.integer.ExtraSoilInputY2Nov)+getResources().getInteger(R.integer.ExtraSoilLaborY2Nov)));
                        dec = (int) (area * (getResources().getInteger(R.integer.ExtraSoilInputY2Dec)+getResources().getInteger(R.integer.ExtraSoilLaborY2Dec)));
                    }else if(labor =="season") {
                        jan = (int) (area * getResources().getInteger(R.integer.ExtraSoilInputY2Jan));
                        feb = (int) (area * getResources().getInteger(R.integer.ExtraSoilInputY2Feb));
                        mar = (int) (area * getResources().getInteger(R.integer.ExtraSoilInputY2Mar));
                        apr = (int) (area * getResources().getInteger(R.integer.ExtraSoilInputY2Apr));
                        may = (int) (area * (getResources().getInteger(R.integer.ExtraSoilInputY2May)+getResources().getInteger(R.integer.ExtraSoilLaborY2May)));
                        jun = (int) (area * (getResources().getInteger(R.integer.ExtraSoilInputY2Jun)+getResources().getInteger(R.integer.ExtraSoilLaborY2Jun)));
                        jul = (int) (area * (getResources().getInteger(R.integer.ExtraSoilInputY2Jul)+getResources().getInteger(R.integer.ExtraSoilLaborY2Jul)));
                        aug = (int) (area * getResources().getInteger(R.integer.ExtraSoilInputY2Aug));
                        sep = (int) (area * getResources().getInteger(R.integer.ExtraSoilInputY2Sep));
                        oct = (int) (area * getResources().getInteger(R.integer.ExtraSoilInputY2Oct));
                        nov = (int) (area * (getResources().getInteger(R.integer.ExtraSoilInputY2Nov)+getResources().getInteger(R.integer.ExtraSoilLaborY2Nov)));
                        dec = (int) (area * (getResources().getInteger(R.integer.ExtraSoilInputY2Dec)+getResources().getInteger(R.integer.ExtraSoilLaborY2Dec)));
                    }else{
                        jan = (int) (area * getResources().getInteger(R.integer.ExtraSoilInputY2Jan));
                        feb = (int) (area * getResources().getInteger(R.integer.ExtraSoilInputY2Feb));
                        mar = (int) (area * getResources().getInteger(R.integer.ExtraSoilInputY2Mar));
                        apr = (int) (area * getResources().getInteger(R.integer.ExtraSoilInputY2Apr));
                        may = (int) (area * getResources().getInteger(R.integer.ExtraSoilInputY2May));
                        jun = (int) (area * getResources().getInteger(R.integer.ExtraSoilInputY2Jun));
                        jul = (int) (area * getResources().getInteger(R.integer.ExtraSoilInputY2Jul));
                        aug = (int) (area * getResources().getInteger(R.integer.ExtraSoilInputY2Aug));
                        sep = (int) (area * getResources().getInteger(R.integer.ExtraSoilInputY2Sep));
                        oct = (int) (area * getResources().getInteger(R.integer.ExtraSoilInputY2Oct));
                        nov = (int) (area * getResources().getInteger(R.integer.ExtraSoilInputY2Nov));
                        dec = (int) (area * getResources().getInteger(R.integer.ExtraSoilInputY2Dec));
                    }

                }else{
                    setText(jlb, p24);
                    setText(fblb, "");
                    setText(mrlb, p12);
                    setText(ablb, p16+" + "+ p19+" + "+ p22);
                    setText(mylb, p14+" + "+ p15+" + "+ p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(jnlb, p21+" + "+ p24);
                    setText(jllb, "");
                    setText(aglb, p12);
                    setText(splb, p14+" + "+ p16+" + "+ p19+" + "+ p21+" + "+ p22+" + "+ p24);
                    setText(oclb, p15+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(nvlb, p19+" + "+ p21+" + "+ p24);
                    setText(dclb, p16+" + "+ p23+" + "+ p24);
                    if (relat == "extra"){
                        if (labor == "labor"){
                            jan = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2Jan)+getResources().getInteger(R.integer.GAPSLaborY2Jan)+getResources().getInteger(R.integer.difInputY2Jan)));
                            feb = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2Feb)+getResources().getInteger(R.integer.GAPSLaborY2Feb)+getResources().getInteger(R.integer.difInputY2Feb)));
                            mar = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2Mar)+getResources().getInteger(R.integer.GAPSLaborY2Mar)+getResources().getInteger(R.integer.difInputY2Mar)));
                            apr = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2Apr)+getResources().getInteger(R.integer.GAPSLaborY2Apr)+getResources().getInteger(R.integer.difInputY2Apr)));
                            may = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2May)+getResources().getInteger(R.integer.GAPSLaborY2May)+getResources().getInteger(R.integer.difInputY2May)));
                            jun = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2Jun)+getResources().getInteger(R.integer.GAPSLaborY2Jun)+getResources().getInteger(R.integer.difInputY2Jun)));
                            jul = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2Jul)+getResources().getInteger(R.integer.GAPSLaborY2Jul)+getResources().getInteger(R.integer.difInputY2Jul)));
                            aug = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2Aug)+getResources().getInteger(R.integer.GAPSLaborY2Aug)+getResources().getInteger(R.integer.difInputY2Aug)));
                            sep = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2Sep)+getResources().getInteger(R.integer.GAPSLaborY2Sep)+getResources().getInteger(R.integer.difInputY2Sep)));
                            oct = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2Oct)+getResources().getInteger(R.integer.GAPSLaborY2Oct)+getResources().getInteger(R.integer.difInputY2Oct)));
                            nov = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2Nov)+getResources().getInteger(R.integer.GAPSLaborY2Nov)+getResources().getInteger(R.integer.difInputY2Nov)));
                            dec = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2Dec)+getResources().getInteger(R.integer.GAPSLaborY2Dec)+getResources().getInteger(R.integer.difInputY2Dec)));
                        }else if(labor =="season") {
                            jan = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2Jan)+getResources().getInteger(R.integer.difInputY2Jan)));
                            feb = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2Feb)+getResources().getInteger(R.integer.difInputY2Feb)));
                            mar = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2Mar)+getResources().getInteger(R.integer.difInputY2Mar)));
                            apr = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2Apr)+getResources().getInteger(R.integer.difInputY2Apr)));
                            may = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2May)+getResources().getInteger(R.integer.GAPSLaborY2May)+getResources().getInteger(R.integer.difInputY2May)));
                            jun = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2Jun)+getResources().getInteger(R.integer.GAPSLaborY2Jun)+getResources().getInteger(R.integer.difInputY2Jun)));
                            jul = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2Jul)+getResources().getInteger(R.integer.GAPSLaborY2Jul)+getResources().getInteger(R.integer.difInputY2Jul)));
                            aug = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2Aug)+getResources().getInteger(R.integer.difInputY2Aug)));
                            sep = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2Sep)+getResources().getInteger(R.integer.difInputY2Sep)));
                            oct = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2Oct)+getResources().getInteger(R.integer.difInputY2Oct)));
                            nov = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2Nov)+getResources().getInteger(R.integer.GAPSLaborY2Nov)+getResources().getInteger(R.integer.difInputY2Nov)));
                            dec = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2Dec)+getResources().getInteger(R.integer.GAPSLaborY2Dec)+getResources().getInteger(R.integer.difInputY2Dec)));
                        }else{
                            jan = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2Jan)+getResources().getInteger(R.integer.difInputY2Jan)));
                            feb = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2Feb)+getResources().getInteger(R.integer.difInputY2Feb)));
                            mar = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2Mar)+getResources().getInteger(R.integer.difInputY2Mar)));
                            apr = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2Apr)+getResources().getInteger(R.integer.difInputY2Apr)));
                            may = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2May)+getResources().getInteger(R.integer.difInputY2May)));
                            jun = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2Jun)+getResources().getInteger(R.integer.difInputY2Jun)));
                            jul = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2Jul)+getResources().getInteger(R.integer.difInputY2Jul)));
                            aug = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2Aug)+getResources().getInteger(R.integer.difInputY2Aug)));
                            sep = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2Sep)+getResources().getInteger(R.integer.difInputY2Sep)));
                            oct = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2Oct)+getResources().getInteger(R.integer.difInputY2Oct)));
                            nov = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2Nov)+getResources().getInteger(R.integer.difInputY2Nov)));
                            dec = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2Dec)+getResources().getInteger(R.integer.difInputY2Dec)));
                        }
                    }else{
                        if (labor == "labor"){
                            jan = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2Jan)+getResources().getInteger(R.integer.GAPSLaborY2Jan)));
                            feb = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2Feb)+getResources().getInteger(R.integer.GAPSLaborY2Feb)));
                            mar = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2Mar)+getResources().getInteger(R.integer.GAPSLaborY2Mar)));
                            apr = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2Apr)+getResources().getInteger(R.integer.GAPSLaborY2Apr)));
                            may = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2May)+getResources().getInteger(R.integer.GAPSLaborY2May)));
                            jun = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2Jun)+getResources().getInteger(R.integer.GAPSLaborY2Jun)));
                            jul = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2Jul)+getResources().getInteger(R.integer.GAPSLaborY2Jul)));
                            aug = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2Aug)+getResources().getInteger(R.integer.GAPSLaborY2Aug)));
                            sep = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2Sep)+getResources().getInteger(R.integer.GAPSLaborY2Sep)));
                            oct = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2Oct)+getResources().getInteger(R.integer.GAPSLaborY2Oct)));
                            nov = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2Nov)+getResources().getInteger(R.integer.GAPSLaborY2Nov)));
                            dec = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2Dec)+getResources().getInteger(R.integer.GAPSLaborY2Dec)));
                        }else if(labor =="season") {
                            jan = (int) (area * getResources().getInteger(R.integer.GAPSInputY2Jan));
                            feb = (int) (area * getResources().getInteger(R.integer.GAPSInputY2Feb));
                            mar = (int) (area * getResources().getInteger(R.integer.GAPSInputY2Mar));
                            apr = (int) (area * getResources().getInteger(R.integer.GAPSInputY2Apr));
                            may = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2May)+getResources().getInteger(R.integer.GAPSLaborY2May)));
                            jun = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2Jun)+getResources().getInteger(R.integer.GAPSLaborY2Jun)));
                            jul = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2Jul)+getResources().getInteger(R.integer.GAPSLaborY2Jul)));
                            aug = (int) (area * getResources().getInteger(R.integer.GAPSInputY2Aug));
                            sep = (int) (area * getResources().getInteger(R.integer.GAPSInputY2Sep));
                            oct = (int) (area * getResources().getInteger(R.integer.GAPSInputY2Oct));
                            nov = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2Nov)+getResources().getInteger(R.integer.GAPSLaborY2Nov)));
                            dec = (int) (area * (getResources().getInteger(R.integer.GAPSInputY2Dec)+getResources().getInteger(R.integer.GAPSLaborY2Dec)));
                        }else{
                            jan = (int) (area * getResources().getInteger(R.integer.GAPSInputY2Jan));
                            feb = (int) (area * getResources().getInteger(R.integer.GAPSInputY2Feb));
                            mar = (int) (area * getResources().getInteger(R.integer.GAPSInputY2Mar));
                            apr = (int) (area * getResources().getInteger(R.integer.GAPSInputY2Apr));
                            may = (int) (area * getResources().getInteger(R.integer.GAPSInputY2May));
                            jun = (int) (area * getResources().getInteger(R.integer.GAPSInputY2Jun));
                            jul = (int) (area * getResources().getInteger(R.integer.GAPSInputY2Jul));
                            aug = (int) (area * getResources().getInteger(R.integer.GAPSInputY2Aug));
                            sep = (int) (area * getResources().getInteger(R.integer.GAPSInputY2Sep));
                            oct = (int) (area * getResources().getInteger(R.integer.GAPSInputY2Oct));
                            nov = (int) (area * getResources().getInteger(R.integer.GAPSInputY2Nov));
                            dec = (int) (area * getResources().getInteger(R.integer.GAPSInputY2Dec));
                        }

                    }

                }
            }else if ((yearLaunch.equals("2")&& yearStart.equals("-1"))||(yearLaunch.equals("1")&& yearStart.equals("-2"))||(yearLaunch.equals("3")&&(yearStart.equals("Year 1")||yearStart.equals("Year 2")||yearStart.equals("Year 3")||yearStart.equals("Year 4")||yearStart.equals("Year 5")||yearStart.equals("Year 6")||yearStart.equals("Year 7")||yearStart.equals("Tahun 1")||yearStart.equals("Tahun 2")||yearStart.equals("Tahun 3")||yearStart.equals("Tahun 4")||yearStart.equals("Tahun 5")||yearStart.equals("Tahun 6")||yearStart.equals("Tahun 7")))){

                if (main == "replant"){
                    setText(jlb, "");
                    setText(fblb, "");
                    setText(mrlb, p12+" + "+ p13);
                    setText(ablb, p16+" + "+ p19+" + "+ p22);
                    setText(mylb, p14+" + "+ p15+" + "+ p16+" + "+ p18+" + "+ p19+" + "+ p21);
                    setText(jnlb, p21+" + "+ p24);
                    setText(jllb, p24);
                    setText(aglb, p12+" + "+ p13+" + "+ p24);
                    setText(splb, p14+" + "+ p16+" + "+ p18+" + "+ p19+" + "+ p21+" + "+ p22+" + "+ p24);
                    setText(oclb, p15+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(nvlb, p19+" + "+ p21+" + "+ p24);
                    setText(dclb, p16+" + "+ p18+" + "+ p23+" + "+ p24);
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
                        }else if(labor =="season") {
                            jan = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Jan)))+(area * (getResources().getInteger(R.integer.difInputY3Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Feb)))+(area * (getResources().getInteger(R.integer.difInputY3Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Mar)))+(area * (getResources().getInteger(R.integer.difInputY3Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Apr)))+(area * (getResources().getInteger(R.integer.difInputY3Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3May)))+(area * (getResources().getInteger(R.integer.ReplantingLaborY3May)))+(area * (getResources().getInteger(R.integer.difInputY3May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Jun)))+(area * (getResources().getInteger(R.integer.ReplantingLaborY3Jun)))+(area * (getResources().getInteger(R.integer.difInputY3Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Jul)))+(area * (getResources().getInteger(R.integer.ReplantingLaborY3Jul)))+(area * (getResources().getInteger(R.integer.difInputY3Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Aug)))+(area * (getResources().getInteger(R.integer.difInputY3Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Sep)))+(area * (getResources().getInteger(R.integer.difInputY3Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Oct)))+(area * (getResources().getInteger(R.integer.difInputY3Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Nov)))+(area * (getResources().getInteger(R.integer.ReplantingLaborY3Nov)))+(area * (getResources().getInteger(R.integer.difInputY3Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Dec)))+(area * (getResources().getInteger(R.integer.ReplantingLaborY3Dec)))+(area * (getResources().getInteger(R.integer.difInputY3Dec))));
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
                        }else if(labor =="season") {
                            jan = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3May)))+(area * (getResources().getInteger(R.integer.ReplantingLaborY3May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Jun)))+(area * (getResources().getInteger(R.integer.ReplantingLaborY3Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Jul)))+(area * (getResources().getInteger(R.integer.ReplantingLaborY3Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Nov)))+(area * (getResources().getInteger(R.integer.ReplantingLaborY3Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Dec)))+(area * (getResources().getInteger(R.integer.ReplantingLaborY3Dec))));
                        }else {
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
                    setText(jlb, p24);
                    setText(fblb, "");
                    setText(mrlb, p12);
                    setText(ablb, p16+" + "+ p19+" + "+ p22);
                    setText(mylb, p14+" + "+ p15+" + "+ p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(jnlb, p21+" + "+ p24);
                    setText(jllb, "");
                    setText(aglb, p12);
                    setText(splb, p14+" + "+ p16+" + "+ p19+" + "+ p21+" + "+ p22+" + "+ p24);
                    setText(oclb, p15+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(nvlb, p19+" + "+ p21+" + "+ p24);
                    setText(dclb, p16+" + "+ p23+" + "+ p24);

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
                        }else if(labor =="season") {
                            jan = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Jan)))+(area * (getResources().getInteger(R.integer.difInputY3Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Feb)))+(area * (getResources().getInteger(R.integer.difInputY3Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Mar)))+(area * (getResources().getInteger(R.integer.difInputY3Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Apr)))+(area * (getResources().getInteger(R.integer.difInputY3Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3May)))+(area * (getResources().getInteger(R.integer.GraftingLaborY3May)))+(area * (getResources().getInteger(R.integer.difInputY3May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Jun)))+(area * (getResources().getInteger(R.integer.GraftingLaborY3Jun)))+(area * (getResources().getInteger(R.integer.difInputY3Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Jul)))+(area * (getResources().getInteger(R.integer.GraftingLaborY3Jul)))+(area * (getResources().getInteger(R.integer.difInputY3Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Aug)))+(area * (getResources().getInteger(R.integer.difInputY3Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Sep)))+(area * (getResources().getInteger(R.integer.difInputY3Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Oct)))+(area * (getResources().getInteger(R.integer.difInputY3Oct))));
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
                        }else if(labor =="season") {
                            jan = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3May)))+(area * (getResources().getInteger(R.integer.GraftingLaborY3May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Jun)))+(area * (getResources().getInteger(R.integer.GraftingLaborY3Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Jul)))+(area * (getResources().getInteger(R.integer.GraftingLaborY3Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Oct))));
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
                    setText(jlb, p24);
                    setText(fblb, "");
                    setText(mrlb, p12);
                    setText(ablb, p16+" + "+ p19+" + "+ p22);
                    setText(mylb, p14+" + "+ p15+" + "+ p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(jnlb, p21+" + "+ p24);
                    setText(jllb, "");
                    setText(aglb, p12);
                    setText(splb, p14+" + "+ p16+" + "+ p19+" + "+ p21+" + "+ p22+" + "+ p24);
                    setText(oclb, p15+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(nvlb, p19+" + "+ p21+" + "+ p24);
                    setText(dclb, p16+" + "+ p23+" + "+ p24);

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
                    }else if(labor =="season") {
                        jan = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY3Jan))));
                        feb = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY3Feb))));
                        mar = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY3Mar))));
                        apr = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY3Apr))));
                        may = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY3May)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY3May))));
                        jun = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY3Jun)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Jun))));
                        jul = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY3Jul)))+(area * (getResources().getInteger(R.integer.ExtraSoilLaborY3Jul))));
                        aug = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY3Aug))));
                        sep = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY3Sep))));
                        oct = (int) ((area * (getResources().getInteger(R.integer.ExtraSoilInputY3Oct))));
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
                    setText(jlb, p24);
                    setText(fblb, "");
                    setText(mrlb, p12);
                    setText(ablb, p16+" + "+ p19+" + "+ p22);
                    setText(mylb, p14+" + "+ p15+" + "+ p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(jnlb, p21+" + "+ p24);
                    setText(jllb, "");
                    setText(aglb, p12);
                    setText(splb, p14+" + "+ p16+" + "+ p19+" + "+ p21+" + "+ p22+" + "+ p24);
                    setText(oclb, p15+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(nvlb, p19+" + "+ p21+" + "+ p24);
                    setText(dclb, p16+" + "+ p23+" + "+ p24);
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
                        }else if(labor =="season") {
                            jan = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Jan)))+(area * (getResources().getInteger(R.integer.difInputY3Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Feb)))+(area * (getResources().getInteger(R.integer.difInputY3Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Mar)))+(area * (getResources().getInteger(R.integer.difInputY3Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Apr)))+(area * (getResources().getInteger(R.integer.difInputY3Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3May)))+(area * (getResources().getInteger(R.integer.GAPSLaborY3May)))+(area * (getResources().getInteger(R.integer.difInputY3May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Jun)))+(area * (getResources().getInteger(R.integer.GAPSLaborY3Jun)))+(area * (getResources().getInteger(R.integer.difInputY3Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Jul)))+(area * (getResources().getInteger(R.integer.GAPSLaborY3Jul)))+(area * (getResources().getInteger(R.integer.difInputY3Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Aug)))+(area * (getResources().getInteger(R.integer.difInputY3Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Sep)))+(area * (getResources().getInteger(R.integer.difInputY3Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Oct)))+(area * (getResources().getInteger(R.integer.difInputY3Oct))));
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
                        }else if(labor =="season") {
                            jan = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3May)))+(area * (getResources().getInteger(R.integer.GAPSLaborY3May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Jun)))+(area * (getResources().getInteger(R.integer.GAPSLaborY3Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Jul)))+(area * (getResources().getInteger(R.integer.GAPSLaborY3Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY3Oct))));
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

            }else if ((yearLaunch.equals("3")&& yearStart.equals("-1"))||(yearLaunch.equals("2")&& yearStart.equals("-2"))||(yearLaunch.equals("1")&& yearStart.equals("-3"))||(yearLaunch.equals("4")&&(yearStart.equals("Year 1")||yearStart.equals("Year 2")||yearStart.equals("Year 3")||yearStart.equals("Year 4")||yearStart.equals("Year 5")||yearStart.equals("Year 6")||yearStart.equals("Year 7")||yearStart.equals("Tahun 1")||yearStart.equals("Tahun 2")||yearStart.equals("Tahun 3")||yearStart.equals("Tahun 4")||yearStart.equals("Tahun 5")||yearStart.equals("Tahun 6")||yearStart.equals("Tahun 7")))){

                if (main == "replant"){
                    setText(jlb, p24);
                    setText(fblb, "");
                    setText(mrlb, p12+" + "+ p13);
                    setText(ablb, p16+" + "+ p19+" + "+ p22);
                    setText(mylb, p14+" + "+ p15+" + "+ p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(jnlb, p21+" + "+ p24);
                    setText(jllb, "");
                    setText(aglb, p12+" + "+ p13);
                    setText(splb, p14+" + "+ p16+" + "+ p19+" + "+ p21+" + "+ p22+" + "+ p24);
                    setText(oclb, p15+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(nvlb, p19+" + "+ p21+" + "+ p24);
                    setText(dclb, p16+" + "+ p23+" + "+ p24);
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
                        }else if(labor =="season") {
                            jan = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Jan)))+(area * (getResources().getInteger(R.integer.difInputY4Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Feb)))+(area * (getResources().getInteger(R.integer.difInputY4Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Mar)))+(area * (getResources().getInteger(R.integer.difInputY4Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Apr)))+(area * (getResources().getInteger(R.integer.difInputY4Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4May)))+(area * (getResources().getInteger(R.integer.ReplantingLaborY4May)))+(area * (getResources().getInteger(R.integer.difInputY4May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Jun)))+(area * (getResources().getInteger(R.integer.ReplantingLaborY4Jun)))+(area * (getResources().getInteger(R.integer.difInputY4Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Jul)))+(area * (getResources().getInteger(R.integer.ReplantingLaborY4Jul)))+(area * (getResources().getInteger(R.integer.difInputY4Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Aug)))+(area * (getResources().getInteger(R.integer.difInputY4Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Sep)))+(area * (getResources().getInteger(R.integer.difInputY4Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Oct)))+(area * (getResources().getInteger(R.integer.difInputY4Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Nov)))+(area * (getResources().getInteger(R.integer.ReplantingLaborY4Nov)))+(area * (getResources().getInteger(R.integer.difInputY4Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Dec)))+(area * (getResources().getInteger(R.integer.ReplantingLaborY4Dec)))+(area * (getResources().getInteger(R.integer.difInputY4Dec))));
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
                        }else if(labor =="season") {
                            jan = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4May)))+(area * (getResources().getInteger(R.integer.ReplantingLaborY4May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Jun)))+(area * (getResources().getInteger(R.integer.ReplantingLaborY4Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Jul)))+(area * (getResources().getInteger(R.integer.ReplantingLaborY4Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Nov)))+(area * (getResources().getInteger(R.integer.ReplantingLaborY4Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Dec)))+(area * (getResources().getInteger(R.integer.ReplantingLaborY4Dec))));
                        }else {
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

                }else{
                    setText(jlb, p24);
                    setText(fblb, "");
                    setText(mrlb, p12);
                    setText(ablb, p16+" + "+ p19+" + "+ p22);
                    setText(mylb, p14+" + "+ p15+" + "+ p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(jnlb, p21+" + "+ p24);
                    setText(jllb, "");
                    setText(aglb, p12);
                    setText(splb, p14+" + "+ p16+" + "+ p19+" + "+ p21+" + "+ p22+" + "+ p24);
                    setText(oclb, p15+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(nvlb, p19+" + "+ p21+" + "+ p24);
                    setText(dclb, p16+" + "+ p23+" + "+ p24);

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
                    }else if(labor =="season") {
                        jan = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Jan))));
                        feb = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Feb))));
                        mar = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Mar))));
                        apr = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Apr))));
                        may = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4May)))+(area * (getResources().getInteger(R.integer.GAPSLaborY4May))));
                        jun = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Jun)))+(area * (getResources().getInteger(R.integer.GAPSLaborY4Jun))));
                        jul = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Jul)))+(area * (getResources().getInteger(R.integer.GAPSLaborY4Jul))));
                        aug = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Aug))));
                        sep = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Sep))));
                        oct = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY4Oct))));
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

            }else{
                setText(jlb, p24);
                setText(fblb, "");
                setText(mrlb, p12);
                setText(ablb, p16+" + "+ p19+" + "+ p22);
                setText(mylb, p14+" + "+ p15+" + "+ p16+" + "+ p19+" + "+ p21+" + "+ p24);
                setText(jnlb, p21+" + "+ p24);
                setText(jllb, "");
                setText(aglb, p12);
                setText(splb, p14+" + "+ p16+" + "+ p19+" + "+ p21+" + "+ p22+" + "+ p24);
                setText(oclb, p15+" + "+ p19+" + "+ p21+" + "+ p24);
                setText(nvlb, p19+" + "+ p21+" + "+ p24);
                setText(dclb, p16+" + "+ p23+" + "+ p24);
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
                }else if(labor =="season") {
                    jan = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Jan))));
                    feb = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Feb))));
                    mar = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Mar))));
                    apr = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Apr))));
                    may = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5May)))+(area * (getResources().getInteger(R.integer.GAPSLaborY5May))));
                    jun = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Jun)))+(area * (getResources().getInteger(R.integer.GAPSLaborY5Jun))));
                    jul = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Jul)))+(area * (getResources().getInteger(R.integer.GAPSLaborY5Jul))));
                    aug = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Aug))));
                    sep = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Sep))));
                    oct = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY5Oct))));
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
