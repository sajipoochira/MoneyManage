package com.mecherycorp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements Home.OnFragmentInteractionListener {
    FragmentManager fragmentmanger ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Home HomeFrag = new Home();


        fragmentmanger = getSupportFragmentManager();

        if (findViewById(R.id.FragContainer) != null) {
            if (savedInstanceState != null) {
                return;
            }

            FragmentTransaction fragmentTransaction = fragmentmanger.beginTransaction();

           fragmentTransaction.add(R.id.FragContainer, HomeFrag, null).commit();

        }


    }

    @Override
    public void onFragmentInteraction(int Selection) {

        Income incomeFragment = new Income();
        Expence expencefragment = new Expence();
        IncomeTable incomeTable = new IncomeTable();

        switch (Selection){
            case 0:
                getSupportFragmentManager().beginTransaction().replace(R.id.FragContainer,incomeFragment,null ).addToBackStack(null).commit();
                break;
            case 1:
                getSupportFragmentManager().beginTransaction().replace(R.id.FragContainer, expencefragment, null).addToBackStack(null).commit();
                break;

            case 2:
                getSupportFragmentManager().beginTransaction().replace(R.id.FragContainer, incomeTable, null).addToBackStack(null).commit();



        }




    }


}
