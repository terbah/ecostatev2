package fil.pai.ecostate;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import fil.pai.ecostate.model.Modele;
import fil.pai.ecostate.model.News;
import fil.pai.ecostate.model.NewsAdapter;

public class NewsFragment extends Fragment {

    private List<News> ln = Modele.getInstance().getListNews();

    public static NewsFragment newInstance() {
        NewsFragment fragment = new NewsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Quiz q1 = new Quiz("Quelle est la quantité de mégôts jetées annuellement en France ?");

        NewsAdapter na = new NewsAdapter(ln);
        RecyclerView rv = getView().findViewById(R.id.listrecycler);
        rv.setAdapter(na);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));

        if (Modele.getInstance().getCurrentQuiz() == Modele.QUIZ_DONE) {
            Fragment childFragment = new QuizDoneFragment();
            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
            transaction.add(R.id.fragment_news_done, childFragment).commit();
        } else {
            Fragment childFragment = new QuizFragment();
            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
            transaction.add(R.id.fragment_news_done, childFragment).commit();
        }
    }
}
