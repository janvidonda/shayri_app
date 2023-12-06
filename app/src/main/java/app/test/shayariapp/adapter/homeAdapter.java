package app.test.shayariapp.adapter;

import static android.content.Context.CLIPBOARD_SERVICE;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Random;

import app.test.shayariapp.R;
import app.test.shayariapp.fragmentHome;
import app.test.shayariapp.model.homeModel;

public class homeAdapter extends RecyclerView.Adapter<homeAdapter.ViewHolder> {
    private homeModel[] homemodel;
    private Context context;

    public homeAdapter(homeModel[] homemodel, Context context) {
        this.homemodel = homemodel;
        this.context = context;
    }

    private int getRandomColor() {
        int[] colors = {R.color.light_blue, R.color.light_pink, R.color.light_purple, R.color.light_orange, R.color.light_teal, R.color.light_lavender, R.color.light_green, R.color.light_yellow};
        int index = new Random().nextInt(colors.length);
        return colors[index];
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View listitemHome = inflater.inflate(R.layout.activity_card_home, parent, false);
        ViewHolder viewHolder = new ViewHolder(listitemHome);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int randomColor = ContextCompat.getColor(context, getRandomColor());
        final homeModel myhomeListData = homemodel[position];
        holder.cardView.setCardBackgroundColor(randomColor);
        holder.textView.setText(homemodel[position].getShayri());
        holder.btn_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent txtIntent = new Intent(Intent.ACTION_SEND);
                txtIntent.setType("text/plain");
                txtIntent.putExtra(Intent.EXTRA_TEXT, myhomeListData.getShayri());
                // context.startActivity(Intent.createChooser(txtIntent, "share"));
                Intent chooserIntent = Intent.createChooser(txtIntent, "Send data with");
                if (txtIntent.resolveActivity(context.getPackageManager()) != null) {
                    context. startActivity(chooserIntent);
                }
            }
        });
        holder.btn_copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) context.getSystemService(CLIPBOARD_SERVICE);
                String getstring = myhomeListData.getShayri();
                ClipData clip = ClipData.newPlainText("label", getstring);
                clipboard.setPrimaryClip(clip);
            }
        });
        holder.btn_wp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent txtIntent = new Intent(Intent.ACTION_SEND);
                txtIntent.setType("text/plain");
                txtIntent.setPackage("com.whatsapp");
                txtIntent.putExtra(Intent.EXTRA_TEXT, myhomeListData.getShayri());
                txtIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
                context.startActivity(Intent.createChooser(txtIntent, "share"));


            }
        });
    }

    @Override
    public int getItemCount() {
        return homemodel.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private CardView cardView;
        private ImageButton btn_wp, btn_share, btn_copy;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textView = (TextView) itemView.findViewById(R.id.txt_shayri);
            this.cardView = (CardView) itemView.findViewById(R.id.card_home);
            this.btn_wp = (ImageButton) itemView.findViewById(R.id.btn_wp);
            this.btn_share = (ImageButton) itemView.findViewById(R.id.btn_share);
            this.btn_copy = (ImageButton) itemView.findViewById(R.id.btn_copy);
        }
    }
}
