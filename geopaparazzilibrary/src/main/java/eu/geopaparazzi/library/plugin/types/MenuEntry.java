package eu.geopaparazzi.library.plugin.types;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import eu.geopaparazzi.library.plugin.ActivityStarter;
import eu.geopaparazzi.library.util.IActivityStarter;

/**
 * @author Cesar Martinez Izquierdo (www.scolab.es)
 */
public class MenuEntry implements IMenuEntry {
    private String label = null;
    private byte[] icon = null;
    protected IActivityStarter starter;
    protected int requestCode = -1;


    public MenuEntry() {
        starter = new ActivityStarter();
    }

    public MenuEntry(IActivityStarter starter) {
        this.starter = starter;
    }

    @Override
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public byte[] getIcon() {
        return this.icon;
    }

    public void setIcon(byte[] icon) {
        this.icon = icon;
    }

    @Override
    public void onClick(IActivityStarter clickActivityStarter) {
        if (processOnClick()) {
            start();
        }
    }

    /**
     * The start method called if the processOnCLick returns true.
     */
    protected void start(){};

    /**
     * This method is invoked when the entry is clicked, before the activity specified
     * by the action is started. The activity execution can be cancelled if this
     * method returns false
     *
     * @return false to cancel the execution of the action, true otherwise
     */
    protected boolean processOnClick() {
        return true;
    }

    @Override
    public int getOrder() {
        return 500;
    }

    public void onActivityResultExecute(AppCompatActivity callingActivity, int requestCode, int resultCode, Intent data){};

    public void setRequestCode(int requestCode){
        this.requestCode = requestCode;
    }

}