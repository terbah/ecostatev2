package fil.pai.ecostate;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.List;

import fil.pai.ecostate.model.Action;
import fil.pai.ecostate.model.ActionAdapter;
import fil.pai.ecostate.model.Modele;

public class ActionsFragment extends Fragment {
    public static final String CHANNEL_1_ID = "channel1";
    private NotificationManagerCompat notificationManager;
    private List<Action> mAction = Modele.getInstance().getmAction();

    public static ActionsFragment newInstance() {
        ActionsFragment fragment = new ActionsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createNotificationChannel();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_actions, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ActionAdapter aa = new ActionAdapter(mAction);

        RecyclerView rv = getView().findViewById(R.id.peripetie);
        rv.setAdapter(aa);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));

        FloatingActionButton fab = getView().findViewById(R.id.fab);

        fab.setOnClickListener(view1 -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Ajouter une action quotidienne");
            // Set up the input
            final EditText input = new EditText(getActivity());
            // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
            input.setInputType(InputType.TYPE_CLASS_TEXT);
            builder.setView(input);

            // Set up the buttons
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Action a = new Action(input.getText().toString());
                    mAction.add(a);
                }
            });


            builder.setNegativeButton("ANNULER", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            builder.show();
        });
    }

    public void sendOnChannel1(View v) {
        String title = "Ecostate";
        Notification notification = new NotificationCompat.Builder(getContext(), App.CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_local_florist_black_24dp)
                .setContentTitle(title)
                .setContentText("T'as tu fais tes actions du jour ?")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManager.notify(1, notification);
    }


    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel1 = new NotificationChannel(
                    CHANNEL_1_ID,
                    "Channel 1",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel1.setDescription("This is Channel 1");
            NotificationManager manager = getActivity().getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
        }
    }
}
