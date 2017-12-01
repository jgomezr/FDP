package com.grameen.fdp.adapter;

/**
 * Created by AangJnr on 9/21/16.
 */

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import com.grameen.fdp.R;
import com.grameen.fdp.object.Farmer;

import java.util.List;
import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by AangJnr on 6/27/16.
 */


public class FarmerListAdapter extends RecyclerView.Adapter<FarmerListAdapter.ViewHolder> {

    private List<Farmer> farmers;
    private Context context;
    OnItemClickListener mItemClickListener;




    /**
     * Constructor
     *
     * @param farmers
     **/

    public FarmerListAdapter(Context context, List<Farmer> farmers) {
        this.farmers = farmers;
        this.context = context;

    }




    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return farmers.size();

    }

    @Override
    public FarmerListAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.farmer_item_view, viewGroup, false);

        return new FarmerListAdapter.ViewHolder(v);
    }




    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Farmer farmer = farmers.get(position);



        if(farmer.getImageUrl() != null && farmer.getImageUrl().equals(""))
        Picasso.with(context).load(farmer.getImageUrl()).into(viewHolder.photo);
        else  {
            String[] value = farmer.getName().split(" ");
            viewHolder.initials.setText(value[0].substring(0, 1) + value[1].substring(0, 1));

            int[] mColors = context.getResources().getIntArray(R.array.recommendations_colors);

            int randomColor = mColors[new Random().nextInt(mColors.length)];

            GradientDrawable drawable = new GradientDrawable();
            drawable.setCornerRadius(0);
            drawable.setColor(randomColor);
            viewHolder.rl1.setBackground(drawable);

            viewHolder.imageView.setVisibility(View.GONE);

        }


        viewHolder.name.setText(farmer.getName());
        viewHolder.code.setText(farmer.getCode());



    }



    public class ViewHolder extends RecyclerView.ViewHolder{


        RelativeLayout mainLayout;
        RelativeLayout rl1;

        TextView name;
        TextView code;
        TextView initials;
        CircleImageView photo;
        ImageView imageView;


        RelativeLayout initialsBackground;





        ViewHolder(final View itemView) {
            super(itemView);

            mainLayout = (RelativeLayout) itemView.findViewById(R.id.mainLayout);
            rl1 = (RelativeLayout) itemView.findViewById(R.id.rl1);

            name = (TextView) itemView.findViewById(R.id.name);
            code = (TextView) itemView.findViewById(R.id.code);
            initials = (TextView) itemView.findViewById(R.id.initials);
            photo = (CircleImageView) itemView.findViewById(R.id.photo);
            imageView = (ImageView) itemView.findViewById(R.id.image_view1);

            initialsBackground = (RelativeLayout) itemView.findViewById(R.id.rl1);




            mainLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (mItemClickListener != null) {
                        mItemClickListener.onItemClick(itemView, getAdapterPosition());


                    }


                }
            });

        }


        }


    public void setOnItemClickListener(final FarmerListAdapter.OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }


    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

}
