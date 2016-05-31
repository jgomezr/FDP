package org.grameenfoundation.fdp.sqlite.Search;

/**
 * Created by julian_Gf on 5/20/2016.
 * Defines an interface for search processors that generate the query in the preferred language.
 */
public interface SearchProcessor {
    //generates the query string for the given search
    //@param search
    //@return
    String generateQuery(Search search);

    //generate the query string that will query the total number of results from the given search.
    //@param search
    //@return
    String generateRowCountQuery(Search search);
}
