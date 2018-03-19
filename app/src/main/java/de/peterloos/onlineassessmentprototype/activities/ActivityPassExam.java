package de.peterloos.onlineassessmentprototype.activities;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import de.peterloos.onlineassessmentprototype.R;
import de.peterloos.onlineassessmentprototype.adapters.SingleAssessmentPagerAdapter;
import de.peterloos.onlineassessmentprototype.fragments.FragmentQuestion;

public class ActivityPassExam extends AppCompatActivity  implements FragmentQuestion.OnQuestionAnsweredListener {

    /**
     * The android.support.v4.view.PagerAdapter that will provide
     * fragments for each of the sections. We use a
     * FragmentPagerAdapter derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a android.support.v4.app.FragmentStatePagerAdapter
     */
    private ViewPager viewPager;
    private SingleAssessmentPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_pass_exam);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.setSupportActionBar(toolbar);

        // create the adapter that will return a fragment for each question
        this.pagerAdapter = new SingleAssessmentPagerAdapter(this.getSupportFragmentManager());

        // setup the ViewPager with the question adapter
        this.viewPager = (ViewPager) this.findViewById(R.id.container);
        this.viewPager.setAdapter(this.pagerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_pass_exam, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void answerSelected(int questionNumber, int answerPosition, boolean checked) {

        Toast.makeText(
                this.getBaseContext(),
                "Question No. " + questionNumber + ", Answer No. " + answerPosition + ": Checked = " + checked,
                Toast.LENGTH_LONG).show();

        pagerAdapter.updateAnswer(questionNumber, answerPosition, checked);
    }
}
