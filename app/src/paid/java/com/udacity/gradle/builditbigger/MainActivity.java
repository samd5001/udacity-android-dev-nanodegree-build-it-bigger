package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.samdunkley.android.displayjokelibrary.DisplayJokeActivity;

public class MainActivity extends BaseMainActivity implements MainActivityInterface {

    public void tellJoke(View view) {
        new JokesAsyncTask().execute(this);
    }

    @Override
    public void handleJokeLoaded(String joke) {
        showJoke(joke);
    }

}
