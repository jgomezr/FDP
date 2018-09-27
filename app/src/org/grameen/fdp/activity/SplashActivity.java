package org.grameen.fdp.activity;

import android.animation.Animator;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.grameen.fdp.R;
import org.grameen.fdp.utility.Constants;

import static java.lang.Thread.sleep;

/**
 * Created by aangjnr on 17/06/2017.
 */

public class SplashActivity extends AppCompatActivity {

    ImageView image1;
    LinearLayout textLayout;
    String TAG = SplashActivity.class.getSimpleName();


    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        setContentView(R.layout.activity_splash);


        textLayout = (LinearLayout) findViewById(R.id.ll1);

        image1 = (ImageView) findViewById(R.id.image_view1);

       /* image1.setTranslationY(Utils.getScreenHeight(this));
        image2.setTranslationY(image1.getHeight());*/

        image1.setAlpha(0f);
        textLayout.setTranslationY(-100f);
        textLayout.setAlpha(0f);


        startAnimations();


    }

    private void startAnimations() {

        image1.animate()
                .alpha(1f)
                .setDuration(1500)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {


                        textLayout.animate()
                                .translationY(0)
                                .alpha(1f)
                                .setDuration(500)
                                .setListener(new Animator.AnimatorListener() {
                                    @Override
                                    public void onAnimationStart(Animator animation) {

                                    }

                                    @Override
                                    public void onAnimationEnd(Animator animation) {
                                        try {
                                            int waited = 0;
                                            // Splash screen pause time
                                            while (waited < 1000) {
                                                sleep(100);
                                                waited += 100;
                                            }


                                            moveToNextActivity();
                                            // startActivity(new Intent(SplashActivity.this, LoginActivity.class));


                                        } catch (InterruptedException e) {
                                            // do nothing
                                        } finally {
                                            supportFinishAfterTransition();

                                        }


                                    }

                                    @Override
                                    public void onAnimationCancel(Animator animation) {

                                    }

                                    @Override
                                    public void onAnimationRepeat(Animator animation) {

                                    }
                                })
                                .setStartDelay(200)
                                .start();
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                }).start();


    }

    private void moveToNextActivity() {


        if (!PreferenceManager.getDefaultSharedPreferences(this).getBoolean(Constants.IS_USER_SIGNED_IN, false))
            startActivity(new Intent(this, LoginActivity.class));
        else
            startActivity(new Intent(this, LandingPageActivity.class));


    }


}
