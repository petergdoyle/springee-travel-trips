/*
 */
package com.springeetravel.ui.web.beans;

import com.springeetravel.domain.AvailableFlight;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author peter
 */
public class UIUtils {

    static public void pause(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException ie) {
            Logger.getLogger(UIUtils.class.getName()).log(Level.WARNING, null, ie);
        }
    }

    public static void ajaxRedirect(String target) {
        try {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ExternalContext extContext = ctx.getExternalContext();
            String url = extContext.encodeActionURL(ctx.getApplication().getViewHandler().getActionURL(ctx, target));
            extContext.redirect(url);
        } catch (IOException ex) {
            Logger.getLogger(UIUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void addAll(List<AvailableFlight> list, Iterable<AvailableFlight> items) {
        for (Iterator<AvailableFlight> it = items.iterator(); it.hasNext();) {
            AvailableFlight each = it.next();
            list.add(each);
        }
    }
}
