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
    private TextView jlb,fblb,mrlb,ablb,mylb,jnlb,jllb,aglb,splb,oclb,nvlb,dclb,jvl,fbvl,mrvl,abvl,myvl,jnvl,jlvl,agvl,spvl,ocvl,nvvl,dcvl,plt;
    private String p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18,p19,p20,p21,p22,p23,p24,p25,p26,p27,p28,p29,p30,p31,p32,p33,p34,p35,p36,p37,p38,p39,p40,p41,p42,p43,p44,p45,p46,p47,p48,p49,p50,p51,p52,p53,p54,p55,p56,p57,p58,p59,p60,p61,p62,p63,p64,p65,p66,p67,p68,p69,p70,p71,p72,p73,p74,p75,p76,p77,p78;
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
        p60 = getString(R.string.p60);
        p61 = getString(R.string.p61);
        p62 = getString(R.string.p62);
        p63 = getString(R.string.p63);
        p64 = getString(R.string.p64);
        p65 = getString(R.string.p65);
        p66 = getString(R.string.p66);
        p67 = getString(R.string.p67);
        p68 = getString(R.string.p68);
        p69 = getString(R.string.p69);
        p70 = getString(R.string.p70);
        p71 = getString(R.string.p71);
        p72 = getString(R.string.p72);
        p73 = getString(R.string.p73);
        p74 = getString(R.string.p74);
        p75 = getString(R.string.p75);
        p76 = getString(R.string.p76);
        p77 = getString(R.string.p77);
        p78 = getString(R.string.p78);

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
        DecimalFormat decF = new DecimalFormat("Ghs ###,###,###");
        setText(jlb, p45);
        setText(fblb, p45);
        setText(mrlb, p78+", "+p36);
        setText(ablb, p30+", "+p68);
        setText(mylb, p26+", "+p47+", "+p5+", "+p40);
        setText(jnlb, p45);
        setText(jllb, p45);
        setText(aglb, p78+", "+p36);
        setText(splb, p26+", "+p21+", "+p41);
        setText(oclb, p25+", "+p47+", "+p41);
        setText(nvlb, p25);
        setText(dclb, p26);
        setText(plt, plot);
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
            jan = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Jan)+ getResources().getInteger(R.integer.GAPSLaborY1Jan)));
            feb = (int) (area * getResources().getInteger(R.integer.GAPSInputY1Feb));
            mar = (int) (area * getResources().getInteger(R.integer.GAPSInputY1Mar));
            apr = (int) (area * getResources().getInteger(R.integer.GAPSInputY1Apr));
            may = (int) (area * getResources().getInteger(R.integer.GAPSInputY1May));
            jun = (int) (area * getResources().getInteger(R.integer.GAPSInputY1Jun));
            jul = (int) (area * getResources().getInteger(R.integer.GAPSInputY1Jul));
            aug = (int) (area * getResources().getInteger(R.integer.GAPSInputY1Aug));
            sep = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Sep)+ getResources().getInteger(R.integer.GAPSLaborY1Sep)));
            oct = (int) (area * (getResources().getInteger(R.integer.GAPSInputY1Oct)+ getResources().getInteger(R.integer.GAPSLaborY1Oct)));
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

    public void calc2(String plot, final String relat, final String labor, final Double area, String yearStart, String yearLaunch){
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
        setText(plt, plot);

        if (launchYear < startYear){
            setText(jlb, p45);
            setText(fblb, p45);
            setText(mrlb, p78+", "+p36);
            setText(ablb, p43+", "+p35+", "+p44);
            setText(mylb, p43+", "+p23+", "+p44);
            setText(jnlb, p45);
            setText(jllb, p45);
            setText(aglb, p78+", "+p36);
            setText(splb, p43+", "+p35+", "+p44);
            setText(oclb, p42+", "+p23+", "+p44);
            setText(nvlb, p45);
            setText(dclb, p48);
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
                jan = (int) (area * (getResources().getInteger(R.integer.MGAPJan)+ getResources().getInteger(R.integer.MGAPSLaborJan)));
                feb = (int) (area * getResources().getInteger(R.integer.MGAPFeb));
                mar = (int) (area * getResources().getInteger(R.integer.MGAPMar));
                apr = (int) (area * getResources().getInteger(R.integer.MGAPApr));
                may = (int) (area * getResources().getInteger(R.integer.MGAPMay));
                jun = (int) (area * getResources().getInteger(R.integer.MGAPJun));
                jul = (int) (area * getResources().getInteger(R.integer.MGAPJul));
                aug = (int) (area * getResources().getInteger(R.integer.MGAPAug));
                sep = (int) (area * (getResources().getInteger(R.integer.MGAPSep)+ getResources().getInteger(R.integer.MGAPSLaborSep)));
                oct = (int) (area * (getResources().getInteger(R.integer.MGAPOct)+ getResources().getInteger(R.integer.MGAPSLaborOct)));
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
                    setText(jlb, p45);
                    setText(fblb, p45);
                    setText(mrlb, p78+", "+p36+", "+p74);
                    setText(ablb, p26+", "+p41+", "+p74);
                    setText(mylb, p26+", "+p2+", "+p4+", "+p41);
                    setText(jnlb, p74);
                    setText(jllb, p45);
                    setText(aglb, p78+", "+p36);
                    setText(splb, p26+", "+p2+", "+p41);
                    setText(oclb, p25+", "+p4);
                    setText(nvlb, p25+", "+p41);
                    setText(dclb, p26+", "+p60);
                    setText(plt, plot);

                    if (labor == "labor"){
                        jan = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1Jan)+getResources().getInteger(R.integer.thinningLaborCostY1Jan)+getResources().getInteger(R.integer.difInputY1Jan))+getResources().getInteger(R.integer.difLaborY1Jan));
                        feb = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1Feb)+getResources().getInteger(R.integer.thinningLaborCostY1Feb)+getResources().getInteger(R.integer.difInputY1Feb))+getResources().getInteger(R.integer.difLaborY1Feb));
                        mar = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1Mar)+getResources().getInteger(R.integer.thinningLaborCostY1Mar)+getResources().getInteger(R.integer.difInputY1Mar))+getResources().getInteger(R.integer.difLaborY1Mar));
                        apr = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1Apr)+getResources().getInteger(R.integer.thinningLaborCostY1Apr)+getResources().getInteger(R.integer.difInputY1Apr))+getResources().getInteger(R.integer.difLaborY1Apr));
                        may = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1May)+getResources().getInteger(R.integer.thinningLaborCostY1May)+getResources().getInteger(R.integer.difInputY1May))+getResources().getInteger(R.integer.difLaborY1May));
                        jun = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1Jun)+getResources().getInteger(R.integer.thinningLaborCostY1Jun)+getResources().getInteger(R.integer.difInputY1Jun))+getResources().getInteger(R.integer.difLaborY1Jun));
                        jul = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1Jul)+getResources().getInteger(R.integer.thinningLaborCostY1Jul)+getResources().getInteger(R.integer.difInputY1Jul))+getResources().getInteger(R.integer.difLaborY1Jul));
                        aug = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1Aug)+getResources().getInteger(R.integer.thinningLaborCostY1Aug)+getResources().getInteger(R.integer.difInputY1Aug))+getResources().getInteger(R.integer.difLaborY1Aug));
                        sep = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1Sep)+getResources().getInteger(R.integer.thinningLaborCostY1Sep)+getResources().getInteger(R.integer.difInputY1Sep))+getResources().getInteger(R.integer.difLaborY1Sep));
                        oct = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1Oct)+getResources().getInteger(R.integer.thinningLaborCostY1Oct)+getResources().getInteger(R.integer.difInputY1Oct))+getResources().getInteger(R.integer.difLaborY1Oct));
                        nov = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1Nov)+getResources().getInteger(R.integer.thinningLaborCostY1Nov)+getResources().getInteger(R.integer.difInputY1Nov))+getResources().getInteger(R.integer.difLaborY1Nov));
                        dec = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1Dec)+getResources().getInteger(R.integer.thinningLaborCostY1Dec)+getResources().getInteger(R.integer.difInputY1Dec))+getResources().getInteger(R.integer.difLaborY1Dec));
                    }else if(labor =="season") {
                        jan = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1Jan)+getResources().getInteger(R.integer.thinningLaborCostY1Jan)+getResources().getInteger(R.integer.difInputY1Jan))+getResources().getInteger(R.integer.difLaborY1Jan));
                        feb = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1Feb)+getResources().getInteger(R.integer.difInputY1Feb)));
                        mar = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1Mar)+getResources().getInteger(R.integer.difInputY1Mar)));
                        apr = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1Apr)+getResources().getInteger(R.integer.difInputY1Apr)));
                        may = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1May)+getResources().getInteger(R.integer.difInputY1May)));
                        jun = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1Jun)+getResources().getInteger(R.integer.difInputY1Jun)));
                        jul = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1Jul)+getResources().getInteger(R.integer.difInputY1Jul)));
                        aug = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1Aug)+getResources().getInteger(R.integer.difInputY1Aug)));
                        sep = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1Sep)+getResources().getInteger(R.integer.thinningLaborCostY1Sep)+getResources().getInteger(R.integer.difInputY1Sep))+getResources().getInteger(R.integer.difLaborY1Sep));
                        oct = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1Oct)+getResources().getInteger(R.integer.thinningLaborCostY1Oct)+getResources().getInteger(R.integer.difInputY1Oct))+getResources().getInteger(R.integer.difLaborY1Oct));
                        nov = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1Nov)+getResources().getInteger(R.integer.thinningLaborCostY1Nov)+getResources().getInteger(R.integer.difInputY1Nov))+getResources().getInteger(R.integer.difLaborY1Nov));
                        dec = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1Dec)+getResources().getInteger(R.integer.thinningLaborCostY1Dec)+getResources().getInteger(R.integer.difInputY1Dec))+getResources().getInteger(R.integer.difLaborY1Dec));
                    }else{
                        jan = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1Jan)+getResources().getInteger(R.integer.difInputY1Jan)));
                        feb = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1Feb)+getResources().getInteger(R.integer.difInputY1Feb)));
                        mar = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1Mar)+getResources().getInteger(R.integer.difInputY1Mar)));
                        apr = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1Apr)+getResources().getInteger(R.integer.difInputY1Apr)));
                        may = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1May)+getResources().getInteger(R.integer.difInputY1May)));
                        jun = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1Jun)+getResources().getInteger(R.integer.difInputY1Jun)));
                        jul = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1Jul)+getResources().getInteger(R.integer.difInputY1Jul)));
                        aug = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1Aug)+getResources().getInteger(R.integer.difInputY1Aug)));
                        sep = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1Sep)+getResources().getInteger(R.integer.difInputY1Sep)));
                        oct = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1Oct)+getResources().getInteger(R.integer.difInputY1Oct)));
                        nov = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1Nov)+getResources().getInteger(R.integer.difInputY1Nov)));
                        dec = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1Dec)+getResources().getInteger(R.integer.difInputY1Dec)));
                    }

                }else{
                    setText(jlb, p45);
                    setText(fblb, p45);
                    setText(mrlb, p78+", "+p36+", "+p74);
                    setText(ablb, p26+", "+p41+", "+p74);
                    setText(mylb, p26+", "+p21+", "+p47+", "+p41);
                    setText(jnlb, p74);
                    setText(jllb, p45);
                    setText(aglb, p78+", "+p36);
                    setText(splb, p26+", "+p47+", "+p41);
                    setText(oclb, p25+", "+p47);
                    setText(nvlb, p25+", "+p41);
                    setText(dclb, p26+", "+p60);
                    setText(plt, plot);
                    if (labor == "labor"){
                        jan = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1Jan)+getResources().getInteger(R.integer.thinningLaborCostY1Jan)));
                        feb = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1Feb)+getResources().getInteger(R.integer.thinningLaborCostY1Feb)));
                        mar = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1Mar)+getResources().getInteger(R.integer.thinningLaborCostY1Mar)));
                        apr = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1Apr)+getResources().getInteger(R.integer.thinningLaborCostY1Apr)));
                        may = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1May)+getResources().getInteger(R.integer.thinningLaborCostY1May)));
                        jun = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1Jun)+getResources().getInteger(R.integer.thinningLaborCostY1Jun)));
                        jul = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1Jul)+getResources().getInteger(R.integer.thinningLaborCostY1Jul)));
                        aug = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1Aug)+getResources().getInteger(R.integer.thinningLaborCostY1Aug)));
                        sep = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1Sep)+getResources().getInteger(R.integer.thinningLaborCostY1Sep)));
                        oct = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1Oct)+getResources().getInteger(R.integer.thinningLaborCostY1Oct)));
                        nov = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1Nov)+getResources().getInteger(R.integer.thinningLaborCostY1Nov)));
                        dec = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1Dec)+getResources().getInteger(R.integer.thinningLaborCostY1Dec)));
                    }else if(labor =="season") {
                        jan = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1Jan)+getResources().getInteger(R.integer.thinningLaborCostY1Jan)));
                        feb = (int) (area * getResources().getInteger(R.integer.thinningInputsY1Feb));
                        mar = (int) (area * getResources().getInteger(R.integer.thinningInputsY1Mar));
                        apr = (int) (area * getResources().getInteger(R.integer.thinningInputsY1Apr));
                        may = (int) (area * getResources().getInteger(R.integer.thinningInputsY1May));
                        jun = (int) (area * getResources().getInteger(R.integer.thinningInputsY1Jun));
                        jul = (int) (area * getResources().getInteger(R.integer.thinningInputsY1Jul));
                        aug = (int) (area * getResources().getInteger(R.integer.thinningInputsY1Aug));
                        sep = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1Sep)+getResources().getInteger(R.integer.thinningLaborCostY1Sep)));
                        oct = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1Oct)+getResources().getInteger(R.integer.thinningLaborCostY1Oct)));
                        nov = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1Nov)+getResources().getInteger(R.integer.thinningLaborCostY1Nov)));
                        dec = (int) (area * (getResources().getInteger(R.integer.thinningInputsY1Dec)+getResources().getInteger(R.integer.thinningLaborCostY1Dec)));
                    }else{
                        jan = (int) (area * getResources().getInteger(R.integer.thinningInputsY1Jan));
                        feb = (int) (area * getResources().getInteger(R.integer.thinningInputsY1Feb));
                        mar = (int) (area * getResources().getInteger(R.integer.thinningInputsY1Mar));
                        apr = (int) (area * getResources().getInteger(R.integer.thinningInputsY1Apr));
                        may = (int) (area * getResources().getInteger(R.integer.thinningInputsY1May));
                        jun = (int) (area * getResources().getInteger(R.integer.thinningInputsY1Jun));
                        jul = (int) (area * getResources().getInteger(R.integer.thinningInputsY1Jul));
                        aug = (int) (area * getResources().getInteger(R.integer.thinningInputsY1Aug));
                        sep = (int) (area * getResources().getInteger(R.integer.thinningInputsY1Sep));
                        oct = (int) (area * getResources().getInteger(R.integer.thinningInputsY1Oct));
                        nov = (int) (area * getResources().getInteger(R.integer.thinningInputsY1Nov));
                        dec = (int) (area * getResources().getInteger(R.integer.thinningInputsY1Dec));
                    }
                }

            }else if ((yearLaunch.equals("1")&& yearStart.equals("-1"))||(yearLaunch.equals("2")&& (yearStart.equals("Year 1")||yearStart.equals("Tahun 1")||yearStart.equals("Année 1")))||(yearLaunch.equals("3")&& (yearStart.equals("Year 2")||yearStart.equals("Tahun 2")||yearStart.equals("Année 2")))||(yearLaunch.equals("4")&& (yearStart.equals("Year 3")||yearStart.equals("Tahun 3")||yearStart.equals("Année 3")))||(yearLaunch.equals("5")&& (yearStart.equals("Year 4")||yearStart.equals("Tahun 4")||yearStart.equals("Année 4")))||(yearLaunch.equals("6")&& (yearStart.equals("Year 5")||yearStart.equals("Tahun 5")||yearStart.equals("Année 5")))||(yearLaunch.equals("7")&& (yearStart.equals("Year 6")||yearStart.equals("Tahun 6")||yearStart.equals("Année 6")))){

                if (relat == "extra"){
                    setText(jlb, p45);
                    setText(fblb, p45);
                    setText(mrlb, p78+", "+p36);
                    setText(ablb, p30+", "+p68);
                    setText(mylb, p26+", "+p3+", "+p2+", "+p40);
                    setText(jnlb, p45);
                    setText(jllb, p45);
                    setText(aglb, p78+", "+p36);
                    setText(splb, p26+", "+p2+", "+p41);
                    setText(oclb, p25+", "+p3+", "+p41);
                    setText(nvlb, p25);
                    setText(dclb, p26);
                    setText(plt, plot);

                    if (labor == "labor"){
                        jan = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2Jan)+getResources().getInteger(R.integer.thinningLaborCostY2Jan)+getResources().getInteger(R.integer.difInputY2Jan))+getResources().getInteger(R.integer.difLaborY2Jan));
                        feb = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2Feb)+getResources().getInteger(R.integer.thinningLaborCostY2Feb)+getResources().getInteger(R.integer.difInputY2Feb))+getResources().getInteger(R.integer.difLaborY2Feb));
                        mar = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2Mar)+getResources().getInteger(R.integer.thinningLaborCostY2Mar)+getResources().getInteger(R.integer.difInputY2Mar))+getResources().getInteger(R.integer.difLaborY2Mar));
                        apr = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2Apr)+getResources().getInteger(R.integer.thinningLaborCostY2Apr)+getResources().getInteger(R.integer.difInputY2Apr))+getResources().getInteger(R.integer.difLaborY2Apr));
                        may = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2May)+getResources().getInteger(R.integer.thinningLaborCostY2May)+getResources().getInteger(R.integer.difInputY2May))+getResources().getInteger(R.integer.difLaborY2May));
                        jun = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2Jun)+getResources().getInteger(R.integer.thinningLaborCostY2Jun)+getResources().getInteger(R.integer.difInputY2Jun))+getResources().getInteger(R.integer.difLaborY2Jun));
                        jul = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2Jul)+getResources().getInteger(R.integer.thinningLaborCostY2Jul)+getResources().getInteger(R.integer.difInputY2Jul))+getResources().getInteger(R.integer.difLaborY2Jul));
                        aug = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2Aug)+getResources().getInteger(R.integer.thinningLaborCostY2Aug)+getResources().getInteger(R.integer.difInputY2Aug))+getResources().getInteger(R.integer.difLaborY2Aug));
                        sep = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2Sep)+getResources().getInteger(R.integer.thinningLaborCostY2Sep)+getResources().getInteger(R.integer.difInputY2Sep))+getResources().getInteger(R.integer.difLaborY2Sep));
                        oct = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2Oct)+getResources().getInteger(R.integer.thinningLaborCostY2Oct)+getResources().getInteger(R.integer.difInputY2Oct))+getResources().getInteger(R.integer.difLaborY2Oct));
                        nov = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2Nov)+getResources().getInteger(R.integer.thinningLaborCostY2Nov)+getResources().getInteger(R.integer.difInputY2Nov))+getResources().getInteger(R.integer.difLaborY2Nov));
                        dec = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2Dec)+getResources().getInteger(R.integer.thinningLaborCostY2Dec)+getResources().getInteger(R.integer.difInputY2Dec))+getResources().getInteger(R.integer.difLaborY2Dec));
                    }else if(labor =="season") {
                        jan = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2Jan)+getResources().getInteger(R.integer.thinningLaborCostY2Jan)+getResources().getInteger(R.integer.difInputY2Jan))+getResources().getInteger(R.integer.difLaborY2Jan));
                        feb = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2Feb)+getResources().getInteger(R.integer.difInputY2Feb)));
                        mar = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2Mar)+getResources().getInteger(R.integer.difInputY2Mar)));
                        apr = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2Apr)+getResources().getInteger(R.integer.difInputY2Apr)));
                        may = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2May)+getResources().getInteger(R.integer.difInputY2May)));
                        jun = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2Jun)+getResources().getInteger(R.integer.difInputY2Jun)));
                        jul = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2Jul)+getResources().getInteger(R.integer.difInputY2Jul)));
                        aug = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2Aug)+getResources().getInteger(R.integer.difInputY2Aug)));
                        sep = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2Sep)+getResources().getInteger(R.integer.thinningLaborCostY2Sep)+getResources().getInteger(R.integer.difInputY2Sep))+getResources().getInteger(R.integer.difLaborY2Sep));
                        oct = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2Oct)+getResources().getInteger(R.integer.thinningLaborCostY2Oct)+getResources().getInteger(R.integer.difInputY2Oct))+getResources().getInteger(R.integer.difLaborY2Oct));
                        nov = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2Nov)+getResources().getInteger(R.integer.thinningLaborCostY2Nov)+getResources().getInteger(R.integer.difInputY2Nov))+getResources().getInteger(R.integer.difLaborY2Nov));
                        dec = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2Dec)+getResources().getInteger(R.integer.thinningLaborCostY2Dec)+getResources().getInteger(R.integer.difInputY2Dec))+getResources().getInteger(R.integer.difLaborY2Dec));
                    }else{
                        jan = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2Jan)+getResources().getInteger(R.integer.difInputY2Jan)));
                        feb = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2Feb)+getResources().getInteger(R.integer.difInputY2Feb)));
                        mar = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2Mar)+getResources().getInteger(R.integer.difInputY2Mar)));
                        apr = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2Apr)+getResources().getInteger(R.integer.difInputY2Apr)));
                        may = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2May)+getResources().getInteger(R.integer.difInputY2May)));
                        jun = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2Jun)+getResources().getInteger(R.integer.difInputY2Jun)));
                        jul = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2Jul)+getResources().getInteger(R.integer.difInputY2Jul)));
                        aug = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2Aug)+getResources().getInteger(R.integer.difInputY2Aug)));
                        sep = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2Sep)+getResources().getInteger(R.integer.difInputY2Sep)));
                        oct = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2Oct)+getResources().getInteger(R.integer.difInputY2Oct)));
                        nov = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2Nov)+getResources().getInteger(R.integer.difInputY2Nov)));
                        dec = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2Dec)+getResources().getInteger(R.integer.difInputY2Dec)));
                    }

                }else{
                    setText(jlb, p45);
                    setText(fblb, p45);
                    setText(mrlb, p78+", "+p36);
                    setText(ablb, p30+", "+p68);
                    setText(mylb, p26+", "+p47+", "+p5+", "+p40);
                    setText(jnlb, p45);
                    setText(jllb, p45);
                    setText(aglb, p78+", "+p36);
                    setText(splb, p26+", "+p21+", "+p41);
                    setText(oclb, p25+", "+p47+", "+p41);
                    setText(nvlb, p25);
                    setText(dclb, p26);
                    setText(plt, plot);
                    if (labor == "labor"){
                        jan = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2Jan)+getResources().getInteger(R.integer.thinningLaborCostY2Jan)));
                        feb = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2Feb)+getResources().getInteger(R.integer.thinningLaborCostY2Feb)));
                        mar = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2Mar)+getResources().getInteger(R.integer.thinningLaborCostY2Mar)));
                        apr = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2Apr)+getResources().getInteger(R.integer.thinningLaborCostY2Apr)));
                        may = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2May)+getResources().getInteger(R.integer.thinningLaborCostY2May)));
                        jun = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2Jun)+getResources().getInteger(R.integer.thinningLaborCostY2Jun)));
                        jul = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2Jul)+getResources().getInteger(R.integer.thinningLaborCostY2Jul)));
                        aug = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2Aug)+getResources().getInteger(R.integer.thinningLaborCostY2Aug)));
                        sep = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2Sep)+getResources().getInteger(R.integer.thinningLaborCostY2Sep)));
                        oct = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2Oct)+getResources().getInteger(R.integer.thinningLaborCostY2Oct)));
                        nov = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2Nov)+getResources().getInteger(R.integer.thinningLaborCostY2Nov)));
                        dec = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2Dec)+getResources().getInteger(R.integer.thinningLaborCostY2Dec)));
                    }else if(labor =="season") {
                        jan = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2Jan)+getResources().getInteger(R.integer.thinningLaborCostY2Jan)));
                        feb = (int) (area * getResources().getInteger(R.integer.thinningInputsY2Feb));
                        mar = (int) (area * getResources().getInteger(R.integer.thinningInputsY2Mar));
                        apr = (int) (area * getResources().getInteger(R.integer.thinningInputsY2Apr));
                        may = (int) (area * getResources().getInteger(R.integer.thinningInputsY2May));
                        jun = (int) (area * getResources().getInteger(R.integer.thinningInputsY2Jun));
                        jul = (int) (area * getResources().getInteger(R.integer.thinningInputsY2Jul));
                        aug = (int) (area * getResources().getInteger(R.integer.thinningInputsY2Aug));
                        sep = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2Sep)+getResources().getInteger(R.integer.thinningLaborCostY2Sep)));
                        oct = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2Oct)+getResources().getInteger(R.integer.thinningLaborCostY2Oct)));
                        nov = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2Nov)+getResources().getInteger(R.integer.thinningLaborCostY2Nov)));
                        dec = (int) (area * (getResources().getInteger(R.integer.thinningInputsY2Dec)+getResources().getInteger(R.integer.thinningLaborCostY2Dec)));
                    }else{
                        jan = (int) (area * getResources().getInteger(R.integer.thinningInputsY2Jan));
                        feb = (int) (area * getResources().getInteger(R.integer.thinningInputsY2Feb));
                        mar = (int) (area * getResources().getInteger(R.integer.thinningInputsY2Mar));
                        apr = (int) (area * getResources().getInteger(R.integer.thinningInputsY2Apr));
                        may = (int) (area * getResources().getInteger(R.integer.thinningInputsY2May));
                        jun = (int) (area * getResources().getInteger(R.integer.thinningInputsY2Jun));
                        jul = (int) (area * getResources().getInteger(R.integer.thinningInputsY2Jul));
                        aug = (int) (area * getResources().getInteger(R.integer.thinningInputsY2Aug));
                        sep = (int) (area * getResources().getInteger(R.integer.thinningInputsY2Sep));
                        oct = (int) (area * getResources().getInteger(R.integer.thinningInputsY2Oct));
                        nov = (int) (area * getResources().getInteger(R.integer.thinningInputsY2Nov));
                        dec = (int) (area * getResources().getInteger(R.integer.thinningInputsY2Dec));
                    }
                }

            }else if ((yearLaunch.equals("1")||yearStart.equals("-2"))||(yearLaunch.equals("2")&& yearStart.equals("-1"))||(yearLaunch.equals("3")&& (yearStart.equals("Year 1")||yearStart.equals("Tahun 1")||yearStart.equals("Année 1")))||(yearLaunch.equals("4")&& (yearStart.equals("Year 2")||yearStart.equals("Tahun 2")||yearStart.equals("Année 2")))||(yearLaunch.equals("5")&& (yearStart.equals("Year 3")||yearStart.equals("Tahun 3")||yearStart.equals("Année 3")))||(yearLaunch.equals("6")&& (yearStart.equals("Year 4")||yearStart.equals("Tahun 4")||yearStart.equals("Année 4")))||(yearLaunch.equals("7")&& (yearStart.equals("Year 5")||yearStart.equals("Tahun 5")||yearStart.equals("Année 5")))){
                setText(jlb, p45);
                setText(fblb, p45);
                setText(mrlb, p78+", "+p36);
                setText(ablb, p30+", "+p68);
                setText(mylb, p26+", "+p47+", "+p5+", "+p40);
                setText(jnlb, p45);
                setText(jllb, p45);
                setText(aglb, p78+", "+p36);
                setText(splb, p26+", "+p21+", "+p41);
                setText(oclb, p25+", "+p47+", "+p41);
                setText(nvlb, p25);
                setText(dclb, p26);
                setText(plt, plot);
                if (relat == "extra"){

                    if (labor == "labor"){
                        jan = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Jan)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY3Jan)))+(area * (getResources().getInteger(R.integer.difInputY3Jan)))+getResources().getInteger(R.integer.difLaborY3Jan));
                        feb = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Feb)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY3Feb)))+(area * (getResources().getInteger(R.integer.difInputY3Feb)))+getResources().getInteger(R.integer.difLaborY3Feb));
                        mar = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Mar)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY3Mar)))+(area * (getResources().getInteger(R.integer.difInputY3Mar)))+getResources().getInteger(R.integer.difLaborY3Mar));
                        apr = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Apr)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY3Apr)))+(area * (getResources().getInteger(R.integer.difInputY3Apr)))+getResources().getInteger(R.integer.difLaborY3Apr));
                        may = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3May)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY3May)))+(area * (getResources().getInteger(R.integer.difInputY3May)))+getResources().getInteger(R.integer.difLaborY3May));
                        jun = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Jun)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY3Jun)))+(area * (getResources().getInteger(R.integer.difInputY3Jun)))+getResources().getInteger(R.integer.difLaborY3Jun));
                        jul = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Jul)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY3Jul)))+(area * (getResources().getInteger(R.integer.difInputY3Jul)))+getResources().getInteger(R.integer.difLaborY3Jul));
                        aug = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Aug)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY3Aug)))+(area * (getResources().getInteger(R.integer.difInputY3Aug)))+getResources().getInteger(R.integer.difLaborY3Aug));
                        sep = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Sep)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY3Sep)))+(area * (getResources().getInteger(R.integer.difInputY3Sep)))+getResources().getInteger(R.integer.difLaborY3Sep));
                        oct = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Oct)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY3Oct)))+(area * (getResources().getInteger(R.integer.difInputY3Oct)))+getResources().getInteger(R.integer.difLaborY3Oct));
                        nov = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Nov)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY3Nov)))+(area * (getResources().getInteger(R.integer.difInputY3Nov)))+getResources().getInteger(R.integer.difLaborY3Nov));
                        dec = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Dec)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY3Dec)))+(area * (getResources().getInteger(R.integer.difInputY3Dec)))+getResources().getInteger(R.integer.difLaborY3Dec));
                    }else if(labor =="season") {
                        jan = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Jan)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY3Jan)))+(area * (getResources().getInteger(R.integer.difInputY3Jan)))+getResources().getInteger(R.integer.difLaborY3Jan));
                        feb = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Feb)))+(area * (getResources().getInteger(R.integer.difInputY3Feb))));
                        mar = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Mar)))+(area * (getResources().getInteger(R.integer.difInputY3Mar))));
                        apr = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Apr)))+(area * (getResources().getInteger(R.integer.difInputY3Apr))));
                        may = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3May)))+(area * (getResources().getInteger(R.integer.difInputY3May))));
                        jun = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Jun)))+(area * (getResources().getInteger(R.integer.difInputY3Jun))));
                        jul = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Jul)))+(area * (getResources().getInteger(R.integer.difInputY3Jul))));
                        aug = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Aug)))+(area * (getResources().getInteger(R.integer.difInputY3Aug))));
                        sep = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Sep)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY3Sep)))+(area * (getResources().getInteger(R.integer.difInputY3Sep)))+getResources().getInteger(R.integer.difLaborY3Sep));
                        oct = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Oct)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY3Oct)))+(area * (getResources().getInteger(R.integer.difInputY3Oct)))+getResources().getInteger(R.integer.difLaborY3Oct));
                        nov = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Nov)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY3Nov)))+(area * (getResources().getInteger(R.integer.difInputY3Nov)))+getResources().getInteger(R.integer.difLaborY3Nov));
                        dec = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Dec)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY3Dec)))+(area * (getResources().getInteger(R.integer.difInputY3Dec)))+getResources().getInteger(R.integer.difLaborY3Dec));
                    }else{
                        jan = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Jan)))+(area * (getResources().getInteger(R.integer.difInputY3Jan))));
                        feb = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Feb)))+(area * (getResources().getInteger(R.integer.difInputY3Feb))));
                        mar = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Mar)))+(area * (getResources().getInteger(R.integer.difInputY3Mar))));
                        apr = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Apr)))+(area * (getResources().getInteger(R.integer.difInputY3Apr))));
                        may = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3May)))+(area * (getResources().getInteger(R.integer.difInputY3May))));
                        jun = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Jun)))+(area * (getResources().getInteger(R.integer.difInputY3Jun))));
                        jul = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Jul)))+(area * (getResources().getInteger(R.integer.difInputY3Jul))));
                        aug = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Aug)))+(area * (getResources().getInteger(R.integer.difInputY3Aug))));
                        sep = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Sep)))+(area * (getResources().getInteger(R.integer.difInputY3Sep))));
                        oct = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Oct)))+(area * (getResources().getInteger(R.integer.difInputY3Oct))));
                        nov = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Nov)))+(area * (getResources().getInteger(R.integer.difInputY3Nov))));
                        dec = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Dec)))+(area * (getResources().getInteger(R.integer.difInputY3Dec))));
                    }

                }else{
                    if (labor == "labor"){
                        jan = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Jan)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY3Jan))));
                        feb = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Feb)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY3Feb))));
                        mar = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Mar)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY3Mar))));
                        apr = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Apr)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY3Apr))));
                        may = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3May)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY3May))));
                        jun = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Jun)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY3Jun))));
                        jul = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Jul)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY3Jul))));
                        aug = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Aug)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY3Aug))));
                        sep = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Sep)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY3Sep))));
                        oct = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Oct)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY3Oct))));
                        nov = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Nov)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY3Nov))));
                        dec = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Dec)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY3Dec))));
                    }else if(labor =="season") {
                        jan = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Jan)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY3Jan))));
                        feb = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Feb))));
                        mar = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Mar))));
                        apr = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Apr))));
                        may = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3May))));
                        jun = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Jun))));
                        jul = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Jul))));
                        aug = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Aug))));
                        sep = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Sep)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY3Sep))));
                        oct = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Oct)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY3Oct))));
                        nov = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Nov)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY3Nov))));
                        dec = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Dec)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY3Dec))));
                    }else{
                        jan = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Jan))));
                        feb = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Feb))));
                        mar = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Mar))));
                        apr = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Apr))));
                        may = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3May))));
                        jun = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Jun))));
                        jul = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Jul))));
                        aug = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Aug))));
                        sep = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Sep))));
                        oct = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Oct))));
                        nov = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Nov))));
                        dec = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY3Dec))));
                    }
                }

            }else if ((yearLaunch.equals("1")&& yearStart.equals("-3"))||(yearLaunch.equals("2")&&yearStart.equals("-2"))||(yearLaunch.equals("3")&& yearStart.equals("-1"))||(yearLaunch.equals("4")&& (yearStart.equals("Year 1")||yearStart.equals("Tahun 1")||yearStart.equals("Année 1")))||(yearLaunch.equals("5")&& (yearStart.equals("Year 2")||yearStart.equals("Tahun 2")||yearStart.equals("Année 2")))||(yearLaunch.equals("6")&& (yearStart.equals("Year 3")||yearStart.equals("Tahun 3")||yearStart.equals("Année 3")))||(yearLaunch.equals("7")&& (yearStart.equals("Year 4")||yearStart.equals("Tahun 4")||yearStart.equals("Année 4")))){

                setText(jlb, p45);
                setText(fblb, p45);
                setText(mrlb, p78+", "+p36);
                setText(ablb, p30+", "+p68);
                setText(mylb, p26+", "+p47+", "+p5+", "+p40);
                setText(jnlb, p45);
                setText(jllb, p45);
                setText(aglb, p78+", "+p36);
                setText(splb, p26+", "+p21+", "+p41);
                setText(oclb, p25+", "+p47+", "+p41);
                setText(nvlb, p25);
                setText(dclb, p26);
                setText(plt, plot);
                if (relat == "extra"){
                    if (labor == "labor"){
                        jan = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Jan)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY4Jan)))+(area * (getResources().getInteger(R.integer.difInputY4Jan))));
                        feb = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Feb)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY4Feb)))+(area * (getResources().getInteger(R.integer.difInputY4Feb))));
                        mar = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Mar)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY4Mar)))+(area * (getResources().getInteger(R.integer.difInputY4Mar))));
                        apr = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Apr)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY4Apr)))+(area * (getResources().getInteger(R.integer.difInputY4Apr))));
                        may = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4May)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY4May)))+(area * (getResources().getInteger(R.integer.difInputY4May))));
                        jun = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Jun)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY4Jun)))+(area * (getResources().getInteger(R.integer.difInputY4Jun))));
                        jul = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Jul)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY4Jul)))+(area * (getResources().getInteger(R.integer.difInputY4Jul))));
                        aug = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Aug)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY4Aug)))+(area * (getResources().getInteger(R.integer.difInputY4Aug))));
                        sep = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Sep)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY4Sep)))+(area * (getResources().getInteger(R.integer.difInputY4Sep))));
                        oct = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Oct)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY4Oct)))+(area * (getResources().getInteger(R.integer.difInputY4Oct))));
                        nov = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Nov)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY4Nov)))+(area * (getResources().getInteger(R.integer.difInputY4Nov))));
                        dec = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Dec)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY4Dec)))+(area * (getResources().getInteger(R.integer.difInputY4Dec))));
                    }else if(labor =="season") {
                        jan = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Jan)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY4Jan)))+(area * (getResources().getInteger(R.integer.difInputY4Jan))));
                        feb = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Feb)))+(area * (getResources().getInteger(R.integer.difInputY4Feb))));
                        mar = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Mar)))+(area * (getResources().getInteger(R.integer.difInputY4Mar))));
                        apr = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Apr)))+(area * (getResources().getInteger(R.integer.difInputY4Apr))));
                        may = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4May)))+(area * (getResources().getInteger(R.integer.difInputY4May))));
                        jun = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Jun)))+(area * (getResources().getInteger(R.integer.difInputY4Jun))));
                        jul = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Jul)))+(area * (getResources().getInteger(R.integer.difInputY4Jul))));
                        aug = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Aug)))+(area * (getResources().getInteger(R.integer.difInputY4Aug))));
                        sep = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Sep)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY4Sep)))+(area * (getResources().getInteger(R.integer.difInputY4Sep))));
                        oct = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Oct)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY4Oct)))+(area * (getResources().getInteger(R.integer.difInputY4Oct))));
                        nov = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Nov)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY4Nov)))+(area * (getResources().getInteger(R.integer.difInputY4Nov))));
                        dec = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Dec)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY4Dec)))+(area * (getResources().getInteger(R.integer.difInputY4Dec))));
                    }else{
                        jan = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Jan)))+(area * (getResources().getInteger(R.integer.difInputY4Jan))));
                        feb = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Feb)))+(area * (getResources().getInteger(R.integer.difInputY4Feb))));
                        mar = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Mar)))+(area * (getResources().getInteger(R.integer.difInputY4Mar))));
                        apr = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Apr)))+(area * (getResources().getInteger(R.integer.difInputY4Apr))));
                        may = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4May)))+(area * (getResources().getInteger(R.integer.difInputY4May))));
                        jun = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Jun)))+(area * (getResources().getInteger(R.integer.difInputY4Jun))));
                        jul = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Jul)))+(area * (getResources().getInteger(R.integer.difInputY4Jul))));
                        aug = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Aug)))+(area * (getResources().getInteger(R.integer.difInputY4Aug))));
                        sep = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Sep)))+(area * (getResources().getInteger(R.integer.difInputY4Sep))));
                        oct = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Oct)))+(area * (getResources().getInteger(R.integer.difInputY4Oct))));
                        nov = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Nov)))+(area * (getResources().getInteger(R.integer.difInputY4Nov))));
                        dec = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Dec)))+(area * (getResources().getInteger(R.integer.difInputY4Dec))));
                    }

                }else{
                    if (labor == "labor"){
                        jan = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Jan)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY4Jan))));
                        feb = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Feb)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY4Feb))));
                        mar = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Mar)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY4Mar))));
                        apr = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Apr)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY4Apr))));
                        may = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4May)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY4May))));
                        jun = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Jun)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY4Jun))));
                        jul = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Jul)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY4Jul))));
                        aug = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Aug)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY4Aug))));
                        sep = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Sep)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY4Sep))));
                        oct = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Oct)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY4Oct))));
                        nov = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Nov)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY4Nov))));
                        dec = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Dec)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY4Dec))));
                    }else if(labor =="season") {
                        jan = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Jan)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY4Jan))));
                        feb = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Feb))));
                        mar = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Mar))));
                        apr = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Apr))));
                        may = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4May))));
                        jun = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Jun))));
                        jul = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Jul))));
                        aug = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Aug))));
                        sep = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Sep)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY4Sep))));
                        oct = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Oct)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY4Oct))));
                        nov = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Nov)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY4Nov))));
                        dec = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Dec)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY4Dec))));
                    }else{
                        jan = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Jan))));
                        feb = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Feb))));
                        mar = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Mar))));
                        apr = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Apr))));
                        may = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4May))));
                        jun = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Jun))));
                        jul = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Jul))));
                        aug = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Aug))));
                        sep = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Sep))));
                        oct = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Oct))));
                        nov = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Nov))));
                        dec = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY4Dec))));
                    }
                }

            }else if ((yearLaunch.equals("1")&& yearStart.equals("-4"))||(yearLaunch.equals("2")&& yearStart.equals("-3"))||(yearLaunch.equals("3")&& yearStart.equals("-2"))||(yearLaunch.equals("4")&& yearStart.equals("-1"))||(yearLaunch.equals("5")&& (yearStart.equals("Year 1")||yearStart.equals("Tahun 1")||yearStart.equals("Année 1")))||(yearLaunch.equals("6")&& (yearStart.equals("Year 2")||yearStart.equals("Tahun 2")||yearStart.equals("Année 2")))||(yearLaunch.equals("7")&& (yearStart.equals("Year 3")||yearStart.equals("Tahun 3")||yearStart.equals("Année 3")))){

                setText(jlb, p45);
                setText(fblb, p45);
                setText(mrlb, p78+", "+p36);
                setText(ablb, p30+", "+p68);
                setText(mylb, p26+", "+p47+", "+p5+", "+p40);
                setText(jnlb, p45);
                setText(jllb, p45);
                setText(aglb, p78+", "+p36);
                setText(splb, p26+", "+p21+", "+p41);
                setText(oclb, p25+", "+p47+", "+p41);
                setText(nvlb, p25);
                setText(dclb, p26);
                setText(plt, plot);

                if (labor == "labor"){
                    jan = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY5Jan)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY5Jan))));
                    feb = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY5Feb)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY5Feb))));
                    mar = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY5Mar)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY5Mar))));
                    apr = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY5Apr)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY5Apr))));
                    may = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY5May)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY5May))));
                    jun = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY5Jun)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY5Jun))));
                    jul = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY5Jul)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY5Jul))));
                    aug = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY5Aug)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY5Aug))));
                    sep = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY5Sep)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY5Sep))));
                    oct = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY5Oct)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY5Oct))));
                    nov = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY5Nov)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY5Nov))));
                    dec = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY5Dec)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY5Dec))));
                }else if(labor =="season") {
                    jan = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY5Jan)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY5Jan))));
                    feb = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY5Feb))));
                    mar = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY5Mar))));
                    apr = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY5Apr))));
                    may = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY5May))));
                    jun = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY5Jun))));
                    jul = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY5Jul))));
                    aug = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY5Aug))));
                    sep = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY5Sep)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY5Sep))));
                    oct = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY5Oct)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY5Oct))));
                    nov = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY5Nov)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY5Nov))));
                    dec = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY5Dec)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY5Dec))));
                }else{
                    jan = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY5Jan))));
                    feb = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY5Feb))));
                    mar = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY5Mar))));
                    apr = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY5Apr))));
                    may = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY5May))));
                    jun = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY5Jun))));
                    jul = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY5Jul))));
                    aug = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY5Aug))));
                    sep = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY5Sep))));
                    oct = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY5Oct))));
                    nov = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY5Nov))));
                    dec = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY5Dec))));
                }
            }else if ((yearLaunch.equals("1")&& yearStart.equals("-5"))||(yearLaunch.equals("2")&& yearStart.equals("-4"))||(yearLaunch.equals("3")&& yearStart.equals("-3"))||(yearLaunch.equals("4")&& yearStart.equals("-2"))||(yearLaunch.equals("5")&& yearStart.equals("-1"))||(yearLaunch.equals("6")&& (yearStart.equals("Year 1")||yearStart.equals("Tahun 1")||yearStart.equals("Année 1")))||(yearLaunch.equals("7")&& (yearStart.equals("Year 2")||yearStart.equals("Tahun 2")||yearStart.equals("Année 2")))){

                setText(jlb, p45);
                setText(fblb, p45);
                setText(mrlb, p78+", "+p36);
                setText(ablb, p30+", "+p68);
                setText(mylb, p26+", "+p47+", "+p5+", "+p40);
                setText(jnlb, p45);
                setText(jllb, p45);
                setText(aglb, p78+", "+p36);
                setText(splb, p26+", "+p21+", "+p41);
                setText(oclb, p25+", "+p47+", "+p41);
                setText(nvlb, p25);
                setText(dclb, p26);
                setText(plt, plot);

                if (labor == "labor"){
                    jan = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY6Jan)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY6Jan))));
                    feb = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY6Feb)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY6Feb))));
                    mar = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY6Mar)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY6Mar))));
                    apr = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY6Apr)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY6Apr))));
                    may = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY6May)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY6May))));
                    jun = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY6Jun)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY6Jun))));
                    jul = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY6Jul)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY6Jul))));
                    aug = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY6Aug)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY6Aug))));
                    sep = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY6Sep)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY6Sep))));
                    oct = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY6Oct)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY6Oct))));
                    nov = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY6Nov)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY6Nov))));
                    dec = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY6Dec)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY6Dec))));
                }else if(labor =="season") {
                    jan = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY6Jan)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY6Jan))));
                    feb = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY6Feb))));
                    mar = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY6Mar))));
                    apr = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY6Apr))));
                    may = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY6May))));
                    jun = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY6Jun))));
                    jul = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY6Jul))));
                    aug = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY6Aug))));
                    sep = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY6Sep)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY6Sep))));
                    oct = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY6Oct)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY6Oct))));
                    nov = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY6Nov)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY6Nov))));
                    dec = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY6Dec)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY6Dec))));
                }else{
                    jan = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY6Jan))));
                    feb = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY6Feb))));
                    mar = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY6Mar))));
                    apr = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY6Apr))));
                    may = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY6May))));
                    jun = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY6Jun))));
                    jul = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY6Jul))));
                    aug = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY6Aug))));
                    sep = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY6Sep))));
                    oct = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY6Oct))));
                    nov = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY6Nov))));
                    dec = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY6Dec))));
                }

            }else{

                setText(jlb, p45);
                setText(fblb, p45);
                setText(mrlb, p78+", "+p36);
                setText(ablb, p30+", "+p68);
                setText(mylb, p26+", "+p47+", "+p5+", "+p40);
                setText(jnlb, p45);
                setText(jllb, p45);
                setText(aglb, p78+", "+p36);
                setText(splb, p26+", "+p21+", "+p41);
                setText(oclb, p25+", "+p47+", "+p41);
                setText(nvlb, p25);
                setText(dclb, p26);
                setText(plt, plot);

                if (labor == "labor"){
                    jan = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY7Jan)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY7Jan))));
                    feb = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY7Feb)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY7Feb))));
                    mar = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY7Mar)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY7Mar))));
                    apr = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY7Apr)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY7Apr))));
                    may = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY7May)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY7May))));
                    jun = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY7Jun)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY7Jun))));
                    jul = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY7Jul)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY7Jul))));
                    aug = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY7Aug)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY7Aug))));
                    sep = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY7Sep)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY7Sep))));
                    oct = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY7Oct)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY7Oct))));
                    nov = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY7Nov)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY7Nov))));
                    dec = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY7Dec)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY7Dec))));
                }else if(labor =="season") {
                    jan = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY7Jan)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY7Jan))));
                    feb = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY7Feb))));
                    mar = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY7Mar))));
                    apr = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY7Apr))));
                    may = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY7May))));
                    jun = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY7Jun))));
                    jul = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY7Jul))));
                    aug = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY7Aug))));
                    sep = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY7Sep)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY7Sep))));
                    oct = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY7Oct)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY7Oct))));
                    nov = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY7Nov)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY7Nov))));
                    dec = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY7Dec)))+(area * (getResources().getInteger(R.integer.thinningLaborCostY7Dec))));
                }else{
                    jan = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY7Jan))));
                    feb = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY7Feb))));
                    mar = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY7Mar))));
                    apr = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY7Apr))));
                    may = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY7May))));
                    jun = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY7Jun))));
                    jul = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY7Jul))));
                    aug = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY7Aug))));
                    sep = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY7Sep))));
                    oct = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY7Oct))));
                    nov = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY7Nov))));
                    dec = (int) ((area * (getResources().getInteger(R.integer.thinningInputsY7Dec))));
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

    public void calc3(String plot, final String relat, final String labor, final Double area, String yearStart, String yearLaunch){
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
        setText(plt, plot);

        if (launchYear < startYear){
            setText(jlb, p45);
            setText(fblb, p45);
            setText(mrlb, p78+", "+p36);
            setText(ablb, p43+", "+p35+", "+p44);
            setText(mylb, p43+", "+p23+", "+p44);
            setText(jnlb, p45);
            setText(jllb, p45);
            setText(aglb, p78+", "+p36);
            setText(splb, p43+", "+p35+", "+p44);
            setText(oclb, p42+", "+p23+", "+p44);
            setText(nvlb, p45);
            setText(dclb, p48);
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
                jan = (int) (area * (getResources().getInteger(R.integer.MGAPJan)+ getResources().getInteger(R.integer.MGAPSLaborJan)));
                feb = (int) (area * getResources().getInteger(R.integer.MGAPFeb));
                mar = (int) (area * getResources().getInteger(R.integer.MGAPMar));
                apr = (int) (area * getResources().getInteger(R.integer.MGAPApr));
                may = (int) (area * getResources().getInteger(R.integer.MGAPMay));
                jun = (int) (area * getResources().getInteger(R.integer.MGAPJun));
                jul = (int) (area * getResources().getInteger(R.integer.MGAPJul));
                aug = (int) (area * getResources().getInteger(R.integer.MGAPAug));
                sep = (int) (area * (getResources().getInteger(R.integer.MGAPSep)+ getResources().getInteger(R.integer.MGAPSLaborSep)));
                oct = (int) (area * (getResources().getInteger(R.integer.MGAPOct)+ getResources().getInteger(R.integer.MGAPSLaborOct)));
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
                    setText(jlb, p45);
                    setText(fblb, p45);
                    setText(mrlb, p78+", "+p36);
                    setText(ablb, p30+", "+p41);
                    setText(mylb, p25+", "+p2+", "+p4+", "+p41);
                    setText(jnlb, p45);
                    setText(jllb, p12+", "+p78+", "+p36);
                    setText(aglb, p12);
                    setText(splb, p26+", "+p12+", "+p2+", "+p41);
                    setText(oclb, p25+", "+p20+", "+p4+", "+p19+", "+p41);
                    setText(nvlb, p25+", "+p20+", "+p19+", "+p52);
                    setText(dclb, p25+", "+p48+", "+p20+", "+p17+", "+p64);
                    setText(plt, plot);

                    if (labor == "labor"){
                        jan = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1Jan)+getResources().getInteger(R.integer.fillingLaborCostY1Jan)+getResources().getInteger(R.integer.difInputY1Jan))+getResources().getInteger(R.integer.difLaborY1Jan));
                        feb = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1Feb)+getResources().getInteger(R.integer.fillingLaborCostY1Feb)+getResources().getInteger(R.integer.difInputY1Feb))+getResources().getInteger(R.integer.difLaborY1Feb));
                        mar = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1Mar)+getResources().getInteger(R.integer.fillingLaborCostY1Mar)+getResources().getInteger(R.integer.difInputY1Mar))+getResources().getInteger(R.integer.difLaborY1Mar));
                        apr = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1Apr)+getResources().getInteger(R.integer.fillingLaborCostY1Apr)+getResources().getInteger(R.integer.difInputY1Apr))+getResources().getInteger(R.integer.difLaborY1Apr));
                        may = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1May)+getResources().getInteger(R.integer.fillingLaborCostY1May)+getResources().getInteger(R.integer.difInputY1May))+getResources().getInteger(R.integer.difLaborY1May));
                        jun = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1Jun)+getResources().getInteger(R.integer.fillingLaborCostY1Jun)+getResources().getInteger(R.integer.difInputY1Jun))+getResources().getInteger(R.integer.difLaborY1Jun));
                        jul = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1Jul)+getResources().getInteger(R.integer.fillingLaborCostY1Jul)+getResources().getInteger(R.integer.difInputY1Jul))+getResources().getInteger(R.integer.difLaborY1Jul));
                        aug = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1Aug)+getResources().getInteger(R.integer.fillingLaborCostY1Aug)+getResources().getInteger(R.integer.difInputY1Aug))+getResources().getInteger(R.integer.difLaborY1Aug));
                        sep = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1Sep)+getResources().getInteger(R.integer.fillingLaborCostY1Sep)+getResources().getInteger(R.integer.difInputY1Sep))+getResources().getInteger(R.integer.difLaborY1Sep));
                        oct = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1Oct)+getResources().getInteger(R.integer.fillingLaborCostY1Oct)+getResources().getInteger(R.integer.difInputY1Oct))+getResources().getInteger(R.integer.difLaborY1Oct));
                        nov = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1Nov)+getResources().getInteger(R.integer.fillingLaborCostY1Nov)+getResources().getInteger(R.integer.difInputY1Nov))+getResources().getInteger(R.integer.difLaborY1Nov));
                        dec = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1Dec)+getResources().getInteger(R.integer.fillingLaborCostY1Dec)+getResources().getInteger(R.integer.difInputY1Dec))+getResources().getInteger(R.integer.difLaborY1Dec));
                    }else if(labor =="season") {
                        jan = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1Jan)+getResources().getInteger(R.integer.fillingLaborCostY1Jan)+getResources().getInteger(R.integer.difInputY1Jan))+getResources().getInteger(R.integer.difLaborY1Jan));
                        feb = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1Feb)+getResources().getInteger(R.integer.difInputY1Feb)));
                        mar = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1Mar)+getResources().getInteger(R.integer.difInputY1Mar)));
                        apr = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1Apr)+getResources().getInteger(R.integer.difInputY1Apr)));
                        may = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1May)+getResources().getInteger(R.integer.difInputY1May)));
                        jun = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1Jun)+getResources().getInteger(R.integer.difInputY1Jun)));
                        jul = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1Jul)+getResources().getInteger(R.integer.difInputY1Jul)));
                        aug = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1Aug)+getResources().getInteger(R.integer.difInputY1Aug)));
                        sep = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1Sep)+getResources().getInteger(R.integer.fillingLaborCostY1Sep)+getResources().getInteger(R.integer.difInputY1Sep))+getResources().getInteger(R.integer.difLaborY1Sep));
                        oct = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1Oct)+getResources().getInteger(R.integer.fillingLaborCostY1Oct)+getResources().getInteger(R.integer.difInputY1Oct))+getResources().getInteger(R.integer.difLaborY1Oct));
                        nov = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1Nov)+getResources().getInteger(R.integer.fillingLaborCostY1Nov)+getResources().getInteger(R.integer.difInputY1Nov))+getResources().getInteger(R.integer.difLaborY1Nov));
                        dec = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1Dec)+getResources().getInteger(R.integer.fillingLaborCostY1Dec)+getResources().getInteger(R.integer.difInputY1Dec))+getResources().getInteger(R.integer.difLaborY1Dec));
                    }else{
                        jan = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1Jan)+getResources().getInteger(R.integer.difInputY1Jan)));
                        feb = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1Feb)+getResources().getInteger(R.integer.difInputY1Feb)));
                        mar = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1Mar)+getResources().getInteger(R.integer.difInputY1Mar)));
                        apr = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1Apr)+getResources().getInteger(R.integer.difInputY1Apr)));
                        may = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1May)+getResources().getInteger(R.integer.difInputY1May)));
                        jun = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1Jun)+getResources().getInteger(R.integer.difInputY1Jun)));
                        jul = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1Jul)+getResources().getInteger(R.integer.difInputY1Jul)));
                        aug = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1Aug)+getResources().getInteger(R.integer.difInputY1Aug)));
                        sep = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1Sep)+getResources().getInteger(R.integer.difInputY1Sep)));
                        oct = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1Oct)+getResources().getInteger(R.integer.difInputY1Oct)));
                        nov = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1Nov)+getResources().getInteger(R.integer.difInputY1Nov)));
                        dec = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1Dec)+getResources().getInteger(R.integer.difInputY1Dec)));
                    }

                }else{
                    setText(jlb, p45);
                    setText(fblb, p45);
                    setText(mrlb, p78+", "+p36);
                    setText(ablb, p30+", "+p41);
                    setText(mylb, p25+", "+p21+", "+p47+", "+p41);
                    setText(jnlb, p45);
                    setText(jllb, p12+", "+p78+", "+p36);
                    setText(aglb, p12);
                    setText(splb, p26+", "+p12+", "+p21+", "+p41);
                    setText(oclb, p25+", "+p20+", "+p47+", "+p19+", "+p41);
                    setText(nvlb, p25+", "+p20+", "+p19+", "+p52);
                    setText(dclb, p25+", "+p48+", "+p20+", "+p17+", "+p64);
                    setText(plt, plot);
                    if (labor == "labor"){
                        jan = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1Jan)+getResources().getInteger(R.integer.fillingLaborCostY1Jan)));
                        feb = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1Feb)+getResources().getInteger(R.integer.fillingLaborCostY1Feb)));
                        mar = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1Mar)+getResources().getInteger(R.integer.fillingLaborCostY1Mar)));
                        apr = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1Apr)+getResources().getInteger(R.integer.fillingLaborCostY1Apr)));
                        may = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1May)+getResources().getInteger(R.integer.fillingLaborCostY1May)));
                        jun = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1Jun)+getResources().getInteger(R.integer.fillingLaborCostY1Jun)));
                        jul = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1Jul)+getResources().getInteger(R.integer.fillingLaborCostY1Jul)));
                        aug = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1Aug)+getResources().getInteger(R.integer.fillingLaborCostY1Aug)));
                        sep = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1Sep)+getResources().getInteger(R.integer.fillingLaborCostY1Sep)));
                        oct = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1Oct)+getResources().getInteger(R.integer.fillingLaborCostY1Oct)));
                        nov = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1Nov)+getResources().getInteger(R.integer.fillingLaborCostY1Nov)));
                        dec = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1Dec)+getResources().getInteger(R.integer.fillingLaborCostY1Dec)));
                    }else if(labor =="season") {
                        jan = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1Jan)+getResources().getInteger(R.integer.fillingLaborCostY1Jan)));
                        feb = (int) (area * getResources().getInteger(R.integer.fillingInputsY1Feb));
                        mar = (int) (area * getResources().getInteger(R.integer.fillingInputsY1Mar));
                        apr = (int) (area * getResources().getInteger(R.integer.fillingInputsY1Apr));
                        may = (int) (area * getResources().getInteger(R.integer.fillingInputsY1May));
                        jun = (int) (area * getResources().getInteger(R.integer.fillingInputsY1Jun));
                        jul = (int) (area * getResources().getInteger(R.integer.fillingInputsY1Jul));
                        aug = (int) (area * getResources().getInteger(R.integer.fillingInputsY1Aug));
                        sep = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1Sep)+getResources().getInteger(R.integer.fillingLaborCostY1Sep)));
                        oct = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1Oct)+getResources().getInteger(R.integer.fillingLaborCostY1Oct)));
                        nov = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1Nov)+getResources().getInteger(R.integer.fillingLaborCostY1Nov)));
                        dec = (int) (area * (getResources().getInteger(R.integer.fillingInputsY1Dec)+getResources().getInteger(R.integer.fillingLaborCostY1Dec)));
                    }else{
                        jan = (int) (area * getResources().getInteger(R.integer.fillingInputsY1Jan));
                        feb = (int) (area * getResources().getInteger(R.integer.fillingInputsY1Feb));
                        mar = (int) (area * getResources().getInteger(R.integer.fillingInputsY1Mar));
                        apr = (int) (area * getResources().getInteger(R.integer.fillingInputsY1Apr));
                        may = (int) (area * getResources().getInteger(R.integer.fillingInputsY1May));
                        jun = (int) (area * getResources().getInteger(R.integer.fillingInputsY1Jun));
                        jul = (int) (area * getResources().getInteger(R.integer.fillingInputsY1Jul));
                        aug = (int) (area * getResources().getInteger(R.integer.fillingInputsY1Aug));
                        sep = (int) (area * getResources().getInteger(R.integer.fillingInputsY1Sep));
                        oct = (int) (area * getResources().getInteger(R.integer.fillingInputsY1Oct));
                        nov = (int) (area * getResources().getInteger(R.integer.fillingInputsY1Nov));
                        dec = (int) (area * getResources().getInteger(R.integer.fillingInputsY1Dec));
                    }
                }

            }else if ((yearLaunch.equals("1")&& yearStart.equals("-1"))||(yearLaunch.equals("2")&& (yearStart.equals("Year 1")||yearStart.equals("Tahun 1")||yearStart.equals("Année 1")))||(yearLaunch.equals("3")&& (yearStart.equals("Year 2")||yearStart.equals("Tahun 2")||yearStart.equals("Année 2")))||(yearLaunch.equals("4")&& (yearStart.equals("Year 3")||yearStart.equals("Tahun 3")||yearStart.equals("Année 3")))||(yearLaunch.equals("5")&& (yearStart.equals("Year 4")||yearStart.equals("Tahun 4")||yearStart.equals("Année 4")))||(yearLaunch.equals("6")&& (yearStart.equals("Year 5")||yearStart.equals("Tahun 5")||yearStart.equals("Année 5")))||(yearLaunch.equals("7")&& (yearStart.equals("Year 6")||yearStart.equals("Tahun 6")||yearStart.equals("Année 6")))){

                if (relat == "extra"){
                    setText(jlb, p20);
                    setText(fblb, p20);
                    setText(mrlb, p11+", "+p78+", "+p36+", "+p18);
                    setText(ablb, p26+", "+p11+", "+p18+", "+p51+", "+p67);
                    setText(mylb, p26+", "+p18+", "+p51+", "+p2+", "+p3+", "+p41);
                    setText(jnlb, p45);
                    setText(jllb, p49+", "+p78+", "+p36);
                    setText(aglb, p78+", "+p36);
                    setText(splb, p26+", "+p14+", "+p2+", "+p67);
                    setText(oclb, p26+", "+p78+", "+p36+", "+p3+", "+p41);
                    setText(nvlb, p26+", "+p71);
                    setText(dclb, p26+", "+p66+", "+p68);
                    setText(plt, plot);

                    if (labor == "labor"){
                        jan = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2Jan)+getResources().getInteger(R.integer.fillingLaborCostY2Jan)+getResources().getInteger(R.integer.difInputY2Jan))+getResources().getInteger(R.integer.difLaborY2Jan));
                        feb = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2Feb)+getResources().getInteger(R.integer.fillingLaborCostY2Feb)+getResources().getInteger(R.integer.difInputY2Feb))+getResources().getInteger(R.integer.difLaborY2Feb));
                        mar = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2Mar)+getResources().getInteger(R.integer.fillingLaborCostY2Mar)+getResources().getInteger(R.integer.difInputY2Mar))+getResources().getInteger(R.integer.difLaborY2Mar));
                        apr = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2Apr)+getResources().getInteger(R.integer.fillingLaborCostY2Apr)+getResources().getInteger(R.integer.difInputY2Apr))+getResources().getInteger(R.integer.difLaborY2Apr));
                        may = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2May)+getResources().getInteger(R.integer.fillingLaborCostY2May)+getResources().getInteger(R.integer.difInputY2May))+getResources().getInteger(R.integer.difLaborY2May));
                        jun = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2Jun)+getResources().getInteger(R.integer.fillingLaborCostY2Jun)+getResources().getInteger(R.integer.difInputY2Jun))+getResources().getInteger(R.integer.difLaborY2Jun));
                        jul = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2Jul)+getResources().getInteger(R.integer.fillingLaborCostY2Jul)+getResources().getInteger(R.integer.difInputY2Jul))+getResources().getInteger(R.integer.difLaborY2Jul));
                        aug = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2Aug)+getResources().getInteger(R.integer.fillingLaborCostY2Aug)+getResources().getInteger(R.integer.difInputY2Aug))+getResources().getInteger(R.integer.difLaborY2Aug));
                        sep = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2Sep)+getResources().getInteger(R.integer.fillingLaborCostY2Sep)+getResources().getInteger(R.integer.difInputY2Sep))+getResources().getInteger(R.integer.difLaborY2Sep));
                        oct = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2Oct)+getResources().getInteger(R.integer.fillingLaborCostY2Oct)+getResources().getInteger(R.integer.difInputY2Oct))+getResources().getInteger(R.integer.difLaborY2Oct));
                        nov = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2Nov)+getResources().getInteger(R.integer.fillingLaborCostY2Nov)+getResources().getInteger(R.integer.difInputY2Nov))+getResources().getInteger(R.integer.difLaborY2Nov));
                        dec = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2Dec)+getResources().getInteger(R.integer.fillingLaborCostY2Dec)+getResources().getInteger(R.integer.difInputY2Dec))+getResources().getInteger(R.integer.difLaborY2Dec));
                    }else if(labor =="season") {
                        jan = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2Jan)+getResources().getInteger(R.integer.fillingLaborCostY2Jan)+getResources().getInteger(R.integer.difInputY2Jan))+getResources().getInteger(R.integer.difLaborY2Jan));
                        feb = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2Feb)+getResources().getInteger(R.integer.difInputY2Feb)));
                        mar = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2Mar)+getResources().getInteger(R.integer.difInputY2Mar)));
                        apr = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2Apr)+getResources().getInteger(R.integer.difInputY2Apr)));
                        may = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2May)+getResources().getInteger(R.integer.difInputY2May)));
                        jun = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2Jun)+getResources().getInteger(R.integer.difInputY2Jun)));
                        jul = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2Jul)+getResources().getInteger(R.integer.difInputY2Jul)));
                        aug = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2Aug)+getResources().getInteger(R.integer.difInputY2Aug)));
                        sep = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2Sep)+getResources().getInteger(R.integer.fillingLaborCostY2Sep)+getResources().getInteger(R.integer.difInputY2Sep))+getResources().getInteger(R.integer.difLaborY2Sep));
                        oct = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2Oct)+getResources().getInteger(R.integer.fillingLaborCostY2Oct)+getResources().getInteger(R.integer.difInputY2Oct))+getResources().getInteger(R.integer.difLaborY2Oct));
                        nov = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2Nov)+getResources().getInteger(R.integer.fillingLaborCostY2Nov)+getResources().getInteger(R.integer.difInputY2Nov))+getResources().getInteger(R.integer.difLaborY2Nov));
                        dec = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2Dec)+getResources().getInteger(R.integer.fillingLaborCostY2Dec)+getResources().getInteger(R.integer.difInputY2Dec))+getResources().getInteger(R.integer.difLaborY2Dec));
                    }else{
                        jan = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2Jan)+getResources().getInteger(R.integer.difInputY2Jan)));
                        feb = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2Feb)+getResources().getInteger(R.integer.difInputY2Feb)));
                        mar = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2Mar)+getResources().getInteger(R.integer.difInputY2Mar)));
                        apr = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2Apr)+getResources().getInteger(R.integer.difInputY2Apr)));
                        may = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2May)+getResources().getInteger(R.integer.difInputY2May)));
                        jun = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2Jun)+getResources().getInteger(R.integer.difInputY2Jun)));
                        jul = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2Jul)+getResources().getInteger(R.integer.difInputY2Jul)));
                        aug = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2Aug)+getResources().getInteger(R.integer.difInputY2Aug)));
                        sep = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2Sep)+getResources().getInteger(R.integer.difInputY2Sep)));
                        oct = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2Oct)+getResources().getInteger(R.integer.difInputY2Oct)));
                        nov = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2Nov)+getResources().getInteger(R.integer.difInputY2Nov)));
                        dec = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2Dec)+getResources().getInteger(R.integer.difInputY2Dec)));
                    }

                }else{
                    setText(jlb, p20);
                    setText(fblb, p20);
                    setText(mrlb, p11+", "+p78+", "+p36+", "+p18);
                    setText(ablb, p26+", "+p11+", "+p18+", "+p51+", "+p67);
                    setText(mylb, p26+", "+p18+", "+p51+", "+p21+", "+p47+", "+p41);
                    setText(jnlb, p45);
                    setText(jllb, p49+", "+p78+", "+p36);
                    setText(aglb, p78+", "+p36);
                    setText(splb, p26+", "+p14+", "+p21+", "+p67);
                    setText(oclb, p26+", "+p78+", "+p36+", "+p47+", "+p41);
                    setText(nvlb, p26+", "+p71);
                    setText(dclb, p26+", "+p66+", "+p68);
                    setText(plt, plot);
                    if (labor == "labor"){
                        jan = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2Jan)+getResources().getInteger(R.integer.fillingLaborCostY2Jan)));
                        feb = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2Feb)+getResources().getInteger(R.integer.fillingLaborCostY2Feb)));
                        mar = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2Mar)+getResources().getInteger(R.integer.fillingLaborCostY2Mar)));
                        apr = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2Apr)+getResources().getInteger(R.integer.fillingLaborCostY2Apr)));
                        may = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2May)+getResources().getInteger(R.integer.fillingLaborCostY2May)));
                        jun = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2Jun)+getResources().getInteger(R.integer.fillingLaborCostY2Jun)));
                        jul = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2Jul)+getResources().getInteger(R.integer.fillingLaborCostY2Jul)));
                        aug = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2Aug)+getResources().getInteger(R.integer.fillingLaborCostY2Aug)));
                        sep = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2Sep)+getResources().getInteger(R.integer.fillingLaborCostY2Sep)));
                        oct = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2Oct)+getResources().getInteger(R.integer.fillingLaborCostY2Oct)));
                        nov = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2Nov)+getResources().getInteger(R.integer.fillingLaborCostY2Nov)));
                        dec = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2Dec)+getResources().getInteger(R.integer.fillingLaborCostY2Dec)));
                    }else if(labor =="season") {
                        jan = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2Jan)+getResources().getInteger(R.integer.fillingLaborCostY2Jan)));
                        feb = (int) (area * getResources().getInteger(R.integer.fillingInputsY2Feb));
                        mar = (int) (area * getResources().getInteger(R.integer.fillingInputsY2Mar));
                        apr = (int) (area * getResources().getInteger(R.integer.fillingInputsY2Apr));
                        may = (int) (area * getResources().getInteger(R.integer.fillingInputsY2May));
                        jun = (int) (area * getResources().getInteger(R.integer.fillingInputsY2Jun));
                        jul = (int) (area * getResources().getInteger(R.integer.fillingInputsY2Jul));
                        aug = (int) (area * getResources().getInteger(R.integer.fillingInputsY2Aug));
                        sep = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2Sep)+getResources().getInteger(R.integer.fillingLaborCostY2Sep)));
                        oct = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2Oct)+getResources().getInteger(R.integer.fillingLaborCostY2Oct)));
                        nov = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2Nov)+getResources().getInteger(R.integer.fillingLaborCostY2Nov)));
                        dec = (int) (area * (getResources().getInteger(R.integer.fillingInputsY2Dec)+getResources().getInteger(R.integer.fillingLaborCostY2Dec)));
                    }else{
                        jan = (int) (area * getResources().getInteger(R.integer.fillingInputsY2Jan));
                        feb = (int) (area * getResources().getInteger(R.integer.fillingInputsY2Feb));
                        mar = (int) (area * getResources().getInteger(R.integer.fillingInputsY2Mar));
                        apr = (int) (area * getResources().getInteger(R.integer.fillingInputsY2Apr));
                        may = (int) (area * getResources().getInteger(R.integer.fillingInputsY2May));
                        jun = (int) (area * getResources().getInteger(R.integer.fillingInputsY2Jun));
                        jul = (int) (area * getResources().getInteger(R.integer.fillingInputsY2Jul));
                        aug = (int) (area * getResources().getInteger(R.integer.fillingInputsY2Aug));
                        sep = (int) (area * getResources().getInteger(R.integer.fillingInputsY2Sep));
                        oct = (int) (area * getResources().getInteger(R.integer.fillingInputsY2Oct));
                        nov = (int) (area * getResources().getInteger(R.integer.fillingInputsY2Nov));
                        dec = (int) (area * getResources().getInteger(R.integer.fillingInputsY2Dec));
                    }
                }

            }else if ((yearLaunch.equals("1")||yearStart.equals("-2"))||(yearLaunch.equals("2")&& yearStart.equals("-1"))||(yearLaunch.equals("3")&& (yearStart.equals("Year 1")||yearStart.equals("Tahun 1")||yearStart.equals("Année 1")))||(yearLaunch.equals("4")&& (yearStart.equals("Year 2")||yearStart.equals("Tahun 2")||yearStart.equals("Année 2")))||(yearLaunch.equals("5")&& (yearStart.equals("Year 3")||yearStart.equals("Tahun 3")||yearStart.equals("Année 3")))||(yearLaunch.equals("6")&& (yearStart.equals("Year 4")||yearStart.equals("Tahun 4")||yearStart.equals("Année 4")))||(yearLaunch.equals("7")&& (yearStart.equals("Year 5")||yearStart.equals("Tahun 5")||yearStart.equals("Année 5")))){
                setText(jlb, p45);
                setText(fblb, p45);
                setText(mrlb, p78+", "+p36+", "+p9);
                setText(ablb, p26+", "+p41);
                setText(mylb, p26+", "+p21+", "+p47+", "+p67);
                setText(jnlb, p45);
                setText(jllb, p45);
                setText(aglb, p78+", "+p36+", "+p9);
                setText(splb, p26+", "+p21+", "+p67);
                setText(oclb, p25+", "+p47+", "+p41);
                setText(nvlb, p25+", "+p41);
                setText(dclb, p26+", "+p68);
                setText(plt, plot);
                if (relat == "extra"){


                    if (labor == "labor"){
                        jan = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Jan)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY3Jan)))+(area * (getResources().getInteger(R.integer.difInputY3Jan)))+getResources().getInteger(R.integer.difLaborY3Jan));
                        feb = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Feb)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY3Feb)))+(area * (getResources().getInteger(R.integer.difInputY3Feb)))+getResources().getInteger(R.integer.difLaborY3Feb));
                        mar = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Mar)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY3Mar)))+(area * (getResources().getInteger(R.integer.difInputY3Mar)))+getResources().getInteger(R.integer.difLaborY3Mar));
                        apr = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Apr)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY3Apr)))+(area * (getResources().getInteger(R.integer.difInputY3Apr)))+getResources().getInteger(R.integer.difLaborY3Apr));
                        may = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3May)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY3May)))+(area * (getResources().getInteger(R.integer.difInputY3May)))+getResources().getInteger(R.integer.difLaborY3May));
                        jun = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Jun)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY3Jun)))+(area * (getResources().getInteger(R.integer.difInputY3Jun)))+getResources().getInteger(R.integer.difLaborY3Jun));
                        jul = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Jul)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY3Jul)))+(area * (getResources().getInteger(R.integer.difInputY3Jul)))+getResources().getInteger(R.integer.difLaborY3Jul));
                        aug = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Aug)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY3Aug)))+(area * (getResources().getInteger(R.integer.difInputY3Aug)))+getResources().getInteger(R.integer.difLaborY3Aug));
                        sep = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Sep)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY3Sep)))+(area * (getResources().getInteger(R.integer.difInputY3Sep)))+getResources().getInteger(R.integer.difLaborY3Sep));
                        oct = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Oct)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY3Oct)))+(area * (getResources().getInteger(R.integer.difInputY3Oct)))+getResources().getInteger(R.integer.difLaborY3Oct));
                        nov = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Nov)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY3Nov)))+(area * (getResources().getInteger(R.integer.difInputY3Nov)))+getResources().getInteger(R.integer.difLaborY3Nov));
                        dec = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Dec)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY3Dec)))+(area * (getResources().getInteger(R.integer.difInputY3Dec)))+getResources().getInteger(R.integer.difLaborY3Dec));
                    }else if(labor =="season") {
                        jan = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Jan)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY3Jan)))+(area * (getResources().getInteger(R.integer.difInputY3Jan)))+getResources().getInteger(R.integer.difLaborY3Jan));
                        feb = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Feb)))+(area * (getResources().getInteger(R.integer.difInputY3Feb))));
                        mar = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Mar)))+(area * (getResources().getInteger(R.integer.difInputY3Mar))));
                        apr = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Apr)))+(area * (getResources().getInteger(R.integer.difInputY3Apr))));
                        may = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3May)))+(area * (getResources().getInteger(R.integer.difInputY3May))));
                        jun = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Jun)))+(area * (getResources().getInteger(R.integer.difInputY3Jun))));
                        jul = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Jul)))+(area * (getResources().getInteger(R.integer.difInputY3Jul))));
                        aug = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Aug)))+(area * (getResources().getInteger(R.integer.difInputY3Aug))));
                        sep = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Sep)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY3Sep)))+(area * (getResources().getInteger(R.integer.difInputY3Sep)))+getResources().getInteger(R.integer.difLaborY3Sep));
                        oct = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Oct)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY3Oct)))+(area * (getResources().getInteger(R.integer.difInputY3Oct)))+getResources().getInteger(R.integer.difLaborY3Oct));
                        nov = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Nov)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY3Nov)))+(area * (getResources().getInteger(R.integer.difInputY3Nov)))+getResources().getInteger(R.integer.difLaborY3Nov));
                        dec = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Dec)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY3Dec)))+(area * (getResources().getInteger(R.integer.difInputY3Dec)))+getResources().getInteger(R.integer.difLaborY3Dec));
                    }else{
                        jan = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Jan)))+(area * (getResources().getInteger(R.integer.difInputY3Jan))));
                        feb = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Feb)))+(area * (getResources().getInteger(R.integer.difInputY3Feb))));
                        mar = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Mar)))+(area * (getResources().getInteger(R.integer.difInputY3Mar))));
                        apr = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Apr)))+(area * (getResources().getInteger(R.integer.difInputY3Apr))));
                        may = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3May)))+(area * (getResources().getInteger(R.integer.difInputY3May))));
                        jun = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Jun)))+(area * (getResources().getInteger(R.integer.difInputY3Jun))));
                        jul = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Jul)))+(area * (getResources().getInteger(R.integer.difInputY3Jul))));
                        aug = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Aug)))+(area * (getResources().getInteger(R.integer.difInputY3Aug))));
                        sep = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Sep)))+(area * (getResources().getInteger(R.integer.difInputY3Sep))));
                        oct = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Oct)))+(area * (getResources().getInteger(R.integer.difInputY3Oct))));
                        nov = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Nov)))+(area * (getResources().getInteger(R.integer.difInputY3Nov))));
                        dec = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Dec)))+(area * (getResources().getInteger(R.integer.difInputY3Dec))));
                    }

                }else{
                    if (labor == "labor"){
                        jan = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Jan)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY3Jan))));
                        feb = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Feb)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY3Feb))));
                        mar = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Mar)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY3Mar))));
                        apr = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Apr)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY3Apr))));
                        may = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3May)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY3May))));
                        jun = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Jun)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY3Jun))));
                        jul = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Jul)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY3Jul))));
                        aug = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Aug)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY3Aug))));
                        sep = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Sep)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY3Sep))));
                        oct = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Oct)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY3Oct))));
                        nov = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Nov)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY3Nov))));
                        dec = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Dec)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY3Dec))));
                    }else if(labor =="season") {
                        jan = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Jan)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY3Jan))));
                        feb = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Feb))));
                        mar = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Mar))));
                        apr = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Apr))));
                        may = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3May))));
                        jun = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Jun))));
                        jul = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Jul))));
                        aug = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Aug))));
                        sep = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Sep)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY3Sep))));
                        oct = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Oct)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY3Oct))));
                        nov = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Nov)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY3Nov))));
                        dec = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Dec)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY3Dec))));
                    }else{
                        jan = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Jan))));
                        feb = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Feb))));
                        mar = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Mar))));
                        apr = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Apr))));
                        may = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3May))));
                        jun = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Jun))));
                        jul = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Jul))));
                        aug = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Aug))));
                        sep = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Sep))));
                        oct = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Oct))));
                        nov = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Nov))));
                        dec = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY3Dec))));
                    }
                }

            }else if ((yearLaunch.equals("1")&& yearStart.equals("-3"))||(yearLaunch.equals("2")&&yearStart.equals("-2"))||(yearLaunch.equals("3")&& yearStart.equals("-1"))||(yearLaunch.equals("4")&& (yearStart.equals("Year 1")||yearStart.equals("Tahun 1")||yearStart.equals("Année 1")))||(yearLaunch.equals("5")&& (yearStart.equals("Year 2")||yearStart.equals("Tahun 2")||yearStart.equals("Année 2")))||(yearLaunch.equals("6")&& (yearStart.equals("Year 3")||yearStart.equals("Tahun 3")||yearStart.equals("Année 3")))||(yearLaunch.equals("7")&& (yearStart.equals("Year 4")||yearStart.equals("Tahun 4")||yearStart.equals("Année 4")))){

                setText(jlb, p45);
                setText(fblb, p45);
                setText(mrlb, p78+", "+p36);
                setText(ablb, p26+", "+p41);
                setText(mylb, p26+", "+p21+", "+p47+", "+p41);
                setText(jnlb, p45);
                setText(jllb, p45);
                setText(aglb, p78+", "+p36);
                setText(splb, p26+", "+p21+", "+p41);
                setText(oclb, p25+", "+p47+", "+p41);
                setText(nvlb, p25+", "+p41);
                setText(dclb, p26);
                setText(plt, plot);
                if (relat == "extra"){
                    if (labor == "labor"){
                        jan = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Jan)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY4Jan)))+(area * (getResources().getInteger(R.integer.difInputY4Jan))));
                        feb = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Feb)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY4Feb)))+(area * (getResources().getInteger(R.integer.difInputY4Feb))));
                        mar = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Mar)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY4Mar)))+(area * (getResources().getInteger(R.integer.difInputY4Mar))));
                        apr = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Apr)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY4Apr)))+(area * (getResources().getInteger(R.integer.difInputY4Apr))));
                        may = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4May)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY4May)))+(area * (getResources().getInteger(R.integer.difInputY4May))));
                        jun = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Jun)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY4Jun)))+(area * (getResources().getInteger(R.integer.difInputY4Jun))));
                        jul = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Jul)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY4Jul)))+(area * (getResources().getInteger(R.integer.difInputY4Jul))));
                        aug = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Aug)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY4Aug)))+(area * (getResources().getInteger(R.integer.difInputY4Aug))));
                        sep = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Sep)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY4Sep)))+(area * (getResources().getInteger(R.integer.difInputY4Sep))));
                        oct = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Oct)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY4Oct)))+(area * (getResources().getInteger(R.integer.difInputY4Oct))));
                        nov = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Nov)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY4Nov)))+(area * (getResources().getInteger(R.integer.difInputY4Nov))));
                        dec = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Dec)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY4Dec)))+(area * (getResources().getInteger(R.integer.difInputY4Dec))));
                    }else if(labor =="season") {
                        jan = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Jan)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY4Jan)))+(area * (getResources().getInteger(R.integer.difInputY4Jan))));
                        feb = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Feb)))+(area * (getResources().getInteger(R.integer.difInputY4Feb))));
                        mar = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Mar)))+(area * (getResources().getInteger(R.integer.difInputY4Mar))));
                        apr = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Apr)))+(area * (getResources().getInteger(R.integer.difInputY4Apr))));
                        may = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4May)))+(area * (getResources().getInteger(R.integer.difInputY4May))));
                        jun = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Jun)))+(area * (getResources().getInteger(R.integer.difInputY4Jun))));
                        jul = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Jul)))+(area * (getResources().getInteger(R.integer.difInputY4Jul))));
                        aug = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Aug)))+(area * (getResources().getInteger(R.integer.difInputY4Aug))));
                        sep = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Sep)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY4Sep)))+(area * (getResources().getInteger(R.integer.difInputY4Sep))));
                        oct = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Oct)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY4Oct)))+(area * (getResources().getInteger(R.integer.difInputY4Oct))));
                        nov = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Nov)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY4Nov)))+(area * (getResources().getInteger(R.integer.difInputY4Nov))));
                        dec = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Dec)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY4Dec)))+(area * (getResources().getInteger(R.integer.difInputY4Dec))));
                    }else{
                        jan = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Jan)))+(area * (getResources().getInteger(R.integer.difInputY4Jan))));
                        feb = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Feb)))+(area * (getResources().getInteger(R.integer.difInputY4Feb))));
                        mar = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Mar)))+(area * (getResources().getInteger(R.integer.difInputY4Mar))));
                        apr = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Apr)))+(area * (getResources().getInteger(R.integer.difInputY4Apr))));
                        may = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4May)))+(area * (getResources().getInteger(R.integer.difInputY4May))));
                        jun = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Jun)))+(area * (getResources().getInteger(R.integer.difInputY4Jun))));
                        jul = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Jul)))+(area * (getResources().getInteger(R.integer.difInputY4Jul))));
                        aug = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Aug)))+(area * (getResources().getInteger(R.integer.difInputY4Aug))));
                        sep = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Sep)))+(area * (getResources().getInteger(R.integer.difInputY4Sep))));
                        oct = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Oct)))+(area * (getResources().getInteger(R.integer.difInputY4Oct))));
                        nov = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Nov)))+(area * (getResources().getInteger(R.integer.difInputY4Nov))));
                        dec = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Dec)))+(area * (getResources().getInteger(R.integer.difInputY4Dec))));
                    }

                }else{
                    if (labor == "labor"){
                        jan = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Jan)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY4Jan))));
                        feb = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Feb)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY4Feb))));
                        mar = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Mar)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY4Mar))));
                        apr = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Apr)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY4Apr))));
                        may = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4May)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY4May))));
                        jun = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Jun)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY4Jun))));
                        jul = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Jul)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY4Jul))));
                        aug = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Aug)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY4Aug))));
                        sep = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Sep)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY4Sep))));
                        oct = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Oct)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY4Oct))));
                        nov = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Nov)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY4Nov))));
                        dec = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Dec)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY4Dec))));
                    }else if(labor =="season") {
                        jan = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Jan)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY4Jan))));
                        feb = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Feb))));
                        mar = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Mar))));
                        apr = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Apr))));
                        may = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4May))));
                        jun = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Jun))));
                        jul = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Jul))));
                        aug = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Aug))));
                        sep = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Sep)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY4Sep))));
                        oct = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Oct)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY4Oct))));
                        nov = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Nov)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY4Nov))));
                        dec = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Dec)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY4Dec))));
                    }else{
                        jan = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Jan))));
                        feb = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Feb))));
                        mar = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Mar))));
                        apr = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Apr))));
                        may = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4May))));
                        jun = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Jun))));
                        jul = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Jul))));
                        aug = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Aug))));
                        sep = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Sep))));
                        oct = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Oct))));
                        nov = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Nov))));
                        dec = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY4Dec))));
                    }
                }

            }else if ((yearLaunch.equals("1")&& yearStart.equals("-4"))||(yearLaunch.equals("2")&& yearStart.equals("-3"))||(yearLaunch.equals("3")&& yearStart.equals("-2"))||(yearLaunch.equals("4")&& yearStart.equals("-1"))||(yearLaunch.equals("5")&& (yearStart.equals("Year 1")||yearStart.equals("Tahun 1")||yearStart.equals("Année 1")))||(yearLaunch.equals("6")&& (yearStart.equals("Year 2")||yearStart.equals("Tahun 2")||yearStart.equals("Année 2")))||(yearLaunch.equals("7")&& (yearStart.equals("Year 3")||yearStart.equals("Tahun 3")||yearStart.equals("Année 3")))){

                setText(jlb, p45);
                setText(fblb, p45);
                setText(mrlb, p78+", "+p36);
                setText(ablb, p30+", "+p68);
                setText(mylb, p26+", "+p47+", "+p5+", "+p40);
                setText(jnlb, p45);
                setText(jllb, p45);
                setText(aglb, p78+", "+p36);
                setText(splb, p26+", "+p21+", "+p41);
                setText(oclb, p25+", "+p47+", "+p41);
                setText(nvlb, p25);
                setText(dclb, p26);
                setText(plt, plot);

                if (labor == "labor"){
                    jan = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY5Jan)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY5Jan))));
                    feb = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY5Feb)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY5Feb))));
                    mar = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY5Mar)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY5Mar))));
                    apr = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY5Apr)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY5Apr))));
                    may = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY5May)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY5May))));
                    jun = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY5Jun)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY5Jun))));
                    jul = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY5Jul)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY5Jul))));
                    aug = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY5Aug)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY5Aug))));
                    sep = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY5Sep)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY5Sep))));
                    oct = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY5Oct)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY5Oct))));
                    nov = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY5Nov)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY5Nov))));
                    dec = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY5Dec)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY5Dec))));
                }else if(labor =="season") {
                    jan = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY5Jan)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY5Jan))));
                    feb = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY5Feb))));
                    mar = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY5Mar))));
                    apr = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY5Apr))));
                    may = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY5May))));
                    jun = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY5Jun))));
                    jul = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY5Jul))));
                    aug = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY5Aug))));
                    sep = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY5Sep)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY5Sep))));
                    oct = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY5Oct)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY5Oct))));
                    nov = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY5Nov)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY5Nov))));
                    dec = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY5Dec)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY5Dec))));
                }else{
                    jan = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY5Jan))));
                    feb = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY5Feb))));
                    mar = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY5Mar))));
                    apr = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY5Apr))));
                    may = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY5May))));
                    jun = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY5Jun))));
                    jul = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY5Jul))));
                    aug = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY5Aug))));
                    sep = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY5Sep))));
                    oct = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY5Oct))));
                    nov = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY5Nov))));
                    dec = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY5Dec))));
                }
            }else if ((yearLaunch.equals("1")&& yearStart.equals("-5"))||(yearLaunch.equals("2")&& yearStart.equals("-4"))||(yearLaunch.equals("3")&& yearStart.equals("-3"))||(yearLaunch.equals("4")&& yearStart.equals("-2"))||(yearLaunch.equals("5")&& yearStart.equals("-1"))||(yearLaunch.equals("6")&& (yearStart.equals("Year 1")||yearStart.equals("Tahun 1")||yearStart.equals("Année 1")))||(yearLaunch.equals("7")&& (yearStart.equals("Year 2")||yearStart.equals("Tahun 2")||yearStart.equals("Année 2")))){

                setText(jlb, p45);
                setText(fblb, p45);
                setText(mrlb, p78+", "+p36);
                setText(ablb, p30+", "+p68);
                setText(mylb, p26+", "+p47+", "+p5+", "+p40);
                setText(jnlb, p45);
                setText(jllb, p45);
                setText(aglb, p78+", "+p36);
                setText(splb, p26+", "+p21+", "+p41);
                setText(oclb, p25+", "+p47+", "+p41);
                setText(nvlb, p25);
                setText(dclb, p26);
                setText(plt, plot);

                if (labor == "labor"){
                    jan = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY6Jan)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY6Jan))));
                    feb = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY6Feb)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY6Feb))));
                    mar = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY6Mar)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY6Mar))));
                    apr = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY6Apr)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY6Apr))));
                    may = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY6May)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY6May))));
                    jun = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY6Jun)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY6Jun))));
                    jul = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY6Jul)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY6Jul))));
                    aug = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY6Aug)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY6Aug))));
                    sep = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY6Sep)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY6Sep))));
                    oct = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY6Oct)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY6Oct))));
                    nov = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY6Nov)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY6Nov))));
                    dec = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY6Dec)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY6Dec))));
                }else if(labor =="season") {
                    jan = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY6Jan)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY6Jan))));
                    feb = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY6Feb))));
                    mar = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY6Mar))));
                    apr = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY6Apr))));
                    may = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY6May))));
                    jun = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY6Jun))));
                    jul = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY6Jul))));
                    aug = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY6Aug))));
                    sep = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY6Sep)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY6Sep))));
                    oct = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY6Oct)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY6Oct))));
                    nov = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY6Nov)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY6Nov))));
                    dec = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY6Dec)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY6Dec))));
                }else{
                    jan = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY6Jan))));
                    feb = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY6Feb))));
                    mar = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY6Mar))));
                    apr = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY6Apr))));
                    may = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY6May))));
                    jun = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY6Jun))));
                    jul = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY6Jul))));
                    aug = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY6Aug))));
                    sep = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY6Sep))));
                    oct = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY6Oct))));
                    nov = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY6Nov))));
                    dec = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY6Dec))));
                }

            }else{

                setText(jlb, p45);
                setText(fblb, p45);
                setText(mrlb, p78+", "+p36);
                setText(ablb, p30+", "+p68);
                setText(mylb, p26+", "+p47+", "+p5+", "+p40);
                setText(jnlb, p45);
                setText(jllb, p45);
                setText(aglb, p78+", "+p36);
                setText(splb, p26+", "+p21+", "+p41);
                setText(oclb, p25+", "+p47+", "+p41);
                setText(nvlb, p25);
                setText(dclb, p26);
                setText(plt, plot);

                if (labor == "labor"){
                    jan = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY7Jan)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY7Jan))));
                    feb = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY7Feb)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY7Feb))));
                    mar = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY7Mar)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY7Mar))));
                    apr = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY7Apr)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY7Apr))));
                    may = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY7May)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY7May))));
                    jun = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY7Jun)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY7Jun))));
                    jul = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY7Jul)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY7Jul))));
                    aug = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY7Aug)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY7Aug))));
                    sep = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY7Sep)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY7Sep))));
                    oct = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY7Oct)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY7Oct))));
                    nov = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY7Nov)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY7Nov))));
                    dec = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY7Dec)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY7Dec))));
                }else if(labor =="season") {
                    jan = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY7Jan)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY7Jan))));
                    feb = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY7Feb))));
                    mar = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY7Mar))));
                    apr = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY7Apr))));
                    may = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY7May))));
                    jun = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY7Jun))));
                    jul = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY7Jul))));
                    aug = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY7Aug))));
                    sep = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY7Sep)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY7Sep))));
                    oct = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY7Oct)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY7Oct))));
                    nov = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY7Nov)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY7Nov))));
                    dec = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY7Dec)))+(area * (getResources().getInteger(R.integer.fillingLaborCostY7Dec))));
                }else{
                    jan = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY7Jan))));
                    feb = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY7Feb))));
                    mar = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY7Mar))));
                    apr = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY7Apr))));
                    may = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY7May))));
                    jun = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY7Jun))));
                    jul = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY7Jul))));
                    aug = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY7Aug))));
                    sep = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY7Sep))));
                    oct = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY7Oct))));
                    nov = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY7Nov))));
                    dec = (int) ((area * (getResources().getInteger(R.integer.fillingInputsY7Dec))));
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
