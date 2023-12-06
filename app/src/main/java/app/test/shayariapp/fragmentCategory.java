package app.test.shayariapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.zip.Inflater;

import app.test.shayariapp.adapter.categoryAdapter;
import app.test.shayariapp.model.categoryModel;


public class fragmentCategory extends Fragment {
RecyclerView recyclerView;

    public fragmentCategory() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_category, container, false);
        categoryModel[] mylistdata=new categoryModel[]
                {
                     new categoryModel("જિંદગી શાયરી",R.drawable.flowers),
                     new categoryModel("પ્રેમ શાયરી",R.drawable.love),
                     new categoryModel("રોમેન્ટિક શાયરી",R.drawable.table),
                     new categoryModel("દુઃખ દાયક શાયરી",R.drawable.sad),
                     new categoryModel("મિસ યુ શાયરી",R.drawable.missyou),
                     new categoryModel("દોસ્તી શાયરી",R.drawable.friend),
                     new categoryModel("માં-બાપ શાયરી",R.drawable.family),
                     new categoryModel("જન્મદિવસ શાયરી",R.drawable.funny),
                     new categoryModel("goog night શાયરી",R.drawable.sleeping),
                     new categoryModel("એટીટુડ શાયરી",R.drawable.trust),
                     new categoryModel("વિશ્વાસ શાયરી",R.drawable.attitude),
                };
        recyclerView=rootView.findViewById(R.id.recyclerView_category);
        categoryAdapter adapter = new categoryAdapter(mylistdata,getContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        return rootView;
    }
}