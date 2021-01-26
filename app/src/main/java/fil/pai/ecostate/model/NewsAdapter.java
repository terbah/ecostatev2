package fil.pai.ecostate.model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import fil.pai.ecostate.R;


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {


    private List<News> mNews;

    public NewsAdapter(List<News> news) {
        mNews = news;
    }

    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View newsView = inflater.inflate(R.layout.news, parent, false);
        ViewHolder vh = new ViewHolder(newsView);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder vh, int i) {
        News news = mNews.get(i);
        vh.caption.setText(news.getCaption());
        vh.img.setImageResource(news.getCover());
        vh.title.setText(news.getTitle());
    }

    @Override
    public int getItemCount() {
        return mNews.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView caption;
        private ImageView img;
        private TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            caption = itemView.findViewById(R.id.caption);
            img = itemView.findViewById(R.id.illus);
            title = itemView.findViewById(R.id.title_news);
        }

    }
}