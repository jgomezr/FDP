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

public class extraDetailFragment extends Fragment {
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
        DecimalFormat decF = new DecimalFormat("IDR ###,###,###");
        setText(plt, plot);

        if (launchYear < startYear){
            setText(jlb, p17);
            setText(fblb, p33);
            setText(mrlb, p58);
            setText(ablb, p39+", "+p46);
            setText(mylb, p46+", "+p40+", "+p12+", "+p38+", "+p17+", "+p4+p19);
            setText(jnlb, p50+", "+p17);
            setText(jllb, p33);
            setText(aglb, p58);
            setText(splb, p46+", "+p40+", "+p12+", "+p17);
            setText(oclb, p45+", "+p50+", "+p38+", "+p17+", "+p4+p19);
            setText(nvlb, p45+", "+p50+", "+p17);
            setText(dclb, p39+", "+p52+", "+p17);
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
        }else{
            if ((yearLaunch.equals("1")&& (yearStart.equals("Year 1")||yearStart.equals("Tahun 1")||yearStart.equals("Année 1")))||(yearLaunch.equals("2")&& (yearStart.equals("Year 2")||yearStart.equals("Tahun 2")||yearStart.equals("Année 2")))||(yearLaunch.equals("3")&& (yearStart.equals("Year 3")||yearStart.equals("Tahun 3")||yearStart.equals("Année 3")))||(yearLaunch.equals("4")&& (yearStart.equals("Year 4")||yearStart.equals("Tahun 4")||yearStart.equals("Année 4")))||(yearLaunch.equals("5")&& (yearStart.equals("Year 5")||yearStart.equals("Tahun 5")||yearStart.equals("Année 5")))||(yearLaunch.equals("6")&& (yearStart.equals("Year 6")||yearStart.equals("Tahun 6")||yearStart.equals("Année 6")))||(yearLaunch.equals("7")&& (yearStart.equals("Year 7")||yearStart.equals("Tahun 7")||yearStart.equals("Année 7")))){
                setText(jlb, p17);
                setText(fblb, p33);
                setText(mrlb, p58);
                setText(ablb, p39+", "+p46);
                setText(mylb, p46+", "+p40+", "+p13+", "+p38+", "+p17+", "+p4+p19);
                setText(jnlb, p50+", "+p17);
                setText(jllb, p33);
                setText(aglb, p58);
                setText(splb, p46+", "+p40+", "+p13+", "+p17);
                setText(oclb, p45+", "+p50+", "+p37+", "+p17+", "+p4+p19);
                setText(nvlb, p45+", "+p50+", "+p17);
                setText(dclb, p39+", "+p52+", "+p17);
                setText(plt, plot);

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

            }else if ((yearLaunch.equals("1")&& yearStart.equals("-1"))||(yearLaunch.equals("2")&& (yearStart.equals("Year 1")||yearStart.equals("Tahun 1")||yearStart.equals("Année 1")))||(yearLaunch.equals("3")&& (yearStart.equals("Year 2")||yearStart.equals("Tahun 2")||yearStart.equals("Année 2")))||(yearLaunch.equals("4")&& (yearStart.equals("Year 3")||yearStart.equals("Tahun 3")||yearStart.equals("Année 3")))||(yearLaunch.equals("5")&& (yearStart.equals("Year 4")||yearStart.equals("Tahun 4")||yearStart.equals("Année 4")))||(yearLaunch.equals("6")&& (yearStart.equals("Year 5")||yearStart.equals("Tahun 5")||yearStart.equals("Année 5")))||(yearLaunch.equals("7")&& (yearStart.equals("Year 6")||yearStart.equals("Tahun 6")||yearStart.equals("Année 6")))){
                setText(jlb, p17);
                setText(fblb, p33);
                setText(mrlb, p58);
                setText(ablb, p39+", "+p46);
                setText(mylb, p46+", "+p40+", "+p13+", "+p38+", "+p17+", "+p4+p19);
                setText(jnlb, p50+", "+p17);
                setText(jllb, p33);
                setText(aglb, p58);
                setText(splb, p46+", "+p40+", "+p13+", "+p17);
                setText(oclb, p45+", "+p50+", "+p37+", "+p17+", "+p4+p19);
                setText(nvlb, p45+", "+p50+", "+p17);
                setText(dclb, p39+", "+p52+", "+p17);
                setText(plt, plot);

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

            }else if ((yearLaunch.equals("1")||yearStart.equals("-2"))||(yearLaunch.equals("2")&& yearStart.equals("-1"))||(yearLaunch.equals("3")&& (yearStart.equals("Year 1")||yearStart.equals("Tahun 1")||yearStart.equals("Année 1")))||(yearLaunch.equals("4")&& (yearStart.equals("Year 2")||yearStart.equals("Tahun 2")||yearStart.equals("Année 2")))||(yearLaunch.equals("5")&& (yearStart.equals("Year 3")||yearStart.equals("Tahun 3")||yearStart.equals("Année 3")))||(yearLaunch.equals("6")&& (yearStart.equals("Year 4")||yearStart.equals("Tahun 4")||yearStart.equals("Année 4")))||(yearLaunch.equals("7")&& (yearStart.equals("Year 5")||yearStart.equals("Tahun 5")||yearStart.equals("Année 5")))){

                setText(jlb, p17);
                setText(fblb, p33);
                setText(mrlb, p58);
                setText(ablb, p39+", "+p46);
                setText(mylb, p46+", "+p40+", "+p12+", "+p38+", "+p17+", "+p4+p19);
                setText(jnlb, p50+", "+p17);
                setText(jllb, p33);
                setText(aglb, p58);
                setText(splb, p46+", "+p40+", "+p12+", "+p17);
                setText(oclb, p45+", "+p50+", "+p38+", "+p17+", "+p4+p19);
                setText(nvlb, p45+", "+p50+", "+p17);
                setText(dclb, p39+", "+p52+", "+p17);
                setText(plt, plot);

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

            }else if ((yearLaunch.equals("1")&& yearStart.equals("-3"))||(yearLaunch.equals("2")&&yearStart.equals("-2"))||(yearLaunch.equals("3")&& yearStart.equals("-1"))||(yearLaunch.equals("4")&& (yearStart.equals("Year 1")||yearStart.equals("Tahun 1")||yearStart.equals("Année 1")))||(yearLaunch.equals("5")&& (yearStart.equals("Year 2")||yearStart.equals("Tahun 2")||yearStart.equals("Année 2")))||(yearLaunch.equals("6")&& (yearStart.equals("Year 3")||yearStart.equals("Tahun 3")||yearStart.equals("Année 3")))||(yearLaunch.equals("7")&& (yearStart.equals("Year 4")||yearStart.equals("Tahun 4")||yearStart.equals("Année 4")))){

                setText(jlb, p17);
                setText(fblb, p33);
                setText(mrlb, p58);
                setText(ablb, p39+", "+p46);
                setText(mylb, p46+", "+p40+", "+p12+", "+p38+", "+p17+", "+p4+p19);
                setText(jnlb, p50+", "+p17);
                setText(jllb, p33);
                setText(aglb, p58);
                setText(splb, p46+", "+p40+", "+p12+", "+p17);
                setText(oclb, p45+", "+p50+", "+p38+", "+p17+", "+p4+p19);
                setText(nvlb, p45+", "+p50+", "+p17);
                setText(dclb, p39+", "+p52+", "+p17);
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

            }else if ((yearLaunch.equals("1")&& yearStart.equals("-4"))||(yearLaunch.equals("2")&& yearStart.equals("-3"))||(yearLaunch.equals("3")&& yearStart.equals("-2"))||(yearLaunch.equals("4")&& yearStart.equals("-1"))||(yearLaunch.equals("5")&& (yearStart.equals("Year 1")||yearStart.equals("Tahun 1")||yearStart.equals("Année 1")))||(yearLaunch.equals("6")&& (yearStart.equals("Year 2")||yearStart.equals("Tahun 2")||yearStart.equals("Année 2")))||(yearLaunch.equals("7")&& (yearStart.equals("Year 3")||yearStart.equals("Tahun 3")||yearStart.equals("Année 3")))){

                setText(jlb, p17);
                setText(fblb, p33);
                setText(mrlb, p58);
                setText(ablb, p39+", "+p46);
                setText(mylb, p46+", "+p40+", "+p12+", "+p38+", "+p17+", "+p4+p19);
                setText(jnlb, p50+", "+p17);
                setText(jllb, p33);
                setText(aglb, p58);
                setText(splb, p46+", "+p40+", "+p12+", "+p17);
                setText(oclb, p45+", "+p50+", "+p38+", "+p17+", "+p4+p19);
                setText(nvlb, p45+", "+p50+", "+p17);
                setText(dclb, p39+", "+p52+", "+p17);
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

            }else if ((yearLaunch.equals("1")&& yearStart.equals("-5"))||(yearLaunch.equals("2")&& yearStart.equals("-4"))||(yearLaunch.equals("3")&& yearStart.equals("-3"))||(yearLaunch.equals("4")&& yearStart.equals("-2"))||(yearLaunch.equals("5")&& yearStart.equals("-1"))||(yearLaunch.equals("6")&& (yearStart.equals("Year 1")||yearStart.equals("Tahun 1")||yearStart.equals("Année 1")))||(yearLaunch.equals("7")&& (yearStart.equals("Year 2")||yearStart.equals("Tahun 2")||yearStart.equals("Année 2")))){

                setText(jlb, p17);
                setText(fblb, p33);
                setText(mrlb, p58);
                setText(ablb, p39+", "+p46);
                setText(mylb, p46+", "+p40+", "+p12+", "+p38+", "+p17+", "+p4+p19);
                setText(jnlb, p50+", "+p17);
                setText(jllb, p33);
                setText(aglb, p58);
                setText(splb, p46+", "+p40+", "+p12+", "+p17);
                setText(oclb, p45+", "+p50+", "+p38+", "+p17+", "+p4+p19);
                setText(nvlb, p45+", "+p50+", "+p17);
                setText(dclb, p39+", "+p52+", "+p17);
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

            }else{
                setText(jlb, p17);
                setText(fblb, p33);
                setText(mrlb, p58);
                setText(ablb, p39+", "+p46);
                setText(mylb, p46+", "+p40+", "+p12+", "+p38+", "+p17+", "+p4+p19);
                setText(jnlb, p50+", "+p17);
                setText(jllb, p33);
                setText(aglb, p58);
                setText(splb, p46+", "+p40+", "+p12+", "+p17);
                setText(oclb, p45+", "+p50+", "+p38+", "+p17+", "+p4+p19);
                setText(nvlb, p45+", "+p50+", "+p17);
                setText(dclb, p39+", "+p52+", "+p17);
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