package org.zaim.na.kartu.polusa

import android.app.Application
import com.my.tracker.MyTracker
import com.yandex.metrica.YandexMetrica
import com.yandex.metrica.YandexMetricaConfig
import dagger.hilt.android.HiltAndroidApp
import org.zaim.na.kartu.polusa.data.APP_METRICA
import org.zaim.na.kartu.polusa.data.MY_TRACKER
import org.zaim.na.kartu.polusa.data.USER_X
import pro.userx.UserX

@HiltAndroidApp
class AppPolus : Application() {
    override fun onCreate() {
        super.onCreate()

        val config = YandexMetricaConfig.newConfigBuilder(APP_METRICA).build()


        MyTracker.initTracker(MY_TRACKER, this)
        YandexMetrica.activate(applicationContext, config)
        YandexMetrica.enableActivityAutoTracking(this)
        UserX.init(USER_X)
    }
}