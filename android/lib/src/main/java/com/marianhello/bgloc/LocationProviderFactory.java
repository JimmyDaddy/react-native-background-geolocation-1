/**
 * @Author: jimmydaddy
 * @Date:   2017-06-23 06:52:46
 * @Email:  heyjimmygo@gmail.com
 * @Filename: LocationProviderFactory.java
 * @Last modified by:   jimmydaddy
 * @Last modified time: 2017-06-23 07:00:20
 * @License: GNU General Public License（GPL)
 * @Copyright: ©2015-2017 www.songxiaocai.com 宋小菜 All Rights Reserved.
 */



/*
According to apache license

This is fork of christocracy cordova-plugin-background-geolocation plugin
https://github.com/christocracy/cordova-plugin-background-geolocation

This is a new class
*/

package com.marianhello.bgloc;

import android.content.Context;
import com.marianhello.bgloc.data.DAOFactory;
import com.marianhello.bgloc.LocationProvider;
import com.tenforwardconsulting.bgloc.DistanceFilterLocationProvider;
import com.marianhello.bgloc.ActivityRecognitionLocationProvider;
import java.lang.IllegalArgumentException;

/**
 * LocationProviderFactory
 */
public class LocationProviderFactory {

    private LocationService context;

    public LocationProviderFactory(LocationService context) {
        this.context = context;
    };

    public LocationProvider getInstance (Integer locationProvider) {
        LocationProvider provider;
        switch (locationProvider) {
            case Config.ANDROID_DISTANCE_FILTER_PROVIDER:
                provider = new DistanceFilterLocationProvider(context);
                break;
            case Config.ANDROID_ACTIVITY_PROVIDER:
                provider = new ActivityRecognitionLocationProvider(context);
                break;
            case Config.TIMER_PROVIDE:
                Log.e("LocationProviderFactory", "getInstance: TIMER_PROVIDE");
                provider = new TimeTaskLocationProvider(context);
                break;
            default:
                Log.e("LocationProviderFactory", "getInstance: TIMER_PROVIDE DEFAULT");
                provider = new TimeTaskLocationProvider(context);
        }

        provider.onCreate();
        return provider;
    }
}
