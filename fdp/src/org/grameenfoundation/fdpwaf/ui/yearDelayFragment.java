package org.grameenfoundation.fdpwaf.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.grameenfoundation.fdpwaf.R;

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
            setText(jlb, p16+p19+p24);
            setText(fblb, p16+p19+p21+p24);
            setText(mrlb, p14+p16+p19+p21+p24);
            setText(ablb, p16+p19+p21+p24);
            setText(mylb, p12+p15+p16+p20+p18+p24);
            setText(jnlb, p12+p16+p20+p18+p24);
            setText(jllb, p16+p19+p24);
            setText(aglb, p16+p19+p21+p24);
            setText(splb, p16+p19+p21+p24);
            setText(oclb, p16+p19+p21+p24);
            setText(nvlb, p12+p15+p16+p20+p18+p24);
            setText(dclb, p14+p16+p19+p21+p24);
            if (main == "replant"){
                if (labor == "labor") {
                    jan = (int) (area * (getResources().getInteger(R.integer.MinGAPJan) + getResources().getInteger(R.integer.MinGAPSLaborJan)));
                    feb = (int) (area * (getResources().getInteger(R.integer.MinGAPFeb) + getResources().getInteger(R.integer.MinGAPSLaborFeb)));
                    mar = (int) (area * (getResources().getInteger(R.integer.MinGAPMar) + getResources().getInteger(R.integer.MinGAPSLaborMar)));
                    apr = (int) (area * (getResources().getInteger(R.integer.MinGAPApr) + getResources().getInteger(R.integer.MinGAPSLaborApr)));
                    may = (int) (area * (getResources().getInteger(R.integer.MinGAPMay) + getResources().getInteger(R.integer.MinGAPSLaborMay)));
                    jun = (int) (area * (getResources().getInteger(R.integer.MinGAPJun) + getResources().getInteger(R.integer.MinGAPSLaborJun)));
                    jul = (int) (area * (getResources().getInteger(R.integer.MinGAPJul) + getResources().getInteger(R.integer.MinGAPSLaborJul)));
                    aug = (int) (area * (getResources().getInteger(R.integer.MinGAPAug) + getResources().getInteger(R.integer.MinGAPSLaborAug)));
                    sep = (int) (area * (getResources().getInteger(R.integer.MinGAPSep) + getResources().getInteger(R.integer.MinGAPSLaborSep)));
                    oct = (int) (area * (getResources().getInteger(R.integer.MinGAPOct) + getResources().getInteger(R.integer.MinGAPSLaborOct)));
                    nov = (int) (area * (getResources().getInteger(R.integer.MinGAPNov) + getResources().getInteger(R.integer.MinGAPSLaborNov)));
                    dec = (int) (area * (getResources().getInteger(R.integer.MinGAPDec) + getResources().getInteger(R.integer.MinGAPSLaborDec)));
                } else if (labor == "season") {
                    jan = (int) (area * getResources().getInteger(R.integer.MinGAPJan));
                    feb = (int) (area * getResources().getInteger(R.integer.MinGAPFeb));
                    mar = (int) (area * getResources().getInteger(R.integer.MinGAPMar));
                    apr = (int) (area * getResources().getInteger(R.integer.MinGAPApr));
                    may = (int) (area * (getResources().getInteger(R.integer.MinGAPMay) + getResources().getInteger(R.integer.MinGAPSLaborMay)));
                    jun = (int) (area * (getResources().getInteger(R.integer.MinGAPJun) + getResources().getInteger(R.integer.MinGAPSLaborJun)));
                    jul = (int) (area * (getResources().getInteger(R.integer.MinGAPJul) + getResources().getInteger(R.integer.MinGAPSLaborJul)));
                    aug = (int) (area * getResources().getInteger(R.integer.MinGAPAug));
                    sep = (int) (area * getResources().getInteger(R.integer.MinGAPSep));
                    oct = (int) (area * getResources().getInteger(R.integer.MinGAPOct));
                    nov = (int) (area * (getResources().getInteger(R.integer.MinGAPNov) + getResources().getInteger(R.integer.MinGAPSLaborNov)));
                    dec = (int) (area * (getResources().getInteger(R.integer.MinGAPDec) + getResources().getInteger(R.integer.MinGAPSLaborDec)));
                } else {
                    jan = (int) (area * getResources().getInteger(R.integer.MinGAPJan));
                    feb = (int) (area * getResources().getInteger(R.integer.MinGAPFeb));
                    mar = (int) (area * getResources().getInteger(R.integer.MinGAPMar));
                    apr = (int) (area * getResources().getInteger(R.integer.MinGAPApr));
                    may = (int) (area * getResources().getInteger(R.integer.MinGAPMay));
                    jun = (int) (area * getResources().getInteger(R.integer.MinGAPJun));
                    jul = (int) (area * getResources().getInteger(R.integer.MinGAPJul));
                    aug = (int) (area * getResources().getInteger(R.integer.MinGAPAug));
                    sep = (int) (area * getResources().getInteger(R.integer.MinGAPSep));
                    oct = (int) (area * getResources().getInteger(R.integer.MinGAPOct));
                    nov = (int) (area * getResources().getInteger(R.integer.MinGAPNov));
                    dec = (int) (area * getResources().getInteger(R.integer.MinGAPDec));
                }

            }else if (main =="graft"){
                if (labor == "labor") {
                    jan = (int) (area * (getResources().getInteger(R.integer.MGAPJan) + getResources().getInteger(R.integer.MGAPSLaborJan)));
                    feb = (int) (area * (getResources().getInteger(R.integer.MGAPFeb) + getResources().getInteger(R.integer.MGAPSLaborFeb)));
                    mar = (int) (area * (getResources().getInteger(R.integer.MGAPMar) + getResources().getInteger(R.integer.MGAPSLaborMar)));
                    apr = (int) (area * (getResources().getInteger(R.integer.MGAPApr) + getResources().getInteger(R.integer.MGAPSLaborApr)));
                    may = (int) (area * (getResources().getInteger(R.integer.MGAPMay) + getResources().getInteger(R.integer.MGAPSLaborMay)));
                    jun = (int) (area * (getResources().getInteger(R.integer.MGAPJun) + getResources().getInteger(R.integer.MGAPSLaborJun)));
                    jul = (int) (area * (getResources().getInteger(R.integer.MGAPJul) + getResources().getInteger(R.integer.MGAPSLaborJul)));
                    aug = (int) (area * (getResources().getInteger(R.integer.MGAPAug) + getResources().getInteger(R.integer.MGAPSLaborAug)));
                    sep = (int) (area * (getResources().getInteger(R.integer.MGAPSep) + getResources().getInteger(R.integer.MGAPSLaborSep)));
                    oct = (int) (area * (getResources().getInteger(R.integer.MGAPOct) + getResources().getInteger(R.integer.MGAPSLaborOct)));
                    nov = (int) (area * (getResources().getInteger(R.integer.MGAPNov) + getResources().getInteger(R.integer.MGAPSLaborNov)));
                    dec = (int) (area * (getResources().getInteger(R.integer.MGAPDec) + getResources().getInteger(R.integer.MGAPSLaborDec)));
                } else if (labor == "season") {
                    jan = (int) (area * getResources().getInteger(R.integer.MGAPJan));
                    feb = (int) (area * getResources().getInteger(R.integer.MGAPFeb));
                    mar = (int) (area * getResources().getInteger(R.integer.MGAPMar));
                    apr = (int) (area * getResources().getInteger(R.integer.MGAPApr));
                    may = (int) (area * (getResources().getInteger(R.integer.MGAPMay) + getResources().getInteger(R.integer.MGAPSLaborMay)));
                    jun = (int) (area * (getResources().getInteger(R.integer.MGAPJun) + getResources().getInteger(R.integer.MGAPSLaborJun)));
                    jul = (int) (area * (getResources().getInteger(R.integer.MGAPJul) + getResources().getInteger(R.integer.MGAPSLaborJul)));
                    aug = (int) (area * getResources().getInteger(R.integer.MGAPAug));
                    sep = (int) (area * getResources().getInteger(R.integer.MGAPSep));
                    oct = (int) (area * getResources().getInteger(R.integer.MGAPOct));
                    nov = (int) (area * (getResources().getInteger(R.integer.MGAPNov) + getResources().getInteger(R.integer.MGAPSLaborNov)));
                    dec = (int) (area * (getResources().getInteger(R.integer.MGAPDec) + getResources().getInteger(R.integer.MGAPSLaborDec)));
                } else {
                    jan = (int) (area * getResources().getInteger(R.integer.MGAPJan));
                    feb = (int) (area * getResources().getInteger(R.integer.MGAPFeb));
                    mar = (int) (area * getResources().getInteger(R.integer.MGAPMar));
                    apr = (int) (area * getResources().getInteger(R.integer.MGAPApr));
                    may = (int) (area * getResources().getInteger(R.integer.MGAPMay));
                    jun = (int) (area * getResources().getInteger(R.integer.MGAPJun));
                    jul = (int) (area * getResources().getInteger(R.integer.MGAPJul));
                    aug = (int) (area * getResources().getInteger(R.integer.MGAPAug));
                    sep = (int) (area * getResources().getInteger(R.integer.MGAPSep));
                    oct = (int) (area * getResources().getInteger(R.integer.MGAPOct));
                    nov = (int) (area * getResources().getInteger(R.integer.MGAPNov));
                    dec = (int) (area * getResources().getInteger(R.integer.MGAPDec));
                }

            }else {
                if (labor == "labor") {
                    jan = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Jan) + getResources().getInteger(R.integer.GAPSLaborY1Jan)));
                    feb = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Feb) + getResources().getInteger(R.integer.GAPSLaborY1Feb)));
                    mar = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Mar) + getResources().getInteger(R.integer.GAPSLaborY1Mar)));
                    apr = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Apr) + getResources().getInteger(R.integer.GAPSLaborY1Apr)));
                    may = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1May) + getResources().getInteger(R.integer.GAPSLaborY1May)));
                    jun = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Jun) + getResources().getInteger(R.integer.GAPSLaborY1Jun)));
                    jul = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Jul) + getResources().getInteger(R.integer.GAPSLaborY1Jul)));
                    aug = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Aug) + getResources().getInteger(R.integer.GAPSLaborY1Aug)));
                    sep = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Sep) + getResources().getInteger(R.integer.GAPSLaborY1Sep)));
                    oct = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Oct) + getResources().getInteger(R.integer.GAPSLaborY1Oct)));
                    nov = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Nov) + getResources().getInteger(R.integer.GAPSLaborY1Nov)));
                    dec = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Dec) + getResources().getInteger(R.integer.GAPSLaborY1Dec)));
                } else if (labor == "season") {
                    jan = (int) (area * getResources().getInteger(R.integer.GAPSInputY1Jan));
                    feb = (int) (area * getResources().getInteger(R.integer.GAPSInputY1Feb));
                    mar = (int) (area * getResources().getInteger(R.integer.GAPSInputY1Mar));
                    apr = (int) (area * getResources().getInteger(R.integer.GAPSInputY1Apr));
                    may = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1May) + getResources().getInteger(R.integer.GAPSLaborY1May)));
                    jun = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Jun) + getResources().getInteger(R.integer.GAPSLaborY1Jun)));
                    jul = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Jul) + getResources().getInteger(R.integer.GAPSLaborY1Jul)));
                    aug = (int) (area * getResources().getInteger(R.integer.GAPSInputY1Aug));
                    sep = (int) (area * getResources().getInteger(R.integer.GAPSInputY1Sep));
                    oct = (int) (area * getResources().getInteger(R.integer.GAPSInputY1Oct));
                    nov = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Nov) + getResources().getInteger(R.integer.GAPSLaborY1Nov)));
                    dec = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Dec) + getResources().getInteger(R.integer.GAPSLaborY1Dec)));
                } else {
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
        }else{
            if (yearLaunch.equals("1")&&(yearStart.equals("Year 1")||yearStart.equals("Year 2")||yearStart.equals("Year 3")||yearStart.equals("Year 4")||yearStart.equals("Year 5")||yearStart.equals("Year 6")||yearStart.equals("Year 7"))){
                if (main == "replant"){
                    setText(jlb, p24);
                    setText(fblb, p24);
                    setText(mrlb, p24);
                    setText(ablb, p24);
                    setText(mylb, p24);
                    setText(jnlb, p24+p1);
                    setText(jllb, "");
                    setText(aglb, p3);
                    setText(splb, p2);
                    setText(oclb, p4+p7);
                    setText(nvlb, p12+p15);
                    setText(dclb, p4+p6+p14+p16);
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
                    setText(jlb, p8+" + "+p9+" + "+p14+" + "+p19+" + "+p24);
                    setText(fblb, p10+" + "+p16+" + "+p19+" + "+p21+" + "+p24);
                    setText(mrlb, p10+" + "+p16+" + "+p19+" + "+p21+" + "+p24);
                    setText(ablb, p16+" + "+p19+" + "+p21+" + "+ p24);
                    setText(mylb, p12+" + "+p15+" + "+p22+" + "+ p20+" + "+ p22+" + "+ p24);
                    setText(jnlb, p14+" + "+p16+" + "+p20+" + "+ p22+" + "+ p24);
                    setText(jllb, p16+" + "+p19+" + "+p24);
                    setText(aglb, p16+" + "+p22+" + "+p21+" + "+p24);
                    setText(splb, p16+" + "+p19+" + "+p21+" + "+p24);
                    setText(oclb, p16+" + "+p19+" + "+p21+" + "+p24);
                    setText(nvlb, p12+" + "+p15+" + "+p22+" + "+p24);
                    setText(dclb, p11+" + "+p14+" + "+p16+" + "+p19+" + "+p24);

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
                    setText(jlb, p16+" + "+ p19+" + "+ p24);
                    setText(fblb, p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(mrlb, p14+" + "+ p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(ablb, p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(mylb, p12+" + "+ p15+" + "+ p20+" + "+ p22+" + "+ p24);
                    setText(jnlb, p14+" + "+ p16+" + "+ p20+" + "+ p22+" + "+ p24);
                    setText(jllb, p16+" + "+ p19+" + "+ p24);
                    setText(aglb, p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(splb, p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(oclb, p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(nvlb, p12+" + "+ p15+" + "+ p20+" + "+ p22+" + "+ p24);
                    setText(dclb, p14+" + "+ p16+" + "+ p19+" + "+ p21+" + "+ p24);

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
                    setText(jlb, p16+" + "+ p19+" + "+ p24);
                    setText(fblb, p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(mrlb, p14+" + "+ p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(ablb, p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(mylb, p12+" + "+ p15+" + "+ p20+" + "+ p22+" + "+ p24);
                    setText(jnlb, p14+" + "+ p16+" + "+ p20+" + "+ p22+" + "+ p24);
                    setText(jllb, p16+" + "+ p19+" + "+ p24);
                    setText(aglb, p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(splb, p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(oclb, p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(nvlb, p12+" + "+ p15+" + "+ p20+" + "+ p22+" + "+ p24);
                    setText(dclb, p14+" + "+ p16+" + "+ p19+" + "+ p21+" + "+ p24);
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

            }else if ((yearLaunch.equals("1")&& yearStart.equals("-1"))||(yearLaunch.equals("2")&&(yearStart.equals("Year 1")||yearStart.equals("Year 2")||yearStart.equals("Year 3")||yearStart.equals("Year 4")||yearStart.equals("Year 5")||yearStart.equals("Year 6")||yearStart.equals("Year 7")))){
                if (main == "replant"){
                    setText(jlb, p16+" + "+ p19);
                    setText(fblb, p13+" + "+ p16+" + "+ p19);
                    setText(mrlb, p5+" + "+p7+" + "+ p12+" + "+ p14+" + "+ p16+" + "+ p22);
                    setText(ablb, p16+" + "+ p19);
                    setText(mylb, p15+" + "+ p19);
                    setText(jnlb, p13+" + "+ p14+" + "+ p16+" + "+ p22);
                    setText(jllb, p12+" + "+ p16+" + "+ p19);
                    setText(aglb, p16+" + "+ p19);
                    setText(splb, p14+" + "+ p16+" + "+ p22);
                    setText(oclb, p13+" + "+ p16+" + "+ p19);
                    setText(nvlb, p12+" + "+ p15+" + "+ p19);
                    setText(dclb, p14+" + "+ p16+" + "+ p19);
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
                    setText(jlb, p16+" + "+ p19);
                    setText(fblb, p16+" + "+ p19+" + "+ p21);
                    setText(mrlb, p14+" + "+ p16+" + "+ p22+" + "+ p21);
                    setText(ablb, p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(mylb, p12+" + "+ p15+" + "+ p20+" + "+ p22+" + "+ p24);
                    setText(jnlb, p14+" + "+ p16+" + "+ p20+" + "+ p22+" + "+ p24);
                    setText(jllb, p16+" + "+ p19+" + "+ p24);
                    setText(aglb, p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(splb, p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(oclb, p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(nvlb, p12+" + "+ p15+" + "+ p20+" + "+ p22+" + "+ p24);
                    setText(dclb, p14+" + "+ p16+" + "+ p20+" + "+ p24);

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
                    setText(jlb, p16+" + "+ p19+" + "+ p24);
                    setText(fblb, p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(mrlb, p14+" + "+ p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(ablb, p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(mylb, p12+" + "+ p15+" + "+ p20+" + "+ p22+" + "+ p24);
                    setText(jnlb, p14+" + "+ p16+" + "+ p20+" + "+ p22+" + "+ p24);
                    setText(jllb, p16+" + "+ p19+" + "+ p24);
                    setText(aglb, p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(splb, p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(oclb, p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(nvlb, p12+" + "+ p15+" + "+ p20+" + "+ p22+" + "+ p24);
                    setText(dclb, p14+" + "+ p16+" + "+ p19+" + "+ p21+" + "+ p24);

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
                    setText(jlb, p16+" + "+ p19+" + "+ p24);
                    setText(fblb, p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(mrlb, p14+" + "+ p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(ablb, p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(mylb, p12+" + "+ p15+" + "+ p20+" + "+ p22+" + "+ p24);
                    setText(jnlb, p14+" + "+ p16+" + "+ p20+" + "+ p22+" + "+ p24);
                    setText(jllb, p16+" + "+ p19+" + "+ p24);
                    setText(aglb, p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(splb, p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(oclb, p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(nvlb, p12+" + "+ p15+" + "+ p20+" + "+ p22+" + "+ p24);
                    setText(dclb, p14+" + "+ p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    if (relat == "extra"){
                        if (labor == "labor"){
                            jan = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Jan)+getResources().getInteger(R.integer.GAPSLaborY1Jan)+getResources().getInteger(R.integer.difInputY2Jan)));
                            feb = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Feb)+getResources().getInteger(R.integer.GAPSLaborY1Feb)+getResources().getInteger(R.integer.difInputY2Feb)));
                            mar = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Mar)+getResources().getInteger(R.integer.GAPSLaborY1Mar)+getResources().getInteger(R.integer.difInputY2Mar)));
                            apr = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Apr)+getResources().getInteger(R.integer.GAPSLaborY1Apr)+getResources().getInteger(R.integer.difInputY2Apr)));
                            may = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1May)+getResources().getInteger(R.integer.GAPSLaborY1May)+getResources().getInteger(R.integer.difInputY2May)));
                            jun = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Jun)+getResources().getInteger(R.integer.GAPSLaborY1Jun)+getResources().getInteger(R.integer.difInputY2Jun)));
                            jul = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Jul)+getResources().getInteger(R.integer.GAPSLaborY1Jul)+getResources().getInteger(R.integer.difInputY2Jul)));
                            aug = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Aug)+getResources().getInteger(R.integer.GAPSLaborY1Aug)+getResources().getInteger(R.integer.difInputY2Aug)));
                            sep = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Sep)+getResources().getInteger(R.integer.GAPSLaborY1Sep)+getResources().getInteger(R.integer.difInputY2Sep)));
                            oct = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Oct)+getResources().getInteger(R.integer.GAPSLaborY1Oct)+getResources().getInteger(R.integer.difInputY2Oct)));
                            nov = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Nov)+getResources().getInteger(R.integer.GAPSLaborY1Nov)+getResources().getInteger(R.integer.difInputY2Nov)));
                            dec = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Dec)+getResources().getInteger(R.integer.GAPSLaborY1Dec)+getResources().getInteger(R.integer.difInputY2Dec)));
                        }else if(labor =="season") {
                            jan = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Jan)+getResources().getInteger(R.integer.difInputY2Jan)));
                            feb = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Feb)+getResources().getInteger(R.integer.difInputY2Feb)));
                            mar = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Mar)+getResources().getInteger(R.integer.difInputY2Mar)));
                            apr = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Apr)+getResources().getInteger(R.integer.difInputY2Apr)));
                            may = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1May)+getResources().getInteger(R.integer.GAPSLaborY1May)+getResources().getInteger(R.integer.difInputY2May)));
                            jun = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Jun)+getResources().getInteger(R.integer.GAPSLaborY1Jun)+getResources().getInteger(R.integer.difInputY2Jun)));
                            jul = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Jul)+getResources().getInteger(R.integer.GAPSLaborY1Jul)+getResources().getInteger(R.integer.difInputY2Jul)));
                            aug = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Aug)+getResources().getInteger(R.integer.difInputY2Aug)));
                            sep = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Sep)+getResources().getInteger(R.integer.difInputY2Sep)));
                            oct = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Oct)+getResources().getInteger(R.integer.difInputY2Oct)));
                            nov = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Nov)+getResources().getInteger(R.integer.GAPSLaborY1Nov)+getResources().getInteger(R.integer.difInputY2Nov)));
                            dec = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Dec)+getResources().getInteger(R.integer.GAPSLaborY1Dec)+getResources().getInteger(R.integer.difInputY2Dec)));
                        }else{
                            jan = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Jan)+getResources().getInteger(R.integer.difInputY2Jan)));
                            feb = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Feb)+getResources().getInteger(R.integer.difInputY2Feb)));
                            mar = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Mar)+getResources().getInteger(R.integer.difInputY2Mar)));
                            apr = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Apr)+getResources().getInteger(R.integer.difInputY2Apr)));
                            may = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1May)+getResources().getInteger(R.integer.difInputY2May)));
                            jun = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Jun)+getResources().getInteger(R.integer.difInputY2Jun)));
                            jul = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Jul)+getResources().getInteger(R.integer.difInputY2Jul)));
                            aug = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Aug)+getResources().getInteger(R.integer.difInputY2Aug)));
                            sep = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Sep)+getResources().getInteger(R.integer.difInputY2Sep)));
                            oct = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Oct)+getResources().getInteger(R.integer.difInputY2Oct)));
                            nov = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Nov)+getResources().getInteger(R.integer.difInputY2Nov)));
                            dec = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Dec)+getResources().getInteger(R.integer.difInputY2Dec)));
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

            }else if ((yearLaunch.equals("2")&& yearStart.equals("-1"))||(yearLaunch.equals("1")&& yearStart.equals("-2"))||(yearLaunch.equals("3")&&(yearStart.equals("Year 1")||yearStart.equals("Year 2")||yearStart.equals("Year 3")||yearStart.equals("Year 4")||yearStart.equals("Year 5")||yearStart.equals("Year 6")||yearStart.equals("Year 7")))){

                if (main == "replant"){
                    setText(jlb, p16+" + "+ p19);
                    setText(fblb, p16+" + "+ p19+" + "+ p21);
                    setText(mrlb, p12+" + "+ p14+" + "+ p16+" + "+ p19+" + "+ p21);
                    setText(ablb, p16+" + "+ p22+" + "+ p21);
                    setText(mylb, p15+" + "+ p20+" + "+ p22);
                    setText(jnlb, p12+" + "+ p14+" + "+ p16+" + "+ p19+" + "+ p20+" + "+ p22+" + "+ p24);
                    setText(jllb, p16+" + "+ p19+" + "+ p24);
                    setText(aglb, p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(splb, p12+" + "+ p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(oclb, p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(nvlb, p15+" + "+ p20+" + "+ p24);
                    setText(dclb, p12+" + "+ p14+" + "+ p16+" + "+ p20+" + "+ p24);
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
                    setText(jlb, p16+" + "+ p19+" + "+ p24);
                    setText(fblb, p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(mrlb, p14+" + "+ p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(ablb, p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(mylb, p12+" + "+ p15+" + "+ p20+" + "+ p22+" + "+ p24);
                    setText(jnlb, p14+" + "+ p16+" + "+p20 +" + "+ p22+" + "+ p24);
                    setText(jllb, p16+" + "+ p19+" + "+ p24);
                    setText(aglb, p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(splb, p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(oclb, p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(nvlb, p12+" + "+ p15+" + "+ p20+" + "+ p24);
                    setText(dclb, p14+" + "+ p16+" + "+ p20+" + "+ p24);

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
                    setText(jlb, p16+" + "+ p19+" + "+ p24);
                    setText(fblb, p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(mrlb, p14+" + "+ p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(ablb, p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(mylb, p12+" + "+ p15+" + "+ p20+" + "+ p22+" + "+ p24);
                    setText(jnlb, p14+" + "+ p16+" + "+ p20+" + "+ p22+" + "+ p24);
                    setText(jllb, p16+" + "+ p19+" + "+ p24);
                    setText(aglb, p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(splb, p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(oclb, p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(nvlb, p12+" + "+ p15+" + "+ p20+" + "+ p22+" + "+ p24);
                    setText(dclb, p14+" + "+ p16+" + "+ p19+" + "+ p21+" + "+ p24);

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
                    setText(jlb, p16+" + "+ p19+" + "+ p24);
                    setText(fblb, p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(mrlb, p14+" + "+ p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(ablb, p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(mylb, p12+" + "+ p15+" + "+ p20+" + "+ p22+" + "+ p24);
                    setText(jnlb, p14+" + "+ p16+" + "+ p20+" + "+ p22+" + "+ p24);
                    setText(jllb, p16+" + "+ p19+" + "+ p24);
                    setText(aglb, p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(splb, p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(oclb, p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(nvlb, p12+" + "+ p15+" + "+ p20+" + "+ p22+" + "+ p24);
                    setText(dclb, p14+" + "+ p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    if (relat == "extra"){
                        if (labor == "labor"){
                            jan = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Jan)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Jan)))+(area * (getResources().getInteger(R.integer.difInputY3Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Feb)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Feb)))+(area * (getResources().getInteger(R.integer.difInputY3Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Mar)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Mar)))+(area * (getResources().getInteger(R.integer.difInputY3Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Apr)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Apr)))+(area * (getResources().getInteger(R.integer.difInputY3Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1May)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1May)))+(area * (getResources().getInteger(R.integer.difInputY3May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Jun)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Jun)))+(area * (getResources().getInteger(R.integer.difInputY3Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Jul)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Jul)))+(area * (getResources().getInteger(R.integer.difInputY3Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Aug)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Aug)))+(area * (getResources().getInteger(R.integer.difInputY3Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Sep)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Sep)))+(area * (getResources().getInteger(R.integer.difInputY3Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Oct)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Oct)))+(area * (getResources().getInteger(R.integer.difInputY3Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Nov)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Nov)))+(area * (getResources().getInteger(R.integer.difInputY3Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Dec)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Dec)))+(area * (getResources().getInteger(R.integer.difInputY3Dec))));
                        }else if(labor =="season") {
                            jan = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Jan)))+(area * (getResources().getInteger(R.integer.difInputY3Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Feb)))+(area * (getResources().getInteger(R.integer.difInputY3Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Mar)))+(area * (getResources().getInteger(R.integer.difInputY3Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Apr)))+(area * (getResources().getInteger(R.integer.difInputY3Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1May)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1May)))+(area * (getResources().getInteger(R.integer.difInputY3May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Jun)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Jun)))+(area * (getResources().getInteger(R.integer.difInputY3Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Jul)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Jul)))+(area * (getResources().getInteger(R.integer.difInputY3Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Aug)))+(area * (getResources().getInteger(R.integer.difInputY3Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Sep)))+(area * (getResources().getInteger(R.integer.difInputY3Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Oct)))+(area * (getResources().getInteger(R.integer.difInputY3Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Nov)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Nov)))+(area * (getResources().getInteger(R.integer.difInputY3Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Dec)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Dec)))+(area * (getResources().getInteger(R.integer.difInputY3Dec))));
                        }else{
                            jan = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Jan)))+(area * (getResources().getInteger(R.integer.difInputY3Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Feb)))+(area * (getResources().getInteger(R.integer.difInputY3Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Mar)))+(area * (getResources().getInteger(R.integer.difInputY3Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Apr)))+(area * (getResources().getInteger(R.integer.difInputY3Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1May)))+(area * (getResources().getInteger(R.integer.difInputY3May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Jun)))+(area * (getResources().getInteger(R.integer.difInputY3Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Jul)))+(area * (getResources().getInteger(R.integer.difInputY3Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Aug)))+(area * (getResources().getInteger(R.integer.difInputY3Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Sep)))+(area * (getResources().getInteger(R.integer.difInputY3Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Oct)))+(area * (getResources().getInteger(R.integer.difInputY3Oct))));
                            nov = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Nov)))+(area * (getResources().getInteger(R.integer.difInputY3Nov))));
                            dec = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Dec)))+(area * (getResources().getInteger(R.integer.difInputY3Dec))));
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
                        }else if(labor =="season") {
                            jan = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Jan))));
                            feb = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Feb))));
                            mar = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Mar))));
                            apr = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Apr))));
                            may = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1May)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1May))));
                            jun = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Jun)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Jun))));
                            jul = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Jul)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Jul))));
                            aug = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Aug))));
                            sep = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Sep))));
                            oct = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Oct))));
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

            }else if ((yearLaunch.equals("3")&& yearStart.equals("-1"))||(yearLaunch.equals("2")&& yearStart.equals("-2"))||(yearLaunch.equals("1")&& yearStart.equals("-3"))||(yearLaunch.equals("4")&&(yearStart.equals("Year 1")||yearStart.equals("Year 2")||yearStart.equals("Year 3")||yearStart.equals("Year 4")||yearStart.equals("Year 5")||yearStart.equals("Year 6")||yearStart.equals("Year 7")))){

                if (main == "replant"){
                    setText(jlb, p16+" + "+ p19);
                    setText(fblb, p16+" + "+ p19+" + "+ p21);
                    setText(mrlb, p12+" + "+ p14+" + "+ p16+" + "+ p19+" + "+ p21);
                    setText(ablb, p16+" + "+ p22+" + "+ p21);
                    setText(mylb, p15+" + "+ p20+" + "+ p22);
                    setText(jnlb, p12+" + "+ p14+" + "+ p16+" + "+ p19+" + "+ p20+" + "+ p22+" + "+ p24);
                    setText(jllb, p16+" + "+ p19+" + "+ p24);
                    setText(aglb, p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(splb, p12+" + "+ p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(oclb, p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(nvlb, p15+" + "+ p20+" + "+ p24);
                    setText(dclb, p12+" + "+ p14+" + "+ p16+" + "+ p20+" + "+ p24);
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
                    setText(jlb, p16+" + "+ p19+" + "+ p24);
                    setText(fblb, p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(mrlb, p14+" + "+ p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(ablb, p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(mylb, p12+" + "+ p15+" + "+ p20+" + "+ p22+" + "+ p24);
                    setText(jnlb, p14+" + "+ p16+" + "+ p20+" + "+ p22+" + "+ p24);
                    setText(jllb, p16+" + "+ p19+" + "+ p24);
                    setText(aglb, p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(splb, p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(oclb, p16+" + "+ p19+" + "+ p21+" + "+ p24);
                    setText(nvlb, p12+" + "+ p15+" + "+ p20+" + "+ p22+" + "+ p24);
                    setText(dclb, p14+" + "+ p16+" + "+ p19+" + "+ p21+" + "+ p24);

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
                    }else if(labor =="season") {
                        jan = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Jan))));
                        feb = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Feb))));
                        mar = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Mar))));
                        apr = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Apr))));
                        may = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1May)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1May))));
                        jun = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Jun)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Jun))));
                        jul = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Jul)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Jul))));
                        aug = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Aug))));
                        sep = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Sep))));
                        oct = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Oct))));
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

            }else{
                setText(jlb, p16+" + "+p19+" + "+p24);
                setText(fblb, p16+" + "+p19+" + "+p21+" + "+p24);
                setText(mrlb, p14+" + "+p16+" + "+p19+" + "+p21+" + "+p24);
                setText(ablb, p16+" + "+p19+" + "+p21+" + "+p24);
                setText(mylb, p12+" + "+p15+" + "+p16+" + "+p20+" + "+p18+" + "+p24);
                setText(jnlb, p12+" + "+p16+" + "+p20+" + "+p18+" + "+p24);
                setText(jllb, p16+" + "+p19+" + "+p24);
                setText(aglb, p16+" + "+p19+" + "+p21+" + "+p24);
                setText(splb, p16+" + "+p19+" + "+p21+" + "+p24);
                setText(oclb, p16+" + "+p19+" + "+p21+" + "+p24);
                setText(nvlb, p12+" + "+p15+" + "+p16+" + "+p20+" + "+p18+" + "+p24);
                setText(dclb, p14+" + "+p16+" + "+p19+" + "+p21+" + "+p24);
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
                }else if(labor =="season") {
                    jan = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Jan))));
                    feb = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Feb))));
                    mar = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Mar))));
                    apr = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Apr))));
                    may = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1May)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1May))));
                    jun = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Jun)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Jun))));
                    jul = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Jul)))+(area * (getResources().getInteger(R.integer.GAPSLaborY1Jul))));
                    aug = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Aug))));
                    sep = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Sep))));
                    oct = (int) ((area * (getResources().getInteger(R.integer.GAPSInputY1Oct))));
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
