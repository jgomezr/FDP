package org.grameen.fdp.object;


import ir.mirrajabi.searchdialog.core.Searchable;

/**
 * Created by AangJnr on 08, October, 2018 @ 4:27 PM
 * Work Mail cibrahim@grameenfoundation.org
 * Personal mail aang.jnr@gmail.com
 */

public class SearchModel implements Searchable {
    String id;
    private String mTitle;

    public SearchModel(String _id, String title) {
        id = _id;
        mTitle = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getTitle() {
        return mTitle;
    }

    public SearchModel setTitle(String title) {
        mTitle = title;
        return this;
    }
}