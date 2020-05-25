package com.samdunkley.android.displayjokelibrary;

import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.JokesAsyncTask;
import com.udacity.gradle.builditbigger.MainActivityInterface;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class JokesAsyncTaskTest {

    @Test
    public void testAsyncTask_Success() {

        String result = null;
        JokesAsyncTask task = new JokesAsyncTask();
        task.execute(new MainActivityInterface() {
            @Override
            public void handleJokeLoaded(String joke) {
                assertNotNull(joke);
            }
        });
        try {
            result = task.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(result);
    }
}
