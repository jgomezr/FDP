package org.grameen.fdp.activity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import org.grameen.fdp.R;
import org.grameen.fdp.printer.PrinterService;

import java.io.File;

/**
 * Created by AangJnr on 02, December, 2018 @ 12:21 AM
 * Work Mail cibrahim@grameenfoundation.org
 * Personal mail aang.jnr@gmail.com
 */

public class PrintingActivity extends BaseActivity {

    String fileLocation;
    ImageView imageView;

    PrinterService printerService;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_printing);

        imageView = findViewById(R.id.print_image);

        setToolbar("Print");


        fileLocation = getIntent().getStringExtra("file_location");
        if (fileLocation != null) {
            Picasso.with(this).load(new File(fileLocation)).into(imageView, new Callback() {
                @Override
                public void onSuccess() {

                    printerService = new PrinterService(PrintingActivity.this, fileLocation);
                    printerService.initializeConnection();
                }

                @Override
                public void onError() {

                }
            });
        }

    }
}
