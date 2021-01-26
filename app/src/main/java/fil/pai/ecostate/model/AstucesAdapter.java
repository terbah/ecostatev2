package fil.pai.ecostate.model;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.LinkedList;

import fil.pai.ecostate.R;

public class AstucesAdapter extends ArrayAdapter<AstucesModel>{

    private ArrayList<AstucesModel> dataSet;
    Context mContext;

    private static class ViewHolder {
        TextView txt;
        ImageView img;
        TextView title;
    }

    public AstucesAdapter(ArrayList<AstucesModel> data, Context context) {
        super(context, R.layout.item, data);
        this.dataSet = data;
        this.mContext=context;
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        AstucesModel dataModel = getItem(position);
        ViewHolder viewHolder;
        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item, parent, false);
            viewHolder.txt = (TextView) convertView.findViewById(R.id.helloText);
            viewHolder.img = (ImageView) convertView.findViewById(R.id.imageAstuce);
            viewHolder.title = (TextView) convertView.findViewById(R.id.textView24) ;

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        viewHolder.txt.setText(dataModel.getTexte());
        viewHolder.img.setImageResource(dataModel.getSrc());
        viewHolder.title.setText(dataModel.getTitle());
        return convertView;
    }

    @Override
    public void notifyDataSetChanged()
    {
        super.notifyDataSetChanged();
    }
}