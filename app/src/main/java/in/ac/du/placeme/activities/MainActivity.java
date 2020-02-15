package in.ac.du.placeme.activities;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.Arrays;
import java.util.List;

import in.ac.du.placeme.R;
import in.ac.du.placeme.ui.HomeFragment;
import in.ac.du.placeme.ui.JobFragment;
import in.ac.du.placeme.ui.AlumniFragment;
import in.ac.du.placeme.ui.ForumFragment;
import in.ac.du.placeme.ui.SettingsFragment;

public class MainActivity extends AppCompatActivity {

    private NavigationView navView;
    private DrawerLayout layout;
    private Toolbar toolbar;
    private List<String> headers = Arrays.asList("Home", "Jobs", "Alumni", "Discuss", "Settings");
    private List<Fragment> fragments = Arrays.asList(new HomeFragment(), new JobFragment(), new AlumniFragment(), new ForumFragment(), new SettingsFragment());

    void loadFragment(String title, Fragment fragment) {
        toolbar.setTitle(title);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_view, fragment).addToBackStack(title).commit();
    }

    @Override public void onBackPressed() {
        super.onBackPressed(); if(getSupportFragmentManager().getBackStackEntryCount()==0) finish();
        else {
            int lastIndex = getSupportFragmentManager().getBackStackEntryCount()-1;
            FragmentManager.BackStackEntry entry = getSupportFragmentManager().getBackStackEntryAt(lastIndex);
            toolbar.setTitle(entry.getName()); navView.getMenu().getItem(headers.indexOf(entry.getName())).setChecked(true);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar); setSupportActionBar(toolbar);

        layout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, layout, toolbar, R.string.drawer_open, R.string.drawer_close);
        toggle.syncState(); layout.closeDrawer(GravityCompat.START);

        NavigationView nav_view = findViewById(R.id.nav_view);
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home: loadFragment(headers.get(0), fragments.get(0)); break;
                    case R.id.navigation_jobs: loadFragment(headers.get(1), fragments.get(1)); break;
                    case R.id.navigation_alumni: loadFragment(headers.get(2), fragments.get(2)); break;
                    case R.id.navigation_forum: loadFragment(headers.get(3), fragments.get(3)); break;
                    case R.id.navigation_settings: loadFragment(headers.get(4), fragments.get(4)); break;
                    default: return false;
                }
                layout.closeDrawer(GravityCompat.START); return true;
            }
        });

        //BottomNavigationView navView = findViewById(R.id.bottom_nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        //AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
        //        R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
        //        .build();
        //NavController navController = Navigation.findNavController(this, R.id.bottom_nav_view);
        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        //NavigationUI.setupWithNavController(navView, navController);
    }

}
