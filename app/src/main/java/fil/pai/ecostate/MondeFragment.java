package fil.pai.ecostate;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

    public class MondeFragment extends Fragment {

    public static MondeFragment newInstance() {
        MondeFragment fragment = new MondeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_stats_monde, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final Button Buttonmoi = getView().findViewById(R.id.button);
        Buttonmoi.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Buttonmoi.setPressed(true);
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.activity_main, StatsFragment.newInstance());
                transaction.commit();
            }
        });
    }
}
