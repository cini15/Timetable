package by.bsac.timetable;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.Toast;

import by.bsac.timetable.resourc.BDWorker;
import by.bsac.timetable.resourc.records.WeeksManager;

import by.bsac.timetable.page_adapter.SectionsPagerAdapter;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class WorkSpace extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private String val_NameGroup;
    private int val_Group;
    private int val_thisWeek;
    private SharedPreferences sharedPreferences;
    private BDWorker bdWorker;
    private WeeksManager weeksManager;


    private ViewPager mViewPager;
    private SectionsPagerAdapter mSectionsPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable_workspase);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarSpace);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener( this);


        sharedPreferences = getSharedPreferences("APP_PREFF", Context.MODE_PRIVATE);


        loadDataGroup();
        bdWorker = new BDWorker(this);
        Cursor cursor = bdWorker.gerData(val_Group);
        printCursorToLogi(cursor);
        weeksManager = new WeeksManager();
        weeksManager.InitializationManager(cursor);


        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        mSectionsPagerAdapter.setWeek(weeksManager.getWeeks(val_thisWeek));

//        try {
//            System.out.println(new ParsTest().execute().get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }


    }


    @Override
    protected void onResume() {
        super.onResume();

        loadDataGroup();
        bdWorker = new BDWorker(this);
        Cursor cursor = bdWorker.gerData(val_Group);
        printCursorToLogi(cursor);
        weeksManager = new WeeksManager();
        weeksManager.InitializationManager(cursor);
        mSectionsPagerAdapter.setWeek(weeksManager.getWeeks(val_thisWeek));
        mSectionsPagerAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.icon_group:

                Intent intent = new Intent(this, SelectGroup.class);
                startActivity(intent);

                return true;
//            case R.id.nowkeek:
//
//                mSectionsPagerAdapter= new SectionsPagerAdapter(getSupportFragmentManager());
//                mSectionsPagerAdapter.setWeek(weeksManager.getWeeks(val_thisWeek));
//                mViewPager.setAdapter(mSectionsPagerAdapter);
//
//                //weeksManager.WriteWeek(val_thisWeek, this);
//                Toast.makeText(this, "Выбор недели: (текущая)" + (val_thisWeek + 1), Toast.LENGTH_SHORT).show();
//
//
//                return true;
//
//            case R.id.week1:
//             //   mSectionsPagerAdapter= new SectionsPagerAdapter(getSupportFragmentManager());
//             //   mViewPager.setAdapter(mSectionsPagerAdapter);
//                mSectionsPagerAdapter.setWeek(weeksManager.getWeeks(0));
//                mSectionsPagerAdapter.notifyDataSetChanged();
//                //weeksManager.WriteWeek(0, this);
//                Toast.makeText(this, "Выбор недели: " + 1, Toast.LENGTH_SHORT).show();
//
//                return true;
//            case R.id.week2:
//
//                mSectionsPagerAdapter.setWeek(weeksManager.getWeeks(1));
//                mSectionsPagerAdapter.notifyDataSetChanged();
//                //weeksManager.WriteWeek(1, this);
//                Toast.makeText(this, "Выбор недели: " + 2, Toast.LENGTH_SHORT).show();
//
//
//                return true;
//            case R.id.week3:
//                mSectionsPagerAdapter.setWeek(weeksManager.getWeeks(2));
//                mSectionsPagerAdapter.notifyDataSetChanged();
//                //weeksManager.WriteWeek(2, this);
//                Toast.makeText(this, "Выбор недели: " + 3, Toast.LENGTH_SHORT).show();
//
//
//                return true;
//            case R.id.week4:
//                mSectionsPagerAdapter.setWeek(weeksManager.getWeeks(3));
//                mSectionsPagerAdapter.notifyDataSetChanged();
//                //weeksManager.WriteWeek(3, this);
//                Toast.makeText(this, "Выбор недели: " + 4, Toast.LENGTH_SHORT).show();
//
//                return true;


            case R.id.action_settings:

                return true;

            case R.id.action_info:

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Информация")
                        .setMessage("Тут будет что-то информативное.")
                        .setIcon(R.mipmap.ic_launcher)
                        .setCancelable(false)
                        .setNegativeButton("ОК, понятно",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                AlertDialog alert = builder.create();
                alert.show();

                return true;
            case R.id.action_update:

                return true;



            default:
                return super.onOptionsItemSelected(item);

        }
    }

    private void loadThisWeek() {
        int thisWeek;

        Calendar calendar = new GregorianCalendar();
        Calendar calendarBegin = new GregorianCalendar(calendar.get(Calendar.YEAR), 8, 0);
        thisWeek = calendar.get(Calendar.WEEK_OF_YEAR);
        int firstSept = calendarBegin.get(Calendar.WEEK_OF_YEAR);
        Log.d("week: ", Integer.toString(thisWeek));
        thisWeek = Math.abs((thisWeek - firstSept) % 4);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("thisWeek", thisWeek);
        editor.apply();

        Log.d("week: ", Integer.toString(firstSept));
        Log.d("week: ", Integer.toString(thisWeek));
        val_thisWeek = thisWeek;
    }

    private void loadDataGroup() {

        loadThisWeek();
        val_Group = sharedPreferences.getInt("id_group", 0);
        val_NameGroup = sharedPreferences.getString("name_group", "");
        val_thisWeek = sharedPreferences.getInt("thisWeek", -1);

        getSupportActionBar().setTitle("Группа: " + val_NameGroup);
        getSupportActionBar().setSubtitle("текущая неделя: " + (val_thisWeek + 1));

        if (val_NameGroup != null && val_Group != 0) {
            Toast.makeText(this, "Ваша группа: " + val_NameGroup + " Неделя: " + (val_thisWeek + 1), Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, "Ваша группа не выбрана. ", Toast.LENGTH_SHORT).show();
    }


    private void printCursorToLogi(Cursor c) {

        String LOG_TAG = "my_Logi";
        Log.d(LOG_TAG, Integer.toString(val_Group));
        Log.d(LOG_TAG, "start");
        if (c != null) {
            if (c.moveToFirst()) {
                String str;
                do {
                    str = "";
                    for (String cn : c.getColumnNames()) {
                        str = str.concat(cn + " = " + c.getString(c.getColumnIndex(cn)) + "; ");
                    }
                    Log.d(LOG_TAG, str);
                } while (c.moveToNext());
            }
        } else
            Log.d(LOG_TAG, "Cursor is null");

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.icon_group:

                Intent intent = new Intent(this, SelectGroup.class);
                startActivity(intent);

                return true;
            case R.id.nowkeek:

                mSectionsPagerAdapter= new SectionsPagerAdapter(getSupportFragmentManager());
                mSectionsPagerAdapter.setWeek(weeksManager.getWeeks(val_thisWeek));
                mViewPager.setAdapter(mSectionsPagerAdapter);

                //weeksManager.WriteWeek(val_thisWeek, this);
                Toast.makeText(this, "Выбор недели: (текущая)" + (val_thisWeek + 1), Toast.LENGTH_SHORT).show();


                return true;

            case R.id.week1:
                //   mSectionsPagerAdapter= new SectionsPagerAdapter(getSupportFragmentManager());
                //   mViewPager.setAdapter(mSectionsPagerAdapter);
                mSectionsPagerAdapter.setWeek(weeksManager.getWeeks(0));
                mSectionsPagerAdapter.notifyDataSetChanged();
                //weeksManager.WriteWeek(0, this);
                Toast.makeText(this, "Выбор недели: " + 1, Toast.LENGTH_SHORT).show();

                return true;
            case R.id.week2:

                mSectionsPagerAdapter.setWeek(weeksManager.getWeeks(1));
                mSectionsPagerAdapter.notifyDataSetChanged();
                //weeksManager.WriteWeek(1, this);
                Toast.makeText(this, "Выбор недели: " + 2, Toast.LENGTH_SHORT).show();


                return true;
            case R.id.week3:
                mSectionsPagerAdapter.setWeek(weeksManager.getWeeks(2));
                mSectionsPagerAdapter.notifyDataSetChanged();
                //weeksManager.WriteWeek(2, this);
                Toast.makeText(this, "Выбор недели: " + 3, Toast.LENGTH_SHORT).show();


                return true;
            case R.id.week4:
                mSectionsPagerAdapter.setWeek(weeksManager.getWeeks(3));
                mSectionsPagerAdapter.notifyDataSetChanged();
                //weeksManager.WriteWeek(3, this);
                Toast.makeText(this, "Выбор недели: " + 4, Toast.LENGTH_SHORT).show();

                return true;


//            case R.id.action_settings:
//
//                return true;
//
//            case R.id.action_info:
//
//                AlertDialog.Builder builder = new AlertDialog.Builder(this);
//                builder.setTitle("Информация")
//                        .setMessage("Тут будет что-то информативное.")
//                        .setIcon(R.mipmap.ic_launcher)
//                        .setCancelable(false)
//                        .setNegativeButton("ОК, понятно",
//                                new DialogInterface.OnClickListener() {
//                                    public void onClick(DialogInterface dialog, int id) {
//                                        dialog.cancel();
//                                    }
//                                });
//                AlertDialog alert = builder.create();
//                alert.show();
//
//                return true;


            default:
                return super.onOptionsItemSelected(item);

        }
    }
    private class ParsTest extends AsyncTask<Void,Void,String>{

        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String resultJson = "";
        final String URL="http://192.168.1.7:8000/api";
        final String facultyURL="/faculty";
        final String chairURL="/chairs";
        final String recordURL="/records";

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL("http://192.168.1.7:8000/api/chairs");

                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();

                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }

                resultJson = buffer.toString();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return resultJson;
        }
    }
}
