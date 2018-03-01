package org.grameen.fdp.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.grameen.fdp.object.Question;

import java.util.List;

import de.codecrafters.tableview.TableHeaderAdapter;

/**
 * Created by aangjnr on 27/01/2018.
 */

public class FamilyMembersTableHearderAdapter extends TableHeaderAdapter {
    static View.OnClickListener mHeaderClickListener;
    private final String[] headers;
    private int paddingLeft = 10;
    private int paddingTop = 10;
    private int paddingRight = 10;
    private int paddingBottom = 10;
    private int textSize = 12;
    private int typeface = 1;
    private int textColor = -1728053248;



    public FamilyMembersTableHearderAdapter(Context context, String... headers) {
        super(context);
        this.headers = headers;
     }


    public FamilyMembersTableHearderAdapter(Context context, int... headerStringResources) {
        super(context);
        this.headers = new String[headerStringResources.length];

        for (int i = 0; i < headerStringResources.length; ++i) {
            this.headers[i] = context.getString(headerStringResources[i]);
        }

    }

    public void setHeaderClickListener(final View.OnClickListener mItemSelectedListener) {
        this.mHeaderClickListener = mItemSelectedListener;
    }

    public void setPaddings(int left, int top, int right, int bottom) {
        this.paddingLeft = left;
        this.paddingTop = top;
        this.paddingRight = right;
        this.paddingBottom = bottom;
    }

    public void setPaddingLeft(int paddingLeft) {
        this.paddingLeft = paddingLeft;
    }

    public void setPaddingTop(int paddingTop) {
        this.paddingTop = paddingTop;
    }

    public void setPaddingRight(int paddingRight) {
        this.paddingRight = paddingRight;
    }

    public void setPaddingBottom(int paddingBottom) {
        this.paddingBottom = paddingBottom;
    }

    public void setTextSize(int textSize) {
        this.textSize = textSize;
    }

    public void setTypeface(int typeface) {
        this.typeface = typeface;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public View getHeaderView(final int columnIndex, ViewGroup parentView) {
        final TextView textView = new TextView(this.getContext());
        TypedValue outValue = new TypedValue();

        if (columnIndex < this.headers.length)
            textView.setText(this.headers[columnIndex]);

        textView.setPadding(this.paddingLeft, this.paddingTop, this.paddingRight, this.paddingBottom);
        textView.setTypeface(textView.getTypeface(), this.typeface);
        textView.setTextSize((float) this.textSize);
        textView.setTextColor(this.textColor);
        textView.setSingleLine(false);
        //textView.setMaxLines(2);
        //textView.setEllipsize(TextUtils.TruncateAt.END);

        /*if (columnIndex > 1) {

            getContext().getTheme().resolveAttribute(android.R.attr.selectableItemBackground, outValue, true);
            textView.setBackgroundResource(outValue.resourceId);
            textView.setClickable(true);
            textView.setFocusable(true);

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.i("MY TABLE HEADER ADAPTER", textView.getText().toString());

                    view.setTag(columnIndex);

                    if (mHeaderClickListener != null)
                        mHeaderClickListener.onClick(view);


                }
            });

        } */

        return textView;
    }
}
