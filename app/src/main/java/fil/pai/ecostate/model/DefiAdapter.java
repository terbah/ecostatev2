package fil.pai.ecostate.model;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import fil.pai.ecostate.MainActivity;
import fil.pai.ecostate.R;
import fil.pai.ecostate.view.ViewDialog;

public class DefiAdapter extends RecyclerView.Adapter<DefiAdapter.ViewHolder> {


    private List<Defi> mDefi;
    private Activity activity;

    public DefiAdapter(Activity activity, List<Defi> defis) {
        mDefi = defis;
        this.activity = activity;
    }

    @NonNull
    @Override
    public DefiAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View defisView = inflater.inflate(R.layout.defi, parent, false);
        DefiAdapter.ViewHolder vh = new DefiAdapter.ViewHolder(defisView);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull DefiAdapter.ViewHolder vh, int i) {
        Defi defis = mDefi.get(i);
        vh.caption.setText(defis.getSingle_word_title());
        vh.img.setScaleType(ImageView.ScaleType.CENTER_CROP);
        vh.img.setImageResource(defis.getDrawable());
        vh.img.setOnClickListener(v -> {
            ViewDialog vd = new ViewDialog();
            vd.showDialog(activity, defis.getMessage(),defis.getTitle(), defis.getDrawable(), defis.getPlayer(), defis.getMaxPlayer(), defis.getReward());
        });


    }

    @Override
    public int getItemCount() {
        return mDefi.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView caption;

        private ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            caption = itemView.findViewById(R.id.caption_card);
            img = itemView.findViewById(R.id.card_view);

        }

    }
}
