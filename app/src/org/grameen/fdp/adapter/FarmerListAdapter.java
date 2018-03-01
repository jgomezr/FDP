package org.grameen.fdp.adapter;

/**
 * Created by AangJnr on 9/21/16.
 */

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.preference.PreferenceManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.grameen.fdp.R;
import org.grameen.fdp.object.RealFarmer;
import org.grameen.fdp.utility.Constants;

import java.util.List;
import java.util.Random;


/**
 * Created by AangJnr on 6/27/16.
 */


public class FarmerListAdapter extends RecyclerView.Adapter<FarmerListAdapter.ViewHolder> {

    OnItemClickListener mItemClickListener;
    OnLongClickListener longClickListener;
    private List<RealFarmer> farmers;
    private Context context;


    /**
     * Constructor
     *
     * @param farmers
     **/

    public FarmerListAdapter(Context context, List<RealFarmer> farmers) {
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
        RealFarmer farmer = farmers.get(position);


        if (farmer.getImageUrl() != null && !farmer.getImageUrl().equals(""))
            Picasso.with(context).load(farmer.getImageUrl()).resize(200, 200).into(viewHolder.photo);
        else {

            try {
                String[] valueArray = farmer.getFarmerName().split(" ");
                String value = valueArray[0].substring(0, 1) + valueArray[1].substring(0, 1);
                viewHolder.initials.setText(value);

            } catch (Exception e) {

                if (!farmer.getFarmerName().trim().isEmpty())
                    viewHolder.initials.setText(farmer.getFarmerName().substring(0, 1));


            }


            int[] mColors = context.getResources().getIntArray(R.array.recommendations_colors);

            int randomColor = mColors[new Random().nextInt(mColors.length)];

            GradientDrawable drawable = new GradientDrawable();
            drawable.setCornerRadius(0);
            drawable.setColor(randomColor);
            viewHolder.rl1.setBackground(drawable);

            viewHolder.imageView.setVisibility(View.GONE);

        }


        viewHolder.name.setText(farmer.getFarmerName());
        viewHolder.code.setText(farmer.getCode());


    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);


    }

    public void setOnItemClickListener(final FarmerListAdapter.OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    public void OnLongClickListener(final FarmerListAdapter.OnLongClickListener mLongClickListener) {
        this.longClickListener = mLongClickListener;
    }


    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }


    public interface OnLongClickListener {
        void onLongClick(View view, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        RelativeLayout mainLayout;
        RelativeLayout rl1;

        TextView name;
        TextView code;
        TextView initials;
        ImageView photo;
        ImageView imageView;


        RelativeLayout initialsBackground;


        ViewHolder(final View itemView) {
            super(itemView);

            mainLayout = (RelativeLayout) itemView.findViewById(R.id.mainLayout);
            rl1 = (RelativeLayout) itemView.findViewById(R.id.rl1);

            name = (TextView) itemView.findViewById(R.id.name);
            code = (TextView) itemView.findViewById(R.id.code);
            initials = (TextView) itemView.findViewById(R.id.initials);
            photo = itemView.findViewById(R.id.photo);
            imageView = itemView.findViewById(R.id.image_view1);

            initialsBackground = (RelativeLayout) itemView.findViewById(R.id.rl1);


            mainLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (mItemClickListener != null) {
                        mItemClickListener.onItemClick(itemView, getAdapterPosition());


                    }


                }
            });

            if (!PreferenceManager.getDefaultSharedPreferences(context).getString("flag", "").equals(Constants.MONITORING))

                mainLayout.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {

                        longClickListener.onLongClick(view, getAdapterPosition());

                        return true;
                    }
                });

        }


    }

}
