package fil.pai.ecostate;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fil.pai.ecostate.model.DefiAdapter;
import fil.pai.ecostate.model.Modele;

public class DefiCommunautaireFragment extends Fragment {

    public static DefiCommunautaireFragment newInstance() {
        return new DefiCommunautaireFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_defi_communautaire, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        RecyclerView rv = getView().findViewById(R.id.recycler_cards);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),3);
        rv.setLayoutManager(layoutManager);

        rv.setAdapter(new DefiAdapter(getActivity(), Modele.getInstance().getmDefis()));

    }
}
