package fil.pai.ecostate;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.bumptech.glide.load.model.Model;
import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;
import java.util.List;

import fil.pai.ecostate.model.AstucesAdapter;
import fil.pai.ecostate.model.AstucesModel;
import fil.pai.ecostate.model.Cards;
import fil.pai.ecostate.model.Modele;

public class AstuceFragment extends Fragment {

    private ArrayList<String> al;
    private ArrayList<AstucesModel> ast;
    private ArrayAdapter<String> arrayAdapter;
    private ArrayAdapter<AstucesModel> adapter;
    private int i;
    private ListView listView;
    private List<Cards> rowItems;

    public static AstuceFragment newInstance() {
        AstuceFragment fragment = new AstuceFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_astuce, container, false);
    }

    public void initMyData(){
        ast.addAll(Modele.getInstance().getmAstuces());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ast = new ArrayList<AstucesModel>();
        initMyData();
        adapter = new AstucesAdapter(ast, getContext());

        arrayAdapter = new ArrayAdapter<>(getActivity(), R.layout.item, R.id.helloText, al);
        SwipeFlingAdapterView flingContainer = getView().findViewById(R.id.frame);

        flingContainer.setAdapter(adapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                Log.d("LIST", "removed object!");
                ast.remove(0);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object dataObject) {Log.d("tag", "left");}

            @Override
            public void onRightCardExit(Object dataObject) {}

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
                initMyData();
                arrayAdapter.notifyDataSetChanged();
                Log.d("LIST", "notified");
                i++;
            }

            @Override
            public void onScroll(float scrollProgressPercent) {}
        });
        flingContainer.setOnItemClickListener((itemPosition, dataObject) -> Toast.makeText(getActivity(), "Clicked!", Toast.LENGTH_SHORT).show());
    }
}
