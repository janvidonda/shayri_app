package app.test.shayariapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import app.test.shayariapp.CategoryWiseShayri;
import app.test.shayariapp.R;
import app.test.shayariapp.model.categoryModel;

public class categoryAdapter extends RecyclerView.Adapter<categoryAdapter.ViewHolder> {
    private categoryModel[] categoryData;
    private Context context;


    public categoryAdapter(categoryModel[] categoryData, Context context) {
        this.categoryData = categoryData;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.activity_card_category, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //jo mare kaik click listner lagavvu hoy to
        final categoryModel myCategoryData = categoryData[position];
        holder.textView.setText(categoryData[position].getDescription());
        holder.imageView.setImageResource(categoryData[position].getImgId());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CategoryWiseShayri.class);
                intent.putExtra("category_name", categoryData[position].getDescription());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;
        public CardView cardView;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.img_category);
            this.textView = (TextView) itemView.findViewById(R.id.txt_category);
            this.cardView = (CardView) itemView.findViewById(R.id.card_category);

        }
    }
}
