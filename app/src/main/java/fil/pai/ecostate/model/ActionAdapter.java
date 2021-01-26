package fil.pai.ecostate.model;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import java.util.List;

import fil.pai.ecostate.R;

public class ActionAdapter extends RecyclerView.Adapter<ActionAdapter.ViewHolder> {

    private List<Action> mAction;

    public ActionAdapter(List<Action> action) {
        mAction = action;
    }

    @NonNull
    @Override
    public ActionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View actionView = inflater.inflate(R.layout.action, parent, false);
        ActionAdapter.ViewHolder vh = new ActionAdapter.ViewHolder(actionView);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ActionAdapter.ViewHolder vh, int i) {
        Action action = mAction.get(i);
        vh.cb.setText(action.getTexte());
        vh.cb.setOnClickListener((v) -> {
            if (((CheckBox) v).isChecked()) {
                vh.cb.setPaintFlags(vh.cb.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                action.setChecked(true);
            } else {
                vh.cb.setPaintFlags(vh.cb.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                action.setChecked(false);
            }
        });
        if (vh.cb.isChecked()) {
            vh.cb.setPaintFlags(vh.cb.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        } else {
            vh.cb.setPaintFlags(vh.cb.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
        }
        vh.cb.setChecked(action.getChecked());
    }

    @Override
    public int getItemCount() {
        return mAction.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CheckBox cb;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cb = itemView.findViewById(R.id.checkAction);

        }

    }
}
