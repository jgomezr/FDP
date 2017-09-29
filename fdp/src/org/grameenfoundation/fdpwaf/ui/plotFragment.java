package org.grameenfoundation.fdpwaf.ui;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.grameenfoundation.fdpwaf.R;


/**
 * Created by julian_Gf on 12/17/2016.
 */

public class plotFragment extends Fragment  {
    public String renovSize;
    public EditText ph,lime,fillingP,geneticP,gapP,soilFertMng,fcondP,ageP,area,reco;
    public Button calc;
    public Spinner cteP,plantP,tehelP,debDiP,pruniP,pesDiP,weediP,harveP,shadeP,soilCP,orgMaP,fertFP,fertAP,renov,renovReason,renovYear,hire;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.plot_fragment, container, false);
        ph = (EditText) view.findViewById(R.id.ph_field);
        lime = (EditText) view.findViewById(R.id.limeP_field);
        fillingP = (EditText) view.findViewById(R.id.fillingP_field);
        geneticP = (EditText) view.findViewById(R.id.geneticP_field);
        gapP = (EditText) view.findViewById(R.id.gapP_field);
        soilFertMng = (EditText) view.findViewById(R.id.soilFertMng_field);
        fcondP = (EditText) view.findViewById(R.id.farmConditionP_field);
        ageP = (EditText) view.findViewById(R.id.plotAgep_field);
        cteP = (Spinner) view.findViewById(R.id.cocoaTreesP_field);
        plantP = (Spinner) view.findViewById(R.id.plantingP_field);
        tehelP = (Spinner) view.findViewById(R.id.treeHealthP_field);
        debDiP = (Spinner) view.findViewById(R.id.debilitationP_field);
        pruniP = (Spinner) view.findViewById(R.id.pruningP_field);
        pesDiP = (Spinner) view.findViewById(R.id.pestDiseaseP_field);
        weediP = (Spinner) view.findViewById(R.id.weedingP_field);
        harveP = (Spinner) view.findViewById(R.id.harvestingP_field);
        shadeP = (Spinner) view.findViewById(R.id.shadeManagementP_field);
        soilCP = (Spinner) view.findViewById(R.id.soilConditionP_field);
        orgMaP = (Spinner) view.findViewById(R.id.organicMatterP_field);
        fertFP = (Spinner) view.findViewById(R.id.fertFormP_field);
        fertAP = (Spinner) view.findViewById(R.id.fertApplicationP_field);
        calc = (Button) view.findViewById(R.id.calculateP);
        renov = (Spinner) view.findViewById(R.id.renovated_field);
        renovReason = (Spinner) view.findViewById(R.id.reason_field);
        renovYear = (Spinner) view.findViewById(R.id.howLong_field);
        area = (EditText) view.findViewById(R.id.plotArea_field);
        hire = (Spinner) view.findViewById(R.id.hireP_field);
        reco = (EditText) view.findViewById(R.id.reco_field);

        ph.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (String.valueOf(ph.getText()).isEmpty()){
                    setText(lime,"N/A");
                }else if (Double.parseDouble(ph.getText().toString()) > 5.7){
                    setText(lime,getString(R.string.cancel));
                }else{
                    setText(lime,getString(R.string.yes));
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        cteP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (cteP.getSelectedItem().toString().equals("3x2.5")||cteP.getSelectedItem().toString().equals("3x3")||cteP.getSelectedItem().toString().equals("2x4")||cteP.getSelectedItem().toString().equals("3x3.5")||cteP.getSelectedItem().toString().equals("2.5x3")||cteP.getSelectedItem().toString().equals("2.5x3.5")||cteP.getSelectedItem().toString().equals("2.5x4")||cteP.getSelectedItem().toString().equals("3.5x3.5")||cteP.getSelectedItem().toString().equals("3x4")){
                    setText(fillingP,"No");
                }else {
                    setText(fillingP,getString(R.string.yes));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (plantP.getSelectedItem().toString().equals("B")) {
                    setText(geneticP, "B");
                }else if(plantP.getSelectedItem().toString().equals("M")){
                    setText(geneticP, "M");
                }else {
                    setText(geneticP, "G");
                }
                if ((cteP.getSelectedItem().toString().equals("2x2")||cteP.getSelectedItem().toString().equals("2.5x2.5")||cteP.getSelectedItem().toString().equals("3.5x4")||cteP.getSelectedItem().toString().equals("4x4")||cteP.getSelectedItem().toString().equals("2x2.5")||cteP.getSelectedItem().toString().equals("2x3")||cteP.getSelectedItem().toString().equals("2x3.5"))||(Double.parseDouble(ageP.getText().toString()) > 30)||(tehelP.getSelectedItem().toString().equals("B"))||(debDiP.getSelectedItem().toString().equals("B"))) {
                    setText(fcondP, "B");
                }else{
                    setText(fcondP, "G");
                }
                if (pruniP.getSelectedItem().toString().equals("B")||pesDiP.getSelectedItem().toString().equals("B")||weediP.getSelectedItem().toString().equals("B")||harveP.getSelectedItem().toString().equals("B")||shadeP.getSelectedItem().toString().equals("B")){
                    setText(gapP,"B");
                }else if(pruniP.getSelectedItem().toString().equals("M")||pesDiP.getSelectedItem().toString().equals("M")){
                    setText(gapP,"M");
                }else{
                    setText(gapP, "G");
                }
                if (soilCP.getSelectedItem().toString().equals("B")||orgMaP.getSelectedItem().toString().equals("B")||fertFP.getSelectedItem().toString().equals("B")||fertAP.getSelectedItem().toString().equals("B")){
                    setText(soilFertMng,"B");
                }else if (fertFP.getSelectedItem().toString().equals("M")||fertAP.getSelectedItem().toString().equals("M")||orgMaP.getSelectedItem().toString().equals("M")){
                    setText(soilFertMng,"M");
                }else{
                    setText(soilFertMng,"G");
                }

                recommendation();
                ((plotActivity)getActivity()).partialSave();
            }
        });

        renov.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (renov.getSelectedItem().toString().equals("Yes")||renov.getSelectedItem().toString().equals("Oui")){
                    renovReason.setEnabled(true);
                    renovYear.setEnabled(true);
                    fillingP.setEnabled(false);
                    geneticP.setEnabled(false);
                    gapP.setEnabled(false);
                    soilFertMng.setEnabled(false);
                    fcondP.setEnabled(false);
                    ageP.setEnabled(false);
                    cteP.setEnabled(false);
                    plantP.setEnabled(false);
                    tehelP.setEnabled(false);
                    debDiP.setEnabled(false);
                    pruniP.setEnabled(false);
                    pesDiP.setEnabled(false);
                    weediP.setEnabled(false);
                    harveP.setEnabled(false);
                    shadeP.setEnabled(false);
                    soilCP.setEnabled(false);
                    orgMaP.setEnabled(false);
                    fertFP.setEnabled(false);
                    fertAP.setEnabled(false);
                    if(Double.parseDouble(area.getText().toString())>Double.parseDouble(renovSize)){
                        area.setBackgroundColor(Color.parseColor("#cc0000"));
                        Toast.makeText(getActivity().getApplicationContext(), getString(R.string.renovatedAreaHiger), Toast.LENGTH_SHORT).show();
                    }
                }else{
                    renovReason.setEnabled(false);
                    renovYear.setEnabled(false);
                    fillingP.setEnabled(true);
                    geneticP.setEnabled(true);
                    gapP.setEnabled(true);
                    soilFertMng.setEnabled(true);
                    fcondP.setEnabled(true);
                    ageP.setEnabled(true);
                    cteP.setEnabled(true);
                    plantP.setEnabled(true);
                    tehelP.setEnabled(true);
                    debDiP.setEnabled(true);
                    pruniP.setEnabled(true);
                    pesDiP.setEnabled(true);
                    weediP.setEnabled(true);
                    harveP.setEnabled(true);
                    shadeP.setEnabled(true);
                    soilCP.setEnabled(true);
                    orgMaP.setEnabled(true);
                    fertFP.setEnabled(true);
                    fertAP.setEnabled(true);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }

    public void recommendation(){
        if (fcondP.getText().toString().equals("B")||(Integer.parseInt(ageP.getText().toString()) > 30)) {
            //Replant
            if (soilFertMng.getText().toString().equals("B")||soilFertMng.getText().toString().equals("M")) {
                setText(reco,"replanting+extra");
            } else {
                setText(reco,"replanting");
            }

        } else if ((fcondP.getText().toString().equals("G") && (geneticP.getText().toString().equals("B")||geneticP.getText().toString().equals("M"))) || ((Integer.parseInt(ageP.getText().toString()) > 25) && (Integer.parseInt(ageP.getText().toString()) < 31))) {
            //Graft
            if (soilFertMng.getText().toString().equals("B")||soilFertMng.getText().toString().equals("M")) {
                setText(reco,"grafting+extra");
            } else {
                setText(reco,"grafting");
            }

        } else if (soilFertMng.getText().toString().equals("B")||soilFertMng.getText().toString().equals("M")) {
            //Extra Soil Management
            setText(reco,"extra");

        } else {
            setText(reco,"gap");
        }

    }

    public void setrenovSize(String rs){
        renovSize = rs;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private void setText(EditText textField, String text) {
        if (textField != null) {
            textField.setText(text);
        }
    }
}