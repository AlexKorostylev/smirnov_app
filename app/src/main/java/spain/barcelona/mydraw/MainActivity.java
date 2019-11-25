package spain.barcelona.mydraw;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        InterviewListFragment.InterviewListListener,
        PoetryListFragment.PoetryListListener,
        AboutListFragment.AboutListListener,
        TopBtnFragment.FragmentArtListener, ImgClickListener, ChipListener {


    // Global Variable
    static String appBranch = "welcomeBranch"; // start for recycleList Fragment
    static int dayNightMode = 0; // 0 - Day mode; 1 - Night mode.
    static Boolean chipsDisabled = true;

    // Variable for Welcome Branch (welcome and recycle welcome fragment).
    static int periodCurrentStateWelcome = 0;
    static int indexCurrentStateWelcome = 0;
    static int indexAllPeriodWelcome = 0;
    static int startPositionWelcome = 0; // 0 - Full frame mode; 1 - Recycle mode.

    // Variable for Paint Branch (paint and recycle paint fragment).
    static int periodCurrentStatePaint = 0;
    static int indexCurrentStatePaint = 0;
    static int indexAllPeriodPaint = 0; //
    static int indexFirstPeriodPaint = -1;
    static int indexSecondPeriodPaint = -1;
    static int indexThirdPeriodPaint = -1;
    static int indexFoursPeriodPaint = -1;
    static int startPositionPaint = 0;

    // Variable for Graphic Branch (graphic and recycle graphic fragment).
    static int periodCurrentStateGraphic = 0;
    static int indexCurrentStateGraphic = 0;
    static int indexAllPeriodGraphic = 0;
    static int indexFirstPeriodGraphic = -1;
    static int indexSecondPeriodGraphic = -1;
    static int indexThirdPeriodGraphic = -1;
    static int indexFoursPeriodGraphic = -1;
    static int startPositionGraphic = 0;

    // Variable for Photo Branch (paint and recycle paint fragment).
    static int periodCurrentStatePhoto = 0;
    static int indexCurrentStatePhoto = 0;
    static int indexAllPeriodPhoto = 0;
    static int startPositionPhoto = 0;

    // Recycle
    static int positionRecycle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.DarkTheme);
        } else setTheme(R.style.AppTheme);

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

        if(MainActivity.dayNightMode == 0){
            View hView =  navigationView.inflateHeaderView(R.layout.nav_header_main);
            hView.setBackgroundResource(R.drawable.nav_bac_1_white);
        } else {
            View hView =  navigationView.inflateHeaderView(R.layout.nav_header_main);
            hView.setBackgroundResource(R.drawable.nav_bac_1_black);
        }

        if (appBranch.equals("paintingBranch")) {
            setTitle("Живопись");
            if (startPositionPaint == 0) {
                PaintFragment paintingFragment = new PaintFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.top_container, paintingFragment);
                ft.addToBackStack(null);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            } else {
                RecycleTopFragment recycleTopFragment = new RecycleTopFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.top_container, recycleTopFragment);
                ft.addToBackStack(null);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }
        } else if (appBranch.equals("graphicBranch")) {
            setTitle("Графика");
            if (startPositionGraphic == 0) {
                GraphicFragment graphicFragment = new GraphicFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.top_container, graphicFragment);
                ft.addToBackStack(null);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            } else {
                RecycleTopFragment recycleTopFragment = new RecycleTopFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.top_container, recycleTopFragment);
                ft.addToBackStack(null);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }
        } else if (appBranch.equals("interviewBranch")) {
            setTitle("Интервью");
            InterviewListFragment interviewListFragment = new InterviewListFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.top_container, interviewListFragment);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }else if (appBranch.equals("bioBranch")) {
            setTitle("Биография");
            BioFragment bioFragment = new BioFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.top_container, bioFragment);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        } else if (appBranch.equals("poetryBranch")) {
            setTitle("Поэзия");
            PoetryListFragment poetryListFragment = new PoetryListFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.top_container, poetryListFragment);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }else if (appBranch.equals("aboutBranch")) {
            setTitle("Отзывы о творчестве");
            AboutListFragment aboutListFragment = new AboutListFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.top_container, aboutListFragment);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        } else if (appBranch.equals("photoBranch")) {
            setTitle("Фотоархив");
            if (startPositionPhoto == 0) {
                PhotoFragment photoFragment = new PhotoFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.top_container, photoFragment);
                ft.addToBackStack(null);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            } else {
                RecycleTopFragment recycleTopFragment = new RecycleTopFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.top_container, recycleTopFragment);
                ft.addToBackStack(null);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }
        }

        else {
            appBranch = "welcomeBranch";
            if (startPositionWelcome == 0) {
                TopFragment topFragment = new TopFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.top_container, topFragment);
                ft.addToBackStack(null);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            } else {
                RecycleTopFragment recycleTopFragment = new RecycleTopFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.top_container, recycleTopFragment);
                ft.addToBackStack(null);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }
        }
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
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        menu.findItem(R.id.filter_hide).setVisible(false);
        menu.findItem(R.id.background_mode).setTitle("Тёмный фон");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.background_mode:
                if (dayNightMode == 0) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    dayNightMode = 1;
                    restartApp();
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    restartApp();
                    dayNightMode = 0;
                }
                break;
            default:
                break;
        }
        return false;
    }

    public void restartApp() {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_painting) {
            appBranch = "paintingBranch";
            if (startPositionPaint == 0) {
                PaintFragment paintingFragment = new PaintFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.top_container, paintingFragment);
                ft.addToBackStack(null);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            } else {
                RecycleTopFragment recycleTopFragment = new RecycleTopFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.top_container, recycleTopFragment);
                ft.addToBackStack(null);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }

        } else if (id == R.id.nav_graphics) {
            appBranch = "graphicBranch";
            if (startPositionGraphic == 0) {
                GraphicFragment graphicFragment = new GraphicFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.top_container, graphicFragment);
                ft.addToBackStack(null);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            } else {
                RecycleTopFragment recycleTopFragment = new RecycleTopFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.top_container, recycleTopFragment);
                ft.addToBackStack(null);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }

        } else if (id == R.id.nav_poetry) {
            appBranch = "poetryBranch";
            PoetryListFragment poetryListFragment = new PoetryListFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.top_container, poetryListFragment);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();

        } else if (id == R.id.nav_interview) {
            appBranch = "interviewBranch";
            InterviewListFragment interviewListFragment = new InterviewListFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.top_container, interviewListFragment);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();

        } else if (id == R.id.nav_camera) {
            appBranch = "photoBranch";
            if (startPositionPhoto == 0) {
                PhotoFragment photoFragment = new PhotoFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.top_container, photoFragment);
                ft.addToBackStack(null);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            } else {
                RecycleTopFragment recycleTopFragment = new RecycleTopFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.top_container, recycleTopFragment);
                ft.addToBackStack(null);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }

        } else if (id == R.id.nav_biography) {
            appBranch = "bioBranch";
            BioFragment bioFragment = new BioFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.top_container, bioFragment);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();

        } else if (id == R.id.nav_about) {
            appBranch = "aboutBranch";
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

    public void imgClick() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        DetailPicFragment detailFragment = new DetailPicFragment();
        ft.replace(R.id.top_container, detailFragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    public void chipClick() {
        RecycleTopFragment recycleTopFragment = new RecycleTopFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.top_container, recycleTopFragment);
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }


}
