package spain.barcelona.mydraw;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, InterviewListFragment.InterviewListListener, PoetryListFragment.PoetryListListener, AboutListFragment.AboutListListener, TopBtnFragment.FragmentArtListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Фрагмент открывающийся при начальной загрузке
        TopFragment topFragment = new TopFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.top_container, topFragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_painting) {
            PaintFragment paintingFragment = new PaintFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.top_container, paintingFragment);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();

        } else if (id == R.id.nav_graphics) {
            GraphicFragment graphicFragment = new GraphicFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.top_container, graphicFragment);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();

        } else if (id == R.id.nav_poetry) {
            PoetryListFragment poetryListFragment = new PoetryListFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.top_container, poetryListFragment);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();

        } else if (id == R.id.nav_interview) {
            // InterviewFragment interviewFragment = new InterviewFragment();
            InterviewListFragment interviewListFragment = new InterviewListFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.top_container, interviewListFragment);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();

        } else if (id == R.id.nav_camera) {
            PhotoFragment photoFragment = new PhotoFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.top_container, photoFragment);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();

        } else if (id == R.id.nav_biography) {
            BioFragment bioFragment = new BioFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.top_container, bioFragment);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();

        } else if (id == R.id.nav_about) {
            AboutListFragment aboutListFragment = new AboutListFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.top_container, aboutListFragment);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void itemClickedInterview(long id) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        InterviewDetailFragment interviewDetailFragment = new InterviewDetailFragment();
        interviewDetailFragment.setInterviewId(id);
        ft.replace(R.id.top_container, interviewDetailFragment);
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
/*        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }*/

    }

    @Override
    public void itemClickedPoetry(long id) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        PoetryDetailFragment poetryDetailFragment = new PoetryDetailFragment();
        poetryDetailFragment.setPoetryId(id);
        ft.replace(R.id.top_container, poetryDetailFragment);
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }

    @Override
    public void itemClickedAbout(long id) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        AboutDetailFragment AboutDetailFragment = new AboutDetailFragment();
        AboutDetailFragment.setAboutId(id);
        ft.replace(R.id.top_container, AboutDetailFragment);
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }

    @Override
    public void itemClickedArtListener(String fragment_name) {
        switch (fragment_name) {
            case "живопись":
                PaintFragment paintingFragment = new PaintFragment();
                FragmentTransaction ftp = getFragmentManager().beginTransaction();
                ftp.replace(R.id.top_container, paintingFragment);
                ftp.addToBackStack(null);
                ftp.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ftp.commit();
                break;
            case "графика":
                GraphicFragment graphicFragment = new GraphicFragment();
                FragmentTransaction ftg = getFragmentManager().beginTransaction();
                ftg.replace(R.id.top_container, graphicFragment);
                ftg.addToBackStack(null);
                ftg.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ftg.commit();
                break;

        }
    }


}
