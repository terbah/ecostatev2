package fil.pai.ecostate.model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import fil.pai.ecostate.R;

public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.ViewHolder> {

    private List<Quiz> mQuiz;

    public QuizAdapter(List<Quiz> quiz) {
        mQuiz = quiz;
    }

    @NonNull
    @Override
    public QuizAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View newsView = inflater.inflate(R.layout.news, parent, false);
        ViewHolder vh = new ViewHolder(newsView);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull QuizAdapter.ViewHolder vh, int i) {
        Quiz quiz = mQuiz.get(i);
        vh.caption.setText(quiz.getCaption());
    }

    @Override
    public int getItemCount() {
        return mQuiz.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView caption;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            caption = itemView.findViewById(R.id.caption);
        }

    }
}