package home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nu_therabbit.bottombarproject.R
import common.AbstractRootFragment

class RootFiveFragment : AbstractRootFragment() {
    companion object {
        fun newInstance(): RootFiveFragment {
            val bundle = Bundle()
            val fragment = RootFiveFragment()
            fragment.arguments = bundle
            return fragment
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_five_root, container, false)
    }
}