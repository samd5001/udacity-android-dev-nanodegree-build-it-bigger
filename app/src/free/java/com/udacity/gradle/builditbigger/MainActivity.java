package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends BaseMainActivity implements MainActivityInterface {

    private InterstitialAd interstitialAd;
    private String joke;

    @Override
    public void handleJokeLoaded(String joke) {
        this.joke = joke;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MobileAds.initialize(this, "");
        setupInterstitialAd();
    }

    private void setupInterstitialAd() {
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        getNewAd();

        findViewById(R.id.joke_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new JokesAsyncTask().execute(MainActivity.this);
                if (interstitialAd.isLoaded()) {
                    interstitialAd.show();
                } else if (joke != null) {
                    MainActivity.this.showJoke(joke);
                }
            }
        });

        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                getNewAd();
                if (joke != null) {
                    MainActivity.this.showJoke(joke);
                }
            }
        });
    }

    private void getNewAd() {
        if (!interstitialAd.isLoading()) {
            AdRequest adRequest = new AdRequest.Builder()
                    .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                    .build();

            interstitialAd.loadAd(adRequest);
        }
    }

}
