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
        setText(jlb, p16+p19+p24);
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
