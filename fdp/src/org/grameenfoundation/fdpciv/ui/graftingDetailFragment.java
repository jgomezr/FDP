package org.grameenfoundation.fdpciv.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.grameenfoundation.fdpciv.R;

import java.text.DecimalFormat;

/**
 * Created by julian_Gf on 9/1/2017.
 */

public class graftingDetailFragment extends Fragment {
    private TextView jlb,fblb,mrlb,ablb,mylb,jnlb,jllb,aglb,splb,oclb,nvlb,dclb,jvl,fbvl,mrvl,abvl,myvl,jnvl,jlvl,agvl,spvl,ocvl,nvvl,dcvl,plt;
    private String p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18,p19,p20,p21,p22,p23,p24,p25,p26,p27,p28,p29,p30,p31,p32,p33,p34,p35,p36,p37,p38,p39,p40,p41,p42,p43,p44,p45,p46,p47,p48,p49,p50,p51,p52,p53,p54,p55,p56,p57,p58,p59;
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
        plt = (TextView) view.findViewById(R.id.pt);
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
        p25 = getString(R.string.p25);
        p26 = getString(R.string.p26);
        p27 = getString(R.string.p27);
        p28 = getString(R.string.p28);
        p29 = getString(R.string.p29);
        p30 = getString(R.string.p30);
        p31 = getString(R.string.p31);
        p32 = getString(R.string.p32);
        p33 = getString(R.string.p33);
        p34 = getString(R.string.p34);
        p35 = getString(R.string.p35);
        p36 = getString(R.string.p36);
        p37 = getString(R.string.p37);
        p38 = getString(R.string.p38);
        p39 = getString(R.string.p39);
        p40 = getString(R.string.p40);
        p41 = getString(R.string.p41);
        p42 = getString(R.string.p42);
        p43 = getString(R.string.p43);
        p44 = getString(R.string.p44);
        p45 = getString(R.string.p45);
        p46 = getString(R.string.p46);
        p47 = getString(R.string.p47);
        p48 = getString(R.string.p48);
        p49 = getString(R.string.p49);
        p50 = getString(R.string.p50);
        p51 = getString(R.string.p51);
        p52 = getString(R.string.p52);
        p53 = getString(R.string.p53);
        p54 = getString(R.string.p54);
        p55 = getString(R.string.p55);
        p56 = getString(R.string.p56);
        p57 = getString(R.string.p57);
        p58 = getString(R.string.p58);
        p59 = getString(R.string.p59);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public void calc(String plot, final String relat, final String labor, final Double area, String yearStart, String yearLaunch){
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
        DecimalFormat decF = new DecimalFormat("FCFA ###,###,###");
        setText(plt, plot);

        if (launchYear < startYear){
            setText(jlb, p17);
            setText(fblb, p33);
            setText(mrlb, p32);
            setText(ablb, p14+", "+p31);
            setText(mylb, p14+", "+p15+", "+p30+", "+p5+", "+p6+", "+p17+", "+p19);
            setText(jnlb, p15+", "+p17);
            setText(jllb, p33);
            setText(aglb, p32);
            setText(splb, p14+", "+p15+", "+p30+", "+p5+", "+p17);
            setText(oclb, p15+", "+p28+", "+p6+", "+p17+", "+p19);
            setText(nvlb, p15+", "+p28+", "+p17);
            setText(dclb, p14+", "+p17);
            setText(plt, plot);
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
                jan = (int) (area * (getResources().getInteger(R.integer.MGAPJan) + getResources().getInteger(R.integer.MGAPSLaborJan)));
                feb = (int) (area * getResources().getInteger(R.integer.MGAPFeb));
                mar = (int) (area * getResources().getInteger(R.integer.MGAPMar));
                apr = (int) (area * getResources().getInteger(R.integer.MGAPApr));
                may = (int) (area * getResources().getInteger(R.integer.MGAPMay) );
                jun = (int) (area * getResources().getInteger(R.integer.MGAPJun) );
                jul = (int) (area * getResources().getInteger(R.integer.MGAPJul));
                aug = (int) (area * getResources().getInteger(R.integer.MGAPAug));
                sep = (int) (area * (getResources().getInteger(R.integer.MGAPSep) + getResources().getInteger(R.integer.MGAPSLaborSep)));
                oct = (int) (area * (getResources().getInteger(R.integer.MGAPOct) + getResources().getInteger(R.integer.MGAPSLaborOct)));
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
        }else{
            if ((yearLaunch.equals("1")&& (yearStart.equals("Year 1")||yearStart.equals("Tahun 1")||yearStart.equals("Année 1")))||(yearLaunch.equals("2")&& (yearStart.equals("Year 2")||yearStart.equals("Tahun 2")||yearStart.equals("Année 2")))||(yearLaunch.equals("3")&& (yearStart.equals("Year 3")||yearStart.equals("Tahun 3")||yearStart.equals("Année 3")))||(yearLaunch.equals("4")&& (yearStart.equals("Year 4")||yearStart.equals("Tahun 4")||yearStart.equals("Année 4")))||(yearLaunch.equals("5")&& (yearStart.equals("Year 5")||yearStart.equals("Tahun 5")||yearStart.equals("Année 5")))||(yearLaunch.equals("6")&& (yearStart.equals("Year 6")||yearStart.equals("Tahun 6")||yearStart.equals("Année 6")))||(yearLaunch.equals("7")&& (yearStart.equals("Year 7")||yearStart.equals("Tahun 7")||yearStart.equals("Année 7")))){

                if (relat == "extra"){
                    setText(jlb, p17);
                    setText(fblb, p33);
                    setText(mrlb, p33);
                    setText(ablb, p33);
                    setText(mylb, p46+", "+p47+", "+p40+", "+p12+", "+p16+", "+p36+", "+p19);
                    setText(jnlb, p43+", "+p47+", "+p16+", "+p49+", "+p36);
                    setText(jllb, p39+", "+p49);
                    setText(aglb, p58);
                    setText(splb, p12+", "+p57+", "+p48+", "+p42+", "+p39+", "+p54+", "+p17);
                    setText(oclb, p55+", "+p10+", "+p12+", "+p36+", "+p39+", "+p17+", "+p19);
                    setText(nvlb, p39+", "+p42+", "+p50+", "+p17);
                    setText(dclb, p58+", "+p39+", "+p54);
                    setText(plt, plot);

                    if (labor == "labor"){
                        jan = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Jan)+getResources().getInteger(R.integer.GraftingLaborY1Jan)+getResources().getInteger(R.integer.difInputY1Jan))+getResources().getInteger(R.integer.difLaborY1Jan));
                        feb = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Feb)+getResources().getInteger(R.integer.GraftingLaborY1Feb)+getResources().getInteger(R.integer.difInputY1Feb))+getResources().getInteger(R.integer.difLaborY1Feb));
                        mar = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Mar)+getResources().getInteger(R.integer.GraftingLaborY1Mar)+getResources().getInteger(R.integer.difInputY1Mar))+getResources().getInteger(R.integer.difLaborY1Mar));
                        apr = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Apr)+getResources().getInteger(R.integer.GraftingLaborY1Apr)+getResources().getInteger(R.integer.difInputY1Apr))+getResources().getInteger(R.integer.difLaborY1Apr));
                        may = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1May)+getResources().getInteger(R.integer.GraftingLaborY1May)+getResources().getInteger(R.integer.difInputY1May))+getResources().getInteger(R.integer.difLaborY1May));
                        jun = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Jun)+getResources().getInteger(R.integer.GraftingLaborY1Jun)+getResources().getInteger(R.integer.difInputY1Jun))+getResources().getInteger(R.integer.difLaborY1Jun));
                        jul = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Jul)+getResources().getInteger(R.integer.GraftingLaborY1Jul)+getResources().getInteger(R.integer.difInputY1Jul))+getResources().getInteger(R.integer.difLaborY1Jul));
                        aug = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Aug)+getResources().getInteger(R.integer.GraftingLaborY1Aug)+getResources().getInteger(R.integer.difInputY1Aug))+getResources().getInteger(R.integer.difLaborY1Aug));
                        sep = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Sep)+getResources().getInteger(R.integer.GraftingLaborY1Sep)+getResources().getInteger(R.integer.difInputY1Sep))+getResources().getInteger(R.integer.difLaborY1Sep));
                        oct = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Oct)+getResources().getInteger(R.integer.GraftingLaborY1Oct)+getResources().getInteger(R.integer.difInputY1Oct))+getResources().getInteger(R.integer.difLaborY1Oct));
                        nov = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Nov)+getResources().getInteger(R.integer.GraftingLaborY1Nov)+getResources().getInteger(R.integer.difInputY1Nov))+getResources().getInteger(R.integer.difLaborY1Nov));
                        dec = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Dec)+getResources().getInteger(R.integer.GraftingLaborY1Dec)+getResources().getInteger(R.integer.difInputY1Dec))+getResources().getInteger(R.integer.difLaborY1Dec));
                    }else if(labor =="season") {
                        jan = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Jan)+getResources().getInteger(R.integer.GraftingLaborY1Jan)+getResources().getInteger(R.integer.difInputY1Jan))+getResources().getInteger(R.integer.difLaborY1Jan));
                        feb = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Feb)+getResources().getInteger(R.integer.difInputY1Feb)));
                        mar = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Mar)+getResources().getInteger(R.integer.difInputY1Mar)));
                        apr = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Apr)+getResources().getInteger(R.integer.difInputY1Apr)));
                        may = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1May)+getResources().getInteger(R.integer.difInputY1May)));
                        jun = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Jun)+getResources().getInteger(R.integer.difInputY1Jun)));
                        jul = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Jul)+getResources().getInteger(R.integer.difInputY1Jul)));
                        aug = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Aug)+getResources().getInteger(R.integer.difInputY1Aug)));
                        sep = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Sep)+getResources().getInteger(R.integer.GraftingLaborY1Sep)+getResources().getInteger(R.integer.difInputY1Sep))+getResources().getInteger(R.integer.difLaborY1Sep));
                        oct = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Oct)+getResources().getInteger(R.integer.GraftingLaborY1Oct)+getResources().getInteger(R.integer.difInputY1Oct))+getResources().getInteger(R.integer.difLaborY1Oct));
                        nov = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Nov)+getResources().getInteger(R.integer.GraftingLaborY1Nov)+getResources().getInteger(R.integer.difInputY1Nov))+getResources().getInteger(R.integer.difLaborY1Nov));
                        dec = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Dec)+getResources().getInteger(R.integer.GraftingLaborY1Dec)+getResources().getInteger(R.integer.difInputY1Dec))+getResources().getInteger(R.integer.difLaborY1Dec));
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
                    setText(jlb, p17);
                    setText(fblb, p33);
                    setText(mrlb, p33);
                    setText(ablb, p33);
                    setText(mylb, p46+", "+p47+", "+p40+", "+p12+", "+p16+", "+p36+", "+p19);
                    setText(jnlb, p43+", "+p47+", "+p16+", "+p49+", "+p36);
                    setText(jllb, p39+", "+p49);
                    setText(aglb, p58);
                    setText(splb, p12+", "+p57+", "+p48+", "+p42+", "+p39+", "+p54+", "+p17);
                    setText(oclb, p55+", "+p10+", "+p12+", "+p36+", "+p39+", "+p17+", "+p19);
                    setText(nvlb, p39+", "+p42+", "+p50+", "+p17);
                    setText(dclb, p58+", "+p39+", "+p54);
                    setText(plt, plot);
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
                        jan = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Jan)+getResources().getInteger(R.integer.GraftingLaborY1Jan)));
                        feb = (int) (area * getResources().getInteger(R.integer.GraftingInputY1Feb));
                        mar = (int) (area * getResources().getInteger(R.integer.GraftingInputY1Mar));
                        apr = (int) (area * getResources().getInteger(R.integer.GraftingInputY1Apr));
                        may = (int) (area * getResources().getInteger(R.integer.GraftingInputY1May));
                        jun = (int) (area * getResources().getInteger(R.integer.GraftingInputY1Jun));
                        jul = (int) (area * getResources().getInteger(R.integer.GraftingInputY1Jul));
                        aug = (int) (area * getResources().getInteger(R.integer.GraftingInputY1Aug));
                        sep = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Sep)+getResources().getInteger(R.integer.GraftingLaborY1Sep)));
                        oct = (int) (area * (getResources().getInteger(R.integer.GraftingInputY1Oct)+getResources().getInteger(R.integer.GraftingLaborY1Oct)));
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

            }else if ((yearLaunch.equals("1")&& yearStart.equals("-1"))||(yearLaunch.equals("2")&& (yearStart.equals("Year 1")||yearStart.equals("Tahun 1")||yearStart.equals("Année 1")))||(yearLaunch.equals("3")&& (yearStart.equals("Year 2")||yearStart.equals("Tahun 2")||yearStart.equals("Année 2")))||(yearLaunch.equals("4")&& (yearStart.equals("Year 3")||yearStart.equals("Tahun 3")||yearStart.equals("Année 3")))||(yearLaunch.equals("5")&& (yearStart.equals("Year 4")||yearStart.equals("Tahun 4")||yearStart.equals("Année 4")))||(yearLaunch.equals("6")&& (yearStart.equals("Year 5")||yearStart.equals("Tahun 5")||yearStart.equals("Année 5")))||(yearLaunch.equals("7")&& (yearStart.equals("Year 6")||yearStart.equals("Tahun 6")||yearStart.equals("Année 6")))){

                if (relat == "extra"){
                    setText(jlb, p33);
                    setText(fblb, p33);
                    setText(mrlb, p58);
                    setText(ablb, p39+", "+p27+", "+p54);
                    setText(mylb, p12+", "+p39+", "+p54+", "+p27+", "+p36+", "+p17+", "+p19);
                    setText(jnlb, p17);
                    setText(jllb, p33);
                    setText(aglb, p58);
                    setText(splb, p39+", "+p12+", "+p27+", "+p54+", "+p17);
                    setText(oclb, p27+", "+p54+", "+p36+", "+p17+", "+p19);
                    setText(nvlb, p27+", "+p17);
                    setText(dclb, p39+", "+p52+", "+p17);
                    setText(plt, plot);

                    if (labor == "labor"){
                        jan = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Jan)+getResources().getInteger(R.integer.GraftingLaborY2Jan)+getResources().getInteger(R.integer.difInputY2Jan))+getResources().getInteger(R.integer.difLaborY2Jan));
                        feb = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Feb)+getResources().getInteger(R.integer.GraftingLaborY2Feb)+getResources().getInteger(R.integer.difInputY2Feb))+getResources().getInteger(R.integer.difLaborY2Feb));
                        mar = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Mar)+getResources().getInteger(R.integer.GraftingLaborY2Mar)+getResources().getInteger(R.integer.difInputY2Mar))+getResources().getInteger(R.integer.difLaborY2Mar));
                        apr = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Apr)+getResources().getInteger(R.integer.GraftingLaborY2Apr)+getResources().getInteger(R.integer.difInputY2Apr))+getResources().getInteger(R.integer.difLaborY2Apr));
                        may = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2May)+getResources().getInteger(R.integer.GraftingLaborY2May)+getResources().getInteger(R.integer.difInputY2May))+getResources().getInteger(R.integer.difLaborY2May));
                        jun = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Jun)+getResources().getInteger(R.integer.GraftingLaborY2Jun)+getResources().getInteger(R.integer.difInputY2Jun))+getResources().getInteger(R.integer.difLaborY2Jun));
                        jul = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Jul)+getResources().getInteger(R.integer.GraftingLaborY2Jul)+getResources().getInteger(R.integer.difInputY2Jul))+getResources().getInteger(R.integer.difLaborY2Jul));
                        aug = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Aug)+getResources().getInteger(R.integer.GraftingLaborY2Aug)+getResources().getInteger(R.integer.difInputY2Aug))+getResources().getInteger(R.integer.difLaborY2Aug));
                        sep = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Sep)+getResources().getInteger(R.integer.GraftingLaborY2Sep)+getResources().getInteger(R.integer.difInputY2Sep))+getResources().getInteger(R.integer.difLaborY2Sep));
                        oct = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Oct)+getResources().getInteger(R.integer.GraftingLaborY2Oct)+getResources().getInteger(R.integer.difInputY2Oct))+getResources().getInteger(R.integer.difLaborY2Oct));
                        nov = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Nov)+getResources().getInteger(R.integer.GraftingLaborY2Nov)+getResources().getInteger(R.integer.difInputY2Nov))+getResources().getInteger(R.integer.difLaborY2Nov));
                        dec = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Dec)+getResources().getInteger(R.integer.GraftingLaborY2Dec)+getResources().getInteger(R.integer.difInputY2Dec))+getResources().getInteger(R.integer.difLaborY2Dec));
                    }else if(labor =="season") {
                        jan = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Jan)+getResources().getInteger(R.integer.GraftingLaborY2Jan)+getResources().getInteger(R.integer.difInputY2Jan))+getResources().getInteger(R.integer.difLaborY2Jan));
                        feb = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Feb)+getResources().getInteger(R.integer.difInputY2Feb)));
                        mar = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Mar)+getResources().getInteger(R.integer.difInputY2Mar)));
                        apr = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Apr)+getResources().getInteger(R.integer.difInputY2Apr)));
                        may = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2May)+getResources().getInteger(R.integer.difInputY2May)));
                        jun = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Jun)+getResources().getInteger(R.integer.difInputY2Jun)));
                        jul = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Jul)+getResources().getInteger(R.integer.difInputY2Jul)));
                        aug = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Aug)+getResources().getInteger(R.integer.difInputY2Aug)));
                        sep = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Sep)+getResources().getInteger(R.integer.GraftingLaborY2Sep)+getResources().getInteger(R.integer.difInputY2Sep))+getResources().getInteger(R.integer.difLaborY2Sep));
                        oct = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Oct)+getResources().getInteger(R.integer.GraftingLaborY2Oct)+getResources().getInteger(R.integer.difInputY2Oct))+getResources().getInteger(R.integer.difLaborY2Oct));
                        nov = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Nov)+getResources().getInteger(R.integer.GraftingLaborY2Nov)+getResources().getInteger(R.integer.difInputY2Nov))+getResources().getInteger(R.integer.difLaborY2Nov));
                        dec = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Dec)+getResources().getInteger(R.integer.GraftingLaborY2Dec)+getResources().getInteger(R.integer.difInputY2Dec))+getResources().getInteger(R.integer.difLaborY2Dec));
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
                    setText(jlb, p33);
                    setText(fblb, p33);
                    setText(mrlb, p58);
                    setText(ablb, p39+", "+p27+", "+p54);
                    setText(mylb, p12+", "+p39+", "+p54+", "+p27+", "+p36+", "+p17+", "+p19);
                    setText(jnlb, p17);
                    setText(jllb, p33);
                    setText(aglb, p58);
                    setText(splb, p39+", "+p12+", "+p27+", "+p54+", "+p17);
                    setText(oclb, p27+", "+p54+", "+p36+", "+p17+", "+p19);
                    setText(nvlb, p27+", "+p17);
                    setText(dclb, p39+", "+p52+", "+p17);
                    setText(plt, plot);
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
                        jan = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Jan)+getResources().getInteger(R.integer.GraftingLaborY2Jan)));
                        feb = (int) (area * getResources().getInteger(R.integer.GraftingInputY2Feb));
                        mar = (int) (area * getResources().getInteger(R.integer.GraftingInputY2Mar));
                        apr = (int) (area * getResources().getInteger(R.integer.GraftingInputY2Apr));
                        may = (int) (area * getResources().getInteger(R.integer.GraftingInputY2May));
                        jun = (int) (area * getResources().getInteger(R.integer.GraftingInputY2Jun));
                        jul = (int) (area * getResources().getInteger(R.integer.GraftingInputY2Jul));
                        aug = (int) (area * getResources().getInteger(R.integer.GraftingInputY2Aug));
                        sep = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Sep)+getResources().getInteger(R.integer.GraftingLaborY2Sep)));
                        oct = (int) (area * (getResources().getInteger(R.integer.GraftingInputY2Oct)+getResources().getInteger(R.integer.GraftingLaborY2Oct)));
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

            }else if ((yearLaunch.equals("1")||yearStart.equals("-2"))||(yearLaunch.equals("2")&& yearStart.equals("-1"))||(yearLaunch.equals("3")&& (yearStart.equals("Year 1")||yearStart.equals("Tahun 1")||yearStart.equals("Année 1")))||(yearLaunch.equals("4")&& (yearStart.equals("Year 2")||yearStart.equals("Tahun 2")||yearStart.equals("Année 2")))||(yearLaunch.equals("5")&& (yearStart.equals("Year 3")||yearStart.equals("Tahun 3")||yearStart.equals("Année 3")))||(yearLaunch.equals("6")&& (yearStart.equals("Year 4")||yearStart.equals("Tahun 4")||yearStart.equals("Année 4")))||(yearLaunch.equals("7")&& (yearStart.equals("Year 5")||yearStart.equals("Tahun 5")||yearStart.equals("Année 5")))){

                if (relat == "extra"){
                    setText(jlb, p17);
                    setText(fblb, p33);
                    setText(mrlb, p58);
                    setText(ablb, p54+", "+p27+", "+p39);
                    setText(mylb, p54+", "+p27+", "+p39+", "+p50+", "+p12+", "+p36+", "+p19);
                    setText(jnlb, p50+", "+p17);
                    setText(jllb, p33);
                    setText(aglb, p58);
                    setText(splb, p27+", "+p54+", "+p39+", "+p50+", "+p12+", "+p17);
                    setText(oclb, p27+", "+p50+", "+p36+", "+p17+", "+p19);
                    setText(nvlb, p27+", "+p50+", "+p17);
                    setText(dclb, p39+", "+p54+", "+p52+", "+p17);
                    setText(plt, plot);

                    if (labor == "labor"){
                        jan = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Jan)))+(area * (getResources().getInteger(R.integer.GraftingLaborY3Jan)))+(area * (getResources().getInteger(R.integer.difInputY3Jan)))+getResources().getInteger(R.integer.difLaborY3Jan));
                        feb = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Feb)))+(area * (getResources().getInteger(R.integer.GraftingLaborY3Feb)))+(area * (getResources().getInteger(R.integer.difInputY3Feb)))+getResources().getInteger(R.integer.difLaborY3Feb));
                        mar = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Mar)))+(area * (getResources().getInteger(R.integer.GraftingLaborY3Mar)))+(area * (getResources().getInteger(R.integer.difInputY3Mar)))+getResources().getInteger(R.integer.difLaborY3Mar));
                        apr = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Apr)))+(area * (getResources().getInteger(R.integer.GraftingLaborY3Apr)))+(area * (getResources().getInteger(R.integer.difInputY3Apr)))+getResources().getInteger(R.integer.difLaborY3Apr));
                        may = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3May)))+(area * (getResources().getInteger(R.integer.GraftingLaborY3May)))+(area * (getResources().getInteger(R.integer.difInputY3May)))+getResources().getInteger(R.integer.difLaborY3May));
                        jun = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Jun)))+(area * (getResources().getInteger(R.integer.GraftingLaborY3Jun)))+(area * (getResources().getInteger(R.integer.difInputY3Jun)))+getResources().getInteger(R.integer.difLaborY3Jun));
                        jul = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Jul)))+(area * (getResources().getInteger(R.integer.GraftingLaborY3Jul)))+(area * (getResources().getInteger(R.integer.difInputY3Jul)))+getResources().getInteger(R.integer.difLaborY3Jul));
                        aug = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Aug)))+(area * (getResources().getInteger(R.integer.GraftingLaborY3Aug)))+(area * (getResources().getInteger(R.integer.difInputY3Aug)))+getResources().getInteger(R.integer.difLaborY3Aug));
                        sep = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Sep)))+(area * (getResources().getInteger(R.integer.GraftingLaborY3Sep)))+(area * (getResources().getInteger(R.integer.difInputY3Sep)))+getResources().getInteger(R.integer.difLaborY3Sep));
                        oct = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Oct)))+(area * (getResources().getInteger(R.integer.GraftingLaborY3Oct)))+(area * (getResources().getInteger(R.integer.difInputY3Oct)))+getResources().getInteger(R.integer.difLaborY3Oct));
                        nov = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Nov)))+(area * (getResources().getInteger(R.integer.GraftingLaborY3Nov)))+(area * (getResources().getInteger(R.integer.difInputY3Nov)))+getResources().getInteger(R.integer.difLaborY3Nov));
                        dec = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Dec)))+(area * (getResources().getInteger(R.integer.GraftingLaborY3Dec)))+(area * (getResources().getInteger(R.integer.difInputY3Dec)))+getResources().getInteger(R.integer.difLaborY3Dec));
                    }else if(labor =="season") {
                        jan = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Jan)))+(area * (getResources().getInteger(R.integer.GraftingLaborY3Jan)))+(area * (getResources().getInteger(R.integer.difInputY3Jan)))+getResources().getInteger(R.integer.difLaborY3Jan));
                        feb = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Feb)))+(area * (getResources().getInteger(R.integer.difInputY3Feb))));
                        mar = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Mar)))+(area * (getResources().getInteger(R.integer.difInputY3Mar))));
                        apr = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Apr)))+(area * (getResources().getInteger(R.integer.difInputY3Apr))));
                        may = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3May)))+(area * (getResources().getInteger(R.integer.difInputY3May))));
                        jun = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Jun)))+(area * (getResources().getInteger(R.integer.difInputY3Jun))));
                        jul = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Jul)))+(area * (getResources().getInteger(R.integer.difInputY3Jul))));
                        aug = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Aug)))+(area * (getResources().getInteger(R.integer.difInputY3Aug))));
                        sep = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Sep)))+(area * (getResources().getInteger(R.integer.GraftingLaborY3Sep)))+(area * (getResources().getInteger(R.integer.difInputY3Sep)))+getResources().getInteger(R.integer.difLaborY3Sep));
                        oct = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Oct)))+(area * (getResources().getInteger(R.integer.GraftingLaborY3Oct)))+(area * (getResources().getInteger(R.integer.difInputY3Oct)))+getResources().getInteger(R.integer.difLaborY3Oct));
                        nov = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Nov)))+(area * (getResources().getInteger(R.integer.GraftingLaborY3Nov)))+(area * (getResources().getInteger(R.integer.difInputY3Nov)))+getResources().getInteger(R.integer.difLaborY3Nov));
                        dec = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Dec)))+(area * (getResources().getInteger(R.integer.GraftingLaborY3Dec)))+(area * (getResources().getInteger(R.integer.difInputY3Dec)))+getResources().getInteger(R.integer.difLaborY3Dec));
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
                    setText(jlb, p17);
                    setText(fblb, p33);
                    setText(mrlb, p58);
                    setText(ablb, p54+", "+p27+", "+p39);
                    setText(mylb, p54+", "+p27+", "+p39+", "+p50+", "+p12+", "+p36+", "+p19);
                    setText(jnlb, p50+", "+p17);
                    setText(jllb, p33);
                    setText(aglb, p58);
                    setText(splb, p27+", "+p54+", "+p39+", "+p50+", "+p12+", "+p17);
                    setText(oclb, p27+", "+p50+", "+p36+", "+p17+", "+p19);
                    setText(nvlb, p27+", "+p50+", "+p17);
                    setText(dclb, p39+", "+p54+", "+p52+", "+p17);
                    setText(plt, plot);
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
                        jan = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Jan)))+(area * (getResources().getInteger(R.integer.GraftingLaborY3Jan))));
                        feb = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Feb))));
                        mar = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Mar))));
                        apr = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Apr))));
                        may = (int) ((area * getResources().getInteger(R.integer.GraftingInputY3May)));
                        jun = (int) ((area * getResources().getInteger(R.integer.GraftingInputY3Jun)));
                        jul = (int) ((area * getResources().getInteger(R.integer.GraftingInputY3Jul)));
                        aug = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY3Aug))));
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

            }else if ((yearLaunch.equals("1")&& yearStart.equals("-3"))||(yearLaunch.equals("2")&&yearStart.equals("-2"))||(yearLaunch.equals("3")&& yearStart.equals("-1"))||(yearLaunch.equals("4")&& (yearStart.equals("Year 1")||yearStart.equals("Tahun 1")||yearStart.equals("Année 1")))||(yearLaunch.equals("5")&& (yearStart.equals("Year 2")||yearStart.equals("Tahun 2")||yearStart.equals("Année 2")))||(yearLaunch.equals("6")&& (yearStart.equals("Year 3")||yearStart.equals("Tahun 3")||yearStart.equals("Année 3")))||(yearLaunch.equals("7")&& (yearStart.equals("Year 4")||yearStart.equals("Tahun 4")||yearStart.equals("Année 4")))){

                setText(jlb, p17);
                setText(fblb, p33);
                setText(mrlb, p58);
                setText(ablb, p54+", "+p27+", "+p39);
                setText(mylb, p54+", "+p27+", "+p39+", "+p50+", "+p12+", "+p36+", "+p19);
                setText(jnlb, p50+", "+p17);
                setText(jllb, p33);
                setText(aglb, p58);
                setText(splb, p27+", "+p54+", "+p39+", "+p50+", "+p12+", "+p17);
                setText(oclb, p27+", "+p50+", "+p36+", "+p17+", "+p19);
                setText(nvlb, p27+", "+p50+", "+p17);
                setText(dclb, p39+", "+p54+", "+p52+", "+p17);
                setText(plt, plot);
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
                    }else if(labor =="season") {
                        jan = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Jan)))+(area * (getResources().getInteger(R.integer.GraftingLaborY4Jan)))+(area * (getResources().getInteger(R.integer.difInputY4Jan))));
                        feb = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Feb)))+(area * (getResources().getInteger(R.integer.difInputY4Feb))));
                        mar = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Mar)))+(area * (getResources().getInteger(R.integer.difInputY4Mar))));
                        apr = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Apr)))+(area * (getResources().getInteger(R.integer.difInputY4Apr))));
                        may = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4May)))+(area * (getResources().getInteger(R.integer.difInputY4May))));
                        jun = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Jun)))+(area * (getResources().getInteger(R.integer.difInputY4Jun))));
                        jul = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Jul)))+(area * (getResources().getInteger(R.integer.difInputY4Jul))));
                        aug = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Aug)))+(area * (getResources().getInteger(R.integer.difInputY4Aug))));
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
                    }else if(labor =="season") {
                        jan = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Jan)))+(area * (getResources().getInteger(R.integer.GraftingLaborY4Jan))));
                        feb = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Feb))));
                        mar = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Mar))));
                        apr = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Apr))));
                        may = (int) ((area * getResources().getInteger(R.integer.GraftingInputY4May)));
                        jun = (int) ((area * getResources().getInteger(R.integer.GraftingInputY4Jun)));
                        jul = (int) ((area * getResources().getInteger(R.integer.GraftingInputY4Jul)));
                        aug = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY4Aug))));
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

            }else if ((yearLaunch.equals("1")&& yearStart.equals("-4"))||(yearLaunch.equals("2")&& yearStart.equals("-3"))||(yearLaunch.equals("3")&& yearStart.equals("-2"))||(yearLaunch.equals("4")&& yearStart.equals("-1"))||(yearLaunch.equals("5")&& (yearStart.equals("Year 1")||yearStart.equals("Tahun 1")||yearStart.equals("Année 1")))||(yearLaunch.equals("6")&& (yearStart.equals("Year 2")||yearStart.equals("Tahun 2")||yearStart.equals("Année 2")))||(yearLaunch.equals("7")&& (yearStart.equals("Year 3")||yearStart.equals("Tahun 3")||yearStart.equals("Année 3")))){

                setText(jlb, p17);
                setText(fblb, p33);
                setText(mrlb, p58);
                setText(ablb, p54+", "+p27+", "+p39);
                setText(mylb, p54+", "+p27+", "+p39+", "+p50+", "+p12+", "+p36+", "+p19);
                setText(jnlb, p50+", "+p17);
                setText(jllb, p33);
                setText(aglb, p58);
                setText(splb, p27+", "+p54+", "+p39+", "+p50+", "+p12+", "+p17);
                setText(oclb, p27+", "+p50+", "+p36+", "+p17+", "+p19);
                setText(nvlb, p27+", "+p50+", "+p17);
                setText(dclb, p39+", "+p54+", "+p52+", "+p17);
                setText(plt, plot);

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
                }else if(labor =="season") {
                    jan = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Jan)))+(area * (getResources().getInteger(R.integer.GraftingLaborY5Jan))));
                    feb = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Feb))));
                    mar = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Mar))));
                    apr = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Apr))));
                    may = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5May))));
                    jun = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Jun))));
                    jul = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Jul))));
                    aug = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY5Aug))));
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
            }else if ((yearLaunch.equals("1")&& yearStart.equals("-5"))||(yearLaunch.equals("2")&& yearStart.equals("-4"))||(yearLaunch.equals("3")&& yearStart.equals("-3"))||(yearLaunch.equals("4")&& yearStart.equals("-2"))||(yearLaunch.equals("5")&& yearStart.equals("-1"))||(yearLaunch.equals("6")&& (yearStart.equals("Year 1")||yearStart.equals("Tahun 1")||yearStart.equals("Année 1")))||(yearLaunch.equals("7")&& (yearStart.equals("Year 2")||yearStart.equals("Tahun 2")||yearStart.equals("Année 2")))){

                setText(jlb, p17);
                setText(fblb, p33);
                setText(mrlb, p58);
                setText(ablb, p54+", "+p27+", "+p39);
                setText(mylb, p54+", "+p27+", "+p39+", "+p50+", "+p12+", "+p36+", "+p19);
                setText(jnlb, p50+", "+p17);
                setText(jllb, p33);
                setText(aglb, p58);
                setText(splb, p27+", "+p54+", "+p39+", "+p50+", "+p12+", "+p17);
                setText(oclb, p27+", "+p50+", "+p36+", "+p17+", "+p19);
                setText(nvlb, p27+", "+p50+", "+p17);
                setText(dclb, p39+", "+p54+", "+p52+", "+p17);
                setText(plt, plot);

                if (labor == "labor"){
                    jan = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY6Jan)))+(area * (getResources().getInteger(R.integer.GraftingLaborY6Jan))));
                    feb = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY6Feb)))+(area * (getResources().getInteger(R.integer.GraftingLaborY6Feb))));
                    mar = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY6Mar)))+(area * (getResources().getInteger(R.integer.GraftingLaborY6Mar))));
                    apr = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY6Apr)))+(area * (getResources().getInteger(R.integer.GraftingLaborY6Apr))));
                    may = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY6May)))+(area * (getResources().getInteger(R.integer.GraftingLaborY6May))));
                    jun = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY6Jun)))+(area * (getResources().getInteger(R.integer.GraftingLaborY6Jun))));
                    jul = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY6Jul)))+(area * (getResources().getInteger(R.integer.GraftingLaborY6Jul))));
                    aug = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY6Aug)))+(area * (getResources().getInteger(R.integer.GraftingLaborY6Aug))));
                    sep = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY6Sep)))+(area * (getResources().getInteger(R.integer.GraftingLaborY6Sep))));
                    oct = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY6Oct)))+(area * (getResources().getInteger(R.integer.GraftingLaborY6Oct))));
                    nov = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY6Nov)))+(area * (getResources().getInteger(R.integer.GraftingLaborY6Nov))));
                    dec = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY6Dec)))+(area * (getResources().getInteger(R.integer.GraftingLaborY6Dec))));
                }else if(labor =="season") {
                    jan = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY6Jan)))+(area * (getResources().getInteger(R.integer.GraftingLaborY6Jan))));
                    feb = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY6Feb))));
                    mar = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY6Mar))));
                    apr = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY6Apr))));
                    may = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY6May))));
                    jun = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY6Jun))));
                    jul = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY6Jul))));
                    aug = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY6Aug))));
                    sep = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY6Sep)))+(area * (getResources().getInteger(R.integer.GraftingLaborY6Sep))));
                    oct = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY6Oct)))+(area * (getResources().getInteger(R.integer.GraftingLaborY6Oct))));
                    nov = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY6Nov)))+(area * (getResources().getInteger(R.integer.GraftingLaborY6Nov))));
                    dec = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY6Dec)))+(area * (getResources().getInteger(R.integer.GraftingLaborY6Dec))));
                }else{
                    jan = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY6Jan))));
                    feb = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY6Feb))));
                    mar = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY6Mar))));
                    apr = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY6Apr))));
                    may = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY6May))));
                    jun = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY6Jun))));
                    jul = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY6Jul))));
                    aug = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY6Aug))));
                    sep = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY6Sep))));
                    oct = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY6Oct))));
                    nov = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY6Nov))));
                    dec = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY6Dec))));
                }

            }else{

                setText(jlb, p17);
                setText(fblb, p33);
                setText(mrlb, p58);
                setText(ablb, p54+", "+p27+", "+p39);
                setText(mylb, p54+", "+p27+", "+p39+", "+p50+", "+p12+", "+p36+", "+p19);
                setText(jnlb, p50+", "+p17);
                setText(jllb, p33);
                setText(aglb, p58);
                setText(splb, p27+", "+p54+", "+p39+", "+p50+", "+p12+", "+p17);
                setText(oclb, p27+", "+p50+", "+p36+", "+p17+", "+p19);
                setText(nvlb, p27+", "+p50+", "+p17);
                setText(dclb, p39+", "+p54+", "+p52+", "+p17);
                setText(plt, plot);

                if (labor == "labor"){
                    jan = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY7Jan)))+(area * (getResources().getInteger(R.integer.GraftingLaborY7Jan))));
                    feb = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY7Feb)))+(area * (getResources().getInteger(R.integer.GraftingLaborY7Feb))));
                    mar = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY7Mar)))+(area * (getResources().getInteger(R.integer.GraftingLaborY7Mar))));
                    apr = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY7Apr)))+(area * (getResources().getInteger(R.integer.GraftingLaborY7Apr))));
                    may = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY7May)))+(area * (getResources().getInteger(R.integer.GraftingLaborY7May))));
                    jun = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY7Jun)))+(area * (getResources().getInteger(R.integer.GraftingLaborY7Jun))));
                    jul = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY7Jul)))+(area * (getResources().getInteger(R.integer.GraftingLaborY7Jul))));
                    aug = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY7Aug)))+(area * (getResources().getInteger(R.integer.GraftingLaborY7Aug))));
                    sep = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY7Sep)))+(area * (getResources().getInteger(R.integer.GraftingLaborY7Sep))));
                    oct = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY7Oct)))+(area * (getResources().getInteger(R.integer.GraftingLaborY7Oct))));
                    nov = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY7Nov)))+(area * (getResources().getInteger(R.integer.GraftingLaborY7Nov))));
                    dec = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY7Dec)))+(area * (getResources().getInteger(R.integer.GraftingLaborY7Dec))));
                }else if(labor =="season") {
                    jan = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY7Jan)))+(area * (getResources().getInteger(R.integer.GraftingLaborY7Jan))));
                    feb = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY7Feb))));
                    mar = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY7Mar))));
                    apr = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY7Apr))));
                    may = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY7May))));
                    jun = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY7Jun))));
                    jul = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY7Jul))));
                    aug = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY7Aug))));
                    sep = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY7Sep)))+(area * (getResources().getInteger(R.integer.GraftingLaborY7Sep))));
                    oct = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY7Oct)))+(area * (getResources().getInteger(R.integer.GraftingLaborY7Oct))));
                    nov = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY7Nov)))+(area * (getResources().getInteger(R.integer.GraftingLaborY7Nov))));
                    dec = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY7Dec)))+(area * (getResources().getInteger(R.integer.GraftingLaborY7Dec))));
                }else{
                    jan = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY7Jan))));
                    feb = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY7Feb))));
                    mar = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY7Mar))));
                    apr = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY7Apr))));
                    may = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY7May))));
                    jun = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY7Jun))));
                    jul = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY7Jul))));
                    aug = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY7Aug))));
                    sep = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY7Sep))));
                    oct = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY7Oct))));
                    nov = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY7Nov))));
                    dec = (int) ((area * (getResources().getInteger(R.integer.GraftingInputY7Dec))));
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
