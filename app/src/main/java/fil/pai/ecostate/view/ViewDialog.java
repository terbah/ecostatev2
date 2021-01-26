package fil.pai.ecostate.view;

import android.app.Activity;
import android.app.Dialog;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import fil.pai.ecostate.R;

public class ViewDialog {

    public void showDialog(Activity activity, String msg, String title, int drawable, int nbPart, int partMax, String reward) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.defi_dialog);

        TextView text = dialog.findViewById(R.id.text_dialog);
        text.setText(msg);

        Button dialogButton = dialog.findViewById(R.id.btn_dialog);
        dialogButton.setOnClickListener(v -> dialog.dismiss());

        ImageView imgVi = dialog.findViewById(R.id.img_dialog);
        imgVi.setImageResource(drawable);

        TextView vTitle = dialog.findViewById(R.id.title_dialog);
        vTitle.setText(title);

        TextView nbp = dialog.findViewById(R.id.nb_on);
        nbp.setText("" + nbPart);


        TextView outof = dialog.findViewById(R.id.nb_out_of);
        outof.setText(""+partMax);

        TextView rew = dialog.findViewById(R.id.reward);
        rew.setText(reward);

        dialog.show();
    }
}