package org.grameen.fdp.viewholder;

/**
 * Created by aangjnr on 22/02/2018.
 */


import android.view.View;
import android.widget.TextView;

import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder;

import org.grameen.fdp.R;

public class RowHeaderViewHolder extends AbstractViewHolder {
    public final TextView row_header_textview;

    public RowHeaderViewHolder(View itemView) {
        super(itemView);
        row_header_textview = (TextView) itemView.findViewById(R.id.row_header_textview);
    }
}