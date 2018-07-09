package common

import android.os.Handler
import android.os.Looper
import com.squareup.otto.Bus

class MainBusKotlin : Bus(){
    private val mHandler = Handler(Looper.getMainLooper())

    companion object {
        @JvmStatic lateinit var instance: MainBusKotlin
    }

    init {
        instance = this
    }

    override fun post(event: Any) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.post(event)
        } else {
            mHandler.post { super@MainBusKotlin.post(event) }
        }
    }
}