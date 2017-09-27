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

public class replantDetailFragment extends Fragment {
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
        DecimalFormat decF = new DecimalFormat("FCFA ###,###,###");
        setText(plt, plot);

        if (launchYear < startYear){
            setText(jlb, p45);
            setText(fblb, p45);
            setText(mrlb, p39);
            setText(ablb, p77+", "+p24+", "+p38);
            setText(mylb, p77+", "+p24+", "+p38);
            setText(jnlb, p45);
            setText(jllb, p45);
            setText(aglb, p39);
            setText(splb, p77+", "+p24+", "+p38);
            setText(oclb, p77+", "+p24+", "+p38);
            setText(nvlb, p45);
            setText(dclb, p48);
            setText(plt, plot);
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
                jan = (int) (area * (getResources().getInteger(R.integer.MinGAPJan) + getResources().getInteger(R.integer.MinGAPSLaborJan)));
                feb = (int) (area * getResources().getInteger(R.integer.MinGAPFeb));
                mar = (int) (area * getResources().getInteger(R.integer.MinGAPMar));
                apr = (int) (area * getResources().getInteger(R.integer.MinGAPApr));
                may = (int) (area * getResources().getInteger(R.integer.MinGAPMay) );
                jun = (int) (area * getResources().getInteger(R.integer.MinGAPJun) );
                jul = (int) (area * getResources().getInteger(R.integer.MinGAPJul) );
                aug = (int) (area * getResources().getInteger(R.integer.MinGAPAug));
                sep = (int) (area * (getResources().getInteger(R.integer.MinGAPSep) + getResources().getInteger(R.integer.MinGAPSLaborSep)));
                oct = (int) (area * (getResources().getInteger(R.integer.MinGAPOct) + getResources().getInteger(R.integer.MinGAPSLaborOct)));
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

        }else{
            if ((yearLaunch.equals("1")&& (yearStart.equals("Year 1")||yearStart.equals("Tahun 1")||yearStart.equals("Année 1")))||(yearLaunch.equals("2")&& (yearStart.equals("Year 2")||yearStart.equals("Tahun 2")||yearStart.equals("Année 2")))||(yearLaunch.equals("3")&& (yearStart.equals("Year 3")||yearStart.equals("Tahun 3")||yearStart.equals("Année 3")))||(yearLaunch.equals("4")&& (yearStart.equals("Year 4")||yearStart.equals("Tahun 4")||yearStart.equals("Année 4")))||(yearLaunch.equals("5")&& (yearStart.equals("Year 5")||yearStart.equals("Tahun 5")||yearStart.equals("Année 5")))||(yearLaunch.equals("6")&& (yearStart.equals("Year 6")||yearStart.equals("Tahun 6")||yearStart.equals("Année 6")))||(yearLaunch.equals("7")&& (yearStart.equals("Year 7")||yearStart.equals("Tahun 7")||yearStart.equals("Année 7")))){

                setText(jlb, p45);
                setText(fblb, p45);
                setText(mrlb, p45);
                setText(ablb, p48);
                setText(mylb, p48);
                setText(jnlb, p45);
                setText(jllb, p13);
                setText(aglb, p13);
                setText(splb, p13);
                setText(oclb, p20+", "+p37);
                setText(nvlb, p20+", "+p37+", "+p52);
                setText(dclb, p20+", "+p52);
                setText(plt, plot);
                if (relat == "extra"){
                    if (labor == "labor"){
                        jan = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Jan)+getResources().getInteger(R.integer.ReplantingLaborY1Jan)+getResources().getInteger(R.integer.difInputY1Jan))+getResources().getInteger(R.integer.difLaborY1Jan));
                        feb = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Feb)+getResources().getInteger(R.integer.ReplantingLaborY1Feb)+getResources().getInteger(R.integer.difInputY1Feb))+getResources().getInteger(R.integer.difLaborY1Feb));
                        mar = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Mar)+getResources().getInteger(R.integer.ReplantingLaborY1Mar)+getResources().getInteger(R.integer.difInputY1Mar))+getResources().getInteger(R.integer.difLaborY1Mar));
                        apr = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Apr)+getResources().getInteger(R.integer.ReplantingLaborY1Apr)+getResources().getInteger(R.integer.difInputY1Apr))+getResources().getInteger(R.integer.difLaborY1Apr));
                        may = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1May)+getResources().getInteger(R.integer.ReplantingLaborY1May)+getResources().getInteger(R.integer.difInputY1May))+getResources().getInteger(R.integer.difLaborY1May));
                        jun = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Jun)+getResources().getInteger(R.integer.ReplantingLaborY1Jun)+getResources().getInteger(R.integer.difInputY1Jun))+getResources().getInteger(R.integer.difLaborY1Jun));
                        jul = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Jul)+getResources().getInteger(R.integer.ReplantingLaborY1Jul)+getResources().getInteger(R.integer.difInputY1Jul))+getResources().getInteger(R.integer.difLaborY1Jul));
                        aug = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Aug)+getResources().getInteger(R.integer.ReplantingLaborY1Aug)+getResources().getInteger(R.integer.difInputY1Aug))+getResources().getInteger(R.integer.difLaborY1Aug));
                        sep = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Sep)+getResources().getInteger(R.integer.ReplantingLaborY1Sep)+getResources().getInteger(R.integer.difInputY1Sep))+getResources().getInteger(R.integer.difLaborY1Sep));
                        oct = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Oct)+getResources().getInteger(R.integer.ReplantingLaborY1Oct)+getResources().getInteger(R.integer.difInputY1Oct))+getResources().getInteger(R.integer.difLaborY1Oct));
                        nov = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Nov)+getResources().getInteger(R.integer.ReplantingLaborY1Nov)+getResources().getInteger(R.integer.difInputY1Nov))+getResources().getInteger(R.integer.difLaborY1Nov));
                        dec = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Dec)+getResources().getInteger(R.integer.ReplantingLaborY1Dec)+getResources().getInteger(R.integer.difInputY1Dec))+getResources().getInteger(R.integer.difLaborY1Dec));
                    }else if(labor =="season") {
                        jan = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Jan)+getResources().getInteger(R.integer.ReplantingLaborY1Jan)+getResources().getInteger(R.integer.difInputY1Jan))+getResources().getInteger(R.integer.difLaborY1Jan));
                        feb = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Feb)+getResources().getInteger(R.integer.difInputY1Feb)));
                        mar = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Mar)+getResources().getInteger(R.integer.difInputY1Mar)));
                        apr = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Apr)+ getResources().getInteger(R.integer.difInputY1Apr)));
                        may = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1May)+getResources().getInteger(R.integer.difInputY1May)));
                        jun = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Jun)+getResources().getInteger(R.integer.difInputY1Jun)));
                        jul = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Jul)+getResources().getInteger(R.integer.difInputY1Jul)));
                        aug = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Aug)+getResources().getInteger(R.integer.difInputY1Aug)));
                        sep = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Sep)+getResources().getInteger(R.integer.ReplantingLaborY1Sep)+getResources().getInteger(R.integer.difInputY1Sep))+getResources().getInteger(R.integer.difLaborY1Sep));
                        oct = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Oct)+getResources().getInteger(R.integer.ReplantingLaborY1Oct)+getResources().getInteger(R.integer.difInputY1Oct))+getResources().getInteger(R.integer.difLaborY1Oct));
                        nov = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Nov)+getResources().getInteger(R.integer.ReplantingLaborY1Nov)+getResources().getInteger(R.integer.difInputY1Nov))+getResources().getInteger(R.integer.difLaborY1Nov));
                        dec = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Dec)+getResources().getInteger(R.integer.ReplantingLaborY1Dec)+getResources().getInteger(R.integer.difInputY1Dec))+getResources().getInteger(R.integer.difLaborY1Dec));
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
                        jan = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Jan)+getResources().getInteger(R.integer.ReplantingLaborY1Jan)));
                        feb = (int) (area * getResources().getInteger(R.integer.ReplantingInputY1Feb));
                        mar = (int) (area * getResources().getInteger(R.integer.ReplantingInputY1Mar));
                        apr = (int) (area * getResources().getInteger(R.integer.ReplantingInputY1Apr));
                        may = (int) (area * getResources().getInteger(R.integer.ReplantingInputY1May));
                        jun = (int) (area * getResources().getInteger(R.integer.ReplantingInputY1Jun));
                        jul = (int) (area * getResources().getInteger(R.integer.ReplantingInputY1Jul));
                        aug = (int) (area * getResources().getInteger(R.integer.ReplantingInputY1Aug));
                        sep = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Sep)+getResources().getInteger(R.integer.ReplantingLaborY1Sep)));
                        oct = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Oct)+getResources().getInteger(R.integer.ReplantingLaborY1Oct)));
                        nov = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY1Nov)+getResources().getInteger(R.integer.ReplantingLaborY1Nov)));
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

            }else if ((yearLaunch.equals("1")&& yearStart.equals("-1"))||(yearLaunch.equals("2")&& (yearStart.equals("Year 1")||yearStart.equals("Tahun 1")||yearStart.equals("Année 1")))||(yearLaunch.equals("3")&& (yearStart.equals("Year 2")||yearStart.equals("Tahun 2")||yearStart.equals("Année 2")))||(yearLaunch.equals("4")&& (yearStart.equals("Year 3")||yearStart.equals("Tahun 3")||yearStart.equals("Année 3")))||(yearLaunch.equals("5")&& (yearStart.equals("Year 4")||yearStart.equals("Tahun 4")||yearStart.equals("Année 4")))||(yearLaunch.equals("6")&& (yearStart.equals("Year 5")||yearStart.equals("Tahun 5")||yearStart.equals("Année 5")))||(yearLaunch.equals("7")&& (yearStart.equals("Year 6")||yearStart.equals("Tahun 6")||yearStart.equals("Année 6")))){
                if (relat == "extra"){
                    setText(jlb, p20);
                    setText(fblb, p20);
                    setText(mrlb, p10);
                    setText(ablb, p10+", "+p54+", "+p6);
                    setText(mylb, p10+", "+p54+", "+p6+", "+p1+", "+p2+", "+p4+", "+p22);
                    setText(jnlb, p10+", "+p53+", "+p6);
                    setText(jllb, p78+", "+p49);
                    setText(aglb, p45);
                    setText(splb, p48+", "+p65+", "+p2+", "+p4+", "+p68+", "+p75);
                    setText(oclb, p78+", "+p36);
                    setText(nvlb, p48);
                    setText(dclb, p78+", "+p36+", "+p68);
                    setText(plt, plot);
                    if (labor == "labor"){
                        jan = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Jan)+getResources().getInteger(R.integer.ReplantingLaborY2Jan)+getResources().getInteger(R.integer.difInputY2Jan))+getResources().getInteger(R.integer.difLaborY2Jan));
                        feb = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Feb)+getResources().getInteger(R.integer.ReplantingLaborY2Feb)+getResources().getInteger(R.integer.difInputY2Feb))+getResources().getInteger(R.integer.difLaborY2Feb));
                        mar = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Mar)+getResources().getInteger(R.integer.ReplantingLaborY2Mar)+getResources().getInteger(R.integer.difInputY2Mar))+getResources().getInteger(R.integer.difLaborY2Mar));
                        apr = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Apr)+getResources().getInteger(R.integer.ReplantingLaborY2Apr)+getResources().getInteger(R.integer.difInputY2Apr))+getResources().getInteger(R.integer.difLaborY2Apr));
                        may = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2May)+getResources().getInteger(R.integer.ReplantingLaborY2May)+getResources().getInteger(R.integer.difInputY2May))+getResources().getInteger(R.integer.difLaborY2May));
                        jun = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Jun)+getResources().getInteger(R.integer.ReplantingLaborY2Jun)+getResources().getInteger(R.integer.difInputY2Jun))+getResources().getInteger(R.integer.difLaborY2Jun));
                        jul = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Jul)+getResources().getInteger(R.integer.ReplantingLaborY2Jul)+getResources().getInteger(R.integer.difInputY2Jul))+getResources().getInteger(R.integer.difLaborY2Jul));
                        aug = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Aug)+getResources().getInteger(R.integer.ReplantingLaborY2Aug)+getResources().getInteger(R.integer.difInputY2Aug))+getResources().getInteger(R.integer.difLaborY2Aug));
                        sep = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Sep)+getResources().getInteger(R.integer.ReplantingLaborY2Sep)+getResources().getInteger(R.integer.difInputY2Sep))+getResources().getInteger(R.integer.difLaborY2Sep));
                        oct = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Oct)+getResources().getInteger(R.integer.ReplantingLaborY2Oct)+getResources().getInteger(R.integer.difInputY2Oct))+getResources().getInteger(R.integer.difLaborY2Oct));
                        nov = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Nov)+getResources().getInteger(R.integer.ReplantingLaborY2Nov)+getResources().getInteger(R.integer.difInputY2Nov))+getResources().getInteger(R.integer.difLaborY2Nov));
                        dec = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Dec)+getResources().getInteger(R.integer.ReplantingLaborY2Dec)+getResources().getInteger(R.integer.difInputY2Dec))+getResources().getInteger(R.integer.difLaborY2Dec));
                    }else if(labor =="season") {
                        jan = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Jan)+getResources().getInteger(R.integer.ReplantingLaborY2Jan)+getResources().getInteger(R.integer.difInputY2Jan))+getResources().getInteger(R.integer.difLaborY2Jan));
                        feb = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Feb)+getResources().getInteger(R.integer.difInputY2Feb)));
                        mar = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Mar)+getResources().getInteger(R.integer.difInputY2Mar)));
                        apr = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Apr)+getResources().getInteger(R.integer.difInputY2Apr)));
                        may = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2May)+getResources().getInteger(R.integer.difInputY2May)));
                        jun = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Jun)+getResources().getInteger(R.integer.difInputY2Jun)));
                        jul = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Jul)+getResources().getInteger(R.integer.difInputY2Jul)));
                        aug = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Aug)+getResources().getInteger(R.integer.difInputY2Aug)));
                        sep = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Sep)+getResources().getInteger(R.integer.ReplantingLaborY2Sep)+getResources().getInteger(R.integer.difInputY2Sep))+getResources().getInteger(R.integer.difLaborY2Sep));
                        oct = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Oct)+getResources().getInteger(R.integer.ReplantingLaborY2Oct)+getResources().getInteger(R.integer.difInputY2Oct))+getResources().getInteger(R.integer.difLaborY2Oct));
                        nov = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Nov)+getResources().getInteger(R.integer.ReplantingLaborY2Nov)+getResources().getInteger(R.integer.difInputY2Nov))+getResources().getInteger(R.integer.difLaborY2Nov));
                        dec = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Dec)+getResources().getInteger(R.integer.ReplantingLaborY2Dec)+getResources().getInteger(R.integer.difInputY2Dec))+getResources().getInteger(R.integer.difLaborY2Dec));
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
                    setText(jlb, p20);
                    setText(fblb, p20);
                    setText(mrlb, p10);
                    setText(ablb, p10+", "+p54+", "+p6);
                    setText(mylb, p10+", "+p54+", "+p6+", "+p1+", "+p22);
                    setText(jnlb, p10+", "+p53+", "+p6);
                    setText(jllb, p78+", "+p49);
                    setText(aglb, p45);
                    setText(splb, p48+", "+p65+", "+p21+", "+p68+", "+p75);
                    setText(oclb, p78+", "+p36);
                    setText(nvlb, p48);
                    setText(dclb, p78+", "+p36+", "+p68);
                    setText(plt, plot);
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
                        jan = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Jan)+getResources().getInteger(R.integer.ReplantingLaborY2Jan)));
                        feb = (int) (area * getResources().getInteger(R.integer.ReplantingInputY2Feb));
                        mar = (int) (area * getResources().getInteger(R.integer.ReplantingInputY2Mar));
                        apr = (int) (area * getResources().getInteger(R.integer.ReplantingInputY2Apr));
                        may = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2May)));
                        jun = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Jun)));
                        jul = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Jul)));
                        aug = (int) (area * getResources().getInteger(R.integer.ReplantingInputY2Aug));
                        sep = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Sep)+getResources().getInteger(R.integer.ReplantingLaborY2Sep)));
                        oct = (int) (area * (getResources().getInteger(R.integer.ReplantingInputY2Oct)+getResources().getInteger(R.integer.ReplantingLaborY2Oct)));
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

            }else if ((yearLaunch.equals("1")||yearStart.equals("-2"))||(yearLaunch.equals("2")&& yearStart.equals("-1"))||(yearLaunch.equals("3")&& (yearStart.equals("Year 1")||yearStart.equals("Tahun 1")||yearStart.equals("Année 1")))||(yearLaunch.equals("4")&& (yearStart.equals("Year 2")||yearStart.equals("Tahun 2")||yearStart.equals("Année 2")))||(yearLaunch.equals("5")&& (yearStart.equals("Year 3")||yearStart.equals("Tahun 3")||yearStart.equals("Année 3")))||(yearLaunch.equals("6")&& (yearStart.equals("Year 4")||yearStart.equals("Tahun 4")||yearStart.equals("Année 4")))||(yearLaunch.equals("7")&& (yearStart.equals("Year 5")||yearStart.equals("Tahun 5")||yearStart.equals("Année 5")))){

                if (relat == "extra"){
                    setText(jlb, p45);
                    setText(fblb, p45);
                    setText(mrlb, p28+", "+p36);
                    setText(ablb, p26+", "+p41);
                    setText(mylb, p25+", "+p2+", "+p3+", "+p67);
                    setText(jnlb, p45);
                    setText(jllb, p45);
                    setText(aglb, p25+", "+p78+", "+p36+", "+p9);
                    setText(splb, p26+", "+p2+", "+p67);
                    setText(oclb, p25+", "+p3+", "+p41);
                    setText(nvlb, p25+", "+p57);
                    setText(dclb, p26+", "+p68);
                    setText(plt, plot);
                    if (labor == "labor"){
                        jan = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Jan))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY3Jan)))+(area * (getResources().getInteger(R.integer.difInputY3Jan)))+getResources().getInteger(R.integer.difLaborY3Jan));
                        feb = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Feb))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY3Feb)))+(area * (getResources().getInteger(R.integer.difInputY3Feb)))+getResources().getInteger(R.integer.difLaborY3Feb));
                        mar = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Mar))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY3Mar)))+(area * (getResources().getInteger(R.integer.difInputY3Mar)))+getResources().getInteger(R.integer.difLaborY3Mar));
                        apr = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Apr))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY3Apr)))+(area * (getResources().getInteger(R.integer.difInputY3Apr)))+getResources().getInteger(R.integer.difLaborY3Apr));
                        may = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3May))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY3May)))+(area * (getResources().getInteger(R.integer.difInputY3May)))+getResources().getInteger(R.integer.difLaborY3May));
                        jun = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Jun))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY3Jun)))+(area * (getResources().getInteger(R.integer.difInputY3Jun)))+getResources().getInteger(R.integer.difLaborY3Jun));
                        jul = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Jul))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY3Jul)))+(area * (getResources().getInteger(R.integer.difInputY3Jul)))+getResources().getInteger(R.integer.difLaborY3Jul));
                        aug = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Aug))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY3Aug)))+(area * (getResources().getInteger(R.integer.difInputY3Aug)))+getResources().getInteger(R.integer.difLaborY3Aug));
                        sep = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Sep))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY3Sep)))+(area * (getResources().getInteger(R.integer.difInputY3Sep)))+getResources().getInteger(R.integer.difLaborY3Sep));
                        oct = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Oct))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY3Oct)))+(area * (getResources().getInteger(R.integer.difInputY3Oct)))+getResources().getInteger(R.integer.difLaborY3Oct));
                        nov = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Nov))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY3Nov)))+(area * (getResources().getInteger(R.integer.difInputY3Nov)))+getResources().getInteger(R.integer.difLaborY3Nov));
                        dec = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Dec))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY3Dec)))+(area * (getResources().getInteger(R.integer.difInputY3Dec)))+getResources().getInteger(R.integer.difLaborY3Dec));
                    }else if(labor =="season") {
                        jan = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Jan))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY3Jan)))+(area * (getResources().getInteger(R.integer.difInputY3Jan)))+getResources().getInteger(R.integer.difLaborY3Jan));
                        feb = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Feb)))+(area * (getResources().getInteger(R.integer.difInputY3Feb))));
                        mar = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Mar)))+(area * (getResources().getInteger(R.integer.difInputY3Mar))));
                        apr = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Apr)))+(area * (getResources().getInteger(R.integer.difInputY3Apr))));
                        may = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3May)))+(area * (getResources().getInteger(R.integer.difInputY3May))));
                        jun = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Jun)))+(area * (getResources().getInteger(R.integer.difInputY3Jun))));
                        jul = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Jul)))+(area * (getResources().getInteger(R.integer.difInputY3Jul))));
                        aug = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Aug)))+(area * (getResources().getInteger(R.integer.difInputY3Aug))));
                        sep = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Sep))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY3Sep)))+(area * (getResources().getInteger(R.integer.difInputY3Sep)))+getResources().getInteger(R.integer.difLaborY3Sep));
                        oct = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Oct))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY3Oct)))+(area * (getResources().getInteger(R.integer.difInputY3Oct)))+getResources().getInteger(R.integer.difLaborY3Oct));
                        nov = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Nov))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY3Nov)))+(area * (getResources().getInteger(R.integer.difInputY3Nov)))+getResources().getInteger(R.integer.difLaborY3Nov));
                        dec = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Dec))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY3Dec)))+(area * (getResources().getInteger(R.integer.difInputY3Dec)))+getResources().getInteger(R.integer.difLaborY3Dec));
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
                    setText(jlb, p45);
                    setText(fblb, p45);
                    setText(mrlb, p28+", "+p36);
                    setText(ablb, p26+", "+p41);
                    setText(mylb, p25+", "+p21+", "+p47+", "+p67);
                    setText(jnlb, p45);
                    setText(jllb, p45);
                    setText(aglb, p25+", "+p78+", "+p36+", "+p9);
                    setText(splb, p26+", "+p21+", "+p67);
                    setText(oclb, p25+", "+p47+", "+p41);
                    setText(nvlb, p25+", "+p57);
                    setText(dclb, p26+", "+p68);
                    setText(plt, plot);
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
                        jan = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Jan))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY3Jan))));
                        feb = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Feb))));
                        mar = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Mar))));
                        apr = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Apr))));
                        may = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3May))));
                        jun = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Jun))));
                        jul = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Jul))));
                        aug = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Aug))));
                        sep = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Sep))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY3Sep))));
                        oct = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Oct))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY3Oct))));
                        nov = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Nov))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY3Nov))));
                        dec = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY3Dec))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY3Dec))));
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

            }else if ((yearLaunch.equals("1")&& yearStart.equals("-3"))||(yearLaunch.equals("2")&&yearStart.equals("-2"))||(yearLaunch.equals("3")&& yearStart.equals("-1"))||(yearLaunch.equals("4")&& (yearStart.equals("Year 1")||yearStart.equals("Tahun 1")||yearStart.equals("Année 1")))||(yearLaunch.equals("5")&& (yearStart.equals("Year 2")||yearStart.equals("Tahun 2")||yearStart.equals("Année 2")))||(yearLaunch.equals("6")&& (yearStart.equals("Year 3")||yearStart.equals("Tahun 3")||yearStart.equals("Année 3")))||(yearLaunch.equals("7")&& (yearStart.equals("Year 4")||yearStart.equals("Tahun 4")||yearStart.equals("Année 4")))){

                setText(jlb, p45);
                setText(fblb, p45);
                setText(mrlb, p78+", "+p36+", "+p9);
                setText(ablb, p26+", "+p41);
                setText(mylb, p26+", "+p21+", "+p47+", "+p67);
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
                        jan = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Jan))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY4Jan)))+(area * (getResources().getInteger(R.integer.difInputY4Jan))));
                        feb = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Feb)))+(area * (getResources().getInteger(R.integer.difInputY4Feb))));
                        mar = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Mar)))+(area * (getResources().getInteger(R.integer.difInputY4Mar))));
                        apr = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Apr)))+(area * (getResources().getInteger(R.integer.difInputY4Apr))));
                        may = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4May)))+(area * (getResources().getInteger(R.integer.difInputY4May))));
                        jun = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Jun)))+(area * (getResources().getInteger(R.integer.difInputY4Jun))));
                        jul = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Jul)))+(area * (getResources().getInteger(R.integer.difInputY4Jul))));
                        aug = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Aug)))+(area * (getResources().getInteger(R.integer.difInputY4Aug))));
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
                    }else if(labor =="season") {
                        jan = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Jan))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY4Jan))));
                        feb = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Feb))));
                        mar = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Mar))));
                        apr = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Apr))));
                        may = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4May))));
                        jun = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Jun))));
                        jul = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Jul))));
                        aug = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Aug))));
                        sep = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Sep))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY4Sep))));
                        oct = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Oct))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY4Oct))));
                        nov = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Nov))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY4Nov))));
                        dec = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY4Dec))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY4Dec))));
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
                }else if(labor =="season") {
                    jan = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Jan))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY5Jan))));
                    feb = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Feb))));
                    mar = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Mar))));
                    apr = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Apr))));
                    may = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5May))));
                    jun = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Jun))));
                    jul = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Jul))));
                    aug = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Aug))));
                    sep = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Sep))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY5Sep))));
                    oct = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Oct))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY5Oct))));
                    nov = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Nov))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY5Nov))));
                    dec = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY5Dec))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY5Dec))));
                }else {
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

                if (labor == "labor") {
                    jan = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY6Jan))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY6Jan))));
                    feb = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY6Feb))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY6Feb))));
                    mar = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY6Mar))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY6Mar))));
                    apr = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY6Apr))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY6Apr))));
                    may = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY6May))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY6May))));
                    jun = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY6Jun))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY6Jun))));
                    jul = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY6Jul))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY6Jul))));
                    aug = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY6Aug))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY6Aug))));
                    sep = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY6Sep))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY6Sep))));
                    oct = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY6Oct))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY6Oct))));
                    nov = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY6Nov))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY6Nov))));
                    dec = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY6Dec))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY6Dec))));
                }else if(labor =="season") {
                    jan = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY6Jan))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY6Jan))));
                    feb = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY6Feb))));
                    mar = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY6Mar))));
                    apr = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY6Apr))));
                    may = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY6May))));
                    jun = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY6Jun))));
                    jul = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY6Jul))));
                    aug = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY6Aug))));
                    sep = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY6Sep))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY6Sep))));
                    oct = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY6Oct))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY6Oct))));
                    nov = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY6Nov))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY6Nov))));
                    dec = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY6Dec))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY6Dec))));
                }else {
                    jan = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY6Jan))));
                    feb = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY6Feb))));
                    mar = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY6Mar))));
                    apr = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY6Apr))));
                    may = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY6May))));
                    jun = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY6Jun))));
                    jul = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY6Jul))));
                    aug = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY6Aug))));
                    sep = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY6Sep))));
                    oct = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY6Oct))));
                    nov = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY6Nov))));
                    dec = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY6Dec))));
                }

            }else {

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
                    jan = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY7Jan))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY7Jan))));
                    feb = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY7Feb))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY7Feb))));
                    mar = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY7Mar))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY7Mar))));
                    apr = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY7Apr))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY7Apr))));
                    may = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY7May))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY7May))));
                    jun = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY7Jun))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY7Jun))));
                    jul = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY7Jul))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY7Jul))));
                    aug = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY7Aug))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY7Aug))));
                    sep = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY7Sep))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY7Sep))));
                    oct = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY7Oct))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY7Oct))));
                    nov = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY7Nov))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY7Nov))));
                    dec = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY7Dec))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY7Dec))));
                }else if(labor =="season") {
                    jan = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY7Jan))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY7Jan))));
                    feb = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY7Feb))));
                    mar = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY7Mar))));
                    apr = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY7Apr))));
                    may = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY7May))));
                    jun = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY7Jun))));
                    jul = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY7Jul))));
                    aug = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY7Aug))));
                    sep = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY7Sep))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY7Sep))));
                    oct = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY7Oct))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY7Oct))));
                    nov = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY7Nov))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY7Nov))));
                    dec = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY7Dec))) + (area * (getResources().getInteger(R.integer.ReplantingLaborY7Dec))));
                }else {
                    jan = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY7Jan))));
                    feb = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY7Feb))));
                    mar = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY7Mar))));
                    apr = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY7Apr))));
                    may = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY7May))));
                    jun = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY7Jun))));
                    jul = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY7Jul))));
                    aug = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY7Aug))));
                    sep = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY7Sep))));
                    oct = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY7Oct))));
                    nov = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY7Nov))));
                    dec = (int) ((area * (getResources().getInteger(R.integer.ReplantingInputY7Dec))));
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
