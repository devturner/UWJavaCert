/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.washington.ext.libraryproject.common;

import edu.washington.ext.libraryproject.model.Patron;
import java.util.Date;

/**
 *
 * @author Chris Turner
 */
public interface LibraryItem {



    /**
     * @return the author
     */
    String getAuthor();

    /**
     * @return the checkedOut
     */
    Patron getCheckedOutPatron();

    /**
     * @return the publishedDate
     */
    Date getPublishedDate();

    /**
     * @return the publisher
     */
    String getPublisher();

    /**
     * @return the title
     */
    String getTitle();

    /**
     * @param checkedOut the checkedOut to set
     */
    void setCheckedOut(Patron checkedOut);

}
